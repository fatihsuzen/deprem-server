package com.mbridge.msdk.playercommon.exoplayer2.extractor.wav;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class WavHeader implements SeekMap {
    private final int averageBytesPerSecond;
    private final int bitsPerSample;
    private final int blockAlignment;
    private long dataSize;
    private long dataStartPosition;
    private final int encoding;
    private final int numChannels;
    private final int sampleRateHz;

    public WavHeader(int i5, int i6, int i7, int i8, int i9, int i10) {
        this.numChannels = i5;
        this.sampleRateHz = i6;
        this.averageBytesPerSecond = i7;
        this.blockAlignment = i8;
        this.bitsPerSample = i9;
        this.encoding = i10;
    }

    public final int getBitrate() {
        return this.sampleRateHz * this.bitsPerSample * this.numChannels;
    }

    public final int getBytesPerFrame() {
        return this.blockAlignment;
    }

    public final long getDurationUs() {
        return ((this.dataSize / ((long) this.blockAlignment)) * 1000000) / ((long) this.sampleRateHz);
    }

    public final int getEncoding() {
        return this.encoding;
    }

    public final int getNumChannels() {
        return this.numChannels;
    }

    public final int getSampleRateHz() {
        return this.sampleRateHz;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j5) {
        int i5 = this.blockAlignment;
        long constrainValue = Util.constrainValue((((((long) this.averageBytesPerSecond) * j5) / 1000000) / ((long) i5)) * ((long) i5), 0, this.dataSize - ((long) i5));
        long j6 = this.dataStartPosition + constrainValue;
        long timeUs = getTimeUs(j6);
        SeekPoint seekPoint = new SeekPoint(timeUs, j6);
        if (timeUs < j5) {
            long j7 = this.dataSize;
            int i6 = this.blockAlignment;
            if (constrainValue != j7 - ((long) i6)) {
                long j8 = j6 + ((long) i6);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j8), j8));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public final long getTimeUs(long j5) {
        return (Math.max(0, j5 - this.dataStartPosition) * 1000000) / ((long) this.averageBytesPerSecond);
    }

    public final boolean hasDataBounds() {
        if (this.dataStartPosition == 0 || this.dataSize == 0) {
            return false;
        }
        return true;
    }

    public final boolean isSeekable() {
        return true;
    }

    public final void setDataBounds(long j5, long j6) {
        this.dataStartPosition = j5;
        this.dataSize = j6;
    }
}
