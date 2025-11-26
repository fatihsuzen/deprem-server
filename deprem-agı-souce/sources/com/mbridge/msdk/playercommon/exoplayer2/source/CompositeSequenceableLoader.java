package com.mbridge.msdk.playercommon.exoplayer2.source;

public class CompositeSequenceableLoader implements SequenceableLoader {
    protected final SequenceableLoader[] loaders;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this.loaders = sequenceableLoaderArr;
    }

    public boolean continueLoading(long j5) {
        boolean z4;
        boolean z5;
        long j6 = j5;
        boolean z6 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return z6;
            }
            z4 = false;
            for (SequenceableLoader sequenceableLoader : this.loaders) {
                long nextLoadPositionUs2 = sequenceableLoader.getNextLoadPositionUs();
                if (nextLoadPositionUs2 == Long.MIN_VALUE || nextLoadPositionUs2 > j6) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (nextLoadPositionUs2 == nextLoadPositionUs || z5) {
                    z4 |= sequenceableLoader.continueLoading(j6);
                }
            }
            z6 |= z4;
        } while (z4);
        return z6;
    }

    public final long getBufferedPositionUs() {
        long j5 = Long.MAX_VALUE;
        for (SequenceableLoader bufferedPositionUs : this.loaders) {
            long bufferedPositionUs2 = bufferedPositionUs.getBufferedPositionUs();
            if (bufferedPositionUs2 != Long.MIN_VALUE) {
                j5 = Math.min(j5, bufferedPositionUs2);
            }
        }
        if (j5 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j5;
    }

    public final long getNextLoadPositionUs() {
        long j5 = Long.MAX_VALUE;
        for (SequenceableLoader nextLoadPositionUs : this.loaders) {
            long nextLoadPositionUs2 = nextLoadPositionUs.getNextLoadPositionUs();
            if (nextLoadPositionUs2 != Long.MIN_VALUE) {
                j5 = Math.min(j5, nextLoadPositionUs2);
            }
        }
        if (j5 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j5;
    }

    public final void reevaluateBuffer(long j5) {
        for (SequenceableLoader reevaluateBuffer : this.loaders) {
            reevaluateBuffer.reevaluateBuffer(j5);
        }
    }
}
