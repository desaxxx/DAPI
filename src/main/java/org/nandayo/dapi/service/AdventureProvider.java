package org.nandayo.dapi.service;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.Validate;

/**
 * This class provides Adventure objects. Use with <b>caution</b>.
 * @see AdventureService#isAdventureSupported()
 * @since 1.3.4
 */
public class AdventureProvider {

    /**
     * Get MiniMessage instance.<br>
     * <b>NOTE:</b> Check if MiniMessage is supported before using this via {@link AdventureService#isMiniMessageSupported()}.
     * @return MiniMessage
     * @since 1.3.0-BETA
     */
    public static MiniMessage getMiniMessage() {
        return MiniMessage.miniMessage();
    }


    public static ComponentProvider createComponentProvider(String miniMessage) {
        return new ComponentProvider(miniMessage);
    }

    public static class ComponentProvider {

        private final String miniMessage;
        public ComponentProvider(String miniMessage) {
            Validate.notNull(miniMessage, "MiniMessage string cannot be null.");
            this.miniMessage = miniMessage;
        }

        @NotNull
        public Component get() {
            return getMiniMessage().deserialize(miniMessage);
        }
    }
}
