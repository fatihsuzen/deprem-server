package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DefaultExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

public class ContainerMediaChunk extends BaseMediaChunk {
    private volatile int bytesLoaded;
    private final int chunkCount;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private volatile boolean loadCompleted;
    private final long sampleOffsetUs;

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i5, Object obj, long j5, long j6, long j7, long j8, int i6, long j9, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, format, i5, obj, j5, j6, j7, j8);
        this.chunkCount = i6;
        this.sampleOffsetUs = j9;
        this.extractorWrapper = chunkExtractorWrapper;
    }

    public final long bytesLoaded() {
        return (long) this.bytesLoaded;
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public long getNextChunkIndex() {
        return this.chunkIndex + ((long) this.chunkCount);
    }

    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    public final void load() throws IOException, InterruptedException {
        DefaultExtractorInput defaultExtractorInput;
        long j5;
        DataSpec subrange = this.dataSpec.subrange((long) this.bytesLoaded);
        try {
            DataSource dataSource = this.dataSource;
            defaultExtractorInput = new DefaultExtractorInput(dataSource, subrange.absoluteStreamPosition, dataSource.open(subrange));
            if (this.bytesLoaded == 0) {
                BaseMediaChunkOutput output = getOutput();
                output.setSampleOffsetUs(this.sampleOffsetUs);
                ChunkExtractorWrapper chunkExtractorWrapper = this.extractorWrapper;
                long j6 = this.seekTimeUs;
                if (j6 == C.TIME_UNSET) {
                    j5 = 0;
                } else {
                    j5 = j6 - this.sampleOffsetUs;
                }
                chunkExtractorWrapper.init(output, j5);
            }
            Extractor extractor = this.extractorWrapper.extractor;
            boolean z4 = false;
            int i5 = 0;
            while (i5 == 0 && !this.loadCanceled) {
                i5 = extractor.read(defaultExtractorInput, (PositionHolder) null);
            }
            if (i5 != 1) {
                z4 = true;
            }
            Assertions.checkState(z4);
            this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
            Util.closeQuietly(this.dataSource);
            this.loadCompleted = true;
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
