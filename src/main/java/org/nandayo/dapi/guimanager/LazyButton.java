package org.nandayo.dapi.guimanager;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
@Getter
public abstract class LazyButton extends AbstractButton {

    private final boolean modifiable;

    public LazyButton(@NotNull List<Integer> slots, boolean modifiable) {
        super(slots);
        this.modifiable = modifiable;
    }
    public LazyButton(@NotNull List<Integer> slots) {
        this(slots, false);
    }
    public LazyButton(boolean modifiable, Integer... slots) {
        this(Arrays.asList(slots), modifiable);
    }
    public LazyButton(Integer... slots) {
        this(Arrays.asList(slots), false);
    }

    //------------------------------
    //   Abstract methods
    //

    public abstract ItemStack getItem();
}
