package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.r3  reason: case insensitive filesystem */
public final class C1203r3 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1203r3 zzj;
    private int zzb;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    static {
        C1203r3 r3Var = new C1203r3();
        zzj = r3Var;
        C1089e5.t(C1203r3.class, r3Var);
    }

    private C1203r3() {
    }

    public static C1195q3 Q() {
        return (C1195q3) zzj.p();
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i6 == 3) {
            return new C1203r3();
        } else {
            if (i6 == 4) {
                return new C1195q3((byte[]) null);
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

    public final long G() {
        return this.zzd;
    }

    public final String H() {
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

    public final long L() {
        return this.zzg;
    }

    public final boolean M() {
        return (this.zzb & 16) != 0;
    }

    public final float N() {
        return this.zzh;
    }

    public final boolean O() {
        return (this.zzb & 32) != 0;
    }

    public final double P() {
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void R(long j5) {
        this.zzb |= 1;
        this.zzd = j5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void S(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void T(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzf = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void U() {
        this.zzb &= -5;
        this.zzf = zzj.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void V(long j5) {
        this.zzb |= 8;
        this.zzg = j5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void W() {
        this.zzb &= -9;
        this.zzg = 0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void X(double d5) {
        this.zzb |= 32;
        this.zzi = d5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Y() {
        this.zzb &= -33;
        this.zzi = 0.0d;
    }
}
