package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.a2  reason: case insensitive filesystem */
public final class C1050a2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1050a2 zzi;
    private int zzb;
    private C1143k5 zzd = C1089e5.B();
    private C1143k5 zze = C1089e5.B();
    private C1143k5 zzf = C1089e5.B();
    private boolean zzg;
    private C1143k5 zzh = C1089e5.B();

    static {
        C1050a2 a2Var = new C1050a2();
        zzi = a2Var;
        C1089e5.t(C1050a2.class, a2Var);
    }

    private C1050a2() {
    }

    public static C1050a2 L() {
        return zzi;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            Class<O1> cls = O1.class;
            return C1089e5.w(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zzb", "zzd", cls, "zze", Q1.class, "zzf", X1.class, "zzg", "zzh", cls});
        } else if (i6 == 3) {
            return new C1050a2();
        } else {
            if (i6 == 4) {
                return new M1((byte[]) null);
            }
            if (i6 == 5) {
                return zzi;
            }
            throw null;
        }
    }

    public final List F() {
        return this.zzd;
    }

    public final List G() {
        return this.zze;
    }

    public final List H() {
        return this.zzf;
    }

    public final boolean I() {
        return (this.zzb & 1) != 0;
    }

    public final boolean J() {
        return this.zzg;
    }

    public final List K() {
        return this.zzh;
    }
}
