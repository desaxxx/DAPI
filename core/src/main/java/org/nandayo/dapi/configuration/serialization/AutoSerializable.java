package org.nandayo.dapi.configuration.serialization;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.*;
import java.util.*;

/**
 * Interface for auto-serializable objects
 * Automatically serializes all fields marked with @Serialize annotation
 */
@SuppressWarnings("unused")
public interface AutoSerializable extends ConfigurationSerializable {

    @Override
    @NotNull
    default Map<String, Object> serialize() {
        Map<String, Object> map = new LinkedHashMap<>();

        Class<?> clazz = this.getClass();
        while (clazz != null && clazz != Object.class) {
            boolean serializeAllInThisClass = clazz.isAnnotationPresent(Serialize.class);

            for (Field field : clazz.getDeclaredFields()) {
                // Skip static and transient fields
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers)) {
                    continue;
                }

                boolean shouldSerialize = false;
                String customKey = "";
                if (field.isAnnotationPresent(DontSerialize.class)) {
                    // Explicitly excluded
                    continue;
                }

                if (field.isAnnotationPresent(Serialize.class)) {
                    // Explicitly included with @Serialize
                    shouldSerialize = true;
                    Serialize annotation = field.getAnnotation(Serialize.class);
                    customKey = annotation.value();
                } else if (serializeAllInThisClass) {
                    shouldSerialize = true;
                }

                if (shouldSerialize) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(this);
                        String key = !customKey.isEmpty() ? customKey : field.getName();
                        // Serialize the value
                        map.put(key, serializeValue(value));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to serialize field: " + field.getName(), e);
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }

        return map;
    }

    /**
     * Helper method to serialize complex values
     */
    default Object serializeValue(Object value) {
        if (value == null) {
            return null;
        }

        // Handle ConfigurationSerializable objects
        if (value instanceof ConfigurationSerializable) {
            return ((ConfigurationSerializable) value).serialize();
        }

        // Handle Lists
        if (value instanceof List) {
            List<?> list = (List<?>) value;
            List<Object> serializedList = new ArrayList<>();
            for (Object item : list) {
                serializedList.add(serializeValue(item));
            }
            return serializedList;
        }

        // Handle Maps
        if (value instanceof Map) {
            Map<?, ?> originalMap = (Map<?, ?>) value;
            Map<Object, Object> serializedMap = new LinkedHashMap<>();
            for (Map.Entry<?, ?> entry : originalMap.entrySet()) {
                serializedMap.put(entry.getKey(), serializeValue(entry.getValue()));
            }
            return serializedMap;
        }

        // Handle Sets
        if (value instanceof Set) {
            Set<?> set = (Set<?>) value;
            List<Object> serializedList = new ArrayList<>();
            for (Object item : set) {
                serializedList.add(serializeValue(item));
            }
            return serializedList;
        }

        // Return primitive types and strings as-is
        return value;
    }

    /**
     * Deserializes a map back into the object
     * Call this from your constructor that takes Map<String, Object>
     */
    default void loadFromMap(Map<String, Object> map) {

        Class<?> clazz = this.getClass();
        while (clazz != null && clazz != Object.class) {
            boolean serializeAllInThisClass = clazz.isAnnotationPresent(Serialize.class);

            for (Field field : clazz.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers)) {
                    continue;
                }

                boolean shouldDeserialize = false;
                String customKey = "";
                if (field.isAnnotationPresent(DontSerialize.class)) {
                    continue;
                }

                if (field.isAnnotationPresent(Serialize.class)) {
                    shouldDeserialize = true;
                    Serialize annotation = field.getAnnotation(Serialize.class);
                    customKey = annotation.value();
                } else if (serializeAllInThisClass) {
                    shouldDeserialize = true;
                }

                if (shouldDeserialize) {
                    try {
                        field.setAccessible(true);
                        String key = !customKey.isEmpty() ? customKey : field.getName();
                        Object value = map.get(key);

                        if (value != null) {
                            // Deserialize and set the value
                            Object deserializedValue = deserializeValue(value, field.getType(), field.getGenericType());
                            field.set(this, deserializedValue);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to deserialize field: " + field.getName(), e);
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    /**
     * Helper method to deserialize complex values
     */
    default Object deserializeValue(Object value, Class<?> targetType, Type genericType) {
        if (value == null) {
            return null;
        }

        // Handle ConfigurationSerializable objects
        if (ConfigurationSerializable.class.isAssignableFrom(targetType)) {
            if (value instanceof Map) {
                try {
                    Method deserializeMethod = targetType.getMethod("deserialize", Map.class);
                    return deserializeMethod.invoke(null, value);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to deserialize ConfigurationSerializable: " + targetType.getName(), e);
                }
            }
        }

        // Handle Lists
        if (List.class.isAssignableFrom(targetType) && genericType instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) genericType;
            Type elementType = paramType.getActualTypeArguments()[0];

            if (value instanceof List) {
                List<?> list = (List<?>) value;
                List<Object> deserializedList = new ArrayList<>();
                for (Object item : list) {
                    deserializedList.add(deserializeValue(item, (Class<?>) elementType, elementType));
                }
                return deserializedList;
            }
        }

        // Handle Maps
        if (Map.class.isAssignableFrom(targetType) && genericType instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) genericType;
            Type valueType = paramType.getActualTypeArguments()[1];

            if (value instanceof Map) {
                Map<?, ?> originalMap = (Map<?, ?>) value;
                Map<Object, Object> deserializedMap = new LinkedHashMap<>();
                for (Map.Entry<?, ?> entry : originalMap.entrySet()) {
                    deserializedMap.put(entry.getKey(),
                            deserializeValue(entry.getValue(), (Class<?>) valueType, valueType));
                }
                return deserializedMap;
            }
        }

        // Return as-is for primitive types
        return value;
    }


    /**
     * Register the class to {@link ConfigurationSerialization}.
     */
    default void registerObject() {
        ConfigurationSerialization.registerClass(getClass());
    }
}