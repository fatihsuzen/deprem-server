package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.t5  reason: case insensitive filesystem */
final class C1223t5 extends C1222t4 implements RandomAccess, C1134j5, M5 {

    /* renamed from: d  reason: collision with root package name */
    private static final long[] f5586d;

    /* renamed from: e  reason: collision with root package name */
    private static final C1223t5 f5587e;

    /* renamed from: b  reason: collision with root package name */
    private long[] f5588b;

    /* renamed from: c  reason: collision with root package name */
    private int f5589c;

    static {
        long[] jArr = new long[0];
        f5586d = jArr;
        f5587e = new C1223t5(jArr, 0, false);
    }

    private C1223t5(long[] jArr, int i5, boolean z4) {
        super(z4);
        this.f5588b = jArr;
        this.f5589c = i5;
    }

    public static C1223t5 d() {
        return f5587e;
    }

    private static int i(int i5) {
        return Math.max(((i5 * 3) / 2) + 1, 10);
    }

    private final void j(int i5) {
        if (i5 < 0 || i5 >= this.f5589c) {
            throw new IndexOutOfBoundsException(k(i5));
        }
    }

    private final String k(int i5) {
        return C1240v4.a(this.f5589c, i5, (byte) 13, "Index:", ", Size:");
    }

    /* renamed from: a */
    public final C1134j5 m(int i5) {
        long[] jArr;
        if (i5 >= this.f5589c) {
            if (i5 == 0) {
                jArr = f5586d;
            } else {
                jArr = Arrays.copyOf(this.f5588b, i5);
            }
            return new C1223t5(jArr, this.f5589c, true);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        long longValue = ((Long) obj).longValue();
        c();
        if (i5 < 0 || i5 > (i6 = this.f5589c)) {
            throw new IndexOutOfBoundsException(k(i5));
        }
        int i7 = i5 + 1;
        long[] jArr = this.f5588b;
        int length = jArr.length;
        if (i6 < length) {
            System.arraycopy(jArr, i5, jArr, i7, i6 - i5);
        } else {
            long[] jArr2 = new long[i(length)];
            System.arraycopy(this.f5588b, 0, jArr2, 0, i5);
            System.arraycopy(this.f5588b, i5, jArr2, i7, this.f5589c - i5);
            this.f5588b = jArr2;
        }
        this.f5588b[i5] = longValue;
        this.f5589c++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        c();
        byte[] bArr = C1152l5.f5434b;
        collection.getClass();
        if (!(collection instanceof C1223t5)) {
            return super.addAll(collection);
        }
        C1223t5 t5Var = (C1223t5) collection;
        int i5 = t5Var.f5589c;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f5589c;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            long[] jArr = this.f5588b;
            if (i7 > jArr.length) {
                this.f5588b = Arrays.copyOf(jArr, i7);
            }
            System.arraycopy(t5Var.f5588b, 0, this.f5588b, this.f5589c, t5Var.f5589c);
            this.f5589c = i7;
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1223t5)) {
            return super.equals(obj);
        }
        C1223t5 t5Var = (C1223t5) obj;
        if (this.f5589c != t5Var.f5589c) {
            return false;
        }
        long[] jArr = t5Var.f5588b;
        for (int i5 = 0; i5 < this.f5589c; i5++) {
            if (this.f5588b[i5] != jArr[i5]) {
                return false;
            }
        }
        return true;
    }

    public final void f(long j5) {
        c();
        int i5 = this.f5589c;
        int length = this.f5588b.length;
        if (i5 == length) {
            long[] jArr = new long[i(length)];
            System.arraycopy(this.f5588b, 0, jArr, 0, this.f5589c);
            this.f5588b = jArr;
        }
        long[] jArr2 = this.f5588b;
        int i6 = this.f5589c;
        this.f5589c = i6 + 1;
        jArr2[i6] = j5;
    }

    /* access modifiers changed from: package-private */
    public final void g(int i5) {
        int length = this.f5588b.length;
        if (i5 > length) {
            if (length != 0) {
                while (length < i5) {
                    length = i(length);
                }
                this.f5588b = Arrays.copyOf(this.f5588b, length);
                return;
            }
            this.f5588b = new long[Math.max(i5, 10)];
        }
    }

    public final /* synthetic */ Object get(int i5) {
        j(i5);
        return Long.valueOf(this.f5588b[i5]);
    }

    public final long h(int i5) {
        j(i5);
        return this.f5588b[i5];
    }

    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f5589c; i6++) {
            long j5 = this.f5588b[i6];
            byte[] bArr = C1152l5.f5434b;
            i5 = (i5 * 31) + ((int) (j5 ^ (j5 >>> 32)));
        }
        return i5;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i5 = this.f5589c;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.f5588b[i6] == longValue) {
                return i6;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        c();
        j(i5);
        long[] jArr = this.f5588b;
        long j5 = jArr[i5];
        int i6 = this.f5589c;
        if (i5 < i6 - 1) {
            System.arraycopy(jArr, i5 + 1, jArr, i5, (i6 - i5) - 1);
        }
        this.f5589c--;
        this.modCount++;
        return Long.valueOf(j5);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i5, int i6) {
        c();
        if (i6 >= i5) {
            long[] jArr = this.f5588b;
            System.arraycopy(jArr, i6, jArr, i5, this.f5589c - i6);
            this.f5589c -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        long longValue = ((Long) obj).longValue();
        c();
        j(i5);
        long[] jArr = this.f5588b;
        long j5 = jArr[i5];
        jArr[i5] = longValue;
        return Long.valueOf(j5);
    }

    public final int size() {
        return this.f5589c;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        f(((Long) obj).longValue());
        return true;
    }
}
