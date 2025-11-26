package androidx.lifecycle.viewmodel.internal;

import k3.C2616a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

public final class SynchronizedObjectKt {
    /* renamed from: synchronized  reason: not valid java name */
    public static final <T> T m63synchronized(SynchronizedObject synchronizedObject, C2616a aVar) {
        T invoke;
        t.e(synchronizedObject, "lock");
        t.e(aVar, "action");
        synchronized (synchronizedObject) {
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
