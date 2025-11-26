package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new Parcelable.Creator<InternalFrame>() {
        public final InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        public final InternalFrame[] newArray(int i5) {
            return new InternalFrame[i5];
        }
    };
    public static final String ID = "----";
    public final String description;
    public final String domain;
    public final String text;

    public InternalFrame(String str, String str2, String str3) {
        super(ID);
        this.domain = str;
        this.description = str2;
        this.text = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && InternalFrame.class == obj.getClass()) {
            InternalFrame internalFrame = (InternalFrame) obj;
            if (!Util.areEqual(this.description, internalFrame.description) || !Util.areEqual(this.domain, internalFrame.domain) || !Util.areEqual(this.text, internalFrame.text)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int i6;
        String str = this.domain;
        int i7 = 0;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = (527 + i5) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i6 = str2.hashCode();
        } else {
            i6 = 0;
        }
        int i9 = (i8 + i6) * 31;
        String str3 = this.text;
        if (str3 != null) {
            i7 = str3.hashCode();
        }
        return i9 + i7;
    }

    public final String toString() {
        return this.id + ": domain=" + this.domain + ", description=" + this.description;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.id);
        parcel.writeString(this.domain);
        parcel.writeString(this.text);
    }

    InternalFrame(Parcel parcel) {
        super(ID);
        this.domain = (String) Assertions.checkNotNull(parcel.readString());
        this.description = (String) Assertions.checkNotNull(parcel.readString());
        this.text = (String) Assertions.checkNotNull(parcel.readString());
    }
}
