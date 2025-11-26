package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.e2  reason: case insensitive filesystem */
public final class C1086e2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1086e2 zzh;
    private int zzb;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        C1086e2 e2Var = new C1086e2();
        zzh = e2Var;
        C1089e5.t(C1086e2.class, e2Var);
    }

    private C1086e2() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        } else if (i6 == 3) {
            return new C1086e2();
        } else {
            if (i6 == 4) {
                return new C1077d2((byte[]) null);
            }
            if (i6 == 5) {
                return zzh;
            }
            throw null;
        }
    }

    public final String F() {
        return this.zzd;
    }

    public final boolean G() {
        return (this.zzb & 2) != 0;
    }

    public final boolean H() {
        return this.zze;
    }

    public final boolean I() {
        return (this.zzb & 4) != 0;
    }

    public final boolean J() {
        return this.zzf;
    }

    public final boolean K() {
        return (this.zzb & 8) != 0;
    }

    public final int L() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void M(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }
}
