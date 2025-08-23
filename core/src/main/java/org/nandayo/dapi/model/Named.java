package org.nandayo.dapi.model;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public interface Named {

    @NotNull String id();
    @NotNull String name();
}
