package org.nandayo.dapi.command;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.util.Util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @since 1.4.2
 */
public interface DSubCommand {

    @NotNull String name();
    @NotNull Set<String> aliases();
    default @NotNull String permission() {
        return "";
    }

    @NotNull DCommand command();
    @NotNull Set<DSubCommand> subCommands();


    //
    void execute(@NotNull CommandSender commandSender, @NotNull String[] args);

    /**
     * @since 1.5.1
     */
    default boolean canExecute(@NotNull CommandSender commandSender) {
        if(!permission().isEmpty() && !commandSender.hasPermission(permission())) {
            Util.tell(commandSender, "&cYou don't have permission to execute this command.");
            return false;
        }
        return true;
    }

    @Nullable
    default List<String> tabComplete(@NotNull CommandSender commandSender, @NotNull String[] args) {
        int argNum = args.length;
        Set<DSubCommand> subCommands = CommandHelper.getSubCommandsAtDepth(this.command(), argNum);

        return subCommands.stream()
                .flatMap(subCommand -> Stream.concat(
                        Stream.of(subCommand.name()),
                        this.ignoreAliasesOnTabComplete() ? Stream.empty() : subCommand.aliases().stream()
                ))
                .collect(Collectors.toList());
    }
    default boolean ignoreAliasesOnTabComplete() {
        return false;
    }

    default void callSubCommand(@NotNull CommandSender commandSender, @NotNull String[] args, @NotNull String subCommandNameOrAlias) {
        subCommand(subCommandNameOrAlias).ifPresent(sc -> {
            if(!sc.canExecute(commandSender)) {
                return;
            }

            sc.execute(commandSender, args);
        });
    }

    @NotNull
    default Optional<DSubCommand> subCommand(@NotNull String nameOrAlias) {
        return subCommands().stream()
                .filter(s -> s.name().equalsIgnoreCase(nameOrAlias) || s.aliases().contains(nameOrAlias))
                .findFirst();
    }

//    @NotNull
//    default Node node(@Nullable Node parent, @NotNull Node @NotNull... children) {
//        return Node.builder(parent).children(children);
//    }




    //============
    // Deprecation

    @Deprecated(since = "1.5.1", forRemoval = true)
    default void executeIf(@NotNull CommandSender commandSender, @NotNull String[] args, boolean condition) {}

    @Deprecated(since = "1.5.1", forRemoval = true)
    default void executeCheckPermission(@NotNull CommandSender commandSender, @NotNull String[] args) {}
}
