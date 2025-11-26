package f0;

import O.C0733b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: f0.b  reason: case insensitive filesystem */
public final class C1647b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            if (C0733b.k(p5) != 1) {
                C0733b.v(parcel, p5);
            } else {
                bundle = C0733b.a(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new C1646a(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C1646a[i5];
    }
}
