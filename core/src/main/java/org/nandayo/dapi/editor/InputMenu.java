package org.nandayo.dapi.editor;

import com.google.common.collect.Sets;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.guimanager.button.Button;
import org.nandayo.dapi.guimanager.menu.AnvilMenu;
import org.nandayo.dapi.task.OnceConsumer;
import org.nandayo.dapi.util.ItemCreator;

import java.util.Set;
import java.util.function.Consumer;

public class InputMenu extends AnvilMenu {

    private final Player player;
    private final String title;
    private final String initName;
    private final OnceConsumer<@Nullable String> onFinish;

    public InputMenu(Player player, String title, String initName, Consumer<@Nullable String> onFinish) {
        this.player = player;
        this.title = title;
        this.initName = initName;
        this.onFinish = new OnceConsumer<>(onFinish);
    }

    public void open() {
        clearButtons();

        createInventory(player, title);

        addButton(new Button() {
            @Override
            protected @NotNull Set<Integer> getSlots() {
                return Sets.newHashSet(0);
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(Material.PAPER)
                        .autoColorize(false)
                        .name(initName)
                        .get();
            }
        });

        addButton(new Button() {
            @Override
            protected @NotNull Set<Integer> getSlots() {
                return Sets.newHashSet(2);
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(Material.NAME_TAG)
                        .get();
            }

            @Override
            public void onClick(@NotNull Player p, @NotNull ClickType clickType) {
                String text = getText();
                onFinish.accept(text);
            }
        });

        displayTo(player);
    }

    @Override
    public void onClose(@NotNull Inventory inventory) {
        onFinish.accept(null);
    }
}
