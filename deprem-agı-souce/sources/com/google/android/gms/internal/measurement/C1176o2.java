package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.o2  reason: case insensitive filesystem */
public final class C1176o2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1176o2 zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        C1176o2 o2Var = new C1176o2();
        zzf = o2Var;
        C1089e5.t(C1176o2.class, o2Var);
    }

    private C1176o2() {
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
            return new C1176o2();
        } else {
            if (i6 == 4) {
                return new C1167n2((byte[]) null);
            }
            if (i6 == 5) {
                return zzf;
            }
            throw null;
        }
    }

    public final String F() {
        return this.zzd;
    }

    public final String G() {
        return this.zze;
    }
}
