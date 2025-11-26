package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new Parcelable.Creator<ChapterFrame>() {
        public final ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        public final ChapterFrame[] newArray(int i5) {
            return new ChapterFrame[i5];
        }
    };
    public static final String ID = "CHAP";
    public final String chapterId;
    public final long endOffset;
    public final int endTimeMs;
    public final long startOffset;
    public final int startTimeMs;
    private final Id3Frame[] subFrames;

    public ChapterFrame(String str, int i5, int i6, long j5, long j6, Id3Frame[] id3FrameArr) {
        super(ID);
        this.chapterId = str;
        this.startTimeMs = i5;
        this.endTimeMs = i6;
        this.startOffset = j5;
        this.endOffset = j6;
        this.subFrames = id3FrameArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ChapterFrame.class == obj.getClass()) {
            ChapterFrame chapterFrame = (ChapterFrame) obj;
            if (this.startTimeMs == chapterFrame.startTimeMs && this.endTimeMs == chapterFrame.endTimeMs && this.startOffset == chapterFrame.startOffset && this.endOffset == chapterFrame.endOffset && Util.areEqual(this.chapterId, chapterFrame.chapterId) && Arrays.equals(this.subFrames, chapterFrame.subFrames)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final Id3Frame getSubFrame(int i5) {
        return this.subFrames[i5];
    }

    public final int getSubFrameCount() {
        return this.subFrames.length;
    }

    public final int hashCode() {
        int i5;
        int i6 = (((((((527 + this.startTimeMs) * 31) + this.endTimeMs) * 31) + ((int) this.startOffset)) * 31) + ((int) this.endOffset)) * 31;
        String str = this.chapterId;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        return i6 + i5;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.chapterId);
        parcel.writeInt(this.startTimeMs);
        parcel.writeInt(this.endTimeMs);
        parcel.writeLong(this.startOffset);
        parcel.writeLong(this.endOffset);
        parcel.writeInt(this.subFrames.length);
        for (Id3Frame writeParcelable : this.subFrames) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    ChapterFrame(Parcel parcel) {
        super(ID);
        this.chapterId = parcel.readString();
        this.startTimeMs = parcel.readInt();
        this.endTimeMs = parcel.readInt();
        this.startOffset = parcel.readLong();
        this.endOffset = parcel.readLong();
        int readInt = parcel.readInt();
        this.subFrames = new Id3Frame[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            this.subFrames[i5] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
