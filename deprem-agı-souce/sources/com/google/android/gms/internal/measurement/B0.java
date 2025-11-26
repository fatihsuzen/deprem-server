package com.google.android.gms.internal.measurement;

import android.os.Parcel;

public abstract class B0 extends Q implements C0 {
    public B0() {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean i(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 != 2) {
            return false;
        }
        d();
        return true;
    }
}
