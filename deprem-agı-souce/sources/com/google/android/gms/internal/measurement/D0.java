package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class D0 extends P implements G0 {
    D0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final int c() {
        Parcel i5 = i(2, j());
        int readInt = i5.readInt();
        i5.recycle();
        return readInt;
    }

    public final void n(String str, String str2, Bundle bundle, long j5) {
        Parcel j6 = j();
        j6.writeString(str);
        j6.writeString(str2);
        S.c(j6, bundle);
        j6.writeLong(j5);
        k(1, j6);
    }
}
