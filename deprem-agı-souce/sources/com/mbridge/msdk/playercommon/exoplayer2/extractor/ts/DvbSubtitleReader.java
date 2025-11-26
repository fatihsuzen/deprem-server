package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class DvbSubtitleReader implements ElementaryStreamReader {
    private int bytesToCheck;
    private final TrackOutput[] outputs;
    private int sampleBytesWritten;
    private long sampleTimeUs;
    private final List<TsPayloadReader.DvbSubtitleInfo> subtitleInfos;
    private boolean writingSample;

    public DvbSubtitleReader(List<TsPayloadReader.DvbSubtitleInfo> list) {
        this.subtitleInfos = list;
        this.outputs = new TrackOutput[list.size()];
    }

    private boolean checkNextByte(ParsableByteArray parsableByteArray, int i5) {
        if (parsableByteArray.bytesLeft() == 0) {
            return false;
        }
        if (parsableByteArray.readUnsignedByte() != i5) {
            this.writingSample = false;
        }
        this.bytesToCheck--;
        return this.writingSample;
    }

    public final void consume(ParsableByteArray parsableByteArray) {
        if (!this.writingSample) {
            return;
        }
        if (this.bytesToCheck != 2 || checkNextByte(parsableByteArray, 32)) {
            if (this.bytesToCheck != 1 || checkNextByte(parsableByteArray, 0)) {
                int position = parsableByteArray.getPosition();
                int bytesLeft = parsableByteArray.bytesLeft();
                for (TrackOutput sampleData : this.outputs) {
                    parsableByteArray.setPosition(position);
                    sampleData.sampleData(parsableByteArray, bytesLeft);
                }
                this.sampleBytesWritten += bytesLeft;
            }
        }
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i5 = 0; i5 < this.outputs.length; i5++) {
            TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = this.subtitleInfos.get(i5);
            trackIdGenerator.generateNewId();
            TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            track.format(Format.createImageSampleFormat(trackIdGenerator.getFormatId(), MimeTypes.APPLICATION_DVBSUBS, (String) null, -1, 0, Collections.singletonList(dvbSubtitleInfo.initializationData), dvbSubtitleInfo.language, (DrmInitData) null));
            this.outputs[i5] = track;
        }
    }

    public final void packetFinished() {
        if (this.writingSample) {
            for (TrackOutput sampleMetadata : this.outputs) {
                sampleMetadata.sampleMetadata(this.sampleTimeUs, 1, this.sampleBytesWritten, 0, (TrackOutput.CryptoData) null);
            }
            this.writingSample = false;
        }
    }

    public final void packetStarted(long j5, boolean z4) {
        if (z4) {
            this.writingSample = true;
            this.sampleTimeUs = j5;
            this.sampleBytesWritten = 0;
            this.bytesToCheck = 2;
        }
    }

    public final void seek() {
        this.writingSample = false;
    }
}
