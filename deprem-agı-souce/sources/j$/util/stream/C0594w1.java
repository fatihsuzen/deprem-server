package j$.util.stream;

import j$.util.C0471g;
import j$.util.C0481q;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.W;
import j$.util.Z;
import j$.util.c0;
import j$.util.concurrent.t;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* renamed from: j$.util.stream.w1  reason: case insensitive filesystem */
public abstract class C0594w1 implements F3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Z0 f1814a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final X0 f1815b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static final Y0 f1816c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final W0 f1817d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f1818e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    public static final long[] f1819f = new long[0];

    /* renamed from: g  reason: collision with root package name */
    public static final double[] f1820g = new double[0];

    public abstract C0608z0 A0(long j5, IntFunction intFunction);

    public abstract R1 D0();

    public abstract C0546m2 F0(Spliterator spliterator, C0546m2 m2Var);

    public abstract C0546m2 G0(C0546m2 m2Var);

    public abstract Spliterator H0(Spliterator spliterator);

    public abstract void f0(Spliterator spliterator, C0546m2 m2Var);

    public abstract boolean g0(Spliterator spliterator, C0546m2 m2Var);

    public abstract H0 j0(Spliterator spliterator, boolean z4, IntFunction intFunction);

    public abstract long k0(Spliterator spliterator);

    public /* synthetic */ int v() {
        return 0;
    }

    public static C0481q r0(Function function) {
        C0481q qVar = new C0481q(6);
        qVar.f1419b = function;
        return qVar;
    }

    public static Set q0(Set set) {
        C0518h hVar;
        Collector.Characteristics characteristics;
        if (set == null || set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Object next = set.iterator().next();
        if (next instanceof C0518h) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    C0518h hVar2 = (C0518h) it.next();
                    if (hVar2 == null) {
                        characteristics = null;
                    } else {
                        characteristics = hVar2 == C0518h.CONCURRENT ? Collector.Characteristics.CONCURRENT : hVar2 == C0518h.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH;
                    }
                    hashSet.add(characteristics);
                } catch (ClassCastException e5) {
                    C0471g.a(e5, "java.util.stream.Collector.Characteristics");
                    throw null;
                }
            }
        } else if (next instanceof Collector.Characteristics) {
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                try {
                    Collector.Characteristics characteristics2 = (Collector.Characteristics) it2.next();
                    if (characteristics2 == null) {
                        hVar = null;
                    } else {
                        hVar = characteristics2 == Collector.Characteristics.CONCURRENT ? C0518h.CONCURRENT : characteristics2 == Collector.Characteristics.UNORDERED ? C0518h.UNORDERED : C0518h.IDENTITY_FINISH;
                    }
                    hashSet.add(hVar);
                } catch (ClassCastException e6) {
                    C0471g.a(e6, "java.util.stream.Collector.Characteristics");
                    throw null;
                }
            }
        } else {
            C0471g.a(next.getClass(), "java.util.stream.Collector.Characteristics");
            throw null;
        }
        return hashSet;
    }

    public static long W(long j5, long j6, long j7) {
        if (j5 >= 0) {
            return Math.max(-1, Math.min(j5 - j6, j7));
        }
        return -1;
    }

    public static long Z(long j5, long j6) {
        long j7 = j6 >= 0 ? j5 + j6 : Long.MAX_VALUE;
        if (j7 >= 0) {
            return j7;
        }
        return Long.MAX_VALUE;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.b2, j$.util.stream.a] */
    public static C0491b2 E0(Spliterator spliterator, boolean z4) {
        Objects.requireNonNull(spliterator);
        return new C0483a(spliterator, Z2.g(spliterator), z4);
    }

    public static Spliterator X(C0487a3 a3Var, Spliterator spliterator, long j5, long j6) {
        long Z4 = Z(j5, j6);
        int i5 = C0590v2.f1810a[a3Var.ordinal()];
        if (i5 == 1) {
            return new C0581t3(spliterator, j5, Z4);
        }
        if (i5 == 2) {
            return new C0576s3((Z) spliterator, j5, Z4);
        }
        if (i5 == 3) {
            return new C0576s3((c0) spliterator, j5, Z4);
        }
        if (i5 == 4) {
            return new C0576s3((W) spliterator, j5, Z4);
        }
        throw new IllegalStateException("Unknown shape " + a3Var);
    }

    public static t B0(C0583u0 u0Var, Predicate predicate) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(u0Var);
        return new t(C0487a3.REFERENCE, u0Var, (Supplier) new t(5, (Object) u0Var, (Object) predicate));
    }

    public static C0485a1 i0(C0487a3 a3Var) {
        int i5 = I0.f1493a[a3Var.ordinal()];
        if (i5 == 1) {
            return f1814a;
        }
        if (i5 == 2) {
            return f1815b;
        }
        if (i5 == 3) {
            return f1816c;
        }
        if (i5 == 4) {
            return f1817d;
        }
        throw new IllegalStateException("Unknown shape " + a3Var);
    }

    public static t w0(C0583u0 u0Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(u0Var);
        return new t(C0487a3.INT_VALUE, u0Var, (Supplier) new C0554o0(u0Var, 1));
    }

    public static C0556o2 C0(C0506e2 e2Var, long j5, long j6) {
        if (j5 >= 0) {
            return new C0556o2(e2Var, l0(j6), j5, j6);
        }
        long j7 = j5;
        throw new IllegalArgumentException("Skip must be non-negative: " + j7);
    }

    public static H0 V(H0 h02, long j5, long j6, IntFunction intFunction) {
        if (j5 == 0 && j6 == h02.count()) {
            return h02;
        }
        Spliterator spliterator = h02.spliterator();
        long j7 = j6 - j5;
        C0608z0 Y4 = Y(j7, intFunction);
        Y4.c(j7);
        for (int i5 = 0; ((long) i5) < j5 && spliterator.tryAdvance(new C0494c0(8)); i5++) {
        }
        if (j6 == h02.count()) {
            spliterator.forEachRemaining(Y4);
        } else {
            for (int i6 = 0; ((long) i6) < j7 && spliterator.tryAdvance(Y4); i6++) {
            }
        }
        Y4.end();
        return Y4.build();
    }

    public static J0 e0(C0487a3 a3Var, H0 h02, H0 h03) {
        int i5 = I0.f1493a[a3Var.ordinal()];
        if (i5 == 1) {
            return new J0(h02, h03);
        }
        if (i5 == 2) {
            return new J0((D0) h02, (D0) h03);
        }
        if (i5 == 3) {
            return new J0((F0) h02, (F0) h03);
        }
        if (i5 == 4) {
            return new J0((B0) h02, (B0) h03);
        }
        throw new IllegalStateException("Unknown shape " + a3Var);
    }

    public static t y0(C0583u0 u0Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(u0Var);
        return new t(C0487a3.LONG_VALUE, u0Var, (Supplier) new C0554o0(u0Var, 0));
    }

    public static void J() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static t u0(C0583u0 u0Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(u0Var);
        return new t(C0487a3.DOUBLE_VALUE, u0Var, (Supplier) new C0554o0(u0Var, 2));
    }

    public static void K() {
        throw new IllegalStateException("called wrong accept method");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [j$.util.stream.z0, j$.util.stream.W2] */
    /* JADX WARNING: type inference failed for: r0v4, types: [j$.util.stream.z0, j$.util.stream.K0] */
    public static C0608z0 Y(long j5, IntFunction intFunction) {
        if (j5 < 0 || j5 >= 2147483639) {
            return new W2();
        }
        return new K0(j5, intFunction);
    }

    public static void C() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void F(C0536k2 k2Var, Integer num) {
        if (!H3.f1490a) {
            k2Var.accept(num.intValue());
        } else {
            H3.a(k2Var.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
    }

    public static void H(C0541l2 l2Var, Long l5) {
        if (!H3.f1490a) {
            l2Var.accept(l5.longValue());
        } else {
            H3.a(l2Var.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [j$.util.stream.x0, j$.util.stream.V2] */
    /* JADX WARNING: type inference failed for: r0v4, types: [j$.util.stream.x0, j$.util.stream.c1] */
    public static C0598x0 s0(long j5) {
        if (j5 < 0 || j5 >= 2147483639) {
            return new V2();
        }
        return new C0495c1(j5);
    }

    public static void D(C0531j2 j2Var, Double d5) {
        if (!H3.f1490a) {
            j2Var.accept(d5.doubleValue());
        } else {
            H3.a(j2Var.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
    }

    public static C0566q2 x0(C0489b0 b0Var, long j5, long j6) {
        if (j5 >= 0) {
            return new C0566q2(b0Var, l0(j6), j5, j6);
        }
        long j7 = j5;
        throw new IllegalArgumentException("Skip must be non-negative: " + j7);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [j$.util.stream.y0, j$.util.stream.V2] */
    /* JADX WARNING: type inference failed for: r0v4, types: [j$.util.stream.y0, j$.util.stream.l1] */
    public static C0603y0 t0(long j5) {
        if (j5 < 0 || j5 >= 2147483639) {
            return new V2();
        }
        return new C0540l1(j5);
    }

    public static Object[] L(G0 g02, IntFunction intFunction) {
        if (H3.f1490a) {
            H3.a(g02.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        } else if (g02.count() < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) g02.count());
            g02.k(objArr, 0);
            return objArr;
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [j$.util.stream.w0, j$.util.stream.V2] */
    /* JADX WARNING: type inference failed for: r0v4, types: [j$.util.stream.w0, j$.util.stream.T0] */
    public static C0593w0 h0(long j5) {
        if (j5 < 0 || j5 >= 2147483639) {
            return new V2();
        }
        return new T0(j5);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.function.LongFunction, j$.util.stream.L, java.lang.Object] */
    public static H0 a0(C0594w1 w1Var, Spliterator spliterator, boolean z4, IntFunction intFunction) {
        long k02 = w1Var.k0(spliterator);
        if (k02 < 0 || !spliterator.hasCharacteristics(16384)) {
            ? obj = new Object();
            obj.f1526a = intFunction;
            H0 h02 = (H0) new M0(w1Var, spliterator, obj, new C0494c0(16), 3).invoke();
            return z4 ? m0(h02, intFunction) : h02;
        } else if (k02 < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) k02);
            new C0569r1(spliterator, w1Var, objArr).invoke();
            return new K0(objArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static void Q(D0 d02, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            d02.g((IntConsumer) consumer);
        } else if (!H3.f1490a) {
            ((Z) d02.spliterator()).forEachRemaining(consumer);
        } else {
            H3.a(d02.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
            throw null;
        }
    }

    public static C0575s2 z0(C0534k0 k0Var, long j5, long j6) {
        if (j5 >= 0) {
            return new C0575s2(k0Var, l0(j6), j5, j6);
        }
        long j7 = j5;
        throw new IllegalArgumentException("Skip must be non-negative: " + j7);
    }

    public static void N(D0 d02, Integer[] numArr, int i5) {
        if (!H3.f1490a) {
            int[] iArr = (int[]) d02.b();
            for (int i6 = 0; i6 < iArr.length; i6++) {
                numArr[i5 + i6] = Integer.valueOf(iArr[i6]);
            }
            return;
        }
        H3.a(d02.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
        throw null;
    }

    public static D0 T(D0 d02, long j5, long j6) {
        if (j5 == 0 && j6 == d02.count()) {
            return d02;
        }
        long j7 = j6 - j5;
        Z z4 = (Z) d02.spliterator();
        C0598x0 s02 = s0(j7);
        s02.c(j7);
        for (int i5 = 0; ((long) i5) < j5 && z4.tryAdvance(new C0(0)); i5++) {
        }
        if (j6 == d02.count()) {
            z4.forEachRemaining(s02);
        } else {
            for (int i6 = 0; ((long) i6) < j7 && z4.tryAdvance(s02); i6++) {
            }
        }
        s02.end();
        return s02.build();
    }

    public static D0 c0(C0594w1 w1Var, Spliterator spliterator, boolean z4) {
        long k02 = w1Var.k0(spliterator);
        if (k02 < 0 || !spliterator.hasCharacteristics(16384)) {
            D0 d02 = (D0) new M0(w1Var, spliterator, new C0494c0(12), new C0494c0(13), 1).invoke();
            return z4 ? o0(d02) : d02;
        } else if (k02 < 2147483639) {
            int[] iArr = new int[((int) k02)];
            new C0560p1(spliterator, w1Var, iArr).invoke();
            return new C0495c1(iArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static F0 d0(C0594w1 w1Var, Spliterator spliterator, boolean z4) {
        long k02 = w1Var.k0(spliterator);
        if (k02 < 0 || !spliterator.hasCharacteristics(16384)) {
            F0 f02 = (F0) new M0(w1Var, spliterator, new C0494c0(14), new C0494c0(15), 2).invoke();
            return z4 ? p0(f02) : f02;
        } else if (k02 < 2147483639) {
            long[] jArr = new long[((int) k02)];
            new C0565q1(spliterator, w1Var, jArr).invoke();
            return new C0540l1(jArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static void R(F0 f02, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            f02.g((LongConsumer) consumer);
        } else if (!H3.f1490a) {
            ((c0) f02.spliterator()).forEachRemaining(consumer);
        } else {
            H3.a(f02.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        }
    }

    public static void O(F0 f02, Long[] lArr, int i5) {
        if (!H3.f1490a) {
            long[] jArr = (long[]) f02.b();
            for (int i6 = 0; i6 < jArr.length; i6++) {
                lArr[i5 + i6] = Long.valueOf(jArr[i6]);
            }
            return;
        }
        H3.a(f02.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
        throw null;
    }

    public static F0 U(F0 f02, long j5, long j6) {
        if (j5 == 0 && j6 == f02.count()) {
            return f02;
        }
        long j7 = j6 - j5;
        c0 c0Var = (c0) f02.spliterator();
        C0603y0 t02 = t0(j7);
        t02.c(j7);
        for (int i5 = 0; ((long) i5) < j5 && c0Var.tryAdvance(new E0(0)); i5++) {
        }
        if (j6 == f02.count()) {
            c0Var.forEachRemaining(t02);
        } else {
            for (int i6 = 0; ((long) i6) < j7 && c0Var.tryAdvance(t02); i6++) {
            }
        }
        t02.end();
        return t02.build();
    }

    public static B0 b0(C0594w1 w1Var, Spliterator spliterator, boolean z4) {
        long k02 = w1Var.k0(spliterator);
        if (k02 < 0 || !spliterator.hasCharacteristics(16384)) {
            B0 b02 = (B0) new M0(w1Var, spliterator, new C0494c0(10), new C0494c0(11), 0).invoke();
            return z4 ? n0(b02) : b02;
        } else if (k02 < 2147483639) {
            double[] dArr = new double[((int) k02)];
            new C0555o1(spliterator, w1Var, dArr).invoke();
            return new T0(dArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static C0585u2 v0(A a5, long j5, long j6) {
        if (j5 >= 0) {
            return new C0585u2(a5, l0(j6), j5, j6);
        }
        long j7 = j5;
        throw new IllegalArgumentException("Skip must be non-negative: " + j7);
    }

    public static H0 m0(H0 h02, IntFunction intFunction) {
        if (h02.o() <= 0) {
            return h02;
        }
        long count = h02.count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) count);
            new C0589v1(h02, (Object) objArr, 1).invoke();
            return new K0(objArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static void P(B0 b02, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            b02.g((DoubleConsumer) consumer);
        } else if (!H3.f1490a) {
            ((W) b02.spliterator()).forEachRemaining(consumer);
        } else {
            H3.a(b02.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        }
    }

    public static D0 o0(D0 d02) {
        if (d02.o() <= 0) {
            return d02;
        }
        long count = d02.count();
        if (count < 2147483639) {
            int[] iArr = new int[((int) count)];
            new C0589v1((H0) d02, (Object) iArr, 0).invoke();
            return new C0495c1(iArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static void M(B0 b02, Double[] dArr, int i5) {
        if (!H3.f1490a) {
            double[] dArr2 = (double[]) b02.b();
            for (int i6 = 0; i6 < dArr2.length; i6++) {
                dArr[i5 + i6] = Double.valueOf(dArr2[i6]);
            }
            return;
        }
        H3.a(b02.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
        throw null;
    }

    public static B0 S(B0 b02, long j5, long j6) {
        if (j5 == 0 && j6 == b02.count()) {
            return b02;
        }
        long j7 = j6 - j5;
        W w4 = (W) b02.spliterator();
        C0593w0 h02 = h0(j7);
        h02.c(j7);
        for (int i5 = 0; ((long) i5) < j5 && w4.tryAdvance(new A0(0)); i5++) {
        }
        if (j6 == b02.count()) {
            w4.forEachRemaining(h02);
        } else {
            for (int i6 = 0; ((long) i6) < j7 && w4.tryAdvance(h02); i6++) {
            }
        }
        h02.end();
        return h02.build();
    }

    public static F0 p0(F0 f02) {
        if (f02.o() <= 0) {
            return f02;
        }
        long count = f02.count();
        if (count < 2147483639) {
            long[] jArr = new long[((int) count)];
            new C0589v1((H0) f02, (Object) jArr, 0).invoke();
            return new C0540l1(jArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static int l0(long j5) {
        return (j5 != -1 ? Z2.f1639u : 0) | Z2.f1638t;
    }

    public static B0 n0(B0 b02) {
        if (b02.o() <= 0) {
            return b02;
        }
        long count = b02.count();
        if (count < 2147483639) {
            double[] dArr = new double[((int) count)];
            new C0589v1((H0) b02, (Object) dArr, 0).invoke();
            return new T0(dArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public Object f(C0483a aVar, Spliterator spliterator) {
        R1 D02 = D0();
        aVar.F0(spliterator, D02);
        return D02.get();
    }

    public Object i(C0594w1 w1Var, Spliterator spliterator) {
        return ((R1) new Y1(this, w1Var, spliterator).invoke()).get();
    }
}
