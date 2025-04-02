package org.nandayo.dapi.guimanager;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public abstract class Button {

    private final int slot;
    private final boolean isModifiable;

    public Button(int slot, boolean isModifiable) {
        this.slot = slot;
        this.isModifiable = isModifiable;
    }
    public Button(int slot) {
        this(slot, false);
    }

    public final int getSlot() {
        return this.slot;
    }

    public boolean isModifiable() {
        return isModifiable;
    }

    //------------------------------
    //   Abstract methods
    //

    public abstract ItemStack getItem();

    public abstract void onClick(Player p, ClickType clickType);
}
