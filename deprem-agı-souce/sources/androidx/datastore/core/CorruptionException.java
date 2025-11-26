package androidx.datastore.core;

import java.io.IOException;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class CorruptionException extends IOException {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CorruptionException(String str, Throwable th, int i5, C2633k kVar) {
        this(str, (i5 & 2) != 0 ? null : th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CorruptionException(String str, Throwable th) {
        super(str, th);
        t.e(str, "message");
    }
}
