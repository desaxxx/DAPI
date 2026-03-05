package org.nandayo.dapi.editor.handler;

import org.nandayo.dapi.editor.annotation.EditableField;
import org.nandayo.dapi.editor.EditorContext;
import org.nandayo.dapi.editor.FieldEditorHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.nandayo.dapi.util.ItemCreator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles double / Double fields.
 * <pre>
 * Left-click → +step (shift: ×10)
 * Right-click → -step (shift: ×10)
 * </pre>
 * Clamps to [min, max] from @EditableField.
 */
public class DoubleFieldHandler implements FieldEditorHandler<Number> {

    @Override
    public boolean supports(Field field) {
        return field.getType() == double.class || field.getType() == Double.class
            || field.getType() == float.class  || field.getType() == Float.class;
    }

    @Override
    public boolean supportsType(Class<?> type) {
        return type == double.class || type == Double.class || type == float.class || type == Float.class;
    }

    @Override
    public ItemStack buildDisplayItem(Field field, Number value, Player player) {
        EditableField ann = field.getAnnotation(EditableField.class);
        String label   = resolveLabel(ann, field);
        double current = value != null ? value.doubleValue() : 0.0;

        return ItemCreator.of(ann != null ? ann.icon() : Material.PAPER)
                .name("&f" + label)
                .lore(buildLore(ann, current))
                .build();
    }

    @Override
    public void onClick(EditorContext ctx) {
        EditableField ann  = ctx.getField().getAnnotation(EditableField.class);
        double step = ann != null ? ann.step() : 0.1;
        double min  = ann != null ? ann.min()  : -Double.MAX_VALUE;
        double max  = ann != null ? ann.max()  :  Double.MAX_VALUE;

        if (ctx.isShift()) step *= 10;

        Number current = ctx.getValue();
        double val = current != null ? current.doubleValue() : 0.0;

        val += ctx.isLeftClick() ? step : -step;
        val  = Math.max(min, Math.min(max, val));

        // Round to 4 decimal places to avoid floating-point noise
        val = Math.round(val * 10000.0) / 10000.0;

        // Preserve float vs double
        if (ctx.getField().getType() == float.class || ctx.getField().getType() == Float.class) {
            ctx.setValue((float) val, true);
        } else {
            ctx.setValue(val, true);
        }
    }

    @Override
    public int priority() {
        return 10;
    }

    // -----------------------------------------------------------------------

    private String resolveLabel(EditableField ann, Field field) {
        return (ann != null && !ann.label().isEmpty()) ? ann.label() : field.getName();
    }

    private List<String> buildLore(EditableField ann, double current) {
        List<String> lore = new ArrayList<>();
        if (ann != null) {
            for (String d : ann.description()) lore.add("&7" + d);
        }
        lore.add("");
        lore.add("&eValue: &f" + current);

        double step = (ann != null) ? ann.step() : 0.1;
        double min  = (ann != null) ? ann.min()  : -Double.MAX_VALUE;
        double max  = (ann != null) ? ann.max()  :  Double.MAX_VALUE;

        if (min != -Double.MAX_VALUE) lore.add("&8Min: " + min);
        if (max !=  Double.MAX_VALUE) lore.add("&8Max: " + max);
        lore.add("");
        lore.add("&aLeft Click &7to add &f+" + step);
        lore.add("&cRight Click &7to subtract &f-" + step);
        lore.add("&8Shift Click ×10");
        return lore;
    }
}
