package org.nandayo.dapi.message;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.ColorizeType;
import org.nandayo.dapi.Util;

@Getter
@SuppressWarnings("unused")
public class ChannelBossBarMessage extends ChannelMessage {

    private int stayTicks = 60;
    private @NotNull BarColor color = BarColor.BLUE;
    private @NotNull BarStyle style = BarStyle.SOLID;
    private @NotNull BarFlag[] flags = new BarFlag[0];
    private double progress = 1.0;

    public ChannelBossBarMessage(@NotNull String message, int stayTicks, double progress, @NotNull BarColor color, @NotNull BarStyle style, @NotNull BarFlag... flags) {
        super(message);
        this.stayTicks = Math.max(1, stayTicks);
        this.progress = Math.max(0.0F, Math.min(1.0F, progress));
        this.color = color;
        this.style = style;
        this.flags = flags;
    }
    public ChannelBossBarMessage(@NotNull Component message, int stayTicks, double progress, @NotNull BarColor color, @NotNull BarStyle style, @NotNull BarFlag... flags) {
        this(miniMessage.serialize(message), stayTicks, progress, color, style, flags);
    }

    public ChannelBossBarMessage(@NotNull String message, int stayTicks, double progress) {
        super(message);
        this.stayTicks = Math.max(1, stayTicks);
        this.progress = Math.max(0.0F, Math.min(1.0F, progress));
    }
    public ChannelBossBarMessage(@NotNull Component message, int stayTicks, double progress) {
        this(miniMessage.serialize(message), stayTicks, progress);
    }

    public ChannelBossBarMessage(@NotNull String message) {
        super(message);
    }
    public ChannelBossBarMessage(@NotNull Component message) {
        this(miniMessage.serialize(message));
    }

    static public ChannelBossBarMessage fromParent(@NotNull ChannelMessage message) {
        return new ChannelBossBarMessage(message.rawMessage);
    }

    
    
    @Override
    public ChannelBossBarMessage copy() {
        return new ChannelBossBarMessage(rawMessage, stayTicks, progress, color, style, flags);
    }

    public ChannelBossBarMessage progress(double progress) {
        return new ChannelBossBarMessage(rawMessage, stayTicks, progress, color, style, flags);
    }

    @Override
    public ChannelBossBarMessage insertPrefix() {
        return new ChannelBossBarMessage(Util.PREFIX + rawMessage, stayTicks, progress, color, style, flags);
    }

    @Override
    public ChannelBossBarMessage colorize(ColorizeType colorizeType) {
        return new ChannelBossBarMessage(colorizeType.apply(rawMessage), stayTicks, progress, color, style, flags);
    }

    @Override
    public ChannelBossBarMessage replace(String key, String value) {
        return new ChannelBossBarMessage(rawMessage.replace(key, value), stayTicks, progress, color, style, flags);
    }
}
