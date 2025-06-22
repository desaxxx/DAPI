package org.nandayo.dapi.guimanager.menu;

import lombok.AccessLevel;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MenuType;
import org.bukkit.inventory.view.AnvilView;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.Wrapper;
import org.nandayo.dapi.guimanager.button.AbstractButton;
import org.nandayo.dapi.guimanager.button.SingleSlotButton;

import java.util.ArrayList;
import java.util.List;

@Getter(AccessLevel.PROTECTED)
@ApiStatus.Experimental
@SuppressWarnings("unused")
public class AnvilMenu extends AbstractMenu {

    private final @NotNull List<AbstractButton> abstractButtons = new ArrayList<>();
    private @NotNull String title = "AnvilMenu";
    private @Nullable String text;
    private @Nullable AnvilView anvilView;

    private int repairItemAmount = 0;
    private int repairCost = 0;


    @Override
    protected final List<AbstractButton> getButtons() {
        return List.of(abstractButtons.toArray(new AbstractButton[0]));
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
        if(anvilView == null) return null;
        return anvilView.getTopInventory();
    }

    @Override
    protected final void displayTo(@NotNull Player p) {
        fixText();
        createAnvilView(p);

        uploadBackgroundButtons();
        uploadButtons();

        handleViewEffects();
        p.setMetadata(DAPI.GUI_METADATA_KEY, new FixedMetadataValue(DAPI.getPlugin(), this));
    }

    /**
     * MenuType since 1.21.1
     * AnvilView since 1.21
     * @param player
     */
    private void createAnvilView(@NotNull Player player) {
        if(Wrapper.getMinecraftVersion() >= 211) {
            //noinspection UnstableApiUsage
            anvilView = MenuType.ANVIL.create(player, Component.text(title));
        }else {
            //noinspection UnstableApiUsage,deprecation
            anvilView = (AnvilView) player.openAnvil(player.getLocation(), true);
            if(anvilView != null) {
                //noinspection deprecation
                anvilView.setTitle(title);
            }
        }
    }

    @SuppressWarnings("UnstableApiUsage")
    private void handleViewEffects() {
        if(anvilView == null) return;
        if(Wrapper.getMinecraftVersion() >= 210) {
            anvilView.setRepairItemCountCost(getRepairItemAmount());
            anvilView.setRepairCost(getRepairCost());
            anvilView.setMaximumRepairCost(getRepairCost());
        }else {
            AnvilInventory anvilInventory = (AnvilInventory) anvilView.getTopInventory();
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

    private void uploadBackgroundButtons() {
        if(getInventory() == null) return;
        for(int i = 0; i < getInventory().getSize(); i++) {
            SingleSlotButton singleSlotButton = backgroundButtonFunction().apply(i);
            if(singleSlotButton == null || getButton(i) != null) continue;
            addButton(singleSlotButton);
        }
    }

    private void uploadButtons() {
        if(getInventory() == null) return;
        for(AbstractButton abstractButton : getAbstractButtons()) {
            for(int slot : abstractButton.getSlots()) {
                getInventory().setItem(slot , abstractButton.getItem());
            }
        }
    }
}
