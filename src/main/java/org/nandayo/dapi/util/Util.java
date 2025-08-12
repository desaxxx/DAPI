package org.nandayo.dapi.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

@SuppressWarnings("unused")
public class Util {

    public static String PREFIX = "";
    public static String DAPI_PREFIX = "[DAPI] ";

    /**
     * Log messages to console with prefix {@link Util#PREFIX}.
     * @param msg Messages
     */
    public static void log(String... msg) {
        for(String s : msg) {
            Bukkit.getConsoleSender().sendMessage(HexUtil.parse(PREFIX + s));
        }
    }

    /**
     * Log messages to console with dapi prefix. For internal use.
     * @param msg Messages
     */
    @ApiStatus.Internal
    public static void logInternal(String... msg) {
        for(String s : msg) {
            Bukkit.getConsoleSender().sendMessage(HexUtil.parse(PREFIX + DAPI_PREFIX + s));
        }
    }

    /**
     * Send a message to console or a player.
     * @param receiver Message receiver
     * @param messages Messages
     */
    public static void tell(@NotNull CommandSender receiver, @NotNull String... messages) {
        for(String m : messages) {
            receiver.sendMessage(HexUtil.parse(Util.PREFIX + m));
        }
    }

    /**
     * Generates random lowercase string.
     * @param length Length of the desired string
     * @return String
     */
    public static String generateRandomLowerCaseString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    /**
     * Generates random uppercase string.
     * @param length Length of the desired string
     * @return String
     */
    public static String generateRandomUpperCaseString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    /**
     * Generates random string.
     * @param length Length of the desired string
     * @return String
     */
    public static String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static int parseInt(String str, int def) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return def;
        }
    }
}
