package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.t3  reason: case insensitive filesystem */
public final class C1221t3 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1221t3 zzd;
    private C1143k5 zzb = C1089e5.B();

    static {
        C1221t3 t3Var = new C1221t3();
        zzd = t3Var;
        C1089e5.t(C1221t3.class, t3Var);
    }

    private C1221t3() {
    }

    public static C1221t3 H() {
        return zzd;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", C1239v3.class});
        } else if (i6 == 3) {
            return new C1221t3();
        } else {
            if (i6 == 4) {
                return new C1212s3((byte[]) null);
            }
            if (i6 == 5) {
                return zzd;
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
}
