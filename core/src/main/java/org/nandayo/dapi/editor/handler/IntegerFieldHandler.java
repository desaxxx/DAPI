package org.nandayo.dapi.editor.handler;

import org.bukkit.Material;
import org.nandayo.dapi.editor.annotation.EditableField;
import org.nandayo.dapi.editor.EditorContext;
import org.nandayo.dapi.editor.FieldEditorHandler;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.nandayo.dapi.util.ItemCreator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles int / Integer fields.
 * <p>
 * Left-click → +step (shift: ×10)
 * Right-click → -step (shift: ×10)
 * <p>
 * Clamps to [min, max] defined in @EditableField.
 */
public class IntegerFieldHandler implements FieldEditorHandler<Number> {

    @Override
    public boolean supports(Field field) {
        return field.getType() == int.class || field.getType() == Integer.class;
    }

    @Override
    public boolean supportsType(Class<?> type) {
        return type == int.class || type == Integer.class;
    }

    @Override
    public ItemStack buildDisplayItem(Field field, Number value, Player player) {
        EditableField ann = field.getAnnotation(EditableField.class);
        String label = resolveLabel(ann, field);
        int current = value != null ? value.intValue() : 0;

        return ItemCreator.of(ann != null ? ann.icon() : Material.PAPER)
                .name("&f" + label)
                .lore(buildLore(ann, current))
                .build();
    }

    @Override
    public void onClick(EditorContext ctx) {
        EditableField ann = ctx.getField().getAnnotation(EditableField.class);
        int step    = ann != null ? (int) ann.step() : 1;
        int min     = ann != null ? (int) ann.min()  : Integer.MIN_VALUE;
        int max     = ann != null ? (int) ann.max()  : Integer.MAX_VALUE;

        if (ctx.isShift()) step *= 10;

        Number current = ctx.getValue();
        int val = current != null ? current.intValue() : 0;

        val += ctx.isLeftClick() ? step : -step;
        val  = Math.max(min, Math.min(max, val));

        ctx.setValue(val);
    }

    @Override
    public int priority() {
        return 10;
    }

    // -----------------------------------------------------------------------

    private String resolveLabel(EditableField ann, Field field) {
        return (ann != null && !ann.label().isEmpty()) ? ann.label() : field.getName();
    }

    private List<String> buildLore(EditableField ann, int current) {
        List<String> lore = new ArrayList<>();
        if (ann != null) {
            for (String d : ann.description()) lore.add("&7" + d);
        }
        lore.add("");
        lore.add("&eValue: &f" + current);

        double step = (ann != null) ? ann.step() : 1;
        double min  = (ann != null) ? ann.min()  : Integer.MIN_VALUE;
        double max  = (ann != null) ? ann.max()  : Integer.MAX_VALUE;

        if (min != Double.MIN_VALUE) lore.add("&8Min: " + (int) min);
        if (max != Double.MAX_VALUE) lore.add("&8Max: " + (int) max);
        lore.add("");
        lore.add("&aLeft Click &7to add &f+" + (int) step);
        lore.add("&cRight Click &7to subtract &f-" + (int) step);
        lore.add("&8Shift Click ×10");
        return lore;
    }
}
