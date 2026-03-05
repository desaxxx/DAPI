package org.nandayo.dapi.editor.handler;

import org.bukkit.event.inventory.ClickType;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.editor.EditorMenuAdapter;
import org.nandayo.dapi.editor.GeneratedMenu;
import org.nandayo.dapi.editor.annotation.EditableField;
import org.nandayo.dapi.editor.annotation.EditableOptions;
import org.nandayo.dapi.editor.EditorContext;
import org.nandayo.dapi.editor.FieldEditorHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.nandayo.dapi.guimanager.button.Button;
import org.nandayo.dapi.util.ItemCreator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Handles Enum fields.
 * <p>
 * Clicking the field opens a {@link GeneratedMenu} picker with one button per enum constant.
 * Clicking a constant sets it as the new value and returns to the parent editor page.
 * <p>
 * Icon and label per constant can be customized with {@link EditableOptions} on the
 * enum class or on the field itself — field-level takes priority over type-level.
 */
public class EnumFieldHandler implements FieldEditorHandler<Enum<?>> {

    @Override
    public boolean supports(Field field) {
        return field.getType().isEnum();
    }

    @Override
    public ItemStack buildDisplayItem(Field field, Enum<?> value, Player player) {
        EditableField ann = field.getAnnotation(EditableField.class);
        String label   = resolveLabel(ann, field);
        String valName = value != null ? value.name() : "&o(not set)";

        // Check for @EditableOptions to get a custom icon for the current value
        Material icon = ann != null ? ann.icon() : Material.PAPER;
        if (value != null) {
            EditableOptions options = resolveOptions(field);
            if (options != null) {
                for (EditableOptions.Option opt : options.values()) {
                    if (opt.constant().equals(value.name())) {
                        icon = opt.icon();
                        valName = opt.label().isEmpty() ? value.name() : opt.label();
                        break;
                    }
                }
            }
        }

        return ItemCreator.of(icon)
                .name("&f" + label)
                .lore(buildLore(ann, valName))
                .build();
    }

    @Override
    public void onClick(EditorContext ctx) {
        openPickerMenu(ctx);
    }

    @Override
    public int priority() {
        return 20;
    }

    // -----------------------------------------------------------------------
    // Picker menu
    // -----------------------------------------------------------------------

    /**
     * Opens a {@link GeneratedMenu} showing all constants of the enum type.
     * <br>
     * One button is created per constant, using icon and label from {@link EditableOptions} if present.
     * <br>
     * Selecting a constant calls {@link EditorContext#setValue(Object)} and reopens the parent page.
     * <br>
     * Closing without selecting also reopens the parent page via the {@code onClose} runnable.
     */
    private void openPickerMenu(EditorContext ctx) {
        Field field = ctx.getField();
        Player player = ctx.getPlayer();
        Enum<?>[] constants = (Enum<?>[]) field.getType().getEnumConstants();
        EditableOptions options = resolveOptions(field);

        String title = "Select: " + resolveLabel(field.getAnnotation(EditableField.class), field);
        int rows = Math.min(6, (constants.length / 9) + 1);

        List<Button> buttons = new ArrayList<>();
        for (int i = 0; i < constants.length; i++) {
            Enum<?> constant = constants[i];
            int finalI = i;

            buttons.add(new Button() {
                @Override
                protected @NotNull Set<Integer> getSlots() {
                    return Set.of(finalI);
                }

                @Override
                public ItemStack getItem() {
                    return buildConstantItem(constant, options, ctx.getValue());
                }

                @Override
                public void onClick(@NotNull Player p, @NotNull ClickType clickType) {
                    ctx.setValue(constants[finalI]);
                    reopenParent(ctx);
                }
            });
        }

        new GeneratedMenu(player, title, rows, buttons, () -> reopenParent(ctx)).open();
    }

    private void reopenParent(EditorContext ctx) {
        new EditorMenuAdapter(ctx.getPlayer(), ctx.getSession(), ctx.getSession().currentPage()).open();
    }

    // -----------------------------------------------------------------------
    // Item builders
    // -----------------------------------------------------------------------

    private ItemStack buildConstantItem(Enum<?> constant, EditableOptions options, Enum<?> current) {
        Material icon = Material.PAPER;
        String label  = constant.name();
        List<String> lore = new ArrayList<>();

        if (options != null) {
            for (EditableOptions.Option opt : options.values()) {
                if (opt.constant().equals(constant.name())) {
                    if (opt.icon() != Material.PAPER) icon = opt.icon();
                    if (!opt.label().isEmpty()) label = opt.label();
                    for (String d : opt.description()) lore.add("&7" + d);
                    break;
                }
            }
        }

        boolean selected = constant == current;
        if (selected) {
            lore.add("");
            lore.add("&a✔ Currently selected");
        }

        return ItemCreator.of(icon)
                .name((selected ? "&a" : "&f") + label)
                .lore(lore)
                .build();
    }

    // -----------------------------------------------------------------------
    // Helpers
    // -----------------------------------------------------------------------

    /** Field-level @EditableOptions takes priority over type-level. */
    private EditableOptions resolveOptions(Field field) {
        EditableOptions fieldLevel = field.getAnnotation(EditableOptions.class);
        if (fieldLevel != null) return fieldLevel;
        return field.getType().getAnnotation(EditableOptions.class);
    }

    private String resolveLabel(EditableField ann, Field field) {
        return (ann != null && !ann.label().isEmpty()) ? ann.label() : field.getName();
    }

    private List<String> buildLore(EditableField ann, String currentLabel) {
        List<String> lore = new ArrayList<>();
        if (ann != null) {
            for (String d : ann.description()) lore.add("&7" + d);
        }
        lore.add("");
        lore.add("&eValue: &f" + currentLabel);
        lore.add("");
        lore.add("&aClick &7to change");
        return lore;
    }
}
