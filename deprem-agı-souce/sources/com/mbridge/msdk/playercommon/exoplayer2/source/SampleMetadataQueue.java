package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class SampleMetadataQueue {
    private static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private int absoluteFirstIndex;
    private int capacity = 1000;
    private TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[1000];
    private int[] flags = new int[1000];
    private Format[] formats = new Format[1000];
    private long largestDiscardedTimestampUs = Long.MIN_VALUE;
    private long largestQueuedTimestampUs = Long.MIN_VALUE;
    private int length;
    private long[] offsets = new long[1000];
    private int readPosition;
    private int relativeFirstIndex;
    private int[] sizes = new int[1000];
    private int[] sourceIds = new int[1000];
    private long[] timesUs = new long[1000];
    private Format upstreamFormat;
    private boolean upstreamFormatRequired = true;
    private boolean upstreamKeyframeRequired = true;
    private int upstreamSourceId;

    public static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;
    }

    private long discardSamples(int i5) {
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i5));
        int i6 = this.length - i5;
        this.length = i6;
        this.absoluteFirstIndex += i5;
        int i7 = this.relativeFirstIndex + i5;
        this.relativeFirstIndex = i7;
        int i8 = this.capacity;
        if (i7 >= i8) {
            this.relativeFirstIndex = i7 - i8;
        }
        int i9 = this.readPosition - i5;
        this.readPosition = i9;
        if (i9 < 0) {
            this.readPosition = 0;
        }
        if (i6 != 0) {
            return this.offsets[this.relativeFirstIndex];
        }
        int i10 = this.relativeFirstIndex;
        if (i10 != 0) {
            i8 = i10;
        }
        int i11 = i8 - 1;
        return this.offsets[i11] + ((long) this.sizes[i11]);
    }

    private int findSampleBefore(int i5, int i6, long j5, boolean z4) {
        int i7 = -1;
        for (int i8 = 0; i8 < i6 && this.timesUs[i5] <= j5; i8++) {
            if (!z4 || (this.flags[i5] & 1) != 0) {
                i7 = i8;
            }
            i5++;
            if (i5 == this.capacity) {
                i5 = 0;
            }
        }
        return i7;
    }

    private long getLargestTimestamp(int i5) {
        long j5 = Long.MIN_VALUE;
        if (i5 == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(i5 - 1);
        for (int i6 = 0; i6 < i5; i6++) {
            j5 = Math.max(j5, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                return j5;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return j5;
    }

    private int getRelativeIndex(int i5) {
        int i6 = this.relativeFirstIndex + i5;
        int i7 = this.capacity;
        if (i6 < i7) {
            return i6;
        }
        return i6 - i7;
    }

    public final synchronized int advanceTo(long j5, boolean z4, boolean z5) {
        try {
            int relativeIndex = getRelativeIndex(this.readPosition);
            if (!hasNextSample() || j5 < this.timesUs[relativeIndex] || (j5 > this.largestQueuedTimestampUs && !z5)) {
                return -1;
            }
            try {
                int findSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j5, z4);
                if (findSampleBefore == -1) {
                    return -1;
                }
                this.readPosition += findSampleBefore;
                return findSampleBefore;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized int advanceToEnd() {
        int i5;
        int i6 = this.length;
        i5 = i6 - this.readPosition;
        this.readPosition = i6;
        return i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean attemptSplice(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.length     // Catch:{ all -> 0x0010 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0012
            long r3 = r7.largestDiscardedTimestampUs     // Catch:{ all -> 0x0010 }
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 <= 0) goto L_0x000e
            r1 = r2
        L_0x000e:
            monitor-exit(r7)
            return r1
        L_0x0010:
            r8 = move-exception
            goto L_0x004b
        L_0x0012:
            long r3 = r7.largestDiscardedTimestampUs     // Catch:{ all -> 0x0010 }
            int r0 = r7.readPosition     // Catch:{ all -> 0x0010 }
            long r5 = r7.getLargestTimestamp(r0)     // Catch:{ all -> 0x0010 }
            long r3 = java.lang.Math.max(r3, r5)     // Catch:{ all -> 0x0010 }
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0024
            monitor-exit(r7)
            return r1
        L_0x0024:
            int r0 = r7.length     // Catch:{ all -> 0x0010 }
            int r1 = r0 + -1
            int r1 = r7.getRelativeIndex(r1)     // Catch:{ all -> 0x0010 }
        L_0x002c:
            int r3 = r7.readPosition     // Catch:{ all -> 0x0010 }
            if (r0 <= r3) goto L_0x0043
            long[] r3 = r7.timesUs     // Catch:{ all -> 0x0010 }
            r4 = r3[r1]     // Catch:{ all -> 0x0010 }
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0043
            int r0 = r0 + -1
            int r1 = r1 + -1
            r3 = -1
            if (r1 != r3) goto L_0x002c
            int r1 = r7.capacity     // Catch:{ all -> 0x0010 }
            int r1 = r1 - r2
            goto L_0x002c
        L_0x0043:
            int r8 = r7.absoluteFirstIndex     // Catch:{ all -> 0x0010 }
            int r8 = r8 + r0
            r7.discardUpstreamSamples(r8)     // Catch:{ all -> 0x0010 }
            monitor-exit(r7)
            return r2
        L_0x004b:
            monitor-exit(r7)     // Catch:{ all -> 0x0010 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue.attemptSplice(long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void commitSample(long r6, int r8, long r9, int r11, com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput.CryptoData r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.upstreamKeyframeRequired     // Catch:{ all -> 0x000f }
            r1 = 0
            if (r0 == 0) goto L_0x0012
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.upstreamKeyframeRequired = r1     // Catch:{ all -> 0x000f }
            goto L_0x0012
        L_0x000f:
            r6 = move-exception
            goto L_0x00c9
        L_0x0012:
            boolean r0 = r5.upstreamFormatRequired     // Catch:{ all -> 0x000f }
            r0 = r0 ^ 1
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r0)     // Catch:{ all -> 0x000f }
            r5.commitSampleTimestamp(r6)     // Catch:{ all -> 0x000f }
            int r0 = r5.length     // Catch:{ all -> 0x000f }
            int r0 = r5.getRelativeIndex(r0)     // Catch:{ all -> 0x000f }
            long[] r2 = r5.timesUs     // Catch:{ all -> 0x000f }
            r2[r0] = r6     // Catch:{ all -> 0x000f }
            long[] r6 = r5.offsets     // Catch:{ all -> 0x000f }
            r6[r0] = r9     // Catch:{ all -> 0x000f }
            int[] r7 = r5.sizes     // Catch:{ all -> 0x000f }
            r7[r0] = r11     // Catch:{ all -> 0x000f }
            int[] r7 = r5.flags     // Catch:{ all -> 0x000f }
            r7[r0] = r8     // Catch:{ all -> 0x000f }
            com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput$CryptoData[] r7 = r5.cryptoDatas     // Catch:{ all -> 0x000f }
            r7[r0] = r12     // Catch:{ all -> 0x000f }
            com.mbridge.msdk.playercommon.exoplayer2.Format[] r7 = r5.formats     // Catch:{ all -> 0x000f }
            com.mbridge.msdk.playercommon.exoplayer2.Format r8 = r5.upstreamFormat     // Catch:{ all -> 0x000f }
            r7[r0] = r8     // Catch:{ all -> 0x000f }
            int[] r7 = r5.sourceIds     // Catch:{ all -> 0x000f }
            int r8 = r5.upstreamSourceId     // Catch:{ all -> 0x000f }
            r7[r0] = r8     // Catch:{ all -> 0x000f }
            int r7 = r5.length     // Catch:{ all -> 0x000f }
            int r7 = r7 + 1
            r5.length = r7     // Catch:{ all -> 0x000f }
            int r8 = r5.capacity     // Catch:{ all -> 0x000f }
            if (r7 != r8) goto L_0x00c7
            int r7 = r8 + 1000
            int[] r9 = new int[r7]     // Catch:{ all -> 0x000f }
            long[] r10 = new long[r7]     // Catch:{ all -> 0x000f }
            long[] r11 = new long[r7]     // Catch:{ all -> 0x000f }
            int[] r12 = new int[r7]     // Catch:{ all -> 0x000f }
            int[] r0 = new int[r7]     // Catch:{ all -> 0x000f }
            com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput$CryptoData[] r2 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput.CryptoData[r7]     // Catch:{ all -> 0x000f }
            com.mbridge.msdk.playercommon.exoplayer2.Format[] r3 = new com.mbridge.msdk.playercommon.exoplayer2.Format[r7]     // Catch:{ all -> 0x000f }
            int r4 = r5.relativeFirstIndex     // Catch:{ all -> 0x000f }
            int r8 = r8 - r4
            java.lang.System.arraycopy(r6, r4, r10, r1, r8)     // Catch:{ all -> 0x000f }
            long[] r6 = r5.timesUs     // Catch:{ all -> 0x000f }
            int r4 = r5.relativeFirstIndex     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r6, r4, r11, r1, r8)     // Catch:{ all -> 0x000f }
            int[] r6 = r5.flags     // Catch:{ all -> 0x000f }
            int r4 = r5.relativeFirstIndex     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r6, r4, r12, r1, r8)     // Catch:{ all -> 0x000f }
            int[] r6 = r5.sizes     // Catch:{ all -> 0x000f }
            int r4 = r5.relativeFirstIndex     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r6, r4, r0, r1, r8)     // Catch:{ all -> 0x000f }
            com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput$CryptoData[] r6 = r5.cryptoDatas     // Catch:{ all -> 0x000f }
            int r4 = r5.relativeFirstIndex     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r6, r4, r2, r1, r8)     // Catch:{ all -> 0x000f }
            com.mbridge.msdk.playercommon.exoplayer2.Format[] r6 = r5.formats     // Catch:{ all -> 0x000f }
            int r4 = r5.relativeFirstIndex     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r6, r4, r3, r1, r8)     // Catch:{ all -> 0x000f }
            int[] r6 = r5.sourceIds     // Catch:{ all -> 0x000f }
            int r4 = r5.relativeFirstIndex     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r6, r4, r9, r1, r8)     // Catch:{ all -> 0x000f }
            int r6 = r5.relativeFirstIndex     // Catch:{ all -> 0x000f }
            long[] r4 = r5.offsets     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r4, r1, r10, r8, r6)     // Catch:{ all -> 0x000f }
            long[] r4 = r5.timesUs     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r4, r1, r11, r8, r6)     // Catch:{ all -> 0x000f }
            int[] r4 = r5.flags     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r4, r1, r12, r8, r6)     // Catch:{ all -> 0x000f }
            int[] r4 = r5.sizes     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r4, r1, r0, r8, r6)     // Catch:{ all -> 0x000f }
            com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput$CryptoData[] r4 = r5.cryptoDatas     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r4, r1, r2, r8, r6)     // Catch:{ all -> 0x000f }
            com.mbridge.msdk.playercommon.exoplayer2.Format[] r4 = r5.formats     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r4, r1, r3, r8, r6)     // Catch:{ all -> 0x000f }
            int[] r4 = r5.sourceIds     // Catch:{ all -> 0x000f }
            java.lang.System.arraycopy(r4, r1, r9, r8, r6)     // Catch:{ all -> 0x000f }
            r5.offsets = r10     // Catch:{ all -> 0x000f }
            r5.timesUs = r11     // Catch:{ all -> 0x000f }
            r5.flags = r12     // Catch:{ all -> 0x000f }
            r5.sizes = r0     // Catch:{ all -> 0x000f }
            r5.cryptoDatas = r2     // Catch:{ all -> 0x000f }
            r5.formats = r3     // Catch:{ all -> 0x000f }
            r5.sourceIds = r9     // Catch:{ all -> 0x000f }
            r5.relativeFirstIndex = r1     // Catch:{ all -> 0x000f }
            int r6 = r5.capacity     // Catch:{ all -> 0x000f }
            r5.length = r6     // Catch:{ all -> 0x000f }
            r5.capacity = r7     // Catch:{ all -> 0x000f }
        L_0x00c7:
            monitor-exit(r5)
            return
        L_0x00c9:
            monitor-exit(r5)     // Catch:{ all -> 0x000f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue.commitSample(long, int, long, int, com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput$CryptoData):void");
    }

    public final synchronized void commitSampleTimestamp(long j5) {
        this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j5);
    }

    public final synchronized long discardTo(long j5, boolean z4, boolean z5) {
        Throwable th;
        try {
            int i5 = this.length;
            if (i5 != 0) {
                long[] jArr = this.timesUs;
                int i6 = this.relativeFirstIndex;
                if (j5 >= jArr[i6]) {
                    if (z5) {
                        try {
                            int i7 = this.readPosition;
                            if (i7 != i5) {
                                i5 = i7 + 1;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    try {
                        int findSampleBefore = findSampleBefore(i6, i5, j5, z4);
                        if (findSampleBefore == -1) {
                            return -1;
                        }
                        return discardSamples(findSampleBefore);
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
            }
            return -1;
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized long discardToEnd() {
        int i5 = this.length;
        if (i5 == 0) {
            return -1;
        }
        return discardSamples(i5);
    }

    public final synchronized long discardToRead() {
        int i5 = this.readPosition;
        if (i5 == 0) {
            return -1;
        }
        return discardSamples(i5);
    }

    public final long discardUpstreamSamples(int i5) {
        boolean z4;
        int writeIndex = getWriteIndex() - i5;
        if (writeIndex < 0 || writeIndex > this.length - this.readPosition) {
            z4 = false;
        } else {
            z4 = true;
        }
        Assertions.checkArgument(z4);
        int i6 = this.length - writeIndex;
        this.length = i6;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i6));
        int i7 = this.length;
        if (i7 == 0) {
            return 0;
        }
        int relativeIndex = getRelativeIndex(i7 - 1);
        return this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]);
    }

    public final synchronized boolean format(Format format) {
        if (format == null) {
            this.upstreamFormatRequired = true;
            return false;
        }
        this.upstreamFormatRequired = false;
        if (Util.areEqual(format, this.upstreamFormat)) {
            return false;
        }
        this.upstreamFormat = format;
        return true;
    }

    public final int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public final synchronized long getFirstTimestampUs() {
        long j5;
        if (this.length == 0) {
            j5 = Long.MIN_VALUE;
        } else {
            j5 = this.timesUs[this.relativeFirstIndex];
        }
        return j5;
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public final int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    public final synchronized Format getUpstreamFormat() {
        Format format;
        if (this.upstreamFormatRequired) {
            format = null;
        } else {
            format = this.upstreamFormat;
        }
        return format;
    }

    public final int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public final synchronized boolean hasNextSample() {
        boolean z4;
        if (this.readPosition != this.length) {
            z4 = true;
        } else {
            z4 = false;
        }
        return z4;
    }

    public final int peekSourceId() {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample()) {
            return this.sourceIds[relativeIndex];
        }
        return this.upstreamSourceId;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int read(com.mbridge.msdk.playercommon.exoplayer2.FormatHolder r5, com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer r6, boolean r7, boolean r8, com.mbridge.msdk.playercommon.exoplayer2.Format r9, com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue.SampleExtrasHolder r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.hasNextSample()     // Catch:{ all -> 0x0012 }
            r1 = -3
            r2 = -5
            r3 = -4
            if (r0 != 0) goto L_0x0022
            if (r8 == 0) goto L_0x0014
            r5 = 4
            r6.setFlags(r5)     // Catch:{ all -> 0x0012 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            r5 = move-exception
            goto L_0x0068
        L_0x0014:
            com.mbridge.msdk.playercommon.exoplayer2.Format r6 = r4.upstreamFormat     // Catch:{ all -> 0x0012 }
            if (r6 == 0) goto L_0x0020
            if (r7 != 0) goto L_0x001c
            if (r6 == r9) goto L_0x0020
        L_0x001c:
            r5.format = r6     // Catch:{ all -> 0x0012 }
            monitor-exit(r4)
            return r2
        L_0x0020:
            monitor-exit(r4)
            return r1
        L_0x0022:
            int r8 = r4.readPosition     // Catch:{ all -> 0x0012 }
            int r8 = r4.getRelativeIndex(r8)     // Catch:{ all -> 0x0012 }
            if (r7 != 0) goto L_0x0060
            com.mbridge.msdk.playercommon.exoplayer2.Format[] r7 = r4.formats     // Catch:{ all -> 0x0012 }
            r7 = r7[r8]     // Catch:{ all -> 0x0012 }
            if (r7 == r9) goto L_0x0031
            goto L_0x0060
        L_0x0031:
            boolean r5 = r6.isFlagsOnly()     // Catch:{ all -> 0x0012 }
            if (r5 == 0) goto L_0x0039
            monitor-exit(r4)
            return r1
        L_0x0039:
            long[] r5 = r4.timesUs     // Catch:{ all -> 0x0012 }
            r0 = r5[r8]     // Catch:{ all -> 0x0012 }
            r6.timeUs = r0     // Catch:{ all -> 0x0012 }
            int[] r5 = r4.flags     // Catch:{ all -> 0x0012 }
            r5 = r5[r8]     // Catch:{ all -> 0x0012 }
            r6.setFlags(r5)     // Catch:{ all -> 0x0012 }
            int[] r5 = r4.sizes     // Catch:{ all -> 0x0012 }
            r5 = r5[r8]     // Catch:{ all -> 0x0012 }
            r10.size = r5     // Catch:{ all -> 0x0012 }
            long[] r5 = r4.offsets     // Catch:{ all -> 0x0012 }
            r6 = r5[r8]     // Catch:{ all -> 0x0012 }
            r10.offset = r6     // Catch:{ all -> 0x0012 }
            com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput$CryptoData[] r5 = r4.cryptoDatas     // Catch:{ all -> 0x0012 }
            r5 = r5[r8]     // Catch:{ all -> 0x0012 }
            r10.cryptoData = r5     // Catch:{ all -> 0x0012 }
            int r5 = r4.readPosition     // Catch:{ all -> 0x0012 }
            int r5 = r5 + 1
            r4.readPosition = r5     // Catch:{ all -> 0x0012 }
            monitor-exit(r4)
            return r3
        L_0x0060:
            com.mbridge.msdk.playercommon.exoplayer2.Format[] r6 = r4.formats     // Catch:{ all -> 0x0012 }
            r6 = r6[r8]     // Catch:{ all -> 0x0012 }
            r5.format = r6     // Catch:{ all -> 0x0012 }
            monitor-exit(r4)
            return r2
        L_0x0068:
            monitor-exit(r4)     // Catch:{ all -> 0x0012 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue.read(com.mbridge.msdk.playercommon.exoplayer2.FormatHolder, com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer, boolean, boolean, com.mbridge.msdk.playercommon.exoplayer2.Format, com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue$SampleExtrasHolder):int");
    }

    public final void reset(boolean z4) {
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        if (z4) {
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    public final synchronized void rewind() {
        this.readPosition = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean setReadPosition(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.absoluteFirstIndex     // Catch:{ all -> 0x0010 }
            if (r0 > r3) goto L_0x0012
            int r1 = r2.length     // Catch:{ all -> 0x0010 }
            int r1 = r1 + r0
            if (r3 > r1) goto L_0x0012
            int r3 = r3 - r0
            r2.readPosition = r3     // Catch:{ all -> 0x0010 }
            monitor-exit(r2)
            r3 = 1
            return r3
        L_0x0010:
            r3 = move-exception
            goto L_0x0015
        L_0x0012:
            monitor-exit(r2)
            r3 = 0
            return r3
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x0010 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue.setReadPosition(int):boolean");
    }

    public final void sourceId(int i5) {
        this.upstreamSourceId = i5;
    }
}
