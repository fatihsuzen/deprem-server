package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.w2  reason: case insensitive filesystem */
public final class C0595w2 extends C0488b {

    /* renamed from: j  reason: collision with root package name */
    public final C0483a f1821j;

    /* renamed from: k  reason: collision with root package name */
    public final IntFunction f1822k;

    /* renamed from: l  reason: collision with root package name */
    public final long f1823l;

    /* renamed from: m  reason: collision with root package name */
    public final long f1824m;

    /* renamed from: n  reason: collision with root package name */
    public long f1825n;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f1826o;

    public final void f() {
        this.f1663i = true;
        if (this.f1826o) {
            d(C0594w1.i0(this.f1821j.M0()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e7, code lost:
        if (r2 >= r0) goto L_0x00e9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCompletion(java.util.concurrent.CountedCompleter r12) {
        /*
            r11 = this;
            j$.util.stream.d r0 = r11.f1692d
            r1 = 0
            if (r0 != 0) goto L_0x0008
            goto L_0x0098
        L_0x0008:
            j$.util.stream.w2 r0 = (j$.util.stream.C0595w2) r0
            long r3 = r0.f1825n
            j$.util.stream.d r0 = r11.f1693e
            j$.util.stream.w2 r0 = (j$.util.stream.C0595w2) r0
            long r5 = r0.f1825n
            long r3 = r3 + r5
            r11.f1825n = r3
            boolean r0 = r11.f1663i
            if (r0 == 0) goto L_0x0027
            r11.f1825n = r1
            j$.util.stream.a r0 = r11.f1821j
            j$.util.stream.a3 r0 = r0.M0()
            j$.util.stream.a1 r0 = j$.util.stream.C0594w1.i0(r0)
        L_0x0025:
            r3 = r0
            goto L_0x006c
        L_0x0027:
            long r3 = r11.f1825n
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0038
            j$.util.stream.a r0 = r11.f1821j
            j$.util.stream.a3 r0 = r0.M0()
            j$.util.stream.a1 r0 = j$.util.stream.C0594w1.i0(r0)
            goto L_0x0025
        L_0x0038:
            j$.util.stream.d r0 = r11.f1692d
            j$.util.stream.w2 r0 = (j$.util.stream.C0595w2) r0
            long r3 = r0.f1825n
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x004d
            j$.util.stream.d r0 = r11.f1693e
            j$.util.stream.w2 r0 = (j$.util.stream.C0595w2) r0
            java.lang.Object r0 = r0.i()
            j$.util.stream.H0 r0 = (j$.util.stream.H0) r0
            goto L_0x0025
        L_0x004d:
            j$.util.stream.a r0 = r11.f1821j
            j$.util.stream.a3 r0 = r0.M0()
            j$.util.stream.d r3 = r11.f1692d
            j$.util.stream.w2 r3 = (j$.util.stream.C0595w2) r3
            java.lang.Object r3 = r3.i()
            j$.util.stream.H0 r3 = (j$.util.stream.H0) r3
            j$.util.stream.d r4 = r11.f1693e
            j$.util.stream.w2 r4 = (j$.util.stream.C0595w2) r4
            java.lang.Object r4 = r4.i()
            j$.util.stream.H0 r4 = (j$.util.stream.H0) r4
            j$.util.stream.J0 r0 = j$.util.stream.C0594w1.e0(r0, r3, r4)
            goto L_0x0025
        L_0x006c:
            boolean r0 = r11.b()
            if (r0 == 0) goto L_0x0092
            long r4 = r11.f1824m
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0087
            long r4 = r3.count()
            long r6 = r11.f1823l
            long r8 = r11.f1824m
            long r6 = r6 + r8
            long r4 = java.lang.Math.min(r4, r6)
        L_0x0085:
            r6 = r4
            goto L_0x008a
        L_0x0087:
            long r4 = r11.f1825n
            goto L_0x0085
        L_0x008a:
            long r4 = r11.f1823l
            java.util.function.IntFunction r8 = r11.f1822k
            j$.util.stream.H0 r3 = r3.i(r4, r6, r8)
        L_0x0092:
            r11.d(r3)
            r0 = 1
            r11.f1826o = r0
        L_0x0098:
            long r3 = r11.f1824m
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00ec
            boolean r0 = r11.b()
            if (r0 != 0) goto L_0x00ec
            long r0 = r11.f1823l
            long r2 = r11.f1824m
            long r0 = r0 + r2
            boolean r2 = r11.f1826o
            if (r2 == 0) goto L_0x00b0
            long r2 = r11.f1825n
            goto L_0x00b4
        L_0x00b0:
            long r2 = r11.j(r0)
        L_0x00b4:
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 < 0) goto L_0x00b9
            goto L_0x00e9
        L_0x00b9:
            java.util.concurrent.CountedCompleter r4 = r11.getCompleter()
            j$.util.stream.d r4 = (j$.util.stream.C0498d) r4
            j$.util.stream.w2 r4 = (j$.util.stream.C0595w2) r4
            r5 = r11
        L_0x00c2:
            if (r4 == 0) goto L_0x00e5
            j$.util.stream.d r6 = r4.f1693e
            if (r5 != r6) goto L_0x00d9
            j$.util.stream.d r5 = r4.f1692d
            j$.util.stream.w2 r5 = (j$.util.stream.C0595w2) r5
            if (r5 == 0) goto L_0x00d9
            long r5 = r5.j(r0)
            long r5 = r5 + r2
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x00d8
            goto L_0x00e9
        L_0x00d8:
            r2 = r5
        L_0x00d9:
            java.util.concurrent.CountedCompleter r5 = r4.getCompleter()
            j$.util.stream.d r5 = (j$.util.stream.C0498d) r5
            j$.util.stream.w2 r5 = (j$.util.stream.C0595w2) r5
            r10 = r5
            r5 = r4
            r4 = r10
            goto L_0x00c2
        L_0x00e5:
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x00ec
        L_0x00e9:
            r11.g()
        L_0x00ec:
            super.onCompletion(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0595w2.onCompletion(java.util.concurrent.CountedCompleter):void");
    }

    public C0595w2(C0483a aVar, C0594w1 w1Var, Spliterator spliterator, IntFunction intFunction, long j5, long j6) {
        super(w1Var, spliterator);
        this.f1821j = aVar;
        this.f1822k = intFunction;
        this.f1823l = j5;
        this.f1824m = j6;
    }

    public C0595w2(C0595w2 w2Var, Spliterator spliterator) {
        super((C0488b) w2Var, spliterator);
        this.f1821j = w2Var.f1821j;
        this.f1822k = w2Var.f1822k;
        this.f1823l = w2Var.f1823l;
        this.f1824m = w2Var.f1824m;
    }

    public final C0498d c(Spliterator spliterator) {
        return new C0595w2(this, spliterator);
    }

    public final Object h() {
        return C0594w1.i0(this.f1821j.M0());
    }

    public final Object a() {
        long j5 = -1;
        if (b()) {
            Z2 z22 = Z2.SIZED;
            C0483a aVar = this.f1821j;
            int i5 = aVar.f1650j;
            int i6 = z22.f1645e;
            if ((i5 & i6) == i6) {
                j5 = aVar.k0(this.f1690b);
            }
            C0608z0 A02 = this.f1821j.A0(j5, this.f1822k);
            C0546m2 Q02 = this.f1821j.Q0(((C0483a) this.f1689a).f1653m, A02);
            C0594w1 w1Var = this.f1689a;
            w1Var.g0(this.f1690b, w1Var.G0(Q02));
            return A02.build();
        }
        C0608z0 A03 = this.f1821j.A0(-1, this.f1822k);
        if (this.f1823l == 0) {
            C0546m2 Q03 = this.f1821j.Q0(((C0483a) this.f1689a).f1653m, A03);
            C0594w1 w1Var2 = this.f1689a;
            w1Var2.g0(this.f1690b, w1Var2.G0(Q03));
        } else {
            this.f1689a.F0(this.f1690b, A03);
        }
        H0 build = A03.build();
        this.f1825n = build.count();
        this.f1826o = true;
        this.f1690b = null;
        return build;
    }

    public final long j(long j5) {
        if (this.f1826o) {
            return this.f1825n;
        }
        C0595w2 w2Var = (C0595w2) this.f1692d;
        C0595w2 w2Var2 = (C0595w2) this.f1693e;
        if (w2Var == null || w2Var2 == null) {
            return this.f1825n;
        }
        long j6 = w2Var.j(j5);
        if (j6 >= j5) {
            return j6;
        }
        return w2Var2.j(j5) + j6;
    }
}
