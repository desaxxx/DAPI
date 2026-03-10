package org.nandayo.dapi.guimanager.button;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@Getter
@SuppressWarnings("unused")
public abstract class SingleSlotButton extends AbstractButton {

    /**
     * Get the slot of the button that will appear on the menu.
     *
     * @return the slot of the button
     */
    protected abstract int getSlot();

    /**
     * {@inheritDoc}
     */
    @Override
    protected final @NotNull Set<Integer> getSlots() {
        return Set.of(getSlot());
    }

    /**
     * {@inheritDoc}
     */
    public abstract ItemStack getItem();
}
