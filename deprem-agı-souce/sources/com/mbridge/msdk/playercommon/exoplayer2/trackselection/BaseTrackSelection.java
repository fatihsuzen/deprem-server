package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.MediaChunk;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class BaseTrackSelection implements TrackSelection {
    private final long[] blacklistUntilTimes;
    private final Format[] formats;
    protected final TrackGroup group;
    private int hashCode;
    protected final int length;
    protected final int[] tracks;

    private static final class DecreasingBandwidthComparator implements Comparator<Format> {
        private DecreasingBandwidthComparator() {
        }

        public final int compare(Format format, Format format2) {
            return format2.bitrate - format.bitrate;
        }
    }

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        boolean z4;
        int i5 = 0;
        if (iArr.length > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.group = (TrackGroup) Assertions.checkNotNull(trackGroup);
        int length2 = iArr.length;
        this.length = length2;
        this.formats = new Format[length2];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            this.formats[i6] = trackGroup.getFormat(iArr[i6]);
        }
        Arrays.sort(this.formats, new DecreasingBandwidthComparator());
        this.tracks = new int[this.length];
        while (true) {
            int i7 = this.length;
            if (i5 < i7) {
                this.tracks[i5] = trackGroup.indexOf(this.formats[i5]);
                i5++;
            } else {
                this.blacklistUntilTimes = new long[i7];
                return;
            }
        }
    }

    public final boolean blacklist(int i5, long j5) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean isBlacklisted = isBlacklisted(i5, elapsedRealtime);
        for (int i6 = 0; i6 < this.length && !isBlacklisted; i6++) {
            if (i6 == i5 || isBlacklisted(i6, elapsedRealtime)) {
                isBlacklisted = false;
            } else {
                isBlacklisted = true;
            }
        }
        if (!isBlacklisted) {
            return false;
        }
        long[] jArr = this.blacklistUntilTimes;
        jArr[i5] = Math.max(jArr[i5], elapsedRealtime + j5);
        return true;
    }

    public void disable() {
    }

    public void enable() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
            if (this.group != baseTrackSelection.group || !Arrays.equals(this.tracks, baseTrackSelection.tracks)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int evaluateQueueSize(long j5, List<? extends MediaChunk> list) {
        return list.size();
    }

    public final Format getFormat(int i5) {
        return this.formats[i5];
    }

    public final int getIndexInTrackGroup(int i5) {
        return this.tracks[i5];
    }

    public final Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.group) * 31) + Arrays.hashCode(this.tracks);
        }
        return this.hashCode;
    }

    public final int indexOf(Format format) {
        for (int i5 = 0; i5 < this.length; i5++) {
            if (this.formats[i5] == format) {
                return i5;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public final boolean isBlacklisted(int i5, long j5) {
        if (this.blacklistUntilTimes[i5] > j5) {
            return true;
        }
        return false;
    }

    public final int length() {
        return this.tracks.length;
    }

    public void onPlaybackSpeed(float f5) {
    }

    public final int indexOf(int i5) {
        for (int i6 = 0; i6 < this.length; i6++) {
            if (this.tracks[i6] == i5) {
                return i6;
            }
        }
        return -1;
    }
}
