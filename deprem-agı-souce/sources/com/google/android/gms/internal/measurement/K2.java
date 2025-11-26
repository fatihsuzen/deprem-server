package com.google.android.gms.internal.measurement;

import java.util.List;

public final class K2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final K2 zzd;
    private C1143k5 zzb = C1089e5.B();

    static {
        K2 k22 = new K2();
        zzd = k22;
        C1089e5.t(K2.class, k22);
    }

    private K2() {
    }

    public static D2 G() {
        return (D2) zzd.p();
    }

    public static K2 H() {
        return zzd;
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", H2.class});
        } else if (i6 == 3) {
            return new K2();
        } else {
            if (i6 == 4) {
                return new D2((byte[]) null);
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

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void I(Iterable iterable) {
        C1143k5 k5Var = this.zzb;
        if (!k5Var.A()) {
            this.zzb = C1089e5.C(k5Var);
        }
        C1213s4.g(iterable, this.zzb);
    }
}
