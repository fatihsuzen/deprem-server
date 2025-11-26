package com.google.android.gms.auth.api.signin;

import O.C0733b;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

public final class c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int w4 = C0733b.w(parcel2);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
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
                    str2 = C0733b.f(parcel2, p5);
                    break;
                case 4:
                    str3 = C0733b.f(parcel2, p5);
                    break;
                case 5:
                    str4 = C0733b.f(parcel2, p5);
                    break;
                case 6:
                    uri = (Uri) C0733b.e(parcel2, p5, Uri.CREATOR);
                    break;
                case 7:
                    str5 = C0733b.f(parcel2, p5);
                    break;
                case 8:
                    j5 = C0733b.s(parcel2, p5);
                    break;
                case 9:
                    str6 = C0733b.f(parcel2, p5);
                    break;
                case 10:
                    arrayList = C0733b.i(parcel2, p5, Scope.CREATOR);
                    break;
                case 11:
                    str7 = C0733b.f(parcel2, p5);
                    break;
                case 12:
                    str8 = C0733b.f(parcel2, p5);
                    break;
                default:
                    C0733b.v(parcel2, p5);
                    break;
            }
        }
        C0733b.j(parcel2, w4);
        return new GoogleSignInAccount(i5, str, str2, str3, str4, uri, str5, j5, str6, arrayList, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new GoogleSignInAccount[i5];
    }
}
