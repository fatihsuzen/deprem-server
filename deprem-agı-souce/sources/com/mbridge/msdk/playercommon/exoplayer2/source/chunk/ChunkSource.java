package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import java.io.IOException;
import java.util.List;

public interface ChunkSource {
    long getAdjustedSeekPositionUs(long j5, SeekParameters seekParameters);

    void getNextChunk(MediaChunk mediaChunk, long j5, long j6, ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j5, List<? extends MediaChunk> list);

    void maybeThrowError() throws IOException;

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean z4, Exception exc);
}
