package androidx.room.concurrent;

import b3.C2312i;
import kotlin.jvm.internal.t;
import w3.V0;

public final class ThreadLocal_jvmAndroidKt {
    public static /* synthetic */ void ThreadLocal$annotations() {
    }

    public static final <T> C2312i.b asContextElement(ThreadLocal<T> threadLocal, T t5) {
        t.e(threadLocal, "<this>");
        return V0.a(threadLocal, t5);
    }

    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }
}
