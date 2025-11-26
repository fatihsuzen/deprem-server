package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator<BinaryFrame>() {
        public final BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        public final BinaryFrame[] newArray(int i5) {
            return new BinaryFrame[i5];
        }
    };
    public final byte[] data;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && BinaryFrame.class == obj.getClass()) {
            BinaryFrame binaryFrame = (BinaryFrame) obj;
            if (!this.id.equals(binaryFrame.id) || !Arrays.equals(this.data, binaryFrame.data)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((527 + this.id.hashCode()) * 31) + Arrays.hashCode(this.data);
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.id);
        parcel.writeByteArray(this.data);
    }

    BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        this.data = parcel.createByteArray();
    }
}
