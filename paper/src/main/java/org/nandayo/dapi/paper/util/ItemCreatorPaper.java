package org.nandayo.dapi.paper.util;

import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.model.MiniString;
import org.nandayo.dapi.util.ItemCreator;
import org.nandayo.dapi.util.Validate;

import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public interface ItemCreatorPaper extends ItemCreator {

    /**
     * Create a builder with specified foundation.
     *
     * @param itemStack foundation item stack
     * @return new ItemCreatorPaper
     */
    @NotNull
    static ItemCreatorPaper of(@NotNull ItemStack itemStack) {
        return new ItemCreatorPaperImpl(itemStack);
    }

    /**
     * Create a builder with specified foundation.
     *
     * @param material foundation material
     * @return new ItemCreatorPaper
     */
    @NotNull
    static ItemCreatorPaper of(@NotNull Material material) {
        Validate.notNull(material, "Material cannot be null!");
        return new ItemCreatorPaperImpl(new ItemStack(material));
    }

    @Override
    boolean hasMeta();

    @Override
    @NotNull
    default ItemStack get() {
        return build();
    }

    @Override
    @NotNull ItemStack build();

    @Override
    @NotNull ItemCreatorPaper amount(int amount);

    @Override
    @NotNull ItemCreatorPaper name(@Nullable String name);

    @Override
    @NotNull ItemCreatorPaper name(@NotNull Supplier<String> nameSupplier);

    @Override
    @NotNull ItemCreatorPaper replaceInName(String @NotNull ... strings);

    @Override
    @NotNull ItemCreatorPaper namePaper(@Nullable Object name);

    @Override
    @NotNull ItemCreatorPaper namePaper(@NotNull Supplier<Object> nameSupplier);

    @Override
    @NotNull ItemCreatorPaper nameMini(@Nullable MiniString name);

    @Override
    @NotNull ItemCreatorPaper nameMini(@NotNull Supplier<MiniString> name);

    @Override
    @NotNull ItemCreatorPaper lore(@Nullable List<String> lore);

    @Override
    @NotNull ItemCreatorPaper lore(String @Nullable ... lore);

    @Override
    @NotNull ItemCreatorPaper lore(@Nullable Supplier<List<String>> loreSupplier);

    @Override
    @NotNull ItemCreatorPaper lorePaper(@Nullable List<Object> lore);

    @Override
    @NotNull ItemCreatorPaper lorePaper(Object @Nullable ... lore);

    @Override
    @NotNull ItemCreatorPaper lorePaper(@Nullable Supplier<List<Object>> loreSupplier);

    @Override
    @NotNull ItemCreatorPaper loreMini(@Nullable List<MiniString> lore);

    @Override
    @NotNull ItemCreatorPaper loreMini(MiniString @Nullable ... lore);

    @Override
    @NotNull ItemCreatorPaper loreMini(@Nullable Supplier<List<MiniString>> loreSupplier);

    @Override
    @NotNull ItemCreatorPaper addLore(@NotNull List<String> lore);

    @Override
    @NotNull ItemCreatorPaper addLore(String @NotNull ... lore);

    @Override
    @NotNull ItemCreatorPaper addLore(@Nullable Supplier<List<String>> loreSupplier);

    @Override
    @NotNull ItemCreatorPaper addLorePaper(@NotNull List<Object> lore);

    @Override
    @NotNull ItemCreatorPaper addLorePaper(Object @NotNull ... lore);

    @Override
    @NotNull ItemCreatorPaper addLorePaper(@Nullable Supplier<List<Object>> loreSupplier);

    @Override
    @NotNull ItemCreatorPaper addLoreMini(@NotNull List<MiniString> lore);

    @Override
    @NotNull ItemCreatorPaper addLoreMini(MiniString @NotNull ... lore);

    @Override
    @NotNull ItemCreatorPaper addLoreMini(@Nullable Supplier<List<MiniString>> loreSupplier);

    @Override
    @NotNull ItemCreatorPaper replaceInLore(String @NotNull ... strings);

    @Override
    @NotNull ItemCreatorPaper replaceInNameAndLore(String @NotNull ... strings);

    @Override
    @NotNull ItemCreatorPaper enchant(@NotNull Enchantment enchantment, int level);

    @Override
    @NotNull ItemCreatorPaper flags(ItemFlag @NotNull ... flags);

    @Override
    @NotNull ItemCreatorPaper unbreakable(boolean unbreakable);

    @Override
    @NotNull ItemCreator enchantmentGlintOverride(boolean b);

    @Override
    @NotNull ItemCreatorPaper potion(@Nullable PotionType potionType, @Nullable Color color);

    @Override
    @NotNull ItemCreatorPaper potion(@Nullable PotionType potionType);

    /**
     * Set name of the item stack.
     *
     * @param name new name
     * @return ItemCreatorPaper
     */
    @NotNull ItemCreatorPaper name(@Nullable Component name);

    /**
     * Set name of the item stack.
     *
     * @param nameSupplier new name supplier
     * @return ItemCreatorPaper
     */
    @NotNull ItemCreatorPaper nameSup(@NotNull Supplier<Component> nameSupplier);

    /**
     * Set lore of the item stack.
     *
     * @param lore new lore
     * @return ItemCreatorPaper
     */
    @NotNull ItemCreatorPaper loreList(@Nullable List<Component> lore);

    /**
     * Set lore of the item stack.
     *
     * @param lore new lore
     * @return ItemCreatorPaper
     */
    @NotNull ItemCreatorPaper lore(Component @Nullable... lore);

    /**
     * Set lore of the item stack.
     *
     * @param loreSupplier new lore supplier
     * @return ItemCreatorPaper
     */
    @NotNull ItemCreatorPaper loreSup(@Nullable Supplier<List<Component>> loreSupplier);

    /**
     * Add lines to lore of the item stack.
     *
     * @param lore new lines
     * @return ItemCreatorPaper
     */
    @NotNull ItemCreatorPaper addLoreList(@NotNull List<Component> lore);

    /**
     * Add lines to lore of the item stack.
     *
     * @param lore new lines
     * @return ItemCreatorPaper
     */
    @NotNull ItemCreatorPaper addLore(Component @NotNull... lore);

    /**
     * Add lines to lore of the item stack.
     *
     * @param loreSupplier new lines supplier
     * @return ItemCreatorPaper
     */
    @NotNull ItemCreatorPaper addLoreSup(@Nullable Supplier<List<Component>> loreSupplier);
}
