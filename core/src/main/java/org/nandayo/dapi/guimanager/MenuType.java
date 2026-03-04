package org.nandayo.dapi.guimanager;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

@Getter
@SuppressWarnings({"unused", "deprecation"})
public abstract class MenuType {

    abstract public @NotNull Inventory createInventory(@NotNull String title);


    public static final MenuType CHEST_1_ROW = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 9, title);
        }
    };

    public static final MenuType CHEST_2_ROWS = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 2*9, title);
        }
    };

    public static final MenuType CHEST_3_ROWS = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 3*9, title);
        }
    };

    public static final MenuType CHEST_4_ROWS = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 4*9, title);
        }
    };

    public static final MenuType CHEST_5_ROWS = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 5*9, title);
        }
    };

    public static final MenuType CHEST_6_ROWS = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 6*9, title);
        }
    };


    /**
     * Get a chest inventory from the number of rows.
     *
     * @param rows the rows of the inventory
     * @return MenuType
     * @since 1.5.3
     */
    public static MenuType getChestFromRows(int rows) {
        switch (rows) {
            case 1:
                return MenuType.CHEST_1_ROW;
            case 2:
                return MenuType.CHEST_2_ROWS;
            case 4:
                return MenuType.CHEST_4_ROWS;
            case 5:
                return MenuType.CHEST_5_ROWS;
            case 6:
                return MenuType.CHEST_6_ROWS;
            default:
                return MenuType.CHEST_3_ROWS;
        }
    }
}