package org.nandayo.dapi.object;

import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.object.annotation.DCaution;
import org.nandayo.dapi.object.annotation.DDeprecated;
import org.nandayo.dapi.object.annotation.DInfo;
import org.nandayo.dapi.object.annotation.DRenamed;

import java.util.HashMap;
import java.util.Map;

/**
 * Only supports 1.16.1 - 1.21.6.<br>
 * Made by @desaxx (<a href="https://github.com/desaxxx/">GitHub</a>)<br>
 * Inspired from XSeries (<a href="https://github.com/CryptoMorin/XSeries">GitHub</a>)<br>
 */
@SuppressWarnings("unused")
public enum DEntityType {

    //<editor-fold desc="EntityTypes" defaultstate="collapsed">
    @DInfo(since = "1.21.2")
    ACACIA_BOAT,
    @DInfo(since = "1.21.2")
    ACACIA_CHEST_BOAT,
    @DInfo(since = "1.19")
    ALLAY,
    AREA_EFFECT_CLOUD,
    @DInfo(since = "1.20.5")
    ARMADILLO,
    ARMOR_STAND,
    ARROW,
    @DInfo(since = "1.17")
    AXOLOTL,
    @DInfo(since = "1.21.2")
    BAMBOO_CHEST_RAFT,
    @DInfo(since = "1.21.2")
    BAMBOO_RAFT,
    BAT,
    BEE,
    @DInfo(since = "1.21.2")
    BIRCH_BOAT,
    @DInfo(since = "1.21.2")
    BIRCH_CHEST_BOAT,
    BLAZE,
    @DInfo(since = "1.19.4")
    BLOCK_DISPLAY,
    @DInfo(since = "1.20.5")
    BOGGED,
    @DInfo(since = "1.20.3")
    BREEZE,
    @DInfo(since = "1.20.5")
    BREEZE_WIND_CHARGE,
    @DInfo(since = "1.19.3")
    CAMEL,
    CAT,
    CAVE_SPIDER,
    @DInfo(since = "1.21.2")
    CHERRY_BOAT,
    @DInfo(since = "1.21.2")
    CHERRY_CHEST_BOAT,
    @DRenamed(since = "1.20.5", from = "MINECART_CHEST")
    CHEST_MINECART,
    CHICKEN,
    COD,
    @DRenamed(since = "1.20.5", from = "MINECART_COMMAND")
    COMMAND_BLOCK_MINECART,
    COW,
    @DInfo(since = "1.21.2")
    CREAKING,
    CREEPER,
    @DInfo(since = "1.21.2")
    DARK_OAK_BOAT,
    @DInfo(since = "1.21.2")
    DARK_OAK_CHEST_BOAT,
    DOLPHIN,
    DONKEY,
    DRAGON_FIREBALL,
    DROWNED,
    EGG,
    ELDER_GUARDIAN,
    @DRenamed(since = "1.20.5", from = "ENDER_CRYSTAL")
    END_CRYSTAL,
    ENDER_DRAGON,
    ENDER_PEARL,
    ENDERMAN,
    ENDERMITE,
    EVOKER,
    EVOKER_FANGS,
    @DRenamed(since = "1.20.5", from = "THROWN_EXP_BOTTLE")
    EXPERIENCE_BOTTLE,
    EXPERIENCE_ORB,
    @DRenamed(since = "1.20.5", from = "ENDER_SIGNAL")
    EYE_OF_ENDER,
    FALLING_BLOCK,
    FIREBALL,
    @DRenamed(since = "1.20.5", from = "FIREWORK")
    FIREWORK_ROCKET,
    @DRenamed(since = "1.20.5", from = "FISHING_HOOK")
    FISHING_BOBBER,
    FOX,
    @DInfo(since = "1.19")
    FROG,
    @DRenamed(since = "1.20.5", from = "MINECART_FURNACE")
    FURNACE_MINECART,
    GHAST,
    GIANT,
    @DInfo(since = "1.17")
    GLOW_ITEM_FRAME,
    @DInfo(since = "1.17")
    GLOW_SQUID,
    @DInfo(since = "1.17")
    GOAT,
    GUARDIAN,
    @DInfo(since = "1.21.6")
    HAPPY_GHAST,
    @DInfo(since = "1.16.1")
    HOGLIN,
    @DRenamed(since = "1.20.5", from = "MINECART_HOPPER")
    HOPPER_MINECART,
    HORSE,
    HUSK,
    ILLUSIONER,
    @DInfo(since = "1.19.4")
    INTERACTION,
    IRON_GOLEM,
    @DRenamed(since = "1.20.5", from = "DROPPED_ITEM")
    ITEM,
    @DInfo(since = "1.19.4")
    ITEM_DISPLAY,
    ITEM_FRAME,
    @DInfo(since = "1.21.2")
    JUNGLE_BOAT,
    @DInfo(since = "1.21.2")
    JUNGLE_CHEST_BOAT,
    @DRenamed(since = "1.20.5", from = "LEASH_HITCH")
    LEASH_KNOT,
    @DRenamed(since = "1.20.5", from = "LIGHTNING")
    LIGHTNING_BOLT,
    @DInfo(since = "1.21.5")
    LINGERING_POTION,
    LLAMA,
    LLAMA_SPIT,
    MAGMA_CUBE,
    @DInfo(since = "1.21.2")
    MANGROVE_BOAT,
    @DInfo(since = "1.21.2")
    MANGROVE_CHEST_BOAT,
    @DInfo(since = "1.17")
    MARKER,
    MINECART,
    @DRenamed(since = "1.20.5", from = "MUSHROOM_COW")
    MOOSHROOM,
    MULE,
    @DInfo(since = "1.21.2")
    OAK_BOAT,
    @DInfo(since = "1.21.2")
    OAK_CHEST_BOAT,
    OCELOT,
    @DInfo(since = "1.20.5")
    OMINOUS_ITEM_SPAWNER,
    PAINTING,
    @DInfo(since = "1.21.2")
    PALE_OAK_BOAT,
    @DInfo(since = "1.21.2")
    PALE_OAK_CHEST_BOAT,
    PANDA,
    PARROT,
    PHANTOM,
    PIG,
    @DInfo(since = "1.16.1")
    PIGLIN,
    @DInfo(since = "1.16.2")
    PIGLIN_BRUTE,
    PILLAGER,
    PLAYER,
    POLAR_BEAR,
    PUFFERFISH,
    RABBIT,
    RAVAGER,
    SALMON,
    SHEEP,
    SHULKER,
    SHULKER_BULLET,
    SILVERFISH,
    SKELETON,
    SKELETON_HORSE,
    SLIME,
    SMALL_FIREBALL,
    @DInfo(since = "1.19.4")
    SNIFFER,
    @DRenamed(since = "1.20.5", from = "SNOWMAN")
    SNOW_GOLEM,
    SNOWBALL,
    @DRenamed(since = "1.20.5", from = "MINECART_MOB_SPAWNER")
    SPAWNER_MINECART,
    SPECTRAL_ARROW,
    SPIDER,
    @DCaution(
            description = "Use DEntityType.POTION between versions of 1.20.5 to 1.21.4",
            deprecatedSince = "1.20.5", restoredSince = "1.21.5")
    SPLASH_POTION,
    @DInfo(since = "1.21.2")
    SPRUCE_BOAT,
    @DInfo(since = "1.21.2")
    SPRUCE_CHEST_BOAT,
    SQUID,
    STRAY,
    @DInfo(since = "1.16.1")
    STRIDER,
    @DInfo(since = "1.19")
    TADPOLE,
    @DInfo(since = "1.19.4")
    TEXT_DISPLAY,
    @DRenamed(since = "1.20.5", from = "PRIMED_TNT")
    TNT,
    @DRenamed(since = "1.20.5", from = "MINECART_TNT")
    TNT_MINECART,
    TRADER_LLAMA,
    TRIDENT,
    TROPICAL_FISH,
    TURTLE,
    UNKNOWN,
    VEX,
    VILLAGER,
    VINDICATOR,
    WANDERING_TRADER,
    @DInfo(since = "1.19")
    WARDEN,
    @DInfo(since = "1.20.3")
    WIND_CHARGE,
    WITCH,
    WITHER,
    WITHER_SKELETON,
    WITHER_SKULL,
    WOLF,
    @DInfo(since = "1.16.1")
    ZOGLIN,
    ZOMBIE,
    ZOMBIE_HORSE,
    ZOMBIE_VILLAGER,
    @DRenamed(since = "1.16.1", from = "PIG_ZOMBIE")
    ZOMBIFIED_PIGLIN,
    //</editor-fold>

    //<editor-fold desc="Deprecated" defaultstate="collapsed>
    @DDeprecated(since = "1.20.5")
    DROPPED_ITEM,
    @DDeprecated(since = "1.20.5")
    LEASH_HITCH,
    @DDeprecated(since = "1.20.5")
    ENDER_SIGNAL,
    @DDeprecated(since = "1.20.5")
    THROWN_EXP_BOTTLE,
    @DDeprecated(since = "1.20.5")
    PRIMED_TNT,
    @DDeprecated(since = "1.20.5")
    FIREWORK,
    @DDeprecated(since = "1.20.5")
    MINECART_COMMAND,
    @DDeprecated(since = "1.20.5")
    MINECART_CHEST,
    @DDeprecated(since = "1.20.5")
    MINECART_FURNACE,
    @DDeprecated(since = "1.20.5")
    MINECART_TNT,
    @DDeprecated(since = "1.20.5")
    MINECART_HOPPER,
    @DDeprecated(since = "1.20.5")
    MINECART_MOB_SPAWNER,
    @DDeprecated(since = "1.20.5")
    MUSHROOM_COW,
    @DDeprecated(since = "1.20.5")
    SNOWMAN,
    @DDeprecated(since = "1.20.5")
    ENDER_CRYSTAL,
    @DDeprecated(since = "1.20.5")
    FISHING_HOOK,
    @DDeprecated(since = "1.20.5")
    LIGHTNING,
    @DDeprecated(since = "1.16.1")
    PIG_ZOMBIE,
    @DRenamed(since = "1.20.5", from = "SPLASH_POTION")
    @DDeprecated(since = "1.21.5")
    POTION,
    @DInfo(since = "1.19")
    @DDeprecated(since = "1.21.2")
    CHEST_BOAT,
    @DDeprecated(since = "1.21.2")
    BOAT,
    @DInfo(since = "1.21.2")
    @DDeprecated(since = "1.21.4")
    CREAKING_TRANSIENT;
    //</editor-fold>


    @SuppressWarnings("deprecation")
    DEntityType() {
        this.entityType = EntityType.fromName(this.name());
    }

    private final EntityType entityType;

    public EntityType get() {
        return entityType;
    }

    //

    private static final Map<String, DEntityType> NAME_MAP = new HashMap<>();

    static {
        for(DEntityType dType : DEntityType.values()) {
            NAME_MAP.put(dType.name(), dType);
        }
    }

    public static EntityType getByName(@NotNull String name) {
        DEntityType dEntityType = NAME_MAP.get(name);
        return dEntityType == null ? null : dEntityType.get();
    }
}
