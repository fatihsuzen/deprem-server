package H;

import Y.c;
import Y.e;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class s extends c implements t {
    public s() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean i(int i5, Parcel parcel, Parcel parcel2, int i6) {
        switch (i5) {
            case 101:
                e.d(parcel);
                x((GoogleSignInAccount) e.a(parcel, GoogleSignInAccount.CREATOR), (Status) e.a(parcel, Status.CREATOR));
                break;
            case 102:
                e.d(parcel);
                R((Status) e.a(parcel, Status.CREATOR));
                break;
            case 103:
                e.d(parcel);
                Z((Status) e.a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
