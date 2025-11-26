package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.measurement.x0  reason: case insensitive filesystem */
public final class C1254x0 extends P implements C1270z0 {
    C1254x0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    public final void W(Bundle bundle) {
        Parcel j5 = j();
        S.c(j5, bundle);
        k(1, j5);
    }
}
