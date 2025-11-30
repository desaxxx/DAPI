package org.nandayo.dapi.command;

import java.util.HashSet;
import java.util.Set;

/**
 * @since 1.4.2
 */
class CommandHelper {

    /**
     * @since 1.5.1
     */
    public static Set<DSubCommand> getSubCommandsAtDepth(DCommand root, int targetDepth) {
        Set<DSubCommand> collector = new HashSet<>();
        findSubCommandsAtDepth(root, 0, targetDepth, collector);
        return collector;
    }

    /**
     * @since 1.5.1
     */
    private static void findSubCommandsAtDepth(DSubCommand root, int currentDepth, int targetDepth, Set<DSubCommand> collector) {
        if (currentDepth == targetDepth) {
            collector.add(root);
            return;
        }
        if (currentDepth > targetDepth) {
            return;
        }
        for (DSubCommand subCommand : root.subCommands()) {
            findSubCommandsAtDepth(subCommand, currentDepth + 1, targetDepth, collector);
        }
    }
}
