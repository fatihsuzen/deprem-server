package J;

import O.C0733b;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: J.d  reason: case insensitive filesystem */
public final class C0648d implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            if (C0733b.k(p5) != 1) {
                C0733b.v(parcel, p5);
            } else {
                intent = (Intent) C0733b.e(parcel, p5, Intent.CREATOR);
            }
        }
        C0733b.j(parcel, w4);
        return new C0645a(intent);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C0645a[i5];
    }
}
