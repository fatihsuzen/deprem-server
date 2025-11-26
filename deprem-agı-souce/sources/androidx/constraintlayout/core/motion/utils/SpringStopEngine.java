package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;

public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private int mBoundaryMode = 0;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;

    private void compute(double d5) {
        if (d5 > 0.0d) {
            double d6 = this.mStiffness;
            double d7 = this.mDamping;
            int sqrt = (int) ((9.0d / ((Math.sqrt(d6 / ((double) this.mMass)) * d5) * 4.0d)) + 1.0d);
            double d8 = d5 / ((double) sqrt);
            int i5 = 0;
            while (i5 < sqrt) {
                float f5 = this.mPos;
                double d9 = this.mTargetPos;
                float f6 = this.mV;
                double d10 = d6;
                float f7 = this.mMass;
                double d11 = d7;
                double d12 = ((double) f6) + ((((((-d6) * (((double) f5) - d9)) - (((double) f6) * d7)) / ((double) f7)) * d8) / 2.0d);
                double d13 = ((((-((((double) f5) + ((d8 * d12) / 2.0d)) - d9)) * d10) - (d12 * d11)) / ((double) f7)) * d8;
                double d14 = ((double) f6) + (d13 / 2.0d);
                float f8 = f6 + ((float) d13);
                this.mV = f8;
                float f9 = f5 + ((float) (d14 * d8));
                this.mPos = f9;
                int i6 = this.mBoundaryMode;
                if (i6 > 0) {
                    if (f9 < 0.0f && (i6 & 1) == 1) {
                        this.mPos = -f9;
                        this.mV = -f8;
                    }
                    float f10 = this.mPos;
                    if (f10 > 1.0f && (i6 & 2) == 2) {
                        this.mPos = 2.0f - f10;
                        this.mV = -this.mV;
                    }
                }
                i5++;
                d6 = d10;
                d7 = d11;
            }
        }
    }

    public String debug(String str, float f5) {
        return null;
    }

    public float getAcceleration() {
        double d5 = this.mStiffness;
        return ((float) (((-d5) * (((double) this.mPos) - this.mTargetPos)) - (this.mDamping * ((double) this.mV)))) / this.mMass;
    }

    public float getInterpolation(float f5) {
        compute((double) (f5 - this.mLastTime));
        this.mLastTime = f5;
        if (isStopped()) {
            this.mPos = (float) this.mTargetPos;
        }
        return this.mPos;
    }

    public float getVelocity() {
        return 0.0f;
    }

    public boolean isStopped() {
        double d5 = ((double) this.mPos) - this.mTargetPos;
        double d6 = this.mStiffness;
        double d7 = (double) this.mV;
        if (Math.sqrt((((d7 * d7) * ((double) this.mMass)) + ((d6 * d5) * d5)) / d6) <= ((double) this.mStopThreshold)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        PrintStream printStream = System.out;
        printStream.println((".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ") + str);
    }

    public void springConfig(float f5, float f6, float f7, float f8, float f9, float f10, float f11, int i5) {
        this.mTargetPos = (double) f6;
        this.mDamping = (double) f10;
        this.mInitialized = false;
        this.mPos = f5;
        this.mLastVelocity = (double) f7;
        this.mStiffness = (double) f9;
        this.mMass = f8;
        this.mStopThreshold = f11;
        this.mBoundaryMode = i5;
        this.mLastTime = 0.0f;
    }

    public float getVelocity(float f5) {
        return this.mV;
    }
}
