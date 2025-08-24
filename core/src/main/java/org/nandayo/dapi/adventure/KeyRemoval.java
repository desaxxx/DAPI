package org.nandayo.dapi.adventure;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

interface KeyRemoval {

    @NotNull String deprecatedKey();
    boolean moveIn();
    @NotNull Set<ConstantInfo> childrenToMove();
}
