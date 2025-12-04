package org.nandayo.dapi.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * @since 1.5.2
 */
@SuppressWarnings("unused")
public final class ItemCreators {

    /**
     * Get an ItemCreator based on {@code Component} existence.
     * <p>
     *     {@code ItemCreatorPaper} if Component is available,
     *     {@link ItemCreator} otherwise
     * </p>
     *
     * @param itemStack ItemStack
     * @return ItemCreator
     * @since 1.5.2
     */
    @NotNull
    public static ItemCreator of(@NotNull ItemStack itemStack) {
        if(ReflectionUtil.isComponentAvailable()) {
            return ReflectionUtil.itemCreatorPaper(itemStack);
        }
        return ItemCreator.of(itemStack);
    }

    /**
     * Get an ItemCreator based on {@code Component} existence.
     * <p>
     *     {@code ItemCreatorPaper} if Component is available,
     *     {@link ItemCreator} otherwise
     * </p>
     *
     * @param material Material
     * @return ItemCreator
     * @since 1.5.2
     */
    @NotNull
    public static ItemCreator of(@NotNull Material material) {
        if(ReflectionUtil.isComponentAvailable()) {
            return ReflectionUtil.itemCreatorPaper(material);
        }
        return ItemCreator.of(material);
    }
}
