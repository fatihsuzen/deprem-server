package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {"position", "x", "y", "width", "height", "pathRotate"};
    private float mAlpha = 1.0f;
    private int mAnimateRelativeTo = -1;
    private boolean mApplyElevation = false;
    LinkedHashMap<String, CustomVariable> mCustomVariable = new LinkedHashMap<>();
    private int mDrawPath = 0;
    private float mElevation = 0.0f;
    private float mHeight;
    private Easing mKeyFrameEasing;
    int mMode = 0;
    private float mPathRotate = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mPosition;
    private float mProgress = Float.NaN;
    private float mRotation = 0.0f;
    private float mRotationX = 0.0f;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    double[] mTempDelta = new double[18];
    double[] mTempValue = new double[18];
    private float mTranslationX = 0.0f;
    private float mTranslationY = 0.0f;
    private float mTranslationZ = 0.0f;
    int mVisibility;
    int mVisibilityMode = 0;
    private float mWidth;
    private float mX;
    private float mY;
    public float rotationY = 0.0f;

    MotionConstrainedPoint() {
    }

    private boolean diff(float f5, float f6) {
        if (Float.isNaN(f5) || Float.isNaN(f6)) {
            if (Float.isNaN(f5) != Float.isNaN(f6)) {
                return true;
            }
            return false;
        } else if (Math.abs(f5 - f6) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    public void addValues(HashMap<String, SplineSet> hashMap, int i5) {
        for (String next : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(next);
            next.getClass();
            char c5 = 65535;
            switch (next.hashCode()) {
                case -1249320806:
                    if (next.equals("rotationX")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (next.equals("rotationY")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -1249320804:
                    if (next.equals("rotationZ")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case -1225497657:
                    if (next.equals("translationX")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case -1001078227:
                    if (next.equals("progress")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case -987906986:
                    if (next.equals("pivotX")) {
                        c5 = 7;
                        break;
                    }
                    break;
                case -987906985:
                    if (next.equals("pivotY")) {
                        c5 = 8;
                        break;
                    }
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c5 = 9;
                        break;
                    }
                    break;
                case -908189617:
                    if (next.equals("scaleY")) {
                        c5 = 10;
                        break;
                    }
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c5 = 11;
                        break;
                    }
                    break;
                case 803192288:
                    if (next.equals("pathRotate")) {
                        c5 = 12;
                        break;
                    }
                    break;
            }
            float f5 = 1.0f;
            float f6 = 0.0f;
            switch (c5) {
                case 0:
                    if (!Float.isNaN(this.mRotationX)) {
                        f6 = this.mRotationX;
                    }
                    splineSet.setPoint(i5, f6);
                    break;
                case 1:
                    if (!Float.isNaN(this.rotationY)) {
                        f6 = this.rotationY;
                    }
                    splineSet.setPoint(i5, f6);
                    break;
                case 2:
                    if (!Float.isNaN(this.mRotation)) {
                        f6 = this.mRotation;
                    }
                    splineSet.setPoint(i5, f6);
                    break;
                case 3:
                    if (!Float.isNaN(this.mTranslationX)) {
                        f6 = this.mTranslationX;
                    }
                    splineSet.setPoint(i5, f6);
                    break;
                case 4:
                    if (!Float.isNaN(this.mTranslationY)) {
                        f6 = this.mTranslationY;
                    }
                    splineSet.setPoint(i5, f6);
                    break;
                case 5:
                    if (!Float.isNaN(this.mTranslationZ)) {
                        f6 = this.mTranslationZ;
                    }
                    splineSet.setPoint(i5, f6);
                    break;
                case 6:
                    if (!Float.isNaN(this.mProgress)) {
                        f6 = this.mProgress;
                    }
                    splineSet.setPoint(i5, f6);
                    break;
                case 7:
                    if (!Float.isNaN(this.mPivotX)) {
                        f6 = this.mPivotX;
                    }
                    splineSet.setPoint(i5, f6);
                    break;
                case 8:
                    if (!Float.isNaN(this.mPivotY)) {
                        f6 = this.mPivotY;
                    }
                    splineSet.setPoint(i5, f6);
                    break;
                case 9:
                    if (!Float.isNaN(this.mScaleX)) {
                        f5 = this.mScaleX;
                    }
                    splineSet.setPoint(i5, f5);
                    break;
                case 10:
                    if (!Float.isNaN(this.mScaleY)) {
                        f5 = this.mScaleY;
                    }
                    splineSet.setPoint(i5, f5);
                    break;
                case 11:
                    if (!Float.isNaN(this.mAlpha)) {
                        f5 = this.mAlpha;
                    }
                    splineSet.setPoint(i5, f5);
                    break;
                case 12:
                    if (!Float.isNaN(this.mPathRotate)) {
                        f6 = this.mPathRotate;
                    }
                    splineSet.setPoint(i5, f6);
                    break;
                default:
                    if (!next.startsWith("CUSTOM")) {
                        Utils.loge("MotionPaths", "UNKNOWN spline " + next);
                        break;
                    } else {
                        String str = next.split(",")[1];
                        if (!this.mCustomVariable.containsKey(str)) {
                            break;
                        } else {
                            CustomVariable customVariable = this.mCustomVariable.get(str);
                            if (!(splineSet instanceof SplineSet.CustomSpline)) {
                                Utils.loge("MotionPaths", next + " ViewSpline not a CustomSet frame = " + i5 + ", value" + customVariable.getValueToInterpolate() + splineSet);
                                break;
                            } else {
                                ((SplineSet.CustomSpline) splineSet).setPoint(i5, customVariable);
                                break;
                            }
                        }
                    }
            }
        }
    }

    public void applyParameters(MotionWidget motionWidget) {
        float f5;
        this.mVisibility = motionWidget.getVisibility();
        if (motionWidget.getVisibility() != 4) {
            f5 = 0.0f;
        } else {
            f5 = motionWidget.getAlpha();
        }
        this.mAlpha = f5;
        this.mApplyElevation = false;
        this.mRotation = motionWidget.getRotationZ();
        this.mRotationX = motionWidget.getRotationX();
        this.rotationY = motionWidget.getRotationY();
        this.mScaleX = motionWidget.getScaleX();
        this.mScaleY = motionWidget.getScaleY();
        this.mPivotX = motionWidget.getPivotX();
        this.mPivotY = motionWidget.getPivotY();
        this.mTranslationX = motionWidget.getTranslationX();
        this.mTranslationY = motionWidget.getTranslationY();
        this.mTranslationZ = motionWidget.getTranslationZ();
        for (String next : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(next);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.mCustomVariable.put(next, customAttribute);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void different(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (diff(this.mAlpha, motionConstrainedPoint.mAlpha)) {
            hashSet.add("alpha");
        }
        if (diff(this.mElevation, motionConstrainedPoint.mElevation)) {
            hashSet.add("translationZ");
        }
        int i5 = this.mVisibility;
        int i6 = motionConstrainedPoint.mVisibility;
        if (i5 != i6 && this.mVisibilityMode == 0 && (i5 == 4 || i6 == 4)) {
            hashSet.add("alpha");
        }
        if (diff(this.mRotation, motionConstrainedPoint.mRotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add("progress");
        }
        if (diff(this.mRotationX, motionConstrainedPoint.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add("pivotX");
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add("pivotY");
        }
        if (diff(this.mScaleX, motionConstrainedPoint.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (diff(this.mScaleY, motionConstrainedPoint.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (diff(this.mTranslationX, motionConstrainedPoint.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (diff(this.mTranslationY, motionConstrainedPoint.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (diff(this.mTranslationZ, motionConstrainedPoint.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (diff(this.mElevation, motionConstrainedPoint.mElevation)) {
            hashSet.add("elevation");
        }
    }

    /* access modifiers changed from: package-private */
    public void fillStandard(double[] dArr, int[] iArr) {
        int[] iArr2 = iArr;
        int i5 = 0;
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mAlpha, this.mElevation, this.mRotation, this.mRotationX, this.rotationY, this.mScaleX, this.mScaleY, this.mPivotX, this.mPivotY, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mPathRotate};
        for (int i6 : iArr2) {
            if (i6 < 18) {
                dArr[i5] = (double) fArr[i6];
                i5++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getCustomData(String str, double[] dArr, int i5) {
        CustomVariable customVariable = this.mCustomVariable.get(str);
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i5] = (double) customVariable.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        customVariable.getValuesToInterpolate(fArr);
        int i6 = 0;
        while (i6 < numberOfInterpolatedValues) {
            dArr[i5] = (double) fArr[i6];
            i6++;
            i5++;
        }
        return numberOfInterpolatedValues;
    }

    /* access modifiers changed from: package-private */
    public int getCustomDataCount(String str) {
        return this.mCustomVariable.get(str).numberOfInterpolatedValues();
    }

    /* access modifiers changed from: package-private */
    public boolean hasCustomData(String str) {
        return this.mCustomVariable.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void setBounds(float f5, float f6, float f7, float f8) {
        this.mX = f5;
        this.mY = f6;
        this.mWidth = f7;
        this.mHeight = f8;
    }

    public void setState(MotionWidget motionWidget) {
        setBounds((float) motionWidget.getX(), (float) motionWidget.getY(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        applyParameters(motionWidget);
    }

    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.mPosition, motionConstrainedPoint.mPosition);
    }

    public void setState(Rect rect, MotionWidget motionWidget, int i5, float f5) {
        setBounds((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        applyParameters(motionWidget);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (i5 == 1) {
            this.mRotation = f5 - 90.0f;
        } else if (i5 == 2) {
            this.mRotation = f5 + 90.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | diff(this.mPosition, motionConstrainedPoint.mPosition);
        zArr[1] = zArr[1] | diff(this.mX, motionConstrainedPoint.mX);
        zArr[2] = zArr[2] | diff(this.mY, motionConstrainedPoint.mY);
        zArr[3] = zArr[3] | diff(this.mWidth, motionConstrainedPoint.mWidth);
        zArr[4] = diff(this.mHeight, motionConstrainedPoint.mHeight) | zArr[4];
    }
}
