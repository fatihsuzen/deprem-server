package androidx.leanback.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.SurfaceHolder;
import androidx.leanback.R;
import androidx.leanback.media.PlayerAdapter;
import java.io.IOException;

public class MediaPlayerAdapter extends PlayerAdapter {
    long mBufferedProgress;
    boolean mBufferingStart;
    Context mContext;
    final Handler mHandler = new Handler();
    boolean mHasDisplay;
    boolean mInitialized = false;
    Uri mMediaSourceUri = null;
    final MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i5) {
            MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
            mediaPlayerAdapter.mBufferedProgress = (mediaPlayerAdapter.getDuration() * ((long) i5)) / 100;
            MediaPlayerAdapter.this.getCallback().onBufferedPositionChanged(MediaPlayerAdapter.this);
        }
    };
    final MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            MediaPlayerAdapter.this.getCallback().onPlayStateChanged(MediaPlayerAdapter.this);
            MediaPlayerAdapter.this.getCallback().onPlayCompleted(MediaPlayerAdapter.this);
        }
    };
    final MediaPlayer.OnErrorListener mOnErrorListener = new MediaPlayer.OnErrorListener() {
        public boolean onError(MediaPlayer mediaPlayer, int i5, int i6) {
            PlayerAdapter.Callback callback = MediaPlayerAdapter.this.getCallback();
            MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
            callback.onError(mediaPlayerAdapter, i5, mediaPlayerAdapter.mContext.getString(R.string.lb_media_player_error, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6)}));
            return MediaPlayerAdapter.this.onError(i5, i6);
        }
    };
    final MediaPlayer.OnInfoListener mOnInfoListener = new MediaPlayer.OnInfoListener() {
        public boolean onInfo(MediaPlayer mediaPlayer, int i5, int i6) {
            boolean z4;
            if (i5 == 701) {
                MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
                mediaPlayerAdapter.mBufferingStart = true;
                mediaPlayerAdapter.notifyBufferingStartEnd();
            } else if (i5 != 702) {
                z4 = false;
                boolean onInfo = MediaPlayerAdapter.this.onInfo(i5, i6);
                if (!z4 || onInfo) {
                    return true;
                }
                return false;
            } else {
                MediaPlayerAdapter mediaPlayerAdapter2 = MediaPlayerAdapter.this;
                mediaPlayerAdapter2.mBufferingStart = false;
                mediaPlayerAdapter2.notifyBufferingStartEnd();
            }
            z4 = true;
            boolean onInfo2 = MediaPlayerAdapter.this.onInfo(i5, i6);
            if (!z4) {
            }
            return true;
        }
    };
    MediaPlayer.OnPreparedListener mOnPreparedListener = new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
            mediaPlayerAdapter.mInitialized = true;
            mediaPlayerAdapter.notifyBufferingStartEnd();
            MediaPlayerAdapter mediaPlayerAdapter2 = MediaPlayerAdapter.this;
            if (mediaPlayerAdapter2.mSurfaceHolderGlueHost == null || mediaPlayerAdapter2.mHasDisplay) {
                mediaPlayerAdapter2.getCallback().onPreparedStateChanged(MediaPlayerAdapter.this);
            }
        }
    };
    final MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener = new MediaPlayer.OnSeekCompleteListener() {
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            MediaPlayerAdapter.this.onSeekComplete();
        }
    };
    final MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i5, int i6) {
            MediaPlayerAdapter.this.getCallback().onVideoSizeChanged(MediaPlayerAdapter.this, i5, i6);
        }
    };
    final MediaPlayer mPlayer = new MediaPlayer();
    final Runnable mRunnable = new Runnable() {
        public void run() {
            MediaPlayerAdapter.this.getCallback().onCurrentPositionChanged(MediaPlayerAdapter.this);
            MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
            mediaPlayerAdapter.mHandler.postDelayed(this, (long) mediaPlayerAdapter.getProgressUpdatingInterval());
        }
    };
    SurfaceHolderGlueHost mSurfaceHolderGlueHost;

    class VideoPlayerSurfaceHolderCallback implements SurfaceHolder.Callback {
        VideoPlayerSurfaceHolderCallback() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i5, int i6, int i7) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            MediaPlayerAdapter.this.setDisplay(surfaceHolder);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            MediaPlayerAdapter.this.setDisplay((SurfaceHolder) null);
        }
    }

    public MediaPlayerAdapter(Context context) {
        this.mContext = context;
    }

    private void prepareMediaForPlaying() {
        reset();
        try {
            Uri uri = this.mMediaSourceUri;
            if (uri != null) {
                this.mPlayer.setDataSource(this.mContext, uri);
                this.mPlayer.setAudioStreamType(3);
                this.mPlayer.setOnPreparedListener(this.mOnPreparedListener);
                this.mPlayer.setOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
                this.mPlayer.setOnErrorListener(this.mOnErrorListener);
                this.mPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
                this.mPlayer.setOnCompletionListener(this.mOnCompletionListener);
                this.mPlayer.setOnInfoListener(this.mOnInfoListener);
                this.mPlayer.setOnBufferingUpdateListener(this.mOnBufferingUpdateListener);
                notifyBufferingStartEnd();
                this.mPlayer.prepareAsync();
                getCallback().onPlayStateChanged(this);
            }
        } catch (IOException e5) {
            e5.printStackTrace();
            throw new RuntimeException(e5);
        }
    }

    /* access modifiers changed from: package-private */
    public void changeToUnitialized() {
        if (this.mInitialized) {
            this.mInitialized = false;
            notifyBufferingStartEnd();
            if (this.mHasDisplay) {
                getCallback().onPreparedStateChanged(this);
            }
        }
    }

    public long getBufferedPosition() {
        return this.mBufferedProgress;
    }

    public long getCurrentPosition() {
        if (this.mInitialized) {
            return (long) this.mPlayer.getCurrentPosition();
        }
        return -1;
    }

    public long getDuration() {
        if (this.mInitialized) {
            return (long) this.mPlayer.getDuration();
        }
        return -1;
    }

    public final MediaPlayer getMediaPlayer() {
        return this.mPlayer;
    }

    public int getProgressUpdatingInterval() {
        return 16;
    }

    public boolean isPlaying() {
        if (!this.mInitialized || !this.mPlayer.isPlaying()) {
            return false;
        }
        return true;
    }

    public boolean isPrepared() {
        if (!this.mInitialized) {
            return false;
        }
        if (this.mSurfaceHolderGlueHost == null || this.mHasDisplay) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void notifyBufferingStartEnd() {
        boolean z4;
        PlayerAdapter.Callback callback = getCallback();
        if (this.mBufferingStart || !this.mInitialized) {
            z4 = true;
        } else {
            z4 = false;
        }
        callback.onBufferingStateChanged(this, z4);
    }

    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        if (playbackGlueHost instanceof SurfaceHolderGlueHost) {
            SurfaceHolderGlueHost surfaceHolderGlueHost = (SurfaceHolderGlueHost) playbackGlueHost;
            this.mSurfaceHolderGlueHost = surfaceHolderGlueHost;
            surfaceHolderGlueHost.setSurfaceHolderCallback(new VideoPlayerSurfaceHolderCallback());
        }
    }

    public void onDetachedFromHost() {
        SurfaceHolderGlueHost surfaceHolderGlueHost = this.mSurfaceHolderGlueHost;
        if (surfaceHolderGlueHost != null) {
            surfaceHolderGlueHost.setSurfaceHolderCallback((SurfaceHolder.Callback) null);
            this.mSurfaceHolderGlueHost = null;
        }
        reset();
        release();
    }

    /* access modifiers changed from: protected */
    public boolean onError(int i5, int i6) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onInfo(int i5, int i6) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSeekComplete() {
    }

    public void pause() {
        if (isPlaying()) {
            this.mPlayer.pause();
            getCallback().onPlayStateChanged(this);
        }
    }

    public void play() {
        if (this.mInitialized && !this.mPlayer.isPlaying()) {
            this.mPlayer.start();
            getCallback().onPlayStateChanged(this);
            getCallback().onCurrentPositionChanged(this);
        }
    }

    public void release() {
        changeToUnitialized();
        this.mHasDisplay = false;
        this.mPlayer.release();
    }

    public void reset() {
        changeToUnitialized();
        this.mPlayer.reset();
    }

    public void seekTo(long j5) {
        if (this.mInitialized) {
            this.mPlayer.seekTo((int) j5);
        }
    }

    public boolean setDataSource(Uri uri) {
        Uri uri2 = this.mMediaSourceUri;
        if (uri2 != null) {
            if (uri2.equals(uri)) {
                return false;
            }
        } else if (uri == null) {
            return false;
        }
        this.mMediaSourceUri = uri;
        prepareMediaForPlaying();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setDisplay(SurfaceHolder surfaceHolder) {
        boolean z4;
        boolean z5 = this.mHasDisplay;
        if (surfaceHolder != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mHasDisplay = z4;
        if (z5 != z4) {
            this.mPlayer.setDisplay(surfaceHolder);
            if (this.mHasDisplay) {
                if (this.mInitialized) {
                    getCallback().onPreparedStateChanged(this);
                }
            } else if (this.mInitialized) {
                getCallback().onPreparedStateChanged(this);
            }
        }
    }

    public void setProgressUpdatingEnabled(boolean z4) {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (z4) {
            this.mHandler.postDelayed(this.mRunnable, (long) getProgressUpdatingInterval());
        }
    }
}
