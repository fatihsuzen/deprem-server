package K;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;

public final class H implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        boolean z4 = false;
        int i5 = 0;
        String str = null;
        int i6 = 0;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                z4 = C0733b.l(parcel, p5);
            } else if (k5 == 2) {
                str = C0733b.f(parcel, p5);
            } else if (k5 == 3) {
                i6 = C0733b.r(parcel, p5);
            } else if (k5 != 4) {
                C0733b.v(parcel, p5);
            } else {
                i5 = C0733b.r(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new G(z4, str, i6, i5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new G[i5];
    }
}
