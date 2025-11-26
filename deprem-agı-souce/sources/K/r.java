package K;

import O.C0733b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

public final class r implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        PendingIntent pendingIntent = null;
        int i5 = 0;
        int i6 = 0;
        String str = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 == 2) {
                i6 = C0733b.r(parcel, p5);
            } else if (k5 == 3) {
                pendingIntent = (PendingIntent) C0733b.e(parcel, p5, PendingIntent.CREATOR);
            } else if (k5 != 4) {
                C0733b.v(parcel, p5);
            } else {
                str = C0733b.f(parcel, p5);
            }
        }
        C0733b.j(parcel, w4);
        return new C0655b(i5, i6, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C0655b[i5];
    }
}
