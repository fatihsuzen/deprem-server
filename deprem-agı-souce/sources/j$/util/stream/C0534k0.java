package j$.util.stream;

import j$.time.format.a;
import j$.util.A;
import j$.util.C;
import j$.util.C0481q;
import j$.util.E;
import j$.util.N;
import j$.util.Objects;
import j$.util.Q;
import j$.util.Spliterator;
import j$.util.c0;
import j$.util.j0;
import java.util.function.BiConsumer;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.k0  reason: case insensitive filesystem */
public abstract class C0534k0 extends C0483a implements C0549n0 {
    public final E findAny() {
        return (E) I0(H.f1484d);
    }

    public final E findFirst() {
        return (E) I0(H.f1483c);
    }

    public final C0549n0 sorted() {
        return new G2(this, Z2.f1635q | Z2.f1633o, 0);
    }

    public void forEach(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        I0(new O(longConsumer, false));
    }

    public void forEachOrdered(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        I0(new O(longConsumer, true));
    }

    public static c0 U0(Spliterator spliterator) {
        if (spliterator instanceof c0) {
            return (c0) spliterator;
        }
        if (H3.f1490a) {
            H3.a(C0483a.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    public final C0487a3 M0() {
        return C0487a3.LONG_VALUE;
    }

    public final H0 K0(C0483a aVar, Spliterator spliterator, boolean z4, IntFunction intFunction) {
        return C0594w1.d0(aVar, spliterator, z4);
    }

    public final Spliterator T0(C0483a aVar, Supplier supplier, boolean z4) {
        return new C0492b3(aVar, supplier, z4);
    }

    public final boolean L0(Spliterator spliterator, C0546m2 m2Var) {
        LongConsumer longConsumer;
        boolean e5;
        c0 U02 = U0(spliterator);
        if (m2Var instanceof LongConsumer) {
            longConsumer = (LongConsumer) m2Var;
        } else if (!H3.f1490a) {
            Objects.requireNonNull(m2Var);
            longConsumer = new N(m2Var, 1);
        } else {
            H3.a(C0483a.class, "using LongStream.adapt(Sink<Long> s)");
            throw null;
        }
        do {
            e5 = m2Var.e();
            if (e5 || !U02.tryAdvance(longConsumer)) {
                return e5;
            }
            e5 = m2Var.e();
            break;
        } while (!U02.tryAdvance(longConsumer));
        return e5;
    }

    public final C0608z0 A0(long j5, IntFunction intFunction) {
        return C0594w1.t0(j5);
    }

    public final Q iterator() {
        c0 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j0(spliterator);
    }

    public final c0 spliterator() {
        return U0(super.spliterator());
    }

    public final D asDoubleStream() {
        return new C0572s(this, Z2.f1632n, 5);
    }

    public final Stream boxed() {
        return new r(this, 0, new C0494c0(2), 2);
    }

    public final C0549n0 e() {
        Objects.requireNonNull(null);
        return new C0582u(this, Z2.f1634p | Z2.f1632n, 3);
    }

    public final Stream mapToObj(LongFunction longFunction) {
        Objects.requireNonNull(longFunction);
        return new r(this, Z2.f1634p | Z2.f1632n, longFunction, 2);
    }

    public final IntStream A() {
        Objects.requireNonNull(null);
        return new C0577t(this, Z2.f1634p | Z2.f1632n, 4);
    }

    public final D j() {
        Objects.requireNonNull(null);
        return new C0572s(this, Z2.f1634p | Z2.f1632n, 6);
    }

    public final C0549n0 d(C0481q qVar) {
        Objects.requireNonNull(qVar);
        return new C0514g0(this, Z2.f1634p | Z2.f1632n | Z2.f1638t, qVar, 0);
    }

    public final C0549n0 b() {
        Objects.requireNonNull(null);
        return new C0582u(this, Z2.f1638t, 5);
    }

    public final C0549n0 peek(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return new C0514g0(this, longConsumer);
    }

    public final C0549n0 limit(long j5) {
        if (j5 >= 0) {
            return C0594w1.z0(this, 0, j5);
        }
        throw new IllegalArgumentException(Long.toString(j5));
    }

    public final C0549n0 skip(long j5) {
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 >= 0) {
            return i5 == 0 ? this : C0594w1.z0(this, j5, -1);
        }
        throw new IllegalArgumentException(Long.toString(j5));
    }

    public final C0549n0 a() {
        int i5 = d4.f1698a;
        Objects.requireNonNull(null);
        return new G2(this, d4.f1698a, 1);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.stream.n0, j$.util.stream.a] */
    public final C0549n0 c() {
        int i5 = d4.f1698a;
        Objects.requireNonNull(null);
        return new C0483a(this, d4.f1699b);
    }

    public final C0549n0 distinct() {
        return ((C0506e2) boxed()).distinct().mapToLong(new C0553o(29));
    }

    public final long sum() {
        return reduce(0, new C0494c0(7));
    }

    public final E min() {
        return reduce(new C0553o(28));
    }

    public final E max() {
        return reduce(new C0494c0(6));
    }

    public final C average() {
        long[] jArr = (long[]) collect(new C0494c0(3), new C0494c0(4), new C0494c0(5));
        long j5 = jArr[0];
        return j5 > 0 ? new C(((double) jArr[1]) / ((double) j5)) : C.f1255c;
    }

    public final long reduce(long j5, LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return ((Long) I0(new C0599x1(C0487a3.LONG_VALUE, longBinaryOperator, j5))).longValue();
    }

    public final A summaryStatistics() {
        return (A) collect(new a(14), new C0553o(27), new C0494c0(0));
    }

    public final Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C0558p pVar = new C0558p(biConsumer, 2);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objLongConsumer);
        Objects.requireNonNull(pVar);
        return I0(new B1(C0487a3.LONG_VALUE, pVar, objLongConsumer, supplier, 0));
    }

    public final boolean q() {
        return ((Boolean) I0(C0594w1.y0(C0583u0.ANY))).booleanValue();
    }

    public final E reduce(LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return (E) I0(new C0609z1(C0487a3.LONG_VALUE, longBinaryOperator, 0));
    }

    public final boolean w() {
        return ((Boolean) I0(C0594w1.y0(C0583u0.ALL))).booleanValue();
    }

    public final boolean m() {
        return ((Boolean) I0(C0594w1.y0(C0583u0.NONE))).booleanValue();
    }

    public final long[] toArray() {
        return (long[]) C0594w1.p0((F0) J0(new C0494c0(1))).b();
    }

    public final long count() {
        return ((Long) I0(new D1(0))).longValue();
    }
}
