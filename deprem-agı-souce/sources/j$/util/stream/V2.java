package j$.util.stream;

import j$.util.Spliterator;
import java.util.Arrays;

public abstract class V2 extends C0493c implements Iterable {

    /* renamed from: e  reason: collision with root package name */
    public Object f1595e = newArray(16);

    /* renamed from: f  reason: collision with root package name */
    public Object[] f1596f;

    public abstract Object newArray(int i5);

    public abstract void p(Object obj, int i5, int i6, Object obj2);

    public abstract int q(Object obj);

    public abstract Spliterator spliterator();

    public abstract Object[] t();

    public V2(int i5) {
        super(i5);
    }

    public V2() {
    }

    public final void s(long j5) {
        long j6;
        int i5 = this.f1678c;
        if (i5 == 0) {
            j6 = (long) q(this.f1595e);
        } else {
            j6 = ((long) q(this.f1596f[i5])) + this.f1679d[i5];
        }
        if (j5 > j6) {
            if (this.f1596f == null) {
                Object[] t5 = t();
                this.f1596f = t5;
                this.f1679d = new long[8];
                t5[0] = this.f1595e;
            }
            int i6 = this.f1678c + 1;
            while (j5 > j6) {
                Object[] objArr = this.f1596f;
                if (i6 >= objArr.length) {
                    int length = objArr.length * 2;
                    this.f1596f = Arrays.copyOf(objArr, length);
                    this.f1679d = Arrays.copyOf(this.f1679d, length);
                }
                int i7 = this.f1676a;
                if (!(i6 == 0 || i6 == 1)) {
                    i7 = Math.min((i7 + i6) - 1, 30);
                }
                int i8 = 1 << i7;
                this.f1596f[i6] = newArray(i8);
                long[] jArr = this.f1679d;
                int i9 = i6 - 1;
                jArr[i6] = jArr[i9] + ((long) q(this.f1596f[i9]));
                j6 += (long) i8;
                i6++;
            }
        }
    }

    public final int r(long j5) {
        if (this.f1678c == 0) {
            if (j5 < ((long) this.f1677b)) {
                return 0;
            }
            throw new IndexOutOfBoundsException(Long.toString(j5));
        } else if (j5 < count()) {
            for (int i5 = 0; i5 <= this.f1678c; i5++) {
                if (j5 < this.f1679d[i5] + ((long) q(this.f1596f[i5]))) {
                    return i5;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j5));
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j5));
        }
    }

    public void f(int i5, Object obj) {
        long j5 = (long) i5;
        long count = count() + j5;
        if (count > ((long) q(obj)) || count < j5) {
            throw new IndexOutOfBoundsException("does not fit");
        } else if (this.f1678c == 0) {
            System.arraycopy(this.f1595e, 0, obj, i5, this.f1677b);
        } else {
            for (int i6 = 0; i6 < this.f1678c; i6++) {
                Object obj2 = this.f1596f[i6];
                System.arraycopy(obj2, 0, obj, i5, q(obj2));
                i5 += q(this.f1596f[i6]);
            }
            int i7 = this.f1677b;
            if (i7 > 0) {
                System.arraycopy(this.f1595e, 0, obj, i5, i7);
            }
        }
    }

    public Object b() {
        long count = count();
        if (count < 2147483639) {
            Object newArray = newArray((int) count);
            f(0, newArray);
            return newArray;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void u() {
        long j5;
        if (this.f1677b == q(this.f1595e)) {
            if (this.f1596f == null) {
                Object[] t5 = t();
                this.f1596f = t5;
                this.f1679d = new long[8];
                t5[0] = this.f1595e;
            }
            int i5 = this.f1678c;
            int i6 = i5 + 1;
            Object[] objArr = this.f1596f;
            if (i6 >= objArr.length || objArr[i6] == null) {
                if (i5 == 0) {
                    j5 = (long) q(this.f1595e);
                } else {
                    j5 = ((long) q(objArr[i5])) + this.f1679d[i5];
                }
                s(j5 + 1);
            }
            this.f1677b = 0;
            int i7 = this.f1678c + 1;
            this.f1678c = i7;
            this.f1595e = this.f1596f[i7];
        }
    }

    public final void clear() {
        Object[] objArr = this.f1596f;
        if (objArr != null) {
            this.f1595e = objArr[0];
            this.f1596f = null;
            this.f1679d = null;
        }
        this.f1677b = 0;
        this.f1678c = 0;
    }

    public void g(Object obj) {
        for (int i5 = 0; i5 < this.f1678c; i5++) {
            Object obj2 = this.f1596f[i5];
            p(obj2, 0, q(obj2), obj);
        }
        p(this.f1595e, 0, this.f1677b, obj);
    }
}
