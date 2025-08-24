package org.nandayo.dapi.adventure;

import org.jetbrains.annotations.NotNull;

interface KeyChange {

    @NotNull String deprecatedKey();
    @NotNull String newKey();
}
