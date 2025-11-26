package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DefaultExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

public final class SingleSampleMediaChunk extends BaseMediaChunk {
    private volatile int bytesLoaded;
    private volatile boolean loadCompleted;
    private final Format sampleFormat;
    private final int trackType;

    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i5, Object obj, long j5, long j6, long j7, int i6, Format format2) {
        super(dataSource, dataSpec, format, i5, obj, j5, j6, C.TIME_UNSET, j7);
        this.trackType = i6;
        this.sampleFormat = format2;
    }

    public final long bytesLoaded() {
        return (long) this.bytesLoaded;
    }

    public final void cancelLoad() {
    }

    public final boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    public final void load() throws IOException, InterruptedException {
        try {
            long open = this.dataSource.open(this.dataSpec.subrange((long) this.bytesLoaded));
            if (open != -1) {
                open += (long) this.bytesLoaded;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, (long) this.bytesLoaded, open);
            BaseMediaChunkOutput output = getOutput();
            output.setSampleOffsetUs(0);
            TrackOutput track = output.track(0, this.trackType);
            track.format(this.sampleFormat);
            for (int i5 = 0; i5 != -1; i5 = track.sampleData(defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.bytesLoaded += i5;
            }
            track.sampleMetadata(this.startTimeUs, 1, this.bytesLoaded, 0, (TrackOutput.CryptoData) null);
            Util.closeQuietly(this.dataSource);
            this.loadCompleted = true;
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
