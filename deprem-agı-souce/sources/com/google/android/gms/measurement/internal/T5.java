package com.google.android.gms.measurement.internal;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;

public final class T5 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        int i5 = 0;
        long j5 = 0;
        String str = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                str = C0733b.f(parcel, p5);
            } else if (k5 == 2) {
                j5 = C0733b.s(parcel, p5);
            } else if (k5 != 3) {
                C0733b.v(parcel, p5);
            } else {
                i5 = C0733b.r(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new S5(str, j5, i5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new S5[i5];
    }
}
