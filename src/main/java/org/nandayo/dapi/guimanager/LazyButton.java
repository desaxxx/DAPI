package org.nandayo.DAPI.guimanager;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class LazyButton {

    private final List<Integer> slots;

    public LazyButton(List<Integer> slots) {
        this.slots = slots;
    }

    public final List<Integer> getSlots() {
        return this.slots;
    }

    //------------------------------
    //   Abstract methods
    //

    public abstract ItemStack getItem();
}
