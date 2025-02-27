package org.nandayo.DAPI.guimanager;

import org.bukkit.inventory.ItemStack;

import java.util.Set;

public abstract class LazyButton {

    private final Set<Integer> slots;

    public LazyButton(Set<Integer> slots) {
        this.slots = slots;
    }

    public final Set<Integer> getSlots() {
        return this.slots;
    }

    //------------------------------
    //   Abstract methods
    //

    public abstract ItemStack getItem();
}
