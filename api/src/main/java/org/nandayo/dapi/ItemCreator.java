package org.nandayo.dapi;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
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
import org.nandayo.dapi.service.Platform;
import org.nandayo.dapi.util.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class ItemCreator {
    static private final MiniMessage miniMessage = DAPI.getMiniMessage();

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
    static public ItemCreator of(ItemStack itemStack) {
        return new ItemCreator(itemStack);
    }

    /**
     * Get ItemCreator from a material.
     * @param material Material
     * @return new ItemCreator
     */
    static public ItemCreator of(Material material) {
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
            //noinspection deprecation
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
     * <b>NOTE:</b> This will lead to {@link #name(String)} with MiniMessage serializer if the server
     * is not running on Paper or any of its fork.
     * @param name Component
     * @return ItemCreator.
     */
    public ItemCreator namePaper(@Nullable Component name) {
        if(hasMeta()) {
            if(!Platform.isPaperFork()) {
                return name(name == null ? null : miniMessage.serialize(name));
            }
            meta.displayName(name);
        }
        return this;
    }

    /**
     * Set name of the item stack using component.
     * <b>NOTE:</b> This will lead to {@link #name(String)} with MiniMessage serializer if the server
     * is not running on Paper or any of its fork.
     * @param nameSupplier Supplier of Component
     * @return ItemCreator
     */
    public ItemCreator namePaper(Supplier<@Nullable Component> nameSupplier) {
        Validate.validate(nameSupplier != null, "Name supplier cannot be null!");
        return namePaper(nameSupplier.get());
    }

    /**
     * Set name of the item stack using MiniString.
     * @param name MiniString
     * @return ItemCreator
     */
    public ItemCreator nameMini(@Nullable MiniString name) {
        if(Platform.isPaperFork()) {
            return namePaper(name == null ? null : name.colorize(ColorizeType.MINI_MESSAGE).asComponent());
        }else {
            return name(name == null ? null : name.colorize(ColorizeType.LEGACY).getRawText());
        }
    }

    /**
     * Set name of the item stack using MiniString.
     * @param name Supplier of MiniString
     * @return ItemCreator
     */
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
                //noinspection deprecation
                meta.setLore(null);
            }else {
                List<String> newLore = new ArrayList<>(lore);
                newLore.replaceAll(HexUtil::parse);
                //noinspection deprecation
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
     * <b>NOTE:</b> This will lead to {@link #lore(List)} with MiniMessage serializer if the server
     * is not running on Paper or any of its fork.
     * @param lore Component list
     * @return ItemCreator
     */
    public ItemCreator lorePaper(@Nullable List<Component> lore) {
        if(hasMeta()) {
            if(!Platform.isPaperFork()) {
                return lore(lore == null ? null : lore.stream().map(l -> l == null ? null : miniMessage.serialize(l)).collect(Collectors.toList()));
            }
            meta.lore(lore);
        }
        return this;
    }

    /**
     * Set lore of the item stack using component.
     * <b>NOTE:</b> This will lead to {@link #lore(List)} with MiniMessage serializer if the server
     * is not running on Paper or any of its fork.
     * @param lore Components
     * @return ItemCreator
     */
    public ItemCreator lorePaper(Component @Nullable... lore) {
        return lorePaper(lore == null ? null : List.of(lore));
    }

    /**
     * Set lore of the item stack using component supplier.
     * <b>NOTE:</b> This will lead to {@link #lore(List)} with MiniMessage serializer if the server
     * is not running on Paper or any of its fork.
     * @param loreSupplier Supplier of Component list
     * @return ItemCreator
     */
    public ItemCreator lorePaper(Supplier<@Nullable List<Component>> loreSupplier) {
        return lorePaper(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * Set lore of the item stack using MiniStrings.
     * @param lore String list
     * @return ItemCreator
     */
    public ItemCreator loreMini(@Nullable List<MiniString> lore) {
        if(Platform.isPaperFork()) {
            return lorePaper(lore == null ? null : lore.stream().map(ms -> ms == null ? null : ms.colorize(ColorizeType.MINI_MESSAGE).asComponent()).collect(Collectors.toList()));
        }else {
            return lore(lore == null ? null : lore.stream().map(ms -> ms == null ? null : ms.colorize(ColorizeType.LEGACY).getRawText()).collect(Collectors.toList()));
        }
    }

    /**
     * Set lore of the item stack using MiniString.
     * @param lore Components
     * @return ItemCreator
     */
    public ItemCreator loreMini(MiniString @Nullable... lore) {
        return loreMini(lore == null ? null : List.of(lore));
    }

    /**
     * Set lore of the item stack using MiniString supplier.
     * @param loreSupplier Supplier of Component list
     * @return ItemCreator
     */
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
            //noinspection deprecation
            List<String> existingLore = meta.getLore() != null ? new ArrayList<>(meta.getLore()) : new ArrayList<>();
            List<String> newLore = new ArrayList<>(lore);
            newLore.replaceAll(HexUtil::parse);
            existingLore.addAll(newLore);
            //noinspection deprecation
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
     * <b>NOTE:</b> This will lead to {@link #addLore(List)} with MiniMessage serializer if the server
     * is not running on Paper or any of its fork.
     * @param lore Component list
     * @return ItemCreator
     */
    public ItemCreator addLorePaper(List<Component> lore) {
        Validate.validate(lore != null, "Lore to be added cannot be null!");
        if(hasMeta()) {
            if(!Platform.isPaperFork()) {
                return addLore(lore.stream().map(l -> l == null ? null : miniMessage.serialize(l)).collect(Collectors.toList()));
            }

            List<Component> existingLore = meta.lore() != null ? new ArrayList<>(meta.lore()) : new ArrayList<>();
            List<Component> newLore = new ArrayList<>(lore);
            existingLore.addAll(newLore);
            meta.lore(existingLore);
        }
        return this;
    }

    /**
     * Add lines to lore of the item stack.
     * <b>NOTE:</b> This will lead to {@link #addLore(List)} with MiniMessage serializer if the server
     * is not running on Paper or any of its fork.
     * @param lore Components
     * @return ItemCreator
     */
    public ItemCreator addLorePaper(Component... lore) {
        return addLorePaper(List.of(lore));
    }

    /**
     * Add lines to lore of the item stack using supplier.
     * <b>NOTE:</b> This will lead to {@link #addLore(List)} with MiniMessage serializer if the server
     * is not running on Paper or any of its fork.
     * @param loreSupplier Supplier of Component List
     * @return ItemCreator
     */
    public ItemCreator addLorePaper(Supplier<List<Component>> loreSupplier) {
        return addLorePaper(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * Add lines to lore of the item stack.
     * @param lore MiniString list
     * @return ItemCreator
     */
    public ItemCreator addLoreMini(List<MiniString> lore) {
        Validate.validate(lore != null, "Lore to be added cannot be null!");
        if(Platform.isPaperFork()) {
            return addLorePaper(lore.stream().map(ms -> ms == null ? null : ms.colorize(ColorizeType.MINI_MESSAGE).asComponent()).collect(Collectors.toList()));
        }else {
            return addLore(lore.stream().map(ms -> ms == null ? null : ms.colorize(ColorizeType.LEGACY).getRawText()).collect(Collectors.toList()));
        }
    }

    /**
     * Add lines to lore of the item stack.
     * @param lore MiniStrings
     * @return ItemCreator
     */
    public ItemCreator addLoreMini(MiniString... lore) {
        return addLoreMini(List.of(lore));
    }

    /**
     * Add lines to lore of the item stack using supplier.
     * @param loreSupplier Supplier of MiniMessage List
     * @return ItemCreator
     */
    public ItemCreator addLoreMini(Supplier<List<MiniString>> loreSupplier) {
        return addLoreMini(loreSupplier == null ? null : loreSupplier.get());
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
