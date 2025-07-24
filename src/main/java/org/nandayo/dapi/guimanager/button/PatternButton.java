package org.nandayo.dapi.guimanager.button;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

@Getter
@SuppressWarnings("unused")
public abstract class PatternButton extends AbstractButton {

    abstract public @NotNull String[] getLayout();

    abstract public @Nullable ItemStack getItem();

    // AbstractButton supplies onClick() and isModifiable()


    @Override
    final protected @NotNull Set<Integer> getSlots() {
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
}
