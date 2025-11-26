package com.google.android.gms.internal.measurement;

public final class Q1 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final Q1 zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        Q1 q12 = new Q1();
        zzf = q12;
        C1089e5.t(Q1.class, q12);
    }

    private Q1() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            C1116h5 h5Var = T1.f5178a;
            return C1089e5.w(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", h5Var, "zze", h5Var});
        } else if (i6 == 3) {
            return new Q1();
        } else {
            if (i6 == 4) {
                return new P1((byte[]) null);
            }
            if (i6 == 5) {
                return zzf;
            }
            throw null;
        }
    }

    public final int G() {
        int a5 = V1.a(this.zzd);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }

    public final int H() {
        int a5 = V1.a(this.zze);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }
}
