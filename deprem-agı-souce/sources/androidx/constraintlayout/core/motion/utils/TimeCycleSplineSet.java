package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

public abstract class TimeCycleSplineSet {
    protected static final int CURVE_OFFSET = 2;
    protected static final int CURVE_PERIOD = 1;
    protected static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    protected static float sVal2PI = 6.2831855f;
    protected float[] mCache;
    protected boolean mContinue;
    protected int mCount;
    protected CurveFit mCurveFit;
    protected float mLastCycle;
    protected long mLastTime;
    protected int[] mTimePoints = new int[10];
    protected String mType;
    protected float[][] mValues;
    protected int mWaveShape = 0;

    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        public void setPoint(int i5, float f5, float f6, int i6, float f7) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f5, long j5, KeyCache keyCache) {
            boolean z4;
            MotionWidget motionWidget2 = motionWidget;
            long j6 = j5;
            this.mCurveFit.getPos((double) f5, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            long j7 = j6 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget2, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f8 = (float) ((((double) this.mLastCycle) + ((((double) j7) * 1.0E-9d) * ((double) f6))) % 1.0d);
            this.mLastCycle = f8;
            this.mLastTime = j6;
            float calcWave = calcWave(f8);
            this.mContinue = false;
            int i5 = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i5 >= fArr2.length) {
                    break;
                }
                boolean z5 = this.mContinue;
                float f9 = this.mTempValues[i5];
                if (((double) f9) != 0.0d) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.mContinue = z5 | z4;
                fArr2[i5] = (f9 * calcWave) + f7;
                i5++;
            }
            motionWidget2.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), this.mCustomCache);
            if (f6 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        public void setup(int i5) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i6 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i6];
            this.mCustomCache = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = i6;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i7 = 0; i7 < size; i7++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i7);
                CustomAttribute valueAt = this.mConstraintAttributeList.valueAt(i7);
                float[] valueAt2 = this.mWaveProperties.valueAt(i7);
                dArr[i7] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i8 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i8 >= fArr.length) {
                        break;
                    }
                    dArr2[i7][i8] = (double) fArr[i8];
                    i8++;
                }
                double[] dArr3 = dArr2[i7];
                dArr3[numberOfInterpolatedValues] = (double) valueAt2[0];
                dArr3[numberOfInterpolatedValues + 1] = (double) valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i5, dArr, dArr2);
        }

        public void setPoint(int i5, CustomAttribute customAttribute, float f5, int i6, float f6) {
            this.mConstraintAttributeList.append(i5, customAttribute);
            this.mWaveProperties.append(i5, new float[]{f5, f6});
            this.mWaveShape = Math.max(this.mWaveShape, i6);
        }
    }

    public static class CustomVarSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        public void setPoint(int i5, float f5, float f6, int i6, float f7) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f5, long j5, KeyCache keyCache) {
            boolean z4;
            MotionWidget motionWidget2 = motionWidget;
            long j6 = j5;
            this.mCurveFit.getPos((double) f5, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            long j7 = j6 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget2, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f8 = (float) ((((double) this.mLastCycle) + ((((double) j7) * 1.0E-9d) * ((double) f6))) % 1.0d);
            this.mLastCycle = f8;
            this.mLastTime = j6;
            float calcWave = calcWave(f8);
            this.mContinue = false;
            int i5 = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i5 >= fArr2.length) {
                    break;
                }
                boolean z5 = this.mContinue;
                float f9 = this.mTempValues[i5];
                if (((double) f9) != 0.0d) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.mContinue = z5 | z4;
                fArr2[i5] = (f9 * calcWave) + f7;
                i5++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget2, this.mCustomCache);
            if (f6 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        public void setup(int i5) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i6 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i6];
            this.mCustomCache = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = i6;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i7 = 0; i7 < size; i7++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i7);
                CustomVariable valueAt = this.mConstraintAttributeList.valueAt(i7);
                float[] valueAt2 = this.mWaveProperties.valueAt(i7);
                dArr[i7] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i8 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i8 >= fArr.length) {
                        break;
                    }
                    dArr2[i7][i8] = (double) fArr[i8];
                    i8++;
                }
                double[] dArr3 = dArr2[i7];
                dArr3[numberOfInterpolatedValues] = (double) valueAt2[0];
                dArr3[numberOfInterpolatedValues + 1] = (double) valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i5, dArr, dArr2);
        }

        public void setPoint(int i5, CustomVariable customVariable, float f5, int i6, float f6) {
            this.mConstraintAttributeList.append(i5, customVariable);
            this.mWaveProperties.append(i5, new float[]{f5, f6});
            this.mWaveShape = Math.max(this.mWaveShape, i6);
        }
    }

    protected static class Sort {
        protected Sort() {
        }

        static void doubleQuickSort(int[] iArr, float[][] fArr, int i5, int i6) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i6;
            iArr2[1] = i5;
            int i7 = 2;
            while (i7 > 0) {
                int i8 = iArr2[i7 - 1];
                int i9 = i7 - 2;
                int i10 = iArr2[i9];
                if (i8 < i10) {
                    int partition = partition(iArr, fArr, i8, i10);
                    iArr2[i9] = partition - 1;
                    iArr2[i7 - 1] = i8;
                    int i11 = i7 + 1;
                    iArr2[i7] = i10;
                    i7 += 2;
                    iArr2[i11] = partition + 1;
                } else {
                    i7 = i9;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i5, int i6) {
            int i7 = iArr[i6];
            int i8 = i5;
            while (i5 < i6) {
                if (iArr[i5] <= i7) {
                    swap(iArr, fArr, i8, i5);
                    i8++;
                }
                i5++;
            }
            swap(iArr, fArr, i8, i6);
            return i8;
        }

        private static void swap(int[] iArr, float[][] fArr, int i5, int i6) {
            int i7 = iArr[i5];
            iArr[i5] = iArr[i6];
            iArr[i6] = i7;
            float[] fArr2 = fArr[i5];
            fArr[i5] = fArr[i6];
            fArr[i6] = fArr2;
        }
    }

    public TimeCycleSplineSet() {
        int[] iArr = new int[2];
        iArr[1] = 3;
        iArr[0] = 10;
        this.mValues = (float[][]) Array.newInstance(Float.TYPE, iArr);
        this.mCache = new float[3];
        this.mContinue = false;
        this.mLastCycle = Float.NaN;
    }

    /* access modifiers changed from: protected */
    public float calcWave(float f5) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f5 * sVal2PI);
            case 2:
                abs = Math.abs(f5);
                break;
            case 3:
                return (((f5 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f5 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f5 * sVal2PI));
            case 6:
                float abs2 = 1.0f - Math.abs(((f5 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin((double) (f5 * sVal2PI));
        }
        return 1.0f - abs;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i5, float f5, float f6, int i6, float f7) {
        int[] iArr = this.mTimePoints;
        int i7 = this.mCount;
        iArr[i7] = i5;
        float[] fArr = this.mValues[i7];
        fArr[0] = f5;
        fArr[1] = f6;
        fArr[2] = f7;
        this.mWaveShape = Math.max(this.mWaveShape, i6);
        this.mCount++;
    }

    /* access modifiers changed from: protected */
    public void setStartTime(long j5) {
        this.mLastTime = j5;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i5) {
        int i6 = this.mCount;
        if (i6 == 0) {
            System.err.println("Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i6 - 1);
        int i7 = 1;
        int i8 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i7 >= iArr.length) {
                break;
            }
            if (iArr[i7] != iArr[i7 - 1]) {
                i8++;
            }
            i7++;
        }
        if (i8 == 0) {
            i8 = 1;
        }
        double[] dArr = new double[i8];
        int[] iArr2 = new int[2];
        iArr2[1] = 3;
        iArr2[0] = i8;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        int i9 = 0;
        for (int i10 = 0; i10 < this.mCount; i10++) {
            if (i10 > 0) {
                int[] iArr3 = this.mTimePoints;
                if (iArr3[i10] == iArr3[i10 - 1]) {
                }
            }
            dArr[i9] = ((double) this.mTimePoints[i10]) * 0.01d;
            double[] dArr3 = dArr2[i9];
            float[] fArr = this.mValues[i10];
            dArr3[0] = (double) fArr[0];
            dArr3[1] = (double) fArr[1];
            dArr3[2] = (double) fArr[2];
            i9++;
        }
        this.mCurveFit = CurveFit.get(i5, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i5 = 0; i5 < this.mCount; i5++) {
            str = str + "[" + this.mTimePoints[i5] + " , " + decimalFormat.format(this.mValues[i5]) + "] ";
        }
        return str;
    }
}
