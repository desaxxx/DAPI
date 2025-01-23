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
    }

    public HexUtil getHexUtil() {
        return new HexUtil();
    }

    public Util getUtil() {
        return new Util();
    }

    public ItemCreator getItemCreator(Material material) {
        return ItemCreator.of(material);
    }
}
