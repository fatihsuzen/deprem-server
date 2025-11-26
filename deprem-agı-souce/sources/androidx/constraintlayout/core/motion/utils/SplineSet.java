package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int mCount;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints = new int[10];
    private String mType;
    protected float[] mValues = new float[10];

    private static class CoreSpline extends SplineSet {
        long mStart;
        String mType;

        CoreSpline(String str, long j5) {
            this.mType = str;
            this.mStart = j5;
        }

        public void setProperty(TypedValues typedValues, float f5) {
            typedValues.setValue(typedValues.getId(this.mType), get(f5));
        }
    }

    public static class CustomSet extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        public void setPoint(int i5, float f5) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(WidgetFrame widgetFrame, float f5) {
            this.mCurveFit.getPos((double) f5, this.mTempValues);
            widgetFrame.setCustomValue(this.mConstraintAttributeList.valueAt(0), this.mTempValues);
        }

        public void setup(int i5) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = numberOfInterpolatedValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i6);
                CustomAttribute valueAt = this.mConstraintAttributeList.valueAt(i6);
                dArr[i6] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i7 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i7 >= fArr.length) {
                        break;
                    }
                    dArr2[i6][i7] = (double) fArr[i7];
                    i7++;
                }
            }
            this.mCurveFit = CurveFit.get(i5, dArr, dArr2);
        }

        public void setPoint(int i5, CustomAttribute customAttribute) {
            this.mConstraintAttributeList.append(i5, customAttribute);
        }
    }

    public static class CustomSpline extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mTempValues;

        public CustomSpline(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        public void setPoint(int i5, float f5) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(TypedValues typedValues, float f5) {
            setProperty((MotionWidget) typedValues, f5);
        }

        public void setup(int i5) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = numberOfInterpolatedValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i6);
                CustomVariable valueAt = this.mConstraintAttributeList.valueAt(i6);
                dArr[i6] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i7 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i7 >= fArr.length) {
                        break;
                    }
                    dArr2[i6][i7] = (double) fArr[i7];
                    i7++;
                }
            }
            this.mCurveFit = CurveFit.get(i5, dArr, dArr2);
        }

        public void setPoint(int i5, CustomVariable customVariable) {
            this.mConstraintAttributeList.append(i5, customVariable);
        }

        public void setProperty(MotionWidget motionWidget, float f5) {
            this.mCurveFit.getPos((double) f5, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mTempValues);
        }
    }

    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] iArr, float[] fArr, int i5, int i6) {
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

        private static int partition(int[] iArr, float[] fArr, int i5, int i6) {
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

        private static void swap(int[] iArr, float[] fArr, int i5, int i6) {
            int i7 = iArr[i5];
            iArr[i5] = iArr[i6];
            iArr[i6] = i7;
            float f5 = fArr[i5];
            fArr[i5] = fArr[i6];
            fArr[i6] = f5;
        }
    }

    public static SplineSet makeCustomSpline(String str, KeyFrameArray.CustomArray customArray) {
        return new CustomSet(str, customArray);
    }

    public static SplineSet makeCustomSplineSet(String str, KeyFrameArray.CustomVar customVar) {
        return new CustomSpline(str, customVar);
    }

    public static SplineSet makeSpline(String str, long j5) {
        return new CoreSpline(str, j5);
    }

    public float get(float f5) {
        return (float) this.mCurveFit.getPos((double) f5, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f5) {
        return (float) this.mCurveFit.getSlope((double) f5, 0);
    }

    public void setPoint(int i5, float f5) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.mCount + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i6 = this.mCount;
        iArr2[i6] = i5;
        this.mValues[i6] = f5;
        this.mCount = i6 + 1;
    }

    public void setProperty(TypedValues typedValues, float f5) {
        typedValues.setValue(a.a(this.mType), get(f5));
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i5) {
        int i6 = this.mCount;
        if (i6 != 0) {
            Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i6 - 1);
            int i7 = 1;
            for (int i8 = 1; i8 < this.mCount; i8++) {
                int[] iArr = this.mTimePoints;
                if (iArr[i8 - 1] != iArr[i8]) {
                    i7++;
                }
            }
            double[] dArr = new double[i7];
            int[] iArr2 = new int[2];
            iArr2[1] = 1;
            iArr2[0] = i7;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
            int i9 = 0;
            for (int i10 = 0; i10 < this.mCount; i10++) {
                if (i10 > 0) {
                    int[] iArr3 = this.mTimePoints;
                    if (iArr3[i10] == iArr3[i10 - 1]) {
                    }
                }
                dArr[i9] = ((double) this.mTimePoints[i10]) * 0.01d;
                dArr2[i9][0] = (double) this.mValues[i10];
                i9++;
            }
            this.mCurveFit = CurveFit.get(i5, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i5 = 0; i5 < this.mCount; i5++) {
            str = str + "[" + this.mTimePoints[i5] + " , " + decimalFormat.format((double) this.mValues[i5]) + "] ";
        }
        return str;
    }
}
