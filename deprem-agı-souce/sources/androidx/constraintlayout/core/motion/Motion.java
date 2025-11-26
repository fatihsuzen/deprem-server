package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Motion implements TypedValues {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    String[] mAttributeTable;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType = 0;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    public String mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<MotionKey> mKeyList = new ArrayList<>();
    private MotionKeyTrigger[] mKeyTriggers;
    private int mMaxDimension = 4;
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    float mMotionStagger = Float.NaN;
    private boolean mNoMovement = false;
    private int mPathMotionArc = -1;
    private DifferentialInterpolator mQuantizeMotionInterpolator = null;
    private float mQuantizeMotionPhase = Float.NaN;
    private int mQuantizeMotionSteps = -1;
    Motion mRelativeMotion;
    private CurveFit[] mSpline;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    Rect mTempRect = new Rect();
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private int mTransformPivotTarget = -1;
    private MotionWidget mTransformPivotView = null;
    private float[] mValuesBuff = new float[4];
    private float[] mVelocity = new float[1];
    MotionWidget mView;

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    private float getAdjustedPosition(float f5, float[] fArr) {
        float f6 = 0.0f;
        float f7 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f8 = this.mStaggerScale;
            if (((double) f8) != 1.0d) {
                float f9 = this.mStaggerOffset;
                if (f5 < f9) {
                    f5 = 0.0f;
                }
                if (f5 > f9 && ((double) f5) < 1.0d) {
                    f5 = Math.min((f5 - f9) * f8, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        float f10 = Float.NaN;
        int i5 = 0;
        while (i5 < size) {
            MotionPaths motionPaths = arrayList.get(i5);
            i5++;
            MotionPaths motionPaths2 = motionPaths;
            Easing easing2 = motionPaths2.mKeyFrameEasing;
            if (easing2 != null) {
                float f11 = motionPaths2.mTime;
                if (f11 < f5) {
                    easing = easing2;
                    f6 = f11;
                } else if (Float.isNaN(f10)) {
                    f10 = motionPaths2.mTime;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f10)) {
                f7 = f10;
            }
            float f12 = f7 - f6;
            double d5 = (double) ((f5 - f6) / f12);
            f5 = (((float) easing.get(d5)) * f12) + f6;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d5);
            }
        }
        return f5;
    }

    private static DifferentialInterpolator getInterpolator(int i5, String str, int i6) {
        if (i5 != -1) {
            return null;
        }
        final Easing interpolator = Easing.getInterpolator(str);
        return new DifferentialInterpolator() {
            float mX;

            public float getInterpolation(float f5) {
                this.mX = f5;
                return (float) Easing.this.get((double) f5);
            }

            public float getVelocity() {
                return (float) Easing.this.getDiff((double) this.mX);
            }
        };
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f5 = 1.0f / ((float) 99);
        double d5 = 0.0d;
        double d6 = 0.0d;
        int i5 = 0;
        float f6 = 0.0f;
        while (i5 < 100) {
            float f7 = ((float) i5) * f5;
            double d7 = (double) f7;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f8 = Float.NaN;
            int i6 = 0;
            float f9 = 0.0f;
            while (i6 < size) {
                MotionPaths motionPaths = arrayList.get(i6);
                i6++;
                MotionPaths motionPaths2 = motionPaths;
                float f10 = f5;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    Easing easing3 = easing2;
                    float f11 = motionPaths2.mTime;
                    if (f11 < f7) {
                        f9 = f11;
                        easing = easing3;
                    } else if (Float.isNaN(f8)) {
                        f8 = motionPaths2.mTime;
                    }
                }
                f5 = f10;
            }
            float f12 = f5;
            if (easing != null) {
                if (Float.isNaN(f8)) {
                    f8 = 1.0f;
                }
                float f13 = f8 - f9;
                d7 = (double) ((((float) easing.get((double) ((f7 - f9) / f13))) * f13) + f9);
            }
            double d8 = d7;
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            int i7 = i5;
            this.mStartMotionPath.getCenter(d8, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i7 > 0) {
                f6 += (float) Math.hypot(d6 - ((double) fArr[1]), d5 - ((double) fArr[0]));
            }
            d5 = (double) fArr[0];
            d6 = (double) fArr[1];
            i5 = i7 + 1;
            f5 = f12;
        }
        return f6;
    }

    private void insertKey(MotionPaths motionPaths) {
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        MotionPaths motionPaths2 = null;
        int i5 = 0;
        while (i5 < size) {
            MotionPaths motionPaths3 = arrayList.get(i5);
            i5++;
            MotionPaths motionPaths4 = motionPaths3;
            if (motionPaths.mPosition == motionPaths4.mPosition) {
                motionPaths2 = motionPaths4;
            }
        }
        if (motionPaths2 != null) {
            this.mMotionPaths.remove(motionPaths2);
        }
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Utils.loge(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((float) this.mView.getX(), (float) this.mView.getY(), (float) this.mView.getWidth(), (float) this.mView.getHeight());
    }

    public void addKey(MotionKey motionKey) {
        this.mKeyList.add(motionKey);
    }

    /* access modifiers changed from: package-private */
    public void addKeys(ArrayList<MotionKey> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void buildBounds(float[] fArr, int i5) {
        int i6 = i5;
        float f5 = 1.0f;
        float f6 = 1.0f / ((float) (i6 - 1));
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            SplineSet splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            SplineSet splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            KeyCycleOscillator keyCycleOscillator = hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            KeyCycleOscillator keyCycleOscillator2 = hashMap4.get("translationY");
        }
        int i7 = 0;
        while (i7 < i6) {
            float f7 = ((float) i7) * f6;
            float f8 = this.mStaggerScale;
            float f9 = 0.0f;
            if (f8 != f5) {
                float f10 = this.mStaggerOffset;
                if (f7 < f10) {
                    f7 = 0.0f;
                }
                if (f7 > f10 && ((double) f7) < 1.0d) {
                    f7 = Math.min((f7 - f10) * f8, f5);
                }
            }
            double d5 = (double) f7;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f11 = Float.NaN;
            int i8 = 0;
            while (i8 < size) {
                MotionPaths motionPaths = arrayList.get(i8);
                i8++;
                MotionPaths motionPaths2 = motionPaths;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f12 = motionPaths2.mTime;
                    if (f12 < f7) {
                        easing = easing2;
                        f9 = f12;
                    } else if (Float.isNaN(f11)) {
                        f11 = motionPaths2.mTime;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f11)) {
                    f11 = 1.0f;
                }
                float f13 = f11 - f9;
                d5 = (double) ((((float) easing.get((double) ((f7 - f9) / f13))) * f13) + f9);
            }
            this.mSpline[0].getPos(d5, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d5, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i7 * 2);
            i7++;
            f5 = 1.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                MotionPaths motionPaths = arrayList.get(i6);
                i6++;
                iArr[i5] = motionPaths.mMode;
                i5++;
            }
        }
        int i7 = 0;
        for (double pos : timePoints) {
            this.mSpline[0].getPos(pos, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i7);
            i7 += 2;
        }
        return i7 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                MotionPaths motionPaths = arrayList.get(i6);
                i6++;
                iArr[i5] = motionPaths.mMode;
                i5++;
            }
        }
        if (iArr2 != null) {
            ArrayList<MotionPaths> arrayList2 = this.mMotionPaths;
            int size2 = arrayList2.size();
            int i7 = 0;
            int i8 = 0;
            while (i8 < size2) {
                MotionPaths motionPaths2 = arrayList2.get(i8);
                i8++;
                iArr2[i7] = (int) (motionPaths2.mPosition * 100.0f);
                i7++;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < timePoints.length; i10++) {
            this.mSpline[0].getPos(timePoints[i10], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i10], this.mInterpolateVariables, this.mInterpolateData, fArr, i9);
            i9 += 2;
        }
        return i9 / 2;
    }

    public void buildPath(float[] fArr, int i5) {
        SplineSet splineSet;
        SplineSet splineSet2;
        KeyCycleOscillator keyCycleOscillator;
        int i6 = i5;
        float f5 = 1.0f;
        float f6 = 1.0f / ((float) (i6 - 1));
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator2 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            keyCycleOscillator2 = hashMap4.get("translationY");
        }
        int i7 = 0;
        while (i7 < i6) {
            float f7 = ((float) i7) * f6;
            float f8 = this.mStaggerScale;
            float f9 = 0.0f;
            if (f8 != f5) {
                float f10 = this.mStaggerOffset;
                if (f7 < f10) {
                    f7 = 0.0f;
                }
                if (f7 > f10 && ((double) f7) < 1.0d) {
                    f7 = Math.min((f7 - f10) * f8, f5);
                }
            }
            double d5 = (double) f7;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f11 = Float.NaN;
            int i8 = 0;
            while (i8 < size) {
                MotionPaths motionPaths = arrayList.get(i8);
                i8++;
                MotionPaths motionPaths2 = motionPaths;
                float f12 = f6;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    Easing easing3 = easing2;
                    float f13 = motionPaths2.mTime;
                    if (f13 < f7) {
                        f9 = f13;
                        easing = easing3;
                    } else if (Float.isNaN(f11)) {
                        f11 = motionPaths2.mTime;
                    }
                }
                int i9 = i5;
                f6 = f12;
            }
            float f14 = f6;
            if (easing != null) {
                if (Float.isNaN(f11)) {
                    f11 = 1.0f;
                }
                float f15 = f11 - f9;
                d5 = (double) ((((float) easing.get((double) ((f7 - f9) / f15))) * f15) + f9);
            }
            this.mSpline[0].getPos(d5, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d5, dArr);
                }
            }
            int i10 = i7 * 2;
            this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, this.mInterpolateData, fArr, i10);
            if (keyCycleOscillator != null) {
                fArr[i10] = fArr[i10] + keyCycleOscillator.get(f7);
            } else if (splineSet != null) {
                fArr[i10] = fArr[i10] + splineSet.get(f7);
            }
            if (keyCycleOscillator2 != null) {
                int i11 = i10 + 1;
                fArr[i11] = fArr[i11] + keyCycleOscillator2.get(f7);
            } else if (splineSet2 != null) {
                int i12 = i10 + 1;
                fArr[i12] = fArr[i12] + splineSet2.get(f7);
            }
            i7++;
            i6 = i5;
            f6 = f14;
            f5 = 1.0f;
        }
    }

    public void buildRect(float f5, float[] fArr, int i5) {
        this.mSpline[0].getPos((double) getAdjustedPosition(f5, (float[]) null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i5);
    }

    /* access modifiers changed from: package-private */
    public void buildRectangles(float[] fArr, int i5) {
        float f5 = 1.0f / ((float) (i5 - 1));
        for (int i6 = 0; i6 < i5; i6++) {
            this.mSpline[0].getPos((double) getAdjustedPosition(((float) i6) * f5, (float[]) null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i6 * 8);
        }
    }

    /* access modifiers changed from: package-private */
    public void endTrigger(boolean z4) {
    }

    public String getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    /* access modifiers changed from: package-private */
    public int getAttributeValues(String str, float[] fArr, int i5) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i6 = 0; i6 < fArr.length; i6++) {
            fArr[i6] = splineSet.get((float) (i6 / (fArr.length - 1)));
        }
        return fArr.length;
    }

    public void getCenter(double d5, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d5, dArr);
        this.mSpline[0].getSlope(d5, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f5, float f6, float f7, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f5, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i5 = 0;
        if (curveFitArr != null) {
            double d5 = (double) adjustedPosition;
            curveFitArr[0].getSlope(d5, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d5, this.mInterpolateData);
            float f8 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i5 >= dArr.length) {
                    break;
                }
                dArr[i5] = dArr[i5] * ((double) f8);
                i5++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d5, dArr2);
                    this.mArcSpline.getSlope(d5, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f6, f7, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f6, f7, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        float f9 = f6;
        float f10 = f7;
        float[] fArr2 = fArr;
        MotionPaths motionPaths = this.mEndMotionPath;
        float f11 = motionPaths.mX;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f12 = f11 - motionPaths2.mX;
        float f13 = motionPaths.mY - motionPaths2.mY;
        float f14 = (motionPaths.mWidth - motionPaths2.mWidth) + f12;
        float f15 = (motionPaths.mHeight - motionPaths2.mHeight) + f13;
        fArr2[0] = (f12 * (1.0f - f9)) + (f14 * f9);
        fArr2[1] = (f13 * (1.0f - f10)) + (f15 * f10);
    }

    public int getDrawPath() {
        int i5 = this.mStartMotionPath.mDrawPath;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            MotionPaths motionPaths = arrayList.get(i6);
            i6++;
            i5 = Math.max(i5, motionPaths.mDrawPath);
        }
        return Math.max(i5, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.mHeight;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.mWidth;
    }

    public float getFinalX() {
        return this.mEndMotionPath.mX;
    }

    public float getFinalY() {
        return this.mEndMotionPath.mY;
    }

    public int getId(String str) {
        return 0;
    }

    public MotionPaths getKeyFrame(int i5) {
        return this.mMotionPaths.get(i5);
    }

    public int getKeyFrameInfo(int i5, int[] iArr) {
        int i6 = i5;
        float[] fArr = new float[2];
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < size) {
            int i10 = i7 + 1;
            MotionKey motionKey = arrayList.get(i7);
            int i11 = motionKey.mType;
            if (i11 == i6 || i6 != -1) {
                iArr[i9] = 0;
                iArr[i9 + 1] = i11;
                int i12 = motionKey.mFramePosition;
                iArr[i9 + 2] = i12;
                double d5 = (double) (((float) i12) / 100.0f);
                this.mSpline[0].getPos(d5, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i9 + 3] = Float.floatToIntBits(fArr[0]);
                int i13 = i9 + 4;
                iArr[i13] = Float.floatToIntBits(fArr[1]);
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    iArr[i9 + 5] = motionKeyPosition.mPositionType;
                    iArr[i9 + 6] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i13 = i9 + 7;
                    iArr[i13] = Float.floatToIntBits(motionKeyPosition.mPercentY);
                }
                int i14 = i13 + 1;
                iArr[i9] = i14 - i9;
                i8++;
                i9 = i14;
            }
            i7 = i10;
        }
        return i8;
    }

    /* access modifiers changed from: package-private */
    public float getKeyFrameParameter(int i5, float f5, float f6) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f7 = motionPaths.mX;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f8 = motionPaths2.mX;
        float f9 = f7 - f8;
        float f10 = motionPaths.mY;
        float f11 = motionPaths2.mY;
        float f12 = f10 - f11;
        float f13 = f8 + (motionPaths2.mWidth / 2.0f);
        float f14 = f11 + (motionPaths2.mHeight / 2.0f);
        float hypot = (float) Math.hypot((double) f9, (double) f12);
        if (((double) hypot) < 1.0E-7d) {
            return Float.NaN;
        }
        float f15 = f5 - f13;
        float f16 = f6 - f14;
        if (((float) Math.hypot((double) f15, (double) f16)) == 0.0f) {
            return 0.0f;
        }
        float f17 = (f15 * f9) + (f16 * f12);
        if (i5 == 0) {
            return f17 / hypot;
        }
        if (i5 == 1) {
            return (float) Math.sqrt((double) ((hypot * hypot) - (f17 * f17)));
        }
        if (i5 == 2) {
            return f15 / f9;
        }
        if (i5 == 3) {
            return f16 / f9;
        }
        if (i5 == 4) {
            return f15 / f12;
        }
        if (i5 != 5) {
            return 0.0f;
        }
        return f16 / f12;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            int i8 = i6 + 1;
            MotionKey motionKey = arrayList.get(i6);
            int i9 = motionKey.mFramePosition;
            iArr[i5] = (motionKey.mType * 1000) + i9;
            double d5 = (double) (((float) i9) / 100.0f);
            this.mSpline[0].getPos(d5, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, this.mInterpolateData, fArr, i7);
            i7 += 2;
            i6 = i8;
            i5++;
        }
        return i5;
    }

    public float getMotionStagger() {
        return this.mMotionStagger;
    }

    /* access modifiers changed from: package-private */
    public double[] getPos(double d5) {
        this.mSpline[0].getPos(d5, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d5, dArr);
            }
        }
        return this.mInterpolateData;
    }

    /* access modifiers changed from: package-private */
    public MotionKeyPosition getPositionKeyframe(int i5, int i6, float f5, float f6) {
        float f7;
        float f8;
        int i7;
        int i8;
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f9 = motionPaths.mX;
        floatRect.left = f9;
        float f10 = motionPaths.mY;
        floatRect.top = f10;
        floatRect.right = f9 + motionPaths.mWidth;
        floatRect.bottom = f10 + motionPaths.mHeight;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f11 = motionPaths2.mX;
        floatRect2.left = f11;
        float f12 = motionPaths2.mY;
        floatRect2.top = f12;
        floatRect2.right = f11 + motionPaths2.mWidth;
        floatRect2.bottom = f12 + motionPaths2.mHeight;
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            int i10 = i9 + 1;
            MotionKey motionKey = arrayList.get(i9);
            if (motionKey instanceof MotionKeyPosition) {
                MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                i8 = i5;
                i7 = i6;
                f8 = f5;
                f7 = f6;
                if (motionKeyPosition.intersects(i8, i7, floatRect, floatRect2, f8, f7)) {
                    return motionKeyPosition;
                }
            } else {
                i8 = i5;
                i7 = i6;
                f8 = f5;
                f7 = f6;
            }
            i5 = i8;
            i6 = i7;
            f5 = f8;
            f6 = f7;
            i9 = i10;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void getPostLayoutDvDp(float f5, int i5, int i6, float f6, float f7, float[] fArr) {
        SplineSet splineSet;
        SplineSet splineSet2;
        SplineSet splineSet3;
        SplineSet splineSet4;
        SplineSet splineSet5;
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        KeyCycleOscillator keyCycleOscillator3;
        KeyCycleOscillator keyCycleOscillator4;
        float adjustedPosition = getAdjustedPosition(f5, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator5 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        if (hashMap3 == null) {
            splineSet3 = null;
        } else {
            splineSet3 = hashMap3.get("rotationZ");
        }
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        if (hashMap4 == null) {
            splineSet4 = null;
        } else {
            splineSet4 = hashMap4.get("scaleX");
        }
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        if (hashMap5 == null) {
            splineSet5 = null;
        } else {
            splineSet5 = hashMap5.get("scaleY");
        }
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        if (hashMap6 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = hashMap6.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        if (hashMap7 == null) {
            keyCycleOscillator2 = null;
        } else {
            keyCycleOscillator2 = hashMap7.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        if (hashMap8 == null) {
            keyCycleOscillator3 = null;
        } else {
            keyCycleOscillator3 = hashMap8.get("rotationZ");
        }
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        if (hashMap9 == null) {
            keyCycleOscillator4 = null;
        } else {
            keyCycleOscillator4 = hashMap9.get("scaleX");
        }
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        if (hashMap10 != null) {
            keyCycleOscillator5 = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d5 = (double) adjustedPosition;
                curveFit.getPos(d5, dArr);
                this.mArcSpline.getSlope(d5, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f6, f7, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f6, f7, i5, i6, fArr);
            return;
        }
        int i7 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = (double) getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f8 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i7 < dArr2.length) {
                    dArr2[i7] = dArr2[i7] * ((double) f8);
                    i7++;
                } else {
                    float f9 = f6;
                    float f10 = f7;
                    float[] fArr2 = fArr;
                    this.mStartMotionPath.setDpDt(f9, f10, fArr2, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f9, f10, i5, i6, fArr2);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f11 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f12 = f11 - motionPaths2.mX;
            float f13 = motionPaths.mY - motionPaths2.mY;
            fArr[0] = (f12 * (1.0f - f6)) + (((motionPaths.mWidth - motionPaths2.mWidth) + f12) * f6);
            fArr[1] = (f13 * (1.0f - f7)) + ((f13 + (motionPaths.mHeight - motionPaths2.mHeight)) * f7);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f6, f7, i5, i6, fArr);
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.mHeight;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.mWidth;
    }

    public float getStartX() {
        return this.mStartMotionPath.mX;
    }

    public float getStartY() {
        return this.mStartMotionPath.mY;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget motionWidget, float f5, long j5, KeyCache keyCache) {
        float f6;
        MotionWidget motionWidget2 = motionWidget;
        float adjustedPosition = getAdjustedPosition(f5, (float[]) null);
        int i5 = this.mQuantizeMotionSteps;
        if (i5 != -1) {
            float f7 = 1.0f / ((float) i5);
            float floor = ((float) Math.floor((double) (adjustedPosition / f7))) * f7;
            float f8 = (adjustedPosition % f7) / f7;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f8 = (f8 + this.mQuantizeMotionPhase) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.mQuantizeMotionInterpolator;
            if (differentialInterpolator != null) {
                f6 = differentialInterpolator.getInterpolation(f8);
            } else if (((double) f8) > 0.5d) {
                f6 = 1.0f;
            } else {
                f6 = 0.0f;
            }
            adjustedPosition = (f6 * f7) + floor;
        }
        float f9 = adjustedPosition;
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            for (SplineSet property : hashMap.values()) {
                property.setProperty(motionWidget2, f9);
            }
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d5 = (double) f9;
            curveFitArr[0].getPos(d5, this.mInterpolateData);
            this.mSpline[0].getSlope(d5, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d5, dArr);
                    this.mArcSpline.getSlope(d5, this.mInterpolateVelocity);
                }
            }
            if (!this.mNoMovement) {
                float f10 = f9;
                MotionWidget motionWidget3 = motionWidget2;
                float f11 = f10;
                this.mStartMotionPath.setView(f11, motionWidget3, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, (double[]) null);
                MotionWidget motionWidget4 = motionWidget3;
                f9 = f11;
                motionWidget2 = motionWidget4;
            }
            if (this.mTransformPivotTarget != -1) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = motionWidget2.getParent().findViewById(this.mTransformPivotTarget);
                }
                MotionWidget motionWidget5 = this.mTransformPivotView;
                if (motionWidget5 != null) {
                    float top = ((float) (motionWidget5.getTop() + this.mTransformPivotView.getBottom())) / 2.0f;
                    float left = ((float) (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight())) / 2.0f;
                    if (motionWidget2.getRight() - motionWidget2.getLeft() > 0 && motionWidget2.getBottom() - motionWidget2.getTop() > 0) {
                        motionWidget2.setPivotX(left - ((float) motionWidget2.getLeft()));
                        motionWidget2.setPivotY(top - ((float) motionWidget2.getTop()));
                    }
                }
            }
            int i6 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i6 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i6].getPos(d5, this.mValuesBuff);
                this.mStartMotionPath.mCustomAttributes.get(this.mAttributeNames[i6 - 1]).setInterpolatedValue(motionWidget2, this.mValuesBuff);
                i6++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f9 <= 0.0f) {
                    motionWidget2.setVisibility(motionConstrainedPoint.mVisibility);
                } else if (f9 >= 1.0f) {
                    motionWidget2.setVisibility(this.mEndPoint.mVisibility);
                } else if (this.mEndPoint.mVisibility != motionConstrainedPoint.mVisibility) {
                    motionWidget2.setVisibility(4);
                }
            }
            if (this.mKeyTriggers != null) {
                int i7 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.mKeyTriggers;
                    if (i7 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i7].conditionallyFire(f9, motionWidget2);
                    i7++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f12 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f13 = f12 + ((motionPaths2.mX - f12) * f9);
            float f14 = motionPaths.mY;
            float f15 = f14 + ((motionPaths2.mY - f14) * f9);
            float f16 = motionPaths.mWidth;
            float f17 = f16 + ((motionPaths2.mWidth - f16) * f9);
            float f18 = motionPaths.mHeight;
            float f19 = f13 + 0.5f;
            float f20 = f15 + 0.5f;
            motionWidget2.layout((int) f19, (int) f20, (int) (f19 + f17), (int) (f20 + f18 + ((motionPaths2.mHeight - f18) * f9)));
        }
        HashMap<String, KeyCycleOscillator> hashMap2 = this.mCycleMap;
        if (hashMap2 != null) {
            for (KeyCycleOscillator next : hashMap2.values()) {
                if (next instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr2 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) next).setPathRotate(motionWidget2, f9, dArr2[0], dArr2[1]);
                } else {
                    next.setProperty(motionWidget2, f9);
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String name() {
        return this.mView.getName();
    }

    /* access modifiers changed from: package-private */
    public void positionKeyframe(MotionWidget motionWidget, MotionKeyPosition motionKeyPosition, float f5, float f6, String[] strArr, float[] fArr) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f7 = motionPaths.mX;
        floatRect.left = f7;
        float f8 = motionPaths.mY;
        floatRect.top = f8;
        floatRect.right = f7 + motionPaths.mWidth;
        floatRect.bottom = f8 + motionPaths.mHeight;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f9 = motionPaths2.mX;
        floatRect2.left = f9;
        float f10 = motionPaths2.mY;
        floatRect2.top = f10;
        floatRect2.right = f9 + motionPaths2.mWidth;
        floatRect2.bottom = f10 + motionPaths2.mHeight;
        motionKeyPosition.positionAttributes(motionWidget, floatRect, floatRect2, f5, f6, strArr, fArr);
    }

    /* access modifiers changed from: package-private */
    public void rotate(Rect rect, Rect rect2, int i5, int i6, int i7) {
        if (i5 == 1) {
            int i8 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i7 - ((i8 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i5 == 2) {
            int i9 = rect.left + rect.right;
            rect2.left = i6 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i9 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i5 == 3) {
            int i10 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i10 / 2);
            rect2.top = i7 - ((i10 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i5 == 4) {
            int i11 = rect.left + rect.right;
            rect2.left = i6 - (((rect.bottom + rect.top) + rect.width()) / 2);
            rect2.top = (i11 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
    }

    /* access modifiers changed from: package-private */
    public void setBothStates(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds((float) motionWidget.getX(), (float) motionWidget.getY(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        this.mEndMotionPath.setBounds((float) motionWidget.getX(), (float) motionWidget.getY(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        this.mStartPoint.setState(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setDrawPath(int i5) {
        this.mStartMotionPath.mDrawPath = i5;
    }

    public void setEnd(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.mTime = 1.0f;
        motionPaths.mPosition = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds((float) motionWidget.getLeft(), (float) motionWidget.getTop(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        this.mEndMotionPath.applyParameters(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setIdString(String str) {
        this.mId = str;
        this.mStartMotionPath.mId = str;
    }

    public void setPathMotionArc(int i5) {
        this.mPathMotionArc = i5;
    }

    public void setStaggerOffset(float f5) {
        this.mStaggerOffset = f5;
    }

    public void setStaggerScale(float f5) {
        this.mStaggerScale = f5;
    }

    public void setStart(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        motionPaths.setBounds((float) motionWidget.getX(), (float) motionWidget.getY(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        this.mStartMotionPath.applyParameters(motionWidget);
        this.mStartPoint.setState(motionWidget);
        TypedBundle motionProperties = motionWidget.getWidgetFrame().getMotionProperties();
        if (motionProperties != null) {
            motionProperties.applyDelta((TypedValues) this);
        }
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i5, int i6, int i7) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        Rect rect = new Rect();
        if (i5 == 1) {
            int i8 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i6 - ((i8 + viewState.height()) / 2);
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        } else if (i5 == 2) {
            int i9 = viewState.left + viewState.right;
            rect.left = i7 - (((viewState.top + viewState.bottom) + viewState.width()) / 2);
            rect.top = (i9 - viewState.height()) / 2;
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        }
        this.mStartMotionPath.setBounds((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.mStartPoint.setState(rect, motionWidget, i5, viewState.rotation);
    }

    public void setTransformPivotTarget(int i5) {
        this.mTransformPivotTarget = i5;
        this.mTransformPivotView = null;
    }

    public boolean setValue(int i5, boolean z4) {
        return false;
    }

    public void setView(MotionWidget motionWidget) {
        this.mView = motionWidget;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v3, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setup(int r23, int r24, float r25, long r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r26
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r0.setupRelative()
            int r7 = r0.mPathMotionArc
            r8 = -1
            if (r7 == r8) goto L_0x002d
            androidx.constraintlayout.core.motion.MotionPaths r9 = r0.mStartMotionPath
            int r10 = r9.mPathMotionArc
            if (r10 != r8) goto L_0x002d
            r9.mPathMotionArc = r7
        L_0x002d:
            androidx.constraintlayout.core.motion.MotionConstrainedPoint r7 = r0.mStartPoint
            androidx.constraintlayout.core.motion.MotionConstrainedPoint r9 = r0.mEndPoint
            r7.different(r9, r4)
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r7 = r0.mKeyList
            r9 = 0
            if (r7 == 0) goto L_0x0098
            int r11 = r7.size()
            r13 = r9
            r12 = 0
        L_0x003f:
            if (r13 >= r11) goto L_0x0099
            java.lang.Object r14 = r7.get(r13)
            int r13 = r13 + 1
            androidx.constraintlayout.core.motion.key.MotionKey r14 = (androidx.constraintlayout.core.motion.key.MotionKey) r14
            boolean r15 = r14 instanceof androidx.constraintlayout.core.motion.key.MotionKeyPosition
            if (r15 == 0) goto L_0x0070
            r19 = r14
            androidx.constraintlayout.core.motion.key.MotionKeyPosition r19 = (androidx.constraintlayout.core.motion.key.MotionKeyPosition) r19
            androidx.constraintlayout.core.motion.MotionPaths r16 = new androidx.constraintlayout.core.motion.MotionPaths
            androidx.constraintlayout.core.motion.MotionPaths r14 = r0.mStartMotionPath
            androidx.constraintlayout.core.motion.MotionPaths r15 = r0.mEndMotionPath
            r17 = r23
            r18 = r24
            r20 = r14
            r21 = r15
            r16.<init>(r17, r18, r19, r20, r21)
            r15 = r16
            r14 = r19
            r0.insertKey(r15)
            int r14 = r14.mCurveFit
            if (r14 == r8) goto L_0x003f
            r0.mCurveFitType = r14
            goto L_0x003f
        L_0x0070:
            boolean r15 = r14 instanceof androidx.constraintlayout.core.motion.key.MotionKeyCycle
            if (r15 == 0) goto L_0x0078
            r14.getAttributeNames(r5)
            goto L_0x003f
        L_0x0078:
            boolean r15 = r14 instanceof androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle
            if (r15 == 0) goto L_0x0080
            r14.getAttributeNames(r3)
            goto L_0x003f
        L_0x0080:
            boolean r15 = r14 instanceof androidx.constraintlayout.core.motion.key.MotionKeyTrigger
            if (r15 == 0) goto L_0x0091
            if (r12 != 0) goto L_0x008b
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
        L_0x008b:
            androidx.constraintlayout.core.motion.key.MotionKeyTrigger r14 = (androidx.constraintlayout.core.motion.key.MotionKeyTrigger) r14
            r12.add(r14)
            goto L_0x003f
        L_0x0091:
            r14.setInterpolation(r6)
            r14.getAttributeNames(r4)
            goto L_0x003f
        L_0x0098:
            r12 = 0
        L_0x0099:
            if (r12 == 0) goto L_0x00a5
            androidx.constraintlayout.core.motion.key.MotionKeyTrigger[] r7 = new androidx.constraintlayout.core.motion.key.MotionKeyTrigger[r9]
            java.lang.Object[] r7 = r12.toArray(r7)
            androidx.constraintlayout.core.motion.key.MotionKeyTrigger[] r7 = (androidx.constraintlayout.core.motion.key.MotionKeyTrigger[]) r7
            r0.mKeyTriggers = r7
        L_0x00a5:
            boolean r7 = r4.isEmpty()
            java.lang.String r11 = ","
            java.lang.String r12 = "CUSTOM,"
            r13 = 1
            if (r7 != 0) goto L_0x019a
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.mAttributesMap = r7
            java.util.Iterator r7 = r4.iterator()
        L_0x00bb:
            boolean r14 = r7.hasNext()
            if (r14 == 0) goto L_0x012e
            java.lang.Object r14 = r7.next()
            java.lang.String r14 = (java.lang.String) r14
            boolean r15 = r14.startsWith(r12)
            if (r15 == 0) goto L_0x0110
            androidx.constraintlayout.core.motion.utils.KeyFrameArray$CustomVar r15 = new androidx.constraintlayout.core.motion.utils.KeyFrameArray$CustomVar
            r15.<init>()
            java.lang.String[] r16 = r14.split(r11)
            r10 = r16[r13]
            r23 = r13
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r13 = r0.mKeyList
            int r8 = r13.size()
        L_0x00e0:
            if (r9 >= r8) goto L_0x0107
            java.lang.Object r18 = r13.get(r9)
            int r9 = r9 + 1
            r19 = r3
            r3 = r18
            androidx.constraintlayout.core.motion.key.MotionKey r3 = (androidx.constraintlayout.core.motion.key.MotionKey) r3
            r18 = r5
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r5 = r3.mCustom
            if (r5 != 0) goto L_0x00f9
        L_0x00f4:
            r5 = r18
            r3 = r19
            goto L_0x00e0
        L_0x00f9:
            java.lang.Object r5 = r5.get(r10)
            androidx.constraintlayout.core.motion.CustomVariable r5 = (androidx.constraintlayout.core.motion.CustomVariable) r5
            if (r5 == 0) goto L_0x00f4
            int r3 = r3.mFramePosition
            r15.append(r3, r5)
            goto L_0x00f4
        L_0x0107:
            r19 = r3
            r18 = r5
            androidx.constraintlayout.core.motion.utils.SplineSet r3 = androidx.constraintlayout.core.motion.utils.SplineSet.makeCustomSplineSet(r14, r15)
            goto L_0x011a
        L_0x0110:
            r19 = r3
            r18 = r5
            r23 = r13
            androidx.constraintlayout.core.motion.utils.SplineSet r3 = androidx.constraintlayout.core.motion.utils.SplineSet.makeSpline(r14, r1)
        L_0x011a:
            if (r3 != 0) goto L_0x0125
        L_0x011c:
            r13 = r23
            r5 = r18
            r3 = r19
            r8 = -1
            r9 = 0
            goto L_0x00bb
        L_0x0125:
            r3.setType(r14)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r5 = r0.mAttributesMap
            r5.put(r14, r3)
            goto L_0x011c
        L_0x012e:
            r19 = r3
            r18 = r5
            r23 = r13
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r3 = r0.mKeyList
            if (r3 == 0) goto L_0x0151
            int r5 = r3.size()
            r7 = 0
        L_0x013d:
            if (r7 >= r5) goto L_0x0151
            java.lang.Object r8 = r3.get(r7)
            int r7 = r7 + 1
            androidx.constraintlayout.core.motion.key.MotionKey r8 = (androidx.constraintlayout.core.motion.key.MotionKey) r8
            boolean r9 = r8 instanceof androidx.constraintlayout.core.motion.key.MotionKeyAttributes
            if (r9 == 0) goto L_0x013d
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r9 = r0.mAttributesMap
            r8.addValues(r9)
            goto L_0x013d
        L_0x0151:
            androidx.constraintlayout.core.motion.MotionConstrainedPoint r3 = r0.mStartPoint
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r5 = r0.mAttributesMap
            r7 = 0
            r3.addValues(r5, r7)
            androidx.constraintlayout.core.motion.MotionConstrainedPoint r3 = r0.mEndPoint
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r5 = r0.mAttributesMap
            r7 = 100
            r3.addValues(r5, r7)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r3 = r0.mAttributesMap
            java.util.Set r3 = r3.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x016c:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x01a0
            java.lang.Object r5 = r3.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L_0x018b
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L_0x018b
            int r7 = r7.intValue()
            goto L_0x018c
        L_0x018b:
            r7 = 0
        L_0x018c:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r8 = r0.mAttributesMap
            java.lang.Object r5 = r8.get(r5)
            androidx.constraintlayout.core.motion.utils.SplineSet r5 = (androidx.constraintlayout.core.motion.utils.SplineSet) r5
            if (r5 == 0) goto L_0x016c
            r5.setup(r7)
            goto L_0x016c
        L_0x019a:
            r19 = r3
            r18 = r5
            r23 = r13
        L_0x01a0:
            boolean r3 = r19.isEmpty()
            if (r3 != 0) goto L_0x0262
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r3 = r0.mTimeCycleAttributesMap
            if (r3 != 0) goto L_0x01b1
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r0.mTimeCycleAttributesMap = r3
        L_0x01b1:
            java.util.Iterator r3 = r19.iterator()
        L_0x01b5:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x020f
            java.lang.Object r5 = r3.next()
            java.lang.String r5 = (java.lang.String) r5
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r7 = r0.mTimeCycleAttributesMap
            boolean r7 = r7.containsKey(r5)
            if (r7 == 0) goto L_0x01ca
            goto L_0x01b5
        L_0x01ca:
            boolean r7 = r5.startsWith(r12)
            if (r7 == 0) goto L_0x0204
            androidx.constraintlayout.core.motion.utils.KeyFrameArray$CustomVar r7 = new androidx.constraintlayout.core.motion.utils.KeyFrameArray$CustomVar
            r7.<init>()
            java.lang.String[] r8 = r5.split(r11)
            r8 = r8[r23]
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r9 = r0.mKeyList
            int r10 = r9.size()
            r13 = 0
        L_0x01e2:
            if (r13 >= r10) goto L_0x01ff
            java.lang.Object r14 = r9.get(r13)
            int r13 = r13 + 1
            androidx.constraintlayout.core.motion.key.MotionKey r14 = (androidx.constraintlayout.core.motion.key.MotionKey) r14
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r15 = r14.mCustom
            if (r15 != 0) goto L_0x01f1
            goto L_0x01e2
        L_0x01f1:
            java.lang.Object r15 = r15.get(r8)
            androidx.constraintlayout.core.motion.CustomVariable r15 = (androidx.constraintlayout.core.motion.CustomVariable) r15
            if (r15 == 0) goto L_0x01e2
            int r14 = r14.mFramePosition
            r7.append(r14, r15)
            goto L_0x01e2
        L_0x01ff:
            androidx.constraintlayout.core.motion.utils.SplineSet r7 = androidx.constraintlayout.core.motion.utils.SplineSet.makeCustomSplineSet(r5, r7)
            goto L_0x0208
        L_0x0204:
            androidx.constraintlayout.core.motion.utils.SplineSet r7 = androidx.constraintlayout.core.motion.utils.SplineSet.makeSpline(r5, r1)
        L_0x0208:
            if (r7 != 0) goto L_0x020b
            goto L_0x01b5
        L_0x020b:
            r7.setType(r5)
            goto L_0x01b5
        L_0x020f:
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r1 = r0.mKeyList
            if (r1 == 0) goto L_0x022e
            int r2 = r1.size()
            r3 = 0
        L_0x0218:
            if (r3 >= r2) goto L_0x022e
            java.lang.Object r5 = r1.get(r3)
            int r3 = r3 + 1
            androidx.constraintlayout.core.motion.key.MotionKey r5 = (androidx.constraintlayout.core.motion.key.MotionKey) r5
            boolean r7 = r5 instanceof androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle
            if (r7 == 0) goto L_0x0218
            androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle r5 = (androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle) r5
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r7 = r0.mTimeCycleAttributesMap
            r5.addTimeValues(r7)
            goto L_0x0218
        L_0x022e:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r1 = r0.mTimeCycleAttributesMap
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0238:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0262
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = r6.containsKey(r2)
            if (r3 == 0) goto L_0x0255
            java.lang.Object r3 = r6.get(r2)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L_0x0256
        L_0x0255:
            r3 = 0
        L_0x0256:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r5 = r0.mTimeCycleAttributesMap
            java.lang.Object r2 = r5.get(r2)
            androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet r2 = (androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet) r2
            r2.setup(r3)
            goto L_0x0238
        L_0x0262:
            java.util.ArrayList<androidx.constraintlayout.core.motion.MotionPaths> r1 = r0.mMotionPaths
            int r1 = r1.size()
            int r2 = r1 + 2
            androidx.constraintlayout.core.motion.MotionPaths[] r3 = new androidx.constraintlayout.core.motion.MotionPaths[r2]
            androidx.constraintlayout.core.motion.MotionPaths r5 = r0.mStartMotionPath
            r7 = 0
            r3[r7] = r5
            int r1 = r1 + 1
            androidx.constraintlayout.core.motion.MotionPaths r5 = r0.mEndMotionPath
            r3[r1] = r5
            java.util.ArrayList<androidx.constraintlayout.core.motion.MotionPaths> r1 = r0.mMotionPaths
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0287
            int r1 = r0.mCurveFitType
            int r5 = androidx.constraintlayout.core.motion.key.MotionKey.UNSET
            if (r1 != r5) goto L_0x0287
            r0.mCurveFitType = r7
        L_0x0287:
            java.util.ArrayList<androidx.constraintlayout.core.motion.MotionPaths> r1 = r0.mMotionPaths
            int r5 = r1.size()
            r7 = r23
            r6 = 0
        L_0x0290:
            if (r6 >= r5) goto L_0x02a0
            java.lang.Object r8 = r1.get(r6)
            int r6 = r6 + 1
            androidx.constraintlayout.core.motion.MotionPaths r8 = (androidx.constraintlayout.core.motion.MotionPaths) r8
            int r9 = r7 + 1
            r3[r7] = r8
            r7 = r9
            goto L_0x0290
        L_0x02a0:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            androidx.constraintlayout.core.motion.MotionPaths r5 = r0.mEndMotionPath
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r5 = r5.mCustomAttributes
            java.util.Set r5 = r5.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x02b1:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x02e0
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            androidx.constraintlayout.core.motion.MotionPaths r7 = r0.mStartMotionPath
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r7 = r7.mCustomAttributes
            boolean r7 = r7.containsKey(r6)
            if (r7 == 0) goto L_0x02b1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r12)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            boolean r7 = r4.contains(r7)
            if (r7 != 0) goto L_0x02b1
            r1.add(r6)
            goto L_0x02b1
        L_0x02e0:
            r7 = 0
            java.lang.String[] r4 = new java.lang.String[r7]
            java.lang.Object[] r1 = r1.toArray(r4)
            java.lang.String[] r1 = (java.lang.String[]) r1
            r0.mAttributeNames = r1
            int r1 = r1.length
            int[] r1 = new int[r1]
            r0.mAttributeInterpolatorCount = r1
            r1 = 0
        L_0x02f1:
            java.lang.String[] r4 = r0.mAttributeNames
            int r5 = r4.length
            if (r1 >= r5) goto L_0x0329
            r4 = r4[r1]
            int[] r5 = r0.mAttributeInterpolatorCount
            r17 = 0
            r5[r1] = r17
            r5 = 0
        L_0x02ff:
            if (r5 >= r2) goto L_0x0326
            r6 = r3[r5]
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r6 = r6.mCustomAttributes
            boolean r6 = r6.containsKey(r4)
            if (r6 == 0) goto L_0x0323
            r6 = r3[r5]
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r6 = r6.mCustomAttributes
            java.lang.Object r6 = r6.get(r4)
            androidx.constraintlayout.core.motion.CustomVariable r6 = (androidx.constraintlayout.core.motion.CustomVariable) r6
            if (r6 == 0) goto L_0x0323
            int[] r4 = r0.mAttributeInterpolatorCount
            r5 = r4[r1]
            int r6 = r6.numberOfInterpolatedValues()
            int r5 = r5 + r6
            r4[r1] = r5
            goto L_0x0326
        L_0x0323:
            int r5 = r5 + 1
            goto L_0x02ff
        L_0x0326:
            int r1 = r1 + 1
            goto L_0x02f1
        L_0x0329:
            r17 = 0
            r1 = r3[r17]
            int r1 = r1.mPathMotionArc
            r5 = -1
            if (r1 == r5) goto L_0x0335
            r1 = r23
            goto L_0x0336
        L_0x0335:
            r1 = 0
        L_0x0336:
            int r4 = r4.length
            r5 = 18
            int r5 = r5 + r4
            boolean[] r4 = new boolean[r5]
            r6 = r23
        L_0x033e:
            if (r6 >= r2) goto L_0x034e
            r7 = r3[r6]
            int r8 = r6 + -1
            r8 = r3[r8]
            java.lang.String[] r9 = r0.mAttributeNames
            r7.different(r8, r4, r9, r1)
            int r6 = r6 + 1
            goto L_0x033e
        L_0x034e:
            r6 = r23
            r1 = 0
        L_0x0351:
            if (r6 >= r5) goto L_0x035c
            boolean r7 = r4[r6]
            if (r7 == 0) goto L_0x0359
            int r1 = r1 + 1
        L_0x0359:
            int r6 = r6 + 1
            goto L_0x0351
        L_0x035c:
            int[] r6 = new int[r1]
            r0.mInterpolateVariables = r6
            r6 = 2
            int r1 = java.lang.Math.max(r6, r1)
            double[] r7 = new double[r1]
            r0.mInterpolateData = r7
            double[] r1 = new double[r1]
            r0.mInterpolateVelocity = r1
            r7 = r23
            r1 = 0
        L_0x0370:
            if (r7 >= r5) goto L_0x0380
            boolean r8 = r4[r7]
            if (r8 == 0) goto L_0x037d
            int[] r8 = r0.mInterpolateVariables
            int r9 = r1 + 1
            r8[r1] = r7
            r1 = r9
        L_0x037d:
            int r7 = r7 + 1
            goto L_0x0370
        L_0x0380:
            int[] r1 = r0.mInterpolateVariables
            int r1 = r1.length
            int[] r4 = new int[r6]
            r4[r23] = r1
            r17 = 0
            r4[r17] = r2
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r1, r4)
            double[][] r4 = (double[][]) r4
            double[] r5 = new double[r2]
            r7 = 0
        L_0x0396:
            if (r7 >= r2) goto L_0x03ab
            r8 = r3[r7]
            r9 = r4[r7]
            int[] r10 = r0.mInterpolateVariables
            r8.fillStandard(r9, r10)
            r8 = r3[r7]
            float r8 = r8.mTime
            double r8 = (double) r8
            r5[r7] = r8
            int r7 = r7 + 1
            goto L_0x0396
        L_0x03ab:
            r7 = 0
        L_0x03ac:
            int[] r8 = r0.mInterpolateVariables
            int r9 = r8.length
            if (r7 >= r9) goto L_0x03ed
            r8 = r8[r7]
            java.lang.String[] r9 = androidx.constraintlayout.core.motion.MotionPaths.sNames
            int r9 = r9.length
            if (r8 >= r9) goto L_0x03ea
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String[] r9 = androidx.constraintlayout.core.motion.MotionPaths.sNames
            int[] r10 = r0.mInterpolateVariables
            r10 = r10[r7]
            r9 = r9[r10]
            r8.append(r9)
            java.lang.String r9 = " ["
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r9 = 0
        L_0x03d2:
            if (r9 >= r2) goto L_0x03ea
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r8)
            r8 = r4[r9]
            r11 = r8[r7]
            r10.append(r11)
            java.lang.String r8 = r10.toString()
            int r9 = r9 + 1
            goto L_0x03d2
        L_0x03ea:
            int r7 = r7 + 1
            goto L_0x03ac
        L_0x03ed:
            java.lang.String[] r7 = r0.mAttributeNames
            int r7 = r7.length
            int r7 = r7 + 1
            androidx.constraintlayout.core.motion.utils.CurveFit[] r7 = new androidx.constraintlayout.core.motion.utils.CurveFit[r7]
            r0.mSpline = r7
            r7 = 0
        L_0x03f7:
            java.lang.String[] r8 = r0.mAttributeNames
            int r9 = r8.length
            if (r7 >= r9) goto L_0x0459
            r8 = r8[r7]
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x0402:
            if (r9 >= r2) goto L_0x043e
            r13 = r3[r9]
            boolean r13 = r13.hasCustomData(r8)
            if (r13 == 0) goto L_0x0436
            if (r12 != 0) goto L_0x0424
            double[] r11 = new double[r2]
            r12 = r3[r9]
            int r12 = r12.getCustomDataCount(r8)
            int[] r13 = new int[r6]
            r13[r23] = r12
            r14 = 0
            r13[r14] = r2
            java.lang.Object r12 = java.lang.reflect.Array.newInstance(r1, r13)
            double[][] r12 = (double[][]) r12
            goto L_0x0425
        L_0x0424:
            r14 = 0
        L_0x0425:
            r13 = r3[r9]
            float r15 = r13.mTime
            r19 = r7
            double r6 = (double) r15
            r11[r10] = r6
            r6 = r12[r10]
            r13.getCustomData(r8, r6, r14)
            int r10 = r10 + 1
            goto L_0x0438
        L_0x0436:
            r19 = r7
        L_0x0438:
            int r9 = r9 + 1
            r7 = r19
            r6 = 2
            goto L_0x0402
        L_0x043e:
            r19 = r7
            double[] r6 = java.util.Arrays.copyOf(r11, r10)
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r12, r10)
            double[][] r7 = (double[][]) r7
            androidx.constraintlayout.core.motion.utils.CurveFit[] r8 = r0.mSpline
            int r9 = r19 + 1
            int r10 = r0.mCurveFitType
            androidx.constraintlayout.core.motion.utils.CurveFit r6 = androidx.constraintlayout.core.motion.utils.CurveFit.get(r10, r6, r7)
            r8[r9] = r6
            r7 = r9
            r6 = 2
            goto L_0x03f7
        L_0x0459:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r6 = r0.mSpline
            int r7 = r0.mCurveFitType
            androidx.constraintlayout.core.motion.utils.CurveFit r4 = androidx.constraintlayout.core.motion.utils.CurveFit.get(r7, r5, r4)
            r17 = 0
            r6[r17] = r4
            r4 = r3[r17]
            int r4 = r4.mPathMotionArc
            r5 = -1
            if (r4 == r5) goto L_0x04a4
            int[] r4 = new int[r2]
            double[] r5 = new double[r2]
            r6 = 2
            int[] r7 = new int[r6]
            r7[r23] = r6
            r7[r17] = r2
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r7)
            double[][] r1 = (double[][]) r1
            r7 = 0
        L_0x047e:
            if (r7 >= r2) goto L_0x049c
            r6 = r3[r7]
            int r8 = r6.mPathMotionArc
            r4[r7] = r8
            float r8 = r6.mTime
            double r8 = (double) r8
            r5[r7] = r8
            r8 = r1[r7]
            float r9 = r6.mX
            double r9 = (double) r9
            r17 = 0
            r8[r17] = r9
            float r6 = r6.mY
            double r9 = (double) r6
            r8[r23] = r9
            int r7 = r7 + 1
            goto L_0x047e
        L_0x049c:
            r17 = 0
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = androidx.constraintlayout.core.motion.utils.CurveFit.getArc(r4, r5, r1)
            r0.mArcSpline = r1
        L_0x04a4:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.mCycleMap = r1
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r1 = r0.mKeyList
            if (r1 == 0) goto L_0x0519
            java.util.Iterator r1 = r18.iterator()
            r2 = 2143289344(0x7fc00000, float:NaN)
        L_0x04b5:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04e1
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            androidx.constraintlayout.core.motion.utils.KeyCycleOscillator r4 = androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.makeWidgetCycle(r3)
            if (r4 != 0) goto L_0x04c8
            goto L_0x04b5
        L_0x04c8:
            boolean r5 = r4.variesByPath()
            if (r5 == 0) goto L_0x04d8
            boolean r5 = java.lang.Float.isNaN(r2)
            if (r5 == 0) goto L_0x04d8
            float r2 = r0.getPreCycleDistance()
        L_0x04d8:
            r4.setType(r3)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.KeyCycleOscillator> r5 = r0.mCycleMap
            r5.put(r3, r4)
            goto L_0x04b5
        L_0x04e1:
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r1 = r0.mKeyList
            int r3 = r1.size()
            r9 = r17
        L_0x04e9:
            if (r9 >= r3) goto L_0x04ff
            java.lang.Object r4 = r1.get(r9)
            int r9 = r9 + 1
            androidx.constraintlayout.core.motion.key.MotionKey r4 = (androidx.constraintlayout.core.motion.key.MotionKey) r4
            boolean r5 = r4 instanceof androidx.constraintlayout.core.motion.key.MotionKeyCycle
            if (r5 == 0) goto L_0x04e9
            androidx.constraintlayout.core.motion.key.MotionKeyCycle r4 = (androidx.constraintlayout.core.motion.key.MotionKeyCycle) r4
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.KeyCycleOscillator> r5 = r0.mCycleMap
            r4.addCycleValues(r5)
            goto L_0x04e9
        L_0x04ff:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.KeyCycleOscillator> r1 = r0.mCycleMap
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x0509:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0519
            java.lang.Object r3 = r1.next()
            androidx.constraintlayout.core.motion.utils.KeyCycleOscillator r3 = (androidx.constraintlayout.core.motion.utils.KeyCycleOscillator) r3
            r3.setup(r2)
            goto L_0x0509
        L_0x0519:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.Motion.setup(int, int, float, long):void");
    }

    public void setupRelative(Motion motion) {
        this.mRelativeMotion = motion;
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    private void setupRelative() {
        Motion motion = this.mRelativeMotion;
        if (motion != null) {
            this.mStartMotionPath.setupRelative(motion, motion.mStartMotionPath);
            MotionPaths motionPaths = this.mEndMotionPath;
            Motion motion2 = this.mRelativeMotion;
            motionPaths.setupRelative(motion2, motion2.mEndMotionPath);
        }
    }

    public boolean setValue(int i5, int i6) {
        if (i5 == 509) {
            setPathMotionArc(i6);
            return true;
        } else if (i5 != 610) {
            return i5 == 704;
        } else {
            this.mQuantizeMotionSteps = i6;
            return true;
        }
    }

    public boolean setValue(int i5, float f5) {
        if (602 == i5) {
            this.mQuantizeMotionPhase = f5;
            return true;
        } else if (600 != i5) {
            return false;
        } else {
            this.mMotionStagger = f5;
            return true;
        }
    }

    public boolean setValue(int i5, String str) {
        if (705 == i5 || 611 == i5) {
            this.mQuantizeMotionInterpolator = getInterpolator(-1, str, 0);
            return true;
        } else if (605 != i5) {
            return false;
        } else {
            this.mStartMotionPath.mAnimateRelativeTo = str;
            return true;
        }
    }
}
