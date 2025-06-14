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

    public ChannelBossBarMessage(@NotNull String message, int stayTicks, @NotNull BarColor color, @NotNull BarStyle style, @NotNull BarFlag... flags) {
        super(message);
        this.stayTicks = Math.max(1, stayTicks);
        this.color = color;
        this.style = style;
        this.flags = flags;
    }

    public ChannelBossBarMessage(@NotNull String message, int stayTicks) {
        super(message);
        this.stayTicks = Math.max(1, stayTicks);
    }

    public ChannelBossBarMessage(@NotNull String message) {
        super(message);
    }

    @Override
    public ChannelBossBarMessage clone() {
        return (ChannelBossBarMessage) super.clone();
    }
}
