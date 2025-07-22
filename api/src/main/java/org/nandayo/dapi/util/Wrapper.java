package org.nandayo.dapi.util;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.util.Locale;

@SuppressWarnings("unused")
public class Wrapper {

    static private int minecraftVersion = -1;

    static public int getMinecraftVersion() {
        if(minecraftVersion != -1) return minecraftVersion;
        return minecraftVersion = fetchVersion();
    }

    static private int fetchVersion() {
        String[] ver = Bukkit.getBukkitVersion().split("-")[0].split("\\.");
        if(ver.length < 2) {
            Util.logInternal("Could not fetch server version!");
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

    static private Attribute armorAttribute;
    static private AttributeModifier attributeModifier;

    static public Attribute getArmorAttribute() {
        if(armorAttribute != null) return armorAttribute;
        setupArmorAttributeModifier();
        return armorAttribute;
    }
    static public AttributeModifier getArmorAttributeModifier() {
        if(attributeModifier != null) return attributeModifier;
        setupArmorAttributeModifier();
        return attributeModifier;
    }

    /**
     * Adding an attribute is necessary to use ItemFlag.HIDE_ATTRIBUTES as of <b>MC 1.20.6</b>.<br>
     * Attribute class change -> 1.21.3<br>
     * AttributeModifier change -> 1.21<br>
     * EquipmentSlotGroup addition -> 1.20.5
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    static private void setupArmorAttributeModifier() {
        if(minecraftVersion >= 213) {
            armorAttribute = Attribute.ARMOR;
            attributeModifier = new AttributeModifier(new NamespacedKey("dapi", "foo"), 0, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.ANY);
        }
        else if(minecraftVersion >= 210) {
            try {
                Class<?> attributeClass = Class.forName("org.bukkit.attribute.Attribute");
                armorAttribute = (Attribute) Enum.valueOf((Class<Enum>) attributeClass, "GENERIC_ARMOR");
            }catch (ClassNotFoundException ignored) {}

            attributeModifier = new AttributeModifier(new NamespacedKey("dapi", "foo"),0, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.ANY);
        }
        else {
            try {
                Class<?> attributeClass = Class.forName("org.bukkit.attribute.Attribute");
                armorAttribute = (Attribute) Enum.valueOf((Class<Enum>) attributeClass, "GENERIC_ARMOR");
            }catch (Exception ignored) {}

            try {
                Class<?> modifierClass = Class.forName("org.bukkit.attribute.AttributeModifier");
                Class<?> operationClass = Class.forName("org.bukkit.attribute.AttributeModifier$Operation");
                Object operation = Enum.valueOf((Class<Enum>) operationClass, "MULTIPLY_SCALAR_1");
                Constructor<?> constructor = modifierClass.getConstructor(String.class, double.class, operationClass);
                attributeModifier = (AttributeModifier) constructor.newInstance("foo", 0.0, operation);
            } catch (Exception ignored) {}
        }
    }

    /**
     * Creating a version-compat PotionMeta.<br>
     * setBasePotionType(NotNull) -> 1.20.2<br>
     * setBasePotionType(Nullable) -> 1.20.5<br>
     * setDurationScale() -> 1.21.5 spigot only so removing it...
     * @param meta PotionMeta
     * @param potionType PotionType
     * @param color Color
     */
    @SuppressWarnings({"removal"})
    static public void editPotionMeta(@NotNull PotionMeta meta, @Nullable PotionType potionType, @Nullable Color color) {
        if (minecraftVersion >= 205) {
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

    /**
     * Get the sound from given key. Only works for minecraft sounds.<br>
     * MC 1.16.4+ : Using Registry.SOUNDS<br>
     * MC 1.16.1-1.16.3 : Sound class was an enum, so accessing the requested field with reflection.
     * @param key Key of the sound
     * @return Sound if found, else {@code null}.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    static public Sound getSound(@NotNull String key) {
        if(minecraftVersion >= 164) {
            return Registry.SOUNDS.get(NamespacedKey.minecraft(key));
        }
        else {
            try {
                return (Sound) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Sound"), key.replace(".","_").toUpperCase(Locale.ENGLISH));
            } catch (Exception ignored) {}
        }
        return null;
    }
}
