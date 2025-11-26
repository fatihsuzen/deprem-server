package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSink;

public final class CacheDataSinkFactory implements DataSink.Factory {
    private final int bufferSize;
    private final Cache cache;
    private final long maxCacheFileSize;

    public CacheDataSinkFactory(Cache cache2, long j5) {
        this(cache2, j5, CacheDataSink.DEFAULT_BUFFER_SIZE);
    }

    public final DataSink createDataSink() {
        return new CacheDataSink(this.cache, this.maxCacheFileSize, this.bufferSize);
    }

    public CacheDataSinkFactory(Cache cache2, long j5, int i5) {
        this.cache = cache2;
        this.maxCacheFileSize = j5;
        this.bufferSize = i5;
    }
}
