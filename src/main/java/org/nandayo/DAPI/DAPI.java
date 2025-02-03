package org.nandayo.DAPI;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public final class DAPI extends JavaPlugin {

    private static DAPI instance;
    public static DAPI getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private static final HexUtil HEX_UTIL = new HexUtil();
    private static final Util UTIL = new Util();

    public static HexUtil getHexUtil() {
        return HEX_UTIL;
    }

    public static Util getUtil() {
        return UTIL;
    }

    public static ItemCreator getItemCreator(Material material) {
        return ItemCreator.of(material);
    }
}
