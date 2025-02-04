package org.nandayo.DAPI;

@SuppressWarnings("unused")
public class Util {


    public static void log(String msg) {
        DAPI.getInstance().plugin.getServer().getConsoleSender().sendMessage(HexUtil.color(msg));
    }

    public static void log(String... msgs) {
        for (String msg : msgs) {
            log(msg);
        }
    }
}
