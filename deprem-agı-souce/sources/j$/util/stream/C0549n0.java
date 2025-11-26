package j$.util.stream;

import j$.util.A;
import j$.util.C;
import j$.util.C0481q;
import j$.util.E;
import j$.util.Q;
import j$.util.c0;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.n0  reason: case insensitive filesystem */
public interface C0549n0 extends C0513g {
    IntStream A();

    C0549n0 a();

    D asDoubleStream();

    C average();

    C0549n0 b();

    Stream boxed();

    C0549n0 c();

    Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer);

    long count();

    C0549n0 d(C0481q qVar);

    C0549n0 distinct();

    C0549n0 e();

    E findAny();

    E findFirst();

    void forEach(LongConsumer longConsumer);

    void forEachOrdered(LongConsumer longConsumer);

    Q iterator();

    D j();

    C0549n0 limit(long j5);

    boolean m();

    Stream mapToObj(LongFunction longFunction);

    E max();

    E min();

    C0549n0 parallel();

    C0549n0 peek(LongConsumer longConsumer);

    boolean q();

    long reduce(long j5, LongBinaryOperator longBinaryOperator);

    E reduce(LongBinaryOperator longBinaryOperator);

    C0549n0 sequential();

    C0549n0 skip(long j5);

    C0549n0 sorted();

    c0 spliterator();

    long sum();

    A summaryStatistics();

    long[] toArray();

    boolean w();
}
