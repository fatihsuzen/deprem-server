package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class MpegAudioReader implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 4;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_FRAME = 2;
    private static final int STATE_READING_HEADER = 1;
    private String formatId;
    private int frameBytesRead;
    private long frameDurationUs;
    private int frameSize;
    private boolean hasOutputFormat;
    private final MpegAudioHeader header;
    private final ParsableByteArray headerScratch;
    private final String language;
    private boolean lastByteWasFF;
    private TrackOutput output;
    private int state;
    private long timeUs;

    public MpegAudioReader() {
        this((String) null);
    }

    private void findHeader(ParsableByteArray parsableByteArray) {
        boolean z4;
        boolean z5;
        byte[] bArr = parsableByteArray.data;
        int limit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < limit; position++) {
            byte b5 = bArr[position];
            if ((b5 & 255) == 255) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!this.lastByteWasFF || (b5 & 224) != 224) {
                z5 = false;
            } else {
                z5 = true;
            }
            this.lastByteWasFF = z4;
            if (z5) {
                parsableByteArray.setPosition(position + 1);
                this.lastByteWasFF = false;
                this.headerScratch.data[1] = bArr[position];
                this.frameBytesRead = 2;
                this.state = 1;
                return;
            }
        }
        parsableByteArray.setPosition(limit);
    }

    private void readFrameRemainder(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), this.frameSize - this.frameBytesRead);
        this.output.sampleData(parsableByteArray, min);
        int i5 = this.frameBytesRead + min;
        this.frameBytesRead = i5;
        int i6 = this.frameSize;
        if (i5 >= i6) {
            this.output.sampleMetadata(this.timeUs, 1, i6, 0, (TrackOutput.CryptoData) null);
            this.timeUs += this.frameDurationUs;
            this.frameBytesRead = 0;
            this.state = 0;
        }
    }

    private void readHeaderRemainder(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), 4 - this.frameBytesRead);
        parsableByteArray.readBytes(this.headerScratch.data, this.frameBytesRead, min);
        int i5 = this.frameBytesRead + min;
        this.frameBytesRead = i5;
        if (i5 >= 4) {
            this.headerScratch.setPosition(0);
            if (!MpegAudioHeader.populateHeader(this.headerScratch.readInt(), this.header)) {
                this.frameBytesRead = 0;
                this.state = 1;
                return;
            }
            MpegAudioHeader mpegAudioHeader = this.header;
            this.frameSize = mpegAudioHeader.frameSize;
            if (!this.hasOutputFormat) {
                int i6 = mpegAudioHeader.sampleRate;
                this.frameDurationUs = (((long) mpegAudioHeader.samplesPerFrame) * 1000000) / ((long) i6);
                this.output.format(Format.createAudioSampleFormat(this.formatId, mpegAudioHeader.mimeType, (String) null, -1, 4096, mpegAudioHeader.channels, i6, (List<byte[]>) null, (DrmInitData) null, 0, this.language));
                this.hasOutputFormat = true;
            }
            this.headerScratch.setPosition(0);
            this.output.sampleData(this.headerScratch, 4);
            this.state = 2;
        }
    }

    public final void consume(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.bytesLeft() > 0) {
            int i5 = this.state;
            if (i5 == 0) {
                findHeader(parsableByteArray);
            } else if (i5 == 1) {
                readHeaderRemainder(parsableByteArray);
            } else if (i5 == 2) {
                readFrameRemainder(parsableByteArray);
            }
        }
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    public final void packetFinished() {
    }

    public final void packetStarted(long j5, boolean z4) {
        this.timeUs = j5;
    }

    public final void seek() {
        this.state = 0;
        this.frameBytesRead = 0;
        this.lastByteWasFF = false;
    }

    public MpegAudioReader(String str) {
        this.state = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.headerScratch = parsableByteArray;
        parsableByteArray.data[0] = -1;
        this.header = new MpegAudioHeader();
        this.language = str;
    }
}
