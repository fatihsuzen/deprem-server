package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            View view2 = view;
            view2.setAlpha(get(f5, j5, view2, keyCache));
            return this.mContinue;
        }
    }

    public static class CustomSet extends ViewTimeCycle {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        public void setPoint(int i5, float f5, float f6, int i6, float f7) {
            throw new RuntimeException("Wrong call for custom attribute");
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            boolean z4;
            View view2 = view;
            long j6 = j5;
            this.mCurveFit.getPos((double) f5, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            long j7 = j6 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(view2, this.mAttributeName, 0);
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
                float[] fArr2 = this.mCache;
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
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view2, this.mCache);
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
            this.mCache = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = i6;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i7 = 0; i7 < size; i7++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i7);
                float[] valueAt = this.mWaveProperties.valueAt(i7);
                dArr[i7] = ((double) keyAt) * 0.01d;
                this.mConstraintAttributeList.valueAt(i7).getValuesToInterpolate(this.mTempValues);
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
                dArr3[numberOfInterpolatedValues] = (double) valueAt[0];
                dArr3[numberOfInterpolatedValues + 1] = (double) valueAt[1];
            }
            this.mCurveFit = CurveFit.get(i5, dArr, dArr2);
        }

        public void setPoint(int i5, ConstraintAttribute constraintAttribute, float f5, int i6, float f6) {
            this.mConstraintAttributeList.append(i5, constraintAttribute);
            this.mWaveProperties.append(i5, new float[]{f5, f6});
            this.mWaveShape = Math.max(this.mWaveShape, i6);
        }
    }

    static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            View view2 = view;
            view2.setElevation(get(f5, j5, view2, keyCache));
            return this.mContinue;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        public boolean setPathRotate(View view, KeyCache keyCache, float f5, long j5, double d5, double d6) {
            View view2 = view;
            view2.setRotation(get(f5, j5, view2, keyCache) + ((float) Math.toDegrees(Math.atan2(d6, d5))));
            return this.mContinue;
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    static class ProgressSet extends ViewTimeCycle {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            ProgressSet progressSet;
            Method method;
            if (view instanceof MotionLayout) {
                float f6 = get(f5, j5, view, keyCache);
                progressSet = this;
                ((MotionLayout) view).setProgress(f6);
            } else {
                progressSet = this;
                View view2 = view;
                float f7 = f5;
                long j6 = j5;
                KeyCache keyCache2 = keyCache;
                if (progressSet.mNoMethod) {
                    return false;
                }
                try {
                    method = view2.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    progressSet.mNoMethod = true;
                    method = null;
                }
                if (method != null) {
                    View view3 = view2;
                    try {
                        method.invoke(view3, new Object[]{Float.valueOf(progressSet.get(f7, j6, view3, keyCache2))});
                    } catch (IllegalAccessException e5) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e5);
                    } catch (InvocationTargetException e6) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e6);
                    }
                }
            }
            return progressSet.mContinue;
        }
    }

    static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            View view2 = view;
            view2.setRotation(get(f5, j5, view2, keyCache));
            return this.mContinue;
        }
    }

    static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            View view2 = view;
            view2.setRotationX(get(f5, j5, view2, keyCache));
            return this.mContinue;
        }
    }

    static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            View view2 = view;
            view2.setRotationY(get(f5, j5, view2, keyCache));
            return this.mContinue;
        }
    }

    static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            View view2 = view;
            view2.setScaleX(get(f5, j5, view2, keyCache));
            return this.mContinue;
        }
    }

    static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            View view2 = view;
            view2.setScaleY(get(f5, j5, view2, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            View view2 = view;
            view2.setTranslationX(get(f5, j5, view2, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            View view2 = view;
            view2.setTranslationY(get(f5, j5, view2, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        public boolean setProperty(View view, float f5, long j5, KeyCache keyCache) {
            View view2 = view;
            view2.setTranslationZ(get(f5, j5, view2, keyCache));
            return this.mContinue;
        }
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewTimeCycle makeSpline(String str, long j5) {
        ViewTimeCycle viewTimeCycle;
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c5 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c5 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c5 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c5 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c5 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c5 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c5 = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c5 = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c5 = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c5 = 11;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                viewTimeCycle = new RotationXset();
                break;
            case 1:
                viewTimeCycle = new RotationYset();
                break;
            case 2:
                viewTimeCycle = new TranslationXset();
                break;
            case 3:
                viewTimeCycle = new TranslationYset();
                break;
            case 4:
                viewTimeCycle = new TranslationZset();
                break;
            case 5:
                viewTimeCycle = new ProgressSet();
                break;
            case 6:
                viewTimeCycle = new ScaleXset();
                break;
            case 7:
                viewTimeCycle = new ScaleYset();
                break;
            case 8:
                viewTimeCycle = new RotationSet();
                break;
            case 9:
                viewTimeCycle = new ElevationSet();
                break;
            case 10:
                viewTimeCycle = new PathRotate();
                break;
            case 11:
                viewTimeCycle = new AlphaSet();
                break;
            default:
                return null;
        }
        viewTimeCycle.setStartTime(j5);
        return viewTimeCycle;
    }

    public float get(float f5, long j5, View view, KeyCache keyCache) {
        boolean z4;
        long j6 = j5;
        View view2 = view;
        KeyCache keyCache2 = keyCache;
        this.mCurveFit.getPos((double) f5, this.mCache);
        float[] fArr = this.mCache;
        float f6 = fArr[1];
        int i5 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
        if (i5 == 0) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.mLastCycle)) {
            float floatValue = keyCache2.getFloatValue(view2, this.mType, 0);
            this.mLastCycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.mLastCycle = 0.0f;
            }
        }
        float f7 = (float) ((((double) this.mLastCycle) + ((((double) (j6 - this.mLastTime)) * 1.0E-9d) * ((double) f6))) % 1.0d);
        this.mLastCycle = f7;
        keyCache2.setFloatValue(view2, this.mType, 0, f7);
        this.mLastTime = j6;
        float f8 = this.mCache[0];
        float calcWave = (calcWave(this.mLastCycle) * f8) + this.mCache[2];
        if (f8 == 0.0f && i5 == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.mContinue = z4;
        return calcWave;
    }

    public abstract boolean setProperty(View view, float f5, long j5, KeyCache keyCache);
}
