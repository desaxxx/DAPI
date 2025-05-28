package org.nandayo.dapi.guimanager;

import com.google.common.collect.ImmutableSet;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public abstract class AbstractButton {

    private final @NotNull Set<Integer> slots;
    public AbstractButton(@NotNull Set<Integer> slots) {
        this.slots = new HashSet<>(slots);
    }
    public AbstractButton(@NotNull List<Integer> slots) {
        this(ImmutableSet.copyOf(slots));
    }
    public AbstractButton(@NotNull Integer... slots) {
        this(ImmutableSet.copyOf(slots));
    }

    protected final @NotNull Set<Integer> getSlots() {
        return ImmutableSet.copyOf(slots);
    }

    protected final void removeSlot(int slot) {
        slots.remove(slot);
    }
}
