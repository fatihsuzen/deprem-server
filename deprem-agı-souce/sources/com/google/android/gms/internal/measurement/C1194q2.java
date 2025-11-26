package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.q2  reason: case insensitive filesystem */
public final class C1194q2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1194q2 zzi;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private int zzg;
    private String zzh = "";

    static {
        C1194q2 q2Var = new C1194q2();
        zzi = q2Var;
        C1089e5.t(C1194q2.class, q2Var);
    }

    private C1194q2() {
    }

    public static C1194q2 J() {
        return zzi;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i6 == 3) {
            return new C1194q2();
        } else {
            if (i6 == 4) {
                return new C1185p2((byte[]) null);
            }
            if (i6 == 5) {
                return zzi;
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

    public final int H() {
        return this.zzg;
    }

    public final String I() {
        return this.zzh;
    }
}
