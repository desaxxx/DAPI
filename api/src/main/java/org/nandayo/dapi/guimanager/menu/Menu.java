package org.nandayo.dapi.guimanager.menu;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.HexUtil;
import org.nandayo.dapi.guimanager.MenuType;

@SuppressWarnings("unused")
@Getter(AccessLevel.PROTECTED)
public class Menu extends AbstractMenu {

    static private final @NotNull MenuType DEFAULT_MENU_TYPE = MenuType.CHEST_3_ROWS;
    static private final @NotNull String DEFAULT_TITLE = "Menu";


    /**
     * Create inventory with menu type and a title.
     * @param menuType MenuType
     * @param title String
     */
    protected final void createInventory(@NotNull MenuType menuType, @NotNull String title) {
        setInventory(menuType.createInventory(HexUtil.parse(title)));
    }

    @Override
    protected void displayTo(@NotNull Player player) {
        if(getInventory() == null) {
            createInventory(DEFAULT_MENU_TYPE, DEFAULT_TITLE);
        }
        super.displayTo(player);
    }
}
