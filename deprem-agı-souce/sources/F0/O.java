package f0;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class O implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            if (C0733b.k(p5) != 1) {
                C0733b.v(parcel, p5);
            } else {
                arrayList = C0733b.d(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new N(arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new N[i5];
    }
}
