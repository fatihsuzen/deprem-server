package com.mbridge.msdk.playercommon.exoplayer2.text.ssa;

import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SsaSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final Cue[] cues;

    public SsaSubtitle(Cue[] cueArr, long[] jArr) {
        this.cues = cueArr;
        this.cueTimesUs = jArr;
    }

    public final List<Cue> getCues(long j5) {
        Cue cue;
        int binarySearchFloor = Util.binarySearchFloor(this.cueTimesUs, j5, true, false);
        if (binarySearchFloor == -1 || (cue = this.cues[binarySearchFloor]) == null) {
            return Collections.EMPTY_LIST;
        }
        return Collections.singletonList(cue);
    }

    public final long getEventTime(int i5) {
        boolean z4;
        boolean z5 = false;
        if (i5 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        if (i5 < this.cueTimesUs.length) {
            z5 = true;
        }
        Assertions.checkArgument(z5);
        return this.cueTimesUs[i5];
    }

    public final int getEventTimeCount() {
        return this.cueTimesUs.length;
    }

    public final int getNextEventTimeIndex(long j5) {
        int binarySearchCeil = Util.binarySearchCeil(this.cueTimesUs, j5, false, false);
        if (binarySearchCeil < this.cueTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }
}
