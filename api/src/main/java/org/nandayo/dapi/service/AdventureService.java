package org.nandayo.dapi.service;

import lombok.Getter;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.util.Ticks;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.Util;
import org.nandayo.dapi.message.ChannelBossBarMessage;
import org.nandayo.dapi.message.ChannelMessage;
import org.nandayo.dapi.message.ChannelTitleMessage;
import org.nandayo.dapi.message.ChannelType;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AdventureService {

    @Getter
    static private final MiniMessage miniMessage = MiniMessage.miniMessage();
    static private BukkitAudiences audiences;
    static public Optional<BukkitAudiences> getAudiences() {
        if(audiences != null) return Optional.of(audiences);
        Util.log("Called for BukkitAudiences - most likely a ChannelMessage use - but it wasn't registered.");
        return Optional.empty();
    }

    @NotNull
    static public BukkitAudiences createAudiences() {
        return audiences = BukkitAudiences.create(DAPI.getPlugin());
    }
    static public void closeAudiences() {
        if(audiences == null) return;
        audiences.close();
        audiences = null;
    }


    static public void sendMessage(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
        getAudiences().ifPresent(audiences -> {
            Audience audience = audiences.sender(receiver);
            audience.sendMessage(message.getMessage());
        });
    }

    static public void sendActionBar(@NotNull Player player, @NotNull ChannelMessage message) {
        getAudiences().ifPresent(audiences -> {
            Audience audience = audiences.player(player);
            audience.sendActionBar(message.getMessage());
        });
    }


    /**
     * Send title using BukkitAudience.
     * @param player Player
     * @param titleMessage ChannelTitleMessage
     * @param type ChannelType
     */
    static public void sendTitle(@NotNull Player player, @NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {
        getAudiences().ifPresent(audiences -> {
            Audience audience = audiences.player(player);
            audience.showTitle(AdventureService.createTitle(titleMessage, type));
        });
    }

    /**
     * Create Adventure Title object from ChannelTitleMessage.
     * @param titleMessage ChannelTitleMessage
     * @param type ChannelType
     * @return Title
     */
    static private Title createTitle(@NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {
        Component titleComponent = type == ChannelType.TITLE || type == ChannelType.TITLE_AND_SUBTITLE ? titleMessage.getMessage() : Component.empty();
        Component subtitleComponent = type == ChannelType.SUBTITLE || type == ChannelType.TITLE_AND_SUBTITLE ? titleMessage.getSecondaryMessage() : Component.empty();
        return Title.title(titleComponent, subtitleComponent,
                Title.Times.times(Ticks.duration(titleMessage.getFadeInTicks()), Ticks.duration(titleMessage.getStayTicks()), Ticks.duration(titleMessage.getFadeOutTicks())));
    }


    /**
     * Show boss bar to player using BukkitAudience.
     * @param player Player
     * @param bossBarMessage ChannelBossBarMessage
     */
    static public void showBossBar(@NotNull Player player, @NotNull ChannelBossBarMessage bossBarMessage) {
        getAudiences().ifPresent(audiences -> {
            Audience audience = audiences.player(player);
            BossBar adventureBossBar = BossBar.bossBar(bossBarMessage.getMessage(),
                    (float) bossBarMessage.getProgress(),
                    Parser.parseBarColor(bossBarMessage.getColor()),
                    Parser.parseBarStyle(bossBarMessage.getStyle()),
                    Parser.parseBarFlags(bossBarMessage.getFlags()));
            audience.showBossBar(adventureBossBar);

            // removal
            Bukkit.getScheduler().runTaskLater(DAPI.getPlugin(), () -> {
                audience.hideBossBar(adventureBossBar);
            }, bossBarMessage.getStayTicks());
        });
    }




    static private class Parser {

        static public BossBar.Color parseBarColor(BarColor color) {
            try {
                return BossBar.Color.valueOf(color.name());
            } catch (IllegalArgumentException e) {
                return BossBar.Color.BLUE;
            }
        }

        static public BossBar.Overlay parseBarStyle(@NotNull BarStyle style) {
            switch (style) {
                case SEGMENTED_6:
                    return BossBar.Overlay.NOTCHED_6;
                case SEGMENTED_10:
                    return BossBar.Overlay.NOTCHED_10;
                case SEGMENTED_12:
                    return BossBar.Overlay.NOTCHED_12;
                case SEGMENTED_20:
                    return BossBar.Overlay.NOTCHED_20;
                default:
                    return BossBar.Overlay.PROGRESS;
            }
        }

        static public Set<BossBar.Flag> parseBarFlags(@NotNull BarFlag... flags) {
            Set<BossBar.Flag> set = new HashSet<>();
            for (BarFlag flag : flags) {
                set.add(parseBarFlag(flag));
            }
            return set;
        }
        static public BossBar.Flag parseBarFlag(@NotNull BarFlag flag) {
            switch (flag) {
                case PLAY_BOSS_MUSIC:
                    return BossBar.Flag.PLAY_BOSS_MUSIC;
                case CREATE_FOG:
                    return BossBar.Flag.CREATE_WORLD_FOG;
                default:
                    return BossBar.Flag.DARKEN_SCREEN;
            }
        }
    }
}
