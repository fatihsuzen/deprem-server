package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.v3  reason: case insensitive filesystem */
public final class C1239v3 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1239v3 zzf;
    private int zzb;
    private String zzd = "";
    private C1143k5 zze = C1089e5.B();

    static {
        C1239v3 v3Var = new C1239v3();
        zzf = v3Var;
        C1089e5.t(C1239v3.class, v3Var);
    }

    private C1239v3() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zzd", "zze", C3.class});
        } else if (i6 == 3) {
            return new C1239v3();
        } else {
            if (i6 == 4) {
                return new C1230u3((byte[]) null);
            }
            if (i6 == 5) {
                return zzf;
            }
            throw null;
        }
    }

    public final String F() {
        return this.zzd;
    }

    public final List G() {
        return this.zze;
    }
}
