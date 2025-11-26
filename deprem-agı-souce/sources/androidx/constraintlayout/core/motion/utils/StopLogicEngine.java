package androidx.constraintlayout.core.motion.utils;

public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards = false;
    private boolean mDone = false;
    private float mLastPosition;
    private float mLastTime;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f5) {
        this.mDone = false;
        float f6 = this.mStage1Duration;
        if (f5 <= f6) {
            float f7 = this.mStage1Velocity;
            return (f7 * f5) + ((((this.mStage2Velocity - f7) * f5) * f5) / (f6 * 2.0f));
        }
        int i5 = this.mNumberOfStages;
        if (i5 == 1) {
            return this.mStage1EndPosition;
        }
        float f8 = f5 - f6;
        float f9 = this.mStage2Duration;
        if (f8 < f9) {
            float f10 = this.mStage1EndPosition;
            float f11 = this.mStage2Velocity;
            return f10 + (f11 * f8) + ((((this.mStage3Velocity - f11) * f8) * f8) / (f9 * 2.0f));
        } else if (i5 == 2) {
            return this.mStage2EndPosition;
        } else {
            float f12 = f8 - f9;
            float f13 = this.mStage3Duration;
            if (f12 <= f13) {
                float f14 = this.mStage2EndPosition;
                float f15 = this.mStage3Velocity;
                return (f14 + (f15 * f12)) - (((f15 * f12) * f12) / (f13 * 2.0f));
            }
            this.mDone = true;
            return this.mStage3EndPosition;
        }
    }

    private void setup(float f5, float f6, float f7, float f8, float f9) {
        this.mDone = false;
        this.mStage3EndPosition = f6;
        if (f5 == 0.0f) {
            f5 = 1.0E-4f;
        }
        float f10 = f5 / f7;
        float f11 = (f10 * f5) / 2.0f;
        if (f5 < 0.0f) {
            float sqrt = (float) Math.sqrt((double) ((f6 - ((((-f5) / f7) * f5) / 2.0f)) * f7));
            if (sqrt < f8) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f5;
                this.mStage2Velocity = sqrt;
                this.mStage3Velocity = 0.0f;
                float f12 = (sqrt - f5) / f7;
                this.mStage1Duration = f12;
                this.mStage2Duration = sqrt / f7;
                this.mStage1EndPosition = ((f5 + sqrt) * f12) / 2.0f;
                this.mStage2EndPosition = f6;
                this.mStage3EndPosition = f6;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f5;
            this.mStage2Velocity = f8;
            this.mStage3Velocity = f8;
            float f13 = (f8 - f5) / f7;
            this.mStage1Duration = f13;
            float f14 = f8 / f7;
            this.mStage3Duration = f14;
            float f15 = ((f5 + f8) * f13) / 2.0f;
            float f16 = (f14 * f8) / 2.0f;
            this.mStage2Duration = ((f6 - f15) - f16) / f8;
            this.mStage1EndPosition = f15;
            this.mStage2EndPosition = f6 - f16;
            this.mStage3EndPosition = f6;
        } else if (f11 >= f6) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f5;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f6;
            this.mStage1Duration = (2.0f * f6) / f5;
        } else {
            float f17 = f6 - f11;
            float f18 = f17 / f5;
            if (f18 + f10 < f9) {
                this.mType = "cruse decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f5;
                this.mStage2Velocity = f5;
                this.mStage3Velocity = 0.0f;
                this.mStage1EndPosition = f17;
                this.mStage2EndPosition = f6;
                this.mStage1Duration = f18;
                this.mStage2Duration = f10;
                return;
            }
            float sqrt2 = (float) Math.sqrt((double) ((f7 * f6) + ((f5 * f5) / 2.0f)));
            float f19 = (sqrt2 - f5) / f7;
            this.mStage1Duration = f19;
            float f20 = sqrt2 / f7;
            this.mStage2Duration = f20;
            if (sqrt2 < f8) {
                this.mType = "accelerate decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f5;
                this.mStage2Velocity = sqrt2;
                this.mStage3Velocity = 0.0f;
                this.mStage1Duration = f19;
                this.mStage2Duration = f20;
                this.mStage1EndPosition = ((f5 + sqrt2) * f19) / 2.0f;
                this.mStage2EndPosition = f6;
                return;
            }
            this.mType = "accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f5;
            this.mStage2Velocity = f8;
            this.mStage3Velocity = f8;
            float f21 = (f8 - f5) / f7;
            this.mStage1Duration = f21;
            float f22 = f8 / f7;
            this.mStage3Duration = f22;
            float f23 = ((f5 + f8) * f21) / 2.0f;
            float f24 = (f22 * f8) / 2.0f;
            this.mStage2Duration = ((f6 - f23) - f24) / f8;
            this.mStage1EndPosition = f23;
            this.mStage2EndPosition = f6 - f24;
            this.mStage3EndPosition = f6;
        }
    }

    public void config(float f5, float f6, float f7, float f8, float f9, float f10) {
        boolean z4 = false;
        this.mDone = false;
        this.mStartPosition = f5;
        if (f5 > f6) {
            z4 = true;
        }
        this.mBackwards = z4;
        if (z4) {
            float f11 = f6;
            float f12 = -f7;
            float f13 = f5 - f11;
            float f14 = f10;
            float f15 = f8;
            setup(f12, f13, f9, f14, f15);
            return;
        }
        float f16 = f10;
        float f17 = f8;
        float f18 = f6 - f5;
        setup(f7, f18, f9, f16, f17);
    }

    public String debug(String str, float f5) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str + " ===== " + this.mType + "\n");
        sb.append(str);
        if (this.mBackwards) {
            str2 = "backwards";
        } else {
            str2 = "forward ";
        }
        sb.append(str2);
        sb.append(" time = ");
        sb.append(f5);
        sb.append("  stages ");
        sb.append(this.mNumberOfStages);
        sb.append("\n");
        String str3 = sb.toString() + str + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition + "\n";
        if (this.mNumberOfStages > 1) {
            str3 = str3 + str + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition + "\n";
        }
        if (this.mNumberOfStages > 2) {
            str3 = str3 + str + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition + "\n";
        }
        float f6 = this.mStage1Duration;
        if (f5 <= f6) {
            return str3 + str + "stage 0\n";
        }
        int i5 = this.mNumberOfStages;
        if (i5 == 1) {
            return str3 + str + "end stage 0\n";
        }
        float f7 = f5 - f6;
        float f8 = this.mStage2Duration;
        if (f7 < f8) {
            return str3 + str + " stage 1\n";
        } else if (i5 == 2) {
            return str3 + str + "end stage 1\n";
        } else if (f7 - f8 < this.mStage3Duration) {
            return str3 + str + " stage 2\n";
        } else {
            return str3 + str + " end stage 2\n";
        }
    }

    public float getInterpolation(float f5) {
        float calcY = calcY(f5);
        this.mLastPosition = calcY;
        this.mLastTime = f5;
        if (this.mBackwards) {
            return this.mStartPosition - calcY;
        }
        return this.mStartPosition + calcY;
    }

    public float getVelocity(float f5) {
        float f6 = this.mStage1Duration;
        if (f5 <= f6) {
            float f7 = this.mStage1Velocity;
            return f7 + (((this.mStage2Velocity - f7) * f5) / f6);
        }
        int i5 = this.mNumberOfStages;
        if (i5 == 1) {
            return 0.0f;
        }
        float f8 = f5 - f6;
        float f9 = this.mStage2Duration;
        if (f8 < f9) {
            float f10 = this.mStage2Velocity;
            return f10 + (((this.mStage3Velocity - f10) * f8) / f9);
        } else if (i5 == 2) {
            return 0.0f;
        } else {
            float f11 = f8 - f9;
            float f12 = this.mStage3Duration;
            if (f11 >= f12) {
                return 0.0f;
            }
            float f13 = this.mStage3Velocity;
            return f13 - ((f11 * f13) / f12);
        }
    }

    public boolean isStopped() {
        if (getVelocity() >= EPSILON || Math.abs(this.mStage3EndPosition - this.mLastPosition) >= EPSILON) {
            return false;
        }
        return true;
    }

    public static class Decelerate implements StopEngine {
        private float mAcceleration;
        private float mDestination;
        private boolean mDone = false;
        private float mDuration;
        private float mInitialPos;
        private float mInitialVelocity;
        private float mLastVelocity;

        public void config(float f5, float f6, float f7) {
            this.mDone = false;
            this.mDestination = f6;
            this.mInitialVelocity = f7;
            this.mInitialPos = f5;
            float f8 = (f6 - f5) / (f7 / 2.0f);
            this.mDuration = f8;
            this.mAcceleration = (-f7) / f8;
        }

        public String debug(String str, float f5) {
            return this.mDuration + " " + this.mLastVelocity;
        }

        public float getInterpolation(float f5) {
            if (f5 > this.mDuration) {
                this.mDone = true;
                return this.mDestination;
            }
            getVelocity(f5);
            return this.mInitialPos + ((this.mInitialVelocity + ((this.mAcceleration * f5) / 2.0f)) * f5);
        }

        public float getVelocity(float f5) {
            if (f5 > this.mDuration) {
                return 0.0f;
            }
            float f6 = this.mInitialVelocity + (this.mAcceleration * f5);
            this.mLastVelocity = f6;
            return f6;
        }

        public boolean isStopped() {
            return this.mDone;
        }

        public float getVelocity() {
            return this.mLastVelocity;
        }
    }

    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastTime) : getVelocity(this.mLastTime);
    }
}
