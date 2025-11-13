package org.nandayo.dapi.util;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("unused")
public final class Instances {
    private static final Map<Class<?>, Object> INSTANCE_MAP = new HashMap<>();

    public static void register(Object instance, boolean force) {
        if(!force && get(instance.getClass()) != null) {
            throw new IllegalStateException("Instance already registered!");
        }
        INSTANCE_MAP.put(instance.getClass(), instance);
    }

    public static void register(Object instance) {
        register(instance, false);
    }

    public static void unregister(Class<?> clazz) {
        INSTANCE_MAP.remove(clazz);
    }

    public static void unregister(Object instance) {
        INSTANCE_MAP.remove(instance.getClass());
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> clazz) {
        return (T) INSTANCE_MAP.get(clazz);
    }

    @NotNull
    public static <T> Optional<T> getOpt(Class<T> clazz) {
        return Optional.ofNullable(get(clazz));
    }
}
