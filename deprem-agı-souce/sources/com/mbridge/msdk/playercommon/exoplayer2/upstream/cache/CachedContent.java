package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.TreeSet;

final class CachedContent {
    private static final int VERSION_MAX = Integer.MAX_VALUE;
    private static final int VERSION_METADATA_INTRODUCED = 2;
    private final TreeSet<SimpleCacheSpan> cachedSpans = new TreeSet<>();
    public final int id;
    public final String key;
    private boolean locked;
    private DefaultContentMetadata metadata = DefaultContentMetadata.EMPTY;

    public CachedContent(int i5, String str) {
        this.id = i5;
        this.key = str;
    }

    public static CachedContent readFromStream(int i5, DataInputStream dataInputStream) throws IOException {
        CachedContent cachedContent = new CachedContent(dataInputStream.readInt(), dataInputStream.readUTF());
        if (i5 < 2) {
            long readLong = dataInputStream.readLong();
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataInternal.setContentLength(contentMetadataMutations, readLong);
            cachedContent.applyMetadataMutations(contentMetadataMutations);
            return cachedContent;
        }
        cachedContent.metadata = DefaultContentMetadata.readFromStream(dataInputStream);
        return cachedContent;
    }

    public final void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.cachedSpans.add(simpleCacheSpan);
    }

    public final boolean applyMetadataMutations(ContentMetadataMutations contentMetadataMutations) {
        DefaultContentMetadata defaultContentMetadata = this.metadata;
        DefaultContentMetadata copyWithMutationsApplied = defaultContentMetadata.copyWithMutationsApplied(contentMetadataMutations);
        this.metadata = copyWithMutationsApplied;
        return !copyWithMutationsApplied.equals(defaultContentMetadata);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CachedContent.class == obj.getClass()) {
            CachedContent cachedContent = (CachedContent) obj;
            if (this.id != cachedContent.id || !this.key.equals(cachedContent.key) || !this.cachedSpans.equals(cachedContent.cachedSpans) || !this.metadata.equals(cachedContent.metadata)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final long getCachedBytesLength(long j5, long j6) {
        long j7;
        SimpleCacheSpan span = getSpan(j5);
        if (span.isHoleSpan()) {
            if (span.isOpenEnded()) {
                j7 = Long.MAX_VALUE;
            } else {
                j7 = span.length;
            }
            return -Math.min(j7, j6);
        }
        long j8 = j5 + j6;
        long j9 = span.position + span.length;
        if (j9 < j8) {
            for (SimpleCacheSpan next : this.cachedSpans.tailSet(span, false)) {
                long j10 = next.position;
                if (j10 <= j9) {
                    j9 = Math.max(j9, j10 + next.length);
                    if (j9 >= j8) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return Math.min(j9 - j5, j6);
    }

    public final ContentMetadata getMetadata() {
        return this.metadata;
    }

    public final SimpleCacheSpan getSpan(long j5) {
        SimpleCacheSpan createLookup = SimpleCacheSpan.createLookup(this.key, j5);
        SimpleCacheSpan floor = this.cachedSpans.floor(createLookup);
        if (floor != null && floor.position + floor.length > j5) {
            return floor;
        }
        SimpleCacheSpan ceiling = this.cachedSpans.ceiling(createLookup);
        if (ceiling == null) {
            return SimpleCacheSpan.createOpenHole(this.key, j5);
        }
        return SimpleCacheSpan.createClosedHole(this.key, j5, ceiling.position - j5);
    }

    public final TreeSet<SimpleCacheSpan> getSpans() {
        return this.cachedSpans;
    }

    public final int hashCode() {
        return (headerHashCode(Integer.MAX_VALUE) * 31) + this.cachedSpans.hashCode();
    }

    public final int headerHashCode(int i5) {
        int i6;
        int hashCode;
        int hashCode2 = (this.id * 31) + this.key.hashCode();
        if (i5 < 2) {
            long contentLength = ContentMetadataInternal.getContentLength(this.metadata);
            i6 = hashCode2 * 31;
            hashCode = (int) (contentLength ^ (contentLength >>> 32));
        } else {
            i6 = hashCode2 * 31;
            hashCode = this.metadata.hashCode();
        }
        return i6 + hashCode;
    }

    public final boolean isEmpty() {
        return this.cachedSpans.isEmpty();
    }

    public final boolean isLocked() {
        return this.locked;
    }

    public final boolean removeSpan(CacheSpan cacheSpan) {
        if (!this.cachedSpans.remove(cacheSpan)) {
            return false;
        }
        cacheSpan.file.delete();
        return true;
    }

    public final void setLocked(boolean z4) {
        this.locked = z4;
    }

    public final SimpleCacheSpan touch(SimpleCacheSpan simpleCacheSpan) throws Cache.CacheException {
        Assertions.checkState(this.cachedSpans.remove(simpleCacheSpan));
        SimpleCacheSpan copyWithUpdatedLastAccessTime = simpleCacheSpan.copyWithUpdatedLastAccessTime(this.id);
        if (simpleCacheSpan.file.renameTo(copyWithUpdatedLastAccessTime.file)) {
            this.cachedSpans.add(copyWithUpdatedLastAccessTime);
            return copyWithUpdatedLastAccessTime;
        }
        throw new Cache.CacheException("Renaming of " + simpleCacheSpan.file + " to " + copyWithUpdatedLastAccessTime.file + " failed.");
    }

    public final void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.id);
        dataOutputStream.writeUTF(this.key);
        this.metadata.writeToStream(dataOutputStream);
    }
}
