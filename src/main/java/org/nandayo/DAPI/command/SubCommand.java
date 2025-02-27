package org.nandayo.DAPI.command;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.nandayo.DAPI.HexUtil;

@SuppressWarnings("unused")
public abstract class SubCommand {

    abstract public boolean onSubCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args);

    /**
     * Set missing arguments message for > ALL < subcommands.
     * Then you can use {@link #sendMissingArgsMsg(CommandSender, String, String[], String)} within
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
    public static @NotNull String missingArgsMsg = "";

    /**
     * Sends the missing arguments message.
     * @param sender Command sender
     */
    public void sendMissingArgsMsg(@NotNull CommandSender sender, @NotNull String label, String[] args, String options) {
        String replacedMsg = missingArgsMsg
                .replace("{label}", label)
                .replace("{current_args}", String.join(" ", args))
                .replace("{options}", options);
        sender.sendMessage(HexUtil.parse(replacedMsg));
    }
}
