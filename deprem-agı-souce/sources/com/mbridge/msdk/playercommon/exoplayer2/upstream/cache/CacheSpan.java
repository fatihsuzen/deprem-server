package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;

public class CacheSpan implements Comparable<CacheSpan> {
    @Nullable
    public final File file;
    public final boolean isCached;
    public final String key;
    public final long lastAccessTimestamp;
    public final long length;
    public final long position;

    public CacheSpan(String str, long j5, long j6) {
        this(str, j5, j6, C.TIME_UNSET, (File) null);
    }

    public boolean isHoleSpan() {
        return !this.isCached;
    }

    public boolean isOpenEnded() {
        if (this.length == -1) {
            return true;
        }
        return false;
    }

    public CacheSpan(String str, long j5, long j6, long j7, @Nullable File file2) {
        this.key = str;
        this.position = j5;
        this.length = j6;
        this.isCached = file2 != null;
        this.file = file2;
        this.lastAccessTimestamp = j7;
    }

    public int compareTo(@NonNull CacheSpan cacheSpan) {
        if (!this.key.equals(cacheSpan.key)) {
            return this.key.compareTo(cacheSpan.key);
        }
        int i5 = ((this.position - cacheSpan.position) > 0 ? 1 : ((this.position - cacheSpan.position) == 0 ? 0 : -1));
        if (i5 == 0) {
            return 0;
        }
        return i5 < 0 ? -1 : 1;
    }
}
