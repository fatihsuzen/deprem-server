package com.google.android.gms.internal.measurement;

import java.util.List;

public final class L1 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final L1 zzh;
    private int zzb;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private C1143k5 zzg = C1089e5.B();

    static {
        L1 l12 = new L1();
        zzh = l12;
        C1089e5.t(L1.class, l12);
    }

    private L1() {
    }

    public static L1 M() {
        return zzh;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzb", "zzd", J1.f4990a, "zze", "zzf", "zzg"});
        } else if (i6 == 3) {
            return new L1();
        } else {
            if (i6 == 4) {
                return new I1((byte[]) null);
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

    public final boolean G() {
        return (this.zzb & 2) != 0;
    }

    public final String H() {
        return this.zze;
    }

    public final boolean I() {
        return (this.zzb & 4) != 0;
    }

    public final boolean J() {
        return this.zzf;
    }

    public final List K() {
        return this.zzg;
    }

    public final int L() {
        return this.zzg.size();
    }

    public final int O() {
        int a5 = K1.a(this.zzd);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }
}
