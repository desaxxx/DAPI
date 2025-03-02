package org.nandayo.DAPI.dobject;

import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/*
 * Only supports 1.16.1 - 1.21.4
 * Made by @desaxx (https://github.com/desaxxx/)
 * Inspired from XSeries (https://github.com/CryptoMorin/XSeries)
 */
@SuppressWarnings("unused")
public enum DPotionEffectType {

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
    WITHER;



    @SuppressWarnings("deprecation")
    DPotionEffectType(String... legacies) {
        this.legacies = legacies;
        PotionEffectType type = PotionEffectType.getByName(this.name());
        if(type == null) {
            for(String legacy : this.legacies) {
                type = PotionEffectType.getByName(legacy);
                break;
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

    private static final Map<String, DPotionEffectType> LEGACY_MAP = new HashMap<>();

    static {
        for(DPotionEffectType dType : DPotionEffectType.values()) {
            LEGACY_MAP.put(dType.name(), dType);
            for(String legacy : dType.legacies) {
                LEGACY_MAP.put(legacy, dType);
            }
        }
    }

    public static PotionEffectType getByName(@NotNull String name) {
        return LEGACY_MAP.get(name).get();
    }
}
