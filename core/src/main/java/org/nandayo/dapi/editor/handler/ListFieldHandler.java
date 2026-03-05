package org.nandayo.dapi.editor.handler;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.editor.annotation.Editable;
import org.nandayo.dapi.editor.annotation.EditableField;
import org.nandayo.dapi.editor.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.nandayo.dapi.guimanager.button.Button;
import org.nandayo.dapi.util.ItemCreator;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Handles {@code List<T>} fields where T is any type supported by a registered handler.
 *
 * <p>Clicking the field opens a {@link GeneratedMenu} list manager showing one button
 * per element plus an Add button at the end.</p>
 *
 * <ul>
 *   <li>Left-click an element — edit in-place via a synthetic {@link EditorContext} if T
 *       is a primitive/String, or push a nested {@link EditorPage} if T is {@link Editable}.</li>
 *   <li>Right-click an element — remove it from the list and refresh.</li>
 *   <li>Click Add — appends a default value for T and refreshes.</li>
 * </ul>
 *
 * <p>The menu refreshes itself after every mutation by re-running the {@code refreshMenu}
 * runnable, which rebuilds the button list and reopens the {@link GeneratedMenu}.</p>
 */
public class ListFieldHandler implements FieldEditorHandler<List<?>> {

    private final EditorHandlerRegistry registry;

    public ListFieldHandler(EditorHandlerRegistry registry) {
        this.registry = registry;
    }

    @Override
    public boolean supports(Field field) {
        return List.class.isAssignableFrom(field.getType());
    }

    @Override
    public ItemStack buildDisplayItem(Field field, List<?> value, Player player) {
        EditableField ann = field.getAnnotation(EditableField.class);
        String label = resolveLabel(ann, field);
        int size = value != null ? value.size() : 0;

        return ItemCreator.of(ann != null ? ann.icon() : Material.CHEST)
                .name("&f" + label)
                .lore(buildLore(ann, size))
                .build();
    }

    @Override
    public void onClick(EditorContext ctx) {
        openListMenu(ctx);
    }

    @Override
    public int priority() {
        return 40;
    }

    // -----------------------------------------------------------------------
    // List sub-menu
    // -----------------------------------------------------------------------

    /**
     * Opens a {@link GeneratedMenu} listing the current elements of the list.
     * Constructs a self-referencing {@code refreshMenu} runnable so any mutation
     * (add, remove, edit) can reopen the menu with up-to-date contents.
     */
    private void openListMenu(EditorContext ctx) {
        Field field = ctx.getField();
        Player player = ctx.getPlayer();
        List<Object> list = ensureList(ctx);

        Class<?> elementType = getElementType(field);
        EditableField ann = field.getAnnotation(EditableField.class);
        String title = "Editing list: " + resolveLabel(ann, field);

        Runnable[] refreshMenu = new Runnable[1];
        refreshMenu[0] = () -> {
            int rows = Math.min(6, Math.max(list.size() + 2, 9) / 9 + 1);
            List<Button> buttons = buildButtons(ctx, list, elementType, refreshMenu);
            ctx.getSession().setSuppressNextClose(true);
            new GeneratedMenu(player, title, rows, buttons, () -> reopenParent(ctx)).open();
        };

        refreshMenu[0].run();
    }

    private void reopenParent(EditorContext ctx) {
        Bukkit.getScheduler().runTask(DAPI.getPlugin(), () ->
                // Call #open() because GeneratedMenu#onClose has nothing to do with EditorMenuAdapter#onClose.
                new EditorMenuAdapter(ctx.getPlayer(), ctx.getSession(), ctx.getSession().currentPage()).open());
    }

    // -----------------------------------------------------------------------
    // Button builders
    // -----------------------------------------------------------------------

    /**
     * Builds the full button list for the list menu — one button per element plus the Add button.
     */
    private List<Button> buildButtons(EditorContext ctx, List<Object> list,
                                      Class<?> elementType, Runnable[] refreshMenu) {
        List<Button> buttons = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Object element = list.get(i);
            ItemStack displayItem = buildElementItem(i, element);
            int slot = i;

            buttons.add(new Button() {
                @Override
                protected @NotNull Set<Integer> getSlots() {
                    return Set.of(slot);
                }

                @Override
                public ItemStack getItem() {
                    return displayItem;
                }

                @Override
                public void onClick(@NotNull Player p, @NotNull ClickType clickType) {
                    if (clickType == ClickType.RIGHT || clickType == ClickType.SHIFT_RIGHT) {
                        list.remove(slot);
                        ctx.setValue(list);
                        refreshMenu[0].run();
                    } else {
                        Object element = list.get(slot);
                        if (element != null && element.getClass().isAnnotationPresent(Editable.class)) {
                            EditorPage elementPage = new EditorPage(element, registry, ctx.getSession());
                            ctx.getSession().push(elementPage, true);
                        } else {
                            FieldEditorHandler<?> handler = registry.resolveOrNull(element != null ? element.getClass() : getElementType(ctx.getField()));
                            if (handler != null) {
                                EditorContext syntheticCtx = new EditorContext(p, ctx.getSession(), ctx.getPage(), ctx.getField(), clickType) {
                                    @Override
                                    @SuppressWarnings("unchecked")
                                    public <T> T getValue() {
                                        return (T) list.get(slot);
                                    }

                                    @Override
                                    public void setValue(Object newValue) {
                                        list.set(slot, newValue);
                                        refreshMenu[0].run();
                                    }
                                };
                                handler.onClick(syntheticCtx);
                            }
                        }
                    }
                }
            });
        }

        buttons.add(new Button() {
            @Override
            protected @NotNull Set<Integer> getSlots() {
                return Set.of(list.size());
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(Material.LIME_CONCRETE)
                        .name("&aAdd Element")
                        .build();
            }

            @Override
            public void onClick(@NotNull Player p, @NotNull ClickType clickType) {
                list.add(defaultValue(elementType));
                ctx.setValue(list);
                refreshMenu[0].run();
            }
        });

        return buttons;
    }

    // -----------------------------------------------------------------------
    // Helpers
    // -----------------------------------------------------------------------

    private List<Object> ensureList(EditorContext ctx) {
        List<Object> list = ctx.getValue();
        if (list == null) {
            list = new ArrayList<>();
            ctx.setValue(list);
        }
        return list;
    }

    private Class<?> getElementType(Field field) {
        Type generic = field.getGenericType();
        if (generic instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) generic;
            Type arg = pt.getActualTypeArguments()[0];
            if (arg instanceof Class<?>) {
                return (Class<?>) arg;
            }
        }
        return Object.class;
    }

    private Object defaultValue(Class<?> type) {
        if (type == Integer.class || type == int.class)      return 0;
        if (type == Double.class  || type == double.class)   return 0.0;
        if (type == Boolean.class || type == boolean.class)  return false;
        if (type == String.class)                            return "";
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Builds the display item for a list element slot.
     * Falls back to a generic paper item with index and value as label
     * if the element type has no special representation.
     */
    private ItemStack buildElementItem(int index, Object element) {
        if (element == null) {
            return ItemCreator.of(Material.BARRIER)
                    .name("&c[" + index + "] null")
                    .build();
        }
        return ItemCreator.of(Material.PAPER)
                .name("&f[" + index + "] " + element)
                .lore("&aLeft Click &7to edit",
                        "&cRight Click &7to remove")
                .build();
    }

    private String resolveLabel(EditableField ann, Field field) {
        return (ann != null && !ann.label().isEmpty()) ? ann.label() : field.getName();
    }

    private List<String> buildLore(EditableField ann, int size) {
        List<String> lore = new ArrayList<>();
        if (ann != null) {
            for (String d : ann.description()) lore.add("&7" + d);
        }
        lore.add("");
        lore.add("&eElements: &f" + size);
        lore.add("");
        lore.add("&aClick &7to manage list");
        return lore;
    }
}