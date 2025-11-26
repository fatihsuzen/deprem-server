package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.List;

public final class Ac3Util {
    private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
    private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] SAMPLE_RATE_BY_FSCOD = {48000, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {24000, 22050, 16000};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};
    public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 16;
    public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 10;

    public static final class SyncFrameInfo {
        public static final int STREAM_TYPE_TYPE0 = 0;
        public static final int STREAM_TYPE_TYPE1 = 1;
        public static final int STREAM_TYPE_TYPE2 = 2;
        public static final int STREAM_TYPE_UNDEFINED = -1;
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface StreamType {
        }

        private SyncFrameInfo(String str, int i5, int i6, int i7, int i8, int i9) {
            this.mimeType = str;
            this.streamType = i5;
            this.channelCount = i6;
            this.sampleRate = i7;
            this.frameSize = i8;
            this.sampleCount = i9;
        }
    }

    private Ac3Util() {
    }

    public static int findTrueHdSyncframeOffset(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i5 = position; i5 <= limit; i5++) {
            if ((byteBuffer.getInt(i5 + 4) & -16777217) == -1167101192) {
                return i5 - position;
            }
        }
        return -1;
    }

    public static int getAc3SyncframeAudioSampleCount() {
        return AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
    }

    private static int getAc3SyncframeSize(int i5, int i6) {
        int i7 = i6 / 2;
        if (i5 < 0) {
            return -1;
        }
        int[] iArr = SAMPLE_RATE_BY_FSCOD;
        if (i5 >= iArr.length || i6 < 0) {
            return -1;
        }
        int[] iArr2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
        if (i7 >= iArr2.length) {
            return -1;
        }
        int i8 = iArr[i5];
        if (i8 == 44100) {
            return (iArr2[i7] + (i6 % 2)) * 2;
        }
        int i9 = BITRATE_BY_HALF_FRMSIZECOD[i7];
        if (i8 == 32000) {
            return i9 * 6;
        }
        return i9 * 4;
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        int i5 = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & PsExtractor.AUDIO_STREAM) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i6 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i6++;
        }
        return Format.createAudioSampleFormat(str, MimeTypes.AUDIO_AC3, (String) null, -1, -1, i6, i5, (List<byte[]>) null, drmInitData, 0, str2);
    }

    public static SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        boolean z4;
        int ac3SyncframeSize;
        int i5;
        int i6;
        String str;
        int i7;
        int i8;
        int i9;
        int i10;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int position = parsableBitArray2.getPosition();
        parsableBitArray2.skipBits(40);
        if (parsableBitArray2.readBits(5) == 16) {
            z4 = true;
        } else {
            z4 = false;
        }
        parsableBitArray2.setPosition(position);
        int i11 = -1;
        if (z4) {
            parsableBitArray2.skipBits(16);
            int readBits = parsableBitArray2.readBits(2);
            if (readBits == 0) {
                i11 = 0;
            } else if (readBits == 1) {
                i11 = 1;
            } else if (readBits == 2) {
                i11 = 2;
            }
            parsableBitArray2.skipBits(3);
            ac3SyncframeSize = (parsableBitArray2.readBits(11) + 1) * 2;
            int readBits2 = parsableBitArray2.readBits(2);
            if (readBits2 == 3) {
                i8 = 6;
                i5 = SAMPLE_RATE_BY_FSCOD2[parsableBitArray2.readBits(2)];
                i9 = 3;
            } else {
                i9 = parsableBitArray2.readBits(2);
                i8 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[i9];
                i5 = SAMPLE_RATE_BY_FSCOD[readBits2];
            }
            i7 = i8 * 256;
            int readBits3 = parsableBitArray2.readBits(3);
            boolean readBit = parsableBitArray2.readBit();
            i6 = CHANNEL_COUNT_BY_ACMOD[readBits3] + (readBit ? 1 : 0);
            parsableBitArray2.skipBits(10);
            if (parsableBitArray2.readBit()) {
                parsableBitArray2.skipBits(8);
            }
            if (readBits3 == 0) {
                parsableBitArray2.skipBits(5);
                if (parsableBitArray2.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
            }
            if (i11 == 1 && parsableBitArray2.readBit()) {
                parsableBitArray2.skipBits(16);
            }
            if (parsableBitArray2.readBit()) {
                if (readBits3 > 2) {
                    parsableBitArray2.skipBits(2);
                }
                if ((readBits3 & 1) != 0 && readBits3 > 2) {
                    parsableBitArray2.skipBits(6);
                }
                if ((readBits3 & 4) != 0) {
                    parsableBitArray2.skipBits(6);
                }
                if (readBit && parsableBitArray2.readBit()) {
                    parsableBitArray2.skipBits(5);
                }
                if (i11 == 0) {
                    if (parsableBitArray2.readBit()) {
                        parsableBitArray2.skipBits(6);
                    }
                    if (readBits3 == 0 && parsableBitArray2.readBit()) {
                        parsableBitArray2.skipBits(6);
                    }
                    if (parsableBitArray2.readBit()) {
                        parsableBitArray2.skipBits(6);
                    }
                    int readBits4 = parsableBitArray2.readBits(2);
                    if (readBits4 == 1) {
                        parsableBitArray2.skipBits(5);
                    } else if (readBits4 == 2) {
                        parsableBitArray2.skipBits(12);
                    } else if (readBits4 == 3) {
                        int readBits5 = parsableBitArray2.readBits(5);
                        if (parsableBitArray2.readBit()) {
                            parsableBitArray2.skipBits(5);
                            if (parsableBitArray2.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray2.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray2.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray2.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray2.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray2.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray2.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray2.readBit()) {
                                if (parsableBitArray2.readBit()) {
                                    parsableBitArray2.skipBits(4);
                                }
                                if (parsableBitArray2.readBit()) {
                                    parsableBitArray2.skipBits(4);
                                }
                            }
                        }
                        if (parsableBitArray2.readBit()) {
                            parsableBitArray2.skipBits(5);
                            if (parsableBitArray2.readBit()) {
                                parsableBitArray2.skipBits(7);
                                if (parsableBitArray2.readBit()) {
                                    parsableBitArray2.skipBits(8);
                                }
                            }
                        }
                        parsableBitArray2.skipBits((readBits5 + 2) * 8);
                        parsableBitArray2.byteAlign();
                    }
                    if (readBits3 < 2) {
                        if (parsableBitArray2.readBit()) {
                            parsableBitArray2.skipBits(14);
                        }
                        if (readBits3 == 0 && parsableBitArray2.readBit()) {
                            parsableBitArray2.skipBits(14);
                        }
                    }
                    if (parsableBitArray2.readBit()) {
                        if (i9 == 0) {
                            parsableBitArray2.skipBits(5);
                        } else {
                            for (int i12 = 0; i12 < i8; i12++) {
                                if (parsableBitArray2.readBit()) {
                                    parsableBitArray2.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray2.readBit()) {
                parsableBitArray2.skipBits(5);
                if (readBits3 == 2) {
                    parsableBitArray2.skipBits(4);
                }
                if (readBits3 >= 6) {
                    parsableBitArray2.skipBits(2);
                }
                if (parsableBitArray2.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
                if (readBits3 == 0 && parsableBitArray2.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
                i10 = 3;
                if (readBits2 < 3) {
                    parsableBitArray2.skipBit();
                }
            } else {
                i10 = 3;
            }
            if (i11 == 0 && i9 != i10) {
                parsableBitArray2.skipBit();
            }
            if (i11 == 2 && (i9 == i10 || parsableBitArray2.readBit())) {
                parsableBitArray2.skipBits(6);
            }
            if (parsableBitArray2.readBit() && parsableBitArray2.readBits(6) == 1 && parsableBitArray2.readBits(8) == 1) {
                str = MimeTypes.AUDIO_E_AC3_JOC;
            } else {
                str = MimeTypes.AUDIO_E_AC3;
            }
        } else {
            parsableBitArray2.skipBits(32);
            int readBits6 = parsableBitArray2.readBits(2);
            ac3SyncframeSize = getAc3SyncframeSize(readBits6, parsableBitArray2.readBits(6));
            parsableBitArray2.skipBits(8);
            int readBits7 = parsableBitArray2.readBits(3);
            if (!((readBits7 & 1) == 0 || readBits7 == 1)) {
                parsableBitArray2.skipBits(2);
            }
            if ((readBits7 & 4) != 0) {
                parsableBitArray2.skipBits(2);
            }
            if (readBits7 == 2) {
                parsableBitArray2.skipBits(2);
            }
            i5 = SAMPLE_RATE_BY_FSCOD[readBits6];
            i6 = CHANNEL_COUNT_BY_ACMOD[readBits7] + (parsableBitArray2.readBit() ? 1 : 0);
            str = MimeTypes.AUDIO_AC3;
            i7 = AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
        }
        return new SyncFrameInfo(str, i11, i6, i5, ac3SyncframeSize, i7);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        byte b5 = bArr[4];
        return getAc3SyncframeSize((b5 & 192) >> 6, b5 & 63);
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        String str3;
        parsableByteArray.skipBytes(2);
        int i5 = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & PsExtractor.AUDIO_STREAM) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i6 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i6++;
        }
        if (((parsableByteArray.readUnsignedByte() & 30) >> 1) > 0 && (2 & parsableByteArray.readUnsignedByte()) != 0) {
            i6 += 2;
        }
        int i7 = i6;
        if (parsableByteArray.bytesLeft() <= 0 || (parsableByteArray.readUnsignedByte() & 1) == 0) {
            str3 = MimeTypes.AUDIO_E_AC3;
        } else {
            str3 = MimeTypes.AUDIO_E_AC3_JOC;
        }
        return Format.createAudioSampleFormat(str, str3, (String) null, -1, -1, i7, i5, (List<byte[]>) null, drmInitData, 0, str2);
    }

    public static int parseEAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        int i5 = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i5 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i5 * 256;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] bArr) {
        boolean z4 = false;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b5 = bArr[7];
            if ((b5 & 254) == 186) {
                if ((b5 & 255) == 187) {
                    z4 = true;
                }
                return 40 << ((bArr[z4 ? (char) 9 : 8] >> 4) & 7);
            }
        }
        return 0;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer byteBuffer, int i5) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i5) + ((byteBuffer.get((byteBuffer.position() + i5) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }
}
