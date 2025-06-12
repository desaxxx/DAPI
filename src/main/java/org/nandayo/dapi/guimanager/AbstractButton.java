package org.nandayo.dapi.guimanager;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public abstract class AbstractButton {

    public @NotNull Set<Integer> getSlots() {
        return new HashSet<>();
    }

    final public boolean matchesSlot(int slot) {
        return getSlots().contains(slot);
    }

    final public void removeSlot(int slot) {
        getSlots().remove(slot);
    }

    public @Nullable ItemStack getItem() {
        return null;
    }

    public void onClick(@NotNull Player p, @NotNull ClickType clickType) {}

    public boolean isModifiable() {
        return false;
    }
}
