package com.mbridge.msdk.playercommon.exoplayer2.util;

import java.util.Arrays;

public final class LongArray {
    private static final int DEFAULT_INITIAL_CAPACITY = 32;
    private int size;
    private long[] values;

    public LongArray() {
        this(32);
    }

    public final void add(long j5) {
        int i5 = this.size;
        long[] jArr = this.values;
        if (i5 == jArr.length) {
            this.values = Arrays.copyOf(jArr, i5 * 2);
        }
        long[] jArr2 = this.values;
        int i6 = this.size;
        this.size = i6 + 1;
        jArr2[i6] = j5;
    }

    public final long get(int i5) {
        if (i5 >= 0 && i5 < this.size) {
            return this.values[i5];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i5 + ", size is " + this.size);
    }

    public final int size() {
        return this.size;
    }

    public final long[] toArray() {
        return Arrays.copyOf(this.values, this.size);
    }

    public LongArray(int i5) {
        this.values = new long[i5];
    }
}
