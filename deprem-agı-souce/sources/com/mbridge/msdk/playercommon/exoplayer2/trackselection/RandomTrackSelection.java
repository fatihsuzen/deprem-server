package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import java.util.Random;

public final class RandomTrackSelection extends BaseTrackSelection {
    private final Random random;
    private int selectedIndex;

    public static final class Factory implements TrackSelection.Factory {
        private final Random random;

        public Factory() {
            this.random = new Random();
        }

        public final RandomTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            return new RandomTrackSelection(trackGroup, iArr, this.random);
        }

        public Factory(int i5) {
            this.random = new Random((long) i5);
        }
    }

    public RandomTrackSelection(TrackGroup trackGroup, int... iArr) {
        super(trackGroup, iArr);
        Random random2 = new Random();
        this.random = random2;
        this.selectedIndex = random2.nextInt(this.length);
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Nullable
    public final Object getSelectionData() {
        return null;
    }

    public final int getSelectionReason() {
        return 3;
    }

    public final void updateSelectedTrack(long j5, long j6, long j7) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i5 = 0;
        for (int i6 = 0; i6 < this.length; i6++) {
            if (!isBlacklisted(i6, elapsedRealtime)) {
                i5++;
            }
        }
        this.selectedIndex = this.random.nextInt(i5);
        if (i5 != this.length) {
            int i7 = 0;
            for (int i8 = 0; i8 < this.length; i8++) {
                if (!isBlacklisted(i8, elapsedRealtime)) {
                    int i9 = i7 + 1;
                    if (this.selectedIndex == i7) {
                        this.selectedIndex = i8;
                        return;
                    }
                    i7 = i9;
                }
            }
        }
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, long j5) {
        this(trackGroup, iArr, new Random(j5));
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, Random random2) {
        super(trackGroup, iArr);
        this.random = random2;
        this.selectedIndex = random2.nextInt(this.length);
    }
}
