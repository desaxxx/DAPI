package org.nandayo.dapi.task;

import com.google.common.base.Preconditions;

import java.util.function.Consumer;

/**
 * @since 1.5.1
 * @param <T>
 */
@SuppressWarnings("unused")
public class OnceConsumer<T> {

    private final Consumer<T> delegate;
    private boolean accepted = false;
    public OnceConsumer(Consumer<T> delegate) {
        Preconditions.checkNotNull(delegate, "Delegate is null.");
        this.delegate = delegate;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void accept(T t) {
        if(this.accepted) return;

        this.accepted = true;
        this.delegate.accept(t);
    }
}
