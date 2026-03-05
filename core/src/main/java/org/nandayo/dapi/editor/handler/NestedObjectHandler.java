package org.nandayo.dapi.editor.handler;

import org.nandayo.dapi.editor.*;
import org.nandayo.dapi.editor.annotation.Editable;
import org.nandayo.dapi.editor.annotation.EditableField;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.nandayo.dapi.util.ItemCreator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles any field whose type is annotated with {@link Editable}.
 * <p>
 * Clicking the field pushes a new {@link EditorPage} for the nested object onto the
 * session stack, which triggers the pageOpenCallback in {@link EditorFactory} to open
 * a new {@link EditorMenuAdapter} on top.
 * <p>
 * The player can edit the nested object's fields freely and use the Back button to
 * return to the parent page. Since the framework operates on the live object directly,
 * all mutations to the nested object are immediately reflected — no extra save step is needed.
 */
public class NestedObjectHandler implements FieldEditorHandler<Object> {

    @Override
    public boolean supports(Field field) {
        // Handles any non-primitive, non-enum, non-collection type with @Editable
        Class<?> type = field.getType();
        return !type.isPrimitive()
            && !type.isEnum()
            && !Iterable.class.isAssignableFrom(type)
            && type.isAnnotationPresent(Editable.class);
    }

    @Override
    public ItemStack buildDisplayItem(Field field, Object value, Player player) {
        EditableField fieldAnn = field.getAnnotation(EditableField.class);
        Editable typeAnn = field.getType().getAnnotation(Editable.class);

        String label = resolveLabel(fieldAnn, typeAnn, field);
        Material icon = resolveIcon(fieldAnn, typeAnn);

        return ItemCreator.of(icon)
                .name("&f" + label)
                .lore(buildLore(fieldAnn, typeAnn, value))
                .build();
    }

    @Override
    public void onClick(EditorContext ctx) {
        Object nestedObject = ctx.getValue();

        // If the field is null, try to instantiate a default instance
        if (nestedObject == null) {
            nestedObject = tryInstantiate(ctx.getField().getType());
            if (nestedObject == null) {
                ctx.getPlayer().sendMessage(
                    "&cCannot edit null field '" + ctx.getField().getName()
                    + "' — no no-arg constructor found."
                );
                return;
            }
            ctx.setValue(nestedObject);
        }

        EditorPage nestedPage = new EditorPage(nestedObject, ctx.getSession().getRegistry(), ctx.getSession());
        ctx.getSession().push(nestedPage, true);
    }

    @Override
    public int priority() {
        return 50;
    }

    // -----------------------------------------------------------------------
    // Helpers
    // -----------------------------------------------------------------------

    private String resolveLabel(EditableField fieldAnn, Editable typeAnn, Field field) {
        if (fieldAnn != null && !fieldAnn.label().isEmpty()) return fieldAnn.label();
        if (typeAnn  != null && !typeAnn.name().isEmpty())   return typeAnn.name();
        return field.getName();
    }

    private Material resolveIcon(EditableField fieldAnn, Editable typeAnn) {
        if (fieldAnn != null && fieldAnn.icon() != Material.PAPER) return fieldAnn.icon();
        if (typeAnn  != null && typeAnn.icon()  != Material.PAPER) return typeAnn.icon();
        return Material.CHEST;
    }

    private List<String> buildLore(EditableField fieldAnn, Editable typeAnn, Object value) {
        List<String> lore = new ArrayList<>();
        if (fieldAnn != null) {
            for (String d : fieldAnn.description()) lore.add("&7" + d);
        }
        if (lore.isEmpty() && typeAnn != null) {
            for (String d : typeAnn.description()) lore.add("&7" + d);
        }
        lore.add("");
        lore.add(value != null ? "&7(configured)" : "&c(not set — will create default)");
        lore.add("");
        lore.add("&aClick &7to open nested editor");
        return lore;
    }

    private Object tryInstantiate(Class<?> type) {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
