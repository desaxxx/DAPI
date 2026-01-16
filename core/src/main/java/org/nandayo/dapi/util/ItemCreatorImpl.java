package org.nandayo.dapi.util;

import org.bukkit.Color;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.model.MiniString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
class ItemCreatorImpl implements ItemCreator {

    private final @NotNull ItemStack itemStack;
    private final ItemMeta meta;
    private boolean autoColorize = true;

    ItemCreatorImpl(@NotNull ItemStack itemStack) {
        Validate.notNull(itemStack, "ItemStack cannot be null!");
        this.itemStack = itemStack.clone();
        this.meta = this.itemStack.getItemMeta();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Contract(pure = true)
    public boolean hasMeta() {
        return meta != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemStack build() {
        if(hasMeta()) {
            itemStack.setItemMeta(meta);
        }
        return itemStack;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull ItemCreator autoColorize(boolean autoColorize) {
        this.autoColorize = autoColorize;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull ItemCreator autoDisableItalic(boolean autoDisableItalic) {
        return this;
    }

    private String colorize(String str) {
        return str == null || !autoColorize ? str : HexUtil.parse(str);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator amount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator name(@Nullable String name) {
        if(hasMeta()) {
            meta.setDisplayName(name == null ? null : colorize(name));
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator name(@NotNull Supplier<String> nameSupplier) {
        Validate.notNull(nameSupplier, "Name supplier cannot be null!");
        return name(nameSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator replaceInName(String @NotNull... strings) {
        if(hasMeta()) {
            String name = meta.getDisplayName();

            int limit = (strings.length / 2) * 2;
            for (int i = 0; i < limit; i += 2) {
                String find = strings[i];
                String replace = strings[i + 1];

                if (find != null && replace != null) {
                    name = name.replace(find, replace);
                }
            }
            this.name(name);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator namePaper(@Nullable Object name) {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator namePaper(@NotNull Supplier<Object> nameSupplier) {
        Validate.notNull(nameSupplier, "Name supplier cannot be null!");
        return namePaper(nameSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator nameMini(@Nullable MiniString name) {
        return name(name == null ? null : name.colorize(ColorizeType.LEGACY).getRawText());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator nameMini(@NotNull Supplier<MiniString> name) {
        Validate.notNull(name, "Name supplier cannot be null!");
        return nameMini(name.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator lore(@Nullable List<String> lore) {
        if(hasMeta()) {
            if(lore == null) {
                meta.setLore(null);
            }else {
                List<String> newLore = new ArrayList<>(lore);
                newLore.replaceAll(this::colorize);
                meta.setLore(newLore);
            }
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator lore(String @Nullable... lore) {
        return lore(lore == null ? null : List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator lore(@Nullable Supplier<List<String>> loreSupplier) {
        return lore(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator lorePaper(@Nullable List<Object> lore) {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator lorePaper(Object @Nullable... lore) {
        return lorePaper(lore == null ? null : List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator lorePaper(@Nullable Supplier<List<Object>> loreSupplier) {
        return lorePaper(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator loreMini(@Nullable List<MiniString> lore) {
        return lore(lore == null ? null : lore.stream().map(ms -> ms == null ? null : ms.colorize(ColorizeType.LEGACY).getRawText()).collect(Collectors.toList()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator loreMini(MiniString @Nullable... lore) {
        return loreMini(lore == null ? null : List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator loreMini(@Nullable Supplier<List<MiniString>> loreSupplier) {
        return loreMini(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator addLore(@NotNull List<String> lore) {
        Validate.notNull(lore, "Lore to be added cannot be null!");
        if(hasMeta()) {
            List<String> existingLore = meta.getLore() != null ? new ArrayList<>(meta.getLore()) : new ArrayList<>();
            List<String> newLore = new ArrayList<>(lore);
            newLore.replaceAll(this::colorize);
            existingLore.addAll(newLore);
            meta.setLore(existingLore);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator addLore(String @NotNull... lore) {
        return addLore(List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator addLore(@Nullable Supplier<List<String>> loreSupplier) {
        return addLore(loreSupplier == null ? new String[0] : loreSupplier.get().toArray(new String[0]));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator addLorePaper(@NotNull List<Object> lore) {
        Validate.notNull(lore, "Lore to be added cannot be null!");
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator addLorePaper(Object @NotNull... lore) {
        return addLorePaper(List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator addLorePaper(@Nullable Supplier<List<Object>> loreSupplier) {
        return addLorePaper(loreSupplier == null ? List.of() : loreSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator addLoreMini(@NotNull List<MiniString> lore) {
        Validate.notNull(lore, "Lore to be added cannot be null!");
        return addLore(lore.stream().map(ms -> ms == null ? null : ms.colorize(ColorizeType.LEGACY).getRawText()).collect(Collectors.toList()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator addLoreMini(MiniString @NotNull... lore) {
        return addLoreMini(List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreator addLoreMini(@Nullable Supplier<List<MiniString>> loreSupplier) {
        return addLoreMini(loreSupplier == null ? new ArrayList<>() : loreSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator replaceInLore(String @NotNull... strings) {
        if(hasMeta()) {
            List<String> lore = meta.getLore();
            if(lore == null) {
                return this;
            }

            int limit = (strings.length / 2) * 2;
            for (int i = 0; i < limit; i += 2) {
                String find = strings[i];
                String replace = strings[i + 1];

                if (find != null && replace != null) {
                    lore.replaceAll(line -> line.replace(find, replace));
                }
            }
            this.lore(lore);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator replaceInNameAndLore(String @NotNull... strings) {
        if(hasMeta()) {
            String name = meta.getDisplayName();
            List<String> lore = meta.getLore();

            int limit = (strings.length / 2) * 2;
            for (int i = 0; i < limit; i += 2) {
                String find = strings[i];
                String replace = strings[i + 1];
                if (find != null && replace != null) {
                    name = name.replace(find, replace);
                    if(lore != null) {
                        lore.replaceAll(line -> line.replace(find, replace));
                    }
                }
            }
            this.name(name);
            this.lore(lore);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator enchant(@NotNull Enchantment enchantment, int level) {
        Validate.notNull(enchantment, "Enchantment cannot be null!");
        if(hasMeta()) {
            meta.addEnchant(enchantment, level, true);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator flags(ItemFlag @NotNull... flags) {
        Validate.notNull(flags, "Flags cannot be null!");
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
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator unbreakable(boolean unbreakable) {
        if(hasMeta()) {
            meta.setUnbreakable(unbreakable);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull ItemCreator enchantmentGlintOverride(boolean b) {
        if (hasMeta() && Wrapper.getMinecraftVersion() >= 2005) {
            meta.setEnchantmentGlintOverride(b);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator potion(@Nullable PotionType potionType, @Nullable Color color) {
        if(hasMeta() && meta instanceof PotionMeta) {
            PotionMeta potionMeta = (PotionMeta) meta;
            Wrapper.editPotionMeta(potionMeta, potionType, color);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreator potion(@Nullable PotionType potionType) {
        if(hasMeta() && meta instanceof PotionMeta) {
            PotionMeta potionMeta = (PotionMeta) meta;
            return potion(potionType, potionMeta.getColor());
        }
        return this;
    }

}
