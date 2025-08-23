package org.nandayo.dapi.guimanager.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.guimanager.button.AbstractButton;
import org.nandayo.dapi.guimanager.button.SingleSlotButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("unused")
public abstract class AbstractMenu {

    private final @NotNull List<AbstractButton> abstractButtons = new ArrayList<>();
    private @Nullable Inventory inventory;

    protected List<AbstractButton> getButtons() {
        return Collections.unmodifiableList(abstractButtons);
    }

    /**
     * Check if the slot is a menu button.
     * @param slot Integer
     * @return bool
     */
    public boolean isButton(int slot) {
        return getButton(slot) != null;
    }

    /**
     * Get an abstract button from given slot.
     * @param slot Integer
     * @return AbstractButton
     */
    public @Nullable AbstractButton getButton(int slot) {
        return this.abstractButtons.stream()
                .filter(b -> b.matchesSlot(slot))
                .findFirst()
                .orElse(null);
    }

    /**
     * Add an abstract button to the menu.<br>
     * Available buttons are: Button, LazyButton.
     * @param button AbstractButton
     */
    protected void addButton(@NotNull AbstractButton button) {
        // Remove the old button from overridden slot.
        for(Integer slot : button.updatedMutableSlots()) {
            removeButton(slot);
        }

        this.abstractButtons.add(button);
    }

    /**
     * Remove a button from the buttons list.
     * @param button AbstractButton
     */
    protected void removeButton(@NotNull AbstractButton button) {
        this.abstractButtons.remove(button);
    }

    /**
     * Remove a button from given slot or remove the slot from slots of the button in case it has multiple slots.
     * @param slot Integer
     * @return The button that contains the given slot
     */
    @Nullable
    protected AbstractButton removeButton(int slot) {
        AbstractButton abstractButton = getButton(slot);
        if(abstractButton != null) {
            abstractButton.removeSlot(slot);
        }
        return abstractButton;
    }

    /**
     * Get the inventory of the Menu.
     * @return Inventory if created one, else {@code null}.
     */
    @Nullable
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Set the inventory of the Menu.
     * @param inventory Inventory
     */
    protected void setInventory(@NotNull Inventory inventory) {
       this.inventory = inventory;
    }

    /**
     * Get item on inventory from given slot.
     * @param slot Integer
     * @return ItemStack or null
     */
    protected @Nullable ItemStack getInvItem(int slot) {
        if(getInventory() == null) return null;
        return getInventory().getItem(slot);
    }

    /**
     * Set item on inventory at given slot.
     * @param slot Integer
     * @param item ItemStack
     */
    protected void setInvItem(int slot, @Nullable ItemStack item) {
        if(getInventory() == null) return;
        getInventory().setItem(slot, item);
    }

    /**
     * Display the menu to a player.
     * @param player Player
     */
    protected void displayTo(@NotNull Player player) {
        if(inventory == null) return;

        uploadBackgroundButtons();
        uploadButtons();

        player.openInventory(inventory);
        player.setMetadata(DAPI.GUI_METADATA_KEY, new FixedMetadataValue(DAPI.getPlugin(), this));
    }

    protected void uploadBackgroundButtons() {
        if(inventory == null) return;
        for(int i = 0; i < inventory.getSize(); i++) {
            SingleSlotButton singleSlotButton = backgroundButtonFunction().apply(i);
            if(singleSlotButton == null || getButton(i) != null) continue;
            addButton(singleSlotButton);
        }
    }

    protected void uploadButtons() {
        if(inventory == null) return;
        for(AbstractButton abstractButton : getButtons()) {
            for(int slot : abstractButton.updatedMutableSlots()) {
                inventory.setItem(slot , abstractButton.getItem());
            }
        }
    }





    /**
     * Set empty slots modifiable or not.
     */
    public boolean isEmptySlotsModifiable() {
        return false;
    }

    /**
     * Set background button function.
     */
    public Function<Integer, @Nullable SingleSlotButton> backgroundButtonFunction() {
        return slot -> null;
    }

    /**
     * Set close consumer.
     */
    public  <T extends Inventory> Consumer<T> onClose() {
        return inventory -> {};
    }

    /**
     * Set player inventory click function.
     */
    public BiConsumer<PlayerInventory, Integer> onPlayerInventoryClick() {
        return (playerInventory, slot) -> {};
    }
}
