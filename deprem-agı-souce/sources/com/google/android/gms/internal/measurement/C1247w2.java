package com.google.android.gms.internal.measurement;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.w2  reason: case insensitive filesystem */
public final class C1247w2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1247w2 zzn;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private long zzk;
    private C1275z5 zzl = C1275z5.a();
    private C1275z5 zzm = C1275z5.a();

    static {
        C1247w2 w2Var = new C1247w2();
        zzn = w2Var;
        C1089e5.t(C1247w2.class, w2Var);
    }

    private C1247w2() {
    }

    public static C1211s2 f0() {
        return (C1211s2) zzn.p();
    }

    public static C1247w2 g0() {
        return zzn;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzn, "\u0004\n\u0000\u0001\u0001\n\n\u0002\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007\t2\n2", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", C1220t2.f5584a, "zzm", C1229u2.f5595a});
        } else if (i6 == 3) {
            return new C1247w2();
        } else {
            if (i6 == 4) {
                return new C1211s2((byte[]) null);
            }
            if (i6 == 5) {
                return zzn;
            }
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void F(String str) {
        this.zzb |= 16;
        this.zzh = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void G() {
        this.zzb &= -17;
        this.zzh = zzn.zzh;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void H(String str) {
        this.zzb |= 32;
        this.zzi = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void I() {
        this.zzb &= -33;
        this.zzi = zzn.zzi;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void J(String str) {
        this.zzb |= 64;
        this.zzj = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void K() {
        this.zzb &= -65;
        this.zzj = zzn.zzj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void L(long j5) {
        this.zzb |= 128;
        this.zzk = j5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map M() {
        if (!this.zzl.f()) {
            this.zzl = this.zzl.c();
        }
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map N() {
        if (!this.zzm.f()) {
            this.zzm = this.zzm.c();
        }
        return this.zzm;
    }

    public final boolean P() {
        return (this.zzb & 1) != 0;
    }

    public final String Q() {
        return this.zzd;
    }

    public final boolean R() {
        return (this.zzb & 2) != 0;
    }

    public final String S() {
        return this.zze;
    }

    public final boolean T() {
        return (this.zzb & 4) != 0;
    }

    public final String U() {
        return this.zzf;
    }

    public final boolean V() {
        return (this.zzb & 8) != 0;
    }

    public final long W() {
        return this.zzg;
    }

    public final boolean X() {
        return (this.zzb & 16) != 0;
    }

    public final String Y() {
        return this.zzh;
    }

    public final boolean Z() {
        return (this.zzb & 32) != 0;
    }

    public final String a0() {
        return this.zzi;
    }

    public final boolean b0() {
        return (this.zzb & 64) != 0;
    }

    public final String c0() {
        return this.zzj;
    }

    public final boolean d0() {
        return (this.zzb & 128) != 0;
    }

    public final long e0() {
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h0(String str) {
        this.zzb |= 1;
        this.zzd = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void i0() {
        this.zzb &= -2;
        this.zzd = zzn.zzd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void j0(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void k0() {
        this.zzb &= -3;
        this.zze = zzn.zze;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void l0(String str) {
        this.zzb |= 4;
        this.zzf = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void m0() {
        this.zzb &= -5;
        this.zzf = zzn.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void n0(long j5) {
        this.zzb |= 8;
        this.zzg = j5;
    }
}
