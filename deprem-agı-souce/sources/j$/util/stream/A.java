package j$.util.stream;

import j$.time.format.a;
import j$.util.C;
import j$.util.C0481q;
import j$.util.C0616x;
import j$.util.F;
import j$.util.I;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.W;
import j$.util.k0;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

public abstract class A extends C0483a implements D {
    public final C findAny() {
        return (C) I0(F.f1473d);
    }

    public final C findFirst() {
        return (C) I0(F.f1472c);
    }

    public final D sorted() {
        return new E2(this, Z2.f1635q | Z2.f1633o, 0);
    }

    public static W U0(Spliterator spliterator) {
        if (spliterator instanceof W) {
            return (W) spliterator;
        }
        if (H3.f1490a) {
            H3.a(C0483a.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    public void forEach(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        I0(new M(doubleConsumer, false));
    }

    public void forEachOrdered(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        I0(new M(doubleConsumer, true));
    }

    public final C0487a3 M0() {
        return C0487a3.DOUBLE_VALUE;
    }

    public final H0 K0(C0483a aVar, Spliterator spliterator, boolean z4, IntFunction intFunction) {
        return C0594w1.b0(aVar, spliterator, z4);
    }

    public final Spliterator T0(C0483a aVar, Supplier supplier, boolean z4) {
        return new C0492b3(aVar, supplier, z4);
    }

    public final boolean L0(Spliterator spliterator, C0546m2 m2Var) {
        DoubleConsumer doubleConsumer;
        boolean e5;
        W U02 = U0(spliterator);
        if (m2Var instanceof DoubleConsumer) {
            doubleConsumer = (DoubleConsumer) m2Var;
        } else if (!H3.f1490a) {
            Objects.requireNonNull(m2Var);
            doubleConsumer = new F(m2Var, 1);
        } else {
            H3.a(C0483a.class, "using DoubleStream.adapt(Sink<Double> s)");
            throw null;
        }
        do {
            e5 = m2Var.e();
            if (e5 || !U02.tryAdvance(doubleConsumer)) {
                return e5;
            }
            e5 = m2Var.e();
            break;
        } while (!U02.tryAdvance(doubleConsumer));
        return e5;
    }

    public final C0608z0 A0(long j5, IntFunction intFunction) {
        return C0594w1.h0(j5);
    }

    public final I iterator() {
        W spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new k0(spliterator);
    }

    public final W spliterator() {
        return U0(super.spliterator());
    }

    public final Stream boxed() {
        return new r(this, 0, new C0553o(1), 0);
    }

    public final D e() {
        Objects.requireNonNull(null);
        return new C0572s(this, Z2.f1634p | Z2.f1632n, 0);
    }

    public final Stream mapToObj(DoubleFunction doubleFunction) {
        Objects.requireNonNull(doubleFunction);
        return new r(this, Z2.f1634p | Z2.f1632n, doubleFunction, 0);
    }

    public final IntStream z() {
        Objects.requireNonNull(null);
        return new C0577t(this, Z2.f1634p | Z2.f1632n, 0);
    }

    public final C0549n0 u() {
        Objects.requireNonNull(null);
        return new C0582u(this, Z2.f1634p | Z2.f1632n, 0);
    }

    public final D d(C0481q qVar) {
        Objects.requireNonNull(qVar);
        return new C0592w(this, Z2.f1634p | Z2.f1632n | Z2.f1638t, qVar, 0);
    }

    public final D b() {
        Objects.requireNonNull(null);
        return new C0572s(this, Z2.f1638t, 2);
    }

    public final D peek(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return new C0592w(this, doubleConsumer);
    }

    public final D limit(long j5) {
        if (j5 >= 0) {
            return C0594w1.v0(this, 0, j5);
        }
        throw new IllegalArgumentException(Long.toString(j5));
    }

    public final D skip(long j5) {
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 >= 0) {
            return i5 == 0 ? this : C0594w1.v0(this, j5, -1);
        }
        throw new IllegalArgumentException(Long.toString(j5));
    }

    public final D a() {
        int i5 = d4.f1698a;
        Objects.requireNonNull(null);
        return new E2(this, d4.f1698a, 1);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.stream.a, j$.util.stream.D] */
    public final D c() {
        int i5 = d4.f1698a;
        Objects.requireNonNull(null);
        return new C0483a(this, d4.f1699b);
    }

    public final D distinct() {
        return ((C0506e2) boxed()).distinct().mapToDouble(new C0553o(2));
    }

    public final double sum() {
        double[] dArr = (double[]) collect(new C0553o(5), new C0553o(6), new a(24));
        Set set = Collectors.f1457a;
        double d5 = dArr[0] + dArr[1];
        double d6 = dArr[dArr.length - 1];
        return (!Double.isNaN(d5) || !Double.isInfinite(d6)) ? d5 : d6;
    }

    public final C min() {
        return reduce(new a(25));
    }

    public final C max() {
        return reduce(new C0553o(4));
    }

    public final C average() {
        double[] dArr = (double[]) collect(new a(26), new a(27), new a(28));
        if (dArr[2] <= 0.0d) {
            return C.f1255c;
        }
        Set set = Collectors.f1457a;
        double d5 = dArr[0] + dArr[1];
        double d6 = dArr[dArr.length - 1];
        if (Double.isNaN(d5) && Double.isInfinite(d6)) {
            d5 = d6;
        }
        return new C(d5 / dArr[2]);
    }

    public final C0616x summaryStatistics() {
        return (C0616x) collect(new a(10), new a(29), new C0553o(0));
    }

    public final Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C0558p pVar = new C0558p(biConsumer, 0);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objDoubleConsumer);
        Objects.requireNonNull(pVar);
        return I0(new B1(C0487a3.DOUBLE_VALUE, pVar, objDoubleConsumer, supplier, 1));
    }

    public final boolean o() {
        return ((Boolean) I0(C0594w1.u0(C0583u0.ANY))).booleanValue();
    }

    public final boolean t() {
        return ((Boolean) I0(C0594w1.u0(C0583u0.ALL))).booleanValue();
    }

    public final boolean B() {
        return ((Boolean) I0(C0594w1.u0(C0583u0.NONE))).booleanValue();
    }

    public final double[] toArray() {
        return (double[]) C0594w1.n0((B0) J0(new C0553o(3))).b();
    }

    public final double reduce(double d5, DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return ((Double) I0(new F1(C0487a3.DOUBLE_VALUE, doubleBinaryOperator, d5))).doubleValue();
    }

    public final C reduce(DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return (C) I0(new C0609z1(C0487a3.DOUBLE_VALUE, doubleBinaryOperator, 1));
    }

    public final long count() {
        return ((Long) I0(new D1(1))).longValue();
    }
}
