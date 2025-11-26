package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.MediaChunk;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.List;

public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    public static final long DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 2000;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private final long minTimeBetweenBufferReevaluationMs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    public static final class Factory implements TrackSelection.Factory {
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;
        private final long minTimeBetweenBufferReevaluationMs;

        public Factory(BandwidthMeter bandwidthMeter2) {
            this(bandwidthMeter2, 10000, 25000, 25000, 0.75f, 0.75f, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, Clock.DEFAULT);
        }

        public Factory(BandwidthMeter bandwidthMeter2, int i5, int i6, int i7, float f5) {
            this(bandwidthMeter2, i5, i6, i7, f5, 0.75f, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, Clock.DEFAULT);
        }

        public final AdaptiveTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            return new AdaptiveTrackSelection(trackGroup, iArr, this.bandwidthMeter, (long) this.minDurationForQualityIncreaseMs, (long) this.maxDurationForQualityDecreaseMs, (long) this.minDurationToRetainAfterDiscardMs, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease, this.minTimeBetweenBufferReevaluationMs, this.clock);
        }

        public Factory(BandwidthMeter bandwidthMeter2, int i5, int i6, int i7, float f5, float f6, long j5, Clock clock2) {
            this.bandwidthMeter = bandwidthMeter2;
            this.minDurationForQualityIncreaseMs = i5;
            this.maxDurationForQualityDecreaseMs = i6;
            this.minDurationToRetainAfterDiscardMs = i7;
            this.bandwidthFraction = f5;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f6;
            this.minTimeBetweenBufferReevaluationMs = j5;
            this.clock = clock2;
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter2) {
        this(trackGroup, iArr, bandwidthMeter2, WorkRequest.MIN_BACKOFF_MILLIS, 25000, 25000, 0.75f, 0.75f, DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, Clock.DEFAULT);
    }

    private int determineIdealSelectedIndex(long j5) {
        long bitrateEstimate = (long) (((float) this.bandwidthMeter.getBitrateEstimate()) * this.bandwidthFraction);
        int i5 = 0;
        for (int i6 = 0; i6 < this.length; i6++) {
            if (j5 == Long.MIN_VALUE || !isBlacklisted(i6, j5)) {
                if (((long) Math.round(((float) getFormat(i6).bitrate) * this.playbackSpeed)) <= bitrateEstimate) {
                    return i6;
                }
                i5 = i6;
            }
        }
        return i5;
    }

    private long minDurationForQualityIncreaseUs(long j5) {
        if (j5 == C.TIME_UNSET || j5 > this.minDurationForQualityIncreaseUs) {
            return this.minDurationForQualityIncreaseUs;
        }
        return (long) (((float) j5) * this.bufferedFractionToLiveEdgeForQualityIncrease);
    }

    public void enable() {
        this.lastBufferEvaluationMs = C.TIME_UNSET;
    }

    public int evaluateQueueSize(long j5, List<? extends MediaChunk> list) {
        int i5;
        int i6;
        long elapsedRealtime = this.clock.elapsedRealtime();
        long j6 = this.lastBufferEvaluationMs;
        if (j6 != C.TIME_UNSET && elapsedRealtime - j6 < this.minTimeBetweenBufferReevaluationMs) {
            return list.size();
        }
        this.lastBufferEvaluationMs = elapsedRealtime;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (Util.getPlayoutDurationForMediaDuration(((MediaChunk) list.get(size - 1)).startTimeUs - j5, this.playbackSpeed) >= this.minDurationToRetainAfterDiscardUs) {
            Format format = getFormat(determineIdealSelectedIndex(elapsedRealtime));
            for (int i7 = 0; i7 < size; i7++) {
                MediaChunk mediaChunk = (MediaChunk) list.get(i7);
                Format format2 = mediaChunk.trackFormat;
                if (Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j5, this.playbackSpeed) >= this.minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i5 = format2.height) != -1 && i5 < 720 && (i6 = format2.width) != -1 && i6 < 1280 && i5 < format.height) {
                    return i7;
                }
            }
        }
        return size;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Nullable
    public Object getSelectionData() {
        return null;
    }

    public int getSelectionReason() {
        return this.reason;
    }

    public void onPlaybackSpeed(float f5) {
        this.playbackSpeed = f5;
    }

    public void updateSelectedTrack(long j5, long j6, long j7) {
        long elapsedRealtime = this.clock.elapsedRealtime();
        int i5 = this.selectedIndex;
        int determineIdealSelectedIndex = determineIdealSelectedIndex(elapsedRealtime);
        this.selectedIndex = determineIdealSelectedIndex;
        if (determineIdealSelectedIndex != i5) {
            if (!isBlacklisted(i5, elapsedRealtime)) {
                Format format = getFormat(i5);
                Format format2 = getFormat(this.selectedIndex);
                if (format2.bitrate > format.bitrate && j6 < minDurationForQualityIncreaseUs(j7)) {
                    this.selectedIndex = i5;
                } else if (format2.bitrate < format.bitrate && j6 >= this.maxDurationForQualityDecreaseUs) {
                    this.selectedIndex = i5;
                }
            }
            if (this.selectedIndex != i5) {
                this.reason = 3;
            }
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter2, long j5, long j6, long j7, float f5, float f6, long j8, Clock clock2) {
        super(trackGroup, iArr);
        this.bandwidthMeter = bandwidthMeter2;
        this.minDurationForQualityIncreaseUs = j5 * 1000;
        this.maxDurationForQualityDecreaseUs = j6 * 1000;
        this.minDurationToRetainAfterDiscardUs = j7 * 1000;
        this.bandwidthFraction = f5;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f6;
        this.minTimeBetweenBufferReevaluationMs = j8;
        this.clock = clock2;
        this.playbackSpeed = 1.0f;
        this.reason = 1;
        this.lastBufferEvaluationMs = C.TIME_UNSET;
        this.selectedIndex = determineIdealSelectedIndex(Long.MIN_VALUE);
    }
}
