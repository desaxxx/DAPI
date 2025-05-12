package org.nandayo.dapi.guimanager;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
@Getter
public abstract class Button extends AbstractButton {

    private final int slot;
    private final boolean modifiable;

    public Button(int slot, boolean modifiable) {
        this.slot = slot;
        this.modifiable = modifiable;
    }
    public Button(int slot) {
        this(slot, false);
    }

    //------------------------------
    //   Abstract methods
    //

    public abstract ItemStack getItem();

    public abstract void onClick(@NotNull Player p, ClickType clickType);
}
