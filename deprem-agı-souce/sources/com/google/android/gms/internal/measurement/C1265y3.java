package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.y3  reason: case insensitive filesystem */
public final class C1265y3 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1265y3 zzf;
    private int zzb;
    private C1143k5 zzd = C1089e5.B();
    private C1221t3 zze;

    static {
        C1265y3 y3Var = new C1265y3();
        zzf = y3Var;
        C1089e5.t(C1265y3.class, y3Var);
    }

    private C1265y3() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzd", C3.class, "zze"});
        } else if (i6 == 3) {
            return new C1265y3();
        } else {
            if (i6 == 4) {
                return new C1248w3((byte[]) null);
            }
            if (i6 == 5) {
                return zzf;
            }
            throw null;
        }
    }

    public final List F() {
        return this.zzd;
    }

    public final C1221t3 G() {
        C1221t3 t3Var = this.zze;
        if (t3Var == null) {
            return C1221t3.H();
        }
        return t3Var;
    }
}
