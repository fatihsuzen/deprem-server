package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() {
        public final GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        public final GeobFrame[] newArray(int i5) {
            return new GeobFrame[i5];
        }
    };
    public static final String ID = "GEOB";
    public final byte[] data;
    public final String description;
    public final String filename;
    public final String mimeType;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(ID);
        this.mimeType = str;
        this.filename = str2;
        this.description = str3;
        this.data = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && GeobFrame.class == obj.getClass()) {
            GeobFrame geobFrame = (GeobFrame) obj;
            if (!Util.areEqual(this.mimeType, geobFrame.mimeType) || !Util.areEqual(this.filename, geobFrame.filename) || !Util.areEqual(this.description, geobFrame.description) || !Arrays.equals(this.data, geobFrame.data)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int i6;
        String str = this.mimeType;
        int i7 = 0;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = (527 + i5) * 31;
        String str2 = this.filename;
        if (str2 != null) {
            i6 = str2.hashCode();
        } else {
            i6 = 0;
        }
        int i9 = (i8 + i6) * 31;
        String str3 = this.description;
        if (str3 != null) {
            i7 = str3.hashCode();
        }
        return ((i9 + i7) * 31) + Arrays.hashCode(this.data);
    }

    public final String toString() {
        return this.id + ": mimeType=" + this.mimeType + ", filename=" + this.filename + ", description=" + this.description;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.filename);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.data);
    }

    GeobFrame(Parcel parcel) {
        super(ID);
        this.mimeType = parcel.readString();
        this.filename = parcel.readString();
        this.description = parcel.readString();
        this.data = parcel.createByteArray();
    }
}
