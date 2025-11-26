package H;

import Y.a;
import Y.e;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class u extends a implements IInterface {
    u(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void k(t tVar, GoogleSignInOptions googleSignInOptions) {
        Parcel i5 = i();
        e.c(i5, tVar);
        e.b(i5, googleSignInOptions);
        j(102, i5);
    }

    public final void q0(t tVar, GoogleSignInOptions googleSignInOptions) {
        Parcel i5 = i();
        e.c(i5, tVar);
        e.b(i5, googleSignInOptions);
        j(103, i5);
    }
}
