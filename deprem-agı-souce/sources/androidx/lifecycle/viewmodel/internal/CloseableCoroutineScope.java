package androidx.lifecycle.viewmodel.internal;

import b3.C2312i;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;
import w3.M;

public final class CloseableCoroutineScope implements AutoCloseable, M {
    private final C2312i coroutineContext;

    public CloseableCoroutineScope(C2312i iVar) {
        t.e(iVar, "coroutineContext");
        this.coroutineContext = iVar;
    }

    public void close() {
        C0.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    public C2312i getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CloseableCoroutineScope(M m5) {
        this(m5.getCoroutineContext());
        t.e(m5, "coroutineScope");
    }
}
