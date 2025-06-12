package org.nandayo.dapi.guimanager;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
@Getter
@Deprecated(since = "1.2.2", forRemoval = true)
public abstract class LazyButton extends AbstractButton {

    abstract public @NotNull Set<Integer> getSlots();

    abstract public @Nullable ItemStack getItem();

    // AbstractButton supplies onClick() and isModifiable()
}
