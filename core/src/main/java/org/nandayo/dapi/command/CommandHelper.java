package org.nandayo.dapi.command;

import java.util.HashSet;
import java.util.Set;

class CommandHelper {

    public static Set<DSubCommand> cumulativeSubCommands(DSubCommand root, int current, int aimed) {
        Set<DSubCommand> subCommands = new HashSet<>();
        if(current > aimed) return subCommands;
        if(current == aimed) {
            subCommands.add(root);
            return subCommands;
        }

        for(DSubCommand subCommand : root.subCommands()) {
            subCommands.addAll(cumulativeSubCommands(subCommand, current+1, aimed));
        }

        return subCommands;
    }
}
