package org.nandayo.DAPI.object;

import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.nandayo.DAPI.object.annotation.DDeprecated;
import org.nandayo.DAPI.object.annotation.DInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Only supports 1.16.1 - 1.21.4<br>
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
    @DInfo(renamedSince = "1.20.5")
    HASTE("FAST_DIGGING"),
    HEALTH_BOOST,
    HERO_OF_THE_VILLAGE,
    HUNGER,
    @DInfo(since = "1.20.5")
    INFESTED,
    @DInfo(renamedSince = "1.20.5")
    INSTANT_DAMAGE("HARM"),
    @DInfo(renamedSince = "1.20.5")
    INSTANT_HEALTH("HEAL"),
    INVISIBILITY,
    @DInfo(renamedSince = "1.20.5")
    JUMP_BOOST("JUMP"),
    LEVITATION,
    LUCK,
    @DInfo(renamedSince = "1.20.5")
    MINING_FATIGUE("SLOW_DIGGING"),
    @DInfo(renamedSince = "1.20.5")
    NAUSEA("CONFUSION"),
    NIGHT_VISION,
    @DInfo(since = "1.20.5")
    OOZING,
    POISON,
    @DInfo(since = "1.20.5")
    RAID_OMEN,
    REGENERATION,
    @DInfo(renamedSince = "1.20.5")
    RESISTANCE("DAMAGE_RESISTANCE"),
    SATURATION,
    @DInfo(renamedSince = "1.20.5")
    SLOWNESS("SLOW"),
    SLOW_FALLING,
    SPEED,
    @DInfo(renamedSince = "1.20.5")
    STRENGTH("INCREASE_DAMAGE"),
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
    DPotionEffectType(String... legacies) {
        this.legacies = legacies;
        PotionEffectType type = PotionEffectType.getByName(this.name());
        if(type == null) {
            for(String legacy : this.legacies) {
                type = PotionEffectType.getByName(legacy);
                if(type != null) break;
            }
        }
        this.potionEffectType = type;
    }

    private final PotionEffectType potionEffectType;
    private final String[] legacies;

    public PotionEffectType get() {
        return potionEffectType;
    }


    //

    private static final Map<String, DPotionEffectType> NAME_MAP = new HashMap<>();

    static {
        for(DPotionEffectType dType : DPotionEffectType.values()) {
            NAME_MAP.put(dType.name(), dType);
            for(String legacy : dType.legacies) {
                NAME_MAP.put(legacy, dType);
            }
        }
    }

    public static PotionEffectType getByName(@NotNull String name) {
        return NAME_MAP.get(name).get();
    }
}
