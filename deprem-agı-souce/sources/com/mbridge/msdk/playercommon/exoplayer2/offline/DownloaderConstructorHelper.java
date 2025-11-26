package com.mbridge.msdk.playercommon.exoplayer2.offline;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSink;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DummyDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.FileDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.PriorityDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSink;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.PriorityTaskManager;

public final class DownloaderConstructorHelper {
    private final Cache cache;
    private final DataSource.Factory cacheReadDataSourceFactory;
    private final DataSink.Factory cacheWriteDataSinkFactory;
    private final PriorityTaskManager priorityTaskManager;
    private final DataSource.Factory upstreamDataSourceFactory;

    public DownloaderConstructorHelper(Cache cache2, DataSource.Factory factory) {
        this(cache2, factory, (DataSource.Factory) null, (DataSink.Factory) null, (PriorityTaskManager) null);
    }

    public final CacheDataSource buildCacheDataSource(boolean z4) {
        DataSource fileDataSource;
        DataSink cacheDataSink;
        PriorityDataSource priorityDataSource;
        DataSource.Factory factory = this.cacheReadDataSourceFactory;
        if (factory != null) {
            fileDataSource = factory.createDataSource();
        } else {
            fileDataSource = new FileDataSource();
        }
        DataSource dataSource = fileDataSource;
        if (z4) {
            return new CacheDataSource(this.cache, DummyDataSource.INSTANCE, dataSource, (DataSink) null, 1, (CacheDataSource.EventListener) null);
        }
        DataSink.Factory factory2 = this.cacheWriteDataSinkFactory;
        if (factory2 != null) {
            cacheDataSink = factory2.createDataSink();
        } else {
            cacheDataSink = new CacheDataSink(this.cache, CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE);
        }
        DataSink dataSink = cacheDataSink;
        DataSource createDataSource = this.upstreamDataSourceFactory.createDataSource();
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (priorityTaskManager2 == null) {
            priorityDataSource = createDataSource;
        } else {
            priorityDataSource = new PriorityDataSource(createDataSource, priorityTaskManager2, -1000);
        }
        return new CacheDataSource(this.cache, priorityDataSource, dataSource, dataSink, 1, (CacheDataSource.EventListener) null);
    }

    public final Cache getCache() {
        return this.cache;
    }

    public final PriorityTaskManager getPriorityTaskManager() {
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (priorityTaskManager2 != null) {
            return priorityTaskManager2;
        }
        return new PriorityTaskManager();
    }

    public DownloaderConstructorHelper(Cache cache2, DataSource.Factory factory, @Nullable DataSource.Factory factory2, @Nullable DataSink.Factory factory3, @Nullable PriorityTaskManager priorityTaskManager2) {
        Assertions.checkNotNull(factory);
        this.cache = cache2;
        this.upstreamDataSourceFactory = factory;
        this.cacheReadDataSourceFactory = factory2;
        this.cacheWriteDataSinkFactory = factory3;
        this.priorityTaskManager = priorityTaskManager2;
    }
}
