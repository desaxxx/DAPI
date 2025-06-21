package org.nandayo.dapi.guimanager.menu;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.guimanager.MenuType;

import java.util.function.Consumer;

@Getter(AccessLevel.PROTECTED)
@SuppressWarnings("unused")
public abstract class AbsMenu<T extends Inventory> {

    protected @Nullable Inventory inventory;
    private @NotNull Consumer<T> closeCallback = (inventory) -> {};

    abstract protected void createInventory(@NotNull MenuType menuType, @NotNull String title);

    @Nullable
    protected ItemStack getInvItem(int slot) {
        if (inventory == null) return null;
        return inventory.getItem(slot);
    }

    protected void setInvItem(int slot, @Nullable ItemStack item) {
        if (inventory == null) return;
        inventory.setItem(slot, item);
    }

    protected void runOnClose(@NotNull Consumer<T> callback) {
        this.closeCallback = callback;
    }

    abstract protected void displayTo(@NotNull Player player);
}
