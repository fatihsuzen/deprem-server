package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;

public final class Id3Reader implements ElementaryStreamReader {
    private static final int ID3_HEADER_SIZE = 10;
    private static final String TAG = "Id3Reader";
    private final ParsableByteArray id3Header = new ParsableByteArray(10);
    private TrackOutput output;
    private int sampleBytesRead;
    private int sampleSize;
    private long sampleTimeUs;
    private boolean writingSample;

    public final void consume(ParsableByteArray parsableByteArray) {
        if (this.writingSample) {
            int bytesLeft = parsableByteArray.bytesLeft();
            int i5 = this.sampleBytesRead;
            if (i5 < 10) {
                int min = Math.min(bytesLeft, 10 - i5);
                System.arraycopy(parsableByteArray.data, parsableByteArray.getPosition(), this.id3Header.data, this.sampleBytesRead, min);
                if (this.sampleBytesRead + min == 10) {
                    this.id3Header.setPosition(0);
                    if (73 == this.id3Header.readUnsignedByte() && 68 == this.id3Header.readUnsignedByte() && 51 == this.id3Header.readUnsignedByte()) {
                        this.id3Header.skipBytes(3);
                        this.sampleSize = this.id3Header.readSynchSafeInt() + 10;
                    } else {
                        Log.w(TAG, "Discarding invalid ID3 tag");
                        this.writingSample = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(bytesLeft, this.sampleSize - this.sampleBytesRead);
            this.output.sampleData(parsableByteArray, min2);
            this.sampleBytesRead += min2;
        }
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
        this.output = track;
        track.format(Format.createSampleFormat(trackIdGenerator.getFormatId(), MimeTypes.APPLICATION_ID3, (String) null, -1, (DrmInitData) null));
    }

    public final void packetFinished() {
        int i5;
        if (this.writingSample && (i5 = this.sampleSize) != 0 && this.sampleBytesRead == i5) {
            this.output.sampleMetadata(this.sampleTimeUs, 1, i5, 0, (TrackOutput.CryptoData) null);
            this.writingSample = false;
        }
    }

    public final void packetStarted(long j5, boolean z4) {
        if (z4) {
            this.writingSample = true;
            this.sampleTimeUs = j5;
            this.sampleSize = 0;
            this.sampleBytesRead = 0;
        }
    }

    public final void seek() {
        this.writingSample = false;
    }
}
