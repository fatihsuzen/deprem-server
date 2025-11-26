package i0;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class i implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        ArrayList arrayList = null;
        String str = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                arrayList = C0733b.g(parcel, p5);
            } else if (k5 != 2) {
                C0733b.v(parcel, p5);
            } else {
                str = C0733b.f(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new h(arrayList, str);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new h[i5];
    }
}
