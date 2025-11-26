package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

public final class TrackGroupArray implements Parcelable {
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new Parcelable.Creator<TrackGroupArray>() {
        public final TrackGroupArray createFromParcel(Parcel parcel) {
            return new TrackGroupArray(parcel);
        }

        public final TrackGroupArray[] newArray(int i5) {
            return new TrackGroupArray[i5];
        }
    };
    public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
    private int hashCode;
    public final int length;
    private final TrackGroup[] trackGroups;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.trackGroups = trackGroupArr;
        this.length = trackGroupArr.length;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackGroupArray.class == obj.getClass()) {
            TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
            if (this.length != trackGroupArray.length || !Arrays.equals(this.trackGroups, trackGroupArray.trackGroups)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final TrackGroup get(int i5) {
        return this.trackGroups[i5];
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.trackGroups);
        }
        return this.hashCode;
    }

    public final int indexOf(TrackGroup trackGroup) {
        for (int i5 = 0; i5 < this.length; i5++) {
            if (this.trackGroups[i5] == trackGroup) {
                return i5;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.length);
        for (int i6 = 0; i6 < this.length; i6++) {
            parcel.writeParcelable(this.trackGroups[i6], 0);
        }
    }

    TrackGroupArray(Parcel parcel) {
        int readInt = parcel.readInt();
        this.length = readInt;
        this.trackGroups = new TrackGroup[readInt];
        for (int i5 = 0; i5 < this.length; i5++) {
            this.trackGroups[i5] = (TrackGroup) parcel.readParcelable(TrackGroup.class.getClassLoader());
        }
    }
}
