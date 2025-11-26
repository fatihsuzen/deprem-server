package N;

import O.C0732a;
import O.C0734c;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class M extends C0732a {
    public static final Parcelable.Creator<M> CREATOR = new N();

    /* renamed from: a  reason: collision with root package name */
    final int f2993a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f2994b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2995c;

    /* renamed from: d  reason: collision with root package name */
    private final GoogleSignInAccount f2996d;

    M(int i5, Account account, int i6, GoogleSignInAccount googleSignInAccount) {
        this.f2993a = i5;
        this.f2994b = account;
        this.f2995c = i6;
        this.f2996d = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.f2993a;
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, i6);
        C0734c.o(parcel, 2, this.f2994b, i5, false);
        C0734c.j(parcel, 3, this.f2995c);
        C0734c.o(parcel, 4, this.f2996d, i5, false);
        C0734c.b(parcel, a5);
    }

    public M(Account account, int i5, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i5, googleSignInAccount);
    }
}
