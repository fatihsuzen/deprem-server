package P;

import N.C0725t;
import Z.c;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class a extends Z.a implements IInterface {
    a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void q0(C0725t tVar) {
        Parcel i5 = i();
        c.c(i5, tVar);
        k(1, i5);
    }
}
