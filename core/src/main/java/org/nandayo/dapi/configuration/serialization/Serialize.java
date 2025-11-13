package org.nandayo.dapi.configuration.serialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark classes or fields for serialization
 * - On CLASS: All fields are serialized by default
 * - On FIELD: Only that specific field is serialized (with optional custom key)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Serialize {
    /**
     * Custom key name for serialization (optional, defaults to field name)
     * Only used when applied to fields
     */
    String value() default "";
}