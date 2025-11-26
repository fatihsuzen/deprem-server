package com.mbridge.msdk.playercommon.exoplayer2.extractor.wav;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.List;

public final class WavExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() {
        public final Extractor[] createExtractors() {
            return new Extractor[]{new WavExtractor()};
        }
    };
    private static final int MAX_INPUT_SIZE = 32768;
    private int bytesPerFrame;
    private ExtractorOutput extractorOutput;
    private int pendingBytes;
    private TrackOutput trackOutput;
    private WavHeader wavHeader;

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = extractorOutput2.track(0, 1);
        this.wavHeader = null;
        extractorOutput2.endTracks();
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        if (this.wavHeader == null) {
            WavHeader peek = WavHeaderReader.peek(extractorInput);
            this.wavHeader = peek;
            if (peek != null) {
                this.trackOutput.format(Format.createAudioSampleFormat((String) null, MimeTypes.AUDIO_RAW, (String) null, peek.getBitrate(), 32768, this.wavHeader.getNumChannels(), this.wavHeader.getSampleRateHz(), this.wavHeader.getEncoding(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.bytesPerFrame = this.wavHeader.getBytesPerFrame();
            } else {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
        }
        if (!this.wavHeader.hasDataBounds()) {
            WavHeaderReader.skipToData(extractorInput, this.wavHeader);
            this.extractorOutput.seekMap(this.wavHeader);
        }
        int sampleData = this.trackOutput.sampleData(extractorInput, 32768 - this.pendingBytes, true);
        if (sampleData != -1) {
            this.pendingBytes += sampleData;
        }
        int i5 = this.pendingBytes / this.bytesPerFrame;
        if (i5 > 0) {
            long timeUs = this.wavHeader.getTimeUs(extractorInput.getPosition() - ((long) this.pendingBytes));
            int i6 = i5 * this.bytesPerFrame;
            int i7 = this.pendingBytes - i6;
            this.pendingBytes = i7;
            this.trackOutput.sampleMetadata(timeUs, 1, i6, i7, (TrackOutput.CryptoData) null);
        }
        if (sampleData == -1) {
            return -1;
        }
        return 0;
    }

    public final void release() {
    }

    public final void seek(long j5, long j6) {
        this.pendingBytes = 0;
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (WavHeaderReader.peek(extractorInput) != null) {
            return true;
        }
        return false;
    }
}
