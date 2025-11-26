package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import java.util.ArrayList;

public final class CodecSpecificDataUtil {
    private static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    private static final int AUDIO_OBJECT_TYPE_ER_BSAC = 22;
    private static final int AUDIO_OBJECT_TYPE_ESCAPE = 31;
    private static final int AUDIO_OBJECT_TYPE_PS = 29;
    private static final int AUDIO_OBJECT_TYPE_SBR = 5;
    private static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_CONFIGURATION_INVALID = -1;
    private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    private static final int AUDIO_SPECIFIC_CONFIG_FREQUENCY_INDEX_ARBITRARY = 15;
    private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};

    private CodecSpecificDataUtil() {
    }

    public static byte[] buildAacAudioSpecificConfig(int i5, int i6, int i7) {
        return new byte[]{(byte) (((i5 << 3) & 248) | ((i6 >> 1) & 7)), (byte) (((i6 << 7) & 128) | ((i7 << 3) & 120))};
    }

    public static byte[] buildAacLcAudioSpecificConfig(int i5, int i6) {
        int i7 = 0;
        int i8 = -1;
        int i9 = 0;
        while (true) {
            int[] iArr = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
            if (i9 >= iArr.length) {
                break;
            }
            if (i5 == iArr[i9]) {
                i8 = i9;
            }
            i9++;
        }
        int i10 = -1;
        while (true) {
            int[] iArr2 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
            if (i7 >= iArr2.length) {
                break;
            }
            if (i6 == iArr2[i7]) {
                i10 = i7;
            }
            i7++;
        }
        if (i5 != -1 && i10 != -1) {
            return buildAacAudioSpecificConfig(2, i8, i10);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i5 + ", " + i6);
    }

    public static byte[] buildNalUnit(byte[] bArr, int i5, int i6) {
        byte[] bArr2 = NAL_START_CODE;
        byte[] bArr3 = new byte[(bArr2.length + i6)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i5, bArr3, bArr2.length, i6);
        return bArr3;
    }

    private static int findNalStartCode(byte[] bArr, int i5) {
        int length = bArr.length - NAL_START_CODE.length;
        while (i5 <= length) {
            if (isNalStartCode(bArr, i5)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private static int getAacAudioObjectType(ParsableBitArray parsableBitArray) {
        int readBits = parsableBitArray.readBits(5);
        if (readBits == 31) {
            return parsableBitArray.readBits(6) + 32;
        }
        return readBits;
    }

    private static int getAacSamplingFrequency(ParsableBitArray parsableBitArray) {
        boolean z4;
        int readBits = parsableBitArray.readBits(4);
        if (readBits == 15) {
            return parsableBitArray.readBits(24);
        }
        if (readBits < 13) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        return AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[readBits];
    }

    private static boolean isNalStartCode(byte[] bArr, int i5) {
        if (bArr.length - i5 <= NAL_START_CODE.length) {
            return false;
        }
        int i6 = 0;
        while (true) {
            byte[] bArr2 = NAL_START_CODE;
            if (i6 >= bArr2.length) {
                return true;
            }
            if (bArr[i5 + i6] != bArr2[i6]) {
                return false;
            }
            i6++;
        }
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(byte[] bArr) throws ParserException {
        return parseAacAudioSpecificConfig(new ParsableBitArray(bArr), false);
    }

    private static void parseGaSpecificConfig(ParsableBitArray parsableBitArray, int i5, int i6) {
        parsableBitArray.skipBits(1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(14);
        }
        boolean readBit = parsableBitArray.readBit();
        if (i6 != 0) {
            if (i5 == 6 || i5 == 20) {
                parsableBitArray.skipBits(3);
            }
            if (readBit) {
                if (i5 == 22) {
                    parsableBitArray.skipBits(16);
                }
                if (i5 == 17 || i5 == 19 || i5 == 20 || i5 == 23) {
                    parsableBitArray.skipBits(3);
                }
                parsableBitArray.skipBits(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }

    public static byte[][] splitNalUnits(byte[] bArr) {
        int i5;
        if (!isNalStartCode(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        do {
            arrayList.add(Integer.valueOf(i6));
            i6 = findNalStartCode(bArr, i6 + NAL_START_CODE.length);
        } while (i6 != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            int intValue = ((Integer) arrayList.get(i7)).intValue();
            if (i7 < arrayList.size() - 1) {
                i5 = ((Integer) arrayList.get(i7 + 1)).intValue();
            } else {
                i5 = bArr.length;
            }
            int i8 = i5 - intValue;
            byte[] bArr3 = new byte[i8];
            System.arraycopy(bArr, intValue, bArr3, 0, i8);
            bArr2[i7] = bArr3;
        }
        return bArr2;
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(ParsableBitArray parsableBitArray, boolean z4) throws ParserException {
        int aacAudioObjectType = getAacAudioObjectType(parsableBitArray);
        int aacSamplingFrequency = getAacSamplingFrequency(parsableBitArray);
        int readBits = parsableBitArray.readBits(4);
        if (aacAudioObjectType == 5 || aacAudioObjectType == 29) {
            aacSamplingFrequency = getAacSamplingFrequency(parsableBitArray);
            aacAudioObjectType = getAacAudioObjectType(parsableBitArray);
            if (aacAudioObjectType == 22) {
                readBits = parsableBitArray.readBits(4);
            }
        }
        boolean z5 = true;
        if (z4) {
            if (!(aacAudioObjectType == 1 || aacAudioObjectType == 2 || aacAudioObjectType == 3 || aacAudioObjectType == 4 || aacAudioObjectType == 6 || aacAudioObjectType == 7 || aacAudioObjectType == 17)) {
                switch (aacAudioObjectType) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new ParserException("Unsupported audio object type: " + aacAudioObjectType);
                }
            }
            parseGaSpecificConfig(parsableBitArray, aacAudioObjectType, readBits);
            switch (aacAudioObjectType) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int readBits2 = parsableBitArray.readBits(2);
                    if (readBits2 == 2 || readBits2 == 3) {
                        throw new ParserException("Unsupported epConfig: " + readBits2);
                    }
            }
        }
        int i5 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[readBits];
        if (i5 == -1) {
            z5 = false;
        }
        Assertions.checkArgument(z5);
        return Pair.create(Integer.valueOf(aacSamplingFrequency), Integer.valueOf(i5));
    }
}
