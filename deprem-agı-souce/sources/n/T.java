package N;

import android.os.Bundle;
import android.os.Parcel;
import b0.C1005d;
import b0.C1006e;

public abstract class T extends C1005d implements C0717k {
    public T() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean i(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            C1006e.b(parcel);
            L(parcel.readInt(), parcel.readStrongBinder(), (Bundle) C1006e.a(parcel, Bundle.CREATOR));
        } else if (i5 == 2) {
            C1006e.b(parcel);
            z(parcel.readInt(), (Bundle) C1006e.a(parcel, Bundle.CREATOR));
        } else if (i5 != 3) {
            return false;
        } else {
            C1006e.b(parcel);
            l(parcel.readInt(), parcel.readStrongBinder(), (i0) C1006e.a(parcel, i0.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
