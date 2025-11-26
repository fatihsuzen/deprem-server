package L3;

import j$.util.concurrent.ConcurrentHashMap;
import k3.l;
import kotlin.jvm.internal.t;

/* renamed from: L3.y  reason: case insensitive filesystem */
final class C2123y implements S0 {

    /* renamed from: a  reason: collision with root package name */
    private final l f18601a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap f18602b = new ConcurrentHashMap();

    public C2123y(l lVar) {
        t.e(lVar, "compute");
        this.f18601a = lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r2 = new L3.C2100m((H3.b) r4.f18601a.invoke(r5));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public H3.b a(r3.C2733c r5) {
        /*
            r4 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.t.e(r5, r0)
            j$.util.concurrent.ConcurrentHashMap r0 = r4.f18602b
            java.lang.Class r1 = j3.C2582a.a(r5)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x0026
            L3.m r2 = new L3.m
            k3.l r3 = r4.f18601a
            java.lang.Object r5 = r3.invoke(r5)
            H3.b r5 = (H3.b) r5
            r2.<init>(r5)
            java.lang.Object r5 = r0.putIfAbsent(r1, r2)
            if (r5 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = r5
        L_0x0026:
            L3.m r2 = (L3.C2100m) r2
            H3.b r5 = r2.f18559a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: L3.C2123y.a(r3.c):H3.b");
    }
}
