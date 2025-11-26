package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import com.mbridge.msdk.playercommon.exoplayer2.RendererConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public final class TrackSelectorResult {
    public final Object info;
    public final int length;
    public final RendererConfiguration[] rendererConfigurations;
    public final TrackSelectionArray selections;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, TrackSelection[] trackSelectionArr, Object obj) {
        this.rendererConfigurations = rendererConfigurationArr;
        this.selections = new TrackSelectionArray(trackSelectionArr);
        this.info = obj;
        this.length = rendererConfigurationArr.length;
    }

    public final boolean isEquivalent(TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.selections.length != this.selections.length) {
            return false;
        }
        for (int i5 = 0; i5 < this.selections.length; i5++) {
            if (!isEquivalent(trackSelectorResult, i5)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isRendererEnabled(int i5) {
        if (this.rendererConfigurations[i5] != null) {
            return true;
        }
        return false;
    }

    public final boolean isEquivalent(TrackSelectorResult trackSelectorResult, int i5) {
        if (trackSelectorResult != null && Util.areEqual(this.rendererConfigurations[i5], trackSelectorResult.rendererConfigurations[i5]) && Util.areEqual(this.selections.get(i5), trackSelectorResult.selections.get(i5))) {
            return true;
        }
        return false;
    }
}
