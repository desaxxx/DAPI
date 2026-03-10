package org.nandayo.dapi.guimanager.button;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public abstract class AbstractButton {

    protected Set<Integer> cachedSlots; // mutable
    protected AbstractButton() {}


    /**
     * Get the slots of the button that will appear on the menu.
     *
     * @return the slot set of the button
     */
    protected @NotNull Set<Integer> getSlots() {
        return Set.of();
    }

    /**
     * Get the cached slots of the button. Unlike {@link #getSlots()},
     * cached slots are mutable. Button slots can change in {@link #removeSlot(int)}.
     *
     * @return cached slots of the button
     */
    public final @NotNull Set<Integer> getCachedSlots() {
        if(cachedSlots == null) {
            cachedSlots = new HashSet<>(getSlots());
        }
        return cachedSlots;
    }

    /**
     * Check whether the button has the given slot.
     *
     * @param slot the slot to check
     * @return {@code true} if the button has the slot, {@code false} otherwise
     */
    public boolean matchesSlot(int slot) {
        return getCachedSlots().contains(slot);
    }

    /**
     * Remove the given slot from the button.
     *
     * @param slot slot to remove
     */
    public void removeSlot(int slot) {
        getCachedSlots().remove(slot);
    }

    /**
     * Get the item stack of the button to appear on the menu.
     *
     * @return the item stack of the button
     */
    public ItemStack getItem() {
        return null;
    }

    /**
     * The main {@code onClick} method to be called when the button is clicked.
     * By default, it will call {@link #onClick(Player, ClickType)} method for
     * backwards compatibility.
     *
     * @since 1.5.1
     */
    public void onClick(@NotNull InventoryClickEvent event) {
        this.onClick((Player) event.getWhoClicked(), event.getClick());
    }

    @ApiStatus.Obsolete(since = "1.5.1")
    public void onClick(@NotNull Player p, @NotNull ClickType clickType) {}

    /**
     * Check if the button is modifiable by clicking it, which will allow the
     * menu viewer to interact with the button item stack.
     *
     * @return {@code true} if the button is modifiable, {@code false} otherwise.
     */
    public boolean isModifiable() {
        return false;
    }



    // ====================================================
    // Deprecated Area
    // ====================================================

    /** @deprecated in favor of {@link #getCachedSlots()} */
    @Deprecated(since = "1.5.3")
    public final @NotNull Set<Integer> updatedMutableSlots() {
        return getCachedSlots();
    }
}
