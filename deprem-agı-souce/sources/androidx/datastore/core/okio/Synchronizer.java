package androidx.datastore.core.okio;

import k3.C2616a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

public final class Synchronizer {
    public final <T> T withLock(C2616a aVar) {
        T invoke;
        t.e(aVar, "block");
        synchronized (this) {
            try {
                invoke = aVar.invoke();
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        return invoke;
    }
}
