package org.nandayo.dapi.guimanager;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Getter
@SuppressWarnings("unused")
public abstract class SingleSlotButton extends AbstractButton {

    private final boolean modifiable;

    public SingleSlotButton(Integer slot, boolean modifiable) {
        super(slot);
        this.modifiable = modifiable;
    }
    public SingleSlotButton(Integer slot) {
        this(slot, false);
    }

    public abstract ItemStack getItem();

    public void onClick(@NotNull Player p, ClickType clickType) {}
}
