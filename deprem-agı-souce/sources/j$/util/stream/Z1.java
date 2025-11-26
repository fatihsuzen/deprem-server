package j$.util.stream;

import j$.util.F;
import j$.util.J;
import j$.util.N;
import j$.util.Objects;

public final class Z1 extends C0526i2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1620b = 1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1621c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1622d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ C0483a f1623e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Z1(V v5, C0546m2 m2Var) {
        super(m2Var);
        this.f1623e = v5;
        C0546m2 m2Var2 = this.f1716a;
        Objects.requireNonNull(m2Var2);
        this.f1622d = new J(m2Var2, 1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Z1(C0592w wVar, C0546m2 m2Var) {
        super(m2Var);
        this.f1623e = wVar;
        C0546m2 m2Var2 = this.f1716a;
        Objects.requireNonNull(m2Var2);
        this.f1622d = new F(m2Var2, 1);
    }

    public final void c(long j5) {
        switch (this.f1620b) {
            case 0:
                this.f1716a.c(-1);
                return;
            case 1:
                this.f1716a.c(-1);
                return;
            default:
                this.f1716a.c(-1);
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f A[Catch:{ all -> 0x0025, all -> 0x0042 }, LOOP:0: B:11:0x002f->B:14:0x003b, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0077 A[Catch:{ all -> 0x006d, all -> 0x008a }, LOOP:1: B:31:0x0077->B:34:0x0083, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bf A[Catch:{ all -> 0x00b5, all -> 0x00d2 }, LOOP:2: B:51:0x00bf->B:54:0x00cb, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(java.lang.Object r4) {
        /*
            r3 = this;
            int r0 = r3.f1620b
            switch(r0) {
                case 0: goto L_0x0095;
                case 1: goto L_0x004d;
                default: goto L_0x0005;
            }
        L_0x0005:
            java.lang.Object r0 = r3.f1622d
            j$.util.F r0 = (j$.util.F) r0
            j$.util.stream.a r1 = r3.f1623e
            j$.util.stream.w r1 = (j$.util.stream.C0592w) r1
            java.lang.Object r1 = r1.f1813t
            j$.util.q r1 = (j$.util.C0481q) r1
            java.lang.Object r4 = r1.apply(r4)
            j$.util.stream.D r4 = (j$.util.stream.D) r4
            if (r4 == 0) goto L_0x0047
            boolean r1 = r3.f1621c     // Catch:{ all -> 0x0025 }
            if (r1 != 0) goto L_0x0027
            j$.util.stream.D r1 = r4.sequential()     // Catch:{ all -> 0x0025 }
            r1.forEach(r0)     // Catch:{ all -> 0x0025 }
            goto L_0x0047
        L_0x0025:
            r0 = move-exception
            goto L_0x003e
        L_0x0027:
            j$.util.stream.D r1 = r4.sequential()     // Catch:{ all -> 0x0025 }
            j$.util.W r1 = r1.spliterator()     // Catch:{ all -> 0x0025 }
        L_0x002f:
            j$.util.stream.m2 r2 = r3.f1716a     // Catch:{ all -> 0x0025 }
            boolean r2 = r2.e()     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x0047
            boolean r2 = r1.tryAdvance(r0)     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x002f
            goto L_0x0047
        L_0x003e:
            r4.close()     // Catch:{ all -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x0046:
            throw r0
        L_0x0047:
            if (r4 == 0) goto L_0x004c
            r4.close()
        L_0x004c:
            return
        L_0x004d:
            java.lang.Object r0 = r3.f1622d
            j$.util.J r0 = (j$.util.J) r0
            j$.util.stream.a r1 = r3.f1623e
            j$.util.stream.V r1 = (j$.util.stream.V) r1
            java.lang.Object r1 = r1.f1594t
            j$.util.q r1 = (j$.util.C0481q) r1
            java.lang.Object r4 = r1.apply(r4)
            j$.util.stream.IntStream r4 = (j$.util.stream.IntStream) r4
            if (r4 == 0) goto L_0x008f
            boolean r1 = r3.f1621c     // Catch:{ all -> 0x006d }
            if (r1 != 0) goto L_0x006f
            j$.util.stream.IntStream r1 = r4.sequential()     // Catch:{ all -> 0x006d }
            r1.forEach(r0)     // Catch:{ all -> 0x006d }
            goto L_0x008f
        L_0x006d:
            r0 = move-exception
            goto L_0x0086
        L_0x006f:
            j$.util.stream.IntStream r1 = r4.sequential()     // Catch:{ all -> 0x006d }
            j$.util.Z r1 = r1.spliterator()     // Catch:{ all -> 0x006d }
        L_0x0077:
            j$.util.stream.m2 r2 = r3.f1716a     // Catch:{ all -> 0x006d }
            boolean r2 = r2.e()     // Catch:{ all -> 0x006d }
            if (r2 != 0) goto L_0x008f
            boolean r2 = r1.tryAdvance(r0)     // Catch:{ all -> 0x006d }
            if (r2 != 0) goto L_0x0077
            goto L_0x008f
        L_0x0086:
            r4.close()     // Catch:{ all -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x008e:
            throw r0
        L_0x008f:
            if (r4 == 0) goto L_0x0094
            r4.close()
        L_0x0094:
            return
        L_0x0095:
            java.lang.Object r0 = r3.f1622d
            j$.util.N r0 = (j$.util.N) r0
            j$.util.stream.a r1 = r3.f1623e
            j$.util.stream.g0 r1 = (j$.util.stream.C0514g0) r1
            java.lang.Object r1 = r1.f1709t
            j$.util.q r1 = (j$.util.C0481q) r1
            java.lang.Object r4 = r1.apply(r4)
            j$.util.stream.n0 r4 = (j$.util.stream.C0549n0) r4
            if (r4 == 0) goto L_0x00d7
            boolean r1 = r3.f1621c     // Catch:{ all -> 0x00b5 }
            if (r1 != 0) goto L_0x00b7
            j$.util.stream.n0 r1 = r4.sequential()     // Catch:{ all -> 0x00b5 }
            r1.forEach(r0)     // Catch:{ all -> 0x00b5 }
            goto L_0x00d7
        L_0x00b5:
            r0 = move-exception
            goto L_0x00ce
        L_0x00b7:
            j$.util.stream.n0 r1 = r4.sequential()     // Catch:{ all -> 0x00b5 }
            j$.util.c0 r1 = r1.spliterator()     // Catch:{ all -> 0x00b5 }
        L_0x00bf:
            j$.util.stream.m2 r2 = r3.f1716a     // Catch:{ all -> 0x00b5 }
            boolean r2 = r2.e()     // Catch:{ all -> 0x00b5 }
            if (r2 != 0) goto L_0x00d7
            boolean r2 = r1.tryAdvance(r0)     // Catch:{ all -> 0x00b5 }
            if (r2 != 0) goto L_0x00bf
            goto L_0x00d7
        L_0x00ce:
            r4.close()     // Catch:{ all -> 0x00d2 }
            goto L_0x00d6
        L_0x00d2:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x00d6:
            throw r0
        L_0x00d7:
            if (r4 == 0) goto L_0x00dc
            r4.close()
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Z1.accept(java.lang.Object):void");
    }

    public final boolean e() {
        switch (this.f1620b) {
            case 0:
                this.f1621c = true;
                return this.f1716a.e();
            case 1:
                this.f1621c = true;
                return this.f1716a.e();
            default:
                this.f1621c = true;
                return this.f1716a.e();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Z1(C0514g0 g0Var, C0546m2 m2Var) {
        super(m2Var);
        this.f1623e = g0Var;
        C0546m2 m2Var2 = this.f1716a;
        Objects.requireNonNull(m2Var2);
        this.f1622d = new N(m2Var2, 1);
    }
}
