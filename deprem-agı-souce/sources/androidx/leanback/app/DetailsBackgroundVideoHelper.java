package androidx.leanback.app;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.widget.DetailsParallax;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.ParallaxEffect;
import androidx.leanback.widget.ParallaxTarget;

final class DetailsBackgroundVideoHelper {
    private static final long BACKGROUND_CROSS_FADE_DURATION = 500;
    private static final long CROSSFADE_DELAY = 1000;
    static final int INITIAL = 0;
    static final int NO_VIDEO = 2;
    static final int PLAY_VIDEO = 1;
    ValueAnimator mBackgroundAnimator;
    Drawable mBackgroundDrawable;
    private boolean mBackgroundDrawableVisible;
    PlaybackControlStateCallback mControlStateCallback = new PlaybackControlStateCallback();
    private int mCurrentState = 0;
    private final DetailsParallax mDetailsParallax;
    private ParallaxEffect mParallaxEffect;
    private PlaybackGlue mPlaybackGlue;

    private class PlaybackControlStateCallback extends PlaybackGlue.PlayerCallback {
        PlaybackControlStateCallback() {
        }

        public void onPreparedStateChanged(PlaybackGlue playbackGlue) {
            if (playbackGlue.isPrepared()) {
                DetailsBackgroundVideoHelper.this.internalStartPlayback();
            }
        }
    }

    DetailsBackgroundVideoHelper(PlaybackGlue playbackGlue, DetailsParallax detailsParallax, Drawable drawable) {
        this.mPlaybackGlue = playbackGlue;
        this.mDetailsParallax = detailsParallax;
        this.mBackgroundDrawable = drawable;
        this.mBackgroundDrawableVisible = true;
        drawable.setAlpha(255);
        startParallax();
    }

    private void applyState() {
        int i5 = this.mCurrentState;
        if (i5 == 1) {
            PlaybackGlue playbackGlue = this.mPlaybackGlue;
            if (playbackGlue == null) {
                crossFadeBackgroundToVideo(false);
            } else if (playbackGlue.isPrepared()) {
                internalStartPlayback();
            } else {
                this.mPlaybackGlue.addPlayerCallback(this.mControlStateCallback);
            }
        } else if (i5 == 2) {
            crossFadeBackgroundToVideo(false);
            PlaybackGlue playbackGlue2 = this.mPlaybackGlue;
            if (playbackGlue2 != null) {
                playbackGlue2.removePlayerCallback(this.mControlStateCallback);
                this.mPlaybackGlue.pause();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void crossFadeBackgroundToVideo(boolean z4) {
        crossFadeBackgroundToVideo(z4, false);
    }

    /* access modifiers changed from: package-private */
    public void internalStartPlayback() {
        PlaybackGlue playbackGlue = this.mPlaybackGlue;
        if (playbackGlue != null) {
            playbackGlue.play();
        }
        this.mDetailsParallax.getRecyclerView().postDelayed(new Runnable() {
            public void run() {
                DetailsBackgroundVideoHelper.this.crossFadeBackgroundToVideo(true);
            }
        }, 1000);
    }

    /* access modifiers changed from: package-private */
    public boolean isVideoVisible() {
        if (this.mCurrentState == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setPlaybackGlue(PlaybackGlue playbackGlue) {
        PlaybackGlue playbackGlue2 = this.mPlaybackGlue;
        if (playbackGlue2 != null) {
            playbackGlue2.removePlayerCallback(this.mControlStateCallback);
        }
        this.mPlaybackGlue = playbackGlue;
        applyState();
    }

    /* access modifiers changed from: package-private */
    public void startParallax() {
        if (this.mParallaxEffect == null) {
            Parallax.IntProperty overviewRowTop = this.mDetailsParallax.getOverviewRowTop();
            this.mParallaxEffect = this.mDetailsParallax.addEffect(overviewRowTop.atFraction(1.0f), overviewRowTop.atFraction(0.0f)).target(new ParallaxTarget() {
                public void update(float f5) {
                    if (f5 == 1.0f) {
                        DetailsBackgroundVideoHelper.this.updateState(2);
                    } else {
                        DetailsBackgroundVideoHelper.this.updateState(1);
                    }
                }
            });
            this.mDetailsParallax.updateValues();
        }
    }

    /* access modifiers changed from: package-private */
    public void stopParallax() {
        this.mDetailsParallax.removeEffect(this.mParallaxEffect);
    }

    /* access modifiers changed from: package-private */
    public void updateState(int i5) {
        if (i5 != this.mCurrentState) {
            this.mCurrentState = i5;
            applyState();
        }
    }

    /* access modifiers changed from: package-private */
    public void crossFadeBackgroundToVideo(boolean z4, boolean z5) {
        boolean z6 = !z4;
        int i5 = 255;
        if (this.mBackgroundDrawableVisible != z6) {
            this.mBackgroundDrawableVisible = z6;
            ValueAnimator valueAnimator = this.mBackgroundAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.mBackgroundAnimator = null;
            }
            float f5 = 0.0f;
            float f6 = z4 ? 1.0f : 0.0f;
            if (!z4) {
                f5 = 1.0f;
            }
            Drawable drawable = this.mBackgroundDrawable;
            if (drawable != null) {
                if (z5) {
                    if (z4) {
                        i5 = 0;
                    }
                    drawable.setAlpha(i5);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f6, f5});
                this.mBackgroundAnimator = ofFloat;
                ofFloat.setDuration(BACKGROUND_CROSS_FADE_DURATION);
                this.mBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        DetailsBackgroundVideoHelper.this.mBackgroundDrawable.setAlpha((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f));
                    }
                });
                this.mBackgroundAnimator.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        DetailsBackgroundVideoHelper.this.mBackgroundAnimator = null;
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.mBackgroundAnimator.start();
            }
        } else if (z5) {
            ValueAnimator valueAnimator2 = this.mBackgroundAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.mBackgroundAnimator = null;
            }
            Drawable drawable2 = this.mBackgroundDrawable;
            if (drawable2 != null) {
                if (z4) {
                    i5 = 0;
                }
                drawable2.setAlpha(i5);
            }
        }
    }
}
