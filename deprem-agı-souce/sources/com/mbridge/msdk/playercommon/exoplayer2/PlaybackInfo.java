package com.mbridge.msdk.playercommon.exoplayer2;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectorResult;

final class PlaybackInfo {
    public volatile long bufferedPositionUs;
    public final long contentPositionUs;
    public final boolean isLoading;
    @Nullable
    public final Object manifest;
    public final MediaSource.MediaPeriodId periodId;
    public final int playbackState;
    public volatile long positionUs;
    public final long startPositionUs;
    public final Timeline timeline;
    public final TrackGroupArray trackGroups;
    public final TrackSelectorResult trackSelectorResult;

    public PlaybackInfo(Timeline timeline2, long j5, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult2) {
        this(timeline2, (Object) null, new MediaSource.MediaPeriodId(0), j5, C.TIME_UNSET, 1, false, trackGroupArray, trackSelectorResult2);
    }

    private static void copyMutablePositions(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2) {
        playbackInfo2.positionUs = playbackInfo.positionUs;
        playbackInfo2.bufferedPositionUs = playbackInfo.bufferedPositionUs;
    }

    public final PlaybackInfo copyWithIsLoading(boolean z4) {
        PlaybackInfo playbackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, z4, this.trackGroups, this.trackSelectorResult);
        copyMutablePositions(this, playbackInfo);
        return playbackInfo;
    }

    public final PlaybackInfo copyWithPeriodIndex(int i5) {
        PlaybackInfo playbackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId.copyWithPeriodIndex(i5), this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, this.trackGroups, this.trackSelectorResult);
        copyMutablePositions(this, playbackInfo);
        return playbackInfo;
    }

    public final PlaybackInfo copyWithPlaybackState(int i5) {
        PlaybackInfo playbackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, i5, this.isLoading, this.trackGroups, this.trackSelectorResult);
        copyMutablePositions(this, playbackInfo);
        return playbackInfo;
    }

    public final PlaybackInfo copyWithTimeline(Timeline timeline2, Object obj) {
        PlaybackInfo playbackInfo = new PlaybackInfo(timeline2, obj, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, this.trackGroups, this.trackSelectorResult);
        copyMutablePositions(this, playbackInfo);
        return playbackInfo;
    }

    public final PlaybackInfo copyWithTrackInfo(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult2) {
        PlaybackInfo playbackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, trackGroupArray, trackSelectorResult2);
        copyMutablePositions(this, playbackInfo);
        return playbackInfo;
    }

    public final PlaybackInfo fromNewPosition(MediaSource.MediaPeriodId mediaPeriodId, long j5, long j6) {
        long j7;
        Timeline timeline2 = this.timeline;
        Object obj = this.manifest;
        if (mediaPeriodId.isAd()) {
            j7 = j6;
        } else {
            j7 = -9223372036854775807L;
        }
        return new PlaybackInfo(timeline2, obj, mediaPeriodId, j5, j7, this.playbackState, this.isLoading, this.trackGroups, this.trackSelectorResult);
    }

    public PlaybackInfo(Timeline timeline2, @Nullable Object obj, MediaSource.MediaPeriodId mediaPeriodId, long j5, long j6, int i5, boolean z4, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult2) {
        this.timeline = timeline2;
        this.manifest = obj;
        this.periodId = mediaPeriodId;
        this.startPositionUs = j5;
        this.contentPositionUs = j6;
        this.positionUs = j5;
        this.bufferedPositionUs = j5;
        this.playbackState = i5;
        this.isLoading = z4;
        this.trackGroups = trackGroupArray;
        this.trackSelectorResult = trackSelectorResult2;
    }
}
