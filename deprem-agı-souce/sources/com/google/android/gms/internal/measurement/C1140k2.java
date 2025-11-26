package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.k2  reason: case insensitive filesystem */
public final class C1140k2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1140k2 zzi;
    private int zzb;
    private int zzd = 14;
    private int zze = 11;
    private int zzf = 60;
    private int zzg = 13;
    private int zzh = 11;

    static {
        C1140k2 k2Var = new C1140k2();
        zzi = k2Var;
        C1089e5.t(C1140k2.class, k2Var);
    }

    private C1140k2() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i6 == 3) {
            return new C1140k2();
        } else {
            if (i6 == 4) {
                return new C1131j2((byte[]) null);
            }
            if (i6 == 5) {
                return zzi;
            }
            throw null;
        }
    }
}
