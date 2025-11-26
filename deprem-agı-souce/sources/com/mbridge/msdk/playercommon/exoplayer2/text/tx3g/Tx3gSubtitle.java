package com.mbridge.msdk.playercommon.exoplayer2.text.tx3g;

import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Tx3gSubtitle implements Subtitle {
    public static final Tx3gSubtitle EMPTY = new Tx3gSubtitle();
    private final List<Cue> cues;

    public Tx3gSubtitle(Cue cue) {
        this.cues = Collections.singletonList(cue);
    }

    public final List<Cue> getCues(long j5) {
        if (j5 >= 0) {
            return this.cues;
        }
        return Collections.EMPTY_LIST;
    }

    public final long getEventTime(int i5) {
        boolean z4;
        if (i5 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        return 0;
    }

    public final int getEventTimeCount() {
        return 1;
    }

    public final int getNextEventTimeIndex(long j5) {
        return j5 < 0 ? 0 : -1;
    }

    private Tx3gSubtitle() {
        this.cues = Collections.EMPTY_LIST;
    }
}
