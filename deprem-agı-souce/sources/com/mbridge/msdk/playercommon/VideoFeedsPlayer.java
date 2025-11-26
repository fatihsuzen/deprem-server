package com.mbridge.msdk.playercommon;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerFactory;
import com.mbridge.msdk.playercommon.exoplayer2.LoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.RenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSourceFactory;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VideoFeedsPlayer implements Player.EventListener {
    public static final int INTERVAL_TIME_PLAY_TIME_CD_THREAD = 1000;
    public static final String TAG = "VideoFeedsPlayer";
    /* access modifiers changed from: private */
    public SimpleExoPlayer exoPlayer;
    private boolean isStart = false;
    private int mBufferTime = 5;
    private Timer mBufferTimeoutTimer;
    /* access modifiers changed from: private */
    public long mCurrentPosition;
    /* access modifiers changed from: private */
    public View mFullScreenLoadingView;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };
    /* access modifiers changed from: private */
    public boolean mHasPrepare = false;
    /* access modifiers changed from: private */
    public volatile VideoPlayerStatusListener mInnerVFPLisener;
    /* access modifiers changed from: private */
    public boolean mIsBuffering = false;
    /* access modifiers changed from: private */
    public boolean mIsComplete = false;
    private boolean mIsFrontDesk = true;
    private boolean mIsNeedBufferingTimeout = false;
    private boolean mIsPlaying = false;
    private boolean mIsSilent;
    /* access modifiers changed from: private */
    public WeakReference<View> mLoadingView;
    private Object mLock = new Object();
    /* access modifiers changed from: private */
    public volatile VideoPlayerStatusListener mOutterVFListener;
    private String mPlayUrl;
    private SurfaceHolder mSurfaceHolder;
    private MediaSource mediaSource;
    private Runnable playProgressRunnable = new Runnable() {
        public void run() {
            long j5;
            try {
                if (VideoFeedsPlayer.this.exoPlayer != null && VideoFeedsPlayer.this.exoPlayerIsPlaying()) {
                    VideoFeedsPlayer videoFeedsPlayer = VideoFeedsPlayer.this;
                    long unused = videoFeedsPlayer.mCurrentPosition = videoFeedsPlayer.exoPlayer.getCurrentPosition();
                    float access$100 = (float) (VideoFeedsPlayer.this.mCurrentPosition % 1000);
                    int round = Math.round(((float) VideoFeedsPlayer.this.mCurrentPosition) / 1000.0f);
                    af.c(VideoFeedsPlayer.TAG, "currentPosition:" + round + " mCurrentPosition:" + VideoFeedsPlayer.this.mCurrentPosition);
                    if (VideoFeedsPlayer.this.exoPlayer == null || VideoFeedsPlayer.this.exoPlayer.getDuration() <= 0) {
                        j5 = 0;
                    } else {
                        j5 = VideoFeedsPlayer.this.exoPlayer.getDuration() / 1000;
                        if (access$100 > 0.0f && access$100 < 500.0f) {
                            round++;
                        }
                    }
                    if (round >= 0 && j5 > 0 && ((long) round) < 1 + j5) {
                        VideoFeedsPlayer.this.postOnPlayProgressOnMainThread(round, (int) j5);
                    }
                    boolean unused2 = VideoFeedsPlayer.this.mIsComplete = false;
                    if (!VideoFeedsPlayer.this.mIsBuffering) {
                        VideoFeedsPlayer.this.hideLoading();
                    }
                    VideoFeedsPlayer.this.mHandler.postDelayed(this, 1000);
                }
            } catch (Exception e5) {
                af.b(VideoFeedsPlayer.TAG, e5.getMessage());
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
                        if (!(VideoFeedsPlayer.this.mLoadingView == null || VideoFeedsPlayer.this.mLoadingView.get() == null)) {
                            ((View) VideoFeedsPlayer.this.mLoadingView.get()).setVisibility(8);
                        }
                        if (VideoFeedsPlayer.this.mFullScreenLoadingView != null) {
                            VideoFeedsPlayer.this.mFullScreenLoadingView.setVisibility(8);
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
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onBufferingEnd();
                            } catch (Exception e5) {
                                af.b(VideoFeedsPlayer.TAG, e5.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onBufferingEnd();
                            } catch (Exception e6) {
                                af.b(VideoFeedsPlayer.TAG, e6.getMessage());
                            }
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
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onBufferingStart(str);
                            } catch (Exception e5) {
                                af.b(VideoFeedsPlayer.TAG, e5.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onBufferingStart(str);
                            } catch (Exception e6) {
                                af.b(VideoFeedsPlayer.TAG, e6.getMessage());
                            }
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
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayCompleted();
                            } catch (Exception e5) {
                                af.b(VideoFeedsPlayer.TAG, e5.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayCompleted();
                            } catch (Exception e6) {
                                af.b(VideoFeedsPlayer.TAG, e6.getMessage());
                            }
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
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayError(str);
                            } catch (Exception e5) {
                                af.b(VideoFeedsPlayer.TAG, e5.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayError(str);
                            } catch (Exception e6) {
                                af.b(VideoFeedsPlayer.TAG, e6.getMessage());
                            }
                        }
                    }
                });
            }
            i.a(94, this.mPlayUrl, str);
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
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayProgress(i5, i6);
                            } catch (Exception e5) {
                                af.b(VideoFeedsPlayer.TAG, e5.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayProgress(i5, i6);
                            } catch (Exception e6) {
                                af.b(VideoFeedsPlayer.TAG, e6.getMessage());
                            }
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
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlaySetDataSourceError(str);
                            } catch (Exception e5) {
                                af.b(VideoFeedsPlayer.TAG, e5.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlaySetDataSourceError(str);
                            } catch (Exception e6) {
                                af.b(VideoFeedsPlayer.TAG, e6.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    private void postOnPlayStartOnMainThread(final long j5) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        int i5 = (int) j5;
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayStarted(i5);
                            } catch (Exception e5) {
                                af.b(VideoFeedsPlayer.TAG, e5.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayStarted(i5);
                            } catch (Exception e6) {
                                af.b(VideoFeedsPlayer.TAG, e6.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    private void startBufferIngTimer(final String str) {
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
                    if (VideoFeedsPlayer.this.mHasPrepare) {
                        if (!VideoFeedsPlayer.this.mIsBuffering) {
                            return;
                        }
                    }
                    af.b(VideoFeedsPlayer.TAG, "缓冲超时");
                    VideoFeedsPlayer.this.postOnBufferingStarOnMainThread(str);
                } catch (Exception e5) {
                    af.b(VideoFeedsPlayer.TAG, e5.getMessage());
                }
            }
        }, (long) (this.mBufferTime * 1000));
    }

    private void startPlayProgressTimer() {
        try {
            cancelPlayProgressTimer();
            this.mHandler.post(this.playProgressRunnable);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void closeSound() {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setVolume(0.0f);
                this.mIsSilent = true;
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

    public boolean fullScreenLoadingViewisVisible() {
        try {
            View view = this.mFullScreenLoadingView;
            if (view == null || view.getVisibility() != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            return false;
        }
    }

    public int getCurPosition() {
        return (int) this.mCurrentPosition;
    }

    public int getDuration() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer == null) {
            return 0;
        }
        simpleExoPlayer.getDuration();
        return 0;
    }

    public float getVolume() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer.getVolume();
        }
        return 0.0f;
    }

    public boolean halfLoadingViewisVisible() {
        try {
            WeakReference<View> weakReference = this.mLoadingView;
            if (weakReference == null || weakReference.get() == null || this.mLoadingView.get().getVisibility() != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            return false;
        }
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

    public boolean initPlayer(Context context, View view, String str, VideoPlayerStatusListener videoPlayerStatusListener) {
        if (view == null) {
            try {
                af.c(TAG, "loadingView is NULL");
                postOnPlayErrorOnMainThread(PlayerErrorConstant.MEDIAPLAYER_INIT_FAILED);
                return false;
            } catch (Throwable th) {
                af.b(TAG, th.getMessage());
                postOnPlayErrorOnMainThread(th.toString());
                return false;
            }
        } else {
            this.mOutterVFListener = videoPlayerStatusListener;
            this.mLoadingView = new WeakReference<>(view);
            this.exoPlayer = ExoPlayerFactory.newSimpleInstance((RenderersFactory) new DefaultRenderersFactory(context), (TrackSelector) new DefaultTrackSelector(), (LoadControl) new DefaultLoadControl());
            this.mediaSource = new ExtractorMediaSource.Factory(new DefaultDataSourceFactory(context, "MBridge_ExoPlayer")).createMediaSource(Uri.parse(str));
            this.exoPlayer.setRepeatMode(0);
            this.exoPlayer.prepare(this.mediaSource);
            this.exoPlayer.addListener(this);
            return true;
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

    public boolean isSilent() {
        return this.mIsSilent;
    }

    public void justSeekTo(int i5) {
        try {
            this.mCurrentPosition = (long) i5;
            if (!this.mHasPrepare) {
                af.a(TAG, "seekTo return mHasPrepare false");
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void onBufferingUpdate(int i5) {
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
            af.b(TAG, "onError what: " + i5 + " extra: " + str);
            hideLoading();
            if (!this.mIsFrontDesk && "MIX 3".equalsIgnoreCase(ab.h()) && ab.x().equalsIgnoreCase("Xiaomi")) {
                return true;
            }
            this.mHasPrepare = false;
            postOnPlayErrorOnMainThread(str);
            return true;
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
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
            startBufferIngTimer(PlayerErrorConstant.PLAYERING_TIMEOUT);
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
        }
    }

    public void onPositionDiscontinuity(int i5) {
    }

    public void onPrepared() {
        try {
            af.c(TAG, "onPrepared:" + this.mHasPrepare);
            this.mHasPrepare = true;
            boolean z4 = this.mIsFrontDesk;
            if (!z4) {
                af.b(TAG, "At background, Do not process");
                if (this.exoPlayer != null) {
                    pause();
                }
            } else if (z4) {
                hideLoading();
                SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
                if (simpleExoPlayer != null) {
                    this.mIsPlaying = true;
                    if (!this.isStart) {
                        postOnPlayStartOnMainThread(simpleExoPlayer.getDuration() / 1000);
                        af.c(TAG, "onPlayStarted()，getCurrentPosition:" + this.exoPlayer.getCurrentPosition());
                        this.isStart = true;
                    }
                }
                postOnBufferinEndOnMainThread();
                startPlayProgressTimer();
                af.c(TAG, "onPrepare mCurrentPosition:" + this.mCurrentPosition + " onPrepare mHasPrepare：" + this.mHasPrepare);
            }
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
                this.mIsSilent = false;
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void pause() {
        try {
            if (this.mHasPrepare) {
                if (this.exoPlayer != null && exoPlayerIsPlaying()) {
                    af.c(TAG, "pause isPalying:" + exoPlayerIsPlaying() + " mIsPlaying:" + this.mIsPlaying);
                    hideLoading();
                    this.exoPlayer.setPlayWhenReady(false);
                    this.mIsPlaying = false;
                }
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void play(String str, int i5) {
        try {
            synchronized (this.mLock) {
                af.b(TAG, "Start Play currentionPosition:" + this.mCurrentPosition);
                if (i5 > 0) {
                    this.mCurrentPosition = (long) i5;
                }
                if (TextUtils.isEmpty(str)) {
                    postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                    return;
                }
                this.mPlayUrl = str;
                this.mHasPrepare = false;
                this.mIsFrontDesk = true;
                showLoading();
                setDataSource();
                af.c(TAG, "mPlayUrl:" + this.mPlayUrl);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        } catch (Throwable th) {
            while (true) {
            }
            throw th;
        }
    }

    public void prepare() {
        try {
            if (!this.mHasPrepare) {
                SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
                if (simpleExoPlayer != null) {
                    simpleExoPlayer.prepare(this.mediaSource);
                    this.mHasPrepare = true;
                    this.mIsPlaying = false;
                }
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void releasePlayer() {
        try {
            af.c(TAG, "release");
            cancelPlayProgressTimer();
            cancelBufferTimeoutTimer();
            if (this.exoPlayer != null) {
                stop();
                this.exoPlayer.removeListener(this);
                this.exoPlayer.release();
                this.mInnerVFPLisener = null;
                this.mOutterVFListener = null;
            }
            hideLoading();
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public void seekTo(int i5) {
        long j5 = (long) i5;
        try {
            this.mCurrentPosition = j5;
            if (!this.mHasPrepare) {
                af.a(TAG, "seekTo return mHasPrepare false");
                return;
            }
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.seekTo(j5);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void seekToEndFrame() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.seekTo(simpleExoPlayer.getCurrentPosition() - 500);
        }
    }

    public void setDataSource() {
        try {
            af.c(TAG, "setDataSource");
            if (this.exoPlayer != null) {
                SurfaceHolder surfaceHolder = this.mSurfaceHolder;
                if (surfaceHolder != null) {
                    setDisplay(surfaceHolder);
                }
                this.mHasPrepare = false;
                this.exoPlayer.prepare(this.mediaSource);
                this.exoPlayer.setPlayWhenReady(true);
                startBufferIngTimer(PlayerErrorConstant.PREPARE_TIMEOUT);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.ILLEGAL_VIDEO_ADDRESS);
            postOnPlaySetDataSourceError2MainThread(PlayerErrorConstant.ILLEGAL_VIDEO_ADDRESS);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            this.exoPlayer.getVideoComponent().setVideoSurfaceHolder(surfaceHolder);
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            postOnPlayErrorOnMainThread(th.toString());
        }
    }

    public void setFullScreenLoadingView(View view) {
        if (view != null) {
            try {
                this.mFullScreenLoadingView = view;
            } catch (Exception e5) {
                af.b(TAG, e5.getMessage());
            }
        }
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

    public void setPlaybackParams(float f5) {
        try {
            if (exoPlayerIsPlaying()) {
                this.exoPlayer.setPlaybackParameters(new PlaybackParameters(f5));
                return;
            }
            this.exoPlayer.setPlaybackParameters(new PlaybackParameters(f5));
            this.exoPlayer.stop();
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public void setSelfVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mInnerVFPLisener = videoPlayerStatusListener;
    }

    public void setVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mOutterVFListener = videoPlayerStatusListener;
    }

    public void setVolume(float f5, float f6) {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setVolume(f6);
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public void showLoading() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoFeedsPlayer.this.mFullScreenLoadingView != null) {
                            VideoFeedsPlayer.this.mFullScreenLoadingView.setVisibility(0);
                        }
                    }
                });
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void start(boolean z4) {
        try {
            if (!this.mHasPrepare) {
                af.c(TAG, "!mHasPrepare");
            } else if (this.exoPlayer != null && !exoPlayerIsPlaying()) {
                showLoading();
                play();
                this.mIsPlaying = true;
                if (z4) {
                    startPlayProgressTimer();
                }
                af.c(TAG, "start");
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void stop() {
        try {
            if (this.mHasPrepare) {
                if (this.exoPlayer != null && exoPlayerIsPlaying()) {
                    hideLoading();
                    this.exoPlayer.stop();
                    this.mHasPrepare = false;
                    this.mIsPlaying = false;
                    this.mIsComplete = true;
                }
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void start(int i5) {
        try {
            if (this.mHasPrepare) {
                if (this.exoPlayer != null && !exoPlayerIsPlaying()) {
                    if (i5 > 0) {
                        this.exoPlayer.seekTo((long) i5);
                        play();
                        return;
                    }
                    play();
                    this.mIsPlaying = true;
                    af.c(TAG, "=========start 指定进度");
                }
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void play(String str, SurfaceHolder surfaceHolder) {
        try {
            synchronized (this.mLock) {
                if (TextUtils.isEmpty(str)) {
                    postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                    return;
                }
                this.mPlayUrl = str;
                this.mHasPrepare = false;
                this.mIsFrontDesk = true;
                this.mSurfaceHolder = surfaceHolder;
                showLoading();
                setDataSource();
                af.c(TAG, "mPlayUrl:" + this.mPlayUrl);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        } catch (Throwable th) {
            while (true) {
            }
            throw th;
        }
    }

    public void play() {
        this.exoPlayer.setPlayWhenReady(true);
    }
}
