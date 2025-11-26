package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.c0;
import java.util.Arrays;
import java.util.function.IntFunction;

public final class G2 extends C0524i0 {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f1482s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ G2(C0483a aVar, int i5, int i6) {
        super(aVar, i5);
        this.f1482s = i6;
    }

    public Spliterator O0(C0483a aVar, Spliterator spliterator) {
        switch (this.f1482s) {
            case 1:
                if (Z2.ORDERED.h(aVar.f1653m)) {
                    return N0(aVar, spliterator, new C0494c0(25)).spliterator();
                }
                return new a4((c0) aVar.H0(spliterator), 1);
            default:
                return super.O0(aVar, spliterator);
        }
    }

    public final H0 N0(C0594w1 w1Var, Spliterator spliterator, IntFunction intFunction) {
        switch (this.f1482s) {
            case 0:
                if (Z2.SORTED.h(((C0483a) w1Var).f1653m)) {
                    return w1Var.j0(spliterator, false, intFunction);
                }
                long[] jArr = (long[]) ((F0) w1Var.j0(spliterator, true, intFunction)).b();
                Arrays.sort(jArr);
                return new C0540l1(jArr);
            default:
                return (H0) new X3(this, w1Var, spliterator, intFunction).invoke();
        }
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        switch (this.f1482s) {
            case 0:
                Objects.requireNonNull(m2Var);
                if (Z2.SORTED.h(i5)) {
                    return m2Var;
                }
                return Z2.SIZED.h(i5) ? new C0521h2(m2Var) : new C0521h2(m2Var);
            default:
                return new O3(this, m2Var);
        }
    }
}
