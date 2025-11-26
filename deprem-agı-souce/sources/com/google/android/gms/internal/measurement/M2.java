package com.google.android.gms.internal.measurement;

public final class M2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final M2 zzf;
    private int zzb;
    private int zzd;
    private long zze;

    static {
        M2 m22 = new M2();
        zzf = m22;
        C1089e5.t(M2.class, m22);
    }

    private M2() {
    }

    public static L2 J() {
        return (L2) zzf.p();
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
        } else if (i6 == 3) {
            return new M2();
        } else {
            if (i6 == 4) {
                return new L2((byte[]) null);
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

    public final boolean H() {
        return (this.zzb & 2) != 0;
    }

    public final long I() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void K(int i5) {
        this.zzb |= 1;
        this.zzd = i5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void L(long j5) {
        this.zzb |= 2;
        this.zze = j5;
    }
}
