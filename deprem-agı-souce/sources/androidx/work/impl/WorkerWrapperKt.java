package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.DirectExecutor;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2886n;

public final class WorkerWrapperKt {
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkerWrapper");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> Object awaitWithin(C1722d dVar, ListenableWorker listenableWorker, C2308e eVar) {
        try {
            if (dVar.isDone()) {
                return getUninterruptibly(dVar);
            }
            C2886n nVar = new C2886n(C2316b.c(eVar), 1);
            nVar.D();
            dVar.addListener(new ToContinuation(dVar, nVar), DirectExecutor.INSTANCE);
            nVar.g(new WorkerWrapperKt$awaitWithin$2$1(listenableWorker, dVar));
            Object x4 = nVar.x();
            if (x4 == C2316b.f()) {
                h.c(eVar);
            }
            return x4;
        } catch (ExecutionException e5) {
            throw nonNullCause(e5);
        }
    }

    /* access modifiers changed from: private */
    public static final <V> V getUninterruptibly(Future<V> future) {
        V v5;
        boolean z4 = false;
        while (true) {
            try {
                v5 = future.get();
                break;
            } catch (InterruptedException unused) {
                z4 = true;
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        return v5;
    }

    /* access modifiers changed from: private */
    public static final Throwable nonNullCause(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        t.b(cause);
        return cause;
    }
}
