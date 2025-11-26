package N;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;

public final class b0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        int i5 = 0;
        boolean z4 = false;
        boolean z5 = false;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 == 2) {
                z4 = C0733b.l(parcel, p5);
            } else if (k5 == 3) {
                z5 = C0733b.l(parcel, p5);
            } else if (k5 == 4) {
                i6 = C0733b.r(parcel, p5);
            } else if (k5 != 5) {
                C0733b.v(parcel, p5);
            } else {
                i7 = C0733b.r(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new r(i5, z4, z5, i6, i7);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new r[i5];
    }
}
