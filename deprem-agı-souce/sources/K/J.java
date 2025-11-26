package K;

import O.C0733b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class J implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        boolean z4 = false;
        String str = null;
        IBinder iBinder = null;
        boolean z5 = false;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                str = C0733b.f(parcel, p5);
            } else if (k5 == 2) {
                iBinder = C0733b.q(parcel, p5);
            } else if (k5 == 3) {
                z4 = C0733b.l(parcel, p5);
            } else if (k5 != 4) {
                C0733b.v(parcel, p5);
            } else {
                z5 = C0733b.l(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new I(str, iBinder, z4, z5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new I[i5];
    }
}
