package org.nandayo.dapi.object;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * @since 1.5.3
 */
public interface ObjectWrapper<T> {

    T parse();

    @NotNull Optional<T> parseOptional();

    default boolean isPresent() {
        return parseOptional().isPresent();
    }

    default T orElse(T defaultValue) {
        return parseOptional().orElse(defaultValue);
    }

    default ObjectWrapper<T> or(ObjectWrapper<T> fallback) {
        return parseOptional().isPresent() ? this : fallback;
    }
}
