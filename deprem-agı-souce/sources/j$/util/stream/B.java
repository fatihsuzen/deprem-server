package j$.util.stream;

import j$.util.C;
import j$.util.C0469e;
import j$.util.C0481q;
import j$.util.C0616x;
import j$.util.stream.IntStream;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

public final /* synthetic */ class B implements D {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleStream f1438a;

    public /* synthetic */ B(DoubleStream doubleStream) {
        this.f1438a = doubleStream;
    }

    public static /* synthetic */ D f(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof C ? ((C) doubleStream).f1449a : new B(doubleStream);
    }

    public final /* synthetic */ boolean B() {
        return this.f1438a.noneMatch((DoublePredicate) null);
    }

    public final /* synthetic */ D a() {
        return f(this.f1438a.takeWhile((DoublePredicate) null));
    }

    public final /* synthetic */ C average() {
        return C0469e.j(this.f1438a.average());
    }

    public final /* synthetic */ D b() {
        return f(this.f1438a.filter((DoublePredicate) null));
    }

    public final /* synthetic */ Stream boxed() {
        return X2.f(this.f1438a.boxed());
    }

    public final /* synthetic */ D c() {
        return f(this.f1438a.dropWhile((DoublePredicate) null));
    }

    public final /* synthetic */ void close() {
        this.f1438a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.f1438a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    public final /* synthetic */ long count() {
        return this.f1438a.count();
    }

    public final /* synthetic */ D distinct() {
        return f(this.f1438a.distinct());
    }

    public final /* synthetic */ D e() {
        return f(this.f1438a.map((DoubleUnaryOperator) null));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        DoubleStream doubleStream = this.f1438a;
        if (obj instanceof B) {
            obj = ((B) obj).f1438a;
        }
        return doubleStream.equals(obj);
    }

    public final /* synthetic */ C findAny() {
        return C0469e.j(this.f1438a.findAny());
    }

    public final /* synthetic */ C findFirst() {
        return C0469e.j(this.f1438a.findFirst());
    }

    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.f1438a.forEach(doubleConsumer);
    }

    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.f1438a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1438a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f1438a.isParallel();
    }

    public final /* synthetic */ D limit(long j5) {
        return f(this.f1438a.limit(j5));
    }

    public final /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
        return X2.f(this.f1438a.mapToObj(doubleFunction));
    }

    public final /* synthetic */ C max() {
        return C0469e.j(this.f1438a.max());
    }

    public final /* synthetic */ C min() {
        return C0469e.j(this.f1438a.min());
    }

    public final /* synthetic */ boolean o() {
        return this.f1438a.anyMatch((DoublePredicate) null);
    }

    public final /* synthetic */ C0513g onClose(Runnable runnable) {
        return C0503e.f(this.f1438a.onClose(runnable));
    }

    public final /* synthetic */ D peek(DoubleConsumer doubleConsumer) {
        return f(this.f1438a.peek(doubleConsumer));
    }

    public final /* synthetic */ double reduce(double d5, DoubleBinaryOperator doubleBinaryOperator) {
        return this.f1438a.reduce(d5, doubleBinaryOperator);
    }

    public final /* synthetic */ C reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return C0469e.j(this.f1438a.reduce(doubleBinaryOperator));
    }

    public final /* synthetic */ D skip(long j5) {
        return f(this.f1438a.skip(j5));
    }

    public final /* synthetic */ D sorted() {
        return f(this.f1438a.sorted());
    }

    public final /* synthetic */ double sum() {
        return this.f1438a.sum();
    }

    public final /* synthetic */ boolean t() {
        return this.f1438a.allMatch((DoublePredicate) null);
    }

    public final /* synthetic */ double[] toArray() {
        return this.f1438a.toArray();
    }

    public final /* synthetic */ C0549n0 u() {
        return C0539l0.f(this.f1438a.mapToLong((DoubleToLongFunction) null));
    }

    public final /* synthetic */ C0513g unordered() {
        return C0503e.f(this.f1438a.unordered());
    }

    public final /* synthetic */ IntStream z() {
        return IntStream.VivifiedWrapper.convert(this.f1438a.mapToInt((DoubleToIntFunction) null));
    }

    public final C0616x summaryStatistics() {
        this.f1438a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    public final D d(C0481q qVar) {
        DoubleStream doubleStream = this.f1438a;
        C0481q qVar2 = new C0481q(5);
        qVar2.f1419b = qVar;
        return f(doubleStream.flatMap(qVar2));
    }
}
