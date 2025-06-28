package org.nandayo.dapi.nms;

import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutOpenWindow;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.player.PlayerInventory;
import net.minecraft.world.inventory.ContainerAccess;
import net.minecraft.world.inventory.ContainerAnvil;
import net.minecraft.world.inventory.Containers;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.block.CraftBlock;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class AnvilManager_V1_17_1_R1 extends AnvilWrapper {

    private EntityPlayer handle(@NotNull Player p) {
        return ((CraftPlayer) p).getHandle();
    }

    @Override
    public <I extends InventoryView> I openInventory(@NotNull Player p, @NotNull String title) {
        EntityPlayer player = handle(p);
        player.closeInventory(); /* closeContainer(). */

        /* Create new MenuAnvil */
        MenuAnvil menu = (MenuAnvil) createMenuAnvil(p, title);

        /* Open the MenuAnvil to the player */
        openMenu(p, menu, title);

        //noinspection unchecked
        return (I) menu.getBukkitView();
    }

    @Override
    MenuAnvilWrapper createMenuAnvil(@NotNull Player p, @Nullable String title) {
        EntityPlayer player = handle(p);
        return new MenuAnvil(
                player.nextContainerCounter(),
                player.getInventory(), /* PlayerInventory */
                ContainerAccess.at(((CraftWorld) p.getWorld()).getHandle(), ((CraftBlock) p.getLocation().getBlock()).getPosition()),
                title
        );
    }

    @Override
    void openMenu(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title) {
        EntityPlayer player = handle(p);
        MenuAnvil menuAnvil = (MenuAnvil) menu;
        player.bV = menuAnvil;
        sendOpenScreenPacket(p, menu, title);
        player.initMenu(menuAnvil); /* SlotListener */
    }

    @Override
    void sendOpenScreenPacket(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title) {
        EntityPlayer player = handle(p);
        MenuAnvil menuAnvil = (MenuAnvil) menu;
        player.b.sendPacket(new PacketPlayOutOpenWindow(
                menuAnvil.j,
                Containers.h,
                title == null ? null : IChatBaseComponent.a(title)
        ));
    }


    static private class MenuAnvil extends ContainerAnvil implements MenuAnvilWrapper {

        public MenuAnvil(int containerId, PlayerInventory playerinventory, ContainerAccess containeraccess, @Nullable String title) {
            super(containerId, playerinventory, containeraccess);
            checkReachable = false;
            if(title != null) setTitle(IChatBaseComponent.a(title));
        }

        @Override
        public void l() { /* createResult() */
            Slot resultSlot = getSlot(0); /* getSlot() */
            ItemStack result = resultSlot.getItem(); /* getItem() */
            if(result.isEmpty()) { /* isEmpty() */
                resultSlot.set(getSlot(0).getItem().cloneItemStack()); /* setItem(stack), getSlot(i).getItem().cloneItemStack() */
            }
            w.set(0); /* cost.set() */
            d(); /* broadcastChanges() */
            updateInventory(); /* sendAllDataToRemote() */
        }
    }
}
