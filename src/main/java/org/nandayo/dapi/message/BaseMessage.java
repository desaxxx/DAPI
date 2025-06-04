package org.nandayo.dapi.message;

import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@Getter
@SuppressWarnings("unused")
@ApiStatus.Experimental
public abstract class BaseMessage {

    private final @NotNull String path;
    public BaseMessage(@NotNull String path) {
        this.path = path;
    }

    static public final BaseMessage EXAMPLE = new BaseMessage("example") {};
}
