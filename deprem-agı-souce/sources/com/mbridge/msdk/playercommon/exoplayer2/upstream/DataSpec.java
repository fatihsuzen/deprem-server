package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public final class DataSpec {
    public static final int FLAG_ALLOW_CACHING_UNKNOWN_LENGTH = 2;
    public static final int FLAG_ALLOW_GZIP = 1;
    public final long absoluteStreamPosition;
    public final int flags;
    @Nullable
    public final String key;
    public final long length;
    public final long position;
    @Nullable
    public final byte[] postBody;
    public final Uri uri;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DataSpec(Uri uri2) {
        this(uri2, 0);
    }

    public final boolean isFlagSet(int i5) {
        if ((this.flags & i5) == i5) {
            return true;
        }
        return false;
    }

    public final DataSpec subrange(long j5) {
        long j6 = this.length;
        long j7 = -1;
        if (j6 != -1) {
            j7 = j6 - j5;
        }
        return subrange(j5, j7);
    }

    public final String toString() {
        return "DataSpec[" + this.uri + ", " + Arrays.toString(this.postBody) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    }

    public final DataSpec withUri(Uri uri2) {
        return new DataSpec(uri2, this.postBody, this.absoluteStreamPosition, this.position, this.length, this.key, this.flags);
    }

    public DataSpec(Uri uri2, int i5) {
        this(uri2, 0, -1, (String) null, i5);
    }

    public final DataSpec subrange(long j5, long j6) {
        if (j5 == 0 && this.length == j6) {
            return this;
        }
        return new DataSpec(this.uri, this.postBody, this.absoluteStreamPosition + j5, this.position + j5, j6, this.key, this.flags);
    }

    public DataSpec(Uri uri2, long j5, long j6, @Nullable String str) {
        this(uri2, j5, j5, j6, str, 0);
    }

    public DataSpec(Uri uri2, long j5, long j6, @Nullable String str, int i5) {
        this(uri2, j5, j5, j6, str, i5);
    }

    public DataSpec(Uri uri2, long j5, long j6, long j7, @Nullable String str, int i5) {
        this(uri2, (byte[]) null, j5, j6, j7, str, i5);
    }

    public DataSpec(Uri uri2, @Nullable byte[] bArr, long j5, long j6, long j7, @Nullable String str, int i5) {
        boolean z4 = false;
        Assertions.checkArgument(j5 >= 0);
        Assertions.checkArgument(j6 >= 0);
        Assertions.checkArgument((j7 > 0 || j7 == -1) ? true : z4);
        this.uri = uri2;
        this.postBody = bArr;
        this.absoluteStreamPosition = j5;
        this.position = j6;
        this.length = j7;
        this.key = str;
        this.flags = i5;
    }
}
