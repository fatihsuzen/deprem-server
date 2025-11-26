package androidx.datastore.core.okio;

public final class AtomicBoolean {
    private final java.util.concurrent.atomic.AtomicBoolean delegate;

    public AtomicBoolean(boolean z4) {
        this.delegate = new java.util.concurrent.atomic.AtomicBoolean(z4);
    }

    public final boolean get() {
        return this.delegate.get();
    }

    public final void set(boolean z4) {
        this.delegate.set(z4);
    }
}
