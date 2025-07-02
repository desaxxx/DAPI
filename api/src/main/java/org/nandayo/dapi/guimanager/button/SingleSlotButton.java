package org.nandayo.dapi.guimanager.button;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

@Getter
@SuppressWarnings("unused")
public abstract class SingleSlotButton extends AbstractButton {

    abstract public int getSlot();

    abstract public @Nullable ItemStack getItem();

    // AbstractButton supplies onClick() and isModifiable()


    @Override
    final protected @NotNull Set<Integer> getSlots() {
        return Set.of(getSlot());
    }
}
