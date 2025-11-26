package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class TtmlSubtitle implements Subtitle {
    private final long[] eventTimesUs;
    private final Map<String, TtmlStyle> globalStyles;
    private final Map<String, TtmlRegion> regionMap;
    private final TtmlNode root;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        Map<String, TtmlStyle> map3;
        this.root = ttmlNode;
        this.regionMap = map2;
        if (map != null) {
            map3 = DesugarCollections.unmodifiableMap(map);
        } else {
            map3 = Collections.EMPTY_MAP;
        }
        this.globalStyles = map3;
        this.eventTimesUs = ttmlNode.getEventTimesUs();
    }

    public final List<Cue> getCues(long j5) {
        return this.root.getCues(j5, this.globalStyles, this.regionMap);
    }

    public final long getEventTime(int i5) {
        return this.eventTimesUs[i5];
    }

    public final int getEventTimeCount() {
        return this.eventTimesUs.length;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, TtmlStyle> getGlobalStyles() {
        return this.globalStyles;
    }

    public final int getNextEventTimeIndex(long j5) {
        int binarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j5, false, false);
        if (binarySearchCeil < this.eventTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final TtmlNode getRoot() {
        return this.root;
    }
}
