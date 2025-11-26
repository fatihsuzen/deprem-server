package com.google.android.gms.internal.measurement;

public final class X1 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final X1 zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        X1 x12 = new X1();
        zzf = x12;
        C1089e5.t(X1.class, x12);
    }

    private X1() {
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
            return new X1();
        } else {
            if (i6 == 4) {
                return new W1((byte[]) null);
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
}
