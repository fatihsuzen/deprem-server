package L3;

import j$.util.concurrent.ConcurrentHashMap;
import k3.p;
import kotlin.jvm.internal.t;

/* renamed from: L3.z  reason: case insensitive filesystem */
final class C2125z implements C2126z0 {

    /* renamed from: a  reason: collision with root package name */
    private final p f18604a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap f18605b = new ConcurrentHashMap();

    public C2125z(p pVar) {
        t.e(pVar, "compute");
        this.f18604a = pVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0016, code lost:
        r2 = new L3.C2124y0();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(r3.C2733c r6, java.util.List r7) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.t.e(r6, r0)
            java.lang.String r0 = "types"
            kotlin.jvm.internal.t.e(r7, r0)
            j$.util.concurrent.ConcurrentHashMap r0 = r5.f18605b
            java.lang.Class r1 = j3.C2582a.a(r6)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x0023
            L3.y0 r2 = new L3.y0
            r2.<init>()
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r2 = r0
        L_0x0023:
            L3.y0 r2 = (L3.C2124y0) r2
            r0 = r7
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r3 = 10
            int r3 = X2.C2250q.p(r0, r3)
            r1.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x0037:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x004c
            java.lang.Object r3 = r0.next()
            r3.m r3 = (r3.C2743m) r3
            L3.Y r4 = new L3.Y
            r4.<init>(r3)
            r1.add(r4)
            goto L_0x0037
        L_0x004c:
            j$.util.concurrent.ConcurrentHashMap r0 = r2.f18603a
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x007d
            W2.t$a r2 = W2.t.f19966b     // Catch:{ all -> 0x0065 }
            k3.p r2 = r5.f18604a     // Catch:{ all -> 0x0065 }
            java.lang.Object r6 = r2.invoke(r6, r7)     // Catch:{ all -> 0x0065 }
            H3.b r6 = (H3.b) r6     // Catch:{ all -> 0x0065 }
            java.lang.Object r6 = W2.t.b(r6)     // Catch:{ all -> 0x0065 }
            goto L_0x0070
        L_0x0065:
            r6 = move-exception
            W2.t$a r7 = W2.t.f19966b
            java.lang.Object r6 = W2.u.a(r6)
            java.lang.Object r6 = W2.t.b(r6)
        L_0x0070:
            W2.t r6 = W2.t.a(r6)
            java.lang.Object r7 = r0.putIfAbsent(r1, r6)
            if (r7 != 0) goto L_0x007c
            r2 = r6
            goto L_0x007d
        L_0x007c:
            r2 = r7
        L_0x007d:
            java.lang.String r6 = "getOrPut(...)"
            kotlin.jvm.internal.t.d(r2, r6)
            W2.t r2 = (W2.t) r2
            java.lang.Object r6 = r2.j()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: L3.C2125z.a(r3.c, java.util.List):java.lang.Object");
    }
}
