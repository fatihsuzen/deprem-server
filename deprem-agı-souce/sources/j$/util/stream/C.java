package j$.util.stream;

import j$.util.C0469e;
import j$.util.C0481q;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;
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
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final /* synthetic */ class C implements DoubleStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ D f1449a;

    public /* synthetic */ C(D d5) {
        this.f1449a = d5;
    }

    public static /* synthetic */ DoubleStream f(D d5) {
        if (d5 == null) {
            return null;
        }
        return d5 instanceof B ? ((B) d5).f1438a : new C(d5);
    }

    public final /* synthetic */ boolean allMatch(DoublePredicate doublePredicate) {
        return this.f1449a.t();
    }

    public final /* synthetic */ boolean anyMatch(DoublePredicate doublePredicate) {
        return this.f1449a.o();
    }

    public final /* synthetic */ OptionalDouble average() {
        return C0469e.n(this.f1449a.average());
    }

    public final /* synthetic */ Stream boxed() {
        return Stream.Wrapper.convert(this.f1449a.boxed());
    }

    public final /* synthetic */ void close() {
        this.f1449a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.f1449a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    public final /* synthetic */ long count() {
        return this.f1449a.count();
    }

    public final /* synthetic */ DoubleStream distinct() {
        return f(this.f1449a.distinct());
    }

    public final /* synthetic */ DoubleStream dropWhile(DoublePredicate doublePredicate) {
        return f(this.f1449a.c());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        D d5 = this.f1449a;
        if (obj instanceof C) {
            obj = ((C) obj).f1449a;
        }
        return d5.equals(obj);
    }

    public final /* synthetic */ DoubleStream filter(DoublePredicate doublePredicate) {
        return f(this.f1449a.b());
    }

    public final /* synthetic */ OptionalDouble findAny() {
        return C0469e.n(this.f1449a.findAny());
    }

    public final /* synthetic */ OptionalDouble findFirst() {
        return C0469e.n(this.f1449a.findFirst());
    }

    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.f1449a.forEach(doubleConsumer);
    }

    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.f1449a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1449a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f1449a.isParallel();
    }

    public final /* synthetic */ DoubleStream limit(long j5) {
        return f(this.f1449a.limit(j5));
    }

    public final /* synthetic */ DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
        return f(this.f1449a.e());
    }

    public final /* synthetic */ IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
        return IntStream.Wrapper.convert(this.f1449a.z());
    }

    public final /* synthetic */ LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
        return C0544m0.f(this.f1449a.u());
    }

    public final /* synthetic */ java.util.stream.Stream mapToObj(DoubleFunction doubleFunction) {
        return Stream.Wrapper.convert(this.f1449a.mapToObj(doubleFunction));
    }

    public final /* synthetic */ OptionalDouble max() {
        return C0469e.n(this.f1449a.max());
    }

    public final /* synthetic */ OptionalDouble min() {
        return C0469e.n(this.f1449a.min());
    }

    public final /* synthetic */ boolean noneMatch(DoublePredicate doublePredicate) {
        return this.f1449a.B();
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C0508f.f(this.f1449a.onClose(runnable));
    }

    public final /* synthetic */ DoubleStream peek(DoubleConsumer doubleConsumer) {
        return f(this.f1449a.peek(doubleConsumer));
    }

    public final /* synthetic */ double reduce(double d5, DoubleBinaryOperator doubleBinaryOperator) {
        return this.f1449a.reduce(d5, doubleBinaryOperator);
    }

    public final /* synthetic */ OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return C0469e.n(this.f1449a.reduce(doubleBinaryOperator));
    }

    public final /* synthetic */ DoubleStream skip(long j5) {
        return f(this.f1449a.skip(j5));
    }

    public final /* synthetic */ DoubleStream sorted() {
        return f(this.f1449a.sorted());
    }

    public final /* synthetic */ double sum() {
        return this.f1449a.sum();
    }

    public final /* synthetic */ DoubleStream takeWhile(DoublePredicate doublePredicate) {
        return f(this.f1449a.a());
    }

    public final /* synthetic */ double[] toArray() {
        return this.f1449a.toArray();
    }

    public final /* synthetic */ BaseStream unordered() {
        return C0508f.f(this.f1449a.unordered());
    }

    public final DoubleSummaryStatistics summaryStatistics() {
        this.f1449a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.DoubleSummaryStatistics");
    }

    public final DoubleStream flatMap(DoubleFunction doubleFunction) {
        D d5 = this.f1449a;
        C0481q qVar = new C0481q(5);
        qVar.f1419b = doubleFunction;
        return f(d5.d(qVar));
    }
}
