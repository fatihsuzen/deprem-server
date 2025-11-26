package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DummyTrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleQueue;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkExtractorWrapper;

public final class BaseMediaChunkOutput implements ChunkExtractorWrapper.TrackOutputProvider {
    private static final String TAG = "BaseMediaChunkOutput";
    private final SampleQueue[] sampleQueues;
    private final int[] trackTypes;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.trackTypes = iArr;
        this.sampleQueues = sampleQueueArr;
    }

    public final int[] getWriteIndices() {
        int[] iArr = new int[this.sampleQueues.length];
        int i5 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            if (i5 >= sampleQueueArr.length) {
                return iArr;
            }
            SampleQueue sampleQueue = sampleQueueArr[i5];
            if (sampleQueue != null) {
                iArr[i5] = sampleQueue.getWriteIndex();
            }
            i5++;
        }
    }

    public final void setSampleOffsetUs(long j5) {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            if (sampleQueue != null) {
                sampleQueue.setSampleOffsetUs(j5);
            }
        }
    }

    public final TrackOutput track(int i5, int i6) {
        int i7 = 0;
        while (true) {
            int[] iArr = this.trackTypes;
            if (i7 >= iArr.length) {
                Log.e(TAG, "Unmatched track of type: " + i6);
                return new DummyTrackOutput();
            } else if (i6 == iArr[i7]) {
                return this.sampleQueues[i7];
            } else {
                i7++;
            }
        }
    }
}
