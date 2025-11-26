package com.google.android.gms.internal.measurement;

import java.util.List;

public final class S2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final S2 zzj;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private float zzg;
    private double zzh;
    private C1143k5 zzi = C1089e5.B();

    static {
        S2 s22 = new S2();
        zzj = s22;
        C1089e5.t(S2.class, s22);
    }

    private S2() {
    }

    public static R2 R() {
        return (R2) zzj.p();
    }

    private final void d0() {
        C1143k5 k5Var = this.zzi;
        if (!k5Var.A()) {
            this.zzi = C1089e5.C(k5Var);
        }
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", S2.class});
        } else if (i6 == 3) {
            return new S2();
        } else {
            if (i6 == 4) {
                return new R2((byte[]) null);
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

    public final String G() {
        return this.zzd;
    }

    public final boolean H() {
        return (this.zzb & 2) != 0;
    }

    public final String I() {
        return this.zze;
    }

    public final boolean J() {
        return (this.zzb & 4) != 0;
    }

    public final long K() {
        return this.zzf;
    }

    public final boolean L() {
        return (this.zzb & 8) != 0;
    }

    public final float M() {
        return this.zzg;
    }

    public final boolean N() {
        return (this.zzb & 16) != 0;
    }

    public final double O() {
        return this.zzh;
    }

    public final List P() {
        return this.zzi;
    }

    public final int Q() {
        return this.zzi.size();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void S(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void T(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void U() {
        this.zzb &= -3;
        this.zze = zzj.zze;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void V(long j5) {
        this.zzb |= 4;
        this.zzf = j5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void W() {
        this.zzb &= -5;
        this.zzf = 0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void X(double d5) {
        this.zzb |= 16;
        this.zzh = d5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Y() {
        this.zzb &= -17;
        this.zzh = 0.0d;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Z(S2 s22) {
        s22.getClass();
        d0();
        this.zzi.add(s22);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a0(Iterable iterable) {
        d0();
        C1213s4.g(iterable, this.zzi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b0() {
        this.zzi = C1089e5.B();
    }
}
