package B3;

import W2.J;
import w3.C2877i0;
import w3.W0;

/* renamed from: B3.i  reason: case insensitive filesystem */
public abstract class C1989i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final D f17398a = new D("UNDEFINED");

    /* renamed from: b  reason: collision with root package name */
    public static final D f17399b = new D("REUSABLE_CLAIMED");

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        if (r0.Q0() != false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        if (r0.Q0() != false) goto L_0x00a4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(b3.C2308e r6, java.lang.Object r7) {
        /*
            boolean r0 = r6 instanceof B3.C1988h
            if (r0 == 0) goto L_0x00b2
            B3.h r6 = (B3.C1988h) r6
            java.lang.Object r0 = w3.C2856C.b(r7)
            w3.I r1 = r6.f17394d
            b3.i r2 = r6.getContext()
            boolean r1 = r1.isDispatchNeeded(r2)
            r2 = 1
            if (r1 == 0) goto L_0x0026
            r6.f17396f = r0
            r6.f26267c = r2
            w3.I r7 = r6.f17394d
            b3.i r0 = r6.getContext()
            r7.dispatch(r0, r6)
            goto L_0x00ac
        L_0x0026:
            w3.W0 r1 = w3.W0.f26260a
            w3.i0 r1 = r1.b()
            boolean r3 = r1.M()
            if (r3 == 0) goto L_0x003b
            r6.f17396f = r0
            r6.f26267c = r2
            r1.I(r6)
            goto L_0x00ac
        L_0x003b:
            r1.K(r2)
            b3.i r3 = r6.getContext()     // Catch:{ all -> 0x0067 }
            w3.y0$b r4 = w3.C2908y0.f26320k0     // Catch:{ all -> 0x0067 }
            b3.i$b r3 = r3.get(r4)     // Catch:{ all -> 0x0067 }
            w3.y0 r3 = (w3.C2908y0) r3     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0069
            boolean r4 = r3.isActive()     // Catch:{ all -> 0x0067 }
            if (r4 != 0) goto L_0x0069
            java.util.concurrent.CancellationException r7 = r3.m()     // Catch:{ all -> 0x0067 }
            r6.b(r0, r7)     // Catch:{ all -> 0x0067 }
            W2.t$a r0 = W2.t.f19966b     // Catch:{ all -> 0x0067 }
            java.lang.Object r7 = W2.u.a(r7)     // Catch:{ all -> 0x0067 }
            java.lang.Object r7 = W2.t.b(r7)     // Catch:{ all -> 0x0067 }
            r6.resumeWith(r7)     // Catch:{ all -> 0x0067 }
            goto L_0x0091
        L_0x0067:
            r7 = move-exception
            goto L_0x00a8
        L_0x0069:
            b3.e r0 = r6.f17395e     // Catch:{ all -> 0x0067 }
            java.lang.Object r3 = r6.f17397g     // Catch:{ all -> 0x0067 }
            b3.i r4 = r0.getContext()     // Catch:{ all -> 0x0067 }
            java.lang.Object r3 = B3.K.i(r4, r3)     // Catch:{ all -> 0x0067 }
            B3.D r5 = B3.K.f17373a     // Catch:{ all -> 0x0067 }
            if (r3 == r5) goto L_0x007e
            w3.b1 r0 = w3.G.m(r0, r4, r3)     // Catch:{ all -> 0x0067 }
            goto L_0x007f
        L_0x007e:
            r0 = 0
        L_0x007f:
            b3.e r5 = r6.f17395e     // Catch:{ all -> 0x009b }
            r5.resumeWith(r7)     // Catch:{ all -> 0x009b }
            W2.J r7 = W2.J.f19942a     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x008e
            boolean r7 = r0.Q0()     // Catch:{ all -> 0x0067 }
            if (r7 == 0) goto L_0x0091
        L_0x008e:
            B3.K.f(r4, r3)     // Catch:{ all -> 0x0067 }
        L_0x0091:
            boolean r7 = r1.P()     // Catch:{ all -> 0x0067 }
            if (r7 != 0) goto L_0x0091
        L_0x0097:
            r1.F(r2)
            goto L_0x00ac
        L_0x009b:
            r7 = move-exception
            if (r0 == 0) goto L_0x00a4
            boolean r0 = r0.Q0()     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x00a7
        L_0x00a4:
            B3.K.f(r4, r3)     // Catch:{ all -> 0x0067 }
        L_0x00a7:
            throw r7     // Catch:{ all -> 0x0067 }
        L_0x00a8:
            r6.i(r7)     // Catch:{ all -> 0x00ad }
            goto L_0x0097
        L_0x00ac:
            return
        L_0x00ad:
            r6 = move-exception
            r1.F(r2)
            throw r6
        L_0x00b2:
            r6.resumeWith(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.C1989i.b(b3.e, java.lang.Object):void");
    }

    public static final boolean c(C1988h hVar) {
        J j5 = J.f19942a;
        C2877i0 b5 = W0.f26260a.b();
        if (b5.N()) {
            return false;
        }
        if (b5.M()) {
            hVar.f17396f = j5;
            hVar.f26267c = 1;
            b5.I(hVar);
            return true;
        }
        b5.K(true);
        try {
            hVar.run();
            do {
            } while (b5.P());
        } catch (Throwable th) {
            b5.F(true);
            throw th;
        }
        b5.F(true);
        return false;
    }
}
