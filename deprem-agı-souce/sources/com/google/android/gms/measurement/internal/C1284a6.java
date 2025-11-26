package com.google.android.gms.measurement.internal;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.measurement.internal.a6  reason: case insensitive filesystem */
public final class C1284a6 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            if (C0733b.k(p5) != 1) {
                C0733b.v(parcel, p5);
            } else {
                arrayList = C0733b.i(parcel, p5, X5.CREATOR);
            }
        }
        C0733b.j(parcel, w4);
        return new Z5(arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new Z5[i5];
    }
}
