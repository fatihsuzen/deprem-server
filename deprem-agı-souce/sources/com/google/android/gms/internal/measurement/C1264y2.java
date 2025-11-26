package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.y2  reason: case insensitive filesystem */
public final class C1264y2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1264y2 zzk;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    static {
        C1264y2 y2Var = new C1264y2();
        zzk = y2Var;
        C1089e5.t(C1264y2.class, y2Var);
    }

    private C1264y2() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i6 == 3) {
            return new C1264y2();
        } else {
            if (i6 == 4) {
                return new C1256x2((byte[]) null);
            }
            if (i6 == 5) {
                return zzk;
            }
            throw null;
        }
    }
}
