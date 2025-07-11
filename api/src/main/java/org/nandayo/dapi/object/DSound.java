package org.nandayo.dapi.object;

import org.bukkit.Sound;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.Wrapper;
import org.nandayo.dapi.object.annotation.DDeprecated;
import org.nandayo.dapi.object.annotation.DInfo;
import org.nandayo.dapi.object.annotation.DRenamed;

import java.util.HashMap;
import java.util.Locale;

/**
 * Only supports 1.16.1 - 1.21.7.<br>
 * Made by @desaxx (<a href="https://github.com/desaxxx/">GitHub</a>)<br>
 * Inspired from XSeries (<a href="https://github.com/CryptoMorin/XSeries">GitHub</a>)<br>
 */
@SuppressWarnings("unused")
public enum DSound {

    //<editor-fold desc="Sounds" defaultstate="collapsed">
    @DInfo(since = "1.16.1")
    AMBIENT_BASALT_DELTAS_ADDITIONS("ambient.basalt_deltas.additions"),
    @DInfo(since = "1.16.1")
    AMBIENT_BASALT_DELTAS_LOOP("ambient.basalt_deltas.loop"),
    @DInfo(since = "1.16.1")
    AMBIENT_BASALT_DELTAS_MOOD("ambient.basalt_deltas.mood"),
    AMBIENT_CAVE("ambient.cave"),
    @DInfo(since = "1.16.1")
    AMBIENT_CRIMSON_FOREST_ADDITIONS("ambient.crimson_forest.additions"),
    @DInfo(since = "1.16.1")
    AMBIENT_CRIMSON_FOREST_LOOP("ambient.crimson_forest.loop"),
    @DInfo(since = "1.16.1")
    AMBIENT_CRIMSON_FOREST_MOOD("ambient.crimson_forest.mood"),
    @DInfo(since = "1.16.1")
    AMBIENT_NETHER_WASTES_ADDITIONS("ambient.nether_wastes.additions"),
    @DInfo(since = "1.16.1")
    AMBIENT_NETHER_WASTES_LOOP("ambient.nether_wastes.loop"),
    @DInfo(since = "1.16.1")
    AMBIENT_NETHER_WASTES_MOOD("ambient.nether_wastes.mood"),
    @DInfo(since = "1.16.1")
    AMBIENT_SOUL_SAND_VALLEY_ADDITIONS("ambient.soul_sand_valley.additions"),
    @DInfo(since = "1.16.1")
    AMBIENT_SOUL_SAND_VALLEY_LOOP("ambient.soul_sand_valley.loop"),
    @DInfo(since = "1.16.1")
    AMBIENT_SOUL_SAND_VALLEY_MOOD("ambient.soul_sand_valley.mood"),
    AMBIENT_UNDERWATER_ENTER("ambient.underwater.enter"),
    AMBIENT_UNDERWATER_EXIT("ambient.underwater.exit"),
    AMBIENT_UNDERWATER_LOOP("ambient.underwater.loop"),
    AMBIENT_UNDERWATER_LOOP_ADDITIONS("ambient.underwater.loop.additions"),
    AMBIENT_UNDERWATER_LOOP_ADDITIONS_RARE("ambient.underwater.loop.additions.rare"),
    AMBIENT_UNDERWATER_LOOP_ADDITIONS_ULTRA_RARE("ambient.underwater.loop.additions.ultra_rare"),
    @DInfo(since = "1.16.1")
    AMBIENT_WARPED_FOREST_ADDITIONS("ambient.warped_forest.additions"),
    @DInfo(since = "1.16.1")
    AMBIENT_WARPED_FOREST_LOOP("ambient.warped_forest.loop"),
    @DInfo(since = "1.16.1")
    AMBIENT_WARPED_FOREST_MOOD("ambient.warped_forest.mood"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_BLOCK_BREAK("block.amethyst_block.break"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_BLOCK_CHIME("block.amethyst_block.chime"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_BLOCK_FALL("block.amethyst_block.fall"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_BLOCK_HIT("block.amethyst_block.hit"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_BLOCK_PLACE("block.amethyst_block.place"),
    @DInfo(since = "1.20")
    BLOCK_AMETHYST_BLOCK_RESONATE("block.amethyst_block.resonate"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_BLOCK_STEP("block.amethyst_block.step"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_CLUSTER_BREAK("block.amethyst_cluster.break"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_CLUSTER_FALL("block.amethyst_cluster.fall"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_CLUSTER_HIT("block.amethyst_cluster.hit"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_CLUSTER_PLACE("block.amethyst_cluster.place"),
    @DInfo(since = "1.17")
    BLOCK_AMETHYST_CLUSTER_STEP("block.amethyst_cluster.step"),
    @DInfo(since = "1.16.1")
    BLOCK_ANCIENT_DEBRIS_BREAK("block.ancient_debris.break"),
    @DInfo(since = "1.16.1")
    BLOCK_ANCIENT_DEBRIS_FALL("block.ancient_debris.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_ANCIENT_DEBRIS_HIT("block.ancient_debris.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_ANCIENT_DEBRIS_PLACE("block.ancient_debris.place"),
    @DInfo(since = "1.16.1")
    BLOCK_ANCIENT_DEBRIS_STEP("block.ancient_debris.step"),
    BLOCK_ANVIL_BREAK("block.anvil.break"),
    BLOCK_ANVIL_DESTROY("block.anvil.destroy"),
    BLOCK_ANVIL_FALL("block.anvil.fall"),
    BLOCK_ANVIL_HIT("block.anvil.hit"),
    BLOCK_ANVIL_LAND("block.anvil.land"),
    BLOCK_ANVIL_PLACE("block.anvil.place"),
    BLOCK_ANVIL_STEP("block.anvil.step"),
    BLOCK_ANVIL_USE("block.anvil.use"),
    @DInfo(since = "1.17")
    BLOCK_AZALEA_BREAK("block.azalea.break"),
    @DInfo(since = "1.17")
    BLOCK_AZALEA_FALL("block.azalea.fall"),
    @DInfo(since = "1.17")
    BLOCK_AZALEA_HIT("block.azalea.hit"),
    @DInfo(since = "1.17")
    BLOCK_AZALEA_LEAVES_BREAK("block.azalea_leaves.break"),
    @DInfo(since = "1.17")
    BLOCK_AZALEA_LEAVES_FALL("block.azalea_leaves.fall"),
    @DInfo(since = "1.17")
    BLOCK_AZALEA_LEAVES_HIT("block.azalea_leaves.hit"),
    @DInfo(since = "1.17")
    BLOCK_AZALEA_LEAVES_PLACE("block.azalea_leaves.place"),
    @DInfo(since = "1.17")
    BLOCK_AZALEA_LEAVES_STEP("block.azalea_leaves.step"),
    @DInfo(since = "1.17")
    BLOCK_AZALEA_PLACE("block.azalea.place"),
    @DInfo(since = "1.17")
    BLOCK_AZALEA_STEP("block.azalea.step"),
    BLOCK_BAMBOO_BREAK("block.bamboo.break"),
    BLOCK_BAMBOO_FALL("block.bamboo.fall"),
    BLOCK_BAMBOO_HIT("block.bamboo.hit"),
    BLOCK_BAMBOO_PLACE("block.bamboo.place"),
    BLOCK_BAMBOO_SAPLING_BREAK("block.bamboo_sapling.break"),
    BLOCK_BAMBOO_SAPLING_HIT("block.bamboo_sapling.hit"),
    BLOCK_BAMBOO_SAPLING_PLACE("block.bamboo_sapling.place"),
    BLOCK_BAMBOO_STEP("block.bamboo.step"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_BREAK("block.bamboo_wood.break"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_BUTTON_CLICK_OFF("block.bamboo_wood_button.click_off"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_BUTTON_CLICK_ON("block.bamboo_wood_button.click_on"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_DOOR_CLOSE("block.bamboo_wood_door.close"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_DOOR_OPEN("block.bamboo_wood_door.open"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_FALL("block.bamboo_wood.fall"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_FENCE_GATE_CLOSE("block.bamboo_wood_fence_gate.close"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_FENCE_GATE_OPEN("block.bamboo_wood_fence_gate.open"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_HANGING_SIGN_BREAK("block.bamboo_wood_hanging_sign.break"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_HANGING_SIGN_FALL("block.bamboo_wood_hanging_sign.fall"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_HANGING_SIGN_HIT("block.bamboo_wood_hanging_sign.hit"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_HANGING_SIGN_PLACE("block.bamboo_wood_hanging_sign.place"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_HANGING_SIGN_STEP("block.bamboo_wood_hanging_sign.step"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_HIT("block.bamboo_wood.hit"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_PLACE("block.bamboo_wood.place"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_PRESSURE_PLATE_CLICK_OFF("block.bamboo_wood_pressure_plate.click_off"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_PRESSURE_PLATE_CLICK_ON("block.bamboo_wood_pressure_plate.click_on"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_STEP("block.bamboo_wood.step"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_TRAPDOOR_CLOSE("block.bamboo_wood_trapdoor.close"),
    @DInfo(since = "1.19.3")
    BLOCK_BAMBOO_WOOD_TRAPDOOR_OPEN("block.bamboo_wood_trapdoor.open"),
    BLOCK_BARREL_CLOSE("block.barrel.close"),
    BLOCK_BARREL_OPEN("block.barrel.open"),
    @DInfo(since = "1.16.1")
    BLOCK_BASALT_BREAK("block.basalt.break"),
    @DInfo(since = "1.16.1")
    BLOCK_BASALT_FALL("block.basalt.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_BASALT_HIT("block.basalt.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_BASALT_PLACE("block.basalt.place"),
    @DInfo(since = "1.16.1")
    BLOCK_BASALT_STEP("block.basalt.step"),
    BLOCK_BEACON_ACTIVATE("block.beacon.activate"),
    BLOCK_BEACON_AMBIENT("block.beacon.ambient"),
    BLOCK_BEACON_DEACTIVATE("block.beacon.deactivate"),
    BLOCK_BEACON_POWER_SELECT("block.beacon.power_select"),
    BLOCK_BEEHIVE_DRIP("block.beehive.drip"),
    BLOCK_BEEHIVE_ENTER("block.beehive.enter"),
    BLOCK_BEEHIVE_EXIT("block.beehive.exit"),
    BLOCK_BEEHIVE_SHEAR("block.beehive.shear"),
    BLOCK_BEEHIVE_WORK("block.beehive.work"),
    BLOCK_BELL_RESONATE("block.bell.resonate"),
    BLOCK_BELL_USE("block.bell.use"),
    @DInfo(since = "1.17")
    BLOCK_BIG_DRIPLEAF_BREAK("block.big_dripleaf.break"),
    @DInfo(since = "1.17")
    BLOCK_BIG_DRIPLEAF_FALL("block.big_dripleaf.fall"),
    @DInfo(since = "1.17")
    BLOCK_BIG_DRIPLEAF_HIT("block.big_dripleaf.hit"),
    @DInfo(since = "1.17")
    BLOCK_BIG_DRIPLEAF_PLACE("block.big_dripleaf.place"),
    @DInfo(since = "1.17")
    BLOCK_BIG_DRIPLEAF_STEP("block.big_dripleaf.step"),
    @DInfo(since = "1.17")
    BLOCK_BIG_DRIPLEAF_TILT_DOWN("block.big_dripleaf.tilt_down"),
    @DInfo(since = "1.17")
    BLOCK_BIG_DRIPLEAF_TILT_UP("block.big_dripleaf.tilt_up"),
    BLOCK_BLASTFURNACE_FIRE_CRACKLE("block.blastfurnace.fire_crackle"),
    @DInfo(since = "1.16.1")
    BLOCK_BONE_BLOCK_BREAK("block.bone_block.break"),
    @DInfo(since = "1.16.1")
    BLOCK_BONE_BLOCK_FALL("block.bone_block.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_BONE_BLOCK_HIT("block.bone_block.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_BONE_BLOCK_PLACE("block.bone_block.place"),
    @DInfo(since = "1.16.1")
    BLOCK_BONE_BLOCK_STEP("block.bone_block.step"),
    BLOCK_BREWING_STAND_BREW("block.brewing_stand.brew"),
    BLOCK_BUBBLE_COLUMN_BUBBLE_POP("block.bubble_column.bubble_pop"),
    BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT("block.bubble_column.upwards_ambient"),
    BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE("block.bubble_column.upwards_inside"),
    BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT("block.bubble_column.whirlpool_ambient"),
    BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE("block.bubble_column.whirlpool_inside"),
    @DInfo(since = "1.21.5")
    BLOCK_CACTUS_FLOWER_BREAK("block.cactus_flower.break"),
    @DInfo(since = "1.21.5")
    BLOCK_CACTUS_FLOWER_PLACE("block.cactus_flower.place"),
    @DInfo(since = "1.17")
    BLOCK_CAKE_ADD_CANDLE("block.cake.add_candle"),
    @DInfo(since = "1.17")
    BLOCK_CALCITE_BREAK("block.calcite.break"),
    @DInfo(since = "1.17")
    BLOCK_CALCITE_FALL("block.calcite.fall"),
    @DInfo(since = "1.17")
    BLOCK_CALCITE_HIT("block.calcite.hit"),
    @DInfo(since = "1.17")
    BLOCK_CALCITE_PLACE("block.calcite.place"),
    @DInfo(since = "1.17")
    BLOCK_CALCITE_STEP("block.calcite.step"),
    BLOCK_CAMPFIRE_CRACKLE("block.campfire.crackle"),
    @DInfo(since = "1.17")
    BLOCK_CANDLE_AMBIENT("block.candle.ambient"),
    @DInfo(since = "1.17")
    BLOCK_CANDLE_BREAK("block.candle.break"),
    @DInfo(since = "1.17")
    BLOCK_CANDLE_EXTINGUISH("block.candle.extinguish"),
    @DInfo(since = "1.17")
    BLOCK_CANDLE_FALL("block.candle.fall"),
    @DInfo(since = "1.17")
    BLOCK_CANDLE_HIT("block.candle.hit"),
    @DInfo(since = "1.17")
    BLOCK_CANDLE_PLACE("block.candle.place"),
    @DInfo(since = "1.17")
    BLOCK_CANDLE_STEP("block.candle.step"),
    @DInfo(since = "1.17")
    BLOCK_CAVE_VINES_BREAK("block.cave_vines.break"),
    @DInfo(since = "1.17")
    BLOCK_CAVE_VINES_FALL("block.cave_vines.fall"),
    @DInfo(since = "1.17")
    BLOCK_CAVE_VINES_HIT("block.cave_vines.hit"),
    @DInfo(since = "1.17")
    BLOCK_CAVE_VINES_PICK_BERRIES("block.cave_vines.pick_berries"),
    @DInfo(since = "1.17")
    BLOCK_CAVE_VINES_PLACE("block.cave_vines.place"),
    @DInfo(since = "1.17")
    BLOCK_CAVE_VINES_STEP("block.cave_vines.step"),
    @DInfo(since = "1.16.1")
    BLOCK_CHAIN_BREAK("block.chain.break"),
    @DInfo(since = "1.16.1")
    BLOCK_CHAIN_FALL("block.chain.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_CHAIN_HIT("block.chain.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_CHAIN_PLACE("block.chain.place"),
    @DInfo(since = "1.16.1")
    BLOCK_CHAIN_STEP("block.chain.step"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_LEAVES_BREAK("block.cherry_leaves.break"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_LEAVES_FALL("block.cherry_leaves.fall"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_LEAVES_HIT("block.cherry_leaves.hit"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_LEAVES_PLACE("block.cherry_leaves.place"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_LEAVES_STEP("block.cherry_leaves.step"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_SAPLING_BREAK("block.cherry_sapling.break"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_SAPLING_FALL("block.cherry_sapling.fall"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_SAPLING_HIT("block.cherry_sapling.hit"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_SAPLING_PLACE("block.cherry_sapling.place"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_SAPLING_STEP("block.cherry_sapling.step"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_BREAK("block.cherry_wood.break"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_BUTTON_CLICK_OFF("block.cherry_wood_button.click_off"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON("block.cherry_wood_button.click_on"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_DOOR_CLOSE("block.cherry_wood_door.close"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_DOOR_OPEN("block.cherry_wood_door.open"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_FALL("block.cherry_wood.fall"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_FENCE_GATE_CLOSE("block.cherry_wood_fence_gate.close"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_FENCE_GATE_OPEN("block.cherry_wood_fence_gate.open"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_HANGING_SIGN_BREAK("block.cherry_wood_hanging_sign.break"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_HANGING_SIGN_FALL("block.cherry_wood_hanging_sign.fall"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_HANGING_SIGN_HIT("block.cherry_wood_hanging_sign.hit"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_HANGING_SIGN_PLACE("block.cherry_wood_hanging_sign.place"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_HANGING_SIGN_STEP("block.cherry_wood_hanging_sign.step"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_HIT("block.cherry_wood.hit"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_PLACE("block.cherry_wood.place"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF("block.cherry_wood_pressure_plate.click_off"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON("block.cherry_wood_pressure_plate.click_on"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_STEP("block.cherry_wood.step"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_TRAPDOOR_CLOSE("block.cherry_wood_trapdoor.close"),
    @DInfo(since = "1.19.4")
    BLOCK_CHERRY_WOOD_TRAPDOOR_OPEN("block.cherry_wood_trapdoor.open"),
    BLOCK_CHEST_CLOSE("block.chest.close"),
    BLOCK_CHEST_LOCKED("block.chest.locked"),
    BLOCK_CHEST_OPEN("block.chest.open"),
    @DInfo(since = "1.19.3")
    BLOCK_CHISELED_BOOKSHELF_BREAK("block.chiseled_bookshelf.break"),
    @DInfo(since = "1.19.3")
    BLOCK_CHISELED_BOOKSHELF_FALL("block.chiseled_bookshelf.fall"),
    @DInfo(since = "1.19.3")
    BLOCK_CHISELED_BOOKSHELF_HIT("block.chiseled_bookshelf.hit"),
    @DInfo(since = "1.19.3")
    BLOCK_CHISELED_BOOKSHELF_INSERT("block.chiseled_bookshelf.insert"),
    @DInfo(since = "1.19.3")
    BLOCK_CHISELED_BOOKSHELF_INSERT_ENCHANTED("block.chiseled_bookshelf.insert.enchanted"),
    @DInfo(since = "1.19.3")
    BLOCK_CHISELED_BOOKSHELF_PICKUP("block.chiseled_bookshelf.pickup"),
    @DInfo(since = "1.19.3")
    BLOCK_CHISELED_BOOKSHELF_PICKUP_ENCHANTED("block.chiseled_bookshelf.pickup.enchanted"),
    @DInfo(since = "1.19.3")
    BLOCK_CHISELED_BOOKSHELF_PLACE("block.chiseled_bookshelf.place"),
    @DInfo(since = "1.19.3")
    BLOCK_CHISELED_BOOKSHELF_STEP("block.chiseled_bookshelf.step"),
    BLOCK_CHORUS_FLOWER_DEATH("block.chorus_flower.death"),
    BLOCK_CHORUS_FLOWER_GROW("block.chorus_flower.grow"),
    @DInfo(since = "1.20.5")
    BLOCK_COBWEB_BREAK("block.cobweb.break"),
    @DInfo(since = "1.20.5")
    BLOCK_COBWEB_FALL("block.cobweb.fall"),
    @DInfo(since = "1.20.5")
    BLOCK_COBWEB_HIT("block.cobweb.hit"),
    @DInfo(since = "1.20.5")
    BLOCK_COBWEB_PLACE("block.cobweb.place"),
    @DInfo(since = "1.20.5")
    BLOCK_COBWEB_STEP("block.cobweb.step"),
    BLOCK_COMPARATOR_CLICK("block.comparator.click"),
    BLOCK_COMPOSTER_EMPTY("block.composter.empty"),
    BLOCK_COMPOSTER_FILL("block.composter.fill"),
    BLOCK_COMPOSTER_FILL_SUCCESS("block.composter.fill_success"),
    BLOCK_COMPOSTER_READY("block.composter.ready"),
    BLOCK_CONDUIT_ACTIVATE("block.conduit.activate"),
    BLOCK_CONDUIT_AMBIENT("block.conduit.ambient"),
    BLOCK_CONDUIT_AMBIENT_SHORT("block.conduit.ambient.short"),
    BLOCK_CONDUIT_ATTACK_TARGET("block.conduit.attack.target"),
    BLOCK_CONDUIT_DEACTIVATE("block.conduit.deactivate"),
    @DInfo(since = "1.17")
    BLOCK_COPPER_BREAK("block.copper.break"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_BULB_BREAK("block.copper_bulb.break"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_BULB_FALL("block.copper_bulb.fall"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_BULB_HIT("block.copper_bulb.hit"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_BULB_PLACE("block.copper_bulb.place"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_BULB_STEP("block.copper_bulb.step"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_BULB_TURN_OFF("block.copper_bulb.turn_off"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_BULB_TURN_ON("block.copper_bulb.turn_on"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_DOOR_CLOSE("block.copper_door.close"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_DOOR_OPEN("block.copper_door.open"),
    @DInfo(since = "1.17")
    BLOCK_COPPER_FALL("block.copper.fall"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_GRATE_BREAK("block.copper_grate.break"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_GRATE_FALL("block.copper_grate.fall"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_GRATE_HIT("block.copper_grate.hit"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_GRATE_PLACE("block.copper_grate.place"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_GRATE_STEP("block.copper_grate.step"),
    @DInfo(since = "1.17")
    BLOCK_COPPER_HIT("block.copper.hit"),
    @DInfo(since = "1.17")
    BLOCK_COPPER_PLACE("block.copper.place"),
    @DInfo(since = "1.17")
    BLOCK_COPPER_STEP("block.copper.step"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_TRAPDOOR_CLOSE("block.copper_trapdoor.close"),
    @DInfo(since = "1.21")
    BLOCK_COPPER_TRAPDOOR_OPEN("block.copper_trapdoor.open"),
    BLOCK_CORAL_BLOCK_BREAK("block.coral_block.break"),
    BLOCK_CORAL_BLOCK_FALL("block.coral_block.fall"),
    BLOCK_CORAL_BLOCK_HIT("block.coral_block.hit"),
    BLOCK_CORAL_BLOCK_PLACE("block.coral_block.place"),
    BLOCK_CORAL_BLOCK_STEP("block.coral_block.step"),
    @DInfo(since = "1.20.3")
    BLOCK_CRAFTER_CRAFT("block.crafter.craft"),
    @DInfo(since = "1.20.3")
    BLOCK_CRAFTER_FAIL("block.crafter.fail"),
    @DInfo(since = "1.21.2")
    BLOCK_CREAKING_HEART_BREAK("block.creaking_heart.break"),
    @DInfo(since = "1.21.2")
    BLOCK_CREAKING_HEART_FALL("block.creaking_heart.fall"),
    @DInfo(since = "1.21.2")
    BLOCK_CREAKING_HEART_HIT("block.creaking_heart.hit"),
    @DInfo(since = "1.21.2")
    BLOCK_CREAKING_HEART_HURT("block.creaking_heart.hurt"),
    @DInfo(since = "1.21.2")
    BLOCK_CREAKING_HEART_IDLE("block.creaking_heart.idle"),
    @DInfo(since = "1.21.2")
    BLOCK_CREAKING_HEART_PLACE("block.creaking_heart.place"),
    @DInfo(since = "1.21.2")
    BLOCK_CREAKING_HEART_SPAWN("block.creaking_heart.spawn"),
    @DInfo(since = "1.21.2")
    BLOCK_CREAKING_HEART_STEP("block.creaking_heart.step"),
    BLOCK_CROP_BREAK("block.crop.break"),
    @DInfo(since = "1.21.5")
    BLOCK_DEADBUSH_IDLE("block.deadbush.idle"),
    @DInfo(since = "1.19.4")
    BLOCK_DECORATED_POT_BREAK("block.decorated_pot.break"),
    @DInfo(since = "1.19.4")
    BLOCK_DECORATED_POT_FALL("block.decorated_pot.fall"),
    @DInfo(since = "1.19.4")
    BLOCK_DECORATED_POT_HIT("block.decorated_pot.hit"),
    @DInfo(since = "1.20.3")
    BLOCK_DECORATED_POT_INSERT("block.decorated_pot.insert"),
    @DInfo(since = "1.20.3")
    BLOCK_DECORATED_POT_INSERT_FAIL("block.decorated_pot.insert_fail"),
    @DInfo(since = "1.19.4")
    BLOCK_DECORATED_POT_PLACE("block.decorated_pot.place"),
    @DInfo(since = "1.19.4")
    BLOCK_DECORATED_POT_SHATTER("block.decorated_pot.shatter"),
    @DInfo(since = "1.19.4")
    BLOCK_DECORATED_POT_STEP("block.decorated_pot.step"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_BREAK("block.deepslate.break"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_BRICKS_BREAK("block.deepslate_bricks.break"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_BRICKS_FALL("block.deepslate_bricks.fall"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_BRICKS_HIT("block.deepslate_bricks.hit"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_BRICKS_PLACE("block.deepslate_bricks.place"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_BRICKS_STEP("block.deepslate_bricks.step"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_FALL("block.deepslate.fall"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_HIT("block.deepslate.hit"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_PLACE("block.deepslate.place"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_STEP("block.deepslate.step"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_TILES_BREAK("block.deepslate_tiles.break"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_TILES_FALL("block.deepslate_tiles.fall"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_TILES_HIT("block.deepslate_tiles.hit"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_TILES_PLACE("block.deepslate_tiles.place"),
    @DInfo(since = "1.17")
    BLOCK_DEEPSLATE_TILES_STEP("block.deepslate_tiles.step"),
    BLOCK_DISPENSER_DISPENSE("block.dispenser.dispense"),
    BLOCK_DISPENSER_FAIL("block.dispenser.fail"),
    BLOCK_DISPENSER_LAUNCH("block.dispenser.launch"),
    @DInfo(since = "1.21.6")
    BLOCK_DRIED_GHAST_AMBIENT("block.dried_ghast.ambient"),
    @DInfo(since = "1.21.6")
    BLOCK_DRIED_GHAST_AMBIENT_WATER("block.dried_ghast.ambient_water"),
    @DInfo(since = "1.21.6")
    BLOCK_DRIED_GHAST_BREAK("block.dried_ghast.break"),
    @DInfo(since = "1.21.6")
    BLOCK_DRIED_GHAST_FALL("block.dried_ghast.fall"),
    @DInfo(since = "1.21.6")
    BLOCK_DRIED_GHAST_PLACE("block.dried_ghast.place"),
    @DInfo(since = "1.21.6")
    BLOCK_DRIED_GHAST_PLACE_IN_WATER("block.dried_ghast.place_in_water"),
    @DInfo(since = "1.21.6")
    BLOCK_DRIED_GHAST_STEP("block.dried_ghast.step"),
    @DInfo(since = "1.21.6")
    BLOCK_DRIED_GHAST_TRANSITION("block.dried_ghast.transition"),
    @DInfo(since = "1.17")
    BLOCK_DRIPSTONE_BLOCK_BREAK("block.dripstone_block.break"),
    @DInfo(since = "1.17")
    BLOCK_DRIPSTONE_BLOCK_FALL("block.dripstone_block.fall"),
    @DInfo(since = "1.17")
    BLOCK_DRIPSTONE_BLOCK_HIT("block.dripstone_block.hit"),
    @DInfo(since = "1.17")
    BLOCK_DRIPSTONE_BLOCK_PLACE("block.dripstone_block.place"),
    @DInfo(since = "1.17")
    BLOCK_DRIPSTONE_BLOCK_STEP("block.dripstone_block.step"),
    @DInfo(since = "1.21.6")
    BLOCK_DRY_GRASS_AMBIENT("block.dry_grass.ambient"),
    BLOCK_ENCHANTMENT_TABLE_USE("block.enchantment_table.use"),
    BLOCK_ENDER_CHEST_CLOSE("block.ender_chest.close"),
    BLOCK_ENDER_CHEST_OPEN("block.ender_chest.open"),
    BLOCK_END_GATEWAY_SPAWN("block.end_gateway.spawn"),
    BLOCK_END_PORTAL_FRAME_FILL("block.end_portal_frame.fill"),
    BLOCK_END_PORTAL_SPAWN("block.end_portal.spawn"),
    @DInfo(since = "1.21.4")
    BLOCK_EYEBLOSSOM_CLOSE("block.eyeblossom.close"),
    @DInfo(since = "1.21.4")
    BLOCK_EYEBLOSSOM_CLOSE_LONG("block.eyeblossom.close_long"),
    @DInfo(since = "1.21.4")
    BLOCK_EYEBLOSSOM_IDLE("block.eyeblossom.idle"),
    @DInfo(since = "1.21.4")
    BLOCK_EYEBLOSSOM_OPEN("block.eyeblossom.open"),
    @DInfo(since = "1.21.4")
    BLOCK_EYEBLOSSOM_OPEN_LONG("block.eyeblossom.open_long"),
    BLOCK_FENCE_GATE_CLOSE("block.fence_gate.close"),
    BLOCK_FENCE_GATE_OPEN("block.fence_gate.open"),
    @DInfo(since = "1.21.5")
    BLOCK_FIREFLY_BUSH_IDLE("block.firefly_bush.idle"),
    BLOCK_FIRE_AMBIENT("block.fire.ambient"),
    BLOCK_FIRE_EXTINGUISH("block.fire.extinguish"),
    @DInfo(since = "1.17")
    BLOCK_FLOWERING_AZALEA_BREAK("block.flowering_azalea.break"),
    @DInfo(since = "1.17")
    BLOCK_FLOWERING_AZALEA_FALL("block.flowering_azalea.fall"),
    @DInfo(since = "1.17")
    BLOCK_FLOWERING_AZALEA_HIT("block.flowering_azalea.hit"),
    @DInfo(since = "1.17")
    BLOCK_FLOWERING_AZALEA_PLACE("block.flowering_azalea.place"),
    @DInfo(since = "1.17")
    BLOCK_FLOWERING_AZALEA_STEP("block.flowering_azalea.step"),
    @DInfo(since = "1.19")
    BLOCK_FROGLIGHT_BREAK("block.froglight.break"),
    @DInfo(since = "1.19")
    BLOCK_FROGLIGHT_FALL("block.froglight.fall"),
    @DInfo(since = "1.19")
    BLOCK_FROGLIGHT_HIT("block.froglight.hit"),
    @DInfo(since = "1.19")
    BLOCK_FROGLIGHT_PLACE("block.froglight.place"),
    @DInfo(since = "1.19")
    BLOCK_FROGLIGHT_STEP("block.froglight.step"),
    @DInfo(since = "1.19")
    BLOCK_FROGSPAWN_BREAK("block.frogspawn.break"),
    @DInfo(since = "1.19")
    BLOCK_FROGSPAWN_FALL("block.frogspawn.fall"),
    @DInfo(since = "1.19")
    BLOCK_FROGSPAWN_HATCH("block.frogspawn.hatch"),
    @DInfo(since = "1.19")
    BLOCK_FROGSPAWN_HIT("block.frogspawn.hit"),
    @DInfo(since = "1.19")
    BLOCK_FROGSPAWN_PLACE("block.frogspawn.place"),
    @DInfo(since = "1.19")
    BLOCK_FROGSPAWN_STEP("block.frogspawn.step"),
    @DInfo(since = "1.16.1")
    BLOCK_FUNGUS_BREAK("block.fungus.break"),
    @DInfo(since = "1.16.1")
    BLOCK_FUNGUS_FALL("block.fungus.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_FUNGUS_HIT("block.fungus.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_FUNGUS_PLACE("block.fungus.place"),
    @DInfo(since = "1.16.1")
    BLOCK_FUNGUS_STEP("block.fungus.step"),
    BLOCK_FURNACE_FIRE_CRACKLE("block.furnace.fire_crackle"),
    @DInfo(since = "1.16.1")
    BLOCK_GILDED_BLACKSTONE_BREAK("block.gilded_blackstone.break"),
    @DInfo(since = "1.16.1")
    BLOCK_GILDED_BLACKSTONE_FALL("block.gilded_blackstone.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_GILDED_BLACKSTONE_HIT("block.gilded_blackstone.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_GILDED_BLACKSTONE_PLACE("block.gilded_blackstone.place"),
    @DInfo(since = "1.16.1")
    BLOCK_GILDED_BLACKSTONE_STEP("block.gilded_blackstone.step"),
    BLOCK_GLASS_BREAK("block.glass.break"),
    BLOCK_GLASS_FALL("block.glass.fall"),
    BLOCK_GLASS_HIT("block.glass.hit"),
    BLOCK_GLASS_PLACE("block.glass.place"),
    BLOCK_GLASS_STEP("block.glass.step"),
    BLOCK_GRASS_BREAK("block.grass.break"),
    BLOCK_GRASS_FALL("block.grass.fall"),
    BLOCK_GRASS_HIT("block.grass.hit"),
    BLOCK_GRASS_PLACE("block.grass.place"),
    BLOCK_GRASS_STEP("block.grass.step"),
    BLOCK_GRAVEL_BREAK("block.gravel.break"),
    BLOCK_GRAVEL_FALL("block.gravel.fall"),
    BLOCK_GRAVEL_HIT("block.gravel.hit"),
    BLOCK_GRAVEL_PLACE("block.gravel.place"),
    BLOCK_GRAVEL_STEP("block.gravel.step"),
    BLOCK_GRINDSTONE_USE("block.grindstone.use"),
    @DInfo(since = "1.18")
    BLOCK_GROWING_PLANT_CROP("block.growing_plant.crop"),
    @DInfo(since = "1.17")
    BLOCK_HANGING_ROOTS_BREAK("block.hanging_roots.break"),
    @DInfo(since = "1.17")
    BLOCK_HANGING_ROOTS_FALL("block.hanging_roots.fall"),
    @DInfo(since = "1.17")
    BLOCK_HANGING_ROOTS_HIT("block.hanging_roots.hit"),
    @DInfo(since = "1.17")
    BLOCK_HANGING_ROOTS_PLACE("block.hanging_roots.place"),
    @DInfo(since = "1.17")
    BLOCK_HANGING_ROOTS_STEP("block.hanging_roots.step"),
    @DInfo(since = "1.19.3")
    BLOCK_HANGING_SIGN_BREAK("block.hanging_sign.break"),
    @DInfo(since = "1.19.3")
    BLOCK_HANGING_SIGN_FALL("block.hanging_sign.fall"),
    @DInfo(since = "1.19.3")
    BLOCK_HANGING_SIGN_HIT("block.hanging_sign.hit"),
    @DInfo(since = "1.19.3")
    BLOCK_HANGING_SIGN_PLACE("block.hanging_sign.place"),
    @DInfo(since = "1.19.3")
    BLOCK_HANGING_SIGN_STEP("block.hanging_sign.step"),
    @DInfo(since = "1.20.3")
    BLOCK_HANGING_SIGN_WAXED_INTERACT_FAIL("block.hanging_sign.waxed_interact_fail"),
    @DInfo(since = "1.21")
    BLOCK_HEAVY_CORE_BREAK("block.heavy_core.break"),
    @DInfo(since = "1.21")
    BLOCK_HEAVY_CORE_FALL("block.heavy_core.fall"),
    @DInfo(since = "1.21")
    BLOCK_HEAVY_CORE_HIT("block.heavy_core.hit"),
    @DInfo(since = "1.21")
    BLOCK_HEAVY_CORE_PLACE("block.heavy_core.place"),
    @DInfo(since = "1.21")
    BLOCK_HEAVY_CORE_STEP("block.heavy_core.step"),
    BLOCK_HONEY_BLOCK_BREAK("block.honey_block.break"),
    BLOCK_HONEY_BLOCK_FALL("block.honey_block.fall"),
    BLOCK_HONEY_BLOCK_HIT("block.honey_block.hit"),
    BLOCK_HONEY_BLOCK_PLACE("block.honey_block.place"),
    BLOCK_HONEY_BLOCK_SLIDE("block.honey_block.slide"),
    BLOCK_HONEY_BLOCK_STEP("block.honey_block.step"),
    @DInfo(since = "1.21.5")
    BLOCK_IRON_BREAK("block.iron.break"),
    BLOCK_IRON_DOOR_CLOSE("block.iron_door.close"),
    BLOCK_IRON_DOOR_OPEN("block.iron_door.open"),
    @DInfo(since = "1.21.5")
    BLOCK_IRON_FALL("block.iron.fall"),
    @DInfo(since = "1.21.5")
    BLOCK_IRON_HIT("block.iron.hit"),
    @DInfo(since = "1.21.5")
    BLOCK_IRON_PLACE("block.iron.place"),
    @DInfo(since = "1.21.5")
    BLOCK_IRON_STEP("block.iron.step"),
    BLOCK_IRON_TRAPDOOR_CLOSE("block.iron_trapdoor.close"),
    BLOCK_IRON_TRAPDOOR_OPEN("block.iron_trapdoor.open"),
    BLOCK_LADDER_BREAK("block.ladder.break"),
    BLOCK_LADDER_FALL("block.ladder.fall"),
    BLOCK_LADDER_HIT("block.ladder.hit"),
    BLOCK_LADDER_PLACE("block.ladder.place"),
    BLOCK_LADDER_STEP("block.ladder.step"),
    BLOCK_LANTERN_BREAK("block.lantern.break"),
    BLOCK_LANTERN_FALL("block.lantern.fall"),
    BLOCK_LANTERN_HIT("block.lantern.hit"),
    BLOCK_LANTERN_PLACE("block.lantern.place"),
    BLOCK_LANTERN_STEP("block.lantern.step"),
    @DInfo(since = "1.17")
    BLOCK_LARGE_AMETHYST_BUD_BREAK("block.large_amethyst_bud.break"),
    @DInfo(since = "1.17")
    BLOCK_LARGE_AMETHYST_BUD_PLACE("block.large_amethyst_bud.place"),
    BLOCK_LAVA_AMBIENT("block.lava.ambient"),
    BLOCK_LAVA_EXTINGUISH("block.lava.extinguish"),
    BLOCK_LAVA_POP("block.lava.pop"),
    @DInfo(since = "1.21.5")
    BLOCK_LEAF_LITTER_BREAK("block.leaf_litter.break"),
    @DInfo(since = "1.21.5")
    BLOCK_LEAF_LITTER_STEP("block.leaf_litter.step"),
    @DInfo(since = "1.21.5")
    BLOCK_LEAF_LITTER_PLACE("block.leaf_litter.place"),
    @DInfo(since = "1.21.5")
    BLOCK_LEAF_LITTER_HIT("block.leaf_litter.hit"),
    @DInfo(since = "1.21.5")
    BLOCK_LEAF_LITTER_FALL("block.leaf_litter.fall"),
    BLOCK_LEVER_CLICK("block.lever.click"),
    BLOCK_LILY_PAD_PLACE("block.lily_pad.place"),
    @DInfo(since = "1.16.1")
    BLOCK_LODESTONE_BREAK("block.lodestone.break"),
    @DInfo(since = "1.16.1")
    BLOCK_LODESTONE_FALL("block.lodestone.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_LODESTONE_HIT("block.lodestone.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_LODESTONE_PLACE("block.lodestone.place"),
    @DInfo(since = "1.16.1")
    BLOCK_LODESTONE_STEP("block.lodestone.step"),
    @DInfo(since = "1.19")
    BLOCK_MANGROVE_ROOTS_BREAK("block.mangrove_roots.break"),
    @DInfo(since = "1.19")
    BLOCK_MANGROVE_ROOTS_FALL("block.mangrove_roots.fall"),
    @DInfo(since = "1.19")
    BLOCK_MANGROVE_ROOTS_HIT("block.mangrove_roots.hit"),
    @DInfo(since = "1.19")
    BLOCK_MANGROVE_ROOTS_PLACE("block.mangrove_roots.place"),
    @DInfo(since = "1.19")
    BLOCK_MANGROVE_ROOTS_STEP("block.mangrove_roots.step"),
    @DInfo(since = "1.17")
    BLOCK_MEDIUM_AMETHYST_BUD_BREAK("block.medium_amethyst_bud.break"),
    @DInfo(since = "1.17")
    BLOCK_MEDIUM_AMETHYST_BUD_PLACE("block.medium_amethyst_bud.place"),
    BLOCK_METAL_BREAK("block.metal.break"),
    BLOCK_METAL_FALL("block.metal.fall"),
    BLOCK_METAL_HIT("block.metal.hit"),
    BLOCK_METAL_PLACE("block.metal.place"),
    BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF("block.metal_pressure_plate.click_off"),
    BLOCK_METAL_PRESSURE_PLATE_CLICK_ON("block.metal_pressure_plate.click_on"),
    BLOCK_METAL_STEP("block.metal.step"),
    @DInfo(since = "1.17")
    BLOCK_MOSS_BREAK("block.moss.break"),
    @DInfo(since = "1.17")
    BLOCK_MOSS_CARPET_BREAK("block.moss_carpet.break"),
    @DInfo(since = "1.17")
    BLOCK_MOSS_CARPET_FALL("block.moss_carpet.fall"),
    @DInfo(since = "1.17")
    BLOCK_MOSS_CARPET_HIT("block.moss_carpet.hit"),
    @DInfo(since = "1.17")
    BLOCK_MOSS_CARPET_PLACE("block.moss_carpet.place"),
    @DInfo(since = "1.17")
    BLOCK_MOSS_CARPET_STEP("block.moss_carpet.step"),
    @DInfo(since = "1.17")
    BLOCK_MOSS_FALL("block.moss.fall"),
    @DInfo(since = "1.17")
    BLOCK_MOSS_HIT("block.moss.hit"),
    @DInfo(since = "1.17")
    BLOCK_MOSS_PLACE("block.moss.place"),
    @DInfo(since = "1.17")
    BLOCK_MOSS_STEP("block.moss.step"),
    @DInfo(since = "1.19")
    BLOCK_MUDDY_MANGROVE_ROOTS_BREAK("block.muddy_mangrove_roots.break"),
    @DInfo(since = "1.19")
    BLOCK_MUDDY_MANGROVE_ROOTS_FALL("block.muddy_mangrove_roots.fall"),
    @DInfo(since = "1.19")
    BLOCK_MUDDY_MANGROVE_ROOTS_HIT("block.muddy_mangrove_roots.hit"),
    @DInfo(since = "1.19")
    BLOCK_MUDDY_MANGROVE_ROOTS_PLACE("block.muddy_mangrove_roots.place"),
    @DInfo(since = "1.19")
    BLOCK_MUDDY_MANGROVE_ROOTS_STEP("block.muddy_mangrove_roots.step"),
    @DInfo(since = "1.19")
    BLOCK_MUD_BREAK("block.mud.break"),
    @DInfo(since = "1.19")
    BLOCK_MUD_BRICKS_BREAK("block.mud_bricks.break"),
    @DInfo(since = "1.19")
    BLOCK_MUD_BRICKS_FALL("block.mud_bricks.fall"),
    @DInfo(since = "1.19")
    BLOCK_MUD_BRICKS_HIT("block.mud_bricks.hit"),
    @DInfo(since = "1.19")
    BLOCK_MUD_BRICKS_PLACE("block.mud_bricks.place"),
    @DInfo(since = "1.19")
    BLOCK_MUD_BRICKS_STEP("block.mud_bricks.step"),
    @DInfo(since = "1.19")
    BLOCK_MUD_FALL("block.mud.fall"),
    @DInfo(since = "1.19")
    BLOCK_MUD_HIT("block.mud.hit"),
    @DInfo(since = "1.19")
    BLOCK_MUD_PLACE("block.mud.place"),
    @DInfo(since = "1.19")
    BLOCK_MUD_STEP("block.mud.step"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHERITE_BLOCK_BREAK("block.netherite_block.break"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHERITE_BLOCK_FALL("block.netherite_block.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHERITE_BLOCK_HIT("block.netherite_block.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHERITE_BLOCK_PLACE("block.netherite_block.place"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHERITE_BLOCK_STEP("block.netherite_block.step"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHERRACK_BREAK("block.netherrack.break"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHERRACK_FALL("block.netherrack.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHERRACK_HIT("block.netherrack.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHERRACK_PLACE("block.netherrack.place"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHERRACK_STEP("block.netherrack.step"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_BRICKS_BREAK("block.nether_bricks.break"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_BRICKS_FALL("block.nether_bricks.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_BRICKS_HIT("block.nether_bricks.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_BRICKS_PLACE("block.nether_bricks.place"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_BRICKS_STEP("block.nether_bricks.step"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_GOLD_ORE_BREAK("block.nether_gold_ore.break"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_GOLD_ORE_FALL("block.nether_gold_ore.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_GOLD_ORE_HIT("block.nether_gold_ore.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_GOLD_ORE_PLACE("block.nether_gold_ore.place"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_GOLD_ORE_STEP("block.nether_gold_ore.step"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_ORE_BREAK("block.nether_ore.break"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_ORE_FALL("block.nether_ore.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_ORE_HIT("block.nether_ore.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_ORE_PLACE("block.nether_ore.place"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_ORE_STEP("block.nether_ore.step"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_SPROUTS_BREAK("block.nether_sprouts.break"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_SPROUTS_FALL("block.nether_sprouts.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_SPROUTS_HIT("block.nether_sprouts.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_SPROUTS_PLACE("block.nether_sprouts.place"),
    @DInfo(since = "1.16.1")
    BLOCK_NETHER_SPROUTS_STEP("block.nether_sprouts.step"),
    BLOCK_NETHER_WART_BREAK("block.nether_wart.break"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_BREAK("block.nether_wood.break"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_BUTTON_CLICK_OFF("block.nether_wood_button.click_off"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_BUTTON_CLICK_ON("block.nether_wood_button.click_on"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_DOOR_CLOSE("block.nether_wood_door.close"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_DOOR_OPEN("block.nether_wood_door.open"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_FALL("block.nether_wood.fall"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_FENCE_GATE_CLOSE("block.nether_wood_fence_gate.close"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_FENCE_GATE_OPEN("block.nether_wood_fence_gate.open"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_HANGING_SIGN_BREAK("block.nether_wood_hanging_sign.break"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_HANGING_SIGN_FALL("block.nether_wood_hanging_sign.fall"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_HANGING_SIGN_HIT("block.nether_wood_hanging_sign.hit"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_HANGING_SIGN_PLACE("block.nether_wood_hanging_sign.place"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_HANGING_SIGN_STEP("block.nether_wood_hanging_sign.step"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_HIT("block.nether_wood.hit"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_PLACE("block.nether_wood.place"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF("block.nether_wood_pressure_plate.click_off"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_ON("block.nether_wood_pressure_plate.click_on"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_STEP("block.nether_wood.step"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_TRAPDOOR_CLOSE("block.nether_wood_trapdoor.close"),
    @DInfo(since = "1.19.3")
    BLOCK_NETHER_WOOD_TRAPDOOR_OPEN("block.nether_wood_trapdoor.open"),
    BLOCK_NOTE_BLOCK_BANJO("block.note_block.banjo"),
    BLOCK_NOTE_BLOCK_BASEDRUM("block.note_block.basedrum"),
    BLOCK_NOTE_BLOCK_BASS("block.note_block.bass"),
    BLOCK_NOTE_BLOCK_BELL("block.note_block.bell"),
    BLOCK_NOTE_BLOCK_BIT("block.note_block.bit"),
    BLOCK_NOTE_BLOCK_CHIME("block.note_block.chime"),
    BLOCK_NOTE_BLOCK_COW_BELL("block.note_block.cow_bell"),
    BLOCK_NOTE_BLOCK_DIDGERIDOO("block.note_block.didgeridoo"),
    BLOCK_NOTE_BLOCK_FLUTE("block.note_block.flute"),
    BLOCK_NOTE_BLOCK_GUITAR("block.note_block.guitar"),
    BLOCK_NOTE_BLOCK_HARP("block.note_block.harp"),
    BLOCK_NOTE_BLOCK_HAT("block.note_block.hat"),
    @DInfo(since = "1.19.3")
    BLOCK_NOTE_BLOCK_IMITATE_CREEPER("block.note_block.imitate.creeper"),
    @DInfo(since = "1.19.3")
    BLOCK_NOTE_BLOCK_IMITATE_ENDER_DRAGON("block.note_block.imitate.ender_dragon"),
    @DInfo(since = "1.19.3")
    BLOCK_NOTE_BLOCK_IMITATE_PIGLIN("block.note_block.imitate.piglin"),
    @DInfo(since = "1.19.3")
    BLOCK_NOTE_BLOCK_IMITATE_SKELETON("block.note_block.imitate.skeleton"),
    @DInfo(since = "1.19.3")
    BLOCK_NOTE_BLOCK_IMITATE_WITHER_SKELETON("block.note_block.imitate.wither_skeleton"),
    @DInfo(since = "1.19.3")
    BLOCK_NOTE_BLOCK_IMITATE_ZOMBIE("block.note_block.imitate.zombie"),
    BLOCK_NOTE_BLOCK_IRON_XYLOPHONE("block.note_block.iron_xylophone"),
    BLOCK_NOTE_BLOCK_PLING("block.note_block.pling"),
    BLOCK_NOTE_BLOCK_SNARE("block.note_block.snare"),
    BLOCK_NOTE_BLOCK_XYLOPHONE("block.note_block.xylophone"),
    @DInfo(since = "1.16.1")
    BLOCK_NYLIUM_BREAK("block.nylium.break"),
    @DInfo(since = "1.16.1")
    BLOCK_NYLIUM_FALL("block.nylium.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_NYLIUM_HIT("block.nylium.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_NYLIUM_PLACE("block.nylium.place"),
    @DInfo(since = "1.16.1")
    BLOCK_NYLIUM_STEP("block.nylium.step"),
    @DInfo(since = "1.19")
    BLOCK_PACKED_MUD_BREAK("block.packed_mud.break"),
    @DInfo(since = "1.19")
    BLOCK_PACKED_MUD_FALL("block.packed_mud.fall"),
    @DInfo(since = "1.19")
    BLOCK_PACKED_MUD_HIT("block.packed_mud.hit"),
    @DInfo(since = "1.19")
    BLOCK_PACKED_MUD_PLACE("block.packed_mud.place"),
    @DInfo(since = "1.19")
    BLOCK_PACKED_MUD_STEP("block.packed_mud.step"),
    @DInfo(since = "1.21.2")
    BLOCK_PALE_HANGING_MOSS_IDLE("block.pale_hanging_moss.idle"),
    @DInfo(since = "1.19.4")
    BLOCK_PINK_PETALS_BREAK("block.pink_petals.break"),
    @DInfo(since = "1.19.4")
    BLOCK_PINK_PETALS_FALL("block.pink_petals.fall"),
    @DInfo(since = "1.19.4")
    BLOCK_PINK_PETALS_HIT("block.pink_petals.hit"),
    @DInfo(since = "1.19.4")
    BLOCK_PINK_PETALS_PLACE("block.pink_petals.place"),
    @DInfo(since = "1.19.4")
    BLOCK_PINK_PETALS_STEP("block.pink_petals.step"),
    BLOCK_PISTON_CONTRACT("block.piston.contract"),
    BLOCK_PISTON_EXTEND("block.piston.extend"),
    @DInfo(since = "1.17")
    BLOCK_POINTED_DRIPSTONE_BREAK("block.pointed_dripstone.break"),
    @DInfo(since = "1.17")
    BLOCK_POINTED_DRIPSTONE_DRIP_LAVA("block.pointed_dripstone.drip_lava"),
    @DInfo(since = "1.17")
    BLOCK_POINTED_DRIPSTONE_DRIP_LAVA_INTO_CAULDRON("block.pointed_dripstone.drip_lava_into_cauldron"),
    @DInfo(since = "1.17")
    BLOCK_POINTED_DRIPSTONE_DRIP_WATER("block.pointed_dripstone.drip_water"),
    @DInfo(since = "1.17")
    BLOCK_POINTED_DRIPSTONE_DRIP_WATER_INTO_CAULDRON("block.pointed_dripstone.drip_water_into_cauldron"),
    @DInfo(since = "1.17")
    BLOCK_POINTED_DRIPSTONE_FALL("block.pointed_dripstone.fall"),
    @DInfo(since = "1.17")
    BLOCK_POINTED_DRIPSTONE_HIT("block.pointed_dripstone.hit"),
    @DInfo(since = "1.17")
    BLOCK_POINTED_DRIPSTONE_LAND("block.pointed_dripstone.land"),
    @DInfo(since = "1.17")
    BLOCK_POINTED_DRIPSTONE_PLACE("block.pointed_dripstone.place"),
    @DInfo(since = "1.17")
    BLOCK_POINTED_DRIPSTONE_STEP("block.pointed_dripstone.step"),
    @DInfo(since = "1.17")
    BLOCK_POLISHED_DEEPSLATE_BREAK("block.polished_deepslate.break"),
    @DInfo(since = "1.17")
    BLOCK_POLISHED_DEEPSLATE_FALL("block.polished_deepslate.fall"),
    @DInfo(since = "1.17")
    BLOCK_POLISHED_DEEPSLATE_HIT("block.polished_deepslate.hit"),
    @DInfo(since = "1.17")
    BLOCK_POLISHED_DEEPSLATE_PLACE("block.polished_deepslate.place"),
    @DInfo(since = "1.17")
    BLOCK_POLISHED_DEEPSLATE_STEP("block.polished_deepslate.step"),
    @DInfo(since = "1.21")
    BLOCK_POLISHED_TUFF_BREAK("block.polished_tuff.break"),
    @DInfo(since = "1.21")
    BLOCK_POLISHED_TUFF_FALL("block.polished_tuff.fall"),
    @DInfo(since = "1.21")
    BLOCK_POLISHED_TUFF_HIT("block.polished_tuff.hit"),
    @DInfo(since = "1.21")
    BLOCK_POLISHED_TUFF_PLACE("block.polished_tuff.place"),
    @DInfo(since = "1.21")
    BLOCK_POLISHED_TUFF_STEP("block.polished_tuff.step"),
    BLOCK_PORTAL_AMBIENT("block.portal.ambient"),
    BLOCK_PORTAL_TRAVEL("block.portal.travel"),
    BLOCK_PORTAL_TRIGGER("block.portal.trigger"),
    @DInfo(since = "1.17")
    BLOCK_POWDER_SNOW_BREAK("block.powder_snow.break"),
    @DInfo(since = "1.17")
    BLOCK_POWDER_SNOW_FALL("block.powder_snow.fall"),
    @DInfo(since = "1.17")
    BLOCK_POWDER_SNOW_HIT("block.powder_snow.hit"),
    @DInfo(since = "1.17")
    BLOCK_POWDER_SNOW_PLACE("block.powder_snow.place"),
    @DInfo(since = "1.17")
    BLOCK_POWDER_SNOW_STEP("block.powder_snow.step"),
    BLOCK_PUMPKIN_CARVE("block.pumpkin.carve"),
    BLOCK_REDSTONE_TORCH_BURNOUT("block.redstone_torch.burnout"),
    @DInfo(since = "1.21.4")
    BLOCK_RESIN_BREAK("block.resin.break"),
    @DInfo(since = "1.21.4")
    BLOCK_RESIN_BRICKS_BREAK("block.resin_bricks.break"),
    @DInfo(since = "1.21.4")
    BLOCK_RESIN_BRICKS_FALL("block.resin_bricks.fall"),
    @DInfo(since = "1.21.4")
    BLOCK_RESIN_BRICKS_HIT("block.resin_bricks.hit"),
    @DInfo(since = "1.21.4")
    BLOCK_RESIN_BRICKS_PLACE("block.resin_bricks.place"),
    @DInfo(since = "1.21.4")
    BLOCK_RESIN_BRICKS_STEP("block.resin_bricks.step"),
    @DInfo(since = "1.21.4")
    BLOCKS_RESIN_FALL("blocks.resin.fall"),
    @DInfo(since = "1.21.4")
    BLOCK_RESIN_PLACE("block.resin.place"),
    @DInfo(since = "1.21.4")
    BLOCK_RESIN_STEP("block.resin.step"),
    @DInfo(since = "1.16.1")
    BLOCK_RESPAWN_ANCHOR_AMBIENT("block.respawn_anchor.ambient"),
    @DInfo(since = "1.16.1")
    BLOCK_RESPAWN_ANCHOR_CHARGE("block.respawn_anchor.charge"),
    @DInfo(since = "1.16.1")
    BLOCK_RESPAWN_ANCHOR_DEPLETE("block.respawn_anchor.deplete"),
    @DInfo(since = "1.16.1")
    BLOCK_RESPAWN_ANCHOR_SET_SPAWN("block.respawn_anchor.set_spawn"),
    @DInfo(since = "1.17")
    BLOCK_ROOTED_DIRT_BREAK("block.rooted_dirt.break"),
    @DInfo(since = "1.17")
    BLOCK_ROOTED_DIRT_FALL("block.rooted_dirt.fall"),
    @DInfo(since = "1.17")
    BLOCK_ROOTED_DIRT_HIT("block.rooted_dirt.hit"),
    @DInfo(since = "1.17")
    BLOCK_ROOTED_DIRT_PLACE("block.rooted_dirt.place"),
    @DInfo(since = "1.17")
    BLOCK_ROOTED_DIRT_STEP("block.rooted_dirt.step"),
    @DInfo(since = "1.16.1")
    BLOCK_ROOTS_BREAK("block.roots.break"),
    @DInfo(since = "1.16.1")
    BLOCK_ROOTS_FALL("block.roots.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_ROOTS_HIT("block.roots.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_ROOTS_PLACE("block.roots.place"),
    @DInfo(since = "1.16.1")
    BLOCK_ROOTS_STEP("block.roots.step"),
    BLOCK_SAND_BREAK("block.sand.break"),
    BLOCK_SAND_FALL("block.sand.fall"),
    BLOCK_SAND_HIT("block.sand.hit"),
    @DInfo(since = "1.21.5")
    BLOCK_SAND_IDLE("block.sand.idle"),
    BLOCK_SAND_PLACE("block.sand.place"),
    BLOCK_SAND_STEP("block.sand.step"),
    BLOCK_SCAFFOLDING_BREAK("block.scaffolding.break"),
    BLOCK_SCAFFOLDING_FALL("block.scaffolding.fall"),
    BLOCK_SCAFFOLDING_HIT("block.scaffolding.hit"),
    BLOCK_SCAFFOLDING_PLACE("block.scaffolding.place"),
    BLOCK_SCAFFOLDING_STEP("block.scaffolding.step"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_BREAK("block.sculk.break"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_CATALYST_BLOOM("block.sculk_catalyst.bloom"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_CATALYST_BREAK("block.sculk_catalyst.break"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_CATALYST_FALL("block.sculk_catalyst.fall"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_CATALYST_HIT("block.sculk_catalyst.hit"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_CATALYST_PLACE("block.sculk_catalyst.place"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_CATALYST_STEP("block.sculk_catalyst.step"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_CHARGE("block.sculk.charge"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_FALL("block.sculk.fall"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_HIT("block.sculk.hit"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_PLACE("block.sculk.place"),
    @DInfo(since = "1.17")
    BLOCK_SCULK_SENSOR_BREAK("block.sculk_sensor.break"),
    @DInfo(since = "1.17")
    BLOCK_SCULK_SENSOR_CLICKING("block.sculk_sensor.clicking"),
    @DInfo(since = "1.17")
    BLOCK_SCULK_SENSOR_CLICKING_STOP("block.sculk_sensor.clicking_stop"),
    @DInfo(since = "1.17")
    BLOCK_SCULK_SENSOR_FALL("block.sculk_sensor.fall"),
    @DInfo(since = "1.17")
    BLOCK_SCULK_SENSOR_HIT("block.sculk_sensor.hit"),
    @DInfo(since = "1.17")
    BLOCK_SCULK_SENSOR_PLACE("block.sculk_sensor.place"),
    @DInfo(since = "1.17")
    BLOCK_SCULK_SENSOR_STEP("block.sculk_sensor.step"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_SHRIEKER_BREAK("block.sculk_shrieker.break"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_SHRIEKER_FALL("block.sculk_shrieker.fall"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_SHRIEKER_HIT("block.sculk_shrieker.hit"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_SHRIEKER_PLACE("block.sculk_shrieker.place"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_SHRIEKER_SHRIEK("block.sculk_shrieker.shriek"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_SHRIEKER_STEP("block.sculk_shrieker.step"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_SPREAD("block.sculk.spread"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_STEP("block.sculk.step"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_VEIN_BREAK("block.sculk_vein.break"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_VEIN_FALL("block.sculk_vein.fall"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_VEIN_HIT("block.sculk_vein.hit"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_VEIN_PLACE("block.sculk_vein.place"),
    @DInfo(since = "1.19")
    BLOCK_SCULK_VEIN_STEP("block.sculk_vein.step"),
    @DInfo(since = "1.16.1")
    BLOCK_SHROOMLIGHT_BREAK("block.shroomlight.break"),
    @DInfo(since = "1.16.1")
    BLOCK_SHROOMLIGHT_FALL("block.shroomlight.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_SHROOMLIGHT_HIT("block.shroomlight.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_SHROOMLIGHT_PLACE("block.shroomlight.place"),
    @DInfo(since = "1.16.1")
    BLOCK_SHROOMLIGHT_STEP("block.shroomlight.step"),
    BLOCK_SHULKER_BOX_CLOSE("block.shulker_box.close"),
    BLOCK_SHULKER_BOX_OPEN("block.shulker_box.open"),
    BLOCK_SIGN_WAXED_INTERACT_FAIL("block.sign.waxed_interact_fail"),
    BLOCK_SLIME_BLOCK_BREAK("block.slime_block.break"),
    BLOCK_SLIME_BLOCK_FALL("block.slime_block.fall"),
    BLOCK_SLIME_BLOCK_HIT("block.slime_block.hit"),
    BLOCK_SLIME_BLOCK_PLACE("block.slime_block.place"),
    BLOCK_SLIME_BLOCK_STEP("block.slime_block.step"),
    @DInfo(since = "1.17")
    BLOCK_SMALL_AMETHYST_BUD_BREAK("block.small_amethyst_bud.break"),
    @DInfo(since = "1.17")
    BLOCK_SMALL_AMETHYST_BUD_PLACE("block.small_amethyst_bud.place"),
    @DInfo(since = "1.17")
    BLOCK_SMALL_DRIPLEAF_BREAK("block.small_dripleaf.break"),
    @DInfo(since = "1.17")
    BLOCK_SMALL_DRIPLEAF_FALL("block.small_dripleaf.fall"),
    @DInfo(since = "1.17")
    BLOCK_SMALL_DRIPLEAF_HIT("block.small_dripleaf.hit"),
    @DInfo(since = "1.17")
    BLOCK_SMALL_DRIPLEAF_PLACE("block.small_dripleaf.place"),
    @DInfo(since = "1.17")
    BLOCK_SMALL_DRIPLEAF_STEP("block.small_dripleaf.step"),
    @DInfo(since = "1.16.1")
    BLOCK_SMITHING_TABLE_USE("block.smithing_table.use"),
    BLOCK_SMOKER_SMOKE("block.smoker.smoke"),
    @DInfo(since = "1.20")
    BLOCK_SNIFFER_EGG_CRACK("block.sniffer_egg.crack"),
    @DInfo(since = "1.20")
    BLOCK_SNIFFER_EGG_HATCH("block.sniffer_egg.hatch"),
    @DInfo(since = "1.20")
    BLOCK_SNIFFER_EGG_PLOP("block.sniffer_egg.plop"),
    BLOCK_SNOW_BREAK("block.snow.break"),
    BLOCK_SNOW_FALL("block.snow.fall"),
    BLOCK_SNOW_HIT("block.snow.hit"),
    BLOCK_SNOW_PLACE("block.snow.place"),
    BLOCK_SNOW_STEP("block.snow.step"),
    @DInfo(since = "1.16.1")
    BLOCK_SOUL_SAND_BREAK("block.soul_sand.break"),
    @DInfo(since = "1.16.1")
    BLOCK_SOUL_SAND_FALL("block.soul_sand.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_SOUL_SAND_HIT("block.soul_sand.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_SOUL_SAND_PLACE("block.soul_sand.place"),
    @DInfo(since = "1.16.1")
    BLOCK_SOUL_SAND_STEP("block.soul_sand.step"),
    @DInfo(since = "1.16.1")
    BLOCK_SOUL_SOIL_BREAK("block.soul_soil.break"),
    @DInfo(since = "1.16.1")
    BLOCK_SOUL_SOIL_FALL("block.soul_soil.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_SOUL_SOIL_HIT("block.soul_soil.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_SOUL_SOIL_PLACE("block.soul_soil.place"),
    @DInfo(since = "1.16.1")
    BLOCK_SOUL_SOIL_STEP("block.soul_soil.step"),
    @DInfo(since = "1.21.2")
    BLOCK_SPAWNER_BREAK("block.spawner.break"),
    @DInfo(since = "1.21.2")
    BLOCK_SPAWNER_FALL("block.spawner.fall"),
    @DInfo(since = "1.21.2")
    BLOCK_SPAWNER_HIT("block.spawner.hit"),
    @DInfo(since = "1.21.2")
    BLOCK_SPAWNER_PLACE("block.spawner.place"),
    @DInfo(since = "1.21.2")
    BLOCK_SPAWNER_STEP("block.spawner.step"),
    @DInfo(since = "1.20.2")
    BLOCK_SPONGE_ABSORB("block.sponge.absorb"),
    @DInfo(since = "1.20.2")
    BLOCK_SPONGE_BREAK("block.sponge.break"),
    @DInfo(since = "1.20.2")
    BLOCK_SPONGE_FALL("block.sponge.fall"),
    @DInfo(since = "1.20.2")
    BLOCK_SPONGE_HIT("block.sponge.hit"),
    @DInfo(since = "1.20.2")
    BLOCK_SPONGE_PLACE("block.sponge.place"),
    @DInfo(since = "1.20.2")
    BLOCK_SPONGE_STEP("block.sponge.step"),
    @DInfo(since = "1.17")
    BLOCK_SPORE_BLOSSOM_BREAK("block.spore_blossom.break"),
    @DInfo(since = "1.17")
    BLOCK_SPORE_BLOSSOM_FALL("block.spore_blossom.fall"),
    @DInfo(since = "1.17")
    BLOCK_SPORE_BLOSSOM_HIT("block.spore_blossom.hit"),
    @DInfo(since = "1.17")
    BLOCK_SPORE_BLOSSOM_PLACE("block.spore_blossom.place"),
    @DInfo(since = "1.17")
    BLOCK_SPORE_BLOSSOM_STEP("block.spore_blossom.step"),
    @DInfo(since = "1.16.1")
    BLOCK_STEM_BREAK("block.stem.break"),
    @DInfo(since = "1.16.1")
    BLOCK_STEM_FALL("block.stem.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_STEM_HIT("block.stem.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_STEM_PLACE("block.stem.place"),
    @DInfo(since = "1.16.1")
    BLOCK_STEM_STEP("block.stem.step"),
    @DInfo(since = "1.16.1")
    BLOCK_STONE_BREAK("block.stone.break"),
    BLOCK_STONE_BUTTON_CLICK_OFF("block.stone_button.click_off"),
    BLOCK_STONE_BUTTON_CLICK_ON("block.stone_button.click_on"),
    BLOCK_STONE_FALL("block.stone.fall"),
    BLOCK_STONE_HIT("block.stone.hit"),
    BLOCK_STONE_PLACE("block.stone.place"),
    BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF("block.stone_pressure_plate.click_off"),
    BLOCK_STONE_PRESSURE_PLATE_CLICK_ON("block.stone_pressure_plate.click_on"),
    BLOCK_STONE_STEP("block.stone.step"),
    @DInfo(since = "1.20")
    BLOCK_SUSPICIOUS_GRAVEL_BREAK("block.suspicious_gravel.break"),
    @DInfo(since = "1.20")
    BLOCK_SUSPICIOUS_GRAVEL_FALL("block.suspicious_gravel.fall"),
    @DInfo(since = "1.20")
    BLOCK_SUSPICIOUS_GRAVEL_HIT("block.suspicious_gravel.hit"),
    @DInfo(since = "1.20")
    BLOCK_SUSPICIOUS_GRAVEL_PLACE("block.suspicious_gravel.place"),
    @DInfo(since = "1.20")
    BLOCK_SUSPICIOUS_GRAVEL_STEP("block.suspicious_gravel.step"),
    @DInfo(since = "1.19.4")
    BLOCK_SUSPICIOUS_SAND_BREAK("block.suspicious_sand.break"),
    @DInfo(since = "1.19.4")
    BLOCK_SUSPICIOUS_SAND_FALL("block.suspicious_sand.fall"),
    @DInfo(since = "1.19.4")
    BLOCK_SUSPICIOUS_SAND_HIT("block.suspicious_sand.hit"),
    @DInfo(since = "1.19.4")
    BLOCK_SUSPICIOUS_SAND_PLACE("block.suspicious_sand.place"),
    @DInfo(since = "1.19.4")
    BLOCK_SUSPICIOUS_SAND_STEP("block.suspicious_sand.step"),
    BLOCK_SWEET_BERRY_BUSH_BREAK("block.sweet_berry_bush.break"),
    @DRenamed(since = "1.17", from = "ITEM_SWEET_BERRIES_PICK_FROM_BUSH")
    BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES("block.sweet_berry_bush.pick_berries"),
    BLOCK_SWEET_BERRY_BUSH_PLACE("block.sweet_berry_bush.place"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_ABOUT_TO_SPAWN_ITEM("block.trial_spawner.about_to_spawn_item"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_AMBIENT("block.trial_spawner.ambient"),
    @DRenamed(since = "1.21", from = "BLOCK_TRIAL_SPAWNER_AMBIENT_CHARGED")
    BLOCK_TRIAL_SPAWNER_AMBIENT_OMINOUS("block.trial_spawner.ambient_ominous"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_BREAK("block.trial_spawner.break"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_CLOSE_SHUTTER("block.trial_spawner.close_shutter"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_DETECT_PLAYER("block.trial_spawner.detect_player"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_EJECT_ITEM("block.trial_spawner.eject_item"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_FALL("block.trial_spawner.fall"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_HIT("block.trial_spawner.hit"),
    @DRenamed(since = "1.21", from = "BLOCK_TRIAL_SPAWNER_CHARGE_ACTIVATE")
    BLOCK_TRIAL_SPAWNER_OMINOUS_ACTIVATE("block.trial_spawner.ominous_activate"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_OPEN_SHUTTER("block.trial_spawner.open_shutter"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_PLACE("block.trial_spawner.place"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_SPAWN_ITEM("block.trial_spawner.spawn_item"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_SPAWN_ITEM_BEGIN("block.trial_spawner.spawn_item_begin"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_SPAWN_MOB("block.trial_spawner.spawn_mob"),
    @DInfo(since = "1.21")
    BLOCK_TRIAL_SPAWNER_STEP("block.trial_spawner.step"),
    BLOCK_TRIPWIRE_ATTACH("block.tripwire.attach"),
    BLOCK_TRIPWIRE_CLICK_OFF("block.tripwire.click_off"),
    BLOCK_TRIPWIRE_CLICK_ON("block.tripwire.click_on"),
    BLOCK_TRIPWIRE_DETACH("block.tripwire.detach"),
    @DInfo(since = "1.17")
    BLOCK_TUFF_BREAK("block.tuff.break"),
    @DInfo(since = "1.21")
    BLOCK_TUFF_BRICKS_BREAK("block.tuff_bricks.break"),
    @DInfo(since = "1.21")
    BLOCK_TUFF_BRICKS_FALL("block.tuff_bricks.fall"),
    @DInfo(since = "1.21")
    BLOCK_TUFF_BRICKS_HIT("block.tuff_bricks.hit"),
    @DInfo(since = "1.21")
    BLOCK_TUFF_BRICKS_PLACE("block.tuff_bricks.place"),
    @DInfo(since = "1.21")
    BLOCK_TUFF_BRICKS_STEP("block.tuff_bricks.step"),
    @DInfo(since = "1.17")
    BLOCK_TUFF_FALL("block.tuff.fall"),
    @DInfo(since = "1.17")
    BLOCK_TUFF_HIT("block.tuff.hit"),
    @DInfo(since = "1.17")
    BLOCK_TUFF_PLACE("block.tuff.place"),
    @DInfo(since = "1.17")
    BLOCK_TUFF_STEP("block.tuff.step"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_ACTIVATE("block.vault.activate"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_AMBIENT("block.vault.ambient"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_BREAK("block.vault.break"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_CLOSE_SHUTTER("block.vault.close_shutter"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_DEACTIVATE("block.vault.deactivate"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_EJECT_ITEM("block.vault.eject_item"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_FALL("block.vault.fall"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_HIT("block.vault.hit"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_INSERT_ITEM("block.vault.insert_item"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_INSERT_ITEM_FAIL("block.vault.insert_item_fail"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_OPEN_SHUTTER("block.vault.open_shutter"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_PLACE("block.vault.place"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_REJECT_REWARDED_PLAYER("block.vault.reject_rewarded_player"),
    @DInfo(since = "1.21")
    BLOCK_VAULT_STEP("block.vault.step"),
    @DInfo(since = "1.17")
    BLOCK_VINE_BREAK("block.vine.break"),
    @DInfo(since = "1.17")
    BLOCK_VINE_FALL("block.vine.fall"),
    @DInfo(since = "1.17")
    BLOCK_VINE_HIT("block.vine.hit"),
    @DInfo(since = "1.17")
    BLOCK_VINE_PLACE("block.vine.place"),
    @DInfo(since = "1.16.1")
    BLOCK_VINE_STEP("block.vine.step"),
    @DInfo(since = "1.16.1")
    BLOCK_WART_BLOCK_BREAK("block.wart_block.break"),
    @DInfo(since = "1.16.1")
    BLOCK_WART_BLOCK_FALL("block.wart_block.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_WART_BLOCK_HIT("block.wart_block.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_WART_BLOCK_PLACE("block.wart_block.place"),
    @DInfo(since = "1.16.1")
    BLOCK_WART_BLOCK_STEP("block.wart_block.step"),
    BLOCK_WATER_AMBIENT("block.water.ambient"),
    @DInfo(since = "1.16.1")
    BLOCK_WEEPING_VINES_BREAK("block.weeping_vines.break"),
    @DInfo(since = "1.16.1")
    BLOCK_WEEPING_VINES_FALL("block.weeping_vines.fall"),
    @DInfo(since = "1.16.1")
    BLOCK_WEEPING_VINES_HIT("block.weeping_vines.hit"),
    @DInfo(since = "1.16.1")
    BLOCK_WEEPING_VINES_PLACE("block.weeping_vines.place"),
    @DInfo(since = "1.16.1")
    BLOCK_WEEPING_VINES_STEP("block.weeping_vines.step"),
    BLOCK_WET_GRASS_BREAK("block.wet_grass.break"),
    BLOCK_WET_GRASS_FALL("block.wet_grass.fall"),
    BLOCK_WET_GRASS_HIT("block.wet_grass.hit"),
    BLOCK_WET_GRASS_PLACE("block.wet_grass.place"),
    BLOCK_WET_GRASS_STEP("block.wet_grass.step"),
    @DInfo(since = "1.20.2")
    BLOCK_WET_SPONGE_BREAK("block.wet_sponge.break"),
    @DInfo(since = "1.20.5")
    BLOCK_WET_SPONGE_DRIES("block.wet_sponge.dries"),
    @DInfo(since = "1.20.2")
    BLOCK_WET_SPONGE_FALL("block.wet_sponge.fall"),
    @DInfo(since = "1.20.2")
    BLOCK_WET_SPONGE_HIT("block.wet_sponge.hit"),
    @DInfo(since = "1.20.2")
    BLOCK_WET_SPONGE_PLACE("block.wet_sponge.place"),
    @DInfo(since = "1.20.2")
    BLOCK_WET_SPONGE_STEP("block.wet_sponge.step"),
    BLOCK_WOODEN_BUTTON_CLICK_OFF("block.wooden_button.click_off"),
    BLOCK_WOODEN_BUTTON_CLICK_ON("block.wooden_button.click_on"),
    BLOCK_WOODEN_DOOR_CLOSE("block.wooden_door.close"),
    BLOCK_WOODEN_DOOR_OPEN("block.wooden_door.open"),
    BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF("block.wooden_pressure_plate.click_off"),
    BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON("block.wooden_pressure_plate.click_on"),
    BLOCK_WOODEN_TRAPDOOR_CLOSE("block.wooden_trapdoor.close"),
    BLOCK_WOODEN_TRAPDOOR_OPEN("block.wooden_trapdoor.open"),
    BLOCK_WOOD_BREAK("block.wood.break"),
    BLOCK_WOOD_FALL("block.wood.fall"),
    BLOCK_WOOD_HIT("block.wood.hit"),
    BLOCK_WOOD_PLACE("block.wood.place"),
    BLOCK_WOOD_STEP("block.wood.step"),
    BLOCK_WOOL_BREAK("block.wool.break"),
    BLOCK_WOOL_FALL("block.wool.fall"),
    BLOCK_WOOL_HIT("block.wool.hit"),
    BLOCK_WOOL_PLACE("block.wool.place"),
    BLOCK_WOOL_STEP("block.wool.step"),
    ENCHANT_THORNS_HIT("enchant.thorns.hit"),
    @DInfo(since = "1.19")
    ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM("entity.allay.ambient_without_item"),
    @DInfo(since = "1.19")
    ENTITY_ALLAY_AMBIENT_WITH_ITEM("entity.allay.ambient_with_item"),
    @DInfo(since = "1.19")
    ENTITY_ALLAY_DEATH("entity.allay.death"),
    @DInfo(since = "1.19")
    ENTITY_ALLAY_HURT("entity.allay.hurt"),
    @DInfo(since = "1.19")
    ENTITY_ALLAY_ITEM_GIVEN("entity.allay.item_given"),
    @DInfo(since = "1.19")
    ENTITY_ALLAY_ITEM_TAKEN("entity.allay.item_taken"),
    @DInfo(since = "1.19")
    ENTITY_ALLAY_ITEM_THROWN("entity.allay.item_thrown"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_AMBIENT("entity.armadillo.ambient"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_BRUSH("entity.armadillo.brush"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_DEATH("entity.armadillo.death"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_EAT("entity.armadillo.eat"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_HURT("entity.armadillo.hurt"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_HURT_REDUCED("entity.armadillo.hurt_reduced"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_LAND("entity.armadillo.land"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_PEEK("entity.armadillo.peek"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_ROLL("entity.armadillo.roll"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_SCUTE_DROP("entity.armadillo.scute_drop"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_STEP("entity.armadillo.step"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_UNROLL_FINISH("entity.armadillo.unroll_finish"),
    @DInfo(since = "1.20.5")
    ENTITY_ARMADILLO_UNROLL_START("entity.armadillo.unroll_start"),
    ENTITY_ARMOR_STAND_BREAK("entity.armor_stand.break"),
    ENTITY_ARMOR_STAND_FALL("entity.armor_stand.fall"),
    ENTITY_ARMOR_STAND_HIT("entity.armor_stand.hit"),
    ENTITY_ARMOR_STAND_PLACE("entity.armor_stand.place"),
    ENTITY_ARROW_HIT("entity.arrow.hit"),
    ENTITY_ARROW_HIT_PLAYER("entity.arrow.hit_player"),
    ENTITY_ARROW_SHOOT("entity.arrow.shoot"),
    @DInfo(since = "1.17")
    ENTITY_AXOLOTL_ATTACK("entity.axolotl.attack"),
    @DInfo(since = "1.17")
    ENTITY_AXOLOTL_DEATH("entity.axolotl.death"),
    @DInfo(since = "1.17")
    ENTITY_AXOLOTL_HURT("entity.axolotl.hurt"),
    @DInfo(since = "1.17")
    ENTITY_AXOLOTL_IDLE_AIR("entity.axolotl.idle_air"),
    @DInfo(since = "1.17")
    ENTITY_AXOLOTL_IDLE_WATER("entity.axolotl.idle_water"),
    @DInfo(since = "1.17")
    ENTITY_AXOLOTL_SPLASH("entity.axolotl.splash"),
    @DInfo(since = "1.17")
    ENTITY_AXOLOTL_SWIM("entity.axolotl.swim"),
    ENTITY_BAT_AMBIENT("entity.bat.ambient"),
    ENTITY_BAT_DEATH("entity.bat.death"),
    ENTITY_BAT_HURT("entity.bat.hurt"),
    ENTITY_BAT_LOOP("entity.bat.loop"),
    ENTITY_BAT_TAKEOFF("entity.bat.takeoff"),
    ENTITY_BEE_DEATH("entity.bee.death"),
    ENTITY_BEE_HURT("entity.bee.hurt"),
    ENTITY_BEE_LOOP("entity.bee.loop"),
    ENTITY_BEE_LOOP_AGGRESSIVE("entity.bee.loop_aggressive"),
    ENTITY_BEE_POLLINATE("entity.bee.pollinate"),
    ENTITY_BEE_STING("entity.bee.sting"),
    ENTITY_BLAZE_AMBIENT("entity.blaze.ambient"),
    ENTITY_BLAZE_BURN("entity.blaze.burn"),
    ENTITY_BLAZE_DEATH("entity.blaze.death"),
    ENTITY_BLAZE_HURT("entity.blaze.hurt"),
    ENTITY_BLAZE_SHOOT("entity.blaze.shoot"),
    ENTITY_BOAT_PADDLE_LAND("entity.boat.paddle_land"),
    ENTITY_BOAT_PADDLE_WATER("entity.boat.paddle_water"),
    @DInfo(since = "1.21")
    ENTITY_BOGGED_AMBIENT("entity.bogged.ambient"),
    @DInfo(since = "1.21")
    ENTITY_BOGGED_DEATH("entity.bogged.death"),
    @DInfo(since = "1.21")
    ENTITY_BOGGED_HURT("entity.bogged.hurt"),
    @DInfo(since = "1.21")
    ENTITY_BOGGED_SHEAR("entity.bogged.shear"),
    @DInfo(since = "1.21")
    ENTITY_BOGGED_STEP("entity.bogged.step"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_CHARGE("entity.breeze.charge"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_DEATH("entity.breeze.death"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_DEFLECT("entity.breeze.deflect"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_HURT("entity.breeze.hurt"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_IDLE_AIR("entity.breeze.idle_air"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_IDLE_GROUND("entity.breeze.idle_ground"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_INHALE("entity.breeze.inhale"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_JUMP("entity.breeze.jump"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_LAND("entity.breeze.land"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_SHOOT("entity.breeze.shoot"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_SLIDE("entity.breeze.slide"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_WHIRL("entity.breeze.whirl"),
    @DInfo(since = "1.21")
    ENTITY_BREEZE_WIND_BURST("entity.breeze.wind_burst"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_AMBIENT("entity.camel.ambient"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_DASH("entity.camel.dash"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_DASH_READY("entity.camel.dash_ready"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_DEATH("entity.camel.death"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_EAT("entity.camel.eat"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_HURT("entity.camel.hurt"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_SADDLE("entity.camel.saddle"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_SIT("entity.camel.sit"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_STAND("entity.camel.stand"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_STEP("entity.camel.step"),
    @DInfo(since = "1.19.3")
    ENTITY_CAMEL_STEP_SAND("entity.camel.step_sand"),
    ENTITY_CAT_AMBIENT("entity.cat.ambient"),
    ENTITY_CAT_BEG_FOR_FOOD("entity.cat.beg_for_food"),
    ENTITY_CAT_DEATH("entity.cat.death"),
    ENTITY_CAT_EAT("entity.cat.eat"),
    ENTITY_CAT_HISS("entity.cat.hiss"),
    ENTITY_CAT_HURT("entity.cat.hurt"),
    ENTITY_CAT_PURR("entity.cat.purr"),
    ENTITY_CAT_PURREOW("entity.cat.purreow"),
    ENTITY_CAT_STRAY_AMBIENT("entity.cat.stray_ambient"),
    ENTITY_CHICKEN_AMBIENT("entity.chicken.ambient"),
    ENTITY_CHICKEN_DEATH("entity.chicken.death"),
    ENTITY_CHICKEN_EGG("entity.chicken.egg"),
    ENTITY_CHICKEN_HURT("entity.chicken.hurt"),
    ENTITY_CHICKEN_STEP("entity.chicken.step"),
    ENTITY_COD_AMBIENT("entity.cod.ambient"),
    ENTITY_COD_DEATH("entity.cod.death"),
    ENTITY_COD_FLOP("entity.cod.flop"),
    ENTITY_COD_HURT("entity.cod.hurt"),
    ENTITY_COW_AMBIENT("entity.cow.ambient"),
    ENTITY_COW_DEATH("entity.cow.death"),
    ENTITY_COW_HURT("entity.cow.hurt"),
    ENTITY_COW_MILK("entity.cow.milk"),
    ENTITY_COW_STEP("entity.cow.step"),
    @DInfo(since = "1.21.2")
    ENTITY_CREAKING_ACTIVATE("entity.creaking.activate"),
    @DInfo(since = "1.21.2")
    ENTITY_CREAKING_AMBIENT("entity.creaking.ambient"),
    @DInfo(since = "1.21.2")
    ENTITY_CREAKING_ATTACK("entity.creaking.attack"),
    @DInfo(since = "1.21.2")
    ENTITY_CREAKING_DEACTIVATE("entity.creaking.deactivate"),
    @DInfo(since = "1.21.2")
    ENTITY_CREAKING_DEATH("entity.creaking.death"),
    @DInfo(since = "1.21.2")
    ENTITY_CREAKING_FREEZE("entity.creaking.freeze"),
    @DInfo(since = "1.21.2")
    ENTITY_CREAKING_SPAWN("entity.creaking.spawn"),
    @DInfo(since = "1.21.2")
    ENTITY_CREAKING_STEP("entity.creaking.step"),
    @DInfo(since = "1.21.2")
    ENTITY_CREAKING_SWAY("entity.creaking.sway"),
    @DInfo(since = "1.21.4")
    ENTITY_CREAKING_TWITCH("entity.creaking.twitch"),
    @DInfo(since = "1.21.2")
    ENTITY_CREAKING_UNFREEZE("entity.creaking.unfreeze"),
    ENTITY_CREEPER_DEATH("entity.creeper.death"),
    ENTITY_CREEPER_HURT("entity.creeper.hurt"),
    ENTITY_CREEPER_PRIMED("entity.creeper.primed"),
    ENTITY_DOLPHIN_AMBIENT("entity.dolphin.ambient"),
    ENTITY_DOLPHIN_AMBIENT_WATER("entity.dolphin.ambient_water"),
    ENTITY_DOLPHIN_ATTACK("entity.dolphin.attack"),
    ENTITY_DOLPHIN_DEATH("entity.dolphin.death"),
    ENTITY_DOLPHIN_EAT("entity.dolphin.eat"),
    ENTITY_DOLPHIN_HURT("entity.dolphin.hurt"),
    ENTITY_DOLPHIN_JUMP("entity.dolphin.jump"),
    ENTITY_DOLPHIN_PLAY("entity.dolphin.play"),
    ENTITY_DOLPHIN_SPLASH("entity.dolphin.splash"),
    ENTITY_DOLPHIN_SWIM("entity.dolphin.swim"),
    ENTITY_DONKEY_AMBIENT("entity.donkey.ambient"),
    ENTITY_DONKEY_ANGRY("entity.donkey.angry"),
    ENTITY_DONKEY_CHEST("entity.donkey.chest"),
    ENTITY_DONKEY_DEATH("entity.donkey.death"),
    @DInfo(since = "1.16.1")
    ENTITY_DONKEY_EAT("entity.donkey.eat"),
    ENTITY_DONKEY_HURT("entity.donkey.hurt"),
    @DInfo(since = "1.20.5")
    ENTITY_DONKEY_JUMP("entity.donkey.jump"),
    ENTITY_DRAGON_FIREBALL_EXPLODE("entity.dragon_fireball.explode"),
    ENTITY_DROWNED_AMBIENT("entity.drowned.ambient"),
    ENTITY_DROWNED_AMBIENT_WATER("entity.drowned.ambient_water"),
    ENTITY_DROWNED_DEATH("entity.drowned.death"),
    ENTITY_DROWNED_DEATH_WATER("entity.drowned.death_water"),
    ENTITY_DROWNED_HURT("entity.drowned.hurt"),
    ENTITY_DROWNED_HURT_WATER("entity.drowned.hurt_water"),
    ENTITY_DROWNED_SHOOT("entity.drowned.shoot"),
    ENTITY_DROWNED_STEP("entity.drowned.step"),
    ENTITY_DROWNED_SWIM("entity.drowned.swim"),
    ENTITY_EGG_THROW("entity.egg.throw"),
    ENTITY_ELDER_GUARDIAN_AMBIENT("entity.elder_guardian.ambient"),
    ENTITY_ELDER_GUARDIAN_AMBIENT_LAND("entity.elder_guardian.ambient_land"),
    ENTITY_ELDER_GUARDIAN_CURSE("entity.elder_guardian.curse"),
    ENTITY_ELDER_GUARDIAN_DEATH("entity.elder_guardian.death"),
    ENTITY_ELDER_GUARDIAN_DEATH_LAND("entity.elder_guardian.death_land"),
    ENTITY_ELDER_GUARDIAN_FLOP("entity.elder_guardian.flop"),
    ENTITY_ELDER_GUARDIAN_HURT("entity.elder_guardian.hurt"),
    ENTITY_ELDER_GUARDIAN_HURT_LAND("entity.elder_guardian.hurt_land"),
    ENTITY_ENDERMAN_AMBIENT("entity.enderman.ambient"),
    ENTITY_ENDERMAN_DEATH("entity.enderman.death"),
    ENTITY_ENDERMAN_HURT("entity.enderman.hurt"),
    ENTITY_ENDERMAN_SCREAM("entity.enderman.scream"),
    ENTITY_ENDERMAN_STARE("entity.enderman.stare"),
    ENTITY_ENDERMAN_TELEPORT("entity.enderman.teleport"),
    ENTITY_ENDERMITE_AMBIENT("entity.endermite.ambient"),
    ENTITY_ENDERMITE_DEATH("entity.endermite.death"),
    ENTITY_ENDERMITE_HURT("entity.endermite.hurt"),
    ENTITY_ENDERMITE_STEP("entity.endermite.step"),
    ENTITY_ENDER_DRAGON_AMBIENT("entity.ender_dragon.ambient"),
    ENTITY_ENDER_DRAGON_DEATH("entity.ender_dragon.death"),
    ENTITY_ENDER_DRAGON_FLAP("entity.ender_dragon.flap"),
    ENTITY_ENDER_DRAGON_GROWL("entity.ender_dragon.growl"),
    ENTITY_ENDER_DRAGON_HURT("entity.ender_dragon.hurt"),
    ENTITY_ENDER_DRAGON_SHOOT("entity.ender_dragon.shoot"),
    ENTITY_ENDER_EYE_DEATH("entity.ender_eye.death"),
    ENTITY_ENDER_EYE_LAUNCH("entity.ender_eye.launch"),
    ENTITY_ENDER_PEARL_THROW("entity.ender_pearl.throw"),
    ENTITY_EVOKER_AMBIENT("entity.evoker.ambient"),
    ENTITY_EVOKER_CAST_SPELL("entity.evoker.cast_spell"),
    ENTITY_EVOKER_CELEBRATE("entity.evoker.celebrate"),
    ENTITY_EVOKER_DEATH("entity.evoker.death"),
    ENTITY_EVOKER_FANGS_ATTACK("entity.evoker_fangs.attack"),
    ENTITY_EVOKER_HURT("entity.evoker.hurt"),
    ENTITY_EVOKER_PREPARE_ATTACK("entity.evoker.prepare_attack"),
    ENTITY_EVOKER_PREPARE_SUMMON("entity.evoker.prepare_summon"),
    ENTITY_EVOKER_PREPARE_WOLOLO("entity.evoker.prepare_wololo"),
    ENTITY_EXPERIENCE_BOTTLE_THROW("entity.experience_bottle.throw"),
    ENTITY_EXPERIENCE_ORB_PICKUP("entity.experience_orb.pickup"),
    ENTITY_FIREWORK_ROCKET_BLAST("entity.firework_rocket.blast"),
    ENTITY_FIREWORK_ROCKET_BLAST_FAR("entity.firework_rocket.blast_far"),
    ENTITY_FIREWORK_ROCKET_LARGE_BLAST("entity.firework_rocket.large_blast"),
    ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR("entity.firework_rocket.large_blast_far"),
    ENTITY_FIREWORK_ROCKET_LAUNCH("entity.firework_rocket.launch"),
    ENTITY_FIREWORK_ROCKET_SHOOT("entity.firework_rocket.shoot"),
    ENTITY_FIREWORK_ROCKET_TWINKLE("entity.firework_rocket.twinkle"),
    ENTITY_FIREWORK_ROCKET_TWINKLE_FAR("entity.firework_rocket.twinkle_far"),
    ENTITY_FISHING_BOBBER_RETRIEVE("entity.fishing_bobber.retrieve"),
    ENTITY_FISHING_BOBBER_SPLASH("entity.fishing_bobber.splash"),
    ENTITY_FISHING_BOBBER_THROW("entity.fishing_bobber.throw"),
    ENTITY_FISH_SWIM("entity.fish.swim"),
    ENTITY_FOX_AGGRO("entity.fox.aggro"),
    ENTITY_FOX_AMBIENT("entity.fox.ambient"),
    ENTITY_FOX_BITE("entity.fox.bite"),
    ENTITY_FOX_DEATH("entity.fox.death"),
    ENTITY_FOX_EAT("entity.fox.eat"),
    ENTITY_FOX_HURT("entity.fox.hurt"),
    ENTITY_FOX_SCREECH("entity.fox.screech"),
    ENTITY_FOX_SLEEP("entity.fox.sleep"),
    ENTITY_FOX_SNIFF("entity.fox.sniff"),
    ENTITY_FOX_SPIT("entity.fox.spit"),
    @DInfo(since = "1.16.1")
    ENTITY_FOX_TELEPORT("entity.fox.teleport"),
    @DInfo(since = "1.19")
    ENTITY_FROG_AMBIENT("entity.frog.ambient"),
    @DInfo(since = "1.19")
    ENTITY_FROG_DEATH("entity.frog.death"),
    @DInfo(since = "1.19")
    ENTITY_FROG_EAT("entity.frog.eat"),
    @DInfo(since = "1.19")
    ENTITY_FROG_HURT("entity.frog.hurt"),
    @DInfo(since = "1.19")
    ENTITY_FROG_LAY_SPAWN("entity.frog.lay_spawn"),
    @DInfo(since = "1.19")
    ENTITY_FROG_LONG_JUMP("entity.frog.long_jump"),
    @DInfo(since = "1.19")
    ENTITY_FROG_STEP("entity.frog.step"),
    @DInfo(since = "1.19")
    ENTITY_FROG_TONGUE("entity.frog.tongue"),
    ENTITY_GENERIC_BIG_FALL("entity.generic.big_fall"),
    ENTITY_GENERIC_BURN("entity.generic.burn"),
    ENTITY_GENERIC_DEATH("entity.generic.death"),
    ENTITY_GENERIC_DRINK("entity.generic.drink"),
    ENTITY_GENERIC_EAT("entity.generic.eat"),
    ENTITY_GENERIC_EXPLODE("entity.generic.explode"),
    ENTITY_GENERIC_EXTINGUISH_FIRE("entity.generic.extinguish_fire"),
    ENTITY_GENERIC_HURT("entity.generic.hurt"),
    ENTITY_GENERIC_SMALL_FALL("entity.generic.small_fall"),
    ENTITY_GENERIC_SPLASH("entity.generic.splash"),
    ENTITY_GENERIC_SWIM("entity.generic.swim"),
    @DInfo(since = "1.21.6")
    ENTITY_GHASTLING_AMBIENT("entity.ghastling.ambient"),
    @DInfo(since = "1.21.6")
    ENTITY_GHASTLING_DEATH("entity.ghastling.death"),
    @DInfo(since = "1.21.6")
    ENTITY_GHASTLING_HURT("entity.ghastling.hurt"),
    @DInfo(since = "1.21.6")
    ENTITY_GHASTLING_SPAWN("entity.ghastling.spawn"),
    ENTITY_GHAST_AMBIENT("entity.ghast.ambient"),
    ENTITY_GHAST_DEATH("entity.ghast.death"),
    ENTITY_GHAST_HURT("entity.ghast.hurt"),
    ENTITY_GHAST_SCREAM("entity.ghast.scream"),
    ENTITY_GHAST_SHOOT("entity.ghast.shoot"),
    ENTITY_GHAST_WARN("entity.ghast.warn"),
    @DInfo(since = "1.17")
    ENTITY_GLOW_ITEM_FRAME_ADD_ITEM("entity.glow_item_frame.add_item"),
    @DInfo(since = "1.17")
    ENTITY_GLOW_ITEM_FRAME_BREAK("entity.glow_item_frame.break"),
    @DInfo(since = "1.17")
    ENTITY_GLOW_ITEM_FRAME_PLACE("entity.glow_item_frame.place"),
    @DInfo(since = "1.17")
    ENTITY_GLOW_ITEM_FRAME_REMOVE_ITEM("entity.glow_item_frame.remove_item"),
    @DInfo(since = "1.17")
    ENTITY_GLOW_ITEM_FRAME_ROTATE_ITEM("entity.glow_item_frame.rotate_item"),
    @DInfo(since = "1.17")
    ENTITY_GLOW_SQUID_AMBIENT("entity.glow_squid.ambient"),
    @DInfo(since = "1.17")
    ENTITY_GLOW_SQUID_DEATH("entity.glow_squid.death"),
    @DInfo(since = "1.17")
    ENTITY_GLOW_SQUID_HURT("entity.glow_squid.hurt"),
    @DInfo(since = "1.17")
    ENTITY_GLOW_SQUID_SQUIRT("entity.glow_squid.squirt"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_AMBIENT("entity.goat.ambient"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_DEATH("entity.goat.death"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_EAT("entity.goat.eat"),
    @DInfo(since = "1.19")
    ENTITY_GOAT_HORN_BREAK("entity.goat.horn_break"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_HURT("entity.goat.hurt"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_LONG_JUMP("entity.goat.long_jump"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_MILK("entity.goat.milk"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_PREPARE_RAM("entity.goat.prepare_ram"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_RAM_IMPACT("entity.goat.ram_impact"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_SCREAMING_AMBIENT("entity.goat.screaming.ambient"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_SCREAMING_DEATH("entity.goat.screaming.death"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_SCREAMING_EAT("entity.goat.screaming.eat"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_SCREAMING_HURT("entity.goat.screaming.hurt"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_SCREAMING_LONG_JUMP("entity.goat.screaming.long_jump"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_SCREAMING_MILK("entity.goat.screaming.milk"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_SCREAMING_PREPARE_RAM("entity.goat.screaming.prepare_ram"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_SCREAMING_RAM_IMPACT("entity.goat.screaming.ram_impact"),
    @DInfo(since = "1.17")
    ENTITY_GOAT_STEP("entity.goat.step"),
    ENTITY_GUARDIAN_AMBIENT("entity.guardian.ambient"),
    ENTITY_GUARDIAN_AMBIENT_LAND("entity.guardian.ambient_land"),
    ENTITY_GUARDIAN_ATTACK("entity.guardian.attack"),
    ENTITY_GUARDIAN_DEATH("entity.guardian.death"),
    ENTITY_GUARDIAN_DEATH_LAND("entity.guardian.death_land"),
    ENTITY_GUARDIAN_FLOP("entity.guardian.flop"),
    ENTITY_GUARDIAN_HURT("entity.guardian.hurt"),
    ENTITY_GUARDIAN_HURT_LAND("entity.guardian.hurt_land"),
    @DInfo(since = "1.21.6")
    ENTITY_HAPPY_GHAST_AMBIENT("entity.happy_ghast.ambient"),
    @DInfo(since = "1.21.6")
    ENTITY_HAPPY_GHAST_DEATH("entity.happy_ghast.death"),
    @DInfo(since = "1.21.6")
    ENTITY_HAPPY_GHAST_EQUIP("entity.happy_ghast.equip"),
    @DInfo(since = "1.21.6")
    ENTITY_HAPPY_GHAST_HARNESS_GOGGLES_DOWN("entity.happy_ghast.harness_goggles_down"),
    @DInfo(since = "1.21.6")
    ENTITY_HAPPY_GHAST_HARNESS_GOGGLES_UP("entity.happy_ghast.harness_goggles_up"),
    @DInfo(since = "1.21.6")
    ENTITY_HAPPY_GHAST_HURT("entity.happy_ghast.hurt"),
    @DInfo(since = "1.21.6")
    ENTITY_HAPPY_GHAST_RIDING("entity.happy_ghast.riding"),
    @DInfo(since = "1.21.6")
    ENTITY_HAPPY_GHAST_UNEQUIP("entity.happy_ghast.unequip"),
    @DInfo(since = "1.16.1")
    ENTITY_HOGLIN_AMBIENT("entity.hoglin.ambient"),
    @DInfo(since = "1.16.1")
    ENTITY_HOGLIN_ANGRY("entity.hoglin.angry"),
    @DInfo(since = "1.16.1")
    ENTITY_HOGLIN_ATTACK("entity.hoglin.attack"),
    @DInfo(since = "1.16.1")
    ENTITY_HOGLIN_CONVERTED_TO_ZOMBIFIED("entity.hoglin.converted_to_zombified"),
    @DInfo(since = "1.16.1")
    ENTITY_HOGLIN_DEATH("entity.hoglin.death"),
    @DInfo(since = "1.16.1")
    ENTITY_HOGLIN_HURT("entity.hoglin.hurt"),
    @DInfo(since = "1.16.1")
    ENTITY_HOGLIN_RETREAT("entity.hoglin.retreat"),
    @DInfo(since = "1.16.1")
    ENTITY_HOGLIN_STEP("entity.hoglin.step"),
    ENTITY_HORSE_AMBIENT("entity.horse.ambient"),
    ENTITY_HORSE_ANGRY("entity.horse.angry"),
    ENTITY_HORSE_ARMOR("entity.horse.armor"),
    ENTITY_HORSE_BREATHE("entity.horse.breathe"),
    ENTITY_HORSE_DEATH("entity.horse.death"),
    ENTITY_HORSE_EAT("entity.horse.eat"),
    ENTITY_HORSE_GALLOP("entity.horse.gallop"),
    ENTITY_HORSE_HURT("entity.horse.hurt"),
    ENTITY_HORSE_JUMP("entity.horse.jump"),
    ENTITY_HORSE_LAND("entity.horse.land"),
    ENTITY_HORSE_SADDLE("entity.horse.saddle"),
    ENTITY_HORSE_STEP("entity.horse.step"),
    ENTITY_HORSE_STEP_WOOD("entity.horse.step_wood"),
    ENTITY_HOSTILE_BIG_FALL("entity.hostile.big_fall"),
    ENTITY_HOSTILE_DEATH("entity.hostile.death"),
    ENTITY_HOSTILE_HURT("entity.hostile.hurt"),
    ENTITY_HOSTILE_SMALL_FALL("entity.hostile.small_fall"),
    ENTITY_HOSTILE_SPLASH("entity.hostile.splash"),
    ENTITY_HOSTILE_SWIM("entity.hostile.swim"),
    ENTITY_HUSK_AMBIENT("entity.husk.ambient"),
    ENTITY_HUSK_CONVERTED_TO_ZOMBIE("entity.husk.converted_to_zombie"),
    ENTITY_HUSK_DEATH("entity.husk.death"),
    ENTITY_HUSK_HURT("entity.husk.hurt"),
    ENTITY_HUSK_STEP("entity.husk.step"),
    ENTITY_ILLUSIONER_AMBIENT("entity.illusioner.ambient"),
    ENTITY_ILLUSIONER_CAST_SPELL("entity.illusioner.cast_spell"),
    ENTITY_ILLUSIONER_DEATH("entity.illusioner.death"),
    ENTITY_ILLUSIONER_HURT("entity.illusioner.hurt"),
    ENTITY_ILLUSIONER_MIRROR_MOVE("entity.illusioner.mirror_move"),
    ENTITY_ILLUSIONER_PREPARE_BLINDNESS("entity.illusioner.prepare_blindness"),
    ENTITY_ILLUSIONER_PREPARE_MIRROR("entity.illusioner.prepare_mirror"),
    ENTITY_IRON_GOLEM_ATTACK("entity.iron_golem.attack"),
    ENTITY_IRON_GOLEM_DAMAGE("entity.iron_golem.damage"),
    ENTITY_IRON_GOLEM_DEATH("entity.iron_golem.death"),
    ENTITY_IRON_GOLEM_HURT("entity.iron_golem.hurt"),
    ENTITY_IRON_GOLEM_REPAIR("entity.iron_golem.repair"),
    ENTITY_IRON_GOLEM_STEP("entity.iron_golem.step"),
    ENTITY_ITEM_BREAK("entity.item.break"),
    ENTITY_ITEM_FRAME_ADD_ITEM("entity.item_frame.add_item"),
    ENTITY_ITEM_FRAME_BREAK("entity.item_frame.break"),
    ENTITY_ITEM_FRAME_PLACE("entity.item_frame.place"),
    ENTITY_ITEM_FRAME_REMOVE_ITEM("entity.item_frame.remove_item"),
    ENTITY_ITEM_FRAME_ROTATE_ITEM("entity.item_frame.rotate_item"),
    ENTITY_ITEM_PICKUP("entity.item.pickup"),
    ENTITY_LIGHTNING_BOLT_IMPACT("entity.lightning_bolt.impact"),
    ENTITY_LIGHTNING_BOLT_THUNDER("entity.lightning_bolt.thunder"),
    ENTITY_LINGERING_POTION_THROW("entity.lingering_potion.throw"),
    ENTITY_LLAMA_AMBIENT("entity.llama.ambient"),
    ENTITY_LLAMA_ANGRY("entity.llama.angry"),
    ENTITY_LLAMA_CHEST("entity.llama.chest"),
    ENTITY_LLAMA_DEATH("entity.llama.death"),
    ENTITY_LLAMA_EAT("entity.llama.eat"),
    ENTITY_LLAMA_HURT("entity.llama.hurt"),
    ENTITY_LLAMA_SPIT("entity.llama.spit"),
    ENTITY_LLAMA_STEP("entity.llama.step"),
    ENTITY_LLAMA_SWAG("entity.llama.swag"),
    ENTITY_MAGMA_CUBE_DEATH("entity.magma_cube.death"),
    ENTITY_MAGMA_CUBE_DEATH_SMALL("entity.magma_cube.death_small"),
    ENTITY_MAGMA_CUBE_HURT("entity.magma_cube.hurt"),
    ENTITY_MAGMA_CUBE_HURT_SMALL("entity.magma_cube.hurt_small"),
    ENTITY_MAGMA_CUBE_JUMP("entity.magma_cube.jump"),
    ENTITY_MAGMA_CUBE_SQUISH("entity.magma_cube.squish"),
    ENTITY_MAGMA_CUBE_SQUISH_SMALL("entity.magma_cube.squish_small"),
    ENTITY_MINECART_INSIDE("entity.minecart.inside"),
    @DInfo(since = "1.17")
    ENTITY_MINECART_INSIDE_UNDERWATER("entity.minecart.inside.underwater"),
    ENTITY_MINECART_RIDING("entity.minecart.riding"),
    ENTITY_MOOSHROOM_CONVERT("entity.mooshroom.convert"),
    ENTITY_MOOSHROOM_EAT("entity.mooshroom.eat"),
    ENTITY_MOOSHROOM_MILK("entity.mooshroom.milk"),
    ENTITY_MOOSHROOM_SHEAR("entity.mooshroom.shear"),
    ENTITY_MOOSHROOM_SUSPICIOUS_MILK("entity.mooshroom.suspicious_milk"),
    ENTITY_MULE_AMBIENT("entity.mule.ambient"),
    @DInfo(since = "1.16.1")
    ENTITY_MULE_ANGRY("entity.mule.angry"),
    ENTITY_MULE_CHEST("entity.mule.chest"),
    ENTITY_MULE_DEATH("entity.mule.death"),
    @DInfo(since = "1.16.1")
    ENTITY_MULE_EAT("entity.mule.eat"),
    ENTITY_MULE_HURT("entity.mule.hurt"),
    @DInfo(since = "1.20.5")
    ENTITY_MULE_JUMP("entity.mule.jump"),
    ENTITY_OCELOT_AMBIENT("entity.ocelot.ambient"),
    ENTITY_OCELOT_DEATH("entity.ocelot.death"),
    ENTITY_OCELOT_HURT("entity.ocelot.hurt"),
    ENTITY_PAINTING_BREAK("entity.painting.break"),
    ENTITY_PAINTING_PLACE("entity.painting.place"),
    ENTITY_PANDA_AGGRESSIVE_AMBIENT("entity.panda.aggressive_ambient"),
    ENTITY_PANDA_AMBIENT("entity.panda.ambient"),
    ENTITY_PANDA_BITE("entity.panda.bite"),
    ENTITY_PANDA_CANT_BREED("entity.panda.cant_breed"),
    ENTITY_PANDA_DEATH("entity.panda.death"),
    ENTITY_PANDA_EAT("entity.panda.eat"),
    ENTITY_PANDA_HURT("entity.panda.hurt"),
    ENTITY_PANDA_PRE_SNEEZE("entity.panda.pre_sneeze"),
    ENTITY_PANDA_SNEEZE("entity.panda.sneeze"),
    ENTITY_PANDA_STEP("entity.panda.step"),
    ENTITY_PANDA_WORRIED_AMBIENT("entity.panda.worried_ambient"),
    ENTITY_PARROT_AMBIENT("entity.parrot.ambient"),
    ENTITY_PARROT_DEATH("entity.parrot.death"),
    ENTITY_PARROT_EAT("entity.parrot.eat"),
    ENTITY_PARROT_FLY("entity.parrot.fly"),
    ENTITY_PARROT_HURT("entity.parrot.hurt"),
    ENTITY_PARROT_IMITATE_BLAZE("entity.parrot.imitate.blaze"),
    @DInfo(since = "1.21")
    ENTITY_PARROT_IMITATE_BOGGED("entity.parrot.imitate.bogged"),
    @DInfo(since = "1.21")
    ENTITY_PARROT_IMITATE_BREEZE("entity.parrot.imitate.breeze"),
    @DInfo(since = "1.21.2")
    ENTITY_PARROT_IMITATE_CREAKING("entity.parrot.imitate.creaking"),
    ENTITY_PARROT_IMITATE_CREEPER("entity.parrot.imitate.creeper"),
    ENTITY_PARROT_IMITATE_DROWNED("entity.parrot.imitate.drowned"),
    ENTITY_PARROT_IMITATE_ELDER_GUARDIAN("entity.parrot.imitate.elder_guardian"),
    ENTITY_PARROT_IMITATE_ENDERMITE("entity.parrot.imitate.endermite"),
    ENTITY_PARROT_IMITATE_ENDER_DRAGON("entity.parrot.imitate.ender_dragon"),
    ENTITY_PARROT_IMITATE_EVOKER("entity.parrot.imitate.evoker"),
    ENTITY_PARROT_IMITATE_GHAST("entity.parrot.imitate.ghast"),
    ENTITY_PARROT_IMITATE_GUARDIAN("entity.parrot.imitate.guardian"),
    @DInfo(since = "1.16.1")
    ENTITY_PARROT_IMITATE_HOGLIN("entity.parrot.imitate.hoglin"),
    ENTITY_PARROT_IMITATE_HUSK("entity.parrot.imitate.husk"),
    ENTITY_PARROT_IMITATE_ILLUSIONER("entity.parrot.imitate.illusioner"),
    ENTITY_PARROT_IMITATE_MAGMA_CUBE("entity.parrot.imitate.magma_cube"),
    ENTITY_PARROT_IMITATE_PHANTOM("entity.parrot.imitate.phantom"),
    @DInfo(since = "1.16.1")
    ENTITY_PARROT_IMITATE_PIGLIN("entity.parrot.imitate.piglin"),
    @DInfo(since = "1.16.2")
    ENTITY_PARROT_IMITATE_PIGLIN_BRUTE("entity.parrot.imitate.piglin_brute"),
    ENTITY_PARROT_IMITATE_PILLAGER("entity.parrot.imitate.pillager"),
    ENTITY_PARROT_IMITATE_RAVAGER("entity.parrot.imitate.ravager"),
    ENTITY_PARROT_IMITATE_SHULKER("entity.parrot.imitate.shulker"),
    ENTITY_PARROT_IMITATE_SILVERFISH("entity.parrot.imitate.silverfish"),
    ENTITY_PARROT_IMITATE_SKELETON("entity.parrot.imitate.skeleton"),
    ENTITY_PARROT_IMITATE_SLIME("entity.parrot.imitate.slime"),
    ENTITY_PARROT_IMITATE_SPIDER("entity.parrot.imitate.spider"),
    ENTITY_PARROT_IMITATE_STRAY("entity.parrot.imitate.stray"),
    ENTITY_PARROT_IMITATE_VEX("entity.parrot.imitate.vex"),
    ENTITY_PARROT_IMITATE_VINDICATOR("entity.parrot.imitate.vindicator"),
    @DInfo(since = "1.19")
    ENTITY_PARROT_IMITATE_WARDEN("entity.parrot.imitate.warden"),
    ENTITY_PARROT_IMITATE_WITCH("entity.parrot.imitate.witch"),
    ENTITY_PARROT_IMITATE_WITHER("entity.parrot.imitate.wither"),
    ENTITY_PARROT_IMITATE_WITHER_SKELETON("entity.parrot.imitate.wither_skeleton"),
    @DInfo(since = "1.16.1")
    ENTITY_PARROT_IMITATE_ZOGLIN("entity.parrot.imitate.zoglin"),
    ENTITY_PARROT_IMITATE_ZOMBIE("entity.parrot.imitate.zombie"),
    ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER("entity.parrot.imitate.zombie_villager"),
    ENTITY_PARROT_STEP("entity.parrot.step"),
    ENTITY_PHANTOM_AMBIENT("entity.phantom.ambient"),
    ENTITY_PHANTOM_BITE("entity.phantom.bite"),
    ENTITY_PHANTOM_DEATH("entity.phantom.death"),
    ENTITY_PHANTOM_FLAP("entity.phantom.flap"),
    ENTITY_PHANTOM_HURT("entity.phantom.hurt"),
    ENTITY_PHANTOM_SWOOP("entity.phantom.swoop"),
    @DInfo(since = "1.16.1")
    ENTITY_PIGLIN_ADMIRING_ITEM("entity.piglin.admiring_item"),
    @DInfo(since = "1.16.1")
    ENTITY_PIGLIN_AMBIENT("entity.piglin.ambient"),
    @DInfo(since = "1.16.1")
    ENTITY_PIGLIN_ANGRY("entity.piglin.angry"),
    @DInfo(since = "1.16.2")
    ENTITY_PIGLIN_BRUTE_AMBIENT("entity.piglin_brute.ambient"),
    @DInfo(since = "1.16.2")
    ENTITY_PIGLIN_BRUTE_ANGRY("entity.piglin_brute.angry"),
    @DInfo(since = "1.16.2")
    ENTITY_PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED("entity.piglin_brute.converted_to_zombified"),
    @DInfo(since = "1.16.2")
    ENTITY_PIGLIN_BRUTE_DEATH("entity.piglin_brute.death"),
    @DInfo(since = "1.16.2")
    ENTITY_PIGLIN_BRUTE_HURT("entity.piglin_brute.hurt"),
    @DInfo(since = "1.16.2")
    ENTITY_PIGLIN_BRUTE_STEP("entity.piglin_brute.step"),
    @DInfo(since = "1.16.1")
    ENTITY_PIGLIN_CELEBRATE("entity.piglin.celebrate"),
    @DInfo(since = "1.16.1")
    ENTITY_PIGLIN_CONVERTED_TO_ZOMBIFIED("entity.piglin.converted_to_zombified"),
    @DInfo(since = "1.16.1")
    ENTITY_PIGLIN_DEATH("entity.piglin.death"),
    @DInfo(since = "1.16.1")
    ENTITY_PIGLIN_HURT("entity.piglin.hurt"),
    @DInfo(since = "1.16.1")
    ENTITY_PIGLIN_JEALOUS("entity.piglin.jealous"),
    @DInfo(since = "1.16.1")
    ENTITY_PIGLIN_RETREAT("entity.piglin.retreat"),
    @DInfo(since = "1.16.1")
    ENTITY_PIGLIN_STEP("entity.piglin.step"),
    ENTITY_PIG_AMBIENT("entity.pig.ambient"),
    ENTITY_PIG_DEATH("entity.pig.death"),
    ENTITY_PIG_HURT("entity.pig.hurt"),
    ENTITY_PIG_SADDLE("entity.pig.saddle"),
    ENTITY_PIG_STEP("entity.pig.step"),
    ENTITY_PILLAGER_AMBIENT("entity.pillager.ambient"),
    ENTITY_PILLAGER_CELEBRATE("entity.pillager.celebrate"),
    ENTITY_PILLAGER_DEATH("entity.pillager.death"),
    ENTITY_PILLAGER_HURT("entity.pillager.hurt"),
    ENTITY_PLAYER_ATTACK_CRIT("entity.player.attack.crit"),
    ENTITY_PLAYER_ATTACK_KNOCKBACK("entity.player.attack.knockback"),
    ENTITY_PLAYER_ATTACK_NODAMAGE("entity.player.attack.nodamage"),
    ENTITY_PLAYER_ATTACK_STRONG("entity.player.attack.strong"),
    ENTITY_PLAYER_ATTACK_SWEEP("entity.player.attack.sweep"),
    ENTITY_PLAYER_ATTACK_WEAK("entity.player.attack.weak"),
    ENTITY_PLAYER_BIG_FALL("entity.player.big_fall"),
    ENTITY_PLAYER_BREATH("entity.player.breath"),
    ENTITY_PLAYER_BURP("entity.player.burp"),
    ENTITY_PLAYER_DEATH("entity.player.death"),
    ENTITY_PLAYER_HURT("entity.player.hurt"),
    ENTITY_PLAYER_HURT_DROWN("entity.player.hurt_drown"),
    @DInfo(since = "1.17")
    ENTITY_PLAYER_HURT_FREEZE("entity.player.hurt_freeze"),
    ENTITY_PLAYER_HURT_ON_FIRE("entity.player.hurt_on_fire"),
    ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH("entity.player.hurt_sweet_berry_bush"),
    ENTITY_PLAYER_LEVELUP("entity.player.levelup"),
    ENTITY_PLAYER_SMALL_FALL("entity.player.small_fall"),
    ENTITY_PLAYER_SPLASH("entity.player.splash"),
    ENTITY_PLAYER_SPLASH_HIGH_SPEED("entity.player.splash.high_speed"),
    ENTITY_PLAYER_SWIM("entity.player.swim"),
    @DInfo(since = "1.20.3")
    ENTITY_PLAYER_TELEPORT("entity.player.teleport"),
    ENTITY_POLAR_BEAR_AMBIENT("entity.polar_bear.ambient"),
    ENTITY_POLAR_BEAR_AMBIENT_BABY("entity.polar_bear.ambient_baby"),
    ENTITY_POLAR_BEAR_DEATH("entity.polar_bear.death"),
    ENTITY_POLAR_BEAR_HURT("entity.polar_bear.hurt"),
    ENTITY_POLAR_BEAR_STEP("entity.polar_bear.step"),
    ENTITY_POLAR_BEAR_WARNING("entity.polar_bear.warning"),
    ENTITY_PUFFER_FISH_BLOW_OUT("entity.puffer_fish.blow_out"),
    ENTITY_PUFFER_FISH_BLOW_UP("entity.puffer_fish.blow_up"),
    ENTITY_PUFFER_FISH_DEATH("entity.puffer_fish.death"),
    ENTITY_PUFFER_FISH_FLOP("entity.puffer_fish.flop"),
    ENTITY_PUFFER_FISH_HURT("entity.puffer_fish.hurt"),
    ENTITY_PUFFER_FISH_STING("entity.puffer_fish.sting"),
    ENTITY_RABBIT_AMBIENT("entity.rabbit.ambient"),
    ENTITY_RABBIT_ATTACK("entity.rabbit.attack"),
    ENTITY_RABBIT_DEATH("entity.rabbit.death"),
    ENTITY_RABBIT_HURT("entity.rabbit.hurt"),
    ENTITY_RABBIT_JUMP("entity.rabbit.jump"),
    ENTITY_RAVAGER_AMBIENT("entity.ravager.ambient"),
    ENTITY_RAVAGER_ATTACK("entity.ravager.attack"),
    ENTITY_RAVAGER_CELEBRATE("entity.ravager.celebrate"),
    ENTITY_RAVAGER_DEATH("entity.ravager.death"),
    ENTITY_RAVAGER_HURT("entity.ravager.hurt"),
    ENTITY_RAVAGER_ROAR("entity.ravager.roar"),
    ENTITY_RAVAGER_STEP("entity.ravager.step"),
    ENTITY_RAVAGER_STUNNED("entity.ravager.stunned"),
    ENTITY_SALMON_AMBIENT("entity.salmon.ambient"),
    ENTITY_SALMON_DEATH("entity.salmon.death"),
    ENTITY_SALMON_FLOP("entity.salmon.flop"),
    ENTITY_SALMON_HURT("entity.salmon.hurt"),
    ENTITY_SHEEP_AMBIENT("entity.sheep.ambient"),
    ENTITY_SHEEP_DEATH("entity.sheep.death"),
    ENTITY_SHEEP_HURT("entity.sheep.hurt"),
    ENTITY_SHEEP_SHEAR("entity.sheep.shear"),
    ENTITY_SHEEP_STEP("entity.sheep.step"),
    ENTITY_SHULKER_AMBIENT("entity.shulker.ambient"),
    ENTITY_SHULKER_BULLET_HIT("entity.shulker_bullet.hit"),
    ENTITY_SHULKER_BULLET_HURT("entity.shulker_bullet.hurt"),
    ENTITY_SHULKER_CLOSE("entity.shulker.close"),
    ENTITY_SHULKER_DEATH("entity.shulker.death"),
    ENTITY_SHULKER_HURT("entity.shulker.hurt"),
    ENTITY_SHULKER_HURT_CLOSED("entity.shulker.hurt_closed"),
    ENTITY_SHULKER_OPEN("entity.shulker.open"),
    ENTITY_SHULKER_SHOOT("entity.shulker.shoot"),
    ENTITY_SHULKER_TELEPORT("entity.shulker.teleport"),
    ENTITY_SILVERFISH_AMBIENT("entity.silverfish.ambient"),
    ENTITY_SILVERFISH_DEATH("entity.silverfish.death"),
    ENTITY_SILVERFISH_HURT("entity.silverfish.hurt"),
    ENTITY_SILVERFISH_STEP("entity.silverfish.step"),
    ENTITY_SKELETON_AMBIENT("entity.skeleton.ambient"),
    @DInfo(since = "1.17")
    ENTITY_SKELETON_CONVERTED_TO_STRAY("entity.skeleton.converted_to_stray"),
    ENTITY_SKELETON_DEATH("entity.skeleton.death"),
    ENTITY_SKELETON_HORSE_AMBIENT("entity.skeleton_horse.ambient"),
    ENTITY_SKELETON_HORSE_AMBIENT_WATER("entity.skeleton_horse.ambient_water"),
    ENTITY_SKELETON_HORSE_DEATH("entity.skeleton_horse.death"),
    ENTITY_SKELETON_HORSE_GALLOP_WATER("entity.skeleton_horse.gallop_water"),
    ENTITY_SKELETON_HORSE_HURT("entity.skeleton_horse.hurt"),
    ENTITY_SKELETON_HORSE_JUMP_WATER("entity.skeleton_horse.jump_water"),
    ENTITY_SKELETON_HORSE_STEP_WATER("entity.skeleton_horse.step_water"),
    ENTITY_SKELETON_HORSE_SWIM("entity.skeleton_horse.swim"),
    ENTITY_SKELETON_HURT("entity.skeleton.hurt"),
    ENTITY_SKELETON_SHOOT("entity.skeleton.shoot"),
    ENTITY_SKELETON_STEP("entity.skeleton.step"),
    ENTITY_SLIME_ATTACK("entity.slime.attack"),
    ENTITY_SLIME_DEATH("entity.slime.death"),
    ENTITY_SLIME_DEATH_SMALL("entity.slime.death_small"),
    ENTITY_SLIME_HURT("entity.slime.hurt"),
    ENTITY_SLIME_HURT_SMALL("entity.slime.hurt_small"),
    ENTITY_SLIME_JUMP("entity.slime.jump"),
    ENTITY_SLIME_JUMP_SMALL("entity.slime.jump_small"),
    ENTITY_SLIME_SQUISH("entity.slime.squish"),
    ENTITY_SLIME_SQUISH_SMALL("entity.slime.squish_small"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_DEATH("entity.sniffer.death"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_DIGGING("entity.sniffer.digging"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_DIGGING_STOP("entity.sniffer.digging_stop"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_DROP_SEED("entity.sniffer.drop_seed"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_EAT("entity.sniffer.eat"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_HAPPY("entity.sniffer.happy"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_HURT("entity.sniffer.hurt"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_IDLE("entity.sniffer.idle"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_SCENTING("entity.sniffer.scenting"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_SEARCHING("entity.sniffer.searching"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_SNIFFING("entity.sniffer.sniffing"),
    @DInfo(since = "1.19.4")
    ENTITY_SNIFFER_STEP("entity.sniffer.step"),
    ENTITY_SNOWBALL_THROW("entity.snowball.throw"),
    ENTITY_SNOW_GOLEM_AMBIENT("entity.snow_golem.ambient"),
    ENTITY_SNOW_GOLEM_DEATH("entity.snow_golem.death"),
    ENTITY_SNOW_GOLEM_HURT("entity.snow_golem.hurt"),
    @DInfo(since = "1.16.1")
    ENTITY_SNOW_GOLEM_SHEAR("entity.snow_golem.shear"),
    ENTITY_SNOW_GOLEM_SHOOT("entity.snow_golem.shoot"),
    ENTITY_SPIDER_AMBIENT("entity.spider.ambient"),
    ENTITY_SPIDER_DEATH("entity.spider.death"),
    ENTITY_SPIDER_HURT("entity.spider.hurt"),
    ENTITY_SPIDER_STEP("entity.spider.step"),
    ENTITY_SPLASH_POTION_BREAK("entity.splash_potion.break"),
    ENTITY_SPLASH_POTION_THROW("entity.splash_potion.throw"),
    ENTITY_SQUID_AMBIENT("entity.squid.ambient"),
    ENTITY_SQUID_DEATH("entity.squid.death"),
    ENTITY_SQUID_HURT("entity.squid.hurt"),
    ENTITY_SQUID_SQUIRT("entity.squid.squirt"),
    ENTITY_STRAY_AMBIENT("entity.stray.ambient"),
    ENTITY_STRAY_DEATH("entity.stray.death"),
    ENTITY_STRAY_HURT("entity.stray.hurt"),
    ENTITY_STRAY_STEP("entity.stray.step"),
    @DInfo(since = "1.16.1")
    ENTITY_STRIDER_AMBIENT("entity.strider.ambient"),
    @DInfo(since = "1.16.1")
    ENTITY_STRIDER_DEATH("entity.strider.death"),
    @DInfo(since = "1.16.1")
    ENTITY_STRIDER_EAT("entity.strider.eat"),
    @DInfo(since = "1.16.1")
    ENTITY_STRIDER_HAPPY("entity.strider.happy"),
    @DInfo(since = "1.16.1")
    ENTITY_STRIDER_HURT("entity.strider.hurt"),
    @DInfo(since = "1.16.1")
    ENTITY_STRIDER_RETREAT("entity.strider.retreat"),
    @DInfo(since = "1.16.1")
    ENTITY_STRIDER_SADDLE("entity.strider.saddle"),
    @DInfo(since = "1.16.1")
    ENTITY_STRIDER_STEP("entity.strider.step"),
    @DInfo(since = "1.16.1")
    ENTITY_STRIDER_STEP_LAVA("entity.strider.step_lava"),
    @DInfo(since = "1.19")
    ENTITY_TADPOLE_DEATH("entity.tadpole.death"),
    @DInfo(since = "1.19")
    ENTITY_TADPOLE_FLOP("entity.tadpole.flop"),
    @DInfo(since = "1.19")
    ENTITY_TADPOLE_GROW_UP("entity.tadpole.grow_up"),
    @DInfo(since = "1.19")
    ENTITY_TADPOLE_HURT("entity.tadpole.hurt"),
    ENTITY_TNT_PRIMED("entity.tnt.primed"),
    ENTITY_TROPICAL_FISH_AMBIENT("entity.tropical_fish.ambient"),
    ENTITY_TROPICAL_FISH_DEATH("entity.tropical_fish.death"),
    ENTITY_TROPICAL_FISH_FLOP("entity.tropical_fish.flop"),
    ENTITY_TROPICAL_FISH_HURT("entity.tropical_fish.hurt"),
    ENTITY_TURTLE_AMBIENT_LAND("entity.turtle.ambient_land"),
    ENTITY_TURTLE_DEATH("entity.turtle.death"),
    ENTITY_TURTLE_DEATH_BABY("entity.turtle.death_baby"),
    ENTITY_TURTLE_EGG_BREAK("entity.turtle.egg_break"),
    ENTITY_TURTLE_EGG_CRACK("entity.turtle.egg_crack"),
    ENTITY_TURTLE_EGG_HATCH("entity.turtle.egg_hatch"),
    ENTITY_TURTLE_HURT("entity.turtle.hurt"),
    ENTITY_TURTLE_HURT_BABY("entity.turtle.hurt_baby"),
    ENTITY_TURTLE_LAY_EGG("entity.turtle.lay_egg"),
    ENTITY_TURTLE_SHAMBLE("entity.turtle.shamble"),
    ENTITY_TURTLE_SHAMBLE_BABY("entity.turtle.shamble_baby"),
    ENTITY_TURTLE_SWIM("entity.turtle.swim"),
    ENTITY_VEX_AMBIENT("entity.vex.ambient"),
    ENTITY_VEX_CHARGE("entity.vex.charge"),
    ENTITY_VEX_DEATH("entity.vex.death"),
    ENTITY_VEX_HURT("entity.vex.hurt"),
    ENTITY_VILLAGER_AMBIENT("entity.villager.ambient"),
    ENTITY_VILLAGER_CELEBRATE("entity.villager.celebrate"),
    ENTITY_VILLAGER_DEATH("entity.villager.death"),
    ENTITY_VILLAGER_HURT("entity.villager.hurt"),
    ENTITY_VILLAGER_NO("entity.villager.no"),
    ENTITY_VILLAGER_TRADE("entity.villager.trade"),
    ENTITY_VILLAGER_WORK_ARMORER("entity.villager.work_armorer"),
    ENTITY_VILLAGER_WORK_BUTCHER("entity.villager.work_butcher"),
    ENTITY_VILLAGER_WORK_CARTOGRAPHER("entity.villager.work_cartographer"),
    ENTITY_VILLAGER_WORK_CLERIC("entity.villager.work_cleric"),
    ENTITY_VILLAGER_WORK_FARMER("entity.villager.work_farmer"),
    ENTITY_VILLAGER_WORK_FISHERMAN("entity.villager.work_fisherman"),
    ENTITY_VILLAGER_WORK_FLETCHER("entity.villager.work_fletcher"),
    ENTITY_VILLAGER_WORK_LEATHERWORKER("entity.villager.work_leatherworker"),
    ENTITY_VILLAGER_WORK_LIBRARIAN("entity.villager.work_librarian"),
    ENTITY_VILLAGER_WORK_MASON("entity.villager.work_mason"),
    ENTITY_VILLAGER_WORK_SHEPHERD("entity.villager.work_shepherd"),
    ENTITY_VILLAGER_WORK_TOOLSMITH("entity.villager.work_toolsmith"),
    ENTITY_VILLAGER_WORK_WEAPONSMITH("entity.villager.work_weaponsmith"),
    ENTITY_VILLAGER_YES("entity.villager.yes"),
    ENTITY_VINDICATOR_AMBIENT("entity.vindicator.ambient"),
    ENTITY_VINDICATOR_CELEBRATE("entity.vindicator.celebrate"),
    ENTITY_VINDICATOR_DEATH("entity.vindicator.death"),
    ENTITY_VINDICATOR_HURT("entity.vindicator.hurt"),
    ENTITY_WANDERING_TRADER_AMBIENT("entity.wandering_trader.ambient"),
    ENTITY_WANDERING_TRADER_DEATH("entity.wandering_trader.death"),
    ENTITY_WANDERING_TRADER_DISAPPEARED("entity.wandering_trader.disappeared"),
    ENTITY_WANDERING_TRADER_DRINK_MILK("entity.wandering_trader.drink_milk"),
    ENTITY_WANDERING_TRADER_DRINK_POTION("entity.wandering_trader.drink_potion"),
    ENTITY_WANDERING_TRADER_HURT("entity.wandering_trader.hurt"),
    ENTITY_WANDERING_TRADER_NO("entity.wandering_trader.no"),
    ENTITY_WANDERING_TRADER_REAPPEARED("entity.wandering_trader.reappeared"),
    ENTITY_WANDERING_TRADER_TRADE("entity.wandering_trader.trade"),
    ENTITY_WANDERING_TRADER_YES("entity.wandering_trader.yes"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_AGITATED("entity.warden.agitated"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_AMBIENT("entity.warden.ambient"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_ANGRY("entity.warden.angry"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_ATTACK_IMPACT("entity.warden.attack_impact"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_DEATH("entity.warden.death"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_DIG("entity.warden.dig"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_EMERGE("entity.warden.emerge"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_HEARTBEAT("entity.warden.heartbeat"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_HURT("entity.warden.hurt"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_LISTENING("entity.warden.listening"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_LISTENING_ANGRY("entity.warden.listening_angry"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_NEARBY_CLOSE("entity.warden.nearby_close"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_NEARBY_CLOSER("entity.warden.nearby_closer"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_NEARBY_CLOSEST("entity.warden.nearby_closest"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_ROAR("entity.warden.roar"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_SNIFF("entity.warden.sniff"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_SONIC_BOOM("entity.warden.sonic_boom"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_SONIC_CHARGE("entity.warden.sonic_charge"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_STEP("entity.warden.step"),
    @DInfo(since = "1.19")
    ENTITY_WARDEN_TENDRIL_CLICKS("entity.warden.tendril_clicks"),
    @DInfo(since = "1.21")
    ENTITY_WIND_CHARGE_THROW("entity.wind_charge.throw"),
    @DInfo(since = "1.21")
    ENTITY_WIND_CHARGE_WIND_BURST("entity.wind_charge.wind_burst"),
    ENTITY_WITCH_AMBIENT("entity.witch.ambient"),
    ENTITY_WITCH_CELEBRATE("entity.witch.celebrate"),
    ENTITY_WITCH_DEATH("entity.witch.death"),
    ENTITY_WITCH_DRINK("entity.witch.drink"),
    ENTITY_WITCH_HURT("entity.witch.hurt"),
    ENTITY_WITCH_THROW("entity.witch.throw"),
    ENTITY_WITHER_AMBIENT("entity.wither.ambient"),
    ENTITY_WITHER_BREAK_BLOCK("entity.wither.break_block"),
    ENTITY_WITHER_DEATH("entity.wither.death"),
    ENTITY_WITHER_HURT("entity.wither.hurt"),
    ENTITY_WITHER_SHOOT("entity.wither.shoot"),
    ENTITY_WITHER_SKELETON_AMBIENT("entity.wither_skeleton.ambient"),
    ENTITY_WITHER_SKELETON_DEATH("entity.wither_skeleton.death"),
    ENTITY_WITHER_SKELETON_HURT("entity.wither_skeleton.hurt"),
    ENTITY_WITHER_SKELETON_STEP("entity.wither_skeleton.step"),
    ENTITY_WITHER_SPAWN("entity.wither.spawn"),
    ENTITY_WOLF_AMBIENT("entity.wolf.ambient"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_ANGRY_AMBIENT("entity.wolf_angry.ambient"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_ANGRY_DEATH("entity.wolf_angry.death"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_ANGRY_GROWL("entity.wolf_angry.growl"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_ANGRY_HURT("entity.wolf_angry.hurt"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_ANGRY_PANT("entity.wolf_angry.pant"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_ANGRY_WHINE("entity.wolf_angry.whine"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_BIG_AMBIENT("entity.wolf_big.ambient"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_BIG_DEATH("entity.wolf_big.death"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_BIG_GROWL("entity.wolf_big.growl"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_BIG_HURT("entity.wolf_big.hurt"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_BIG_PANT("entity.wolf_big.pant"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_BIG_WHINE("entity.wolf_big.whine"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_CUTE_AMBIENT("entity.wolf_cute.ambient"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_CUTE_DEATH("entity.wolf_cute.death"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_CUTE_GROWL("entity.wolf_cute.growl"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_CUTE_HURT("entity.wolf_cute.hurt"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_CUTE_PANT("entity.wolf_cute.pant"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_CUTE_WHINE("entity.wolf_cute.whine"),
    ENTITY_WOLF_DEATH("entity.wolf.death"),
    ENTITY_WOLF_GROWL("entity.wolf.growl"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_GRUMPY_AMBIENT("entity.wolf_grumpy.ambient"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_GRUMPY_DEATH("entity.wolf_grumpy.death"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_GRUMPY_GROWL("entity.wolf_grumpy.growl"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_GRUMPY_HURT("entity.wolf_grumpy.hurt"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_GRUMPY_PANT("entity.wolf_grumpy.pant"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_GRUMPY_WHINE("entity.wolf_grumpy.whine"),
    ENTITY_WOLF_HURT("entity.wolf.hurt"),
    ENTITY_WOLF_PANT("entity.wolf.pant"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_PUGLIN_AMBIENT("entity.wolf_puglin.ambient"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_PUGLIN_DEATH("entity.wolf_puglin.death"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_PUGLIN_GROWL("entity.wolf_puglin.growl"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_PUGLIN_HURT("entity.wolf_puglin.hurt"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_PUGLIN_PANT("entity.wolf_puglin.pant"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_PUGLIN_WHINE("entity.wolf_puglin.whine"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_SAD_AMBIENT("entity.wolf_sad.ambient"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_SAD_DEATH("entity.wolf_sad.death"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_SAD_GROWL("entity.wolf_sad.growl"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_SAD_HURT("entity.wolf_sad.hurt"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_SAD_PANT("entity.wolf_sad.pant"),
    @DInfo(since = "1.21.5")
    ENTITY_WOLF_SAD_WHINE("entity.wolf_sad.whine"),
    ENTITY_WOLF_SHAKE("entity.wolf.shake"),
    ENTITY_WOLF_STEP("entity.wolf.step"),
    ENTITY_WOLF_WHINE("entity.wolf.whine"),
    @DInfo(since = "1.16.1")
    ENTITY_ZOGLIN_AMBIENT("entity.zoglin.ambient"),
    @DInfo(since = "1.16.1")
    ENTITY_ZOGLIN_ANGRY("entity.zoglin.angry"),
    @DInfo(since = "1.16.1")
    ENTITY_ZOGLIN_ATTACK("entity.zoglin.attack"),
    @DInfo(since = "1.16.1")
    ENTITY_ZOGLIN_DEATH("entity.zoglin.death"),
    @DInfo(since = "1.16.1")
    ENTITY_ZOGLIN_HURT("entity.zoglin.hurt"),
    @DInfo(since = "1.16.1")
    ENTITY_ZOGLIN_STEP("entity.zoglin.step"),
    ENTITY_ZOMBIE_AMBIENT("entity.zombie.ambient"),
    ENTITY_ZOMBIE_ATTACK_IRON_DOOR("entity.zombie.attack_iron_door"),
    ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR("entity.zombie.attack_wooden_door"),
    ENTITY_ZOMBIE_BREAK_WOODEN_DOOR("entity.zombie.break_wooden_door"),
    ENTITY_ZOMBIE_CONVERTED_TO_DROWNED("entity.zombie.converted_to_drowned"),
    ENTITY_ZOMBIE_DEATH("entity.zombie.death"),
    ENTITY_ZOMBIE_DESTROY_EGG("entity.zombie.destroy_egg"),
    ENTITY_ZOMBIE_HORSE_AMBIENT("entity.zombie_horse.ambient"),
    ENTITY_ZOMBIE_HORSE_DEATH("entity.zombie_horse.death"),
    ENTITY_ZOMBIE_HORSE_HURT("entity.zombie_horse.hurt"),
    ENTITY_ZOMBIE_HURT("entity.zombie.hurt"),
    ENTITY_ZOMBIE_INFECT("entity.zombie.infect"),
    ENTITY_ZOMBIE_STEP("entity.zombie.step"),
    ENTITY_ZOMBIE_VILLAGER_AMBIENT("entity.zombie_villager.ambient"),
    ENTITY_ZOMBIE_VILLAGER_CONVERTED("entity.zombie_villager.converted"),
    ENTITY_ZOMBIE_VILLAGER_CURE("entity.zombie_villager.cure"),
    ENTITY_ZOMBIE_VILLAGER_DEATH("entity.zombie_villager.death"),
    ENTITY_ZOMBIE_VILLAGER_HURT("entity.zombie_villager.hurt"),
    ENTITY_ZOMBIE_VILLAGER_STEP("entity.zombie_villager.step"),
    @DRenamed(since = "1.16.1", from = "ENTITY_ZOMBIE_PIGMAN_AMBIENT")
    ENTITY_ZOMBIFIED_PIGLIN_AMBIENT("entity.zombified_piglin.ambient"),
    @DRenamed(since = "1.16.1", from = "ENTITY_ZOMBIE_PIGMAN_ANGRY")
    ENTITY_ZOMBIFIED_PIGLIN_ANGRY("entity.zombified_piglin.angry"),
    @DRenamed(since = "1.16.1", from = "ENTITY_ZOMBIE_PIGMAN_DEATH")
    ENTITY_ZOMBIFIED_PIGLIN_DEATH("entity.zombified_piglin.death"),
    @DRenamed(since = "1.16.1", from = "ENTITY_ZOMBIE_PIGMAN_HURT")
    ENTITY_ZOMBIFIED_PIGLIN_HURT("entity.zombified_piglin.hurt"),
    @DInfo(since = "1.21")
    EVENT_MOB_EFFECT_BAD_OMEN("event.mob_effect.bad_omen"),
    @DInfo(since = "1.21")
    EVENT_MOB_EFFECT_RAID_OMEN("event.mob_effect.raid_omen"),
    @DInfo(since = "1.21")
    EVENT_MOB_EFFECT_TRIAL_OMEN("event.mob_effect.trial_omen"),
    EVENT_RAID_HORN("event.raid.horn"),
    @DInfo(since = "1.19.4")
    INTENTIONALLY_EMPTY("intentionally_empty"),
    ITEM_ARMOR_EQUIP_CHAIN("item.armor.equip_chain"),
    ITEM_ARMOR_EQUIP_DIAMOND("item.armor.equip_diamond"),
    ITEM_ARMOR_EQUIP_ELYTRA("item.armor.equip_elytra"),
    ITEM_ARMOR_EQUIP_GENERIC("item.armor.equip_generic"),
    ITEM_ARMOR_EQUIP_GOLD("item.armor.equip_gold"),
    ITEM_ARMOR_EQUIP_IRON("item.armor.equip_iron"),
    ITEM_ARMOR_EQUIP_LEATHER("item.armor.equip_leather"),
    @DInfo(since = "1.16.1")
    ITEM_ARMOR_EQUIP_NETHERITE("item.armor.equip_netherite"),
    ITEM_ARMOR_EQUIP_TURTLE("item.armor.equip_turtle"),
    @DInfo(since = "1.20.5")
    ITEM_ARMOR_EQUIP_WOLF("item.armor.equip_wolf"),
    @DInfo(since = "1.20.5")
    ITEM_ARMOR_UNEQUIP_WOLF("item.armor.unequip_wolf"),
    @DInfo(since = "1.17")
    ITEM_AXE_SCRAPE("item.axe.scrape"),
    ITEM_AXE_STRIP("item.axe.strip"),
    @DInfo(since = "1.17")
    ITEM_AXE_WAX_OFF("item.axe.wax_off"),
    @DInfo(since = "1.17")
    ITEM_BONE_MEAL_USE("item.bone_meal.use"),
    ITEM_BOOK_PAGE_TURN("item.book.page_turn"),
    ITEM_BOOK_PUT("item.book.put"),
    ITEM_BOTTLE_EMPTY("item.bottle.empty"),
    ITEM_BOTTLE_FILL("item.bottle.fill"),
    ITEM_BOTTLE_FILL_DRAGONBREATH("item.bottle.fill_dragonbreath"),
    @DInfo(since = "1.20")
    ITEM_BRUSH_BRUSHING_GENERIC("item.brush.brushing.generic"),
    @DInfo(since = "1.20")
    ITEM_BRUSH_BRUSHING_GRAVEL("item.brush.brushing.gravel"),
    @DInfo(since = "1.20")
    ITEM_BRUSH_BRUSHING_GRAVEL_COMPLETE("item.brush.brushing.gravel.complete"),
    @DInfo(since = "1.20")
    ITEM_BRUSH_BRUSHING_SAND("item.brush.brushing.sand"),
    @DInfo(since = "1.20")
    ITEM_BRUSH_BRUSHING_SAND_COMPLETE("item.brush.brushing.sand.complete"),
    ITEM_BUCKET_EMPTY("item.bucket.empty"),
    @DInfo(since = "1.17")
    ITEM_BUCKET_EMPTY_AXOLOTL("item.bucket.empty_axolotl"),
    ITEM_BUCKET_EMPTY_FISH("item.bucket.empty_fish"),
    ITEM_BUCKET_EMPTY_LAVA("item.bucket.empty_lava"),
    @DInfo(since = "1.17")
    ITEM_BUCKET_EMPTY_POWDER_SNOW("item.bucket.empty_powder_snow"),
    @DInfo(since = "1.19")
    ITEM_BUCKET_EMPTY_TADPOLE("item.bucket.empty_tadpole"),
    ITEM_BUCKET_FILL("item.bucket.fill"),
    @DInfo(since = "1.17")
    ITEM_BUCKET_FILL_AXOLOTL("item.bucket.fill_axolotl"),
    ITEM_BUCKET_FILL_FISH("item.bucket.fill_fish"),
    ITEM_BUCKET_FILL_LAVA("item.bucket.fill_lava"),
    @DInfo(since = "1.17")
    ITEM_BUCKET_FILL_POWDER_SNOW("item.bucket.fill_powder_snow"),
    @DInfo(since = "1.19")
    ITEM_BUCKET_FILL_TADPOLE("item.bucket.fill_tadpole"),
    @DInfo(since = "1.18")
    ITEM_BUNDLE_DROP_CONTENTS("item.bundle.drop_contents"),
    @DInfo(since = "1.18")
    ITEM_BUNDLE_INSERT("item.bundle.insert"),
    @DInfo(since = "1.21.2")
    ITEM_BUNDLE_INSERT_FAIL("item.bundle.insert_fail"),
    @DInfo(since = "1.18")
    ITEM_BUNDLE_REMOVE_ONE("item.bundle.remove_one"),
    ITEM_CHORUS_FRUIT_TELEPORT("item.chorus_fruit.teleport"),
    ITEM_CROP_PLANT("item.crop.plant"),
    ITEM_CROSSBOW_HIT("item.crossbow.hit"),
    ITEM_CROSSBOW_LOADING_END("item.crossbow.loading_end"),
    ITEM_CROSSBOW_LOADING_MIDDLE("item.crossbow.loading_middle"),
    ITEM_CROSSBOW_LOADING_START("item.crossbow.loading_start"),
    ITEM_CROSSBOW_QUICK_CHARGE_1("item.crossbow.quick_charge_1"),
    ITEM_CROSSBOW_QUICK_CHARGE_2("item.crossbow.quick_charge_2"),
    ITEM_CROSSBOW_QUICK_CHARGE_3("item.crossbow.quick_charge_3"),
    ITEM_CROSSBOW_SHOOT("item.crossbow.shoot"),
    @DInfo(since = "1.17")
    ITEM_DYE_USE("item.dye.use"),
    ITEM_ELYTRA_FLYING("item.elytra.flying"),
    ITEM_FIRECHARGE_USE("item.firecharge.use"),
    ITEM_FLINTANDSTEEL_USE("item.flintandsteel.use"),
    @DInfo(since = "1.17")
    ITEM_GLOW_INK_SAC_USE("item.glow_ink_sac.use"),
    @DInfo(since = "1.19")
    ITEM_GOAT_HORN_SOUND_0("item.goat_horn.sound.0"),
    @DInfo(since = "1.19")
    ITEM_GOAT_HORN_SOUND_1("item.goat_horn.sound.1"),
    @DInfo(since = "1.19")
    ITEM_GOAT_HORN_SOUND_2("item.goat_horn.sound.2"),
    @DInfo(since = "1.19")
    ITEM_GOAT_HORN_SOUND_3("item.goat_horn.sound.3"),
    @DInfo(since = "1.19")
    ITEM_GOAT_HORN_SOUND_4("item.goat_horn.sound.4"),
    @DInfo(since = "1.19")
    ITEM_GOAT_HORN_SOUND_5("item.goat_horn.sound.5"),
    @DInfo(since = "1.19")
    ITEM_GOAT_HORN_SOUND_6("item.goat_horn.sound.6"),
    @DInfo(since = "1.19")
    ITEM_GOAT_HORN_SOUND_7("item.goat_horn.sound.7"),
    ITEM_HOE_TILL("item.hoe.till"),
    @DInfo(since = "1.17")
    ITEM_HONEYCOMB_WAX_ON("item.honeycomb.wax_on"),
    ITEM_HONEY_BOTTLE_DRINK("item.honey_bottle.drink"),
    @DInfo(since = "1.21.6")
    ITEM_HORSE_ARMOR_UNEQUIP("item.horse_armor.unequip"),
    @DInfo(since = "1.17")
    ITEM_INK_SAC_USE("item.ink_sac.use"),
    @DRenamed(since = "1.21.6", from = "ENTITY_LEASH_KNOT_BREAK")
    ITEM_LEAD_BREAK("item.lead.break"),
    @DInfo(since = "1.21.6")
    ITEM_LEAD_TIED("item.lead.tied"),
    @DInfo(since = "1.21.6")
    ITEM_LEAD_UNTIED("item.lead.untied"),
    @DInfo(since = "1.21.6")
    ITEM_LLAMA_CARPET_UNEQUIP("item.llama_carpet.unequip"),
    @DInfo(since = "1.16.1")
    ITEM_LODESTONE_COMPASS_LOCK("item.lodestone_compass.lock"),
    @DInfo(since = "1.21")
    ITEM_MACE_SMASH_AIR("item.mace.smash_air"),
    @DInfo(since = "1.21")
    ITEM_MACE_SMASH_GROUND("item.mace.smash_ground"),
    @DInfo(since = "1.21")
    ITEM_MACE_SMASH_GROUND_HEAVY("item.mace.smash_ground_heavy"),
    ITEM_NETHER_WART_PLANT("item.nether_wart.plant"),
    @DInfo(since = "1.21")
    ITEM_OMINOUS_BOTTLE_DISPOSE("item.ominous_bottle.dispose"),
    @DInfo(since = "1.21.6")
    ITEM_SADDLE_UNEQUIP("item.saddle.unequip"),
    @DInfo(since = "1.21.6")
    ITEM_SHEARS_SNIP("item.shears.snip"),
    ITEM_SHIELD_BLOCK("item.shield.block"),
    ITEM_SHIELD_BREAK("item.shield.break"),
    ITEM_SHOVEL_FLATTEN("item.shovel.flatten"),
    @DInfo(since = "1.17")
    ITEM_SPYGLASS_STOP_USING("item.spyglass.stop_using"),
    @DInfo(since = "1.17")
    ITEM_SPYGLASS_USE("item.spyglass.use"),
    ITEM_TOTEM_USE("item.totem.use"),
    ITEM_TRIDENT_HIT("item.trident.hit"),
    ITEM_TRIDENT_HIT_GROUND("item.trident.hit_ground"),
    ITEM_TRIDENT_RETURN("item.trident.return"),
    ITEM_TRIDENT_RIPTIDE_1("item.trident.riptide_1"),
    ITEM_TRIDENT_RIPTIDE_2("item.trident.riptide_2"),
    ITEM_TRIDENT_RIPTIDE_3("item.trident.riptide_3"),
    ITEM_TRIDENT_THROW("item.trident.throw"),
    ITEM_TRIDENT_THUNDER("item.trident.thunder"),
    @DInfo(since = "1.21")
    ITEM_WOLF_ARMOR_BREAK("item.wolf_armor.break"),
    @DInfo(since = "1.21")
    ITEM_WOLF_ARMOR_CRACK("item.wolf_armor.crack"),
    @DInfo(since = "1.21")
    ITEM_WOLF_ARMOR_DAMAGE("item.wolf_armor.damage"),
    @DInfo(since = "1.21")
    ITEM_WOLF_ARMOR_REPAIR("item.wolf_armor.repair"),
    MUSIC_CREATIVE("music.creative"),
    MUSIC_CREDITS("music.credits"),
    MUSIC_DISC_11("music_disc.11"),
    MUSIC_DISC_13("music_disc.13"),
    @DInfo(since = "1.19")
    MUSIC_DISC_5("music_disc.5"),
    MUSIC_DISC_BLOCKS("music_disc.blocks"),
    MUSIC_DISC_CAT("music_disc.cat"),
    MUSIC_DISC_CHIRP("music_disc.chirp"),
    @DInfo(since = "1.21")
    MUSIC_DISC_CREATOR("music_disc.creator"),
    @DInfo(since = "1.21")
    MUSIC_DISC_CREATOR_MUSIC_BOX("music_disc.creator_music_box"),
    MUSIC_DISC_FAR("music_disc.far"),
    @DInfo(since = "1.21.7")
    MUSIC_DISC_LAVA_CHICKEN("music_disc.lava_chicken"),
    MUSIC_DISC_MALL("music_disc.mall"),
    MUSIC_DISC_MELLOHI("music_disc.mellohi"),
    @DInfo(since = "1.18")
    MUSIC_DISC_OTHERSIDE("music_disc.otherside"),
    @DInfo(since = "1.16.1")
    MUSIC_DISC_PIGSTEP("music_disc.pigstep"),
    @DInfo(since = "1.21")
    MUSIC_DISC_PRECIPICE("music_disc.precipice"),
    @DInfo(since = "1.20")
    MUSIC_DISC_RELIC("music_disc.relic"),
    MUSIC_DISC_STAL("music_disc.stal"),
    MUSIC_DISC_STRAD("music_disc.strad"),
    MUSIC_DISC_TEARS("music_disc.tears"),
    MUSIC_DISC_WAIT("music_disc.wait"),
    MUSIC_DISC_WARD("music_disc.ward"),
    MUSIC_DRAGON("music.dragon"),
    MUSIC_END("music.end"),
    MUSIC_GAME("music.game"),
    MUSIC_MENU("music.menu"),
    @DInfo(since = "1.16.1")
    MUSIC_NETHER_BASALT_DELTAS("music.nether.basalt_deltas"),
    @DInfo(since = "1.16.1")
    MUSIC_NETHER_CRIMSON_FOREST("music.nether.crimson_forest"),
    @DInfo(since = "1.16.1")
    MUSIC_NETHER_NETHER_WASTES("music.nether.nether_wastes"),
    @DInfo(since = "1.16.1")
    MUSIC_NETHER_SOUL_SAND_VALLEY("music.nether.soul_sand_valley"),
    @DInfo(since = "1.16.1")
    MUSIC_NETHER_WARPED_FOREST("music.nether.warped_forest"),
    @DInfo(since = "1.20")
    MUSIC_OVERWORLD_BADLANDS("music.overworld.badlands"),
    @DInfo(since = "1.20")
    MUSIC_OVERWORLD_BAMBOO_JUNGLE("music.overworld.bamboo_jungle"),
    @DInfo(since = "1.19.4")
    MUSIC_OVERWORLD_CHERRY_GROVE("music.overworld.cherry_grove"),
    @DInfo(since = "1.19")
    MUSIC_OVERWORLD_DEEP_DARK("music.overworld.deep_dark"),
    @DInfo(since = "1.20")
    MUSIC_OVERWORLD_DESERT("music.overworld.desert"),
    @DInfo(since = "1.18")
    MUSIC_OVERWORLD_DRIPSTONE_CAVES("music.overworld.dripstone_caves"),
    MUSIC_OVERWORLD_FLOWER_FOREST("music.overworld.flower_forest"),
    @DInfo(since = "1.20")
    MUSIC_OVERWORLD_FOREST("music.overworld.forest"),
    @DInfo(since = "1.18")
    MUSIC_OVERWORLD_FROZEN_PEAKS("music.overworld.frozen_peaks"),
    @DInfo(since = "1.18")
    MUSIC_OVERWORLD_GROVE("music.overworld.grove"),
    @DInfo(since = "1.18")
    MUSIC_OVERWORLD_JAGGED_PEAKS("music.overworld.jagged_peaks"),
    @DRenamed(since = "1.20", from = "MUSIC_OVERWORLD_JUNGLE_AND_FOREST")
    MUSIC_OVERWORLD_JUNGLE("music.overworld.jungle"),
    @DInfo(since = "1.18")
    MUSIC_OVERWORLD_LUSH_CAVES("music.overworld.lush_caves"),
    @DInfo(since = "1.18")
    MUSIC_OVERWORLD_MEADOW("music.overworld.meadow"),
    @DInfo(since = "1.19")
    MUSIC_OVERWORLD_OLD_GROWTH_TAIGA("music.overworld.old_growth_taiga"),
    @DInfo(since = "1.18")
    MUSIC_OVERWORLD_SNOWY_SLOPES("music.overworld.snowy_slopes"),
    @DInfo(since = "1.20")
    MUSIC_OVERWORLD_SPARSE_JUNGLE("music.overworld.sparse_jungle"),
    @DInfo(since = "1.18")
    MUSIC_OVERWORLD_STONY_PEAKS("music.overworld.stony_peaks"),
    @DInfo(since = "1.19")
    MUSIC_OVERWORLD_SWAMP("music.overworld.swamp"),
    MUSIC_UNDER_WATER("music.under_water"),
    @DInfo(since = "1.16.1")
    PARTICLE_SOUL_ESCAPE("particle.soul_escape"),
    UI_BUTTON_CLICK("ui.button.click"),
    UI_CARTOGRAPHY_TABLE_TAKE_RESULT("ui.cartography_table.take_result"),
    @DInfo(since = "1.21.2")
    UI_HUD_BUBBLE_POP("ui.hud.bubble_pop"),
    UI_LOOM_SELECT_PATTERN("ui.loom.select_pattern"),
    UI_LOOM_TAKE_RESULT("ui.loom.take_result"),
    UI_STONECUTTER_SELECT_RECIPE("ui.stonecutter.select_recipe"),
    UI_STONECUTTER_TAKE_RESULT("ui.stonecutter.take_result"),
    UI_TOAST_CHALLENGE_COMPLETE("ui.toast.challenge_complete"),
    UI_TOAST_IN("ui.toast.in"),
    UI_TOAST_OUT("ui.toast.out"),
    WEATHER_RAIN("weather.rain"),
    WEATHER_RAIN_ABOVE("weather.rain.above"),
    //</editor-fold>

    //<editor-folder desc="Deprecated" defaultstate="collapsed">
    @DInfo(since = "1.21.5")
    @DDeprecated(since = "1.21.6")
    BLOCK_SAND_WIND("block.sand.wind"),
    @DInfo(since = "1.21")
    @DDeprecated(since = "1.21")
    BLOCK_TRIAL_SPAWNER_AMBIENT_CHARGED("block.trial_spawner.ambient_charged"),
    @DInfo(since = "1.21")
    @DDeprecated(since = "1.21")
    BLOCK_TRIAL_SPAWNER_CHARGE_ACTIVATE("block.trial_spawner.charge_activate"),
    @DInfo(since = "1.20.3")
    @DDeprecated(since = "1.20.5")
    ENTITY_GENERIC_WIND_BURST("entity.generic.wind_burst"),
    @DInfo(since = "1.19")
    @DDeprecated(since = "1.21.2")
    ENTITY_GOAT_SCREAMING_HORN_BREAK("entity.goat.screaming.horn_break"),
    @DDeprecated(since = "1.21.6")
    ENTITY_LEASH_KNOT_BREAK("entity.leash_knot.break"),
    @DDeprecated(since = "1.21.6")
    ENTITY_LEASH_KNOT_PLACE("entity.leash_knot.place"),
    @DDeprecated(since = "1.21.6")
    ENTITY_PUFFER_FISH_AMBIENT("entity.puffer_fish.ambient"),
    @DDeprecated(since = "1.21.5")
    ENTITY_WOLF_HOWL("entity.wolf.howl"),
    @DDeprecated(since = "1.16.1")
    ENTITY_ZOMBIE_PIGMAN_AMBIENT("entity.zombie_pigman.ambient"),
    @DDeprecated(since = "1.16.1")
    ENTITY_ZOMBIE_PIGMAN_ANGRY("entity.zombie_pigman.angry"),
    @DDeprecated(since = "1.16.1")
    ENTITY_ZOMBIE_PIGMAN_DEATH("entity.zombie_pigman.death"),
    @DDeprecated(since = "1.16.1")
    ENTITY_ZOMBIE_PIGMAN_HURT("entity.zombie_pigman.hurt"),
    @DInfo(since = "1.19.4")
    @DDeprecated(since = "1.20")
    ITEM_BRUSH_BRUSHING("item.brush_brushing"),
    @DInfo(since = "1.19.4")
    @DDeprecated(since = "1.20")
    ITEM_BRUSH_BRUSH_SAND_COMPLETED("item.brush.brush_sand_completed"),
    @DInfo(since = "1.19")
    @DDeprecated(since = "1.21.2")
    ITEM_GOAT_HORN_PLAY("item.goat_horn.play"),
    @DDeprecated(since = "1.17")
    ITEM_SWEET_BERRIES_PICK_FROM_BUSH("item.sweet_berries.pick_from_bush"),
    @DDeprecated(since = "1.16.1")
    MUSIC_NETHER("music.nether"),
    @DInfo(since = "1.19")
    @DDeprecated(since = "1.20")
    MUSIC_OVERWORLD_JUNGLE_AND_FOREST("music.overworld.jungle_and_forest"),
    ;
    //</editor-fold>

    DSound(@NotNull String key) {
        this.key = key;
    }

    private final @NotNull String key;

    public Sound parseSound() {
        return Wrapper.getSound(key);
    }


    //

    static public final @NotNull DSound[] VALUES = values();
    static private final @NotNull HashMap<String, DSound> NAME_MAP = new HashMap<>();

    static {
        for(DSound dSound : VALUES) {
            NAME_MAP.put(dSound.name(), dSound);
        }
    }

    static public DSound getByName(@NotNull String name) {
        return NAME_MAP.get(name);
    }

    static public DSound getByKey(@NotNull String key) {
        return NAME_MAP.get(key.replace(".","_").toUpperCase(Locale.ENGLISH));
    }
}
