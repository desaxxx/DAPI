package org.nandayo.dapi.guimanager;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ApiStatus.Experimental
@SuppressWarnings("unused")
public class MenuModel {

    private final @NotNull String id;
    private final @NotNull String title;
    private final int rows;
    private final @Nullable Material empty;
    private final @NotNull Map<Integer, @NotNull MenuItem> items;
    private final @NotNull List<CustomSection> customSections;

    public MenuModel(@NotNull String id, @NotNull String title, int rows, @Nullable Material empty, @NotNull Map<Integer, MenuItem> items, @NotNull List<CustomSection> customSections) {
        this.id = id;
        this.title = title;
        this.rows = rows;
        this.empty = empty;
        this.items = new HashMap<>(items);
        this.customSections = new ArrayList<>(customSections);
    }

    @NotNull
    static public <T extends ConfigurationSection> MenuModel read(@NotNull T section, boolean readItems) {
        String id = section.getString("id", Util.generateRandomLowerCaseString(4));
        String title = section.getString("title","Default Title");
        int rows = Math.min(6, Math.max(1, section.getInt("rows")));
        Material empty = Material.getMaterial(section.getString("empty",""));

        ConfigurationSection itemsSection = section.getConfigurationSection("items");
        Map<Integer, MenuItem> items = new HashMap<>();
        if (readItems && itemsSection != null) {
            for(String slotStr : itemsSection.getKeys(false)) {
                int slot;
                try {
                    slot = Integer.parseInt(slotStr);
                }catch (NumberFormatException e) {
                    slot = 0;
                }
                ConfigurationSection menuItemSection = itemsSection.getConfigurationSection(slotStr);
                if(menuItemSection == null) continue;
                MenuItem menuItem = MenuItem.read(menuItemSection);
                items.put(slot, menuItem);
            }
        }
        List<CustomSection> customSections = new ArrayList<>();
        return new MenuModel(id, title, rows, empty, items, customSections);
    }

    @NotNull
    static public <T extends ConfigurationSection> MenuModel read(@NotNull T section) {
        return read(section, true);
    }
}