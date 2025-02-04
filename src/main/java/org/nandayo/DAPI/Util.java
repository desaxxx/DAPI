package org.nandayo.DAPI;

import org.bukkit.Bukkit;

@SuppressWarnings("unused")
public class Util {

    public static void log(String msg) {
        Bukkit.getConsoleSender().sendMessage(HexUtil.color(msg));
    }

    public static void log(String... msgs) {
        for (String msg : msgs) {
            log(msg);
        }
    }
}
