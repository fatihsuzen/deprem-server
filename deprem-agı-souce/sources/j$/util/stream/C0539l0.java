package j$.util.stream;

import j$.util.A;
import j$.util.C;
import j$.util.C0469e;
import j$.util.C0481q;
import j$.util.E;
import j$.util.stream.IntStream;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.LongStream;

/* renamed from: j$.util.stream.l0  reason: case insensitive filesystem */
public final /* synthetic */ class C0539l0 implements C0549n0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongStream f1737a;

    public /* synthetic */ C0539l0(LongStream longStream) {
        this.f1737a = longStream;
    }

    public static /* synthetic */ C0549n0 f(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof C0544m0 ? ((C0544m0) longStream).f1744a : new C0539l0(longStream);
    }

    public final /* synthetic */ IntStream A() {
        return IntStream.VivifiedWrapper.convert(this.f1737a.mapToInt((LongToIntFunction) null));
    }

    public final /* synthetic */ C0549n0 a() {
        return f(this.f1737a.takeWhile((LongPredicate) null));
    }

    public final /* synthetic */ D asDoubleStream() {
        return B.f(this.f1737a.asDoubleStream());
    }

    public final /* synthetic */ C average() {
        return C0469e.j(this.f1737a.average());
    }

    public final /* synthetic */ C0549n0 b() {
        return f(this.f1737a.filter((LongPredicate) null));
    }

    public final /* synthetic */ Stream boxed() {
        return X2.f(this.f1737a.boxed());
    }

    public final /* synthetic */ C0549n0 c() {
        return f(this.f1737a.dropWhile((LongPredicate) null));
    }

    public final /* synthetic */ void close() {
        this.f1737a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.f1737a.collect(supplier, objLongConsumer, biConsumer);
    }

    public final /* synthetic */ long count() {
        return this.f1737a.count();
    }

    public final /* synthetic */ C0549n0 distinct() {
        return f(this.f1737a.distinct());
    }

    public final /* synthetic */ C0549n0 e() {
        return f(this.f1737a.map((LongUnaryOperator) null));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        LongStream longStream = this.f1737a;
        if (obj instanceof C0539l0) {
            obj = ((C0539l0) obj).f1737a;
        }
        return longStream.equals(obj);
    }

    public final /* synthetic */ E findAny() {
        return C0469e.l(this.f1737a.findAny());
    }

    public final /* synthetic */ E findFirst() {
        return C0469e.l(this.f1737a.findFirst());
    }

    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.f1737a.forEach(longConsumer);
    }

    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.f1737a.forEachOrdered(longConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1737a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f1737a.isParallel();
    }

    public final /* synthetic */ D j() {
        return B.f(this.f1737a.mapToDouble((LongToDoubleFunction) null));
    }

    public final /* synthetic */ C0549n0 limit(long j5) {
        return f(this.f1737a.limit(j5));
    }

    public final /* synthetic */ boolean m() {
        return this.f1737a.noneMatch((LongPredicate) null);
    }

    public final /* synthetic */ Stream mapToObj(LongFunction longFunction) {
        return X2.f(this.f1737a.mapToObj(longFunction));
    }

    public final /* synthetic */ E max() {
        return C0469e.l(this.f1737a.max());
    }

    public final /* synthetic */ E min() {
        return C0469e.l(this.f1737a.min());
    }

    public final /* synthetic */ C0513g onClose(Runnable runnable) {
        return C0503e.f(this.f1737a.onClose(runnable));
    }

    public final /* synthetic */ C0549n0 peek(LongConsumer longConsumer) {
        return f(this.f1737a.peek(longConsumer));
    }

    public final /* synthetic */ boolean q() {
        return this.f1737a.anyMatch((LongPredicate) null);
    }

    public final /* synthetic */ long reduce(long j5, LongBinaryOperator longBinaryOperator) {
        return this.f1737a.reduce(j5, longBinaryOperator);
    }

    public final /* synthetic */ E reduce(LongBinaryOperator longBinaryOperator) {
        return C0469e.l(this.f1737a.reduce(longBinaryOperator));
    }

    public final /* synthetic */ C0549n0 skip(long j5) {
        return f(this.f1737a.skip(j5));
    }

    public final /* synthetic */ C0549n0 sorted() {
        return f(this.f1737a.sorted());
    }

    public final /* synthetic */ long sum() {
        return this.f1737a.sum();
    }

    public final /* synthetic */ long[] toArray() {
        return this.f1737a.toArray();
    }

    public final /* synthetic */ C0513g unordered() {
        return C0503e.f(this.f1737a.unordered());
    }

    public final /* synthetic */ boolean w() {
        return this.f1737a.allMatch((LongPredicate) null);
    }

    public final A summaryStatistics() {
        this.f1737a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    public final C0549n0 d(C0481q qVar) {
        LongStream longStream = this.f1737a;
        C0481q qVar2 = new C0481q(7);
        qVar2.f1419b = qVar;
        return f(longStream.flatMap(qVar2));
    }
}
