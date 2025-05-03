package org.nandayo.dapi.command;

import org.bukkit.command.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.Util;

import java.util.List;

@SuppressWarnings("unused")
public abstract class BaseCommand implements CommandExecutor, TabCompleter {

    public <T extends JavaPlugin> BaseCommand(T plugin) {
        register(plugin);
    }

    abstract public @NotNull String command();
    abstract public @NotNull String description();
    abstract public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args);
    abstract public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull String[] args);

    public <T extends JavaPlugin> void register(@NotNull T plugin) {
        PluginCommand command = plugin.getCommand(command());
        if (command == null) {
            Util.log("DAPI: Command '/" + command() + "' was not found.");
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
