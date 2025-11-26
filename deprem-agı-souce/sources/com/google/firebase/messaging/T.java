package com.google.firebase.messaging;

import O.C0733b;
import O.C0734c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class T implements Parcelable.Creator {
    static void c(S s5, Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.e(parcel, 2, s5.f7312a, false);
        C0734c.b(parcel, a5);
    }

    /* renamed from: a */
    public S createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            if (C0733b.k(p5) != 2) {
                C0733b.v(parcel, p5);
            } else {
                bundle = C0733b.a(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new S(bundle);
    }

    /* renamed from: b */
    public S[] newArray(int i5) {
        return new S[i5];
    }
}
