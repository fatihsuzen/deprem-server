package com.google.android.gms.internal.measurement;

public final class Q2 extends C1089e5 implements G5 {
    /* access modifiers changed from: private */
    public static final Q2 zzf;
    private int zzb;
    private String zzd = "";
    private long zze;

    static {
        Q2 q22 = new Q2();
        zzf = q22;
        C1089e5.t(Q2.class, q22);
    }

    private Q2() {
    }

    public static P2 F() {
        return (P2) zzf.p();
    }

    /* access modifiers changed from: protected */
    public final Object E(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return C1089e5.w(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
        } else if (i6 == 3) {
            return new Q2();
        } else {
            if (i6 == 4) {
                return new P2((byte[]) null);
            }
            if (i6 == 5) {
                return zzf;
            }
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void G(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void H(long j5) {
        this.zzb |= 2;
        this.zze = j5;
    }
}
