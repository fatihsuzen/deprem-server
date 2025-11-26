package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;

public final class H262Reader implements ElementaryStreamReader {
    private static final double[] FRAME_RATE_VALUES = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private static final int START_EXTENSION = 181;
    private static final int START_GROUP = 184;
    private static final int START_PICTURE = 0;
    private static final int START_SEQUENCE_HEADER = 179;
    private final CsdBuffer csdBuffer = new CsdBuffer(128);
    private String formatId;
    private long frameDurationUs;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final boolean[] prefixFlags = new boolean[4];
    private boolean sampleHasPicture;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private boolean startedFirstSample;
    private long totalBytesWritten;

    private static final class CsdBuffer {
        private static final byte[] START_CODE = {0, 0, 1};
        public byte[] data;
        private boolean isFilling;
        public int length;
        public int sequenceExtensionPosition;

        public CsdBuffer(int i5) {
            this.data = new byte[i5];
        }

        public final void onData(byte[] bArr, int i5, int i6) {
            if (this.isFilling) {
                int i7 = i6 - i5;
                byte[] bArr2 = this.data;
                int length2 = bArr2.length;
                int i8 = this.length;
                if (length2 < i8 + i7) {
                    this.data = Arrays.copyOf(bArr2, (i8 + i7) * 2);
                }
                System.arraycopy(bArr, i5, this.data, this.length, i7);
                this.length += i7;
            }
        }

        public final boolean onStartCode(int i5, int i6) {
            if (this.isFilling) {
                int i7 = this.length - i6;
                this.length = i7;
                if (this.sequenceExtensionPosition == 0 && i5 == H262Reader.START_EXTENSION) {
                    this.sequenceExtensionPosition = i7;
                } else {
                    this.isFilling = false;
                    return true;
                }
            } else if (i5 == H262Reader.START_SEQUENCE_HEADER) {
                this.isFilling = true;
            }
            byte[] bArr = START_CODE;
            onData(bArr, 0, bArr.length);
            return false;
        }

        public final void reset() {
            this.isFilling = false;
            this.length = 0;
            this.sequenceExtensionPosition = 0;
        }
    }

    private static Pair<Format, Long> parseCsdBuffer(CsdBuffer csdBuffer2, String str) {
        float f5;
        int i5;
        float f6;
        long j5;
        CsdBuffer csdBuffer3 = csdBuffer2;
        byte[] copyOf = Arrays.copyOf(csdBuffer3.data, csdBuffer3.length);
        byte b5 = copyOf[5];
        int i6 = ((copyOf[4] & 255) << 4) | ((b5 & 255) >> 4);
        byte b6 = ((b5 & 15) << 8) | (copyOf[6] & 255);
        int i7 = (copyOf[7] & 240) >> 4;
        if (i7 != 2) {
            if (i7 == 3) {
                f5 = (float) (b6 * 16);
                i5 = i6 * 9;
            } else if (i7 != 4) {
                f6 = 1.0f;
            } else {
                f5 = (float) (b6 * 121);
                i5 = i6 * 100;
            }
            f6 = f5 / ((float) i5);
        } else {
            f5 = (float) (b6 * 4);
            i5 = i6 * 3;
            f6 = f5 / ((float) i5);
        }
        Format createVideoSampleFormat = Format.createVideoSampleFormat(str, MimeTypes.VIDEO_MPEG2, (String) null, -1, -1, i6, b6, -1.0f, Collections.singletonList(copyOf), -1, f6, (DrmInitData) null);
        int i8 = (copyOf[7] & 15) - 1;
        if (i8 >= 0) {
            double[] dArr = FRAME_RATE_VALUES;
            if (i8 < dArr.length) {
                double d5 = dArr[i8];
                byte b7 = copyOf[csdBuffer3.sequenceExtensionPosition + 9];
                int i9 = (b7 & 96) >> 5;
                byte b8 = b7 & 31;
                if (i9 != b8) {
                    d5 *= (((double) i9) + 1.0d) / ((double) (b8 + 1));
                }
                j5 = (long) (1000000.0d / d5);
                return Pair.create(createVideoSampleFormat, Long.valueOf(j5));
            }
        }
        j5 = 0;
        return Pair.create(createVideoSampleFormat, Long.valueOf(j5));
    }

    public final void consume(ParsableByteArray parsableByteArray) {
        boolean z4;
        int i5;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int position = parsableByteArray2.getPosition();
        int limit = parsableByteArray2.limit();
        byte[] bArr = parsableByteArray2.data;
        this.totalBytesWritten += (long) parsableByteArray2.bytesLeft();
        this.output.sampleData(parsableByteArray2, parsableByteArray2.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
            if (findNalUnit == limit) {
                break;
            }
            int i6 = findNalUnit + 3;
            byte b5 = parsableByteArray2.data[i6] & 255;
            boolean z5 = false;
            if (!this.hasOutputFormat) {
                int i7 = findNalUnit - position;
                if (i7 > 0) {
                    this.csdBuffer.onData(bArr, position, findNalUnit);
                }
                if (i7 < 0) {
                    i5 = -i7;
                } else {
                    i5 = 0;
                }
                if (this.csdBuffer.onStartCode(b5, i5)) {
                    Pair<Format, Long> parseCsdBuffer = parseCsdBuffer(this.csdBuffer, this.formatId);
                    this.output.format((Format) parseCsdBuffer.first);
                    this.frameDurationUs = ((Long) parseCsdBuffer.second).longValue();
                    this.hasOutputFormat = true;
                }
            }
            if (b5 == 0 || b5 == START_SEQUENCE_HEADER) {
                int i8 = limit - findNalUnit;
                if (this.startedFirstSample && this.sampleHasPicture && this.hasOutputFormat) {
                    this.output.sampleMetadata(this.sampleTimeUs, this.sampleIsKeyframe ? 1 : 0, ((int) (this.totalBytesWritten - this.samplePosition)) - i8, i8, (TrackOutput.CryptoData) null);
                }
                int i9 = i8;
                boolean z6 = this.startedFirstSample;
                if (!z6 || this.sampleHasPicture) {
                    this.samplePosition = this.totalBytesWritten - ((long) i9);
                    long j5 = this.pesTimeUs;
                    if (j5 == C.TIME_UNSET) {
                        if (z6) {
                            j5 = this.sampleTimeUs + this.frameDurationUs;
                        } else {
                            j5 = 0;
                        }
                    }
                    this.sampleTimeUs = j5;
                    this.sampleIsKeyframe = false;
                    this.pesTimeUs = C.TIME_UNSET;
                    z4 = true;
                    this.startedFirstSample = true;
                } else {
                    z4 = true;
                }
                if (b5 == 0) {
                    z5 = z4;
                }
                this.sampleHasPicture = z5;
            } else if (b5 == START_GROUP) {
                this.sampleIsKeyframe = true;
            }
            position = i6;
        }
        if (!this.hasOutputFormat) {
            this.csdBuffer.onData(bArr, position, limit);
        }
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
    }

    public final void packetFinished() {
    }

    public final void packetStarted(long j5, boolean z4) {
        this.pesTimeUs = j5;
    }

    public final void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        this.totalBytesWritten = 0;
        this.startedFirstSample = false;
    }
}
