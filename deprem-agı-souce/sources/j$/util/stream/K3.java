package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public final class K3 extends C0496c2 implements U3 {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Predicate f1525s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public K3(C0506e2 e2Var, int i5, Predicate predicate) {
        super(e2Var, i5);
        this.f1525s = predicate;
    }

    public final Spliterator O0(C0483a aVar, Spliterator spliterator) {
        if (Z2.ORDERED.h(aVar.f1653m)) {
            return N0(aVar, spliterator, new C0494c0(9)).spliterator();
        }
        return new b4(aVar.H0(spliterator), this.f1525s, 0);
    }

    public final H0 N0(C0594w1 w1Var, Spliterator spliterator, IntFunction intFunction) {
        return (H0) new W3(this, w1Var, spliterator, intFunction).invoke();
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        return new J3(this, m2Var, false);
    }

    public final V3 h(C0608z0 z0Var, boolean z4) {
        return new J3(this, z0Var, z4);
    }
}
