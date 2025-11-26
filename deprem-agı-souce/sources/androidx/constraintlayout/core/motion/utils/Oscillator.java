package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    private boolean mNormalized = false;
    double mPI2 = 6.283185307179586d;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    int mType;

    public void addPoint(double d5, float f5) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d5);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d5;
        this.mPeriod[binarySearch] = f5;
        this.mNormalized = false;
    }

    /* access modifiers changed from: package-private */
    public double getDP(double d5) {
        if (d5 <= 0.0d) {
            return 0.0d;
        }
        if (d5 >= 1.0d) {
            return 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d5);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        float[] fArr = this.mPeriod;
        float f5 = fArr[binarySearch];
        int i5 = binarySearch - 1;
        float f6 = fArr[i5];
        double d6 = (double) (f5 - f6);
        double[] dArr = this.mPosition;
        double d7 = dArr[binarySearch];
        double d8 = dArr[i5];
        double d9 = d6 / (d7 - d8);
        return (d5 * d9) + (((double) f6) - (d9 * d8));
    }

    /* access modifiers changed from: package-private */
    public double getP(double d5) {
        if (d5 <= 0.0d) {
            return 0.0d;
        }
        if (d5 >= 1.0d) {
            return 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d5);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        float[] fArr = this.mPeriod;
        float f5 = fArr[binarySearch];
        int i5 = binarySearch - 1;
        float f6 = fArr[i5];
        double d6 = (double) (f5 - f6);
        double[] dArr = this.mPosition;
        double d7 = dArr[binarySearch];
        double d8 = dArr[i5];
        double d9 = d6 / (d7 - d8);
        return this.mArea[i5] + ((((double) f6) - (d9 * d8)) * (d5 - d8)) + ((d9 * ((d5 * d5) - (d8 * d8))) / 2.0d);
    }

    public double getSlope(double d5, double d6, double d7) {
        double p5 = d6 + getP(d5);
        double dp = getDP(d5) + d7;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                return dp * 4.0d * Math.signum((((p5 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return dp * 2.0d;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                double d8 = this.mPI2;
                return (-d8) * dp * Math.sin(d8 * p5);
            case 6:
                return dp * 4.0d * ((((p5 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.mCustomCurve.getSlope(p5 % 1.0d, 0);
            default:
                double d9 = this.mPI2;
                return dp * d9 * Math.cos(d9 * p5);
        }
    }

    public double getValue(double d5, double d6) {
        double abs;
        double p5 = getP(d5) + d6;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p5 % 1.0d));
            case 2:
                abs = Math.abs((((p5 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((p5 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((p5 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.mPI2 * (d6 + p5));
            case 6:
                double abs2 = 1.0d - Math.abs(((p5 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.mCustomCurve.getPos(p5 % 1.0d, 0);
            default:
                return Math.sin(this.mPI2 * p5);
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d5 = 0.0d;
        int i5 = 0;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i5 >= fArr.length) {
                break;
            }
            d5 += (double) fArr[i5];
            i5++;
        }
        double d6 = 0.0d;
        int i6 = 1;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i6 >= fArr2.length) {
                break;
            }
            int i7 = i6 - 1;
            double[] dArr = this.mPosition;
            d6 += (dArr[i6] - dArr[i7]) * ((double) ((fArr2[i7] + fArr2[i6]) / 2.0f));
            i6++;
        }
        int i8 = 0;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i8 >= fArr3.length) {
                break;
            }
            fArr3[i8] = fArr3[i8] * ((float) (d5 / d6));
            i8++;
        }
        this.mArea[0] = 0.0d;
        int i9 = 1;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i9 < fArr4.length) {
                int i10 = i9 - 1;
                double[] dArr2 = this.mPosition;
                double d7 = dArr2[i9] - dArr2[i10];
                double[] dArr3 = this.mArea;
                dArr3[i9] = dArr3[i10] + (d7 * ((double) ((fArr4[i10] + fArr4[i9]) / 2.0f)));
                i9++;
            } else {
                this.mNormalized = true;
                return;
            }
        }
    }

    public void setType(int i5, String str) {
        this.mType = i5;
        this.mCustomType = str;
        if (str != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
