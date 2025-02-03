package org.nandayo.DAPI;

import org.bukkit.Bukkit;

import static org.nandayo.DAPI.HexUtil.color;

@SuppressWarnings("unused")
public class Util {

    /*
     * General Util
     */
    private final static String PREFIX = "<#857c67>[<#ffd16d>DMentions<#857c67>]&r ";

    public static void log(String msg) {
        Bukkit.getConsoleSender().sendMessage(color(PREFIX + msg));
    }
}
