package com.google.android.gms.internal.measurement;

public final class H2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final H2 zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        H2 h22 = new H2();
        zzf = h22;
        C1089e5.t(H2.class, h22);
    }

    private H2() {
    }

    public static G2 F() {
        return (G2) zzf.p();
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", E2.f4939a, "zze", I2.f4963a});
        } else if (i6 == 3) {
            return new H2();
        } else {
            if (i6 == 4) {
                return new G2((byte[]) null);
            }
            if (i6 == 5) {
                return zzf;
            }
            throw null;
        }
    }

    public final int H() {
        int a5 = F2.a(this.zzd);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }

    public final int I() {
        int a5 = J2.a(this.zze);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void J(int i5) {
        this.zzd = i5 - 1;
        this.zzb |= 1;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void K(int i5) {
        this.zze = i5 - 1;
        this.zzb |= 2;
    }
}
