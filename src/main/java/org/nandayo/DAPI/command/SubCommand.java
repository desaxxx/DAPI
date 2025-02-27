package org.nandayo.DAPI.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.nandayo.DAPI.HexUtil;

@SuppressWarnings("unused")
public abstract class SubCommand {

    abstract public boolean onSubCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args);

    private @NotNull String missingArgsMsg = "";

    /**
     * Set missing args message for subcommand.
     * Then you can use {@link #sendMissingArgsMsg(CommandSender)} to send this message.
     * @param msg Message
     */
    public void setMissingArgsMsg(@NotNull String msg) {
        this.missingArgsMsg = msg;
    }

    /**
     * Sends the missing args message.
     * @param sender Command sender
     */
    public void sendMissingArgsMsg(@NotNull CommandSender sender) {
        sender.sendMessage(HexUtil.parse(this.missingArgsMsg));
    }
}
