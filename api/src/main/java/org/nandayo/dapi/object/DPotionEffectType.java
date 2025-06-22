package org.nandayo.dapi.object;

import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.object.annotation.DDeprecated;
import org.nandayo.dapi.object.annotation.DInfo;
import org.nandayo.dapi.object.annotation.DRenamed;

import java.util.HashMap;
import java.util.Map;

/**
 * Only supports 1.16.1 - 1.21.6<br>
 * Made by @desaxx (<a href="https://github.com/desaxxx/">GitHub</a>)<br>
 * Inspired from XSeries (<a href="https://github.com/CryptoMorin/XSeries">GitHub</a>)
 */
@SuppressWarnings("unused")
public enum DPotionEffectType {

    //<editor-fold desc="PotionEffectTypes" defaultstate="collapsed">
    ABSORPTION,
    BAD_OMEN,
    BLINDNESS,
    CONDUIT_POWER,
    @DInfo(since = "1.19.1")
    DARKNESS,
    DOLPHINS_GRACE,
    FIRE_RESISTANCE,
    GLOWING,
    @DRenamed(since = "1.20.5", from = "FAST_DIGGING")
    HASTE,
    HEALTH_BOOST,
    HERO_OF_THE_VILLAGE,
    HUNGER,
    @DInfo(since = "1.20.5")
    INFESTED,
    @DRenamed(since = "1.20.5", from = "HARM")
    INSTANT_DAMAGE,
    @DRenamed(since = "1.20.5", from = "HEAL")
    INSTANT_HEALTH,
    INVISIBILITY,
    @DRenamed(since = "1.20.5", from = "JUMP")
    JUMP_BOOST,
    LEVITATION,
    LUCK,
    @DRenamed(since = "1.20.5", from = "SLOW_DIGGING")
    MINING_FATIGUE,
    @DRenamed(since = "1.20.5", from = "CONFUSION")
    NAUSEA,
    NIGHT_VISION,
    @DInfo(since = "1.20.5")
    OOZING,
    POISON,
    @DInfo(since = "1.20.5")
    RAID_OMEN,
    REGENERATION,
    @DRenamed(since = "1.20.5", from = "DAMAGE_RESISTANCE")
    RESISTANCE,
    SATURATION,
    @DRenamed(since = "1.20.5", from = "SLOW")
    SLOWNESS,
    SLOW_FALLING,
    SPEED,
    @DRenamed(since = "1.20.5", from = "INCREASE_DAMAGE")
    STRENGTH,
    @DInfo(since = "1.20.5")
    TRIAL_OMEN,
    UNLUCK,
    WATER_BREATHING,
    WEAKNESS,
    @DInfo(since = "1.20.5")
    WEAVING,
    @DInfo(since = "1.20.5")
    WIND_CHARGED,
    WITHER,
    //</editor-fold>

    //<editor-fold desc="Deprecated" defaultstate="collapsed">
    @DDeprecated(since = "1.20.5")
    SLOW,
    @DDeprecated(since = "1.20.5")
    FAST_DIGGING,
    @DDeprecated(since = "1.20.5")
    SLOW_DIGGING,
    @DDeprecated(since = "1.20.5")
    INCREASE_DAMAGE,
    @DDeprecated(since = "1.20.5")
    HEAL,
    @DDeprecated(since = "1.20.5")
    HARM,
    @DDeprecated(since = "1.20.5")
    JUMP,
    @DDeprecated(since = "1.20.5")
    CONFUSION,
    @DDeprecated(since = "1.20.5")
    DAMAGE_RESISTANCE;
    //</editor-fold>


    @SuppressWarnings("deprecation")
    DPotionEffectType() {
        this.potionEffectType = PotionEffectType.getByName(this.name());
    }

    private final PotionEffectType potionEffectType;

    public PotionEffectType get() {
        return potionEffectType;
    }


    //

    private static final Map<String, DPotionEffectType> NAME_MAP = new HashMap<>();

    static {
        for(DPotionEffectType dType : DPotionEffectType.values()) {
            NAME_MAP.put(dType.name(), dType);
        }
    }

    public static PotionEffectType getByName(@NotNull String name) {
        DPotionEffectType dPotionEffectType = NAME_MAP.get(name);
        return dPotionEffectType == null ? null : dPotionEffectType.get();
    }
}
