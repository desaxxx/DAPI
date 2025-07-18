package org.nandayo.dapi.message;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.HexUtil;
import org.nandayo.dapi.Util;
import org.nandayo.dapi.service.AdventureService;

@Getter
@SuppressWarnings("unused")
public class ChannelMessage implements Cloneable {
    static protected final MiniMessage miniMessage = AdventureService.getMiniMessage();

    private @NotNull String rawMessage;

    public ChannelMessage(@NotNull String message) {
        this.rawMessage = message;
    }
    public ChannelMessage(@NotNull Component message) {
        this.rawMessage = miniMessage.serialize(message);
    }



    @Override
    public ChannelMessage clone() {
        try {
            return (ChannelMessage) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public ChannelMessage insertPrefix() {
        this.rawMessage = Util.PREFIX + rawMessage;
        return this;
    }

    public ChannelMessage replaceHexColors() {
        this.rawMessage = HexUtil.parse(rawMessage);
        return this;
    }

    public ChannelMessage replace(@NotNull String key, @NotNull String value) {
        this.rawMessage = rawMessage.replace(key, value);
        return this;
    }

    public Component getMessage() {
        return miniMessage.deserialize(rawMessage);
    }
}
