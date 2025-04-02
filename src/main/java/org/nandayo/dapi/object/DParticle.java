package org.nandayo.dapi.object;

import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.object.annotation.DDeprecated;
import org.nandayo.dapi.object.annotation.DInfo;
import org.nandayo.dapi.object.annotation.DMerged;
import org.nandayo.dapi.object.annotation.DRenamed;

import java.util.HashMap;
import java.util.Map;

/**
 * Only supports 1.16.1 - 1.21.5<br>
 * Made by @desaxx (<a href="https://github.com/desaxxx/">GitHub</a>)<br>
 * Inspired from XSeries (<a href="https://github.com/CryptoMorin/XSeries">GitHub</a>)
 */
@SuppressWarnings("unused")
public enum DParticle {

    //<editor-fold desc="Particles" defaultstate="collapsed">
    @DRenamed(since = "1.20.5", from = "VILLAGER_ANGRY")
    ANGRY_VILLAGER,
    ASH,
    @DMerged(since = "1.20.5", of = {"BLOCK_CRACK","BLOCK_DUST"})
    BLOCK,
    @DInfo(since = "1.21.2")
    BLOCK_CRUMBLE,
    @DMerged(since = "1.18", of = {"BARRIER","LIGHT"})
    BLOCK_MARKER,
    @DRenamed(since = "1.20.5", from = "WATER_BUBBLE")
    BUBBLE,
    BUBBLE_COLUMN_UP,
    BUBBLE_POP,
    CAMPFIRE_COSY_SMOKE,
    CAMPFIRE_SIGNAL_SMOKE,
    @DInfo(since = "1.19.4")
    @DMerged(since = "1.20", of = {"LANDING_CHERRY_LEAVES","FALLING_CHERRY_LEAVES","DRIPPING_CHERRY_LEAVES"})
    CHERRY_LEAVES,
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
    @DRenamed(since = "1.20.5", from = "DRIP_LAVA")
    DRIPPING_LAVA,
    DRIPPING_OBSIDIAN_TEAR,
    @DRenamed(since = "1.20.5", from = "DRIP_WATER")
    DRIPPING_WATER,
    @DInfo(since = "1.20.5")
    DUST,
    @DInfo(since = "1.17")
    DUST_COLOR_TRANSITION,
    @DInfo(since = "1.20.5")
    DUST_PILLAR,
    @DInfo(since = "1.20.3")
    DUST_PLUME,
    @DRenamed(since = "1.20.5", from = "SPELL")
    EFFECT,
    @DInfo(since = "1.20")
    EGG_CRACK,
    @DRenamed(since = "1.20.5", from = "MOB_APPEARANCE")
    ELDER_GUARDIAN,
    @DInfo(since = "1.17")
    ELECTRIC_SPARK,
    @DRenamed(since = "1.20.5", from = "ENCHANTMENT_TABLE")
    ENCHANT,
    @DRenamed(since = "1.20.5", from = "CRIT_MAGIC")
    ENCHANTED_HIT,
    END_ROD,
    @DMerged(since = "1.20.5", of = {"SPELL_MOB","SPELL_MOB_AMBIENT"})
    ENTITY_EFFECT,
    @DRenamed(since = "1.20.5", from = "EXPLOSION_LARGE")
    EXPLOSION,
    @DRenamed(since = "1.20.5", from = "EXPLOSION_HUGE")
    EXPLOSION_EMITTER,
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
    @DInfo(since = "1.21.5")
    FIREFLY,
    @DRenamed(since = "1.20.5", from = "FIREWORKS_SPARK")
    FIREWORK,
    @DRenamed(since = "1.20.5", from = "WATER_WAKE")
    FISHING,
    FLAME,
    FLASH,
    @DInfo(since = "1.17")
    GLOW,
    @DInfo(since = "1.17")
    GLOW_SQUID_INK,
    @DInfo(since = "1.20.3")
    GUST,
    @DInfo(since = "1.20.5")
    GUST_EMITTER_LARGE,
    @DInfo(since = "1.20.5")
    GUST_EMITTER_SMALL,
    @DRenamed(since = "1.20.5", from = "VILLAGER_HAPPY")
    HAPPY_VILLAGER,
    HEART,
    @DInfo(since = "1.20.5")
    INFESTED,
    @DRenamed(since = "1.20.5", from = "SPELL_INSTANT")
    INSTANT_EFFECT,
    @DRenamed(since = "1.20.5", from = "ITEM_CRACK")
    ITEM,
    @DInfo(since = "1.20.5")
    ITEM_COBWEB,
    @DRenamed(since = "1.20.5", from = "SLIME")
    ITEM_SLIME,
    @DMerged(since = "1.20.5", of = {"SNOWBALL","SNOW_SHOVEL"})
    ITEM_SNOWBALL,
    LANDING_HONEY,
    LANDING_LAVA,
    LANDING_OBSIDIAN_TEAR,
    @DRenamed(since = "1.20.5", from = "SMOKE_LARGE")
    LARGE_SMOKE,
    LAVA,
    @DRenamed(since = "1.20.5", from = "TOWN_AURA")
    MYCELIUM,
    NAUTILUS,
    NOTE,
    @DInfo(since = "1.20.5")
    OMINOUS_SPAWNING,
    @DInfo(since = "1.21.4")
    PALE_OAK_LEAVES,
    @DRenamed(since = "1.20.5", from = "EXPLOSION_NORMAL")
    POOF,
    PORTAL,
    @DInfo(since = "1.20.5")
    RAID_OMEN,
    @DRenamed(since = "1.20.5", from = "WATER_DROP")
    RAIN,
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
    @DInfo(since = "1.20.5")
    SMALL_GUST,
    @DRenamed(since = "1.20.5", from = "SMOKE_NORMAL")
    SMOKE,
    SNEEZE,
    @DInfo(since = "1.17")
    SNOWFLAKE,
    @DInfo(since = "1.19")
    SONIC_BOOM,
    SOUL,
    SOUL_FIRE_FLAME,
    SPIT,
    @DRenamed(since = "1.20.5", from = "WATER_SPLASH")
    SPLASH,
    @DInfo(since = "1.17")
    SPORE_BLOSSOM_AIR,
    SQUID_INK,
    SWEEP_ATTACK,
    @DInfo(since = "1.21.5")
    TINTED_LEAVES,
    @DRenamed(since = "1.20.5", from = "TOTEM")
    TOTEM_OF_UNDYING,
    @DInfo(since = "1.21.2")
    TRAIL,
    @DInfo(since = "1.20.5")
    TRIAL_OMEN,
    @DInfo(since = "1.20.3")
    TRIAL_SPAWNER_DETECTION,
    @DInfo(since = "1.20.5")
    TRIAL_SPAWNER_DETECTION_OMINOUS,
    @DMerged(since = "1.20.5", of = {"SUSPENDED","SUSPENDED_DEPTH"})
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
    @DRenamed(since = "1.20.5", from = "SPELL_WITCH")
    WITCH,
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
    WATER_BUBBLE,
    @DDeprecated(since = "1.20.5")
    WATER_SPLASH,
    @DDeprecated(since = "1.20.5")
    WATER_WAKE;
    //</editor-fold>


    DParticle() {
        Particle type = null;
        try {
            type = Particle.valueOf(this.name());
        } catch (IllegalArgumentException ignored) {}
        this.particle = type;
    }

    private final Particle particle;

    public Particle get() {
        return particle;
    }


    //

    private static final Map<String, DParticle> NAME_MAP = new HashMap<>();

    static {
        for(DParticle dType : DParticle.values()) {
            NAME_MAP.put(dType.name(), dType);
        }
    }

    public static Particle getByName(@NotNull String name) {
        DParticle dParticle = NAME_MAP.get(name);
        return dParticle == null ? null : dParticle.get();
    }
}
