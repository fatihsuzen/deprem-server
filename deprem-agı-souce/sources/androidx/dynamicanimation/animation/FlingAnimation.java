package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        DragForce() {
        }

        public float getAcceleration(float f5, float f6) {
            return f6 * this.mFriction;
        }

        /* access modifiers changed from: package-private */
        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        public boolean isAtEquilibrium(float f5, float f6) {
            if (Math.abs(f6) < this.mVelocityThreshold) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void setFrictionScalar(float f5) {
            this.mFriction = f5 * DEFAULT_FRICTION;
        }

        /* access modifiers changed from: package-private */
        public void setValueThreshold(float f5) {
            this.mVelocityThreshold = f5 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        /* access modifiers changed from: package-private */
        public DynamicAnimation.MassState updateValueAndVelocity(float f5, float f6, long j5) {
            this.mMassState.mVelocity = (float) (((double) f6) * Math.exp((double) ((((float) j5) / 1000.0f) * this.mFriction)));
            DynamicAnimation.MassState massState = this.mMassState;
            float f7 = massState.mVelocity;
            float f8 = f5 + ((f7 - f6) / this.mFriction);
            massState.mValue = f8;
            if (isAtEquilibrium(f8, f7)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    /* access modifiers changed from: package-private */
    public float getAcceleration(float f5, float f6) {
        return this.mFlingForce.getAcceleration(f5, f6);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    /* access modifiers changed from: package-private */
    public boolean isAtEquilibrium(float f5, float f6) {
        if (f5 >= this.mMaxValue || f5 <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f5, f6)) {
            return true;
        }
        return false;
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f5) {
        if (f5 > 0.0f) {
            this.mFlingForce.setFrictionScalar(f5);
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    /* access modifiers changed from: package-private */
    public void setValueThreshold(float f5) {
        this.mFlingForce.setValueThreshold(f5);
    }

    /* access modifiers changed from: package-private */
    public boolean updateValueAndVelocity(long j5) {
        DynamicAnimation.MassState updateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j5);
        float f5 = updateValueAndVelocity.mValue;
        this.mValue = f5;
        float f6 = updateValueAndVelocity.mVelocity;
        this.mVelocity = f6;
        float f7 = this.mMinValue;
        if (f5 < f7) {
            this.mValue = f7;
            return true;
        }
        float f8 = this.mMaxValue;
        if (f5 > f8) {
            this.mValue = f8;
            return true;
        } else if (isAtEquilibrium(f5, f6)) {
            return true;
        } else {
            return false;
        }
    }

    public FlingAnimation setMaxValue(float f5) {
        super.setMaxValue(f5);
        return this;
    }

    public FlingAnimation setMinValue(float f5) {
        super.setMinValue(f5);
        return this;
    }

    public FlingAnimation setStartVelocity(float f5) {
        super.setStartVelocity(f5);
        return this;
    }

    public <K> FlingAnimation(K k5, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k5, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
