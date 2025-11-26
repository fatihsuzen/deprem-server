package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public final class FixedTrackSelection extends BaseTrackSelection {
    @Nullable
    private final Object data;
    private final int reason;

    public static final class Factory implements TrackSelection.Factory {
        @Nullable
        private final Object data;
        private final int reason;

        public Factory() {
            this.reason = 0;
            this.data = null;
        }

        public final FixedTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            boolean z4 = true;
            if (iArr.length != 1) {
                z4 = false;
            }
            Assertions.checkArgument(z4);
            return new FixedTrackSelection(trackGroup, iArr[0], this.reason, this.data);
        }

        public Factory(int i5, @Nullable Object obj) {
            this.reason = i5;
            this.data = obj;
        }
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i5) {
        this(trackGroup, i5, 0, (Object) null);
    }

    public final int getSelectedIndex() {
        return 0;
    }

    @Nullable
    public final Object getSelectionData() {
        return this.data;
    }

    public final int getSelectionReason() {
        return this.reason;
    }

    public final void updateSelectedTrack(long j5, long j6, long j7) {
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i5, int i6, @Nullable Object obj) {
        super(trackGroup, i5);
        this.reason = i6;
        this.data = obj;
    }
}
