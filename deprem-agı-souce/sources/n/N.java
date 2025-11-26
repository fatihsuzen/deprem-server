package N;

import O.C0733b;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class N implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        Account account = null;
        int i5 = 0;
        int i6 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 == 2) {
                account = (Account) C0733b.e(parcel, p5, Account.CREATOR);
            } else if (k5 == 3) {
                i6 = C0733b.r(parcel, p5);
            } else if (k5 != 4) {
                C0733b.v(parcel, p5);
            } else {
                googleSignInAccount = (GoogleSignInAccount) C0733b.e(parcel, p5, GoogleSignInAccount.CREATOR);
            }
        }
        C0733b.j(parcel, w4);
        return new M(i5, account, i6, googleSignInAccount);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new M[i5];
    }
}
