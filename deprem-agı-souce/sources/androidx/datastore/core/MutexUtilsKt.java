package androidx.datastore.core;

import F3.a;
import k3.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

public final class MutexUtilsKt {
    public static final <R> R withTryLock(a aVar, Object obj, l lVar) {
        t.e(aVar, "<this>");
        t.e(lVar, "block");
        boolean tryLock = aVar.tryLock(obj);
        try {
            return lVar.invoke(Boolean.valueOf(tryLock));
        } finally {
            r.b(1);
            if (tryLock) {
                aVar.unlock(obj);
            }
            r.a(1);
        }
    }

    public static /* synthetic */ Object withTryLock$default(a aVar, Object obj, l lVar, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            obj = null;
        }
        t.e(aVar, "<this>");
        t.e(lVar, "block");
        boolean tryLock = aVar.tryLock(obj);
        try {
            return lVar.invoke(Boolean.valueOf(tryLock));
        } finally {
            r.b(1);
            if (tryLock) {
                aVar.unlock(obj);
            }
            r.a(1);
        }
    }
}
