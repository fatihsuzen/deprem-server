package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] mMaximumVelocity = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] mMinimumVelocity = {0.0f, 0.0f};
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private float[] mRelativeEdges = {0.0f, 0.0f};
    private float[] mRelativeVelocity = {0.0f, 0.0f};
    private Runnable mRunnable;
    final ClampedScroller mScroller = new ClampedScroller();
    final View mTarget;

    private static class ClampedScroller {
        private long mDeltaTime = 0;
        private int mDeltaX = 0;
        private int mDeltaY = 0;
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private long mStartTime = Long.MIN_VALUE;
        private long mStopTime = -1;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;

        ClampedScroller() {
        }

        private float getValueAt(long j5) {
            long j6 = this.mStartTime;
            if (j5 < j6) {
                return 0.0f;
            }
            long j7 = this.mStopTime;
            if (j7 < 0 || j5 < j7) {
                return AutoScrollHelper.constrain(((float) (j5 - j6)) / ((float) this.mRampUpDuration), 0.0f, 1.0f) * 0.5f;
            }
            float f5 = this.mStopValue;
            return (1.0f - f5) + (f5 * AutoScrollHelper.constrain(((float) (j5 - j7)) / ((float) this.mEffectiveRampDown), 0.0f, 1.0f));
        }

        private float interpolateValue(float f5) {
            return (-4.0f * f5 * f5) + (f5 * 4.0f);
        }

        public void computeScrollDelta() {
            if (this.mDeltaTime != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float interpolateValue = interpolateValue(getValueAt(currentAnimationTimeMillis));
                this.mDeltaTime = currentAnimationTimeMillis;
                float f5 = ((float) (currentAnimationTimeMillis - this.mDeltaTime)) * interpolateValue;
                this.mDeltaX = (int) (this.mTargetVelocityX * f5);
                this.mDeltaY = (int) (f5 * this.mTargetVelocityY);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        public int getHorizontalDirection() {
            float f5 = this.mTargetVelocityX;
            return (int) (f5 / Math.abs(f5));
        }

        public int getVerticalDirection() {
            float f5 = this.mTargetVelocityY;
            return (int) (f5 / Math.abs(f5));
        }

        public boolean isFinished() {
            if (this.mStopTime <= 0 || AnimationUtils.currentAnimationTimeMillis() <= this.mStopTime + ((long) this.mEffectiveRampDown)) {
                return false;
            }
            return true;
        }

        public void requestStop() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (currentAnimationTimeMillis - this.mStartTime), 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(currentAnimationTimeMillis);
            this.mStopTime = currentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i5) {
            this.mRampDownDuration = i5;
        }

        public void setRampUpDuration(int i5) {
            this.mRampUpDuration = i5;
        }

        public void setTargetVelocity(float f5, float f6) {
            this.mTargetVelocityX = f5;
            this.mTargetVelocityY = f6;
        }

        public void start() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis;
            this.mStopTime = -1;
            this.mDeltaTime = currentAnimationTimeMillis;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }
    }

    private class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.mAnimating) {
                if (autoScrollHelper.mNeedsReset) {
                    autoScrollHelper.mNeedsReset = false;
                    autoScrollHelper.mScroller.start();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.mScroller;
                if (clampedScroller.isFinished() || !AutoScrollHelper.this.shouldAnimate()) {
                    AutoScrollHelper.this.mAnimating = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.mNeedsCancel) {
                    autoScrollHelper2.mNeedsCancel = false;
                    autoScrollHelper2.cancelTargetTouch();
                }
                clampedScroller.computeScrollDelta();
                AutoScrollHelper.this.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
            }
        }
    }

    public AutoScrollHelper(@NonNull View view) {
        this.mTarget = view;
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        float f6 = (float) ((int) ((1575.0f * f5) + 0.5f));
        setMaximumVelocity(f6, f6);
        float f7 = (float) ((int) ((f5 * 315.0f) + 0.5f));
        setMinimumVelocity(f7, f7);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    private float computeTargetVelocity(int i5, float f5, float f6, float f7) {
        float edgeValue = getEdgeValue(this.mRelativeEdges[i5], f6, this.mMaximumEdges[i5], f5);
        int i6 = (edgeValue > 0.0f ? 1 : (edgeValue == 0.0f ? 0 : -1));
        if (i6 == 0) {
            return 0.0f;
        }
        float f8 = this.mRelativeVelocity[i5];
        float f9 = this.mMinimumVelocity[i5];
        float f10 = this.mMaximumVelocity[i5];
        float f11 = f8 * f7;
        if (i6 > 0) {
            return constrain(edgeValue * f11, f9, f10);
        }
        return -constrain((-edgeValue) * f11, f9, f10);
    }

    static float constrain(float f5, float f6, float f7) {
        if (f5 > f7) {
            return f7;
        }
        return f5 < f6 ? f6 : f5;
    }

    private float constrainEdgeValue(float f5, float f6) {
        if (f6 == 0.0f) {
            return 0.0f;
        }
        int i5 = this.mEdgeType;
        if (i5 == 0 || i5 == 1) {
            if (f5 < f6) {
                if (f5 >= 0.0f) {
                    return 1.0f - (f5 / f6);
                }
                if (!this.mAnimating || i5 != 1) {
                    return 0.0f;
                }
                return 1.0f;
            }
        } else if (i5 == 2 && f5 < 0.0f) {
            return f5 / (-f6);
        }
        return 0.0f;
    }

    private float getEdgeValue(float f5, float f6, float f7, float f8) {
        float f9;
        float constrain = constrain(f5 * f6, 0.0f, f7);
        float constrainEdgeValue = constrainEdgeValue(f6 - f8, constrain) - constrainEdgeValue(f8, constrain);
        if (constrainEdgeValue < 0.0f) {
            f9 = -this.mEdgeInterpolator.getInterpolation(-constrainEdgeValue);
        } else if (constrainEdgeValue <= 0.0f) {
            return 0.0f;
        } else {
            f9 = this.mEdgeInterpolator.getInterpolation(constrainEdgeValue);
        }
        return constrain(f9, -1.0f, 1.0f);
    }

    private void requestStop() {
        if (this.mNeedsReset) {
            this.mAnimating = false;
        } else {
            this.mScroller.requestStop();
        }
    }

    private void startAnimating() {
        int i5;
        if (this.mRunnable == null) {
            this.mRunnable = new ScrollAnimationRunnable();
        }
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (this.mAlreadyDelayed || (i5 = this.mActivationDelay) <= 0) {
            this.mRunnable.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, (long) i5);
        }
        this.mAlreadyDelayed = true;
    }

    public abstract boolean canTargetScrollHorizontally(int i5);

    public abstract boolean canTargetScrollVertically(int i5);

    /* access modifiers changed from: package-private */
    public void cancelTargetTouch() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(obtain);
        obtain.recycle();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.mEnabled
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.requestStop()
            goto L_0x0058
        L_0x001a:
            r5.mNeedsCancel = r2
            r5.mAlreadyDelayed = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.mTarget
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.computeTargetVelocity(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.mTarget
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.computeTargetVelocity(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r7 = r5.mScroller
            r7.setTargetVelocity(r0, r6)
            boolean r6 = r5.mAnimating
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.shouldAnimate()
            if (r6 == 0) goto L_0x0058
            r5.startAnimating()
        L_0x0058:
            boolean r6 = r5.mExclusive
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.mAnimating
            if (r6 == 0) goto L_0x0061
            return r2
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract void scrollTargetBy(int i5, int i6);

    @NonNull
    public AutoScrollHelper setActivationDelay(int i5) {
        this.mActivationDelay = i5;
        return this;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int i5) {
        this.mEdgeType = i5;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z4) {
        if (this.mEnabled && !z4) {
            requestStop();
        }
        this.mEnabled = z4;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z4) {
        this.mExclusive = z4;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumEdges(float f5, float f6) {
        float[] fArr = this.mMaximumEdges;
        fArr[0] = f5;
        fArr[1] = f6;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float f5, float f6) {
        float[] fArr = this.mMaximumVelocity;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float f5, float f6) {
        float[] fArr = this.mMinimumVelocity;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int i5) {
        this.mScroller.setRampDownDuration(i5);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int i5) {
        this.mScroller.setRampUpDuration(i5);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float f5, float f6) {
        float[] fArr = this.mRelativeEdges;
        fArr[0] = f5;
        fArr[1] = f6;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float f5, float f6) {
        float[] fArr = this.mRelativeVelocity;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldAnimate() {
        ClampedScroller clampedScroller = this.mScroller;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        if (verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) {
            return true;
        }
        if (horizontalDirection == 0 || !canTargetScrollHorizontally(horizontalDirection)) {
            return false;
        }
        return true;
    }

    static int constrain(int i5, int i6, int i7) {
        if (i5 > i7) {
            return i7;
        }
        return i5 < i6 ? i6 : i5;
    }
}
