package org.nandayo.dapi.object;

import org.bukkit.attribute.Attribute;
import org.jetbrains.annotations.ApiStatus;
import org.nandayo.dapi.object.annotation.DDeprecated;
import org.nandayo.dapi.object.annotation.DInfo;
import org.nandayo.dapi.object.annotation.DRenamed;

@ApiStatus.Experimental
@ApiStatus.Internal
public enum DAttribute {

    @DDeprecated(since = "1.21.3")
    GENERIC_ARMOR("armor","generic.armor"),
    @DDeprecated(since = "1.21.3")
    GENERIC_ARMOR_TOUGHNESS("armor.toughness", "generic.armor.toughness"),
    @DDeprecated(since = "1.21.3")
    GENERIC_ATTACK_DAMAGE("generic.attack_damage","attack_damage"),
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.16.1")
    GENERIC_ATTACK_KNOCKBACK,
    @DDeprecated(since = "1.21.3")
    GENERIC_ATTACK_SPEED,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    GENERIC_BURNING_TIME,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    GENERIC_EXPLOSION_KNOCKBACK_RESISTANCE,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    GENERIC_FALL_DAMAGE_MULTIPLIER,
    @DDeprecated(since = "1.21.3")
    GENERIC_FLYING_SPEED,
    @DDeprecated(since = "1.21.3")
    GENERIC_FOLLOW_RANGE,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    GENERIC_GRAVITY,
    @DDeprecated(since = "1.21.3")
    @DRenamed(since = "1.20.5", from = "HORSE_JUMP_STRENGTH")
    GENERIC_JUMP_STRENGTH,
    @DDeprecated(since = "1.21.3")
    GENERIC_KNOCKBACK_RESISTANCE,
    @DDeprecated(since = "1.21.3")
    GENERIC_LUCK,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.2")
    GENERIC_MAX_ABSORPTION,
    @DDeprecated(since = "1.21.3")
    GENERIC_MAX_HEALTH,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    GENERIC_MOVEMENT_EFFICIENCY,
    @DDeprecated(since = "1.21.3")
    GENERIC_MOVEMENT_SPEED,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    GENERIC_OXYGEN_BONUS,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    GENERIC_SAFE_FALL_DISTANCE,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    GENERIC_SCALE,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    GENERIC_STEP_HEIGHT,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21.2")
    GENERIC_TEMPT_RANGE,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    GENERIC_WATER_MOVEMENT_EFFICIENCY,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    PLAYER_BLOCK_BREAK_SPEED,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    PLAYER_BLOCK_INTERACTION_RANGE,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.20.5")
    PLAYER_ENTITY_INTERACTION_RANGE,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    PLAYER_MINING_EFFICIENCY,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    PLAYER_SNEAKING_SPEED,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    PLAYER_SUBMERGED_MINING_SPEED,
    @DDeprecated(since = "1.21.3")
    @DInfo(since = "1.21")
    PLAYER_SWEEPING_DAMAGE_RATIO,
    @DDeprecated(since = "1.21.3")
    ZOMBIE_SPAWN_REINFORCEMENTS,
    @DDeprecated(since = "1.20.5")
    HORSE_JUMP_STRENGTH,
    ;

    DAttribute(String... keys) {
        this.keys = keys;
    }

    private final String[] keys;
    private final Attribute attribute = null;
}
