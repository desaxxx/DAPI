package org.nandayo.dapi.editor;

import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;

/**
 * Strategy interface for editing a specific type of field.
 * <p>
 * Implement this to support a new field type — then register it with
 * EditorHandlerRegistry. The registry will pick the first handler whose
 * supports() method returns true, in priority order (the lowest number = checked first).
 * <pre>
 * Built-in handlers (registered by EditorFactory on startup):
 *   priority 0  — BooleanFieldHandler
 *   priority 10 — IntegerFieldHandler
 *   priority 10 — DoubleFieldHandler
 *   priority 20 — EnumFieldHandler
 *   priority 30 — StringFieldHandler
 *   priority 40 — ListFieldHandler
 *   priority 50 — NestedObjectHandler  (catch-all for @Editable classes)
 * </pre>
 * Custom handlers should use priority values that fit between these tiers
 * (e.g., priority 5 for a specialized Boolean-like type).
 *
 * @param <T> The Java type this handler manages.
 */
public interface FieldEditorHandler<T> {

    /**
     * Returns true if this handler is capable of editing the given field.
     * The field is guaranteed to be annotated with @EditableField when this is called.
     * <br>
     * Tip: check field.getType() or field.getGenericType() here.
     */
    boolean supports(Field field);

    default boolean supportsType(Class<?> type) {
        return false;
    }

    /**
     * Builds the ItemStack displayed in the menu slot for this field.
     *
     * @param field  The reflected field.
     * @param value  The current value of the field (might be null).
     * @param player The player viewing the menu (useful for personalized lore).
     * @return       The item to display.
     */
    ItemStack buildDisplayItem(Field field, T value, org.bukkit.entity.Player player);

    /**
     * Called when the player clicks this field's slot.
     * The handler is responsible for:
     *   - mutating the value via ctx.setValue(...)
     *   - OR pushing a new page via ctx.getSession().push(...)
     *   - OR opening an AnvilMenu / chat prompt and registering a callback
     *
     * @param ctx Full context including player, session, page, field, and click type.
     */
    void onClick(EditorContext ctx);

    /**
     * Priority used to determine handler resolution order.
     * Lower number = higher priority (checked first).
     * Default: 100.
     */
    default int priority() {
        return 100;
    }
}
