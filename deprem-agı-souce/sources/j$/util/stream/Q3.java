package j$.util.stream;

import j$.util.Spliterator;
import j$.util.c0;
import java.util.function.IntFunction;

public final class Q3 extends C0524i0 implements U3 {
    public final Spliterator O0(C0483a aVar, Spliterator spliterator) {
        if (Z2.ORDERED.h(aVar.f1653m)) {
            return N0(aVar, spliterator, new C0494c0(26)).spliterator();
        }
        return new a4((c0) aVar.H0(spliterator), 0);
    }

    public final H0 N0(C0594w1 w1Var, Spliterator spliterator, IntFunction intFunction) {
        return (H0) new W3(this, w1Var, spliterator, intFunction).invoke();
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        return new P3(this, m2Var, false);
    }

    public final V3 h(C0608z0 z0Var, boolean z4) {
        return new P3(this, z0Var, z4);
    }
}
