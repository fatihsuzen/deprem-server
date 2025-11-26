package com.mbridge.msdk.playercommon.exoplayer2.source;

public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void onContinueLoadingRequested(T t5);
    }

    boolean continueLoading(long j5);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    void reevaluateBuffer(long j5);
}
