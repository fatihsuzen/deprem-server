package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Collections;

public final class H265Reader implements ElementaryStreamReader {
    private static final int BLA_W_LP = 16;
    private static final int CRA_NUT = 21;
    private static final int PPS_NUT = 34;
    private static final int PREFIX_SEI_NUT = 39;
    private static final int RASL_R = 9;
    private static final int SPS_NUT = 33;
    private static final int SUFFIX_SEI_NUT = 40;
    private static final String TAG = "H265Reader";
    private static final int VPS_NUT = 32;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(34, 128);
    private final boolean[] prefixFlags = new boolean[3];
    private final NalUnitTargetBuffer prefixSei = new NalUnitTargetBuffer(39, 128);
    private SampleReader sampleReader;
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper = new ParsableByteArray();
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(33, 128);
    private final NalUnitTargetBuffer suffixSei = new NalUnitTargetBuffer(40, 128);
    private long totalBytesWritten;
    private final NalUnitTargetBuffer vps = new NalUnitTargetBuffer(32, 128);

    private static final class SampleReader {
        private static final int FIRST_SLICE_FLAG_OFFSET = 2;
        private boolean isFirstParameterSet;
        private boolean isFirstSlice;
        private boolean lookingForFirstSliceFlag;
        private int nalUnitBytesRead;
        private boolean nalUnitHasKeyframeData;
        private long nalUnitStartPosition;
        private long nalUnitTimeUs;
        private final TrackOutput output;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;
        private boolean writingParameterSets;

        public SampleReader(TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        private void outputSample(int i5) {
            boolean z4 = this.sampleIsKeyframe;
            int i6 = (int) (this.nalUnitStartPosition - this.samplePosition);
            this.output.sampleMetadata(this.sampleTimeUs, z4 ? 1 : 0, i6, i5, (TrackOutput.CryptoData) null);
        }

        public final void endNalUnit(long j5, int i5) {
            if (this.writingParameterSets && this.isFirstSlice) {
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                this.writingParameterSets = false;
            } else if (this.isFirstParameterSet || this.isFirstSlice) {
                if (this.readingSample) {
                    outputSample(i5 + ((int) (j5 - this.nalUnitStartPosition)));
                }
                this.samplePosition = this.nalUnitStartPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.readingSample = true;
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
            }
        }

        public final void readNalUnitData(byte[] bArr, int i5, int i6) {
            boolean z4;
            if (this.lookingForFirstSliceFlag) {
                int i7 = this.nalUnitBytesRead;
                int i8 = (i5 + 2) - i7;
                if (i8 < i6) {
                    if ((bArr[i8] & 128) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    this.isFirstSlice = z4;
                    this.lookingForFirstSliceFlag = false;
                    return;
                }
                this.nalUnitBytesRead = i7 + (i6 - i5);
            }
        }

        public final void reset() {
            this.lookingForFirstSliceFlag = false;
            this.isFirstSlice = false;
            this.isFirstParameterSet = false;
            this.readingSample = false;
            this.writingParameterSets = false;
        }

        public final void startNalUnit(long j5, int i5, int i6, long j6) {
            boolean z4;
            boolean z5 = false;
            this.isFirstSlice = false;
            this.isFirstParameterSet = false;
            this.nalUnitTimeUs = j6;
            this.nalUnitBytesRead = 0;
            this.nalUnitStartPosition = j5;
            if (i6 >= 32) {
                if (!this.writingParameterSets && this.readingSample) {
                    outputSample(i5);
                    this.readingSample = false;
                }
                if (i6 <= 34) {
                    this.isFirstParameterSet = !this.writingParameterSets;
                    this.writingParameterSets = true;
                }
            }
            if (i6 < 16 || i6 > 21) {
                z4 = false;
            } else {
                z4 = true;
            }
            this.nalUnitHasKeyframeData = z4;
            if (z4 || i6 <= 9) {
                z5 = true;
            }
            this.lookingForFirstSliceFlag = z5;
        }
    }

    public H265Reader(SeiReader seiReader2) {
        this.seiReader = seiReader2;
    }

    private void endNalUnit(long j5, int i5, int i6, long j6) {
        if (this.hasOutputFormat) {
            this.sampleReader.endNalUnit(j5, i5);
        } else {
            this.vps.endNalUnit(i6);
            this.sps.endNalUnit(i6);
            this.pps.endNalUnit(i6);
            if (this.vps.isCompleted() && this.sps.isCompleted() && this.pps.isCompleted()) {
                this.output.format(parseMediaFormat(this.formatId, this.vps, this.sps, this.pps));
                this.hasOutputFormat = true;
            }
        }
        if (this.prefixSei.endNalUnit(i6)) {
            NalUnitTargetBuffer nalUnitTargetBuffer = this.prefixSei;
            this.seiWrapper.reset(this.prefixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j6, this.seiWrapper);
        }
        if (this.suffixSei.endNalUnit(i6)) {
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.suffixSei;
            this.seiWrapper.reset(this.suffixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j6, this.seiWrapper);
        }
    }

    private void nalUnitData(byte[] bArr, int i5, int i6) {
        if (this.hasOutputFormat) {
            this.sampleReader.readNalUnitData(bArr, i5, i6);
        } else {
            this.vps.appendToNalUnit(bArr, i5, i6);
            this.sps.appendToNalUnit(bArr, i5, i6);
            this.pps.appendToNalUnit(bArr, i5, i6);
        }
        this.prefixSei.appendToNalUnit(bArr, i5, i6);
        this.suffixSei.appendToNalUnit(bArr, i5, i6);
    }

    private static Format parseMediaFormat(String str, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int i5;
        int i6;
        NalUnitTargetBuffer nalUnitTargetBuffer4 = nalUnitTargetBuffer;
        NalUnitTargetBuffer nalUnitTargetBuffer5 = nalUnitTargetBuffer2;
        NalUnitTargetBuffer nalUnitTargetBuffer6 = nalUnitTargetBuffer3;
        int i7 = nalUnitTargetBuffer4.nalLength;
        byte[] bArr = new byte[(nalUnitTargetBuffer5.nalLength + i7 + nalUnitTargetBuffer6.nalLength)];
        System.arraycopy(nalUnitTargetBuffer4.nalData, 0, bArr, 0, i7);
        System.arraycopy(nalUnitTargetBuffer5.nalData, 0, bArr, nalUnitTargetBuffer4.nalLength, nalUnitTargetBuffer5.nalLength);
        System.arraycopy(nalUnitTargetBuffer6.nalData, 0, bArr, nalUnitTargetBuffer4.nalLength + nalUnitTargetBuffer5.nalLength, nalUnitTargetBuffer6.nalLength);
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalUnitTargetBuffer5.nalData, 0, nalUnitTargetBuffer5.nalLength);
        parsableNalUnitBitArray.skipBits(44);
        int readBits = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBit();
        parsableNalUnitBitArray.skipBits(88);
        parsableNalUnitBitArray.skipBits(8);
        int i8 = 0;
        for (int i9 = 0; i9 < readBits; i9++) {
            if (parsableNalUnitBitArray.readBit()) {
                i8 += 89;
            }
            if (parsableNalUnitBitArray.readBit()) {
                i8 += 8;
            }
        }
        parsableNalUnitBitArray.skipBits(i8);
        if (readBits > 0) {
            parsableNalUnitBitArray.skipBits((8 - readBits) * 2);
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt == 3) {
            parsableNalUnitBitArray.skipBit();
        }
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int i10 = 1;
            if (readUnsignedExpGolombCodedInt == 1 || readUnsignedExpGolombCodedInt == 2) {
                i6 = 2;
            } else {
                i6 = 1;
            }
            if (readUnsignedExpGolombCodedInt == 1) {
                i10 = 2;
            }
            readUnsignedExpGolombCodedInt2 -= i6 * (readUnsignedExpGolombCodedInt4 + readUnsignedExpGolombCodedInt5);
            readUnsignedExpGolombCodedInt3 -= i10 * (readUnsignedExpGolombCodedInt6 + readUnsignedExpGolombCodedInt7);
        }
        int i11 = readUnsignedExpGolombCodedInt2;
        int i12 = readUnsignedExpGolombCodedInt3;
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            i5 = 0;
        } else {
            i5 = readBits;
        }
        while (i5 <= readBits) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            i5++;
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            skipScalingList(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.skipBits(2);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(8);
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        skipShortTermRefPicSets(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.readBit()) {
            for (int i13 = 0; i13 < parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(); i13++) {
                parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt8 + 5);
            }
        }
        parsableNalUnitBitArray.skipBits(2);
        float f5 = 1.0f;
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            int readBits2 = parsableNalUnitBitArray.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = parsableNalUnitBitArray.readBits(16);
                int readBits4 = parsableNalUnitBitArray.readBits(16);
                if (!(readBits3 == 0 || readBits4 == 0)) {
                    f5 = ((float) readBits3) / ((float) readBits4);
                }
            } else {
                float[] fArr = NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
                if (readBits2 < fArr.length) {
                    f5 = fArr[readBits2];
                } else {
                    Log.w(TAG, "Unexpected aspect_ratio_idc value: " + readBits2);
                }
            }
        }
        return Format.createVideoSampleFormat(str, MimeTypes.VIDEO_H265, (String) null, -1, -1, i11, i12, -1.0f, Collections.singletonList(bArr), -1, f5, (DrmInitData) null);
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i5 = 0; i5 < 4; i5++) {
            int i6 = 0;
            while (i6 < 6) {
                int i7 = 1;
                if (!parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                } else {
                    int min = Math.min(64, 1 << ((i5 << 1) + 4));
                    if (i5 > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i8 = 0; i8 < min; i8++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                }
                if (i5 == 3) {
                    i7 = 3;
                }
                i6 += i7;
            }
        }
    }

    private static void skipShortTermRefPicSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        boolean z4 = false;
        int i5 = 0;
        for (int i6 = 0; i6 < readUnsignedExpGolombCodedInt; i6++) {
            if (i6 != 0) {
                z4 = parsableNalUnitBitArray.readBit();
            }
            if (z4) {
                parsableNalUnitBitArray.skipBit();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                for (int i7 = 0; i7 <= i5; i7++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBit();
                    }
                }
            } else {
                int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int i8 = readUnsignedExpGolombCodedInt2 + readUnsignedExpGolombCodedInt3;
                for (int i9 = 0; i9 < readUnsignedExpGolombCodedInt2; i9++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                for (int i10 = 0; i10 < readUnsignedExpGolombCodedInt3; i10++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                i5 = i8;
            }
        }
    }

    private void startNalUnit(long j5, int i5, int i6, long j6) {
        int i7;
        if (this.hasOutputFormat) {
            i7 = i6;
            this.sampleReader.startNalUnit(j5, i5, i7, j6);
        } else {
            i7 = i6;
            this.vps.startNalUnit(i7);
            this.sps.startNalUnit(i7);
            this.pps.startNalUnit(i7);
        }
        this.prefixSei.startNalUnit(i7);
        this.suffixSei.startNalUnit(i7);
    }

    public final void consume(ParsableByteArray parsableByteArray) {
        int i5;
        while (parsableByteArray.bytesLeft() > 0) {
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            byte[] bArr = parsableByteArray.data;
            this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
            while (true) {
                if (position < limit) {
                    int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
                    if (findNalUnit == limit) {
                        nalUnitData(bArr, position, limit);
                        return;
                    }
                    int h265NalUnitType = NalUnitUtil.getH265NalUnitType(bArr, findNalUnit);
                    int i6 = findNalUnit - position;
                    if (i6 > 0) {
                        nalUnitData(bArr, position, findNalUnit);
                    }
                    int i7 = limit - findNalUnit;
                    long j5 = this.totalBytesWritten - ((long) i7);
                    if (i6 < 0) {
                        i5 = -i6;
                    } else {
                        i5 = 0;
                    }
                    long j6 = j5;
                    int i8 = i5;
                    long j7 = j6;
                    endNalUnit(j7, i7, i8, this.pesTimeUs);
                    startNalUnit(j7, i7, h265NalUnitType, this.pesTimeUs);
                    position = findNalUnit + 3;
                }
            }
        }
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.output = track;
        this.sampleReader = new SampleReader(track);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    public final void packetFinished() {
    }

    public final void packetStarted(long j5, boolean z4) {
        this.pesTimeUs = j5;
    }

    public final void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.vps.reset();
        this.sps.reset();
        this.pps.reset();
        this.prefixSei.reset();
        this.suffixSei.reset();
        this.sampleReader.reset();
        this.totalBytesWritten = 0;
    }
}
