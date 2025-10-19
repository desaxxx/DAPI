package org.nandayo.dapi.util;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.model.MiniString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class ItemCreator {

    private final @NotNull ItemStack itemStack;
    private final @Nullable ItemMeta meta;

    public ItemCreator(ItemStack itemStack) {
        Validate.validate(itemStack != null, "ItemStack cannot be null!");
        this.itemStack = itemStack.clone();
        this.meta = this.itemStack.getItemMeta();
    }

    /**
     * Get ItemCreator from item stack.
     * @param itemStack ItemStack
     * @return new ItemCreator
     */
    public static ItemCreator of(ItemStack itemStack) {
        return new ItemCreator(itemStack);
    }

    /**
     * Get ItemCreator from a material.
     * @param material Material
     * @return new ItemCreator
     */
    public static ItemCreator of(Material material) {
        Validate.validate(material != null, "Material cannot be null!");
        return new ItemCreator(new ItemStack(material));
    }

    /**
     * Check if the item stack has a valid meta.
     * @return Whether it has meta or not
     */
    private boolean hasMeta() {
        return meta != null;
    }

    /**
     * Get the built item stack.
     * @return ItemStack
     */
    public ItemStack get() {
        if(hasMeta()) {
            itemStack.setItemMeta(meta);
        }
        return itemStack;
    }

    /**
     * Set amount of the item stack.
     * @param amount Integer
     * @return ItemCreator
     */
    public ItemCreator amount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    /**
     * Set name of the item stack.
     * @param name String
     * @return ItemCreator
     */
    public ItemCreator name(@Nullable String name) {
        if(hasMeta()) {
            meta.setDisplayName(name == null ? null : HexUtil.parse(name));
        }
        return this;
    }

    /**
     * Set name of the item stack using supplier.
     * @param nameSupplier Supplier of String
     * @return ItemCreator
     */
    public ItemCreator name(Supplier<@Nullable String> nameSupplier) {
        Validate.validate(nameSupplier != null, "Name supplier cannot be null!");
        return name(nameSupplier.get());
    }

    /**
     * Set name of the item stack using component.
     * <b>NOTE:</b> This will silently fail if the server is not on running Paper or any of its fork.
     * @param name Component
     * @return ItemCreator.
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator namePaper(@Nullable Object name) {
        return this;
    }

    /**
     * Set name of the item stack using component.
     * <b>NOTE:</b> This will silently fail if the server is not on running Paper or any of its fork.
     * @param nameSupplier Supplier of Component
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator namePaper(Supplier<@Nullable Object> nameSupplier) {
        Validate.validate(nameSupplier != null, "Name supplier cannot be null!");
        return namePaper(nameSupplier.get());
    }

    /**
     * Set name of the item stack using MiniString.
     * @param name MiniString
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator nameMini(@Nullable MiniString name) {
        return name(name == null ? null : name.colorize(ColorizeType.LEGACY).getRawText());
    }

    /**
     * Set name of the item stack using MiniString.
     * @param name Supplier of MiniString
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator nameMini(Supplier<@Nullable MiniString> name) {
        Validate.validate(name != null, "Name supplier cannot be null!");
        return nameMini(name.get());
    }

    /**
     * Set lore of the item stack.
     * @param lore String list
     * @return ItemCreator
     */
    public ItemCreator lore(@Nullable List<String> lore) {
        if(hasMeta()) {
            if(lore == null) {
                meta.setLore(null);
            }else {
                List<String> newLore = new ArrayList<>(lore);
                newLore.replaceAll(HexUtil::parse);
                meta.setLore(newLore);
            }
        }
        return this;
    }

    /**
     * Set lore of the item stack.
     * @param lore Strings
     * @return ItemCreator
     */
    public ItemCreator lore(String @Nullable... lore) {
        return lore(lore == null ? null : List.of(lore));
    }

    /**
     * Set lore of the item stack using supplier.
     * @param loreSupplier Supplier of String list
     * @return ItemCreator
     */
    public ItemCreator lore(Supplier<@Nullable List<String>> loreSupplier) {
        return lore(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * Set lore of the item stack using list of component.<br>
     * <b>NOTE:</b> This will silently fail if the server is not on running Paper or any of its fork.
     * @param lore Component list
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator lorePaper(@Nullable List<Object> lore) {
        return this;
    }

    /**
     * Set lore of the item stack using component.
     * <b>NOTE:</b> This will silently fail if the server is not on running Paper or any of its fork.
     * @param lore Components
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator lorePaper(Object @Nullable... lore) {
        return lorePaper(lore == null ? null : List.of(lore));
    }

    /**
     * Set lore of the item stack using component supplier.
     * <b>NOTE:</b> This will silently fail if the server is not on running Paper or any of its fork.
     * @param loreSupplier Supplier of Component list
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator lorePaper(Supplier<@Nullable List<Object>> loreSupplier) {
        return lorePaper(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * Set lore of the item stack using MiniStrings.
     * @param lore String list
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator loreMini(@Nullable List<MiniString> lore) {
        return lore(lore == null ? null : lore.stream().map(ms -> ms == null ? null : ms.colorize(ColorizeType.LEGACY).getRawText()).collect(Collectors.toList()));
    }

    /**
     * Set lore of the item stack using MiniString.
     * @param lore Components
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator loreMini(MiniString @Nullable... lore) {
        return loreMini(lore == null ? null : List.of(lore));
    }

    /**
     * Set lore of the item stack using MiniString supplier.
     * @param loreSupplier Supplier of Component list
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator loreMini(Supplier<@Nullable List<MiniString>> loreSupplier) {
        return loreMini(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * Add lines to lore of the item stack.
     * @param lore String list
     * @return ItemCreator
     */
    public ItemCreator addLore(List<String> lore) {
        Validate.validate(lore != null, "Lore to be added cannot be null!");
        if(hasMeta()) {
            List<String> existingLore = meta.getLore() != null ? new ArrayList<>(meta.getLore()) : new ArrayList<>();
            List<String> newLore = new ArrayList<>(lore);
            newLore.replaceAll(HexUtil::parse);
            existingLore.addAll(newLore);
            meta.setLore(existingLore);
        }
        return this;
    }

    /**
     * Add lines to lore of the item stack.
     * @param lore Strings
     * @return ItemCreator
     */
    public ItemCreator addLore(String... lore) {
        return addLore(List.of(lore));
    }

    /**
     * Add lines to lore of the item stack using supplier.
     * @param loreSupplier Supplier of String List
     * @return ItemCreator
     */
    public ItemCreator addLore(Supplier<List<String>> loreSupplier) {
        return addLore(loreSupplier == null ? null : loreSupplier.get().toArray(new String[0]));
    }

    /**
     * Add lines to lore of the item stack.
     * <b>NOTE:</b> This will silently fail if the server is not on running Paper or any of its fork.
     * @param lore Component list
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator addLorePaper(List<Object> lore) {
        Validate.validate(lore != null, "Lore to be added cannot be null!");
        return this;
    }

    /**
     * Add lines to lore of the item stack.
     * <b>NOTE:</b> This will silently fail if the server is not on running Paper or any of its fork.
     * @param lore Components
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator addLorePaper(Object... lore) {
        return addLorePaper(List.of(lore));
    }

    /**
     * Add lines to lore of the item stack using supplier.
     * <b>NOTE:</b> This will silently fail if the server is not on running Paper or any of its fork.
     * @param loreSupplier Supplier of Component List
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator addLorePaper(Supplier<List<Object>> loreSupplier) {
        return addLorePaper(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * Add lines to lore of the item stack.
     * @param lore MiniString list
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator addLoreMini(List<MiniString> lore) {
        return addLore(lore.stream().map(ms -> ms == null ? null : ms.colorize(ColorizeType.LEGACY).getRawText()).collect(Collectors.toList()));
    }

    /**
     * Add lines to lore of the item stack.
     * @param lore MiniStrings
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator addLoreMini(MiniString... lore) {
        return addLoreMini(List.of(lore));
    }

    /**
     * Add lines to lore of the item stack using supplier.
     * @param loreSupplier Supplier of MiniMessage List
     * @return ItemCreator
     */
    @Deprecated(since = "1.4.0")
    public ItemCreator addLoreMini(Supplier<List<MiniString>> loreSupplier) {
        return addLoreMini(loreSupplier == null ? new ArrayList<>() : loreSupplier.get());
    }

    /**
     * Enchant the item stack.
     * @param enchantment Enchantment
     * @param level Integer
     * @return ItemCreator
     */
    public ItemCreator enchant(Enchantment enchantment, int level) {
        Validate.validate(enchantment != null, "Enchantment cannot be null!");
        if(hasMeta()) {
            meta.addEnchant(enchantment, level, true);
        }
        return this;
    }

    /**
     * Hide flags of the item stack.
     * @param flags ItemFlag
     * @return ItemCreator
     */
    public ItemCreator flags(ItemFlag... flags) {
        Validate.validate(flags != null, "Flags cannot be null!");
        if(hasMeta()) {
            if(List.of(flags).contains(ItemFlag.HIDE_ATTRIBUTES)) {
                Attribute armorAttribute = Wrapper.getArmorAttribute();
                AttributeModifier attributeModifier = Wrapper.getArmorAttributeModifier();
                if(armorAttribute != null && attributeModifier != null) {
                    meta.addAttributeModifier(armorAttribute, attributeModifier);
                }
            }
            meta.addItemFlags(flags);
        }
        return this;
    }

    /**
     * Set the item stack unbreakable.
     * @param unbreakable boolean
     * @return ItemCreator
     */
    public ItemCreator unbreakable(boolean unbreakable) {
        if(hasMeta()) {
            meta.setUnbreakable(unbreakable);
        }
        return this;
    }

    /**
     * Set the base potion of item stack.
     * @param potionType PotionType
     * @param color Color
     * @return ItemCreator
     */
    public ItemCreator potion(@Nullable PotionType potionType, @Nullable Color color) {
        if(hasMeta() && meta instanceof PotionMeta) {
            PotionMeta potionMeta = (PotionMeta) meta;
            Wrapper.editPotionMeta(potionMeta, potionType, color);
        }
        return this;
    }

    /**
     * Set the base potion of item stack.
     * @param potionType PotionType
     * @return ItemCreator
     */
    public ItemCreator potion(@Nullable PotionType potionType) {
        if(hasMeta() && meta instanceof PotionMeta) {
            PotionMeta potionMeta = (PotionMeta) meta;
            return potion(potionType, potionMeta.getColor());
        }
        return this;
    }
}
