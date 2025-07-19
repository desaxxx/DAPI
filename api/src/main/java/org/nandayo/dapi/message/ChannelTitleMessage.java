package org.nandayo.dapi.message;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.ColorizeType;
import org.nandayo.dapi.Util;

@Getter
@SuppressWarnings("unused")
public class ChannelTitleMessage extends ChannelMessage {

    private @NotNull String rawSecondaryMessage = "";
    private int fadeInTicks = 10;
    private int stayTicks = 70;
    private int fadeOutTicks = 20;

    public ChannelTitleMessage(@NotNull String message, @NotNull String secondaryMessage, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        this.rawSecondaryMessage = secondaryMessage;
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }
    public ChannelTitleMessage(@NotNull Component message, @NotNull Component secondaryMessage, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        this(miniMessage.serialize(message), miniMessage.serialize(secondaryMessage), fadeInTicks, stayTicks, fadeOutTicks);
    }

    public ChannelTitleMessage(@NotNull String message) {
        super(message);
    }
    public ChannelTitleMessage(@NotNull Component message) {
        this(miniMessage.serialize(message));
    }

    public ChannelTitleMessage(@NotNull String message, @NotNull String secondaryMessage) {
        super(message);
        this.rawSecondaryMessage = secondaryMessage;
    }
    public ChannelTitleMessage(@NotNull Component message, @NotNull Component secondaryMessage) {
        this(miniMessage.serialize(message), miniMessage.serialize(secondaryMessage));
    }

    public ChannelTitleMessage(@NotNull String message, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }
    public ChannelTitleMessage(@NotNull Component message, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        this(miniMessage.serialize(message), fadeInTicks, stayTicks, fadeOutTicks);
    }

    static public ChannelTitleMessage fromParent(@NotNull ChannelMessage message) {
        return new ChannelTitleMessage(message.rawMessage);
    }



    @Override
    public ChannelTitleMessage copy() {
        return new ChannelTitleMessage(rawMessage, rawSecondaryMessage, fadeInTicks, stayTicks, fadeOutTicks);
    }

    public Component getSecondaryMessage() {
        return miniMessage.deserialize(rawSecondaryMessage);
    }

    @Override
    public ChannelTitleMessage insertPrefix() {
        return new ChannelTitleMessage(Util.PREFIX + rawMessage, Util.PREFIX + rawSecondaryMessage, fadeInTicks, stayTicks, fadeOutTicks);
    }

    @Override
    public ChannelTitleMessage colorize(ColorizeType colorizeType) {
        return new ChannelTitleMessage(colorizeType.apply(rawMessage), colorizeType.apply(rawSecondaryMessage), fadeInTicks, stayTicks, fadeOutTicks);
    }

    @Override
    public ChannelTitleMessage replace(String key, String value) {
        return new ChannelTitleMessage(rawMessage.replace(key, value), rawSecondaryMessage.replace(key, value), fadeInTicks, stayTicks, fadeOutTicks);
    }
}
