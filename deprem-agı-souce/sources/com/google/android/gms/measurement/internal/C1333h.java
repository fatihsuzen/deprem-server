package com.google.android.gms.measurement.internal;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.measurement.internal.h  reason: case insensitive filesystem */
public final class C1333h implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        long j5 = 0;
        long j6 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                j5 = C0733b.s(parcel, p5);
            } else if (k5 == 2) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 != 3) {
                C0733b.v(parcel, p5);
            } else {
                j6 = C0733b.s(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new C1325g(j5, i5, j6);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C1325g[i5];
    }
}
