package org.nandayo.dapi.paper.util;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.util.ItemCreator;
import org.nandayo.dapi.util.Validate;

import java.util.List;
import java.util.function.Supplier;

public interface ItemCreatorPaper extends ItemCreator {

    /**
     * Create a builder with specified foundation.
     *
     * @param itemStack foundation item stack
     * @return new ItemCreator
     */
    @NotNull
    static ItemCreator of(@NotNull ItemStack itemStack) {
        return new ItemCreatorPaperImpl(itemStack);
    }

    /**
     * Create a builder with specified foundation.
     *
     * @param material foundation material
     * @return new ItemCreator
     */
    @NotNull
    static ItemCreator of(@NotNull Material material) {
        Validate.notNull(material, "Material cannot be null!");
        return new ItemCreatorPaperImpl(new ItemStack(material));
    }

    /**
     * Set name of the item stack.
     *
     * @param name new name
     * @return ItemCreator
     */
    @NotNull ItemCreator name(@Nullable Component name);

    /**
     * Set name of the item stack.
     *
     * @param nameSupplier new name supplier
     * @return ItemCreator
     */
    @NotNull ItemCreator nameSup(@NotNull Supplier<Component> nameSupplier);

    /**
     * Set lore of the item stack.
     *
     * @param lore new lore
     * @return ItemCreator
     */
    @NotNull ItemCreator loreList(@Nullable List<Component> lore);

    /**
     * Set lore of the item stack.
     *
     * @param lore new lore
     * @return ItemCreator
     */
    @NotNull ItemCreator lore(Component @Nullable... lore);

    /**
     * Set lore of the item stack.
     *
     * @param loreSupplier new lore supplier
     * @return ItemCreator
     */
    @NotNull ItemCreator loreSup(@Nullable Supplier<List<Component>> loreSupplier);

    /**
     * Add lines to lore of the item stack.
     *
     * @param lore new lines
     * @return ItemCreator
     */
    @NotNull ItemCreator addLoreList(@NotNull List<Component> lore);

    /**
     * Add lines to lore of the item stack.
     *
     * @param lore new lines
     * @return ItemCreator
     */
    @NotNull ItemCreator addLore(Component @NotNull... lore);

    /**
     * Add lines to lore of the item stack.
     *
     * @param loreSupplier new lines supplier
     * @return ItemCreator
     */
    @NotNull ItemCreator addLoreSup(@Nullable Supplier<List<Component>> loreSupplier);
}
