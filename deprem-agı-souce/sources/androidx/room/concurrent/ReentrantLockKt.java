package androidx.room.concurrent;

import java.util.concurrent.locks.ReentrantLock;
import k3.C2616a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

public final class ReentrantLockKt {
    public static final <T> T withLock(ReentrantLock reentrantLock, C2616a aVar) {
        t.e(reentrantLock, "<this>");
        t.e(aVar, "block");
        reentrantLock.lock();
        try {
            return aVar.invoke();
        } finally {
            r.b(1);
            reentrantLock.unlock();
            r.a(1);
        }
    }
}
