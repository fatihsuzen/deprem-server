package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.x1  reason: case insensitive filesystem */
public final class C1255x1 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1255x1 zzi;
    private int zzb;
    private int zzd;
    private C1143k5 zze = C1089e5.B();
    private C1143k5 zzf = C1089e5.B();
    private boolean zzg;
    private boolean zzh;

    static {
        C1255x1 x1Var = new C1255x1();
        zzi = x1Var;
        C1089e5.t(C1255x1.class, x1Var);
    }

    private C1255x1() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzb", "zzd", "zze", H1.class, "zzf", C1271z1.class, "zzg", "zzh"});
        } else if (i6 == 3) {
            return new C1255x1();
        } else {
            if (i6 == 4) {
                return new C1246w1((byte[]) null);
            }
            if (i6 == 5) {
                return zzi;
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

    public final List H() {
        return this.zze;
    }

    public final int I() {
        return this.zze.size();
    }

    public final H1 J(int i5) {
        return (H1) this.zze.get(i5);
    }

    public final List K() {
        return this.zzf;
    }

    public final int L() {
        return this.zzf.size();
    }

    public final C1271z1 M(int i5) {
        return (C1271z1) this.zzf.get(i5);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void N(int i5, H1 h12) {
        h12.getClass();
        C1143k5 k5Var = this.zze;
        if (!k5Var.A()) {
            this.zze = C1089e5.C(k5Var);
        }
        this.zze.set(i5, h12);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void O(int i5, C1271z1 z1Var) {
        z1Var.getClass();
        C1143k5 k5Var = this.zzf;
        if (!k5Var.A()) {
            this.zzf = C1089e5.C(k5Var);
        }
        this.zzf.set(i5, z1Var);
    }
}
