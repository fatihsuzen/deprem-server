package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.google.android.material.internal.ViewUtils;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

public final class DtsUtil {
    private static final int[] CHANNELS_BY_AMODE = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final byte FIRST_BYTE_14B_BE = 31;
    private static final byte FIRST_BYTE_14B_LE = -1;
    private static final byte FIRST_BYTE_BE = Byte.MAX_VALUE;
    private static final byte FIRST_BYTE_LE = -2;
    private static final int[] SAMPLE_RATE_BY_SFREQ = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int SYNC_VALUE_14B_BE = 536864768;
    private static final int SYNC_VALUE_14B_LE = -14745368;
    private static final int SYNC_VALUE_BE = 2147385345;
    private static final int SYNC_VALUE_LE = -25230976;
    private static final int[] TWICE_BITRATE_KBPS_BY_RATE = {64, 112, 128, PsExtractor.AUDIO_STREAM, 224, 256, 384, 448, 512, 640, ViewUtils.EDGE_TO_EDGE_FLAGS, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    private DtsUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getDtsFrameSize(byte[] r7) {
        /*
            r0 = 0
            byte r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L_0x004f
            r2 = -1
            if (r1 == r2) goto L_0x003e
            r2 = 31
            if (r1 == r2) goto L_0x0026
            r1 = 5
            byte r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            byte r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r7 = r7[r3]
        L_0x0020:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L_0x005e
        L_0x0026:
            byte r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            byte r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            byte r7 = r7[r1]
        L_0x0036:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L_0x005e
        L_0x003e:
            byte r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            byte r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            byte r7 = r7[r1]
            goto L_0x0036
        L_0x004f:
            byte r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            byte r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r7 = r7[r4]
            goto L_0x0020
        L_0x005e:
            if (r0 == 0) goto L_0x0064
            int r7 = r7 * 16
            int r7 = r7 / 14
        L_0x0064:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.audio.DtsUtil.getDtsFrameSize(byte[]):int");
    }

    private static ParsableBitArray getNormalizedFrameHeader(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new ParsableBitArray(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (isLittleEndianFrameHeader(copyOf)) {
            for (int i5 = 0; i5 < copyOf.length - 1; i5 += 2) {
                byte b5 = copyOf[i5];
                int i6 = i5 + 1;
                copyOf[i5] = copyOf[i6];
                copyOf[i6] = b5;
            }
        }
        ParsableBitArray parsableBitArray = new ParsableBitArray(copyOf);
        if (copyOf[0] == 31) {
            ParsableBitArray parsableBitArray2 = new ParsableBitArray(copyOf);
            while (parsableBitArray2.bitsLeft() >= 16) {
                parsableBitArray2.skipBits(2);
                parsableBitArray.putInt(parsableBitArray2.readBits(14), 14);
            }
        }
        parsableBitArray.reset(copyOf);
        return parsableBitArray;
    }

    private static boolean isLittleEndianFrameHeader(byte[] bArr) {
        byte b5 = bArr[0];
        if (b5 == -2 || b5 == -1) {
            return true;
        }
        return false;
    }

    public static boolean isSyncWord(int i5) {
        return i5 == SYNC_VALUE_BE || i5 == SYNC_VALUE_LE || i5 == SYNC_VALUE_14B_BE || i5 == SYNC_VALUE_14B_LE;
    }

    public static int parseDtsAudioSampleCount(byte[] bArr) {
        int i5;
        byte b5;
        byte b6;
        int i6;
        byte b7;
        byte b8 = bArr[0];
        if (b8 != -2) {
            if (b8 == -1) {
                i6 = (bArr[4] & 7) << 4;
                b7 = bArr[7];
            } else if (b8 != 31) {
                i5 = (bArr[4] & 1) << 6;
                b5 = bArr[5];
            } else {
                i6 = (bArr[5] & 7) << 4;
                b7 = bArr[6];
            }
            b6 = b7 & 60;
            return (((b6 >> 2) | i6) + 1) * 32;
        }
        i5 = (bArr[5] & 1) << 6;
        b5 = bArr[4];
        b6 = b5 & 252;
        return (((b6 >> 2) | i6) + 1) * 32;
    }

    public static Format parseDtsFormat(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int i5;
        int i6;
        ParsableBitArray normalizedFrameHeader = getNormalizedFrameHeader(bArr);
        normalizedFrameHeader.skipBits(60);
        int i7 = CHANNELS_BY_AMODE[normalizedFrameHeader.readBits(6)];
        int i8 = SAMPLE_RATE_BY_SFREQ[normalizedFrameHeader.readBits(4)];
        int readBits = normalizedFrameHeader.readBits(5);
        int[] iArr = TWICE_BITRATE_KBPS_BY_RATE;
        if (readBits >= iArr.length) {
            i5 = -1;
        } else {
            i5 = (iArr[readBits] * 1000) / 2;
        }
        int i9 = i5;
        normalizedFrameHeader.skipBits(10);
        if (normalizedFrameHeader.readBits(2) > 0) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        return Format.createAudioSampleFormat(str, MimeTypes.AUDIO_DTS, (String) null, i9, -1, i7 + i6, i8, (List<byte[]>) null, drmInitData, 0, str2);
    }

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer) {
        int i5;
        byte b5;
        byte b6;
        int i6;
        byte b7;
        int position = byteBuffer.position();
        byte b8 = byteBuffer.get(position);
        if (b8 != -2) {
            if (b8 == -1) {
                i6 = (byteBuffer.get(position + 4) & 7) << 4;
                b7 = byteBuffer.get(position + 7);
            } else if (b8 != 31) {
                i5 = (byteBuffer.get(position + 4) & 1) << 6;
                b5 = byteBuffer.get(position + 5);
            } else {
                i6 = (byteBuffer.get(position + 5) & 7) << 4;
                b7 = byteBuffer.get(position + 6);
            }
            b6 = b7 & 60;
            return (((b6 >> 2) | i6) + 1) * 32;
        }
        i5 = (byteBuffer.get(position + 5) & 1) << 6;
        b5 = byteBuffer.get(position + 4);
        b6 = b5 & 252;
        return (((b6 >> 2) | i6) + 1) * 32;
    }
}
