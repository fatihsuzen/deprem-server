package N;

import O.C0733b;
import android.os.Parcel;
import android.os.Parcelable;

public final class H implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int w4 = C0733b.w(parcel2);
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        String str2 = null;
        long j5 = 0;
        long j6 = 0;
        while (parcel2.dataPosition() < w4) {
            int p5 = C0733b.p(parcel2);
            switch (C0733b.k(p5)) {
                case 1:
                    i6 = C0733b.r(parcel2, p5);
                    break;
                case 2:
                    i7 = C0733b.r(parcel2, p5);
                    break;
                case 3:
                    i8 = C0733b.r(parcel2, p5);
                    break;
                case 4:
                    j5 = C0733b.s(parcel2, p5);
                    break;
                case 5:
                    j6 = C0733b.s(parcel2, p5);
                    break;
                case 6:
                    str = C0733b.f(parcel2, p5);
                    break;
                case 7:
                    str2 = C0733b.f(parcel2, p5);
                    break;
                case 8:
                    i9 = C0733b.r(parcel2, p5);
                    break;
                case 9:
                    i5 = C0733b.r(parcel2, p5);
                    break;
                default:
                    C0733b.v(parcel2, p5);
                    break;
            }
        }
        C0733b.j(parcel2, w4);
        return new C0719m(i6, i7, i8, j5, j6, str, str2, i9, i5);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C0719m[i5];
    }
}
