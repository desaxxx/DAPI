package org.nandayo.dapi.task;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class Completable {

    private boolean completed;
    private Runnable onCompleteCallback = null;

    public Completable(boolean completed) {
        this.completed = completed;
    }
    public Completable() {
        this(false);
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        if (isCompleted()) {
            return;
        }
        this.completed = true;

        if (onCompleteCallback != null) {
            onCompleteCallback.run();
        }
    }


    private void onComplete(Runnable runnable) {
        if (this.completed) {
            runnable.run();
        } else {
            this.onCompleteCallback = runnable;
        }
    }

    public Completable then(Supplier<Completable> nextTaskSupplier) {
        Completable nextLink = new Completable();

        onComplete(() -> {
            Completable nextTask = nextTaskSupplier.get();
            nextTask.onComplete(nextLink::complete);
        });
        return nextLink;
    }

    public Completable thenRun(Runnable runnable) {
        return then(() -> {
            runnable.run();
            return new Completable(true);
        });
    }


    public static Completable incomplete() {
        return new Completable();
    }
}