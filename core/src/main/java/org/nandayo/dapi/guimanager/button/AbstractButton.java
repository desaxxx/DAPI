package org.nandayo.dapi.guimanager.button;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public abstract class AbstractButton {

    protected @NotNull Set<Integer> getSlots() {
        return Set.of();
    }

    protected Set<Integer> slots;
    public final @NotNull Set<Integer> updatedMutableSlots() {
        if(slots == null) {
            slots = new HashSet<>(getSlots());
        }
        return slots;
    }

    final public boolean matchesSlot(int slot) {
        return updatedMutableSlots().contains(slot);
    }

    final public void removeSlot(int slot) {
        updatedMutableSlots().remove(slot);
    }

    public @Nullable ItemStack getItem() {
        return null;
    }

    public void onClick(@NotNull Player p, @NotNull ClickType clickType) {}

    /**
     * @since 1.5.1
     */
    public void onClick(@NotNull InventoryClickEvent event) {
        this.onClick((Player) event.getWhoClicked(), event.getClick());
    }

    public boolean isModifiable() {
        return false;
    }
}
