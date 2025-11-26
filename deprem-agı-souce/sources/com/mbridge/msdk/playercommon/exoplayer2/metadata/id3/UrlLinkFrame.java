package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() {
        public final UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        public final UrlLinkFrame[] newArray(int i5) {
            return new UrlLinkFrame[i5];
        }
    };
    public final String description;
    public final String url;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.url = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && UrlLinkFrame.class == obj.getClass()) {
            UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
            if (!this.id.equals(urlLinkFrame.id) || !Util.areEqual(this.description, urlLinkFrame.description) || !Util.areEqual(this.url, urlLinkFrame.url)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int hashCode = (527 + this.id.hashCode()) * 31;
        String str = this.description;
        int i6 = 0;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        int i7 = (hashCode + i5) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i6 = str2.hashCode();
        }
        return i7 + i6;
    }

    public final String toString() {
        return this.id + ": url=" + this.url;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.url);
    }

    UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.url = parcel.readString();
    }
}
