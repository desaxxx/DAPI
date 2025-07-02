package org.nandayo.dapi.guimanager.menu;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.nms.NMSWrapper;

@ApiStatus.Experimental
@Getter(AccessLevel.PROTECTED)
@SuppressWarnings("unused")
public class AnvilMenu extends AbstractMenu {

    static private final @NotNull String DEFAULT_TITLE = "Menu";


    /**
     * Create anvil inventory with a title.
     * @param player Player
     * @param title String
     */
    protected final void createInventory(@NotNull Player player, @NotNull String title) {
        setInventory(NMSWrapper.getAnvilWrapper().createMenuAnvil(player, title).getInventoryView().getTopInventory());
    }

    @Override
    protected final void displayTo(@NotNull Player player) {
        if(getInventory() == null) {
            createInventory(player, DEFAULT_TITLE);
        }
        super.displayTo(player);
    }

    @Nullable
    protected final String getText() {
        ItemStack resultItem = getInvItem(2);
        if(resultItem == null) return null;
        return resultItem.getItemMeta() != null ? resultItem.getItemMeta().getDisplayName() : null;
    }
}
