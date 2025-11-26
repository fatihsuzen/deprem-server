package com.google.android.gms.internal.measurement;

import java.util.List;

public final class O2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final O2 zzj;
    private int zzb;
    private C1143k5 zzd = C1089e5.B();
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;

    static {
        O2 o22 = new O2();
        zzj = o22;
        C1089e5.t(O2.class, o22);
    }

    private O2() {
    }

    public static N2 P() {
        return (N2) zzj.p();
    }

    private final void a0() {
        C1143k5 k5Var = this.zzd;
        if (!k5Var.A()) {
            this.zzd = C1089e5.C(k5Var);
        }
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003\u0006ဂ\u0004", new Object[]{"zzb", "zzd", S2.class, "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i6 == 3) {
            return new O2();
        } else {
            if (i6 == 4) {
                return new N2((byte[]) null);
            }
            if (i6 == 5) {
                return zzj;
            }
            throw null;
        }
    }

    public final List F() {
        return this.zzd;
    }

    public final int G() {
        return this.zzd.size();
    }

    public final S2 H(int i5) {
        return (S2) this.zzd.get(i5);
    }

    public final String I() {
        return this.zze;
    }

    public final boolean J() {
        return (this.zzb & 2) != 0;
    }

    public final long K() {
        return this.zzf;
    }

    public final boolean L() {
        return (this.zzb & 4) != 0;
    }

    public final long M() {
        return this.zzg;
    }

    public final boolean N() {
        return (this.zzb & 8) != 0;
    }

    public final int O() {
        return this.zzh;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Q(int i5, S2 s22) {
        s22.getClass();
        a0();
        this.zzd.set(i5, s22);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void R(S2 s22) {
        s22.getClass();
        a0();
        this.zzd.add(s22);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void S(Iterable iterable) {
        a0();
        C1213s4.g(iterable, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void T() {
        this.zzd = C1089e5.B();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void U(int i5) {
        a0();
        this.zzd.remove(i5);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void V(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void W(long j5) {
        this.zzb |= 2;
        this.zzf = j5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void X(long j5) {
        this.zzb |= 4;
        this.zzg = j5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Y(long j5) {
        this.zzb |= 16;
        this.zzi = j5;
    }
}
