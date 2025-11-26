package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {"position", "x", "y", "width", "height", "pathRotate"};
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    LinkedHashMap<String, ConstraintAttribute> mAttributes;
    int mDrawPath = 0;
    float mHeight;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate = Float.NaN;
    float mPosition;
    float mProgress = Float.NaN;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float mTime;
    float mWidth;
    float mX;
    float mY;

    MotionPaths() {
        int i5 = Key.UNSET;
        this.mPathMotionArc = i5;
        this.mAnimateRelativeTo = i5;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mAttributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
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

    private static float xRotate(float f5, float f6, float f7, float f8, float f9, float f10) {
        return (((f9 - f7) * f6) - ((f10 - f8) * f5)) + f7;
    }

    private static float yRotate(float f5, float f6, float f7, float f8, float f9, float f10) {
        return ((f9 - f7) * f5) + ((f10 - f8) * f6) + f8;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = constraint.propertySet.mProgress;
        this.mRelativeAngle = constraint.layout.circleAngle;
        for (String next : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(next);
            if (constraintAttribute != null && constraintAttribute.isContinuous()) {
                this.mAttributes.put(next, constraintAttribute);
            }
        }
    }

    public void configureRelativeTo(MotionController motionController) {
        motionController.getPos((double) this.mProgress);
    }

    /* access modifiers changed from: package-private */
    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z4) {
        boolean diff = diff(this.mX, motionPaths.mX);
        boolean diff2 = diff(this.mY, motionPaths.mY);
        zArr[0] = zArr[0] | diff(this.mPosition, motionPaths.mPosition);
        boolean z5 = diff | diff2 | z4;
        zArr[1] = zArr[1] | z5;
        zArr[2] = z5 | zArr[2];
        zArr[3] = zArr[3] | diff(this.mWidth, motionPaths.mWidth);
        zArr[4] = diff(this.mHeight, motionPaths.mHeight) | zArr[4];
    }

    /* access modifiers changed from: package-private */
    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mPathRotate};
        int i5 = 0;
        for (int i6 : iArr) {
            if (i6 < 6) {
                dArr[i5] = (double) fArr[i6];
                i5++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i5) {
        float f5 = this.mWidth;
        float f6 = this.mHeight;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f7 = (float) dArr[i6];
            int i7 = iArr[i6];
            if (i7 == 3) {
                f5 = f7;
            } else if (i7 == 4) {
                f6 = f7;
            }
        }
        fArr[i5] = f5;
        fArr[i5 + 1] = f6;
    }

    /* access modifiers changed from: package-private */
    public void getCenter(double d5, int[] iArr, double[] dArr, float[] fArr, int i5) {
        int[] iArr2 = iArr;
        float f5 = this.mX;
        float f6 = this.mY;
        float f7 = this.mWidth;
        float f8 = this.mHeight;
        for (int i6 = 0; i6 < iArr2.length; i6++) {
            float f9 = (float) dArr[i6];
            int i7 = iArr2[i6];
            if (i7 == 1) {
                f5 = f9;
            } else if (i7 == 2) {
                f6 = f9;
            } else if (i7 == 3) {
                f7 = f9;
            } else if (i7 == 4) {
                f8 = f9;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d5, fArr2, new float[2]);
            float f10 = fArr2[0];
            float f11 = fArr2[1];
            double d6 = (double) f10;
            double d7 = (double) f5;
            double d8 = (double) f6;
            f5 = (float) ((d6 + (Math.sin(d8) * d7)) - ((double) (f7 / 2.0f)));
            f6 = (float) ((((double) f11) - (d7 * Math.cos(d8))) - ((double) (f8 / 2.0f)));
        }
        fArr[i5] = f5 + (f7 / 2.0f) + 0.0f;
        fArr[i5 + 1] = f6 + (f8 / 2.0f) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void getCenterVelocity(double d5, int[] iArr, double[] dArr, float[] fArr, int i5) {
        int[] iArr2 = iArr;
        float f5 = this.mX;
        float f6 = this.mY;
        float f7 = this.mWidth;
        float f8 = this.mHeight;
        for (int i6 = 0; i6 < iArr2.length; i6++) {
            float f9 = (float) dArr[i6];
            int i7 = iArr2[i6];
            if (i7 == 1) {
                f5 = f9;
            } else if (i7 == 2) {
                f6 = f9;
            } else if (i7 == 3) {
                f7 = f9;
            } else if (i7 == 4) {
                f8 = f9;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d5, fArr2, new float[2]);
            float f10 = fArr2[0];
            float f11 = fArr2[1];
            double d6 = (double) f10;
            double d7 = (double) f5;
            double d8 = (double) f6;
            f5 = (float) ((d6 + (Math.sin(d8) * d7)) - ((double) (f7 / 2.0f)));
            f6 = (float) ((((double) f11) - (d7 * Math.cos(d8))) - ((double) (f8 / 2.0f)));
        }
        fArr[i5] = f5 + (f7 / 2.0f) + 0.0f;
        fArr[i5 + 1] = f6 + (f8 / 2.0f) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int getCustomData(String str, double[] dArr, int i5) {
        ConstraintAttribute constraintAttribute = this.mAttributes.get(str);
        int i6 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            dArr[i5] = (double) constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        while (i6 < numberOfInterpolatedValues) {
            dArr[i5] = (double) fArr[i6];
            i6++;
            i5++;
        }
        return numberOfInterpolatedValues;
    }

    /* access modifiers changed from: package-private */
    public int getCustomDataCount(String str) {
        ConstraintAttribute constraintAttribute = this.mAttributes.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.numberOfInterpolatedValues();
    }

    /* access modifiers changed from: package-private */
    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i5) {
        float f5 = this.mX;
        float f6 = this.mY;
        float f7 = this.mWidth;
        float f8 = this.mHeight;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f9 = (float) dArr[i6];
            int i7 = iArr[i6];
            if (i7 == 1) {
                f5 = f9;
            } else if (i7 == 2) {
                f6 = f9;
            } else if (i7 == 3) {
                f7 = f9;
            } else if (i7 == 4) {
                f8 = f9;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
            double d5 = (double) f5;
            double d6 = (double) f6;
            f6 = (float) ((((double) this.mRelativeToController.getCenterY()) - (d5 * Math.cos(d6))) - ((double) (f8 / 2.0f)));
            f5 = (float) ((((double) centerX) + (Math.sin(d6) * d5)) - ((double) (f7 / 2.0f)));
        }
        float f10 = f7 + f5;
        float f11 = f8 + f6;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i5] = f5 + 0.0f;
        fArr[i5 + 1] = f6 + 0.0f;
        fArr[i5 + 2] = f10 + 0.0f;
        fArr[i5 + 3] = f6 + 0.0f;
        fArr[i5 + 4] = f10 + 0.0f;
        int i8 = i5 + 6;
        fArr[i5 + 5] = f11 + 0.0f;
        fArr[i8] = f5 + 0.0f;
        fArr[i5 + 7] = f11 + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean hasCustomData(String str) {
        return this.mAttributes.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void initAxis(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f5;
        float f6;
        float f7;
        float f8;
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f9 = ((float) keyPosition2.mFramePosition) / 100.0f;
        this.mTime = f9;
        this.mDrawPath = keyPosition2.mDrawPath;
        if (Float.isNaN(keyPosition2.mPercentWidth)) {
            f5 = f9;
        } else {
            f5 = keyPosition2.mPercentWidth;
        }
        if (Float.isNaN(keyPosition2.mPercentHeight)) {
            f6 = f9;
        } else {
            f6 = keyPosition2.mPercentHeight;
        }
        float f10 = motionPaths4.mWidth;
        float f11 = motionPaths3.mWidth;
        float f12 = f10 - f11;
        float f13 = motionPaths4.mHeight;
        float f14 = motionPaths3.mHeight;
        float f15 = f13 - f14;
        this.mPosition = this.mTime;
        float f16 = motionPaths3.mX;
        float f17 = (f11 / 2.0f) + f16;
        float f18 = motionPaths3.mY;
        float f19 = f18 + (f14 / 2.0f);
        float f20 = f9;
        float f21 = motionPaths4.mX + (f10 / 2.0f);
        float f22 = motionPaths4.mY + (f13 / 2.0f);
        if (f17 > f21) {
            float f23 = f17;
            f17 = f21;
            f21 = f23;
        }
        if (f19 <= f22) {
            float f24 = f19;
            f19 = f22;
            f22 = f24;
        }
        float f25 = f21 - f17;
        float f26 = f19 - f22;
        float f27 = f12 * f5;
        float f28 = f27 / 2.0f;
        this.mX = (float) ((int) ((f16 + (f25 * f20)) - f28));
        float f29 = f15 * f6;
        float f30 = f29 / 2.0f;
        this.mY = (float) ((int) ((f18 + (f26 * f20)) - f30));
        this.mWidth = (float) ((int) (f11 + f27));
        this.mHeight = (float) ((int) (f14 + f29));
        if (Float.isNaN(keyPosition2.mPercentX)) {
            f7 = f20;
        } else {
            f7 = keyPosition2.mPercentX;
        }
        float f31 = 0.0f;
        if (Float.isNaN(keyPosition2.mAltPercentY)) {
            f8 = 0.0f;
        } else {
            f8 = keyPosition2.mAltPercentY;
        }
        if (!Float.isNaN(keyPosition2.mPercentY)) {
            f20 = keyPosition2.mPercentY;
        }
        if (!Float.isNaN(keyPosition2.mAltPercentX)) {
            f31 = keyPosition2.mAltPercentX;
        }
        this.mMode = 0;
        this.mX = (float) ((int) (((motionPaths3.mX + (f7 * f25)) + (f31 * f26)) - f28));
        this.mY = (float) ((int) (((motionPaths3.mY + (f25 * f8)) + (f26 * f20)) - f30));
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition2.mTransitionEasing);
        this.mPathMotionArc = keyPosition2.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f5;
        float f6;
        float f7;
        float f8;
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f9 = ((float) keyPosition2.mFramePosition) / 100.0f;
        this.mTime = f9;
        this.mDrawPath = keyPosition2.mDrawPath;
        if (Float.isNaN(keyPosition2.mPercentWidth)) {
            f5 = f9;
        } else {
            f5 = keyPosition2.mPercentWidth;
        }
        if (Float.isNaN(keyPosition2.mPercentHeight)) {
            f6 = f9;
        } else {
            f6 = keyPosition2.mPercentHeight;
        }
        float f10 = motionPaths4.mWidth;
        float f11 = motionPaths3.mWidth;
        float f12 = motionPaths4.mHeight;
        float f13 = motionPaths3.mHeight;
        this.mPosition = this.mTime;
        float f14 = motionPaths3.mX;
        float f15 = motionPaths3.mY;
        float f16 = f9;
        float f17 = (motionPaths4.mX + (f10 / 2.0f)) - ((f11 / 2.0f) + f14);
        float f18 = (motionPaths4.mY + (f12 / 2.0f)) - (f15 + (f13 / 2.0f));
        float f19 = (f10 - f11) * f5;
        float f20 = f19 / 2.0f;
        this.mX = (float) ((int) ((f14 + (f17 * f16)) - f20));
        float f21 = (f12 - f13) * f6;
        float f22 = f21 / 2.0f;
        this.mY = (float) ((int) ((f15 + (f18 * f16)) - f22));
        this.mWidth = (float) ((int) (f11 + f19));
        this.mHeight = (float) ((int) (f13 + f21));
        if (Float.isNaN(keyPosition2.mPercentX)) {
            f7 = f16;
        } else {
            f7 = keyPosition2.mPercentX;
        }
        float f23 = 0.0f;
        if (Float.isNaN(keyPosition2.mAltPercentY)) {
            f8 = 0.0f;
        } else {
            f8 = keyPosition2.mAltPercentY;
        }
        if (!Float.isNaN(keyPosition2.mPercentY)) {
            f16 = keyPosition2.mPercentY;
        }
        if (!Float.isNaN(keyPosition2.mAltPercentX)) {
            f23 = keyPosition2.mAltPercentX;
        }
        this.mMode = 0;
        this.mX = (float) ((int) (((motionPaths3.mX + (f7 * f17)) + (f23 * f18)) - f20));
        this.mY = (float) ((int) (((motionPaths3.mY + (f17 * f8)) + (f18 * f16)) - f22));
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition2.mTransitionEasing);
        this.mPathMotionArc = keyPosition2.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f5;
        float f6;
        float f7;
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f8 = ((float) keyPosition2.mFramePosition) / 100.0f;
        this.mTime = f8;
        this.mDrawPath = keyPosition2.mDrawPath;
        if (Float.isNaN(keyPosition2.mPercentWidth)) {
            f5 = f8;
        } else {
            f5 = keyPosition2.mPercentWidth;
        }
        if (Float.isNaN(keyPosition2.mPercentHeight)) {
            f6 = f8;
        } else {
            f6 = keyPosition2.mPercentHeight;
        }
        float f9 = motionPaths4.mWidth - motionPaths3.mWidth;
        float f10 = motionPaths4.mHeight - motionPaths3.mHeight;
        this.mPosition = this.mTime;
        if (!Float.isNaN(keyPosition2.mPercentX)) {
            f8 = keyPosition2.mPercentX;
        }
        float f11 = motionPaths3.mX;
        float f12 = motionPaths3.mWidth;
        float f13 = motionPaths3.mY;
        float f14 = motionPaths3.mHeight;
        float f15 = f8;
        float f16 = motionPaths4.mX + (motionPaths4.mWidth / 2.0f);
        float f17 = f16 - ((f12 / 2.0f) + f11);
        float f18 = (motionPaths4.mY + (motionPaths4.mHeight / 2.0f)) - ((f14 / 2.0f) + f13);
        float f19 = f17 * f15;
        float f20 = f9 * f5;
        float f21 = f20 / 2.0f;
        this.mX = (float) ((int) ((f11 + f19) - f21));
        float f22 = f18 * f15;
        float f23 = f10 * f6;
        float f24 = f23 / 2.0f;
        this.mY = (float) ((int) ((f13 + f22) - f24));
        this.mWidth = (float) ((int) (f12 + f20));
        this.mHeight = (float) ((int) (f14 + f23));
        if (Float.isNaN(keyPosition2.mPercentY)) {
            f7 = 0.0f;
        } else {
            f7 = keyPosition2.mPercentY;
        }
        this.mMode = 1;
        this.mX = ((float) ((int) ((motionPaths3.mX + f19) - f21))) + ((-f18) * f7);
        this.mY = ((float) ((int) ((motionPaths3.mY + f22) - f24))) + (f17 * f7);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition2.mTransitionEasing);
        this.mPathMotionArc = keyPosition2.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void initPolar(int i5, int i6, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10 = ((float) keyPosition.mFramePosition) / 100.0f;
        this.mTime = f10;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mMode = keyPosition.mPositionType;
        if (Float.isNaN(keyPosition.mPercentWidth)) {
            f5 = f10;
        } else {
            f5 = keyPosition.mPercentWidth;
        }
        if (Float.isNaN(keyPosition.mPercentHeight)) {
            f6 = f10;
        } else {
            f6 = keyPosition.mPercentHeight;
        }
        float f11 = motionPaths2.mWidth;
        float f12 = motionPaths.mWidth;
        float f13 = motionPaths2.mHeight;
        float f14 = motionPaths.mHeight;
        this.mPosition = this.mTime;
        this.mWidth = (float) ((int) (f12 + ((f11 - f12) * f5)));
        this.mHeight = (float) ((int) (f14 + ((f13 - f14) * f6)));
        if (keyPosition.mPositionType != 2) {
            if (Float.isNaN(keyPosition.mPercentX)) {
                f9 = f10;
            } else {
                f9 = keyPosition.mPercentX;
            }
            float f15 = motionPaths2.mX;
            float f16 = motionPaths.mX;
            this.mX = (f9 * (f15 - f16)) + f16;
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f10 = keyPosition.mPercentY;
            }
            float f17 = motionPaths2.mY;
            float f18 = motionPaths.mY;
            this.mY = (f10 * (f17 - f18)) + f18;
        } else {
            if (Float.isNaN(keyPosition.mPercentX)) {
                float f19 = motionPaths2.mX;
                float f20 = motionPaths.mX;
                f7 = ((f19 - f20) * f10) + f20;
            } else {
                f7 = Math.min(f6, f5) * keyPosition.mPercentX;
            }
            this.mX = f7;
            if (Float.isNaN(keyPosition.mPercentY)) {
                float f21 = motionPaths2.mY;
                float f22 = motionPaths.mY;
                f8 = (f10 * (f21 - f22)) + f22;
            } else {
                f8 = keyPosition.mPercentY;
            }
            this.mY = f8;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void initScreen(int i5, int i6, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f5;
        float f6;
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f7 = ((float) keyPosition2.mFramePosition) / 100.0f;
        this.mTime = f7;
        this.mDrawPath = keyPosition2.mDrawPath;
        if (Float.isNaN(keyPosition2.mPercentWidth)) {
            f5 = f7;
        } else {
            f5 = keyPosition2.mPercentWidth;
        }
        if (Float.isNaN(keyPosition2.mPercentHeight)) {
            f6 = f7;
        } else {
            f6 = keyPosition2.mPercentHeight;
        }
        float f8 = motionPaths4.mWidth;
        float f9 = motionPaths3.mWidth;
        float f10 = motionPaths4.mHeight;
        float f11 = motionPaths3.mHeight;
        this.mPosition = this.mTime;
        float f12 = motionPaths3.mX;
        float f13 = motionPaths3.mY;
        float f14 = motionPaths4.mX + (f8 / 2.0f);
        float f15 = motionPaths4.mY + (f10 / 2.0f);
        float f16 = (f8 - f9) * f5;
        this.mX = (float) ((int) ((f12 + ((f14 - ((f9 / 2.0f) + f12)) * f7)) - (f16 / 2.0f)));
        float f17 = (f10 - f11) * f6;
        this.mY = (float) ((int) ((f13 + ((f15 - (f13 + (f11 / 2.0f))) * f7)) - (f17 / 2.0f)));
        this.mWidth = (float) ((int) (f9 + f16));
        this.mHeight = (float) ((int) (f11 + f17));
        this.mMode = 2;
        if (!Float.isNaN(keyPosition2.mPercentX)) {
            this.mX = (float) ((int) (keyPosition2.mPercentX * ((float) (i5 - ((int) this.mWidth)))));
        }
        if (!Float.isNaN(keyPosition2.mPercentY)) {
            this.mY = (float) ((int) (keyPosition2.mPercentY * ((float) (i6 - ((int) this.mHeight)))));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition2.mTransitionEasing);
        this.mPathMotionArc = keyPosition2.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void setBounds(float f5, float f6, float f7, float f8) {
        this.mX = f5;
        this.mY = f6;
        this.mWidth = f7;
        this.mHeight = f8;
    }

    /* access modifiers changed from: package-private */
    public void setDpDt(float f5, float f6, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            float f11 = (float) dArr[i5];
            double d5 = dArr2[i5];
            int i6 = iArr2[i5];
            if (i6 == 1) {
                f7 = f11;
            } else if (i6 == 2) {
                f9 = f11;
            } else if (i6 == 3) {
                f8 = f11;
            } else if (i6 == 4) {
                f10 = f11;
            }
        }
        float f12 = f7 - ((0.0f * f8) / 2.0f);
        float f13 = f9 - ((0.0f * f10) / 2.0f);
        fArr[0] = (f12 * (1.0f - f5)) + (((f8 * 1.0f) + f12) * f5) + 0.0f;
        fArr[1] = (f13 * (1.0f - f6)) + (((f10 * 1.0f) + f13) * f6) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void setView(float f5, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z4) {
        float f6;
        View view2 = view;
        int[] iArr2 = iArr;
        float f7 = this.mX;
        float f8 = this.mY;
        float f9 = this.mWidth;
        float f10 = this.mHeight;
        if (iArr2.length != 0 && this.mTempValue.length <= iArr2[iArr2.length - 1]) {
            int i5 = iArr2[iArr2.length - 1] + 1;
            this.mTempValue = new double[i5];
            this.mTempDelta = new double[i5];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i6 = 0; i6 < iArr2.length; i6++) {
            double[] dArr4 = this.mTempValue;
            int i7 = iArr2[i6];
            dArr4[i7] = dArr[i6];
            this.mTempDelta[i7] = dArr2[i6];
        }
        float f11 = Float.NaN;
        int i8 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i8 >= dArr5.length) {
                break;
            }
            double d5 = 0.0d;
            if (!Double.isNaN(dArr5[i8]) || !(dArr3 == null || dArr3[i8] == 0.0d)) {
                if (dArr3 != null) {
                    d5 = dArr3[i8];
                }
                if (!Double.isNaN(this.mTempValue[i8])) {
                    d5 = this.mTempValue[i8] + d5;
                }
                f6 = f11;
                float f16 = (float) d5;
                float f17 = (float) this.mTempDelta[i8];
                if (i8 == 1) {
                    f11 = f6;
                    f12 = f17;
                    f7 = f16;
                } else if (i8 == 2) {
                    f11 = f6;
                    f13 = f17;
                    f8 = f16;
                } else if (i8 == 3) {
                    f11 = f6;
                    f14 = f17;
                    f9 = f16;
                } else if (i8 == 4) {
                    f11 = f6;
                    f15 = f17;
                    f10 = f16;
                } else if (i8 == 5) {
                    f11 = f16;
                }
                i8++;
            } else {
                f6 = f11;
            }
            f11 = f6;
            i8++;
        }
        float f18 = f11;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter((double) f5, fArr, fArr2);
            float f19 = fArr[0];
            float f20 = fArr[1];
            float f21 = fArr2[0];
            float f22 = fArr2[1];
            double d6 = (double) f7;
            double d7 = (double) f8;
            f7 = (float) ((((double) f19) + (Math.sin(d7) * d6)) - ((double) (f9 / 2.0f)));
            f8 = (float) ((((double) f20) - (Math.cos(d7) * d6)) - ((double) (f10 / 2.0f)));
            double d8 = (double) f21;
            double d9 = (double) f12;
            double d10 = d7;
            double d11 = (double) f13;
            float sin = (float) (d8 + (Math.sin(d7) * d9) + (Math.cos(d7) * d6 * d11));
            float cos = (float) ((((double) f22) - (d9 * Math.cos(d10))) + (Math.sin(d10) * d6 * d11));
            double[] dArr6 = dArr2;
            if (dArr6.length >= 2) {
                dArr6[0] = (double) sin;
                dArr6[1] = (double) cos;
            }
            if (!Float.isNaN(f18)) {
                view2.setRotation((float) (((double) f18) + Math.toDegrees(Math.atan2((double) cos, (double) sin))));
            }
        } else {
            float f23 = f18;
            if (!Float.isNaN(f23)) {
                view2.setRotation(f23 + ((float) Math.toDegrees(Math.atan2((double) (f13 + (f15 / 2.0f)), (double) (f12 + (f14 / 2.0f))))) + 0.0f);
            }
        }
        if (view2 instanceof FloatLayout) {
            ((FloatLayout) view2).layout(f7, f8, f9 + f7, f10 + f8);
            return;
        }
        float f24 = f7 + 0.5f;
        int i9 = (int) f24;
        float f25 = f8 + 0.5f;
        int i10 = (int) f25;
        int i11 = (int) (f24 + f9);
        int i12 = (int) (f25 + f10);
        int i13 = i11 - i9;
        int i14 = i12 - i10;
        if (!(i13 == view2.getMeasuredWidth() && i14 == view2.getMeasuredHeight() && !z4)) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), View.MeasureSpec.makeMeasureSpec(i14, 1073741824));
        }
        view2.layout(i9, i10, i11, i12);
    }

    public void setupRelative(MotionController motionController, MotionPaths motionPaths) {
        double d5 = (double) (((this.mX + (this.mWidth / 2.0f)) - motionPaths.mX) - (motionPaths.mWidth / 2.0f));
        double d6 = (double) (((this.mY + (this.mHeight / 2.0f)) - motionPaths.mY) - (motionPaths.mHeight / 2.0f));
        this.mRelativeToController = motionController;
        this.mX = (float) Math.hypot(d6, d5);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.mY = (float) (Math.atan2(d6, d5) + 1.5707963267948966d);
        } else {
            this.mY = (float) Math.toRadians((double) this.mRelativeAngle);
        }
    }

    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.mPosition, motionPaths.mPosition);
    }

    MotionPaths(int i5, int i6, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i7 = Key.UNSET;
        this.mPathMotionArc = i7;
        this.mAnimateRelativeTo = i7;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mAttributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != Key.UNSET) {
            initPolar(i5, i6, keyPosition, motionPaths, motionPaths2);
            return;
        }
        MotionPaths motionPaths3 = motionPaths2;
        MotionPaths motionPaths4 = motionPaths;
        KeyPosition keyPosition2 = keyPosition;
        int i8 = i6;
        int i9 = keyPosition2.mPositionType;
        if (i9 == 1) {
            initPath(keyPosition2, motionPaths4, motionPaths3);
        } else if (i9 == 2) {
            initScreen(i5, i8, keyPosition2, motionPaths4, motionPaths3);
        } else if (i9 != 3) {
            initCartesian(keyPosition2, motionPaths4, motionPaths3);
        } else {
            initAxis(keyPosition2, motionPaths4, motionPaths3);
        }
    }

    /* access modifiers changed from: package-private */
    public void getCenter(double d5, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f5;
        int[] iArr2 = iArr;
        float f6 = this.mX;
        float f7 = this.mY;
        float f8 = this.mWidth;
        float f9 = this.mHeight;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            float f14 = (float) dArr[i5];
            float f15 = (float) dArr2[i5];
            int i6 = iArr2[i5];
            if (i6 == 1) {
                f6 = f14;
                f10 = f15;
            } else if (i6 == 2) {
                f7 = f14;
                f12 = f15;
            } else if (i6 == 3) {
                f8 = f14;
                f11 = f15;
            } else if (i6 == 4) {
                f9 = f14;
                f13 = f15;
            }
        }
        float f16 = (f11 / 2.0f) + f10;
        float f17 = (f13 / 2.0f) + f12;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.getCenter(d5, fArr3, fArr4);
            float f18 = fArr3[0];
            float f19 = fArr3[1];
            float f20 = fArr4[0];
            float f21 = fArr4[1];
            f5 = 2.0f;
            double d6 = (double) f6;
            double d7 = (double) f7;
            f6 = (float) ((((double) f18) + (Math.sin(d7) * d6)) - ((double) (f8 / 2.0f)));
            double d8 = d7;
            f7 = (float) ((((double) f19) - (Math.cos(d7) * d6)) - ((double) (f9 / 2.0f)));
            double d9 = (double) f10;
            double d10 = (double) f12;
            f17 = (float) ((((double) f21) - (d9 * Math.cos(d8))) + (Math.sin(d8) * d10));
            f16 = (float) (((double) f20) + (Math.sin(d8) * d9) + (Math.cos(d8) * d10));
        } else {
            f5 = 2.0f;
        }
        fArr[0] = f6 + (f8 / f5) + 0.0f;
        fArr[1] = f7 + (f9 / f5) + 0.0f;
        fArr2[0] = f16;
        fArr2[1] = f17;
    }
}
