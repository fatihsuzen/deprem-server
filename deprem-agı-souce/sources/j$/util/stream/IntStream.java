package j$.util.stream;

import j$.util.C;
import j$.util.C0469e;
import j$.util.C0617y;
import j$.util.D;
import j$.util.M;
import j$.util.Z;
import j$.util.stream.Stream;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public interface IntStream extends C0513g {
    IntStream a();

    D asDoubleStream();

    C0549n0 asLongStream();

    C average();

    IntStream b();

    Stream boxed();

    IntStream c();

    Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer);

    long count();

    IntStream distinct();

    IntStream e();

    D findAny();

    D findFirst();

    void forEach(IntConsumer intConsumer);

    void forEachOrdered(IntConsumer intConsumer);

    D g();

    M iterator();

    C0549n0 k();

    IntStream limit(long j5);

    Stream mapToObj(IntFunction intFunction);

    D max();

    D min();

    boolean p();

    IntStream parallel();

    IntStream peek(IntConsumer intConsumer);

    IntStream r(L l5);

    int reduce(int i5, IntBinaryOperator intBinaryOperator);

    D reduce(IntBinaryOperator intBinaryOperator);

    boolean s();

    IntStream sequential();

    IntStream skip(long j5);

    IntStream sorted();

    Z spliterator();

    int sum();

    C0617y summaryStatistics();

    int[] toArray();

    boolean x();

    public final /* synthetic */ class Wrapper implements java.util.stream.IntStream {
        public /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.IntStream convert(IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof VivifiedWrapper ? ((VivifiedWrapper) intStream).f1500a : new Wrapper();
        }

        public final /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
            return IntStream.this.p();
        }

        public final /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
            return IntStream.this.x();
        }

        public final /* synthetic */ DoubleStream asDoubleStream() {
            return C.f(IntStream.this.asDoubleStream());
        }

        public final /* synthetic */ LongStream asLongStream() {
            return C0544m0.f(IntStream.this.asLongStream());
        }

        public final /* synthetic */ OptionalDouble average() {
            return C0469e.n(IntStream.this.average());
        }

        public final /* synthetic */ Stream boxed() {
            return Stream.Wrapper.convert(IntStream.this.boxed());
        }

        public final /* synthetic */ void close() {
            IntStream.this.close();
        }

        public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return IntStream.this.collect(supplier, objIntConsumer, biConsumer);
        }

        public final /* synthetic */ long count() {
            return IntStream.this.count();
        }

        public final /* synthetic */ java.util.stream.IntStream distinct() {
            return convert(IntStream.this.distinct());
        }

        public final /* synthetic */ java.util.stream.IntStream dropWhile(IntPredicate intPredicate) {
            return convert(IntStream.this.c());
        }

        public final /* synthetic */ boolean equals(Object obj) {
            IntStream intStream = IntStream.this;
            if (obj instanceof Wrapper) {
                obj = IntStream.this;
            }
            return intStream.equals(obj);
        }

        public final /* synthetic */ java.util.stream.IntStream filter(IntPredicate intPredicate) {
            return convert(IntStream.this.b());
        }

        public final /* synthetic */ OptionalInt findAny() {
            return C0469e.o(IntStream.this.findAny());
        }

        public final /* synthetic */ OptionalInt findFirst() {
            return C0469e.o(IntStream.this.findFirst());
        }

        public final /* synthetic */ void forEach(IntConsumer intConsumer) {
            IntStream.this.forEach(intConsumer);
        }

        public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            IntStream.this.forEachOrdered(intConsumer);
        }

        public final /* synthetic */ int hashCode() {
            return IntStream.this.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return IntStream.this.isParallel();
        }

        public final /* synthetic */ java.util.stream.IntStream limit(long j5) {
            return convert(IntStream.this.limit(j5));
        }

        public final /* synthetic */ java.util.stream.IntStream map(IntUnaryOperator intUnaryOperator) {
            return convert(IntStream.this.e());
        }

        public final /* synthetic */ DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
            return C.f(IntStream.this.g());
        }

        public final /* synthetic */ LongStream mapToLong(IntToLongFunction intToLongFunction) {
            return C0544m0.f(IntStream.this.k());
        }

        public final /* synthetic */ java.util.stream.Stream mapToObj(IntFunction intFunction) {
            return Stream.Wrapper.convert(IntStream.this.mapToObj(intFunction));
        }

        public final /* synthetic */ OptionalInt max() {
            return C0469e.o(IntStream.this.max());
        }

        public final /* synthetic */ OptionalInt min() {
            return C0469e.o(IntStream.this.min());
        }

        public final /* synthetic */ boolean noneMatch(IntPredicate intPredicate) {
            return IntStream.this.s();
        }

        public final /* synthetic */ BaseStream onClose(Runnable runnable) {
            return C0508f.f(IntStream.this.onClose(runnable));
        }

        public final /* synthetic */ java.util.stream.IntStream peek(IntConsumer intConsumer) {
            return convert(IntStream.this.peek(intConsumer));
        }

        public final /* synthetic */ int reduce(int i5, IntBinaryOperator intBinaryOperator) {
            return IntStream.this.reduce(i5, intBinaryOperator);
        }

        public final /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
            return C0469e.o(IntStream.this.reduce(intBinaryOperator));
        }

        public final /* synthetic */ java.util.stream.IntStream skip(long j5) {
            return convert(IntStream.this.skip(j5));
        }

        public final /* synthetic */ java.util.stream.IntStream sorted() {
            return convert(IntStream.this.sorted());
        }

        public final /* synthetic */ int sum() {
            return IntStream.this.sum();
        }

        public final /* synthetic */ java.util.stream.IntStream takeWhile(IntPredicate intPredicate) {
            return convert(IntStream.this.a());
        }

        public final /* synthetic */ int[] toArray() {
            return IntStream.this.toArray();
        }

        public final /* synthetic */ BaseStream unordered() {
            return C0508f.f(IntStream.this.unordered());
        }

        public final IntSummaryStatistics summaryStatistics() {
            IntStream.this.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.IntSummaryStatistics");
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [j$.util.stream.L, java.lang.Object] */
        public final java.util.stream.IntStream flatMap(IntFunction intFunction) {
            IntStream intStream = IntStream.this;
            ? obj = new Object();
            obj.f1526a = intFunction;
            return convert(intStream.r(obj));
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements IntStream {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.stream.IntStream f1500a;

        public /* synthetic */ VivifiedWrapper(java.util.stream.IntStream intStream) {
            this.f1500a = intStream;
        }

        public static /* synthetic */ IntStream convert(java.util.stream.IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof Wrapper ? IntStream.this : new VivifiedWrapper(intStream);
        }

        public final /* synthetic */ IntStream a() {
            return convert(this.f1500a.takeWhile((IntPredicate) null));
        }

        public final /* synthetic */ D asDoubleStream() {
            return B.f(this.f1500a.asDoubleStream());
        }

        public final /* synthetic */ C0549n0 asLongStream() {
            return C0539l0.f(this.f1500a.asLongStream());
        }

        public final /* synthetic */ C average() {
            return C0469e.j(this.f1500a.average());
        }

        public final /* synthetic */ IntStream b() {
            return convert(this.f1500a.filter((IntPredicate) null));
        }

        public final /* synthetic */ Stream boxed() {
            return X2.f(this.f1500a.boxed());
        }

        public final /* synthetic */ IntStream c() {
            return convert(this.f1500a.dropWhile((IntPredicate) null));
        }

        public final /* synthetic */ void close() {
            this.f1500a.close();
        }

        public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return this.f1500a.collect(supplier, objIntConsumer, biConsumer);
        }

        public final /* synthetic */ long count() {
            return this.f1500a.count();
        }

        public final /* synthetic */ IntStream distinct() {
            return convert(this.f1500a.distinct());
        }

        public final /* synthetic */ IntStream e() {
            return convert(this.f1500a.map((IntUnaryOperator) null));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            java.util.stream.IntStream intStream = this.f1500a;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f1500a;
            }
            return intStream.equals(obj);
        }

        public final /* synthetic */ D findAny() {
            return C0469e.k(this.f1500a.findAny());
        }

        public final /* synthetic */ D findFirst() {
            return C0469e.k(this.f1500a.findFirst());
        }

        public final /* synthetic */ void forEach(IntConsumer intConsumer) {
            this.f1500a.forEach(intConsumer);
        }

        public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            this.f1500a.forEachOrdered(intConsumer);
        }

        public final /* synthetic */ D g() {
            return B.f(this.f1500a.mapToDouble((IntToDoubleFunction) null));
        }

        public final /* synthetic */ int hashCode() {
            return this.f1500a.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return this.f1500a.isParallel();
        }

        public final /* synthetic */ C0549n0 k() {
            return C0539l0.f(this.f1500a.mapToLong((IntToLongFunction) null));
        }

        public final /* synthetic */ IntStream limit(long j5) {
            return convert(this.f1500a.limit(j5));
        }

        public final /* synthetic */ Stream mapToObj(IntFunction intFunction) {
            return X2.f(this.f1500a.mapToObj(intFunction));
        }

        public final /* synthetic */ D max() {
            return C0469e.k(this.f1500a.max());
        }

        public final /* synthetic */ D min() {
            return C0469e.k(this.f1500a.min());
        }

        public final /* synthetic */ C0513g onClose(Runnable runnable) {
            return C0503e.f(this.f1500a.onClose(runnable));
        }

        public final /* synthetic */ boolean p() {
            return this.f1500a.allMatch((IntPredicate) null);
        }

        public final /* synthetic */ IntStream peek(IntConsumer intConsumer) {
            return convert(this.f1500a.peek(intConsumer));
        }

        public final /* synthetic */ int reduce(int i5, IntBinaryOperator intBinaryOperator) {
            return this.f1500a.reduce(i5, intBinaryOperator);
        }

        public final /* synthetic */ D reduce(IntBinaryOperator intBinaryOperator) {
            return C0469e.k(this.f1500a.reduce(intBinaryOperator));
        }

        public final /* synthetic */ boolean s() {
            return this.f1500a.noneMatch((IntPredicate) null);
        }

        public final /* synthetic */ IntStream skip(long j5) {
            return convert(this.f1500a.skip(j5));
        }

        public final /* synthetic */ IntStream sorted() {
            return convert(this.f1500a.sorted());
        }

        public final /* synthetic */ int sum() {
            return this.f1500a.sum();
        }

        public final /* synthetic */ int[] toArray() {
            return this.f1500a.toArray();
        }

        public final /* synthetic */ C0513g unordered() {
            return C0503e.f(this.f1500a.unordered());
        }

        public final /* synthetic */ boolean x() {
            return this.f1500a.anyMatch((IntPredicate) null);
        }

        public final C0617y summaryStatistics() {
            this.f1500a.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [j$.util.stream.L, java.lang.Object, java.util.function.IntFunction] */
        public final IntStream r(L l5) {
            java.util.stream.IntStream intStream = this.f1500a;
            ? obj = new Object();
            obj.f1526a = l5;
            return convert(intStream.flatMap(obj));
        }
    }
}
