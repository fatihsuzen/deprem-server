package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class TrackSelectionArray {
    private int hashCode;
    public final int length;
    private final TrackSelection[] trackSelections;

    public TrackSelectionArray(TrackSelection... trackSelectionArr) {
        this.trackSelections = trackSelectionArr;
        this.length = trackSelectionArr.length;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionArray.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.trackSelections, ((TrackSelectionArray) obj).trackSelections);
    }

    @Nullable
    public final TrackSelection get(int i5) {
        return this.trackSelections[i5];
    }

    public final TrackSelection[] getAll() {
        return (TrackSelection[]) this.trackSelections.clone();
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 527 + Arrays.hashCode(this.trackSelections);
        }
        return this.hashCode;
    }
}
