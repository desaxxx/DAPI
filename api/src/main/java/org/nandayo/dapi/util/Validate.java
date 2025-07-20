package org.nandayo.dapi.util;

import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.DAPIException;

public class Validate {

    static public void validate(boolean b, @NotNull String errorMessage) {
        if(!b) {
            throw new DAPIException(errorMessage);
        }
    }

    static public void validate(@NotNull ThrowingSupplier<Boolean> supplier, @NotNull String errorMessage, boolean log) {
        try {
            if(!supplier.get()) {
                throw new DAPIException(errorMessage);
            }
        }catch (Exception e) {
            if(log) errorMessage = errorMessage + e;
            throw new DAPIException(errorMessage);
        }
    }

    static public void validate(@NotNull ThrowingSupplier<Boolean> supplier, @NotNull String errorMessage) {
        validate(supplier, errorMessage, false);
    }

    @NotNull
    static public <T> T validateReturn(@NotNull ThrowingSupplier<T> supplier, @NotNull String errorMessage, boolean log) {
        try {
            return supplier.get();
        }catch (Exception e) {
            if(log) errorMessage = errorMessage + e;
            throw new DAPIException(errorMessage);
        }
    }

    @NotNull
    static public <T> T validateReturn(@NotNull ThrowingSupplier<T> supplier, @NotNull String errorMessage) {
        return validateReturn(supplier, errorMessage, false);
    }
}
