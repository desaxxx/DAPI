package org.nandayo.dapi.guimanager;

import org.bukkit.inventory.ItemStack;

public class ExampleMenu extends Menu {

    public ExampleMenu() {
        this.addButton(new LazyButton(2,1,3,4) {
            @Override
            public ItemStack getItem() {
                return null;
            }
        });
    }
}
