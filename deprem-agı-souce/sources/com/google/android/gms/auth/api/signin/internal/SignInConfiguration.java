package com.google.android.gms.auth.api.signin.internal;

import H.C0642b;
import H.w;
import N.C0722p;
import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class SignInConfiguration extends C0732a implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private final String f4835a;

    /* renamed from: b  reason: collision with root package name */
    private final GoogleSignInOptions f4836b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f4835a = C0722p.e(str);
        this.f4836b = googleSignInOptions;
    }

    public final GoogleSignInOptions c() {
        return this.f4836b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f4835a.equals(signInConfiguration.f4835a)) {
            GoogleSignInOptions googleSignInOptions = this.f4836b;
            GoogleSignInOptions googleSignInOptions2 = signInConfiguration.f4836b;
            if (googleSignInOptions == null) {
                if (googleSignInOptions2 == null) {
                    return true;
                }
            } else if (!googleSignInOptions.equals(googleSignInOptions2)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new C0642b().a(this.f4835a).a(this.f4836b).b();
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        String str = this.f4835a;
        int a5 = C0734c.a(parcel);
        C0734c.p(parcel, 2, str, false);
        C0734c.o(parcel, 5, this.f4836b, i5, false);
        C0734c.b(parcel, a5);
    }
}
