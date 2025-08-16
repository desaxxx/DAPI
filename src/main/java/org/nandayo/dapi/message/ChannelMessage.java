package org.nandayo.dapi.message;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.service.AdventureProvider;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.util.Util;
import org.nandayo.dapi.model.MiniString;
import org.nandayo.dapi.util.Validate;

@Getter
@SuppressWarnings("unused")
public class ChannelMessage implements IChannelMessage {

    protected final @NotNull MiniString message;

    protected ChannelMessage(MiniString message) {
        Validate.validate(message != null, "MiniString cannot be null!");
        this.message = message.copy();
    }

    public ChannelMessage(String message) {
        Validate.validate(message != null, "Message cannot be null!");
        this.message = new MiniString(message);
    }
    public ChannelMessage(Component message) {
        Validate.validate(message != null, "Message cannot be null!");
        this.message = new MiniString(message);
    }



    @Override
    public ChannelMessage copy() {
        return new ChannelMessage(message);
    }

    @Override
    public String getRawMessage() {
        return message.getRawText();
    }

    @Override
    public AdventureProvider.ComponentProvider getMessage() {
        return message.asComponent();
    }

    @Override
    public ChannelMessage insertPrefix() {
        return new ChannelMessage(Util.PREFIX + message.getRawText());
    }

    @Override
    public ChannelMessage colorize(ColorizeType colorizeType) {
        return new ChannelMessage(message.colorize(colorizeType));
    }

    @Override
    public ChannelMessage replace(String key, String value) {
        return new ChannelMessage(message.replace(key, value));
    }
}
