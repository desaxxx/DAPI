package org.nandayo.dapi.object;

import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.attribute.Attribute;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.object.annotation.DDeprecated;
import org.nandayo.dapi.object.annotation.DInfo;
import org.nandayo.dapi.object.annotation.DRenamed;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 * Only supports 1.16.1 - 1.21.11<br>
 * Made by @desaxx (<a href="https://github.com/desaxxx/">GitHub</a>)<br>
 * Inspired from XSeries (<a href="https://github.com/CryptoMorin/XSeries">GitHub</a>)
 *
 * @since 1.5.3
 */
@SuppressWarnings("unused")
public enum DAttribute implements ObjectWrapper<Attribute> {

    //<editor-fold desc="Attributes" defaultstate="collapsed">
    @DInfo(since = "1.21.3")
    ARMOR("armor"),
    @DInfo(since = "1.21.3")
    ARMOR_TOUGHNESS("armor_toughness"),
    @DInfo(since = "1.21.3")
    ATTACK_DAMAGE("attack_damage"),
    @DInfo(since = "1.21.3")
    ATTACK_KNOCKBACK("attack_knockback"),
    @DInfo(since = "1.21.3")
    ATTACK_SPEED("attack_speed"),
    @DInfo(since = "1.21.3")
    BURNING_TIME("burning_time"),
    @DInfo(since = "1.21.6")
    CAMERA_DISTANCE("camera_distance"),
    @DInfo(since = "1.21.3")
    EXPLOSION_KNOCKBACK_RESISTANCE("explosion_knockback_resistance"),
    @DInfo(since = "1.21.3")
    FALL_DAMAGE_MULTIPLIER("fall_damage_multiplier"),
    @DInfo(since = "1.21.3")
    FLYING_SPEED("flying_speed"),
    @DInfo(since = "1.21.3")
    FOLLOW_RANGE("follow_range"),
    @DInfo(since = "1.21.3")
    GRAVITY("gravity"),
    @DInfo(since = "1.21.3")
    JUMP_STRENGTH("jump_strength"),
    @DInfo(since = "1.21.3")
    KNOCKBACK_RESISTANCE("knockback_resistance"),
    @DInfo(since = "1.21.3")
    LUCK("luck"),
    @DInfo(since = "1.21.3")
    MAX_ABSORPTION("max_absorption"),
    @DInfo(since = "1.21.3")
    MAX_HEALTH("max_health"),
    @DInfo(since = "1.21.3")
    MOVEMENT_EFFICIENCY("movement_efficiency"),
    @DInfo(since = "1.21.3")
    MOVEMENT_SPEED("movement_speed"),
    @DInfo(since = "1.21.3")
    OXYGEN_BONUS("oxygen_bonus"),
    @DInfo(since = "1.21.3")
    SAFE_FALL_DISTANCE("safe_fall_distance"),
    @DInfo(since = "1.21.3")
    SCALE("scale"),
    @DInfo(since = "1.21.3")
    STEP_HEIGHT("step_height"),
    @DInfo(since = "1.21.3")
    TEMPT_RANGE("tempt_range"),
    @DInfo(since = "1.21.3")
    WATER_MOVEMENT_EFFICIENCY("water_movement_efficiency"),
    @DInfo(since = "1.21.3")
    BLOCK_BREAK_SPEED("block_break_speed"),
    @DInfo(since = "1.21.3")
    BLOCK_INTERACTION_RANGE("block_interaction_range"),
    @DInfo(since = "1.21.3")
    ENTITY_INTERACTION_RANGE("entity_interaction_range"),
    @DInfo(since = "1.21.3")
    MINING_EFFICIENCY("mining_efficiency"),
    @DInfo(since = "1.21.3")
    SNEAKING_SPEED("sneaking_speed"),
    @DInfo(since = "1.21.3")
    SUBMERGED_MINING_SPEED("submerged_mining_speed"),
    @DInfo(since = "1.21.3")
    SWEEPING_DAMAGE_RATIO("sweeping_damage_ratio"),
    @DInfo(since = "1.21.3")
    SPAWN_REINFORCEMENTS("spawn_reinforcements"),
    @DInfo(since = "1.21.6")
    WAYPOINT_RECEIVE_RANGE("waypoint_receive_range"),
    @DInfo(since = "1.21.6")
    WAYPOINT_TRANSMIT_RANGE("waypoint_transmit_range"),
    //</editor-fold>

    //<editor-fold desc="Deprecated" defaultstate="collapsed>
    @DDeprecated(since = "1.21.3")
    GENERIC_ARMOR("armor","generic.armor"),
    @DDeprecated(since = "1.21.3")
    GENERIC_ARMOR_TOUGHNESS("armor_toughness", "generic.armor_toughness"),
    @DDeprecated(since = "1.21.3")
    GENERIC_ATTACK_DAMAGE("attack_damage","generic.attack_damage"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.16.1")
    GENERIC_ATTACK_KNOCKBACK("attack_knockback","generic.attack_knockback"),
    @DDeprecated(since = "1.21.3")
    GENERIC_ATTACK_SPEED("attack_speed","generic.attack_speed"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    GENERIC_BURNING_TIME("burning_time","generic.burning_time"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    GENERIC_EXPLOSION_KNOCKBACK_RESISTANCE("explosion_knockback_resistance","generic.explosion_knockback_resistance"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    GENERIC_FALL_DAMAGE_MULTIPLIER("fall_damage_multiplier","generic.fall_damage_multiplier"),
    @DDeprecated(since = "1.21.3")
    GENERIC_FLYING_SPEED,
    @DDeprecated(since = "1.21.3")
    GENERIC_FOLLOW_RANGE("follow_range","generic.follow_range"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    GENERIC_GRAVITY("gravity","generic.gravity"),
    @DDeprecated(since = "1.21.3")
    @DRenamed(since = "1.20.5", from = "HORSE_JUMP_STRENGTH")
    GENERIC_JUMP_STRENGTH("jump_strength","generic.jump_strength"),
    @DDeprecated(since = "1.21.3")
    GENERIC_KNOCKBACK_RESISTANCE("knockback_resistance","generic.knockback_resistance"),
    @DDeprecated(since = "1.21.3")
    GENERIC_LUCK("luck","generic.luck"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.2")
    GENERIC_MAX_ABSORPTION("max_absorption","generic.max_absorption"),
    @DDeprecated(since = "1.21.3")
    GENERIC_MAX_HEALTH("max_health","generic.max_health"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    GENERIC_MOVEMENT_EFFICIENCY("movement_efficiency","generic.movement_efficiency"),
    @DDeprecated(since = "1.21.3")
    GENERIC_MOVEMENT_SPEED("movement_speed","generic.movement_speed"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    GENERIC_OXYGEN_BONUS("oxygen_bonus","generic.oxygen_bonus"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    GENERIC_SAFE_FALL_DISTANCE("safe_fall_distance","generic.safe_fall_distance"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    GENERIC_SCALE("scale","generic.scale"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    GENERIC_STEP_HEIGHT("step_height","generic.step_height"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21.2")
    GENERIC_TEMPT_RANGE("tempt_range"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    GENERIC_WATER_MOVEMENT_EFFICIENCY("water_movement_efficiency","generic.water_movement_efficiency"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    PLAYER_BLOCK_BREAK_SPEED("block_break_speed","player.block_break_speed"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    PLAYER_BLOCK_INTERACTION_RANGE("block_interaction_range","player.block_interaction_range"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    PLAYER_ENTITY_INTERACTION_RANGE("entity_interaction_range","player.entity_interaction_range"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    PLAYER_MINING_EFFICIENCY("mining_efficiency","player.mining_efficiency"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    PLAYER_SNEAKING_SPEED("sneaking_speed","player.sneaking_speed"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    PLAYER_SUBMERGED_MINING_SPEED("submerged_mining_speed","player.submerged_mining_speed"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    PLAYER_SWEEPING_DAMAGE_RATIO("sweeping_damage_ratio","player.sweeping_damage_ratio"),
    @DDeprecated(since = "1.21.3")
    ZOMBIE_SPAWN_REINFORCEMENTS("spawn_reinforcements","zombie.spawn_reinforcements"),

    @DDeprecated(since = "1.20.5")
    HORSE_JUMP_STRENGTH("horse.jump_strength"),
    //</editor-fold>

    ;


    private final String[] keys;
    private final Attribute attribute;

    DAttribute(String... keys) {
        this.keys = keys;

        Attribute att = null;
        for(String key : keys) {
            att = Registry.ATTRIBUTE.get(NamespacedKey.minecraft(key.toLowerCase(Locale.ENGLISH)));
            if(att != null) {
                break;
            }
        }
        this.attribute = att;
    }

    @Override
    public Attribute parse() {
        return attribute;
    }

    @Override
    public @NotNull Optional<Attribute> parseOptional() {
        return Optional.ofNullable(attribute);
    }

    //

    private static final Map<String, DAttribute> NAME_MAP = new HashMap<>();
    private static final Map<String, DAttribute> KEY_MAP = new HashMap<>();

    static {
        for(DAttribute dAttribute : DAttribute.values()) {
            NAME_MAP.put(dAttribute.name(), dAttribute);

            for(String key : dAttribute.keys) {
                KEY_MAP.put(key, dAttribute);
            }
        }
    }

    public static DAttribute getByName(@NotNull String name) {
        return NAME_MAP.get(name);
    }

    public static DAttribute getByKey(@NotNull String key) {
        return KEY_MAP.get(key);
    }
}
