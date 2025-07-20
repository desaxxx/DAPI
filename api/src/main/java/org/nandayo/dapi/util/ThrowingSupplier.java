package org.nandayo.dapi.util;

@FunctionalInterface
public interface ThrowingSupplier<T> {
    T get() throws Exception;
}
