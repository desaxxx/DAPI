package org.nandayo.dapi.message;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.util.Util;
import org.nandayo.dapi.model.MiniString;
import org.nandayo.dapi.util.Validate;

@Getter
@SuppressWarnings("unused")
public class ChannelMessage implements IChannelMessage {

    protected final @NotNull String message;

    @Deprecated(since = "1.5.3", forRemoval = true)
    protected ChannelMessage(MiniString message) {
        Validate.validate(message != null, "MiniString cannot be null!");
        this.message = message.copy().getRawText();
    }

    public ChannelMessage(String message) {
        Validate.validate(message != null, "Message cannot be null!");
        this.message = message;
    }
    @Deprecated(since = "1.4.0", forRemoval = true)
    public ChannelMessage(Object message) {
        Validate.validate(message != null, "Message cannot be null!");
        this.message = "";
    }



    @Override
    public ChannelMessage copy() {
        return new ChannelMessage(message);
    }

    @Override
    public String getRawMessage() {
        return message;
    }

    @Override
    @Deprecated(since = "1.4.0", forRemoval = true)
    public Object getMessage() {
        return null;
    }

    @Override
    public ChannelMessage insertPrefix() {
        return new ChannelMessage(Util.PREFIX + message);
    }

    @Override
    public ChannelMessage colorize(ColorizeType colorizeType) {
        return new ChannelMessage(colorizeType.apply(message));
    }

    @Override
    public ChannelMessage replace(String key, String value) {
        return new ChannelMessage(message.replace(key, value));
    }
}
