package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class TrackSampleTable {
    public final long durationUs;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int sampleCount;
    public final int[] sizes;
    public final long[] timestampsUs;
    public final Track track;

    public TrackSampleTable(Track track2, long[] jArr, int[] iArr, int i5, long[] jArr2, int[] iArr2, long j5) {
        boolean z4;
        boolean z5;
        boolean z6 = false;
        if (iArr.length == jArr2.length) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        if (jArr.length == jArr2.length) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkArgument(z5);
        Assertions.checkArgument(iArr2.length == jArr2.length ? true : z6);
        this.track = track2;
        this.offsets = jArr;
        this.sizes = iArr;
        this.maximumSize = i5;
        this.timestampsUs = jArr2;
        this.flags = iArr2;
        this.durationUs = j5;
        this.sampleCount = jArr.length;
    }

    public final int getIndexOfEarlierOrEqualSynchronizationSample(long j5) {
        for (int binarySearchFloor = Util.binarySearchFloor(this.timestampsUs, j5, true, false); binarySearchFloor >= 0; binarySearchFloor--) {
            if ((this.flags[binarySearchFloor] & 1) != 0) {
                return binarySearchFloor;
            }
        }
        return -1;
    }

    public final int getIndexOfLaterOrEqualSynchronizationSample(long j5) {
        for (int binarySearchCeil = Util.binarySearchCeil(this.timestampsUs, j5, true, false); binarySearchCeil < this.timestampsUs.length; binarySearchCeil++) {
            if ((this.flags[binarySearchCeil] & 1) != 0) {
                return binarySearchCeil;
            }
        }
        return -1;
    }
}
