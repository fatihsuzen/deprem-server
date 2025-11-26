package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.measurement.y0  reason: case insensitive filesystem */
public abstract class C1262y0 extends Q implements C1270z0 {
    public C1262y0() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    /* access modifiers changed from: protected */
    public final boolean i(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 != 1) {
            return false;
        }
        S.f(parcel);
        W((Bundle) S.b(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
