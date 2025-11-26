package B3;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.t;

public class O {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17381b = AtomicIntegerFieldUpdater.newUpdater(O.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a  reason: collision with root package name */
    private P[] f17382a;

    private final P[] g() {
        P[] pArr = this.f17382a;
        if (pArr == null) {
            P[] pArr2 = new P[4];
            this.f17382a = pArr2;
            return pArr2;
        } else if (c() < pArr.length) {
            return pArr;
        } else {
            Object[] copyOf = Arrays.copyOf(pArr, c() * 2);
            t.d(copyOf, "copyOf(...)");
            P[] pArr3 = (P[]) copyOf;
            this.f17382a = pArr3;
            return pArr3;
        }
    }

    private final void k(int i5) {
        f17381b.set(this, i5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0028, code lost:
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void l(int r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto L_0x000b
            goto L_0x003e
        L_0x000b:
            B3.P[] r2 = r5.f17382a
            kotlin.jvm.internal.t.b(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L_0x002b
            r3 = r2[r0]
            kotlin.jvm.internal.t.b(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.t.b(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            r1 = r2[r6]
            kotlin.jvm.internal.t.b(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.t.b(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L_0x003f
        L_0x003e:
            return
        L_0x003f:
            r5.n(r6, r0)
            r6 = r0
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.O.l(int):void");
    }

    private final void m(int i5) {
        while (i5 > 0) {
            P[] pArr = this.f17382a;
            t.b(pArr);
            int i6 = (i5 - 1) / 2;
            P p5 = pArr[i6];
            t.b(p5);
            P p6 = pArr[i5];
            t.b(p6);
            if (((Comparable) p5).compareTo(p6) > 0) {
                n(i5, i6);
                i5 = i6;
            } else {
                return;
            }
        }
    }

    private final void n(int i5, int i6) {
        P[] pArr = this.f17382a;
        t.b(pArr);
        P p5 = pArr[i6];
        t.b(p5);
        P p6 = pArr[i5];
        t.b(p6);
        pArr[i5] = p5;
        pArr[i6] = p6;
        p5.setIndex(i5);
        p6.setIndex(i6);
    }

    public final void a(P p5) {
        p5.c(this);
        P[] g5 = g();
        int c5 = c();
        k(c5 + 1);
        g5[c5] = p5;
        p5.setIndex(c5);
        m(c5);
    }

    public final P b() {
        P[] pArr = this.f17382a;
        if (pArr != null) {
            return pArr[0];
        }
        return null;
    }

    public final int c() {
        return f17381b.get(this);
    }

    public final boolean e() {
        if (c() == 0) {
            return true;
        }
        return false;
    }

    public final P f() {
        P b5;
        synchronized (this) {
            b5 = b();
        }
        return b5;
    }

    public final boolean h(P p5) {
        boolean z4;
        synchronized (this) {
            if (p5.b() == null) {
                z4 = false;
            } else {
                i(p5.getIndex());
                z4 = true;
            }
        }
        return z4;
    }

    public final P i(int i5) {
        P[] pArr = this.f17382a;
        t.b(pArr);
        k(c() - 1);
        if (i5 < c()) {
            n(i5, c());
            int i6 = (i5 - 1) / 2;
            if (i5 > 0) {
                P p5 = pArr[i5];
                t.b(p5);
                P p6 = pArr[i6];
                t.b(p6);
                if (((Comparable) p5).compareTo(p6) < 0) {
                    n(i5, i6);
                    m(i6);
                }
            }
            l(i5);
        }
        P p7 = pArr[c()];
        t.b(p7);
        p7.c((O) null);
        p7.setIndex(-1);
        pArr[c()] = null;
        return p7;
    }

    public final P j() {
        P p5;
        synchronized (this) {
            if (c() > 0) {
                p5 = i(0);
            } else {
                p5 = null;
            }
        }
        return p5;
    }
}
