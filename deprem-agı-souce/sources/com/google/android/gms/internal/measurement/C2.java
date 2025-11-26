package com.google.android.gms.internal.measurement;

public final class C2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C2 zzh;
    private int zzb;
    private int zzd;
    private C1096f3 zze;
    private C1096f3 zzf;
    private boolean zzg;

    static {
        C2 c22 = new C2();
        zzh = c22;
        C1089e5.t(C2.class, c22);
    }

    private C2() {
    }

    public static B2 M() {
        return (B2) zzh.p();
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        } else if (i6 == 3) {
            return new C2();
        } else {
            if (i6 == 4) {
                return new B2((byte[]) null);
            }
            if (i6 == 5) {
                return zzh;
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

    public final C1096f3 H() {
        C1096f3 f3Var = this.zze;
        if (f3Var == null) {
            return C1096f3.O();
        }
        return f3Var;
    }

    public final boolean I() {
        return (this.zzb & 4) != 0;
    }

    public final C1096f3 J() {
        C1096f3 f3Var = this.zzf;
        if (f3Var == null) {
            return C1096f3.O();
        }
        return f3Var;
    }

    public final boolean K() {
        return (this.zzb & 8) != 0;
    }

    public final boolean L() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void N(int i5) {
        this.zzb |= 1;
        this.zzd = i5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void O(C1096f3 f3Var) {
        f3Var.getClass();
        this.zze = f3Var;
        this.zzb |= 2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void P(C1096f3 f3Var) {
        this.zzf = f3Var;
        this.zzb |= 4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Q(boolean z4) {
        this.zzb |= 8;
        this.zzg = z4;
    }
}
