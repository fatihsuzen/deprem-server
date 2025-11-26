package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() {
        public final ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        public final ApicFrame[] newArray(int i5) {
            return new ApicFrame[i5];
        }
    };
    public static final String ID = "APIC";
    public final String description;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;

    public ApicFrame(String str, String str2, int i5, byte[] bArr) {
        super(ID);
        this.mimeType = str;
        this.description = str2;
        this.pictureType = i5;
        this.pictureData = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ApicFrame.class == obj.getClass()) {
            ApicFrame apicFrame = (ApicFrame) obj;
            if (this.pictureType != apicFrame.pictureType || !Util.areEqual(this.mimeType, apicFrame.mimeType) || !Util.areEqual(this.description, apicFrame.description) || !Arrays.equals(this.pictureData, apicFrame.pictureData)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int i6 = (527 + this.pictureType) * 31;
        String str = this.mimeType;
        int i7 = 0;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = (i6 + i5) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i7 = str2.hashCode();
        }
        return ((i8 + i7) * 31) + Arrays.hashCode(this.pictureData);
    }

    public final String toString() {
        return this.id + ": mimeType=" + this.mimeType + ", description=" + this.description;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.pictureType);
        parcel.writeByteArray(this.pictureData);
    }

    ApicFrame(Parcel parcel) {
        super(ID);
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.pictureType = parcel.readInt();
        this.pictureData = parcel.createByteArray();
    }
}
