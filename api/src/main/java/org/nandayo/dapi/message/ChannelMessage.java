package org.nandayo.dapi.message;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.ColorizeType;
import org.nandayo.dapi.Util;

@Getter
@SuppressWarnings("unused")
public class ChannelMessage implements IChannelMessage {

    protected final @NotNull String rawMessage;

    public ChannelMessage(@NotNull String message) {
        this.rawMessage = message;
    }
    public ChannelMessage(@NotNull Component message) {
        this.rawMessage = miniMessage.serialize(message);
    }



    @Override
    public ChannelMessage copy() {
        return new ChannelMessage(rawMessage);
    }

    @Override
    public Component getMessage() {
        return miniMessage.deserialize(rawMessage);
    }

    @Override
    public ChannelMessage insertPrefix() {
        return new ChannelMessage(Util.PREFIX + rawMessage);
    }

    @Override
    public ChannelMessage colorize(ColorizeType colorizeType) {
        return new ChannelMessage(colorizeType.apply(rawMessage));
    }

    @Override
    public ChannelMessage replace(String key, String value) {
        return new ChannelMessage(rawMessage.replace(key, value));
    }
}
