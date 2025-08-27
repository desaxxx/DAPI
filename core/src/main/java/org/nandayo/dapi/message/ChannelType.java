package org.nandayo.dapi.message;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.util.Util;

@SuppressWarnings("unused")
public abstract class ChannelType {

    private ChannelType() {}

    public static final ChannelType CHAT = new ChannelType() {
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            receiver.sendMessage(message.colorize(ColorizeType.LEGACY).getRawMessage());
        }
    };

    public static final ChannelType ACTION_BAR = new ChannelType() {
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            if(!(receiver instanceof Player)) return;
            Player player = (Player) receiver;
            //noinspection deprecation
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message.colorize(ColorizeType.LEGACY).getRawMessage()));
        }
    };

    public static final ChannelType TITLE = new ChannelType() {
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            if(!(receiver instanceof Player)) return;
            Player player = (Player) receiver;

            ChannelTitleMessage titleMessage = message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message, true);
            player.sendTitle(titleMessage.getRawMessage(), "", titleMessage.getFadeInTicks(), titleMessage.getStayTicks(), titleMessage.getFadeOutTicks());
        }
    };

    public static final ChannelType SUBTITLE = new ChannelType() {
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            if(!(receiver instanceof Player)) return;
            Player player = (Player) receiver;

            ChannelTitleMessage titleMessage = (message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message,false)).colorize(ColorizeType.LEGACY);
            player.sendTitle("", titleMessage.getRawSecondaryMessage(), titleMessage.getFadeInTicks(), titleMessage.getStayTicks(), titleMessage.getFadeOutTicks());
        }
    };

    public static final ChannelType TITLE_AND_SUBTITLE = new ChannelType() {
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            if(!(receiver instanceof Player)) return;
            Player player = (Player) receiver;

            ChannelTitleMessage titleMessage = (message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message,true)).colorize(ColorizeType.LEGACY);
            player.sendTitle(titleMessage.getRawMessage(), titleMessage.getRawSecondaryMessage(), titleMessage.getFadeInTicks(), titleMessage.getStayTicks(), titleMessage.getFadeOutTicks());
        }
    };

    public static final ChannelType BOSS_BAR = new ChannelType() {
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            if(!(receiver instanceof Player)) return;
            Player player = (Player) receiver;

            ChannelBossBarMessage bossBarMessage = (message instanceof ChannelBossBarMessage ? (ChannelBossBarMessage) message : ChannelBossBarMessage.fromParent(message)).colorize(ColorizeType.LEGACY);
            @SuppressWarnings("UnstableApiUsage")
            NamespacedKey key = new NamespacedKey("dapi","boss_bar_" + Util.generateRandomLowerCaseString(8));
            KeyedBossBar bb = Bukkit.createBossBar(key, bossBarMessage.getRawMessage(), bossBarMessage.getColor(), bossBarMessage.getStyle(), bossBarMessage.getFlags());
            bb.addPlayer(player);

            // removal of BossBar
            Bukkit.getScheduler().runTaskLater(DAPI.getPlugin(), () -> {
                bb.removePlayer(player);
                Bukkit.removeBossBar(key);
            }, bossBarMessage.getStayTicks());
        }
    };


    abstract public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message);


    public final void send(@NotNull CommandSender receiver, @NotNull String message) {
        send(receiver, new ChannelMessage(message));
    }

    /**
     * Send a prefixed — from {@link Util#PREFIX} — channel message to a player or console.<br>
     * @param receiver Player/Console
     * @param message Message
     */
    public final void sendWithPrefix(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
        send(receiver, message.insertPrefix());
    }

    /**
     * Send a prefixed — from {@link Util#PREFIX} — channel message to a player or console.<br>
     * @param receiver Player/Console
     * @param message Message
     */
    public final void sendWithPrefix(@NotNull CommandSender receiver, @NotNull String message) {
        sendWithPrefix(receiver, new ChannelMessage(message));
    }

    /**
     * Send a message to all online players.
     * @param message Message
     * @param includeConsole whether send the message to console or not.
     */
    public final void sendAll(@NotNull ChannelMessage message, boolean includeConsole) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            send(player, message);
        }
        if (includeConsole) send(Bukkit.getConsoleSender(), message);
    }

    /**
     * Send a message to all online players.
     * @param message Message
     * @param includeConsole whether send the message to console or not.
     */
    public final void sendAll(@NotNull String message, boolean includeConsole) {
        sendAll(new ChannelMessage(message), includeConsole);
    }

    /**
     * Send a prefixed — from {@link Util#PREFIX} — message to all online players.
     * @param message Message
     * @param includeConsole whether send the message to console or not.
     */
    public final void sendAllWithPrefix(@NotNull ChannelMessage message, boolean includeConsole) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            sendWithPrefix(player, message);
        }
        if(includeConsole) sendWithPrefix(Bukkit.getConsoleSender(), message);
    }

    /**
     * Send a prefixed — from {@link Util#PREFIX} — message to all online players.
     * @param message Message
     * @param includeConsole whether send the message to console or not.
     */
    public final void sendAllWithPrefix(@NotNull String message, boolean includeConsole) {
        sendAllWithPrefix(new ChannelMessage(message), includeConsole);
    }
}
