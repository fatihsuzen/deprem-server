package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.d3  reason: case insensitive filesystem */
public final class C1078d3 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1078d3 zzf;
    private int zzb;
    private int zzd = 1;
    private C1143k5 zze = C1089e5.B();

    static {
        C1078d3 d3Var = new C1078d3();
        zzf = d3Var;
        C1089e5.t(C1078d3.class, d3Var);
    }

    private C1078d3() {
    }

    public static C1060b3 F() {
        return (C1060b3) zzf.p();
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzb", "zzd", C1069c3.f5317a, "zze", Q2.class});
        } else if (i6 == 3) {
            return new C1078d3();
        } else {
            if (i6 == 4) {
                return new C1060b3((byte[]) null);
            }
            if (i6 == 5) {
                return zzf;
            }
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void G(Q2 q22) {
        q22.getClass();
        C1143k5 k5Var = this.zze;
        if (!k5Var.A()) {
            this.zze = C1089e5.C(k5Var);
        }
        this.zze.add(q22);
    }
}
