package org.nandayo.dapi.guimanager.button;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@Getter
@SuppressWarnings("unused")
public abstract class PatternButton extends AbstractButton {

    /**
     * Get the layout of the button slots.
     * <p>
     * An example layout where the button has the slots on menu edges:
     * <pre>
     * new String[] {
     *     "XXXXXXXXX",
     *     "X       X",
     *     "XXXXXXXXX",
     * }
     * </pre>
     *
     * @return String array of the layout
     */
    public abstract @NotNull String[] getLayout();

    /**
     * {@inheritDoc}
     */
    @Override
    protected final @NotNull Set<Integer> getSlots() {
        Set<Integer> slots = new HashSet<>();
        String[] layout = getLayout();
        for(int i = 0; i < layout.length; i++) {
            char[] chars = layout[i].toCharArray();
            for(int j = 0; j < chars.length; j++) {
                if(chars[j] != ' ') {
                    int slot = i * 9 + j;
                    slots.add(slot);
                }
            }
        }
        return slots;
    }

    /**
     * {@inheritDoc}
     */
    public abstract ItemStack getItem();
}
