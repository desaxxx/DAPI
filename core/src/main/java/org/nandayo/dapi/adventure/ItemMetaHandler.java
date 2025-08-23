package org.nandayo.dapi.adventure;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

/**
 * @since 1.4.0
 */
@ApiStatus.Experimental
public interface ItemMetaHandler {

    static ItemMetaHandler getInstance() {
        return ItemMetaHandlerProvider.INSTANCE;
    }

    void name(ItemMeta meta, Component component);
    void lore(ItemMeta meta, List<Component> componentList);
}
