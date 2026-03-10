package org.nandayo.dapi.guimanager.button;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@SuppressWarnings("unused")
@Getter
public abstract class Button extends AbstractButton {

    /**
     * {@inheritDoc}
     */
    protected abstract @NotNull Set<Integer> getSlots();

    /**
     * {@inheritDoc}
     */
    public abstract ItemStack getItem();
}
