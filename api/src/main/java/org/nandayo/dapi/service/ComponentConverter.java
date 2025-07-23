package org.nandayo.dapi.service;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

import java.lang.reflect.Method;

public class ComponentConverter {

    public static Object toServerComponent(Component shadedComponent) {
        try {
            // Serialize to String using shaded GsonComponentSerializer
            String json = GsonComponentSerializer.gson().serialize(shadedComponent);

            // Get the server's GsonComponentSerializer class
            Class<?> gsonSerializerClass = Class.forName("net.kyori.adventure.text.serializer.gson.GsonComponentSerializer");

            // Call gson() to get the instance of the class
            Object gsonSerializer = gsonSerializerClass.getMethod("gson").invoke(null);

            // Find the deserialize method
            Method deserializerMethod = gsonSerializerClass.getMethod("deserialize", String.class);

            return deserializerMethod.invoke(gsonSerializer, json);
        } catch (Exception e) {
            throw new RuntimeException("Could not convert shaded component", e);
        }
    }
}