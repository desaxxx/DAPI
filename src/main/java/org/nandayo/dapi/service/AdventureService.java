package org.nandayo.dapi.service;

import net.kyori.adventure.bossbar.BossBar;
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
import org.nandayo.dapi.message.ChannelBossBarMessage;
import org.nandayo.dapi.message.ChannelMessage;
import org.nandayo.dapi.message.ChannelTitleMessage;
import org.nandayo.dapi.message.ChannelType;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.util.Util;
import org.nandayo.dapi.util.Validate;

import java.util.HashSet;
import java.util.Set;

/**
 * Service class for using Adventure related methods.
 * @since 1.3.0-BETA
 */
public final class AdventureService {

    private static Boolean miniMessageSupported;
    /**
     * Check if MiniMessage is supported based on its existence on default package which is
     * {@code net.kyori.adventure.text.minimessage.MiniMessage}.
     * <p>
     *     Additional info:<br>
     *     Spigot doesn't bundle Adventure - no MiniMessage by default.<br>
     *     Paper bundles Adventure - MiniMessage is bundled as of 1.18.2.<br>
     * </p>
     * @return whether it's supported or not
     * @since 1.3.0-BETA
     */
    public static boolean isMiniMessageSupported() {
        if(miniMessageSupported != null) return miniMessageSupported;
        try {
            Class.forName("net.kyori.adventure.text.minimessage.MiniMessage");
            return miniMessageSupported = true;
        } catch (ClassNotFoundException e) {
            return miniMessageSupported = false;
        }
    }

    /**
     * Validates MiniMessage supporting.
     * @since 1.3.0-BETA
     */
    public static void validateMiniMessage() {
        Validate.validate(isMiniMessageSupported(), "MiniMessage is not supported on this server.");
    }

    private static Object miniMessage;
    /**
     * Get MiniMessage instance.<br>
     * <b>NOTE:</b> Check if MiniMessage is supported before using this via {@link #isMiniMessageSupported()}.
     * @return MiniMessage
     * @since 1.3.0-BETA
     */
    public static MiniMessage getMiniMessage() {
        if(miniMessage == null) miniMessage = MiniMessage.miniMessage();
        return (MiniMessage) miniMessage;
    }



    /**
     * Send message to a CommandSender with available option. (Audience or default)
     * @param receiver Message receiver
     * @param message ChannelMessage
     * @since 1.3.0-BETA
     */
    public static void sendMessage(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
        // getMessage uses MiniString#asComponent which requires MiniMessage.
        if(AdventureService.isMiniMessageSupported()) {
            receiver.sendMessage(message.colorize(ColorizeType.MINI_MESSAGE).getMessage());
        }else {
            receiver.sendMessage(message.colorize(ColorizeType.LEGACY).getRawMessage());
        }
    }

    /**
     * Send action bar message to a player with available option. (Audience or default)
     * @param player Message receiver
     * @param message ChannelMessage
     * @since 1.3.0-BETA
     */
    public static void sendActionBar(@NotNull Player player, @NotNull ChannelMessage message) {
        // getMessage uses MiniString#asComponent which requires MiniMessage.
        if(AdventureService.isMiniMessageSupported()) {
            player.sendActionBar(message.colorize(ColorizeType.MINI_MESSAGE).getMessage());
        }else {
            //noinspection deprecation
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message.colorize(ColorizeType.LEGACY).getRawMessage()));
        }
    }


    /**
     * Send title to a player with available option. (Audience or default)
     * @param player Message receiver
     * @param titleMessage ChannelTitleMessage
     * @param type ChannelType
     * @since 1.3.0-BETA
     */
    public static void sendTitle(@NotNull Player player, @NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {
        // getMessage uses MiniString#asComponent which requires MiniMessage.
        if(AdventureService.isMiniMessageSupported()) {
            player.showTitle(createTitle(titleMessage.colorize(ColorizeType.MINI_MESSAGE), type));
        }else {
            ChannelTitleMessage ttMessage = titleMessage.colorize(ColorizeType.LEGACY);
            //noinspection deprecation
            player.sendTitle(ttMessage.getRawMessage(), ttMessage.getRawSecondaryMessage(), ttMessage.getFadeInTicks(), ttMessage.getStayTicks(), ttMessage.getFadeOutTicks());
        }
    }

    /**
     * Create Adventure Title object from ChannelTitleMessage.
     * @param titleMessage ChannelTitleMessage
     * @param type ChannelType
     * @return Title
     * @since 1.3.0-BETA
     */
    private static Title createTitle(@NotNull ChannelTitleMessage titleMessage, @NotNull ChannelType type) {
        Component titleComponent = type == ChannelType.TITLE || type == ChannelType.TITLE_AND_SUBTITLE ? titleMessage.getMessage() : Component.empty();
        Component subtitleComponent = type == ChannelType.SUBTITLE || type == ChannelType.TITLE_AND_SUBTITLE ? titleMessage.getSecondaryMessage() : Component.empty();
        return Title.title(titleComponent, subtitleComponent,
                Title.Times.times(Ticks.duration(titleMessage.getFadeInTicks()), Ticks.duration(titleMessage.getStayTicks()), Ticks.duration(titleMessage.getFadeOutTicks())));
    }


    /**
     * Show boss bar to a player with available option. (Audience or default)
     * @param player Message receiver
     * @param bossBarMessage ChannelBossBarMessage
     * @since 1.3.0-BETA
     */
    public static void showBossBar(@NotNull Player player, @NotNull ChannelBossBarMessage bossBarMessage) {
        // getMessage uses MiniString#asComponent which requires MiniMessage.
        if(AdventureService.isMiniMessageSupported()) {
            showAdventureBossBar(player, bossBarMessage);
        }else {
            showBukkitBossBar(player, bossBarMessage);
        }
    }

    /**
     * Show {@link BossBar Adventure BossBar} to the player with {@link ChannelBossBarMessage}.
     * @param player Player
     * @param bossBarMessage ChannelBossBarMessage
     * @since 1.3.1
     */
    private static void showAdventureBossBar(@NotNull Player player, @NotNull ChannelBossBarMessage bossBarMessage) {
        ChannelBossBarMessage bbMessage = bossBarMessage.colorize(ColorizeType.MINI_MESSAGE);
        BossBar adventureBossBar = BossBar.bossBar(bbMessage.getMessage(),
                (float) bbMessage.getProgress(),
                Parser.parseBarColor(bbMessage.getColor()),
                Parser.parseBarStyle(bbMessage.getStyle()),
                Parser.parseBarFlags(bbMessage.getFlags()));
        player.showBossBar(adventureBossBar);

        // removal of BossBar
        Bukkit.getScheduler().runTaskLater(DAPI.getPlugin(), () ->
                        player.hideBossBar(adventureBossBar)
                ,bbMessage.getStayTicks());
    }

    /**
     * Show {@link KeyedBossBar Bukkit BossBar} to the player with {@link ChannelBossBarMessage}.
     * @param player Player
     * @param bossBarMessage ChannelBossBarMessage
     * @since 1.3.1
     */
    private static void showBukkitBossBar(@NotNull Player player, @NotNull ChannelBossBarMessage bossBarMessage) {
        ChannelBossBarMessage bbMessage = bossBarMessage.colorize(ColorizeType.LEGACY);
        NamespacedKey key = new NamespacedKey("dapi","boss_bar_" + Util.generateRandomLowerCaseString(8));
        KeyedBossBar bb = Bukkit.createBossBar(key, bbMessage.getRawMessage(), bbMessage.getColor(), bbMessage.getStyle(), bbMessage.getFlags());
        bb.addPlayer(player);

        // removal of BossBar
        Bukkit.getScheduler().runTaskLater(DAPI.getPlugin(), () -> {
            bb.removePlayer(player);
            Bukkit.removeBossBar(key);
        }, bbMessage.getStayTicks());
    }




    /**
     * Parser for some Bukkit objects to Adventure object.
     * @since 1.3.0-BETA
     */
    public static final class Parser {

        /**
         * Parse a {@link BarColor Bukkit BarColor} to {@link BossBar.Color Adventure BossBar.Color}.
         * @param color BarColor
         * @return BossBar.Color
         * @since 1.3.0-BETA
         */
        public static BossBar.Color parseBarColor(BarColor color) {
            try {
                return BossBar.Color.valueOf(color.name());
            } catch (IllegalArgumentException e) {
                return BossBar.Color.BLUE;
            }
        }

        /**
         * Parse a {@link BarStyle Bukkit BarStyle} to {@link BossBar.Overlay Adventure BossBar.Overlay}.
         * @param style BarStyle
         * @return BossBar.Overlay
         * @since 1.3.0-BETA
         */
        public static BossBar.Overlay parseBarStyle(@NotNull BarStyle style) {
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

        /**
         * Parse a set of {@link BarFlag Bukkit BarFlag} to set of {@link BossBar.Flag Adventure BossBar.Flag}.
         * @param flags Set of BarFlag
         * @return Set of BossBar.Flag
         * @since 1.3.0-BETA
         */
        public static Set<BossBar.Flag> parseBarFlags(@NotNull BarFlag... flags) {
            Set<BossBar.Flag> set = new HashSet<>();
            for (BarFlag flag : flags) {
                set.add(parseBarFlag(flag));
            }
            return set;
        }

        /**
         * Parse a {@link BarFlag Bukkit BarFlag} to {@link BossBar.Flag Adventure BossBar.Flag}.
         * @param flag BarFlag
         * @return BossBar.Flag
         * @since 1.3.0-BETA
         */
        public static BossBar.Flag parseBarFlag(@NotNull BarFlag flag) {
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