package org.nandayo.dapi.guimanager.button;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
@Getter
public abstract class Button extends AbstractButton {

    abstract protected @NotNull Set<Integer> getSlots();

    abstract public @Nullable ItemStack getItem();

    // AbstractButton supplies onClick() and isModifiable()
}
