package com.mbridge.msdk.thrid.okhttp.internal.http2;

import java.util.Arrays;

public final class Settings {
    static final int COUNT = 10;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    static final int ENABLE_PUSH = 2;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    /* access modifiers changed from: package-private */
    public void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* access modifiers changed from: package-private */
    public int get(int i5) {
        return this.values[i5];
    }

    /* access modifiers changed from: package-private */
    public boolean getEnablePush(boolean z4) {
        int i5;
        if ((this.set & 4) != 0) {
            i5 = this.values[2];
        } else if (z4) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (i5 == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    public int getMaxConcurrentStreams(int i5) {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public int getMaxFrameSize(int i5) {
        if ((this.set & 32) != 0) {
            return this.values[5];
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public int getMaxHeaderListSize(int i5) {
        if ((this.set & 64) != 0) {
            return this.values[6];
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public boolean isSet(int i5) {
        if (((1 << i5) & this.set) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void merge(Settings settings) {
        for (int i5 = 0; i5 < 10; i5++) {
            if (settings.isSet(i5)) {
                set(i5, settings.get(i5));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Settings set(int i5, int i6) {
        if (i5 >= 0) {
            int[] iArr = this.values;
            if (i5 < iArr.length) {
                this.set = (1 << i5) | this.set;
                iArr[i5] = i6;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return Integer.bitCount(this.set);
    }
}
