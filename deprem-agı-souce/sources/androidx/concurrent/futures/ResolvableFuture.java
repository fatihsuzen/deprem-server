package androidx.concurrent.futures;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import n0.C1722d;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    private ResolvableFuture() {
    }

    public static <V> ResolvableFuture<V> create() {
        return new ResolvableFuture<>();
    }

    public boolean set(@Nullable V v5) {
        return super.set(v5);
    }

    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    public boolean setFuture(C1722d dVar) {
        return super.setFuture(dVar);
    }
}
