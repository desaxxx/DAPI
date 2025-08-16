package org.nandayo.dapi.model;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.service.AdventureProvider;
import org.nandayo.dapi.service.AdventureService;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.util.Validate;

/**
 * Represents a MiniMessage helper model. Holds raw text of given String or serialized Component.
 * You can access the raw text with {@link #getRawText()} and deserialize to Component again with {@link #asComponent()}.
 *
 * @since 1.2.9
 */
@SuppressWarnings("unused")
public class MiniString {

    @Getter
    private final @NotNull String rawText;

    public MiniString(String text) {
        Validate.notNull(text, "MiniString text cannot be null!");
        this.rawText = text;
    }

    public MiniString(Object component) {
        Validate.notNull(component, "MiniString component cannot be null!");
        AdventureService.validateMiniMessage();
        Validate.validate(component instanceof Component, "Object is not a Component.");
        this.rawText = AdventureProvider.getMiniMessage().serialize((Component) component);
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
    @NotNull
    public AdventureProvider.ComponentProvider asComponent() {
        AdventureService.validateMiniMessage();
        return AdventureProvider.createComponentProvider(rawText);
    }
}
