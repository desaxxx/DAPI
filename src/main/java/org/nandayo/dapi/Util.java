package org.nandayo.dapi;

import org.bukkit.Bukkit;

import java.util.Random;

@SuppressWarnings("unused")
public class Util {

    static public String PREFIX = "";

    static public void log(String... msg) {
        for(String s : msg) {
            Bukkit.getConsoleSender().sendMessage(HexUtil.parse(PREFIX + s));
        }
    }

    static public String generateRandomLowerCaseString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    static public String generateRandomUpperCaseString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    static public String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
