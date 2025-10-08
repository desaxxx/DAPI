package org.nandayo.dapi.command;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.DAPIException;

/**
 * @since 1.4.2
 */
@ApiStatus.Experimental
public interface DCommand extends DSubCommand {

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
}
