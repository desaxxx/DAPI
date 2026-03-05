package org.nandayo.dapi.editor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Explicitly excludes a field from the auto-generated editor menu.
 * <p>
 * Useful when you want the EditorFactory to scan ALL fields by default
 * but skip specific ones (e.g., internal IDs, caches, transient state).
 * <pre>
 * Example:
 *  {@literal @EditableIgnore}
 *   private final UUID internalId;
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EditableIgnore {
}
