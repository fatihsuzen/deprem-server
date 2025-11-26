package com.google.android.gms.measurement.internal;

import O.C0733b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class Y5 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int w4 = C0733b.w(parcel2);
        byte[] bArr = null;
        String str = null;
        Bundle bundle = null;
        String str2 = null;
        long j5 = 0;
        long j6 = 0;
        int i5 = 0;
        while (parcel2.dataPosition() < w4) {
            int p5 = C0733b.p(parcel2);
            switch (C0733b.k(p5)) {
                case 1:
                    j5 = C0733b.s(parcel2, p5);
                    break;
                case 2:
                    bArr = C0733b.b(parcel2, p5);
                    break;
                case 3:
                    str = C0733b.f(parcel2, p5);
                    break;
                case 4:
                    bundle = C0733b.a(parcel2, p5);
                    break;
                case 5:
                    i5 = C0733b.r(parcel2, p5);
                    break;
                case 6:
                    j6 = C0733b.s(parcel2, p5);
                    break;
                case 7:
                    str2 = C0733b.f(parcel2, p5);
                    break;
                default:
                    C0733b.v(parcel2, p5);
                    break;
            }
        }
        C0733b.j(parcel2, w4);
        return new X5(j5, bArr, str, bundle, i5, j6, str2);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new X5[i5];
    }
}
