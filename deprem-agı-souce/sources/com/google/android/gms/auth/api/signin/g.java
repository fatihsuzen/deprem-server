package com.google.android.gms.auth.api.signin;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;

public final class g implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = str;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 4) {
                str = C0733b.f(parcel, p5);
            } else if (k5 == 7) {
                googleSignInAccount = (GoogleSignInAccount) C0733b.e(parcel, p5, GoogleSignInAccount.CREATOR);
            } else if (k5 != 8) {
                C0733b.v(parcel, p5);
            } else {
                str2 = C0733b.f(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new SignInAccount[i5];
    }
}
