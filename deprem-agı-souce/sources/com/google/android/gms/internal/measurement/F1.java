package com.google.android.gms.internal.measurement;

public final class F1 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final F1 zzi;
    private int zzb;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        F1 f12 = new F1();
        zzi = f12;
        C1089e5.t(F1.class, f12);
    }

    private F1() {
    }

    public static F1 O() {
        return zzi;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", D1.f4935a, "zze", "zzf", "zzg", "zzh"});
        } else if (i6 == 3) {
            return new F1();
        } else {
            if (i6 == 4) {
                return new C1((byte[]) null);
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

    public final boolean G() {
        return (this.zzb & 2) != 0;
    }

    public final boolean H() {
        return this.zze;
    }

    public final boolean I() {
        return (this.zzb & 4) != 0;
    }

    public final String J() {
        return this.zzf;
    }

    public final boolean K() {
        return (this.zzb & 8) != 0;
    }

    public final String L() {
        return this.zzg;
    }

    public final boolean M() {
        return (this.zzb & 16) != 0;
    }

    public final String N() {
        return this.zzh;
    }

    public final int Q() {
        int a5 = E1.a(this.zzd);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }
}
