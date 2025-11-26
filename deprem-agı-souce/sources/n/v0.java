package N;

import U.a;
import android.os.IBinder;
import android.os.Parcel;
import b0.C1002a;

public final class v0 extends C1002a implements S {
    v0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final a C() {
        Parcel i5 = i(1, j());
        a j5 = a.C0060a.j(i5.readStrongBinder());
        i5.recycle();
        return j5;
    }

    public final int b() {
        Parcel i5 = i(2, j());
        int readInt = i5.readInt();
        i5.recycle();
        return readInt;
    }
}
