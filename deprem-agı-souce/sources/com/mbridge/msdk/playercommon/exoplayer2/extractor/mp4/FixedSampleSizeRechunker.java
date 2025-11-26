package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class FixedSampleSizeRechunker {
    private static final int MAX_SAMPLE_SIZE = 8192;

    public static final class Results {
        public final long duration;
        public final int[] flags;
        public final int maximumSize;
        public final long[] offsets;
        public final int[] sizes;
        public final long[] timestamps;

        private Results(long[] jArr, int[] iArr, int i5, long[] jArr2, int[] iArr2, long j5) {
            this.offsets = jArr;
            this.sizes = iArr;
            this.maximumSize = i5;
            this.timestamps = jArr2;
            this.flags = iArr2;
            this.duration = j5;
        }
    }

    private FixedSampleSizeRechunker() {
    }

    public static Results rechunk(int i5, long[] jArr, int[] iArr, long j5) {
        int[] iArr2 = iArr;
        int i6 = 8192 / i5;
        int i7 = 0;
        for (int ceilDivide : iArr2) {
            i7 += Util.ceilDivide(ceilDivide, i6);
        }
        long[] jArr2 = new long[i7];
        int[] iArr3 = new int[i7];
        long[] jArr3 = new long[i7];
        int[] iArr4 = new int[i7];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            int i12 = iArr2[i11];
            long j6 = jArr[i11];
            while (i12 > 0) {
                int min = Math.min(i6, i12);
                jArr2[i9] = j6;
                int i13 = i5 * min;
                iArr3[i9] = i13;
                i10 = Math.max(i10, i13);
                jArr3[i9] = ((long) i8) * j5;
                iArr4[i9] = 1;
                j6 += (long) iArr3[i9];
                i8 += min;
                i12 -= min;
                i9++;
            }
        }
        return new Results(jArr2, iArr3, i10, jArr3, iArr4, j5 * ((long) i8));
    }
}
