package j$.util.stream;

import j$.util.B;
import j$.util.C0469e;
import j$.util.C0481q;
import j$.util.Spliterator;
import j$.util.stream.IntStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
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
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public interface Stream<T> extends C0513g {

    public final /* synthetic */ class Wrapper implements java.util.stream.Stream {
        public /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.Stream convert(Stream stream) {
            if (stream == null) {
                return null;
            }
            return stream instanceof X2 ? ((X2) stream).f1609a : new Wrapper();
        }

        public final /* synthetic */ boolean allMatch(Predicate predicate) {
            return Stream.this.allMatch(predicate);
        }

        public final /* synthetic */ boolean anyMatch(Predicate predicate) {
            return Stream.this.anyMatch(predicate);
        }

        public final /* synthetic */ void close() {
            Stream.this.close();
        }

        public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
            return Stream.this.collect(supplier, biConsumer, biConsumer2);
        }

        public final /* synthetic */ Object collect(Collector collector) {
            return Stream.this.collect(collector == null ? null : collector instanceof C0528j ? ((C0528j) collector).f1721a : new C0523i(collector));
        }

        public final /* synthetic */ long count() {
            return Stream.this.count();
        }

        public final /* synthetic */ java.util.stream.Stream distinct() {
            return convert(Stream.this.distinct());
        }

        public final /* synthetic */ java.util.stream.Stream dropWhile(Predicate predicate) {
            return convert(Stream.this.dropWhile(predicate));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            Stream stream = Stream.this;
            if (obj instanceof Wrapper) {
                obj = Stream.this;
            }
            return stream.equals(obj);
        }

        public final /* synthetic */ java.util.stream.Stream filter(Predicate predicate) {
            return convert(Stream.this.filter(predicate));
        }

        public final /* synthetic */ Optional findAny() {
            return C0469e.m(Stream.this.findAny());
        }

        public final /* synthetic */ Optional findFirst() {
            return C0469e.m(Stream.this.findFirst());
        }

        public final /* synthetic */ java.util.stream.Stream flatMap(Function function) {
            return convert(Stream.this.d(C0594w1.r0(function)));
        }

        public final /* synthetic */ DoubleStream flatMapToDouble(Function function) {
            return C.f(Stream.this.y(C0594w1.r0(function)));
        }

        public final /* synthetic */ IntStream flatMapToInt(Function function) {
            return IntStream.Wrapper.convert(Stream.this.n(C0594w1.r0(function)));
        }

        public final /* synthetic */ LongStream flatMapToLong(Function function) {
            return C0544m0.f(Stream.this.l(C0594w1.r0(function)));
        }

        public final /* synthetic */ void forEach(Consumer consumer) {
            Stream.this.forEach(consumer);
        }

        public final /* synthetic */ void forEachOrdered(Consumer consumer) {
            Stream.this.forEachOrdered(consumer);
        }

        public final /* synthetic */ int hashCode() {
            return Stream.this.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return Stream.this.isParallel();
        }

        public final /* synthetic */ Iterator iterator() {
            return Stream.this.iterator();
        }

        public final /* synthetic */ java.util.stream.Stream limit(long j5) {
            return convert(Stream.this.limit(j5));
        }

        public final /* synthetic */ java.util.stream.Stream map(Function function) {
            return convert(Stream.this.map(function));
        }

        public final /* synthetic */ DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction) {
            return C.f(Stream.this.mapToDouble(toDoubleFunction));
        }

        public final /* synthetic */ java.util.stream.IntStream mapToInt(ToIntFunction toIntFunction) {
            return IntStream.Wrapper.convert(Stream.this.mapToInt(toIntFunction));
        }

        public final /* synthetic */ LongStream mapToLong(ToLongFunction toLongFunction) {
            return C0544m0.f(Stream.this.mapToLong(toLongFunction));
        }

        public final /* synthetic */ Optional max(Comparator comparator) {
            return C0469e.m(Stream.this.max(comparator));
        }

        public final /* synthetic */ Optional min(Comparator comparator) {
            return C0469e.m(Stream.this.min(comparator));
        }

        public final /* synthetic */ boolean noneMatch(Predicate predicate) {
            return Stream.this.noneMatch(predicate);
        }

        public final /* synthetic */ BaseStream onClose(Runnable runnable) {
            return C0508f.f(Stream.this.onClose(runnable));
        }

        public final /* synthetic */ BaseStream parallel() {
            return C0508f.f(Stream.this.parallel());
        }

        public final /* synthetic */ java.util.stream.Stream peek(Consumer consumer) {
            return convert(Stream.this.peek(consumer));
        }

        public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
            return Stream.this.reduce(obj, biFunction, binaryOperator);
        }

        public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
            return Stream.this.reduce(obj, binaryOperator);
        }

        public final /* synthetic */ Optional reduce(BinaryOperator binaryOperator) {
            return C0469e.m(Stream.this.reduce(binaryOperator));
        }

        public final /* synthetic */ BaseStream sequential() {
            return C0508f.f(Stream.this.sequential());
        }

        public final /* synthetic */ java.util.stream.Stream skip(long j5) {
            return convert(Stream.this.skip(j5));
        }

        public final /* synthetic */ java.util.stream.Stream sorted() {
            return convert(Stream.this.sorted());
        }

        public final /* synthetic */ java.util.stream.Stream sorted(Comparator comparator) {
            return convert(Stream.this.sorted(comparator));
        }

        public final /* synthetic */ Spliterator spliterator() {
            return Spliterator.Wrapper.convert(Stream.this.spliterator());
        }

        public final /* synthetic */ java.util.stream.Stream takeWhile(Predicate predicate) {
            return convert(Stream.this.takeWhile(predicate));
        }

        public final /* synthetic */ Object[] toArray() {
            return Stream.this.toArray();
        }

        public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Stream.this.toArray(intFunction);
        }

        public final /* synthetic */ List toList() {
            return Stream.this.toList();
        }

        public final /* synthetic */ BaseStream unordered() {
            return C0508f.f(Stream.this.unordered());
        }
    }

    boolean allMatch(Predicate predicate);

    boolean anyMatch(Predicate predicate);

    <R, A> R collect(Collector<? super T, A, R> collector);

    Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2);

    long count();

    Stream d(C0481q qVar);

    Stream distinct();

    Stream dropWhile(Predicate predicate);

    Stream filter(Predicate predicate);

    B findAny();

    B findFirst();

    void forEach(Consumer consumer);

    void forEachOrdered(Consumer consumer);

    C0549n0 l(C0481q qVar);

    Stream limit(long j5);

    <R> Stream<R> map(Function<? super T, ? extends R> function);

    D mapToDouble(ToDoubleFunction toDoubleFunction);

    IntStream mapToInt(ToIntFunction toIntFunction);

    C0549n0 mapToLong(ToLongFunction toLongFunction);

    B max(Comparator comparator);

    B min(Comparator comparator);

    IntStream n(C0481q qVar);

    boolean noneMatch(Predicate predicate);

    Stream peek(Consumer consumer);

    B reduce(BinaryOperator binaryOperator);

    Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator);

    Object reduce(Object obj, BinaryOperator binaryOperator);

    Stream skip(long j5);

    Stream<T> sorted();

    Stream sorted(Comparator comparator);

    Stream takeWhile(Predicate predicate);

    Object[] toArray();

    Object[] toArray(IntFunction intFunction);

    List toList();

    D y(C0481q qVar);

    /* renamed from: j$.util.stream.Stream$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static <T> Stream<T> of(T... tArr) {
            return C0594w1.E0(C0469e.v(tArr, 0, tArr.length), false);
        }
    }
}
