package org.nandayo.dapi.adventure;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

final class PaperItemMetaHandler implements ItemMetaHandler {
    public static final PaperItemMetaHandler INSTANCE = new PaperItemMetaHandler();
    private PaperItemMetaHandler() {}

    @Override
    public void name(ItemMeta meta, Component component) {
    }

    @Override
    public void lore(ItemMeta meta, List<Component> componentList) {
        meta.lore(componentList);
    }

}
