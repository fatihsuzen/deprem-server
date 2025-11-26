package com.google.android.gms.auth.api.signin;

import N.C0722p;
import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class SignInAccount extends C0732a implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<SignInAccount> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    final String f4830a;

    /* renamed from: b  reason: collision with root package name */
    private final GoogleSignInAccount f4831b;

    /* renamed from: c  reason: collision with root package name */
    final String f4832c;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f4831b = googleSignInAccount;
        this.f4830a = C0722p.f(str, "8.3 and 8.4 SDKs require non-null email");
        this.f4832c = C0722p.f(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount c() {
        return this.f4831b;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        String str = this.f4830a;
        int a5 = C0734c.a(parcel);
        C0734c.p(parcel, 4, str, false);
        C0734c.o(parcel, 7, this.f4831b, i5, false);
        C0734c.p(parcel, 8, this.f4832c, false);
        C0734c.b(parcel, a5);
    }
}
