package org.nandayo.dapi.guimanager;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.Util;

@Getter
@SuppressWarnings("unused")
public abstract class MenuType {

    abstract @NotNull Inventory createInventory(@NotNull String title);


    static public final MenuType CHEST_1_ROW = new MenuType() {
        @Override
        @NotNull Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 9, title);
        }
    };

    static public final MenuType CHEST_2_ROWS = new MenuType() {
        @Override
        @NotNull Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 2*9, title);
        }
    };

    static public final MenuType CHEST_3_ROWS = new MenuType() {
        @Override
        @NotNull Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 3*9, title);
        }
    };

    static public final MenuType CHEST_4_ROWS = new MenuType() {
        @Override
        @NotNull Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 4*9, title);
        }
    };

    static public final MenuType CHEST_5_ROWS = new MenuType() {
        @Override
        @NotNull Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 5*9, title);
        }
    };

    static public final MenuType CHEST_6_ROWS = new MenuType() {
        @Override
        @NotNull Inventory createInventory(@NotNull String title) {
            return Bukkit.createInventory(null, 6*9, title);
        }
    };

    @ApiStatus.Experimental
    @ApiStatus.Internal
    static public MenuType OTHER(@NotNull InventoryType inventoryType) {
        if(!inventoryType.isCreatable()) {
            Util.log("InventoryType '" + inventoryType.name() + "' is not creatable, using default.");
            return CHEST_3_ROWS;
        }
        
        return new MenuType() {
            @Override
            @NotNull Inventory createInventory(@NotNull String title) {
                return Bukkit.createInventory(null, inventoryType, title);
            }
        };
    }
}