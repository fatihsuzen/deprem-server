package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private IndeterminateAnimatorDelegate<ObjectAnimator> animatorDelegate;
    private DrawingDelegate<S> drawingDelegate;
    private Drawable staticDummyDrawable;

    IndeterminateDrawable(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec, @NonNull DrawingDelegate<S> drawingDelegate2, @NonNull IndeterminateAnimatorDelegate<ObjectAnimator> indeterminateAnimatorDelegate) {
        super(context, baseProgressIndicatorSpec);
        setDrawingDelegate(drawingDelegate2);
        setAnimatorDelegate(indeterminateAnimatorDelegate);
    }

    @NonNull
    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return createCircularDrawable(context, circularProgressIndicatorSpec, new CircularDrawingDelegate(circularProgressIndicatorSpec));
    }

    @NonNull
    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return createLinearDrawable(context, linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec));
    }

    private boolean isSystemAnimatorDisabled() {
        AnimatorDurationScaleProvider animatorDurationScaleProvider = this.animatorDurationScaleProvider;
        if (animatorDurationScaleProvider == null || animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver()) != 0.0f) {
            return false;
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas r15) {
        /*
            r14 = this;
            r1 = r15
            android.graphics.Rect r0 = r14.getBounds()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0151
            boolean r0 = r14.isVisible()
            if (r0 == 0) goto L_0x0151
            android.graphics.Rect r0 = r14.clipBounds
            boolean r0 = r15.getClipBounds(r0)
            if (r0 != 0) goto L_0x001b
            goto L_0x0151
        L_0x001b:
            boolean r0 = r14.isSystemAnimatorDisabled()
            r8 = 0
            if (r0 == 0) goto L_0x003e
            android.graphics.drawable.Drawable r0 = r14.staticDummyDrawable
            if (r0 == 0) goto L_0x003e
            android.graphics.Rect r2 = r14.getBounds()
            r0.setBounds(r2)
            android.graphics.drawable.Drawable r0 = r14.staticDummyDrawable
            com.google.android.material.progressindicator.BaseProgressIndicatorSpec r2 = r14.baseSpec
            int[] r2 = r2.indicatorColors
            r2 = r2[r8]
            r0.setTint(r2)
            android.graphics.drawable.Drawable r0 = r14.staticDummyDrawable
            r0.draw(r15)
            return
        L_0x003e:
            r15.save()
            com.google.android.material.progressindicator.DrawingDelegate<S> r0 = r14.drawingDelegate
            android.graphics.Rect r2 = r14.getBounds()
            float r3 = r14.getGrowFraction()
            boolean r4 = r14.isShowing()
            boolean r5 = r14.isHiding()
            r0.validateSpecAndAdjustCanvas(r1, r2, r3, r4, r5)
            com.google.android.material.progressindicator.BaseProgressIndicatorSpec r0 = r14.baseSpec
            int r9 = r0.indicatorTrackGapSize
            int r6 = r14.getAlpha()
            com.google.android.material.progressindicator.BaseProgressIndicatorSpec r0 = r14.baseSpec
            boolean r1 = r0 instanceof com.google.android.material.progressindicator.LinearProgressIndicatorSpec
            r2 = 1
            if (r1 != 0) goto L_0x0073
            boolean r1 = r0 instanceof com.google.android.material.progressindicator.CircularProgressIndicatorSpec
            if (r1 == 0) goto L_0x0071
            r1 = r0
            com.google.android.material.progressindicator.CircularProgressIndicatorSpec r1 = (com.google.android.material.progressindicator.CircularProgressIndicatorSpec) r1
            boolean r1 = r1.indeterminateTrackVisible
            if (r1 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r10 = r8
            goto L_0x0074
        L_0x0073:
            r10 = r2
        L_0x0074:
            if (r10 == 0) goto L_0x0080
            if (r9 != 0) goto L_0x0080
            boolean r0 = r0.hasWavyEffect(r8)
            if (r0 != 0) goto L_0x0080
            r11 = r2
            goto L_0x0081
        L_0x0080:
            r11 = r8
        L_0x0081:
            if (r11 == 0) goto L_0x0096
            com.google.android.material.progressindicator.DrawingDelegate<S> r0 = r14.drawingDelegate
            android.graphics.Paint r2 = r14.paint
            com.google.android.material.progressindicator.BaseProgressIndicatorSpec r1 = r14.baseSpec
            int r5 = r1.trackColor
            r7 = 0
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r1 = r15
            r0.fillTrack(r1, r2, r3, r4, r5, r6, r7)
        L_0x0093:
            r7 = r9
            goto L_0x00ff
        L_0x0096:
            if (r10 == 0) goto L_0x00fd
            com.google.android.material.progressindicator.IndeterminateAnimatorDelegate<android.animation.ObjectAnimator> r0 = r14.animatorDelegate
            java.util.List<com.google.android.material.progressindicator.DrawingDelegate$ActiveIndicator> r0 = r0.activeIndicators
            java.lang.Object r0 = r0.get(r8)
            com.google.android.material.progressindicator.DrawingDelegate$ActiveIndicator r0 = (com.google.android.material.progressindicator.DrawingDelegate.ActiveIndicator) r0
            com.google.android.material.progressindicator.IndeterminateAnimatorDelegate<android.animation.ObjectAnimator> r1 = r14.animatorDelegate
            java.util.List<com.google.android.material.progressindicator.DrawingDelegate$ActiveIndicator> r1 = r1.activeIndicators
            int r3 = r1.size()
            int r3 = r3 - r2
            java.lang.Object r1 = r1.get(r3)
            r12 = r1
            com.google.android.material.progressindicator.DrawingDelegate$ActiveIndicator r12 = (com.google.android.material.progressindicator.DrawingDelegate.ActiveIndicator) r12
            com.google.android.material.progressindicator.DrawingDelegate<S> r1 = r14.drawingDelegate
            boolean r2 = r1 instanceof com.google.android.material.progressindicator.LinearDrawingDelegate
            if (r2 == 0) goto L_0x00d8
            android.graphics.Paint r2 = r14.paint
            float r4 = r0.startFraction
            com.google.android.material.progressindicator.BaseProgressIndicatorSpec r0 = r14.baseSpec
            int r5 = r0.trackColor
            r3 = 0
            r0 = r1
            r7 = r9
            r1 = r15
            r0.fillTrack(r1, r2, r3, r4, r5, r6, r7)
            com.google.android.material.progressindicator.DrawingDelegate<S> r0 = r14.drawingDelegate
            android.graphics.Paint r2 = r14.paint
            float r3 = r12.endFraction
            com.google.android.material.progressindicator.BaseProgressIndicatorSpec r1 = r14.baseSpec
            int r5 = r1.trackColor
            r4 = 1065353216(0x3f800000, float:1.0)
            r1 = r15
            r0.fillTrack(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x00ff
        L_0x00d8:
            r1 = r15
            r7 = r9
            r15.save()
            float r2 = r12.rotationDegree
            r15.rotate(r2)
            com.google.android.material.progressindicator.DrawingDelegate<S> r2 = r14.drawingDelegate
            r3 = r2
            android.graphics.Paint r2 = r14.paint
            float r4 = r12.endFraction
            float r0 = r0.startFraction
            r5 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 + r5
            com.google.android.material.progressindicator.BaseProgressIndicatorSpec r5 = r14.baseSpec
            int r5 = r5.trackColor
            r13 = r4
            r4 = r0
            r0 = r3
            r3 = r13
            r0.fillTrack(r1, r2, r3, r4, r5, r6, r7)
            r15.restore()
            goto L_0x00ff
        L_0x00fd:
            r1 = r15
            goto L_0x0093
        L_0x00ff:
            com.google.android.material.progressindicator.IndeterminateAnimatorDelegate<android.animation.ObjectAnimator> r0 = r14.animatorDelegate
            java.util.List<com.google.android.material.progressindicator.DrawingDelegate$ActiveIndicator> r0 = r0.activeIndicators
            int r0 = r0.size()
            if (r8 >= r0) goto L_0x014e
            com.google.android.material.progressindicator.IndeterminateAnimatorDelegate<android.animation.ObjectAnimator> r0 = r14.animatorDelegate
            java.util.List<com.google.android.material.progressindicator.DrawingDelegate$ActiveIndicator> r0 = r0.activeIndicators
            java.lang.Object r0 = r0.get(r8)
            com.google.android.material.progressindicator.DrawingDelegate$ActiveIndicator r0 = (com.google.android.material.progressindicator.DrawingDelegate.ActiveIndicator) r0
            float r2 = r14.getPhaseFraction()
            r0.phaseFraction = r2
            com.google.android.material.progressindicator.DrawingDelegate<S> r2 = r14.drawingDelegate
            android.graphics.Paint r3 = r14.paint
            int r4 = r14.getAlpha()
            r2.fillIndicator(r15, r3, r0, r4)
            if (r8 <= 0) goto L_0x014a
            if (r11 != 0) goto L_0x014a
            if (r10 == 0) goto L_0x014a
            com.google.android.material.progressindicator.IndeterminateAnimatorDelegate<android.animation.ObjectAnimator> r2 = r14.animatorDelegate
            java.util.List<com.google.android.material.progressindicator.DrawingDelegate$ActiveIndicator> r2 = r2.activeIndicators
            int r3 = r8 + -1
            java.lang.Object r2 = r2.get(r3)
            com.google.android.material.progressindicator.DrawingDelegate$ActiveIndicator r2 = (com.google.android.material.progressindicator.DrawingDelegate.ActiveIndicator) r2
            com.google.android.material.progressindicator.DrawingDelegate<S> r3 = r14.drawingDelegate
            android.graphics.Paint r4 = r14.paint
            float r2 = r2.endFraction
            float r0 = r0.startFraction
            com.google.android.material.progressindicator.BaseProgressIndicatorSpec r5 = r14.baseSpec
            int r5 = r5.trackColor
            r13 = r4
            r4 = r0
            r0 = r3
            r3 = r2
            r2 = r13
            r0.fillTrack(r1, r2, r3, r4, r5, r6, r7)
        L_0x014a:
            int r8 = r8 + 1
            r1 = r15
            goto L_0x00ff
        L_0x014e:
            r15.restore()
        L_0x0151:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.progressindicator.IndeterminateDrawable.draw(android.graphics.Canvas):void");
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public IndeterminateAnimatorDelegate<ObjectAnimator> getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Drawable getStaticDummyDrawable() {
        return this.staticDummyDrawable;
    }

    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    public /* bridge */ /* synthetic */ void setAlpha(@IntRange(from = 0, to = 255) int i5) {
        super.setAlpha(i5);
    }

    /* access modifiers changed from: package-private */
    public void setAnimatorDelegate(@NonNull IndeterminateAnimatorDelegate<ObjectAnimator> indeterminateAnimatorDelegate) {
        this.animatorDelegate = indeterminateAnimatorDelegate;
        indeterminateAnimatorDelegate.registerDrawable(this);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: package-private */
    public void setDrawingDelegate(@NonNull DrawingDelegate<S> drawingDelegate2) {
        this.drawingDelegate = drawingDelegate2;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStaticDummyDrawable(@Nullable Drawable drawable) {
        this.staticDummyDrawable = drawable;
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z4, boolean z5) {
        return super.setVisible(z4, z5);
    }

    /* access modifiers changed from: package-private */
    public boolean setVisibleInternal(boolean z4, boolean z5, boolean z6) {
        Drawable drawable;
        boolean visibleInternal = super.setVisibleInternal(z4, z5, z6);
        if (isSystemAnimatorDisabled() && (drawable = this.staticDummyDrawable) != null) {
            return drawable.setVisible(z4, z5);
        }
        if (!isRunning()) {
            this.animatorDelegate.cancelAnimatorImmediately();
        }
        if (!z4 || !z6) {
            return visibleInternal;
        }
        this.animatorDelegate.startAnimator();
        return visibleInternal;
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    @NonNull
    static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec, @NonNull CircularDrawingDelegate circularDrawingDelegate) {
        IndeterminateAnimatorDelegate indeterminateAnimatorDelegate;
        if (circularProgressIndicatorSpec.indeterminateAnimationType == 1) {
            indeterminateAnimatorDelegate = new CircularIndeterminateRetreatAnimatorDelegate(context, circularProgressIndicatorSpec);
        } else {
            indeterminateAnimatorDelegate = new CircularIndeterminateAdvanceAnimatorDelegate(circularProgressIndicatorSpec);
        }
        IndeterminateDrawable<CircularProgressIndicatorSpec> indeterminateDrawable = new IndeterminateDrawable<>(context, circularProgressIndicatorSpec, circularDrawingDelegate, indeterminateAnimatorDelegate);
        indeterminateDrawable.setStaticDummyDrawable(VectorDrawableCompat.create(context.getResources(), R.drawable.ic_mtrl_arrow_circle, (Resources.Theme) null));
        return indeterminateDrawable;
    }

    @NonNull
    static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec, @NonNull LinearDrawingDelegate linearDrawingDelegate) {
        IndeterminateAnimatorDelegate indeterminateAnimatorDelegate;
        if (linearProgressIndicatorSpec.indeterminateAnimationType == 0) {
            indeterminateAnimatorDelegate = new LinearIndeterminateContiguousAnimatorDelegate(linearProgressIndicatorSpec);
        } else {
            indeterminateAnimatorDelegate = new LinearIndeterminateDisjointAnimatorDelegate(context, linearProgressIndicatorSpec);
        }
        return new IndeterminateDrawable<>(context, linearProgressIndicatorSpec, linearDrawingDelegate, indeterminateAnimatorDelegate);
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z4, boolean z5, boolean z6) {
        return super.setVisible(z4, z5, z6);
    }
}
