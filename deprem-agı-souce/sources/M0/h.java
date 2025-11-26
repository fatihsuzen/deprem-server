package m0;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

public abstract class h extends AbstractCollection implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f15553a = new Object[0];

    static abstract class a extends b {

        /* renamed from: a  reason: collision with root package name */
        Object[] f15554a;

        /* renamed from: b  reason: collision with root package name */
        int f15555b = 0;

        /* renamed from: c  reason: collision with root package name */
        boolean f15556c;

        a(int i5) {
            C1715d.b(i5, "initialCapacity");
            this.f15554a = new Object[i5];
        }

        private void d(int i5) {
            Object[] objArr = this.f15554a;
            if (objArr.length < i5) {
                this.f15554a = Arrays.copyOf(objArr, b.a(objArr.length, i5));
                this.f15556c = false;
            } else if (this.f15556c) {
                this.f15554a = (Object[]) objArr.clone();
                this.f15556c = false;
            }
        }

        public b b(Object... objArr) {
            c(objArr, objArr.length);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void c(Object[] objArr, int i5) {
            q.c(objArr, i5);
            d(this.f15555b + i5);
            System.arraycopy(objArr, 0, this.f15554a, this.f15555b, i5);
            this.f15555b += i5;
        }
    }

    public static abstract class b {
        b() {
        }

        static int a(int i5, int i6) {
            if (i6 >= 0) {
                int i7 = i5 + (i5 >> 1) + 1;
                if (i7 < i6) {
                    i7 = Integer.highestOneBit(i6 - 1) << 1;
                }
                if (i7 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i7;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
    }

    h() {
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public abstract int c(Object[] objArr, int i5);

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(Object obj);

    /* access modifiers changed from: package-private */
    public Object[] d() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(f15553a);
    }

    public final Object[] toArray(Object[] objArr) {
        l0.h.h(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] d5 = d();
            if (d5 != null) {
                return s.a(d5, g(), f(), objArr);
            }
            objArr = q.d(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        c(objArr, 0);
        return objArr;
    }
}
