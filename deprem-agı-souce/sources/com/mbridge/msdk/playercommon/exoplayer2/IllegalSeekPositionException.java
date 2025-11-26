package com.mbridge.msdk.playercommon.exoplayer2;

public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final Timeline timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(Timeline timeline2, int i5, long j5) {
        this.timeline = timeline2;
        this.windowIndex = i5;
        this.positionMs = j5;
    }
}
