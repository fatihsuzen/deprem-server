package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;

abstract class e {
    public static void a(Object obj, Parcel parcel, int i5) {
        ((MediaMetadata) obj).writeToParcel(parcel, i5);
    }
}
