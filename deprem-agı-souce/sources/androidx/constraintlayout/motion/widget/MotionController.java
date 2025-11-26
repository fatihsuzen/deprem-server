package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MotionController {
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
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType = -1;
    private HashMap<String, ViewOscillator> mCycleMap;
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    boolean mForceMeasure = false;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private KeyTrigger[] mKeyTriggers;
    private int mMaxDimension = 4;
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    float mMotionStagger = Float.NaN;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    Rect mTempRect = new Rect();
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    private float[] mValuesBuff = new float[4];
    private float[] mVelocity = new float[1];
    View mView;

    MotionController(View view) {
        int i5 = Key.UNSET;
        this.mPathMotionArc = i5;
        this.mTransformPivotTarget = i5;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = i5;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(view);
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

    private static Interpolator getInterpolator(Context context, int i5, String str, int i6) {
        if (i5 == -2) {
            return AnimationUtils.loadInterpolator(context, i6);
        }
        if (i5 == -1) {
            final Easing interpolator = Easing.getInterpolator(str);
            return new Interpolator() {
                public float getInterpolation(float f5) {
                    return (float) Easing.this.get((double) f5);
                }
            };
        } else if (i5 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (i5 == 1) {
                return new AccelerateInterpolator();
            }
            if (i5 == 2) {
                return new DecelerateInterpolator();
            }
            if (i5 == 4) {
                return new BounceInterpolator();
            }
            if (i5 != 5) {
                return null;
            }
            return new OvershootInterpolator();
        }
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
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Log.e(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((float) ((int) this.mView.getX()), (float) ((int) this.mView.getY()), (float) this.mView.getWidth(), (float) this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    /* access modifiers changed from: package-private */
    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void buildBounds(float[] fArr, int i5) {
        int i6 = i5;
        float f5 = 1.0f;
        float f6 = 1.0f / ((float) (i6 - 1));
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            SplineSet splineSet = hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            SplineSet splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            ViewOscillator viewOscillator = hashMap3.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            ViewOscillator viewOscillator2 = hashMap4.get("translationY");
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

    /* access modifiers changed from: package-private */
    public int buildKeyFrames(float[] fArr, int[] iArr) {
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
        for (int i8 = 0; i8 < timePoints.length; i8++) {
            this.mSpline[0].getPos(timePoints[i8], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i8], this.mInterpolateVariables, this.mInterpolateData, fArr, i7);
            i7 += 2;
        }
        return i7 / 2;
    }

    /* access modifiers changed from: package-private */
    public void buildPath(float[] fArr, int i5) {
        SplineSet splineSet;
        SplineSet splineSet2;
        ViewOscillator viewOscillator;
        int i6 = i5;
        float f5 = 1.0f;
        float f6 = 1.0f / ((float) (i6 - 1));
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        ViewOscillator viewOscillator2 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 == null) {
            viewOscillator = null;
        } else {
            viewOscillator = hashMap3.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            viewOscillator2 = hashMap4.get("translationY");
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
            if (viewOscillator != null) {
                fArr[i10] = fArr[i10] + viewOscillator.get(f7);
            } else if (splineSet != null) {
                fArr[i10] = fArr[i10] + splineSet.get(f7);
            }
            if (viewOscillator2 != null) {
                int i11 = i10 + 1;
                fArr[i11] = fArr[i11] + viewOscillator2.get(f7);
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

    /* access modifiers changed from: package-private */
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
        float f5;
        if ("button".equals(Debug.getName(this.mView)) && this.mKeyTriggers != null) {
            int i5 = 0;
            while (true) {
                KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                if (i5 < keyTriggerArr.length) {
                    KeyTrigger keyTrigger = keyTriggerArr[i5];
                    if (z4) {
                        f5 = -100.0f;
                    } else {
                        f5 = 100.0f;
                    }
                    keyTrigger.conditionallyFire(f5, this.mView);
                    i5++;
                } else {
                    return;
                }
            }
        }
    }

    public int getAnimateRelativeTo() {
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

    /* access modifiers changed from: package-private */
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

    /* access modifiers changed from: package-private */
    public MotionPaths getKeyFrame(int i5) {
        return this.mMotionPaths.get(i5);
    }

    public int getKeyFrameInfo(int i5, int[] iArr) {
        int i6 = i5;
        float[] fArr = new float[2];
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < size) {
            int i10 = i7 + 1;
            Key key = arrayList.get(i7);
            int i11 = key.mType;
            if (i11 == i6 || i6 != -1) {
                iArr[i9] = 0;
                iArr[i9 + 1] = i11;
                int i12 = key.mFramePosition;
                iArr[i9 + 2] = i12;
                double d5 = (double) (((float) i12) / 100.0f);
                this.mSpline[0].getPos(d5, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i9 + 3] = Float.floatToIntBits(fArr[0]);
                int i13 = i9 + 4;
                iArr[i13] = Float.floatToIntBits(fArr[1]);
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    iArr[i9 + 5] = keyPosition.mPositionType;
                    iArr[i9 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i13 = i9 + 7;
                    iArr[i13] = Float.floatToIntBits(keyPosition.mPercentY);
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
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            int i8 = i6 + 1;
            Key key = arrayList.get(i6);
            int i9 = key.mFramePosition;
            iArr[i5] = (key.mType * 1000) + i9;
            double d5 = (double) (((float) i9) / 100.0f);
            this.mSpline[0].getPos(d5, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, this.mInterpolateData, fArr, i7);
            i7 += 2;
            i6 = i8;
            i5++;
        }
        return i5;
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
    public KeyPositionBase getPositionKeyframe(int i5, int i6, float f5, float f6) {
        float f7;
        float f8;
        int i7;
        int i8;
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f9 = motionPaths.mX;
        rectF.left = f9;
        float f10 = motionPaths.mY;
        rectF.top = f10;
        rectF.right = f9 + motionPaths.mWidth;
        rectF.bottom = f10 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f11 = motionPaths2.mX;
        rectF2.left = f11;
        float f12 = motionPaths2.mY;
        rectF2.top = f12;
        rectF2.right = f11 + motionPaths2.mWidth;
        rectF2.bottom = f12 + motionPaths2.mHeight;
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            int i10 = i9 + 1;
            Key key = arrayList.get(i9);
            if (key instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) key;
                i8 = i5;
                i7 = i6;
                f8 = f5;
                f7 = f6;
                if (keyPositionBase.intersects(i8, i7, rectF, rectF2, f8, f7)) {
                    return keyPositionBase;
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
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        ViewOscillator viewOscillator3;
        ViewOscillator viewOscillator4;
        float adjustedPosition = getAdjustedPosition(f5, this.mVelocity);
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        ViewOscillator viewOscillator5 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, ViewSpline> hashMap3 = this.mAttributesMap;
        if (hashMap3 == null) {
            splineSet3 = null;
        } else {
            splineSet3 = hashMap3.get(Key.ROTATION);
        }
        HashMap<String, ViewSpline> hashMap4 = this.mAttributesMap;
        if (hashMap4 == null) {
            splineSet4 = null;
        } else {
            splineSet4 = hashMap4.get("scaleX");
        }
        HashMap<String, ViewSpline> hashMap5 = this.mAttributesMap;
        if (hashMap5 == null) {
            splineSet5 = null;
        } else {
            splineSet5 = hashMap5.get("scaleY");
        }
        HashMap<String, ViewOscillator> hashMap6 = this.mCycleMap;
        if (hashMap6 == null) {
            viewOscillator = null;
        } else {
            viewOscillator = hashMap6.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap7 = this.mCycleMap;
        if (hashMap7 == null) {
            viewOscillator2 = null;
        } else {
            viewOscillator2 = hashMap7.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap8 = this.mCycleMap;
        if (hashMap8 == null) {
            viewOscillator3 = null;
        } else {
            viewOscillator3 = hashMap8.get(Key.ROTATION);
        }
        HashMap<String, ViewOscillator> hashMap9 = this.mCycleMap;
        if (hashMap9 == null) {
            viewOscillator4 = null;
        } else {
            viewOscillator4 = hashMap9.get("scaleX");
        }
        HashMap<String, ViewOscillator> hashMap10 = this.mCycleMap;
        if (hashMap10 != null) {
            viewOscillator5 = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity((KeyCycleOscillator) viewOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity((KeyCycleOscillator) viewOscillator, (KeyCycleOscillator) viewOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity((KeyCycleOscillator) viewOscillator4, (KeyCycleOscillator) viewOscillator5, adjustedPosition);
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
            velocityMatrix.setRotationVelocity((KeyCycleOscillator) viewOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity((KeyCycleOscillator) viewOscillator, (KeyCycleOscillator) viewOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity((KeyCycleOscillator) viewOscillator4, (KeyCycleOscillator) viewOscillator5, adjustedPosition);
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

    public View getView() {
        return this.mView;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v55, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean interpolate(android.view.View r21, float r22, long r23, androidx.constraintlayout.core.motion.utils.KeyCache r25) {
        /*
            r20 = this;
            r0 = r20
            r2 = r21
            r1 = 0
            r3 = r22
            float r3 = r0.getAdjustedPosition(r3, r1)
            int r4 = r0.mQuantizeMotionSteps
            int r5 = androidx.constraintlayout.motion.widget.Key.UNSET
            r12 = 1065353216(0x3f800000, float:1.0)
            if (r4 == r5) goto L_0x0042
            float r4 = (float) r4
            float r4 = r12 / r4
            float r5 = r3 / r4
            double r5 = (double) r5
            double r5 = java.lang.Math.floor(r5)
            float r5 = (float) r5
            float r5 = r5 * r4
            float r3 = r3 % r4
            float r3 = r3 / r4
            float r6 = r0.mQuantizeMotionPhase
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x002d
            float r6 = r0.mQuantizeMotionPhase
            float r3 = r3 + r6
            float r3 = r3 % r12
        L_0x002d:
            android.view.animation.Interpolator r6 = r0.mQuantizeMotionInterpolator
            if (r6 == 0) goto L_0x0036
            float r3 = r6.getInterpolation(r3)
            goto L_0x0040
        L_0x0036:
            double r6 = (double) r3
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x003f
            r3 = r12
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            float r3 = r3 * r4
            float r3 = r3 + r5
        L_0x0042:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r4 = r0.mAttributesMap
            if (r4 == 0) goto L_0x005e
            java.util.Collection r4 = r4.values()
            java.util.Iterator r4 = r4.iterator()
        L_0x004e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x005e
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.motion.utils.ViewSpline r5 = (androidx.constraintlayout.motion.utils.ViewSpline) r5
            r5.setProperty(r2, r3)
            goto L_0x004e
        L_0x005e:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r4 = r0.mTimeCycleAttributesMap
            r13 = 0
            if (r4 == 0) goto L_0x0090
            java.util.Collection r4 = r4.values()
            java.util.Iterator r7 = r4.iterator()
            r8 = r1
            r9 = r13
        L_0x006d:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x008d
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.utils.ViewTimeCycle r1 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r1
            boolean r4 = r1 instanceof androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate
            if (r4 == 0) goto L_0x0081
            r8 = r1
            androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate r8 = (androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate) r8
            goto L_0x006d
        L_0x0081:
            r4 = r23
            r6 = r25
            boolean r1 = r1.setProperty(r2, r3, r4, r6)
            r9 = r9 | r1
            r2 = r21
            goto L_0x006d
        L_0x008d:
            r14 = r9
            r9 = r8
            goto L_0x0092
        L_0x0090:
            r9 = r1
            r14 = r13
        L_0x0092:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.mSpline
            r15 = 1
            if (r1 == 0) goto L_0x01f4
            r1 = r1[r13]
            double r4 = (double) r3
            double[] r2 = r0.mInterpolateData
            r1.getPos((double) r4, (double[]) r2)
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.mSpline
            r1 = r1[r13]
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r4, (double[]) r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.mArcSpline
            if (r1 == 0) goto L_0x00bb
            double[] r2 = r0.mInterpolateData
            int r6 = r2.length
            if (r6 <= 0) goto L_0x00bb
            r1.getPos((double) r4, (double[]) r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.mArcSpline
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r4, (double[]) r2)
        L_0x00bb:
            boolean r1 = r0.mNoMovement
            if (r1 != 0) goto L_0x00e3
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            r5 = r4
            int[] r4 = r0.mInterpolateVariables
            r6 = r5
            double[] r5 = r0.mInterpolateData
            r7 = r6
            double[] r6 = r0.mInterpolateVelocity
            r16 = r7
            r7 = 0
            boolean r8 = r0.mForceMeasure
            r2 = r3
            r18 = r12
            r11 = r16
            r22 = 0
            r3 = r21
            r1.setView(r2, r3, r4, r5, r6, r7, r8)
            r19 = r3
            r3 = r2
            r2 = r19
            r0.mForceMeasure = r13
            goto L_0x00ea
        L_0x00e3:
            r2 = r21
            r18 = r12
            r22 = 0
            r11 = r4
        L_0x00ea:
            int r1 = r0.mTransformPivotTarget
            int r4 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r1 == r4) goto L_0x014c
            android.view.View r1 = r0.mTransformPivotView
            if (r1 != 0) goto L_0x0102
            android.view.ViewParent r1 = r2.getParent()
            android.view.View r1 = (android.view.View) r1
            int r4 = r0.mTransformPivotTarget
            android.view.View r1 = r1.findViewById(r4)
            r0.mTransformPivotView = r1
        L_0x0102:
            android.view.View r1 = r0.mTransformPivotView
            if (r1 == 0) goto L_0x014c
            int r1 = r1.getTop()
            android.view.View r4 = r0.mTransformPivotView
            int r4 = r4.getBottom()
            int r1 = r1 + r4
            float r1 = (float) r1
            r4 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r4
            android.view.View r5 = r0.mTransformPivotView
            int r5 = r5.getLeft()
            android.view.View r6 = r0.mTransformPivotView
            int r6 = r6.getRight()
            int r5 = r5 + r6
            float r5 = (float) r5
            float r5 = r5 / r4
            int r4 = r2.getRight()
            int r6 = r2.getLeft()
            int r4 = r4 - r6
            if (r4 <= 0) goto L_0x014c
            int r4 = r2.getBottom()
            int r6 = r2.getTop()
            int r4 = r4 - r6
            if (r4 <= 0) goto L_0x014c
            int r4 = r2.getLeft()
            float r4 = (float) r4
            float r5 = r5 - r4
            int r4 = r2.getTop()
            float r4 = (float) r4
            float r1 = r1 - r4
            r2.setPivotX(r5)
            r2.setPivotY(r1)
        L_0x014c:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r1 = r0.mAttributesMap
            if (r1 == 0) goto L_0x017c
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x0158:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x017c
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.core.motion.utils.SplineSet r1 = (androidx.constraintlayout.core.motion.utils.SplineSet) r1
            boolean r4 = r1 instanceof androidx.constraintlayout.motion.utils.ViewSpline.PathRotate
            if (r4 == 0) goto L_0x0179
            double[] r4 = r0.mInterpolateVelocity
            int r5 = r4.length
            if (r5 <= r15) goto L_0x0179
            androidx.constraintlayout.motion.utils.ViewSpline$PathRotate r1 = (androidx.constraintlayout.motion.utils.ViewSpline.PathRotate) r1
            r5 = r4[r13]
            r16 = r4[r15]
            r4 = r5
            r6 = r16
            r1.setPathRotate(r2, r3, r4, r6)
        L_0x0179:
            r2 = r21
            goto L_0x0158
        L_0x017c:
            if (r9 == 0) goto L_0x0194
            double[] r1 = r0.mInterpolateVelocity
            r7 = r1[r13]
            r4 = r1[r15]
            r2 = r21
            r1 = r9
            r9 = r4
            r5 = r23
            r4 = r3
            r3 = r25
            boolean r1 = r1.setPathRotate(r2, r3, r4, r5, r7, r9)
            r3 = r4
            r14 = r14 | r1
            goto L_0x0196
        L_0x0194:
            r2 = r21
        L_0x0196:
            r1 = r15
        L_0x0197:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r4 = r0.mSpline
            int r5 = r4.length
            if (r1 >= r5) goto L_0x01bb
            r4 = r4[r1]
            float[] r5 = r0.mValuesBuff
            r4.getPos((double) r11, (float[]) r5)
            androidx.constraintlayout.motion.widget.MotionPaths r4 = r0.mStartMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r4 = r4.mAttributes
            java.lang.String[] r5 = r0.mAttributeNames
            int r6 = r1 + -1
            r5 = r5[r6]
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.widget.ConstraintAttribute r4 = (androidx.constraintlayout.widget.ConstraintAttribute) r4
            float[] r5 = r0.mValuesBuff
            androidx.constraintlayout.motion.utils.CustomSupport.setInterpolatedValue(r4, r2, r5)
            int r1 = r1 + 1
            goto L_0x0197
        L_0x01bb:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mStartPoint
            int r4 = r1.mVisibilityMode
            if (r4 != 0) goto L_0x01e2
            int r4 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r4 > 0) goto L_0x01cb
            int r1 = r1.mVisibility
            r2.setVisibility(r1)
            goto L_0x01e2
        L_0x01cb:
            int r4 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r4 < 0) goto L_0x01d7
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mEndPoint
            int r1 = r1.mVisibility
            r2.setVisibility(r1)
            goto L_0x01e2
        L_0x01d7:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r4 = r0.mEndPoint
            int r4 = r4.mVisibility
            int r1 = r1.mVisibility
            if (r4 == r1) goto L_0x01e2
            r2.setVisibility(r13)
        L_0x01e2:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r1 = r0.mKeyTriggers
            if (r1 == 0) goto L_0x0244
            r1 = r13
        L_0x01e7:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r4 = r0.mKeyTriggers
            int r5 = r4.length
            if (r1 >= r5) goto L_0x0244
            r4 = r4[r1]
            r4.conditionallyFire(r3, r2)
            int r1 = r1 + 1
            goto L_0x01e7
        L_0x01f4:
            r2 = r21
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            float r4 = r1.mX
            androidx.constraintlayout.motion.widget.MotionPaths r5 = r0.mEndMotionPath
            float r6 = r5.mX
            float r6 = r6 - r4
            float r6 = r6 * r3
            float r4 = r4 + r6
            float r6 = r1.mY
            float r7 = r5.mY
            float r7 = r7 - r6
            float r7 = r7 * r3
            float r6 = r6 + r7
            float r7 = r1.mWidth
            float r8 = r5.mWidth
            float r9 = r8 - r7
            float r9 = r9 * r3
            float r9 = r9 + r7
            float r1 = r1.mHeight
            float r5 = r5.mHeight
            float r10 = r5 - r1
            float r10 = r10 * r3
            float r10 = r10 + r1
            r11 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r11
            int r12 = (int) r4
            float r6 = r6 + r11
            int r11 = (int) r6
            float r4 = r4 + r9
            int r4 = (int) r4
            float r6 = r6 + r10
            int r6 = (int) r6
            int r9 = r4 - r12
            int r10 = r6 - r11
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x0232
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0232
            boolean r1 = r0.mForceMeasure
            if (r1 == 0) goto L_0x0241
        L_0x0232:
            r1 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r1)
            r2.measure(r5, r1)
            r0.mForceMeasure = r13
        L_0x0241:
            r2.layout(r12, r11, r4, r6)
        L_0x0244:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r1 = r0.mCycleMap
            if (r1 == 0) goto L_0x0272
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x0250:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0272
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r1 = (androidx.constraintlayout.motion.utils.ViewOscillator) r1
            boolean r4 = r1 instanceof androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet
            if (r4 == 0) goto L_0x026e
            androidx.constraintlayout.motion.utils.ViewOscillator$PathRotateSet r1 = (androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet) r1
            double[] r4 = r0.mInterpolateVelocity
            r5 = r4[r13]
            r9 = r4[r15]
            r4 = r5
            r6 = r9
            r1.setPathRotate(r2, r3, r4, r6)
            goto L_0x0250
        L_0x026e:
            r1.setProperty(r2, r3)
            goto L_0x0250
        L_0x0272:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.interpolate(android.view.View, float, long, androidx.constraintlayout.core.motion.utils.KeyCache):boolean");
    }

    /* access modifiers changed from: package-private */
    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    /* access modifiers changed from: package-private */
    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f5, float f6, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f7 = motionPaths.mX;
        rectF.left = f7;
        float f8 = motionPaths.mY;
        rectF.top = f8;
        rectF.right = f7 + motionPaths.mWidth;
        rectF.bottom = f8 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f9 = motionPaths2.mX;
        rectF2.left = f9;
        float f10 = motionPaths2.mY;
        rectF2.top = f10;
        rectF2.right = f9 + motionPaths2.mWidth;
        rectF2.bottom = f10 + motionPaths2.mHeight;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f5, f6, strArr, fArr);
    }

    public void remeasure() {
        this.mForceMeasure = true;
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
    public void setBothStates(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mEndMotionPath.setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void setDrawPath(int i5) {
        this.mStartMotionPath.mDrawPath = i5;
    }

    /* access modifiers changed from: package-private */
    public void setEndState(Rect rect, ConstraintSet constraintSet, int i5, int i6) {
        MotionController motionController;
        int i7 = constraintSet.mRotate;
        if (i7 != 0) {
            motionController = this;
            motionController.rotate(rect, this.mTempRect, i7, i5, i6);
            rect = motionController.mTempRect;
        } else {
            motionController = this;
            Rect rect2 = rect;
        }
        MotionPaths motionPaths = motionController.mEndMotionPath;
        motionPaths.mTime = 1.0f;
        motionPaths.mPosition = 1.0f;
        readView(motionPaths);
        motionController.mEndMotionPath.setBounds((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        motionController.mEndMotionPath.applyParameters(constraintSet.getParameters(motionController.mId));
        motionController.mEndPoint.setState(rect, constraintSet, i7, motionController.mId);
    }

    public void setPathMotionArc(int i5) {
        this.mPathMotionArc = i5;
    }

    /* access modifiers changed from: package-private */
    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(ViewState viewState, View view, int i5, int i6, int i7) {
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
        this.mStartPoint.setState(rect, view, i5, viewState.rotation);
    }

    public void setTransformPivotTarget(int i5) {
        this.mTransformPivotTarget = i5;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setup(int r20, int r21, float r22, long r23) {
        /*
            r19 = this;
            r0 = r19
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r5 = r0.mPathMotionArc
            int r6 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r5 == r6) goto L_0x0025
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.mStartMotionPath
            r6.mPathMotionArc = r5
        L_0x0025:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r5 = r0.mStartPoint
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.mEndPoint
            r5.different(r6, r2)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r5 = r0.mKeyList
            r6 = 0
            if (r5 == 0) goto L_0x0090
            int r8 = r5.size()
            r10 = r6
            r9 = 0
        L_0x0037:
            if (r10 >= r8) goto L_0x0091
            java.lang.Object r11 = r5.get(r10)
            int r10 = r10 + 1
            androidx.constraintlayout.motion.widget.Key r11 = (androidx.constraintlayout.motion.widget.Key) r11
            boolean r12 = r11 instanceof androidx.constraintlayout.motion.widget.KeyPosition
            if (r12 == 0) goto L_0x0068
            r16 = r11
            androidx.constraintlayout.motion.widget.KeyPosition r16 = (androidx.constraintlayout.motion.widget.KeyPosition) r16
            androidx.constraintlayout.motion.widget.MotionPaths r13 = new androidx.constraintlayout.motion.widget.MotionPaths
            androidx.constraintlayout.motion.widget.MotionPaths r11 = r0.mStartMotionPath
            androidx.constraintlayout.motion.widget.MotionPaths r12 = r0.mEndMotionPath
            r14 = r20
            r15 = r21
            r17 = r11
            r18 = r12
            r13.<init>(r14, r15, r16, r17, r18)
            r11 = r16
            r0.insertKey(r13)
            int r11 = r11.mCurveFit
            int r12 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r11 == r12) goto L_0x0037
            r0.mCurveFitType = r11
            goto L_0x0037
        L_0x0068:
            boolean r12 = r11 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r12 == 0) goto L_0x0070
            r11.getAttributeNames(r3)
            goto L_0x0037
        L_0x0070:
            boolean r12 = r11 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r12 == 0) goto L_0x0078
            r11.getAttributeNames(r1)
            goto L_0x0037
        L_0x0078:
            boolean r12 = r11 instanceof androidx.constraintlayout.motion.widget.KeyTrigger
            if (r12 == 0) goto L_0x0089
            if (r9 != 0) goto L_0x0083
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x0083:
            androidx.constraintlayout.motion.widget.KeyTrigger r11 = (androidx.constraintlayout.motion.widget.KeyTrigger) r11
            r9.add(r11)
            goto L_0x0037
        L_0x0089:
            r11.setInterpolation(r4)
            r11.getAttributeNames(r2)
            goto L_0x0037
        L_0x0090:
            r9 = 0
        L_0x0091:
            if (r9 == 0) goto L_0x009d
            androidx.constraintlayout.motion.widget.KeyTrigger[] r5 = new androidx.constraintlayout.motion.widget.KeyTrigger[r6]
            java.lang.Object[] r5 = r9.toArray(r5)
            androidx.constraintlayout.motion.widget.KeyTrigger[] r5 = (androidx.constraintlayout.motion.widget.KeyTrigger[]) r5
            r0.mKeyTriggers = r5
        L_0x009d:
            boolean r5 = r2.isEmpty()
            java.lang.String r8 = ","
            java.lang.String r9 = "CUSTOM,"
            r10 = 1
            if (r5 != 0) goto L_0x017f
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r0.mAttributesMap = r5
            java.util.Iterator r5 = r2.iterator()
        L_0x00b3:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x0117
            java.lang.Object r11 = r5.next()
            java.lang.String r11 = (java.lang.String) r11
            boolean r12 = r11.startsWith(r9)
            if (r12 == 0) goto L_0x0102
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.lang.String[] r13 = r11.split(r8)
            r13 = r13[r10]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r14 = r0.mKeyList
            int r15 = r14.size()
            r7 = r6
        L_0x00d7:
            if (r7 >= r15) goto L_0x00fb
            java.lang.Object r16 = r14.get(r7)
            int r7 = r7 + 1
            r20 = r10
            r10 = r16
            androidx.constraintlayout.motion.widget.Key r10 = (androidx.constraintlayout.motion.widget.Key) r10
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r6 = r10.mCustomConstraints
            if (r6 != 0) goto L_0x00ed
        L_0x00e9:
            r10 = r20
            r6 = 0
            goto L_0x00d7
        L_0x00ed:
            java.lang.Object r6 = r6.get(r13)
            androidx.constraintlayout.widget.ConstraintAttribute r6 = (androidx.constraintlayout.widget.ConstraintAttribute) r6
            if (r6 == 0) goto L_0x00e9
            int r10 = r10.mFramePosition
            r12.append(r10, r6)
            goto L_0x00e9
        L_0x00fb:
            r20 = r10
            androidx.constraintlayout.motion.utils.ViewSpline r6 = androidx.constraintlayout.motion.utils.ViewSpline.makeCustomSpline(r11, r12)
            goto L_0x0108
        L_0x0102:
            r20 = r10
            androidx.constraintlayout.motion.utils.ViewSpline r6 = androidx.constraintlayout.motion.utils.ViewSpline.makeSpline(r11)
        L_0x0108:
            if (r6 != 0) goto L_0x010e
        L_0x010a:
            r10 = r20
            r6 = 0
            goto L_0x00b3
        L_0x010e:
            r6.setType(r11)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r7 = r0.mAttributesMap
            r7.put(r11, r6)
            goto L_0x010a
        L_0x0117:
            r20 = r10
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r5 = r0.mKeyList
            if (r5 == 0) goto L_0x0136
            int r6 = r5.size()
            r7 = 0
        L_0x0122:
            if (r7 >= r6) goto L_0x0136
            java.lang.Object r10 = r5.get(r7)
            int r7 = r7 + 1
            androidx.constraintlayout.motion.widget.Key r10 = (androidx.constraintlayout.motion.widget.Key) r10
            boolean r11 = r10 instanceof androidx.constraintlayout.motion.widget.KeyAttributes
            if (r11 == 0) goto L_0x0122
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r11 = r0.mAttributesMap
            r10.addValues(r11)
            goto L_0x0122
        L_0x0136:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r5 = r0.mStartPoint
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r6 = r0.mAttributesMap
            r7 = 0
            r5.addValues(r6, r7)
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r5 = r0.mEndPoint
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r6 = r0.mAttributesMap
            r7 = 100
            r5.addValues(r6, r7)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r5 = r0.mAttributesMap
            java.util.Set r5 = r5.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0151:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0181
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = r4.containsKey(r6)
            if (r7 == 0) goto L_0x0170
            java.lang.Object r7 = r4.get(r6)
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L_0x0170
            int r7 = r7.intValue()
            goto L_0x0171
        L_0x0170:
            r7 = 0
        L_0x0171:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r10 = r0.mAttributesMap
            java.lang.Object r6 = r10.get(r6)
            androidx.constraintlayout.core.motion.utils.SplineSet r6 = (androidx.constraintlayout.core.motion.utils.SplineSet) r6
            if (r6 == 0) goto L_0x0151
            r6.setup(r7)
            goto L_0x0151
        L_0x017f:
            r20 = r10
        L_0x0181:
            boolean r5 = r1.isEmpty()
            if (r5 != 0) goto L_0x024d
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r5 = r0.mTimeCycleAttributesMap
            if (r5 != 0) goto L_0x0192
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r0.mTimeCycleAttributesMap = r5
        L_0x0192:
            java.util.Iterator r1 = r1.iterator()
        L_0x0196:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x01fa
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r6 = r0.mTimeCycleAttributesMap
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x01ab
            goto L_0x0196
        L_0x01ab:
            boolean r6 = r5.startsWith(r9)
            if (r6 == 0) goto L_0x01e8
            android.util.SparseArray r6 = new android.util.SparseArray
            r6.<init>()
            java.lang.String[] r7 = r5.split(r8)
            r7 = r7[r20]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r10 = r0.mKeyList
            int r11 = r10.size()
            r12 = 0
        L_0x01c3:
            if (r12 >= r11) goto L_0x01e0
            java.lang.Object r13 = r10.get(r12)
            int r12 = r12 + 1
            androidx.constraintlayout.motion.widget.Key r13 = (androidx.constraintlayout.motion.widget.Key) r13
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r14 = r13.mCustomConstraints
            if (r14 != 0) goto L_0x01d2
            goto L_0x01c3
        L_0x01d2:
            java.lang.Object r14 = r14.get(r7)
            androidx.constraintlayout.widget.ConstraintAttribute r14 = (androidx.constraintlayout.widget.ConstraintAttribute) r14
            if (r14 == 0) goto L_0x01c3
            int r13 = r13.mFramePosition
            r6.append(r13, r14)
            goto L_0x01c3
        L_0x01e0:
            androidx.constraintlayout.motion.utils.ViewTimeCycle r6 = androidx.constraintlayout.motion.utils.ViewTimeCycle.makeCustomSpline(r5, r6)
            r10 = r6
            r6 = r23
            goto L_0x01ee
        L_0x01e8:
            r6 = r23
            androidx.constraintlayout.motion.utils.ViewTimeCycle r10 = androidx.constraintlayout.motion.utils.ViewTimeCycle.makeSpline(r5, r6)
        L_0x01ee:
            if (r10 != 0) goto L_0x01f1
            goto L_0x0196
        L_0x01f1:
            r10.setType(r5)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r11 = r0.mTimeCycleAttributesMap
            r11.put(r5, r10)
            goto L_0x0196
        L_0x01fa:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r0.mKeyList
            if (r1 == 0) goto L_0x0219
            int r5 = r1.size()
            r6 = 0
        L_0x0203:
            if (r6 >= r5) goto L_0x0219
            java.lang.Object r7 = r1.get(r6)
            int r6 = r6 + 1
            androidx.constraintlayout.motion.widget.Key r7 = (androidx.constraintlayout.motion.widget.Key) r7
            boolean r8 = r7 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r8 == 0) goto L_0x0203
            androidx.constraintlayout.motion.widget.KeyTimeCycle r7 = (androidx.constraintlayout.motion.widget.KeyTimeCycle) r7
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r8 = r0.mTimeCycleAttributesMap
            r7.addTimeValues(r8)
            goto L_0x0203
        L_0x0219:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r1 = r0.mTimeCycleAttributesMap
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0223:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x024d
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = r4.containsKey(r5)
            if (r6 == 0) goto L_0x0240
            java.lang.Object r6 = r4.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            goto L_0x0241
        L_0x0240:
            r6 = 0
        L_0x0241:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r7 = r0.mTimeCycleAttributesMap
            java.lang.Object r5 = r7.get(r5)
            androidx.constraintlayout.motion.utils.ViewTimeCycle r5 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r5
            r5.setup(r6)
            goto L_0x0223
        L_0x024d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r1 = r0.mMotionPaths
            int r1 = r1.size()
            int r4 = r1 + 2
            androidx.constraintlayout.motion.widget.MotionPaths[] r5 = new androidx.constraintlayout.motion.widget.MotionPaths[r4]
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.mStartMotionPath
            r7 = 0
            r5[r7] = r6
            int r1 = r1 + 1
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.mEndMotionPath
            r5[r1] = r6
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r1 = r0.mMotionPaths
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0271
            int r1 = r0.mCurveFitType
            r6 = -1
            if (r1 != r6) goto L_0x0271
            r0.mCurveFitType = r7
        L_0x0271:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r1 = r0.mMotionPaths
            int r6 = r1.size()
            r8 = r20
            r7 = 0
        L_0x027a:
            if (r7 >= r6) goto L_0x028a
            java.lang.Object r10 = r1.get(r7)
            int r7 = r7 + 1
            androidx.constraintlayout.motion.widget.MotionPaths r10 = (androidx.constraintlayout.motion.widget.MotionPaths) r10
            int r11 = r8 + 1
            r5[r8] = r10
            r8 = r11
            goto L_0x027a
        L_0x028a:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.mEndMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r6 = r6.mAttributes
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x029b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x02ca
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            androidx.constraintlayout.motion.widget.MotionPaths r8 = r0.mStartMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r8 = r8.mAttributes
            boolean r8 = r8.containsKey(r7)
            if (r8 == 0) goto L_0x029b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            boolean r8 = r2.contains(r8)
            if (r8 != 0) goto L_0x029b
            r1.add(r7)
            goto L_0x029b
        L_0x02ca:
            r7 = 0
            java.lang.String[] r2 = new java.lang.String[r7]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            r0.mAttributeNames = r1
            int r1 = r1.length
            int[] r1 = new int[r1]
            r0.mAttributeInterpolatorCount = r1
            r1 = 0
        L_0x02db:
            java.lang.String[] r2 = r0.mAttributeNames
            int r6 = r2.length
            if (r1 >= r6) goto L_0x0313
            r2 = r2[r1]
            int[] r6 = r0.mAttributeInterpolatorCount
            r16 = 0
            r6[r1] = r16
            r6 = 0
        L_0x02e9:
            if (r6 >= r4) goto L_0x0310
            r7 = r5[r6]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r7 = r7.mAttributes
            boolean r7 = r7.containsKey(r2)
            if (r7 == 0) goto L_0x030d
            r7 = r5[r6]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r7 = r7.mAttributes
            java.lang.Object r7 = r7.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r7 = (androidx.constraintlayout.widget.ConstraintAttribute) r7
            if (r7 == 0) goto L_0x030d
            int[] r2 = r0.mAttributeInterpolatorCount
            r6 = r2[r1]
            int r7 = r7.numberOfInterpolatedValues()
            int r6 = r6 + r7
            r2[r1] = r6
            goto L_0x0310
        L_0x030d:
            int r6 = r6 + 1
            goto L_0x02e9
        L_0x0310:
            int r1 = r1 + 1
            goto L_0x02db
        L_0x0313:
            r16 = 0
            r1 = r5[r16]
            int r1 = r1.mPathMotionArc
            int r6 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r1 == r6) goto L_0x0320
            r1 = r20
            goto L_0x0321
        L_0x0320:
            r1 = 0
        L_0x0321:
            int r2 = r2.length
            r6 = 18
            int r6 = r6 + r2
            boolean[] r2 = new boolean[r6]
            r7 = r20
        L_0x0329:
            if (r7 >= r4) goto L_0x0339
            r8 = r5[r7]
            int r9 = r7 + -1
            r9 = r5[r9]
            java.lang.String[] r10 = r0.mAttributeNames
            r8.different(r9, r2, r10, r1)
            int r7 = r7 + 1
            goto L_0x0329
        L_0x0339:
            r7 = r20
            r1 = 0
        L_0x033c:
            if (r7 >= r6) goto L_0x0347
            boolean r8 = r2[r7]
            if (r8 == 0) goto L_0x0344
            int r1 = r1 + 1
        L_0x0344:
            int r7 = r7 + 1
            goto L_0x033c
        L_0x0347:
            int[] r7 = new int[r1]
            r0.mInterpolateVariables = r7
            r7 = 2
            int r1 = java.lang.Math.max(r7, r1)
            double[] r8 = new double[r1]
            r0.mInterpolateData = r8
            double[] r1 = new double[r1]
            r0.mInterpolateVelocity = r1
            r8 = r20
            r1 = 0
        L_0x035b:
            if (r8 >= r6) goto L_0x036b
            boolean r9 = r2[r8]
            if (r9 == 0) goto L_0x0368
            int[] r9 = r0.mInterpolateVariables
            int r10 = r1 + 1
            r9[r1] = r8
            r1 = r10
        L_0x0368:
            int r8 = r8 + 1
            goto L_0x035b
        L_0x036b:
            int[] r1 = r0.mInterpolateVariables
            int r1 = r1.length
            int[] r2 = new int[r7]
            r2[r20] = r1
            r16 = 0
            r2[r16] = r4
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r1, r2)
            double[][] r2 = (double[][]) r2
            double[] r6 = new double[r4]
            r8 = 0
        L_0x0381:
            if (r8 >= r4) goto L_0x0396
            r9 = r5[r8]
            r10 = r2[r8]
            int[] r11 = r0.mInterpolateVariables
            r9.fillStandard(r10, r11)
            r9 = r5[r8]
            float r9 = r9.mTime
            double r9 = (double) r9
            r6[r8] = r9
            int r8 = r8 + 1
            goto L_0x0381
        L_0x0396:
            r8 = 0
        L_0x0397:
            int[] r9 = r0.mInterpolateVariables
            int r10 = r9.length
            if (r8 >= r10) goto L_0x03d8
            r9 = r9[r8]
            java.lang.String[] r10 = androidx.constraintlayout.motion.widget.MotionPaths.sNames
            int r10 = r10.length
            if (r9 >= r10) goto L_0x03d5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String[] r10 = androidx.constraintlayout.motion.widget.MotionPaths.sNames
            int[] r11 = r0.mInterpolateVariables
            r11 = r11[r8]
            r10 = r10[r11]
            r9.append(r10)
            java.lang.String r10 = " ["
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r10 = 0
        L_0x03bd:
            if (r10 >= r4) goto L_0x03d5
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            r9 = r2[r10]
            r12 = r9[r8]
            r11.append(r12)
            java.lang.String r9 = r11.toString()
            int r10 = r10 + 1
            goto L_0x03bd
        L_0x03d5:
            int r8 = r8 + 1
            goto L_0x0397
        L_0x03d8:
            java.lang.String[] r8 = r0.mAttributeNames
            int r8 = r8.length
            int r8 = r8 + 1
            androidx.constraintlayout.core.motion.utils.CurveFit[] r8 = new androidx.constraintlayout.core.motion.utils.CurveFit[r8]
            r0.mSpline = r8
            r8 = 0
        L_0x03e2:
            java.lang.String[] r9 = r0.mAttributeNames
            int r10 = r9.length
            if (r8 >= r10) goto L_0x0444
            r9 = r9[r8]
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x03ed:
            if (r10 >= r4) goto L_0x0429
            r14 = r5[r10]
            boolean r14 = r14.hasCustomData(r9)
            if (r14 == 0) goto L_0x0421
            if (r13 != 0) goto L_0x040f
            double[] r12 = new double[r4]
            r13 = r5[r10]
            int r13 = r13.getCustomDataCount(r9)
            int[] r14 = new int[r7]
            r14[r20] = r13
            r15 = 0
            r14[r15] = r4
            java.lang.Object r13 = java.lang.reflect.Array.newInstance(r1, r14)
            double[][] r13 = (double[][]) r13
            goto L_0x0410
        L_0x040f:
            r15 = 0
        L_0x0410:
            r14 = r5[r10]
            float r7 = r14.mTime
            r17 = r8
            double r7 = (double) r7
            r12[r11] = r7
            r7 = r13[r11]
            r14.getCustomData(r9, r7, r15)
            int r11 = r11 + 1
            goto L_0x0423
        L_0x0421:
            r17 = r8
        L_0x0423:
            int r10 = r10 + 1
            r8 = r17
            r7 = 2
            goto L_0x03ed
        L_0x0429:
            r17 = r8
            double[] r7 = java.util.Arrays.copyOf(r12, r11)
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r13, r11)
            double[][] r8 = (double[][]) r8
            androidx.constraintlayout.core.motion.utils.CurveFit[] r9 = r0.mSpline
            int r10 = r17 + 1
            int r11 = r0.mCurveFitType
            androidx.constraintlayout.core.motion.utils.CurveFit r7 = androidx.constraintlayout.core.motion.utils.CurveFit.get(r11, r7, r8)
            r9[r10] = r7
            r8 = r10
            r7 = 2
            goto L_0x03e2
        L_0x0444:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r7 = r0.mSpline
            int r8 = r0.mCurveFitType
            androidx.constraintlayout.core.motion.utils.CurveFit r2 = androidx.constraintlayout.core.motion.utils.CurveFit.get(r8, r6, r2)
            r16 = 0
            r7[r16] = r2
            r2 = r5[r16]
            int r2 = r2.mPathMotionArc
            int r6 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r2 == r6) goto L_0x0490
            int[] r2 = new int[r4]
            double[] r6 = new double[r4]
            r7 = 2
            int[] r8 = new int[r7]
            r8[r20] = r7
            r8[r16] = r4
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r8)
            double[][] r1 = (double[][]) r1
            r7 = 0
        L_0x046a:
            if (r7 >= r4) goto L_0x0488
            r8 = r5[r7]
            int r9 = r8.mPathMotionArc
            r2[r7] = r9
            float r9 = r8.mTime
            double r9 = (double) r9
            r6[r7] = r9
            r9 = r1[r7]
            float r10 = r8.mX
            double r10 = (double) r10
            r16 = 0
            r9[r16] = r10
            float r8 = r8.mY
            double r10 = (double) r8
            r9[r20] = r10
            int r7 = r7 + 1
            goto L_0x046a
        L_0x0488:
            r16 = 0
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = androidx.constraintlayout.core.motion.utils.CurveFit.getArc(r2, r6, r1)
            r0.mArcSpline = r1
        L_0x0490:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.mCycleMap = r1
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r0.mKeyList
            if (r1 == 0) goto L_0x0505
            java.util.Iterator r1 = r3.iterator()
            r2 = 2143289344(0x7fc00000, float:NaN)
        L_0x04a1:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04cd
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            androidx.constraintlayout.motion.utils.ViewOscillator r4 = androidx.constraintlayout.motion.utils.ViewOscillator.makeSpline(r3)
            if (r4 != 0) goto L_0x04b4
            goto L_0x04a1
        L_0x04b4:
            boolean r5 = r4.variesByPath()
            if (r5 == 0) goto L_0x04c4
            boolean r5 = java.lang.Float.isNaN(r2)
            if (r5 == 0) goto L_0x04c4
            float r2 = r0.getPreCycleDistance()
        L_0x04c4:
            r4.setType(r3)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r5 = r0.mCycleMap
            r5.put(r3, r4)
            goto L_0x04a1
        L_0x04cd:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r0.mKeyList
            int r3 = r1.size()
            r6 = r16
        L_0x04d5:
            if (r6 >= r3) goto L_0x04eb
            java.lang.Object r4 = r1.get(r6)
            int r6 = r6 + 1
            androidx.constraintlayout.motion.widget.Key r4 = (androidx.constraintlayout.motion.widget.Key) r4
            boolean r5 = r4 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r5 == 0) goto L_0x04d5
            androidx.constraintlayout.motion.widget.KeyCycle r4 = (androidx.constraintlayout.motion.widget.KeyCycle) r4
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r5 = r0.mCycleMap
            r4.addCycleValues(r5)
            goto L_0x04d5
        L_0x04eb:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r1 = r0.mCycleMap
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x04f5:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0505
            java.lang.Object r3 = r1.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r3 = (androidx.constraintlayout.motion.utils.ViewOscillator) r3
            r3.setup(r2)
            goto L_0x04f5
        L_0x0505:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.setup(int, int, float, long):void");
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    /* access modifiers changed from: package-private */
    public void setStartState(Rect rect, ConstraintSet constraintSet, int i5, int i6) {
        Rect rect2;
        MotionController motionController;
        int i7 = constraintSet.mRotate;
        if (i7 != 0) {
            motionController = this;
            rect2 = rect;
            motionController.rotate(rect2, this.mTempRect, i7, i5, i6);
        } else {
            motionController = this;
            rect2 = rect;
        }
        MotionPaths motionPaths = motionController.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        readView(motionPaths);
        motionController.mStartMotionPath.setBounds((float) rect2.left, (float) rect2.top, (float) rect2.width(), (float) rect2.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(motionController.mId);
        motionController.mStartMotionPath.applyParameters(parameters);
        motionController.mMotionStagger = parameters.motion.mMotionStagger;
        motionController.mStartPoint.setState(rect2, constraintSet, i7, motionController.mId);
        motionController.mTransformPivotTarget = parameters.transform.transformPivotTarget;
        ConstraintSet.Motion motion = parameters.motion;
        motionController.mQuantizeMotionSteps = motion.mQuantizeMotionSteps;
        motionController.mQuantizeMotionPhase = motion.mQuantizeMotionPhase;
        Context context = motionController.mView.getContext();
        ConstraintSet.Motion motion2 = parameters.motion;
        motionController.mQuantizeMotionInterpolator = getInterpolator(context, motion2.mQuantizeInterpolatorType, motion2.mQuantizeInterpolatorString, motion2.mQuantizeInterpolatorID);
    }
}
