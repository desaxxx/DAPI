package org.nandayo.dapi.message;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.util.Util;
import org.nandayo.dapi.model.MiniString;
import org.nandayo.dapi.util.Validate;

@Getter
@SuppressWarnings("unused")
public class ChannelTitleMessage extends ChannelMessage {

    private @NotNull MiniString secondaryMessage = new MiniString("");
    private int fadeInTicks = 10;
    private int stayTicks = 70;
    private int fadeOutTicks = 20;

    protected ChannelTitleMessage(MiniString message, MiniString secondaryMessage, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");

        this.secondaryMessage = secondaryMessage.copy();
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }

    public ChannelTitleMessage(String message, String secondaryMessage, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");

        this.secondaryMessage = new MiniString(secondaryMessage);
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }
    public ChannelTitleMessage(Component message, Component secondaryMessage, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");

        this.secondaryMessage = new MiniString(secondaryMessage);
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }

    protected ChannelTitleMessage(MiniString message) {
        super(message);
    }

    public ChannelTitleMessage(String message) {
        super(message);
    }
    public ChannelTitleMessage(Component message) {
        super(message);
    }

    public ChannelTitleMessage(String message, String secondaryMessage) {
        super(message);
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");
        this.secondaryMessage = new MiniString(secondaryMessage);
    }
    public ChannelTitleMessage(Component message, Component secondaryMessage) {
        super(message);
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");
        this.secondaryMessage = new MiniString(secondaryMessage);
    }

    public ChannelTitleMessage(String message, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }
    public ChannelTitleMessage(Component message, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }

    static public ChannelTitleMessage fromParent(ChannelMessage message) {
        return new ChannelTitleMessage(message.message);
    }



    @Override
    public ChannelTitleMessage copy() {
        return new ChannelTitleMessage(message, secondaryMessage, fadeInTicks, stayTicks, fadeOutTicks);
    }

    public String getRawSecondaryMessage() {
        return secondaryMessage.getRawText();
    }
    public Component getSecondaryMessage() {
        return secondaryMessage.asComponent();
    }

    @Override
    public ChannelTitleMessage insertPrefix() {
        return new ChannelTitleMessage(Util.PREFIX + message.getRawText(), Util.PREFIX + secondaryMessage.getRawText(), fadeInTicks, stayTicks, fadeOutTicks);
    }

    @Override
    public ChannelTitleMessage colorize(ColorizeType colorizeType) {
        return new ChannelTitleMessage(message.colorize(colorizeType), secondaryMessage.colorize(colorizeType), fadeInTicks, stayTicks, fadeOutTicks);
    }

    @Override
    public ChannelTitleMessage replace(String key, String value) {
        return new ChannelTitleMessage(message.replace(key, value), secondaryMessage.replace(key, value), fadeInTicks, stayTicks, fadeOutTicks);
    }
}
