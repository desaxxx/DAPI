package org.nandayo.DAPI.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.nandayo.DAPI.DAPI;
import org.nandayo.DAPI.HexUtil;

@SuppressWarnings("unused")
public abstract class SubCommand {

    abstract public boolean onSubCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args);

    /**
     * Sends the missing arguments message.
     * @param sender Command sender
     */
    public void sendMissingArgsMsg(@NotNull CommandSender sender, @NotNull String label, String[] args, String options) {
        String replacedMsg = DAPI.getInstance().getMissingArgsMsg()
                .replace("{command}", label)
                .replace("{current_args}", String.join(" ", args))
                .replace("{options}", options);
        sender.sendMessage(HexUtil.parse(replacedMsg));
    }
}
