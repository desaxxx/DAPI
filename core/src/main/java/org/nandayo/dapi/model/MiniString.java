package org.nandayo.dapi.model;

import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.util.Validate;

/**
 * Represents a MiniMessage helper model. Holds raw text of given String or serialized Component.
 * You can access the raw text with {@link #getRawText()} and deserialize to Component again with {@link #asComponent()}.
 *
 * @since 1.2.9
 * @apiNote  MiniString no longer supports {@code Component}
 */
@SuppressWarnings("unused")
@ApiStatus.Obsolete(since = "1.5")
public class MiniString {

    @Getter
    private final @NotNull String rawText;

    public MiniString(String text) {
        Validate.notNull(text, "MiniString text cannot be null!");
        this.rawText = text;
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public MiniString(Object component) {
        this.rawText = "";
    }


    /**
     * Copies this MiniString.
     * @return new MiniString
     * @since 1.2.9
     */
    @NotNull
    public MiniString copy() {
        return new MiniString(rawText);
    }

    /**
     * Replaces texts within raw text.
     * @param key Key to replace
     * @param value Value to replace key with
     * @return new MiniString
     * @since 1.2.9
     */
    @NotNull
    public MiniString replace(String key, String value) {
        return new MiniString(rawText.replace(key, value));
    }

    /**
     * Colorize the raw text with selected ColorizeType.
     * @param colorizeType ColorizeType
     * @return new MiniString
     * @since 1.2.9
     */
    @NotNull
    public MiniString colorize(ColorizeType colorizeType) {
        Validate.validate(colorizeType != null, "ColorizeType cannot be null!");
        return new MiniString(colorizeType.apply(rawText));
    }


    /**
     * Return a component from raw text using MiniMessage deserializer.
     * @return Component
     * @since 1.2.9
     */
    @Deprecated(since = "1.4.0", forRemoval = true)
    public Object asComponent() {
        return null;
    }
}
