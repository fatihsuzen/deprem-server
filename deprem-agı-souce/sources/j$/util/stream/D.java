package j$.util.stream;

import j$.util.C;
import j$.util.C0481q;
import j$.util.C0616x;
import j$.util.I;
import j$.util.W;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

public interface D extends C0513g {
    boolean B();

    D a();

    C average();

    D b();

    Stream boxed();

    D c();

    Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer);

    long count();

    D d(C0481q qVar);

    D distinct();

    D e();

    C findAny();

    C findFirst();

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    I iterator();

    D limit(long j5);

    Stream mapToObj(DoubleFunction doubleFunction);

    C max();

    C min();

    boolean o();

    D parallel();

    D peek(DoubleConsumer doubleConsumer);

    double reduce(double d5, DoubleBinaryOperator doubleBinaryOperator);

    C reduce(DoubleBinaryOperator doubleBinaryOperator);

    D sequential();

    D skip(long j5);

    D sorted();

    W spliterator();

    double sum();

    C0616x summaryStatistics();

    boolean t();

    double[] toArray();

    C0549n0 u();

    IntStream z();
}
