package M2;

import android.os.Parcel;
import android.os.Parcelable;
import c.j;
import c.k;
import kotlin.jvm.internal.t;

public final class a implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        String str;
        Parcel parcel2 = parcel;
        t.e(parcel2, "parcel");
        t.e(parcel2, "parcel");
        String readString = parcel2.readString();
        if (readString == null) {
            readString = "";
        }
        String readString2 = parcel2.readString();
        if (readString2 == null) {
            readString2 = "";
        }
        String readString3 = parcel2.readString();
        if (readString3 == null) {
            readString3 = "";
        }
        String readString4 = parcel2.readString();
        if (readString4 == null) {
            readString4 = "";
        }
        String readString5 = parcel2.readString();
        if (readString5 == null) {
            readString5 = "";
        }
        String readString6 = parcel2.readString();
        if (readString6 == null) {
            readString6 = "";
        }
        String readString7 = parcel2.readString();
        if (readString7 == null) {
            readString7 = "";
        }
        String readString8 = parcel2.readString();
        if (readString8 == null) {
            readString8 = "";
        }
        String readString9 = parcel2.readString();
        if (readString9 == null) {
            readString9 = "";
        }
        String readString10 = parcel2.readString();
        if (readString10 == null) {
            readString10 = "";
        }
        String readString11 = parcel2.readString();
        if (readString11 == null) {
            readString11 = "";
        }
        String readString12 = parcel2.readString();
        if (readString12 == null) {
            readString12 = "";
        }
        int readInt = parcel2.readInt();
        k a5 = j.a(parcel2.readInt());
        String readString13 = parcel2.readString();
        if (readString13 == null) {
            readString13 = "";
        }
        String readString14 = parcel2.readString();
        if (readString14 == null) {
            str = "";
        } else {
            str = readString14;
        }
        return new b(readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readInt, a5, readString13, str);
    }

    public final Object[] newArray(int i5) {
        return new b[i5];
    }
}
