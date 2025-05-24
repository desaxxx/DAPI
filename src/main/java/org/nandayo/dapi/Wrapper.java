package org.nandayo.dapi;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;

public class Wrapper {

    public Wrapper() {
        this.minecraftVersion = fetchVersion();
        setupArmorAttributeModifier();
    }

    private final int minecraftVersion;

    private int fetchVersion() {
        String[] ver = Bukkit.getBukkitVersion().split("-")[0].split("\\.");
        if(ver.length < 2) {
            Util.log("{WARN}DAPI: Could not fetch server version!");
            return 165;
        }
        int major = 0;
        try {
            major = Integer.parseInt(ver[1]);
        } catch (NumberFormatException ignored) {}
        int minor = 0;
        if(ver.length >= 3) {
            try {
                minor = Integer.parseInt(ver[2]);
            } catch (NumberFormatException ignored) {}
        }

        return major * 10 + minor;
    }

    @Getter
    private @Nullable Attribute attribute;
    @Getter
    private @Nullable AttributeModifier attributeModifier;

    /**
     * Adding an attribute is necessary to use ItemFlag.HIDE_ATTRIBUTES as of <b>MC 1.20.6</b>.<br>
     * Attribute class change -> 1.21.3<br>
     * AttributeModifier change -> 1.21<br>
     * EquipmentSlotGroup addition -> 1.20.5
     */
    @SuppressWarnings({"unchecked", "rawtypes", "UnstableApiUsage"})
    public void setupArmorAttributeModifier() {
        if(minecraftVersion >= 213) {
            this.attribute = Attribute.ARMOR;
            this.attributeModifier = new AttributeModifier(new NamespacedKey("dapi", "foo"), 0, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.ANY);
        }
        else if(minecraftVersion >= 210) {
            // Armor attribute
            Attribute armorAttribute = null;
            try {
                Class<?> attributeClass = Class.forName("org.bukkit.attribute.Attribute");
                armorAttribute = (Attribute) Enum.valueOf((Class<Enum>) attributeClass, "GENERIC_ARMOR");
            }catch (ClassNotFoundException ignored) {}

            this.attribute = armorAttribute;
            this.attributeModifier = new AttributeModifier(new NamespacedKey("dapi", "foo"),0, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.ANY);
        }
        else {
            // Armor attribute
            Attribute armorAttribute = null;
            try {
                Class<?> attributeClass = Class.forName("org.bukkit.attribute.Attribute");
                armorAttribute = (Attribute) Enum.valueOf((Class<Enum>) attributeClass, "GENERIC_ARMOR");
            }catch (Exception ignored) {}

            this.attribute = armorAttribute;

            AttributeModifier attributeModifier = null;
            try {
                Class<?> modifierClass = Class.forName("org.bukkit.attribute.AttributeModifier");
                Class<?> operationClass = Class.forName("org.bukkit.attribute.AttributeModifier$Operation");
                Object operation = Enum.valueOf((Class<Enum>) operationClass, "MULTIPLY_SCALAR_1");
                Constructor<?> constructor = modifierClass.getConstructor(String.class, double.class, operationClass);
                attributeModifier = (AttributeModifier) constructor.newInstance("foo", 0.0, operation);
            } catch (Exception ignored) {}

            this.attributeModifier = attributeModifier;
        }
    }

    /**
     * Creating a version-compat PotionMeta.<br>
     * setBasePotionType(NotNull) -> 1.20.2<br>
     * setBasePotionType(Nullable) -> 1.20.5<br>
     * setDurationScale() -> 1.21.5
     * @param meta PotionMeta
     * @param potionType PotionType
     * @param scale Float
     * @param color Color
     */
    @SuppressWarnings({"deprecation", "removal"})
    public void editPotionMeta(@NotNull PotionMeta meta, @Nullable PotionType potionType, @Nullable Float scale, @Nullable Color color) {
        if(minecraftVersion >= 215) {
            meta.setBasePotionType(potionType);
            if(meta.hasDurationScale()) meta.setDurationScale(scale);
        }
        else if (minecraftVersion >= 205) {
            meta.setBasePotionType(potionType);
        }
        else if(minecraftVersion >= 202) {
            if(potionType != null) meta.setBasePotionType(potionType);
        }
        else {
            if(potionType != null) meta.setBasePotionData(new PotionData(potionType));
        }
        meta.setColor(color);
    }
}
