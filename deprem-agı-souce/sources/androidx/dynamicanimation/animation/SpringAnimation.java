package androidx.dynamicanimation.animation;

import android.util.AndroidRuntimeException;
import androidx.annotation.MainThread;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested = false;
    private float mPendingPosition = Float.MAX_VALUE;
    private SpringForce mSpring = null;

    public SpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
    }

    private void sanityCheck() {
        SpringForce springForce = this.mSpring;
        if (springForce != null) {
            double finalPosition = (double) springForce.getFinalPosition();
            if (finalPosition > ((double) this.mMaxValue)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (finalPosition < ((double) this.mMinValue)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public void animateToFinalPosition(float f5) {
        if (isRunning()) {
            this.mPendingPosition = f5;
            return;
        }
        if (this.mSpring == null) {
            this.mSpring = new SpringForce(f5);
        }
        this.mSpring.setFinalPosition(f5);
        start();
    }

    public boolean canSkipToEnd() {
        if (this.mSpring.mDampingRatio > 0.0d) {
            return true;
        }
        return false;
    }

    @MainThread
    public void cancel() {
        super.cancel();
        float f5 = this.mPendingPosition;
        if (f5 != Float.MAX_VALUE) {
            SpringForce springForce = this.mSpring;
            if (springForce == null) {
                this.mSpring = new SpringForce(f5);
            } else {
                springForce.setFinalPosition(f5);
            }
            this.mPendingPosition = Float.MAX_VALUE;
        }
    }

    /* access modifiers changed from: package-private */
    public float getAcceleration(float f5, float f6) {
        return this.mSpring.getAcceleration(f5, f6);
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    /* access modifiers changed from: package-private */
    public boolean isAtEquilibrium(float f5, float f6) {
        return this.mSpring.isAtEquilibrium(f5, f6);
    }

    public SpringAnimation setSpring(SpringForce springForce) {
        this.mSpring = springForce;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setValueThreshold(float f5) {
    }

    public void skipToEnd() {
        if (!canSkipToEnd()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (!getAnimationHandler().isCurrentThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        } else if (this.mRunning) {
            this.mEndRequested = true;
        }
    }

    @MainThread
    public void start() {
        sanityCheck();
        this.mSpring.setValueThreshold((double) getValueThreshold());
        super.start();
    }

    /* access modifiers changed from: package-private */
    public boolean updateValueAndVelocity(long j5) {
        if (this.mEndRequested) {
            float f5 = this.mPendingPosition;
            if (f5 != Float.MAX_VALUE) {
                this.mSpring.setFinalPosition(f5);
                this.mPendingPosition = Float.MAX_VALUE;
            }
            this.mValue = this.mSpring.getFinalPosition();
            this.mVelocity = 0.0f;
            this.mEndRequested = false;
            return true;
        }
        if (this.mPendingPosition != Float.MAX_VALUE) {
            long j6 = j5 / 2;
            DynamicAnimation.MassState updateValues = this.mSpring.updateValues((double) this.mValue, (double) this.mVelocity, j6);
            this.mSpring.setFinalPosition(this.mPendingPosition);
            this.mPendingPosition = Float.MAX_VALUE;
            DynamicAnimation.MassState updateValues2 = this.mSpring.updateValues((double) updateValues.mValue, (double) updateValues.mVelocity, j6);
            this.mValue = updateValues2.mValue;
            this.mVelocity = updateValues2.mVelocity;
        } else {
            DynamicAnimation.MassState updateValues3 = this.mSpring.updateValues((double) this.mValue, (double) this.mVelocity, j5);
            this.mValue = updateValues3.mValue;
            this.mVelocity = updateValues3.mVelocity;
        }
        float max = Math.max(this.mValue, this.mMinValue);
        this.mValue = max;
        float min = Math.min(max, this.mMaxValue);
        this.mValue = min;
        if (!isAtEquilibrium(min, this.mVelocity)) {
            return false;
        }
        this.mValue = this.mSpring.getFinalPosition();
        this.mVelocity = 0.0f;
        return true;
    }

    public SpringAnimation(FloatValueHolder floatValueHolder, float f5) {
        super(floatValueHolder);
        this.mSpring = new SpringForce(f5);
    }

    public <K> SpringAnimation(K k5, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k5, floatPropertyCompat);
    }

    public <K> SpringAnimation(K k5, FloatPropertyCompat<K> floatPropertyCompat, float f5) {
        super(k5, floatPropertyCompat);
        this.mSpring = new SpringForce(f5);
    }
}
