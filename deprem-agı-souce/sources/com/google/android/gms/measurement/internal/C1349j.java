package com.google.android.gms.measurement.internal;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.measurement.internal.j  reason: case insensitive filesystem */
public final class C1349j implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int w4 = C0733b.w(parcel2);
        String str = null;
        String str2 = null;
        v6 v6Var = null;
        String str3 = null;
        G g5 = null;
        G g6 = null;
        G g7 = null;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        boolean z4 = false;
        while (parcel2.dataPosition() < w4) {
            int p5 = C0733b.p(parcel2);
            switch (C0733b.k(p5)) {
                case 2:
                    str = C0733b.f(parcel2, p5);
                    break;
                case 3:
                    str2 = C0733b.f(parcel2, p5);
                    break;
                case 4:
                    v6Var = (v6) C0733b.e(parcel2, p5, v6.CREATOR);
                    break;
                case 5:
                    j5 = C0733b.s(parcel2, p5);
                    break;
                case 6:
                    z4 = C0733b.l(parcel2, p5);
                    break;
                case 7:
                    str3 = C0733b.f(parcel2, p5);
                    break;
                case 8:
                    g5 = (G) C0733b.e(parcel2, p5, G.CREATOR);
                    break;
                case 9:
                    j6 = C0733b.s(parcel2, p5);
                    break;
                case 10:
                    g6 = (G) C0733b.e(parcel2, p5, G.CREATOR);
                    break;
                case 11:
                    j7 = C0733b.s(parcel2, p5);
                    break;
                case 12:
                    g7 = (G) C0733b.e(parcel2, p5, G.CREATOR);
                    break;
                default:
                    C0733b.v(parcel2, p5);
                    break;
            }
        }
        C0733b.j(parcel2, w4);
        return new C1341i(str, str2, v6Var, j5, z4, str3, g5, j6, g6, j7, g7);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C1341i[i5];
    }
}
