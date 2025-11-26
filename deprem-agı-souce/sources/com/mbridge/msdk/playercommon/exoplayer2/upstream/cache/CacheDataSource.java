package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSink;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSourceException;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.FileDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.TeeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CacheDataSource implements DataSource {
    public static final int CACHE_IGNORED_REASON_ERROR = 0;
    public static final int CACHE_IGNORED_REASON_UNSET_LENGTH = 1;
    private static final int CACHE_NOT_IGNORED = -1;
    public static final long DEFAULT_MAX_CACHE_FILE_SIZE = 2097152;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    private static final long MIN_READ_BEFORE_CHECKING_CACHE = 102400;
    private Uri actualUri;
    private final boolean blockOnCache;
    private long bytesRemaining;
    private final Cache cache;
    private final DataSource cacheReadDataSource;
    private final DataSource cacheWriteDataSource;
    private long checkCachePosition;
    private DataSource currentDataSource;
    private boolean currentDataSpecLengthUnset;
    private CacheSpan currentHoleSpan;
    private boolean currentRequestIgnoresCache;
    @Nullable
    private final EventListener eventListener;
    private int flags;
    private final boolean ignoreCacheForUnsetLengthRequests;
    private final boolean ignoreCacheOnError;
    private String key;
    private long readPosition;
    private boolean seenCacheError;
    private long totalCachedBytesRead;
    private final DataSource upstreamDataSource;
    private Uri uri;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void onCacheIgnored(int i5);

        void onCachedBytesRead(long j5, long j6);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public CacheDataSource(Cache cache2, DataSource dataSource) {
        this(cache2, dataSource, 0, DEFAULT_MAX_CACHE_FILE_SIZE);
    }

    private void closeCurrentSource() throws IOException {
        DataSource dataSource = this.currentDataSource;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.currentDataSource = null;
                this.currentDataSpecLengthUnset = false;
                CacheSpan cacheSpan = this.currentHoleSpan;
                if (cacheSpan != null) {
                    this.cache.releaseHoleSpan(cacheSpan);
                    this.currentHoleSpan = null;
                }
            }
        }
    }

    private static Uri getRedirectedUriOrDefault(Cache cache2, String str, Uri uri2) {
        Uri redirectedUri = ContentMetadataInternal.getRedirectedUri(cache2.getContentMetadata(str));
        if (redirectedUri == null) {
            return uri2;
        }
        return redirectedUri;
    }

    private void handleBeforeThrow(IOException iOException) {
        if (isReadingFromCache() || (iOException instanceof Cache.CacheException)) {
            this.seenCacheError = true;
        }
    }

    private boolean isBypassingCache() {
        if (this.currentDataSource == this.upstreamDataSource) {
            return true;
        }
        return false;
    }

    private static boolean isCausedByPositionOutOfRange(IOException iOException) {
        Throwable th;
        while (th != null) {
            if ((th instanceof DataSourceException) && ((DataSourceException) th).reason == 0) {
                return true;
            }
            Throwable cause = th.getCause();
            th = iOException;
            th = cause;
        }
        return false;
    }

    private boolean isReadingFromCache() {
        if (this.currentDataSource == this.cacheReadDataSource) {
            return true;
        }
        return false;
    }

    private boolean isReadingFromUpstream() {
        return !isReadingFromCache();
    }

    private boolean isWritingToCache() {
        if (this.currentDataSource == this.cacheWriteDataSource) {
            return true;
        }
        return false;
    }

    private void notifyBytesRead() {
        EventListener eventListener2 = this.eventListener;
        if (eventListener2 != null && this.totalCachedBytesRead > 0) {
            eventListener2.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
            this.totalCachedBytesRead = 0;
        }
    }

    private void notifyCacheIgnored(int i5) {
        EventListener eventListener2 = this.eventListener;
        if (eventListener2 != null) {
            eventListener2.onCacheIgnored(i5);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void openNextSource(boolean r17) throws java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            boolean r0 = r1.currentRequestIgnoresCache
            r2 = 0
            if (r0 == 0) goto L_0x0009
            r0 = r2
            goto L_0x002f
        L_0x0009:
            boolean r0 = r1.blockOnCache
            if (r0 == 0) goto L_0x0025
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache r0 = r1.cache     // Catch:{ InterruptedException -> 0x0018 }
            java.lang.String r3 = r1.key     // Catch:{ InterruptedException -> 0x0018 }
            long r4 = r1.readPosition     // Catch:{ InterruptedException -> 0x0018 }
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheSpan r0 = r0.startReadWrite(r3, r4)     // Catch:{ InterruptedException -> 0x0018 }
            goto L_0x002f
        L_0x0018:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException
            r0.<init>()
            throw r0
        L_0x0025:
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache r0 = r1.cache
            java.lang.String r3 = r1.key
            long r4 = r1.readPosition
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheSpan r0 = r0.startReadWriteNonBlocking(r3, r4)
        L_0x002f:
            r3 = -1
            if (r0 != 0) goto L_0x0047
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource r2 = r1.upstreamDataSource
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec r5 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec
            android.net.Uri r6 = r1.uri
            long r7 = r1.readPosition
            long r9 = r1.bytesRemaining
            java.lang.String r11 = r1.key
            int r12 = r1.flags
            r5.<init>(r6, r7, r9, r11, r12)
        L_0x0044:
            r7 = r5
        L_0x0045:
            r5 = r0
            goto L_0x00a7
        L_0x0047:
            boolean r5 = r0.isCached
            if (r5 == 0) goto L_0x0073
            java.io.File r2 = r0.file
            android.net.Uri r6 = android.net.Uri.fromFile(r2)
            long r7 = r1.readPosition
            long r9 = r0.position
            long r9 = r7 - r9
            long r7 = r0.length
            long r7 = r7 - r9
            long r11 = r1.bytesRemaining
            int r2 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0064
            long r7 = java.lang.Math.min(r7, r11)
        L_0x0064:
            r11 = r7
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec r5 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec
            long r7 = r1.readPosition
            java.lang.String r13 = r1.key
            int r14 = r1.flags
            r5.<init>(r6, r7, r9, r11, r13, r14)
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource r2 = r1.cacheReadDataSource
            goto L_0x0044
        L_0x0073:
            boolean r5 = r0.isOpenEnded()
            if (r5 == 0) goto L_0x007d
            long r5 = r1.bytesRemaining
        L_0x007b:
            r11 = r5
            goto L_0x008a
        L_0x007d:
            long r5 = r0.length
            long r7 = r1.bytesRemaining
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 == 0) goto L_0x007b
            long r5 = java.lang.Math.min(r5, r7)
            goto L_0x007b
        L_0x008a:
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec r7 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec
            android.net.Uri r8 = r1.uri
            long r9 = r1.readPosition
            java.lang.String r13 = r1.key
            int r14 = r1.flags
            r7.<init>(r8, r9, r11, r13, r14)
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource r5 = r1.cacheWriteDataSource
            if (r5 == 0) goto L_0x009d
            r2 = r5
            goto L_0x0045
        L_0x009d:
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource r5 = r1.upstreamDataSource
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache r6 = r1.cache
            r6.releaseHoleSpan(r0)
            r15 = r5
            r5 = r2
            r2 = r15
        L_0x00a7:
            boolean r0 = r1.currentRequestIgnoresCache
            if (r0 != 0) goto L_0x00b6
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource r0 = r1.upstreamDataSource
            if (r2 != r0) goto L_0x00b6
            long r8 = r1.readPosition
            r10 = 102400(0x19000, double:5.05923E-319)
            long r8 = r8 + r10
            goto L_0x00bb
        L_0x00b6:
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00bb:
            r1.checkCachePosition = r8
            if (r17 == 0) goto L_0x00dc
            boolean r0 = r1.isBypassingCache()
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r0)
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource r0 = r1.upstreamDataSource
            if (r2 != r0) goto L_0x00cb
            goto L_0x0138
        L_0x00cb:
            r1.closeCurrentSource()     // Catch:{ all -> 0x00cf }
            goto L_0x00dc
        L_0x00cf:
            r0 = move-exception
            boolean r2 = r5.isHoleSpan()
            if (r2 == 0) goto L_0x00db
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache r2 = r1.cache
            r2.releaseHoleSpan(r5)
        L_0x00db:
            throw r0
        L_0x00dc:
            if (r5 == 0) goto L_0x00e6
            boolean r0 = r5.isHoleSpan()
            if (r0 == 0) goto L_0x00e6
            r1.currentHoleSpan = r5
        L_0x00e6:
            r1.currentDataSource = r2
            long r5 = r7.length
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x00f0
            r0 = 1
            goto L_0x00f1
        L_0x00f0:
            r0 = 0
        L_0x00f1:
            r1.currentDataSpecLengthUnset = r0
            long r5 = r2.open(r7)
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.ContentMetadataMutations r0 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.ContentMetadataMutations
            r0.<init>()
            boolean r2 = r1.currentDataSpecLengthUnset
            if (r2 == 0) goto L_0x010c
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x010c
            r1.bytesRemaining = r5
            long r2 = r1.readPosition
            long r2 = r2 + r5
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.ContentMetadataInternal.setContentLength(r0, r2)
        L_0x010c:
            boolean r2 = r1.isReadingFromUpstream()
            if (r2 == 0) goto L_0x012b
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource r2 = r1.currentDataSource
            android.net.Uri r2 = r2.getUri()
            r1.actualUri = r2
            android.net.Uri r3 = r1.uri
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0128
            android.net.Uri r2 = r1.actualUri
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.ContentMetadataInternal.setRedirectedUri(r0, r2)
            goto L_0x012b
        L_0x0128:
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.ContentMetadataInternal.removeRedirectedUri(r0)
        L_0x012b:
            boolean r2 = r1.isWritingToCache()
            if (r2 == 0) goto L_0x0138
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache r2 = r1.cache
            java.lang.String r3 = r1.key
            r2.applyContentMetadataMutations(r3, r0)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSource.openNextSource(boolean):void");
    }

    private void setNoBytesRemainingAndMaybeStoreLength() throws IOException {
        this.bytesRemaining = 0;
        if (isWritingToCache()) {
            this.cache.setContentLength(this.key, this.readPosition);
        }
    }

    private int shouldIgnoreCacheForRequest(DataSpec dataSpec) {
        if (this.ignoreCacheOnError && this.seenCacheError) {
            return 0;
        }
        if (!this.ignoreCacheForUnsetLengthRequests || dataSpec.length != -1) {
            return -1;
        }
        return 1;
    }

    public final void close() throws IOException {
        this.uri = null;
        this.actualUri = null;
        notifyBytesRead();
        try {
            closeCurrentSource();
        } catch (IOException e5) {
            handleBeforeThrow(e5);
            throw e5;
        }
    }

    public final Uri getUri() {
        return this.actualUri;
    }

    public final long open(DataSpec dataSpec) throws IOException {
        boolean z4;
        try {
            String key2 = CacheUtil.getKey(dataSpec);
            this.key = key2;
            Uri uri2 = dataSpec.uri;
            this.uri = uri2;
            this.actualUri = getRedirectedUriOrDefault(this.cache, key2, uri2);
            this.flags = dataSpec.flags;
            this.readPosition = dataSpec.position;
            int shouldIgnoreCacheForRequest = shouldIgnoreCacheForRequest(dataSpec);
            if (shouldIgnoreCacheForRequest != -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.currentRequestIgnoresCache = z4;
            if (z4) {
                notifyCacheIgnored(shouldIgnoreCacheForRequest);
            }
            long j5 = dataSpec.length;
            if (j5 == -1) {
                if (!this.currentRequestIgnoresCache) {
                    long contentLength = this.cache.getContentLength(this.key);
                    this.bytesRemaining = contentLength;
                    if (contentLength != -1) {
                        long j6 = contentLength - dataSpec.position;
                        this.bytesRemaining = j6;
                        if (j6 <= 0) {
                            throw new DataSourceException(0);
                        }
                    }
                    openNextSource(false);
                    return this.bytesRemaining;
                }
            }
            this.bytesRemaining = j5;
            openNextSource(false);
            return this.bytesRemaining;
        } catch (IOException e5) {
            handleBeforeThrow(e5);
            throw e5;
        }
    }

    public final int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            if (this.readPosition >= this.checkCachePosition) {
                openNextSource(true);
            }
            int read = this.currentDataSource.read(bArr, i5, i6);
            if (read != -1) {
                if (isReadingFromCache()) {
                    this.totalCachedBytesRead += (long) read;
                }
                long j5 = (long) read;
                this.readPosition += j5;
                long j6 = this.bytesRemaining;
                if (j6 != -1) {
                    this.bytesRemaining = j6 - j5;
                    return read;
                }
            } else if (this.currentDataSpecLengthUnset) {
                setNoBytesRemainingAndMaybeStoreLength();
                return read;
            } else {
                long j7 = this.bytesRemaining;
                if (j7 <= 0) {
                    if (j7 == -1) {
                    }
                }
                closeCurrentSource();
                openNextSource(false);
                return read(bArr, i5, i6);
            }
            return read;
        } catch (IOException e5) {
            if (!this.currentDataSpecLengthUnset || !isCausedByPositionOutOfRange(e5)) {
                handleBeforeThrow(e5);
                throw e5;
            }
            setNoBytesRemainingAndMaybeStoreLength();
            return -1;
        }
    }

    public CacheDataSource(Cache cache2, DataSource dataSource, int i5) {
        this(cache2, dataSource, i5, DEFAULT_MAX_CACHE_FILE_SIZE);
    }

    public CacheDataSource(Cache cache2, DataSource dataSource, int i5, long j5) {
        this(cache2, dataSource, new FileDataSource(), new CacheDataSink(cache2, j5), i5, (EventListener) null);
    }

    public CacheDataSource(Cache cache2, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int i5, @Nullable EventListener eventListener2) {
        this.cache = cache2;
        this.cacheReadDataSource = dataSource2;
        boolean z4 = false;
        this.blockOnCache = (i5 & 1) != 0;
        this.ignoreCacheOnError = (i5 & 2) != 0;
        this.ignoreCacheForUnsetLengthRequests = (i5 & 4) != 0 ? true : z4;
        this.upstreamDataSource = dataSource;
        if (dataSink != null) {
            this.cacheWriteDataSource = new TeeDataSource(dataSource, dataSink);
        } else {
            this.cacheWriteDataSource = null;
        }
        this.eventListener = eventListener2;
    }
}
