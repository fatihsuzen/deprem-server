package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.m2  reason: case insensitive filesystem */
public final class C1158m2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1158m2 zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        C1158m2 m2Var = new C1158m2();
        zzf = m2Var;
        C1089e5.t(C1158m2.class, m2Var);
    }

    private C1158m2() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
        } else if (i6 == 3) {
            return new C1158m2();
        } else {
            if (i6 == 4) {
                return new C1149l2((byte[]) null);
            }
            if (i6 == 5) {
                return zzf;
            }
            throw null;
        }
    }
}
