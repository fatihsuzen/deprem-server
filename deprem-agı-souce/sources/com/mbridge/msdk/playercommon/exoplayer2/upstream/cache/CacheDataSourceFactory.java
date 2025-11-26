package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSink;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.FileDataSourceFactory;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSource;

public final class CacheDataSourceFactory implements DataSource.Factory {
    private final Cache cache;
    private final DataSource.Factory cacheReadDataSourceFactory;
    private final DataSink.Factory cacheWriteDataSinkFactory;
    private final CacheDataSource.EventListener eventListener;
    private final int flags;
    private final DataSource.Factory upstreamFactory;

    public CacheDataSourceFactory(Cache cache2, DataSource.Factory factory) {
        this(cache2, factory, 0);
    }

    public CacheDataSourceFactory(Cache cache2, DataSource.Factory factory, int i5) {
        this(cache2, factory, i5, CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE);
    }

    public final CacheDataSource createDataSource() {
        Cache cache2 = this.cache;
        DataSource createDataSource = this.upstreamFactory.createDataSource();
        DataSource createDataSource2 = this.cacheReadDataSourceFactory.createDataSource();
        DataSink.Factory factory = this.cacheWriteDataSinkFactory;
        return new CacheDataSource(cache2, createDataSource, createDataSource2, factory != null ? factory.createDataSink() : null, this.flags, this.eventListener);
    }

    public CacheDataSourceFactory(Cache cache2, DataSource.Factory factory, int i5, long j5) {
        this(cache2, factory, new FileDataSourceFactory(), new CacheDataSinkFactory(cache2, j5), i5, (CacheDataSource.EventListener) null);
    }

    public CacheDataSourceFactory(Cache cache2, DataSource.Factory factory, DataSource.Factory factory2, DataSink.Factory factory3, int i5, CacheDataSource.EventListener eventListener2) {
        this.cache = cache2;
        this.upstreamFactory = factory;
        this.cacheReadDataSourceFactory = factory2;
        this.cacheWriteDataSinkFactory = factory3;
        this.flags = i5;
        this.eventListener = eventListener2;
    }
}
