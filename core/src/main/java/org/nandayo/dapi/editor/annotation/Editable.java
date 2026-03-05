package org.nandayo.dapi.editor.annotation;

import org.bukkit.Material;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a class as editable by the EditorFactory.
 * Apply this to any object you want auto-generated menus for.
 * <pre>
 * Example:
 *  {@literal @Editable}(name = "Game Editor", icon = Material.BOOK)
 *   public class Game { ... }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Editable {

    /** Title shown at the top of the generated menu. */
    String name() default "Object Editor";

    /** Icon representing this object in parent menus (e.g., when it appears as a nested field). */
    Material icon() default Material.PAPER;

    /** Optional description lines shown on the icon's lore in parent menus. */
    String[] description() default {};

    /**
     * Number of rows in the generated inventory (1-6).
     * The framework may override this if there are more fields than slots available.
     */
    int rows() default 3;
}
