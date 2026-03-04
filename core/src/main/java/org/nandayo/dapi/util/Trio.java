package org.nandayo.dapi.util;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@SuppressWarnings("unused")
public class Trio<T> {

    private T first;
    private T second;
    private T third;
    public Trio(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getNext(T value) {
        return value == null ? null : value.equals(first) ? second : (value.equals(second) ? third : (value.equals(third) ? first : null));
    }

    public T @NotNull [] toArray(T @NotNull [] array) {
        array[0] = first;
        array[1] = second;
        array[2] = third;
        return array;
    }
}
