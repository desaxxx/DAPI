package org.nandayo.dapi.object;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.object.annotation.DDeprecated;
import org.nandayo.dapi.object.annotation.DInfo;
import org.nandayo.dapi.object.annotation.DRenamed;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Only supports 1.16.1 - 1.21.11.<br>
 * Made by @desaxx (<a href="https://github.com/desaxxx/">GitHub</a>)<br>
 * Inspired from XSeries (<a href="https://github.com/CryptoMorin/XSeries">GitHub</a>)<br>
 */
@SuppressWarnings("unused")
public enum DMaterial implements ObjectWrapper<Material> {

    //<editor-fold desc="Materials" defaultstate="collapsed">
    ACACIA_BOAT,
    ACACIA_BUTTON,
    ACACIA_CHEST_BOAT,
    ACACIA_DOOR,
    ACACIA_FENCE,
    ACACIA_FENCE_GATE,
    @DInfo(since = "1.19.3")
    ACACIA_HANGING_SIGN,
    ACACIA_LEAVES,
    ACACIA_LOG,
    ACACIA_PLANKS,
    ACACIA_PRESSURE_PLATE,
    ACACIA_SAPLING,
    @DInfo(since = "1.21.9")
    ACACIA_SHELF,
    ACACIA_SLAB,
    ACACIA_STAIRS,
    ACACIA_TRAPDOOR,
    @DInfo(since = "1.19.3")
    ACACIA_WALL_HANGING_SIGN,
    ACACIA_WALL_SIGN,
    ACACIA_WOOD,
    ACTIVATOR_RAIL,
    AIR,
    @DInfo(since = "1.19")
    ALLAY_SPAWN_EGG,
    ALLIUM,
    @DInfo(since = "1.17")
    AMETHYST_BLOCK,
    @DInfo(since = "1.17")
    AMETHYST_CLUSTER,
    @DInfo(since = "1.17")
    AMETHYST_SHARD,
    ANCIENT_DEBRIS,
    ANDESITE,
    ANDESITE_SLAB,
    ANDESITE_STAIRS,
    ANDESITE_WALL,
    @DInfo(since = "1.20")
    ANGLER_POTTERY_SHERD,
    ANVIL,
    APPLE,
    @DInfo(since = "1.20")
    ARCHER_POTTERY_SHERD,
    @DInfo(since = "1.20.5")
    ARMADILLO_SCUTE,
    @DInfo(since = "1.20.5")
    ARMADILLO_SPAWN_EGG,
    ARMOR_STAND,
    @DInfo(since = "1.20")
    ARMS_UP_POTTERY_SHERD,
    ARROW,
    ATTACHED_MELON_STEM,
    ATTACHED_PUMPKIN_STEM,
    @DInfo(since = "1.17")
    AXOLOTL_BUCKET,
    @DInfo(since = "1.17")
    AXOLOTL_SPAWN_EGG,
    @DInfo(since = "1.17")
    AZALEA,
    @DInfo(since = "1.17")
    AZALEA_LEAVES,
    AZURE_BLUET,
    BAKED_POTATO,
    BAMBOO,
    @DInfo(since = "1.19.3")
    BAMBOO_BLOCK,
    @DInfo(since = "1.19.3")
    BAMBOO_BUTTON,
    @DInfo(since = "1.19.3")
    BAMBOO_CHEST_RAFT,
    @DInfo(since = "1.19.3")
    BAMBOO_DOOR,
    @DInfo(since = "1.19.3")
    BAMBOO_FENCE,
    @DInfo(since = "1.19.3")
    BAMBOO_FENCE_GATE,
    @DInfo(since = "1.19.3")
    BAMBOO_HANGING_SIGN,
    @DInfo(since = "1.19.3")
    BAMBOO_MOSAIC,
    @DInfo(since = "1.19.3")
    BAMBOO_MOSAIC_SLAB,
    @DInfo(since = "1.19.3")
    BAMBOO_MOSAIC_STAIRS,
    @DInfo(since = "1.19.3")
    BAMBOO_PLANKS,
    @DInfo(since = "1.19.3")
    BAMBOO_PRESSURE_PLATE,
    @DInfo(since = "1.19.3")
    BAMBOO_RAFT,
    BAMBOO_SAPLING,
    @DInfo(since = "1.21.9")
    BAMBOO_SHELF,
    @DInfo(since = "1.19.3")
    BAMBOO_SIGN,
    @DInfo(since = "1.19.3")
    BAMBOO_SLAB,
    @DInfo(since = "1.19.3")
    BAMBOO_STAIRS,
    @DInfo(since = "1.19.3")
    BAMBOO_TRAPDOOR,
    @DInfo(since = "1.19.3")
    BAMBOO_WALL_HANGING_SIGN,
    @DInfo(since = "1.19.3")
    BAMBOO_WALL_SIGN,
    BARREL,
    BARRIER,
    BASALT,
    BAT_SPAWN_EGG,
    BEACON,
    BEDROCK,
    BEEF,
    BEEHIVE,
    BEETROOT,
    BEETROOTS,
    BEETROOT_SEEDS,
    BEETROOT_SOUP,
    BEE_NEST,
    BEE_SPAWN_EGG,
    BELL,
    @DInfo(since = "1.17")
    BIG_DRIPLEAF,
    @DInfo(since = "1.17")
    BIG_DRIPLEAF_STEM,
    BIRCH_BOAT,
    BIRCH_BUTTON,
    BIRCH_CHEST_BOAT,
    BIRCH_DOOR,
    BIRCH_FENCE,
    BIRCH_FENCE_GATE,
    @DInfo(since = "1.19.3")
    BIRCH_HANGING_SIGN,
    BIRCH_LEAVES,
    BIRCH_LOG,
    BIRCH_PLANKS,
    BIRCH_PRESSURE_PLATE,
    BIRCH_SAPLING,
    @DInfo(since = "1.21.9")
    BIRCH_SHELF,
    BIRCH_SIGN,
    BIRCH_SLAB,
    BIRCH_STAIRS,
    BIRCH_TRAPDOOR,
    @DInfo(since = "1.19.3")
    BIRCH_WALL_HANGING_SIGN,
    BIRCH_WALL_SIGN,
    BIRCH_WOOD,
    BLACKSTONE,
    BLACKSTONE_SLAB,
    BLACKSTONE_STAIRS,
    BLACKSTONE_WALL,
    BLACK_BANNER,
    BLACK_BED,
    @DInfo(since = "1.21.2")
    BLACK_BUNDLE,
    @DInfo(since = "1.17")
    BLACK_CANDLE,
    @DInfo(since = "1.17")
    BLACK_CANDLE_CAKE,
    BLACK_CARPET,
    BLACK_CONCRETE,
    BLACK_CONCRETE_POWDER,
    BLACK_DYE,
    BLACK_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    BLACK_HARNESS,
    BLACK_SHULKER_BOX,
    BLACK_STAINED_GLASS,
    BLACK_STAINED_GLASS_PANE,
    BLACK_TERRACOTTA,
    BLACK_WALL_BANNER,
    BLACK_WOOL,
    @DInfo(since = "1.20")
    BLADE_POTTERY_SHERD,
    BLAST_FURNACE,
    BLAZE_POWDER,
    BLAZE_ROD,
    BLAZE_SPAWN_EGG,
    BLUE_BANNER,
    BLUE_BED,
    @DInfo(since = "1.21.2")
    BLUE_BUNDLE,
    @DInfo(since = "1.17")
    BLUE_CANDLE,
    @DInfo(since = "1.17")
    BLUE_CANDLE_CAKE,
    BLUE_CARPET,
    BLUE_CONCRETE,
    BLUE_CONCRETE_POWDER,
    BLUE_DYE,
    @DInfo(since = "1.21.5")
    BLUE_EGG,
    BLUE_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    BLUE_HARNESS,
    BLUE_ICE,
    BLUE_ORCHID,
    BLUE_SHULKER_BOX,
    BLUE_STAINED_GLASS,
    BLUE_STAINED_GLASS_PANE,
    BLUE_TERRACOTTA,
    BLUE_WALL_BANNER,
    BLUE_WOOL,
    @DInfo(since = "1.20.5")
    BOGGED_SPAWN_EGG,
    @DInfo(since = "1.20.5")
    BOLT_ARMOR_TRIM_SMITHING_TEMPLATE,
    BONE,
    BONE_BLOCK,
    BONE_MEAL,
    BOOK,
    BOOKSHELF,
    @DInfo(since = "1.21.2")
    BORDURE_INDENTED_BANNER_PATTERN,
    BOW,
    BOWL,
    BRAIN_CORAL,
    BRAIN_CORAL_BLOCK,
    BRAIN_CORAL_FAN,
    BRAIN_CORAL_WALL_FAN,
    BREAD,
    @DInfo(since = "1.20.5")
    BREEZE_ROD,
    @DInfo(since = "1.20.3")
    BREEZE_SPAWN_EGG,
    @DInfo(since = "1.20")
    BREWER_POTTERY_SHERD,
    BREWING_STAND,
    BRICK,
    BRICKS,
    BRICK_SLAB,
    BRICK_STAIRS,
    BRICK_WALL,
    BROWN_BANNER,
    BROWN_BED,
    @DInfo(since = "1.21.2")
    BROWN_BUNDLE,
    @DInfo(since = "1.17")
    BROWN_CANDLE,
    @DInfo(since = "1.17")
    BROWN_CANDLE_CAKE,
    BROWN_CARPET,
    BROWN_CONCRETE,
    BROWN_CONCRETE_POWDER,
    BROWN_DYE,
    @DInfo(since = "1.21.5")
    BROWN_EGG,
    BROWN_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    BROWN_HARNESS,
    BROWN_MUSHROOM,
    BROWN_MUSHROOM_BLOCK,
    BROWN_SHULKER_BOX,
    BROWN_STAINED_GLASS,
    BROWN_STAINED_GLASS_PANE,
    BROWN_TERRACOTTA,
    BROWN_WALL_BANNER,
    BROWN_WOOL,
    @DInfo(since = "1.19.4")
    BRUSH,
    BUBBLE_COLUMN,
    BUBBLE_CORAL,
    BUBBLE_CORAL_BLOCK,
    BUBBLE_CORAL_FAN,
    BUBBLE_CORAL_WALL_FAN,
    BUCKET,
    @DInfo(since = "1.17")
    BUDDING_AMETHYST,
    @DInfo(since = "1.17")
    BUNDLE,
    @DInfo(since = "1.20")
    BURN_POTTERY_SHERD,
    @DInfo(since = "1.21.5")
    BUSH,
    CACTUS,
    @DInfo(since = "1.21.5")
    CACTUS_FLOWER,
    CAKE,
    @DInfo(since = "1.17")
    CALCITE,
    @DInfo(since = "1.20")
    CALIBRATED_SCULK_SENSOR,
    @DInfo(since = "1.21.11")
    CAMEL_HUSK_SPAWN_EGG,
    @DInfo(since = "1.19.3")
    CAMEL_SPAWN_EGG,
    CAMPFIRE,
    @DInfo(since = "1.17")
    CANDLE,
    @DInfo(since = "1.17")
    CANDLE_CAKE,
    CARROT,
    CARROTS,
    CARROT_ON_A_STICK,
    CARTOGRAPHY_TABLE,
    CARVED_PUMPKIN,
    CAT_SPAWN_EGG,
    CAULDRON,
    CAVE_AIR,
    CAVE_SPIDER_SPAWN_EGG,
    @DInfo(since = "1.17")
    CAVE_VINES,
    @DInfo(since = "1.17")
    CAVE_VINES_PLANT,
    CHAINMAIL_BOOTS,
    CHAINMAIL_CHESTPLATE,
    CHAINMAIL_HELMET,
    CHAINMAIL_LEGGINGS,
    CHAIN_COMMAND_BLOCK,
    CHARCOAL,
    @DInfo(since = "1.19.4")
    CHERRY_BOAT,
    @DInfo(since = "1.19.4")
    CHERRY_BUTTON,
    @DInfo(since = "1.19.4")
    CHERRY_CHEST_BOAT,
    @DInfo(since = "1.19.4")
    CHERRY_DOOR,
    @DInfo(since = "1.19.4")
    CHERRY_FENCE,
    @DInfo(since = "1.19.4")
    CHERRY_FENCE_GATE,
    @DInfo(since = "1.19.4")
    CHERRY_HANGING_SIGN,
    @DInfo(since = "1.19.4")
    CHERRY_LEAVES,
    @DInfo(since = "1.19.4")
    CHERRY_LOG,
    @DInfo(since = "1.19.4")
    CHERRY_PLANKS,
    @DInfo(since = "1.19.4")
    CHERRY_PRESSURE_PLATE,
    @DInfo(since = "1.19.4")
    CHERRY_SAPLING,
    @DInfo(since = "1.21.9")
    CHERRY_SHELF,
    @DInfo(since = "1.19.4")
    CHERRY_SIGN,
    @DInfo(since = "1.19.4")
    CHERRY_SLAB,
    @DInfo(since = "1.19.4")
    CHERRY_STAIRS,
    @DInfo(since = "1.19.4")
    CHERRY_TRAPDOOR,
    @DInfo(since = "1.19.4")
    CHERRY_WALL_HANGING_SIGN,
    @DInfo(since = "1.19.4")
    CHERRY_WALL_SIGN,
    @DInfo(since = "1.19.4")
    CHERRY_WOOD,
    CHEST,
    CHEST_MINECART,
    CHICKEN,
    CHICKEN_SPAWN_EGG,
    CHIPPED_ANVIL,
    @DInfo(since = "1.19.3")
    CHISELED_BOOKSHELF,
    @DInfo(since = "1.20.3")
    CHISELED_COPPER,
    @DInfo(since = "1.17")
    CHISELED_DEEPSLATE,
    CHISELED_NETHER_BRICKS,
    CHISELED_POLISHED_BLACKSTONE,
    CHISELED_QUARTZ_BLOCK,
    CHISELED_RED_SANDSTONE,
    @DInfo(since = "1.21.4")
    CHISELED_RESIN_BRICKS,
    CHISELED_SANDSTONE,
    CHISELED_STONE_BRICKS,
    @DInfo(since = "1.20.3")
    CHISELED_TUFF,
    @DInfo(since = "1.20.3")
    CHISELED_TUFF_BRICKS,
    CHORUS_FLOWER,
    CHORUS_FRUIT,
    CHORUS_PLANT,
    CLAY,
    CLAY_BALL,
    CLOCK,
    @DInfo(since = "1.21.4")
    CLOSED_EYEBLOSSOM,
    COAL,
    COAL_BLOCK,
    COAL_ORE,
    COARSE_DIRT,
    @DInfo(since = "1.19.4")
    COAST_ARMOR_TRIM_SMITHING_TEMPLATE,
    @DInfo(since = "1.17")
    COBBLED_DEEPSLATE,
    @DInfo(since = "1.17")
    COBBLED_DEEPSLATE_SLAB,
    @DInfo(since = "1.17")
    COBBLED_DEEPSLATE_STAIRS,
    @DInfo(since = "1.17")
    COBBLED_DEEPSLATE_WALL,
    COBBLESTONE,
    COBBLESTONE_SLAB,
    COBBLESTONE_STAIRS,
    COBBLESTONE_WALL,
    COBWEB,
    COCOA,
    COCOA_BEANS,
    COD,
    COD_BUCKET,
    COD_SPAWN_EGG,
    COMMAND_BLOCK,
    COMMAND_BLOCK_MINECART,
    COMPARATOR,
    COMPASS,
    COMPOSTER,
    CONDUIT,
    COOKED_BEEF,
    COOKED_CHICKEN,
    COOKED_COD,
    COOKED_MUTTON,
    COOKED_PORKCHOP,
    COOKED_RABBIT,
    COOKED_SALMON,
    COOKIE,
    @DInfo(since = "1.21.9")
    COPPER_AXE,
    @DInfo(since = "1.21.9")
    COPPER_BARS,
    COPPER_BLOCK,
    @DInfo(since = "1.21.9")
    COPPER_BOOTS,
    @DInfo(since = "1.20.3")
    COPPER_BULB,
    @DInfo(since = "1.21.9")
    COPPER_CHAIN,
    @DInfo(since = "1.21.9")
    COPPER_CHEST,
    @DInfo(since = "1.21.9")
    COPPER_CHESTPLATE,
    @DInfo(since = "1.20.3")
    COPPER_DOOR,
    @DInfo(since = "1.21.9")
    COPPER_GOLEM_SPAWN_EGG,
    @DInfo(since = "1.21.9")
    COPPER_GOLEM_STATUE,
    @DInfo(since = "1.20.3")
    COPPER_GRATE,
    @DInfo(since = "1.21.9")
    COPPER_HELMET,
    @DInfo(since = "1.21.9")
    COPPER_HOE,
    @DInfo(since = "1.21.9")
    COPPER_HORSE_ARMOR,
    COPPER_INGOT,
    @DInfo(since = "1.21.9")
    COPPER_LANTERN,
    @DInfo(since = "1.21.9")
    COPPER_LEGGINGS,
    @DInfo(since = "1.21.11")
    COPPER_NAUTILUS_ARMOR,
    @DInfo(since = "1.21.9")
    COPPER_NUGGET,
    @DInfo(since = "1.17")
    COPPER_ORE,
    @DInfo(since = "1.21.9")
    COPPER_PICKAXE,
    @DInfo(since = "1.21.9")
    COPPER_SHOVEL,
    @DInfo(since = "1.21.11")
    COPPER_SPEAR,
    @DInfo(since = "1.21.9")
    COPPER_SWORD,
    @DInfo(since = "1.21.9")
    COPPER_TORCH,
    @DInfo(since = "1.20.3")
    COPPER_TRAPDOOR,
    @DInfo(since = "1.21.9")
    COPPER_WALL_TORCH,
    CORNFLOWER,
    COW_SPAWN_EGG,
    @DInfo(since = "1.17")
    CRACKED_DEEPSLATE_BRICKS,
    @DInfo(since = "1.17")
    CRACKED_DEEPSLATE_TILES,
    CRACKED_NETHER_BRICKS,
    CRACKED_POLISHED_BLACKSTONE_BRICKS,
    CRACKED_STONE_BRICKS,
    @DInfo(since = "1.20.3")
    CRAFTER,
    CRAFTING_TABLE,
    @DInfo(since = "1.21.2")
    CREAKING_HEART,
    @DInfo(since = "1.21.2")
    CREAKING_SPAWN_EGG,
    CREEPER_BANNER_PATTERN,
    CREEPER_HEAD,
    CREEPER_SPAWN_EGG,
    CREEPER_WALL_HEAD,
    CRIMSON_BUTTON,
    CRIMSON_DOOR,
    CRIMSON_FENCE,
    CRIMSON_FENCE_GATE,
    CRIMSON_FUNGUS,
    @DInfo(since = "1.19.3")
    CRIMSON_HANGING_SIGN,
    CRIMSON_HYPHAE,
    CRIMSON_NYLIUM,
    CRIMSON_PLANKS,
    CRIMSON_PRESSURE_PLATE,
    CRIMSON_ROOTS,
    @DInfo(since = "1.21.9")
    CRIMSON_SHELF,
    CRIMSON_SIGN,
    CRIMSON_SLAB,
    CRIMSON_STAIRS,
    CRIMSON_STEM,
    CRIMSON_TRAPDOOR,
    @DInfo(since = "1.19.3")
    CRIMSON_WALL_HANGING_SIGN,
    CRIMSON_WALL_SIGN,
    CROSSBOW,
    CRYING_OBSIDIAN,
    @DInfo(since = "1.17")
    CUT_COPPER,
    CUT_COPPER_SLAB,
    CUT_COPPER_STAIRS,
    CUT_RED_SANDSTONE,
    CUT_RED_SANDSTONE_SLAB,
    CUT_SANDSTONE,
    CUT_SANDSTONE_SLAB,
    CYAN_BANNER,
    CYAN_BED,
    @DInfo(since = "1.21.2")
    CYAN_BUNDLE,
    @DInfo(since = "1.17")
    CYAN_CANDLE,
    @DInfo(since = "1.17")
    CYAN_CANDLE_CAKE,
    CYAN_CARPET,
    CYAN_CONCRETE,
    CYAN_CONCRETE_POWDER,
    CYAN_DYE,
    CYAN_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    CYAN_HARNESS,
    CYAN_SHULKER_BOX,
    CYAN_STAINED_GLASS,
    CYAN_STAINED_GLASS_PANE,
    CYAN_TERRACOTTA,
    CYAN_WALL_BANNER,
    CYAN_WOOL,
    DAMAGED_ANVIL,
    DANDELION,
    @DInfo(since = "1.20")
    DANGER_POTTERY_SHERD,
    DARK_OAK_BOAT,
    DARK_OAK_BUTTON,
    DARK_OAK_CHEST_BOAT,
    DARK_OAK_DOOR,
    DARK_OAK_FENCE,
    DARK_OAK_FENCE_GATE,
    @DInfo(since = "1.19.3")
    DARK_OAK_HANGING_SIGN,
    DARK_OAK_LEAVES,
    DARK_OAK_LOG,
    DARK_OAK_PLANKS,
    DARK_OAK_PRESSURE_PLATE,
    DARK_OAK_SAPLING,
    @DInfo(since = "1.21.9")
    DARK_OAK_SHELF,
    DARK_OAK_SIGN,
    DARK_OAK_SLAB,
    DARK_OAK_STAIRS,
    DARK_OAK_TRAPDOOR,
    @DInfo(since = "1.19.3")
    DARK_OAK_WALL_HANGING_SIGN,
    DARK_OAK_WALL_SIGN,
    DARK_OAK_WOOD,
    DARK_PRISMARINE,
    DARK_PRISMARINE_SLAB,
    DARK_PRISMARINE_STAIRS,
    DAYLIGHT_DETECTOR,
    DEAD_BRAIN_CORAL,
    DEAD_BRAIN_CORAL_BLOCK,
    DEAD_BRAIN_CORAL_FAN,
    DEAD_BRAIN_CORAL_WALL_FAN,
    DEAD_BUBBLE_CORAL,
    DEAD_BUBBLE_CORAL_BLOCK,
    DEAD_BUBBLE_CORAL_FAN,
    DEAD_BUBBLE_CORAL_WALL_FAN,
    DEAD_BUSH,
    DEAD_FIRE_CORAL,
    DEAD_FIRE_CORAL_BLOCK,
    DEAD_FIRE_CORAL_FAN,
    DEAD_FIRE_CORAL_WALL_FAN,
    DEAD_HORN_CORAL,
    DEAD_HORN_CORAL_BLOCK,
    DEAD_HORN_CORAL_FAN,
    DEAD_HORN_CORAL_WALL_FAN,
    DEAD_TUBE_CORAL,
    DEAD_TUBE_CORAL_BLOCK,
    DEAD_TUBE_CORAL_FAN,
    DEAD_TUBE_CORAL_WALL_FAN,
    DEBUG_STICK,
    @DInfo(since = "1.19.4")
    DECORATED_POT,
    @DInfo(since = "1.17")
    DEEPSLATE,
    @DInfo(since = "1.17")
    DEEPSLATE_BRICKS,
    @DInfo(since = "1.17")
    DEEPSLATE_BRICK_SLAB,
    @DInfo(since = "1.17")
    DEEPSLATE_BRICK_STAIRS,
    @DInfo(since = "1.17")
    DEEPSLATE_BRICK_WALL,
    @DInfo(since = "1.17")
    DEEPSLATE_COAL_ORE,
    @DInfo(since = "1.17")
    DEEPSLATE_COPPER_ORE,
    @DInfo(since = "1.17")
    DEEPSLATE_DIAMOND_ORE,
    @DInfo(since = "1.17")
    DEEPSLATE_EMERALD_ORE,
    @DInfo(since = "1.17")
    DEEPSLATE_GOLD_ORE,
    @DInfo(since = "1.17")
    DEEPSLATE_IRON_ORE,
    @DInfo(since = "1.17")
    DEEPSLATE_LAPIS_ORE,
    @DInfo(since = "1.17")
    DEEPSLATE_REDSTONE_ORE,
    DEEPSLATE_TILES,
    @DInfo(since = "1.17")
    DEEPSLATE_TILE_SLAB,
    @DInfo(since = "1.17")
    DEEPSLATE_TILE_STAIRS,
    @DInfo(since = "1.17")
    DEEPSLATE_TILE_WALL,
    DETECTOR_RAIL,
    DIAMOND,
    DIAMOND_AXE,
    DIAMOND_BLOCK,
    DIAMOND_BOOTS,
    DIAMOND_CHESTPLATE,
    DIAMOND_HELMET,
    DIAMOND_HOE,
    DIAMOND_HORSE_ARMOR,
    DIAMOND_LEGGINGS,
    @DInfo(since = "1.21.11")
    DIAMOND_NAUTILUS_ARMOR,
    DIAMOND_ORE,
    DIAMOND_PICKAXE,
    DIAMOND_SHOVEL,
    @DInfo(since = "1.21.11")
    DIAMOND_SPEAR,
    DIAMOND_SWORD,
    DIORITE,
    DIORITE_SLAB,
    DIORITE_STAIRS,
    DIORITE_WALL,
    DIRT,
    @DRenamed(since = "1.17", from = "GRASS_PATH")
    DIRT_PATH,
    @DInfo(since = "1.19")
    DISC_FRAGMENT_5,
    DISPENSER,
    DOLPHIN_SPAWN_EGG,
    DONKEY_SPAWN_EGG,
    DRAGON_BREATH,
    DRAGON_EGG,
    DRAGON_HEAD,
    DRAGON_WALL_HEAD,
    @DInfo(since = "1.21.6")
    DRIED_GHAST,
    DRIED_KELP,
    DRIED_KELP_BLOCK,
    @DInfo(since = "1.17")
    DRIPSTONE_BLOCK,
    DROPPER,
    DROWNED_SPAWN_EGG,
    @DInfo(since = "1.19.4")
    DUNE_ARMOR_TRIM_SMITHING_TEMPLATE,
    @DInfo(since = "1.19")
    ECHO_SHARD,
    EGG,
    ELDER_GUARDIAN_SPAWN_EGG,
    ELYTRA,
    EMERALD,
    EMERALD_BLOCK,
    EMERALD_ORE,
    ENCHANTED_BOOK,
    ENCHANTED_GOLDEN_APPLE,
    ENCHANTING_TABLE,
    ENDERMAN_SPAWN_EGG,
    ENDERMITE_SPAWN_EGG,
    ENDER_CHEST,
    @DInfo(since = "1.19.3")
    ENDER_DRAGON_SPAWN_EGG,
    ENDER_EYE,
    ENDER_PEARL,
    END_CRYSTAL,
    END_GATEWAY,
    END_PORTAL,
    END_PORTAL_FRAME,
    END_ROD,
    END_STONE,
    END_STONE_BRICKS,
    END_STONE_BRICK_SLAB,
    END_STONE_BRICK_STAIRS,
    END_STONE_BRICK_WALL,
    EVOKER_SPAWN_EGG,
    EXPERIENCE_BOTTLE,
    @DInfo(since = "1.20")
    EXPLORER_POTTERY_SHERD,
    @DInfo(since = "1.20.3")
    EXPOSED_CHISELED_COPPER,
    @DInfo(since = "1.17")
    EXPOSED_COPPER,
    @DInfo(since = "1.21.9")
    EXPOSED_COPPER_BARS,
    @DInfo(since = "1.20.3")
    EXPOSED_COPPER_BULB,
    @DInfo(since = "1.21.9")
    EXPOSED_COPPER_CHAIN,
    @DInfo(since = "1.21.9")
    EXPOSED_COPPER_CHEST,
    @DInfo(since = "1.20.3")
    EXPOSED_COPPER_DOOR,
    @DInfo(since = "1.21.9")
    EXPOSED_COPPER_GOLEM_STATUE,
    @DInfo(since = "1.20.3")
    EXPOSED_COPPER_GRATE,
    @DInfo(since = "1.21.9")
    EXPOSED_COPPER_LANTERN,
    @DInfo(since = "1.20.3")
    EXPOSED_COPPER_TRAPDOOR,
    @DInfo(since = "1.17")
    EXPOSED_CUT_COPPER,
    @DInfo(since = "1.17")
    EXPOSED_CUT_COPPER_SLAB,
    @DInfo(since = "1.17")
    EXPOSED_CUT_COPPER_STAIRS,
    @DInfo(since = "1.21.9")
    EXPOSED_LIGHTNING_ROD,
    @DInfo(since = "1.19.4")
    EYE_ARMOR_TRIM_SMITHING_TEMPLATE,
    FARMLAND,
    FEATHER,
    FERMENTED_SPIDER_EYE,
    FERN,
    @DInfo(since = "1.21.2")
    FIELD_MASONED_BANNER_PATTERN,
    FILLED_MAP,
    FIRE,
    @DInfo(since = "1.21.5")
    FIREFLY_BUSH,
    FIREWORK_ROCKET,
    FIREWORK_STAR,
    FIRE_CHARGE,
    FIRE_CORAL,
    FIRE_CORAL_BLOCK,
    FIRE_CORAL_FAN,
    FIRE_CORAL_WALL_FAN,
    FISHING_ROD,
    FLETCHING_TABLE,
    FLINT,
    FLINT_AND_STEEL,
    @DInfo(since = "1.17")
    FLOWERING_AZALEA,
    @DInfo(since = "1.17")
    FLOWERING_AZALEA_LEAVES,
    FLOWER_BANNER_PATTERN,
    FLOWER_POT,
    @DInfo(since = "1.20.5")
    FLOW_ARMOR_TRIM_SMITHING_TEMPLATE,
    @DInfo(since = "1.20.5")
    FLOW_BANNER_PATTERN,
    @DInfo(since = "1.20.5")
    FLOW_POTTERY_SHERD,
    FOX_SPAWN_EGG,
    @DInfo(since = "1.20")
    FRIEND_POTTERY_SHERD,
    @DInfo(since = "1.19")
    FROGSPAWN,
    @DInfo(since = "1.19")
    FROG_SPAWN_EGG,
    FROSTED_ICE,
    FURNACE,
    FURNACE_MINECART,
    GHAST_SPAWN_EGG,
    GHAST_TEAR,
    GILDED_BLACKSTONE,
    GLASS,
    GLASS_BOTTLE,
    GLASS_PANE,
    GLISTERING_MELON_SLICE,
    GLOBE_BANNER_PATTERN,
    GLOWSTONE,
    GLOWSTONE_DUST,
    @DInfo(since = "1.17")
    GLOW_BERRIES,
    @DInfo(since = "1.17")
    GLOW_INK_SAC,
    @DInfo(since = "1.17")
    GLOW_ITEM_FRAME,
    @DInfo(since = "1.17")
    GLOW_LICHEN,
    @DInfo(since = "1.17")
    GLOW_SQUID_SPAWN_EGG,
    @DInfo(since = "1.19")
    GOAT_HORN,
    @DInfo(since = "1.17")
    GOAT_SPAWN_EGG,
    GOLDEN_APPLE,
    GOLDEN_AXE,
    GOLDEN_BOOTS,
    GOLDEN_CARROT,
    GOLDEN_CHESTPLATE,
    GOLDEN_HELMET,
    GOLDEN_HOE,
    GOLDEN_HORSE_ARMOR,
    GOLDEN_LEGGINGS,
    @DInfo(since = "1.21.11")
    GOLDEN_NAUTILUS_ARMOR,
    GOLDEN_PICKAXE,
    GOLDEN_SHOVEL,
    @DInfo(since = "1.21.11")
    GOLDEN_SPEAR,
    GOLDEN_SWORD,
    GOLD_BLOCK,
    GOLD_INGOT,
    GOLD_NUGGET,
    GOLD_ORE,
    GRANITE,
    GRANITE_SLAB,
    GRANITE_STAIRS,
    GRANITE_WALL,
    GRASS_BLOCK,
    GRAVEL,
    GRAY_BANNER,
    GRAY_BED,
    @DInfo(since = "1.21.2")
    GRAY_BUNDLE,
    @DInfo(since = "1.17")
    GRAY_CANDLE,
    @DInfo(since = "1.17")
    GRAY_CANDLE_CAKE,
    GRAY_CARPET,
    GRAY_CONCRETE,
    GRAY_CONCRETE_POWDER,
    GRAY_DYE,
    GRAY_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    GRAY_HARNESS,
    GRAY_SHULKER_BOX,
    GRAY_STAINED_GLASS,
    GRAY_STAINED_GLASS_PANE,
    GRAY_TERRACOTTA,
    GRAY_WALL_BANNER,
    GRAY_WOOL,
    GREEN_BANNER,
    GREEN_BED,
    @DInfo(since = "1.21.2")
    GREEN_BUNDLE,
    @DInfo(since = "1.17")
    GREEN_CANDLE,
    @DInfo(since = "1.17")
    GREEN_CANDLE_CAKE,
    GREEN_CARPET,
    GREEN_CONCRETE,
    GREEN_CONCRETE_POWDER,
    GREEN_DYE,
    GREEN_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    GREEN_HARNESS,
    GREEN_SHULKER_BOX,
    GREEN_STAINED_GLASS,
    GREEN_STAINED_GLASS_PANE,
    GREEN_TERRACOTTA,
    GREEN_WALL_BANNER,
    GREEN_WOOL,
    GRINDSTONE,
    GUARDIAN_SPAWN_EGG,
    GUNPOWDER,
    @DInfo(since = "1.20.5")
    GUSTER_BANNER_PATTERN,
    @DInfo(since = "1.20.5")
    GUSTER_POTTERY_SHERD,
    @DInfo(since = "1.17")
    HANGING_ROOTS,
    @DInfo(since = "1.21.6")
    HAPPY_GHAST_SPAWN_EGG,
    HAY_BLOCK,
    @DInfo(since = "1.20")
    HEARTBREAK_POTTERY_SHERD,
    HEART_OF_THE_SEA,
    @DInfo(since = "1.20")
    HEART_POTTERY_SHERD,
    @DInfo(since = "1.20.5")
    HEAVY_CORE,
    HEAVY_WEIGHTED_PRESSURE_PLATE,
    HOGLIN_SPAWN_EGG,
    HONEYCOMB,
    HONEYCOMB_BLOCK,
    HONEY_BLOCK,
    HONEY_BOTTLE,
    HOPPER,
    HOPPER_MINECART,
    HORN_CORAL,
    HORN_CORAL_BLOCK,
    HORN_CORAL_FAN,
    HORN_CORAL_WALL_FAN,
    HORSE_SPAWN_EGG,
    @DInfo(since = "1.20")
    HOST_ARMOR_TRIM_SMITHING_TEMPLATE,
    @DInfo(since = "1.20")
    HOWL_POTTERY_SHERD,
    HUSK_SPAWN_EGG,
    ICE,
    INFESTED_CHISELED_STONE_BRICKS,
    INFESTED_COBBLESTONE,
    INFESTED_CRACKED_STONE_BRICKS,
    @DInfo(since = "1.17")
    INFESTED_DEEPSLATE,
    INFESTED_MOSSY_STONE_BRICKS,
    INFESTED_STONE,
    INFESTED_STONE_BRICKS,
    INK_SAC,
    IRON_AXE,
    IRON_BARS,
    IRON_BLOCK,
    IRON_BOOTS,
    @DRenamed(since = "1.21.9", from = "CHAIN")
    IRON_CHAIN,
    IRON_CHESTPLATE,
    IRON_DOOR,
    @DInfo(since = "1.19.3")
    IRON_GOLEM_SPAWN_EGG,
    IRON_HELMET,
    IRON_HOE,
    IRON_HORSE_ARMOR,
    IRON_INGOT,
    IRON_LEGGINGS,
    @DInfo(since = "1.21.11")
    IRON_NAUTILUS_ARMOR,
    IRON_NUGGET,
    IRON_ORE,
    IRON_PICKAXE,
    IRON_SHOVEL,
    @DInfo(since = "1.21.11")
    IRON_SPEAR,
    IRON_SWORD,
    IRON_TRAPDOOR,
    ITEM_FRAME,
    JACK_O_LANTERN,
    JIGSAW,
    JUKEBOX,
    JUNGLE_BOAT,
    JUNGLE_BUTTON,
    JUNGLE_CHEST_BOAT,
    JUNGLE_DOOR,
    JUNGLE_FENCE,
    JUNGLE_FENCE_GATE,
    @DInfo(since = "1.19.3")
    JUNGLE_HANGING_SIGN,
    JUNGLE_LEAVES,
    JUNGLE_LOG,
    JUNGLE_PLANKS,
    JUNGLE_PRESSURE_PLATE,
    JUNGLE_SAPLING,
    @DInfo(since = "1.21.9")
    JUNGLE_SHELF,
    JUNGLE_SIGN,
    JUNGLE_SLAB,
    JUNGLE_STAIRS,
    JUNGLE_TRAPDOOR,
    @DInfo(since = "1.19.3")
    JUNGLE_WALL_HANGING_SIGN,
    JUNGLE_WALL_SIGN,
    JUNGLE_WOOD,
    KELP,
    KELP_PLANT,
    KNOWLEDGE_BOOK,
    LADDER,
    LANTERN,
    LAPIS_BLOCK,
    LAPIS_LAZULI,
    LAPIS_ORE,
    @DInfo(since = "1.17")
    LARGE_AMETHYST_BUD,
    LARGE_FERN,
    LAVA,
    LAVA_BUCKET,
    @DInfo(since = "1.17")
    LAVA_CAULDRON,
    LEAD,
    @DInfo(since = "1.21.5")
    LEAF_LITTER,
    LEATHER,
    LEATHER_BOOTS,
    LEATHER_CHESTPLATE,
    LEATHER_HELMET,
    LEATHER_HORSE_ARMOR,
    LEATHER_LEGGINGS,
    LECTERN,
    LEVER,
    @DInfo(since = "1.17")
    LIGHT,
    @DInfo(since = "1.17")
    LIGHTNING_ROD,
    LIGHT_BLUE_BANNER,
    LIGHT_BLUE_BED,
    @DInfo(since = "1.21.2")
    LIGHT_BLUE_BUNDLE,
    @DInfo(since = "1.17")
    LIGHT_BLUE_CANDLE,
    @DInfo(since = "1.17")
    LIGHT_BLUE_CANDLE_CAKE,
    LIGHT_BLUE_CARPET,
    LIGHT_BLUE_CONCRETE,
    LIGHT_BLUE_CONCRETE_POWDER,
    LIGHT_BLUE_DYE,
    LIGHT_BLUE_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    LIGHT_BLUE_HARNESS,
    LIGHT_BLUE_SHULKER_BOX,
    LIGHT_BLUE_STAINED_GLASS,
    LIGHT_BLUE_STAINED_GLASS_PANE,
    LIGHT_BLUE_TERRACOTTA,
    LIGHT_BLUE_WALL_BANNER,
    LIGHT_BLUE_WOOL,
    LIGHT_GRAY_BANNER,
    LIGHT_GRAY_BED,
    @DInfo(since = "1.21.2")
    LIGHT_GRAY_BUNDLE,
    @DInfo(since = "1.17")
    LIGHT_GRAY_CANDLE,
    @DInfo(since = "1.17")
    LIGHT_GRAY_CANDLE_CAKE,
    LIGHT_GRAY_CARPET,
    LIGHT_GRAY_CONCRETE,
    LIGHT_GRAY_CONCRETE_POWDER,
    LIGHT_GRAY_DYE,
    LIGHT_GRAY_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    LIGHT_GRAY_HARNESS,
    LIGHT_GRAY_SHULKER_BOX,
    LIGHT_GRAY_STAINED_GLASS,
    LIGHT_GRAY_STAINED_GLASS_PANE,
    LIGHT_GRAY_TERRACOTTA,
    LIGHT_GRAY_WALL_BANNER,
    LIGHT_GRAY_WOOL,
    LIGHT_WEIGHTED_PRESSURE_PLATE,
    LILAC,
    LILY_OF_THE_VALLEY,
    LILY_PAD,
    LIME_BANNER,
    LIME_BED,
    @DInfo(since = "1.21.2")
    LIME_BUNDLE,
    @DInfo(since = "1.17")
    LIME_CANDLE,
    @DInfo(since = "1.17")
    LIME_CANDLE_CAKE,
    LIME_CARPET,
    LIME_CONCRETE,
    LIME_CONCRETE_POWDER,
    LIME_DYE,
    LIME_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    LIME_HARNESS,
    LIME_SHULKER_BOX,
    LIME_STAINED_GLASS,
    LIME_STAINED_GLASS_PANE,
    LIME_TERRACOTTA,
    LIME_WALL_BANNER,
    LIME_WOOL,
    LINGERING_POTION,
    LLAMA_SPAWN_EGG,
    LODESTONE,
    LOOM,
    @DInfo(since = "1.20.5")
    MACE,
    MAGENTA_BANNER,
    MAGENTA_BED,
    @DInfo(since = "1.21.2")
    MAGENTA_BUNDLE,
    @DInfo(since = "1.17")
    MAGENTA_CANDLE,
    @DInfo(since = "1.17")
    MAGENTA_CANDLE_CAKE,
    MAGENTA_CARPET,
    MAGENTA_CONCRETE,
    MAGENTA_CONCRETE_POWDER,
    MAGENTA_DYE,
    MAGENTA_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    MAGENTA_HARNESS,
    MAGENTA_SHULKER_BOX,
    MAGENTA_STAINED_GLASS,
    MAGENTA_STAINED_GLASS_PANE,
    MAGENTA_TERRACOTTA,
    MAGENTA_WALL_BANNER,
    MAGENTA_WOOL,
    MAGMA_BLOCK,
    MAGMA_CREAM,
    MAGMA_CUBE_SPAWN_EGG,
    @DInfo(since = "1.19")
    MANGROVE_BOAT,
    @DInfo(since = "1.19")
    MANGROVE_BUTTON,
    @DInfo(since = "1.19")
    MANGROVE_CHEST_BOAT,
    @DInfo(since = "1.19")
    MANGROVE_DOOR,
    @DInfo(since = "1.19")
    MANGROVE_FENCE,
    @DInfo(since = "1.19")
    MANGROVE_FENCE_GATE,
    @DInfo(since = "1.19.3")
    MANGROVE_HANGING_SIGN,
    @DInfo(since = "1.19")
    MANGROVE_LEAVES,
    @DInfo(since = "1.19")
    MANGROVE_LOG,
    @DInfo(since = "1.19")
    MANGROVE_PLANKS,
    @DInfo(since = "1.19")
    MANGROVE_PRESSURE_PLATE,
    @DInfo(since = "1.19")
    MANGROVE_PROPAGULE,
    @DInfo(since = "1.19")
    MANGROVE_ROOTS,
    @DInfo(since = "1.21.9")
    MANGROVE_SHELF,
    @DInfo(since = "1.19")
    MANGROVE_SIGN,
    @DInfo(since = "1.19")
    MANGROVE_SLAB,
    @DInfo(since = "1.19")
    MANGROVE_STAIRS,
    @DInfo(since = "1.19")
    MANGROVE_TRAPDOOR,
    @DInfo(since = "1.19.3")
    MANGROVE_WALL_HANGING_SIGN,
    @DInfo(since = "1.19")
    MANGROVE_WALL_SIGN,
    @DInfo(since = "1.19")
    MANGROVE_WOOD,
    MAP,
    @DInfo(since = "1.17")
    MEDIUM_AMETHYST_BUD,
    MELON,
    MELON_SEEDS,
    MELON_SLICE,
    MELON_STEM,
    MILK_BUCKET,
    MINECART,
    @DInfo(since = "1.20")
    MINER_POTTERY_SHERD,
    MOJANG_BANNER_PATTERN,
    MOOSHROOM_SPAWN_EGG,
    MOSSY_COBBLESTONE,
    MOSSY_COBBLESTONE_SLAB,
    MOSSY_COBBLESTONE_STAIRS,
    MOSSY_COBBLESTONE_WALL,
    MOSSY_STONE_BRICKS,
    MOSSY_STONE_BRICK_SLAB,
    MOSSY_STONE_BRICK_STAIRS,
    MOSSY_STONE_BRICK_WALL,
    @DInfo(since = "1.17")
    MOSS_BLOCK,
    @DInfo(since = "1.17")
    MOSS_CARPET,
    @DInfo(since = "1.20")
    MOURNER_POTTERY_SHERD,
    MOVING_PISTON,
    @DInfo(since = "1.19")
    MUD,
    @DInfo(since = "1.19")
    MUDDY_MANGROVE_ROOTS,
    @DInfo(since = "1.19")
    MUD_BRICKS,
    @DInfo(since = "1.19")
    MUD_BRICK_SLAB,
    @DInfo(since = "1.19")
    MUD_BRICK_STAIRS,
    @DInfo(since = "1.19")
    MUD_BRICK_WALL,
    MULE_SPAWN_EGG,
    MUSHROOM_STEM,
    MUSHROOM_STEW,
    MUSIC_DISC_11,
    MUSIC_DISC_13,
    @DInfo(since = "1.19")
    MUSIC_DISC_5,
    MUSIC_DISC_BLOCKS,
    MUSIC_DISC_CAT,
    MUSIC_DISC_CHIRP,
    @DInfo(since = "1.21")
    MUSIC_DISC_CREATOR,
    @DInfo(since = "1.21")
    MUSIC_DISC_CREATOR_MUSIC_BOX,
    MUSIC_DISC_FAR,
    @DInfo(since = "1.21.7")
    MUSIC_DISC_LAVA_CHICKEN,
    MUSIC_DISC_MALL,
    MUSIC_DISC_MELLOHI,
    @DInfo(since = "1.18")
    MUSIC_DISC_OTHERSIDE,
    MUSIC_DISC_PIGSTEP,
    @DInfo(since = "1.21")
    MUSIC_DISC_PRECIPICE,
    @DInfo(since = "1.20")
    MUSIC_DISC_RELIC,
    MUSIC_DISC_STAL,
    MUSIC_DISC_STRAD,
    @DInfo(since = "1.21.6")
    MUSIC_DISC_TEARS,
    MUSIC_DISC_WAIT,
    MUSIC_DISC_WARD,
    MUTTON,
    MYCELIUM,
    NAME_TAG,
    NAUTILUS_SHELL,
    @DInfo(since = "1.21.11")
    NAUTILUS_SPAWN_EGG,
    NETHERITE_AXE,
    NETHERITE_BLOCK,
    NETHERITE_BOOTS,
    NETHERITE_CHESTPLATE,
    NETHERITE_HELMET,
    NETHERITE_HOE,
    @DInfo(since = "1.21.11")
    NETHERITE_HORSE_ARMOR,
    NETHERITE_INGOT,
    NETHERITE_LEGGINGS,
    @DInfo(since = "1.21.11")
    NETHERITE_NAUTILUS_ARMOR,
    NETHERITE_PICKAXE,
    NETHERITE_SCRAP,
    NETHERITE_SHOVEL,
    @DInfo(since = "1.21.11")
    NETHERITE_SPEAR,
    NETHERITE_SWORD,
    @DInfo(since = "1.19.4")
    NETHERITE_UPGRADE_SMITHING_TEMPLATE,
    NETHERRACK,
    NETHER_BRICK,
    NETHER_BRICKS,
    NETHER_BRICK_FENCE,
    NETHER_BRICK_SLAB,
    NETHER_BRICK_STAIRS,
    NETHER_BRICK_WALL,
    NETHER_GOLD_ORE,
    NETHER_PORTAL,
    NETHER_QUARTZ_ORE,
    NETHER_SPROUTS,
    NETHER_STAR,
    NETHER_WART,
    NETHER_WART_BLOCK,
    NOTE_BLOCK,
    OAK_BOAT,
    OAK_BUTTON,
    OAK_CHEST_BOAT,
    OAK_DOOR,
    OAK_FENCE,
    OAK_FENCE_GATE,
    @DInfo(since = "1.19.3")
    OAK_HANGING_SIGN,
    OAK_LEAVES,
    OAK_LOG,
    OAK_PLANKS,
    OAK_PRESSURE_PLATE,
    OAK_SAPLING,
    @DInfo(since = "1.21.9")
    OAK_SHELF,
    OAK_SIGN,
    OAK_SLAB,
    OAK_STAIRS,
    OAK_TRAPDOOR,
    @DInfo(since = "1.19.3")
    OAK_WALL_HANGING_SIGN,
    OAK_WALL_SIGN,
    OAK_WOOD,
    OBSERVER,
    OBSIDIAN,
    OCELOT_SPAWN_EGG,
    @DInfo(since = "1.19")
    OCHRE_FROGLIGHT,
    @DInfo(since = "1.20.5")
    OMINOUS_BOTTLE,
    @DInfo(since = "1.20.5")
    OMINOUS_TRIAL_KEY,
    @DInfo(since = "1.21.4")
    OPEN_EYEBLOSSOM,
    ORANGE_BANNER,
    ORANGE_BED,
    @DInfo(since = "1.21.2")
    ORANGE_BUNDLE,
    @DInfo(since = "1.17")
    ORANGE_CANDLE,
    @DInfo(since = "1.17")
    ORANGE_CANDLE_CAKE,
    ORANGE_CARPET,
    ORANGE_CONCRETE,
    ORANGE_CONCRETE_POWDER,
    ORANGE_DYE,
    ORANGE_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    ORANGE_HARNESS,
    ORANGE_SHULKER_BOX,
    ORANGE_STAINED_GLASS,
    ORANGE_STAINED_GLASS_PANE,
    ORANGE_TERRACOTTA,
    ORANGE_TULIP,
    ORANGE_WALL_BANNER,
    ORANGE_WOOL,
    OXEYE_DAISY,
    @DInfo(since = "1.20.3")
    OXIDIZED_CHISELED_COPPER,
    @DInfo(since = "1.17")
    OXIDIZED_COPPER,
    @DInfo(since = "1.21.9")
    OXIDIZED_COPPER_BARS,
    @DInfo(since = "1.20.3")
    OXIDIZED_COPPER_BULB,
    @DInfo(since = "1.21.9")
    OXIDIZED_COPPER_CHAIN,
    @DInfo(since = "1.21.9")
    OXIDIZED_COPPER_CHEST,
    @DInfo(since = "1.20.3")
    OXIDIZED_COPPER_DOOR,
    @DInfo(since = "1.21.9")
    OXIDIZED_COPPER_GOLEM_STATUE,
    @DInfo(since = "1.20.3")
    OXIDIZED_COPPER_GRATE,
    @DInfo(since = "1.21.9")
    OXIDIZED_COPPER_LANTERN,
    @DInfo(since = "1.20.3")
    OXIDIZED_COPPER_TRAPDOOR,
    @DInfo(since = "1.17")
    OXIDIZED_CUT_COPPER,
    @DInfo(since = "1.17")
    OXIDIZED_CUT_COPPER_SLAB,
    @DInfo(since = "1.17")
    OXIDIZED_CUT_COPPER_STAIRS,
    @DInfo(since = "1.21.9")
    OXIDIZED_LIGHTNING_ROD,
    PACKED_ICE,
    @DInfo(since = "1.19")
    PACKED_MUD,
    PAINTING,
    @DInfo(since = "1.21.2")
    PALE_HANGING_MOSS,
    @DInfo(since = "1.21.2")
    PALE_MOSS_BLOCK,
    @DInfo(since = "1.21.2")
    PALE_MOSS_CARPET,
    @DInfo(since = "1.21.2")
    PALE_OAK_BOAT,
    @DInfo(since = "1.21.2")
    PALE_OAK_BUTTON,
    @DInfo(since = "1.21.2")
    PALE_OAK_CHEST_BOAT,
    @DInfo(since = "1.21.2")
    PALE_OAK_DOOR,
    @DInfo(since = "1.21.2")
    PALE_OAK_FENCE,
    @DInfo(since = "1.21.2")
    PALE_OAK_FENCE_GATE,
    @DInfo(since = "1.21.2")
    PALE_OAK_HANGING_SIGN,
    @DInfo(since = "1.21.2")
    PALE_OAK_LEAVES,
    @DInfo(since = "1.21.2")
    PALE_OAK_LOG,
    @DInfo(since = "1.21.2")
    PALE_OAK_PLANKS,
    @DInfo(since = "1.21.2")
    PALE_OAK_PRESSURE_PLATE,
    @DInfo(since = "1.21.2")
    PALE_OAK_SAPLING,
    @DInfo(since = "1.21.9")
    PALE_OAK_SHELF,
    @DInfo(since = "1.21.2")
    PALE_OAK_SIGN,
    @DInfo(since = "1.21.2")
    PALE_OAK_SLAB,
    @DInfo(since = "1.21.2")
    PALE_OAK_STAIRS,
    @DInfo(since = "1.21.2")
    PALE_OAK_TRAPDOOR,
    @DInfo(since = "1.21.2")
    PALE_OAK_WALL_HANGING_SIGN,
    @DInfo(since = "1.21.2")
    PALE_OAK_WALL_SIGN,
    @DInfo(since = "1.21.2")
    PALE_OAK_WOOD,
    PANDA_SPAWN_EGG,
    PAPER,
    @DInfo(since = "1.21.11")
    PARCHED_SPAWN_EGG,
    PARROT_SPAWN_EGG,
    @DInfo(since = "1.19")
    PEARLESCENT_FROGLIGHT,
    PEONY,
    PETRIFIED_OAK_SLAB,
    PHANTOM_MEMBRANE,
    PHANTOM_SPAWN_EGG,
    PIGLIN_BANNER_PATTERN,
    @DInfo(since = "1.16.2")
    PIGLIN_BRUTE_SPAWN_EGG,
    @DInfo(since = "1.19.3")
    PIGLIN_HEAD,
    PIGLIN_SPAWN_EGG,
    @DInfo(since = "1.19.3")
    PIGLIN_WALL_HEAD,
    PIG_SPAWN_EGG,
    PILLAGER_SPAWN_EGG,
    PINK_BANNER,
    PINK_BED,
    @DInfo(since = "1.21.2")
    PINK_BUNDLE,
    @DInfo(since = "1.17")
    PINK_CANDLE,
    @DInfo(since = "1.17")
    PINK_CANDLE_CAKE,
    PINK_CARPET,
    PINK_CONCRETE,
    PINK_CONCRETE_POWDER,
    PINK_DYE,
    PINK_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    PINK_HARNESS,
    @DInfo(since = "1.19.4")
    PINK_PETALS,
    PINK_SHULKER_BOX,
    PINK_STAINED_GLASS,
    PINK_STAINED_GLASS_PANE,
    PINK_TERRACOTTA,
    PINK_TULIP,
    PINK_WALL_BANNER,
    PINK_WOOL,
    PISTON,
    PISTON_HEAD,
    @DInfo(since = "1.20")
    PITCHER_CROP,
    @DInfo(since = "1.20")
    PITCHER_PLANT,
    @DInfo(since = "1.20")
    PITCHER_POD,
    PLAYER_HEAD,
    PLAYER_WALL_HEAD,
    @DInfo(since = "1.20")
    PLENTY_POTTERY_SHERD,
    PODZOL,
    @DInfo(since = "1.17")
    POINTED_DRIPSTONE,
    POISONOUS_POTATO,
    POLAR_BEAR_SPAWN_EGG,
    POLISHED_ANDESITE,
    POLISHED_ANDESITE_SLAB,
    POLISHED_ANDESITE_STAIRS,
    POLISHED_BASALT,
    POLISHED_BLACKSTONE,
    POLISHED_BLACKSTONE_BRICKS,
    POLISHED_BLACKSTONE_BRICK_SLAB,
    POLISHED_BLACKSTONE_BRICK_STAIRS,
    POLISHED_BLACKSTONE_BRICK_WALL,
    POLISHED_BLACKSTONE_BUTTON,
    POLISHED_BLACKSTONE_PRESSURE_PLATE,
    POLISHED_BLACKSTONE_SLAB,
    POLISHED_BLACKSTONE_STAIRS,
    POLISHED_BLACKSTONE_WALL,
    @DInfo(since = "1.17")
    POLISHED_DEEPSLATE,
    @DInfo(since = "1.17")
    POLISHED_DEEPSLATE_SLAB,
    @DInfo(since = "1.17")
    POLISHED_DEEPSLATE_STAIRS,
    @DInfo(since = "1.17")
    POLISHED_DEEPSLATE_WALL,
    POLISHED_DIORITE,
    POLISHED_DIORITE_SLAB,
    POLISHED_DIORITE_STAIRS,
    POLISHED_GRANITE,
    POLISHED_GRANITE_SLAB,
    POLISHED_GRANITE_STAIRS,
    @DInfo(since = "1.20.3")
    POLISHED_TUFF,
    @DInfo(since = "1.20.3")
    POLISHED_TUFF_SLAB,
    @DInfo(since = "1.20.3")
    POLISHED_TUFF_STAIRS,
    @DInfo(since = "1.20.3")
    POLISHED_TUFF_WALL,
    POPPED_CHORUS_FRUIT,
    POPPY,
    PORKCHOP,
    POTATO,
    POTATOES,
    POTION,
    POTTED_ACACIA_SAPLING,
    POTTED_ALLIUM,
    @DInfo(since = "1.17")
    POTTED_AZALEA_BUSH,
    POTTED_AZURE_BLUET,
    POTTED_BAMBOO,
    POTTED_BIRCH_SAPLING,
    POTTED_BLUE_ORCHID,
    POTTED_BROWN_MUSHROOM,
    POTTED_CACTUS,
    @DInfo(since = "1.19.4")
    POTTED_CHERRY_SAPLING,
    @DInfo(since = "1.21.4")
    POTTED_CLOSED_EYEBLOSSOM,
    POTTED_CORNFLOWER,
    POTTED_CRIMSON_FUNGUS,
    POTTED_CRIMSON_ROOTS,
    POTTED_DANDELION,
    POTTED_DARK_OAK_SAPLING,
    POTTED_DEAD_BUSH,
    POTTED_FERN,
    @DInfo(since = "1.17")
    POTTED_FLOWERING_AZALEA_BUSH,
    POTTED_JUNGLE_SAPLING,
    POTTED_LILY_OF_THE_VALLEY,
    @DInfo(since = "1.19")
    POTTED_MANGROVE_PROPAGULE,
    POTTED_OAK_SAPLING,
    @DInfo(since = "1.21.4")
    POTTED_OPEN_EYEBLOSSOM,
    POTTED_ORANGE_TULIP,
    POTTED_OXEYE_DAISY,
    POTTED_PALE_OAK_SAPLING,
    POTTED_PINK_TULIP,
    POTTED_POPPY,
    POTTED_RED_MUSHROOM,
    POTTED_RED_TULIP,
    POTTED_SPRUCE_SAPLING,
    @DInfo(since = "1.19.4")
    POTTED_TORCHFLOWER,
    POTTED_WARPED_FUNGUS,
    POTTED_WARPED_ROOTS,
    POTTED_WHITE_TULIP,
    POTTED_WITHER_ROSE,
    @DInfo(since = "1.17")
    POWDER_SNOW,
    @DInfo(since = "1.17")
    POWDER_SNOW_BUCKET,
    @DInfo(since = "1.17")
    POWDER_SNOW_CAULDRON,
    POWERED_RAIL,
    PRISMARINE,
    PRISMARINE_BRICKS,
    PRISMARINE_BRICK_SLAB,
    PRISMARINE_BRICK_STAIRS,
    PRISMARINE_CRYSTALS,
    PRISMARINE_SHARD,
    PRISMARINE_SLAB,
    PRISMARINE_STAIRS,
    PRISMARINE_WALL,
    @DInfo(since = "1.20")
    PRIZE_POTTERY_SHERD,
    PUFFERFISH,
    PUFFERFISH_BUCKET,
    PUFFERFISH_SPAWN_EGG,
    PUMPKIN,
    PUMPKIN_PIE,
    PUMPKIN_SEEDS,
    PUMPKIN_STEM,
    PURPLE_BANNER,
    PURPLE_BED,
    @DInfo(since = "1.21.2")
    PURPLE_BUNDLE,
    @DInfo(since = "1.17")
    PURPLE_CANDLE,
    @DInfo(since = "1.17")
    PURPLE_CANDLE_CAKE,
    PURPLE_CARPET,
    PURPLE_CONCRETE,
    PURPLE_CONCRETE_POWDER,
    PURPLE_DYE,
    PURPLE_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    PURPLE_HARNESS,
    PURPLE_SHULKER_BOX,
    PURPLE_STAINED_GLASS,
    PURPLE_STAINED_GLASS_PANE,
    PURPLE_TERRACOTTA,
    PURPLE_WALL_BANNER,
    PURPLE_WOOL,
    PURPUR_BLOCK,
    PURPUR_PILLAR,
    PURPUR_SLAB,
    PURPUR_STAIRS,
    QUARTZ,
    QUARTZ_BLOCK,
    QUARTZ_BRICKS,
    QUARTZ_PILLAR,
    QUARTZ_SLAB,
    QUARTZ_STAIRS,
    RABBIT,
    RABBIT_FOOT,
    RABBIT_HIDE,
    RABBIT_SPAWN_EGG,
    RABBIT_STEW,
    RAIL,
    @DInfo(since = "1.20")
    RAISER_ARMOR_TRIM_SMITHING_TEMPLATE,
    RAVAGER_SPAWN_EGG,
    @DInfo(since = "1.17")
    RAW_COPPER,
    @DInfo(since = "1.17")
    RAW_COPPER_BLOCK,
    @DInfo(since = "1.17")
    RAW_GOLD,
    @DInfo(since = "1.17")
    RAW_GOLD_BLOCK,
    @DInfo(since = "1.17")
    RAW_IRON,
    @DInfo(since = "1.17")
    RAW_IRON_BLOCK,
    @DInfo(since = "1.19")
    RECOVERY_COMPASS,
    REDSTONE,
    REDSTONE_BLOCK,
    REDSTONE_LAMP,
    REDSTONE_ORE,
    REDSTONE_TORCH,
    REDSTONE_WALL_TORCH,
    REDSTONE_WIRE,
    RED_BANNER,
    RED_BED,
    @DInfo(since = "1.21.2")
    RED_BUNDLE,
    @DInfo(since = "1.17")
    RED_CANDLE,
    @DInfo(since = "1.17")
    RED_CANDLE_CAKE,
    RED_CARPET,
    RED_CONCRETE,
    RED_CONCRETE_POWDER,
    RED_DYE,
    RED_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    RED_HARNESS,
    RED_MUSHROOM,
    RED_MUSHROOM_BLOCK,
    RED_NETHER_BRICKS,
    RED_NETHER_BRICK_SLAB,
    RED_NETHER_BRICK_STAIRS,
    RED_NETHER_BRICK_WALL,
    RED_SAND,
    RED_SANDSTONE,
    RED_SANDSTONE_SLAB,
    RED_SANDSTONE_STAIRS,
    RED_SANDSTONE_WALL,
    RED_SHULKER_BOX,
    RED_STAINED_GLASS,
    RED_STAINED_GLASS_PANE,
    RED_TERRACOTTA,
    RED_TULIP,
    RED_WALL_BANNER,
    RED_WOOL,
    @DInfo(since = "1.19")
    REINFORCED_DEEPSLATE,
    REPEATER,
    REPEATING_COMMAND_BLOCK,
    @DInfo(since = "1.21.4")
    RESIN_BLOCK,
    @DInfo(since = "1.21.4")
    RESIN_BRICK,
    @DInfo(since = "1.21.4")
    RESIN_BRICKS,
    @DInfo(since = "1.21.4")
    RESIN_BRICK_SLAB,
    @DInfo(since = "1.21.4")
    RESIN_BRICK_STAIRS,
    @DInfo(since = "1.21.4")
    RESIN_BRICK_WALL,
    @DInfo(since = "1.21.4")
    RESIN_CLUMP,
    RESPAWN_ANCHOR,
    @DInfo(since = "1.19.4")
    RIB_ARMOR_TRIM_SMITHING_TEMPLATE,
    @DInfo(since = "1.17")
    ROOTED_DIRT,
    ROSE_BUSH,
    ROTTEN_FLESH,
    SADDLE,
    SALMON,
    SALMON_BUCKET,
    SALMON_SPAWN_EGG,
    SAND,
    SANDSTONE,
    SANDSTONE_SLAB,
    SANDSTONE_STAIRS,
    SANDSTONE_WALL,
    SCAFFOLDING,
    @DInfo(since = "1.20.5")
    SCRAPE_POTTERY_SHERD,
    @DInfo(since = "1.19")
    SCULK,
    @DInfo(since = "1.19")
    SCULK_CATALYST,
    @DInfo(since = "1.17")
    SCULK_SENSOR,
    @DInfo(since = "1.19")
    SCULK_SHRIEKER,
    @DInfo(since = "1.19")
    SCULK_VEIN,
    SEAGRASS,
    SEA_LANTERN,
    SEA_PICKLE,
    @DInfo(since = "1.19.4")
    SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
    @DInfo(since = "1.20")
    SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE,
    @DInfo(since = "1.20")
    SHEAF_POTTERY_SHERD,
    SHEARS,
    SHEEP_SPAWN_EGG,
    @DInfo(since = "1.20")
    SHELTER_POTTERY_SHERD,
    SHIELD,
    @DInfo(since = "1.21.5")
    SHORT_DRY_GRASS,
    @DRenamed(since = "1.20.3", from = "GRASS")
    SHORT_GRASS,
    SHROOMLIGHT,
    SHULKER_BOX,
    SHULKER_SHELL,
    SHULKER_SPAWN_EGG,
    @DInfo(since = "1.20")
    SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,
    SILVERFISH_SPAWN_EGG,
    SKELETON_HORSE_SPAWN_EGG,
    SKELETON_SKULL,
    SKELETON_SPAWN_EGG,
    SKELETON_WALL_SKULL,
    SKULL_BANNER_PATTERN,
    @DInfo(since = "1.20")
    SKULL_POTTERY_SHERD,
    SLIME_BALL,
    SLIME_BLOCK,
    SLIME_SPAWN_EGG,
    @DInfo(since = "1.17")
    SMALL_AMETHYST_BUD,
    @DInfo(since = "1.17")
    SMALL_DRIPLEAF,
    SMITHING_TABLE,
    SMOKER,
    @DInfo(since = "1.17")
    SMOOTH_BASALT,
    SMOOTH_QUARTZ,
    SMOOTH_QUARTZ_SLAB,
    SMOOTH_QUARTZ_STAIRS,
    SMOOTH_RED_SANDSTONE,
    SMOOTH_RED_SANDSTONE_SLAB,
    SMOOTH_RED_SANDSTONE_STAIRS,
    SMOOTH_SANDSTONE,
    SMOOTH_SANDSTONE_SLAB,
    SMOOTH_SANDSTONE_STAIRS,
    SMOOTH_STONE,
    SMOOTH_STONE_SLAB,
    @DInfo(since = "1.20")
    SNIFFER_EGG,
    @DInfo(since = "1.19.4")
    SNIFFER_SPAWN_EGG,
    @DInfo(since = "1.20")
    SNORT_POTTERY_SHERD,
    @DInfo(since = "1.19.4")
    SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE,
    SNOW,
    SNOWBALL,
    SNOW_BLOCK,
    @DInfo(since = "1.19.3")
    SNOW_GOLEM_SPAWN_EGG,
    SOUL_CAMPFIRE,
    SOUL_FIRE,
    SOUL_LANTERN,
    SOUL_SAND,
    SOUL_SOIL,
    SOUL_TORCH,
    SOUL_WALL_TORCH,
    SPAWNER,
    SPECTRAL_ARROW,
    SPIDER_EYE,
    SPIDER_SPAWN_EGG,
    @DInfo(since = "1.19.4")
    SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,
    SPLASH_POTION,
    SPONGE,
    @DInfo(since = "1.17")
    SPORE_BLOSSOM,
    SPRUCE_BOAT,
    SPRUCE_BUTTON,
    SPRUCE_CHEST_BOAT,
    SPRUCE_DOOR,
    SPRUCE_FENCE,
    SPRUCE_FENCE_GATE,
    @DInfo(since = "1.19.3")
    SPRUCE_HANGING_SIGN,
    SPRUCE_LEAVES,
    SPRUCE_LOG,
    SPRUCE_PLANKS,
    SPRUCE_PRESSURE_PLATE,
    SPRUCE_SAPLING,
    @DInfo(since = "1.21.9")
    SPRUCE_SHELF,
    SPRUCE_SIGN,
    SPRUCE_SLAB,
    SPRUCE_STAIRS,
    SPRUCE_TRAPDOOR,
    @DInfo(since = "1.19.3")
    SPRUCE_WALL_HANGING_SIGN,
    SPRUCE_WALL_SIGN,
    SPRUCE_WOOD,
    @DInfo(since = "1.17")
    SPYGLASS,
    SQUID_SPAWN_EGG,
    STICK,
    STICKY_PISTON,
    STONE,
    STONECUTTER,
    STONE_AXE,
    STONE_BRICKS,
    STONE_BRICK_SLAB,
    STONE_BRICK_STAIRS,
    STONE_BRICK_WALL,
    STONE_BUTTON,
    STONE_HOE,
    STONE_PICKAXE,
    STONE_PRESSURE_PLATE,
    STONE_SHOVEL,
    STONE_SLAB,
    @DInfo(since = "1.21.11")
    STONE_SPEAR,
    STONE_STAIRS,
    STONE_SWORD,
    STRAY_SPAWN_EGG,
    STRIDER_SPAWN_EGG,
    STRING,
    STRIPPED_ACACIA_LOG,
    STRIPPED_ACACIA_WOOD,
    @DInfo(since = "1.19.3")
    STRIPPED_BAMBOO_BLOCK,
    STRIPPED_BIRCH_LOG,
    STRIPPED_BIRCH_WOOD,
    @DInfo(since = "1.19.4")
    STRIPPED_CHERRY_LOG,
    @DInfo(since = "1.19.4")
    STRIPPED_CHERRY_WOOD,
    STRIPPED_CRIMSON_HYPHAE,
    STRIPPED_CRIMSON_STEM,
    STRIPPED_DARK_OAK_LOG,
    STRIPPED_DARK_OAK_WOOD,
    STRIPPED_JUNGLE_LOG,
    STRIPPED_JUNGLE_WOOD,
    @DInfo(since = "1.19")
    STRIPPED_MANGROVE_LOG,
    @DInfo(since = "1.19")
    STRIPPED_MANGROVE_WOOD,
    STRIPPED_OAK_LOG,
    STRIPPED_OAK_WOOD,
    @DInfo(since = "1.21.2")
    STRIPPED_PALE_OAK_LOG,
    @DInfo(since = "1.21.2")
    STRIPPED_PALE_OAK_WOOD,
    STRIPPED_SPRUCE_LOG,
    STRIPPED_SPRUCE_WOOD,
    STRIPPED_WARPED_HYPHAE,
    STRIPPED_WARPED_STEM,
    STRUCTURE_BLOCK,
    STRUCTURE_VOID,
    SUGAR,
    SUGAR_CANE,
    SUNFLOWER,
    @DInfo(since = "1.20")
    SUSPICIOUS_GRAVEL,
    @DInfo(since = "1.19.4")
    SUSPICIOUS_SAND,
    SUSPICIOUS_STEW,
    SWEET_BERRIES,
    SWEET_BERRY_BUSH,
    @DInfo(since = "1.19")
    TADPOLE_BUCKET,
    @DInfo(since = "1.19")
    TADPOLE_SPAWN_EGG,
    @DInfo(since = "1.21.5")
    TALL_DRY_GRASS,
    TALL_GRASS,
    TALL_SEAGRASS,
    TARGET,
    TERRACOTTA,
    @DInfo(since = "1.21.5")
    TEST_BLOCK,
    @DInfo(since = "1.21.5")
    TEST_INSTANCE_BLOCK,
    @DInfo(since = "1.19.4")
    TIDE_ARMOR_TRIM_SMITHING_TEMPLATE,
    @DInfo(since = "1.17")
    TINTED_GLASS,
    TIPPED_ARROW,
    TNT,
    TNT_MINECART,
    TORCH,
    @DInfo(since = "1.19.4")
    TORCHFLOWER,
    @DInfo(since = "1.19.4")
    TORCHFLOWER_CROP,
    @DInfo(since = "1.19.4")
    TORCHFLOWER_SEEDS,
    TOTEM_OF_UNDYING,
    TRADER_LLAMA_SPAWN_EGG,
    TRAPPED_CHEST,
    @DInfo(since = "1.20.3")
    TRIAL_KEY,
    @DInfo(since = "1.20.3")
    TRIAL_SPAWNER,
    TRIDENT,
    TRIPWIRE,
    TRIPWIRE_HOOK,
    TROPICAL_FISH,
    TROPICAL_FISH_BUCKET,
    TROPICAL_FISH_SPAWN_EGG,
    TUBE_CORAL,
    TUBE_CORAL_BLOCK,
    TUBE_CORAL_FAN,
    TUBE_CORAL_WALL_FAN,
    @DInfo(since = "1.17")
    TUFF,
    @DInfo(since = "1.20.3")
    TUFF_BRICKS,
    @DInfo(since = "1.20.3")
    TUFF_BRICK_SLAB,
    @DInfo(since = "1.20.3")
    TUFF_BRICK_STAIRS,
    @DInfo(since = "1.20.3")
    TUFF_BRICK_WALL,
    @DInfo(since = "1.20.3")
    TUFF_SLAB,
    @DInfo(since = "1.20.3")
    TUFF_STAIRS,
    @DInfo(since = "1.20.3")
    TUFF_WALL,
    TURTLE_EGG,
    TURTLE_HELMET,
    @DInfo(since = "1.20.5")
    TURTLE_SCUTE,
    TURTLE_SPAWN_EGG,
    TWISTING_VINES,
    TWISTING_VINES_PLANT,
    @DInfo(since = "1.20.5")
    VAULT,
    @DInfo(since = "1.19")
    VERDANT_FROGLIGHT,
    @DInfo(since = "1.19.4")
    VEX_ARMOR_TRIM_SMITHING_TEMPLATE,
    VEX_SPAWN_EGG,
    VILLAGER_SPAWN_EGG,
    VINDICATOR_SPAWN_EGG,
    VINE,
    VOID_AIR,
    WALL_TORCH,
    WANDERING_TRADER_SPAWN_EGG,
    @DInfo(since = "1.19")
    WARDEN_SPAWN_EGG,
    @DInfo(since = "1.19.4")
    WARD_ARMOR_TRIM_SMITHING_TEMPLATE,
    WARPED_BUTTON,
    WARPED_DOOR,
    WARPED_FENCE,
    WARPED_FENCE_GATE,
    WARPED_FUNGUS,
    WARPED_FUNGUS_ON_A_STICK,
    @DInfo(since = "1.19.3")
    WARPED_HANGING_SIGN,
    WARPED_HYPHAE,
    WARPED_NYLIUM,
    WARPED_PLANKS,
    WARPED_PRESSURE_PLATE,
    WARPED_ROOTS,
    @DInfo(since = "1.21.9")
    WARPED_SHELF,
    WARPED_SIGN,
    WARPED_SLAB,
    WARPED_STAIRS,
    WARPED_STEM,
    WARPED_TRAPDOOR,
    @DInfo(since = "1.19.3")
    WARPED_WALL_HANGING_SIGN,
    WARPED_WALL_SIGN,
    WARPED_WART_BLOCK,
    WATER,
    WATER_BUCKET,
    @DInfo(since = "1.17")
    WATER_CAULDRON,
    @DInfo(since = "1.20.3")
    WAXED_CHISELED_COPPER,
    @DInfo(since = "1.21.9")
    WAXED_COPPER_BARS,
    @DInfo(since = "1.17")
    WAXED_COPPER_BLOCK,
    @DInfo(since = "1.20.3")
    WAXED_COPPER_BULB,
    @DInfo(since = "1.21.9")
    WAXED_COPPER_CHAIN,
    @DInfo(since = "1.21.9")
    WAXED_COPPER_CHEST,
    @DInfo(since = "1.20.3")
    WAXED_COPPER_DOOR,
    @DInfo(since = "1.21.9")
    WAXED_COPPER_GOLEM_STATUE,
    @DInfo(since = "1.20.3")
    WAXED_COPPER_GRATE,
    @DInfo(since = "1.21.9")
    WAXED_COPPER_LANTERN,
    @DInfo(since = "1.20.3")
    WAXED_COPPER_TRAPDOOR,
    @DInfo(since = "1.17")
    WAXED_CUT_COPPER,
    @DInfo(since = "1.17")
    WAXED_CUT_COPPER_SLAB,
    @DInfo(since = "1.17")
    WAXED_CUT_COPPER_STAIRS,
    @DInfo(since = "1.20.3")
    WAXED_EXPOSED_CHISELED_COPPER,
    @DInfo(since = "1.17")
    WAXED_EXPOSED_COPPER,
    @DInfo(since = "1.21.9")
    WAXED_EXPOSED_COPPER_BARS,
    @DInfo(since = "1.20.3")
    WAXED_EXPOSED_COPPER_BULB,
    @DInfo(since = "1.21.9")
    WAXED_EXPOSED_COPPER_CHAIN,
    @DInfo(since = "1.21.9")
    WAXED_EXPOSED_COPPER_CHEST,
    @DInfo(since = "1.20.3")
    WAXED_EXPOSED_COPPER_DOOR,
    @DInfo(since = "1.21.9")
    WAXED_EXPOSED_COPPER_GOLEM_STATUE,
    @DInfo(since = "1.20.3")
    WAXED_EXPOSED_COPPER_GRATE,
    @DInfo(since = "1.21.9")
    WAXED_EXPOSED_COPPER_LANTERN,
    @DInfo(since = "1.20.3")
    WAXED_EXPOSED_COPPER_TRAPDOOR,
    @DInfo(since = "1.17")
    WAXED_EXPOSED_CUT_COPPER,
    @DInfo(since = "1.17")
    WAXED_EXPOSED_CUT_COPPER_SLAB,
    @DInfo(since = "1.17")
    WAXED_EXPOSED_CUT_COPPER_STAIRS,
    @DInfo(since = "1.21.9")
    WAXED_EXPOSED_LIGHTNING_ROD,
    @DInfo(since = "1.21.9")
    WAXED_LIGHTNING_ROD,
    @DInfo(since = "1.20.3")
    WAXED_OXIDIZED_CHISELED_COPPER,
    @DInfo(since = "1.17")
    WAXED_OXIDIZED_COPPER,
    @DInfo(since = "1.21.9")
    WAXED_OXIDIZED_COPPER_BARS,
    @DInfo(since = "1.20.3")
    WAXED_OXIDIZED_COPPER_BULB,
    @DInfo(since = "1.21.9")
    WAXED_OXIDIZED_COPPER_CHAIN,
    @DInfo(since = "1.21.9")
    WAXED_OXIDIZED_COPPER_CHEST,
    @DInfo(since = "1.20.3")
    WAXED_OXIDIZED_COPPER_DOOR,
    @DInfo(since = "1.21.9")
    WAXED_OXIDIZED_COPPER_GOLEM_STATUE,
    @DInfo(since = "1.20.3")
    WAXED_OXIDIZED_COPPER_GRATE,
    @DInfo(since = "1.21.9")
    WAXED_OXIDIZED_COPPER_LANTERN,
    @DInfo(since = "1.20.3")
    WAXED_OXIDIZED_COPPER_TRAPDOOR,
    @DInfo(since = "1.17")
    WAXED_OXIDIZED_CUT_COPPER,
    @DInfo(since = "1.17")
    WAXED_OXIDIZED_CUT_COPPER_SLAB,
    @DInfo(since = "1.17")
    WAXED_OXIDIZED_CUT_COPPER_STAIRS,
    @DInfo(since = "1.21.9")
    WAXED_OXIDIZED_LIGHTNING_ROD,
    @DInfo(since = "1.20.3")
    WAXED_WEATHERED_CHISELED_COPPER,
    @DInfo(since = "1.17")
    WAXED_WEATHERED_COPPER,
    @DInfo(since = "1.21.9")
    WAXED_WEATHERED_COPPER_BARS,
    @DInfo(since = "1.20.3")
    WAXED_WEATHERED_COPPER_BULB,
    @DInfo(since = "1.21.9")
    WAXED_WEATHERED_COPPER_CHAIN,
    @DInfo(since = "1.21.9")
    WAXED_WEATHERED_COPPER_CHEST,
    @DInfo(since = "1.20.3")
    WAXED_WEATHERED_COPPER_DOOR,
    @DInfo(since = "1.21.9")
    WAXED_WEATHERED_COPPER_GOLEM_STATUE,
    @DInfo(since = "1.20.3")
    WAXED_WEATHERED_COPPER_GRATE,
    @DInfo(since = "1.21.9")
    WAXED_WEATHERED_COPPER_LANTERN,
    @DInfo(since = "1.20.3")
    WAXED_WEATHERED_COPPER_TRAPDOOR,
    @DInfo(since = "1.17")
    WAXED_WEATHERED_CUT_COPPER,
    @DInfo(since = "1.17")
    WAXED_WEATHERED_CUT_COPPER_SLAB,
    @DInfo(since = "1.17")
    WAXED_WEATHERED_CUT_COPPER_STAIRS,
    @DInfo(since = "1.21.9")
    WAXED_WEATHERED_LIGHTNING_ROD,
    @DInfo(since = "1.20")
    WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE,
    @DInfo(since = "1.20.3")
    WEATHERED_CHISELED_COPPER,
    @DInfo(since = "1.17")
    WEATHERED_COPPER,
    @DInfo(since = "1.21.9")
    WEATHERED_COPPER_BARS,
    @DInfo(since = "1.20.3")
    WEATHERED_COPPER_BULB,
    @DInfo(since = "1.21.9")
    WEATHERED_COPPER_CHAIN,
    @DInfo(since = "1.21.9")
    WEATHERED_COPPER_CHEST,
    @DInfo(since = "1.20.3")
    WEATHERED_COPPER_DOOR,
    @DInfo(since = "1.21.9")
    WEATHERED_COPPER_GOLEM_STATUE,
    @DInfo(since = "1.20.3")
    WEATHERED_COPPER_GRATE,
    @DInfo(since = "1.21.9")
    WEATHERED_COPPER_LANTERN,
    @DInfo(since = "1.20.3")
    WEATHERED_COPPER_TRAPDOOR,
    @DInfo(since = "1.17")
    WEATHERED_CUT_COPPER,
    @DInfo(since = "1.17")
    WEATHERED_CUT_COPPER_SLAB,
    @DInfo(since = "1.17")
    WEATHERED_CUT_COPPER_STAIRS,
    @DInfo(since = "1.21.9")
    WEATHERED_LIGHTNING_ROD,
    WEEPING_VINES,
    WEEPING_VINES_PLANT,
    WET_SPONGE,
    WHEAT,
    WHEAT_SEEDS,
    WHITE_BANNER,
    WHITE_BED,
    @DInfo(since = "1.21.2")
    WHITE_BUNDLE,
    @DInfo(since = "1.17")
    WHITE_CANDLE,
    @DInfo(since = "1.17")
    WHITE_CANDLE_CAKE,
    WHITE_CARPET,
    WHITE_CONCRETE,
    WHITE_CONCRETE_POWDER,
    WHITE_DYE,
    WHITE_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    WHITE_HARNESS,
    WHITE_SHULKER_BOX,
    WHITE_STAINED_GLASS,
    WHITE_STAINED_GLASS_PANE,
    WHITE_TERRACOTTA,
    WHITE_TULIP,
    WHITE_WALL_BANNER,
    WHITE_WOOL,
    @DInfo(since = "1.21.5")
    WILDFLOWERS,
    @DInfo(since = "1.19.4")
    WILD_ARMOR_TRIM_SMITHING_TEMPLATE,
    @DInfo(since = "1.20.5")
    WIND_CHARGE,
    WITCH_SPAWN_EGG,
    WITHER_ROSE,
    WITHER_SKELETON_SKULL,
    WITHER_SKELETON_SPAWN_EGG,
    WITHER_SKELETON_WALL_SKULL,
    @DInfo(since = "1.19.3")
    WITHER_SPAWN_EGG,
    @DInfo(since = "1.20.5")
    WOLF_ARMOR,
    WOLF_SPAWN_EGG,
    WOODEN_AXE,
    WOODEN_HOE,
    WOODEN_PICKAXE,
    WOODEN_SHOVEL,
    @DInfo(since = "1.21.11")
    WOODEN_SPEAR,
    WOODEN_SWORD,
    WRITABLE_BOOK,
    WRITTEN_BOOK,
    YELLOW_BANNER,
    YELLOW_BED,
    @DInfo(since = "1.21.2")
    YELLOW_BUNDLE,
    @DInfo(since = "1.17")
    YELLOW_CANDLE,
    @DInfo(since = "1.17")
    YELLOW_CANDLE_CAKE,
    YELLOW_CARPET,
    YELLOW_CONCRETE,
    YELLOW_CONCRETE_POWDER,
    YELLOW_DYE,
    YELLOW_GLAZED_TERRACOTTA,
    @DInfo(since = "1.21.6")
    YELLOW_HARNESS,
    YELLOW_SHULKER_BOX,
    YELLOW_STAINED_GLASS,
    YELLOW_STAINED_GLASS_PANE,
    YELLOW_TERRACOTTA,
    YELLOW_WALL_BANNER,
    YELLOW_WOOL,
    ZOGLIN_SPAWN_EGG,
    ZOMBIE_HEAD,
    ZOMBIE_HORSE_SPAWN_EGG,
    @DInfo(since = "1.21.11")
    ZOMBIE_NAUTILUS_SPAWN_EGG,
    ZOMBIE_SPAWN_EGG,
    ZOMBIE_VILLAGER_SPAWN_EGG,
    ZOMBIE_WALL_HEAD,
    ZOMBIFIED_PIGLIN_SPAWN_EGG,
    //</editor-fold>

    //<editor-fold desc="Deprecated" defaultstate="collapsed">
    @DDeprecated(since = "1.21.9")
    CHAIN,
    @DDeprecated(since = "1.17")
    GRASS_PATH,
    @DInfo(since = "1.19.4")
    @DDeprecated(since = "1.20")
    POTTERY_SHARD_ARCHER,
    @DInfo(since = "1.19.4")
    @DDeprecated(since = "1.20")
    POTTERY_SHARD_ARMS_UP,
    @DInfo(since = "1.19.4")
    @DDeprecated(since = "1.20")
    POTTERY_SHARD_PRIZE,
    @DInfo(since = "1.19.4")
    @DDeprecated(since = "1.20")
    POTTERY_SHARD_SKULL,
    @DDeprecated(since = "1.20.3")
    GRASS,
    @DDeprecated(since = "1.20.5")
    SCUTE;
    //</editor-fold>


    DMaterial() {
        this.material = Material.getMaterial(this.name());
    }

    private final Material material;

    @Override
    public Material parse() {
        return material;
    }

    @Override
    public @NotNull Optional<Material> parseOptional() {
        return Optional.ofNullable(material);
    }

    //

    private static final Map<String, DMaterial> NAME_MAP = new HashMap<>();
    public static final DMaterial[] VALUES = values();

    static {
        for(DMaterial dMat : VALUES) {
            NAME_MAP.put(dMat.name(), dMat);
        }
    }

    public static DMaterial getByName(@NotNull String name) {
        return NAME_MAP.get(name);
    }


    @Deprecated(since = "1.5.3")
    public Material parseMaterial() {
        return material;
    }
}