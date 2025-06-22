package org.nandayo.dapi.nms;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AnvilWrapper {

    /**
     * Open an anvil menu to the player.
     * @param p BukkitPlayer
     * @param title Title of the menu
     */
    abstract public <I extends InventoryView> I openInventory(@NotNull Player p, @NotNull String title);

    /**
     * Create a MenuAnvilWrapper.
     * @param p BukkitPlayer
     * @param title Title of the menu
     * @return new MenuAnvilWrapper
     */
    abstract MenuAnvilWrapper createMenuAnvil(@NotNull Player p, @Nullable String title);

    /**
     * Copy of necessary part of method ServerPlayer#openMenu(MenuProvider).
     * @param p BukkitPlayer
     * @param menu MenuAnvilWrapper to open to the player
     * @param title Title of the menu
     */
    abstract void openMenu(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title);

    /**
     * send OpenScreenPacket to the player
     * @param p BukkitPlayer
     * @param menu MenuAnvilWrapper to open to the player
     * @param title Title of the menu
     */
    abstract void sendOpenScreenPacket(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title);


    interface MenuAnvilWrapper {

    }
}
