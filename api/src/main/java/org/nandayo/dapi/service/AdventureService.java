package org.nandayo.dapi.service;

import lombok.Getter;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.util.Ticks;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.Util;
import org.nandayo.dapi.Wrapper;
import org.nandayo.dapi.message.ChannelBossBarMessage;
import org.nandayo.dapi.message.ChannelMessage;
import org.nandayo.dapi.message.ChannelTitleMessage;
import org.nandayo.dapi.message.ChannelType;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings("unused")
public class AdventureService {
    @Getter
    static private final MiniMessage miniMessage = MiniMessage.miniMessage();


    static public boolean isBukkitAudiencesSupported() {
        // As of platform-bukkit v4.4.0, it only supports up to MC 1.21.5
        return Wrapper.getMinecraftVersion() <= 215;
    }

    static private BukkitAudiences audiences;
    static public Optional<BukkitAudiences> getAudiences() {
        if(!isBukkitAudiencesSupported()) {
            Util.logInternal("BukkitAudiences is not supported in your MC version.");
        }
        if(audiences != null) return Optional.of(audiences);
        Util.logInternal("Called for BukkitAudiences - most likely a ChannelMessage use - but it wasn't registered.");
        return Optional.empty();
    }

    /**
     * Create BukkitAudiences instance. You can access it via {@link #getAudiences()}.
     * Don't forget to close it before disabling the plugin via {@link #closeAudiences()}.
     */
    static public void createAudiences() {
        audiences = BukkitAudiences.create(DAPI.getPlugin());
    }

    /**
     * Close BukkitAudiences instance to release used resources.
     */
    static public void closeAudiences() {
        if(audiences == null) return;
        audiences.close();
        audiences = null;
    }


    /**
     * Send message to a CommandSender with available option. (Audience or default)
     * @param receiver Message receiver
     * @param message ChannelMessage
     */
    static public void sendMessage(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
        if(DAPI.isPaper()) {
            receiver.sendMessage(message.getMessage());
        }else if(isBukkitAudiencesSupported()) {
            getAudiences().ifPresent(audiences ->
                    audiences.sender(receiver).sendMessage(message.getMessage())
            );
        }else {
            receiver.sendMessage(message.getRawMessage());
        }
    }

    /**
     * Send action bar message to a player with available option. (Audience or default)
     * @param player Message receiver
     * @param message ChannelMessage
     */
    static public void sendActionBar(@NotNull Player player, @NotNull ChannelMessage message) {
        if(DAPI.isPaper()) {
            player.sendActionBar(message.getMessage());
        }else if(isBukkitAudiencesSupported()) {
            getAudiences().ifPresent(audiences ->
                audiences.player(player).sendActionBar(message.getMessage())
            );
        }else {
            //noinspection deprecation
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message.getRawMessage()));
        }
    }


    /**
     * Send title to a player with available option. (Audience or default)
     * @param player Message receiver
     * @param titleMessage ChannelTitleMessage
     * @param type ChannelType
     */
    static public void sendTitle(@NotNull Player player, @NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {
        if(DAPI.isPaper()) {
            player.showTitle(AdventureService.createTitle(titleMessage, type));
        }else if(isBukkitAudiencesSupported()) {
            getAudiences().ifPresent(audiences ->
                audiences.player(player).showTitle(AdventureService.createTitle(titleMessage, type))
            );
        }else {
            //noinspection deprecation
            player.sendTitle(titleMessage.getRawMessage(), titleMessage.getRawSecondaryMessage(), titleMessage.getFadeInTicks(), titleMessage.getStayTicks(), titleMessage.getFadeOutTicks());
        }
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
     * Show boss bar to a player with available option. (Audience or default)
     * @param player Message receiver
     * @param bossBarMessage ChannelBossBarMessage
     */
    static public void showBossBar(@NotNull Player player, @NotNull ChannelBossBarMessage bossBarMessage) {
        if(DAPI.isPaper()) {
            BossBar adventureBossBar = BossBar.bossBar(bossBarMessage.getMessage(),
                    (float) bossBarMessage.getProgress(),
                    Parser.parseBarColor(bossBarMessage.getColor()),
                    Parser.parseBarStyle(bossBarMessage.getStyle()),
                    Parser.parseBarFlags(bossBarMessage.getFlags()));
            player.showBossBar(adventureBossBar);

            // removal
            Bukkit.getScheduler().runTaskLater(DAPI.getPlugin(), () ->
                player.hideBossBar(adventureBossBar)
            , bossBarMessage.getStayTicks());
        }else if(isBukkitAudiencesSupported()) {
            getAudiences().ifPresent(audiences -> {
                Audience audience = audiences.player(player);
                BossBar adventureBossBar = BossBar.bossBar(bossBarMessage.getMessage(),
                        (float) bossBarMessage.getProgress(),
                        Parser.parseBarColor(bossBarMessage.getColor()),
                        Parser.parseBarStyle(bossBarMessage.getStyle()),
                        Parser.parseBarFlags(bossBarMessage.getFlags()));
                audience.showBossBar(adventureBossBar);

                // removal
                Bukkit.getScheduler().runTaskLater(DAPI.getPlugin(), () ->
                    audience.hideBossBar(adventureBossBar)
                , bossBarMessage.getStayTicks());
            });
        }else {
            NamespacedKey key = new NamespacedKey("dapi", "boss_bar_" + Util.generateRandomLowerCaseString(8));
            KeyedBossBar bossBar = Bukkit.createBossBar(key, bossBarMessage.getRawMessage(), bossBarMessage.getColor(), bossBarMessage.getStyle(), bossBarMessage.getFlags());
            bossBar.addPlayer(player);

            // removal
            Bukkit.getScheduler().runTaskLater(DAPI.getPlugin(), () -> {
                bossBar.removePlayer(player);
                Bukkit.removeBossBar(key);
            }, bossBarMessage.getStayTicks());
        }
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
