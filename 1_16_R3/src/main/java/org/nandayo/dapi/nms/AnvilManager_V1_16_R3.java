package org.nandayo.dapi.nms;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.craftbukkit.v1_16_R3.block.CraftBlock;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class AnvilManager_V1_16_R3 extends AnvilWrapper {

    private EntityPlayer handle(@NotNull Player p) {
        return ((CraftPlayer) p).getHandle();
    }

    @Override
    public <I extends InventoryView> I openInventory(@NotNull Player p, @NotNull String title) {
        /* Create new MenuAnvil */
        MenuAnvil menu = (MenuAnvil) createMenuAnvil(p, title);
        return openInventory(p, menu);
    }

    @Override
    public <I extends InventoryView> I openInventory(@NotNull Player p, @NotNull MenuAnvilWrapper menuWrapper) {
        EntityPlayer player = handle(p);
        player.closeInventory(); /* Close the open menu. */

        MenuAnvil menu = (MenuAnvil) menuWrapper;

        /* Open the MenuAnvil to the player */
        openMenu(p, menu, menu.getTitle().getString());

        //noinspection unchecked
        return (I) menu.getBukkitView();
    }

    @Override
    public MenuAnvilWrapper createMenuAnvil(@NotNull Player p, @Nullable String title) {
        EntityPlayer player = handle(p);
        return new MenuAnvil(
                player.nextContainerCounter(),
                player.inventory,
                ContainerAccess.at(player.world, ((CraftBlock) p.getLocation().getBlock()).getPosition()),
                title
        );
    }

    @Override
    void openMenu(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title) {
        EntityPlayer player = handle(p);
        player.activeContainer = (MenuAnvil) menu;
        sendOpenScreenPacket(p, menu, title);
        player.syncInventory(); /* SlotListener */
    }

    @Override
    void sendOpenScreenPacket(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title) {
        EntityPlayer player = handle(p);
        MenuAnvil menuAnvil = (MenuAnvil) menu;
        player.playerConnection.sendPacket(new PacketPlayOutOpenWindow(
                menuAnvil.windowId,
                Containers.ANVIL,
                title == null ? null : new ChatComponentText(title)
        ));
    }


    static private class MenuAnvil extends ContainerAnvil implements MenuAnvilWrapper {


        public MenuAnvil(int containerId, PlayerInventory playerinventory, ContainerAccess containeraccess, @Nullable String title) {
            super(containerId, playerinventory, containeraccess);
            checkReachable = false;
            if(title != null) setTitle(new ChatComponentText(title));
        }

        @Override
        public void e() { /* createResult() */
            Slot resultSlot = getSlot(2);
            ItemStack result = resultSlot.getItem();
            if(result.isEmpty()) {
                resultSlot.set(getSlot(0).getItem().cloneItemStack());
            }
            levelCost.set(0);
            c(); /* broadcastChanges() */
        }
    }
}
