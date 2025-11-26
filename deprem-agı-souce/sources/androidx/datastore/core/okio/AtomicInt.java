package androidx.datastore.core.okio;

import java.util.concurrent.atomic.AtomicInteger;

public final class AtomicInt {
    private final AtomicInteger delegate;

    public AtomicInt(int i5) {
        this.delegate = new AtomicInteger(i5);
    }

    public final int decrementAndGet() {
        return this.delegate.decrementAndGet();
    }

    public final int get() {
        return this.delegate.get();
    }

    public final int getAndIncrement() {
        return this.delegate.getAndIncrement();
    }

    public final int incrementAndGet() {
        return this.delegate.incrementAndGet();
    }
}
