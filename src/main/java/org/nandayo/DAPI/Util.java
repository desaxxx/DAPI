package org.nandayo.DAPI;

import org.bukkit.Bukkit;

@SuppressWarnings("unused")
public class Util {

    public static String PREFIX = "";

    public static void log(String... msg) {
        for(String s : msg) {
            Bukkit.getConsoleSender().sendMessage(HexUtil.parse(PREFIX + s));
        }
    }
}
