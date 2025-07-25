package org.nandayo.dapi.service;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
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

    static public boolean isBukkitAudiencesSupported() {
        return false;
    }
    static public Optional<BukkitAudiences> getAudiences() {
        return Optional.empty();
    }
    static public void createAudiences() {}
    static public void closeAudiences() {}
    static public void sendMessage(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {}
    static public void sendActionBar(@NotNull Player player, @NotNull ChannelMessage message) {}
    static public void sendTitle(@NotNull Player player, @NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {}
    static private Title createTitle(@NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {
        return Title.title(Component.empty(), Component.empty());
    }
    static public void showBossBar(@NotNull Player player, @NotNull ChannelBossBarMessage bossBarMessage) {}

    @Deprecated(since = "1.3.0-BETA", forRemoval = true)
    static private class Parser {

        static public BossBar.Color parseBarColor(BarColor color) {
            return BossBar.Color.BLUE;
        }

        static public BossBar.Overlay parseBarStyle(@NotNull BarStyle style) {
            return BossBar.Overlay.PROGRESS;
        }

        static public Set<BossBar.Flag> parseBarFlags(@NotNull BarFlag... flags) {
            return new HashSet<>();
        }
        static public BossBar.Flag parseBarFlag(@NotNull BarFlag flag) {
            return BossBar.Flag.DARKEN_SCREEN;
        }
    }
}
