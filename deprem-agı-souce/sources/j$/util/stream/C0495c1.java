package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.f0;
import j$.util.r0;
import j$.util.u0;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.c1  reason: case insensitive filesystem */
public class C0495c1 implements D0 {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1681a;

    /* renamed from: b  reason: collision with root package name */
    public int f1682b;

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0594w1.Q(this, consumer);
    }

    public final /* synthetic */ H0 i(long j5, long j6, IntFunction intFunction) {
        return C0594w1.T(this, j5, j6);
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
        C0594w1.N(this, (Integer[]) objArr, i5);
    }

    public final void f(int i5, Object obj) {
        int i6 = this.f1682b;
        System.arraycopy(this.f1681a, 0, (int[]) obj, i5, i6);
    }

    public final void g(Object obj) {
        IntConsumer intConsumer = (IntConsumer) obj;
        for (int i5 = 0; i5 < this.f1682b; i5++) {
            intConsumer.accept(this.f1681a[i5]);
        }
    }

    public C0495c1(long j5) {
        if (j5 < 2147483639) {
            this.f1681a = new int[((int) j5)];
            this.f1682b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public C0495c1(int[] iArr) {
        this.f1681a = iArr;
        this.f1682b = iArr.length;
    }

    public final Spliterator spliterator() {
        int i5 = this.f1682b;
        int[] iArr = this.f1681a;
        u0.a(((int[]) Objects.requireNonNull(iArr)).length, 0, i5);
        return new r0(iArr, 0, i5, 1040);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final f0 m219spliterator() {
        int i5 = this.f1682b;
        int[] iArr = this.f1681a;
        u0.a(((int[]) Objects.requireNonNull(iArr)).length, 0, i5);
        return new r0(iArr, 0, i5, 1040);
    }

    public final Object b() {
        int[] iArr = this.f1681a;
        int length = iArr.length;
        int i5 = this.f1682b;
        if (length == i5) {
            return iArr;
        }
        return Arrays.copyOf(iArr, i5);
    }

    public final long count() {
        return (long) this.f1682b;
    }

    public String toString() {
        int[] iArr = this.f1681a;
        return String.format("IntArrayNode[%d][%s]", new Object[]{Integer.valueOf(iArr.length - this.f1682b), Arrays.toString(iArr)});
    }
}
