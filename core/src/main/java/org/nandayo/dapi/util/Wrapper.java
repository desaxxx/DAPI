package org.nandayo.dapi.util;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Locale;

@SuppressWarnings("unused")
public class Wrapper {

    private static int minecraftVersion = -1;

    public static int getMinecraftVersion() {
        if(minecraftVersion != -1) return minecraftVersion;
        return minecraftVersion = fetchVersion();
    }

    private static int fetchVersion() {
        String ver = Bukkit.getBukkitVersion().split("-")[0];
        // 1.21.10  -> 21.10    -> 2110
        // 1.19     -> 19       -> 1900
        return VersionUtil.intify(ver.substring(2), 2);
    }

    private static Attribute armorAttribute;
    private static AttributeModifier attributeModifier;

    public static Attribute getArmorAttribute() {
        if(armorAttribute != null) return armorAttribute;
        setupArmorAttributeModifier();
        return armorAttribute;
    }
    public static AttributeModifier getArmorAttributeModifier() {
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
    private static void setupArmorAttributeModifier() {
        int MC = fetchVersion();
        if(MC >= 2103) {
            armorAttribute = Attribute.ARMOR;
            attributeModifier = new AttributeModifier(new NamespacedKey("dapi", "foo"), 0, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.ANY);
        }
        else if(MC >= 2100) {
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
     * setDurationScale() -> 1.21.5 spigot only so removing it...
     * PotionData is marked forRemoval in Paper -> 1.20.6<br>
     * setBasePotionType(Nullable) -> 1.20.5<br>
     * setBasePotionType(NotNull) -> 1.20.2<br>
     * @param meta PotionMeta
     * @param potionType PotionType
     * @param color Color
     */
    public static void editPotionMeta(@NotNull PotionMeta meta, @Nullable PotionType potionType, @Nullable Color color) {
        int MC = fetchVersion();
        if (MC >= 2005) {
            meta.setBasePotionType(potionType);
        }
        else if(MC >= 2002) {
            if(potionType != null) meta.setBasePotionType(potionType);
        }
        else {
            if(potionType != null) {
                try {
                    Class<?> potionDataClass = Class.forName("org.bukkit.potion.PotionData");
                    Object potionData = potionDataClass.getConstructor(PotionType.class).newInstance(potionType);

                    Method setBasePotionDataMethod = meta.getClass().getMethod("setBasePotionData", potionDataClass);
                    //noinspection JavaReflectionInvocation
                    setBasePotionDataMethod.invoke(meta, potionData);
                } catch (Exception ignored) {}
            }
            // PotionData is marked forRemoval.
            //if (potionType != null) meta.setBasePotionData(new PotionData(potionType));
        }
        meta.setColor(color);
    }

    /**
     * Get the sound from given key. Only works for minecraft sounds.<br>
     * MC 1.16.4+ : Using {@link Registry#SOUNDS}<br>
     * MC 1.16.1-1.16.3 : Sound class was an enum, so accessing the requested field with reflection.
     * @param key Key of the sound
     * @return Sound if found, else {@code null}.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Sound getSound(@NotNull String key) {
        if(fetchVersion() >= 1604) {
            return Registry.SOUNDS.get(NamespacedKey.minecraft(key));
        }
        else {
            try { // TODO: I don't think this works as wanted.
                return (Sound) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Sound"), key.replace(".","_").toUpperCase(Locale.ENGLISH));
            } catch (Exception ignored) {}
        }
        return null;
    }
}
