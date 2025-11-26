package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DefaultExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

public final class InitializationChunk extends Chunk {
    private volatile int bytesLoaded;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i5, @Nullable Object obj, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, 2, format, i5, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.extractorWrapper = chunkExtractorWrapper;
    }

    public final long bytesLoaded() {
        return (long) this.bytesLoaded;
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public final void load() throws IOException, InterruptedException {
        DefaultExtractorInput defaultExtractorInput;
        DataSpec subrange = this.dataSpec.subrange((long) this.bytesLoaded);
        try {
            DataSource dataSource = this.dataSource;
            defaultExtractorInput = new DefaultExtractorInput(dataSource, subrange.absoluteStreamPosition, dataSource.open(subrange));
            if (this.bytesLoaded == 0) {
                this.extractorWrapper.init((ChunkExtractorWrapper.TrackOutputProvider) null, C.TIME_UNSET);
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
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
