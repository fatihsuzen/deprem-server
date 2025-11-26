package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.PriorityTaskManager;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CacheUtil {
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;

    public static class CachingCounters {
        public volatile long alreadyCachedBytes;
        public volatile long contentLength = -1;
        public volatile long newlyCachedBytes;

        public long totalCachedBytes() {
            return this.alreadyCachedBytes + this.newlyCachedBytes;
        }
    }

    private CacheUtil() {
    }

    public static void cache(DataSpec dataSpec, Cache cache, DataSource dataSource, @Nullable CachingCounters cachingCounters, @Nullable AtomicBoolean atomicBoolean) throws IOException, InterruptedException {
        cache(dataSpec, cache, new CacheDataSource(cache, dataSource), new byte[131072], (PriorityTaskManager) null, 0, cachingCounters, atomicBoolean, false);
    }

    public static String generateKey(Uri uri) {
        return uri.toString();
    }

    public static void getCached(DataSpec dataSpec, Cache cache, CachingCounters cachingCounters) {
        long j5;
        DataSpec dataSpec2 = dataSpec;
        CachingCounters cachingCounters2 = cachingCounters;
        String key = getKey(dataSpec2);
        long j6 = dataSpec2.absoluteStreamPosition;
        long j7 = dataSpec2.length;
        Cache cache2 = cache;
        if (j7 == -1) {
            j7 = cache2.getContentLength(key);
        }
        cachingCounters2.contentLength = j7;
        cachingCounters2.alreadyCachedBytes = 0;
        cachingCounters2.newlyCachedBytes = 0;
        long j8 = j7;
        while (j8 != 0) {
            int i5 = (j8 > -1 ? 1 : (j8 == -1 ? 0 : -1));
            if (i5 != 0) {
                j5 = j8;
            } else {
                j5 = Long.MAX_VALUE;
            }
            long cachedLength = cache2.getCachedLength(key, j6, j5);
            if (cachedLength > 0) {
                cachingCounters2.alreadyCachedBytes += cachedLength;
            } else {
                cachedLength = -cachedLength;
                if (cachedLength == Long.MAX_VALUE) {
                    return;
                }
            }
            j6 += cachedLength;
            if (i5 == 0) {
                cachedLength = 0;
            }
            j8 -= cachedLength;
            cache2 = cache;
        }
    }

    public static String getKey(DataSpec dataSpec) {
        String str = dataSpec.key;
        if (str != null) {
            return str;
        }
        return generateKey(dataSpec.uri);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008f, code lost:
        com.mbridge.msdk.playercommon.exoplayer2.util.Util.closeQuietly(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0092, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044 A[Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }, ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }]), Splitter:B:3:0x000d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long readAndDiscard(com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec r16, long r17, long r19, com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource r21, byte[] r22, com.mbridge.msdk.playercommon.exoplayer2.util.PriorityTaskManager r23, int r24, com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheUtil.CachingCounters r25) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r1 = r21
            r0 = r22
            r2 = r25
            r3 = r16
        L_0x0008:
            if (r23 == 0) goto L_0x000d
            r23.proceed(r24)
        L_0x000d:
            boolean r4 = java.lang.Thread.interrupted()     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            if (r4 != 0) goto L_0x0089
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec r5 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            android.net.Uri r6 = r3.uri     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            byte[] r7 = r3.postBody     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            long r8 = r3.position     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            long r8 = r8 + r17
            long r10 = r3.absoluteStreamPosition     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            long r10 = r8 - r10
            java.lang.String r14 = r3.key     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            int r4 = r3.flags     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            r15 = r4 | 2
            r12 = -1
            r8 = r17
            r5.<init>(r6, r7, r8, r10, r12, r14, r15)     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            long r3 = r1.open(r5)     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            long r6 = r2.contentLength     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            r8 = -1
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x0048
            int r6 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0048
            long r6 = r5.absoluteStreamPosition     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            long r6 = r6 + r3
            r2.contentLength = r6     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r0 = move-exception
            goto L_0x008f
        L_0x0046:
            r3 = r5
            goto L_0x0093
        L_0x0048:
            r3 = 0
        L_0x004a:
            int r6 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r6 == 0) goto L_0x0085
            boolean r6 = java.lang.Thread.interrupted()     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            if (r6 != 0) goto L_0x007f
            int r6 = (r19 > r8 ? 1 : (r19 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0062
            int r6 = r0.length     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            long r6 = (long) r6     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            long r10 = r19 - r3
            long r6 = java.lang.Math.min(r6, r10)     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            int r6 = (int) r6     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            goto L_0x0063
        L_0x0062:
            int r6 = r0.length     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
        L_0x0063:
            r7 = 0
            int r6 = r1.read(r0, r7, r6)     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            r7 = -1
            if (r6 != r7) goto L_0x0077
            long r6 = r2.contentLength     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x0085
            long r6 = r5.absoluteStreamPosition     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            long r6 = r6 + r3
            r2.contentLength = r6     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            goto L_0x0085
        L_0x0077:
            long r6 = (long) r6     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            long r3 = r3 + r6
            long r10 = r2.newlyCachedBytes     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            long r10 = r10 + r6
            r2.newlyCachedBytes = r10     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            goto L_0x004a
        L_0x007f:
            java.lang.InterruptedException r3 = new java.lang.InterruptedException     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            r3.<init>()     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
            throw r3     // Catch:{ PriorityTooLowException -> 0x0046, all -> 0x0044 }
        L_0x0085:
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.closeQuietly((com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource) r1)
            return r3
        L_0x0089:
            java.lang.InterruptedException r4 = new java.lang.InterruptedException     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            r4.<init>()     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
            throw r4     // Catch:{ PriorityTooLowException -> 0x0093, all -> 0x0044 }
        L_0x008f:
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.closeQuietly((com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource) r1)
            throw r0
        L_0x0093:
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.closeQuietly((com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource) r1)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheUtil.readAndDiscard(com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec, long, long, com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource, byte[], com.mbridge.msdk.playercommon.exoplayer2.util.PriorityTaskManager, int, com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheUtil$CachingCounters):long");
    }

    public static void remove(Cache cache, String str) {
        for (CacheSpan removeSpan : cache.getCachedSpans(str)) {
            try {
                cache.removeSpan(removeSpan);
            } catch (Cache.CacheException unused) {
            }
        }
    }

    public static void cache(DataSpec dataSpec, Cache cache, CacheDataSource cacheDataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int i5, @Nullable CachingCounters cachingCounters, @Nullable AtomicBoolean atomicBoolean, boolean z4) throws IOException, InterruptedException {
        DataSpec dataSpec2 = dataSpec;
        Cache cache2 = cache;
        CachingCounters cachingCounters2 = cachingCounters;
        Assertions.checkNotNull(cacheDataSource);
        Assertions.checkNotNull(bArr);
        if (cachingCounters2 != null) {
            getCached(dataSpec2, cache2, cachingCounters2);
        } else {
            cachingCounters2 = new CachingCounters();
        }
        CachingCounters cachingCounters3 = cachingCounters2;
        String key = getKey(dataSpec2);
        long j5 = dataSpec2.absoluteStreamPosition;
        long j6 = dataSpec2.length;
        if (j6 == -1) {
            j6 = cache2.getContentLength(key);
        }
        long j7 = j6;
        while (true) {
            long j8 = 0;
            if (j7 == 0) {
                return;
            }
            if (atomicBoolean == null || !atomicBoolean.get()) {
                int i6 = (j7 > -1 ? 1 : (j7 == -1 ? 0 : -1));
                long cachedLength = cache2.getCachedLength(key, j5, i6 != 0 ? j7 : Long.MAX_VALUE);
                String str = key;
                long j9 = j5;
                if (cachedLength <= 0) {
                    long j10 = -cachedLength;
                    if (readAndDiscard(dataSpec2, j9, j10, cacheDataSource, bArr, priorityTaskManager, i5, cachingCounters3) >= j10) {
                        cachedLength = j10;
                    } else if (z4 && i6 != 0) {
                        throw new EOFException();
                    } else {
                        return;
                    }
                }
                j5 = j9 + cachedLength;
                if (i6 != 0) {
                    j8 = cachedLength;
                }
                j7 -= j8;
                dataSpec2 = dataSpec;
                cache2 = cache;
                key = str;
            } else {
                throw new InterruptedException();
            }
        }
    }
}
