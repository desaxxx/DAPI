package org.nandayo.dapi.service;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.message.ChannelBossBarMessage;
import org.nandayo.dapi.message.ChannelMessage;
import org.nandayo.dapi.message.ChannelTitleMessage;
import org.nandayo.dapi.message.ChannelType;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Bukkit-platform doesn't bundle MiniMessage. As use of MiniString requires that,
 * dropping MiniMessage support for Spigot.
 * @deprecated Bukkit Audience is removed due internal problems. Other methods are
 * transferred to {@link AdventureService}
 */
@SuppressWarnings("unused")
@Deprecated(since = "1.3.0-BETA", forRemoval = true)
public class BukkitAdventureService {

    public static boolean isBukkitAudiencesSupported() {
        return false;
    }
    public static Optional<Object> getAudiences() {
        return Optional.empty();
    }
    public static void createAudiences() {}
    public static void closeAudiences() {}
    public static void sendMessage(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {}
    public static void sendActionBar(@NotNull Player player, @NotNull ChannelMessage message) {}
    public static void sendTitle(@NotNull Player player, @NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {}
    private static Title createTitle(@NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {
        return Title.title(Component.empty(), Component.empty());
    }
    public static void showBossBar(@NotNull Player player, @NotNull ChannelBossBarMessage bossBarMessage) {}

    @Deprecated(since = "1.3.0-BETA", forRemoval = true)
    private static class Parser {

        public static BossBar.Color parseBarColor(BarColor color) {
            return BossBar.Color.BLUE;
        }

        public static BossBar.Overlay parseBarStyle(@NotNull BarStyle style) {
            return BossBar.Overlay.PROGRESS;
        }

        public static Set<BossBar.Flag> parseBarFlags(@NotNull BarFlag... flags) {
            return new HashSet<>();
        }
        public static BossBar.Flag parseBarFlag(@NotNull BarFlag flag) {
            return BossBar.Flag.DARKEN_SCREEN;
        }
    }
}
