package androidx.lifecycle;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AtomicReference<V> {
    private final java.util.concurrent.atomic.AtomicReference<V> base;

    public AtomicReference(V v5) {
        this.base = new java.util.concurrent.atomic.AtomicReference<>(v5);
    }

    public final boolean compareAndSet(V v5, V v6) {
        return a.a(this.base, v5, v6);
    }

    public final V get() {
        return this.base.get();
    }
}
