package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.f0;
import j$.util.m0;
import j$.util.u0;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;

public class T0 implements B0 {

    /* renamed from: a  reason: collision with root package name */
    public final double[] f1583a;

    /* renamed from: b  reason: collision with root package name */
    public int f1584b;

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0594w1.P(this, consumer);
    }

    public final /* synthetic */ H0 i(long j5, long j6, IntFunction intFunction) {
        return C0594w1.S(this, j5, j6);
    }

    public final /* synthetic */ Object[] m(IntFunction intFunction) {
        return C0594w1.L(this, intFunction);
    }

    public final /* synthetic */ int o() {
        return 0;
    }

    public final G0 a(int i5) {
        throw new IndexOutOfBoundsException();
    }

    public final /* synthetic */ void k(Object[] objArr, int i5) {
        C0594w1.M(this, (Double[]) objArr, i5);
    }

    public final void f(int i5, Object obj) {
        int i6 = this.f1584b;
        System.arraycopy(this.f1583a, 0, (double[]) obj, i5, i6);
    }

    public final void g(Object obj) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i5 = 0; i5 < this.f1584b; i5++) {
            doubleConsumer.accept(this.f1583a[i5]);
        }
    }

    public T0(long j5) {
        if (j5 < 2147483639) {
            this.f1583a = new double[((int) j5)];
            this.f1584b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public T0(double[] dArr) {
        this.f1583a = dArr;
        this.f1584b = dArr.length;
    }

    public final Spliterator spliterator() {
        int i5 = this.f1584b;
        double[] dArr = this.f1583a;
        u0.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i5);
        return new m0(dArr, 0, i5, 1040);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final f0 m216spliterator() {
        int i5 = this.f1584b;
        double[] dArr = this.f1583a;
        u0.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i5);
        return new m0(dArr, 0, i5, 1040);
    }

    public final Object b() {
        double[] dArr = this.f1583a;
        int length = dArr.length;
        int i5 = this.f1584b;
        if (length == i5) {
            return dArr;
        }
        return Arrays.copyOf(dArr, i5);
    }

    public final long count() {
        return (long) this.f1584b;
    }

    public String toString() {
        double[] dArr = this.f1583a;
        return String.format("DoubleArrayNode[%d][%s]", new Object[]{Integer.valueOf(dArr.length - this.f1584b), Arrays.toString(dArr)});
    }
}
