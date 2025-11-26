package com.mbridge.msdk.playercommon.exoplayer2.offline;

public final class TrackKey {
    public final int groupIndex;
    public final int periodIndex;
    public final int trackIndex;

    public TrackKey(int i5, int i6, int i7) {
        this.periodIndex = i5;
        this.groupIndex = i6;
        this.trackIndex = i7;
    }
}
