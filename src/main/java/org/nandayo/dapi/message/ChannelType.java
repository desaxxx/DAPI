package org.nandayo.dapi.message;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.service.AdventureService;
import org.nandayo.dapi.util.Util;

@SuppressWarnings("unused")
public abstract class ChannelType {

    private ChannelType() {}

    public static final ChannelType CHAT = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            AdventureService.sendMessage(receiver, message);
        }
    };

    public static final ChannelType ACTION_BAR = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            AdventureService.sendActionBar((Player) receiver, message);
        }
    };

    public static final ChannelType TITLE = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelTitleMessage titleMessage = message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message);
            AdventureService.sendTitle((Player) receiver, titleMessage, this);
        }
    };

    public static final ChannelType SUBTITLE = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelTitleMessage titleMessage = message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message);
            AdventureService.sendTitle((Player) receiver, titleMessage, this);
        }
    };

    public static final ChannelType TITLE_AND_SUBTITLE = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelTitleMessage titleMessage = message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message);
            AdventureService.sendTitle((Player) receiver, titleMessage, this);
        }
    };

    public static final ChannelType BOSS_BAR = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelBossBarMessage bossBarMessage = message instanceof ChannelBossBarMessage ? (ChannelBossBarMessage) message : ChannelBossBarMessage.fromParent(message);
            AdventureService.showBossBar((Player) receiver, bossBarMessage);
        }
    };


    abstract public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message);


    public final void send(@NotNull CommandSender receiver, @NotNull String message) {
        send(receiver, new ChannelMessage(message));
    }

    /**
     * Send a prefixed — from {@link Util#PREFIX} — channel message to a player or console.<br>
     * @param receiver Player/Console
     * @param message Message
     */
    public final <T extends ChannelMessage> void sendWithPrefix(@NotNull CommandSender receiver, @NotNull T message) {
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
    public final <T extends ChannelMessage> void sendAll(@NotNull T message, boolean includeConsole) {
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
    public final <T extends ChannelMessage> void sendAllWithPrefix(@NotNull T message, boolean includeConsole) {
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
