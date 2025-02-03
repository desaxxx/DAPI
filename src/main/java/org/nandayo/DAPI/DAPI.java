package org.nandayo.DAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.nandayo.DAPI.GUIManager.MenuListener;

public final class DAPI extends JavaPlugin {

    private static DAPI instance;
    public static DAPI getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public String GUI_METADATA_KEY = String.valueOf(1000000 + (int) (Math.random() * 9000000));
}
