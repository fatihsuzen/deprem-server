package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.g2  reason: case insensitive filesystem */
public final class C1104g2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1104g2 zzu;
    private int zzb;
    private long zzd;
    private String zze = "";
    private int zzf;
    private C1143k5 zzg = C1089e5.B();
    private C1143k5 zzh = C1089e5.B();
    private C1143k5 zzi = C1089e5.B();
    private String zzj = "";
    private boolean zzk;
    private C1143k5 zzl = C1089e5.B();
    private C1143k5 zzm = C1089e5.B();
    private String zzn = "";
    private String zzo = "";
    private C1050a2 zzp;
    private C1140k2 zzq;
    private C1194q2 zzr;
    private C1158m2 zzs;
    private C1122i2 zzt;

    static {
        C1104g2 g2Var = new C1104g2();
        zzu = g2Var;
        C1089e5.t(C1104g2.class, g2Var);
    }

    private C1104g2() {
    }

    public static C1095f2 V() {
        return (C1095f2) zzu.p();
    }

    public static C1104g2 W() {
        return zzu;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzu, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", C1176o2.class, "zzh", C1086e2.class, "zzi", C1255x1.class, "zzj", "zzk", "zzl", C1265y3.class, "zzm", C1068c2.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        } else if (i6 == 3) {
            return new C1104g2();
        } else {
            if (i6 == 4) {
                return new C1095f2((byte[]) null);
            }
            if (i6 == 5) {
                return zzu;
            }
            throw null;
        }
    }

    public final boolean F() {
        return (this.zzb & 1) != 0;
    }

    public final long G() {
        return this.zzd;
    }

    public final boolean H() {
        return (this.zzb & 2) != 0;
    }

    public final String I() {
        return this.zze;
    }

    public final List J() {
        return this.zzg;
    }

    public final int K() {
        return this.zzh.size();
    }

    public final C1086e2 L(int i5) {
        return (C1086e2) this.zzh.get(i5);
    }

    public final List M() {
        return this.zzi;
    }

    public final List N() {
        return this.zzl;
    }

    public final int O() {
        return this.zzl.size();
    }

    public final List P() {
        return this.zzm;
    }

    public final String Q() {
        return this.zzn;
    }

    public final boolean R() {
        return (this.zzb & 128) != 0;
    }

    public final C1050a2 S() {
        C1050a2 a2Var = this.zzp;
        if (a2Var == null) {
            return C1050a2.L();
        }
        return a2Var;
    }

    public final boolean T() {
        return (this.zzb & 512) != 0;
    }

    public final C1194q2 U() {
        C1194q2 q2Var = this.zzr;
        if (q2Var == null) {
            return C1194q2.J();
        }
        return q2Var;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void X(int i5, C1086e2 e2Var) {
        e2Var.getClass();
        C1143k5 k5Var = this.zzh;
        if (!k5Var.A()) {
            this.zzh = C1089e5.C(k5Var);
        }
        this.zzh.set(i5, e2Var);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Y() {
        this.zzi = C1089e5.B();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Z() {
        this.zzl = C1089e5.B();
    }
}
