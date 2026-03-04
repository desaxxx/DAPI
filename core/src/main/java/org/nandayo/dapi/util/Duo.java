package org.nandayo.dapi.util;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@SuppressWarnings("unused")
public class Duo<T> {

    private T first;
    private T second;
    public Duo(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getNext(T value) {
        return value == null ? null : value.equals(first) ? second : (value.equals(second) ? first : null);
    }

    public T getOpposite(T value) {
        return value == null ? null : value.equals(first) ? second : (value.equals(second) ? first : null);
    }

    public T @NotNull [] toArray(T@NotNull  [] array) {
        array[0] = first;
        array[1] = second;
        return array;
    }
}
