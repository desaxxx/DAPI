package org.nandayo.dapi.adventure;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.message.ChannelBossBarMessage;
import org.nandayo.dapi.message.ChannelMessage;
import org.nandayo.dapi.message.ChannelTitleMessage;
import org.nandayo.dapi.message.ChannelType;

import java.util.Set;

/**
 * Service class for using Adventure related methods.
 * @since 1.3.0-BETA
 */
@ApiStatus.Experimental
@Deprecated(since = "1.4.0", forRemoval = true)
public final class AdventureService {

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static boolean isAdventureSupported() {
        return false;
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static boolean isMiniMessageSupported() {
        return false;
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static void validateMiniMessage() {
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static MiniMessage getMiniMessage() {
        return null;
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static void sendMessage(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {}

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static void sendActionBar(@NotNull Player player, @NotNull ChannelMessage message) {}

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static void sendTitle(@NotNull Player player, @NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {}

    @Deprecated(since = "1.4.0", forRemoval = true)
    private static Title createTitle(@NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {
        return null;
    }

    @Deprecated(since = "1.4.0", forRemoval = true)
    public static void showBossBar(@NotNull Player player, @NotNull ChannelBossBarMessage bossBarMessage) {}

    @Deprecated(since = "1.4.0", forRemoval = true)
    private static void showAdventureBossBar(@NotNull Player player, @NotNull ChannelBossBarMessage bossBarMessage) {}

    @Deprecated(since = "1.4.0", forRemoval = true)
    private static void showBukkitBossBar(@NotNull Player player, @NotNull ChannelBossBarMessage bossBarMessage) {}




    @Deprecated(since = "1.4.0", forRemoval = true)
    public static final class Parser {

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
}