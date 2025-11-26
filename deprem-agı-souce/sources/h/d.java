package H;

import O.C0733b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class d implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        Bundle bundle = null;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 == 2) {
                i6 = C0733b.r(parcel, p5);
            } else if (k5 != 3) {
                C0733b.v(parcel, p5);
            } else {
                bundle = C0733b.a(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new C0641a(i5, i6, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C0641a[i5];
    }
}
