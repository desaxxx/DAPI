package org.nandayo.dapi.message;

import lombok.Getter;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.jetbrains.annotations.NotNull;

@Getter
@SuppressWarnings("unused")
public class ChannelBossBarMessage extends ChannelMessage implements Cloneable {

    private int stayTicks = 60;
    private @NotNull BarColor color = BarColor.BLUE;
    private @NotNull BarStyle style = BarStyle.SOLID;
    private @NotNull BarFlag[] flags = new BarFlag[0];
    private double progress = 1.0;

    public ChannelBossBarMessage(@NotNull String message, int stayTicks, double progress, @NotNull BarColor color, @NotNull BarStyle style, @NotNull BarFlag... flags) {
        super(message);
        this.stayTicks = Math.max(1, stayTicks);
        progress(progress);
        this.color = color;
        this.style = style;
        this.flags = flags;
    }

    public ChannelBossBarMessage(@NotNull String message, int stayTicks, double progress) {
        super(message);
        this.stayTicks = Math.max(1, stayTicks);
        progress(progress);
    }

    public ChannelBossBarMessage(@NotNull String message) {
        super(message);
    }

    public void progress(double progress) {
        this.progress = Math.max(0, Math.min(1, progress));
    }

    static public ChannelBossBarMessage fromParent(@NotNull ChannelMessage message) {
        return new ChannelBossBarMessage(message.getMessage());
    }

    @Override
    public ChannelBossBarMessage clone() {
        return (ChannelBossBarMessage) super.clone();
    }
}
