package org.nandayo.dapi.adventure;

import net.kyori.adventure.platform.bukkit.MinecraftComponentSerializer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.DAPIException;
import org.nandayo.dapi.util.Wrapper;

import java.lang.reflect.Field;
import java.util.List;

@ApiStatus.Experimental
final class SpigotItemMetaHandler implements ItemMetaHandler {
    public static final SpigotItemMetaHandler INSTANCE = new SpigotItemMetaHandler();
    private SpigotItemMetaHandler() {}

    /*
     * String before Spigot-1.20.5
     * IChatBaseComponent onwards Spigot-1.20.5
     */
    private static final Field FIELD_DISPLAYNAME;
    /*
     * List<String> before Spigot-1.20.5
     * List<IChatBaseComponent> onwards Spigot-1.20.5
     */
    private static final Field FIELD_LORE;
    static {
        try {
            Class<?> craftMetaItem = Class.forName("org.bukkit.craftbukkit.inventory.CraftMetaItem");

            FIELD_DISPLAYNAME = craftMetaItem.getDeclaredField("displayName");
            FIELD_DISPLAYNAME.setAccessible(true);
            FIELD_LORE = craftMetaItem.getDeclaredField("lore");
            FIELD_LORE.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            throw new DAPIException("Failed to read CraftMetaItem class and fields!");
        }
    }


    @Override
    public void name(ItemMeta meta, Component component) {
        try {
            FIELD_DISPLAYNAME.set(meta, serializeComponent(component));
        } catch (IllegalAccessException e) {
            throw new DAPIException("Failed to set item display name.");
        }
    }

    @Override
    public void lore(ItemMeta meta, List<Component> componentList) {
        try {
            FIELD_LORE.set(meta, deserializeComponent(componentList));
        } catch (IllegalAccessException e) {
            throw new DAPIException("Failed to set item lore.");
        }
    }


    /**
     * Serialize a {@link Component} to an {@link Object}.
     * @param component Component
     * @return String for Spigot-1.20.4 and below.<br>
     *         IChatBaseComponent for Spigot-1.20.5 and upward.
     */
    @NotNull
    private Object serializeComponent(Component component) {
        if(Wrapper.getMinecraftVersion() >= 205) {
            return GsonComponentSerializer.gson().serialize(component); // String
        }else {
            //noinspection UnstableApiUsage
            return MinecraftComponentSerializer.get().serialize(component); // IChatBaseComponent
        }
    }

    /**
     * Deserialize a {@link Object} to a {@link Component}.
     * @param obj String for Spigot-1.20.4 and below.<br>
     *            IChatBaseComponent for Spigot-1.20.5 and upward.
     * @return Component
     */
    @NotNull
    private Component deserializeComponent(Object obj) {
        if(Wrapper.getMinecraftVersion() >= 205) {
            return GsonComponentSerializer.gson().deserialize((String) obj);
        }else {
            //noinspection UnstableApiUsage
            return MinecraftComponentSerializer.get().deserialize(obj);
        }
    }
}
