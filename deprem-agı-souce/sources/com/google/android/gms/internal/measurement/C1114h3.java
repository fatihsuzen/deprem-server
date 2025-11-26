package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.h3  reason: case insensitive filesystem */
public final class C1114h3 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1114h3 zzf;
    private int zzb;
    private int zzd;
    private C1134j5 zze = C1089e5.z();

    static {
        C1114h3 h3Var = new C1114h3();
        zzf = h3Var;
        C1089e5.t(C1114h3.class, h3Var);
    }

    private C1114h3() {
    }

    public static C1105g3 K() {
        return (C1105g3) zzf.p();
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
        } else if (i6 == 3) {
            return new C1114h3();
        } else {
            if (i6 == 4) {
                return new C1105g3((byte[]) null);
            }
            if (i6 == 5) {
                return zzf;
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

    public final List H() {
        return this.zze;
    }

    public final int I() {
        return this.zze.size();
    }

    public final long J(int i5) {
        return this.zze.h(i5);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void L(int i5) {
        this.zzb |= 1;
        this.zzd = i5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void M(Iterable iterable) {
        C1134j5 j5Var = this.zze;
        if (!j5Var.A()) {
            this.zze = C1089e5.A(j5Var);
        }
        C1213s4.g(iterable, this.zze);
    }
}
