package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

public final class X3 extends C0488b {

    /* renamed from: j  reason: collision with root package name */
    public final C0483a f1610j;

    /* renamed from: k  reason: collision with root package name */
    public final IntFunction f1611k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f1612l;

    /* renamed from: m  reason: collision with root package name */
    public long f1613m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1614n;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f1615o;

    public final void f() {
        this.f1663i = true;
        if (this.f1612l && this.f1615o) {
            d(C0594w1.i0(this.f1610j.M0()));
        }
    }

    public final void onCompletion(CountedCompleter countedCompleter) {
        Object obj;
        C0498d dVar = this.f1692d;
        if (dVar != null) {
            this.f1614n = ((X3) dVar).f1614n | ((X3) this.f1693e).f1614n;
            if (!this.f1612l || !this.f1663i) {
                if (this.f1612l) {
                    X3 x32 = (X3) this.f1692d;
                    if (x32.f1614n) {
                        this.f1613m = x32.f1613m;
                        obj = (H0) x32.i();
                    }
                }
                X3 x33 = (X3) this.f1692d;
                long j5 = x33.f1613m;
                X3 x34 = (X3) this.f1693e;
                this.f1613m = j5 + x34.f1613m;
                if (x33.f1613m == 0) {
                    obj = (H0) x34.i();
                } else if (x34.f1613m == 0) {
                    obj = (H0) x33.i();
                } else {
                    obj = C0594w1.e0(this.f1610j.M0(), (H0) ((X3) this.f1692d).i(), (H0) ((X3) this.f1693e).i());
                }
            } else {
                this.f1613m = 0;
                obj = C0594w1.i0(this.f1610j.M0());
            }
            d(obj);
        }
        this.f1615o = true;
        super.onCompletion(countedCompleter);
    }

    public X3(C0483a aVar, C0594w1 w1Var, Spliterator spliterator, IntFunction intFunction) {
        super(w1Var, spliterator);
        this.f1610j = aVar;
        this.f1611k = intFunction;
        this.f1612l = Z2.ORDERED.h(((C0483a) w1Var).f1653m);
    }

    public X3(X3 x32, Spliterator spliterator) {
        super((C0488b) x32, spliterator);
        this.f1610j = x32.f1610j;
        this.f1611k = x32.f1611k;
        this.f1612l = x32.f1612l;
    }

    public final C0498d c(Spliterator spliterator) {
        return new X3(this, spliterator);
    }

    public final Object h() {
        return C0594w1.i0(this.f1610j.M0());
    }

    public final Object a() {
        C0608z0 A02 = this.f1689a.A0(-1, this.f1611k);
        C0546m2 Q02 = this.f1610j.Q0(((C0483a) this.f1689a).f1653m, A02);
        C0594w1 w1Var = this.f1689a;
        boolean g02 = w1Var.g0(this.f1690b, w1Var.G0(Q02));
        this.f1614n = g02;
        if (g02) {
            g();
        }
        H0 build = A02.build();
        this.f1613m = build.count();
        return build;
    }
}
