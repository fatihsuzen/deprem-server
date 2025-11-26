package com.google.android.gms.measurement.internal;

import O.C0733b;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;

public final class H implements Parcelable.Creator {
    static void a(G g5, Parcel parcel, int i5) {
        String str = g5.f5883a;
        int a5 = C0734c.a(parcel);
        C0734c.p(parcel, 2, str, false);
        C0734c.o(parcel, 3, g5.f5884b, i5, false);
        C0734c.p(parcel, 4, g5.f5885c, false);
        C0734c.m(parcel, 5, g5.f5886d);
        C0734c.b(parcel, a5);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        long j5 = 0;
        String str = null;
        E e5 = null;
        String str2 = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 2) {
                str = C0733b.f(parcel, p5);
            } else if (k5 == 3) {
                e5 = (E) C0733b.e(parcel, p5, E.CREATOR);
            } else if (k5 == 4) {
                str2 = C0733b.f(parcel, p5);
            } else if (k5 != 5) {
                C0733b.v(parcel, p5);
            } else {
                j5 = C0733b.s(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new G(str, e5, str2, j5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new G[i5];
    }
}
