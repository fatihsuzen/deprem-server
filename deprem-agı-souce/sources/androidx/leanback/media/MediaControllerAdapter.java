package androidx.leanback.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSource;

public class MediaControllerAdapter extends PlayerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "MediaControllerAdapter";
    private MediaControllerCompat mController;
    Handler mHandler = new Handler();
    boolean mIsBuffering = false;
    MediaControllerCompat.a mMediaControllerCallback = new MediaControllerCompat.a() {
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaControllerAdapter.this.getCallback().onMetadataChanged(MediaControllerAdapter.this);
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            if (MediaControllerAdapter.this.mIsBuffering && playbackStateCompat.h() != 6) {
                MediaControllerAdapter.this.getCallback().onBufferingStateChanged(MediaControllerAdapter.this, false);
                MediaControllerAdapter.this.getCallback().onBufferedPositionChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.mIsBuffering = false;
            }
            if (playbackStateCompat.h() != 0) {
                if (playbackStateCompat.h() == 1) {
                    MediaControllerAdapter.this.getCallback().onPlayCompleted(MediaControllerAdapter.this);
                } else if (playbackStateCompat.h() == 2) {
                    MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                    MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
                } else if (playbackStateCompat.h() == 3) {
                    MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                    MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
                } else if (playbackStateCompat.h() == 6) {
                    MediaControllerAdapter mediaControllerAdapter = MediaControllerAdapter.this;
                    mediaControllerAdapter.mIsBuffering = true;
                    mediaControllerAdapter.getCallback().onBufferingStateChanged(MediaControllerAdapter.this, true);
                    MediaControllerAdapter.this.getCallback().onBufferedPositionChanged(MediaControllerAdapter.this);
                } else if (playbackStateCompat.h() == 7) {
                    if (playbackStateCompat.e() == null) {
                        MediaControllerAdapter.this.getCallback().onError(MediaControllerAdapter.this, playbackStateCompat.d(), "");
                    } else {
                        MediaControllerAdapter.this.getCallback().onError(MediaControllerAdapter.this, playbackStateCompat.d(), playbackStateCompat.e().toString());
                    }
                } else if (playbackStateCompat.h() == 4) {
                    MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                    MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
                } else if (playbackStateCompat.h() == 5) {
                    MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                    MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
                }
            }
        }
    };
    private final Runnable mPositionUpdaterRunnable = new Runnable() {
        public void run() {
            MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
            MediaControllerAdapter mediaControllerAdapter = MediaControllerAdapter.this;
            mediaControllerAdapter.mHandler.postDelayed(this, (long) mediaControllerAdapter.getUpdatePeriod());
        }
    };

    public MediaControllerAdapter(MediaControllerCompat mediaControllerCompat) {
        if (mediaControllerCompat != null) {
            this.mController = mediaControllerCompat;
            return;
        }
        throw new NullPointerException("Object of MediaControllerCompat is null");
    }

    private int mapRepeatActionToRepeatMode(int i5) {
        if (i5 == 0) {
            return 0;
        }
        if (i5 != 1) {
            return i5 != 2 ? -1 : 1;
        }
        return 2;
    }

    private int mapShuffleActionToShuffleMode(int i5) {
        if (i5 != 0) {
            return i5 != 1 ? -1 : 1;
        }
        return 0;
    }

    public void fastForward() {
        this.mController.d().a();
    }

    public long getBufferedPosition() {
        if (this.mController.c() == null) {
            return 0;
        }
        return this.mController.c().c();
    }

    public long getCurrentPosition() {
        if (this.mController.c() == null) {
            return 0;
        }
        return this.mController.c().g();
    }

    public long getDuration() {
        if (this.mController.b() == null) {
            return 0;
        }
        return (long) ((int) this.mController.b().d("android.media.metadata.DURATION"));
    }

    public Drawable getMediaArt(Context context) {
        Bitmap b5;
        if (this.mController.b() == null || (b5 = this.mController.b().c().b()) == null) {
            return null;
        }
        return new BitmapDrawable(context.getResources(), b5);
    }

    public MediaControllerCompat getMediaController() {
        return this.mController;
    }

    public CharSequence getMediaSubtitle() {
        if (this.mController.b() == null) {
            return "";
        }
        return this.mController.b().c().d();
    }

    public CharSequence getMediaTitle() {
        if (this.mController.b() == null) {
            return "";
        }
        return this.mController.b().c().e();
    }

    public long getSupportedActions() {
        long j5;
        if (this.mController.c() == null) {
            return 0;
        }
        long b5 = this.mController.c().b();
        if ((b5 & 512) != 0) {
            j5 = 64;
        } else {
            j5 = 0;
        }
        if ((b5 & 32) != 0) {
            j5 |= 256;
        }
        if ((b5 & 16) != 0) {
            j5 |= 16;
        }
        if ((64 & b5) != 0) {
            j5 |= 128;
        }
        if ((8 & b5) != 0) {
            j5 |= 32;
        }
        if ((262144 & b5) != 0) {
            j5 |= 512;
        }
        if ((b5 & CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE) != 0) {
            return 1024 | j5;
        }
        return j5;
    }

    /* access modifiers changed from: package-private */
    public int getUpdatePeriod() {
        return 16;
    }

    public boolean isPlaying() {
        if (this.mController.c() == null) {
            return false;
        }
        if (this.mController.c().h() == 3 || this.mController.c().h() == 4 || this.mController.c().h() == 5) {
            return true;
        }
        return false;
    }

    public void next() {
        this.mController.d().h();
    }

    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        this.mController.e(this.mMediaControllerCallback);
    }

    public void onDetachedFromHost() {
        this.mController.g(this.mMediaControllerCallback);
    }

    public void pause() {
        this.mController.d().b();
    }

    public void play() {
        this.mController.d().c();
    }

    public void previous() {
        this.mController.d().i();
    }

    public void rewind() {
        this.mController.d().d();
    }

    public void seekTo(long j5) {
        this.mController.d().e(j5);
    }

    public void setProgressUpdatingEnabled(boolean z4) {
        this.mHandler.removeCallbacks(this.mPositionUpdaterRunnable);
        if (z4) {
            this.mHandler.postDelayed(this.mPositionUpdaterRunnable, (long) getUpdatePeriod());
        }
    }

    public void setRepeatAction(int i5) {
        this.mController.d().f(mapRepeatActionToRepeatMode(i5));
    }

    public void setShuffleAction(int i5) {
        this.mController.d().g(mapShuffleActionToShuffleMode(i5));
    }
}
