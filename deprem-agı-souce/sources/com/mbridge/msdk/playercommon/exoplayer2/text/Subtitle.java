package com.mbridge.msdk.playercommon.exoplayer2.text;

import java.util.List;

public interface Subtitle {
    List<Cue> getCues(long j5);

    long getEventTime(int i5);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j5);
}
