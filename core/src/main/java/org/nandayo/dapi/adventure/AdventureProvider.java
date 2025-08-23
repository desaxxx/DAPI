package org.nandayo.dapi.adventure;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.message.ChannelTitleMessage;
import org.nandayo.dapi.message.ChannelType;
import org.nandayo.dapi.util.Validate;

import java.util.Set;

/**
 * @since 1.4.0
 */
@ApiStatus.Experimental
@Deprecated(since = "1.4.0", forRemoval = true)
public class AdventureProvider {

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static MiniMessage getMiniMessage() {
        return null;
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static ComponentProvider createComponentProvider(String miniMessage) {
        return null;
    }

    /**
     * @since 1.4.0
     */
    @Deprecated(since = "1.4.0", forRemoval = true)
    public static class ComponentProvider {

        private final String miniMessage;
        @Deprecated(since = "1.4.0", forRemoval = true)
        public ComponentProvider(String miniMessage) {
            Validate.notNull(miniMessage, "MiniMessage string cannot be null.");
            this.miniMessage = miniMessage;
        }

        @Deprecated(since = "1.4.0", forRemoval = true)
        public Component get() {
            return null;
        }
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static Title createTitle(@NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {
        return null;
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static BossBar.Color parseBarColor(BarColor color) {
        return null;
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static BossBar.Overlay parseBarStyle(@NotNull BarStyle style) {
        return null;
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static Set<BossBar.Flag> parseBarFlags(@NotNull BarFlag... flags) {
        return null;
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static BossBar.Flag parseBarFlag(@NotNull BarFlag flag) {
        return null;
    }
}
