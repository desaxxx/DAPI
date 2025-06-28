package org.nandayo.dapi.guimanager;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

@Getter
@SuppressWarnings("unused")
public abstract class MenuType {

    abstract public @NotNull Inventory createInventory(@NotNull String title);


    static public final MenuType CHEST_1_ROW = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 9, title);
        }
    };

    static public final MenuType CHEST_2_ROWS = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 2*9, title);
        }
    };

    static public final MenuType CHEST_3_ROWS = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 3*9, title);
        }
    };

    static public final MenuType CHEST_4_ROWS = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 4*9, title);
        }
    };

    static public final MenuType CHEST_5_ROWS = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 5*9, title);
        }
    };

    static public final MenuType CHEST_6_ROWS = new MenuType() {
        @Override
        @NotNull
        public Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 6*9, title);
        }
    };
}