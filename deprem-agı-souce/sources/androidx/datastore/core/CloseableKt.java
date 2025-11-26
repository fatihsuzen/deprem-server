package androidx.datastore.core;

import W2.C2216e;
import k3.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

public final class CloseableKt {
    public static final <T extends Closeable, R> R use(T t5, l lVar) {
        t.e(t5, "<this>");
        t.e(lVar, "block");
        try {
            R invoke = lVar.invoke(t5);
            r.b(1);
            try {
                t5.close();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            if (th == null) {
                r.a(1);
                return invoke;
            }
            throw th;
        } catch (Throwable th2) {
            C2216e.a(th, th2);
        }
        throw th;
    }
}
