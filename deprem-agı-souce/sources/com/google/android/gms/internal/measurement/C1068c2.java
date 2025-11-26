package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.c2  reason: case insensitive filesystem */
public final class C1068c2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1068c2 zzg;
    private int zzb;
    private String zzd = "";
    private C1143k5 zze = C1089e5.B();
    private boolean zzf;

    static {
        C1068c2 c2Var = new C1068c2();
        zzg = c2Var;
        C1089e5.t(C1068c2.class, c2Var);
    }

    private C1068c2() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzb", "zzd", "zze", C1158m2.class, "zzf"});
        } else if (i6 == 3) {
            return new C1068c2();
        } else {
            if (i6 == 4) {
                return new C1059b2((byte[]) null);
            }
            if (i6 == 5) {
                return zzg;
            }
            throw null;
        }
    }

    public final String F() {
        return this.zzd;
    }
}
