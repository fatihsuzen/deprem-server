package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public final class S0 extends J0 {
    public final H0 i(long j5, long j6, IntFunction intFunction) {
        if (j5 == 0 && j6 == this.f1506c) {
            return this;
        }
        long count = this.f1504a.count();
        if (j5 >= count) {
            return this.f1505b.i(j5 - count, j6 - count, intFunction);
        } else if (j6 <= count) {
            return this.f1504a.i(j5, j6, intFunction);
        } else {
            return C0594w1.e0(C0487a3.REFERENCE, this.f1504a.i(j5, count, intFunction), this.f1505b.i(0, j6 - count, intFunction));
        }
    }

    public final Spliterator spliterator() {
        return new C0535k1(this);
    }

    public final void k(Object[] objArr, int i5) {
        Objects.requireNonNull(objArr);
        H0 h02 = this.f1504a;
        h02.k(objArr, i5);
        this.f1505b.k(objArr, i5 + ((int) h02.count()));
    }

    public final Object[] m(IntFunction intFunction) {
        long j5 = this.f1506c;
        if (j5 < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) j5);
            k(objArr, 0);
            return objArr;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void forEach(Consumer consumer) {
        this.f1504a.forEach(consumer);
        this.f1505b.forEach(consumer);
    }

    public final String toString() {
        long j5 = this.f1506c;
        if (j5 < 32) {
            return String.format("ConcNode[%s.%s]", new Object[]{this.f1504a, this.f1505b});
        }
        return String.format("ConcNode[size=%d]", new Object[]{Long.valueOf(j5)});
    }
}
