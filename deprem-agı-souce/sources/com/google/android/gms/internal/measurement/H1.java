package com.google.android.gms.internal.measurement;

public final class H1 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final H1 zzj;
    private int zzb;
    private int zzd;
    private String zze = "";
    private B1 zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        H1 h12 = new H1();
        zzj = h12;
        C1089e5.t(H1.class, h12);
    }

    private H1() {
    }

    public static G1 N() {
        return (G1) zzj.p();
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i6 == 3) {
            return new H1();
        } else {
            if (i6 == 4) {
                return new G1((byte[]) null);
            }
            if (i6 == 5) {
                return zzj;
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

    public final B1 I() {
        B1 b12 = this.zzf;
        if (b12 == null) {
            return B1.N();
        }
        return b12;
    }

    public final boolean J() {
        return this.zzg;
    }

    public final boolean K() {
        return this.zzh;
    }

    public final boolean L() {
        return (this.zzb & 32) != 0;
    }

    public final boolean M() {
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void O(String str) {
        this.zzb |= 2;
        this.zze = str;
    }
}
