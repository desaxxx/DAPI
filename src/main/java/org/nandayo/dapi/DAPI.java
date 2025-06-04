package org.nandayo.dapi;

import lombok.Getter;
import lombok.Setter;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.guimanager.MenuListener;

@SuppressWarnings("unused")
public final class DAPI {

    public Plugin plugin;
    @Getter
    private final Wrapper wrapper;
    private final String version = "1.2";
    public final String GUI_METADATA_KEY = "DAPI_GUI_" + Util.generateRandomLowerCaseString(8);

    @Getter
    private static DAPI instance;
    public DAPI(@NotNull Plugin plugin) {
        instance = this;
        this.plugin = plugin;
        this.wrapper = new Wrapper();
        Metrics metrics = new Metrics(plugin, 24974);
        metrics.addCustomChart(new SimplePie("dapi_version", () -> version));

    }


    public void registerMenuListener() {
        if(plugin == null) {
            Util.log("&cPlugin is not initialized! Try defining DAPI in your main class.");
            return;
        }
        Bukkit.getPluginManager().registerEvents(new MenuListener(), plugin);
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
    public @NotNull String missingArgsMsg = "";
}
