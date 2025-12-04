package org.nandayo.dapi.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @since 1.5.2
 */
public class ReflectionUtil {
    private static final @Nullable Method ITEM_CREATOR_PAPER_OF_ITEMSTACK;
    private static final @Nullable Method ITEM_CREATOR_PAPER_OF_MATERIAL;

    static {
        Method ofItemStackMethod = null;
        Method ofMaterialMethod = null;
        try {
            Class<?> itemCreatorPaper = Class.forName("org.nandayo.dapi.paper.util.ItemCreatorPaper");

            ofItemStackMethod = itemCreatorPaper.getMethod("of", ItemStack.class);
            ofMaterialMethod = itemCreatorPaper.getMethod("of", Material.class);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
            Util.logInternal("Couldn't find ItemCreatorPaper methods.");
        }
        ITEM_CREATOR_PAPER_OF_ITEMSTACK = ofItemStackMethod;
        ITEM_CREATOR_PAPER_OF_MATERIAL = ofMaterialMethod;
    }


    /**
     * Call {@code ItemCreatorPaper#of(ItemStack)} method using reflection.
     *
     * @param itemStack ItemStack
     * @return ItemCreator of Paper
     * @since 1.5.2
     */
    @NotNull
    public static ItemCreator itemCreatorPaper(@NotNull ItemStack itemStack) {
        if(ITEM_CREATOR_PAPER_OF_ITEMSTACK == null) {
            throw new NullPointerException("ItemCreatorPaper method is null.");
        }
        try {
            return (ItemCreator) ITEM_CREATOR_PAPER_OF_ITEMSTACK.invoke(null, itemStack);
        } catch (IllegalAccessException |InvocationTargetException e) {
            throw new DAPIException("Failed to invoke ItemCreatorPaper method.");
        }
    }

    /**
     * Call {@code ItemCreatorPaper#of(Material)} method using reflection.
     *
     * @param material Material
     * @return ItemCreator of Paper
     * @since 1.5.2
     */
    @NotNull
    public static ItemCreator itemCreatorPaper(@NotNull Material material) {
        if(ITEM_CREATOR_PAPER_OF_MATERIAL == null) {
            throw new NullPointerException("ItemCreatorPaper method is null.");
        }
        try {
            return (ItemCreator) ITEM_CREATOR_PAPER_OF_MATERIAL.invoke(null, material);
        } catch (IllegalAccessException |InvocationTargetException e) {
            throw new DAPIException("Failed to invoke ItemCreatorPaper method.");
        }
    }
}
