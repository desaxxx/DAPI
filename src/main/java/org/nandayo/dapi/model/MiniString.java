package org.nandayo.dapi.model;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.service.AdventureService;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.util.Validate;

import java.util.List;

/**
 * Represents a MiniMessage helper model. Holds raw text of given String or serialized Component.
 * You can access the raw text with {@link #getRawText()} and deserialize to Component again with {@link #asComponent()}.
 * <b>CAUTION:</b>
 *
 * @since 1.2.9
 */
@SuppressWarnings("unused")
public class MiniString {
    static private final String ITALIC_FALSE = "<!italic>";

    @Getter
    private final @NotNull String rawText;

    public MiniString(String text) {
        Validate.validate(text != null, "MiniString text cannot be null!");
        this.rawText = text;
    }

    public MiniString(Component component) {
        AdventureService.validateMiniMessage();
        Validate.validate(component != null, "MiniString component cannot be null!");
        this.rawText = AdventureService.getMiniMessage().serialize(component);
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
     * Return a component from raw text using MiniMessage deserializer.<br>
     * <p>
     *     Italic decoration is off by default to override {@link org.bukkit.inventory.meta.ItemMeta#displayName(Component)}
     *     and {@link org.bukkit.inventory.meta.ItemMeta#lore(List)} which makes it true by default.
     * </p>
     * @return Component
     * @since 1.2.9
     */
    @NotNull
    public Component asComponent() {
        AdventureService.validateMiniMessage();
        return AdventureService.getMiniMessage().deserialize(ITALIC_FALSE + rawText);
    }
}
