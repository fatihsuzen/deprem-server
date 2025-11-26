package j$.util.stream;

import j$.util.C0469e;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class K0 implements H0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f1518a;

    /* renamed from: b  reason: collision with root package name */
    public int f1519b;

    public final /* synthetic */ H0 i(long j5, long j6, IntFunction intFunction) {
        return C0594w1.V(this, j5, j6, intFunction);
    }

    public final /* synthetic */ int o() {
        return 0;
    }

    public final H0 a(int i5) {
        throw new IndexOutOfBoundsException();
    }

    public K0(long j5, IntFunction intFunction) {
        if (j5 < 2147483639) {
            this.f1518a = (Object[]) intFunction.apply((int) j5);
            this.f1519b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public K0(Object[] objArr) {
        this.f1518a = objArr;
        this.f1519b = objArr.length;
    }

    public final Spliterator spliterator() {
        return C0469e.v(this.f1518a, 0, this.f1519b);
    }

    public final void k(Object[] objArr, int i5) {
        System.arraycopy(this.f1518a, 0, objArr, i5, this.f1519b);
    }

    public final Object[] m(IntFunction intFunction) {
        Object[] objArr = this.f1518a;
        if (objArr.length == this.f1519b) {
            return objArr;
        }
        throw new IllegalStateException();
    }

    public final long count() {
        return (long) this.f1519b;
    }

    public final void forEach(Consumer consumer) {
        for (int i5 = 0; i5 < this.f1519b; i5++) {
            consumer.accept(this.f1518a[i5]);
        }
    }

    public String toString() {
        Object[] objArr = this.f1518a;
        return String.format("ArrayNode[%d][%s]", new Object[]{Integer.valueOf(objArr.length - this.f1519b), Arrays.toString(objArr)});
    }
}
