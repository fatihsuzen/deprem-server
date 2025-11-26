package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

public abstract class E0 extends Q implements G0 {
    public E0() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    /* access modifiers changed from: protected */
    public final boolean i(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            long readLong = parcel.readLong();
            S.f(parcel);
            n(parcel.readString(), parcel.readString(), (Bundle) S.b(parcel, Bundle.CREATOR), readLong);
            parcel2.writeNoException();
        } else if (i5 != 2) {
            return false;
        } else {
            int c5 = c();
            parcel2.writeNoException();
            parcel2.writeInt(c5);
        }
        return true;
    }
}
