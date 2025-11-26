package j$.util.stream;

import j$.util.Spliterator;

public final class K extends C0488b {

    /* renamed from: j  reason: collision with root package name */
    public final E f1516j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f1517k;

    public K(E e5, boolean z4, C0483a aVar, Spliterator spliterator) {
        super((C0594w1) aVar, spliterator);
        this.f1517k = z4;
        this.f1516j = e5;
    }

    public K(K k5, Spliterator spliterator) {
        super((C0488b) k5, spliterator);
        this.f1517k = k5.f1517k;
        this.f1516j = k5.f1516j;
    }

    public final C0498d c(Spliterator spliterator) {
        return new K(this, spliterator);
    }

    public final Object h() {
        return this.f1516j.f1462b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045 A[LOOP:2: B:19:0x0045->B:22:0x0050, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x001e A[LOOP:0: B:4:0x001e->B:7:0x0029, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a() {
        /*
            r5 = this;
            j$.util.stream.w1 r0 = r5.f1689a
            j$.util.stream.E r1 = r5.f1516j
            java.util.function.Supplier r1 = r1.f1464d
            java.lang.Object r1 = r1.get()
            j$.util.stream.G3 r1 = (j$.util.stream.G3) r1
            j$.util.Spliterator r2 = r5.f1690b
            r0.F0(r2, r1)
            java.lang.Object r0 = r1.get()
            boolean r1 = r5.f1517k
            r2 = 0
            if (r1 != 0) goto L_0x002c
            if (r0 == 0) goto L_0x0053
            java.util.concurrent.atomic.AtomicReference r1 = r5.f1662h
        L_0x001e:
            boolean r3 = r1.compareAndSet(r2, r0)
            if (r3 == 0) goto L_0x0025
            goto L_0x0053
        L_0x0025:
            java.lang.Object r3 = r1.get()
            if (r3 == 0) goto L_0x001e
            goto L_0x0053
        L_0x002c:
            if (r0 == 0) goto L_0x0053
            r1 = r5
        L_0x002f:
            if (r1 == 0) goto L_0x0043
            java.util.concurrent.CountedCompleter r3 = r1.getCompleter()
            j$.util.stream.d r3 = (j$.util.stream.C0498d) r3
            if (r3 == 0) goto L_0x0041
            j$.util.stream.d r4 = r3.f1692d
            if (r4 == r1) goto L_0x0041
            r5.g()
            return r0
        L_0x0041:
            r1 = r3
            goto L_0x002f
        L_0x0043:
            java.util.concurrent.atomic.AtomicReference r1 = r5.f1662h
        L_0x0045:
            boolean r3 = r1.compareAndSet(r2, r0)
            if (r3 == 0) goto L_0x004c
            goto L_0x0052
        L_0x004c:
            java.lang.Object r3 = r1.get()
            if (r3 == 0) goto L_0x0045
        L_0x0052:
            return r0
        L_0x0053:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.K.a():java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A[LOOP:2: B:17:0x0036->B:20:0x0041, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCompletion(java.util.concurrent.CountedCompleter r7) {
        /*
            r6 = this;
            boolean r0 = r6.f1517k
            if (r0 == 0) goto L_0x004c
            j$.util.stream.d r0 = r6.f1692d
            j$.util.stream.K r0 = (j$.util.stream.K) r0
            r1 = 0
            r2 = r1
        L_0x000a:
            if (r0 == r2) goto L_0x004c
            java.lang.Object r2 = r0.i()
            if (r2 == 0) goto L_0x0044
            j$.util.stream.E r3 = r6.f1516j
            java.util.function.Predicate r3 = r3.f1463c
            boolean r3 = r3.test(r2)
            if (r3 == 0) goto L_0x0044
            r6.d(r2)
            r0 = r6
        L_0x0020:
            if (r0 == 0) goto L_0x0034
            java.util.concurrent.CountedCompleter r3 = r0.getCompleter()
            j$.util.stream.d r3 = (j$.util.stream.C0498d) r3
            if (r3 == 0) goto L_0x0032
            j$.util.stream.d r4 = r3.f1692d
            if (r4 == r0) goto L_0x0032
            r6.g()
            goto L_0x004c
        L_0x0032:
            r0 = r3
            goto L_0x0020
        L_0x0034:
            java.util.concurrent.atomic.AtomicReference r3 = r6.f1662h
        L_0x0036:
            boolean r0 = r3.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x003d
            goto L_0x004c
        L_0x003d:
            java.lang.Object r0 = r3.get()
            if (r0 == 0) goto L_0x0036
            goto L_0x004c
        L_0x0044:
            j$.util.stream.d r2 = r6.f1693e
            j$.util.stream.K r2 = (j$.util.stream.K) r2
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x000a
        L_0x004c:
            super.onCompletion(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.K.onCompletion(java.util.concurrent.CountedCompleter):void");
    }
}
