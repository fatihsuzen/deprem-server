package androidx.leanback.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;

@Deprecated
public abstract class MediaControllerGlue extends PlaybackControlGlue {
    static final boolean DEBUG = false;
    static final String TAG = "MediaControllerGlue";
    private final MediaControllerCompat.a mCallback = new MediaControllerCompat.a() {
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaControllerGlue.this.onMetadataChanged();
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            MediaControllerGlue.this.onStateChanged();
        }

        public void onSessionDestroyed() {
            MediaControllerGlue.this.mMediaController = null;
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }
    };
    MediaControllerCompat mMediaController;

    public MediaControllerGlue(Context context, int[] iArr, int[] iArr2) {
        super(context, iArr, iArr2);
    }

    public void attachToMediaController(MediaControllerCompat mediaControllerCompat) {
        if (mediaControllerCompat != this.mMediaController) {
            detach();
            this.mMediaController = mediaControllerCompat;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.e(this.mCallback);
            }
            onMetadataChanged();
            onStateChanged();
        }
    }

    public void detach() {
        MediaControllerCompat mediaControllerCompat = this.mMediaController;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.g(this.mCallback);
        }
        this.mMediaController = null;
    }

    public int getCurrentPosition() {
        return (int) this.mMediaController.c().g();
    }

    public int getCurrentSpeedId() {
        int f5 = (int) this.mMediaController.c().f();
        int i5 = 0;
        if (f5 == 0) {
            return 0;
        }
        if (f5 == 1) {
            return 1;
        }
        if (f5 > 0) {
            int[] fastForwardSpeeds = getFastForwardSpeeds();
            while (i5 < fastForwardSpeeds.length) {
                if (f5 == fastForwardSpeeds[i5]) {
                    return i5 + 10;
                }
                i5++;
            }
        } else {
            int[] rewindSpeeds = getRewindSpeeds();
            while (i5 < rewindSpeeds.length) {
                if ((-f5) == rewindSpeeds[i5]) {
                    return -10 - i5;
                }
                i5++;
            }
        }
        Log.w(TAG, "Couldn't find index for speed " + f5);
        return -1;
    }

    public Drawable getMediaArt() {
        Bitmap b5 = this.mMediaController.b().c().b();
        if (b5 == null) {
            return null;
        }
        return new BitmapDrawable(getContext().getResources(), b5);
    }

    public final MediaControllerCompat getMediaController() {
        return this.mMediaController;
    }

    public int getMediaDuration() {
        return (int) this.mMediaController.b().d("android.media.metadata.DURATION");
    }

    public CharSequence getMediaSubtitle() {
        return this.mMediaController.b().c().d();
    }

    public CharSequence getMediaTitle() {
        return this.mMediaController.b().c().e();
    }

    public long getSupportedActions() {
        long j5;
        long b5 = this.mMediaController.c().b();
        if ((512 & b5) != 0) {
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
        if ((b5 & 8) != 0) {
            return j5 | 32;
        }
        return j5;
    }

    public boolean hasValidMedia() {
        MediaControllerCompat mediaControllerCompat = this.mMediaController;
        if (mediaControllerCompat == null || mediaControllerCompat.b() == null) {
            return false;
        }
        return true;
    }

    public boolean isMediaPlaying() {
        if (this.mMediaController.c().h() == 3) {
            return true;
        }
        return false;
    }

    public void next() {
        this.mMediaController.d().h();
    }

    public void pause() {
        this.mMediaController.d().b();
    }

    public void play(int i5) {
        if (i5 == 1) {
            this.mMediaController.d().c();
        } else if (i5 > 0) {
            this.mMediaController.d().a();
        } else {
            this.mMediaController.d().d();
        }
    }

    public void previous() {
        this.mMediaController.d().i();
    }
}
