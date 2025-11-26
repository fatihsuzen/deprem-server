package N;

import U.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b0.C1005d;
import b0.C1006e;

public abstract class w0 extends C1005d implements S {
    public w0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static S j(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof S) {
            return (S) queryLocalInterface;
        }
        return new v0(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean i(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            a C4 = C();
            parcel2.writeNoException();
            C1006e.d(parcel2, C4);
        } else if (i5 != 2) {
            return false;
        } else {
            int b5 = b();
            parcel2.writeNoException();
            parcel2.writeInt(b5);
        }
        return true;
    }
}
