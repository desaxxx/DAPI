package org.nandayo.dapi.editor;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import java.lang.reflect.Field;

/**
 * Passed to a FieldEditorHandler when a player clicks a field's slot.
 * Contains everything the handler needs to read / write the field value
 * and interact with the editor navigation stack.
 */
public class EditorContext {

    private final Player player;
    private final EditorSession session;
    private final EditorPage page;
    private final Field field;
    private final ClickType clickType;

    public EditorContext(Player player, EditorSession session, EditorPage page,
                         Field field, ClickType clickType) {
        this.player = player;
        this.session = session;
        this.page = page;
        this.field = field;
        this.clickType = clickType;
    }

    /** The admin interacting with the menu. */
    public Player getPlayer() {
        return player;
    }

    /** The full navigation session for this player (holds the page stack). */
    public EditorSession getSession() {
        return session;
    }

    /** The currently open editor page. */
    public EditorPage getPage() {
        return page;
    }

    /** The reflected field that was clicked. */
    public Field getField() {
        return field;
    }

    /** What kind of click was performed. */
    public ClickType getClickType() {
        return clickType;
    }

    // -----------------------------------------------------------------------
    // Convenience helpers so handlers don't need to deal with reflection boilerplate
    // -----------------------------------------------------------------------

    /**
     * Reads the current value of the field from the page's working object.
     * Returns null if the field is inaccessible or the value is null.
     */
    @SuppressWarnings("unchecked")
    public <T> T getValue() {
        try {
            field.setAccessible(true);
            return (T) field.get(page.getWorkingObject());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot read field: " + field.getName(), e);
        }
    }

    /**
     * Writes a new value into the field on the page's working object,
     * then requests the page to refresh the display item for this field's slot.
     */
    public void setValue(Object newValue) {
        try {
            field.setAccessible(true);
            field.set(page.getWorkingObject(), newValue);
            page.triggerFullRefresh();
            //page.refreshSlot(field);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot write field: " + field.getName(), e);
        }
    }

    /** True if the player held Shift during the click. */
    public boolean isShift() {
        return clickType == ClickType.SHIFT_LEFT || clickType == ClickType.SHIFT_RIGHT;
    }

    /** True if the click was any kind of left-click. */
    public boolean isLeftClick() {
        return clickType == ClickType.LEFT || clickType == ClickType.SHIFT_LEFT;
    }

    /** True if the click was any kind of right-click. */
    public boolean isRightClick() {
        return clickType == ClickType.RIGHT || clickType == ClickType.SHIFT_RIGHT;
    }
}
