package com.google.android.gms.internal.measurement;

public final class U2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final U2 zzg;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private C1264y2 zzf;

    static {
        U2 u22 = new U2();
        zzg = u22;
        C1089e5.t(U2.class, u22);
    }

    private U2() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
        } else if (i6 == 3) {
            return new U2();
        } else {
            if (i6 == 4) {
                return new T2((byte[]) null);
            }
            if (i6 == 5) {
                return zzg;
            }
            throw null;
        }
    }
}
