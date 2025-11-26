package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import java.util.Comparator;
import java.util.TreeSet;

public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor, Comparator<CacheSpan> {
    private long currentSize;
    private final TreeSet<CacheSpan> leastRecentlyUsed = new TreeSet<>(this);
    private final long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long j5) {
        this.maxBytes = j5;
    }

    private void evictCache(Cache cache, long j5) {
        while (this.currentSize + j5 > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
            try {
                cache.removeSpan(this.leastRecentlyUsed.first());
            } catch (Cache.CacheException unused) {
            }
        }
    }

    public final void onCacheInitialized() {
    }

    public final void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.add(cacheSpan);
        this.currentSize += cacheSpan.length;
        evictCache(cache, 0);
    }

    public final void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.remove(cacheSpan);
        this.currentSize -= cacheSpan.length;
    }

    public final void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    public final void onStartFile(Cache cache, String str, long j5, long j6) {
        evictCache(cache, j6);
    }

    public final int compare(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        long j5 = cacheSpan.lastAccessTimestamp;
        long j6 = cacheSpan2.lastAccessTimestamp;
        if (j5 - j6 == 0) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        return j5 < j6 ? -1 : 1;
    }
}
