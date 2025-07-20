package org.nandayo.dapi.model;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.ColorizeType;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.util.Validate;

@SuppressWarnings("unused")
public class MiniString {
    static private final MiniMessage miniMessage = DAPI.getMiniMessage();

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


    @NotNull
    public MiniString copy() {
        return new MiniString(rawText);
    }

    @NotNull
    public MiniString copy(MiniString other) {
        Validate.validate(other != null, "MiniString cannot be null!");
        return new MiniString(other.rawText);
    }

    @NotNull
    public MiniString replace(String key, String value) {
        return new MiniString(rawText.replace(key, value));
    }

    @NotNull
    public MiniString colorize(ColorizeType colorizeType) {
        Validate.validate(colorizeType != null, "ColorizeType cannot be null!");
        return new MiniString(colorizeType.apply(rawText));
    }


    @NotNull
    public Component asComponent() {
        return miniMessage.deserialize(rawText);
    }
}
