package org.nandayo.dapi.guimanager.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.guimanager.button.AbstractButton;
import org.nandayo.dapi.guimanager.button.SingleSlotButton;
import org.nandayo.dapi.util.Validate;

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
    protected AbstractMenu() {}


    protected List<AbstractButton> getButtons() {
        return Collections.unmodifiableList(abstractButtons);
    }

    /**
     * Check if the inventory slot has a menu button.
     *
     * @param slot the slot to check
     * @return {@code true} if the slot has a button, {@code false} otherwise
     * @since 1.5.3
     */
    public boolean hasButton(int slot) {
        for(AbstractButton button : abstractButtons) {
            if(button.matchesSlot(slot)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the button from the given inventory slot.
     *
     * @param slot the slot to get button from
     * @return the button if found, {@code null} otherwise
     */
    public @Nullable AbstractButton getButton(int slot) {
        for(AbstractButton button : abstractButtons) {
            if(button.matchesSlot(slot)) {
                return button;
            }
        }
        return null;
    }

    /**
     * Add a button to the menu.
     *
     * @param button the button to add
     */
    protected void addButton(@NotNull AbstractButton button) {
        for(int slot : button.getCachedSlots()) {
            removeSlot(slot);
        }

        this.abstractButtons.add(button);
    }

    /**
     * Remove a button from the menu.
     *
     * @param button the button to remove
     */
    protected void removeButton(@NotNull AbstractButton button) {
        this.abstractButtons.remove(button);
    }

    /**
     * Clear buttons from the menu.
     * <p>
     * This action doesn't remove item stacks from {@link #inventory}.
     *
     * @since 1.5.2
     */
    protected void clearButtons() {
        this.abstractButtons.clear();
    }

    /**
     * Remove an inventory slot from the existing button if it exists.
     *
     * @param slot the slot to remove
     * @return the button that the slot was removed from, or {@code null} if no button was found
     * @since 1.5.3
     */
    @Nullable
    protected AbstractButton removeSlot(int slot) {
        AbstractButton abstractButton = getButton(slot);
        if(abstractButton != null) {
            abstractButton.removeSlot(slot);
        }
        return abstractButton;
    }

    /**
     * Get the inventory of the menu.
     *
     * @return the inventory if created one, {@code null} otherwise.
     */
    @Nullable
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Set the inventory of the menu.
     *
     * @param inventory the inventory to set to
     */
    protected void setInventory(@NotNull Inventory inventory) {
       this.inventory = inventory;
    }

    /**
     * Get the item stack on inventory from the given inventory slot.
     *
     * @param slot the slot to get item from
     * @return the item stack if found, {@code null} otherwise
     */
    protected @Nullable ItemStack getInvItem(int slot) {
        if(getInventory() == null) return null;
        return getInventory().getItem(slot);
    }

    /**
     * Set the item stack on inventory at the given slot.
     *
     * @param slot the slot to set item to
     * @param item the item stack to set to
     */
    protected void setInvItem(int slot, @Nullable ItemStack item) {
        if(getInventory() == null) return;
        getInventory().setItem(slot, item);
    }

    /**
     * Display the menu to a player.
     *
     * @param player the player to display to
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
            SingleSlotButton singleSlotButton = backgroundButton(i);
            if(singleSlotButton == null || getButton(i) != null) {
                continue;
            }
            addButton(singleSlotButton);
        }
    }

    protected void uploadButtons() {
        if(inventory == null) return;

        for(AbstractButton abstractButton : getButtons()) {
            for(int slot : abstractButton.getCachedSlots()) {
                if(slot < 0 || slot >= inventory.getSize()) {
                    continue;
                }
                inventory.setItem(slot , abstractButton.getItem());
            }
        }
    }





    /**
     * Check whether empty slots are modifiable or not.
     *
     * @return {@code true} if empty slots are modifiable, {@code false} otherwise
     */
    public boolean isEmptySlotsModifiable() {
        return false;
    }

    /**
     * Check whether player inventory is modifiable or not.
     *
     * @return {@code true} if player inventory is modifiable, {@code false} otherwise
     */
    public boolean isPlayerInventoryModifiable() {
        return false;
    }

    /**
     * Get the background button for the given inventory slot.
     * <p>
     * <b>Note:</b> Buttons added with {@link #addButton(AbstractButton)} will override background buttons.
     *
     * @param slot the slot to get the background button
     * @return the single slot button if found, {@code null} otherwise
     * @since 1.5.1
     */
    @Nullable
    public SingleSlotButton backgroundButton(int slot) {
        return null;
    }

    /**
     * Called method on the menu close.
     *
     * @param inventory the inventory of the menu
     * @since 1.5.1
     */
    public void onClose(@NotNull Inventory inventory) {}

    /**
     * Called method on the menu close.
     *
     * @param event the inventory close event
     * @since 1.5.2
     */
    public void onClose(@NotNull InventoryCloseEvent event) {
        onClose(event.getInventory());
    }

    /**
     * Main called method on player clicking their own inventory.
     *
     * @param event inventory click event
     * @since 1.5.1
     */
    public void onPlayerInventoryClick(@NotNull InventoryClickEvent event) {
        Validate.notNull(event.getClickedInventory(), "Clicked inventory is null."); // Shouldn't happen
        this.onPlayerInventoryClick((PlayerInventory) event.getClickedInventory(), event.getSlot());
    }

    /**
     * Called method on player clicking their own inventory.
     *
     * @param inventory the inventory of the menu viewer
     * @param slot the inventory slot clicked on player inventory
     * @since 1.5.1
     */
    public void onPlayerInventoryClick(@NotNull PlayerInventory inventory, int slot) {}



    //================
    // DEPRECATED AREA
    //================

    /** @deprecated See {@link #hasButton(int)} */
    @Deprecated(since = "1.5.3")
    public boolean isButton(int slot) {
        return hasButton(slot);
    }

    /** @deprecated See {@link #removeSlot(int)} */
    @Deprecated(since = "1.5.3")
    @Nullable
    protected AbstractButton removeButton(int slot) {
        return removeSlot(slot);
    }

    /** @deprecated See {@link #backgroundButton(int)} */
    @Deprecated(since = "1.5.1")
    public Function<Integer, @Nullable SingleSlotButton> backgroundButtonFunction() {
        return this::backgroundButton;
    }

    /** @deprecated See {@link #onClose(Inventory)} */
    @Deprecated(since = "1.5.1")
    public <T extends Inventory> Consumer<T> onClose() {
        return this::onClose;
    }

    /** @deprecated See {@link #onPlayerInventoryClick(PlayerInventory, int)} */
    @Deprecated(since = "1.5.1")
    public BiConsumer<PlayerInventory, Integer> onPlayerInventoryClick() {
        return this::onPlayerInventoryClick;
    }
}
