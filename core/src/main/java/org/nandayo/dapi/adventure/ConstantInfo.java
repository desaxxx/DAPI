package org.nandayo.dapi.adventure;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;

interface ConstantInfo extends Comparable<ConstantInfo> {

    @NotNull String sinceVersion();
    @Nullable String key();

    @Nullable ConstantInfo parent();
    @Nullable String deprecatedKey();

    boolean moveIn();
    @Nullable Set<ConstantInfo> childrenToMove();

    @Nullable Depends depends();

    @Nullable <T,R> Function<T, R> valueFunction();

    boolean matches(Node someNode);


    @Override
    default int compareTo(@NotNull ConstantInfo o) {
        return sinceVersion().compareTo(o.sinceVersion());
    }






    static ConstantInfo imitate(ConstantInfo parent, String key) {
        return new ConstantInfoImpl.Builder<>()
                .parent(parent)
                .key(key)
                .build();
    }

    static Optional<ConstantInfo> find(Node node, Collection<ConstantInfo> constants) {
        return constants.stream()
                .filter(constant -> constant.matches(node))
                .findFirst();
    }
}
