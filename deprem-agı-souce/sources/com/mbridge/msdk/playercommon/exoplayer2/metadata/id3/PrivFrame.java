package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator<PrivFrame>() {
        public final PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        public final PrivFrame[] newArray(int i5) {
            return new PrivFrame[i5];
        }
    };
    public static final String ID = "PRIV";
    public final String owner;
    public final byte[] privateData;

    public PrivFrame(String str, byte[] bArr) {
        super(ID);
        this.owner = str;
        this.privateData = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PrivFrame.class == obj.getClass()) {
            PrivFrame privFrame = (PrivFrame) obj;
            if (!Util.areEqual(this.owner, privFrame.owner) || !Arrays.equals(this.privateData, privFrame.privateData)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        String str = this.owner;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        return ((527 + i5) * 31) + Arrays.hashCode(this.privateData);
    }

    public final String toString() {
        return this.id + ": owner=" + this.owner;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.owner);
        parcel.writeByteArray(this.privateData);
    }

    PrivFrame(Parcel parcel) {
        super(ID);
        this.owner = parcel.readString();
        this.privateData = parcel.createByteArray();
    }
}
