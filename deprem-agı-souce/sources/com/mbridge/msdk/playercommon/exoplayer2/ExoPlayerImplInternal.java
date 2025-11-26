package com.mbridge.msdk.playercommon.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultMediaClock;
import com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectorResult;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.HandlerWrapper;
import com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

final class ExoPlayerImplInternal implements Handler.Callback, DefaultMediaClock.PlaybackParameterListener, PlayerMessage.Sender, MediaPeriod.Callback, MediaSource.SourceInfoRefreshListener, TrackSelector.InvalidationListener {
    private static final long DEFAULT_RELEASE_TIMEOUT_MS = 500;
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_DO_SOME_WORK = 2;
    public static final int MSG_ERROR = 2;
    private static final int MSG_PERIOD_PREPARED = 9;
    public static final int MSG_PLAYBACK_INFO_CHANGED = 0;
    public static final int MSG_PLAYBACK_PARAMETERS_CHANGED = 1;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_REFRESH_SOURCE_INFO = 8;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 12;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 13;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 10;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 11;
    private static final int PREPARING_SOURCE_INTERVAL_MS = 10;
    private static final int RENDERING_INTERVAL_MS = 10;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final Clock clock;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private Renderer[] enabledRenderers;
    private final Handler eventHandler;
    private final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private MediaSource mediaSource;
    private int nextPendingMessageIndex;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private int pendingPrepareCount;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private PlaybackInfo playbackInfo;
    private final PlaybackInfoUpdate playbackInfoUpdate;
    private final ExoPlayer player;
    private final MediaPeriodQueue queue = new MediaPeriodQueue();
    private boolean rebuffering;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private int repeatMode;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    private static final class MediaSourceRefreshInfo {
        public final Object manifest;
        public final MediaSource source;
        public final Timeline timeline;

        public MediaSourceRefreshInfo(MediaSource mediaSource, Timeline timeline2, Object obj) {
            this.source = mediaSource;
            this.timeline = timeline2;
            this.manifest = obj;
        }
    }

    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        @Nullable
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public final void setResolvedPosition(int i5, long j5, Object obj) {
            this.resolvedPeriodIndex = i5;
            this.resolvedPeriodTimeUs = j5;
            this.resolvedPeriodUid = obj;
        }

        public final int compareTo(@NonNull PendingMessageInfo pendingMessageInfo) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i5 = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            if (i5 != 0) {
                return i5;
            }
            return Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    private static final class PlaybackInfoUpdate {
        /* access modifiers changed from: private */
        public int discontinuityReason;
        private PlaybackInfo lastPlaybackInfo;
        /* access modifiers changed from: private */
        public int operationAcks;
        /* access modifiers changed from: private */
        public boolean positionDiscontinuity;

        private PlaybackInfoUpdate() {
        }

        public final boolean hasPendingUpdate(PlaybackInfo playbackInfo) {
            if (playbackInfo != this.lastPlaybackInfo || this.operationAcks > 0 || this.positionDiscontinuity) {
                return true;
            }
            return false;
        }

        public final void incrementPendingOperationAcks(int i5) {
            this.operationAcks += i5;
        }

        public final void reset(PlaybackInfo playbackInfo) {
            this.lastPlaybackInfo = playbackInfo;
            this.operationAcks = 0;
            this.positionDiscontinuity = false;
        }

        public final void setPositionDiscontinuity(int i5) {
            boolean z4 = true;
            if (!this.positionDiscontinuity || this.discontinuityReason == 4) {
                this.positionDiscontinuity = true;
                this.discontinuityReason = i5;
                return;
            }
            if (i5 != 4) {
                z4 = false;
            }
            Assertions.checkArgument(z4);
        }
    }

    private static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline2, int i5, long j5) {
            this.timeline = timeline2;
            this.windowIndex = i5;
            this.windowPositionUs = j5;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector2, TrackSelectorResult trackSelectorResult, LoadControl loadControl2, boolean z4, int i5, boolean z5, Handler handler2, ExoPlayer exoPlayer, Clock clock2) {
        Clock clock3 = clock2;
        this.renderers = rendererArr;
        this.trackSelector = trackSelector2;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl2;
        this.playWhenReady = z4;
        this.repeatMode = i5;
        this.shuffleModeEnabled = z5;
        this.eventHandler = handler2;
        this.player = exoPlayer;
        this.clock = clock3;
        this.backBufferDurationUs = loadControl2.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl2.retainBackBufferFromKeyframe();
        this.seekParameters = SeekParameters.DEFAULT;
        this.playbackInfo = new PlaybackInfo(Timeline.EMPTY, C.TIME_UNSET, TrackGroupArray.EMPTY, trackSelectorResult);
        this.playbackInfoUpdate = new PlaybackInfoUpdate();
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i6 = 0; i6 < rendererArr.length; i6++) {
            rendererArr[i6].setIndex(i6);
            this.rendererCapabilities[i6] = rendererArr[i6].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock3);
        this.pendingMessages = new ArrayList<>();
        this.enabledRenderers = new Renderer[0];
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector2.init(this);
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.internalPlaybackThread = handlerThread;
        handlerThread.start();
        this.handler = clock3.createHandler(handlerThread.getLooper(), this);
    }

    /* access modifiers changed from: private */
    public void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (!playerMessage.isCanceled()) {
            try {
                playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
            } finally {
                playerMessage.markAsProcessed(true);
            }
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        this.mediaClock.onRendererDisabled(renderer);
        ensureStopped(renderer);
        renderer.disable();
    }

    private void doSomeWork() throws ExoPlaybackException, IOException {
        int i5;
        boolean z4;
        long uptimeMillis = this.clock.uptimeMillis();
        updatePeriods();
        if (!this.queue.hasPlayingPeriod()) {
            maybeThrowPeriodPrepareError();
            scheduleNextWork(uptimeMillis, 10);
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
        Renderer[] rendererArr = this.enabledRenderers;
        int length = rendererArr.length;
        int i6 = 0;
        boolean z5 = true;
        boolean z6 = true;
        while (i6 < length) {
            Renderer renderer = rendererArr[i6];
            int i7 = i6;
            renderer.render(this.rendererPositionUs, elapsedRealtime);
            if (!z6 || !renderer.isEnded()) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (renderer.isReady() || renderer.isEnded() || rendererWaitingForNextStream(renderer)) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                renderer.maybeThrowStreamError();
            }
            if (!z5 || !z4) {
                z5 = false;
            } else {
                z5 = true;
            }
            i6 = i7 + 1;
        }
        if (!z5) {
            maybeThrowPeriodPrepareError();
        }
        long j5 = playingPeriod.info.durationUs;
        if (z6 && ((j5 == C.TIME_UNSET || j5 <= this.playbackInfo.positionUs) && playingPeriod.info.isFinal)) {
            setState(4);
            stopRenderers();
        } else if (this.playbackInfo.playbackState == 2 && shouldTransitionToReadyState(z5)) {
            setState(3);
            if (this.playWhenReady) {
                startRenderers();
            }
        } else if (this.playbackInfo.playbackState == 3 && (this.enabledRenderers.length != 0 ? !z5 : !isTimelineReady())) {
            this.rebuffering = this.playWhenReady;
            setState(2);
            stopRenderers();
        }
        if (this.playbackInfo.playbackState == 2) {
            for (Renderer maybeThrowStreamError : this.enabledRenderers) {
                maybeThrowStreamError.maybeThrowStreamError();
            }
        }
        if ((this.playWhenReady && this.playbackInfo.playbackState == 3) || (i5 = this.playbackInfo.playbackState) == 2) {
            scheduleNextWork(uptimeMillis, 10);
        } else if (this.enabledRenderers.length == 0 || i5 == 4) {
            this.handler.removeMessages(2);
        } else {
            scheduleNextWork(uptimeMillis, 1000);
        }
        TraceUtil.endSection();
    }

    private void enableRenderer(int i5, boolean z4, int i6) throws ExoPlaybackException {
        boolean z5;
        boolean z6;
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        Renderer renderer = this.renderers[i5];
        this.enabledRenderers[i6] = renderer;
        if (renderer.getState() == 0) {
            TrackSelectorResult trackSelectorResult = playingPeriod.trackSelectorResult;
            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i5];
            Format[] formats = getFormats(trackSelectorResult.selections.get(i5));
            if (!this.playWhenReady || this.playbackInfo.playbackState != 3) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z4 || !z5) {
                z6 = false;
            } else {
                z6 = true;
            }
            renderer.enable(rendererConfiguration, formats, playingPeriod.sampleStreams[i5], this.rendererPositionUs, z6, playingPeriod.getRendererOffset());
            this.mediaClock.onRendererEnabled(renderer);
            if (z5) {
                renderer.start();
            }
        }
    }

    private void enableRenderers(boolean[] zArr, int i5) throws ExoPlaybackException {
        this.enabledRenderers = new Renderer[i5];
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        int i6 = 0;
        for (int i7 = 0; i7 < this.renderers.length; i7++) {
            if (playingPeriod.trackSelectorResult.isRendererEnabled(i7)) {
                enableRenderer(i7, zArr[i7], i6);
                i6++;
            }
        }
    }

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private int getFirstPeriodIndex() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return 0;
        }
        return timeline.getWindow(timeline.getFirstWindowIndex(this.shuffleModeEnabled), this.window).firstPeriodIndex;
    }

    @NonNull
    private static Format[] getFormats(TrackSelection trackSelection) {
        int i5;
        if (trackSelection != null) {
            i5 = trackSelection.length();
        } else {
            i5 = 0;
        }
        Format[] formatArr = new Format[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            formatArr[i6] = trackSelection.getFormat(i6);
        }
        return formatArr;
    }

    private Pair<Integer, Long> getPeriodPosition(Timeline timeline, int i5, long j5) {
        return timeline.getPeriodPosition(this.window, this.period, i5, j5);
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackParameters().speed);
            updateLoadControlTrackSelection(loadingPeriod.trackGroups, loadingPeriod.trackSelectorResult);
            if (!this.queue.hasPlayingPeriod()) {
                resetRendererPosition(this.queue.advancePlayingPeriod().info.startPositionUs);
                updatePlayingPeriodRenderers((MediaPeriodHolder) null);
            }
            maybeContinueLoading();
        }
    }

    private void handleSourceInfoRefreshEndedPlayback() {
        setState(4);
        resetInternal(false, true, false);
    }

    private void handleSourceInfoRefreshed(MediaSourceRefreshInfo mediaSourceRefreshInfo) throws ExoPlaybackException {
        Object obj;
        long j5;
        long j6;
        long j7;
        MediaSourceRefreshInfo mediaSourceRefreshInfo2 = mediaSourceRefreshInfo;
        if (mediaSourceRefreshInfo2.source == this.mediaSource) {
            Timeline timeline = this.playbackInfo.timeline;
            Timeline timeline2 = mediaSourceRefreshInfo2.timeline;
            Object obj2 = mediaSourceRefreshInfo2.manifest;
            this.queue.setTimeline(timeline2);
            this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2, obj2);
            resolvePendingMessagePositions();
            int i5 = this.pendingPrepareCount;
            long j8 = 0;
            if (i5 > 0) {
                this.playbackInfoUpdate.incrementPendingOperationAcks(i5);
                this.pendingPrepareCount = 0;
                SeekPosition seekPosition = this.pendingInitialSeekPosition;
                if (seekPosition != null) {
                    Pair<Integer, Long> resolveSeekPosition = resolveSeekPosition(seekPosition, true);
                    this.pendingInitialSeekPosition = null;
                    if (resolveSeekPosition == null) {
                        handleSourceInfoRefreshEndedPlayback();
                        return;
                    }
                    int intValue = ((Integer) resolveSeekPosition.first).intValue();
                    long longValue = ((Long) resolveSeekPosition.second).longValue();
                    MediaSource.MediaPeriodId resolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(intValue, longValue);
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    if (resolveMediaPeriodIdForAds.isAd()) {
                        j7 = 0;
                    } else {
                        j7 = longValue;
                    }
                    this.playbackInfo = playbackInfo2.fromNewPosition(resolveMediaPeriodIdForAds, j7, longValue);
                } else if (this.playbackInfo.startPositionUs != C.TIME_UNSET) {
                } else {
                    if (timeline2.isEmpty()) {
                        handleSourceInfoRefreshEndedPlayback();
                        return;
                    }
                    Pair<Integer, Long> periodPosition = getPeriodPosition(timeline2, timeline2.getFirstWindowIndex(this.shuffleModeEnabled), C.TIME_UNSET);
                    int intValue2 = ((Integer) periodPosition.first).intValue();
                    long longValue2 = ((Long) periodPosition.second).longValue();
                    MediaSource.MediaPeriodId resolveMediaPeriodIdForAds2 = this.queue.resolveMediaPeriodIdForAds(intValue2, longValue2);
                    PlaybackInfo playbackInfo3 = this.playbackInfo;
                    if (resolveMediaPeriodIdForAds2.isAd()) {
                        j6 = 0;
                    } else {
                        j6 = longValue2;
                    }
                    this.playbackInfo = playbackInfo3.fromNewPosition(resolveMediaPeriodIdForAds2, j6, longValue2);
                }
            } else {
                PlaybackInfo playbackInfo4 = this.playbackInfo;
                int i6 = playbackInfo4.periodId.periodIndex;
                long j9 = playbackInfo4.contentPositionUs;
                if (!timeline.isEmpty()) {
                    MediaPeriodHolder frontPeriod = this.queue.getFrontPeriod();
                    if (frontPeriod == null) {
                        obj = timeline.getPeriod(i6, this.period, true).uid;
                    } else {
                        obj = frontPeriod.uid;
                    }
                    int indexOfPeriod = timeline2.getIndexOfPeriod(obj);
                    if (indexOfPeriod == -1) {
                        int resolveSubsequentPeriod = resolveSubsequentPeriod(i6, timeline, timeline2);
                        if (resolveSubsequentPeriod == -1) {
                            handleSourceInfoRefreshEndedPlayback();
                            return;
                        }
                        Pair<Integer, Long> periodPosition2 = getPeriodPosition(timeline2, timeline2.getPeriod(resolveSubsequentPeriod, this.period).windowIndex, C.TIME_UNSET);
                        int intValue3 = ((Integer) periodPosition2.first).intValue();
                        long longValue3 = ((Long) periodPosition2.second).longValue();
                        MediaSource.MediaPeriodId resolveMediaPeriodIdForAds3 = this.queue.resolveMediaPeriodIdForAds(intValue3, longValue3);
                        timeline2.getPeriod(intValue3, this.period, true);
                        if (frontPeriod != null) {
                            Object obj3 = this.period.uid;
                            frontPeriod.info = frontPeriod.info.copyWithPeriodIndex(-1);
                            while (true) {
                                frontPeriod = frontPeriod.next;
                                if (frontPeriod == null) {
                                    break;
                                } else if (frontPeriod.uid.equals(obj3)) {
                                    frontPeriod.info = this.queue.getUpdatedMediaPeriodInfo(frontPeriod.info, intValue3);
                                } else {
                                    frontPeriod.info = frontPeriod.info.copyWithPeriodIndex(-1);
                                }
                            }
                        }
                        if (!resolveMediaPeriodIdForAds3.isAd()) {
                            j8 = longValue3;
                        }
                        this.playbackInfo = this.playbackInfo.fromNewPosition(resolveMediaPeriodIdForAds3, seekToPeriodPosition(resolveMediaPeriodIdForAds3, j8), longValue3);
                        return;
                    }
                    if (indexOfPeriod != i6) {
                        this.playbackInfo = this.playbackInfo.copyWithPeriodIndex(indexOfPeriod);
                    }
                    MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
                    if (mediaPeriodId.isAd()) {
                        MediaSource.MediaPeriodId resolveMediaPeriodIdForAds4 = this.queue.resolveMediaPeriodIdForAds(indexOfPeriod, j9);
                        if (!resolveMediaPeriodIdForAds4.equals(mediaPeriodId)) {
                            if (!resolveMediaPeriodIdForAds4.isAd()) {
                                j8 = j9;
                            }
                            this.playbackInfo = this.playbackInfo.fromNewPosition(resolveMediaPeriodIdForAds4, seekToPeriodPosition(resolveMediaPeriodIdForAds4, j8), j9);
                            return;
                        }
                    }
                    if (!this.queue.updateQueuedPeriods(mediaPeriodId, this.rendererPositionUs)) {
                        seekToCurrentPosition(false);
                    }
                } else if (!timeline2.isEmpty()) {
                    MediaSource.MediaPeriodId resolveMediaPeriodIdForAds5 = this.queue.resolveMediaPeriodIdForAds(i6, j9);
                    long j10 = j9;
                    PlaybackInfo playbackInfo5 = this.playbackInfo;
                    if (resolveMediaPeriodIdForAds5.isAd()) {
                        j5 = 0;
                    } else {
                        j5 = j10;
                    }
                    this.playbackInfo = playbackInfo5.fromNewPosition(resolveMediaPeriodIdForAds5, j5, j10);
                }
            }
        }
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j5 = playingPeriod.info.durationUs;
        if (j5 == C.TIME_UNSET || this.playbackInfo.positionUs < j5) {
            return true;
        }
        MediaPeriodHolder mediaPeriodHolder = playingPeriod.next;
        if (mediaPeriodHolder == null) {
            return false;
        }
        if (mediaPeriodHolder.prepared || mediaPeriodHolder.info.id.isAd()) {
            return true;
        }
        return false;
    }

    private void maybeContinueLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long nextLoadPositionUs = loadingPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            setIsLoading(false);
            return;
        }
        boolean shouldContinueLoading = this.loadControl.shouldContinueLoading(nextLoadPositionUs - loadingPeriod.toPeriodTime(this.rendererPositionUs), this.mediaClock.getPlaybackParameters().speed);
        setIsLoading(shouldContinueLoading);
        if (shouldContinueLoading) {
            loadingPeriod.continueLoading(this.rendererPositionUs);
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        int i5;
        if (this.playbackInfoUpdate.hasPendingUpdate(this.playbackInfo)) {
            Handler handler2 = this.eventHandler;
            int access$100 = this.playbackInfoUpdate.operationAcks;
            if (this.playbackInfoUpdate.positionDiscontinuity) {
                i5 = this.playbackInfoUpdate.discontinuityReason;
            } else {
                i5 = -1;
            }
            handler2.obtainMessage(0, access$100, i5, this.playbackInfo).sendToTarget();
            this.playbackInfoUpdate.reset(this.playbackInfo);
        }
    }

    private void maybeThrowPeriodPrepareError() throws IOException {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (loadingPeriod != null && !loadingPeriod.prepared) {
            if (readingPeriod == null || readingPeriod.next == loadingPeriod) {
                Renderer[] rendererArr = this.enabledRenderers;
                int length = rendererArr.length;
                int i5 = 0;
                while (i5 < length) {
                    if (rendererArr[i5].hasReadStreamToEnd()) {
                        i5++;
                    } else {
                        return;
                    }
                }
                loadingPeriod.mediaPeriod.maybeThrowPrepareError();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b A[LOOP:1: B:24:0x006b->B:34:0x008b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0055 A[EDGE_INSN: B:55:0x0055->B:20:0x0055 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x006a A[EDGE_INSN: B:60:0x006a->B:23:0x006a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void maybeTriggerPendingMessages(long r7, long r9) throws com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException {
        /*
            r6 = this;
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r0 = r6.pendingMessages
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00e5
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r0 = r6.playbackInfo
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId
            boolean r0 = r0.isAd()
            if (r0 == 0) goto L_0x0014
            goto L_0x00e5
        L_0x0014:
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r0 = r6.playbackInfo
            long r1 = r0.startPositionUs
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x001f
            r1 = 1
            long r7 = r7 - r1
        L_0x001f:
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId
            int r0 = r0.periodIndex
            int r1 = r6.nextPendingMessageIndex
            r2 = 0
            if (r1 <= 0) goto L_0x0033
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r6.pendingMessages
            int r1 = r1 + -1
            java.lang.Object r1 = r3.get(r1)
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r1 = (com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x0034
        L_0x0033:
            r1 = r2
        L_0x0034:
            if (r1 == 0) goto L_0x0055
            int r3 = r1.resolvedPeriodIndex
            if (r3 > r0) goto L_0x0042
            if (r3 != r0) goto L_0x0055
            long r3 = r1.resolvedPeriodTimeUs
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0055
        L_0x0042:
            int r1 = r6.nextPendingMessageIndex
            int r3 = r1 + -1
            r6.nextPendingMessageIndex = r3
            if (r3 <= 0) goto L_0x0033
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r6.pendingMessages
            int r1 = r1 + -2
            java.lang.Object r1 = r3.get(r1)
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r1 = (com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x0034
        L_0x0055:
            int r1 = r6.nextPendingMessageIndex
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r6.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x006a
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r1 = r6.pendingMessages
            int r3 = r6.nextPendingMessageIndex
            java.lang.Object r1 = r1.get(r3)
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r1 = (com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x006b
        L_0x006a:
            r1 = r2
        L_0x006b:
            if (r1 == 0) goto L_0x0096
            java.lang.Object r3 = r1.resolvedPeriodUid
            if (r3 == 0) goto L_0x0096
            int r3 = r1.resolvedPeriodIndex
            if (r3 < r0) goto L_0x007d
            if (r3 != r0) goto L_0x0096
            long r3 = r1.resolvedPeriodTimeUs
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0096
        L_0x007d:
            int r1 = r6.nextPendingMessageIndex
            int r1 = r1 + 1
            r6.nextPendingMessageIndex = r1
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r6.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x006a
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r1 = r6.pendingMessages
            int r3 = r6.nextPendingMessageIndex
            java.lang.Object r1 = r1.get(r3)
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r1 = (com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x006b
        L_0x0096:
            if (r1 == 0) goto L_0x00e5
            java.lang.Object r3 = r1.resolvedPeriodUid
            if (r3 == 0) goto L_0x00e5
            int r3 = r1.resolvedPeriodIndex
            if (r3 != r0) goto L_0x00e5
            long r3 = r1.resolvedPeriodTimeUs
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x00e5
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 > 0) goto L_0x00e5
            com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage r3 = r1.message
            r6.sendMessageToTarget(r3)
            com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage r3 = r1.message
            boolean r3 = r3.getDeleteAfterDelivery()
            if (r3 != 0) goto L_0x00c7
            com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage r1 = r1.message
            boolean r1 = r1.isCanceled()
            if (r1 == 0) goto L_0x00c0
            goto L_0x00c7
        L_0x00c0:
            int r1 = r6.nextPendingMessageIndex
            int r1 = r1 + 1
            r6.nextPendingMessageIndex = r1
            goto L_0x00ce
        L_0x00c7:
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r1 = r6.pendingMessages
            int r3 = r6.nextPendingMessageIndex
            r1.remove(r3)
        L_0x00ce:
            int r1 = r6.nextPendingMessageIndex
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r6.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x00e3
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r1 = r6.pendingMessages
            int r3 = r6.nextPendingMessageIndex
            java.lang.Object r1 = r1.get(r3)
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r1 = (com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x0096
        L_0x00e3:
            r1 = r2
            goto L_0x0096
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal.maybeTriggerPendingMessages(long, long):void");
    }

    private void maybeUpdateLoadingPeriod() throws IOException {
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod()) {
            MediaPeriodInfo nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo);
            if (nextMediaPeriodInfo == null) {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
                return;
            }
            this.queue.enqueueNextMediaPeriod(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSource, this.playbackInfo.timeline.getPeriod(nextMediaPeriodInfo.id.periodIndex, this.period, true).uid, nextMediaPeriodInfo).prepare(this, nextMediaPeriodInfo.startPositionUs);
            setIsLoading(true);
        }
    }

    private void prepareInternal(MediaSource mediaSource2, boolean z4, boolean z5) {
        this.pendingPrepareCount++;
        resetInternal(true, z4, z5);
        this.loadControl.onPrepared();
        this.mediaSource = mediaSource2;
        setState(2);
        mediaSource2.prepareSource(this.player, true, this);
        this.handler.sendEmptyMessage(2);
    }

    private void releaseInternal() {
        resetInternal(true, true, true);
        this.loadControl.onReleased();
        setState(1);
        this.internalPlaybackThread.quitSafely();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private boolean rendererWaitingForNextStream(Renderer renderer) {
        MediaPeriodHolder mediaPeriodHolder = this.queue.getReadingPeriod().next;
        if (mediaPeriodHolder == null || !mediaPeriodHolder.prepared || !renderer.hasReadStreamToEnd()) {
            return false;
        }
        return true;
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        boolean z4;
        if (this.queue.hasPlayingPeriod()) {
            float f5 = this.mediaClock.getPlaybackParameters().speed;
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
            boolean z5 = true;
            while (playingPeriod != null && playingPeriod.prepared) {
                if (playingPeriod.selectTracks(f5)) {
                    if (z5) {
                        MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                        boolean removeAfter = this.queue.removeAfter(playingPeriod2);
                        boolean[] zArr = new boolean[this.renderers.length];
                        long applyTrackSelection = playingPeriod2.applyTrackSelection(this.playbackInfo.positionUs, removeAfter, zArr);
                        updateLoadControlTrackSelection(playingPeriod2.trackGroups, playingPeriod2.trackSelectorResult);
                        PlaybackInfo playbackInfo2 = this.playbackInfo;
                        if (!(playbackInfo2.playbackState == 4 || applyTrackSelection == playbackInfo2.positionUs)) {
                            PlaybackInfo playbackInfo3 = this.playbackInfo;
                            this.playbackInfo = playbackInfo3.fromNewPosition(playbackInfo3.periodId, applyTrackSelection, playbackInfo3.contentPositionUs);
                            this.playbackInfoUpdate.setPositionDiscontinuity(4);
                            resetRendererPosition(applyTrackSelection);
                        }
                        boolean[] zArr2 = new boolean[this.renderers.length];
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            Renderer[] rendererArr = this.renderers;
                            if (i5 >= rendererArr.length) {
                                break;
                            }
                            Renderer renderer = rendererArr[i5];
                            if (renderer.getState() != 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            zArr2[i5] = z4;
                            SampleStream sampleStream = playingPeriod2.sampleStreams[i5];
                            if (sampleStream != null) {
                                i6++;
                            }
                            if (z4) {
                                if (sampleStream != renderer.getStream()) {
                                    disableRenderer(renderer);
                                } else if (zArr[i5]) {
                                    renderer.resetPosition(this.rendererPositionUs);
                                }
                            }
                            i5++;
                        }
                        this.playbackInfo = this.playbackInfo.copyWithTrackInfo(playingPeriod2.trackGroups, playingPeriod2.trackSelectorResult);
                        enableRenderers(zArr2, i6);
                    } else {
                        this.queue.removeAfter(playingPeriod);
                        if (playingPeriod.prepared) {
                            playingPeriod.applyTrackSelection(Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                            updateLoadControlTrackSelection(playingPeriod.trackGroups, playingPeriod.trackSelectorResult);
                        }
                    }
                    if (this.playbackInfo.playbackState != 4) {
                        maybeContinueLoading();
                        updatePlaybackPositions();
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
                if (playingPeriod == readingPeriod) {
                    z5 = false;
                }
                playingPeriod = playingPeriod.next;
            }
        }
    }

    private void resetInternal(boolean z4, boolean z5, boolean z6) {
        Timeline timeline;
        Object obj;
        MediaSource.MediaPeriodId mediaPeriodId;
        long j5;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        MediaSource mediaSource2;
        this.handler.removeMessages(2);
        this.rebuffering = false;
        this.mediaClock.stop();
        this.rendererPositionUs = 0;
        for (Renderer disableRenderer : this.enabledRenderers) {
            try {
                disableRenderer(disableRenderer);
            } catch (ExoPlaybackException | RuntimeException e5) {
                Log.e(TAG, "Stop failed.", e5);
            }
        }
        this.enabledRenderers = new Renderer[0];
        this.queue.clear(!z5);
        setIsLoading(false);
        if (z5) {
            this.pendingInitialSeekPosition = null;
        }
        if (z6) {
            this.queue.setTimeline(Timeline.EMPTY);
            ArrayList<PendingMessageInfo> arrayList = this.pendingMessages;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                PendingMessageInfo pendingMessageInfo = arrayList.get(i5);
                i5++;
                pendingMessageInfo.message.markAsProcessed(false);
            }
            this.pendingMessages.clear();
            this.nextPendingMessageIndex = 0;
        }
        if (z6) {
            timeline = Timeline.EMPTY;
        } else {
            timeline = this.playbackInfo.timeline;
        }
        Timeline timeline2 = timeline;
        if (z6) {
            obj = null;
        } else {
            obj = this.playbackInfo.manifest;
        }
        if (z5) {
            mediaPeriodId = new MediaSource.MediaPeriodId(getFirstPeriodIndex());
        } else {
            mediaPeriodId = this.playbackInfo.periodId;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j6 = C.TIME_UNSET;
        if (z5) {
            j5 = -9223372036854775807L;
        } else {
            j5 = this.playbackInfo.positionUs;
        }
        if (!z5) {
            j6 = this.playbackInfo.contentPositionUs;
        }
        long j7 = j6;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        int i6 = playbackInfo2.playbackState;
        if (z6) {
            trackGroupArray = TrackGroupArray.EMPTY;
        } else {
            trackGroupArray = playbackInfo2.trackGroups;
        }
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        if (z6) {
            trackSelectorResult = this.emptyTrackSelectorResult;
        } else {
            trackSelectorResult = playbackInfo2.trackSelectorResult;
        }
        this.playbackInfo = new PlaybackInfo(timeline2, obj, mediaPeriodId2, j5, j7, i6, false, trackGroupArray2, trackSelectorResult);
        if (z4 && (mediaSource2 = this.mediaSource) != null) {
            mediaSource2.releaseSource(this);
            this.mediaSource = null;
        }
    }

    private void resetRendererPosition(long j5) throws ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            j5 = this.queue.getPlayingPeriod().toRendererTime(j5);
        }
        this.rendererPositionUs = j5;
        this.mediaClock.resetPosition(j5);
        for (Renderer resetPosition : this.enabledRenderers) {
            resetPosition.resetPosition(this.rendererPositionUs);
        }
    }

    private boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo) {
        Object obj = pendingMessageInfo.resolvedPeriodUid;
        if (obj == null) {
            Pair<Integer, Long> resolveSeekPosition = resolveSeekPosition(new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getWindowIndex(), C.msToUs(pendingMessageInfo.message.getPositionMs())), false);
            if (resolveSeekPosition == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(((Integer) resolveSeekPosition.first).intValue(), ((Long) resolveSeekPosition.second).longValue(), this.playbackInfo.timeline.getPeriod(((Integer) resolveSeekPosition.first).intValue(), this.period, true).uid);
        } else {
            int indexOfPeriod = this.playbackInfo.timeline.getIndexOfPeriod(obj);
            if (indexOfPeriod == -1) {
                return false;
            }
            pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        }
        return true;
    }

    private void resolvePendingMessagePositions() {
        for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size))) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
        }
        Collections.sort(this.pendingMessages);
    }

    private Pair<Integer, Long> resolveSeekPosition(SeekPosition seekPosition, boolean z4) {
        Timeline timeline;
        int resolveSubsequentPeriod;
        Timeline timeline2 = this.playbackInfo.timeline;
        Timeline timeline3 = seekPosition.timeline;
        if (timeline2.isEmpty()) {
            return null;
        }
        if (timeline3.isEmpty()) {
            timeline = timeline2;
        } else {
            timeline = timeline3;
        }
        try {
            Pair<Integer, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            if (timeline2 == timeline) {
                return periodPosition;
            }
            int indexOfPeriod = timeline2.getIndexOfPeriod(timeline.getPeriod(((Integer) periodPosition.first).intValue(), this.period, true).uid);
            if (indexOfPeriod != -1) {
                return Pair.create(Integer.valueOf(indexOfPeriod), periodPosition.second);
            }
            if (!z4 || (resolveSubsequentPeriod = resolveSubsequentPeriod(((Integer) periodPosition.first).intValue(), timeline, timeline2)) == -1) {
                return null;
            }
            return getPeriodPosition(timeline2, timeline2.getPeriod(resolveSubsequentPeriod, this.period).windowIndex, C.TIME_UNSET);
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalSeekPositionException(timeline2, seekPosition.windowIndex, seekPosition.windowPositionUs);
        }
    }

    private int resolveSubsequentPeriod(int i5, Timeline timeline, Timeline timeline2) {
        int periodCount = timeline.getPeriodCount();
        int i6 = 0;
        int i7 = i5;
        int i8 = -1;
        while (i6 < periodCount && i8 == -1) {
            Timeline timeline3 = timeline;
            i7 = timeline3.getNextPeriodIndex(i7, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (i7 == -1) {
                break;
            }
            i8 = timeline2.getIndexOfPeriod(timeline3.getPeriod(i7, this.period, true).uid);
            i6++;
            timeline = timeline3;
        }
        return i8;
    }

    private void scheduleNextWork(long j5, long j6) {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageAtTime(2, j5 + j6);
    }

    private void seekToCurrentPosition(boolean z4) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.id;
        long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true);
        if (seekToPeriodPosition != this.playbackInfo.positionUs) {
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            this.playbackInfo = playbackInfo2.fromNewPosition(mediaPeriodId, seekToPeriodPosition, playbackInfo2.contentPositionUs);
            if (z4) {
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void seekToInternal(com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal.SeekPosition r21) throws com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r2 = r1.playbackInfoUpdate
            r3 = 1
            r2.incrementPendingOperationAcks(r3)
            android.util.Pair r2 = r1.resolveSeekPosition(r0, r3)
            r4 = 0
            r6 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 != 0) goto L_0x0027
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource$MediaPeriodId r2 = new com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource$MediaPeriodId
            int r9 = r1.getFirstPeriodIndex()
            r2.<init>(r9)
            r15 = r2
            r2 = r3
            r12 = r7
            r18 = r12
            goto L_0x005b
        L_0x0027:
            java.lang.Object r9 = r2.first
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.lang.Object r10 = r2.second
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            com.mbridge.msdk.playercommon.exoplayer2.MediaPeriodQueue r12 = r1.queue
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource$MediaPeriodId r9 = r12.resolveMediaPeriodIdForAds(r9, r10)
            boolean r12 = r9.isAd()
            if (r12 == 0) goto L_0x0049
            r2 = r3
            r12 = r4
        L_0x0045:
            r15 = r9
            r18 = r10
            goto L_0x005b
        L_0x0049:
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r12 = r2.longValue()
            long r14 = r0.windowPositionUs
            int r2 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x0059
            r2 = r3
            goto L_0x0045
        L_0x0059:
            r2 = r6
            goto L_0x0045
        L_0x005b:
            r9 = 2
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource r10 = r1.mediaSource     // Catch:{ all -> 0x0071 }
            if (r10 == 0) goto L_0x00c9
            int r10 = r1.pendingPrepareCount     // Catch:{ all -> 0x0071 }
            if (r10 <= 0) goto L_0x0065
            goto L_0x00c9
        L_0x0065:
            int r0 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0074
            r0 = 4
            r1.setState(r0)     // Catch:{ all -> 0x0071 }
            r1.resetInternal(r6, r3, r6)     // Catch:{ all -> 0x0071 }
            goto L_0x00cb
        L_0x0071:
            r0 = move-exception
            goto L_0x00d9
        L_0x0074:
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r0 = r1.playbackInfo     // Catch:{ all -> 0x0071 }
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId     // Catch:{ all -> 0x0071 }
            boolean r0 = r15.equals(r0)     // Catch:{ all -> 0x0071 }
            if (r0 == 0) goto L_0x00ba
            com.mbridge.msdk.playercommon.exoplayer2.MediaPeriodQueue r0 = r1.queue     // Catch:{ all -> 0x0071 }
            com.mbridge.msdk.playercommon.exoplayer2.MediaPeriodHolder r0 = r0.getPlayingPeriod()     // Catch:{ all -> 0x0071 }
            if (r0 == 0) goto L_0x0093
            int r4 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0093
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod r0 = r0.mediaPeriod     // Catch:{ all -> 0x0071 }
            com.mbridge.msdk.playercommon.exoplayer2.SeekParameters r4 = r1.seekParameters     // Catch:{ all -> 0x0071 }
            long r4 = r0.getAdjustedSeekPositionUs(r12, r4)     // Catch:{ all -> 0x0071 }
            goto L_0x0094
        L_0x0093:
            r4 = r12
        L_0x0094:
            long r7 = com.mbridge.msdk.playercommon.exoplayer2.C.usToMs(r4)     // Catch:{ all -> 0x0071 }
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r0 = r1.playbackInfo     // Catch:{ all -> 0x0071 }
            long r10 = r0.positionUs     // Catch:{ all -> 0x0071 }
            long r10 = com.mbridge.msdk.playercommon.exoplayer2.C.usToMs(r10)     // Catch:{ all -> 0x0071 }
            int r0 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x00bb
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r0 = r1.playbackInfo     // Catch:{ all -> 0x0071 }
            long r3 = r0.positionUs     // Catch:{ all -> 0x0071 }
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r14 = r1.playbackInfo
            r16 = r3
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r0 = r14.fromNewPosition(r15, r16, r18)
            r1.playbackInfo = r0
            if (r2 == 0) goto L_0x00d8
        L_0x00b4:
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r0 = r1.playbackInfoUpdate
            r0.setPositionDiscontinuity(r9)
            return
        L_0x00ba:
            r4 = r12
        L_0x00bb:
            long r4 = r1.seekToPeriodPosition(r15, r4)     // Catch:{ all -> 0x0071 }
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r3 = r6
        L_0x00c5:
            r2 = r2 | r3
            r16 = r4
            goto L_0x00cd
        L_0x00c9:
            r1.pendingInitialSeekPosition = r0     // Catch:{ all -> 0x0071 }
        L_0x00cb:
            r16 = r12
        L_0x00cd:
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r14 = r1.playbackInfo
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r0 = r14.fromNewPosition(r15, r16, r18)
            r1.playbackInfo = r0
            if (r2 == 0) goto L_0x00d8
            goto L_0x00b4
        L_0x00d8:
            return
        L_0x00d9:
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r14 = r1.playbackInfo
            r16 = r12
            com.mbridge.msdk.playercommon.exoplayer2.PlaybackInfo r3 = r14.fromNewPosition(r15, r16, r18)
            r1.playbackInfo = r3
            if (r2 == 0) goto L_0x00ea
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r2 = r1.playbackInfoUpdate
            r2.setPositionDiscontinuity(r9)
        L_0x00ea:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal.seekToInternal(com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal$SeekPosition):void");
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j5) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j5, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod());
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == C.TIME_UNSET) {
            sendMessageToTarget(playerMessage);
        } else if (this.mediaSource == null || this.pendingPrepareCount > 0) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
        } else {
            PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
            if (resolvePendingMessagePosition(pendingMessageInfo)) {
                this.pendingMessages.add(pendingMessageInfo);
                Collections.sort(this.pendingMessages);
                return;
            }
            playerMessage.markAsProcessed(false);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getHandler().getLooper() == this.handler.getLooper()) {
            deliverMessage(playerMessage);
            int i5 = this.playbackInfo.playbackState;
            if (i5 == 3 || i5 == 2) {
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.handler.obtainMessage(15, playerMessage).sendToTarget();
    }

    private void sendMessageToTargetThread(final PlayerMessage playerMessage) {
        playerMessage.getHandler().post(new Runnable() {
            public void run() {
                try {
                    ExoPlayerImplInternal.this.deliverMessage(playerMessage);
                } catch (ExoPlaybackException e5) {
                    Log.e(ExoPlayerImplInternal.TAG, "Unexpected error delivering message on external thread.", e5);
                    throw new RuntimeException(e5);
                }
            }
        });
    }

    private void setIsLoading(boolean z4) {
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.isLoading != z4) {
            this.playbackInfo = playbackInfo2.copyWithIsLoading(z4);
        }
    }

    private void setPlayWhenReadyInternal(boolean z4) throws ExoPlaybackException {
        this.rebuffering = false;
        this.playWhenReady = z4;
        if (!z4) {
            stopRenderers();
            updatePlaybackPositions();
            return;
        }
        int i5 = this.playbackInfo.playbackState;
        if (i5 == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (i5 == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) {
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void setRepeatModeInternal(int i5) throws ExoPlaybackException {
        this.repeatMode = i5;
        if (!this.queue.updateRepeatMode(i5)) {
            seekToCurrentPosition(true);
        }
    }

    private void setSeekParametersInternal(SeekParameters seekParameters2) {
        this.seekParameters = seekParameters2;
    }

    private void setShuffleModeEnabledInternal(boolean z4) throws ExoPlaybackException {
        this.shuffleModeEnabled = z4;
        if (!this.queue.updateShuffleModeEnabled(z4)) {
            seekToCurrentPosition(true);
        }
    }

    private void setState(int i5) {
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.playbackState != i5) {
            this.playbackInfo = playbackInfo2.copyWithPlaybackState(i5);
        }
    }

    private boolean shouldKeepPeriodHolder(MediaSource.MediaPeriodId mediaPeriodId, long j5, MediaPeriodHolder mediaPeriodHolder) {
        if (!mediaPeriodId.equals(mediaPeriodHolder.info.id) || !mediaPeriodHolder.prepared) {
            return false;
        }
        this.playbackInfo.timeline.getPeriod(mediaPeriodHolder.info.id.periodIndex, this.period);
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j5);
        if (adGroupIndexAfterPositionUs == -1 || this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) == mediaPeriodHolder.info.endPositionUs) {
            return true;
        }
        return false;
    }

    private boolean shouldTransitionToReadyState(boolean z4) {
        if (this.enabledRenderers.length == 0) {
            return isTimelineReady();
        }
        if (!z4) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long bufferedPositionUs = loadingPeriod.getBufferedPositionUs(!loadingPeriod.info.isFinal);
        if (bufferedPositionUs == Long.MIN_VALUE || this.loadControl.shouldStartPlayback(bufferedPositionUs - loadingPeriod.toPeriodTime(this.rendererPositionUs), this.mediaClock.getPlaybackParameters().speed, this.rebuffering)) {
            return true;
        }
        return false;
    }

    private void startRenderers() throws ExoPlaybackException {
        this.rebuffering = false;
        this.mediaClock.start();
        for (Renderer start : this.enabledRenderers) {
            start.start();
        }
    }

    private void stopInternal(boolean z4, boolean z5) {
        resetInternal(true, z4, z4);
        this.playbackInfoUpdate.incrementPendingOperationAcks(this.pendingPrepareCount + (z5 ? 1 : 0));
        this.pendingPrepareCount = 0;
        this.loadControl.onStopped();
        setState(1);
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer ensureStopped : this.enabledRenderers) {
            ensureStopped(ensureStopped);
        }
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        boolean z4;
        boolean z5;
        int i5;
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            if (this.pendingPrepareCount > 0) {
                mediaSource2.maybeThrowSourceInfoRefreshError();
                return;
            }
            maybeUpdateLoadingPeriod();
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            int i6 = 0;
            if (loadingPeriod == null || loadingPeriod.isFullyBuffered()) {
                setIsLoading(false);
            } else if (!this.playbackInfo.isLoading) {
                maybeContinueLoading();
            }
            if (this.queue.hasPlayingPeriod()) {
                MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
                MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
                boolean z6 = false;
                while (this.playWhenReady && playingPeriod != readingPeriod && this.rendererPositionUs >= playingPeriod.next.rendererPositionOffsetUs) {
                    if (z6) {
                        maybeNotifyPlaybackInfoChanged();
                    }
                    if (playingPeriod.info.isLastInTimelinePeriod) {
                        i5 = 0;
                    } else {
                        i5 = 3;
                    }
                    MediaPeriodHolder advancePlayingPeriod = this.queue.advancePlayingPeriod();
                    updatePlayingPeriodRenderers(playingPeriod);
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    MediaPeriodInfo mediaPeriodInfo = advancePlayingPeriod.info;
                    this.playbackInfo = playbackInfo2.fromNewPosition(mediaPeriodInfo.id, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.contentPositionUs);
                    this.playbackInfoUpdate.setPositionDiscontinuity(i5);
                    updatePlaybackPositions();
                    playingPeriod = advancePlayingPeriod;
                    z6 = true;
                }
                if (readingPeriod.info.isFinal) {
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i6 < rendererArr.length) {
                            Renderer renderer = rendererArr[i6];
                            SampleStream sampleStream = readingPeriod.sampleStreams[i6];
                            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                                renderer.setCurrentStreamFinal();
                            }
                            i6++;
                        } else {
                            return;
                        }
                    }
                } else {
                    MediaPeriodHolder mediaPeriodHolder = readingPeriod.next;
                    if (mediaPeriodHolder != null && mediaPeriodHolder.prepared) {
                        int i7 = 0;
                        while (true) {
                            Renderer[] rendererArr2 = this.renderers;
                            if (i7 < rendererArr2.length) {
                                Renderer renderer2 = rendererArr2[i7];
                                SampleStream sampleStream2 = readingPeriod.sampleStreams[i7];
                                if (renderer2.getStream() != sampleStream2) {
                                    return;
                                }
                                if (sampleStream2 == null || renderer2.hasReadStreamToEnd()) {
                                    i7++;
                                } else {
                                    return;
                                }
                            } else {
                                TrackSelectorResult trackSelectorResult = readingPeriod.trackSelectorResult;
                                MediaPeriodHolder advanceReadingPeriod = this.queue.advanceReadingPeriod();
                                TrackSelectorResult trackSelectorResult2 = advanceReadingPeriod.trackSelectorResult;
                                if (advanceReadingPeriod.mediaPeriod.readDiscontinuity() != C.TIME_UNSET) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                int i8 = 0;
                                while (true) {
                                    Renderer[] rendererArr3 = this.renderers;
                                    if (i8 < rendererArr3.length) {
                                        Renderer renderer3 = rendererArr3[i8];
                                        if (trackSelectorResult.isRendererEnabled(i8)) {
                                            if (!z4) {
                                                if (!renderer3.isCurrentStreamFinal()) {
                                                    TrackSelection trackSelection = trackSelectorResult2.selections.get(i8);
                                                    boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i8);
                                                    if (this.rendererCapabilities[i8].getTrackType() == 5) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i8];
                                                    RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i8];
                                                    if (isRendererEnabled && rendererConfiguration2.equals(rendererConfiguration) && !z5) {
                                                        renderer3.replaceStream(getFormats(trackSelection), advanceReadingPeriod.sampleStreams[i8], advanceReadingPeriod.getRendererOffset());
                                                    }
                                                }
                                            }
                                            renderer3.setCurrentStreamFinal();
                                        }
                                        i8++;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        long j5;
        if (this.queue.hasPlayingPeriod()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            long readDiscontinuity = playingPeriod.mediaPeriod.readDiscontinuity();
            if (readDiscontinuity != C.TIME_UNSET) {
                resetRendererPosition(readDiscontinuity);
                if (readDiscontinuity != this.playbackInfo.positionUs) {
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    this.playbackInfo = playbackInfo2.fromNewPosition(playbackInfo2.periodId, readDiscontinuity, playbackInfo2.contentPositionUs);
                    this.playbackInfoUpdate.setPositionDiscontinuity(4);
                }
            } else {
                long syncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs();
                this.rendererPositionUs = syncAndGetPositionUs;
                long periodTime = playingPeriod.toPeriodTime(syncAndGetPositionUs);
                maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
                this.playbackInfo.positionUs = periodTime;
            }
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            if (this.enabledRenderers.length == 0) {
                j5 = playingPeriod.info.durationUs;
            } else {
                j5 = playingPeriod.getBufferedPositionUs(true);
            }
            playbackInfo3.bufferedPositionUs = j5;
        }
    }

    private void updatePlayingPeriodRenderers(@Nullable MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        boolean z4;
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null && mediaPeriodHolder != playingPeriod) {
            boolean[] zArr = new boolean[this.renderers.length];
            int i5 = 0;
            int i6 = 0;
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i5 < rendererArr.length) {
                    Renderer renderer = rendererArr[i5];
                    if (renderer.getState() != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zArr[i5] = z4;
                    if (playingPeriod.trackSelectorResult.isRendererEnabled(i5)) {
                        i6++;
                    }
                    if (zArr[i5] && (!playingPeriod.trackSelectorResult.isRendererEnabled(i5) || (renderer.isCurrentStreamFinal() && renderer.getStream() == mediaPeriodHolder.sampleStreams[i5]))) {
                        disableRenderer(renderer);
                    }
                    i5++;
                } else {
                    this.playbackInfo = this.playbackInfo.copyWithTrackInfo(playingPeriod.trackGroups, playingPeriod.trackSelectorResult);
                    enableRenderers(zArr, i6);
                    return;
                }
            }
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f5) {
        for (MediaPeriodHolder frontPeriod = this.queue.getFrontPeriod(); frontPeriod != null; frontPeriod = frontPeriod.next) {
            TrackSelectorResult trackSelectorResult = frontPeriod.trackSelectorResult;
            if (trackSelectorResult != null) {
                for (TrackSelection trackSelection : trackSelectorResult.selections.getAll()) {
                    if (trackSelection != null) {
                        trackSelection.onPlaybackSpeed(f5);
                    }
                }
            }
        }
    }

    public final Looper getPlaybackLooper() {
        return this.internalPlaybackThread.getLooper();
    }

    public final boolean handleMessage(Message message) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        try {
            switch (message.what) {
                case 0:
                    MediaSource mediaSource2 = (MediaSource) message.obj;
                    if (message.arg1 != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (message.arg2 != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    prepareInternal(mediaSource2, z4, z5);
                    break;
                case 1:
                    if (message.arg1 != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    setPlayWhenReadyInternal(z6);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    if (message.arg1 != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    stopInternal(z7, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handleSourceInfoRefreshed((MediaSourceRefreshInfo) message.obj);
                    break;
                case 9:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 10:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 11:
                    reselectTracksInternal();
                    break;
                case 12:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 13:
                    if (message.arg1 != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    setShuffleModeEnabledInternal(z8);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                default:
                    return false;
            }
            maybeNotifyPlaybackInfoChanged();
        } catch (ExoPlaybackException e5) {
            Log.e(TAG, "Playback error.", e5);
            stopInternal(false, false);
            this.eventHandler.obtainMessage(2, e5).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        } catch (IOException e6) {
            Log.e(TAG, "Source error.", e6);
            stopInternal(false, false);
            this.eventHandler.obtainMessage(2, ExoPlaybackException.createForSource(e6)).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        } catch (RuntimeException e7) {
            Log.e(TAG, "Internal runtime error.", e7);
            stopInternal(false, false);
            this.eventHandler.obtainMessage(2, ExoPlaybackException.createForUnexpected(e7)).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        }
        return true;
    }

    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.eventHandler.obtainMessage(1, playbackParameters).sendToTarget();
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
    }

    public final void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    public final void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline, Object obj) {
        this.handler.obtainMessage(8, new MediaSourceRefreshInfo(mediaSource2, timeline, obj)).sendToTarget();
    }

    public final void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(11);
    }

    public final void prepare(MediaSource mediaSource2, boolean z4, boolean z5) {
        this.handler.obtainMessage(0, z4 ? 1 : 0, z5 ? 1 : 0, mediaSource2).sendToTarget();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void release() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.released     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x0044
            android.os.HandlerThread r0 = r7.internalPlaybackThread     // Catch:{ all -> 0x002c }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x000e
            goto L_0x0044
        L_0x000e:
            com.mbridge.msdk.playercommon.exoplayer2.util.HandlerWrapper r0 = r7.handler     // Catch:{ all -> 0x002c }
            r1 = 7
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x002c }
            com.mbridge.msdk.playercommon.exoplayer2.util.Clock r0 = r7.clock     // Catch:{ all -> 0x002c }
            long r0 = r0.elapsedRealtime()     // Catch:{ all -> 0x002c }
            r2 = 500(0x1f4, double:2.47E-321)
            long r0 = r0 + r2
            r4 = 0
        L_0x001e:
            boolean r5 = r7.released     // Catch:{ all -> 0x002c }
            if (r5 != 0) goto L_0x0039
            r5 = 0
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0039
            r7.wait(r2)     // Catch:{ InterruptedException -> 0x002e }
            goto L_0x0030
        L_0x002c:
            r0 = move-exception
            goto L_0x0046
        L_0x002e:
            r2 = 1
            r4 = r2
        L_0x0030:
            com.mbridge.msdk.playercommon.exoplayer2.util.Clock r2 = r7.clock     // Catch:{ all -> 0x002c }
            long r2 = r2.elapsedRealtime()     // Catch:{ all -> 0x002c }
            long r2 = r0 - r2
            goto L_0x001e
        L_0x0039:
            if (r4 == 0) goto L_0x0042
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002c }
            r0.interrupt()     // Catch:{ all -> 0x002c }
        L_0x0042:
            monitor-exit(r7)
            return
        L_0x0044:
            monitor-exit(r7)
            return
        L_0x0046:
            monitor-exit(r7)     // Catch:{ all -> 0x002c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImplInternal.release():void");
    }

    public final void seekTo(Timeline timeline, int i5, long j5) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i5, j5)).sendToTarget();
    }

    public final synchronized void sendMessage(PlayerMessage playerMessage) {
        if (this.released) {
            Log.w(TAG, "Ignoring messages sent after release.");
            playerMessage.markAsProcessed(false);
            return;
        }
        this.handler.obtainMessage(14, playerMessage).sendToTarget();
    }

    public final void setPlayWhenReady(boolean z4) {
        this.handler.obtainMessage(1, z4 ? 1 : 0, 0).sendToTarget();
    }

    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public final void setRepeatMode(int i5) {
        this.handler.obtainMessage(12, i5, 0).sendToTarget();
    }

    public final void setSeekParameters(SeekParameters seekParameters2) {
        this.handler.obtainMessage(5, seekParameters2).sendToTarget();
    }

    public final void setShuffleModeEnabled(boolean z4) {
        this.handler.obtainMessage(13, z4 ? 1 : 0, 0).sendToTarget();
    }

    public final void stop(boolean z4) {
        this.handler.obtainMessage(6, z4 ? 1 : 0, 0).sendToTarget();
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(10, mediaPeriod).sendToTarget();
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j5, boolean z4) throws ExoPlaybackException {
        stopRenderers();
        this.rebuffering = false;
        setState(2);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolder = playingPeriod;
        while (true) {
            if (mediaPeriodHolder == null) {
                break;
            } else if (shouldKeepPeriodHolder(mediaPeriodId, j5, mediaPeriodHolder)) {
                this.queue.removeAfter(mediaPeriodHolder);
                break;
            } else {
                mediaPeriodHolder = this.queue.advancePlayingPeriod();
            }
        }
        if (playingPeriod != mediaPeriodHolder || z4) {
            for (Renderer disableRenderer : this.enabledRenderers) {
                disableRenderer(disableRenderer);
            }
            this.enabledRenderers = new Renderer[0];
            playingPeriod = null;
        }
        if (mediaPeriodHolder != null) {
            updatePlayingPeriodRenderers(playingPeriod);
            if (mediaPeriodHolder.hasEnabledTracks) {
                j5 = mediaPeriodHolder.mediaPeriod.seekToUs(j5);
                mediaPeriodHolder.mediaPeriod.discardBuffer(j5 - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            }
            resetRendererPosition(j5);
            maybeContinueLoading();
        } else {
            this.queue.clear(true);
            resetRendererPosition(j5);
        }
        this.handler.sendEmptyMessage(2);
        return j5;
    }
}
