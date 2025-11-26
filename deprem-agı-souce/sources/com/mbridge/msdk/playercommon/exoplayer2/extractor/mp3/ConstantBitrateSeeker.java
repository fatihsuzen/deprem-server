package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class ConstantBitrateSeeker implements Mp3Extractor.Seeker {
    private static final int BITS_PER_BYTE = 8;
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFramePosition;
    private final int frameSize;

    public ConstantBitrateSeeker(long j5, long j6, MpegAudioHeader mpegAudioHeader) {
        this.firstFramePosition = j6;
        this.frameSize = mpegAudioHeader.frameSize;
        this.bitrate = mpegAudioHeader.bitrate;
        if (j5 == -1) {
            this.dataSize = -1;
            this.durationUs = C.TIME_UNSET;
            return;
        }
        this.dataSize = j5 - j6;
        this.durationUs = getTimeUs(j5);
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j5) {
        long j6 = this.dataSize;
        if (j6 == -1) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.firstFramePosition));
        }
        int i5 = this.frameSize;
        long constrainValue = Util.constrainValue((((((long) this.bitrate) * j5) / 8000000) / ((long) i5)) * ((long) i5), 0, j6 - ((long) i5));
        long j7 = this.firstFramePosition + constrainValue;
        long timeUs = getTimeUs(j7);
        SeekPoint seekPoint = new SeekPoint(timeUs, j7);
        if (timeUs < j5) {
            long j8 = this.dataSize;
            int i6 = this.frameSize;
            if (constrainValue != j8 - ((long) i6)) {
                long j9 = j7 + ((long) i6);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j9), j9));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public final long getTimeUs(long j5) {
        return (Math.max(0, j5 - this.firstFramePosition) * 8000000) / ((long) this.bitrate);
    }

    public final boolean isSeekable() {
        if (this.dataSize != -1) {
            return true;
        }
        return false;
    }
}
