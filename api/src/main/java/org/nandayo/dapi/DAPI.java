package org.nandayo.dapi;

import lombok.Getter;
import lombok.Setter;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.guimanager.MenuListener;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@SuppressWarnings("unused")
public final class DAPI {

    private DAPI() {
        // no construction
    }


    static private boolean init = false;
    static private void init() {
        if(init) return;
        init = true;
        final String defaultPackage = new String(new byte[] { 'o','r','g','.','n','a','n','d','a','y','o','.','d','a','p','i'});
        if(DAPI.class.getPackage().getName().equals(defaultPackage)) {
            Util.log("DAPI was not relocated. It is recommended to relocate it to avoid potential conflicts with other plugins that also include DAPI.");
        }
        registerMetrics();
    }


    static public final String VERSION = "1.2.6";
    static public final String GUI_METADATA_KEY = "DAPI_GUI_" + Util.generateRandomLowerCaseString(8);


    static public void registerMenuListener() {
        Bukkit.getPluginManager().registerEvents(new MenuListener(), getPlugin());
    }


    static private Plugin plugin;

    @NotNull
    static public Plugin getPlugin() {
        if(plugin != null) return plugin;
        String pluginName = forcePluginName();
        Plugin foundPlugin = Bukkit.getPluginManager().getPlugin(pluginName);
        if(foundPlugin == null) throw new DAPIException("Plugin not found with name '" + pluginName + "'!");
        plugin = foundPlugin;
        init();
        return plugin;
    }

    @NotNull
    static private String forcePluginName() {
        String pluginName = findPluginName();
        if(pluginName != null) return pluginName;
        throw new DAPIException("Plugin name not found! To developer who uses DAPI, please check your plugin file (either 'plugin.yml' or 'paper-plugin.yml') and ensure it has 'name' key there.");
    }

    @Nullable
    static private String findPluginName() {
        ClassLoader loader = DAPI.class.getClassLoader();
        for(String pluginFile : List.of("plugin.yml","paper-plugin.yml")) {
            try {
                InputStream stream = loader.getResourceAsStream(pluginFile);
                if(stream == null) continue;

                InputStreamReader reader = new InputStreamReader(stream);
                YamlConfiguration config = YamlConfiguration.loadConfiguration(reader);
                return config.getString("name");
            } catch (Exception ignored) {}
        }
        return null;
    }


    static private boolean metricsRegistered = false;
    static private void registerMetrics() {
        if(metricsRegistered) return;
        metricsRegistered = true;
        try {
            Metrics metrics = new Metrics(plugin, 24974);
            metrics.addCustomChart(new SimplePie("dapi_version", () -> VERSION));
            Util.log("[DAPI] Registered bStats metrics for DAPI using plugin '" + plugin.getName() + "'.");
        } catch (Exception e) {
            Util.log("[DAPI] Failed to register bStats metrics for DAPI using plugin '" + plugin.getName() + "'. Skipping it.");
        }
    }


    static private Boolean paper;
    static public boolean isPaper() {
        if(paper != null) return paper;
        try {
            Class.forName("com.destroystokyo.paper.PaperConfig");
            paper = true;
        } catch (Exception ignored) {
            paper = false;
        }
        return paper;
    }



    /**
     * Set missing arguments message for > ALL < subcommands.
     * Then you can use {@link org.nandayo.dapi.command.SubCommand#sendMissingArgsMsg(CommandSender, String, String[], String)} within
     * subcommands to send this message.
     * <blockquote><pre>
     *     Placeholders:
     *       {command}      - Command name
     *       {current_args} - Current args entered
     *       {options}      - Options for the missing args
     *
     *     Example missing arguments message: "&cUsage: /{label} {current_args} {options}"
     * </pre></blockquote>
     */
    @Getter
    @Setter
    @Deprecated(since = "1.2.5", forRemoval = true)
    static public @NotNull String missingArgsMsg = "";
}
