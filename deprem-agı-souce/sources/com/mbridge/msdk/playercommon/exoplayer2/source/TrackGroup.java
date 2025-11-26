package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new Parcelable.Creator<TrackGroup>() {
        public final TrackGroup createFromParcel(Parcel parcel) {
            return new TrackGroup(parcel);
        }

        public final TrackGroup[] newArray(int i5) {
            return new TrackGroup[i5];
        }
    };
    private final Format[] formats;
    private int hashCode;
    public final int length;

    public TrackGroup(Format... formatArr) {
        Assertions.checkState(formatArr.length > 0);
        this.formats = formatArr;
        this.length = formatArr.length;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackGroup.class == obj.getClass()) {
            TrackGroup trackGroup = (TrackGroup) obj;
            if (this.length != trackGroup.length || !Arrays.equals(this.formats, trackGroup.formats)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Format getFormat(int i5) {
        return this.formats[i5];
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 527 + Arrays.hashCode(this.formats);
        }
        return this.hashCode;
    }

    public final int indexOf(Format format) {
        int i5 = 0;
        while (true) {
            Format[] formatArr = this.formats;
            if (i5 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i5]) {
                return i5;
            }
            i5++;
        }
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.length);
        for (int i6 = 0; i6 < this.length; i6++) {
            parcel.writeParcelable(this.formats[i6], 0);
        }
    }

    TrackGroup(Parcel parcel) {
        int readInt = parcel.readInt();
        this.length = readInt;
        this.formats = new Format[readInt];
        for (int i5 = 0; i5 < this.length; i5++) {
            this.formats[i5] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }
}
