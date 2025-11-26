package com.google.android.gms.internal.measurement;

import O.C0733b;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public final class M0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        String str = null;
        int i5 = 0;
        Intent intent = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 == 2) {
                str = C0733b.f(parcel, p5);
            } else if (k5 != 3) {
                C0733b.v(parcel, p5);
            } else {
                intent = (Intent) C0733b.e(parcel, p5, Intent.CREATOR);
            }
        }
        C0733b.j(parcel, w4);
        return new L0(i5, str, intent);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new L0[i5];
    }
}
