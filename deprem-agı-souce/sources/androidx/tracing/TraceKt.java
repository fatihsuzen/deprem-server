package androidx.tracing;

import b3.C2308e;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

public final class TraceKt {
    public static final <T> T trace(String str, C2616a aVar) {
        t.e(str, "label");
        t.e(aVar, "block");
        Trace.beginSection(str);
        try {
            return aVar.invoke();
        } finally {
            r.b(1);
            Trace.endSection();
            r.a(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object traceAsync(java.lang.String r4, int r5, k3.l r6, b3.C2308e r7) {
        /*
            boolean r0 = r7 instanceof androidx.tracing.TraceKt$traceAsync$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.tracing.TraceKt$traceAsync$1 r0 = (androidx.tracing.TraceKt$traceAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.tracing.TraceKt$traceAsync$1 r0 = new androidx.tracing.TraceKt$traceAsync$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            int r5 = r0.I$0
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            W2.u.b(r7)     // Catch:{ all -> 0x002f }
            goto L_0x004c
        L_0x002f:
            r6 = move-exception
            goto L_0x0056
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            W2.u.b(r7)
            androidx.tracing.Trace.beginAsyncSection(r4, r5)
            r0.L$0 = r4     // Catch:{ all -> 0x002f }
            r0.I$0 = r5     // Catch:{ all -> 0x002f }
            r0.label = r3     // Catch:{ all -> 0x002f }
            java.lang.Object r7 = r6.invoke(r0)     // Catch:{ all -> 0x002f }
            if (r7 != r1) goto L_0x004c
            return r1
        L_0x004c:
            kotlin.jvm.internal.r.b(r3)
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            kotlin.jvm.internal.r.a(r3)
            return r7
        L_0x0056:
            kotlin.jvm.internal.r.b(r3)
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            kotlin.jvm.internal.r.a(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.tracing.TraceKt.traceAsync(java.lang.String, int, k3.l, b3.e):java.lang.Object");
    }

    private static final <T> Object traceAsync$$forInline(String str, int i5, l lVar, C2308e eVar) {
        Trace.beginAsyncSection(str, i5);
        try {
            return lVar.invoke(eVar);
        } finally {
            r.b(1);
            Trace.endAsyncSection(str, i5);
            r.a(1);
        }
    }

    public static final <T> T trace(C2616a aVar, C2616a aVar2) {
        t.e(aVar, "lazyLabel");
        t.e(aVar2, "block");
        boolean isEnabled = Trace.isEnabled();
        if (isEnabled) {
            Trace.beginSection((String) aVar.invoke());
        }
        try {
            return aVar2.invoke();
        } finally {
            r.b(1);
            if (isEnabled) {
                Trace.endSection();
            }
            r.a(1);
        }
    }

    public static final <T> T traceAsync(C2616a aVar, C2616a aVar2, C2616a aVar3) {
        int i5;
        String str;
        t.e(aVar, "lazyMethodName");
        t.e(aVar2, "lazyCookie");
        t.e(aVar3, "block");
        if (Trace.isEnabled()) {
            str = (String) aVar.invoke();
            i5 = ((Number) aVar2.invoke()).intValue();
            Trace.beginAsyncSection(str, i5);
        } else {
            str = null;
            i5 = 0;
        }
        try {
            return aVar3.invoke();
        } finally {
            r.b(1);
            if (str != null) {
                Trace.endAsyncSection(str, i5);
            }
            r.a(1);
        }
    }
}
