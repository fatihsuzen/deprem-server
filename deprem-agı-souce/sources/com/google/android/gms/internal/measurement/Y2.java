package com.google.android.gms.internal.measurement;

import java.util.List;

public final class Y2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final Y2 zzh;
    private int zzb;
    private C1143k5 zzd = C1089e5.B();
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        Y2 y22 = new Y2();
        zzh = y22;
        C1089e5.t(Y2.class, y22);
    }

    private Y2() {
    }

    public static V2 M() {
        return (V2) zzh.p();
    }

    public static V2 N(Y2 y22) {
        C1071c5 p5 = zzh.p();
        p5.p(y22);
        return (V2) p5;
    }

    private final void V() {
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
            return C1089e5.w(zzh, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zzb", "zzd", C1051a3.class, "zze", "zzf", "zzg", X2.f5211a});
        } else if (i6 == 3) {
            return new Y2();
        } else {
            if (i6 == 4) {
                return new V2((byte[]) null);
            }
            if (i6 == 5) {
                return zzh;
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

    public final C1051a3 H(int i5) {
        return (C1051a3) this.zzd.get(i5);
    }

    public final boolean I() {
        return (this.zzb & 1) != 0;
    }

    public final String J() {
        return this.zze;
    }

    public final boolean K() {
        return (this.zzb & 2) != 0;
    }

    public final String L() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void O(int i5, C1051a3 a3Var) {
        a3Var.getClass();
        V();
        this.zzd.set(i5, a3Var);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void P(C1051a3 a3Var) {
        a3Var.getClass();
        V();
        this.zzd.add(a3Var);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Q(Iterable iterable) {
        V();
        C1213s4.g(iterable, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void R() {
        this.zzd = C1089e5.B();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void S(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void T(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzf = str;
    }
}
