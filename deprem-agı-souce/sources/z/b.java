package Z;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b extends Binder implements IInterface {
    protected b(String str) {
        attachInterface(this, str);
    }

    public final boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i5, parcel, parcel2, i6)) {
            return true;
        }
        return q0(i5, parcel, parcel2, i6);
    }

    /* access modifiers changed from: protected */
    public abstract boolean q0(int i5, Parcel parcel, Parcel parcel2, int i6);

    public final IBinder asBinder() {
        return this;
    }
}
