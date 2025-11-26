package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

abstract class StreamReader {
    private static final int STATE_END_OF_INPUT = 3;
    private static final int STATE_READ_HEADERS = 0;
    private static final int STATE_READ_PAYLOAD = 2;
    private static final int STATE_SKIP_HEADERS = 1;
    private long currentGranule;
    private ExtractorOutput extractorOutput;
    private boolean formatSet;
    private long lengthOfReadPacket;
    private final OggPacket oggPacket = new OggPacket();
    private OggSeeker oggSeeker;
    private long payloadStartPosition;
    private int sampleRate;
    private boolean seekMapSet;
    private SetupData setupData;
    private int state;
    private long targetGranule;
    private TrackOutput trackOutput;

    static class SetupData {
        Format format;
        OggSeeker oggSeeker;

        SetupData() {
        }
    }

    private static final class UnseekableOggSeeker implements OggSeeker {
        private UnseekableOggSeeker() {
        }

        public final SeekMap createSeekMap() {
            return new SeekMap.Unseekable(C.TIME_UNSET);
        }

        public final long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
            return -1;
        }

        public final long startSeek(long j5) {
            return 0;
        }
    }

    private int readHeaders(ExtractorInput extractorInput) throws IOException, InterruptedException {
        StreamReader streamReader;
        boolean z4 = true;
        while (z4) {
            if (!this.oggPacket.populate(extractorInput)) {
                this.state = 3;
                return -1;
            }
            this.lengthOfReadPacket = extractorInput.getPosition() - this.payloadStartPosition;
            z4 = readHeaders(this.oggPacket.getPayload(), this.payloadStartPosition, this.setupData);
            if (z4) {
                this.payloadStartPosition = extractorInput.getPosition();
            }
        }
        Format format = this.setupData.format;
        this.sampleRate = format.sampleRate;
        if (!this.formatSet) {
            this.trackOutput.format(format);
            this.formatSet = true;
        }
        OggSeeker oggSeeker2 = this.setupData.oggSeeker;
        if (oggSeeker2 != null) {
            this.oggSeeker = oggSeeker2;
        } else if (extractorInput.getLength() == -1) {
            this.oggSeeker = new UnseekableOggSeeker();
        } else {
            OggPageHeader pageHeader = this.oggPacket.getPageHeader();
            streamReader = this;
            streamReader.oggSeeker = new DefaultOggSeeker(this.payloadStartPosition, extractorInput.getLength(), streamReader, pageHeader.headerSize + pageHeader.bodySize, pageHeader.granulePosition);
            streamReader.setupData = null;
            streamReader.state = 2;
            streamReader.oggPacket.trimPayload();
            return 0;
        }
        streamReader = this;
        streamReader.setupData = null;
        streamReader.state = 2;
        streamReader.oggPacket.trimPayload();
        return 0;
    }

    private int readPayload(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        ExtractorInput extractorInput2 = extractorInput;
        long read = this.oggSeeker.read(extractorInput2);
        if (read >= 0) {
            positionHolder.position = read;
            return 1;
        }
        if (read < -1) {
            onSeekEnd(-(read + 2));
        }
        if (!this.seekMapSet) {
            this.extractorOutput.seekMap(this.oggSeeker.createSeekMap());
            this.seekMapSet = true;
        }
        if (this.lengthOfReadPacket > 0 || this.oggPacket.populate(extractorInput2)) {
            this.lengthOfReadPacket = 0;
            ParsableByteArray payload = this.oggPacket.getPayload();
            long preparePayload = preparePayload(payload);
            if (preparePayload >= 0) {
                long j5 = this.currentGranule;
                if (j5 + preparePayload >= this.targetGranule) {
                    long convertGranuleToTime = convertGranuleToTime(j5);
                    this.trackOutput.sampleData(payload, payload.limit());
                    this.trackOutput.sampleMetadata(convertGranuleToTime, 1, payload.limit(), 0, (TrackOutput.CryptoData) null);
                    this.targetGranule = -1;
                }
            }
            this.currentGranule += preparePayload;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public long convertGranuleToTime(long j5) {
        return (j5 * 1000000) / ((long) this.sampleRate);
    }

    /* access modifiers changed from: protected */
    public long convertTimeToGranule(long j5) {
        return (((long) this.sampleRate) * j5) / 1000000;
    }

    /* access modifiers changed from: package-private */
    public void init(ExtractorOutput extractorOutput2, TrackOutput trackOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = trackOutput2;
        reset(true);
    }

    /* access modifiers changed from: protected */
    public void onSeekEnd(long j5) {
        this.currentGranule = j5;
    }

    /* access modifiers changed from: protected */
    public abstract long preparePayload(ParsableByteArray parsableByteArray);

    /* access modifiers changed from: package-private */
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        int i5 = this.state;
        if (i5 == 0) {
            return readHeaders(extractorInput);
        }
        if (i5 == 1) {
            extractorInput.skipFully((int) this.payloadStartPosition);
            this.state = 2;
            return 0;
        } else if (i5 == 2) {
            return readPayload(extractorInput, positionHolder);
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean readHeaders(ParsableByteArray parsableByteArray, long j5, SetupData setupData2) throws IOException, InterruptedException;

    /* access modifiers changed from: protected */
    public void reset(boolean z4) {
        if (z4) {
            this.setupData = new SetupData();
            this.payloadStartPosition = 0;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.targetGranule = -1;
        this.currentGranule = 0;
    }

    /* access modifiers changed from: package-private */
    public final void seek(long j5, long j6) {
        this.oggPacket.reset();
        if (j5 == 0) {
            reset(!this.seekMapSet);
        } else if (this.state != 0) {
            this.targetGranule = this.oggSeeker.startSeek(j6);
            this.state = 2;
        }
    }
}
