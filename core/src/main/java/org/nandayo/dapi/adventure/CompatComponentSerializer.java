package org.nandayo.dapi.adventure;

import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.DAPIException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @since 1.4.0
 */
@SuppressWarnings("unused")
@ApiStatus.Experimental
public class CompatComponentSerializer {

    @NotNull
    public static CompatComponentSerializer newInstance(Class<?> gsonComponentSerializerClass) {
        return new CompatComponentSerializer(gsonComponentSerializerClass);
    }

    @Getter
    private final String adventureVersion;

    private final Class<?> componentClass;
    private final Object gsonInstance;
    private final Object jsonParserInstance;
    private final Method serializeMethod;
    private final Method deserializeMethod;
    private final Method parseStringMethod;

    private CompatComponentSerializer(Class<?> gsonComponentSerializerClass) {
        this.adventureVersion = gsonComponentSerializerClass.getPackage().getImplementationVersion();
        try {
            Method gsonMethod = gsonComponentSerializerClass.getDeclaredMethod("gson");
            gsonMethod.setAccessible(true);
            this.gsonInstance = gsonMethod.invoke(null);

            Method foundSerialize = null;
            Method foundDeserialize = null;
            Method foundParseString = null;
            Class<?> foundComponent = null;
            Class<?> foundJsonElement;
            Object foundJsonParserInstance = null;

            for (Method m : gsonComponentSerializerClass.getDeclaredMethods()) {
                Class<?>[] params = m.getParameterTypes();
                if (m.getName().equals("serializeToTree") && params.length == 1) {
                    foundSerialize = m;
                    foundComponent = params[0];
                } else if (m.getName().equals("deserializeFromTree") && params.length == 1) {
                    foundDeserialize = m;
                    foundJsonElement = params[0];

                    Class<?> jsonParser = null;
                    try {
                        jsonParser = Class.forName(foundJsonElement.getPackageName() + ".JsonParser");
                        foundJsonParserInstance = jsonParser.getConstructor().newInstance();
                        foundParseString = jsonParser.getDeclaredMethod("parse", String.class);
                    } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException e) {
                        throw new DAPIException("Failed to find parse method in " + jsonParser);
                    }
                }
            }

            if (foundSerialize == null || foundDeserialize == null) {
                throw new DAPIException("Failed to find serialize/deserialize methods in " + gsonComponentSerializerClass);
            }

            foundSerialize.setAccessible(true);
            foundDeserialize.setAccessible(true);
            foundParseString.setAccessible(true);

            this.jsonParserInstance = foundJsonParserInstance;
            this.serializeMethod = foundSerialize;
            this.deserializeMethod = foundDeserialize;
            this.parseStringMethod = foundParseString;
            this.componentClass = foundComponent;

        } catch (NoSuchMethodException e) {
            throw new DAPIException("Failed to find gson() method in " + gsonComponentSerializerClass + ". " + e);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new DAPIException("Failed to invoke gson() method in " + gsonComponentSerializerClass + ". " + e);
        }
    }


    /**
     * Serialize a Component object to a String.
     * @param component Component from {@link #componentClass}.
     * @return Json String
     * @since 1.4.0
     */
    public String serialize(Object component) {
        try {
            return serializeMethod.invoke(gsonInstance, component).toString();
        } catch (IllegalAccessException | InvocationTargetException  e) {
            throw new DAPIException("Failed to serialize the Component to a String. " + e);
        }
    }

    /**
     * Deserialize a String to a Component.
     * @param jsonString Json String
     * @return Component from {@link #componentClass}
     * @since 1.4.0
     */
    public Object deserialize(String jsonString) {
        try {
            Object jsonElement = parseStringMethod.invoke(jsonParserInstance, jsonString);
            return deserializeMethod.invoke(gsonInstance, jsonElement);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new DAPIException("Failed to deserialize the JsonElement to a Component. " + e);
        }
    }
}
