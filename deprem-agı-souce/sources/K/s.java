package K;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;

public final class s implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        long j5 = -1;
        int i5 = 0;
        String str = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                str = C0733b.f(parcel, p5);
            } else if (k5 == 2) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 != 3) {
                C0733b.v(parcel, p5);
            } else {
                j5 = C0733b.s(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new C0657d(str, i5, j5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C0657d[i5];
    }
}
