package i0;

import K.C0655b;
import N.O;
import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;

public final class m implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        C0655b bVar = null;
        int i5 = 0;
        O o5 = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 == 2) {
                bVar = (C0655b) C0733b.e(parcel, p5, C0655b.CREATOR);
            } else if (k5 != 3) {
                C0733b.v(parcel, p5);
            } else {
                o5 = (O) C0733b.e(parcel, p5, O.CREATOR);
            }
        }
        C0733b.j(parcel, w4);
        return new l(i5, bVar, o5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new l[i5];
    }
}
