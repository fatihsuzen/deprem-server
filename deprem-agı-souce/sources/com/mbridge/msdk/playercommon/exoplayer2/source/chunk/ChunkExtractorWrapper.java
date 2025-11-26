package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DummyTrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class ChunkExtractorWrapper implements ExtractorOutput {
    private final SparseArray<BindingTrackOutput> bindingTrackOutputs = new SparseArray<>();
    public final Extractor extractor;
    private boolean extractorInitialized;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private Format[] sampleFormats;
    private SeekMap seekMap;
    private TrackOutputProvider trackOutputProvider;

    private static final class BindingTrackOutput implements TrackOutput {
        private final int id;
        private final Format manifestFormat;
        public Format sampleFormat;
        private TrackOutput trackOutput;
        private final int type;

        public BindingTrackOutput(int i5, int i6, Format format) {
            this.id = i5;
            this.type = i6;
            this.manifestFormat = format;
        }

        public final void bind(TrackOutputProvider trackOutputProvider) {
            if (trackOutputProvider == null) {
                this.trackOutput = new DummyTrackOutput();
                return;
            }
            TrackOutput track = trackOutputProvider.track(this.id, this.type);
            this.trackOutput = track;
            Format format = this.sampleFormat;
            if (format != null) {
                track.format(format);
            }
        }

        public final void format(Format format) {
            Format format2 = this.manifestFormat;
            if (format2 != null) {
                format = format.copyWithManifestFormatInfo(format2);
            }
            this.sampleFormat = format;
            this.trackOutput.format(format);
        }

        public final int sampleData(ExtractorInput extractorInput, int i5, boolean z4) throws IOException, InterruptedException {
            return this.trackOutput.sampleData(extractorInput, i5, z4);
        }

        public final void sampleMetadata(long j5, int i5, int i6, int i7, TrackOutput.CryptoData cryptoData) {
            this.trackOutput.sampleMetadata(j5, i5, i6, i7, cryptoData);
        }

        public final void sampleData(ParsableByteArray parsableByteArray, int i5) {
            this.trackOutput.sampleData(parsableByteArray, i5);
        }
    }

    public interface TrackOutputProvider {
        TrackOutput track(int i5, int i6);
    }

    public ChunkExtractorWrapper(Extractor extractor2, int i5, Format format) {
        this.extractor = extractor2;
        this.primaryTrackType = i5;
        this.primaryTrackManifestFormat = format;
    }

    public final void endTracks() {
        Format[] formatArr = new Format[this.bindingTrackOutputs.size()];
        for (int i5 = 0; i5 < this.bindingTrackOutputs.size(); i5++) {
            formatArr[i5] = this.bindingTrackOutputs.valueAt(i5).sampleFormat;
        }
        this.sampleFormats = formatArr;
    }

    public final Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public final SeekMap getSeekMap() {
        return this.seekMap;
    }

    public final void init(TrackOutputProvider trackOutputProvider2, long j5) {
        this.trackOutputProvider = trackOutputProvider2;
        if (!this.extractorInitialized) {
            this.extractor.init(this);
            if (j5 != C.TIME_UNSET) {
                this.extractor.seek(0, j5);
            }
            this.extractorInitialized = true;
            return;
        }
        Extractor extractor2 = this.extractor;
        if (j5 == C.TIME_UNSET) {
            j5 = 0;
        }
        extractor2.seek(0, j5);
        for (int i5 = 0; i5 < this.bindingTrackOutputs.size(); i5++) {
            this.bindingTrackOutputs.valueAt(i5).bind(trackOutputProvider2);
        }
    }

    public final void seekMap(SeekMap seekMap2) {
        this.seekMap = seekMap2;
    }

    public final TrackOutput track(int i5, int i6) {
        boolean z4;
        Format format;
        BindingTrackOutput bindingTrackOutput = this.bindingTrackOutputs.get(i5);
        if (bindingTrackOutput == null) {
            if (this.sampleFormats == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkState(z4);
            if (i6 == this.primaryTrackType) {
                format = this.primaryTrackManifestFormat;
            } else {
                format = null;
            }
            bindingTrackOutput = new BindingTrackOutput(i5, i6, format);
            bindingTrackOutput.bind(this.trackOutputProvider);
            this.bindingTrackOutputs.put(i5, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }
}
