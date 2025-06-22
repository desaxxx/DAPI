package org.nandayo.dapi.nms;

import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutOpenWindow;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.player.PlayerInventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_20_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R4.block.CraftBlock;
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AnvilManager extends AnvilWrapper {

    private EntityPlayer handle(@NotNull Player p) {
        return ((CraftPlayer) p).getHandle();
    }

    @Override
    public <I extends InventoryView> I openInventory(@NotNull Player p, @NotNull String title) {
        EntityPlayer player = handle(p);
        player.r(); /* closeContainer(). */

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
                player.gc(), /* PlayerInventory */
                ContainerAccess.a(((CraftWorld) p.getWorld()).getHandle(), ((CraftBlock) p.getLocation().getBlock()).getPosition()),
                title
        );
    }

    @Override
    void openMenu(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title) {
        EntityPlayer player = handle(p);
        player.cb = (MenuAnvil) menu;
        sendOpenScreenPacket(p, menu, title);
        player.a((Container) menu); /* SlotListener */
    }

    @Override
    void sendOpenScreenPacket(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title) {
        EntityPlayer player = handle(p);
        MenuAnvil menuAnvil = (MenuAnvil) menu;
        player.c.b(new PacketPlayOutOpenWindow(
                menuAnvil.j,
                Containers.i,
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
        public void m() { /* createResult() */
            Slot resultSlot = b(0); /* getSlot() */
            ItemStack result = resultSlot.g(); /* getItem() */
            if(result.e()) { /* isEmpty() */
                resultSlot.f(b(0).g().s()); /* getSlot(i).getItem().cloneItemStack() */
            }
            w.a(0); /* cost.set() */
            d(); /* broadcastChanges() */
            b(); /* sendAllDataToRemote() */
        }
    }
}
