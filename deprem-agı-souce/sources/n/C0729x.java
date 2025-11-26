package N;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: N.x  reason: case insensitive filesystem */
public final class C0729x implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        ArrayList arrayList = null;
        int i5 = 0;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 != 2) {
                C0733b.v(parcel, p5);
            } else {
                arrayList = C0733b.i(parcel, p5, C0719m.CREATOR);
            }
        }
        C0733b.j(parcel, w4);
        return new C0725t(i5, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C0725t[i5];
    }
}
