package j$.util.stream;

import j$.util.Spliterator;
import j$.util.W;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.u2  reason: case insensitive filesystem */
public final class C0585u2 extends C0602y {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ long f1795s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ long f1796t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0585u2(A a5, int i5, long j5, long j6) {
        super(a5, i5);
        this.f1795s = j5;
        this.f1796t = j6;
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [j$.util.stream.B3, j$.util.Spliterator] */
    public final Spliterator O0(C0483a aVar, Spliterator spliterator) {
        long k02 = aVar.k0(spliterator);
        if (k02 > 0 && spliterator.hasCharacteristics(16384)) {
            long j5 = this.f1795s;
            return new C0576s3((W) aVar.H0(spliterator), j5, C0594w1.Z(j5, this.f1796t));
        } else if (!Z2.ORDERED.h(aVar.f1653m)) {
            W w4 = (W) aVar.H0(spliterator);
            long j6 = this.f1795s;
            long j7 = this.f1796t;
            if (j6 <= k02) {
                long j8 = k02 - j6;
                if (j7 >= 0) {
                    j8 = Math.min(j7, j8);
                }
                j7 = j8;
                j6 = 0;
            }
            return new B3(w4, j6, j7);
        } else {
            return ((H0) new C0595w2(this, aVar, spliterator, new C0494c0(20), this.f1795s, this.f1796t).invoke()).spliterator();
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [j$.util.stream.B3, j$.util.Spliterator] */
    public final H0 N0(C0594w1 w1Var, Spliterator spliterator, IntFunction intFunction) {
        long j5;
        long j6;
        long k02 = w1Var.k0(spliterator);
        if (k02 <= 0 || !spliterator.hasCharacteristics(16384)) {
            Spliterator spliterator2 = spliterator;
            if (!Z2.ORDERED.h(((C0483a) w1Var).f1653m)) {
                W w4 = (W) w1Var.H0(spliterator2);
                long j7 = this.f1795s;
                long j8 = this.f1796t;
                if (j7 <= k02) {
                    long j9 = k02 - j7;
                    j5 = j8 >= 0 ? Math.min(j8, j9) : j9;
                    j6 = 0;
                } else {
                    j5 = j8;
                    j6 = j7;
                }
                return C0594w1.b0(this, new B3(w4, j6, j5), true);
            }
            return (H0) new C0595w2(this, w1Var, spliterator2, intFunction, this.f1795s, this.f1796t).invoke();
        }
        C0483a aVar = (C0483a) w1Var;
        while (aVar.f1652l > 0) {
            aVar = aVar.f1649i;
        }
        return C0594w1.b0(w1Var, C0594w1.X(aVar.M0(), spliterator, this.f1795s, this.f1796t), true);
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        return new C0580t2(this, m2Var);
    }
}
