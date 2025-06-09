package org.nandayo.dapi.message;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.HexUtil;
import org.nandayo.dapi.Util;

@SuppressWarnings("unused")
public abstract class ChannelType {

    static public final ChannelType CHAT = new ChannelType() {
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            receiver.sendMessage(HexUtil.parse(message.getPrimaryMessage()));
        }

        @Override
        public void send(@NotNull CommandSender receiver, @NotNull String message) {
            send(receiver, ChannelMessage.Builder.of(message).build());
        }
    };

    static public final ChannelType ACTION_BAR = new ChannelType() {
        @SuppressWarnings("deprecation")
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            if(!(receiver instanceof Player)) return;
            ((Player) receiver).spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(HexUtil.parse(message.getPrimaryMessage())));
        }

        @Override
        public void send(@NotNull CommandSender receiver, @NotNull String message) {
            send(receiver, ChannelMessage.Builder.of(message).build());
        }
    };

    static public final ChannelType TITLE = new ChannelType() {
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            if(!(receiver instanceof Player)) return;
            ((Player) receiver).sendTitle(HexUtil.parse(message.getPrimaryMessage()), "", message.getFadeInTicks(), message.getStayTicks(), message.getFadeOutTicks());
        }

        @Override
        public void send(@NotNull CommandSender receiver, @NotNull String message) {
            send(receiver, ChannelMessage.Builder.of(message).build());
        }
    };

    static public final ChannelType SUBTITLE = new ChannelType() {
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            if(!(receiver instanceof Player)) return;
            ((Player) receiver).sendTitle(HexUtil.parse(message.getPrimaryMessage()), "", message.getFadeInTicks(), message.getStayTicks(), message.getFadeOutTicks());
        }

        @Override
        public void send(@NotNull CommandSender receiver, @NotNull String message) {
            send(receiver, ChannelMessage.Builder.of(message).build());
        }
    };

    static public final ChannelType TITLE_AND_SUBTITLE = new ChannelType() {
        @Override
        public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
            if(!(receiver instanceof Player)) return;
            ((Player) receiver).sendTitle(HexUtil.parse(message.getPrimaryMessage()), HexUtil.parse(message.getSecondaryMessage()), message.getFadeInTicks(), message.getStayTicks(), message.getFadeOutTicks());
        }

        @Override
        public void send(@NotNull CommandSender receiver, @NotNull String message) {
            send(receiver, ChannelMessage.Builder.of(message).build());
        }
    };


    abstract public void send(@NotNull CommandSender receiver, @NotNull ChannelMessage message);
    abstract public void send(@NotNull CommandSender receiver, @NotNull String message);

    /**
     * Send a prefixed — from {@link Util#PREFIX} — channel message to a player or console.<br>
     * Use {@link org.nandayo.dapi.message.ChannelMessage.Builder} to build channel messages.
     * @param receiver Player/Console
     * @param message Message
     */
    public void sendWithPrefix(@NotNull CommandSender receiver, @NotNull ChannelMessage message) {
        send(receiver, message);
    }

    /**
     * Send a prefixed — from {@link Util#PREFIX} — channel message to a player or console.<br>
     * @param receiver Player/Console
     * @param message Message
     */
    public void sendWithPrefix(@NotNull CommandSender receiver, @NotNull String message) {
        sendWithPrefix(receiver, ChannelMessage.Builder.of(message).build());
    }

    /**
     * Send a message to all online players.
     * Use {@link org.nandayo.dapi.message.ChannelMessage.Builder} to build channel messages.
     * @param message Message
     * @param includeConsole whether send the message to console or not.
     */
    public void sendAll(@NotNull ChannelMessage message, boolean includeConsole) {
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
    public void sendAll(@NotNull String message, boolean includeConsole) {
        sendAll(ChannelMessage.Builder.of(message).build(), includeConsole);
    }

    /**
     * Send a prefixed — from {@link Util#PREFIX} — message to all online players.
     * Use {@link org.nandayo.dapi.message.ChannelMessage.Builder} to build channel messages.
     * @param message Message
     * @param includeConsole whether send the message to console or not.
     */
    public void sendAllWithPrefix(@NotNull ChannelMessage message, boolean includeConsole) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            sendWithPrefix(player, message);
        }
        if(includeConsole) send(Bukkit.getConsoleSender(), message);
    }

    /**
     * Send a prefixed — from {@link Util#PREFIX} — message to all online players.
     * @param message Message
     * @param includeConsole whether send the message to console or not.
     */
    public void sendAllWithPrefix(@NotNull String message, boolean includeConsole) {
        sendAllWithPrefix(ChannelMessage.Builder.of(message).build(), includeConsole);
    }
}
