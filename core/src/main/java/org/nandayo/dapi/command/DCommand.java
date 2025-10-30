package org.nandayo.dapi.command;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.util.DAPIException;

import java.util.List;

/**
 * @since 1.4.2
 */
@ApiStatus.Experimental
public interface DCommand extends DSubCommand, CommandExecutor, TabCompleter {

    @Override
    default @NotNull DCommand command() {
        return this;
    }

    default void register() {
        PluginCommand pluginCommand = Bukkit.getPluginCommand(name());
        if(pluginCommand == null) {
            throw new DAPIException("Command '" + name() + "' was not found in plugin.yml!");
        }
        pluginCommand.setExecutor(this);
        pluginCommand.setTabCompleter(this);
    }


    /**
     * @since 1.5.1
     */
    @Override
    default boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!canExecute(commandSender)) {
            return true;
        }

        execute(commandSender, args);
        return true;
    }

    /**
     * @since 1.5.1
     */
    @Override
    default @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        return tabComplete(commandSender, args);
    }
}
