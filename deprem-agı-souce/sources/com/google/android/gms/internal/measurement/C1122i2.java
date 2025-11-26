package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.i2  reason: case insensitive filesystem */
public final class C1122i2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final C1122i2 zzd;
    private C1143k5 zzb = C1089e5.B();

    static {
        C1122i2 i2Var = new C1122i2();
        zzd = i2Var;
        C1089e5.t(C1122i2.class, i2Var);
    }

    private C1122i2() {
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        } else if (i6 == 3) {
            return new C1122i2();
        } else {
            if (i6 == 4) {
                return new C1113h2((byte[]) null);
            }
            if (i6 == 5) {
                return zzd;
            }
            throw null;
        }
    }
}
