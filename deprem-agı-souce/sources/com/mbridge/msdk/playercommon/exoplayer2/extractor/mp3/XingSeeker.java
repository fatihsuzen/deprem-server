package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class XingSeeker implements Mp3Extractor.Seeker {
    private static final String TAG = "XingSeeker";
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;
    private final long[] tableOfContents;
    private final int xingFrameSize;

    private XingSeeker(long j5, int i5, long j6) {
        this(j5, i5, j6, -1, (long[]) null);
    }

    public static XingSeeker create(long j5, long j6, MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt;
        long j7 = j5;
        MpegAudioHeader mpegAudioHeader2 = mpegAudioHeader;
        int i5 = mpegAudioHeader2.samplesPerFrame;
        int i6 = mpegAudioHeader2.sampleRate;
        int readInt = parsableByteArray.readInt();
        if ((readInt & 1) != 1 || (readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) == 0) {
            return null;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp((long) readUnsignedIntToInt, ((long) i5) * 1000000, (long) i6);
        if ((readInt & 6) != 6) {
            return new XingSeeker(j6, mpegAudioHeader2.frameSize, scaleLargeTimestamp);
        }
        long readUnsignedIntToInt2 = (long) parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[100];
        for (int i7 = 0; i7 < 100; i7++) {
            jArr[i7] = (long) parsableByteArray.readUnsignedByte();
        }
        if (j7 != -1) {
            long j8 = j6 + readUnsignedIntToInt2;
            if (j7 != j8) {
                Log.w(TAG, "XING data size mismatch: " + j7 + ", " + j8);
            }
        }
        return new XingSeeker(j6, mpegAudioHeader2.frameSize, scaleLargeTimestamp, readUnsignedIntToInt2, jArr);
    }

    private long getTimeUsForTableIndex(int i5) {
        return (this.durationUs * ((long) i5)) / 100;
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j5) {
        double d5;
        if (!isSeekable()) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.dataStartPosition + ((long) this.xingFrameSize)));
        }
        long constrainValue = Util.constrainValue(j5, 0, this.durationUs);
        double d6 = (((double) constrainValue) * 100.0d) / ((double) this.durationUs);
        double d7 = 0.0d;
        if (d6 > 0.0d) {
            if (d6 >= 100.0d) {
                d7 = 256.0d;
            } else {
                int i5 = (int) d6;
                long[] jArr = this.tableOfContents;
                double d8 = (double) jArr[i5];
                if (i5 == 99) {
                    d5 = 256.0d;
                } else {
                    d5 = (double) jArr[i5 + 1];
                }
                d7 = d8 + ((d6 - ((double) i5)) * (d5 - d8));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(constrainValue, this.dataStartPosition + Util.constrainValue(Math.round((d7 / 256.0d) * ((double) this.dataSize)), (long) this.xingFrameSize, this.dataSize - 1)));
    }

    public final long getTimeUs(long j5) {
        long j6;
        double d5;
        long j7 = j5 - this.dataStartPosition;
        if (!isSeekable() || j7 <= ((long) this.xingFrameSize)) {
            return 0;
        }
        double d6 = (((double) j7) * 256.0d) / ((double) this.dataSize);
        int binarySearchFloor = Util.binarySearchFloor(this.tableOfContents, (long) d6, true, true);
        long timeUsForTableIndex = getTimeUsForTableIndex(binarySearchFloor);
        long j8 = this.tableOfContents[binarySearchFloor];
        int i5 = binarySearchFloor + 1;
        long timeUsForTableIndex2 = getTimeUsForTableIndex(i5);
        if (binarySearchFloor == 99) {
            j6 = 256;
        } else {
            j6 = this.tableOfContents[i5];
        }
        if (j8 == j6) {
            d5 = 0.0d;
        } else {
            d5 = (d6 - ((double) j8)) / ((double) (j6 - j8));
        }
        return timeUsForTableIndex + Math.round(d5 * ((double) (timeUsForTableIndex2 - timeUsForTableIndex)));
    }

    public final boolean isSeekable() {
        if (this.tableOfContents != null) {
            return true;
        }
        return false;
    }

    private XingSeeker(long j5, int i5, long j6, long j7, long[] jArr) {
        this.dataStartPosition = j5;
        this.xingFrameSize = i5;
        this.durationUs = j6;
        this.dataSize = j7;
        this.tableOfContents = jArr;
    }
}
