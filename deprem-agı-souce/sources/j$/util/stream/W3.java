package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

public final class W3 extends C0498d {

    /* renamed from: h  reason: collision with root package name */
    public final C0483a f1600h;

    /* renamed from: i  reason: collision with root package name */
    public final IntFunction f1601i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1602j;

    /* renamed from: k  reason: collision with root package name */
    public long f1603k;

    /* renamed from: l  reason: collision with root package name */
    public long f1604l;

    public final void onCompletion(CountedCompleter countedCompleter) {
        H0 e02;
        C0498d dVar = this.f1692d;
        if (dVar != null) {
            if (this.f1602j) {
                W3 w32 = (W3) dVar;
                long j5 = w32.f1604l;
                this.f1604l = j5;
                if (j5 == w32.f1603k) {
                    this.f1604l = j5 + ((W3) this.f1693e).f1604l;
                }
            }
            W3 w33 = (W3) dVar;
            long j6 = w33.f1603k;
            W3 w34 = (W3) this.f1693e;
            this.f1603k = j6 + w34.f1603k;
            if (w33.f1603k == 0) {
                e02 = (H0) w34.f1694f;
            } else if (w34.f1603k == 0) {
                e02 = (H0) w33.f1694f;
            } else {
                e02 = C0594w1.e0(this.f1600h.M0(), (H0) ((W3) this.f1692d).f1694f, (H0) ((W3) this.f1693e).f1694f);
            }
            H0 h02 = e02;
            if (b() && this.f1602j) {
                h02 = h02.i(this.f1604l, h02.count(), this.f1601i);
            }
            this.f1694f = h02;
        }
        super.onCompletion(countedCompleter);
    }

    public W3(C0483a aVar, C0594w1 w1Var, Spliterator spliterator, IntFunction intFunction) {
        super(w1Var, spliterator);
        this.f1600h = aVar;
        this.f1601i = intFunction;
        this.f1602j = Z2.ORDERED.h(((C0483a) w1Var).f1653m);
    }

    public W3(W3 w32, Spliterator spliterator) {
        super((C0498d) w32, spliterator);
        this.f1600h = w32.f1600h;
        this.f1601i = w32.f1601i;
        this.f1602j = w32.f1602j;
    }

    public final C0498d c(Spliterator spliterator) {
        return new W3(this, spliterator);
    }

    public final Object a() {
        long j5;
        boolean b5 = b();
        if (!b5 && this.f1602j) {
            Z2 z22 = Z2.SIZED;
            C0483a aVar = this.f1600h;
            int i5 = aVar.f1650j;
            int i6 = z22.f1645e;
            if ((i5 & i6) == i6) {
                j5 = aVar.k0(this.f1690b);
                C0608z0 A02 = this.f1689a.A0(j5, this.f1601i);
                V3 h5 = ((U3) this.f1600h).h(A02, !this.f1602j && !b5);
                this.f1689a.F0(this.f1690b, h5);
                H0 build = A02.build();
                this.f1603k = build.count();
                this.f1604l = h5.h();
                return build;
            }
        }
        j5 = -1;
        C0608z0 A022 = this.f1689a.A0(j5, this.f1601i);
        V3 h52 = ((U3) this.f1600h).h(A022, !this.f1602j && !b5);
        this.f1689a.F0(this.f1690b, h52);
        H0 build2 = A022.build();
        this.f1603k = build2.count();
        this.f1604l = h52.h();
        return build2;
    }
}
