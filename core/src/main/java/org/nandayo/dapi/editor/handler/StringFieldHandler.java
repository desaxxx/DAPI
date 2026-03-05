package org.nandayo.dapi.editor.handler;

import org.nandayo.dapi.editor.EditorMenuAdapter;
import org.nandayo.dapi.editor.InputMenu;
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
 * Handles String fields.
 * <br>
 * Opens AnvilMenu for input.
 */
public class StringFieldHandler implements FieldEditorHandler<String> {

    @Override
    public boolean supports(Field field) {
        return field.getType() == String.class;
    }

    @Override
    public boolean supportsType(Class<?> type) {
        return type == String.class;
    }

    @Override
    public ItemStack buildDisplayItem(Field field, String value, Player player) {
        EditableField ann = field.getAnnotation(EditableField.class);
        String label = resolveLabel(ann, field);
        String current = value != null ? value : "&o(not set)";

        return ItemCreator.of(ann != null ? ann.icon() : Material.NAME_TAG)
                .name("&f" + label)
                .lore(buildLore(ann, current))
                .build();
    }

    @Override
    public void onClick(EditorContext ctx) {
        openAnvilInput(ctx);
    }

    @Override
    public int priority() {
        return 30;
    }

    // -----------------------------------------------------------------------
    // Input method implementations
    // -----------------------------------------------------------------------

    /**
     * Opens an AnvilMenu for text input.
     */
    private void openAnvilInput(EditorContext ctx) {
        String current = ctx.getValue();
        Player player = ctx.getPlayer();

        new InputMenu(player, "Enter the new value:", current != null ? current : "", input -> {
            if (input != null) {
                ctx.setValue(input);
            }
            new EditorMenuAdapter(player, ctx.getSession(), ctx.getSession().currentPage()).open();
        }).open();
    }


    // -----------------------------------------------------------------------

    private String resolveLabel(EditableField ann, Field field) {
        return (ann != null && !ann.label().isEmpty()) ? ann.label() : field.getName();
    }

    private List<String> buildLore(EditableField ann, String current) {
        List<String> lore = new ArrayList<>();
        if (ann != null) {
            for (String d : ann.description()) lore.add("&7" + d);
        }
        lore.add("");
        lore.add("&eValue: &f" + current);
        lore.add("");
        lore.add("&aClick &7to edit");
        return lore;
    }
}
