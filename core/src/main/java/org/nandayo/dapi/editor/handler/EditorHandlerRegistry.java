package org.nandayo.dapi.editor.handler;

import org.nandayo.dapi.editor.FieldEditorHandler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Central registry of all FieldEditorHandlers.
 *
 * Handlers are stored in ascending priority order (lowest number = checked first).
 * The first handler whose supports() returns true for a given field is used.
 *
 * Usage:
 *   EditorHandlerRegistry registry = EditorHandlerRegistry.createDefault();
 *   registry.register(new MyCustomHandler());        // plug in new types
 *   FieldEditorHandler<?> h = registry.resolve(field); // find handler for a field
 */
public class EditorHandlerRegistry {

    private final List<FieldEditorHandler<?>> handlers = new ArrayList<>();

    // -----------------------------------------------------------------------
    // Registration
    // -----------------------------------------------------------------------

    /**
     * Registers a handler. The registry is re-sorted by priority after each add,
     * so you can register in any order.
     */
    public void register(FieldEditorHandler<?> handler) {
        handlers.add(handler);
        handlers.sort(Comparator.comparingInt(FieldEditorHandler::priority));
    }

    /**
     * Removes all handlers of a given class (useful for replacing built-ins).
     */
    public void unregister(Class<? extends FieldEditorHandler<?>> handlerClass) {
        handlers.removeIf(h -> h.getClass().equals(handlerClass));
    }

    // -----------------------------------------------------------------------
    // Resolution
    // -----------------------------------------------------------------------

    /**
     * Finds the best handler for the given field.
     *
     * @throws IllegalStateException if no handler supports the field type.
     */
    public FieldEditorHandler<?> resolve(Field field) {
        for (FieldEditorHandler<?> handler : handlers) {
            if (handler.supports(field)) {
                return handler;
            }
        }
        throw new IllegalStateException(
            "No FieldEditorHandler registered for field: " + field.getName()
            + " (type: " + field.getType().getSimpleName() + ")"
        );
    }

    public FieldEditorHandler<?> resolve(Class<?> type) {
        for (FieldEditorHandler<?> handler : handlers) {
            if (handler.supportsType(type)) return handler;
        }
        throw new IllegalStateException(
            "No FieldEditorHandler registered for type: " + type.getSimpleName()
                + " (type: " + type.getSimpleName() + ")"
        );
    }

    /**
     * Like resolve() but returns null instead of throwing if not found.
     * <br>
     * Useful for checking support before attempting to build a menu.
     *
     * @param field field to check
     * @return FieldEditorHandler or null
     */
    public FieldEditorHandler<?> resolveOrNull(Field field) {
        for (FieldEditorHandler<?> handler : handlers) {
            if (handler.supports(field)) {
                return handler;
            }
        }
        return null;
    }

    /**
     * Like resolve() but returns null instead of throwing if not found.
     * <br>
     * Useful for checking support before attempting to build a menu.
     *
     * @param type type of the field to check
     * @return FieldEditorHandler or null
     */
    public FieldEditorHandler<?> resolveOrNull(Class<?> type) {
        for (FieldEditorHandler<?> handler : handlers) {
            if (handler.supportsType(type)) {
                return handler;
            }
        }
        return null;
    }

    public List<FieldEditorHandler<?>> getAll() {
        return Collections.unmodifiableList(handlers);
    }

    // -----------------------------------------------------------------------
    // Factory
    // -----------------------------------------------------------------------

    /**
     * Creates a registry preloaded with all built-in handlers.
     * Call this once in your plugin's onEnable and pass the instance to EditorFactory.
     */
    public static EditorHandlerRegistry createDefault() {
        EditorHandlerRegistry registry = new EditorHandlerRegistry();

        // Priority 0 — most specific first
        registry.register(new BooleanFieldHandler());

        // Priority 10
        registry.register(new IntegerFieldHandler());
        registry.register(new DoubleFieldHandler());

        // Priority 20
        registry.register(new EnumFieldHandler());

        // Priority 30
        registry.register(new StringFieldHandler());

        // Priority 40
        registry.register(new ListFieldHandler(registry));

        // Priority 50 — catch-all for nested @Editable objects
        registry.register(new NestedObjectHandler());

        return registry;
    }
}
