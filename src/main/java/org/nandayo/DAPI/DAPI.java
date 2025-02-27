package org.nandayo.DAPI;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.nandayo.DAPI.guimanager.MenuListener;

@SuppressWarnings("unused")
public final class DAPI {

    public final Plugin plugin;
    @Getter
    private static DAPI instance;

    public final String GUI_METADATA_KEY = String.valueOf(1000000 + (int) (Math.random() * 9000000));

    public DAPI(Plugin plugin) {
        instance = this;
        this.plugin = plugin;
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
     * Then you can use {@link org.nandayo.DAPI.command.SubCommand#sendMissingArgsMsg(CommandSender, String, String[], String)} within
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
