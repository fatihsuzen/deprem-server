package androidx.room.concurrent;

import k3.C2616a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

public final class Synchronized_jvmAndroidKt {
    /* renamed from: synchronized  reason: not valid java name */
    public static final <T> T m65synchronized(Object obj, C2616a aVar) {
        T invoke;
        t.e(obj, "lock");
        t.e(aVar, "block");
        synchronized (obj) {
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
