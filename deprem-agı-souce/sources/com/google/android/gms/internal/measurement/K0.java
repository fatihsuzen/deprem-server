package com.google.android.gms.internal.measurement;

import O.C0733b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class K0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        Bundle bundle = null;
        String str = null;
        boolean z4 = false;
        long j5 = 0;
        long j6 = 0;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                j5 = C0733b.s(parcel, p5);
            } else if (k5 == 2) {
                j6 = C0733b.s(parcel, p5);
            } else if (k5 == 3) {
                z4 = C0733b.l(parcel, p5);
            } else if (k5 == 7) {
                bundle = C0733b.a(parcel, p5);
            } else if (k5 != 8) {
                C0733b.v(parcel, p5);
            } else {
                str = C0733b.f(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new J0(j5, j6, z4, bundle, str);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new J0[i5];
    }
}
