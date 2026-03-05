package org.nandayo.dapi.editor.handler;

import org.nandayo.dapi.editor.annotation.EditableField;
import org.nandayo.dapi.editor.EditorContext;
import org.nandayo.dapi.editor.FieldEditorHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.nandayo.dapi.util.ItemCreator;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Handles boolean / Boolean fields.
 * Any click toggles the value.
 * The item switches between a green dye (true) and a red dye (false).
 */
public class BooleanFieldHandler implements FieldEditorHandler<Boolean> {

    @Override
    public boolean supports(Field field) {
        return field.getType() == boolean.class || field.getType() == Boolean.class;
    }

    @Override
    public boolean supportsType(Class<?> type) {
        return type == boolean.class || type == Boolean.class;
    }

    @Override
    public ItemStack buildDisplayItem(Field field, Boolean value, Player player) {
        EditableField ann = field.getAnnotation(EditableField.class);
        boolean boolValue = value != null && value;

        String label = resolveLabel(ann, field);
        Material icon = boolValue ? Material.LIME_DYE : Material.RED_DYE;

        return ItemCreator.of(icon)
                .name("&f" + label)
                .lore(buildLore(ann, boolValue))
                .build();
    }

    @Override
    public void onClick(EditorContext ctx) {
        Boolean current = ctx.getValue();
        ctx.setValue(current == null || !current);
    }

    @Override
    public int priority() {
        return 0; // checked before int/double to avoid Boolean being matched by those
    }

    // -----------------------------------------------------------------------

    private String resolveLabel(EditableField ann, Field field) {
        return (ann != null && !ann.label().isEmpty()) ? ann.label() : field.getName();
    }

    private List<String> buildLore(EditableField ann, boolean value) {
        List<String> lore = new java.util.ArrayList<>();
        if (ann != null) {
            for (String d : ann.description()) lore.add("&7" + d);
        }
        lore.add("");
        lore.add(value ? "&a● Enabled" : "&c● Disabled");
        lore.add("&8Click to toggle");
        return lore;
    }
}
