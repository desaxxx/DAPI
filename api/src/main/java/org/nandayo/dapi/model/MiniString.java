package org.nandayo.dapi.model;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.util.Validate;

import java.util.List;

@SuppressWarnings("unused")
public class MiniString {
    static private final MiniMessage miniMessage = DAPI.getMiniMessage();
    static private final String ITALIC_FALSE = "<!italic>";

    @Getter
    private final @NotNull String rawText;

    public MiniString(String text) {
        Validate.validate(text != null, "MiniString text cannot be null!");
        this.rawText = text;
    }

    public MiniString(Component component) {
        Validate.validate(component != null, "MiniString component cannot be null!");
        this.rawText = miniMessage.serialize(component);
    }


    /**
     * Copies this MiniString.
     * @return new MiniString
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
     */
    @NotNull
    public MiniString replace(String key, String value) {
        return new MiniString(rawText.replace(key, value));
    }

    /**
     * Colorize the raw text with selected ColorizeType.
     * @param colorizeType ColorizeType
     * @return new MiniString
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
     *     and {@link org.bukkit.inventory.meta.ItemMeta#lore(List)}, which makes it true by default.
     * </p>
     * @return Component
     */
    @NotNull
    public Component asComponent() {
        return miniMessage.deserialize(ITALIC_FALSE + rawText);
    }
}
