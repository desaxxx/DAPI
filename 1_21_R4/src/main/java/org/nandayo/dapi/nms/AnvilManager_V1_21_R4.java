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
import org.bukkit.craftbukkit.v1_21_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R4.block.CraftBlock;
import org.bukkit.craftbukkit.v1_21_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AnvilManager_V1_21_R4 extends AnvilWrapper {

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
        player.o(); /* closeContainer(). */

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
                player.gj(),
                ContainerAccess.a(((CraftWorld) p.getWorld()).getHandle(), ((CraftBlock) p.getLocation().getBlock()).getPosition()),
                title
        );
    }

    @Override
    void openMenu(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title) {
        EntityPlayer player = handle(p);
        MenuAnvil menuAnvil = (MenuAnvil) menu;
        player.bR = menuAnvil;
        sendOpenScreenPacket(p, menu, title);
        player.a(menuAnvil); /* SlotListener */
    }

    @Override
    void sendOpenScreenPacket(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title) {
        EntityPlayer player = handle(p);
        MenuAnvil menuAnvil = (MenuAnvil) menu;
        player.f.b(new PacketPlayOutOpenWindow(
                menuAnvil.l,
                Containers.i,
                title == null ? null : IChatBaseComponent.a(title)
        ));
    }


    static private class MenuAnvil extends ContainerAnvil implements MenuAnvilWrapper {

        public MenuAnvil(int i, PlayerInventory playerinventory, ContainerAccess containeraccess, @Nullable String title) {
            super(i, playerinventory, containeraccess);
            checkReachable = false;
            if(title != null) setTitle(IChatBaseComponent.a(title)); /* title is null by default */
        }

        @Override
        public void l() { /* createResult() */
            Slot resultSlot = b(2); /* getSlot() */
            ItemStack result = resultSlot.g(); /* getItem() */
            if(result.f()) { /* isEmpty() */
                resultSlot.f(b(0).g().v()); /* getSlot(i).getItem().copy() */
            }
            y.a(0); /* cost.set(i) */
            d(); /* broadcastChanges() */
            b(); /* sendAllDataToRemote() */
        }

        @Override
        public <I extends InventoryView> I getInventoryView() {
            //noinspection unchecked
            return (I) getBukkitView();
        }
    }
}