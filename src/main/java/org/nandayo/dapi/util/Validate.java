package org.nandayo.dapi.util;

import org.jetbrains.annotations.NotNull;

public class Validate {

    public static void validate(boolean b, @NotNull String errorMessage) {
        if(!b) {
            throw new DAPIException(errorMessage);
        }
    }

    public static void validate(@NotNull ThrowingSupplier<Boolean> supplier, @NotNull String errorMessage, boolean log) {
        try {
            if(!supplier.get()) {
                throw new DAPIException(errorMessage);
            }
        }catch (Exception e) {
            if(log) errorMessage = errorMessage + e;
            throw new DAPIException(errorMessage);
        }
    }

    public static void validate(@NotNull ThrowingSupplier<Boolean> supplier, @NotNull String errorMessage) {
        validate(supplier, errorMessage, false);
    }

    @NotNull
    public static <T> T validateReturn(@NotNull ThrowingSupplier<T> supplier, @NotNull String errorMessage, boolean log) {
        try {
            return supplier.get();
        }catch (Exception e) {
            if(log) errorMessage = errorMessage + e;
            throw new DAPIException(errorMessage);
        }
    }

    @NotNull
    public static <T> T validateReturn(@NotNull ThrowingSupplier<T> supplier, @NotNull String errorMessage) {
        return validateReturn(supplier, errorMessage, false);
    }


    @NotNull
    public static <T> T notNull(T object, @NotNull String errorMessage) {
        if(object == null) {
            throw new DAPIException(errorMessage);
        }
        return object;
    }
}
