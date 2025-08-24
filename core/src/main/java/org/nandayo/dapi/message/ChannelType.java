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
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            receiver.sendMessage(message.colorize(ColorizeType.LEGACY).getRawMessage());
        }
    };

    public static final ChannelType ACTION_BAR = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            //noinspection deprecation
            ((Player) receiver).spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message.colorize(ColorizeType.LEGACY).getRawMessage()));
        }
    };

    public static final ChannelType TITLE = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelTitleMessage titleMessage = message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message);
            ChannelTitleMessage ttMessage = titleMessage.colorize(ColorizeType.LEGACY);
            ((Player) receiver).sendTitle(ttMessage.getRawMessage(), "", ttMessage.getFadeInTicks(), ttMessage.getStayTicks(), ttMessage.getFadeOutTicks());
        }
    };

    public static final ChannelType SUBTITLE = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelTitleMessage titleMessage = message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message);
            ChannelTitleMessage ttMessage = titleMessage.colorize(ColorizeType.LEGACY);
            ((Player) receiver).sendTitle("", ttMessage.getRawSecondaryMessage(), ttMessage.getFadeInTicks(), ttMessage.getStayTicks(), ttMessage.getFadeOutTicks());
        }
    };

    public static final ChannelType TITLE_AND_SUBTITLE = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelTitleMessage titleMessage = message instanceof ChannelTitleMessage ? (ChannelTitleMessage) message : ChannelTitleMessage.fromParent(message);
            ChannelTitleMessage ttMessage = titleMessage.colorize(ColorizeType.LEGACY);
            ((Player) receiver).sendTitle(ttMessage.getRawMessage(), ttMessage.getRawSecondaryMessage(), ttMessage.getFadeInTicks(), ttMessage.getStayTicks(), ttMessage.getFadeOutTicks());
        }
    };

    public static final ChannelType BOSS_BAR = new ChannelType() {
        @Override
        public <T extends ChannelMessage> void send(@NotNull CommandSender receiver, @NotNull T message) {
            if(!(receiver instanceof Player)) return;
            ChannelBossBarMessage bossBarMessage = message instanceof ChannelBossBarMessage ? (ChannelBossBarMessage) message : ChannelBossBarMessage.fromParent(message);
            ChannelBossBarMessage bbMessage = bossBarMessage.colorize(ColorizeType.LEGACY);
            @SuppressWarnings("UnstableApiUsage")
            NamespacedKey key = new NamespacedKey("dapi","boss_bar_" + Util.generateRandomLowerCaseString(8));
            KeyedBossBar bb = Bukkit.createBossBar(key, bbMessage.getRawMessage(), bbMessage.getColor(), bbMessage.getStyle(), bbMessage.getFlags());
            bb.addPlayer((Player) receiver);

            // removal of BossBar
            Bukkit.getScheduler().runTaskLater(DAPI.getPlugin(), () -> {
                bb.removePlayer((Player) receiver);
                Bukkit.removeBossBar(key);
            }, bbMessage.getStayTicks());
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
