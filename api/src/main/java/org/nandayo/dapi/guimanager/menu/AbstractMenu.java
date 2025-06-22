package org.nandayo.dapi.guimanager.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.guimanager.button.AbstractButton;
import org.nandayo.dapi.guimanager.button.SingleSlotButton;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("unused")
public abstract class AbstractMenu {

    abstract protected List<AbstractButton> getButtons();

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
        return getButtons().stream()
                .filter(b -> b.matchesSlot(slot))
                .findFirst()
                .orElse(null);
    }

    /**
     * Add an abstract button to the menu.<br>
     * Available buttons are: Button, LazyButton.
     * @param button AbstractButton
     */
    abstract protected <T extends AbstractButton> void addButton(@NotNull T button);

    /**
     * Remove a button from the buttons list.
     * @param button AbstractButton
     */
    abstract protected void removeButton(@NotNull AbstractButton button);

    /**
     * Remove a button from given slot or remove the slot from slots of the button in case it has multiple slots.
     * @param slot Integer
     */
    abstract protected void removeButton(int slot);

    abstract public Inventory getInventory();

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

    /**
     * Display the menu to a player.
     * @param p Player
     */
    abstract protected void displayTo(@NotNull Player p);
}
