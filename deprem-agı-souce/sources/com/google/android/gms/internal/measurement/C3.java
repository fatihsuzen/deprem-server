package com.google.android.gms.internal.measurement;

import java.util.List;

public final class C3 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C3 zzj;
    private int zzb;
    private int zzd;
    private C1143k5 zze = C1089e5.B();
    private String zzf = "";
    private String zzg = "";
    private boolean zzh;
    private double zzi;

    static {
        C3 c32 = new C3();
        zzj = c32;
        C1089e5.t(C3.class, c32);
    }

    private C3() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzb", "zzd", A3.f4920a, "zze", C3.class, "zzf", "zzg", "zzh", "zzi"});
        } else if (i6 == 3) {
            return new C3();
        } else {
            if (i6 == 4) {
                return new C1273z3((byte[]) null);
            }
            if (i6 == 5) {
                return zzj;
            }
            throw null;
        }
    }

    public final List F() {
        return this.zze;
    }

    public final String G() {
        return this.zzf;
    }

    public final boolean H() {
        return (this.zzb & 4) != 0;
    }

    public final String I() {
        return this.zzg;
    }

    public final boolean J() {
        return (this.zzb & 8) != 0;
    }

    public final boolean K() {
        return this.zzh;
    }

    public final boolean L() {
        return (this.zzb & 16) != 0;
    }

    public final double M() {
        return this.zzi;
    }

    public final int O() {
        int a5 = B3.a(this.zzd);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }
}
