package com.mbridge.msdk.playercommon.exoplayer2.analytics;

import android.net.NetworkInfo;
import android.view.Surface;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.analytics.AnalyticsListener;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;

public abstract class DefaultAnalyticsListener implements AnalyticsListener {
    public void onAudioSessionId(AnalyticsListener.EventTime eventTime, int i5) {
    }

    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i5, long j5, long j6) {
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i5, long j5, long j6) {
    }

    public void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i5, DecoderCounters decoderCounters) {
    }

    public void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i5, DecoderCounters decoderCounters) {
    }

    public void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i5, String str, long j5) {
    }

    public void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i5, Format format) {
    }

    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
    }

    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
    }

    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
    }

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i5, long j5) {
    }

    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z4) {
    }

    public void onLoadStarted(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z4) {
    }

    public void onMediaPeriodCreated(AnalyticsListener.EventTime eventTime) {
    }

    public void onMediaPeriodReleased(AnalyticsListener.EventTime eventTime) {
    }

    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
    }

    public void onNetworkTypeChanged(AnalyticsListener.EventTime eventTime, NetworkInfo networkInfo) {
    }

    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
    }

    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
    }

    public void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z4, int i5) {
    }

    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i5) {
    }

    public void onReadingStarted(AnalyticsListener.EventTime eventTime) {
    }

    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
    }

    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i5) {
    }

    public void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
    }

    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
    }

    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z4) {
    }

    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i5) {
    }

    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i5, int i6, int i7, float f5) {
    }

    public void onViewportSizeChange(AnalyticsListener.EventTime eventTime, int i5, int i6) {
    }
}
