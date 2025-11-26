package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ViewUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialMainContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private static final float MIN_SCALE = 0.9f;
    @Nullable
    private float[] expandedCornerRadii;
    @Nullable
    private Rect initialHideFromClipBounds;
    @Nullable
    private Rect initialHideToClipBounds;
    private float initialTouchY;
    private final float maxTranslationY;
    private final float minEdgeGap;

    public MaterialMainContainerBackHelper(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.minEdgeGap = resources.getDimension(R.dimen.m3_back_progress_main_container_min_edge_gap);
        this.maxTranslationY = resources.getDimension(R.dimen.m3_back_progress_main_container_max_translation_y);
    }

    private float[] calculateExpandedCornerRadii() {
        WindowInsets rootWindowInsets;
        int i5;
        int i6;
        int i7;
        int i8;
        if (Build.VERSION.SDK_INT < 31 || (rootWindowInsets = this.view.getRootWindowInsets()) == null) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        DisplayMetrics displayMetrics = this.view.getResources().getDisplayMetrics();
        int i9 = displayMetrics.widthPixels;
        int i10 = displayMetrics.heightPixels;
        int[] iArr = new int[2];
        this.view.getLocationOnScreen(iArr);
        int i11 = iArr[0];
        int i12 = iArr[1];
        int width = this.view.getWidth();
        int height = this.view.getHeight();
        if (i11 == 0 && i12 == 0) {
            i5 = getRoundedCornerRadius(rootWindowInsets, 0);
        } else {
            i5 = 0;
        }
        int i13 = width + i11;
        if (i13 < i9 || i12 != 0) {
            i6 = 0;
        } else {
            i6 = getRoundedCornerRadius(rootWindowInsets, 1);
        }
        if (i13 < i9 || i12 + height < i10) {
            i7 = 0;
        } else {
            i7 = getRoundedCornerRadius(rootWindowInsets, 2);
        }
        if (i11 != 0 || i12 + height < i10) {
            i8 = 0;
        } else {
            i8 = getRoundedCornerRadius(rootWindowInsets, 3);
        }
        float f5 = (float) i5;
        float f6 = (float) i6;
        float f7 = (float) i7;
        float f8 = (float) i8;
        return new float[]{f5, f5, f6, f6, f7, f7, f8, f8};
    }

    @NonNull
    private ValueAnimator createCornerAnimator(ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new c(), new Object[]{clippableRoundedCornerLayout.getCornerRadii(), getExpandedCornerRadii()});
        ofObject.addUpdateListener(new d(clippableRoundedCornerLayout));
        return ofObject;
    }

    @NonNull
    private AnimatorSet createResetScaleAndTranslationAnimator(@Nullable final View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{1.0f}), ObjectAnimator.ofFloat(this.view, View.TRANSLATION_X, new float[]{0.0f}), ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Y, new float[]{0.0f})});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                View view = view;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        });
        return animatorSet;
    }

    @RequiresApi(31)
    private int getRoundedCornerRadius(WindowInsets windowInsets, int i5) {
        RoundedCorner a5 = windowInsets.getRoundedCorner(i5);
        if (a5 != null) {
            return a5.getRadius();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static float[] lerpCornerRadii(float[] fArr, float[] fArr2, float f5) {
        float f6 = f5;
        return new float[]{AnimationUtils.lerp(fArr[0], fArr2[0], f6), AnimationUtils.lerp(fArr[1], fArr2[1], f6), AnimationUtils.lerp(fArr[2], fArr2[2], f6), AnimationUtils.lerp(fArr[3], fArr2[3], f6), AnimationUtils.lerp(fArr[4], fArr2[4], f6), AnimationUtils.lerp(fArr[5], fArr2[5], f6), AnimationUtils.lerp(fArr[6], fArr2[6], f6), AnimationUtils.lerp(fArr[7], fArr2[7], f6)};
    }

    private void resetInitialValues() {
        this.initialTouchY = 0.0f;
        this.initialHideToClipBounds = null;
        this.initialHideFromClipBounds = null;
    }

    public void cancelBackProgress(@Nullable View view) {
        if (super.onCancelBackProgress() != null) {
            AnimatorSet createResetScaleAndTranslationAnimator = createResetScaleAndTranslationAnimator(view);
            V v5 = this.view;
            if (v5 instanceof ClippableRoundedCornerLayout) {
                createResetScaleAndTranslationAnimator.playTogether(new Animator[]{createCornerAnimator((ClippableRoundedCornerLayout) v5)});
            }
            createResetScaleAndTranslationAnimator.setDuration((long) this.cancelDuration);
            createResetScaleAndTranslationAnimator.start();
            resetInitialValues();
        }
    }

    public void clearExpandedCornerRadii() {
        this.expandedCornerRadii = null;
    }

    public void finishBackProgress(long j5, @Nullable View view) {
        AnimatorSet createResetScaleAndTranslationAnimator = createResetScaleAndTranslationAnimator(view);
        createResetScaleAndTranslationAnimator.setDuration(j5);
        createResetScaleAndTranslationAnimator.start();
        resetInitialValues();
    }

    @NonNull
    public float[] getExpandedCornerRadii() {
        if (this.expandedCornerRadii == null) {
            this.expandedCornerRadii = calculateExpandedCornerRadii();
        }
        return this.expandedCornerRadii;
    }

    @Nullable
    public Rect getInitialHideFromClipBounds() {
        return this.initialHideFromClipBounds;
    }

    @Nullable
    public Rect getInitialHideToClipBounds() {
        return this.initialHideToClipBounds;
    }

    public void startBackProgress(@NonNull BackEventCompat backEventCompat, @Nullable View view) {
        super.onStartBackProgress(backEventCompat);
        startBackProgress(backEventCompat.getTouchY(), view);
    }

    public void updateBackProgress(@NonNull BackEventCompat backEventCompat, @Nullable View view, float f5) {
        if (super.onUpdateBackProgress(backEventCompat) != null) {
            if (!(view == null || view.getVisibility() == 4)) {
                view.setVisibility(4);
            }
            updateBackProgress(backEventCompat.getProgress(), backEventCompat.getSwipeEdge() == 0, backEventCompat.getTouchY(), f5);
        }
    }

    @VisibleForTesting
    public void startBackProgress(float f5, @Nullable View view) {
        this.initialHideToClipBounds = ViewUtils.calculateRectFromBounds(this.view);
        if (view != null) {
            this.initialHideFromClipBounds = ViewUtils.calculateOffsetRectFromBounds(this.view, view);
        }
        this.initialTouchY = f5;
    }

    @VisibleForTesting
    public void updateBackProgress(float f5, boolean z4, float f6, float f7) {
        float interpolateProgress = interpolateProgress(f5);
        float width = (float) this.view.getWidth();
        float height = (float) this.view.getHeight();
        if (width > 0.0f && height > 0.0f) {
            float lerp = AnimationUtils.lerp(1.0f, (float) MIN_SCALE, interpolateProgress);
            float lerp2 = AnimationUtils.lerp(0.0f, Math.max(0.0f, ((width - (MIN_SCALE * width)) / 2.0f) - this.minEdgeGap), interpolateProgress) * ((float) (z4 ? 1 : -1));
            float min = Math.min(Math.max(0.0f, ((height - (lerp * height)) / 2.0f) - this.minEdgeGap), this.maxTranslationY);
            float f8 = f6 - this.initialTouchY;
            float lerp3 = AnimationUtils.lerp(0.0f, min, Math.abs(f8) / height) * Math.signum(f8);
            if (!Float.isNaN(lerp) && !Float.isNaN(lerp2) && !Float.isNaN(lerp3)) {
                this.view.setScaleX(lerp);
                this.view.setScaleY(lerp);
                this.view.setTranslationX(lerp2);
                this.view.setTranslationY(lerp3);
                V v5 = this.view;
                if (v5 instanceof ClippableRoundedCornerLayout) {
                    ((ClippableRoundedCornerLayout) v5).updateCornerRadii(lerpCornerRadii(getExpandedCornerRadii(), f7, interpolateProgress));
                }
            }
        }
    }

    private static float[] lerpCornerRadii(float[] fArr, float f5, float f6) {
        float f7 = f5;
        float f8 = f6;
        return new float[]{AnimationUtils.lerp(fArr[0], f7, f8), AnimationUtils.lerp(fArr[1], f7, f8), AnimationUtils.lerp(fArr[2], f7, f8), AnimationUtils.lerp(fArr[3], f7, f8), AnimationUtils.lerp(fArr[4], f7, f8), AnimationUtils.lerp(fArr[5], f7, f8), AnimationUtils.lerp(fArr[6], f7, f8), AnimationUtils.lerp(fArr[7], f7, f8)};
    }
}
