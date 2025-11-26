package j$.util.stream;

import j$.util.C0470f;
import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

public final class H2 extends C0496c2 {

    /* renamed from: s  reason: collision with root package name */
    public final boolean f1488s;

    /* renamed from: t  reason: collision with root package name */
    public final Comparator f1489t;

    public H2(C0506e2 e2Var) {
        super(e2Var, Z2.f1635q | Z2.f1633o);
        this.f1488s = true;
        this.f1489t = C0470f.INSTANCE;
    }

    public H2(C0506e2 e2Var, Comparator comparator) {
        super(e2Var, Z2.f1635q | Z2.f1634p);
        this.f1488s = false;
        this.f1489t = (Comparator) Objects.requireNonNull(comparator);
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        Objects.requireNonNull(m2Var);
        if (Z2.SORTED.h(i5) && this.f1488s) {
            return m2Var;
        }
        if (Z2.SIZED.h(i5)) {
            return new A2(m2Var, this.f1489t);
        }
        return new A2(m2Var, this.f1489t);
    }

    public final H0 N0(C0594w1 w1Var, Spliterator spliterator, IntFunction intFunction) {
        if (Z2.SORTED.h(((C0483a) w1Var).f1653m) && this.f1488s) {
            return w1Var.j0(spliterator, false, intFunction);
        }
        Object[] m5 = w1Var.j0(spliterator, true, intFunction).m(intFunction);
        Arrays.sort(m5, this.f1489t);
        return new K0(m5);
    }
}
