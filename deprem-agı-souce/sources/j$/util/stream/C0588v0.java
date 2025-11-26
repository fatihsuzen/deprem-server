package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.t;

/* renamed from: j$.util.stream.v0  reason: case insensitive filesystem */
public final class C0588v0 extends C0488b {

    /* renamed from: j  reason: collision with root package name */
    public final t f1805j;

    public C0588v0(t tVar, C0483a aVar, Spliterator spliterator) {
        super((C0594w1) aVar, spliterator);
        this.f1805j = tVar;
    }

    public C0588v0(C0588v0 v0Var, Spliterator spliterator) {
        super((C0488b) v0Var, spliterator);
        this.f1805j = v0Var.f1805j;
    }

    public final C0498d c(Spliterator spliterator) {
        return new C0588v0(this, spliterator);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0026 A[LOOP:0: B:3:0x0026->B:6:0x0031, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a() {
        /*
            r4 = this;
            j$.util.stream.w1 r0 = r4.f1689a
            j$.util.concurrent.t r1 = r4.f1805j
            java.lang.Object r1 = r1.f1351c
            java.util.function.Supplier r1 = (java.util.function.Supplier) r1
            java.lang.Object r1 = r1.get()
            j$.util.stream.t0 r1 = (j$.util.stream.C0578t0) r1
            j$.util.Spliterator r2 = r4.f1690b
            r0.F0(r2, r1)
            boolean r0 = r1.f1787b
            j$.util.concurrent.t r1 = r4.f1805j
            java.lang.Object r1 = r1.f1350b
            j$.util.stream.u0 r1 = (j$.util.stream.C0583u0) r1
            boolean r1 = r1.f1794b
            r2 = 0
            if (r0 != r1) goto L_0x0033
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.util.concurrent.atomic.AtomicReference r1 = r4.f1662h
        L_0x0026:
            boolean r3 = r1.compareAndSet(r2, r0)
            if (r3 == 0) goto L_0x002d
            goto L_0x0033
        L_0x002d:
            java.lang.Object r3 = r1.get()
            if (r3 == 0) goto L_0x0026
        L_0x0033:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0588v0.a():java.lang.Object");
    }

    public final Object h() {
        return Boolean.valueOf(!((C0583u0) this.f1805j.f1350b).f1794b);
    }
}
