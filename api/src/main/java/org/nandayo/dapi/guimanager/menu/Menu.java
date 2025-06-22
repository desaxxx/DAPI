package org.nandayo.dapi.guimanager.menu;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.guimanager.button.AbstractButton;
import org.nandayo.dapi.guimanager.MenuType;
import org.nandayo.dapi.guimanager.button.SingleSlotButton;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@Getter(AccessLevel.PROTECTED)
public class Menu extends AbstractMenu {

    private final @NotNull List<AbstractButton> abstractButtons = new ArrayList<>();
    private @NotNull MenuType menuType = MenuType.CHEST_3_ROWS;
    private @NotNull String title = "Menu";
    private @Nullable Inventory inventory;


    @Override
    protected final List<AbstractButton> getButtons() {
        return ImmutableList.copyOf(abstractButtons);
    }




    /**
     * Create inventory with menu type and a title.
     * @param menuType MenuType
     * @param title String
     */
    protected final void createInventory(@NotNull MenuType menuType, @NotNull String title) {
        this.menuType = menuType;
        this.title = title;
        this.inventory = menuType.createInventory(title);
    }

    @Override
    protected final <T extends AbstractButton> void addButton(@NotNull T button) {
        // Remove the old button from overridden slot.
        for(Integer slot : button.getSlots()) {
            removeButton(slot);
        }

        this.abstractButtons.add(button);
    }

    @Override
    protected final void removeButton(@NotNull AbstractButton button) {
        this.abstractButtons.remove(button);
    }

    @Override
    protected final void removeButton(int slot) {
        AbstractButton abstractButton = getButton(slot);
        if(abstractButton == null) return;
        abstractButton.removeSlot(slot);
    }

    @Override
    public @Nullable Inventory getInventory() {
        return inventory;
    }

    @Override
    protected final void displayTo(@NotNull Player p) {
        if(inventory == null) {
            createInventory(menuType, title);
        }
        Inventory inv = this.inventory;

        uploadBackgroundButtons(inv);
        uploadButtons(inv);

        p.openInventory(inv);
        p.setMetadata(DAPI.GUI_METADATA_KEY, new FixedMetadataValue(DAPI.getPlugin(), this));
    }


    private void uploadBackgroundButtons(@NotNull Inventory inv) {
        for(int i = 0; i < inv.getSize(); i++) {
            SingleSlotButton singleSlotButton = backgroundButtonFunction().apply(i);
            if(singleSlotButton == null || getButton(i) != null) continue;
            addButton(singleSlotButton);
        }
    }

    private void uploadButtons(@NotNull Inventory inv) {
        for(AbstractButton abstractButton : getAbstractButtons()) {
            for(int slot : abstractButton.getSlots()) {
                inv.setItem(slot , abstractButton.getItem());
            }
        }
    }
}
