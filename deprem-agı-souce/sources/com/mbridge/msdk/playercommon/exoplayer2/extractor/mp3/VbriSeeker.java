package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class VbriSeeker implements Mp3Extractor.Seeker {
    private static final String TAG = "VbriSeeker";
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    private VbriSeeker(long[] jArr, long[] jArr2, long j5) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j5;
    }

    public static VbriSeeker create(long j5, long j6, MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray) {
        int i5;
        int i6;
        long j7 = j5;
        MpegAudioHeader mpegAudioHeader2 = mpegAudioHeader;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.skipBytes(10);
        int readInt = parsableByteArray2.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i7 = mpegAudioHeader2.sampleRate;
        long j8 = (long) readInt;
        if (i7 >= 32000) {
            i5 = 1152;
        } else {
            i5 = 576;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j8, ((long) i5) * 1000000, (long) i7);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray2.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        long j9 = j6 + ((long) mpegAudioHeader2.frameSize);
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        int i8 = 0;
        long j10 = j6;
        while (i8 < readUnsignedShort) {
            jArr[i8] = (((long) i8) * scaleLargeTimestamp) / ((long) readUnsignedShort);
            long j11 = j9;
            jArr2[i8] = Math.max(j10, j11);
            if (readUnsignedShort3 == 1) {
                i6 = parsableByteArray2.readUnsignedByte();
            } else if (readUnsignedShort3 == 2) {
                i6 = parsableByteArray2.readUnsignedShort();
            } else if (readUnsignedShort3 == 3) {
                i6 = parsableByteArray2.readUnsignedInt24();
            } else if (readUnsignedShort3 != 4) {
                return null;
            } else {
                i6 = parsableByteArray2.readUnsignedIntToInt();
            }
            j10 += (long) (i6 * readUnsignedShort2);
            i8++;
            parsableByteArray2 = parsableByteArray;
            j9 = j11;
            readUnsignedShort = readUnsignedShort;
        }
        if (!(j7 == -1 || j7 == j10)) {
            Log.w(TAG, "VBRI data size mismatch: " + j7 + ", " + j10);
        }
        return new VbriSeeker(jArr, jArr2, scaleLargeTimestamp);
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j5) {
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j5, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[binarySearchFloor], this.positions[binarySearchFloor]);
        if (seekPoint.timeUs >= j5 || binarySearchFloor == this.timesUs.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i5 = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i5], this.positions[i5]));
    }

    public final long getTimeUs(long j5) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j5, true, true)];
    }

    public final boolean isSeekable() {
        return true;
    }
}
