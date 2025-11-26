package androidx.work.impl.utils.futures;

import androidx.annotation.RestrictTo;
import n0.C1722d;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SettableFuture<V> extends AbstractFuture<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> create() {
        return new SettableFuture<>();
    }

    public boolean set(V v5) {
        return super.set(v5);
    }

    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    public boolean setFuture(C1722d dVar) {
        return super.setFuture(dVar);
    }
}
