package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.f3  reason: case insensitive filesystem */
public final class C1096f3 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1096f3 zzg;
    private C1134j5 zzb = C1089e5.z();
    private C1134j5 zzd = C1089e5.z();
    private C1143k5 zze = C1089e5.B();
    private C1143k5 zzf = C1089e5.B();

    static {
        C1096f3 f3Var = new C1096f3();
        zzg = f3Var;
        C1089e5.t(C1096f3.class, f3Var);
    }

    private C1096f3() {
    }

    public static C1087e3 N() {
        return (C1087e3) zzg.p();
    }

    public static C1096f3 O() {
        return zzg;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zzd", "zze", M2.class, "zzf", C1114h3.class});
        } else if (i6 == 3) {
            return new C1096f3();
        } else {
            if (i6 == 4) {
                return new C1087e3((byte[]) null);
            }
            if (i6 == 5) {
                return zzg;
            }
            throw null;
        }
    }

    public final List F() {
        return this.zzb;
    }

    public final int G() {
        return this.zzb.size();
    }

    public final List H() {
        return this.zzd;
    }

    public final int I() {
        return this.zzd.size();
    }

    public final List J() {
        return this.zze;
    }

    public final int K() {
        return this.zze.size();
    }

    public final List L() {
        return this.zzf;
    }

    public final int M() {
        return this.zzf.size();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void P(Iterable iterable) {
        C1134j5 j5Var = this.zzb;
        if (!j5Var.A()) {
            this.zzb = C1089e5.A(j5Var);
        }
        C1213s4.g(iterable, this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Q() {
        this.zzb = C1089e5.z();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void R(Iterable iterable) {
        C1134j5 j5Var = this.zzd;
        if (!j5Var.A()) {
            this.zzd = C1089e5.A(j5Var);
        }
        C1213s4.g(iterable, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void S() {
        this.zzd = C1089e5.z();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void T(Iterable iterable) {
        C1143k5 k5Var = this.zze;
        if (!k5Var.A()) {
            this.zze = C1089e5.C(k5Var);
        }
        C1213s4.g(iterable, this.zze);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void U() {
        this.zze = C1089e5.B();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void V(Iterable iterable) {
        C1143k5 k5Var = this.zzf;
        if (!k5Var.A()) {
            this.zzf = C1089e5.C(k5Var);
        }
        C1213s4.g(iterable, this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void W() {
        this.zzf = C1089e5.B();
    }
}
