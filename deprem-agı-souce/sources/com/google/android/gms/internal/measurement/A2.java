package com.google.android.gms.internal.measurement;

public final class A2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final A2 zzk;
    private int zzb;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        A2 a22 = new A2();
        zzk = a22;
        C1089e5.t(A2.class, a22);
    }

    private A2() {
    }

    public static C1272z2 M() {
        return (C1272z2) zzk.p();
    }

    public static A2 N() {
        return zzk;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i6 == 3) {
            return new A2();
        } else {
            if (i6 == 4) {
                return new C1272z2((byte[]) null);
            }
            if (i6 == 5) {
                return zzk;
            }
            throw null;
        }
    }

    public final boolean F() {
        return this.zzd;
    }

    public final boolean G() {
        return this.zze;
    }

    public final boolean H() {
        return this.zzf;
    }

    public final boolean I() {
        return this.zzg;
    }

    public final boolean J() {
        return this.zzh;
    }

    public final boolean K() {
        return this.zzi;
    }

    public final boolean L() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void O(boolean z4) {
        this.zzb |= 1;
        this.zzd = z4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void P(boolean z4) {
        this.zzb |= 2;
        this.zze = z4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Q(boolean z4) {
        this.zzb |= 4;
        this.zzf = z4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void R(boolean z4) {
        this.zzb |= 8;
        this.zzg = z4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void S(boolean z4) {
        this.zzb |= 16;
        this.zzh = z4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void T(boolean z4) {
        this.zzb |= 32;
        this.zzi = z4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void U(boolean z4) {
        this.zzb |= 64;
        this.zzj = z4;
    }
}
