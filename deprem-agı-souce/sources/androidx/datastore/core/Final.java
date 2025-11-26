package androidx.datastore.core;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class Final<T> extends State<T> {
    private final Throwable finalException;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Final(Throwable th) {
        super(Integer.MAX_VALUE, (C2633k) null);
        t.e(th, "finalException");
        this.finalException = th;
    }

    public final Throwable getFinalException() {
        return this.finalException;
    }
}
