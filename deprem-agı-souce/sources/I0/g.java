package i0;

import Z.a;
import Z.c;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class g extends a implements IInterface {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void q0(j jVar, f fVar) {
        Parcel i5 = i();
        c.c(i5, jVar);
        c.d(i5, fVar);
        j(12, i5);
    }
}
