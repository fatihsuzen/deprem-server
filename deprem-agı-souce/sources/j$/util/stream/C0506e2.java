package j$.util.stream;

import j$.util.B;
import j$.util.C0481q;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.concurrent.t;
import j$.util.function.a;
import j$.util.h0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* renamed from: j$.util.stream.e2  reason: case insensitive filesystem */
public abstract class C0506e2 extends C0483a implements Stream {
    public final Stream sorted() {
        return new H2(this);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.Stream, j$.util.stream.a] */
    public final Stream distinct() {
        return new C0483a(this, Z2.f1631m | Z2.f1638t);
    }

    public final B min(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new a(comparator, 1));
    }

    public final B findAny() {
        return (B) I0(I.f1492d);
    }

    public final B findFirst() {
        return (B) I0(I.f1491c);
    }

    public final Stream sorted(Comparator comparator) {
        return new H2(this, comparator);
    }

    public final Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(binaryOperator);
        return I0(new B1(C0487a3.REFERENCE, binaryOperator, biFunction, obj, 2));
    }

    public final Object reduce(Object obj, BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        Objects.requireNonNull(binaryOperator);
        return I0(new B1(C0487a3.REFERENCE, binaryOperator, binaryOperator, obj, 2));
    }

    public void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        I0(new P(consumer, false));
    }

    public void forEachOrdered(Consumer consumer) {
        Objects.requireNonNull(consumer);
        I0(new P(consumer, true));
    }

    public final B max(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new a(comparator, 0));
    }

    public final C0487a3 M0() {
        return C0487a3.REFERENCE;
    }

    public final B reduce(BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return (B) I0(new C0609z1(C0487a3.REFERENCE, binaryOperator, 2));
    }

    public final H0 K0(C0483a aVar, Spliterator spliterator, boolean z4, IntFunction intFunction) {
        return C0594w1.a0(aVar, spliterator, z4, intFunction);
    }

    public final Spliterator T0(C0483a aVar, Supplier supplier, boolean z4) {
        return new C0492b3(aVar, supplier, z4);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final boolean L0(j$.util.Spliterator r3, j$.util.stream.C0546m2 r4) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r4.e()
            if (r0 != 0) goto L_0x000c
            boolean r1 = r3.tryAdvance(r4)
            if (r1 != 0) goto L_0x0000
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0506e2.L0(j$.util.Spliterator, j$.util.stream.m2):boolean");
    }

    public final C0608z0 A0(long j5, IntFunction intFunction) {
        return C0594w1.Y(j5, intFunction);
    }

    public final Iterator iterator() {
        Spliterator spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new h0(spliterator);
    }

    public final Stream filter(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new r(this, Z2.f1638t, predicate, 4);
    }

    public final Stream map(Function function) {
        Objects.requireNonNull(function);
        return new r(this, Z2.f1634p | Z2.f1632n, function, 5);
    }

    public final IntStream mapToInt(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new V(this, Z2.f1634p | Z2.f1632n, toIntFunction, 2);
    }

    public final Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(biConsumer);
        Objects.requireNonNull(biConsumer2);
        return I0(new B1(C0487a3.REFERENCE, biConsumer2, biConsumer, supplier, 3));
    }

    public final C0549n0 mapToLong(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new C0514g0(this, Z2.f1634p | Z2.f1632n, toLongFunction, 3);
    }

    public final D mapToDouble(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new C0592w(this, Z2.f1634p | Z2.f1632n, toDoubleFunction, 2);
    }

    public final long count() {
        return ((Long) I0(new D1(2))).longValue();
    }

    public final Stream d(C0481q qVar) {
        Objects.requireNonNull(qVar);
        return new r(this, Z2.f1634p | Z2.f1632n | Z2.f1638t, qVar, 6);
    }

    public final IntStream n(C0481q qVar) {
        Objects.requireNonNull(qVar);
        return new V(this, Z2.f1634p | Z2.f1632n | Z2.f1638t, qVar, 3);
    }

    public final D y(C0481q qVar) {
        Objects.requireNonNull(qVar);
        return new C0592w(this, Z2.f1634p | Z2.f1632n | Z2.f1638t, qVar, 3);
    }

    public final Object collect(Collector collector) {
        Collector collector2;
        Object obj;
        if (!this.f1648h.f1658r || !collector.characteristics().contains(C0518h.CONCURRENT) || (Z2.ORDERED.h(this.f1653m) && !collector.characteristics().contains(C0518h.UNORDERED))) {
            Supplier supplier = ((Collector) Objects.requireNonNull(collector)).supplier();
            BiConsumer accumulator = collector.accumulator();
            collector2 = collector;
            obj = I0(new I1(C0487a3.REFERENCE, collector.combiner(), accumulator, supplier, collector2));
        } else {
            obj = collector.supplier().get();
            forEach(new t(7, (Object) collector.accumulator(), obj));
            collector2 = collector;
        }
        if (collector2.characteristics().contains(C0518h.IDENTITY_FINISH)) {
            return obj;
        }
        return collector2.finisher().apply(obj);
    }

    public final C0549n0 l(C0481q qVar) {
        Objects.requireNonNull(qVar);
        return new C0514g0(this, Z2.f1634p | Z2.f1632n | Z2.f1638t, qVar, 2);
    }

    public final Stream peek(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new r(this, consumer);
    }

    public final Stream limit(long j5) {
        if (j5 >= 0) {
            return C0594w1.C0(this, 0, j5);
        }
        throw new IllegalArgumentException(Long.toString(j5));
    }

    public final Stream skip(long j5) {
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 >= 0) {
            return i5 == 0 ? this : C0594w1.C0(this, j5, -1);
        }
        throw new IllegalArgumentException(Long.toString(j5));
    }

    public final Stream takeWhile(Predicate predicate) {
        int i5 = d4.f1698a;
        Objects.requireNonNull(predicate);
        return new I3(this, d4.f1698a, predicate);
    }

    public final Stream dropWhile(Predicate predicate) {
        int i5 = d4.f1698a;
        Objects.requireNonNull(predicate);
        return new K3(this, d4.f1699b, predicate);
    }

    public final Object[] toArray(IntFunction intFunction) {
        return C0594w1.m0(J0(intFunction), intFunction).m(intFunction);
    }

    public final Object[] toArray() {
        return toArray(new C0494c0(17));
    }

    public final boolean anyMatch(Predicate predicate) {
        return ((Boolean) I0(C0594w1.B0(C0583u0.ANY, predicate))).booleanValue();
    }

    public final boolean allMatch(Predicate predicate) {
        return ((Boolean) I0(C0594w1.B0(C0583u0.ALL, predicate))).booleanValue();
    }

    public final boolean noneMatch(Predicate predicate) {
        return ((Boolean) I0(C0594w1.B0(C0583u0.NONE, predicate))).booleanValue();
    }

    public final List toList() {
        return Collections.unmodifiableList(new ArrayList(Arrays.asList(toArray())));
    }
}
