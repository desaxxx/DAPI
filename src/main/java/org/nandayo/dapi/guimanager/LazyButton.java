package org.nandayo.dapi.guimanager;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
@Getter
public abstract class LazyButton extends AbstractButton {

    private final @NotNull List<Integer> slots;
    private final boolean modifiable;

    public LazyButton(@NotNull List<Integer> slots, boolean modifiable) {
        this.slots = new ArrayList<>(slots);
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

    @NotNull
    public final List<Integer> getSlots() {
        return ImmutableList.copyOf(slots);
    }

    //------------------------------
    //   Abstract methods
    //

    public abstract ItemStack getItem();
}
