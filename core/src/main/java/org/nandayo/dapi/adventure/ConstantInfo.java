package org.nandayo.dapi.adventure;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

interface ConstantInfo extends Comparable<ConstantInfo> {

    @NotNull String sinceVersion();
    @NotNull String key();

    @Nullable ConstantInfo parent();

    @Nullable KeyChange keyChange();

    @Nullable KeyRemoval keyRemoval();

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

    static List<ConstantInfo> find(Node node, List<ConstantInfo> constants) {
        return constants.stream()
                .filter(constant -> constant.matches(node))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
