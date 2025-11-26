package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public abstract class MediaChunk extends Chunk {
    public final long chunkIndex;

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i5, Object obj, long j5, long j6, long j7) {
        super(dataSource, dataSpec, 1, format, i5, obj, j5, j6);
        Assertions.checkNotNull(format);
        this.chunkIndex = j7;
    }

    public long getNextChunkIndex() {
        long j5 = this.chunkIndex;
        if (j5 != -1) {
            return j5 + 1;
        }
        return -1;
    }

    public abstract boolean isLoadCompleted();
}
