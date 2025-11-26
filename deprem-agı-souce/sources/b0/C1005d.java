package b0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: b0.d  reason: case insensitive filesystem */
public abstract class C1005d extends Binder implements IInterface {
    protected C1005d(String str) {
        attachInterface(this, str);
    }

    /* access modifiers changed from: protected */
    public boolean i(int i5, Parcel parcel, Parcel parcel2, int i6) {
        return false;
    }

    public final boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i5, parcel, parcel2, i6)) {
            return true;
        }
        return i(i5, parcel, parcel2, i6);
    }

    public final IBinder asBinder() {
        return this;
    }
}
