package org.nandayo.DAPI.object;


import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;
import org.nandayo.DAPI.object.annotation.DDeprecated;
import org.nandayo.DAPI.object.annotation.DInfo;
import org.nandayo.DAPI.object.annotation.DMerge;

import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Map;

/**
 * Only supports 1.16.1 - 1.21.4<br>
 * Made by @desaxx (<a href="https://github.com/desaxxx/">GitHub</a>)<br>
 * Inspired from XSeries (<a href="https://github.com/CryptoMorin/XSeries">GitHub</a>)
 */
@SuppressWarnings("unused")
public enum DParticle {

    //<editor-fold desc="Particles" defaultstate="collapsed">
    @DInfo(renamedSince = "1.20.5")
    ANGRY_VILLAGER("VILLAGER_ANGRY"),
    ASH,
    @DMerge(since = "1.20.5")
    BLOCK("BLOCK_CRACK", "BLOCK_DUST"),
    @DInfo(since = "1.21.2")
    BLOCK_CRUMBLE,
    @DInfo(renamedSince = "1.18")
    BLOCK_MARKER("BARRIER","LIGHT"),
    @DInfo(renamedSince = "1.20.5")
    BUBBLE("WATER_BUBBLE"),
    BUBBLE_COLUMN_UP,
    BUBBLE_POP,
    CAMPFIRE_COSY_SMOKE,
    CAMPFIRE_SIGNAL_SMOKE,
    @DInfo(since = "1.19.4")
    @DMerge(since = "1.20")
    CHERRY_LEAVES("DRIPPING_CHERRY_LEAVES","FALLING_CHERRY_LEAVES","LANDING_CHERRY_LEAVES"),
    CLOUD,
    COMPOSTER,
    CRIMSON_SPORE,
    CRIT,
    CURRENT_DOWN,
    DAMAGE_INDICATOR,
    DOLPHIN,
    DRAGON_BREATH,
    @DInfo(since = "1.17")
    DRIPPING_DRIPSTONE_LAVA,
    @DInfo(since = "1.17")
    DRIPPING_DRIPSTONE_WATER,
    DRIPPING_HONEY,
    @DInfo(renamedSince = "1.20.5")
    DRIPPING_LAVA("DRIP_LAVA"),
    DRIPPING_OBSIDIAN_TEAR,
    @DInfo(renamedSince = "1.20.5")
    DRIPPING_WATER("DRIP_WATER"),
    @DInfo(renamedSince = "1.20.5")
    DUST("REDSTONE"),
    @DInfo(since = "1.17")
    DUST_COLOR_TRANSITION,
    @DInfo(since = "1.20.5")
    DUST_PILLAR,
    @DInfo(since = "1.20.3")
    DUST_PLUME,
    @DInfo(renamedSince = "1.20.5")
    EFFECT("SPELL"),
    @DInfo(since = "1.20")
    EGG_CRACK,
    @DInfo(renamedSince = "1.20.5")
    ELDER_GUARDIAN("MOB_APPEARANCE"),
    @DInfo(since = "1.17")
    ELECTRIC_SPARK,
    @DInfo(renamedSince = "1.20.5")
    ENCHANT("ENCHANTMENT_TABLE"),
    @DInfo(renamedSince = "1.20.5")
    ENCHANTED_HIT("CRIT_MAGIC"),
    END_ROD,
    @DMerge(since = "1.20.5")
    ENTITY_EFFECT("SPELL_MOB","SPELL_MOB_AMBIENT"),
    @DInfo(renamedSince = "1.20.5")
    EXPLOSION("EXPLOSION_LARGE"),
    @DInfo(renamedSince = "1.20.5")
    EXPLOSION_EMITTER("EXPLOSION_HUGE"),
    @DInfo(since = "1.17")
    FALLING_DRIPSTONE_LAVA,
    @DInfo(since = "1.17")
    FALLING_DRIPSTONE_WATER,
    FALLING_DUST,
    FALLING_HONEY,
    FALLING_LAVA,
    FALLING_NECTAR,
    FALLING_OBSIDIAN_TEAR,
    @DInfo(since = "1.17")
    FALLING_SPORE_BLOSSOM,
    FALLING_WATER,
    @DInfo(renamedSince = "1.20.5")
    FIREWORK("FIREWORKS_SPARK"),
    @DInfo(renamedSince = "1.20.5")
    FISHING("WATER_WAKE"),
    FLAME,
    FLASH,
    @DInfo(since = "1.17")
    GLOW,
    @DInfo(since = "1.17")
    GLOW_SQUID_INK,
    @DInfo(since = "1.20.3")
    GUST,
    @DInfo(since = "1.20.5")
    @DMerge(since = "1.20.5")
    GUST_EMITTER_LARGE("GUST_DUST"),
    @DInfo(since = "1.20.5")
    GUST_EMITTER_SMALL,
    @DInfo(renamedSince = "1.20.5")
    HAPPY_VILLAGER("VILLAGER_HAPPY"),
    HEART,
    @DInfo(since = "1.20.5")
    INFESTED,
    @DInfo(renamedSince = "1.20.5")
    INSTANT_EFFECT("SPELL_INSTANT"),
    @DInfo(renamedSince = "1.20.5")
    ITEM("ITEM_CRACK"),
    @DInfo(since = "1.20.5")
    ITEM_COBWEB,
    @DInfo(renamedSince = "1.20.5")
    ITEM_SLIME("SLIME"),
    @DMerge(since = "1.20.5")
    ITEM_SNOWBALL("SNOWBALL","SNOW_SHOVEL"),
    LANDING_HONEY,
    LANDING_LAVA,
    LANDING_OBSIDIAN_TEAR,
    @DInfo(renamedSince = "1.20.5")
    LARGE_SMOKE("SMOKE_LARGE"),
    LAVA,
    @DInfo(renamedSince = "1.20.5")
    MYCELIUM("TOWN_AURA"),
    NAUTILUS,
    NOTE,
    @DInfo(since = "1.20.5")
    OMINOUS_SPAWNING,
    @DInfo(since = "1.21.4")
    PALE_OAK_LEAVES,
    @DInfo(renamedSince = "1.20.5")
    POOF("EXPLOSION_NORMAL"),
    PORTAL,
    @DInfo(since = "1.20.5")
    RAID_OMEN,
    @DInfo(renamedSince = "1.20.5")
    RAIN("WATER_DROP"),
    REVERSE_PORTAL,
    @DInfo(since = "1.17")
    SCRAPE,
    @DInfo(since = "1.19")
    SCULK_CHARGE,
    @DInfo(since = "1.19")
    SCULK_CHARGE_POP,
    @DInfo(since = "1.19")
    SCULK_SOUL,
    @DInfo(since = "1.19")
    SHRIEK,
    @DInfo(since = "1.17")
    SMALL_FLAME,
    @DInfo(renamedSince = "1.20.5")
    SMALL_GUST("GUST_EMITTER"),
    @DInfo(renamedSince = "1.20.5")
    SMOKE("SMOKE_NORMAL"),
    SNEEZE,
    @DInfo(since = "1.17")
    SNOWFLAKE,
    @DInfo(since = "1.19")
    SONIC_BOOM,
    SOUL,
    SOUL_FIRE_FLAME,
    SPIT,
    @DInfo(renamedSince = "1.20.5")
    SPLASH("WATER_SPLASH"),
    @DInfo(since = "1.17")
    SPORE_BLOSSOM_AIR,
    SQUID_INK,
    SWEEP_ATTACK,
    @DInfo(renamedSince = "1.20.5")
    TOTEM_OF_UNDYING("TOTEM"),
    @DInfo(since = "1.21.2")
    TRAIL,
    @DInfo(since = "1.20.5")
    TRIAL_OMEN,
    @DInfo(since = "1.20.3")
    TRIAL_SPAWNER_DETECTION,
    @DInfo(since = "1.20.5")
    TRIAL_SPAWNER_DETECTION_OMINOUS,
    @DMerge(since = "1.20.5")
    UNDERWATER("SUSPENDED","SUSPENDED_DEPTH"),
    @DInfo(since = "1.20.5")
    VAULT_CONNECTION,
    @DInfo(since = "1.17")
    VIBRATION,
    WARPED_SPORE,
    @DInfo(since = "1.17")
    WAX_OFF,
    @DInfo(since = "1.17")
    WAX_ON,
    WHITE_ASH,
    @DInfo(since = "1.20.3")
    WHITE_SMOKE,
    @DInfo(renamedSince = "1.20.5")
    WITCH("SPELL_WITCH"),
    //</editor-fold>

    //<editor-fold desc="Deprecated" defaultstate="collapsed>
    @DDeprecated(since = "1.20.5")
    BARRIER,
    @DDeprecated(since = "1.20.5")
    BLOCK_CRACK,
    @DDeprecated(since = "1.20.5")
    BLOCK_DUST,
    @DDeprecated(since = "1.20.5")
    CRIT_MAGIC,
    @DDeprecated(since = "1.20.5")
    DRIP_LAVA,
    @DDeprecated(since = "1.20.5")
    DRIP_WATER,
    @DInfo(since = "1.19")
    @DDeprecated(since = "1.20")
    DRIPPING_CHERRY_LEAVES,
    @DDeprecated(since = "1.20.5")
    ENCHANTMENT_TABLE,
    @DDeprecated(since = "1.20.5")
    EXPLOSION_HUGE,
    @DDeprecated(since = "1.20.5")
    EXPLOSION_LARGE,
    @DDeprecated(since = "1.20.5")
    EXPLOSION_NORMAL,
    @DInfo(since = "1.19")
    @DDeprecated(since = "1.20")
    FALLING_CHERRY_LEAVES,
    @DDeprecated(since = "1.20.5")
    FIREWORKS_SPARK,
    @DDeprecated(since = "1.20.5")
    GUST_DUST,
    @DDeprecated(since = "1.20.5")
    GUST_EMITTER,
    @DDeprecated(since = "1.20.5")
    ITEM_CRACK,
    @DInfo(since = "1.19")
    @DDeprecated(since = "1.20")
    LANDING_CHERRY_LEAVES,
    @DInfo(since = "1.17")
    @DDeprecated(since = "1.18")
    LIGHT,
    @DDeprecated(since = "1.20.5")
    MOB_APPEARANCE,
    @DDeprecated(since = "1.20.5")
    REDSTONE,
    @DDeprecated(since = "1.20.5")
    SLIME,
    @DDeprecated(since = "1.20.5")
    SMOKE_LARGE,
    @DDeprecated(since = "1.20.5")
    SMOKE_NORMAL,
    @DDeprecated(since = "1.20.5")
    SNOW_SHOVEL,
    @DDeprecated(since = "1.20.5")
    SNOWBALL,
    @DDeprecated(since = "1.20.5")
    SPELL,
    @DDeprecated(since = "1.20.5")
    SPELL_INSTANT,
    @DDeprecated(since = "1.20.5")
    SPELL_MOB,
    @DDeprecated(since = "1.20.5")
    SPELL_MOB_AMBIENT,
    @DDeprecated(since = "1.20.5")
    SPELL_WITCH,
    @DDeprecated(since = "1.20.5")
    SUSPENDED,
    @DDeprecated(since = "1.20.5")
    SUSPENDED_DEPTH,
    @DDeprecated(since = "1.20.5")
    TOWN_AURA,
    @DDeprecated(since = "1.20.5")
    TOTEM,
    @DDeprecated(since = "1.20.5")
    VILLAGER_ANGRY,
    @DDeprecated(since = "1.20.5")
    VILLAGER_HAPPY,
    @DDeprecated(since = "1.20.5")
    WATER_DROP,
    @DDeprecated(since = "1.20.5")
    WATTER_BUBBLE,
    @DDeprecated(since = "1.20.5")
    WATTER_SPLASH,
    @DDeprecated(since = "1.20.5")
    WATTER_WAKE;
    //</editor-fold>


    DParticle(String... legacies) {
        this.legacies = legacies;
        Particle type = null;
        try {
            type = Particle.valueOf(this.name());
        } catch (IllegalArgumentException e) {
            for(String legacy : legacies) {
                try {
                    type = Particle.valueOf(legacy);
                } catch (IllegalFormatException ignore) {}
                if(type != null) break;
            }
        }
        this.particle = type;
    }

    private final Particle particle;
    private final String[] legacies;

    public Particle get() {
        return particle;
    }


    //

    private static final Map<String, DParticle> NAME_MAP = new HashMap<>();

    static {
        for(DParticle dType : DParticle.values()) {
            NAME_MAP.put(dType.name(), dType);
            for(String legacy : dType.legacies) {
                NAME_MAP.put(legacy, dType);
            }
        }
    }

    public static Particle getByName(@NotNull String name) {
        return NAME_MAP.get(name).get();
    }
}
