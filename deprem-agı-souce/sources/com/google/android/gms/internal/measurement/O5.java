package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

final class O5 extends C1222t4 implements RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    private static final Object[] f5113d;

    /* renamed from: e  reason: collision with root package name */
    private static final O5 f5114e;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f5115b;

    /* renamed from: c  reason: collision with root package name */
    private int f5116c;

    static {
        Object[] objArr = new Object[0];
        f5113d = objArr;
        f5114e = new O5(objArr, 0, false);
    }

    private O5(Object[] objArr, int i5, boolean z4) {
        super(z4);
        this.f5115b = objArr;
        this.f5116c = i5;
    }

    public static O5 d() {
        return f5114e;
    }

    private static int g(int i5) {
        return Math.max(((i5 * 3) / 2) + 1, 10);
    }

    private final void i(int i5) {
        if (i5 < 0 || i5 >= this.f5116c) {
            throw new IndexOutOfBoundsException(j(i5));
        }
    }

    private final String j(int i5) {
        return C1240v4.a(this.f5116c, i5, (byte) 13, "Index:", ", Size:");
    }

    public final void add(int i5, Object obj) {
        int i6;
        c();
        if (i5 < 0 || i5 > (i6 = this.f5116c)) {
            throw new IndexOutOfBoundsException(j(i5));
        }
        int i7 = i5 + 1;
        Object[] objArr = this.f5115b;
        int length = objArr.length;
        if (i6 < length) {
            System.arraycopy(objArr, i5, objArr, i7, i6 - i5);
        } else {
            Object[] objArr2 = new Object[g(length)];
            System.arraycopy(this.f5115b, 0, objArr2, 0, i5);
            System.arraycopy(this.f5115b, i5, objArr2, i7, this.f5116c - i5);
            this.f5115b = objArr2;
        }
        this.f5115b[i5] = obj;
        this.f5116c++;
        this.modCount++;
    }

    /* access modifiers changed from: package-private */
    public final void f(int i5) {
        int length = this.f5115b.length;
        if (i5 > length) {
            if (length != 0) {
                while (length < i5) {
                    length = g(length);
                }
                this.f5115b = Arrays.copyOf(this.f5115b, length);
                return;
            }
            this.f5115b = new Object[Math.max(i5, 10)];
        }
    }

    public final Object get(int i5) {
        i(i5);
        return this.f5115b[i5];
    }

    public final /* bridge */ /* synthetic */ C1143k5 m(int i5) {
        Object[] objArr;
        if (i5 >= this.f5116c) {
            if (i5 == 0) {
                objArr = f5113d;
            } else {
                objArr = Arrays.copyOf(this.f5115b, i5);
            }
            return new O5(objArr, this.f5116c, true);
        }
        throw new IllegalArgumentException();
    }

    public final Object remove(int i5) {
        c();
        i(i5);
        Object[] objArr = this.f5115b;
        Object obj = objArr[i5];
        int i6 = this.f5116c;
        if (i5 < i6 - 1) {
            System.arraycopy(objArr, i5 + 1, objArr, i5, (i6 - i5) - 1);
        }
        this.f5116c--;
        this.modCount++;
        return obj;
    }

    public final Object set(int i5, Object obj) {
        c();
        i(i5);
        Object[] objArr = this.f5115b;
        Object obj2 = objArr[i5];
        objArr[i5] = obj;
        this.modCount++;
        return obj2;
    }

    public final int size() {
        return this.f5116c;
    }

    public final boolean add(Object obj) {
        c();
        int i5 = this.f5116c;
        int length = this.f5115b.length;
        if (i5 == length) {
            this.f5115b = Arrays.copyOf(this.f5115b, g(length));
        }
        Object[] objArr = this.f5115b;
        int i6 = this.f5116c;
        this.f5116c = i6 + 1;
        objArr[i6] = obj;
        this.modCount++;
        return true;
    }
}
