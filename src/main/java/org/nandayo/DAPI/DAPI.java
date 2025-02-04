package org.nandayo.DAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.nandayo.DAPI.GUIManager.MenuListener;

@SuppressWarnings("unused")
public final class DAPI {

    private static DAPI instance;
    public static DAPI getInstance() {
        return instance;
    }

    public final Plugin plugin;

    public DAPI(Plugin plugin) {
        instance = this;
        this.plugin = plugin;
    }

    public String GUI_METADATA_KEY = String.valueOf(1000000 + (int) (Math.random() * 9000000));

    public void registerEvents() {
        if(plugin == null) {
            Util.log("&cPlugin is not initialized!");
            return;
        }
        Bukkit.getPluginManager().registerEvents(new MenuListener(), plugin);
    }
}
