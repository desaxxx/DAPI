package org.nandayo.dapi.guimanager.menu;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.anvilmenu.nms.AnvilWrapper;
import org.nandayo.anvilmenu.nms.NMSWrapper;
import org.nandayo.dapi.DAPI;

@Getter(AccessLevel.PROTECTED)
@SuppressWarnings("unused")
public class AnvilMenu extends AbstractMenu {

    private static final @NotNull String DEFAULT_TITLE = "Menu";

    private @Nullable AnvilWrapper.MenuAnvilWrapper menuAnvilWrapper;


    /**
     * Create anvil inventory with a title.
     * @param player Player
     * @param title String
     */
    protected final void createInventory(@NotNull Player player, @NotNull String title) {
        menuAnvilWrapper = NMSWrapper.getAnvilWrapper().createMenuAnvil(player, title);
        setInventory(menuAnvilWrapper.getInventory());
    }

    @Override
    protected final void displayTo(@NotNull Player player) {
        if(getInventory() == null || menuAnvilWrapper == null) {
            createInventory(player, DEFAULT_TITLE);
        }
        uploadBackgroundButtons();
        uploadButtons();

        NMSWrapper.getAnvilWrapper().openInventory(player, menuAnvilWrapper); // different from AbstractMenu
        player.setMetadata(DAPI.GUI_METADATA_KEY, new FixedMetadataValue(DAPI.getPlugin(), this));
    }

    @Nullable
    protected final String getText() {
        ItemStack resultItem = getInvItem(2);
        if(resultItem == null) return null;
        return resultItem.getItemMeta() != null ? resultItem.getItemMeta().getDisplayName() : null;
    }
}
