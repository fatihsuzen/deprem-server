package H;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

public final class w implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 2) {
                str = C0733b.f(parcel, p5);
            } else if (k5 != 5) {
                C0733b.v(parcel, p5);
            } else {
                googleSignInOptions = (GoogleSignInOptions) C0733b.e(parcel, p5, GoogleSignInOptions.CREATOR);
            }
        }
        C0733b.j(parcel, w4);
        return new SignInConfiguration(str, googleSignInOptions);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new SignInConfiguration[i5];
    }
}
