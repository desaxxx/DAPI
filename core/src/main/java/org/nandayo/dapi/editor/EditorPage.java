package org.nandayo.dapi.editor;

import org.nandayo.dapi.editor.annotation.Editable;
import org.nandayo.dapi.editor.annotation.EditableField;
import org.nandayo.dapi.editor.annotation.EditableIgnore;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.nandayo.dapi.editor.handler.EditorHandlerRegistry;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Represents a single "page" in the editor navigation stack.
 * <p>
 * Each page wraps one working object, discovers its @EditableField fields,
 * assigns them to inventory slots, and delegates click events to the
 * appropriate FieldEditorHandler.
 * <p>
 * EditorMenuAdapter consumes this class in two ways:
 * <pre>
 *   1. Calls buildSlotMap() to get the slot→ItemStack map for populating buttons.
 *   2. Calls handleClick(player, slot, clickType) from each button onClick.
 * </pre>
 * On any field change, triggerFullRefresh() is called, which fires the
 * fullRefreshListener wired by EditorMenuAdapter to re-call open().
 */
public class EditorPage {

    private final Object workingObject;
    private final EditorHandlerRegistry registry;
    private final EditorSession session;

    /** Slot index → reflected field */
    private final Map<Integer, Field> slotToField = new LinkedHashMap<>();

    /** Reflected field → slot index (reverse lookup for refreshSlot) */
    private final Map<Field, Integer> fieldToSlot = new HashMap<>();

    /** Called when a single slot's item needs refreshing (wired by EditorMenuAdapter). */
    @Deprecated
    private SlotUpdateListener slotUpdateListener;

    /** Called when the whole page needs to be rebuilt (e.g., after a list mutation). */
    private Runnable fullRefreshListener;

    // -----------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------

    public EditorPage(Object workingObject, EditorHandlerRegistry registry, EditorSession session) {
        this.workingObject = workingObject;
        this.registry = registry;
        this.session = session;
        discoverFields();
    }

    // -----------------------------------------------------------------------
    // Field discovery
    // -----------------------------------------------------------------------

    /**
     * Scans the working object's class (and superclasses) for @EditableField fields,
     * assigns them to inventory slots, and builds the slot↔field maps.
     */
    private void discoverFields() {
        List<Field> editableFields = new ArrayList<>();

        // Walk up the class hierarchy so subclasses inherit parent fields
        Class<?> clazz = workingObject.getClass();
        while (clazz != null && clazz != Object.class) {
            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(EditableField.class) && !f.isAnnotationPresent(EditableIgnore.class)) {
                    editableFields.add(f);
                }
            }
            clazz = clazz.getSuperclass();
        }

        // Determine rows from @Editable annotation (default 3)
        int rows = 3;
        Editable editableAnnotation = workingObject.getClass().getAnnotation(Editable.class);
        if (editableAnnotation != null) {
            rows = Math.max(1, Math.min(6, editableAnnotation.rows()));
        }

        // Auto-assign slots, skipping border slots (row 0, last row, col 0, col 8)
        // and any slot explicitly claimed by a field via @EditableField(slot = X)
        Set<Integer> claimed = new HashSet<>();
        for (Field f : editableFields) {
            int explicit = f.getAnnotation(EditableField.class).slot();
            if (explicit >= 0) claimed.add(explicit);
        }

        // Build list of available interior slots
        Queue<Integer> available = new LinkedList<>();
        for (int slot = 0; slot < rows * 9; slot++) {
            int row = slot / 9;
            int col = slot % 9;
            boolean isBorder = row == 0 || row == rows - 1 || col == 0 || col == 8;
            if (!isBorder && !claimed.contains(slot)) {
                available.add(slot);
            }
        }

        // Assign slots
        for (Field f : editableFields) {
            int explicit = f.getAnnotation(EditableField.class).slot();
            int assignedSlot;
            if (explicit >= 0) {
                assignedSlot = explicit;
            } else {
                if (available.isEmpty()) {
                    throw new IllegalStateException(
                        "Not enough inventory slots for all @EditableField fields in "
                        + workingObject.getClass().getSimpleName()
                        + ". Increase @Editable(rows = ?) or use explicit slot assignments."
                    );
                }
                assignedSlot = available.poll();
            }
            slotToField.put(assignedSlot, f);
            fieldToSlot.put(f, assignedSlot);
        }
    }

    // -----------------------------------------------------------------------
    // Public API used by EditorMenuAdapter
    // -----------------------------------------------------------------------

    /**
     * Builds the complete slot → ItemStack map for the initial menu render.
     * Pass this to your Menu system to populate the inventory.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Map<Integer, ItemStack> buildSlotMap(Player player) {
        Map<Integer, ItemStack> map = new LinkedHashMap<>();
        for (Map.Entry<Integer, Field> entry : slotToField.entrySet()) {
            int slot = entry.getKey();
            Field field = entry.getValue();
            FieldEditorHandler handler = registry.resolve(field);
            Object value = getFieldValue(field);
            map.put(slot, handler.buildDisplayItem(field, value, player));
        }
        return map;
    }

    /**
     * Called by EditorMenuAdapter when a player clicks a slot.
     * Delegates to the appropriate FieldEditorHandler.
     */
    @SuppressWarnings({"rawtypes"})
    public void handleClick(Player player, int slot, ClickType clickType) {
        Field field = slotToField.get(slot);
        if (field == null) return; // decoration or empty slot

        FieldEditorHandler handler = registry.resolve(field);
        EditorContext ctx = new EditorContext(player, session, this, field, clickType);
        handler.onClick(ctx);
    }

    /**
     * Refreshes the display item for the slot that contains the given field.
     * Called automatically by EditorContext.setValue().
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Deprecated
    public void refreshSlot(Field field) {
        Integer slot = fieldToSlot.get(field);
        if (slot == null || slotUpdateListener == null) return;

        FieldEditorHandler handler = registry.resolve(field);
        // We need a player reference for buildDisplayItem — stored in session
        Player player = session.getPlayer();
        Object value = getFieldValue(field);
        ItemStack newItem = handler.buildDisplayItem(field, value, player);
        slotUpdateListener.onSlotUpdate(slot, newItem);
    }

    /**
     * Triggers a full menu rebuild (used by ListFieldHandler after add/remove).
     */
    public void triggerFullRefresh() {
        if (fullRefreshListener != null) fullRefreshListener.run();
    }

    // -----------------------------------------------------------------------
    // Listener wiring (called by EditorMenuAdapter)
    // -----------------------------------------------------------------------

    @Deprecated
    public void setSlotUpdateListener(SlotUpdateListener listener) {
        this.slotUpdateListener = listener;
    }

    public void setFullRefreshListener(Runnable listener) {
        this.fullRefreshListener = listener;
    }

    // -----------------------------------------------------------------------
    // Getters
    // -----------------------------------------------------------------------

    public Object getWorkingObject() {
        return workingObject;
    }

    public Map<Integer, Field> getSlotToField() {
        return Collections.unmodifiableMap(slotToField);
    }

    public int getRows() {
        Editable ann = workingObject.getClass().getAnnotation(Editable.class);
        return ann != null ? Math.max(1, Math.min(6, ann.rows())) : 3;
    }

    public String getTitle() {
        Editable ann = workingObject.getClass().getAnnotation(Editable.class);
        return ann != null ? ann.name() : workingObject.getClass().getSimpleName();
    }

    // -----------------------------------------------------------------------
    // Internal helpers
    // -----------------------------------------------------------------------

    private Object getFieldValue(Field field) {
        try {
            field.setAccessible(true);
            return field.get(workingObject);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot read field: " + field.getName(), e);
        }
    }

    // -----------------------------------------------------------------------
    // Slot update callback interface
    // -----------------------------------------------------------------------

    @Deprecated
    @FunctionalInterface
    public interface SlotUpdateListener {
        void onSlotUpdate(int slot, ItemStack newItem);
    }
}
