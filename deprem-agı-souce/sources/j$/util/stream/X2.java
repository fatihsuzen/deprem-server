package j$.util.stream;

import j$.util.B;
import j$.util.C0469e;
import j$.util.C0481q;
import j$.util.Spliterator;
import j$.util.g0;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
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
import java.util.stream.Stream;

public final /* synthetic */ class X2 implements Stream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Stream f1609a;

    public /* synthetic */ X2(Stream stream) {
        this.f1609a = stream;
    }

    public static /* synthetic */ Stream f(Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof Stream.Wrapper ? Stream.this : new X2(stream);
    }

    public final /* synthetic */ boolean allMatch(Predicate predicate) {
        return this.f1609a.allMatch(predicate);
    }

    public final /* synthetic */ boolean anyMatch(Predicate predicate) {
        return this.f1609a.anyMatch(predicate);
    }

    public final /* synthetic */ void close() {
        this.f1609a.close();
    }

    public final /* synthetic */ Object collect(Collector collector) {
        return this.f1609a.collect(collector == null ? null : collector instanceof C0523i ? ((C0523i) collector).f1715a : new C0528j(collector));
    }

    public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.f1609a.collect(supplier, biConsumer, biConsumer2);
    }

    public final /* synthetic */ long count() {
        return this.f1609a.count();
    }

    public final /* synthetic */ Stream d(C0481q qVar) {
        return f(this.f1609a.flatMap(C0594w1.r0(qVar)));
    }

    public final /* synthetic */ Stream distinct() {
        return f(this.f1609a.distinct());
    }

    public final /* synthetic */ Stream dropWhile(Predicate predicate) {
        return f(this.f1609a.dropWhile(predicate));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.Stream stream = this.f1609a;
        if (obj instanceof X2) {
            obj = ((X2) obj).f1609a;
        }
        return stream.equals(obj);
    }

    public final /* synthetic */ Stream filter(Predicate predicate) {
        return f(this.f1609a.filter(predicate));
    }

    public final /* synthetic */ B findAny() {
        return C0469e.i(this.f1609a.findAny());
    }

    public final /* synthetic */ B findFirst() {
        return C0469e.i(this.f1609a.findFirst());
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        this.f1609a.forEach(consumer);
    }

    public final /* synthetic */ void forEachOrdered(Consumer consumer) {
        this.f1609a.forEachOrdered(consumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1609a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f1609a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f1609a.iterator();
    }

    public final /* synthetic */ C0549n0 l(C0481q qVar) {
        return C0539l0.f(this.f1609a.flatMapToLong(C0594w1.r0(qVar)));
    }

    public final /* synthetic */ Stream limit(long j5) {
        return f(this.f1609a.limit(j5));
    }

    public final /* synthetic */ Stream map(Function function) {
        return f(this.f1609a.map(function));
    }

    public final /* synthetic */ D mapToDouble(ToDoubleFunction toDoubleFunction) {
        return B.f(this.f1609a.mapToDouble(toDoubleFunction));
    }

    public final /* synthetic */ IntStream mapToInt(ToIntFunction toIntFunction) {
        return IntStream.VivifiedWrapper.convert(this.f1609a.mapToInt(toIntFunction));
    }

    public final /* synthetic */ C0549n0 mapToLong(ToLongFunction toLongFunction) {
        return C0539l0.f(this.f1609a.mapToLong(toLongFunction));
    }

    public final /* synthetic */ B max(Comparator comparator) {
        return C0469e.i(this.f1609a.max(comparator));
    }

    public final /* synthetic */ B min(Comparator comparator) {
        return C0469e.i(this.f1609a.min(comparator));
    }

    public final /* synthetic */ IntStream n(C0481q qVar) {
        return IntStream.VivifiedWrapper.convert(this.f1609a.flatMapToInt(C0594w1.r0(qVar)));
    }

    public final /* synthetic */ boolean noneMatch(Predicate predicate) {
        return this.f1609a.noneMatch(predicate);
    }

    public final /* synthetic */ C0513g onClose(Runnable runnable) {
        return C0503e.f(this.f1609a.onClose(runnable));
    }

    public final /* synthetic */ C0513g parallel() {
        return C0503e.f(this.f1609a.parallel());
    }

    public final /* synthetic */ Stream peek(Consumer consumer) {
        return f(this.f1609a.peek(consumer));
    }

    public final /* synthetic */ B reduce(BinaryOperator binaryOperator) {
        return C0469e.i(this.f1609a.reduce(binaryOperator));
    }

    public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return this.f1609a.reduce(obj, biFunction, binaryOperator);
    }

    public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
        return this.f1609a.reduce(obj, binaryOperator);
    }

    public final /* synthetic */ C0513g sequential() {
        return C0503e.f(this.f1609a.sequential());
    }

    public final /* synthetic */ Stream skip(long j5) {
        return f(this.f1609a.skip(j5));
    }

    public final /* synthetic */ Stream sorted() {
        return f(this.f1609a.sorted());
    }

    public final /* synthetic */ Stream sorted(Comparator comparator) {
        return f(this.f1609a.sorted(comparator));
    }

    public final /* synthetic */ Spliterator spliterator() {
        return g0.a(this.f1609a.spliterator());
    }

    public final /* synthetic */ Stream takeWhile(Predicate predicate) {
        return f(this.f1609a.takeWhile(predicate));
    }

    public final /* synthetic */ Object[] toArray() {
        return this.f1609a.toArray();
    }

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return this.f1609a.toArray(intFunction);
    }

    public final /* synthetic */ List toList() {
        return this.f1609a.toList();
    }

    public final /* synthetic */ C0513g unordered() {
        return C0503e.f(this.f1609a.unordered());
    }

    public final /* synthetic */ D y(C0481q qVar) {
        return B.f(this.f1609a.flatMapToDouble(C0594w1.r0(qVar)));
    }
}
