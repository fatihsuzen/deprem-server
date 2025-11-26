package com.google.android.gms.internal.measurement;

public final class O1 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final O1 zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        O1 o12 = new O1();
        zzg = o12;
        C1089e5.t(O1.class, o12);
    }

    private O1() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", T1.f5178a, "zze", R1.f5160a, "zzf", Y1.f5278a});
        } else if (i6 == 3) {
            return new O1();
        } else {
            if (i6 == 4) {
                return new N1((byte[]) null);
            }
            if (i6 == 5) {
                return zzg;
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
        int a5 = S1.a(this.zze);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }

    public final int I() {
        int a5 = Z1.a(this.zzf);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }
}
