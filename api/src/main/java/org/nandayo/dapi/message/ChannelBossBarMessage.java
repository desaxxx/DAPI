package org.nandayo.dapi.message;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.ColorizeType;
import org.nandayo.dapi.Util;
import org.nandayo.dapi.model.MiniString;
import org.nandayo.dapi.util.Validate;

@Getter
@SuppressWarnings("unused")
public class ChannelBossBarMessage extends ChannelMessage {

    private int stayTicks = 60;
    private @NotNull BarColor color = BarColor.BLUE;
    private @NotNull BarStyle style = BarStyle.SOLID;
    private @NotNull BarFlag[] flags = new BarFlag[0];
    private double progress = 1.0;

    protected ChannelBossBarMessage(MiniString message, int stayTicks, double progress, BarColor color, BarStyle style, BarFlag... flags) {
        super(message);
    }

    public ChannelBossBarMessage(String message, int stayTicks, double progress, BarColor color, BarStyle style, BarFlag... flags) {
        super(message);
        Validate.validate(color != null, "BarColor cannot be null!");
        Validate.validate(style != null, "BarStyle cannot be null!");
        Validate.validate(flags != null, "BarFlag cannot be null!");

        this.stayTicks = Math.max(1, stayTicks);
        this.progress = Math.max(0.0F, Math.min(1.0F, progress));
        this.color = color;
        this.style = style;
        this.flags = flags;
    }
    public ChannelBossBarMessage(Component message, int stayTicks, double progress, BarColor color, BarStyle style, BarFlag... flags) {
        this(Validate.validateReturn(() -> miniMessage.serialize(message),"Message cannot be null!"),
                stayTicks, progress, color, style, flags);
    }

    public ChannelBossBarMessage(String message, int stayTicks, double progress) {
        super(message);
        this.stayTicks = Math.max(1, stayTicks);
        this.progress = Math.max(0.0F, Math.min(1.0F, progress));
    }
    public ChannelBossBarMessage(Component message, int stayTicks, double progress) {
        this(Validate.validateReturn(() -> miniMessage.serialize(message),"Message cannot be null!"),
                stayTicks, progress);
    }

    protected ChannelBossBarMessage(MiniString message) {
        super(message);
    }

    public ChannelBossBarMessage(String message) {
        super(message);
    }
    public ChannelBossBarMessage(Component message) {
        this(Validate.validateReturn(() -> miniMessage.serialize(message),"Message cannot be null!"));
    }

    static public ChannelBossBarMessage fromParent(ChannelMessage message) {
        return new ChannelBossBarMessage(message.message);
    }

    
    
    @Override
    public ChannelBossBarMessage copy() {
        return new ChannelBossBarMessage(message, stayTicks, progress, color, style, flags);
    }

    public ChannelBossBarMessage progress(double progress) {
        return new ChannelBossBarMessage(message, stayTicks, progress, color, style, flags);
    }

    @Override
    public ChannelBossBarMessage insertPrefix() {
        return new ChannelBossBarMessage(Util.PREFIX + message.getRawText(), stayTicks, progress, color, style, flags);
    }

    @Override
    public ChannelBossBarMessage colorize(ColorizeType colorizeType) {
        return new ChannelBossBarMessage(message.colorize(colorizeType), stayTicks, progress, color, style, flags);
    }

    @Override
    public ChannelBossBarMessage replace(String key, String value) {
        return new ChannelBossBarMessage(message.replace(key, value), stayTicks, progress, color, style, flags);
    }
}
