package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.f0;
import j$.util.t0;
import j$.util.u0;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.l1  reason: case insensitive filesystem */
public class C0540l1 implements F0 {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f1738a;

    /* renamed from: b  reason: collision with root package name */
    public int f1739b;

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0594w1.R(this, consumer);
    }

    public final /* synthetic */ H0 i(long j5, long j6, IntFunction intFunction) {
        return C0594w1.U(this, j5, j6);
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
        C0594w1.O(this, (Long[]) objArr, i5);
    }

    public final void f(int i5, Object obj) {
        int i6 = this.f1739b;
        System.arraycopy(this.f1738a, 0, (long[]) obj, i5, i6);
    }

    public final void g(Object obj) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i5 = 0; i5 < this.f1739b; i5++) {
            longConsumer.accept(this.f1738a[i5]);
        }
    }

    public C0540l1(long j5) {
        if (j5 < 2147483639) {
            this.f1738a = new long[((int) j5)];
            this.f1739b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public C0540l1(long[] jArr) {
        this.f1738a = jArr;
        this.f1739b = jArr.length;
    }

    public final Spliterator spliterator() {
        int i5 = this.f1739b;
        long[] jArr = this.f1738a;
        u0.a(((long[]) Objects.requireNonNull(jArr)).length, 0, i5);
        return new t0(jArr, 0, i5, 1040);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final f0 m224spliterator() {
        int i5 = this.f1739b;
        long[] jArr = this.f1738a;
        u0.a(((long[]) Objects.requireNonNull(jArr)).length, 0, i5);
        return new t0(jArr, 0, i5, 1040);
    }

    public final Object b() {
        long[] jArr = this.f1738a;
        int length = jArr.length;
        int i5 = this.f1739b;
        if (length == i5) {
            return jArr;
        }
        return Arrays.copyOf(jArr, i5);
    }

    public final long count() {
        return (long) this.f1739b;
    }

    public String toString() {
        long[] jArr = this.f1738a;
        return String.format("LongArrayNode[%d][%s]", new Object[]{Integer.valueOf(jArr.length - this.f1739b), Arrays.toString(jArr)});
    }
}
