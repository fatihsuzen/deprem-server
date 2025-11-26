package com.mbridge.msdk.playercommon;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import java.util.Timer;
import java.util.TimerTask;

public class VideoNativePlayer implements Player.EventListener {
    public static final int INTERVAL_TIME_PLAY_TIME_CD_THREAD = 1000;
    public static final int INTERVAL_TIME_PLAY_TIME_PROGRESS = 100;
    public static final String TAG = "VideoNativePlayer";
    /* access modifiers changed from: private */
    public SimpleExoPlayer exoPlayer;
    private int mBufferTime = 5;
    private Timer mBufferTimeoutTimer;
    /* access modifiers changed from: private */
    public long mCurrentPosition;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };
    private boolean mHasChaoDi = false;
    /* access modifiers changed from: private */
    public boolean mHasPrepare = false;
    /* access modifiers changed from: private */
    public VideoPlayerStatusListener mInnerVFPLisener;
    private boolean mIsAllowLoopPlay = true;
    /* access modifiers changed from: private */
    public boolean mIsBuffering = false;
    /* access modifiers changed from: private */
    public boolean mIsComplete = false;
    private boolean mIsFrontDesk = true;
    private boolean mIsNeedBufferingTimeout = false;
    private boolean mIsOpenSound = true;
    private boolean mIsPlaying = false;
    /* access modifiers changed from: private */
    public boolean mIsStartPlay = true;
    /* access modifiers changed from: private */
    public View mLoadingView;
    private String mNetUrl;
    /* access modifiers changed from: private */
    public VideoPlayerStatusListener mOutterVFListener;
    private String mPlayUrl;
    private Surface mSurfaceHolder;
    private MediaSource mediaSource;
    private Runnable playProgressMSRunnable = new Runnable() {
        public void run() {
            long j5;
            try {
                if (VideoNativePlayer.this.exoPlayer != null && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    VideoNativePlayer videoNativePlayer = VideoNativePlayer.this;
                    long unused = videoNativePlayer.mCurrentPosition = videoNativePlayer.exoPlayer.getCurrentPosition();
                    long access$100 = VideoNativePlayer.this.mCurrentPosition / 100;
                    if (VideoNativePlayer.this.exoPlayer == null || VideoNativePlayer.this.exoPlayer.getDuration() <= 0) {
                        j5 = 0;
                    } else {
                        j5 = VideoNativePlayer.this.exoPlayer.getDuration() / 100;
                    }
                    if (access$100 >= 0 && j5 > 0 && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                        VideoNativePlayer videoNativePlayer2 = VideoNativePlayer.this;
                        videoNativePlayer2.postOnPlayProgressMSOnMainThread(videoNativePlayer2.mCurrentPosition / 100, j5);
                    }
                    VideoNativePlayer.this.mHandler.postDelayed(this, 100);
                }
            } catch (Exception e5) {
                af.b(VideoNativePlayer.TAG, e5.getMessage());
            }
        }
    };
    private Runnable playProgressRunnable = new Runnable() {
        public void run() {
            int i5;
            try {
                if (VideoNativePlayer.this.exoPlayer != null && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    VideoNativePlayer videoNativePlayer = VideoNativePlayer.this;
                    long unused = videoNativePlayer.mCurrentPosition = videoNativePlayer.exoPlayer.getCurrentPosition();
                    int access$100 = (int) (VideoNativePlayer.this.mCurrentPosition / 1000);
                    af.c(VideoNativePlayer.TAG, "currentPosition:" + access$100 + " mCurrentPosition:" + VideoNativePlayer.this.mCurrentPosition);
                    if (VideoNativePlayer.this.exoPlayer == null || VideoNativePlayer.this.exoPlayer.getDuration() <= 0) {
                        i5 = 0;
                    } else {
                        i5 = (int) (VideoNativePlayer.this.exoPlayer.getDuration() / 1000);
                    }
                    if (VideoNativePlayer.this.mIsStartPlay) {
                        VideoNativePlayer.this.postOnPlayStartOnMainThread(i5);
                        af.c(VideoNativePlayer.TAG, "onPlayStarted()");
                        boolean unused2 = VideoNativePlayer.this.mIsStartPlay = false;
                    }
                    if (access$100 >= 0 && i5 > 0 && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                        VideoNativePlayer.this.postOnPlayProgressOnMainThread(access$100, i5);
                    }
                    boolean unused3 = VideoNativePlayer.this.mIsComplete = false;
                    if (!VideoNativePlayer.this.mIsBuffering) {
                        VideoNativePlayer.this.hideLoading();
                    }
                    VideoNativePlayer.this.mHandler.postDelayed(this, 1000);
                }
            } catch (Exception e5) {
                af.b(VideoNativePlayer.TAG, e5.getMessage());
            }
        }
    };

    private void cancelBufferTimeoutTimer() {
        try {
            Timer timer = this.mBufferTimeoutTimer;
            if (timer != null) {
                timer.cancel();
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    private void cancelPlayProgressTimer() {
        try {
            this.mHandler.removeCallbacks(this.playProgressRunnable);
            this.mHandler.removeCallbacks(this.playProgressMSRunnable);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void hideLoading() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mLoadingView != null) {
                            VideoNativePlayer.this.mLoadingView.setVisibility(8);
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    private void postOnBufferinEndOnMainThread() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onBufferingEnd();
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onBufferingEnd();
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void postOnBufferingStarOnMainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onBufferingStart(str);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onBufferingStart(str);
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    private void postOnPlayCompletedOnMainThread() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayCompleted();
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayCompleted();
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    private void postOnPlayErrorOnMainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayError(str);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayError(str);
                        }
                    }
                });
            }
            i.a(42, this.mPlayUrl, str);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void postOnPlayProgressMSOnMainThread(long j5, long j6) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                final long j7 = j5;
                final long j8 = j6;
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayProgressMS((int) j7, (int) j8);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayProgressMS((int) j7, (int) j8);
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void postOnPlayProgressOnMainThread(final int i5, final int i6) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayProgress(i5, i6);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayProgress(i5, i6);
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    private void postOnPlaySetDataSourceError2MainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlaySetDataSourceError(str);
                        }
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlaySetDataSourceError(str);
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void postOnPlayStartOnMainThread(final int i5) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayStarted(i5);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayStarted(i5);
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    private void startBufferingTimer(final String str) {
        if (!this.mIsNeedBufferingTimeout) {
            af.b(TAG, "不需要缓冲超时功能");
            return;
        }
        cancelBufferTimeoutTimer();
        Timer timer = new Timer();
        this.mBufferTimeoutTimer = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                try {
                    if (VideoNativePlayer.this.mHasPrepare) {
                        if (!VideoNativePlayer.this.mIsBuffering) {
                            return;
                        }
                    }
                    af.b(VideoNativePlayer.TAG, "缓冲超时");
                    VideoNativePlayer.this.postOnBufferingStarOnMainThread(str);
                } catch (Exception e5) {
                    af.b(VideoNativePlayer.TAG, e5.getMessage());
                }
            }
        }, (long) (this.mBufferTime * 1000));
    }

    private void startPlayProgressTimer() {
        try {
            cancelPlayProgressTimer();
            this.mHandler.post(this.playProgressRunnable);
            this.mHandler.post(this.playProgressMSRunnable);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void closeSound() {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setVolume(0.0f);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public boolean exoPlayerIsPlaying() {
        if (this.exoPlayer.getPlaybackState() != 3 || !this.exoPlayer.getPlayWhenReady()) {
            return false;
        }
        return true;
    }

    public int getCurPosition() {
        return (int) this.mCurrentPosition;
    }

    public boolean hasPrepare() {
        return this.mHasPrepare;
    }

    public void initBufferIngParam(int i5) {
        if (i5 > 0) {
            this.mBufferTime = i5;
        }
        this.mIsNeedBufferingTimeout = true;
        af.c(TAG, "mIsNeedBufferingTimeout:" + this.mIsNeedBufferingTimeout + "  mMaxBufferTime:" + this.mBufferTime);
    }

    public boolean initParameter(String str, boolean z4, boolean z5, View view, VideoPlayerStatusListener videoPlayerStatusListener) {
        try {
            if (TextUtils.isEmpty(str)) {
                af.c(TAG, "netUrl为空 return");
                postOnPlayErrorOnMainThread(PlayerErrorConstant.MEDIAPLAYER_INIT_FAILED);
                return false;
            } else if (view == null) {
                af.c(TAG, "loadingView为空 return");
                postOnPlayErrorOnMainThread(PlayerErrorConstant.MEDIAPLAYER_INIT_FAILED);
                return false;
            } else {
                this.mIsOpenSound = z4;
                this.mIsAllowLoopPlay = z5;
                this.mLoadingView = view;
                this.mNetUrl = str;
                this.mOutterVFListener = videoPlayerStatusListener;
                return true;
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            postOnPlayErrorOnMainThread(th.toString());
            return false;
        }
    }

    public boolean isComplete() {
        return this.mIsComplete;
    }

    public boolean isPlayIng() {
        try {
            if (this.exoPlayer == null || !exoPlayerIsPlaying()) {
                return false;
            }
            return true;
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            return false;
        }
    }

    public boolean isPlaying() {
        return exoPlayerIsPlaying();
    }

    public boolean loadingViewIsVisible() {
        try {
            View view = this.mLoadingView;
            if (view == null || view.getVisibility() != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            return false;
        }
    }

    public void onCompletion() {
        try {
            this.mIsComplete = true;
            this.mIsPlaying = false;
            this.mCurrentPosition = 0;
            hideLoading();
            postOnPlayCompletedOnMainThread();
            af.c(TAG, "======onCompletion");
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public boolean onError(int i5, String str) {
        try {
            af.b(TAG, "onError what:" + i5 + " extra:" + str);
            hideLoading();
            this.mHasPrepare = false;
            this.mIsPlaying = false;
            postOnPlayErrorOnMainThread(str);
            return true;
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            return true;
        }
    }

    public void onLoadingChanged(boolean z4) {
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        af.b(TAG, "onPlaybackParametersChanged : " + playbackParameters.speed);
    }

    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        String str;
        if (exoPlaybackException != null) {
            int i5 = exoPlaybackException.type;
            if (i5 == 0) {
                str = "Play error, because have a SourceException.";
            } else if (i5 == 1) {
                str = "Play error, because have a RendererException.";
            } else if (i5 == 2) {
                str = "Play error, because have a UnexpectedException.";
            }
            if (exoPlaybackException.getCause() != null && !TextUtils.isEmpty(exoPlaybackException.getCause().getMessage())) {
                str = exoPlaybackException.getCause().getMessage();
            }
            af.b(TAG, "onPlayerError : " + str);
            onError(exoPlaybackException.type, str);
        }
        str = "Play error and ExoPlayer have not message.";
        str = exoPlaybackException.getCause().getMessage();
        af.b(TAG, "onPlayerError : " + str);
        onError(exoPlaybackException.type, str);
    }

    public void onPlayerStateChanged(boolean z4, int i5) {
        af.b(TAG, "onPlaybackStateChanged : " + i5);
        if (i5 == 1) {
            af.b(TAG, "onPlaybackStateChanged : IDLE");
        } else if (i5 == 2) {
            af.b(TAG, "onPlaybackStateChanged : Buffering");
            this.mIsBuffering = true;
            showLoading();
            startBufferingTimer(PlayerErrorConstant.PLAYERING_TIMEOUT);
        } else if (i5 == 3) {
            af.b(TAG, "onPlaybackStateChanged : READY");
            this.mIsBuffering = false;
            hideLoading();
            postOnBufferinEndOnMainThread();
            onPrepared();
        } else if (i5 == 4) {
            af.b(TAG, "onPlaybackStateChanged : Ended : PLAY ENDED");
            cancelPlayProgressTimer();
            onCompletion();
            if (!this.mIsAllowLoopPlay) {
                this.mHasPrepare = false;
            }
        }
    }

    public void onPositionDiscontinuity(int i5) {
        af.b(TAG, "onPositionDiscontinuity : " + i5);
        if (i5 == 0) {
            onCompletion();
        }
    }

    public void onPrepared() {
        try {
            af.c(TAG, "onPrepared:" + this.mHasPrepare);
            if (this.mIsFrontDesk) {
                this.mHasPrepare = true;
                postOnBufferinEndOnMainThread();
                startPlayProgressTimer();
                if (this.exoPlayer != null) {
                    this.mIsPlaying = true;
                }
                af.c(TAG, "onprepare mCurrentPosition:" + this.mCurrentPosition + " mHasPrepare：" + this.mHasPrepare);
                return;
            }
            af.b(TAG, "At background, Do not process");
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public void onRepeatModeChanged(int i5) {
    }

    public void onSeekProcessed() {
    }

    public void onShuffleModeEnabledChanged(boolean z4) {
    }

    public void onTimelineChanged(Timeline timeline, @Nullable Object obj, int i5) {
    }

    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public void openSound() {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setVolume(1.0f);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void pause() {
        try {
            af.c(TAG, "player pause");
            if (!this.mHasPrepare) {
                af.c(TAG, "pause !mHasPrepare retrun");
            } else if (this.exoPlayer != null && exoPlayerIsPlaying()) {
                af.c(TAG, "pause " + this.mIsPlaying);
                hideLoading();
                this.exoPlayer.setPlayWhenReady(false);
                this.mIsPlaying = false;
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void play(Context context, String str, int i5) {
        try {
            af.b(TAG, "进来播放 currentionPosition:" + this.mCurrentPosition);
            this.mCurrentPosition = (long) i5;
            if (TextUtils.isEmpty(str)) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                return;
            }
            showLoading();
            this.mPlayUrl = str;
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            setDataSource(context);
            af.c(TAG, "mPlayUrl:" + this.mPlayUrl);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    public void releasePlayer() {
        try {
            af.c(TAG, "releasePlayer");
            cancelPlayProgressTimer();
            cancelBufferTimeoutTimer();
            if (this.exoPlayer != null) {
                stop();
                this.exoPlayer.removeListener(this);
                this.exoPlayer.release();
                this.exoPlayer = null;
                this.mIsPlaying = false;
            }
            if (this.mOutterVFListener != null) {
                this.mOutterVFListener = null;
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage(), th);
        }
        hideLoading();
    }

    public void replaySameSource(Context context, String str, Surface surface) {
        MediaSource mediaSource2;
        try {
            showLoading();
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null || (mediaSource2 = this.mediaSource) == null) {
                play(context, str, surface);
                return;
            }
            simpleExoPlayer.prepare(mediaSource2);
            this.exoPlayer.setPlayWhenReady(true);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0093 A[Catch:{ Exception -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095 A[Catch:{ Exception -> 0x0028 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDataSource(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "VideoNativePlayer"
            r1 = 1
            java.lang.String r2 = "setDataSource begin"
            com.mbridge.msdk.foundation.tools.af.c(r0, r2)     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ Exception -> 0x0028 }
            if (r2 == 0) goto L_0x002b
            boolean r2 = r6.exoPlayerIsPlaying()     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x001a
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ all -> 0x0018 }
            r2.stop()     // Catch:{ all -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r2 = move-exception
            goto L_0x0020
        L_0x001a:
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ all -> 0x0018 }
            r2.release()     // Catch:{ all -> 0x0018 }
            goto L_0x002b
        L_0x0020:
            java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.foundation.tools.af.b(r0, r2)     // Catch:{ Exception -> 0x0028 }
            goto L_0x002b
        L_0x0028:
            r2 = move-exception
            goto L_0x00be
        L_0x002b:
            boolean r2 = r6.mIsOpenSound     // Catch:{ Exception -> 0x0028 }
            if (r2 != 0) goto L_0x0032
            r6.closeSound()     // Catch:{ Exception -> 0x0028 }
        L_0x0032:
            java.lang.String r2 = r6.mPlayUrl     // Catch:{ Exception -> 0x0028 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0028 }
            if (r2 != 0) goto L_0x00aa
            com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory r2 = new com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory     // Catch:{ Exception -> 0x0028 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector r3 = new com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector     // Catch:{ Exception -> 0x0028 }
            r3.<init>()     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl r4 = new com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl     // Catch:{ Exception -> 0x0028 }
            r4.<init>()     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerFactory.newSimpleInstance((com.mbridge.msdk.playercommon.exoplayer2.RenderersFactory) r2, (com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector) r3, (com.mbridge.msdk.playercommon.exoplayer2.LoadControl) r4)     // Catch:{ Exception -> 0x0028 }
            r6.exoPlayer = r2     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = r6.mPlayUrl     // Catch:{ Exception -> 0x0028 }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r3 = r6.mPlayUrl     // Catch:{ Exception -> 0x0028 }
            java.lang.String r4 = "http"
            boolean r3 = r3.startsWith(r4)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r4 = "MBridge_ExoPlayer"
            if (r3 != 0) goto L_0x007d
            java.lang.String r3 = r6.mPlayUrl     // Catch:{ Exception -> 0x0028 }
            java.lang.String r5 = "https"
            boolean r3 = r3.startsWith(r5)     // Catch:{ Exception -> 0x0028 }
            if (r3 == 0) goto L_0x006c
            goto L_0x007d
        L_0x006c:
            com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource$Factory r3 = new com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource$Factory     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSourceFactory r5 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSourceFactory     // Catch:{ Exception -> 0x0028 }
            r5.<init>(r7, r4)     // Catch:{ Exception -> 0x0028 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource r2 = r3.createMediaSource((android.net.Uri) r2)     // Catch:{ Exception -> 0x0028 }
            r6.mediaSource = r2     // Catch:{ Exception -> 0x0028 }
            goto L_0x008d
        L_0x007d:
            com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource$Factory r3 = new com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource$Factory     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultHttpDataSourceFactory r5 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultHttpDataSourceFactory     // Catch:{ Exception -> 0x0028 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0028 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource r2 = r3.createMediaSource((android.net.Uri) r2)     // Catch:{ Exception -> 0x0028 }
            r6.mediaSource = r2     // Catch:{ Exception -> 0x0028 }
        L_0x008d:
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ Exception -> 0x0028 }
            boolean r3 = r6.mIsAllowLoopPlay     // Catch:{ Exception -> 0x0028 }
            if (r3 == 0) goto L_0x0095
            r3 = 2
            goto L_0x0096
        L_0x0095:
            r3 = 0
        L_0x0096:
            r2.setRepeatMode(r3)     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource r3 = r6.mediaSource     // Catch:{ Exception -> 0x0028 }
            r2.prepare(r3)     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ Exception -> 0x0028 }
            r2.setPlayWhenReady(r1)     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ Exception -> 0x0028 }
            r2.addListener(r6)     // Catch:{ Exception -> 0x0028 }
        L_0x00aa:
            android.view.Surface r2 = r6.mSurfaceHolder     // Catch:{ Exception -> 0x0028 }
            if (r2 == 0) goto L_0x00b3
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r3 = r6.exoPlayer     // Catch:{ Exception -> 0x0028 }
            r3.setVideoSurface(r2)     // Catch:{ Exception -> 0x0028 }
        L_0x00b3:
            java.lang.String r2 = "mediaplayer prepare timeout"
            r6.startBufferingTimer(r2)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = "setDataSource done"
            com.mbridge.msdk.foundation.tools.af.c(r0, r2)     // Catch:{ Exception -> 0x0028 }
            goto L_0x0126
        L_0x00be:
            java.lang.String r2 = r2.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r2)
            r6.hideLoading()
            java.lang.String r2 = r6.mPlayUrl
            boolean r2 = android.webkit.URLUtil.isNetworkUrl(r2)
            java.lang.String r3 = "set data source error"
            java.lang.String r4 = "mediaplayer cannot play"
            if (r2 == 0) goto L_0x00f1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "setDataSource error : Is Online source : "
            r7.append(r1)
            java.lang.String r1 = r6.mNetUrl
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            com.mbridge.msdk.foundation.tools.af.c(r0, r7)
            r6.postOnPlayErrorOnMainThread(r4)
            r6.postOnPlaySetDataSourceError2MainThread(r3)
            goto L_0x0123
        L_0x00f1:
            java.lang.String r2 = r6.mNetUrl
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0120
            boolean r2 = r6.mHasChaoDi
            if (r2 != 0) goto L_0x0120
            r6.mHasChaoDi = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "setDataSource error : Will play online source : "
            r1.append(r2)
            java.lang.String r2 = r6.mNetUrl
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.mbridge.msdk.foundation.tools.af.c(r0, r1)
            java.lang.String r0 = r6.mNetUrl
            r6.mPlayUrl = r0
            r6.showLoading()
            r6.setDataSource(r7)
            goto L_0x0123
        L_0x0120:
            r6.postOnPlayErrorOnMainThread(r4)
        L_0x0123:
            r6.postOnPlaySetDataSourceError2MainThread(r3)
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.VideoNativePlayer.setDataSource(android.content.Context):void");
    }

    public void setIsComplete(boolean z4) {
        this.mIsComplete = z4;
    }

    public void setIsFrontDesk(boolean z4) {
        String str;
        try {
            this.mIsFrontDesk = z4;
            StringBuilder sb = new StringBuilder();
            sb.append("isFrontDesk: ");
            if (z4) {
                str = "frontStage";
            } else {
                str = "backStage";
            }
            sb.append(str);
            af.b(TAG, sb.toString());
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void setSelfVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mInnerVFPLisener = videoPlayerStatusListener;
    }

    public void setVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mOutterVFListener = videoPlayerStatusListener;
    }

    public void showLoading() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mLoadingView != null) {
                            VideoNativePlayer.this.mLoadingView.setVisibility(0);
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void start() {
        start((Surface) null);
    }

    public void stop() {
        try {
            if (!this.mHasPrepare) {
                af.c(TAG, "stop !mHasPrepare retrun");
            } else if (this.exoPlayer != null && exoPlayerIsPlaying()) {
                hideLoading();
                this.exoPlayer.stop();
                cancelPlayProgressTimer();
                this.mIsPlaying = false;
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void start(Surface surface) {
        try {
            if (!this.mHasPrepare) {
                af.c(TAG, "start !mHasPrepare retrun");
                return;
            }
            boolean z4 = true;
            if (this.exoPlayer == null || exoPlayerIsPlaying()) {
                StringBuilder sb = new StringBuilder();
                sb.append("exoplayer is null : ");
                if (this.exoPlayer != null) {
                    z4 = false;
                }
                sb.append(z4);
                af.c(TAG, sb.toString());
                return;
            }
            showLoading();
            if (surface != null) {
                this.mSurfaceHolder = surface;
                this.exoPlayer.setVideoSurface(surface);
            }
            play();
            startPlayProgressTimer();
            this.mIsPlaying = true;
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void start(int i5) {
        try {
            if (!this.mHasPrepare) {
                af.c(TAG, "start mHasprepare is false return");
            } else if (this.exoPlayer != null && !exoPlayerIsPlaying()) {
                if (i5 > 0) {
                    this.exoPlayer.seekTo((long) i5);
                }
                play();
                startPlayProgressTimer();
                this.mIsPlaying = true;
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void play(Context context, String str, Surface surface) {
        try {
            if (TextUtils.isEmpty(str)) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                return;
            }
            showLoading();
            this.mPlayUrl = str;
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            this.mSurfaceHolder = surface;
            setDataSource(context);
            af.c(TAG, "mPlayUrl:" + this.mPlayUrl);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    public void play() {
        try {
            this.exoPlayer.setPlayWhenReady(true);
            startPlayProgressTimer();
            this.mIsPlaying = true;
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }
}
