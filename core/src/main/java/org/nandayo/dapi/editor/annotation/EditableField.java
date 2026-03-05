package org.nandayo.dapi.editor.annotation;

import org.bukkit.Material;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a field inside an @Editable class to be included in the auto-generated menu.
 * <p>
 * Supported field types (built-in handlers):
 * <ul>
 *     <li>int / Integer</li>
 *     <li>double / Double</li>
 *     <li>boolean / Boolean</li>
 *     <li>String</li>
 *     <li>Enum subtypes</li>
 *     <li>Any class annotated with @Editable (opens nested editor)</li>
 *     <li>List<T> where T is any of the above (opens list subeditor)</li>
 * </ul>
 * <pre>
 * Example:
 *  {@literal @EditableField}(label = "Max Players", icon = Material.PLAYER_HEAD, slot = 10)
 *   private int maxPlayers;
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EditableField {

    /** Human-readable label shown as the item display name. */
    String label() default "";

    /** Icon material used to represent this field in the menu. */
    Material icon() default Material.PAPER;

    /** Optional description lines added to the item lore (above the current value). */
    String[] description() default {};

    /**
     * Explicit slot index (0-based) in the inventory.
     * If left at -1, the EditorPage will auto-place fields left-to-right, top-to-bottom,
     * skipping border/decoration slots.
     */
    int slot() default -1;

    /**
     * For numeric fields: the amount added/subtracted per normal left/right click.
     * Shift-click will multiply this by 10.
     */
    double step() default 1.0;

    /**
     * For numeric fields: hard minimum value.
     * Ignored for non-numeric types.
     */
    double min() default Double.MIN_VALUE;

    /**
     * For numeric fields: hard maximum value.
     * Ignored for non-numeric types.
     */
    double max() default Double.MAX_VALUE;

    /*
     * For String fields: if true, opens an AnvilMenu for text input.
     * If false, prompts via chat (your own chat-input mechanism).
     *
     * ONLY ANVIL INPUT IS SUPPORTED AT THE MOMENT
     */
    //boolean useAnvil() default true;
}
