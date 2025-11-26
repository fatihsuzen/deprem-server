package com.mbridge.msdk.playercommon.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class WebvttSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final List<WebvttCue> cues;
    private final int numCues;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(List<WebvttCue> list) {
        this.cues = list;
        int size = list.size();
        this.numCues = size;
        this.cueTimesUs = new long[(size * 2)];
        for (int i5 = 0; i5 < this.numCues; i5++) {
            WebvttCue webvttCue = list.get(i5);
            int i6 = i5 * 2;
            long[] jArr = this.cueTimesUs;
            jArr[i6] = webvttCue.startTime;
            jArr[i6 + 1] = webvttCue.endTime;
        }
        long[] jArr2 = this.cueTimesUs;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.sortedCueTimesUs = copyOf;
        Arrays.sort(copyOf);
    }

    public final List<Cue> getCues(long j5) {
        SpannableStringBuilder spannableStringBuilder = null;
        ArrayList arrayList = null;
        WebvttCue webvttCue = null;
        for (int i5 = 0; i5 < this.numCues; i5++) {
            long[] jArr = this.cueTimesUs;
            int i6 = i5 * 2;
            if (jArr[i6] <= j5 && j5 < jArr[i6 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                WebvttCue webvttCue2 = this.cues.get(i5);
                if (!webvttCue2.isNormalCue()) {
                    arrayList.add(webvttCue2);
                } else if (webvttCue == null) {
                    webvttCue = webvttCue2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(webvttCue.text).append("\n").append(webvttCue2.text);
                } else {
                    spannableStringBuilder.append("\n").append(webvttCue2.text);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new WebvttCue(spannableStringBuilder));
        } else if (webvttCue != null) {
            arrayList.add(webvttCue);
        }
        if (arrayList != null) {
            return arrayList;
        }
        return Collections.EMPTY_LIST;
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
        if (i5 < this.sortedCueTimesUs.length) {
            z5 = true;
        }
        Assertions.checkArgument(z5);
        return this.sortedCueTimesUs[i5];
    }

    public final int getEventTimeCount() {
        return this.sortedCueTimesUs.length;
    }

    public final int getNextEventTimeIndex(long j5) {
        int binarySearchCeil = Util.binarySearchCeil(this.sortedCueTimesUs, j5, false, false);
        if (binarySearchCeil < this.sortedCueTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }
}
