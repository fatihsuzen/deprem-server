package androidx.datastore.core;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class ReadException<T> extends State<T> {
    private final Throwable readException;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReadException(Throwable th, int i5) {
        super(i5, (C2633k) null);
        t.e(th, "readException");
        this.readException = th;
    }

    public final Throwable getReadException() {
        return this.readException;
    }
}
