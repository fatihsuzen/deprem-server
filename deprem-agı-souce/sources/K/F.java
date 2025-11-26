package K;

import O.C0733b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class F implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            switch (C0733b.k(p5)) {
                case 1:
                    str = C0733b.f(parcel, p5);
                    break;
                case 2:
                    z4 = C0733b.l(parcel, p5);
                    break;
                case 3:
                    z5 = C0733b.l(parcel, p5);
                    break;
                case 4:
                    iBinder = C0733b.q(parcel, p5);
                    break;
                case 5:
                    z6 = C0733b.l(parcel, p5);
                    break;
                case 6:
                    z7 = C0733b.l(parcel, p5);
                    break;
                default:
                    C0733b.v(parcel, p5);
                    break;
            }
        }
        C0733b.j(parcel, w4);
        return new E(str, z4, z5, iBinder, z6, z7);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new E[i5];
    }
}
