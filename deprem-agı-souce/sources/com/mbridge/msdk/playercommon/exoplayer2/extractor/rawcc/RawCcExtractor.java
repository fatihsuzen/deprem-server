package com.mbridge.msdk.playercommon.exoplayer2.extractor.rawcc;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

public final class RawCcExtractor implements Extractor {
    private static final int HEADER_ID = Util.getIntegerCodeForString("RCC\u0001");
    private static final int HEADER_SIZE = 8;
    private static final int SCRATCH_SIZE = 9;
    private static final int STATE_READING_HEADER = 0;
    private static final int STATE_READING_SAMPLES = 2;
    private static final int STATE_READING_TIMESTAMP_AND_COUNT = 1;
    private static final int TIMESTAMP_SIZE_V0 = 4;
    private static final int TIMESTAMP_SIZE_V1 = 8;
    private final ParsableByteArray dataScratch = new ParsableByteArray(9);
    private final Format format;
    private int parserState = 0;
    private int remainingSampleCount;
    private int sampleBytesWritten;
    private long timestampUs;
    private TrackOutput trackOutput;
    private int version;

    public RawCcExtractor(Format format2) {
        this.format = format2;
    }

    private boolean parseHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        this.dataScratch.reset();
        if (!extractorInput.readFully(this.dataScratch.data, 0, 8, true)) {
            return false;
        }
        if (this.dataScratch.readInt() == HEADER_ID) {
            this.version = this.dataScratch.readUnsignedByte();
            return true;
        }
        throw new IOException("Input not RawCC");
    }

    private void parseSamples(ExtractorInput extractorInput) throws IOException, InterruptedException {
        while (this.remainingSampleCount > 0) {
            this.dataScratch.reset();
            extractorInput.readFully(this.dataScratch.data, 0, 3);
            this.trackOutput.sampleData(this.dataScratch, 3);
            this.sampleBytesWritten += 3;
            this.remainingSampleCount--;
        }
        int i5 = this.sampleBytesWritten;
        if (i5 > 0) {
            this.trackOutput.sampleMetadata(this.timestampUs, 1, i5, 0, (TrackOutput.CryptoData) null);
        }
    }

    private boolean parseTimestampAndSampleCount(ExtractorInput extractorInput) throws IOException, InterruptedException {
        this.dataScratch.reset();
        int i5 = this.version;
        if (i5 == 0) {
            if (!extractorInput.readFully(this.dataScratch.data, 0, 5, true)) {
                return false;
            }
            this.timestampUs = (this.dataScratch.readUnsignedInt() * 1000) / 45;
        } else if (i5 != 1) {
            throw new ParserException("Unsupported version number: " + this.version);
        } else if (!extractorInput.readFully(this.dataScratch.data, 0, 9, true)) {
            return false;
        } else {
            this.timestampUs = this.dataScratch.readLong();
        }
        this.remainingSampleCount = this.dataScratch.readUnsignedByte();
        this.sampleBytesWritten = 0;
        return true;
    }

    public final void init(ExtractorOutput extractorOutput) {
        extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
        this.trackOutput = extractorOutput.track(0, 3);
        extractorOutput.endTracks();
        this.trackOutput.format(this.format);
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            int i5 = this.parserState;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        parseSamples(extractorInput);
                        this.parserState = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (parseTimestampAndSampleCount(extractorInput)) {
                    this.parserState = 2;
                } else {
                    this.parserState = 0;
                    return -1;
                }
            } else if (!parseHeader(extractorInput)) {
                return -1;
            } else {
                this.parserState = 1;
            }
        }
    }

    public final void release() {
    }

    public final void seek(long j5, long j6) {
        this.parserState = 0;
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        this.dataScratch.reset();
        extractorInput.peekFully(this.dataScratch.data, 0, 8);
        if (this.dataScratch.readInt() == HEADER_ID) {
            return true;
        }
        return false;
    }
}
