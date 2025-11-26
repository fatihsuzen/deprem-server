package i0;

import O.C0733b;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: i0.c  reason: case insensitive filesystem */
public final class C1674c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        Intent intent = null;
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
                intent = (Intent) C0733b.e(parcel, p5, Intent.CREATOR);
            }
        }
        C0733b.j(parcel, w4);
        return new C1673b(i5, i6, intent);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C1673b[i5];
    }
}
