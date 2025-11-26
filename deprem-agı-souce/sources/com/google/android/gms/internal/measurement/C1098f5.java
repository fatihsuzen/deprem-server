package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.f5  reason: case insensitive filesystem */
final class C1098f5 extends C1222t4 implements RandomAccess, C1125i5, M5 {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f5349d;

    /* renamed from: e  reason: collision with root package name */
    private static final C1098f5 f5350e;

    /* renamed from: b  reason: collision with root package name */
    private int[] f5351b;

    /* renamed from: c  reason: collision with root package name */
    private int f5352c;

    static {
        int[] iArr = new int[0];
        f5349d = iArr;
        f5350e = new C1098f5(iArr, 0, false);
    }

    private C1098f5(int[] iArr, int i5, boolean z4) {
        super(z4);
        this.f5351b = iArr;
        this.f5352c = i5;
    }

    public static C1098f5 d() {
        return f5350e;
    }

    private static int j(int i5) {
        return Math.max(((i5 * 3) / 2) + 1, 10);
    }

    private final void k(int i5) {
        if (i5 < 0 || i5 >= this.f5352c) {
            throw new IndexOutOfBoundsException(l(i5));
        }
    }

    private final String l(int i5) {
        return C1240v4.a(this.f5352c, i5, (byte) 13, "Index:", ", Size:");
    }

    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        int intValue = ((Integer) obj).intValue();
        c();
        if (i5 < 0 || i5 > (i6 = this.f5352c)) {
            throw new IndexOutOfBoundsException(l(i5));
        }
        int i7 = i5 + 1;
        int[] iArr = this.f5351b;
        int length = iArr.length;
        if (i6 < length) {
            System.arraycopy(iArr, i5, iArr, i7, i6 - i5);
        } else {
            int[] iArr2 = new int[j(length)];
            System.arraycopy(this.f5351b, 0, iArr2, 0, i5);
            System.arraycopy(this.f5351b, i5, iArr2, i7, this.f5352c - i5);
            this.f5351b = iArr2;
        }
        this.f5351b[i5] = intValue;
        this.f5352c++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        c();
        byte[] bArr = C1152l5.f5434b;
        collection.getClass();
        if (!(collection instanceof C1098f5)) {
            return super.addAll(collection);
        }
        C1098f5 f5Var = (C1098f5) collection;
        int i5 = f5Var.f5352c;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f5352c;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            int[] iArr = this.f5351b;
            if (i7 > iArr.length) {
                this.f5351b = Arrays.copyOf(iArr, i7);
            }
            System.arraycopy(f5Var.f5351b, 0, this.f5351b, this.f5352c, f5Var.f5352c);
            this.f5352c = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final C1125i5 m(int i5) {
        int[] iArr;
        if (i5 >= this.f5352c) {
            if (i5 == 0) {
                iArr = f5349d;
            } else {
                iArr = Arrays.copyOf(this.f5351b, i5);
            }
            return new C1098f5(iArr, this.f5352c, true);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1098f5)) {
            return super.equals(obj);
        }
        C1098f5 f5Var = (C1098f5) obj;
        if (this.f5352c != f5Var.f5352c) {
            return false;
        }
        int[] iArr = f5Var.f5351b;
        for (int i5 = 0; i5 < this.f5352c; i5++) {
            if (this.f5351b[i5] != iArr[i5]) {
                return false;
            }
        }
        return true;
    }

    public final int f(int i5) {
        k(i5);
        return this.f5351b[i5];
    }

    public final void g(int i5) {
        c();
        int i6 = this.f5352c;
        int length = this.f5351b.length;
        if (i6 == length) {
            int[] iArr = new int[j(length)];
            System.arraycopy(this.f5351b, 0, iArr, 0, this.f5352c);
            this.f5351b = iArr;
        }
        int[] iArr2 = this.f5351b;
        int i7 = this.f5352c;
        this.f5352c = i7 + 1;
        iArr2[i7] = i5;
    }

    public final /* synthetic */ Object get(int i5) {
        k(i5);
        return Integer.valueOf(this.f5351b[i5]);
    }

    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f5352c; i6++) {
            i5 = (i5 * 31) + this.f5351b[i6];
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public final void i(int i5) {
        int length = this.f5351b.length;
        if (i5 > length) {
            if (length != 0) {
                while (length < i5) {
                    length = j(length);
                }
                this.f5351b = Arrays.copyOf(this.f5351b, length);
                return;
            }
            this.f5351b = new int[Math.max(i5, 10)];
        }
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i5 = this.f5352c;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.f5351b[i6] == intValue) {
                return i6;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        c();
        k(i5);
        int[] iArr = this.f5351b;
        int i6 = iArr[i5];
        int i7 = this.f5352c;
        if (i5 < i7 - 1) {
            System.arraycopy(iArr, i5 + 1, iArr, i5, (i7 - i5) - 1);
        }
        this.f5352c--;
        this.modCount++;
        return Integer.valueOf(i6);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i5, int i6) {
        c();
        if (i6 >= i5) {
            int[] iArr = this.f5351b;
            System.arraycopy(iArr, i6, iArr, i5, this.f5352c - i6);
            this.f5352c -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        k(i5);
        int[] iArr = this.f5351b;
        int i6 = iArr[i5];
        iArr[i5] = intValue;
        return Integer.valueOf(i6);
    }

    public final int size() {
        return this.f5352c;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Integer) obj).intValue());
        return true;
    }
}
