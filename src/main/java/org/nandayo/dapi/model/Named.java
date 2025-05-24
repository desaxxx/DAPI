package org.nandayo.dapi.model;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@SuppressWarnings("unused")
public abstract class Named {

    private final @NotNull String id;
    private final @NotNull String name;

    public Named(@NotNull String id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }
}
