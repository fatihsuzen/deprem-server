package j$.util.stream;

import j$.time.format.a;
import j$.util.C;
import j$.util.C0617y;
import j$.util.D;
import j$.util.J;
import j$.util.M;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Z;
import j$.util.i0;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.b0  reason: case insensitive filesystem */
public abstract class C0489b0 extends C0483a implements IntStream {
    public final D findAny() {
        return (D) I0(G.f1478d);
    }

    public final D findFirst() {
        return (D) I0(G.f1477c);
    }

    public final IntStream sorted() {
        return new F2(this, Z2.f1635q | Z2.f1633o, 0);
    }

    public void forEach(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        I0(new N(intConsumer, false));
    }

    public void forEachOrdered(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        I0(new N(intConsumer, true));
    }

    public static Z U0(Spliterator spliterator) {
        if (spliterator instanceof Z) {
            return (Z) spliterator;
        }
        if (H3.f1490a) {
            H3.a(C0483a.class, "using IntStream.adapt(Spliterator<Integer> s)");
            throw null;
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    public final C0487a3 M0() {
        return C0487a3.INT_VALUE;
    }

    public final H0 K0(C0483a aVar, Spliterator spliterator, boolean z4, IntFunction intFunction) {
        return C0594w1.c0(aVar, spliterator, z4);
    }

    public final Spliterator T0(C0483a aVar, Supplier supplier, boolean z4) {
        return new C0492b3(aVar, supplier, z4);
    }

    public final boolean L0(Spliterator spliterator, C0546m2 m2Var) {
        IntConsumer intConsumer;
        boolean e5;
        Z U02 = U0(spliterator);
        if (m2Var instanceof IntConsumer) {
            intConsumer = (IntConsumer) m2Var;
        } else if (!H3.f1490a) {
            Objects.requireNonNull(m2Var);
            intConsumer = new J(m2Var, 1);
        } else {
            H3.a(C0483a.class, "using IntStream.adapt(Sink<Integer> s)");
            throw null;
        }
        do {
            e5 = m2Var.e();
            if (e5 || !U02.tryAdvance(intConsumer)) {
                return e5;
            }
            e5 = m2Var.e();
            break;
        } while (!U02.tryAdvance(intConsumer));
        return e5;
    }

    public final C0608z0 A0(long j5, IntFunction intFunction) {
        return C0594w1.s0(j5);
    }

    public final M iterator() {
        Z spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new i0(spliterator);
    }

    public final Z spliterator() {
        return U0(super.spliterator());
    }

    public final C0549n0 asLongStream() {
        return new C0582u(this, 0, 1);
    }

    public final D asDoubleStream() {
        return new C0572s(this, 0, 3);
    }

    public final Stream boxed() {
        return new r(this, 0, new C0553o(18), 1);
    }

    public final IntStream e() {
        Objects.requireNonNull(null);
        return new C0577t(this, Z2.f1634p | Z2.f1632n, 1);
    }

    public final Stream mapToObj(IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new r(this, Z2.f1634p | Z2.f1632n, intFunction, 1);
    }

    public final C0549n0 k() {
        Objects.requireNonNull(null);
        return new C0582u(this, Z2.f1634p | Z2.f1632n, 2);
    }

    public final D g() {
        Objects.requireNonNull(null);
        return new C0572s(this, Z2.f1634p | Z2.f1632n, 4);
    }

    public final int reduce(int i5, IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return ((Integer) I0(new M1(C0487a3.INT_VALUE, intBinaryOperator, i5))).intValue();
    }

    public final IntStream r(L l5) {
        Objects.requireNonNull(l5);
        return new V(this, Z2.f1634p | Z2.f1632n | Z2.f1638t, l5, 1);
    }

    public final D reduce(IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return (D) I0(new C0609z1(C0487a3.INT_VALUE, intBinaryOperator, 3));
    }

    public final IntStream b() {
        Objects.requireNonNull(null);
        return new C0577t(this, Z2.f1638t, 3);
    }

    public final IntStream peek(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return new V(this, intConsumer);
    }

    public final IntStream limit(long j5) {
        if (j5 >= 0) {
            return C0594w1.x0(this, 0, j5);
        }
        throw new IllegalArgumentException(Long.toString(j5));
    }

    public final IntStream skip(long j5) {
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 >= 0) {
            return i5 == 0 ? this : C0594w1.x0(this, j5, -1);
        }
        throw new IllegalArgumentException(Long.toString(j5));
    }

    public final IntStream a() {
        int i5 = d4.f1698a;
        Objects.requireNonNull(null);
        return new F2(this, d4.f1698a, 1);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    public final IntStream c() {
        int i5 = d4.f1698a;
        Objects.requireNonNull(null);
        return new C0483a(this, d4.f1699b);
    }

    public final long count() {
        return ((Long) I0(new D1(3))).longValue();
    }

    public final IntStream distinct() {
        return ((C0506e2) boxed()).distinct().mapToInt(new C0553o(17));
    }

    public final int sum() {
        return reduce(0, new C0553o(22));
    }

    public final D min() {
        return reduce(new C0553o(19));
    }

    public final D max() {
        return reduce(new C0553o(23));
    }

    public final C average() {
        long[] jArr = (long[]) collect(new C0553o(24), new C0553o(25), new C0553o(26));
        long j5 = jArr[0];
        return j5 > 0 ? new C(((double) jArr[1]) / ((double) j5)) : C.f1255c;
    }

    public final C0617y summaryStatistics() {
        return (C0617y) collect(new a(13), new C0553o(20), new C0553o(21));
    }

    public final Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C0558p pVar = new C0558p(biConsumer, 1);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objIntConsumer);
        Objects.requireNonNull(pVar);
        return I0(new B1(C0487a3.INT_VALUE, pVar, objIntConsumer, supplier, 4));
    }

    public final boolean x() {
        return ((Boolean) I0(C0594w1.w0(C0583u0.ANY))).booleanValue();
    }

    public final boolean p() {
        return ((Boolean) I0(C0594w1.w0(C0583u0.ALL))).booleanValue();
    }

    public final boolean s() {
        return ((Boolean) I0(C0594w1.w0(C0583u0.NONE))).booleanValue();
    }

    public final int[] toArray() {
        return (int[]) C0594w1.o0((D0) J0(new C0553o(16))).b();
    }
}
