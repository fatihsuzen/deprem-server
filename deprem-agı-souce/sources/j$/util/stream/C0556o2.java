package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.o2  reason: case insensitive filesystem */
public final class C0556o2 extends C0496c2 {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ long f1754s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ long f1755t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0556o2(C0506e2 e2Var, int i5, long j5, long j6) {
        super(e2Var, i5);
        this.f1754s = j5;
        this.f1755t = j6;
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [j$.util.stream.B3, j$.util.Spliterator] */
    public final Spliterator O0(C0483a aVar, Spliterator spliterator) {
        long k02 = aVar.k0(spliterator);
        if (k02 > 0 && spliterator.hasCharacteristics(16384)) {
            Spliterator H02 = aVar.H0(spliterator);
            long j5 = this.f1754s;
            return new C0581t3(H02, j5, C0594w1.Z(j5, this.f1755t));
        } else if (!Z2.ORDERED.h(aVar.f1653m)) {
            Spliterator H03 = aVar.H0(spliterator);
            long j6 = this.f1754s;
            long j7 = this.f1755t;
            if (j6 <= k02) {
                long j8 = k02 - j6;
                if (j7 >= 0) {
                    j8 = Math.min(j7, j8);
                }
                j7 = j8;
                j6 = 0;
            }
            return new B3(H03, j6, j7);
        } else {
            return ((H0) new C0595w2(this, aVar, spliterator, new C0494c0(9), this.f1754s, this.f1755t).invoke()).spliterator();
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
                Spliterator H02 = w1Var.H0(spliterator2);
                long j7 = this.f1754s;
                long j8 = this.f1755t;
                if (j7 <= k02) {
                    long j9 = k02 - j7;
                    j5 = j8 >= 0 ? Math.min(j8, j9) : j9;
                    j6 = 0;
                } else {
                    j5 = j8;
                    j6 = j7;
                }
                return C0594w1.a0(this, new B3(H02, j6, j5), true, intFunction);
            }
            return (H0) new C0595w2(this, w1Var, spliterator2, intFunction, this.f1754s, this.f1755t).invoke();
        }
        C0483a aVar = (C0483a) w1Var;
        while (aVar.f1652l > 0) {
            aVar = aVar.f1649i;
        }
        return C0594w1.a0(w1Var, C0594w1.X(aVar.M0(), spliterator, this.f1754s, this.f1755t), true, intFunction);
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        return new C0551n2(this, m2Var);
    }
}
