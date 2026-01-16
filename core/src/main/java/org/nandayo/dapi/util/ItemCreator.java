package org.nandayo.dapi.util;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.model.MiniString;

import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public interface ItemCreator {

    /**
     * Create a builder with specified foundation.
     *
     * @param itemStack foundation item stack
     * @return new ItemCreator
     */
    @NotNull
    static ItemCreator of(@NotNull ItemStack itemStack) {
        return new ItemCreatorImpl(itemStack);
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
        return new ItemCreatorImpl(new ItemStack(material));
    }


    /**
     * Check if the item stack has an item meta.
     *
     * @return whether it has meta or not
     */
    @Contract(pure = true)
    boolean hasMeta();

    /**
     * Get the built item stack.
     *
     * @return built item stack
     */
    @NotNull
    @ApiStatus.Obsolete(since = "1.5.2")
    default ItemStack get() {
        return build();
    }

    /**
     * Get the built item stack.
     *
     * @return built item stack
     */
    @NotNull ItemStack build();

    /**
     * Set auto colorization option.
     * <br>
     * This option uses {@link HexUtil#parse(String)} for colorizing name and lore.
     *
     * @param autoColorize colorize
     * @return ItemCreator
     * @since 1.5.3
     */
    @NotNull ItemCreator autoColorize(boolean autoColorize);

    /**
     * Set amount of the item stack.
     *
     * @param amount new amount
     * @return ItemCreator
     */
    @NotNull ItemCreator amount(int amount);

    /**
     * Set name of the item stack.
     *
     * @param name new name
     * @return ItemCreator
     */
    @NotNull ItemCreator name(@Nullable String name);

    /**
     * Set name of the item stack.
     *
     * @param nameSupplier new name supplier
     * @return ItemCreator
     */
    @NotNull ItemCreator name(@NotNull Supplier<String> nameSupplier);

    /**
     * Replaces text in the item's display name.
     * <p>
     * This method takes a variable number of strings, interpreting them as
     * "find-and-replace" pairs. For example, calling
     * {@code replaceInName("a", "b", "c", "d")} would replace all occurrences
     * of "a" with "b", and then all occurrences of "c" with "d".
     * <p>
     * The replacements are applied sequentially. If an odd number of arguments
     * is provided, the final string will be ignored.
     * 
     * @param strings A vararg list of find-and-replace pairs.
     * @return ItemCreator
     * @since 1.5.1
     */
    @NotNull ItemCreator replaceInName(String @NotNull... strings);

    /**
     * Set name of the item stack using component.
     * <p>
     * This will silently fail if the server is not on running Paper or any of its fork.
     * 
     * @param name new name component
     * @return ItemCreator.
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator namePaper(@Nullable Object name);

    /**
     * Set name of the item stack using component.
     * <p>
     * This will silently fail if the server is not on running Paper or any of its fork.
     * 
     * @param nameSupplier new name component supplier
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator namePaper(@NotNull Supplier<Object> nameSupplier);

    /**
     * Set name of the item stack.
     *
     * @param name new name mini string
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator nameMini(@Nullable MiniString name);

    /**
     * Set name of the item stack.
     *
     * @param name new name mini string supplier
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator nameMini(@NotNull Supplier<MiniString> name);

    /**
     * Set lore of the item stack.
     *
     * @param lore new lore
     * @return ItemCreator
     */
    @NotNull ItemCreator lore(@Nullable List<String> lore);

    /**
     * Set lore of the item stack.
     *
     * @param lore new lore
     * @return ItemCreator
     */
    @NotNull ItemCreator lore(String @Nullable... lore);

    /**
     * Set lore of the item stack.
     *
     * @param loreSupplier new lore supplier
     * @return ItemCreator
     */
    @NotNull ItemCreator lore(@Nullable Supplier<List<String>> loreSupplier);

    /**
     * Set lore of the item stack.
     * <p>
     * This will silently fail if the server is not on running Paper or any of its fork.
     *
     * @param lore new component lore
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator lorePaper(@Nullable List<Object> lore);

    /**
     * Set lore of the item stack.
     * <p>
     * This will silently fail if the server is not on running Paper or any of its fork.
     *
     * @param lore new component lore
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator lorePaper(Object @Nullable... lore);

    /**
     * Set lore of the item stack.
     * <p>
     * This will silently fail if the server is not on running Paper or any of its fork.
     *
     * @param loreSupplier new component lore supplier
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator lorePaper(@Nullable Supplier<List<Object>> loreSupplier);

    /**
     * Set lore of the item stack.
     *
     * @param lore new mini string lore
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator loreMini(@Nullable List<MiniString> lore);

    /**
     * Set lore of the item stack.
     *
     * @param lore new mini string lore
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator loreMini(MiniString @Nullable... lore);

    /**
     * Set lore of the item stack.
     *
     * @param loreSupplier new mini string lore supplier
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator loreMini(@Nullable Supplier<List<MiniString>> loreSupplier);

    /**
     * Add lines to lore of the item stack.
     *
     * @param lore new lines
     * @return ItemCreator
     */
    @NotNull ItemCreator addLore(@NotNull List<String> lore);

    /**
     * Add lines to lore of the item stack.
     *
     * @param lore new lines
     * @return ItemCreator
     */
    @NotNull ItemCreator addLore(String @NotNull... lore);

    /**
     * Add lines to lore of the item stack.
     *
     * @param loreSupplier new lines supplier
     * @return ItemCreator
     */
    @NotNull ItemCreator addLore(@Nullable Supplier<List<String>> loreSupplier);

    /**
     * Add lines to lore of the item stack.
     * <p>
     * This will silently fail if the server is not on running Paper or any of its fork.
     *
     * @param lore new component lines
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator addLorePaper(@NotNull List<Object> lore);

    /**
     * Add lines to lore of the item stack.
     * <p>
     * This will silently fail if the server is not on running Paper or any of its fork.
     *
     * @param lore new component lines
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator addLorePaper(Object @NotNull... lore);

    /**
     * Add lines to lore of the item stack.
     * <p>
     * This will silently fail if the server is not on running Paper or any of its fork.
     *
     * @param loreSupplier new component lines supplier
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator addLorePaper(@Nullable Supplier<List<Object>> loreSupplier);

    /**
     * Add lines to lore of the item stack.
     *
     * @param lore new mini string lines
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator addLoreMini(@NotNull List<MiniString> lore);

    /**
     * Add lines to lore of the item stack.
     *
     * @param lore new mini string lines
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator addLoreMini(MiniString @NotNull... lore);

    /**
     * Add lines to lore of the item stack.
     *
     * @param loreSupplier new mini string lines supplier
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    @NotNull ItemCreator addLoreMini(@Nullable Supplier<List<MiniString>> loreSupplier);

    /**
     * Replaces texts in the item's lore.
     * <p>
     * This method takes a variable number of strings, interpreting them as
     * "find-and-replace" pairs. For example, calling
     * {@code replaceInLore("a", "b", "c", "d")} would replace all occurrences
     * of "a" with "b", and then all occurrences of "c" with "d".
     * <p>
     * The replacements are applied sequentially. If an odd number of arguments
     * is provided, the final string will be ignored.
     *
     * @param strings A vararg list of find-and-replace pairs.
     * @return ItemCreator
     * @since 1.5.1
     */
    @NotNull ItemCreator replaceInLore(String @NotNull... strings);

    /**
     * Replaces texts in the item's display name and lore.
     * <p>
     * This method takes a variable number of strings, interpreting them as
     * "find-and-replace" pairs. For example, calling
     * {@code replaceInNameAndLore("a", "b", "c", "d")} would replace all occurrences
     * of "a" with "b", and then all occurrences of "c" with "d".
     * <p>
     * The replacements are applied sequentially. If an odd number of arguments
     * is provided, the final string will be ignored.
     *
     * @param strings A vararg list of find-and-replace pairs.
     * @return ItemCreator
     * @since 1.5.1
     */
    @NotNull ItemCreator replaceInNameAndLore(String @NotNull... strings);

    /**
     * Enchant the item stack.
     *
     * @param enchantment enchantment
     * @param level enchantment level (no restriction)
     * @return ItemCreator
     */
    @NotNull ItemCreator enchant(@NotNull Enchantment enchantment, int level);

    /**
     * Add flags to item stack.
     *
     * @param flags new item flags
     * @return ItemCreator
     */
    @NotNull ItemCreator flags(ItemFlag @NotNull... flags);

    /**
     * Set the item stack unbreakable.
     *
     * @param unbreakable unbreakable
     * @return ItemCreator
     */
    @NotNull ItemCreator unbreakable(boolean unbreakable);

    /**
     * Set enchantments glint override for the item stack.
     * <br>
     * Silently fails if this field is absent in the item meta.
     *
     * @param b override state
     * @return ItemCreator
     * @since 1.5.3
     */
    @NotNull ItemCreator enchantmentGlintOverride(boolean b);

    /**
     * Set the base potion of item stack.
     *
     * @param potionType new potion type
     * @param color new color
     * @return ItemCreator
     */
    @NotNull ItemCreator potion(@Nullable PotionType potionType, @Nullable Color color);

    /**
     * Set the base potion of item stack.
     *
     * @param potionType new potion type
     * @return ItemCreator
     */
    @NotNull ItemCreator potion(@Nullable PotionType potionType);
}
