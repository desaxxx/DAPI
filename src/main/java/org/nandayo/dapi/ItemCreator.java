package org.nandayo.dapi;

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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ItemCreator {

    private final ItemStack itemStack;
    private final ItemMeta meta;

    public ItemCreator(@NotNull ItemStack itemStack) {
        this.itemStack = itemStack.clone();
        this.meta = this.itemStack.getItemMeta();
    }

    /**
     * Get ItemCreator from item stack.
     * @param itemStack ItemStack
     * @return new ItemCreator
     */
    static public ItemCreator of(@NotNull ItemStack itemStack) {
        return new ItemCreator(itemStack);
    }

    /**
     * Get ItemCreator from a material.
     * @param material Material
     * @return new ItemCreator
     */
    static public ItemCreator of(@NotNull Material material) {
        return new ItemCreator(new ItemStack(material));
    }

    /**
     * Get the built item stack.
     * @return ItemStack
     */
    public ItemStack get() {
        if(meta != null) {
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
        if(itemStack != null) {
            itemStack.setAmount(amount);
        }
        return this;
    }

    /**
     * Set name of the item stack.
     * @param name String
     * @return ItemCreator
     */
    public ItemCreator name(@NotNull String name) {
        if(meta != null) {
            meta.setDisplayName(HexUtil.parse(name));
        }
        return this;
    }

    /**
     * Set name of the item stack using supplier.
     * @param nameSupplier Supplier of String
     * @return ItemCreator
     */
    public ItemCreator name(@NotNull Supplier<String> nameSupplier) {
        return name(nameSupplier.get());
    }

    /**
     * Set lore of the item stack.
     * @param lore Strings
     * @return ItemCreator
     */
    public ItemCreator lore(@NotNull String... lore) {
        if(meta != null) {
            List<String> loreFix = new ArrayList<>();
            for(String line : lore) {
                loreFix.add(HexUtil.parse(line));
            }
            meta.setLore(loreFix);
        }
        return this;
    }

    /**
     * Set lore of the item stack.
     * @param lore String list
     * @return ItemCreator
     */
    public ItemCreator lore(@NotNull List<String> lore) {
        return lore(lore.toArray(new String[0]));
    }

    /**
     * Set lore of the item stack using supplier.
     * @param loreSupplier Supplier of String List
     * @return ItemCreator
     */
    public ItemCreator lore(@NotNull Supplier<List<String>> loreSupplier) {
        return lore(loreSupplier.get().toArray(new String[0]));
    }

    /**
     * Add lines to lore of the item stack.
     * @param lore Strings
     * @return ItemCreator
     */
    public ItemCreator addLore(@NotNull String... lore) {
        if(meta != null) {
            List<String> loreFix = meta.getLore() == null ? new ArrayList<>() : new ArrayList<>(meta.getLore());
            for(String line : lore) {
                loreFix.add(HexUtil.parse(line));
            }
            meta.setLore(loreFix);
        }
        return this;
    }

    /**
     * Add lines to lore of the item stack.
     * @param lore String list
     * @return ItemCreator
     */
    public ItemCreator addLore(@NotNull List<String> lore) {
        return addLore(lore.toArray(new String[0]));
    }

    /**
     * Add lines to lore of the item stack using supplier.
     * @param loreSupplier Supplier of String List
     * @return ItemCreator
     */
    public ItemCreator addLore(@NotNull Supplier<List<String>> loreSupplier) {
        return addLore(loreSupplier.get().toArray(new String[0]));
    }

    /**
     * Enchant the item stack.
     * @param enchantment Enchantment
     * @param level Integer
     * @return ItemCreator
     */
    public ItemCreator enchant(@NotNull Enchantment enchantment, int level) {
        if(meta != null) {
            meta.addEnchant(enchantment, level, true);
        }
        return this;
    }

    /**
     * Hide flags of the item stack.
     * @param flags ItemFlag
     * @return ItemCreator
     */
    public ItemCreator hideFlag(@NotNull ItemFlag... flags) {
        if(meta != null) {
            DAPI dapi = DAPI.getInstance();
            if(dapi != null) {
                Attribute armorAttribute = dapi.getWrapper().getAttribute();
                AttributeModifier attributeModifier = dapi.getWrapper().getAttributeModifier();
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
        if(meta != null) {
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
        if(meta != null && meta instanceof PotionMeta) {
            PotionMeta potionMeta = (PotionMeta) meta;
            DAPI dapi = DAPI.getInstance();
            if(dapi != null) {
                dapi.getWrapper().editPotionMeta(potionMeta, potionType, color);
            }
        }
        return this;
    }

    /**
     * Set the base potion of item stack.
     * @param potionType PotionType
     * @return ItemCreator
     */
    public ItemCreator potion(@Nullable PotionType potionType) {
        if(meta != null && meta instanceof PotionMeta) {
            PotionMeta potionMeta = (PotionMeta) meta;
            return potion(potionType, potionMeta.getColor());
        }
        return this;
    }
}
