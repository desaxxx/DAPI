package org.nandayo.dapi.paper.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
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
import org.nandayo.dapi.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class ItemCreatorPaperImpl implements ItemCreatorPaper {

    private final @NotNull ItemStack itemStack;
    private final ItemMeta meta;
    private boolean autoColorize;

    ItemCreatorPaperImpl(@NotNull ItemStack itemStack) {
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

    private String colorize(String str) {
        return str == null || !autoColorize ? str : HexUtil.parse(str);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper amount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper name(@Nullable String name) {
        if(hasMeta()) {
            if(name == null) {
                meta.displayName(null);
                return this;
            }

            String hexUtilResult = colorize(name);
            if(ReflectionUtil.MINIMESSAGE_AVAILABLE) {
                meta.displayName(MiniMessage.miniMessage().deserialize(hexUtilResult));
            }else {
                meta.displayName(LegacyComponentSerializer.legacySection().deserialize(hexUtilResult));
            }
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper name(@NotNull Supplier<String> nameSupplier) {
        Validate.notNull(nameSupplier, "Name supplier cannot be null!");
        return name(nameSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper replaceInName(String @NotNull... strings) {
        if(hasMeta()) {
            Component name = meta.displayName();
            if(name == null) {
                return this;
            }

            int limit = (strings.length / 2) * 2;
            for (int i = 0; i < limit; i += 2) {
                String find = strings[i];
                String replace = strings[i + 1];
                if (find != null && replace != null) {
                    name = name.replaceText(b -> b.matchLiteral(find).replacement(replace));
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
    public ItemCreatorPaper namePaper(@Nullable Object name) {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper namePaper(@NotNull Supplier<Object> nameSupplier) {
        Validate.notNull(nameSupplier, "Name supplier cannot be null!");
        return namePaper(nameSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper nameMini(@Nullable MiniString name) {
        return name(name == null ? null : name.colorize(ColorizeType.LEGACY).getRawText());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper nameMini(@NotNull Supplier<MiniString> name) {
        Validate.notNull(name, "Name supplier cannot be null!");
        return nameMini(name.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper lore(@Nullable List<String> lore) {
        if(hasMeta()) {
            if(lore == null) {
                meta.lore(null);
            }else {
                List<Component> newLore = new ArrayList<>();
                for(String s : lore) {

                    String hexUtilResult = colorize(s);
                    if(ReflectionUtil.MINIMESSAGE_AVAILABLE) {
                        newLore.add(MiniMessage.miniMessage().deserialize(hexUtilResult));
                    }else {
                        newLore.add(LegacyComponentSerializer.legacySection().deserialize(hexUtilResult));
                    }
                }
                meta.lore(newLore);
            }
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper lore(String @Nullable... lore) {
        return lore(lore == null ? null : List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper lore(@Nullable Supplier<List<String>> loreSupplier) {
        return lore(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper lorePaper(@Nullable List<Object> lore) {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper lorePaper(Object @Nullable... lore) {
        return lorePaper(lore == null ? null : List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper lorePaper(@Nullable Supplier<List<Object>> loreSupplier) {
        return lorePaper(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper loreMini(@Nullable List<MiniString> lore) {
        return lore(lore == null ? null : lore.stream().map(ms -> ms == null ? null : ms.colorize(ColorizeType.LEGACY).getRawText()).collect(Collectors.toList()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper loreMini(MiniString @Nullable... lore) {
        return loreMini(lore == null ? null : List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper loreMini(@Nullable Supplier<List<MiniString>> loreSupplier) {
        return loreMini(loreSupplier == null ? null : loreSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper addLore(@NotNull List<String> lore) {
        Validate.notNull(lore, "Lore to be added cannot be null!");
        if(hasMeta()) {
            List<Component> existingLore = meta.lore() != null ? new ArrayList<>(meta.lore()) : new ArrayList<>();
            List<Component> newLore = new ArrayList<>();
            for(String s : lore) {

                String hexUtilResult = colorize(s);
                if(ReflectionUtil.MINIMESSAGE_AVAILABLE) {
                    newLore.add(MiniMessage.miniMessage().deserialize(hexUtilResult));
                }else {
                    newLore.add(LegacyComponentSerializer.legacySection().deserialize(hexUtilResult));
                }
            }
            existingLore.addAll(newLore);
            meta.lore(existingLore);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper addLore(String @NotNull... lore) {
        return addLore(List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper addLore(@Nullable Supplier<List<String>> loreSupplier) {
        return addLore(loreSupplier == null ? new String[0] : loreSupplier.get().toArray(new String[0]));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper addLorePaper(@NotNull List<Object> lore) {
        Validate.notNull(lore, "Lore to be added cannot be null!");
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper addLorePaper(Object @NotNull... lore) {
        return addLorePaper(List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper addLorePaper(@Nullable Supplier<List<Object>> loreSupplier) {
        return addLorePaper(loreSupplier == null ? List.of() : loreSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper addLoreMini(@NotNull List<MiniString> lore) {
        Validate.notNull(lore, "Lore to be added cannot be null!");
        return addLore(lore.stream().map(ms -> ms == null ? null : ms.colorize(ColorizeType.LEGACY).getRawText()).collect(Collectors.toList()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper addLoreMini(MiniString @NotNull... lore) {
        return addLoreMini(List.of(lore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Deprecated(since = "1.4.0")
    public ItemCreatorPaper addLoreMini(@Nullable Supplier<List<MiniString>> loreSupplier) {
        return addLoreMini(loreSupplier == null ? new ArrayList<>() : loreSupplier.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper replaceInLore(String @NotNull... strings) {
        if(hasMeta()) {
            List<Component> lore = meta.lore();
            if(lore == null) {
                return this;
            }

            List<Component> newLore = new ArrayList<>();
            int limit = (strings.length / 2) * 2;
            for (int i = 0; i < limit; i += 2) {
                String find = strings[i];
                String replace = strings[i + 1];
                if (find != null && replace != null) {
                    for(Component line : lore) {
                        newLore.add(line.replaceText(b -> b.matchLiteral(find).replacement(replace)));
                    }
                }
            }
            this.loreList(newLore);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper replaceInNameAndLore(String @NotNull... strings) {
        if(hasMeta()) {
            Component name = meta.displayName();
            List<Component> lore = meta.lore();

            List<Component> newLore = new ArrayList<>();
            int limit = (strings.length / 2) * 2;
            for (int i = 0; i < limit; i += 2) {
                String find = strings[i];
                String replace = strings[i + 1];
                if (find != null && replace != null) {

                    if(name != null) {
                        name = name.replaceText(b -> b.matchLiteral(find).replacement(replace));
                    }

                    if(lore != null) {
                        for(Component line : lore) {
                            newLore.add(line.replaceText(b -> b.matchLiteral(find).replacement(replace)));
                        }
                    }
                }
            }
            this.name(name);
            this.loreList(newLore);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper enchant(@NotNull Enchantment enchantment, int level) {
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
    public ItemCreatorPaper flags(ItemFlag @NotNull... flags) {
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
    public ItemCreatorPaper unbreakable(boolean unbreakable) {
        if(hasMeta()) {
            meta.setUnbreakable(unbreakable);
        }
        return this;
    }

    @Override
    public @NotNull ItemCreator enchantmentGlintOverride(boolean b) {
        if(hasMeta() && Wrapper.getMinecraftVersion() >= 2005) {
            meta.setEnchantmentGlintOverride(b);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public ItemCreatorPaper potion(@Nullable PotionType potionType, @Nullable Color color) {
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
    public ItemCreatorPaper potion(@Nullable PotionType potionType) {
        if(hasMeta() && meta instanceof PotionMeta) {
            PotionMeta potionMeta = (PotionMeta) meta;
            return potion(potionType, potionMeta.getColor());
        }
        return this;
    }



    //===================
    // PAPER SPECIFIC
    //===================

    @Override
    @NotNull
    public ItemCreatorPaper name(@Nullable Component name) {
        if(hasMeta()) {
            meta.displayName(name);
        }
        return this;
    }

    @Override
    @NotNull
    public ItemCreatorPaper nameSup(@NotNull Supplier<Component> nameSupplier) {
        if(hasMeta()) {
            meta.displayName(nameSupplier.get());
        }
        return this;
    }

    @Override
    @NotNull
    public ItemCreatorPaper loreList(@Nullable List<Component> lore) {
        if(hasMeta()) {
            meta.lore(lore);
        }
        return this;
    }

    @Override
    @NotNull
    public ItemCreatorPaper lore(Component @Nullable ... lore) {
        return loreList(lore == null ? null : List.of(lore));
    }

    @Override
    @NotNull
    public ItemCreatorPaper loreSup(@Nullable Supplier<List<Component>> loreSupplier) {
        return loreList(loreSupplier == null ? null : loreSupplier.get());
    }

    @Override
    @NotNull
    public ItemCreatorPaper addLoreList(@NotNull List<Component> lore) {
        if(hasMeta()) {
            List<Component> existingLore = meta.lore() != null ? new ArrayList<>(meta.lore()) : new ArrayList<>();
            existingLore.addAll(lore);
            meta.lore(existingLore);
        }
        return this;
    }

    @Override
    @NotNull
    public ItemCreatorPaper addLore(Component @NotNull ... lore) {
        return addLoreList(List.of(lore));
    }

    @Override
    @NotNull
    public ItemCreatorPaper addLoreSup(@Nullable Supplier<List<Component>> loreSupplier) {
        return addLoreList(loreSupplier == null ? new ArrayList<>() : loreSupplier.get());
    }
}
