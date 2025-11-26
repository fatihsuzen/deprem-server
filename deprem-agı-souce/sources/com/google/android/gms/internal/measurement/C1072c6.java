package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.measurement.c6  reason: case insensitive filesystem */
public final class C1072c6 {

    /* renamed from: f  reason: collision with root package name */
    private static final C1072c6 f5320f = new C1072c6(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f5321a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f5322b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f5323c;

    /* renamed from: d  reason: collision with root package name */
    private int f5324d = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5325e;

    private C1072c6(int i5, int[] iArr, Object[] objArr, boolean z4) {
        this.f5321a = i5;
        this.f5322b = iArr;
        this.f5323c = objArr;
        this.f5325e = z4;
    }

    public static C1072c6 a() {
        return f5320f;
    }

    static C1072c6 b() {
        return new C1072c6(0, new int[8], new Object[8], true);
    }

    static C1072c6 c(C1072c6 c6Var, C1072c6 c6Var2) {
        int i5 = c6Var.f5321a + c6Var2.f5321a;
        int[] copyOf = Arrays.copyOf(c6Var.f5322b, i5);
        System.arraycopy(c6Var2.f5322b, 0, copyOf, c6Var.f5321a, c6Var2.f5321a);
        Object[] copyOf2 = Arrays.copyOf(c6Var.f5323c, i5);
        System.arraycopy(c6Var2.f5323c, 0, copyOf2, c6Var.f5321a, c6Var2.f5321a);
        return new C1072c6(i5, copyOf, copyOf2, true);
    }

    private final void l(int i5) {
        int[] iArr = this.f5322b;
        if (i5 > iArr.length) {
            int i6 = this.f5321a;
            int i7 = i6 + (i6 / 2);
            if (i7 >= i5) {
                i5 = i7;
            }
            if (i5 < 8) {
                i5 = 8;
            }
            this.f5322b = Arrays.copyOf(iArr, i5);
            this.f5323c = Arrays.copyOf(this.f5323c, i5);
        }
    }

    public final void d() {
        if (this.f5325e) {
            this.f5325e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (!this.f5325e) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C1072c6)) {
            return false;
        }
        C1072c6 c6Var = (C1072c6) obj;
        int i5 = this.f5321a;
        if (i5 == c6Var.f5321a) {
            int[] iArr = this.f5322b;
            int[] iArr2 = c6Var.f5322b;
            int i6 = 0;
            while (true) {
                if (i6 >= i5) {
                    Object[] objArr = this.f5323c;
                    Object[] objArr2 = c6Var.f5323c;
                    int i7 = this.f5321a;
                    int i8 = 0;
                    while (i8 < i7) {
                        if (objArr[i8].equals(objArr2[i8])) {
                            i8++;
                        }
                    }
                    return true;
                } else if (iArr[i6] != iArr2[i6]) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        return false;
    }

    public final void f(C1180o6 o6Var) {
        if (this.f5321a != 0) {
            for (int i5 = 0; i5 < this.f5321a; i5++) {
                int i6 = this.f5322b[i5];
                Object obj = this.f5323c[i5];
                int i7 = i6 & 7;
                int i8 = i6 >>> 3;
                if (i7 == 0) {
                    o6Var.i(i8, ((Long) obj).longValue());
                } else if (i7 == 1) {
                    o6Var.b(i8, ((Long) obj).longValue());
                } else if (i7 == 2) {
                    o6Var.a(i8, (H4) obj);
                } else if (i7 == 3) {
                    o6Var.o(i8);
                    ((C1072c6) obj).f(o6Var);
                    o6Var.r(i8);
                } else if (i7 == 5) {
                    o6Var.f(i8, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new C1161m5("Protocol message tag had invalid wire type."));
                }
            }
        }
    }

    public final int g() {
        int i5 = this.f5324d;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f5321a; i7++) {
            int E4 = M4.E(8);
            int E5 = M4.E(16) + M4.E(this.f5322b[i7] >>> 3);
            int E6 = M4.E(24);
            int f5 = ((H4) this.f5323c[i7]).f();
            i6 += E4 + E4 + E5 + E6 + M4.E(f5) + f5;
        }
        this.f5324d = i6;
        return i6;
    }

    public final int h() {
        int E4;
        int a5;
        int i5;
        int i6 = this.f5324d;
        if (i6 != -1) {
            return i6;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.f5321a; i8++) {
            int i9 = this.f5322b[i8];
            int i10 = i9 >>> 3;
            int i11 = i9 & 7;
            if (i11 == 0) {
                int i12 = i10 << 3;
                long longValue = ((Long) this.f5323c[i8]).longValue();
                E4 = M4.E(i12);
                a5 = M4.a(longValue);
                i5 = E4 + a5;
            } else if (i11 == 1) {
                ((Long) this.f5323c[i8]).getClass();
                i5 = M4.E(i10 << 3) + 8;
            } else if (i11 == 2) {
                int E5 = M4.E(i10 << 3);
                int f5 = ((H4) this.f5323c[i8]).f();
                i5 = E5 + M4.E(f5) + f5;
            } else if (i11 == 3) {
                int E6 = M4.E(i10 << 3);
                E4 = E6 + E6;
                a5 = ((C1072c6) this.f5323c[i8]).h();
                i5 = E4 + a5;
            } else if (i11 == 5) {
                ((Integer) this.f5323c[i8]).getClass();
                i5 = M4.E(i10 << 3) + 4;
            } else {
                throw new IllegalStateException(new C1161m5("Protocol message tag had invalid wire type."));
            }
            i7 += i5;
        }
        this.f5324d = i7;
        return i7;
    }

    public final int hashCode() {
        int i5 = this.f5321a;
        int i6 = i5 + 527;
        int[] iArr = this.f5322b;
        int i7 = 17;
        int i8 = 17;
        for (int i9 = 0; i9 < i5; i9++) {
            i8 = (i8 * 31) + iArr[i9];
        }
        int i10 = ((i6 * 31) + i8) * 31;
        Object[] objArr = this.f5323c;
        int i11 = this.f5321a;
        for (int i12 = 0; i12 < i11; i12++) {
            i7 = (i7 * 31) + objArr[i12].hashCode();
        }
        return i10 + i7;
    }

    /* access modifiers changed from: package-private */
    public final void i(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.f5321a; i6++) {
            H5.b(sb, i5, String.valueOf(this.f5322b[i6] >>> 3), this.f5323c[i6]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void j(int i5, Object obj) {
        e();
        l(this.f5321a + 1);
        int[] iArr = this.f5322b;
        int i6 = this.f5321a;
        iArr[i6] = i5;
        this.f5323c[i6] = obj;
        this.f5321a = i6 + 1;
    }

    /* access modifiers changed from: package-private */
    public final C1072c6 k(C1072c6 c6Var) {
        if (c6Var.equals(f5320f)) {
            return this;
        }
        e();
        int i5 = this.f5321a + c6Var.f5321a;
        l(i5);
        System.arraycopy(c6Var.f5322b, 0, this.f5322b, this.f5321a, c6Var.f5321a);
        System.arraycopy(c6Var.f5323c, 0, this.f5323c, this.f5321a, c6Var.f5321a);
        this.f5321a = i5;
        return this;
    }
}
