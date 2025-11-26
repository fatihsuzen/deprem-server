package com.google.android.gms.measurement.internal;

import O.C0733b;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;

public final class w6 implements Parcelable.Creator {
    static void a(v6 v6Var, Parcel parcel, int i5) {
        int i6 = v6Var.f6787a;
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, i6);
        C0734c.p(parcel, 2, v6Var.f6788b, false);
        C0734c.m(parcel, 3, v6Var.f6789c);
        C0734c.n(parcel, 4, v6Var.f6790d, false);
        C0734c.h(parcel, 5, (Float) null, false);
        C0734c.p(parcel, 6, v6Var.f6791e, false);
        C0734c.p(parcel, 7, v6Var.f6792f, false);
        C0734c.g(parcel, 8, v6Var.f6793g, false);
        C0734c.b(parcel, a5);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int w4 = C0733b.w(parcel2);
        String str = null;
        Long l5 = null;
        Float f5 = null;
        String str2 = null;
        String str3 = null;
        Double d5 = null;
        long j5 = 0;
        int i5 = 0;
        while (parcel2.dataPosition() < w4) {
            int p5 = C0733b.p(parcel2);
            switch (C0733b.k(p5)) {
                case 1:
                    i5 = C0733b.r(parcel2, p5);
                    break;
                case 2:
                    str = C0733b.f(parcel2, p5);
                    break;
                case 3:
                    j5 = C0733b.s(parcel2, p5);
                    break;
                case 4:
                    l5 = C0733b.t(parcel2, p5);
                    break;
                case 5:
                    f5 = C0733b.o(parcel2, p5);
                    break;
                case 6:
                    str2 = C0733b.f(parcel2, p5);
                    break;
                case 7:
                    str3 = C0733b.f(parcel2, p5);
                    break;
                case 8:
                    d5 = C0733b.n(parcel2, p5);
                    break;
                default:
                    C0733b.v(parcel2, p5);
                    break;
            }
        }
        C0733b.j(parcel2, w4);
        return new v6(i5, str, j5, l5, f5, str2, str3, d5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new v6[i5];
    }
}
