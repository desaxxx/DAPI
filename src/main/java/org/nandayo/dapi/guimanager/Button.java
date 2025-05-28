package org.nandayo.dapi.guimanager;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
@Getter
public abstract class Button extends AbstractButton {

    private final boolean modifiable;

    public Button(@NotNull List<Integer> slots, boolean modifiable) {
        super(slots);
        this.modifiable = modifiable;
    }
    public Button(@NotNull List<Integer> slots) {
        this(slots, false);
    }
    public Button(boolean modifiable, @NotNull Integer... slots) {
        this(Arrays.asList(slots), modifiable);
    }
    public Button(@NotNull Integer... slots) {
        this(Arrays.asList(slots), false);
    }

    //------------------------------
    //   Abstract methods
    //

    public abstract ItemStack getItem();

    public abstract void onClick(@NotNull Player p, ClickType clickType);
}
