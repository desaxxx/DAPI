package org.nandayo.dapi.object;

import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.object.annotation.DDeprecated;
import org.nandayo.dapi.object.annotation.DInfo;
import org.nandayo.dapi.object.annotation.DRenamed;

import java.util.HashMap;
import java.util.Map;

/**
 * Only supports 1.16.1 - 1.21.11.<br>
 * Made by @desaxx (<a href="https://github.com/desaxxx/">GitHub</a>)<br>
 * Inspired from XSeries (<a href="https://github.com/CryptoMorin/XSeries">GitHub</a>)<br>
 */
@SuppressWarnings("unused")
public enum DEnchantment {

    //<editor-fold desc="Enchantments" defaultstate="collapsed>
    @DRenamed(since = "1.20.5", from = "WATER_WORKER")
    AQUA_AFFINITY,
    @DRenamed(since = "1.20.5", from = "DAMAGE_ARTHROPODS")
    BANE_OF_ARTHROPODS,
    BINDING_CURSE,
    @DRenamed(since = "1.20.5", from = "PROTECTION_EXPLOSIONS")
    BLAST_PROTECTION,
    @DInfo(since = "1.20.5")
    BREACH,
    CHANNELING,
    @DInfo(since = "1.20.5")
    DENSITY,
    DEPTH_STRIDER,
    @DRenamed(since = "1.20.5", from = "DIG_SPEED")
    EFFICIENCY,
    @DRenamed(since = "1.20.5", from = "PROTECTION_FALL")
    FEATHER_FALLING,
    FIRE_ASPECT,
    @DRenamed(since = "1.20.5", from = "PROTECTION_FIRE")
    FIRE_PROTECTION,
    @DRenamed(since = "1.20.5", from = "ARROW_FIRE")
    FLAME,
    @DRenamed(since = "1.20.5", from = "LOOT_BONUS_BLOCKS")
    FORTUNE,
    FROST_WALKER,
    IMPALING,
    @DRenamed(since = "1.20.5", from = "ARROW_INFINITE")
    INFINITY,
    KNOCKBACK,
    @DRenamed(since = "1.20.5", from = "LOOT_BONUS_MOBS")
    LOOTING,
    LOYALTY,
    @DRenamed(since = "1.20.5", from = "LUCK")
    LUCK_OF_THE_SEA,
    @DInfo(since = "1.21.11")
    LUNGE,
    LURE,
    MENDING,
    MULTISHOT,
    PIERCING,
    @DRenamed(since = "1.20.5", from = "ARROW_DAMAGE")
    POWER,
    @DRenamed(since = "1.20.5", from = "PROTECTION_PROJECTILE")
    PROJECTILE_PROTECTION,
    @DRenamed(since = "1.20.5", from = "PROTECTION_ENVIRONMENTAL")
    PROTECTION,
    @DRenamed(since = "1.20.5", from = "ARROW_KNOCKBACK")
    PUNCH,
    QUICK_CHARGE,
    @DRenamed(since = "1.20.5", from = "OXYGEN")
    RESPIRATION,
    RIPTIDE,
    @DRenamed(since = "1.20.5", from = "DAMAGE_ALL")
    SHARPNESS,
    SILK_TOUCH,
    @DRenamed(since = "1.20.5", from = "DAMAGE_UNDEAD")
    SMITE,
    @DInfo(since = "1.16.1")
    SOUL_SPEED,
    SWEEPING_EDGE,
    @DInfo(since = "1.19")
    SWIFT_SNEAK,
    THORNS,
    @DRenamed(since = "1.20.5", from = "DURABILITY")
    UNBREAKING,
    VANISHING_CURSE,
    @DInfo(since = "1.20.5")
    WIND_BURST,
    //</editor-fold>

    //<editor-fold desc="Deprecated" defaultstate="collapsed>
    @DDeprecated(since = "1.20.5")
    PROTECTION_ENVIRONMENTAL,
    @DDeprecated(since = "1.20.5")
    PROTECTION_FIRE,
    @DDeprecated(since = "1.20.5")
    PROTECTION_FALL,
    @DDeprecated(since = "1.20.5")
    PROTECTION_EXPLOSIONS,
    @DDeprecated(since = "1.20.5")
    PROTECTION_PROJECTILE,
    @DDeprecated(since = "1.20.5")
    OXYGEN,
    @DDeprecated(since = "1.20.5")
    WATER_WORKER,
    @DDeprecated(since = "1.20.5")
    DAMAGE_ALL,
    @DDeprecated(since = "1.20.5")
    DAMAGE_UNDEAD,
    @DDeprecated(since = "1.20.5")
    DAMAGE_ARTHROPODS,
    @DDeprecated(since = "1.20.5")
    LOOT_BONUS_MOBS,
    @DDeprecated(since = "1.20.5")
    DIG_SPEED,
    @DDeprecated(since = "1.20.5")
    DURABILITY,
    @DDeprecated(since = "1.20.5")
    LOOT_BONUS_BLOCKS,
    @DDeprecated(since = "1.20.5")
    ARROW_DAMAGE,
    @DDeprecated(since = "1.20.5")
    ARROW_KNOCKBACK,
    @DDeprecated(since = "1.20.5")
    ARROW_FIRE,
    @DDeprecated(since = "1.20.5")
    ARROW_INFINITE,
    @DDeprecated(since = "1.20.5")
    LUCK;
    //</editor-fold>

    @SuppressWarnings("deprecation")
    DEnchantment() {
        this.enchantment = Enchantment.getByName(this.name());
    }

    private final Enchantment enchantment;

    public Enchantment get() {
        return enchantment;
    }

    //

    private static final Map<String, DEnchantment> NAME_MAP = new HashMap<>();

    static {
        for(DEnchantment dEnchantment : DEnchantment.values()) {
            NAME_MAP.put(dEnchantment.name(), dEnchantment);
        }
    }

    public static Enchantment getByName(@NotNull String name) {
        DEnchantment dEnchantment = NAME_MAP.get(name);
        return dEnchantment == null ? null : dEnchantment.get();
    }

}
