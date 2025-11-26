package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class Q extends Binder implements IInterface {
    protected Q(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract boolean i(int i5, Parcel parcel, Parcel parcel2, int i6);

    public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
        if (i5 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i5, parcel, parcel2, i6)) {
            return true;
        }
        return i(i5, parcel, parcel2, i6);
    }
}
