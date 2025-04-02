package org.nandayo.dapi.command;

import org.bukkit.command.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.Util;

import java.util.List;

@ApiStatus.Experimental
@SuppressWarnings("unused")
public abstract class BaseCommand implements CommandExecutor, TabCompleter {

    abstract @NotNull String command();
    abstract @NotNull String description();
    abstract boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args);
    abstract @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull String[] args);

    public void register(@NotNull JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand(command());
        if (command == null) {
            Util.log("Command '/" + command() + "' was not found.");
            return;
        }
        command.setExecutor(this);
        command.setTabCompleter(this);
    }

    @Override
    public final boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return onCommand(commandSender, strings);
    }

    @Override
    public final @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return onTabComplete(commandSender, strings);
    }
}
