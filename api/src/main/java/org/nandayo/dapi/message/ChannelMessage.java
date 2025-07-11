package org.nandayo.dapi.message;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.Util;

@Getter
@SuppressWarnings("unused")
public class ChannelMessage implements Cloneable {

    private @NotNull String message;

    public ChannelMessage(@NotNull String message) {
        this.message = message;
    }

    public void insertPrefix() {
        this.message = Util.PREFIX + message;
    }

    @Override
    public ChannelMessage clone() {
        try {
            return (ChannelMessage) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public ChannelMessage replace(@NotNull String key, @NotNull String value) {
        this.message = this.message.replace(key, value);
        return this;
    }
}
