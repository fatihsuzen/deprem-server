package com.mbridge.msdk.playercommon.exoplayer2.analytics;

import android.net.NetworkInfo;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.analytics.AnalyticsListener;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DefaultDrmSessionEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.video.VideoRendererEventListener;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class AnalyticsCollector implements Player.EventListener, AudioRendererEventListener, DefaultDrmSessionEventListener, MetadataOutput, MediaSourceEventListener, BandwidthMeter.EventListener, VideoRendererEventListener {
    private final Clock clock;
    private final CopyOnWriteArraySet<AnalyticsListener> listeners = new CopyOnWriteArraySet<>();
    private final MediaPeriodQueueTracker mediaPeriodQueueTracker = new MediaPeriodQueueTracker();
    @Nullable
    private Player player;
    private final Timeline.Window window = new Timeline.Window();

    public static class Factory {
        public AnalyticsCollector createAnalyticsCollector(@Nullable Player player, Clock clock) {
            return new AnalyticsCollector(player, clock);
        }
    }

    private static final class MediaPeriodQueueTracker {
        /* access modifiers changed from: private */
        public final ArrayList<WindowAndMediaPeriodId> activeMediaPeriods = new ArrayList<>();
        private boolean isSeeking;
        private WindowAndMediaPeriodId lastReportedPlayingMediaPeriod;
        private final Timeline.Period period = new Timeline.Period();
        private WindowAndMediaPeriodId readingMediaPeriod;
        private Timeline timeline = Timeline.EMPTY;

        private void updateLastReportedPlayingMediaPeriod() {
            if (!this.activeMediaPeriods.isEmpty()) {
                this.lastReportedPlayingMediaPeriod = this.activeMediaPeriods.get(0);
            }
        }

        private WindowAndMediaPeriodId updateMediaPeriodToNewTimeline(WindowAndMediaPeriodId windowAndMediaPeriodId, Timeline timeline2) {
            int indexOfPeriod;
            if (timeline2.isEmpty() || this.timeline.isEmpty() || (indexOfPeriod = timeline2.getIndexOfPeriod(this.timeline.getPeriod(windowAndMediaPeriodId.mediaPeriodId.periodIndex, this.period, true).uid)) == -1) {
                return windowAndMediaPeriodId;
            }
            return new WindowAndMediaPeriodId(timeline2.getPeriod(indexOfPeriod, this.period).windowIndex, windowAndMediaPeriodId.mediaPeriodId.copyWithPeriodIndex(indexOfPeriod));
        }

        @Nullable
        public final WindowAndMediaPeriodId getLastReportedPlayingMediaPeriod() {
            return this.lastReportedPlayingMediaPeriod;
        }

        @Nullable
        public final WindowAndMediaPeriodId getLoadingMediaPeriod() {
            if (this.activeMediaPeriods.isEmpty()) {
                return null;
            }
            ArrayList<WindowAndMediaPeriodId> arrayList = this.activeMediaPeriods;
            return arrayList.get(arrayList.size() - 1);
        }

        @Nullable
        public final WindowAndMediaPeriodId getPlayingMediaPeriod() {
            if (this.activeMediaPeriods.isEmpty() || this.timeline.isEmpty() || this.isSeeking) {
                return null;
            }
            return this.activeMediaPeriods.get(0);
        }

        @Nullable
        public final WindowAndMediaPeriodId getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public final boolean isSeeking() {
            return this.isSeeking;
        }

        public final void onMediaPeriodCreated(int i5, MediaSource.MediaPeriodId mediaPeriodId) {
            this.activeMediaPeriods.add(new WindowAndMediaPeriodId(i5, mediaPeriodId));
            if (this.activeMediaPeriods.size() == 1 && !this.timeline.isEmpty()) {
                updateLastReportedPlayingMediaPeriod();
            }
        }

        public final void onMediaPeriodReleased(int i5, MediaSource.MediaPeriodId mediaPeriodId) {
            WindowAndMediaPeriodId windowAndMediaPeriodId;
            WindowAndMediaPeriodId windowAndMediaPeriodId2 = new WindowAndMediaPeriodId(i5, mediaPeriodId);
            this.activeMediaPeriods.remove(windowAndMediaPeriodId2);
            if (windowAndMediaPeriodId2.equals(this.readingMediaPeriod)) {
                if (this.activeMediaPeriods.isEmpty()) {
                    windowAndMediaPeriodId = null;
                } else {
                    windowAndMediaPeriodId = this.activeMediaPeriods.get(0);
                }
                this.readingMediaPeriod = windowAndMediaPeriodId;
            }
        }

        public final void onPositionDiscontinuity(int i5) {
            updateLastReportedPlayingMediaPeriod();
        }

        public final void onReadingStarted(int i5, MediaSource.MediaPeriodId mediaPeriodId) {
            this.readingMediaPeriod = new WindowAndMediaPeriodId(i5, mediaPeriodId);
        }

        public final void onSeekProcessed() {
            this.isSeeking = false;
            updateLastReportedPlayingMediaPeriod();
        }

        public final void onSeekStarted() {
            this.isSeeking = true;
        }

        public final void onTimelineChanged(Timeline timeline2) {
            for (int i5 = 0; i5 < this.activeMediaPeriods.size(); i5++) {
                ArrayList<WindowAndMediaPeriodId> arrayList = this.activeMediaPeriods;
                arrayList.set(i5, updateMediaPeriodToNewTimeline(arrayList.get(i5), timeline2));
            }
            WindowAndMediaPeriodId windowAndMediaPeriodId = this.readingMediaPeriod;
            if (windowAndMediaPeriodId != null) {
                this.readingMediaPeriod = updateMediaPeriodToNewTimeline(windowAndMediaPeriodId, timeline2);
            }
            this.timeline = timeline2;
            updateLastReportedPlayingMediaPeriod();
        }

        @Nullable
        public final MediaSource.MediaPeriodId tryResolveWindowIndex(int i5) {
            Timeline timeline2 = this.timeline;
            if (timeline2 == null) {
                return null;
            }
            int periodCount = timeline2.getPeriodCount();
            MediaSource.MediaPeriodId mediaPeriodId = null;
            for (int i6 = 0; i6 < this.activeMediaPeriods.size(); i6++) {
                WindowAndMediaPeriodId windowAndMediaPeriodId = this.activeMediaPeriods.get(i6);
                int i7 = windowAndMediaPeriodId.mediaPeriodId.periodIndex;
                if (i7 < periodCount && this.timeline.getPeriod(i7, this.period).windowIndex == i5) {
                    if (mediaPeriodId != null) {
                        return null;
                    }
                    mediaPeriodId = windowAndMediaPeriodId.mediaPeriodId;
                }
            }
            return mediaPeriodId;
        }
    }

    private static final class WindowAndMediaPeriodId {
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final int windowIndex;

        public WindowAndMediaPeriodId(int i5, MediaSource.MediaPeriodId mediaPeriodId2) {
            this.windowIndex = i5;
            this.mediaPeriodId = mediaPeriodId2;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && WindowAndMediaPeriodId.class == obj.getClass()) {
                WindowAndMediaPeriodId windowAndMediaPeriodId = (WindowAndMediaPeriodId) obj;
                if (this.windowIndex != windowAndMediaPeriodId.windowIndex || !this.mediaPeriodId.equals(windowAndMediaPeriodId.mediaPeriodId)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.windowIndex * 31) + this.mediaPeriodId.hashCode();
        }
    }

    protected AnalyticsCollector(@Nullable Player player2, Clock clock2) {
        this.player = player2;
        this.clock = (Clock) Assertions.checkNotNull(clock2);
    }

    private AnalyticsListener.EventTime generateLastReportedPlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLastReportedPlayingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    public void addListener(AnalyticsListener analyticsListener) {
        this.listeners.add(analyticsListener);
    }

    /* access modifiers changed from: protected */
    public AnalyticsListener.EventTime generateEventTime(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        long elapsedRealtime = this.clock.elapsedRealtime();
        Timeline currentTimeline = this.player.getCurrentTimeline();
        long j5 = 0;
        if (i5 == this.player.getCurrentWindowIndex()) {
            if (mediaPeriodId == null || !mediaPeriodId.isAd()) {
                j5 = this.player.getContentPosition();
            } else if (this.player.getCurrentAdGroupIndex() == mediaPeriodId.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaPeriodId.adIndexInAdGroup) {
                j5 = this.player.getCurrentPosition();
            }
        } else if (i5 < currentTimeline.getWindowCount() && (mediaPeriodId == null || !mediaPeriodId.isAd())) {
            j5 = currentTimeline.getWindow(i5, this.window).getDefaultPositionMs();
        }
        long j6 = j5;
        return new AnalyticsListener.EventTime(elapsedRealtime, currentTimeline, i5, mediaPeriodId, j6, this.player.getCurrentPosition(), this.player.getBufferedPosition() - this.player.getContentPosition());
    }

    /* access modifiers changed from: protected */
    public Set<AnalyticsListener> getListeners() {
        return DesugarCollections.unmodifiableSet(this.listeners);
    }

    public final void notifyNetworkTypeChanged(@Nullable NetworkInfo networkInfo) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkTypeChanged(generatePlayingMediaPeriodEventTime, networkInfo);
        }
    }

    public final void notifySeekStarted() {
        if (!this.mediaPeriodQueueTracker.isSeeking()) {
            AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
            this.mediaPeriodQueueTracker.onSeekStarted();
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onSeekStarted(generatePlayingMediaPeriodEventTime);
            }
        }
    }

    public final void notifyViewportSizeChanged(int i5, int i6) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onViewportSizeChange(generatePlayingMediaPeriodEventTime, i5, i6);
        }
    }

    public final void onAudioDecoderInitialized(String str, long j5, long j6) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(generateReadingMediaPeriodEventTime, 1, str, j6);
        }
    }

    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateLastReportedPlayingMediaPeriodEventTime = generateLastReportedPlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(generateLastReportedPlayingMediaPeriodEventTime, 1, decoderCounters);
        }
    }

    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(generatePlayingMediaPeriodEventTime, 1, decoderCounters);
        }
    }

    public final void onAudioInputFormatChanged(Format format) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(generateReadingMediaPeriodEventTime, 1, format);
        }
    }

    public final void onAudioSessionId(int i5) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionId(generateReadingMediaPeriodEventTime, i5);
        }
    }

    public final void onAudioSinkUnderrun(int i5, long j5, long j6) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioUnderrun(generateReadingMediaPeriodEventTime, i5, j5, j6);
        }
    }

    public final void onBandwidthSample(int i5, long j5, long j6) {
        AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onBandwidthEstimate(generateLoadingMediaPeriodEventTime, i5, j5, j6);
        }
    }

    public final void onDownstreamFormatChanged(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateEventTime = generateEventTime(i5, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDownstreamFormatChanged(generateEventTime, mediaLoadData);
        }
    }

    public final void onDrmKeysLoaded() {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysLoaded(generateReadingMediaPeriodEventTime);
        }
    }

    public final void onDrmKeysRemoved() {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRemoved(generateReadingMediaPeriodEventTime);
        }
    }

    public final void onDrmKeysRestored() {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRestored(generateReadingMediaPeriodEventTime);
        }
    }

    public final void onDrmSessionManagerError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionManagerError(generateReadingMediaPeriodEventTime, exc);
        }
    }

    public final void onDroppedFrames(int i5, long j5) {
        AnalyticsListener.EventTime generateLastReportedPlayingMediaPeriodEventTime = generateLastReportedPlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDroppedVideoFrames(generateLastReportedPlayingMediaPeriodEventTime, i5, j5);
        }
    }

    public final void onLoadCanceled(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateEventTime = generateEventTime(i5, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadCanceled(generateEventTime, loadEventInfo, mediaLoadData);
        }
    }

    public final void onLoadCompleted(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateEventTime = generateEventTime(i5, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadCompleted(generateEventTime, loadEventInfo, mediaLoadData);
        }
    }

    public final void onLoadError(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z4) {
        AnalyticsListener.EventTime generateEventTime = generateEventTime(i5, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadError(generateEventTime, loadEventInfo, mediaLoadData, iOException, z4);
        }
    }

    public final void onLoadStarted(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateEventTime = generateEventTime(i5, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadStarted(generateEventTime, loadEventInfo, mediaLoadData);
        }
    }

    public final void onLoadingChanged(boolean z4) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadingChanged(generatePlayingMediaPeriodEventTime, z4);
        }
    }

    public final void onMediaPeriodCreated(int i5, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onMediaPeriodCreated(i5, mediaPeriodId);
        AnalyticsListener.EventTime generateEventTime = generateEventTime(i5, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onMediaPeriodCreated(generateEventTime);
        }
    }

    public final void onMediaPeriodReleased(int i5, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onMediaPeriodReleased(i5, mediaPeriodId);
        AnalyticsListener.EventTime generateEventTime = generateEventTime(i5, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onMediaPeriodReleased(generateEventTime);
        }
    }

    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onMetadata(generatePlayingMediaPeriodEventTime, metadata);
        }
    }

    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackParametersChanged(generatePlayingMediaPeriodEventTime, playbackParameters);
        }
    }

    public final void onPlayerError(ExoPlaybackException exoPlaybackException) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerError(generatePlayingMediaPeriodEventTime, exoPlaybackException);
        }
    }

    public final void onPlayerStateChanged(boolean z4, int i5) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStateChanged(generatePlayingMediaPeriodEventTime, z4, i5);
        }
    }

    public final void onPositionDiscontinuity(int i5) {
        this.mediaPeriodQueueTracker.onPositionDiscontinuity(i5);
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(generatePlayingMediaPeriodEventTime, i5);
        }
    }

    public final void onReadingStarted(int i5, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onReadingStarted(i5, mediaPeriodId);
        AnalyticsListener.EventTime generateEventTime = generateEventTime(i5, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onReadingStarted(generateEventTime);
        }
    }

    public final void onRenderedFirstFrame(Surface surface) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRenderedFirstFrame(generateReadingMediaPeriodEventTime, surface);
        }
    }

    public final void onRepeatModeChanged(int i5) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRepeatModeChanged(generatePlayingMediaPeriodEventTime, i5);
        }
    }

    public final void onSeekProcessed() {
        if (this.mediaPeriodQueueTracker.isSeeking()) {
            this.mediaPeriodQueueTracker.onSeekProcessed();
            AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onSeekProcessed(generatePlayingMediaPeriodEventTime);
            }
        }
    }

    public final void onShuffleModeEnabledChanged(boolean z4) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onShuffleModeChanged(generatePlayingMediaPeriodEventTime, z4);
        }
    }

    public final void onTimelineChanged(Timeline timeline, @Nullable Object obj, int i5) {
        this.mediaPeriodQueueTracker.onTimelineChanged(timeline);
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTimelineChanged(generatePlayingMediaPeriodEventTime, i5);
        }
    }

    public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTracksChanged(generatePlayingMediaPeriodEventTime, trackGroupArray, trackSelectionArray);
        }
    }

    public final void onUpstreamDiscarded(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateEventTime = generateEventTime(i5, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onUpstreamDiscarded(generateEventTime, mediaLoadData);
        }
    }

    public final void onVideoDecoderInitialized(String str, long j5, long j6) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(generateReadingMediaPeriodEventTime, 2, str, j6);
        }
    }

    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateLastReportedPlayingMediaPeriodEventTime = generateLastReportedPlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(generateLastReportedPlayingMediaPeriodEventTime, 2, decoderCounters);
        }
    }

    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(generatePlayingMediaPeriodEventTime, 2, decoderCounters);
        }
    }

    public final void onVideoInputFormatChanged(Format format) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(generateReadingMediaPeriodEventTime, 2, format);
        }
    }

    public final void onVideoSizeChanged(int i5, int i6, int i7, float f5) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(generateReadingMediaPeriodEventTime, i5, i6, i7, f5);
        }
    }

    public void removeListener(AnalyticsListener analyticsListener) {
        this.listeners.remove(analyticsListener);
    }

    public final void resetForNewMediaSource() {
        ArrayList arrayList = new ArrayList(this.mediaPeriodQueueTracker.activeMediaPeriods);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            WindowAndMediaPeriodId windowAndMediaPeriodId = (WindowAndMediaPeriodId) obj;
            onMediaPeriodReleased(windowAndMediaPeriodId.windowIndex, windowAndMediaPeriodId.mediaPeriodId);
        }
    }

    public void setPlayer(Player player2) {
        boolean z4;
        if (this.player == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.player = (Player) Assertions.checkNotNull(player2);
    }

    private AnalyticsListener.EventTime generateEventTime(@Nullable WindowAndMediaPeriodId windowAndMediaPeriodId) {
        if (windowAndMediaPeriodId != null) {
            return generateEventTime(windowAndMediaPeriodId.windowIndex, windowAndMediaPeriodId.mediaPeriodId);
        }
        int currentWindowIndex = ((Player) Assertions.checkNotNull(this.player)).getCurrentWindowIndex();
        return generateEventTime(currentWindowIndex, this.mediaPeriodQueueTracker.tryResolveWindowIndex(currentWindowIndex));
    }
}
