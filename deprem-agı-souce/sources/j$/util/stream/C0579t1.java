package j$.util.stream;

import java.util.function.IntFunction;

/* renamed from: j$.util.stream.t1  reason: case insensitive filesystem */
public final class C0579t1 extends W2 implements H0, C0608z0 {
    public final /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public final /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public final /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final H0 build() {
        return this;
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final void end() {
    }

    public final /* synthetic */ H0 i(long j5, long j6, IntFunction intFunction) {
        return C0594w1.V(this, j5, j6, intFunction);
    }

    public final /* synthetic */ int o() {
        return 0;
    }

    public final H0 a(int i5) {
        throw new IndexOutOfBoundsException();
    }

    public final void k(Object[] objArr, int i5) {
        long j5 = (long) i5;
        long count = count() + j5;
        if (count > ((long) objArr.length) || count < j5) {
            throw new IndexOutOfBoundsException("does not fit");
        } else if (this.f1678c == 0) {
            System.arraycopy(this.f1598e, 0, objArr, i5, this.f1677b);
        } else {
            for (int i6 = 0; i6 < this.f1678c; i6++) {
                Object[] objArr2 = this.f1599f[i6];
                System.arraycopy(objArr2, 0, objArr, i5, objArr2.length);
                i5 += this.f1599f[i6].length;
            }
            int i7 = this.f1677b;
            if (i7 > 0) {
                System.arraycopy(this.f1598e, 0, objArr, i5, i7);
            }
        }
    }

    public final Object[] m(IntFunction intFunction) {
        long count = count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) count);
            k(objArr, 0);
            return objArr;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void c(long j5) {
        clear();
        p(j5);
    }
}
