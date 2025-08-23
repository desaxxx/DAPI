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
import org.nandayo.dapi.service.RelocateService;
import org.nandayo.dapi.util.DAPIException;
import org.nandayo.dapi.util.Util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@SuppressWarnings("unused")
public final class DAPI {

    private DAPI() {
        // no construction
    }

    public static final String VERSION = "1.3.3";
    public static final String GUI_METADATA_KEY = "DAPI_GUI_" + Util.generateRandomLowerCaseString(8);


    private static boolean init = false;
    private static void init() {
        if(init) return;
        init = true;
        if(!RelocateService.isDAPIRelocated()) {
            Util.logInternal("DAPI was not relocated. It is recommended to relocate it to avoid potential conflicts with other plugins that also include DAPI.");
        }
        if(RelocateService.isbStatsRelocated()) {
            registerMetrics();
        }
    }


    public static void registerMenuListener() {
        Bukkit.getPluginManager().registerEvents(new MenuListener(), getPlugin());
    }


    private static Plugin plugin;
    @NotNull
    public static Plugin getPlugin() {
        if(plugin != null) return plugin;
        String pluginName = forcePluginName();
        Plugin foundPlugin = Bukkit.getPluginManager().getPlugin(pluginName);
        if(foundPlugin == null) throw new DAPIException("Plugin not found with name '" + pluginName + "'!");
        plugin = foundPlugin;
        init();
        return plugin;
    }

    @NotNull
    private static String forcePluginName() {
        String pluginName = findPluginName();
        if(pluginName != null) return pluginName;
        throw new DAPIException("Plugin name not found! To developer who uses DAPI, please check your plugin file (either 'plugin.yml' or 'paper-plugin.yml') and ensure it has 'name' key there.");
    }

    @Nullable
    private static String findPluginName() {
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


    private static boolean metricsRegistered = false;
    private static void registerMetrics() {
        if(metricsRegistered) return;
        metricsRegistered = true;
        try {
            Metrics metrics = new Metrics(plugin, 24974);
            metrics.addCustomChart(new SimplePie("dapi_version", () -> VERSION));
            Util.logInternal("Registered bStats metrics for DAPI using plugin '" + plugin.getName() + "'.");
        } catch (Exception e) {
            Util.logInternal("Failed to register bStats metrics for DAPI using plugin '" + plugin.getName() + "'. " + e);
        }
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
    public static @NotNull String missingArgsMsg = "";
}
