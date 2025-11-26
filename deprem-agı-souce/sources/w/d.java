package W;

import android.os.IBinder;
import android.os.Parcel;

public final class d extends a implements f {
    d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String b() {
        Parcel j5 = j(1, i());
        String readString = j5.readString();
        j5.recycle();
        return readString;
    }

    public final boolean s(boolean z4) {
        Parcel i5 = i();
        c.a(i5, true);
        Parcel j5 = j(2, i5);
        boolean b5 = c.b(j5);
        j5.recycle();
        return b5;
    }
}
