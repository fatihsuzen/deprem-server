package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import androidx.annotation.Nullable;

public final class SeekPoint {
    public static final SeekPoint START = new SeekPoint(0, 0);
    public final long position;
    public final long timeUs;

    public SeekPoint(long j5, long j6) {
        this.timeUs = j5;
        this.position = j6;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SeekPoint.class == obj.getClass()) {
            SeekPoint seekPoint = (SeekPoint) obj;
            if (this.timeUs == seekPoint.timeUs && this.position == seekPoint.position) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.timeUs) * 31) + ((int) this.position);
    }

    public final String toString() {
        return "[timeUs=" + this.timeUs + ", position=" + this.position + "]";
    }
}
