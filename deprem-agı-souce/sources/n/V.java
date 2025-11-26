package N;

import K.E;
import K.G;
import K.I;
import U.a;
import android.os.IBinder;
import android.os.Parcel;
import b0.C1002a;
import b0.C1006e;

public final class V extends C1002a implements X {
    V(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final G d0(E e5) {
        Parcel j5 = j();
        C1006e.c(j5, e5);
        Parcel i5 = i(6, j5);
        G g5 = (G) C1006e.a(i5, G.CREATOR);
        i5.recycle();
        return g5;
    }

    public final boolean e() {
        Parcel i5 = i(7, j());
        boolean e5 = C1006e.e(i5);
        i5.recycle();
        return e5;
    }

    public final boolean f0(I i5, a aVar) {
        Parcel j5 = j();
        C1006e.c(j5, i5);
        C1006e.d(j5, aVar);
        Parcel i6 = i(5, j5);
        boolean e5 = C1006e.e(i6);
        i6.recycle();
        return e5;
    }

    public final G i0(E e5) {
        Parcel j5 = j();
        C1006e.c(j5, e5);
        Parcel i5 = i(8, j5);
        G g5 = (G) C1006e.a(i5, G.CREATOR);
        i5.recycle();
        return g5;
    }
}
