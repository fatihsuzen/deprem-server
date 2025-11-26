package com.google.android.gms.measurement.internal;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public final class C6 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int w4 = C0733b.w(parcel2);
        boolean z4 = false;
        int i5 = 0;
        boolean z5 = false;
        boolean z6 = false;
        int i6 = 0;
        int i7 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        String str = "";
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        Boolean bool = null;
        ArrayList arrayList = null;
        String str11 = null;
        String str12 = null;
        int i8 = 100;
        boolean z7 = true;
        boolean z8 = true;
        long j12 = -2147483648L;
        while (parcel2.dataPosition() < w4) {
            int p5 = C0733b.p(parcel2);
            switch (C0733b.k(p5)) {
                case 2:
                    str5 = C0733b.f(parcel2, p5);
                    break;
                case 3:
                    str6 = C0733b.f(parcel2, p5);
                    break;
                case 4:
                    str7 = C0733b.f(parcel2, p5);
                    break;
                case 5:
                    str8 = C0733b.f(parcel2, p5);
                    break;
                case 6:
                    j5 = C0733b.s(parcel2, p5);
                    break;
                case 7:
                    j6 = C0733b.s(parcel2, p5);
                    break;
                case 8:
                    str9 = C0733b.f(parcel2, p5);
                    break;
                case 9:
                    z7 = C0733b.l(parcel2, p5);
                    break;
                case 10:
                    z4 = C0733b.l(parcel2, p5);
                    break;
                case 11:
                    j12 = C0733b.s(parcel2, p5);
                    break;
                case 12:
                    str10 = C0733b.f(parcel2, p5);
                    break;
                case 14:
                    j7 = C0733b.s(parcel2, p5);
                    break;
                case 15:
                    i5 = C0733b.r(parcel2, p5);
                    break;
                case 16:
                    z8 = C0733b.l(parcel2, p5);
                    break;
                case 18:
                    z5 = C0733b.l(parcel2, p5);
                    break;
                case 21:
                    bool = C0733b.m(parcel2, p5);
                    break;
                case 22:
                    j8 = C0733b.s(parcel2, p5);
                    break;
                case 23:
                    arrayList = C0733b.g(parcel2, p5);
                    break;
                case 25:
                    str = C0733b.f(parcel2, p5);
                    break;
                case 26:
                    str2 = C0733b.f(parcel2, p5);
                    break;
                case 27:
                    str11 = C0733b.f(parcel2, p5);
                    break;
                case 28:
                    z6 = C0733b.l(parcel2, p5);
                    break;
                case 29:
                    j9 = C0733b.s(parcel2, p5);
                    break;
                case 30:
                    i8 = C0733b.r(parcel2, p5);
                    break;
                case 31:
                    str3 = C0733b.f(parcel2, p5);
                    break;
                case 32:
                    i6 = C0733b.r(parcel2, p5);
                    break;
                case 34:
                    j10 = C0733b.s(parcel2, p5);
                    break;
                case 35:
                    str12 = C0733b.f(parcel2, p5);
                    break;
                case 36:
                    str4 = C0733b.f(parcel2, p5);
                    break;
                case 37:
                    j11 = C0733b.s(parcel2, p5);
                    break;
                case 38:
                    i7 = C0733b.r(parcel2, p5);
                    break;
                default:
                    C0733b.v(parcel2, p5);
                    break;
            }
        }
        C0733b.j(parcel2, w4);
        return new B6(str5, str6, str7, str8, j5, j6, str9, z7, z4, j12, str10, j7, i5, z8, z5, bool, j8, (List) arrayList, str, str2, str11, z6, j9, i8, str3, i6, j10, str12, str4, j11, i7);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new B6[i5];
    }
}
