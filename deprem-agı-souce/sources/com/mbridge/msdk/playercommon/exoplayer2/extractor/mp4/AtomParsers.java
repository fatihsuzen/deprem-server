package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 3;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_meta = Util.getIntegerCodeForString("meta");
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_text = Util.getIntegerCodeForString(MimeTypes.BASE_TYPE_TEXT);
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z4) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z4;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() != 1 ? false : true, "first_chunk must be 1");
            this.index = -1;
        }

        public final boolean moveNext() {
            long j5;
            int i5;
            int i6 = this.index + 1;
            this.index = i6;
            if (i6 == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                j5 = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                j5 = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = j5;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i7 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i7;
                if (i7 > 0) {
                    i5 = this.stsc.readUnsignedIntToInt() - 1;
                } else {
                    i5 = -1;
                }
                this.nextSamplesPerChunkChangeIndex = i5;
            }
            return true;
        }
    }

    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i5) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i5];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fixedSampleSize = parsableByteArray.readUnsignedIntToInt();
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final boolean isFixedSampleSize() {
            if (this.fixedSampleSize != 0) {
                return true;
            }
            return false;
        }

        public final int readNextSampleSize() {
            int i5 = this.fixedSampleSize;
            if (i5 == 0) {
                return this.data.readUnsignedIntToInt();
            }
            return i5;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final boolean isFixedSampleSize() {
            return false;
        }

        public final int readNextSampleSize() {
            int i5 = this.fieldSize;
            if (i5 == 8) {
                return this.data.readUnsignedByte();
            }
            if (i5 == 16) {
                return this.data.readUnsignedShort();
            }
            int i6 = this.sampleIndex;
            this.sampleIndex = i6 + 1;
            if (i6 % 2 != 0) {
                return this.currentByte & 15;
            }
            int readUnsignedByte = this.data.readUnsignedByte();
            this.currentByte = readUnsignedByte;
            return (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        }
    }

    private static final class TkhdData {
        /* access modifiers changed from: private */
        public final long duration;
        /* access modifiers changed from: private */
        public final int id;
        /* access modifiers changed from: private */
        public final int rotationDegrees;

        public TkhdData(int i5, long j5, int i6) {
            this.id = i5;
            this.duration = j5;
            this.rotationDegrees = i6;
        }
    }

    public static final class UnhandledEditListException extends ParserException {
    }

    private AtomParsers() {
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j5, long j6, long j7) {
        int length = jArr.length - 1;
        int constrainValue = Util.constrainValue(3, 0, length);
        int constrainValue2 = Util.constrainValue(jArr.length - 3, 0, length);
        if (jArr[0] > j6 || j6 >= jArr[constrainValue] || jArr[constrainValue2] >= j7 || j7 > j5) {
            return false;
        }
        return true;
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i5, int i6) {
        boolean z4;
        int position = parsableByteArray.getPosition();
        while (position - i5 < i6) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            if (readInt > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v6, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseAudioSampleEntry(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r29, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.StsdData r30, int r31) throws com.mbridge.msdk.playercommon.exoplayer2.ParserException {
        /*
            r0 = r22
            r1 = r24
            r2 = r25
            r11 = r27
            r3 = r29
            r14 = r30
            int r4 = r1 + 16
            r0.setPosition(r4)
            r4 = 6
            if (r28 == 0) goto L_0x001c
            int r5 = r0.readUnsignedShort()
            r0.skipBytes(r4)
            goto L_0x0022
        L_0x001c:
            r5 = 8
            r0.skipBytes(r5)
            r5 = 0
        L_0x0022:
            r6 = 2
            r7 = 1
            r8 = 16
            if (r5 == 0) goto L_0x0043
            if (r5 != r7) goto L_0x002b
            goto L_0x0043
        L_0x002b:
            if (r5 != r6) goto L_0x0206
            r0.skipBytes(r8)
            double r4 = r0.readDouble()
            long r4 = java.lang.Math.round(r4)
            int r4 = (int) r4
            int r5 = r0.readUnsignedIntToInt()
            r8 = 20
            r0.skipBytes(r8)
            goto L_0x0054
        L_0x0043:
            int r9 = r0.readUnsignedShort()
            r0.skipBytes(r4)
            int r4 = r0.readUnsignedFixedPoint1616()
            if (r5 != r7) goto L_0x0053
            r0.skipBytes(r8)
        L_0x0053:
            r5 = r9
        L_0x0054:
            int r8 = r0.getPosition()
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_enca
            r16 = 0
            r10 = r23
            if (r10 != r9) goto L_0x0088
            android.util.Pair r9 = parseSampleEntryEncryptionData(r0, r1, r2)
            if (r9 == 0) goto L_0x0085
            java.lang.Object r10 = r9.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r3 != 0) goto L_0x0073
            r3 = r16
            goto L_0x007d
        L_0x0073:
            java.lang.Object r12 = r9.second
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox r12 = (com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox) r12
            java.lang.String r12 = r12.schemeType
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r3 = r3.copyWithSchemeType(r12)
        L_0x007d:
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox[] r12 = r14.trackEncryptionBoxes
            java.lang.Object r9 = r9.second
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox r9 = (com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox) r9
            r12[r31] = r9
        L_0x0085:
            r0.setPosition(r8)
        L_0x0088:
            r9 = r3
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ac_3
            java.lang.String r12 = "audio/raw"
            if (r10 != r3) goto L_0x0092
            java.lang.String r3 = "audio/ac3"
            goto L_0x00dc
        L_0x0092:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ec_3
            if (r10 != r3) goto L_0x0099
            java.lang.String r3 = "audio/eac3"
            goto L_0x00dc
        L_0x0099:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtsc
            if (r10 != r3) goto L_0x00a0
            java.lang.String r3 = "audio/vnd.dts"
            goto L_0x00dc
        L_0x00a0:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtsh
            if (r10 == r3) goto L_0x00da
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtsl
            if (r10 != r3) goto L_0x00a9
            goto L_0x00da
        L_0x00a9:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtse
            if (r10 != r3) goto L_0x00b0
            java.lang.String r3 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00dc
        L_0x00b0:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_samr
            if (r10 != r3) goto L_0x00b7
            java.lang.String r3 = "audio/3gpp"
            goto L_0x00dc
        L_0x00b7:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_sawb
            if (r10 != r3) goto L_0x00be
            java.lang.String r3 = "audio/amr-wb"
            goto L_0x00dc
        L_0x00be:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_lpcm
            if (r10 == r3) goto L_0x00d8
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_sowt
            if (r10 != r3) goto L_0x00c7
            goto L_0x00d8
        L_0x00c7:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE__mp3
            if (r10 != r3) goto L_0x00ce
            java.lang.String r3 = "audio/mpeg"
            goto L_0x00dc
        L_0x00ce:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_alac
            if (r10 != r3) goto L_0x00d5
            java.lang.String r3 = "audio/alac"
            goto L_0x00dc
        L_0x00d5:
            r3 = r16
            goto L_0x00dc
        L_0x00d8:
            r3 = r12
            goto L_0x00dc
        L_0x00da:
            java.lang.String r3 = "audio/vnd.dts.hd"
        L_0x00dc:
            r17 = r4
            r4 = r3
            r3 = r17
            r17 = r8
            r8 = r5
            r5 = r17
            r17 = r16
        L_0x00e8:
            int r10 = r5 - r1
            if (r10 >= r2) goto L_0x01d3
            r0.setPosition(r5)
            int r10 = r0.readInt()
            if (r10 <= 0) goto L_0x00f7
            r6 = r7
            goto L_0x00f8
        L_0x00f7:
            r6 = 0
        L_0x00f8:
            java.lang.String r7 = "childAtomSize should be positive"
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkArgument(r6, r7)
            int r6 = r0.readInt()
            int r7 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_esds
            if (r6 == r7) goto L_0x010b
            if (r28 == 0) goto L_0x0117
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_wave
            if (r6 != r13) goto L_0x0117
        L_0x010b:
            r15 = r5
            r11 = r9
            r1 = r10
            r2 = r12
            r5 = 0
            r18 = 2
            r19 = 1
            r9 = r3
            goto L_0x018c
        L_0x0117:
            int r7 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dac3
            if (r6 != r7) goto L_0x0135
            int r6 = r5 + 8
            r0.setPosition(r6)
            java.lang.String r6 = java.lang.Integer.toString(r26)
            com.mbridge.msdk.playercommon.exoplayer2.Format r6 = com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util.parseAc3AnnexFFormat(r0, r6, r11, r9)
            r14.format = r6
        L_0x012a:
            r15 = r5
            r11 = r9
            r1 = r10
            r2 = r12
            r5 = 0
            r18 = 2
            r19 = 1
            r9 = r3
            goto L_0x018a
        L_0x0135:
            int r7 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dec3
            if (r6 != r7) goto L_0x0149
            int r6 = r5 + 8
            r0.setPosition(r6)
            java.lang.String r6 = java.lang.Integer.toString(r26)
            com.mbridge.msdk.playercommon.exoplayer2.Format r6 = com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util.parseEAc3AnnexFFormat(r0, r6, r11, r9)
            r14.format = r6
            goto L_0x012a
        L_0x0149:
            int r7 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ddts
            if (r6 != r7) goto L_0x0172
            r11 = r9
            r9 = r3
            java.lang.String r3 = java.lang.Integer.toString(r26)
            r6 = r10
            r10 = 0
            r7 = r12
            r12 = 0
            r13 = r5
            r5 = 0
            r20 = r6
            r6 = -1
            r21 = r7
            r7 = -1
            r15 = r13
            r1 = r20
            r2 = r21
            r18 = 2
            r19 = 1
            r13 = r27
            com.mbridge.msdk.playercommon.exoplayer2.Format r3 = com.mbridge.msdk.playercommon.exoplayer2.Format.createAudioSampleFormat(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r14.format = r3
        L_0x0170:
            r5 = 0
            goto L_0x018a
        L_0x0172:
            r15 = r5
            r11 = r9
            r1 = r10
            r2 = r12
            r18 = 2
            r19 = 1
            r9 = r3
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_alac
            if (r6 != r3) goto L_0x0170
            byte[] r3 = new byte[r1]
            r0.setPosition(r15)
            r5 = 0
            r0.readBytes(r3, r5, r1)
            r17 = r3
        L_0x018a:
            r3 = r9
            goto L_0x01c3
        L_0x018c:
            if (r6 != r7) goto L_0x0191
            r3 = r15
        L_0x018f:
            r6 = -1
            goto L_0x0196
        L_0x0191:
            int r3 = findEsdsPosition(r0, r15, r1)
            goto L_0x018f
        L_0x0196:
            if (r3 == r6) goto L_0x018a
            android.util.Pair r3 = parseEsdsFromParent(r0, r3)
            java.lang.Object r4 = r3.first
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.second
            r17 = r3
            byte[] r17 = (byte[]) r17
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x018a
            android.util.Pair r3 = com.mbridge.msdk.playercommon.exoplayer2.util.CodecSpecificDataUtil.parseAacAudioSpecificConfig(r17)
            java.lang.Object r6 = r3.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r8 = r3.intValue()
            r3 = r6
        L_0x01c3:
            int r1 = r1 + r15
            r5 = r1
            r12 = r2
            r9 = r11
            r6 = r18
            r7 = r19
            r1 = r24
            r2 = r25
            r11 = r27
            goto L_0x00e8
        L_0x01d3:
            r18 = r6
            r11 = r9
            r2 = r12
            r6 = -1
            r9 = r3
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r14.format
            if (r0 != 0) goto L_0x0206
            if (r4 == 0) goto L_0x0206
            boolean r0 = r2.equals(r4)
            if (r0 == 0) goto L_0x01e8
            r7 = r18
            goto L_0x01e9
        L_0x01e8:
            r7 = r6
        L_0x01e9:
            java.lang.String r0 = java.lang.Integer.toString(r26)
            if (r17 != 0) goto L_0x01f0
            goto L_0x01f4
        L_0x01f0:
            java.util.List r16 = java.util.Collections.singletonList(r17)
        L_0x01f4:
            r10 = 0
            r2 = 0
            r3 = -1
            r1 = r4
            r4 = -1
            r5 = r8
            r6 = r9
            r9 = r11
            r8 = r16
            r11 = r27
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = com.mbridge.msdk.playercommon.exoplayer2.Format.createAudioSampleFormat(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r14.format = r0
        L_0x0206:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.parseAudioSampleEntry(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i5, int i6) {
        boolean z4;
        boolean z5;
        int i7 = i5 + 8;
        boolean z6 = false;
        int i8 = -1;
        int i9 = 0;
        String str = null;
        Integer num = null;
        while (i7 - i5 < i6) {
            parsableByteArray.setPosition(i7);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_frma) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == Atom.TYPE_schi) {
                i8 = i7;
                i9 = readInt;
            }
            i7 += readInt;
        }
        if (!C.CENC_TYPE_cenc.equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        if (num != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4, "frma atom is mandatory");
        if (i8 != -1) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkArgument(z5, "schi atom is mandatory");
        TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i8, i9, str);
        if (parseSchiFromParent != null) {
            z6 = true;
        }
        Assertions.checkArgument(z6, "tenc atom is mandatory");
        return Pair.create(num, parseSchiFromParent);
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        long j5;
        long j6;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) == null) {
            return Pair.create((Object) null, (Object) null);
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        int i5 = 0;
        while (i5 < readUnsignedIntToInt) {
            if (parseFullAtomVersion == 1) {
                j5 = parsableByteArray.readUnsignedLongToLong();
            } else {
                j5 = parsableByteArray.readUnsignedInt();
            }
            jArr[i5] = j5;
            if (parseFullAtomVersion == 1) {
                j6 = parsableByteArray.readLong();
            } else {
                j6 = (long) parsableByteArray.readInt();
            }
            jArr2[i5] = j6;
            if (parsableByteArray.readShort() == 1) {
                parsableByteArray.skipBytes(2);
                i5++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i5) {
        parsableByteArray.setPosition(i5 + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, (Object) null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i5 = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i5 = (i5 << 7) | (readUnsignedByte & 127);
        }
        return i5;
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        int readInt = parsableByteArray.readInt();
        if (readInt == TYPE_soun) {
            return 1;
        }
        if (readInt == TYPE_vide) {
            return 2;
        }
        if (readInt == TYPE_text || readInt == TYPE_sbtl || readInt == TYPE_subt || readInt == TYPE_clcp) {
            return 3;
        }
        if (readInt == TYPE_meta) {
            return 4;
        }
        return -1;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i5) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i5) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        int i5;
        int i6 = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (parseFullAtomVersion == 0) {
            i5 = 8;
        } else {
            i5 = 16;
        }
        parsableByteArray.skipBytes(i5);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            i6 = 4;
        }
        parsableByteArray.skipBytes(i6);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static Metadata parseMetaAtom(ParsableByteArray parsableByteArray, int i5) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i5) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.skipBytes(readInt - 8);
        }
        return null;
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int i5 = 8;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
            i5 = 16;
        }
        parsableByteArray.skipBytes(i5);
        return parsableByteArray.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i5) {
        parsableByteArray.setPosition(i5 + 8);
        return ((float) parsableByteArray.readUnsignedIntToInt()) / ((float) parsableByteArray.readUnsignedIntToInt());
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i5, int i6) {
        int i7 = i5 + 8;
        while (i7 - i5 < i6) {
            parsableByteArray.setPosition(i7);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i7, readInt + i7);
            }
            i7 += readInt;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i5, int i6) {
        boolean z4;
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i5 < i6) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            if (readInt > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i5, int i6, String str) {
        int i7;
        int i8;
        boolean z4;
        int i9 = i5 + 8;
        while (true) {
            byte[] bArr = null;
            if (i9 - i5 >= i6) {
                return null;
            }
            parsableByteArray.setPosition(i9);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i8 = 0;
                    i7 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i7 = readUnsignedByte & 15;
                    i8 = (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                }
                if (parsableByteArray.readUnsignedByte() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z4 && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z4, str, readUnsignedByte2, bArr2, i8, i7, bArr);
            }
            String str2 = str;
            i9 += readInt;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v71, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v72, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v73, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v74, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0233  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable parseStbl(com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Track r42, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.ContainerAtom r43, com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder r44) throws com.mbridge.msdk.playercommon.exoplayer2.ParserException {
        /*
            r0 = r43
            int r2 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stsz
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r2 = r0.getLeafAtomOfType(r2)
            if (r2 == 0) goto L_0x0010
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox r3 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox
            r3.<init>(r2)
            goto L_0x001d
        L_0x0010:
            int r2 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stz2
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r2 = r0.getLeafAtomOfType(r2)
            if (r2 == 0) goto L_0x046c
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox r3 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox
            r3.<init>(r2)
        L_0x001d:
            int r2 = r3.getSampleCount()
            r4 = 0
            if (r2 != 0) goto L_0x003a
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            long[] r2 = new long[r4]
            int[] r3 = new int[r4]
            long[] r5 = new long[r4]
            int[] r6 = new int[r4]
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = 0
            r1 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x003a:
            r5 = r42
            int r6 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stco
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            r7 = 1
            if (r6 != 0) goto L_0x004d
            int r6 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_co64
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            r8 = r7
            goto L_0x004e
        L_0x004d:
            r8 = r4
        L_0x004e:
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r6 = r6.data
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stsc
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r9 = r0.getLeafAtomOfType(r9)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r9 = r9.data
            int r10 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stts
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = r0.getLeafAtomOfType(r10)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r10 = r10.data
            int r11 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stss
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = r0.getLeafAtomOfType(r11)
            r12 = 0
            if (r11 == 0) goto L_0x006c
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r11 = r11.data
            goto L_0x006d
        L_0x006c:
            r11 = r12
        L_0x006d:
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ctts
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r0 = r0.getLeafAtomOfType(r13)
            if (r0 == 0) goto L_0x0078
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r0 = r0.data
            goto L_0x0079
        L_0x0078:
            r0 = r12
        L_0x0079:
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator r13 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.setPosition(r6)
            int r8 = r10.readUnsignedIntToInt()
            int r8 = r8 - r7
            int r9 = r10.readUnsignedIntToInt()
            int r14 = r10.readUnsignedIntToInt()
            if (r0 == 0) goto L_0x009a
            r0.setPosition(r6)
            int r15 = r0.readUnsignedIntToInt()
            goto L_0x009b
        L_0x009a:
            r15 = r4
        L_0x009b:
            r16 = -1
            if (r11 == 0) goto L_0x00b0
            r11.setPosition(r6)
            int r6 = r11.readUnsignedIntToInt()
            if (r6 <= 0) goto L_0x00b2
            int r12 = r11.readUnsignedIntToInt()
            int r16 = r12 + -1
        L_0x00ae:
            r12 = r11
            goto L_0x00b2
        L_0x00b0:
            r6 = r4
            goto L_0x00ae
        L_0x00b2:
            boolean r11 = r3.isFixedSampleSize()
            if (r11 == 0) goto L_0x00ce
            com.mbridge.msdk.playercommon.exoplayer2.Format r11 = r5.format
            java.lang.String r11 = r11.sampleMimeType
            r17 = r4
            java.lang.String r4 = "audio/raw"
            boolean r4 = r4.equals(r11)
            if (r4 == 0) goto L_0x00d0
            if (r8 != 0) goto L_0x00d0
            if (r15 != 0) goto L_0x00d0
            if (r6 != 0) goto L_0x00d0
            r4 = r7
            goto L_0x00d2
        L_0x00ce:
            r17 = r4
        L_0x00d0:
            r4 = r17
        L_0x00d2:
            java.lang.String r11 = "AtomParsers"
            r18 = 0
            if (r4 != 0) goto L_0x01e1
            long[] r4 = new long[r2]
            r20 = r7
            int[] r7 = new int[r2]
            r43 = r0
            long[] r0 = new long[r2]
            r21 = r0
            int[] r0 = new int[r2]
            r22 = r16
            r16 = r0
            r0 = r22
            r22 = r3
            r23 = r4
            r25 = r7
            r26 = r10
            r3 = r17
            r4 = r3
            r7 = r4
            r10 = r7
            r24 = r10
            r27 = r18
            r29 = r27
        L_0x00ff:
            if (r3 >= r2) goto L_0x0172
        L_0x0101:
            if (r7 != 0) goto L_0x0115
            boolean r7 = r13.moveNext()
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r7)
            r31 = r2
            long r1 = r13.offset
            int r7 = r13.numSamples
            r29 = r1
            r2 = r31
            goto L_0x0101
        L_0x0115:
            r31 = r2
            if (r43 == 0) goto L_0x012a
        L_0x0119:
            if (r24 != 0) goto L_0x0128
            if (r15 <= 0) goto L_0x0128
            int r24 = r43.readUnsignedIntToInt()
            int r4 = r43.readInt()
            int r15 = r15 + -1
            goto L_0x0119
        L_0x0128:
            int r24 = r24 + -1
        L_0x012a:
            r23[r3] = r29
            int r1 = r22.readNextSampleSize()
            r25[r3] = r1
            if (r1 <= r10) goto L_0x0135
            r10 = r1
        L_0x0135:
            long r1 = (long) r4
            long r1 = r27 + r1
            r21[r3] = r1
            if (r12 != 0) goto L_0x013f
            r1 = r20
            goto L_0x0141
        L_0x013f:
            r1 = r17
        L_0x0141:
            r16[r3] = r1
            if (r3 != r0) goto L_0x0151
            r16[r3] = r20
            int r6 = r6 + -1
            if (r6 <= 0) goto L_0x0151
            int r0 = r12.readUnsignedIntToInt()
            int r0 = r0 + -1
        L_0x0151:
            long r1 = (long) r14
            long r27 = r27 + r1
            int r9 = r9 + -1
            if (r9 != 0) goto L_0x0166
            if (r8 <= 0) goto L_0x0166
            int r1 = r26.readUnsignedIntToInt()
            int r2 = r26.readInt()
            int r8 = r8 + -1
            r9 = r1
            r14 = r2
        L_0x0166:
            r1 = r25[r3]
            long r1 = (long) r1
            long r29 = r29 + r1
            int r7 = r7 + -1
            int r3 = r3 + 1
            r2 = r31
            goto L_0x00ff
        L_0x0172:
            r31 = r2
            long r0 = (long) r4
            long r27 = r27 + r0
            if (r24 != 0) goto L_0x017c
            r0 = r20
            goto L_0x017e
        L_0x017c:
            r0 = r17
        L_0x017e:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkArgument(r0)
        L_0x0181:
            if (r15 <= 0) goto L_0x0197
            int r0 = r43.readUnsignedIntToInt()
            if (r0 != 0) goto L_0x018c
            r0 = r20
            goto L_0x018e
        L_0x018c:
            r0 = r17
        L_0x018e:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkArgument(r0)
            r43.readInt()
            int r15 = r15 + -1
            goto L_0x0181
        L_0x0197:
            if (r6 != 0) goto L_0x019f
            if (r9 != 0) goto L_0x019f
            if (r7 != 0) goto L_0x019f
            if (r8 == 0) goto L_0x01d5
        L_0x019f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Inconsistent stbl box for track "
            r0.append(r1)
            int r1 = r5.id
            r0.append(r1)
            java.lang.String r1 = ": remainingSynchronizationSamples "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = ", remainingSamplesAtTimestampDelta "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = ", remainingSamplesInChunk "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r11, r0)
        L_0x01d5:
            r6 = r16
            r0 = r21
            r2 = r23
            r3 = r25
            r21 = r27
        L_0x01df:
            r4 = r10
            goto L_0x021e
        L_0x01e1:
            r31 = r2
            r20 = r7
            int r0 = r13.length
            long[] r1 = new long[r0]
            int[] r0 = new int[r0]
        L_0x01eb:
            boolean r2 = r13.moveNext()
            if (r2 == 0) goto L_0x01fc
            int r2 = r13.index
            long r3 = r13.offset
            r1[r2] = r3
            int r3 = r13.numSamples
            r0[r2] = r3
            goto L_0x01eb
        L_0x01fc:
            com.mbridge.msdk.playercommon.exoplayer2.Format r2 = r5.format
            int r3 = r2.pcmEncoding
            int r2 = r2.channelCount
            int r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.getPcmFrameSize(r3, r2)
            long r3 = (long) r14
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$Results r0 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.rechunk(r2, r1, r0, r3)
            long[] r4 = r0.offsets
            int[] r7 = r0.sizes
            int r10 = r0.maximumSize
            long[] r1 = r0.timestamps
            int[] r2 = r0.flags
            long r8 = r0.duration
            r0 = r1
            r6 = r2
            r2 = r4
            r3 = r7
            r21 = r8
            goto L_0x01df
        L_0x021e:
            r23 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r5.timescale
            r25 = r7
            long r7 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            long[] r1 = r5.editListDurations
            if (r1 == 0) goto L_0x0233
            boolean r1 = r44.hasGaplessInfo()
            if (r1 == 0) goto L_0x023d
        L_0x0233:
            r30 = r2
            r31 = r3
            r21 = r4
            r1 = r5
            r5 = r0
            goto L_0x0458
        L_0x023d:
            long[] r1 = r5.editListDurations
            int r12 = r1.length
            r13 = r20
            if (r12 != r13) goto L_0x02c7
            int r12 = r5.type
            if (r12 != r13) goto L_0x02c7
            int r12 = r0.length
            r13 = 2
            if (r12 < r13) goto L_0x02c7
            long[] r12 = r5.editListMediaTimes
            r24 = r12[r17]
            r32 = r1[r17]
            long r12 = r5.timescale
            long r14 = r5.movieTimescale
            r34 = r12
            r36 = r14
            long r12 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r32, r34, r36)
            long r26 = r24 + r12
            r22 = r21
            r21 = r0
            boolean r0 = canApplyEditWithGaplessInfo(r21, r22, r24, r26)
            r1 = r21
            r21 = r22
            if (r0 == 0) goto L_0x029b
            long r32 = r21 - r26
            r12 = r1[r17]
            long r34 = r24 - r12
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r5.format
            int r0 = r0.sampleRate
            long r12 = (long) r0
            long r14 = r5.timescale
            r36 = r12
            r38 = r14
            long r12 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r34, r36, r38)
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r5.format
            int r0 = r0.sampleRate
            long r14 = (long) r0
            long r9 = r5.timescale
            r36 = r9
            r34 = r14
            long r9 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r32, r34, r36)
            int r0 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x02a1
            int r0 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x029b
            goto L_0x02a1
        L_0x029b:
            r40 = r5
            r5 = r1
            r1 = r40
            goto L_0x02c9
        L_0x02a1:
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x029b
            int r0 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x029b
            int r0 = (int) r12
            r11 = r44
            r11.encoderDelay = r0
            int r0 = (int) r9
            r11.encoderPadding = r0
            long r9 = r5.timescale
            r11 = 1000000(0xf4240, double:4.940656E-318)
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r1, r11, r9)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r40 = r5
            r5 = r1
            r1 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x02c7:
            r1 = r5
            r5 = r0
        L_0x02c9:
            long[] r0 = r1.editListDurations
            int r7 = r0.length
            r13 = 1
            if (r7 != r13) goto L_0x0302
            r7 = r0[r17]
            int r0 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x0302
            long[] r0 = r1.editListMediaTimes
            r7 = r0[r17]
            r0 = r17
        L_0x02db:
            int r9 = r5.length
            if (r0 >= r9) goto L_0x02f1
            r9 = r5[r0]
            long r11 = r9 - r7
            r13 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r1.timescale
            r15 = r9
            long r9 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r11, r13, r15)
            r5[r0] = r9
            int r0 = r0 + 1
            goto L_0x02db
        L_0x02f1:
            long r9 = r21 - r7
            r11 = 1000000(0xf4240, double:4.940656E-318)
            long r13 = r1.timescale
            long r7 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r9, r11, r13)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x0302:
            int r0 = r1.type
            r13 = 1
            if (r0 != r13) goto L_0x0309
            r13 = 1
            goto L_0x030b
        L_0x0309:
            r13 = r17
        L_0x030b:
            r0 = r17
            r7 = r0
            r8 = r7
            r9 = r8
        L_0x0310:
            long[] r10 = r1.editListDurations
            int r12 = r10.length
            if (r0 >= r12) goto L_0x0356
            long[] r12 = r1.editListMediaTimes
            r43 = -1
            r14 = r12[r0]
            int r12 = (r14 > r43 ? 1 : (r14 == r43 ? 0 : -1))
            if (r12 == 0) goto L_0x0349
            r21 = r10[r0]
            r12 = r11
            long r10 = r1.timescale
            r23 = r10
            long r10 = r1.movieTimescale
            r25 = r10
            long r10 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            r16 = r0
            r21 = r4
            r0 = 1
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r5, (long) r14, (boolean) r0, (boolean) r0)
            long r14 = r14 + r10
            r0 = r17
            int r10 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r5, (long) r14, (boolean) r13, (boolean) r0)
            int r0 = r10 - r4
            int r8 = r8 + r0
            if (r9 == r4) goto L_0x0345
            r0 = 1
            goto L_0x0346
        L_0x0345:
            r0 = 0
        L_0x0346:
            r7 = r7 | r0
            r9 = r10
            goto L_0x034e
        L_0x0349:
            r16 = r0
            r21 = r4
            r12 = r11
        L_0x034e:
            int r0 = r16 + 1
            r11 = r12
            r4 = r21
            r17 = 0
            goto L_0x0310
        L_0x0356:
            r21 = r4
            r12 = r11
            r0 = r31
            r43 = -1
            if (r8 == r0) goto L_0x0361
            r0 = 1
            goto L_0x0362
        L_0x0361:
            r0 = 0
        L_0x0362:
            r0 = r0 | r7
            if (r0 == 0) goto L_0x0368
            long[] r4 = new long[r8]
            goto L_0x0369
        L_0x0368:
            r4 = r2
        L_0x0369:
            if (r0 == 0) goto L_0x036e
            int[] r7 = new int[r8]
            goto L_0x036f
        L_0x036e:
            r7 = r3
        L_0x036f:
            if (r0 == 0) goto L_0x0373
            r21 = 0
        L_0x0373:
            if (r0 == 0) goto L_0x0378
            int[] r9 = new int[r8]
            goto L_0x0379
        L_0x0378:
            r9 = r6
        L_0x0379:
            long[] r8 = new long[r8]
            r14 = r21
            r10 = 0
            r11 = 0
            r21 = r18
        L_0x0381:
            long[] r15 = r1.editListDurations
            r16 = r0
            int r0 = r15.length
            if (r10 >= r0) goto L_0x0437
            long[] r0 = r1.editListMediaTimes
            r18 = r14
            r19 = r15
            r14 = r0[r10]
            r23 = r19[r10]
            int r0 = (r14 > r43 ? 1 : (r14 == r43 ? 0 : -1))
            r19 = r8
            if (r0 == 0) goto L_0x041e
            r0 = r9
            long r8 = r1.timescale
            r25 = r8
            long r8 = r1.movieTimescale
            r27 = r8
            long r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r23, r25, r27)
            r27 = r23
            long r8 = r8 + r14
            r23 = r0
            r20 = r10
            r0 = 1
            int r10 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r5, (long) r14, (boolean) r0, (boolean) r0)
            r29 = r0
            r0 = 0
            int r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r5, (long) r8, (boolean) r13, (boolean) r0)
            if (r16 == 0) goto L_0x03c8
            int r9 = r8 - r10
            java.lang.System.arraycopy(r2, r10, r4, r11, r9)
            java.lang.System.arraycopy(r3, r10, r7, r11, r9)
            r0 = r23
            java.lang.System.arraycopy(r6, r10, r0, r11, r9)
            goto L_0x03ca
        L_0x03c8:
            r0 = r23
        L_0x03ca:
            if (r10 >= r8) goto L_0x03de
            r9 = r0[r11]
            r9 = r9 & 1
            if (r9 == 0) goto L_0x03d3
            goto L_0x03de
        L_0x03d3:
            java.lang.String r0 = "Ignoring edit list: edit does not start with a sync sample."
            android.util.Log.w(r12, r0)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$UnhandledEditListException r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$UnhandledEditListException
            r0.<init>()
            throw r0
        L_0x03de:
            r9 = r18
        L_0x03e0:
            if (r10 >= r8) goto L_0x0418
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r30 = r2
            r31 = r3
            long r2 = r1.movieTimescale
            r25 = r2
            long r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            r23 = r5[r10]
            long r32 = r23 - r14
            r34 = 1000000(0xf4240, double:4.940656E-318)
            r23 = r2
            long r2 = r1.timescale
            r36 = r2
            long r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r32, r34, r36)
            long r2 = r23 + r2
            r19[r11] = r2
            if (r16 == 0) goto L_0x040f
            r2 = r7[r11]
            if (r2 <= r9) goto L_0x040f
            r2 = r31[r10]
            r9 = r2
        L_0x040f:
            int r11 = r11 + 1
            int r10 = r10 + 1
            r2 = r30
            r3 = r31
            goto L_0x03e0
        L_0x0418:
            r14 = r9
        L_0x0419:
            r30 = r2
            r31 = r3
            goto L_0x0428
        L_0x041e:
            r0 = r9
            r20 = r10
            r27 = r23
            r29 = 1
            r14 = r18
            goto L_0x0419
        L_0x0428:
            long r21 = r21 + r27
            int r10 = r20 + 1
            r9 = r0
            r0 = r16
            r8 = r19
            r2 = r30
            r3 = r31
            goto L_0x0381
        L_0x0437:
            r19 = r8
            r0 = r9
            r18 = r14
            r23 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r1.timescale
            r25 = r2
            long r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            r6 = r0
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r40 = r2
            r3 = r7
            r7 = r40
            r2 = r4
            r4 = r18
            r5 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x0458:
            long r2 = r1.timescale
            r11 = 1000000(0xf4240, double:4.940656E-318)
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r5, r11, r2)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r4 = r21
            r2 = r30
            r3 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x046c:
            com.mbridge.msdk.playercommon.exoplayer2.ParserException r0 = new com.mbridge.msdk.playercommon.exoplayer2.ParserException
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.parseStbl(com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Track, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$ContainerAtom, com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder):com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable");
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i5, int i6, String str, DrmInitData drmInitData, boolean z4) throws ParserException {
        boolean z5;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        int i7 = 0;
        while (i7 < readInt) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Assertions.checkArgument(z5, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == Atom.TYPE_avc1 || readInt3 == Atom.TYPE_avc3 || readInt3 == Atom.TYPE_encv || readInt3 == Atom.TYPE_mp4v || readInt3 == Atom.TYPE_hvc1 || readInt3 == Atom.TYPE_hev1 || readInt3 == Atom.TYPE_s263 || readInt3 == Atom.TYPE_vp08 || readInt3 == Atom.TYPE_vp09) {
                StsdData stsdData2 = stsdData;
                int i8 = i7;
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i5, i6, drmInitData, stsdData2, i8);
                stsdData = stsdData2;
                i7 = i8;
            } else if (readInt3 == Atom.TYPE_mp4a || readInt3 == Atom.TYPE_enca || readInt3 == Atom.TYPE_ac_3 || readInt3 == Atom.TYPE_ec_3 || readInt3 == Atom.TYPE_dtsc || readInt3 == Atom.TYPE_dtse || readInt3 == Atom.TYPE_dtsh || readInt3 == Atom.TYPE_dtsl || readInt3 == Atom.TYPE_samr || readInt3 == Atom.TYPE_sawb || readInt3 == Atom.TYPE_lpcm || readInt3 == Atom.TYPE_sowt || readInt3 == Atom.TYPE__mp3 || readInt3 == Atom.TYPE_alac) {
                StsdData stsdData3 = stsdData;
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i5, str, z4, drmInitData, stsdData3, i7);
                stsdData = stsdData3;
            } else if (readInt3 == Atom.TYPE_TTML || readInt3 == Atom.TYPE_tx3g || readInt3 == Atom.TYPE_wvtt || readInt3 == Atom.TYPE_stpp || readInt3 == Atom.TYPE_c608) {
                parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i5, str, stsdData);
            } else if (readInt3 == Atom.TYPE_camm) {
                stsdData.format = Format.createSampleFormat(Integer.toString(i5), MimeTypes.APPLICATION_CAMERA_MOTION, (String) null, -1, (DrmInitData) null);
            }
            parsableByteArray.setPosition(position + readInt2);
            i7++;
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i5, int i6, int i7, int i8, String str, StsdData stsdData) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i9 = i5;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i6 + 16);
        int i10 = Atom.TYPE_TTML;
        String str2 = MimeTypes.APPLICATION_TTML;
        List list = null;
        long j5 = Long.MAX_VALUE;
        if (i9 != i10) {
            if (i9 == Atom.TYPE_tx3g) {
                int i11 = i7 - 16;
                byte[] bArr = new byte[i11];
                parsableByteArray2.readBytes(bArr, 0, i11);
                list = Collections.singletonList(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i9 == Atom.TYPE_wvtt) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i9 == Atom.TYPE_stpp) {
                j5 = 0;
            } else if (i9 == Atom.TYPE_c608) {
                stsdData2.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData2.format = Format.createTextSampleFormat(Integer.toString(i8), str2, (String) null, -1, 0, str, -1, (DrmInitData) null, j5, list);
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        int i5;
        long j5;
        long j6;
        int i6 = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (parseFullAtomVersion == 0) {
            i5 = 8;
        } else {
            i5 = 16;
        }
        parsableByteArray.skipBytes(i5);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        if (parseFullAtomVersion == 0) {
            i6 = 4;
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            j5 = C.TIME_UNSET;
            if (i8 >= i6) {
                parsableByteArray.skipBytes(i6);
                break;
            } else if (parsableByteArray.data[position + i8] != -1) {
                if (parseFullAtomVersion == 0) {
                    j6 = parsableByteArray.readUnsignedInt();
                } else {
                    j6 = parsableByteArray.readUnsignedLongToLong();
                }
                if (j6 != 0) {
                    j5 = j6;
                }
            } else {
                i8++;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i7 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i7 = SubsamplingScaleImageView.ORIENTATION_270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i7 = SubsamplingScaleImageView.ORIENTATION_180;
        }
        return new TkhdData(readInt, j5, i7);
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j5, DrmInitData drmInitData, boolean z4, boolean z5) throws ParserException {
        long j6;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtomOfType = containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia);
        int parseHdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (parseHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(containerAtom2.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        long j7 = C.TIME_UNSET;
        if (j5 == C.TIME_UNSET) {
            j6 = parseTkhd.duration;
        } else {
            j6 = j5;
        }
        long parseMvhd = parseMvhd(leafAtom.data);
        if (j6 != C.TIME_UNSET) {
            j7 = Util.scaleLargeTimestamp(j6, 1000000, parseMvhd);
        }
        long j8 = j7;
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z5);
        if (!z4) {
            Pair<long[], long[]> parseEdts = parseEdts(containerAtom2.getContainerAtomOfType(Atom.TYPE_edts));
            jArr = (long[]) parseEdts.second;
            jArr2 = (long[]) parseEdts.first;
        } else {
            jArr2 = null;
            jArr = null;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.id, parseHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j8, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr2, jArr);
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z4) {
        if (z4) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                parsableByteArray.setPosition(position);
                return parseMetaAtom(parsableByteArray, position + readInt);
            }
            parsableByteArray.skipBytes(readInt - 8);
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r13v9 */
    /* JADX WARNING: type inference failed for: r13v11 */
    /* JADX WARNING: type inference failed for: r13v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseVideoSampleEntry(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r21, int r22, int r23, int r24, int r25, int r26, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r27, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.StsdData r28, int r29) throws com.mbridge.msdk.playercommon.exoplayer2.ParserException {
        /*
            r0 = r21
            r1 = r23
            r2 = r24
            r3 = r27
            r4 = r28
            int r5 = r1 + 16
            r0.setPosition(r5)
            r5 = 16
            r0.skipBytes(r5)
            int r11 = r0.readUnsignedShort()
            int r12 = r0.readUnsignedShort()
            r5 = 50
            r0.skipBytes(r5)
            int r5 = r0.getPosition()
            int r6 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_encv
            r7 = 0
            r8 = r22
            if (r8 != r6) goto L_0x0053
            android.util.Pair r6 = parseSampleEntryEncryptionData(r0, r1, r2)
            if (r6 == 0) goto L_0x0050
            java.lang.Object r8 = r6.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r3 != 0) goto L_0x003e
            r3 = r7
            goto L_0x0048
        L_0x003e:
            java.lang.Object r9 = r6.second
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox r9 = (com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox) r9
            java.lang.String r9 = r9.schemeType
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r3 = r3.copyWithSchemeType(r9)
        L_0x0048:
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox[] r9 = r4.trackEncryptionBoxes
            java.lang.Object r6 = r6.second
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox r6 = (com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox) r6
            r9[r29] = r6
        L_0x0050:
            r0.setPosition(r5)
        L_0x0053:
            r20 = r3
            r6 = 1065353216(0x3f800000, float:1.0)
            r9 = -1
            r16 = r6
            r14 = r7
            r17 = r14
            r18 = r9
            r6 = 0
        L_0x0060:
            int r9 = r5 - r1
            if (r9 >= r2) goto L_0x0148
            r0.setPosition(r5)
            int r9 = r0.getPosition()
            int r10 = r0.readInt()
            if (r10 != 0) goto L_0x007a
            int r13 = r0.getPosition()
            int r13 = r13 - r1
            if (r13 != r2) goto L_0x007a
            goto L_0x0148
        L_0x007a:
            r13 = 1
            if (r10 <= 0) goto L_0x007f
            r15 = r13
            goto L_0x0080
        L_0x007f:
            r15 = 0
        L_0x0080:
            java.lang.String r3 = "childAtomSize should be positive"
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkArgument(r15, r3)
            int r3 = r0.readInt()
            int r15 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_avcC
            if (r3 != r15) goto L_0x00af
            if (r7 != 0) goto L_0x0090
            goto L_0x0091
        L_0x0090:
            r13 = 0
        L_0x0091:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r13)
            int r9 = r9 + 8
            r0.setPosition(r9)
            com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig r3 = com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig.parse(r0)
            java.util.List<byte[]> r7 = r3.initializationData
            int r9 = r3.nalUnitLengthFieldLength
            r4.nalUnitLengthFieldLength = r9
            if (r6 != 0) goto L_0x00a9
            float r3 = r3.pixelWidthAspectRatio
            r16 = r3
        L_0x00a9:
            java.lang.String r3 = "video/avc"
        L_0x00ab:
            r14 = r7
        L_0x00ac:
            r7 = r3
            goto L_0x0145
        L_0x00af:
            int r15 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_hvcC
            if (r3 != r15) goto L_0x00cc
            if (r7 != 0) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            r13 = 0
        L_0x00b7:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r13)
            int r9 = r9 + 8
            r0.setPosition(r9)
            com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig r3 = com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig.parse(r0)
            java.util.List<byte[]> r7 = r3.initializationData
            int r3 = r3.nalUnitLengthFieldLength
            r4.nalUnitLengthFieldLength = r3
            java.lang.String r3 = "video/hevc"
            goto L_0x00ab
        L_0x00cc:
            int r15 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_vpcC
            if (r3 != r15) goto L_0x00e1
            if (r7 != 0) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            r13 = 0
        L_0x00d4:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r13)
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_vp08
            if (r8 != r3) goto L_0x00de
            java.lang.String r3 = "video/x-vnd.on2.vp8"
            goto L_0x00ac
        L_0x00de:
            java.lang.String r3 = "video/x-vnd.on2.vp9"
            goto L_0x00ac
        L_0x00e1:
            int r15 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_d263
            if (r3 != r15) goto L_0x00ef
            if (r7 != 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r13 = 0
        L_0x00e9:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r13)
            java.lang.String r3 = "video/3gpp"
            goto L_0x00ac
        L_0x00ef:
            int r15 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_esds
            if (r3 != r15) goto L_0x010a
            if (r7 != 0) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r13 = 0
        L_0x00f7:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r13)
            android.util.Pair r3 = parseEsdsFromParent(r0, r9)
            java.lang.Object r7 = r3.first
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r3 = r3.second
            java.util.List r3 = java.util.Collections.singletonList(r3)
            r14 = r3
            goto L_0x0145
        L_0x010a:
            int r15 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_pasp
            if (r3 != r15) goto L_0x0116
            float r3 = parsePaspFromParent(r0, r9)
            r16 = r3
            r6 = r13
            goto L_0x0145
        L_0x0116:
            int r15 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_sv3d
            if (r3 != r15) goto L_0x0121
            byte[] r3 = parseProjFromParent(r0, r9, r10)
            r17 = r3
            goto L_0x0145
        L_0x0121:
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_st3d
            if (r3 != r9) goto L_0x0145
            int r3 = r0.readUnsignedByte()
            r9 = 3
            r0.skipBytes(r9)
            if (r3 != 0) goto L_0x0145
            int r3 = r0.readUnsignedByte()
            if (r3 == 0) goto L_0x0143
            if (r3 == r13) goto L_0x0140
            r13 = 2
            if (r3 == r13) goto L_0x0140
            if (r3 == r9) goto L_0x013d
            goto L_0x0145
        L_0x013d:
            r18 = r9
            goto L_0x0145
        L_0x0140:
            r18 = r13
            goto L_0x0145
        L_0x0143:
            r18 = 0
        L_0x0145:
            int r5 = r5 + r10
            goto L_0x0060
        L_0x0148:
            if (r7 != 0) goto L_0x014b
            return
        L_0x014b:
            java.lang.String r6 = java.lang.Integer.toString(r25)
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r19 = 0
            r8 = 0
            r9 = -1
            r10 = -1
            r15 = r26
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = com.mbridge.msdk.playercommon.exoplayer2.Format.createVideoSampleFormat(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r4.format = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.parseVideoSampleEntry(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray, int, int, int, int, int, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }
}
