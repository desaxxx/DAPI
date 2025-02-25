package org.nandayo.DAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.nandayo.DAPI.GUIManager.MenuListener;

@SuppressWarnings("unused")
public final class DAPI {

    public final Plugin plugin;
    private static DAPI instance;

    public final String GUI_METADATA_KEY = String.valueOf(1000000 + (int) (Math.random() * 9000000));

    public DAPI(Plugin plugin) {
        instance = this;
        this.plugin = plugin;
    }

    public static DAPI getInstance() {
        return instance;
    }

    public void registerMenuListener() {
        if(plugin == null) {
            Util.log("&cPlugin is not initialized! Try defining DAPI in your main class.");
            return;
        }
        Bukkit.getPluginManager().registerEvents(new MenuListener(), plugin);
    }
}
