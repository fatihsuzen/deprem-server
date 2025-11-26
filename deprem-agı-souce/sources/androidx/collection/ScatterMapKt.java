package androidx.collection;

import W2.s;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap mutableScatterMap = EmptyScatterMap;
        t.c(mutableScatterMap, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return mutableScatterMap;
    }

    public static final int get(long j5) {
        return Long.numberOfTrailingZeros(j5) >> 3;
    }

    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    public static /* synthetic */ void getSentinel$annotations() {
    }

    public static final long group(long[] jArr, int i5) {
        t.e(jArr, TtmlNode.TAG_METADATA);
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        return (((-((long) i7)) >> 63) & (jArr[i6 + 1] << (64 - i7))) | (jArr[i6] >>> i7);
    }

    public static final int h1(int i5) {
        return i5 >>> 7;
    }

    public static final int h2(int i5) {
        return i5 & 127;
    }

    public static final boolean hasNext(long j5) {
        return j5 != 0;
    }

    public static final int hash(Object obj) {
        int i5;
        if (obj != null) {
            i5 = obj.hashCode();
        } else {
            i5 = 0;
        }
        int i6 = i5 * MurmurHashC1;
        return i6 ^ (i6 << 16);
    }

    public static final boolean isDeleted(long[] jArr, int i5) {
        t.e(jArr, TtmlNode.TAG_METADATA);
        if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) == 254) {
            return true;
        }
        return false;
    }

    public static final boolean isEmpty(long[] jArr, int i5) {
        t.e(jArr, TtmlNode.TAG_METADATA);
        if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) == 128) {
            return true;
        }
        return false;
    }

    public static final boolean isFull(long j5) {
        return j5 < 128;
    }

    public static final int loadedCapacity(int i5) {
        if (i5 == 7) {
            return 6;
        }
        return i5 - (i5 / 8);
    }

    public static final int lowestBitSet(long j5) {
        return Long.numberOfTrailingZeros(j5) >> 3;
    }

    public static final long maskEmpty(long j5) {
        return j5 & ((~j5) << 6) & -9187201950435737472L;
    }

    public static final long maskEmptyOrDeleted(long j5) {
        return j5 & ((~j5) << 7) & -9187201950435737472L;
    }

    public static final long match(long j5, int i5) {
        long j6 = j5 ^ (((long) i5) * BitmaskLsb);
        return (~j6) & (j6 - BitmaskLsb) & -9187201950435737472L;
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, (C2633k) null);
    }

    public static final long next(long j5) {
        return j5 & (j5 - 1);
    }

    public static final int nextCapacity(int i5) {
        if (i5 == 0) {
            return 6;
        }
        return (i5 * 2) + 1;
    }

    public static final int normalizeCapacity(int i5) {
        if (i5 > 0) {
            return -1 >>> Integer.numberOfLeadingZeros(i5);
        }
        return 0;
    }

    public static final long readRawMetadata(long[] jArr, int i5) {
        t.e(jArr, DataSchemeDataSource.SCHEME_DATA);
        return (jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255;
    }

    public static final int unloadedCapacity(int i5) {
        if (i5 == 7) {
            return 8;
        }
        return i5 + ((i5 - 1) / 7);
    }

    public static final void writeRawMetadata(long[] jArr, int i5, long j5) {
        t.e(jArr, DataSchemeDataSource.SCHEME_DATA);
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        jArr[i6] = (j5 << i7) | (jArr[i6] & (~(255 << i7)));
    }

    public static final boolean isFull(long[] jArr, int i5) {
        t.e(jArr, TtmlNode.TAG_METADATA);
        return ((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128;
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(s... sVarArr) {
        t.e(sVarArr, "pairs");
        MutableScatterMap<K, V> mutableScatterMap = new MutableScatterMap<>(sVarArr.length);
        mutableScatterMap.putAll(sVarArr);
        return mutableScatterMap;
    }
}
