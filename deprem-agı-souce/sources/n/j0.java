package N;

import K.C0657d;
import O.C0733b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class j0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int w4 = C0733b.w(parcel);
        Bundle bundle = null;
        C0711e eVar = null;
        int i5 = 0;
        C0657d[] dVarArr = null;
        while (parcel.dataPosition() < w4) {
            int p5 = C0733b.p(parcel);
            int k5 = C0733b.k(p5);
            if (k5 == 1) {
                bundle = C0733b.a(parcel, p5);
            } else if (k5 == 2) {
                dVarArr = (C0657d[]) C0733b.h(parcel, p5, C0657d.CREATOR);
            } else if (k5 == 3) {
                i5 = C0733b.r(parcel, p5);
            } else if (k5 != 4) {
                C0733b.v(parcel, p5);
            } else {
                eVar = (C0711e) C0733b.e(parcel, p5, C0711e.CREATOR);
            }
        }
        C0733b.j(parcel, w4);
        return new i0(bundle, dVarArr, i5, eVar);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new i0[i5];
    }
}
