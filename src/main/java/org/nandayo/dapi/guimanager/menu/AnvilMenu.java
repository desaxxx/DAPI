package org.nandayo.dapi.guimanager.menu;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.view.AnvilView;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.Wrapper;
import org.nandayo.dapi.guimanager.button.AbstractButton;
import org.nandayo.dapi.guimanager.MenuType;
import org.nandayo.dapi.guimanager.button.SingleSlotButton;

import java.util.ArrayList;
import java.util.List;

@Getter(AccessLevel.PROTECTED)
@ApiStatus.Experimental
@SuppressWarnings("unused")
public class AnvilMenu extends AbstractMenu {

    private final @NotNull List<AbstractButton> abstractButtons = new ArrayList<>();
    private final @NotNull MenuType menuType = MenuType.OTHER(InventoryType.ANVIL);
    private @NotNull String title = "AnvilMenu";
    private @Nullable String text;
    private @Nullable AnvilInventory inventory;

    private int repairItemAmount = 0;
    private int repairCost = 0;


    @Override
    protected final List<AbstractButton> getButtons() {
        return ImmutableList.copyOf(abstractButtons);
    }

    @Override
    protected final <T extends AbstractButton> void addButton(@NotNull T button) {
        // Remove the old button from overridden slot.
        for(Integer slot : button.getSlots()) {
            removeButton(slot);
        }

        this.abstractButtons.add(button);
    }

    /**
     * Remove a button from the buttons list.
     * @param button AbstractButton
     */
    @Override
    protected final void removeButton(@NotNull AbstractButton button) {
        this.abstractButtons.remove(button);
    }

    /**
     * Remove a button from given slot or remove the slot from slots of the button in case it has multiple slots.
     * @param slot Integer
     */
    @Override
    protected final void removeButton(int slot) {
        AbstractButton abstractButton = getButton(slot);
        if(abstractButton == null) return;
        abstractButton.removeSlot(slot);
    }




    /**
     * Create inventory with title.
     * @param title Title text
     */
    protected final void createInventory(@NotNull String title) {
        this.title = title;
        //noinspection deprecation
        this.inventory = (AnvilInventory) Bukkit.createInventory(null, InventoryType.ANVIL, title);
    }

    protected final void setText(@NotNull String text) {
        this.text = text;
    }

    protected final void setRepairItemAmount(int amount) {
        this.repairItemAmount = Math.max(0, amount);
    }

    protected final void setRepairCost(int cost) {
        this.repairCost = Math.max(0, cost);
    }

    @Override
    public @Nullable AnvilInventory getInventory() {
        return inventory;
    }

    @Override
    protected final void displayTo(@NotNull Player p) {
        fixText();
        if(inventory == null) {
            createInventory(title);
        }
        AnvilInventory inv = this.inventory;

        uploadBackgroundButtons(inv);
        uploadButtons(inv);

        handleViewEffects(p.openInventory(inv));
        p.setMetadata(DAPI.GUI_METADATA_KEY, new FixedMetadataValue(DAPI.getPlugin(), this));
    }

    @SuppressWarnings("UnstableApiUsage")
    private void handleViewEffects(InventoryView view) {
        if(Wrapper.getMinecraftVersion() >= 210) {
            AnvilView anvilView = (AnvilView) view;
            anvilView.setRepairItemCountCost(getRepairItemAmount());
            anvilView.setRepairCost(getRepairCost());
            anvilView.setMaximumRepairCost(getRepairCost());
        }else {
            AnvilInventory anvilInventory = (AnvilInventory) view.getTopInventory();
            anvilInventory.setRepairCostAmount(getRepairItemAmount());
            anvilInventory.setRepairCost(getRepairCost());
            anvilInventory.setMaximumRepairCost(getRepairCost());
        }
    }


    private void fixText() {
        ItemStack firstItem = getInvItem(0);
        if(getText() != null && firstItem != null && !firstItem.getType().isAir() && firstItem.getItemMeta() != null) {
            //noinspection deprecation
            firstItem.getItemMeta().setDisplayName(getText());
        }
    }

    private void uploadBackgroundButtons(@NotNull AnvilInventory inv) {
        for(int i = 0; i < inv.getSize(); i++) {
            SingleSlotButton singleSlotButton = backgroundButtonFunction().apply(i);
            if(singleSlotButton == null || getButton(i) != null) continue;
            addButton(singleSlotButton);
        }
    }

    private void uploadButtons(@NotNull AnvilInventory inv) {
        for(AbstractButton abstractButton : getAbstractButtons()) {
            for(int slot : abstractButton.getSlots()) {
                inv.setItem(slot , abstractButton.getItem());
            }
        }
    }
}
