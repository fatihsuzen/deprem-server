package com.google.android.gms.common.api;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 != 2) {
                C0733b.v(parcel, p5);
            } else {
                str = C0733b.f(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new Scope(i5, str);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new Scope[i5];
    }
}
