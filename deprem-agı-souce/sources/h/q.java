package H;

import Y.c;
import android.os.Parcel;

public abstract class q extends c implements r {
    public q() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    /* access modifiers changed from: protected */
    public final boolean i(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            q();
        } else if (i5 != 2) {
            return false;
        } else {
            u();
        }
        return true;
    }
}
