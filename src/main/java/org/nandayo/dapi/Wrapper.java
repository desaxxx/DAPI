package org.nandayo.dapi;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;

public class Wrapper {

    public Wrapper() {
        this.version = fetchVersion();
    }

    private final int version;

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

    /**
     * Adding an attribute is necessary to use ItemFlag.HIDE_ATTRIBUTES as of <b>MC 1.20.6</b>.<br>
     * Attribute class change -> 1.21.3<br>
     * AttributeModifier change -> 1.21<br>
     * EquipmentSlotGroup addition -> 1.20.5
     *
     * @param meta ItemMeta
     */
    @SuppressWarnings({"unchecked", "rawtypes", "UnstableApiUsage"})
    public void addArmorAttribute(@NotNull ItemMeta meta) {
        if(version >= 213) {
            meta.addAttributeModifier(Attribute.ARMOR, new AttributeModifier(new NamespacedKey("dapi", "foo"),0, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.ANY));
        }
        else if(version >= 210) {
            // Armor attribute
            Attribute armorAttribute = null;
            try {
                Class<?> attributeClass = Class.forName("org.bukkit.attribute.Attribute");
                armorAttribute = (Attribute) Enum.valueOf((Class<Enum>) attributeClass, "GENERIC_ARMOR");
            }catch (ClassNotFoundException ignored) {}

            if(armorAttribute != null) {
                meta.addAttributeModifier(armorAttribute, new AttributeModifier(new NamespacedKey("dapi", "foo"),0, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.ANY));
            }
        }
        else {
            // Armor attribute
            Attribute armorAttribute = null;
            try {
                Class<?> attributeClass = Class.forName("org.bukkit.attribute.Attribute");
                armorAttribute = (Attribute) Enum.valueOf((Class<Enum>) attributeClass, "GENERIC_ARMOR");
            }catch (Exception ignored) {}

            AttributeModifier attributeModifier = null;
            try {
                Class<?> modifierClass = Class.forName("org.bukkit.attribute.AttributeModifier");
                Class<?> operationClass = Class.forName("org.bukkit.attribute.AttributeModifier$Operation");
                Object operation = Enum.valueOf((Class<Enum>) operationClass, "MULTIPLY_SCALAR_1");
                Constructor<?> constructor = modifierClass.getConstructor(String.class, double.class, operationClass);
                attributeModifier = (AttributeModifier) constructor.newInstance("foo", 0.0, operation);
            } catch (Exception ignored) {}

            if(armorAttribute != null && attributeModifier != null) {
                meta.addAttributeModifier(armorAttribute, attributeModifier);
            }
        }
    }
}
