package androidx.work;

import b3.C2309f;
import b3.C2312i;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.t;
import w3.C2894r0;
import w3.I;

public final class ConfigurationKt {
    public static final int DEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT = 8;

    /* access modifiers changed from: private */
    public static final Executor asExecutor(C2312i iVar) {
        C2309f fVar;
        I i5;
        if (iVar != null) {
            fVar = (C2309f) iVar.get(C2309f.f20792a0);
        } else {
            fVar = null;
        }
        if (fVar instanceof I) {
            i5 = (I) fVar;
        } else {
            i5 = null;
        }
        if (i5 != null) {
            return C2894r0.a(i5);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Executor createDefaultExecutor(boolean z4) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ConfigurationKt$createDefaultExecutor$factory$1(z4));
        t.d(newFixedThreadPool, "newFixedThreadPool(...)");
        return newFixedThreadPool;
    }

    /* access modifiers changed from: private */
    public static final Tracer createDefaultTracer() {
        return new ConfigurationKt$createDefaultTracer$tracer$1();
    }
}
