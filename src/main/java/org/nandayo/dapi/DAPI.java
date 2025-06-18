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
import org.nandayo.dapi.guimanager.MenuListener;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@SuppressWarnings("unused")
public final class DAPI {

    private DAPI() {
        // no construction
    }

    static public final String VERSION = "1.2.5";
    static public final String GUI_METADATA_KEY = "DAPI_GUI_" + Util.generateRandomLowerCaseString(8);


    static public void registerMenuListener() {
        Bukkit.getPluginManager().registerEvents(new MenuListener(), getPlugin());
    }



    static private Plugin plugin;

    @NotNull
    static public Plugin getPlugin() {
        if(plugin != null) return plugin;
        String pluginName = findPluginName();
        Plugin foundPlugin = Bukkit.getPluginManager().getPlugin(pluginName);
        if(foundPlugin == null) throw new DAPIException("Plugin not found with name '" + pluginName + "'!");
        plugin = foundPlugin;
        registerMetrics();
        return plugin;
    }

    @NotNull
    static private String findPluginName() {
        ClassLoader loader = DAPI.class.getClassLoader();
        for(String pluginFile : List.of("paper-plugin.yml", "plugin.yml")) {
            try {
                InputStream stream = loader.getResourceAsStream(pluginFile);
                if (stream != null) {
                    InputStreamReader reader = new InputStreamReader(stream);
                    YamlConfiguration config = YamlConfiguration.loadConfiguration(reader);
                    String pluginName = config.getString("plugin.name");
                    if (pluginName == null) throw new DAPIException("Plugin name not found!");
                    return pluginName;
                }
            } catch (Exception ignored) {}
        }
        throw new DAPIException("Plugin file (either 'plugin.yml' or 'paper-plugin.yml') not found!");
    }


    static private boolean metricsRegistered = false;

    static private void registerMetrics() {
        if(metricsRegistered) return;
        metricsRegistered = true;
        Util.log("[DAPI] Registering metrics for DAPI using plugin '" + plugin.getName() + "'.");
        Metrics metrics = new Metrics(plugin, 24974);
        metrics.addCustomChart(new SimplePie("dapi_version", () -> VERSION));
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
