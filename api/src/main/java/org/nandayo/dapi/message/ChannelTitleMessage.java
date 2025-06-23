package org.nandayo.dapi.message;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.Util;

@Getter
@SuppressWarnings("unused")
public class ChannelTitleMessage extends ChannelMessage implements Cloneable {

    private @NotNull String secondaryMessage = "";
    private int fadeInTicks = 10;
    private int stayTicks = 70;
    private int fadeOutTicks = 20;

    public ChannelTitleMessage(@NotNull String message, @NotNull String secondaryMessage, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        this.secondaryMessage = secondaryMessage;
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }

    public ChannelTitleMessage(@NotNull String message) {
        super(message);
    }

    public ChannelTitleMessage(@NotNull String message, @NotNull String secondaryMessage) {
        super(message);
        this.secondaryMessage = secondaryMessage;
    }

    public ChannelTitleMessage(@NotNull String message, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }

    static public ChannelTitleMessage fromParent(@NotNull ChannelMessage message) {
        return new ChannelTitleMessage(message.getMessage());
    }

    @Override
    public void insertPrefix() {
        super.insertPrefix();
        this.secondaryMessage = Util.PREFIX + secondaryMessage;
    }

    @Override
    public ChannelTitleMessage clone() {
        return (ChannelTitleMessage) super.clone();
    }
}
