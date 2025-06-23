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
import org.nandayo.dapi.HexUtil;
import org.nandayo.dapi.Util;

@SuppressWarnings("unused")
public abstract class ChannelType {

    private ChannelType() {}

    static public final ChannelType CHAT = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            receiver.sendMessage(HexUtil.parse(message.getMessage()));
        }
    };

    static public final ChannelType ACTION_BAR = new ChannelType() {
        @SuppressWarnings("deprecation")
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ((Player) receiver).spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(HexUtil.parse(message.getMessage())));
        }
    };

    static public final ChannelType TITLE = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelTitleMessage titleMessage = message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message);
            ((Player) receiver).sendTitle(HexUtil.parse(message.getMessage()), "", titleMessage.getFadeInTicks(), titleMessage.getStayTicks(), titleMessage.getFadeOutTicks());
        }
    };

    static public final ChannelType SUBTITLE = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelTitleMessage titleMessage = message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message);
            ((Player) receiver).sendTitle(HexUtil.parse(message.getMessage()), "", titleMessage.getFadeInTicks(), titleMessage.getStayTicks(), titleMessage.getFadeOutTicks());
        }
    };

    static public final ChannelType TITLE_AND_SUBTITLE = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelTitleMessage titleMessage = message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message);
            ((Player) receiver).sendTitle(HexUtil.parse(message.getMessage()), HexUtil.parse(titleMessage.getSecondaryMessage()), titleMessage.getFadeInTicks(), titleMessage.getStayTicks(), titleMessage.getFadeOutTicks());
        }
    };

    static public final ChannelType BOSS_BAR = new ChannelType() {
        @SuppressWarnings("UnstableApiUsage")
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelBossBarMessage bossBarMessage = message instanceof ChannelBossBarMessage ? (ChannelBossBarMessage) message : ChannelBossBarMessage.fromParent(message);
            Player player = (Player) receiver;

            KeyedBossBar bossBar = Bukkit.createBossBar(new NamespacedKey("dapi","bossbar_message_" + player.getUniqueId()), HexUtil.parse(message.getMessage()), bossBarMessage.getColor(), bossBarMessage.getStyle(), bossBarMessage.getFlags());
            bossBar.addPlayer(player);

            // removal
            Bukkit.getScheduler().runTaskLater(DAPI.getPlugin(), () -> {
                bossBar.removePlayer(((Player) receiver));
                Bukkit.removeBossBar(bossBar.getKey());
            }, bossBarMessage.getStayTicks());
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
    @SuppressWarnings("unchecked")
    public final <T extends ChannelMessage> void sendWithPrefix(@NotNull CommandSender receiver, @NotNull T message) {
        T prefixedMessage = (T) message.clone();
        prefixedMessage.insertPrefix();
        send(receiver, prefixedMessage);
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
