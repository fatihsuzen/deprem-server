package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.z1  reason: case insensitive filesystem */
public final class C1271z1 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1271z1 zzl;
    private int zzb;
    private int zzd;
    private String zze = "";
    private C1143k5 zzf = C1089e5.B();
    private boolean zzg;
    private F1 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        C1271z1 z1Var = new C1271z1();
        zzl = z1Var;
        C1089e5.t(C1271z1.class, z1Var);
    }

    private C1271z1() {
    }

    public static C1263y1 R() {
        return (C1263y1) zzl.p();
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzl, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", B1.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i6 == 3) {
            return new C1271z1();
        } else {
            if (i6 == 4) {
                return new C1263y1((byte[]) null);
            }
            if (i6 == 5) {
                return zzl;
            }
            throw null;
        }
    }

    public final boolean F() {
        return (this.zzb & 1) != 0;
    }

    public final int G() {
        return this.zzd;
    }

    public final String H() {
        return this.zze;
    }

    public final List I() {
        return this.zzf;
    }

    public final int J() {
        return this.zzf.size();
    }

    public final B1 K(int i5) {
        return (B1) this.zzf.get(i5);
    }

    public final boolean L() {
        return (this.zzb & 8) != 0;
    }

    public final F1 M() {
        F1 f12 = this.zzh;
        if (f12 == null) {
            return F1.O();
        }
        return f12;
    }

    public final boolean N() {
        return this.zzi;
    }

    public final boolean O() {
        return this.zzj;
    }

    public final boolean P() {
        return (this.zzb & 64) != 0;
    }

    public final boolean Q() {
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void S(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void T(int i5, B1 b12) {
        b12.getClass();
        C1143k5 k5Var = this.zzf;
        if (!k5Var.A()) {
            this.zzf = C1089e5.C(k5Var);
        }
        this.zzf.set(i5, b12);
    }
}
