package org.nandayo.dapi.message;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.util.Util;
import org.nandayo.dapi.model.MiniString;
import org.nandayo.dapi.util.Validate;

@Getter
@SuppressWarnings("unused")
public class ChannelTitleMessage extends ChannelMessage {

    private @NotNull String secondaryMessage = "";
    private int fadeInTicks = 10;
    private int stayTicks = 70;
    private int fadeOutTicks = 20;

    @Deprecated(since = "1.5.3", forRemoval = true)
    protected ChannelTitleMessage(MiniString message, MiniString secondaryMessage, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message.getRawText());
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");

        this.secondaryMessage = secondaryMessage.copy().getRawText();
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }

    public ChannelTitleMessage(String message, String secondaryMessage, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");

        this.secondaryMessage = secondaryMessage;
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }
    @Deprecated(since = "1.4.0", forRemoval = true)
    public ChannelTitleMessage(Object message, Object secondaryMessage, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super("");
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");

        this.secondaryMessage = "";
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }

    @Deprecated(since = "1.5.3", forRemoval = true)
    protected ChannelTitleMessage(MiniString message) {
        super(message.getRawText());
    }

    @Deprecated(since = "1.5.3", forRemoval = true)
    protected ChannelTitleMessage(MiniString message, MiniString secondaryMessage) {
        super(message.getRawText());
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");
        this.secondaryMessage = secondaryMessage.copy().getRawText();
    }

    public ChannelTitleMessage(String message) {
        super(message);
    }
    @Deprecated(since = "1.4.0", forRemoval = true)
    public ChannelTitleMessage(Object message) {
        super("");
    }

    public ChannelTitleMessage(String message, String secondaryMessage) {
        super(message);
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");
        this.secondaryMessage = secondaryMessage;
    }
    @Deprecated(since = "1.4.0", forRemoval = true)
    public ChannelTitleMessage(Object message, Object secondaryMessage) {
        super("");
        Validate.validate(secondaryMessage != null, "Secondary message cannot be null!");
        this.secondaryMessage = "";
    }

    public ChannelTitleMessage(String message, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super(message);
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }
    @Deprecated(since = "1.4.0", forRemoval = true)
    public ChannelTitleMessage(Object message, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        super("");
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }

    public static ChannelTitleMessage fromParent(ChannelMessage message, boolean isTitle) {
        if(isTitle) {
            return new ChannelTitleMessage(message.message);
        }else {
            return new ChannelTitleMessage("", message.message);
        }
    }



    @Override
    public ChannelTitleMessage copy() {
        return new ChannelTitleMessage(message, secondaryMessage, fadeInTicks, stayTicks, fadeOutTicks);
    }

    public String getRawSecondaryMessage() {
        return secondaryMessage;
    }
    @Deprecated(since = "1.4.0", forRemoval = true)
    public Object getSecondaryMessage() {
        return null;
    }

    @Override
    public ChannelTitleMessage insertPrefix() {
        return new ChannelTitleMessage(Util.PREFIX + message, Util.PREFIX + secondaryMessage, fadeInTicks, stayTicks, fadeOutTicks);
    }

    @Override
    public ChannelTitleMessage colorize(ColorizeType colorizeType) {
        return new ChannelTitleMessage(colorizeType.apply(message), colorizeType.apply(message), fadeInTicks, stayTicks, fadeOutTicks);
    }

    @Override
    public ChannelTitleMessage replace(String key, String value) {
        return new ChannelTitleMessage(message.replace(key, value), secondaryMessage.replace(key, value), fadeInTicks, stayTicks, fadeOutTicks);
    }
}
