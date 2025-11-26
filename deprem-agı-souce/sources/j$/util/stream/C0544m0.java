package j$.util.stream;

import j$.util.C0469e;
import j$.util.C0481q;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
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
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/* renamed from: j$.util.stream.m0  reason: case insensitive filesystem */
public final /* synthetic */ class C0544m0 implements LongStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0549n0 f1744a;

    public /* synthetic */ C0544m0(C0549n0 n0Var) {
        this.f1744a = n0Var;
    }

    public static /* synthetic */ LongStream f(C0549n0 n0Var) {
        if (n0Var == null) {
            return null;
        }
        return n0Var instanceof C0539l0 ? ((C0539l0) n0Var).f1737a : new C0544m0(n0Var);
    }

    public final /* synthetic */ boolean allMatch(LongPredicate longPredicate) {
        return this.f1744a.w();
    }

    public final /* synthetic */ boolean anyMatch(LongPredicate longPredicate) {
        return this.f1744a.q();
    }

    public final /* synthetic */ DoubleStream asDoubleStream() {
        return C.f(this.f1744a.asDoubleStream());
    }

    public final /* synthetic */ OptionalDouble average() {
        return C0469e.n(this.f1744a.average());
    }

    public final /* synthetic */ Stream boxed() {
        return Stream.Wrapper.convert(this.f1744a.boxed());
    }

    public final /* synthetic */ void close() {
        this.f1744a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.f1744a.collect(supplier, objLongConsumer, biConsumer);
    }

    public final /* synthetic */ long count() {
        return this.f1744a.count();
    }

    public final /* synthetic */ LongStream distinct() {
        return f(this.f1744a.distinct());
    }

    public final /* synthetic */ LongStream dropWhile(LongPredicate longPredicate) {
        return f(this.f1744a.c());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0549n0 n0Var = this.f1744a;
        if (obj instanceof C0544m0) {
            obj = ((C0544m0) obj).f1744a;
        }
        return n0Var.equals(obj);
    }

    public final /* synthetic */ LongStream filter(LongPredicate longPredicate) {
        return f(this.f1744a.b());
    }

    public final /* synthetic */ OptionalLong findAny() {
        return C0469e.p(this.f1744a.findAny());
    }

    public final /* synthetic */ OptionalLong findFirst() {
        return C0469e.p(this.f1744a.findFirst());
    }

    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.f1744a.forEach(longConsumer);
    }

    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.f1744a.forEachOrdered(longConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1744a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f1744a.isParallel();
    }

    public final /* synthetic */ LongStream limit(long j5) {
        return f(this.f1744a.limit(j5));
    }

    public final /* synthetic */ LongStream map(LongUnaryOperator longUnaryOperator) {
        return f(this.f1744a.e());
    }

    public final /* synthetic */ DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction) {
        return C.f(this.f1744a.j());
    }

    public final /* synthetic */ IntStream mapToInt(LongToIntFunction longToIntFunction) {
        return IntStream.Wrapper.convert(this.f1744a.A());
    }

    public final /* synthetic */ java.util.stream.Stream mapToObj(LongFunction longFunction) {
        return Stream.Wrapper.convert(this.f1744a.mapToObj(longFunction));
    }

    public final /* synthetic */ OptionalLong max() {
        return C0469e.p(this.f1744a.max());
    }

    public final /* synthetic */ OptionalLong min() {
        return C0469e.p(this.f1744a.min());
    }

    public final /* synthetic */ boolean noneMatch(LongPredicate longPredicate) {
        return this.f1744a.m();
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C0508f.f(this.f1744a.onClose(runnable));
    }

    public final /* synthetic */ LongStream peek(LongConsumer longConsumer) {
        return f(this.f1744a.peek(longConsumer));
    }

    public final /* synthetic */ long reduce(long j5, LongBinaryOperator longBinaryOperator) {
        return this.f1744a.reduce(j5, longBinaryOperator);
    }

    public final /* synthetic */ OptionalLong reduce(LongBinaryOperator longBinaryOperator) {
        return C0469e.p(this.f1744a.reduce(longBinaryOperator));
    }

    public final /* synthetic */ LongStream skip(long j5) {
        return f(this.f1744a.skip(j5));
    }

    public final /* synthetic */ LongStream sorted() {
        return f(this.f1744a.sorted());
    }

    public final /* synthetic */ long sum() {
        return this.f1744a.sum();
    }

    public final /* synthetic */ LongStream takeWhile(LongPredicate longPredicate) {
        return f(this.f1744a.a());
    }

    public final /* synthetic */ long[] toArray() {
        return this.f1744a.toArray();
    }

    public final /* synthetic */ BaseStream unordered() {
        return C0508f.f(this.f1744a.unordered());
    }

    public final LongSummaryStatistics summaryStatistics() {
        this.f1744a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.LongSummaryStatistics");
    }

    public final LongStream flatMap(LongFunction longFunction) {
        C0549n0 n0Var = this.f1744a;
        C0481q qVar = new C0481q(7);
        qVar.f1419b = longFunction;
        return f(n0Var.d(qVar));
    }
}
