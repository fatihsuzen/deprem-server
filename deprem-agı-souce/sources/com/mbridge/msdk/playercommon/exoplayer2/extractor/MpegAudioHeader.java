package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

public final class MpegAudioHeader {
    private static final int[] BITRATE_V1_L1 = {32, 64, 96, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 288, 320, 352, 384, TypedValues.CycleType.TYPE_PATH_ROTATE, 448};
    private static final int[] BITRATE_V1_L2 = {32, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384};
    private static final int[] BITRATE_V1_L3 = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320};
    private static final int[] BITRATE_V2 = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    private static final int[] BITRATE_V2_L1 = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, PsExtractor.AUDIO_STREAM, 224, 256};
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    private static final String[] MIME_TYPE_BY_LAYER = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};
    private static final int[] SAMPLING_RATE_V1 = {44100, 48000, 32000};
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;

    public static int getFrameSize(int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        if ((i5 & -2097152) != -2097152 || (i6 = (i5 >>> 19) & 3) == 1 || (i7 = (i5 >>> 17) & 3) == 0 || (i8 = (i5 >>> 12) & 15) == 0 || i8 == 15 || (i9 = (i5 >>> 10) & 3) == 3) {
            return -1;
        }
        int i12 = SAMPLING_RATE_V1[i9];
        if (i6 == 2) {
            i12 /= 2;
        } else if (i6 == 0) {
            i12 /= 4;
        }
        int i13 = (i5 >>> 9) & 1;
        if (i7 == 3) {
            if (i6 == 3) {
                i11 = BITRATE_V1_L1[i8 - 1];
            } else {
                i11 = BITRATE_V2_L1[i8 - 1];
            }
            return (((i11 * 12000) / i12) + i13) * 4;
        }
        if (i6 != 3) {
            i10 = BITRATE_V2[i8 - 1];
        } else if (i7 == 2) {
            i10 = BITRATE_V1_L2[i8 - 1];
        } else {
            i10 = BITRATE_V1_L3[i8 - 1];
        }
        int i14 = 144000;
        if (i6 == 3) {
            return ((i10 * 144000) / i12) + i13;
        }
        if (i7 == 1) {
            i14 = DefaultOggSeeker.MATCH_RANGE;
        }
        return ((i14 * i10) / i12) + i13;
    }

    public static boolean populateHeader(int i5, MpegAudioHeader mpegAudioHeader) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if ((i5 & -2097152) != -2097152 || (i6 = (i5 >>> 19) & 3) == 1 || (i7 = (i5 >>> 17) & 3) == 0 || (i8 = (i5 >>> 12) & 15) == 0 || i8 == 15 || (i9 = (i5 >>> 10) & 3) == 3) {
            return false;
        }
        int i15 = SAMPLING_RATE_V1[i9];
        int i16 = 2;
        if (i6 == 2) {
            i15 /= 2;
        } else if (i6 == 0) {
            i15 /= 4;
        }
        int i17 = i15;
        int i18 = (i5 >>> 9) & 1;
        if (i7 == 3) {
            if (i6 == 3) {
                i12 = BITRATE_V1_L1[i8 - 1];
            } else {
                i12 = BITRATE_V2_L1[i8 - 1];
            }
            i11 = (((i12 * 12000) / i17) + i18) * 4;
            i10 = 384;
        } else {
            int i19 = 1152;
            if (i6 != 3) {
                i14 = BITRATE_V2[i8 - 1];
                if (i7 == 1) {
                    i19 = 576;
                }
                if (i7 == 1) {
                    i13 = DefaultOggSeeker.MATCH_RANGE;
                    i10 = i19;
                    i11 = i18 + ((i13 * i12) / i17);
                }
            } else if (i7 == 2) {
                i14 = BITRATE_V1_L2[i8 - 1];
            } else {
                i14 = BITRATE_V1_L3[i8 - 1];
            }
            i13 = 144000;
            i10 = i19;
            i11 = i18 + ((i13 * i12) / i17);
        }
        String str = MIME_TYPE_BY_LAYER[3 - i7];
        if (((i5 >> 6) & 3) == 3) {
            i16 = 1;
        }
        int i20 = i11;
        int i21 = i16;
        mpegAudioHeader.setValues(i6, str, i20, i17, i21, i12 * 1000, i10);
        return true;
    }

    private void setValues(int i5, String str, int i6, int i7, int i8, int i9, int i10) {
        this.version = i5;
        this.mimeType = str;
        this.frameSize = i6;
        this.sampleRate = i7;
        this.channels = i8;
        this.bitrate = i9;
        this.samplesPerFrame = i10;
    }
}
