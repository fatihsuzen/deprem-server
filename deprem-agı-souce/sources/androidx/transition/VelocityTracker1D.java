package androidx.transition;

import java.util.Arrays;

class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f5) {
        return (float) (((double) Math.signum(f5)) * Math.sqrt((double) (Math.abs(f5) * 2.0f)));
    }

    public void addDataPoint(long j5, float f5) {
        int i5 = (this.mIndex + 1) % 20;
        this.mIndex = i5;
        this.mTimeSamples[i5] = j5;
        this.mDataSamples[i5] = f5;
    }

    /* access modifiers changed from: package-private */
    public float calculateVelocity() {
        float kineticEnergyToVelocity;
        int i5;
        int i6 = this.mIndex;
        if (i6 == 0 && this.mTimeSamples[i6] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j5 = this.mTimeSamples[i6];
        int i7 = 0;
        long j6 = j5;
        while (true) {
            long j7 = this.mTimeSamples[i6];
            if (j7 != Long.MIN_VALUE) {
                float abs = (float) Math.abs(j7 - j6);
                if (((float) (j5 - j7)) > 100.0f || abs > 40.0f) {
                    break;
                }
                if (i6 == 0) {
                    i6 = 20;
                }
                i6--;
                i7++;
                if (i7 >= 20) {
                    break;
                }
                j6 = j7;
            } else {
                break;
            }
        }
        if (i7 < 2) {
            return 0.0f;
        }
        if (i7 == 2) {
            int i8 = this.mIndex;
            if (i8 == 0) {
                i5 = 19;
            } else {
                i5 = i8 - 1;
            }
            long[] jArr = this.mTimeSamples;
            float f5 = (float) (jArr[i8] - jArr[i5]);
            if (f5 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            kineticEnergyToVelocity = (fArr[i8] - fArr[i5]) / f5;
        } else {
            int i9 = this.mIndex;
            int i10 = ((i9 - i7) + 21) % 20;
            int i11 = (i9 + 21) % 20;
            long j8 = this.mTimeSamples[i10];
            float f6 = this.mDataSamples[i10];
            int i12 = i10 + 1;
            float f7 = 0.0f;
            for (int i13 = i12 % 20; i13 != i11; i13 = (i13 + 1) % 20) {
                long j9 = this.mTimeSamples[i13];
                float f8 = (float) (j9 - j8);
                if (f8 != 0.0f) {
                    float f9 = this.mDataSamples[i13];
                    float f10 = (f9 - f6) / f8;
                    f7 += (f10 - kineticEnergyToVelocity(f7)) * Math.abs(f10);
                    if (i13 == i12) {
                        f7 *= 0.5f;
                    }
                    f6 = f9;
                    j8 = j9;
                }
            }
            kineticEnergyToVelocity = kineticEnergyToVelocity(f7);
        }
        return kineticEnergyToVelocity * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
