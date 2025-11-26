package com.mbridge.msdk.playercommon.exoplayer2.text;

import com.mbridge.msdk.playercommon.exoplayer2.decoder.OutputBuffer;
import java.util.List;

public abstract class SubtitleOutputBuffer extends OutputBuffer implements Subtitle {
    private long subsampleOffsetUs;
    private Subtitle subtitle;

    public void clear() {
        super.clear();
        this.subtitle = null;
    }

    public List<Cue> getCues(long j5) {
        return this.subtitle.getCues(j5 - this.subsampleOffsetUs);
    }

    public long getEventTime(int i5) {
        return this.subtitle.getEventTime(i5) + this.subsampleOffsetUs;
    }

    public int getEventTimeCount() {
        return this.subtitle.getEventTimeCount();
    }

    public int getNextEventTimeIndex(long j5) {
        return this.subtitle.getNextEventTimeIndex(j5 - this.subsampleOffsetUs);
    }

    public abstract void release();

    public void setContent(long j5, Subtitle subtitle2, long j6) {
        this.timeUs = j5;
        this.subtitle = subtitle2;
        if (j6 != Long.MAX_VALUE) {
            j5 = j6;
        }
        this.subsampleOffsetUs = j5;
    }
}
