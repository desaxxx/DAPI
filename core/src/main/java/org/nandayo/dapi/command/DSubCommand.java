package org.nandayo.dapi.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * @since 1.4.2
 */
@ApiStatus.Experimental
public interface DSubCommand extends CommandExecutor, TabCompleter {

    @NotNull String name();
    @NotNull Set<String> aliases();
    default @NotNull String permission() {
        return "";
    }

    @NotNull DCommand command();
    @NotNull Set<DSubCommand> subCommands();


    //
    void execute(@NotNull CommandSender commandSender, @NotNull String[] args);

    default void executeIf(@NotNull CommandSender commandSender, @NotNull String[] args, boolean condition) {
        if(!condition) return;
        execute(commandSender, args);
    }
    default void executeCheckPermission(@NotNull CommandSender commandSender, @NotNull String[] args) {
        executeIf(commandSender, args, commandSender.hasPermission(permission()));
    }

    @Nullable
    default List<String> tabComplete(@NotNull CommandSender commandSender, @NotNull String[] args) {
        int argNum = args.length;
        List<String> cumulativeSubCommandNames = new ArrayList<>();

        for(DSubCommand subCommand : CommandHelper.cumulativeSubCommands(command(), 0, argNum)) {
            cumulativeSubCommandNames.add(subCommand.name());
            if(ignoreAliasesOnTabComplete()) continue;
            cumulativeSubCommandNames.addAll(subCommand.aliases());
        }

        return cumulativeSubCommandNames;
    }
    default boolean ignoreAliasesOnTabComplete() {
        return false;
    }

    default void callSubCommand(@NotNull CommandSender commandSender, @NotNull String[] args, @NotNull String subCommandNameOrAlias) {
        subCommand(subCommandNameOrAlias).ifPresent(sc -> sc.executeCheckPermission(commandSender, args));
    }

    @NotNull
    default Optional<DSubCommand> subCommand(@NotNull String nameOrAlias) {
        return subCommands().stream()
                .filter(s -> s.name().equalsIgnoreCase(nameOrAlias) || s.aliases().contains(nameOrAlias))
                .findFirst();
    }



    @Override
    default boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        execute(commandSender, args);
        return true;
    }
    @Override
    default @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        return tabComplete(commandSender, args);
    }
}
