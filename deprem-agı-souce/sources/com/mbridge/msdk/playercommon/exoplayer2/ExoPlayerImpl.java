package com.mbridge.msdk.playercommon.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectorResult;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

final class ExoPlayerImpl implements ExoPlayer {
    private static final String TAG = "ExoPlayerImpl";
    private final TrackSelectorResult emptyTrackSelectorResult;
    private final Handler eventHandler;
    private boolean hasPendingPrepare;
    private boolean hasPendingSeek;
    private final ExoPlayerImplInternal internalPlayer;
    private final Handler internalPlayerHandler;
    private final CopyOnWriteArraySet<Player.EventListener> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private int pendingOperationAcks;
    private final ArrayDeque<PlaybackInfoUpdate> pendingPlaybackInfoUpdates;
    private final Timeline.Period period;
    private boolean playWhenReady;
    @Nullable
    private ExoPlaybackException playbackError;
    private PlaybackInfo playbackInfo;
    private PlaybackParameters playbackParameters;
    private final Renderer[] renderers;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    private static final class PlaybackInfoUpdate {
        private final boolean isLoadingChanged;
        private final Set<Player.EventListener> listeners;
        private final boolean playWhenReady;
        private final PlaybackInfo playbackInfo;
        private final boolean playbackStateOrPlayWhenReadyChanged;
        private final boolean positionDiscontinuity;
        private final int positionDiscontinuityReason;
        private final boolean seekProcessed;
        private final int timelineChangeReason;
        private final boolean timelineOrManifestChanged;
        private final TrackSelector trackSelector;
        private final boolean trackSelectorResultChanged;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo2, PlaybackInfo playbackInfo3, Set<Player.EventListener> set, TrackSelector trackSelector2, boolean z4, int i5, int i6, boolean z5, boolean z6, boolean z7) {
            boolean z8;
            boolean z9;
            boolean z10;
            this.playbackInfo = playbackInfo2;
            this.listeners = set;
            this.trackSelector = trackSelector2;
            this.positionDiscontinuity = z4;
            this.positionDiscontinuityReason = i5;
            this.timelineChangeReason = i6;
            this.seekProcessed = z5;
            this.playWhenReady = z6;
            boolean z11 = true;
            if (z7 || playbackInfo3.playbackState != playbackInfo2.playbackState) {
                z8 = true;
            } else {
                z8 = false;
            }
            this.playbackStateOrPlayWhenReadyChanged = z8;
            if (playbackInfo3.timeline == playbackInfo2.timeline && playbackInfo3.manifest == playbackInfo2.manifest) {
                z9 = false;
            } else {
                z9 = true;
            }
            this.timelineOrManifestChanged = z9;
            if (playbackInfo3.isLoading != playbackInfo2.isLoading) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.isLoadingChanged = z10;
            this.trackSelectorResultChanged = playbackInfo3.trackSelectorResult == playbackInfo2.trackSelectorResult ? false : z11;
        }

        public final void notifyListeners() {
            if (this.timelineOrManifestChanged || this.timelineChangeReason == 0) {
                for (Player.EventListener onTimelineChanged : this.listeners) {
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    onTimelineChanged.onTimelineChanged(playbackInfo2.timeline, playbackInfo2.manifest, this.timelineChangeReason);
                }
            }
            if (this.positionDiscontinuity) {
                for (Player.EventListener onPositionDiscontinuity : this.listeners) {
                    onPositionDiscontinuity.onPositionDiscontinuity(this.positionDiscontinuityReason);
                }
            }
            if (this.trackSelectorResultChanged) {
                this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
                for (Player.EventListener onTracksChanged : this.listeners) {
                    PlaybackInfo playbackInfo3 = this.playbackInfo;
                    onTracksChanged.onTracksChanged(playbackInfo3.trackGroups, playbackInfo3.trackSelectorResult.selections);
                }
            }
            if (this.isLoadingChanged) {
                for (Player.EventListener onLoadingChanged : this.listeners) {
                    onLoadingChanged.onLoadingChanged(this.playbackInfo.isLoading);
                }
            }
            if (this.playbackStateOrPlayWhenReadyChanged) {
                for (Player.EventListener onPlayerStateChanged : this.listeners) {
                    onPlayerStateChanged.onPlayerStateChanged(this.playWhenReady, this.playbackInfo.playbackState);
                }
            }
            if (this.seekProcessed) {
                for (Player.EventListener onSeekProcessed : this.listeners) {
                    onSeekProcessed.onSeekProcessed();
                }
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector2, LoadControl loadControl, Clock clock) {
        boolean z4;
        Looper looper;
        Log.i(TAG, "Init " + Integer.toHexString(System.identityHashCode(this)) + " [" + ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "]");
        if (rendererArr.length > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.renderers = (Renderer[]) Assertions.checkNotNull(rendererArr);
        this.trackSelector = (TrackSelector) Assertions.checkNotNull(trackSelector2);
        this.playWhenReady = false;
        this.repeatMode = 0;
        this.shuffleModeEnabled = false;
        this.listeners = new CopyOnWriteArraySet<>();
        TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[rendererArr.length], new TrackSelection[rendererArr.length], (Object) null);
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.playbackParameters = PlaybackParameters.DEFAULT;
        if (Looper.myLooper() != null) {
            looper = Looper.myLooper();
        } else {
            looper = Looper.getMainLooper();
        }
        AnonymousClass1 r8 = new Handler(looper) {
            public void handleMessage(Message message) {
                ExoPlayerImpl.this.handleEvent(message);
            }
        };
        this.eventHandler = r8;
        TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
        this.playbackInfo = new PlaybackInfo(Timeline.EMPTY, 0, TrackGroupArray.EMPTY, trackSelectorResult2);
        this.pendingPlaybackInfoUpdates = new ArrayDeque<>();
        ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(rendererArr, trackSelector2, trackSelectorResult2, loadControl, this.playWhenReady, this.repeatMode, this.shuffleModeEnabled, r8, this, clock);
        this.internalPlayer = exoPlayerImplInternal;
        this.internalPlayerHandler = new Handler(exoPlayerImplInternal.getPlaybackLooper());
    }

    private PlaybackInfo getResetPlaybackInfo(boolean z4, boolean z5, int i5) {
        Timeline timeline;
        Object obj;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        if (z4) {
            this.maskingWindowIndex = 0;
            this.maskingPeriodIndex = 0;
            this.maskingWindowPositionMs = 0;
        } else {
            this.maskingWindowIndex = getCurrentWindowIndex();
            this.maskingPeriodIndex = getCurrentPeriodIndex();
            this.maskingWindowPositionMs = getCurrentPosition();
        }
        if (z5) {
            timeline = Timeline.EMPTY;
        } else {
            timeline = this.playbackInfo.timeline;
        }
        Timeline timeline2 = timeline;
        if (z5) {
            obj = null;
        } else {
            obj = this.playbackInfo.manifest;
        }
        Object obj2 = obj;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.periodId;
        long j5 = playbackInfo2.startPositionUs;
        long j6 = playbackInfo2.contentPositionUs;
        if (z5) {
            trackGroupArray = TrackGroupArray.EMPTY;
        } else {
            trackGroupArray = playbackInfo2.trackGroups;
        }
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        if (z5) {
            trackSelectorResult = this.emptyTrackSelectorResult;
        } else {
            trackSelectorResult = playbackInfo2.trackSelectorResult;
        }
        return new PlaybackInfo(timeline2, obj2, mediaPeriodId, j5, j6, i5, false, trackGroupArray2, trackSelectorResult);
    }

    private void handlePlaybackInfo(PlaybackInfo playbackInfo2, int i5, boolean z4, int i6) {
        PlaybackInfo playbackInfo3;
        int i7;
        int i8 = this.pendingOperationAcks - i5;
        this.pendingOperationAcks = i8;
        if (i8 == 0) {
            if (playbackInfo2.startPositionUs == C.TIME_UNSET) {
                playbackInfo3 = playbackInfo2.fromNewPosition(playbackInfo2.periodId, 0, playbackInfo2.contentPositionUs);
            } else {
                playbackInfo3 = playbackInfo2;
            }
            if ((!this.playbackInfo.timeline.isEmpty() || this.hasPendingPrepare) && playbackInfo3.timeline.isEmpty()) {
                this.maskingPeriodIndex = 0;
                this.maskingWindowIndex = 0;
                this.maskingWindowPositionMs = 0;
            }
            if (this.hasPendingPrepare) {
                i7 = 0;
            } else {
                i7 = 2;
            }
            boolean z5 = this.hasPendingSeek;
            this.hasPendingPrepare = false;
            this.hasPendingSeek = false;
            updatePlaybackInfo(playbackInfo3, z4, i6, i7, z5, false);
        }
    }

    private long playbackInfoPositionUsToWindowPositionMs(long j5) {
        long usToMs = C.usToMs(j5);
        if (this.playbackInfo.periodId.isAd()) {
            return usToMs;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        playbackInfo2.timeline.getPeriod(playbackInfo2.periodId.periodIndex, this.period);
        return usToMs + this.period.getPositionInWindowMs();
    }

    private boolean shouldMaskPosition() {
        if (this.playbackInfo.timeline.isEmpty() || this.pendingOperationAcks > 0) {
            return true;
        }
        return false;
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo2, boolean z4, int i5, int i6, boolean z5, boolean z6) {
        boolean isEmpty = this.pendingPlaybackInfoUpdates.isEmpty();
        this.pendingPlaybackInfoUpdates.addLast(new PlaybackInfoUpdate(playbackInfo2, this.playbackInfo, this.listeners, this.trackSelector, z4, i5, i6, z5, this.playWhenReady, z6));
        this.playbackInfo = playbackInfo2;
        if (isEmpty) {
            while (!this.pendingPlaybackInfoUpdates.isEmpty()) {
                this.pendingPlaybackInfoUpdates.peekFirst().notifyListeners();
                this.pendingPlaybackInfoUpdates.removeFirst();
            }
        }
    }

    public final void addListener(Player.EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    public final void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        ArrayList arrayList = new ArrayList();
        for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
            arrayList.add(createMessage(exoPlayerMessage.target).setType(exoPlayerMessage.messageType).setPayload(exoPlayerMessage.message).send());
        }
        int size = arrayList.size();
        boolean z4 = false;
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            PlayerMessage playerMessage = (PlayerMessage) obj;
            boolean z5 = true;
            while (z5) {
                try {
                    playerMessage.blockUntilDelivered();
                    z5 = false;
                } catch (InterruptedException unused) {
                    z4 = true;
                } catch (TimeoutException e5) {
                    af.b(TAG, e5.getMessage());
                }
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
    }

    public final PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.internalPlayerHandler);
    }

    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == C.TIME_UNSET || duration == C.TIME_UNSET) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    public final long getBufferedPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        return playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.bufferedPositionUs);
    }

    public final long getContentPosition() {
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        playbackInfo2.timeline.getPeriod(playbackInfo2.periodId.periodIndex, this.period);
        return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.contentPositionUs);
    }

    public final int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    public final int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    public final Object getCurrentManifest() {
        return this.playbackInfo.manifest;
    }

    public final int getCurrentPeriodIndex() {
        if (shouldMaskPosition()) {
            return this.maskingPeriodIndex;
        }
        return this.playbackInfo.periodId.periodIndex;
    }

    public final long getCurrentPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        return playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.positionUs);
    }

    @Nullable
    public final Object getCurrentTag() {
        int currentWindowIndex = getCurrentWindowIndex();
        if (currentWindowIndex > this.playbackInfo.timeline.getWindowCount()) {
            return null;
        }
        return this.playbackInfo.timeline.getWindow(currentWindowIndex, this.window, true).tag;
    }

    public final Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    public final TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    public final TrackSelectionArray getCurrentTrackSelections() {
        return this.playbackInfo.trackSelectorResult.selections;
    }

    public final int getCurrentWindowIndex() {
        if (shouldMaskPosition()) {
            return this.maskingWindowIndex;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        return playbackInfo2.timeline.getPeriod(playbackInfo2.periodId.periodIndex, this.period).windowIndex;
    }

    public final long getDuration() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return C.TIME_UNSET;
        }
        if (!isPlayingAd()) {
            return timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        return C.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
    }

    public final int getNextWindowIndex() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return -1;
        }
        return timeline.getNextWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
    }

    public final boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    @Nullable
    public final ExoPlaybackException getPlaybackError() {
        return this.playbackError;
    }

    public final Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    public final PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    public final int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    public final int getPreviousWindowIndex() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return -1;
        }
        return timeline.getPreviousWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
    }

    public final int getRendererCount() {
        return this.renderers.length;
    }

    public final int getRendererType(int i5) {
        return this.renderers[i5].getTrackType();
    }

    public final int getRepeatMode() {
        return this.repeatMode;
    }

    public final boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    public final Player.TextComponent getTextComponent() {
        return null;
    }

    public final Player.VideoComponent getVideoComponent() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void handleEvent(Message message) {
        int i5 = message.what;
        boolean z4 = true;
        if (i5 == 0) {
            PlaybackInfo playbackInfo2 = (PlaybackInfo) message.obj;
            int i6 = message.arg1;
            int i7 = message.arg2;
            if (i7 == -1) {
                z4 = false;
            }
            handlePlaybackInfo(playbackInfo2, i6, z4, i7);
        } else if (i5 == 1) {
            PlaybackParameters playbackParameters2 = (PlaybackParameters) message.obj;
            if (!this.playbackParameters.equals(playbackParameters2)) {
                this.playbackParameters = playbackParameters2;
                Iterator<Player.EventListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onPlaybackParametersChanged(playbackParameters2);
                }
            }
        } else if (i5 == 2) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
            this.playbackError = exoPlaybackException;
            Iterator<Player.EventListener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().onPlayerError(exoPlaybackException);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final boolean isCurrentWindowDynamic() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty() || !timeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic) {
            return false;
        }
        return true;
    }

    public final boolean isCurrentWindowSeekable() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty() || !timeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable) {
            return false;
        }
        return true;
    }

    public final boolean isLoading() {
        return this.playbackInfo.isLoading;
    }

    public final boolean isPlayingAd() {
        if (shouldMaskPosition() || !this.playbackInfo.periodId.isAd()) {
            return false;
        }
        return true;
    }

    public final void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    public final void release() {
        Log.i(TAG, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        this.internalPlayer.release();
        this.eventHandler.removeCallbacksAndMessages((Object) null);
    }

    public final void removeListener(Player.EventListener eventListener) {
        this.listeners.remove(eventListener);
    }

    public final void seekTo(long j5) {
        seekTo(getCurrentWindowIndex(), j5);
    }

    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    public final void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
            createMessage(exoPlayerMessage.target).setType(exoPlayerMessage.messageType).setPayload(exoPlayerMessage.message).send();
        }
    }

    public final void setPlayWhenReady(boolean z4) {
        if (this.playWhenReady != z4) {
            this.playWhenReady = z4;
            this.internalPlayer.setPlayWhenReady(z4);
            updatePlaybackInfo(this.playbackInfo, false, 4, 1, false, true);
        }
    }

    public final void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters2) {
        if (playbackParameters2 == null) {
            playbackParameters2 = PlaybackParameters.DEFAULT;
        }
        this.internalPlayer.setPlaybackParameters(playbackParameters2);
    }

    public final void setRepeatMode(int i5) {
        if (this.repeatMode != i5) {
            this.repeatMode = i5;
            this.internalPlayer.setRepeatMode(i5);
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(i5);
            }
        }
    }

    public final void setSeekParameters(@Nullable SeekParameters seekParameters) {
        if (seekParameters == null) {
            seekParameters = SeekParameters.DEFAULT;
        }
        this.internalPlayer.setSeekParameters(seekParameters);
    }

    public final void setShuffleModeEnabled(boolean z4) {
        if (this.shuffleModeEnabled != z4) {
            this.shuffleModeEnabled = z4;
            this.internalPlayer.setShuffleModeEnabled(z4);
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onShuffleModeEnabledChanged(z4);
            }
        }
    }

    public final void stop() {
        stop(false);
    }

    public final void prepare(MediaSource mediaSource, boolean z4, boolean z5) {
        this.playbackError = null;
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z4, z5, 2);
        this.hasPendingPrepare = true;
        this.pendingOperationAcks++;
        this.internalPlayer.prepare(mediaSource, z4, z5);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false, false);
    }

    public final void seekTo(int i5, long j5) {
        int i6;
        Timeline timeline = this.playbackInfo.timeline;
        if (i5 < 0 || (!timeline.isEmpty() && i5 >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, i5, j5);
        }
        this.hasPendingSeek = true;
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            Log.w(TAG, "seekTo ignored because an ad is playing");
            this.eventHandler.obtainMessage(0, 1, -1, this.playbackInfo).sendToTarget();
            return;
        }
        this.maskingWindowIndex = i5;
        if (timeline.isEmpty()) {
            this.maskingWindowPositionMs = j5 == C.TIME_UNSET ? 0 : j5;
            this.maskingPeriodIndex = 0;
            i6 = i5;
        } else {
            long defaultPositionUs = j5 == C.TIME_UNSET ? timeline.getWindow(i5, this.window).getDefaultPositionUs() : C.msToUs(j5);
            i6 = i5;
            Pair<Integer, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, i6, defaultPositionUs);
            this.maskingWindowPositionMs = C.usToMs(defaultPositionUs);
            this.maskingPeriodIndex = ((Integer) periodPosition.first).intValue();
        }
        this.internalPlayer.seekTo(timeline, i6, C.msToUs(j5));
        Iterator<Player.EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(1);
        }
    }

    public final void seekToDefaultPosition(int i5) {
        seekTo(i5, C.TIME_UNSET);
    }

    public final void stop(boolean z4) {
        if (z4) {
            this.playbackError = null;
        }
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z4, z4, 1);
        this.pendingOperationAcks++;
        this.internalPlayer.stop(z4);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false, false);
    }
}
