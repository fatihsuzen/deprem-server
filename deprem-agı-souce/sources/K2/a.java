package K2;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.t;

public final class a implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        t.e(parcel, "parcel");
        return new c(parcel);
    }

    public final Object[] newArray(int i5) {
        return new c[i5];
    }
}
