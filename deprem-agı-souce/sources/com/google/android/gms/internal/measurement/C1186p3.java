package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.p3  reason: case insensitive filesystem */
public final class C1186p3 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1186p3 zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        C1186p3 p3Var = new C1186p3();
        zzg = p3Var;
        C1089e5.t(C1186p3.class, p3Var);
    }

    private C1186p3() {
    }

    public static C1123i3 G() {
        return (C1123i3) zzg.p();
    }

    public static C1186p3 H() {
        return zzg;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", C1168n3.f5483a, "zze", C1132j3.f5397a, "zzf", C1150l3.f5431a});
        } else if (i6 == 3) {
            return new C1186p3();
        } else {
            if (i6 == 4) {
                return new C1123i3((byte[]) null);
            }
            if (i6 == 5) {
                return zzg;
            }
            throw null;
        }
    }

    public final C1141k3 F() {
        C1141k3 a5 = C1141k3.a(this.zze);
        return a5 == null ? C1141k3.CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN : a5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void I(C1141k3 k3Var) {
        this.zze = k3Var.A();
        this.zzb |= 2;
    }

    public final int K() {
        int a5 = C1177o3.a(this.zzd);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }

    public final int L() {
        int a5 = C1159m3.a(this.zzf);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void M(int i5) {
        this.zzd = i5 - 1;
        this.zzb |= 1;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void N(int i5) {
        this.zzf = i5 - 1;
        this.zzb |= 4;
    }
}
