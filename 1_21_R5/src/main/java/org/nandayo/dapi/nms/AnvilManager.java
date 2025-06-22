package org.nandayo.dapi.nms;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundOpenScreenPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AnvilManager extends AnvilWrapper {

    private ServerPlayer handle(@NotNull Player p) {
        return ((CraftPlayer) p).getHandle();
    }


    @Override
    public <I extends InventoryView> I openInventory(@NotNull Player p, @NotNull String title) {
        ServerPlayer player = handle(p);
        player.closeContainer(); /* Close the open menu. */

        /* Create new MenuAnvil */
        MenuAnvil menu = (MenuAnvil) createMenuAnvil(p, title);

        /* Open the MenuAnvil to the player */
        openMenu(p, menu, title);

        //noinspection unchecked
        return (I) menu.getBukkitView();
    }

    @Override
    MenuAnvilWrapper createMenuAnvil(@NotNull Player p, @Nullable String title) {
        ServerPlayer player = handle(p);
        return new MenuAnvil(
                player.nextContainerCounter(),
                player.getInventory(),
                ContainerLevelAccess.create(player.level(), player.blockPosition()),
                title
        );
    }

    @Override
    void openMenu(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title) {
        ServerPlayer player = handle(p);
        MenuAnvil menuAnvil = (MenuAnvil) menu;
        player.containerMenu = menuAnvil;
        sendOpenScreenPacket(p, menu, title);
        player.initMenu(menuAnvil); /* SlotListener */
    }

    @Override
    void sendOpenScreenPacket(@NotNull Player p, @NotNull MenuAnvilWrapper menu, @Nullable String title) {
        ServerPlayer player = handle(p);
        MenuAnvil menuAnvil = (MenuAnvil) menu;
        player.connection.send(new ClientboundOpenScreenPacket(
                menuAnvil.containerId,
                MenuType.ANVIL,
                title == null ? null : Component.literal(title)
        ));
    }


    static private class MenuAnvil extends AnvilMenu implements MenuAnvilWrapper {

        public MenuAnvil(int i, Inventory playerinventory, ContainerLevelAccess containeraccess, @Nullable String title) {
            super(i, playerinventory, containeraccess);
            checkReachable = false;
            if(title != null) setTitle(Component.literal(title)); /* title is null by default */
        }

        @Override
        public void createResult() {
            Slot resultSlot = getSlot(RESULT_SLOT);
            ItemStack result = resultSlot.getItem();
            if(result.isEmpty()) {
                resultSlot.set(getSlot(INPUT_SLOT).getItem().copy());
            }
            cost.set(0);
            broadcastChanges();
            sendAllDataToRemote();
        }
    }
}
