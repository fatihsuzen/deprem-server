package com.google.android.gms.internal.measurement;

public final class B1 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final B1 zzh;
    private int zzb;
    private L1 zzd;
    private F1 zze;
    private boolean zzf;
    private String zzg = "";

    static {
        B1 b12 = new B1();
        zzh = b12;
        C1089e5.t(B1.class, b12);
    }

    private B1() {
    }

    public static B1 N() {
        return zzh;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        } else if (i6 == 3) {
            return new B1();
        } else {
            if (i6 == 4) {
                return new A1((byte[]) null);
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

    public final L1 G() {
        L1 l12 = this.zzd;
        if (l12 == null) {
            return L1.M();
        }
        return l12;
    }

    public final boolean H() {
        return (this.zzb & 2) != 0;
    }

    public final F1 I() {
        F1 f12 = this.zze;
        if (f12 == null) {
            return F1.O();
        }
        return f12;
    }

    public final boolean J() {
        return (this.zzb & 4) != 0;
    }

    public final boolean K() {
        return this.zzf;
    }

    public final boolean L() {
        return (this.zzb & 8) != 0;
    }

    public final String M() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void O(String str) {
        this.zzb |= 8;
        this.zzg = str;
    }
}
