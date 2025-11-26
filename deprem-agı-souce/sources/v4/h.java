package v4;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.t;

public final class h implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        String str;
        t.e(parcel, "parcel");
        t.e(parcel, "parcel");
        String readString = parcel.readString();
        if (readString == null) {
            readString = "";
        }
        String readString2 = parcel.readString();
        if (readString2 == null) {
            readString2 = "";
        }
        String readString3 = parcel.readString();
        if (readString3 == null) {
            readString3 = "";
        }
        String readString4 = parcel.readString();
        if (readString4 == null) {
            readString4 = "";
        }
        String readString5 = parcel.readString();
        if (readString5 == null) {
            str = "";
        } else {
            str = readString5;
        }
        return new i(readString, readString2, readString3, readString4, str);
    }

    public final Object[] newArray(int i5) {
        return new i[i5];
    }
}
