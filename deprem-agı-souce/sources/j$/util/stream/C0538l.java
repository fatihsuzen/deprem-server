package j$.util.stream;

/* renamed from: j$.util.stream.l  reason: case insensitive filesystem */
public final class C0538l extends C0526i2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1734b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1735c;

    /* renamed from: d  reason: collision with root package name */
    public Object f1736d;

    public /* synthetic */ C0538l(C0546m2 m2Var) {
        super(m2Var);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0538l(I3 i32, C0546m2 m2Var) {
        super(m2Var);
        this.f1736d = i32;
        this.f1735c = true;
    }

    public final void c(long j5) {
        switch (this.f1734b) {
            case 0:
                this.f1735c = false;
                this.f1736d = null;
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

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[Catch:{ all -> 0x003d, all -> 0x005a }, LOOP:0: B:18:0x0049->B:21:0x0053, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(java.lang.Object r4) {
        /*
            r3 = this;
            int r0 = r3.f1734b
            switch(r0) {
                case 0: goto L_0x0065;
                case 1: goto L_0x001d;
                default: goto L_0x0005;
            }
        L_0x0005:
            boolean r0 = r3.f1735c
            if (r0 == 0) goto L_0x001c
            java.lang.Object r0 = r3.f1736d
            j$.util.stream.I3 r0 = (j$.util.stream.I3) r0
            java.util.function.Predicate r0 = r0.f1499s
            boolean r0 = r0.test(r4)
            r3.f1735c = r0
            if (r0 == 0) goto L_0x001c
            j$.util.stream.m2 r0 = r3.f1716a
            r0.accept(r4)
        L_0x001c:
            return
        L_0x001d:
            java.lang.Object r0 = r3.f1736d
            j$.util.stream.r r0 = (j$.util.stream.r) r0
            java.lang.Object r0 = r0.f1770t
            j$.util.q r0 = (j$.util.C0481q) r0
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.Stream r4 = (j$.util.stream.Stream) r4
            if (r4 == 0) goto L_0x005f
            boolean r0 = r3.f1735c     // Catch:{ all -> 0x003d }
            j$.util.stream.m2 r1 = r3.f1716a
            if (r0 != 0) goto L_0x003f
            j$.util.stream.g r0 = r4.sequential()     // Catch:{ all -> 0x003d }
            j$.util.stream.Stream r0 = (j$.util.stream.Stream) r0     // Catch:{ all -> 0x003d }
            r0.forEach(r1)     // Catch:{ all -> 0x003d }
            goto L_0x005f
        L_0x003d:
            r0 = move-exception
            goto L_0x0056
        L_0x003f:
            j$.util.stream.g r0 = r4.sequential()     // Catch:{ all -> 0x003d }
            j$.util.stream.Stream r0 = (j$.util.stream.Stream) r0     // Catch:{ all -> 0x003d }
            j$.util.Spliterator r0 = r0.spliterator()     // Catch:{ all -> 0x003d }
        L_0x0049:
            boolean r2 = r1.e()     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x005f
            boolean r2 = r0.tryAdvance(r1)     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0049
            goto L_0x005f
        L_0x0056:
            r4.close()     // Catch:{ all -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x005e:
            throw r0
        L_0x005f:
            if (r4 == 0) goto L_0x0064
            r4.close()
        L_0x0064:
            return
        L_0x0065:
            j$.util.stream.m2 r0 = r3.f1716a
            if (r4 != 0) goto L_0x0077
            boolean r4 = r3.f1735c
            if (r4 != 0) goto L_0x0086
            r4 = 1
            r3.f1735c = r4
            r4 = 0
            r3.f1736d = r4
            r0.accept(r4)
            goto L_0x0086
        L_0x0077:
            java.lang.Object r1 = r3.f1736d
            if (r1 == 0) goto L_0x0081
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x0086
        L_0x0081:
            r3.f1736d = r4
            r0.accept(r4)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0538l.accept(java.lang.Object):void");
    }

    public boolean e() {
        switch (this.f1734b) {
            case 1:
                this.f1735c = true;
                return this.f1716a.e();
            case 2:
                return !this.f1735c || this.f1716a.e();
            default:
                return super.e();
        }
    }

    public void end() {
        switch (this.f1734b) {
            case 0:
                this.f1735c = false;
                this.f1736d = null;
                this.f1716a.end();
                return;
            default:
                super.end();
                return;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0538l(r rVar, C0546m2 m2Var) {
        super(m2Var);
        this.f1736d = rVar;
    }
}
