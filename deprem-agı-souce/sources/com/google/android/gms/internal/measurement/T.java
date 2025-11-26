package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class T extends P implements V {
    T(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle D(Bundle bundle) {
        Parcel j5 = j();
        S.c(j5, bundle);
        Parcel i5 = i(1, j5);
        Bundle bundle2 = (Bundle) S.b(i5, Bundle.CREATOR);
        i5.recycle();
        return bundle2;
    }
}
