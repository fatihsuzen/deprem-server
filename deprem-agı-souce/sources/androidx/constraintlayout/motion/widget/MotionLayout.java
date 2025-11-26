package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    private long mAnimationStartTime = 0;
    /* access modifiers changed from: private */
    public int mBeginState = -1;
    private RectF mBoundsCheck = new RectF();
    int mCurrentState = -1;
    int mDebugPath = 0;
    private DecelerateInterpolator mDecelerateLogic = new DecelerateInterpolator();
    private ArrayList<MotionHelper> mDecoratorsHelpers = null;
    private boolean mDelayedApply = false;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    /* access modifiers changed from: private */
    public int mEndState = -1;
    int mEndWrapHeight;
    int mEndWrapWidth;
    boolean mFirstDown = true;
    HashMap<View, MotionController> mFrameArrayList = new HashMap<>();
    private int mFrames = 0;
    int mHeightMeasureMode;
    private boolean mInLayout = false;
    /* access modifiers changed from: private */
    public boolean mInRotation = false;
    boolean mInTransition = false;
    boolean mIndirectTransition = false;
    private boolean mInteractionEnabled = true;
    Interpolator mInterpolator;
    private Matrix mInverseMatrix = null;
    boolean mIsAnimating = false;
    private boolean mKeepAnimating = false;
    private KeyCache mKeyCache = new KeyCache();
    private long mLastDrawTime = -1;
    private float mLastFps = 0.0f;
    /* access modifiers changed from: private */
    public int mLastHeightMeasureSpec = 0;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    private float mLastPos;
    float mLastVelocity = 0.0f;
    /* access modifiers changed from: private */
    public int mLastWidthMeasureSpec = 0;
    private float mLastY;
    private float mListenerPosition = 0.0f;
    private int mListenerState = 0;
    protected boolean mMeasureDuringTransition = false;
    Model mModel = new Model();
    private boolean mNeedsFireTransitionCompleted = false;
    int mOldHeight;
    int mOldWidth;
    private Runnable mOnComplete = null;
    private ArrayList<MotionHelper> mOnHideHelpers = null;
    private ArrayList<MotionHelper> mOnShowHelpers = null;
    float mPostInterpolationPosition;
    HashMap<View, ViewState> mPreRotate = new HashMap<>();
    /* access modifiers changed from: private */
    public int mPreRotateHeight;
    /* access modifiers changed from: private */
    public int mPreRotateWidth;
    private int mPreviouseRotation;
    Interpolator mProgressInterpolator = null;
    private View mRegionView = null;
    int mRotatMode = 0;
    MotionScene mScene;
    private int[] mScheduledTransitionTo = null;
    int mScheduledTransitions = 0;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    /* access modifiers changed from: private */
    public StateCache mStateCache;
    private StopLogic mStopLogic = new StopLogic();
    Rect mTempRect = new Rect();
    private boolean mTemporalInterpolator = false;
    ArrayList<Integer> mTransitionCompleted = new ArrayList<>();
    private float mTransitionDuration = 1.0f;
    float mTransitionGoalPosition = 0.0f;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition = 0.0f;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private CopyOnWriteArrayList<TransitionListener> mTransitionListeners = null;
    float mTransitionPosition = 0.0f;
    TransitionState mTransitionState = TransitionState.UNDEFINED;
    boolean mUndergoingMotion = false;
    int mWidthMeasureMode;

    class DecelerateInterpolator extends MotionInterpolator {
        float mCurrentP = 0.0f;
        float mInitialV = 0.0f;
        float mMaxA;

        DecelerateInterpolator() {
        }

        public void config(float f5, float f6, float f7) {
            this.mInitialV = f5;
            this.mCurrentP = f6;
            this.mMaxA = f7;
        }

        public float getInterpolation(float f5) {
            float f6;
            float f7;
            float f8 = this.mInitialV;
            if (f8 > 0.0f) {
                float f9 = this.mMaxA;
                if (f8 / f9 < f5) {
                    f5 = f8 / f9;
                }
                MotionLayout.this.mLastVelocity = f8 - (f9 * f5);
                f6 = (f8 * f5) - (((f9 * f5) * f5) / 2.0f);
                f7 = this.mCurrentP;
            } else {
                float f10 = this.mMaxA;
                if ((-f8) / f10 < f5) {
                    f5 = (-f8) / f10;
                }
                MotionLayout.this.mLastVelocity = (f10 * f5) + f8;
                f6 = (f8 * f5) + (((f10 * f5) * f5) / 2.0f);
                f7 = this.mCurrentP;
            }
            return f6 + f7;
        }

        public float getVelocity() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    private class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        Rect mBounds = new Rect();
        DashPathEffect mDashPathEffect;
        final int mDiamondSize = 10;
        Paint mFillPaint;
        final int mGraphColor = -13391360;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        final int mKeyframeColor = -2067046;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        boolean mPresentationMode = false;
        private float[] mRectangle;
        final int mRedColor = -21965;
        final int mShadowColor = 1996488704;
        int mShadowTranslate = 1;
        Paint mTextPaint;

        DevModeDraw() {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            Paint paint2 = this.mPaint;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.mPaintKeyframes = paint3;
            paint3.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(style);
            Paint paint4 = new Paint();
            this.mPaintGraph = paint4;
            paint4.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(style);
            Paint paint5 = new Paint();
            this.mTextPaint = paint5;
            paint5.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint paint6 = new Paint();
            this.mFillPaint = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = dashPathEffect;
            this.mPaintGraph.setPathEffect(dashPathEffect);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        private void drawBasicPath(Canvas canvas) {
            canvas.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas canvas) {
            boolean z4 = false;
            boolean z5 = false;
            for (int i5 = 0; i5 < this.mKeyFrameCount; i5++) {
                int i6 = this.mPathMode[i5];
                if (i6 == 1) {
                    z4 = true;
                }
                if (i6 == 0) {
                    z5 = true;
                }
            }
            if (z4) {
                drawPathRelative(canvas);
            }
            if (z5) {
                drawPathCartesian(canvas);
            }
        }

        private void drawPathCartesian(Canvas canvas) {
            float[] fArr = this.mPoints;
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = fArr[fArr.length - 2];
            float f8 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f5, f7), Math.max(f6, f8), Math.max(f5, f7), Math.max(f6, f8), this.mPaintGraph);
            canvas.drawLine(Math.min(f5, f7), Math.min(f6, f8), Math.min(f5, f7), Math.max(f6, f8), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas canvas, float f5, float f6) {
            Canvas canvas2 = canvas;
            float[] fArr = this.mPoints;
            float f7 = fArr[0];
            float f8 = fArr[1];
            float f9 = fArr[fArr.length - 2];
            float f10 = fArr[fArr.length - 1];
            float min = Math.min(f7, f9);
            float max = Math.max(f8, f10);
            float min2 = f5 - Math.min(f7, f9);
            float max2 = Math.max(f8, f10) - f6;
            String str = "" + (((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f9 - f7))) + 0.5d))) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas2.drawText(str, ((min2 / 2.0f) - ((float) (this.mBounds.width() / 2))) + min, f6 - 20.0f, this.mTextPaint);
            canvas2.drawLine(f5, f6, Math.min(f7, f9), f6, this.mPaintGraph);
            String str2 = "" + (((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f10 - f8))) + 0.5d))) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas2.drawText(str2, f5 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.mBounds.height() / 2))), this.mTextPaint);
            canvas2.drawLine(f5, f6, f5, Math.max(f8, f10), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas canvas) {
            float[] fArr = this.mPoints;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas canvas, float f5, float f6) {
            float[] fArr = this.mPoints;
            float f7 = fArr[0];
            float f8 = fArr[1];
            float f9 = fArr[fArr.length - 2];
            float f10 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f7 - f9), (double) (f8 - f10));
            float f11 = f9 - f7;
            float f12 = f10 - f8;
            float f13 = (((f5 - f7) * f11) + ((f6 - f8) * f12)) / (hypot * hypot);
            float f14 = f7 + (f11 * f13);
            float f15 = f8 + (f13 * f12);
            Path path = new Path();
            path.moveTo(f5, f6);
            path.lineTo(f14, f15);
            float hypot2 = (float) Math.hypot((double) (f14 - f5), (double) (f15 - f6));
            String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            Canvas canvas2 = canvas;
            canvas2.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.mBounds.width() / 2)), -20.0f, this.mTextPaint);
            canvas2.drawLine(f5, f6, f14, f15, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas canvas, float f5, float f6, int i5, int i6) {
            String str = "" + (((float) ((int) (((double) (((f5 - ((float) (i5 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i5)))) + 0.5d))) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((f5 / 2.0f) - ((float) (this.mBounds.width() / 2))) + 0.0f, f6 - 20.0f, this.mTextPaint);
            Canvas canvas2 = canvas;
            canvas2.drawLine(f5, f6, Math.min(0.0f, 1.0f), f6, this.mPaintGraph);
            String str2 = "" + (((float) ((int) (((double) (((f6 - ((float) (i6 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i6)))) + 0.5d))) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, 5.0f + f5, 0.0f - ((f6 / 2.0f) - ((float) (this.mBounds.height() / 2))), this.mTextPaint);
            canvas2.drawLine(f5, f6, f5, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas canvas, MotionController motionController) {
            this.mPath.reset();
            for (int i5 = 0; i5 <= 50; i5++) {
                motionController.buildRect(((float) i5) / ((float) 50), this.mRectangle, 0);
                Path path = this.mPath;
                float[] fArr = this.mRectangle;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.mPath;
                float[] fArr2 = this.mRectangle;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.mPath;
                float[] fArr3 = this.mRectangle;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.mPath;
                float[] fArr4 = this.mRectangle;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.mPath.close();
            }
            this.mPaint.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.translate(-2.0f, -2.0f);
            this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas canvas, int i5, int i6, MotionController motionController) {
            int i7;
            int i8;
            Canvas canvas2 = canvas;
            int i9 = i5;
            MotionController motionController2 = motionController;
            View view = motionController2.mView;
            if (view != null) {
                i8 = view.getWidth();
                i7 = motionController2.mView.getHeight();
            } else {
                i8 = 0;
                i7 = 0;
            }
            for (int i10 = 1; i10 < i6 - 1; i10++) {
                if (i9 != 4 || this.mPathMode[i10 - 1] != 0) {
                    float[] fArr = this.mKeyFramePoints;
                    int i11 = i10 * 2;
                    float f5 = fArr[i11];
                    float f6 = fArr[i11 + 1];
                    this.mPath.reset();
                    this.mPath.moveTo(f5, f6 + 10.0f);
                    this.mPath.lineTo(f5 + 10.0f, f6);
                    this.mPath.lineTo(f5, f6 - 10.0f);
                    this.mPath.lineTo(f5 - 10.0f, f6);
                    this.mPath.close();
                    int i12 = i10 - 1;
                    motionController2.getKeyFrame(i12);
                    if (i9 == 4) {
                        int i13 = this.mPathMode[i12];
                        if (i13 == 1) {
                            drawPathRelativeTicks(canvas2, f5 - 0.0f, f6 - 0.0f);
                        } else if (i13 == 0) {
                            drawPathCartesianTicks(canvas2, f5 - 0.0f, f6 - 0.0f);
                        } else if (i13 == 2) {
                            drawPathScreenTicks(canvas2, f5 - 0.0f, f6 - 0.0f, i8, i7);
                        }
                        canvas2.drawPath(this.mPath, this.mFillPaint);
                    }
                    if (i9 == 2) {
                        drawPathRelativeTicks(canvas2, f5 - 0.0f, f6 - 0.0f);
                    }
                    if (i9 == 3) {
                        drawPathCartesianTicks(canvas2, f5 - 0.0f, f6 - 0.0f);
                    }
                    if (i9 == 6) {
                        drawPathScreenTicks(canvas2, f5 - 0.0f, f6 - 0.0f, i8, i7);
                    }
                    canvas2.drawPath(this.mPath, this.mFillPaint);
                }
            }
            float[] fArr2 = this.mPoints;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
                float[] fArr3 = this.mPoints;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
            }
        }

        private void drawTranslation(Canvas canvas, float f5, float f6, float f7, float f8) {
            canvas.drawRect(f5, f6, f7, f8, this.mPaintGraph);
            canvas.drawLine(f5, f6, f7, f8, this.mPaintGraph);
        }

        public void draw(Canvas canvas, HashMap<View, MotionController> hashMap, int i5, int i6) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i6 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ":" + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.mTextPaint);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.mPaint);
                }
                for (MotionController next : hashMap.values()) {
                    int drawPath = next.getDrawPath();
                    if (i6 > 0 && drawPath == 0) {
                        drawPath = 1;
                    }
                    if (drawPath != 0) {
                        this.mKeyFrameCount = next.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                        if (drawPath >= 1) {
                            int i7 = i5 / 16;
                            float[] fArr = this.mPoints;
                            if (fArr == null || fArr.length != i7 * 2) {
                                this.mPoints = new float[(i7 * 2)];
                                this.mPath = new Path();
                            }
                            int i8 = this.mShadowTranslate;
                            canvas.translate((float) i8, (float) i8);
                            this.mPaint.setColor(1996488704);
                            this.mFillPaint.setColor(1996488704);
                            this.mPaintKeyframes.setColor(1996488704);
                            this.mPaintGraph.setColor(1996488704);
                            next.buildPath(this.mPoints, i7);
                            drawAll(canvas, drawPath, this.mKeyFrameCount, next);
                            this.mPaint.setColor(-21965);
                            this.mPaintKeyframes.setColor(-2067046);
                            this.mFillPaint.setColor(-2067046);
                            this.mPaintGraph.setColor(-13391360);
                            int i9 = this.mShadowTranslate;
                            canvas.translate((float) (-i9), (float) (-i9));
                            drawAll(canvas, drawPath, this.mKeyFrameCount, next);
                            if (drawPath == 5) {
                                drawRectangle(canvas, next);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void drawAll(Canvas canvas, int i5, int i6, MotionController motionController) {
            if (i5 == 4) {
                drawPathAsConfigured(canvas);
            }
            if (i5 == 2) {
                drawPathRelative(canvas);
            }
            if (i5 == 3) {
                drawPathCartesian(canvas);
            }
            drawBasicPath(canvas);
            drawTicks(canvas, i5, i6, motionController);
        }

        /* access modifiers changed from: package-private */
        public void getTextBounds(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.mBounds);
        }
    }

    class Model {
        ConstraintSet mEnd = null;
        int mEndId;
        ConstraintWidgetContainer mLayoutEnd = new ConstraintWidgetContainer();
        ConstraintWidgetContainer mLayoutStart = new ConstraintWidgetContainer();
        ConstraintSet mStart = null;
        int mStartId;

        Model() {
        }

        private void computeStartEndSize(int i5, int i6) {
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.mCurrentState == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutEnd;
                ConstraintSet constraintSet = this.mEnd;
                if (constraintSet == null || constraintSet.mRotate == 0) {
                    i10 = i5;
                } else {
                    i10 = i6;
                }
                if (constraintSet == null || constraintSet.mRotate == 0) {
                    i11 = i6;
                } else {
                    i11 = i5;
                }
                motionLayout2.resolveSystem(constraintWidgetContainer, optimizationLevel, i10, i11);
                ConstraintSet constraintSet2 = this.mStart;
                if (constraintSet2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                    int i13 = constraintSet2.mRotate;
                    if (i13 == 0) {
                        i12 = i5;
                    } else {
                        i12 = i6;
                    }
                    if (i13 == 0) {
                        i5 = i6;
                    }
                    motionLayout3.resolveSystem(constraintWidgetContainer2, optimizationLevel, i12, i5);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet3 = this.mStart;
            if (constraintSet3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutStart;
                int i14 = constraintSet3.mRotate;
                if (i14 == 0) {
                    i8 = i5;
                } else {
                    i8 = i6;
                }
                if (i14 == 0) {
                    i9 = i6;
                } else {
                    i9 = i5;
                }
                motionLayout4.resolveSystem(constraintWidgetContainer3, optimizationLevel, i8, i9);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            ConstraintWidgetContainer constraintWidgetContainer4 = this.mLayoutEnd;
            ConstraintSet constraintSet4 = this.mEnd;
            if (constraintSet4 == null || constraintSet4.mRotate == 0) {
                i7 = i5;
            } else {
                i7 = i6;
            }
            if (constraintSet4 == null || constraintSet4.mRotate == 0) {
                i5 = i6;
            }
            motionLayout5.resolveSystem(constraintWidgetContainer4, optimizationLevel, i7, i5);
        }

        @SuppressLint({"LogConditional"})
        private void debugLayout(String str, ConstraintWidgetContainer constraintWidgetContainer) {
            String str2;
            String str3;
            String str4;
            String str5 = str + " " + Debug.getName((View) constraintWidgetContainer.getCompanionWidget());
            Log.v(MotionLayout.TAG, str5 + "  ========= " + constraintWidgetContainer);
            int size = constraintWidgetContainer.getChildren().size();
            for (int i5 = 0; i5 < size; i5++) {
                String str6 = str5 + "[" + i5 + "] ";
                ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i5);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                String str7 = "_";
                if (constraintWidget.mTop.mTarget != null) {
                    str2 = ExifInterface.GPS_DIRECTION_TRUE;
                } else {
                    str2 = str7;
                }
                sb.append(str2);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                if (constraintWidget.mBottom.mTarget != null) {
                    str3 = "B";
                } else {
                    str3 = str7;
                }
                sb3.append(str3);
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(sb4);
                if (constraintWidget.mLeft.mTarget != null) {
                    str4 = "L";
                } else {
                    str4 = str7;
                }
                sb5.append(str4);
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                if (constraintWidget.mRight.mTarget != null) {
                    str7 = "R";
                }
                sb7.append(str7);
                String sb8 = sb7.toString();
                View view = (View) constraintWidget.getCompanionWidget();
                String name = Debug.getName(view);
                if (view instanceof TextView) {
                    name = name + "(" + ((TextView) view).getText() + ")";
                }
                Log.v(MotionLayout.TAG, str6 + "  " + name + " " + constraintWidget + " " + sb8);
            }
            Log.v(MotionLayout.TAG, str5 + " done. ");
        }

        @SuppressLint({"LogConditional"})
        private void debugLayoutParam(String str, ConstraintLayout.LayoutParams layoutParams) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            if (layoutParams.startToStart != -1) {
                str2 = "SS";
            } else {
                str2 = "__";
            }
            sb.append(str2);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            String str13 = "|__";
            if (layoutParams.startToEnd != -1) {
                str3 = "|SE";
            } else {
                str3 = str13;
            }
            sb3.append(str3);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            if (layoutParams.endToStart != -1) {
                str4 = "|ES";
            } else {
                str4 = str13;
            }
            sb5.append(str4);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            if (layoutParams.endToEnd != -1) {
                str5 = "|EE";
            } else {
                str5 = str13;
            }
            sb7.append(str5);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(sb8);
            if (layoutParams.leftToLeft != -1) {
                str6 = "|LL";
            } else {
                str6 = str13;
            }
            sb9.append(str6);
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb10);
            if (layoutParams.leftToRight != -1) {
                str7 = "|LR";
            } else {
                str7 = str13;
            }
            sb11.append(str7);
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(sb12);
            if (layoutParams.rightToLeft != -1) {
                str8 = "|RL";
            } else {
                str8 = str13;
            }
            sb13.append(str8);
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(sb14);
            if (layoutParams.rightToRight != -1) {
                str9 = "|RR";
            } else {
                str9 = str13;
            }
            sb15.append(str9);
            String sb16 = sb15.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(sb16);
            if (layoutParams.topToTop != -1) {
                str10 = "|TT";
            } else {
                str10 = str13;
            }
            sb17.append(str10);
            String sb18 = sb17.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append(sb18);
            if (layoutParams.topToBottom != -1) {
                str11 = "|TB";
            } else {
                str11 = str13;
            }
            sb19.append(str11);
            String sb20 = sb19.toString();
            StringBuilder sb21 = new StringBuilder();
            sb21.append(sb20);
            if (layoutParams.bottomToTop != -1) {
                str12 = "|BT";
            } else {
                str12 = str13;
            }
            sb21.append(str12);
            String sb22 = sb21.toString();
            StringBuilder sb23 = new StringBuilder();
            sb23.append(sb22);
            if (layoutParams.bottomToBottom != -1) {
                str13 = "|BB";
            }
            sb23.append(str13);
            String sb24 = sb23.toString();
            Log.v(MotionLayout.TAG, str + sb24);
        }

        @SuppressLint({"LogConditional"})
        private void debugWidget(String str, ConstraintWidget constraintWidget) {
            String str2;
            String str3;
            String str4;
            String str5;
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            String str6 = "B";
            String str7 = "__";
            if (constraintWidget.mTop.mTarget != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ExifInterface.GPS_DIRECTION_TRUE);
                sb2.append(constraintWidget.mTop.mTarget.mType == ConstraintAnchor.Type.TOP ? ExifInterface.GPS_DIRECTION_TRUE : str6);
                str2 = sb2.toString();
            } else {
                str2 = str7;
            }
            sb.append(str2);
            String sb3 = sb.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            if (constraintWidget.mBottom.mTarget != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str6);
                if (constraintWidget.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP) {
                    str6 = ExifInterface.GPS_DIRECTION_TRUE;
                }
                sb5.append(str6);
                str3 = sb5.toString();
            } else {
                str3 = str7;
            }
            sb4.append(str3);
            String sb6 = sb4.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            String str8 = "R";
            if (constraintWidget.mLeft.mTarget != null) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("L");
                if (constraintWidget.mLeft.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                    str5 = "L";
                } else {
                    str5 = str8;
                }
                sb8.append(str5);
                str4 = sb8.toString();
            } else {
                str4 = str7;
            }
            sb7.append(str4);
            String sb9 = sb7.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(sb9);
            if (constraintWidget.mRight.mTarget != null) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append(str8);
                if (constraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                    str8 = "L";
                }
                sb11.append(str8);
                str7 = sb11.toString();
            }
            sb10.append(str7);
            String sb12 = sb10.toString();
            Log.v(MotionLayout.TAG, str + sb12 + " ---  " + constraintWidget);
        }

        private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            int i5 = 0;
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            if (!(constraintSet == null || constraintSet.mRotate == 0)) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.mLayoutEnd, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            int i6 = 0;
            while (i6 < size) {
                ConstraintWidget constraintWidget = children.get(i6);
                i6++;
                ConstraintWidget constraintWidget2 = constraintWidget;
                constraintWidget2.setAnimated(true);
                sparseArray.put(((View) constraintWidget2.getCompanionWidget()).getId(), constraintWidget2);
            }
            ArrayList<ConstraintWidget> children2 = constraintWidgetContainer.getChildren();
            int size2 = children2.size();
            int i7 = 0;
            while (i7 < size2) {
                int i8 = i7 + 1;
                ConstraintWidget constraintWidget3 = children2.get(i7);
                View view = (View) constraintWidget3.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                constraintWidget3.setWidth(constraintSet.getWidth(view.getId()));
                constraintWidget3.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.applyToHelper((ConstraintHelper) view, constraintWidget3, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, constraintWidget3, layoutParams, sparseArray);
                if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                    constraintWidget3.setVisibility(view.getVisibility());
                } else {
                    constraintWidget3.setVisibility(constraintSet.getVisibility(view.getId()));
                }
                i7 = i8;
            }
            ArrayList<ConstraintWidget> children3 = constraintWidgetContainer.getChildren();
            int size3 = children3.size();
            while (i5 < size3) {
                ConstraintWidget constraintWidget4 = children3.get(i5);
                i5++;
                ConstraintWidget constraintWidget5 = constraintWidget4;
                if (constraintWidget5 instanceof VirtualLayout) {
                    Helper helper = (Helper) constraintWidget5;
                    ((ConstraintHelper) constraintWidget5.getCompanionWidget()).updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x00df  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0133 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void build() {
            /*
                r17 = this;
                r0 = r17
                androidx.constraintlayout.motion.widget.MotionLayout r1 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r1 = r1.getChildCount()
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r2 = r2.mFrameArrayList
                r2.clear()
                android.util.SparseArray r2 = new android.util.SparseArray
                r2.<init>()
                int[] r3 = new int[r1]
                r4 = 0
                r5 = r4
            L_0x0018:
                if (r5 >= r1) goto L_0x0038
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionController r7 = new androidx.constraintlayout.motion.widget.MotionController
                r7.<init>(r6)
                int r8 = r6.getId()
                r3[r5] = r8
                r2.put(r8, r7)
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r8 = r8.mFrameArrayList
                r8.put(r6, r7)
                int r5 = r5 + 1
                goto L_0x0018
            L_0x0038:
                r5 = r4
            L_0x0039:
                if (r5 >= r1) goto L_0x0137
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r9 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r6 = r6.mFrameArrayList
                java.lang.Object r6 = r6.get(r9)
                r7 = r6
                androidx.constraintlayout.motion.widget.MotionController r7 = (androidx.constraintlayout.motion.widget.MotionController) r7
                if (r7 != 0) goto L_0x0050
                goto L_0x0133
            L_0x0050:
                androidx.constraintlayout.widget.ConstraintSet r6 = r0.mStart
                java.lang.String r13 = ")"
                java.lang.String r14 = " ("
                java.lang.String r15 = "no widget for  "
                java.lang.String r8 = "MotionLayout"
                if (r6 == 0) goto L_0x00b2
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r6 = r0.mLayoutStart
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r0.getWidget(r6, r9)
                if (r6 == 0) goto L_0x007c
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r6 = r10.toRect(r6)
                androidx.constraintlayout.widget.ConstraintSet r10 = r0.mStart
                androidx.constraintlayout.motion.widget.MotionLayout r11 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r11 = r11.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r12 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r12 = r12.getHeight()
                r7.setStartState(r6, r10, r11, r12)
                goto L_0x00b0
            L_0x007c:
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r6 = r6.mDebugPath
                if (r6 == 0) goto L_0x00b0
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r10 = androidx.constraintlayout.motion.widget.Debug.getLocation()
                r6.append(r10)
                r6.append(r15)
                java.lang.String r10 = androidx.constraintlayout.motion.widget.Debug.getName(r9)
                r6.append(r10)
                r6.append(r14)
                java.lang.Class r10 = r9.getClass()
                java.lang.String r10 = r10.getName()
                r6.append(r10)
                r6.append(r13)
                java.lang.String r6 = r6.toString()
                android.util.Log.e(r8, r6)
            L_0x00b0:
                r6 = r8
                goto L_0x00db
            L_0x00b2:
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                boolean r6 = r6.mInRotation
                if (r6 == 0) goto L_0x00b0
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.utils.ViewState> r6 = r6.mPreRotate
                java.lang.Object r6 = r6.get(r9)
                androidx.constraintlayout.motion.utils.ViewState r6 = (androidx.constraintlayout.motion.utils.ViewState) r6
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                r11 = r10
                int r10 = r11.mRotatMode
                int r11 = r11.mPreRotateWidth
                androidx.constraintlayout.motion.widget.MotionLayout r12 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r12 = r12.mPreRotateHeight
                r16 = r8
                r8 = r6
                r6 = r16
                r7.setStartState(r8, r9, r10, r11, r12)
            L_0x00db:
                androidx.constraintlayout.widget.ConstraintSet r8 = r0.mEnd
                if (r8 == 0) goto L_0x0133
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8 = r0.mLayoutEnd
                androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r0.getWidget(r8, r9)
                if (r8 == 0) goto L_0x00ff
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r6 = r6.toRect(r8)
                androidx.constraintlayout.widget.ConstraintSet r8 = r0.mEnd
                androidx.constraintlayout.motion.widget.MotionLayout r9 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r9 = r9.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r10.getHeight()
                r7.setEndState(r6, r8, r9, r10)
                goto L_0x0133
            L_0x00ff:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.mDebugPath
                if (r7 == 0) goto L_0x0133
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.getLocation()
                r7.append(r8)
                r7.append(r15)
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.getName(r9)
                r7.append(r8)
                r7.append(r14)
                java.lang.Class r8 = r9.getClass()
                java.lang.String r8 = r8.getName()
                r7.append(r8)
                r7.append(r13)
                java.lang.String r7 = r7.toString()
                android.util.Log.e(r6, r7)
            L_0x0133:
                int r5 = r5 + 1
                goto L_0x0039
            L_0x0137:
                if (r4 >= r1) goto L_0x0154
                r5 = r3[r4]
                java.lang.Object r5 = r2.get(r5)
                androidx.constraintlayout.motion.widget.MotionController r5 = (androidx.constraintlayout.motion.widget.MotionController) r5
                int r6 = r5.getAnimateRelativeTo()
                r7 = -1
                if (r6 == r7) goto L_0x0151
                java.lang.Object r6 = r2.get(r6)
                androidx.constraintlayout.motion.widget.MotionController r6 = (androidx.constraintlayout.motion.widget.MotionController) r6
                r5.setupRelative(r6)
            L_0x0151:
                int r4 = r4 + 1
                goto L_0x0137
            L_0x0154:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.Model.build():void");
        }

        /* access modifiers changed from: package-private */
        public void copy(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            HashMap hashMap = new HashMap();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            int size = children.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                ConstraintWidget constraintWidget2 = children.get(i6);
                i6++;
                ConstraintWidget constraintWidget3 = constraintWidget2;
                if (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.Barrier) {
                    constraintWidget = new androidx.constraintlayout.core.widgets.Barrier();
                } else if (constraintWidget3 instanceof Guideline) {
                    constraintWidget = new Guideline();
                } else if (constraintWidget3 instanceof Flow) {
                    constraintWidget = new Flow();
                } else if (constraintWidget3 instanceof Placeholder) {
                    constraintWidget = new Placeholder();
                } else if (constraintWidget3 instanceof Helper) {
                    constraintWidget = new HelperWidget();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.add(constraintWidget);
                hashMap.put(constraintWidget3, constraintWidget);
            }
            int size2 = children.size();
            while (i5 < size2) {
                ConstraintWidget constraintWidget4 = children.get(i5);
                i5++;
                ConstraintWidget constraintWidget5 = constraintWidget4;
                ((ConstraintWidget) hashMap.get(constraintWidget5)).copy(constraintWidget5, hashMap);
            }
        }

        /* access modifiers changed from: package-private */
        public ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget = children.get(i5);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void initFrom(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.mStart = constraintSet;
            this.mEnd = constraintSet2;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.mLayoutEnd.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(MotionLayout.this.mLayoutWidget, this.mLayoutStart);
            copy(MotionLayout.this.mLayoutWidget, this.mLayoutEnd);
            if (((double) MotionLayout.this.mTransitionLastPosition) > 0.5d) {
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            } else {
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
            }
            this.mLayoutStart.setRtl(MotionLayout.this.isRtl());
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.this.isRtl());
            this.mLayoutEnd.updateHierarchy();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    this.mLayoutEnd.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutStart;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    this.mLayoutEnd.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            }
        }

        public boolean isNotConfiguredWith(int i5, int i6) {
            if (i5 == this.mStartId && i6 == this.mEndId) {
                return false;
            }
            return true;
        }

        public void measure(int i5, int i6) {
            boolean z4;
            boolean z5;
            boolean z6;
            int mode = View.MeasureSpec.getMode(i5);
            int mode2 = View.MeasureSpec.getMode(i6);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            computeStartEndSize(i5, i6);
            if (!((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824)) {
                computeStartEndSize(i5, i6);
                MotionLayout.this.mStartWrapWidth = this.mLayoutStart.getWidth();
                MotionLayout.this.mStartWrapHeight = this.mLayoutStart.getHeight();
                MotionLayout.this.mEndWrapWidth = this.mLayoutEnd.getWidth();
                MotionLayout.this.mEndWrapHeight = this.mLayoutEnd.getHeight();
                MotionLayout motionLayout2 = MotionLayout.this;
                if (motionLayout2.mStartWrapWidth == motionLayout2.mEndWrapWidth && motionLayout2.mStartWrapHeight == motionLayout2.mEndWrapHeight) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                motionLayout2.mMeasureDuringTransition = z6;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i7 = motionLayout3.mStartWrapWidth;
            int i8 = motionLayout3.mStartWrapHeight;
            int i9 = motionLayout3.mWidthMeasureMode;
            if (i9 == Integer.MIN_VALUE || i9 == 0) {
                i7 = (int) (((float) i7) + (motionLayout3.mPostInterpolationPosition * ((float) (motionLayout3.mEndWrapWidth - i7))));
            }
            int i10 = i7;
            int i11 = motionLayout3.mHeightMeasureMode;
            if (i11 == Integer.MIN_VALUE || i11 == 0) {
                i8 = (int) (((float) i8) + (motionLayout3.mPostInterpolationPosition * ((float) (motionLayout3.mEndWrapHeight - i8))));
            }
            int i12 = i8;
            if (this.mLayoutStart.isWidthMeasuredTooSmall() || this.mLayoutEnd.isWidthMeasuredTooSmall()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (this.mLayoutStart.isHeightMeasuredTooSmall() || this.mLayoutEnd.isHeightMeasuredTooSmall()) {
                z5 = true;
            } else {
                z5 = false;
            }
            MotionLayout.this.resolveMeasuredDimension(i5, i6, i10, i12, z4, z5);
        }

        public void reEvaluateState() {
            measure(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void setMeasuredId(int i5, int i6) {
            this.mStartId = i5;
            this.mEndId = i6;
        }
    }

    protected interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i5);

        void computeCurrentVelocity(int i5, float f5);

        float getXVelocity();

        float getXVelocity(int i5);

        float getYVelocity();

        float getYVelocity(int i5);

        void recycle();
    }

    class StateCache {
        int mEndState = -1;
        final String mKeyEndState = "motion.EndState";
        final String mKeyProgress = "motion.progress";
        final String mKeyStartState = "motion.StartState";
        final String mKeyVelocity = "motion.velocity";
        float mProgress = Float.NaN;
        int mStartState = -1;
        float mVelocity = Float.NaN;

        StateCache() {
        }

        /* access modifiers changed from: package-private */
        public void apply() {
            int i5 = this.mStartState;
            if (!(i5 == -1 && this.mEndState == -1)) {
                if (i5 == -1) {
                    MotionLayout.this.transitionToState(this.mEndState);
                } else {
                    int i6 = this.mEndState;
                    if (i6 == -1) {
                        MotionLayout.this.setState(i5, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i5, i6);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.mVelocity)) {
                MotionLayout.this.setProgress(this.mProgress, this.mVelocity);
                this.mProgress = Float.NaN;
                this.mVelocity = Float.NaN;
                this.mStartState = -1;
                this.mEndState = -1;
            } else if (!Float.isNaN(this.mProgress)) {
                MotionLayout.this.setProgress(this.mProgress);
            }
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.mProgress);
            bundle.putFloat("motion.velocity", this.mVelocity);
            bundle.putInt("motion.StartState", this.mStartState);
            bundle.putInt("motion.EndState", this.mEndState);
            return bundle;
        }

        public void recordState() {
            this.mEndState = MotionLayout.this.mEndState;
            this.mStartState = MotionLayout.this.mBeginState;
            this.mVelocity = MotionLayout.this.getVelocity();
            this.mProgress = MotionLayout.this.getProgress();
        }

        public void setEndState(int i5) {
            this.mEndState = i5;
        }

        public void setProgress(float f5) {
            this.mProgress = f5;
        }

        public void setStartState(int i5) {
            this.mStartState = i5;
        }

        public void setTransitionState(Bundle bundle) {
            this.mProgress = bundle.getFloat("motion.progress");
            this.mVelocity = bundle.getFloat("motion.velocity");
            this.mStartState = bundle.getInt("motion.StartState");
            this.mEndState = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f5) {
            this.mVelocity = f5;
        }
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i5, int i6, float f5);

        void onTransitionCompleted(MotionLayout motionLayout, int i5);

        void onTransitionStarted(MotionLayout motionLayout, int i5, int i6);

        void onTransitionTrigger(MotionLayout motionLayout, int i5, boolean z4, float f5);
    }

    enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        init((AttributeSet) null);
    }

    private boolean callTransformedTouchEvent(View view, MotionEvent motionEvent, float f5, float f6) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f5, f6);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f5, -f6);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f5, f6);
        if (this.mInverseMatrix == null) {
            this.mInverseMatrix = new Matrix();
        }
        matrix.invert(this.mInverseMatrix);
        obtain.transform(this.mInverseMatrix);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    private void checkStructure() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int startId = motionScene.getStartId();
        MotionScene motionScene2 = this.mScene;
        checkStructure(startId, motionScene2.getConstraintSet(motionScene2.getStartId()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList<MotionScene.Transition> definedTransitions = this.mScene.getDefinedTransitions();
        int size = definedTransitions.size();
        int i5 = 0;
        while (i5 < size) {
            MotionScene.Transition transition = definedTransitions.get(i5);
            i5++;
            MotionScene.Transition transition2 = transition;
            if (transition2 == this.mScene.mCurrentTransition) {
                Log.v(TAG, "CHECK: CURRENT");
            }
            checkStructure(transition2);
            int startConstraintSetId = transition2.getStartConstraintSetId();
            int endConstraintSetId = transition2.getEndConstraintSetId();
            String name = Debug.getName(getContext(), startConstraintSetId);
            String name2 = Debug.getName(getContext(), endConstraintSetId);
            if (sparseIntArray.get(startConstraintSetId) == endConstraintSetId) {
                Log.e(TAG, "CHECK: two transitions with the same start and end " + name + "->" + name2);
            }
            if (sparseIntArray2.get(endConstraintSetId) == startConstraintSetId) {
                Log.e(TAG, "CHECK: you can't have reverse transitions" + name + "->" + name2);
            }
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            if (this.mScene.getConstraintSet(startConstraintSetId) == null) {
                Log.e(TAG, " no such constraintSetStart " + name);
            }
            if (this.mScene.getConstraintSet(endConstraintSetId) == null) {
                Log.e(TAG, " no such constraintSetEnd " + name);
            }
        }
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.setStartCurrentState(childAt);
            }
        }
    }

    @SuppressLint({"LogConditional"})
    private void debugPos() {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            Log.v(TAG, " " + Debug.getLocation() + " " + Debug.getName(this) + " " + Debug.getName(getContext(), this.mCurrentState) + " " + Debug.getName(childAt) + childAt.getLeft() + " " + childAt.getTop());
        }
    }

    private void evaluateLayout() {
        float f5;
        boolean z4;
        float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.mInterpolator;
        if (!(interpolator instanceof StopLogic)) {
            f5 = ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration;
        } else {
            f5 = 0.0f;
        }
        float f6 = this.mTransitionLastPosition + f5;
        if (this.mTransitionInstantly) {
            f6 = this.mTransitionGoalPosition;
        }
        int i5 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i5 <= 0 || f6 < this.mTransitionGoalPosition) && (signum > 0.0f || f6 > this.mTransitionGoalPosition)) {
            z4 = false;
        } else {
            f6 = this.mTransitionGoalPosition;
            z4 = true;
        }
        if (interpolator != null && !z4) {
            if (this.mTemporalInterpolator) {
                f6 = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
            } else {
                f6 = interpolator.getInterpolation(f6);
            }
        }
        if ((i5 > 0 && f6 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f6 <= this.mTransitionGoalPosition)) {
            f6 = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f6;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.mProgressInterpolator;
        if (interpolator2 != null) {
            f6 = interpolator2.getInterpolation(f6);
        }
        float f7 = f6;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.interpolate(childAt, f7, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) && this.mListenerPosition != this.mTransitionPosition) {
            if (this.mListenerState != -1) {
                fireTransitionStarted();
                this.mIsAnimating = true;
            }
            this.mListenerState = -1;
            float f5 = this.mTransitionPosition;
            this.mListenerPosition = f5;
            TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionChange(this, this.mBeginState, this.mEndState, f5);
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
            if (copyOnWriteArrayList2 != null) {
                Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
                }
            }
            this.mIsAnimating = true;
        }
    }

    private void fireTransitionStarted() {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handlesTouchEvent(float r8, float r9, android.view.View r10, android.view.MotionEvent r11) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof android.view.ViewGroup
            r1 = 1
            if (r0 == 0) goto L_0x0036
            r0 = r10
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r1
        L_0x000d:
            if (r2 < 0) goto L_0x0036
            android.view.View r3 = r0.getChildAt(r2)
            int r4 = r3.getLeft()
            float r4 = (float) r4
            float r4 = r4 + r8
            int r5 = r10.getScrollX()
            float r5 = (float) r5
            float r4 = r4 - r5
            int r5 = r3.getTop()
            float r5 = (float) r5
            float r5 = r5 + r9
            int r6 = r10.getScrollY()
            float r6 = (float) r6
            float r5 = r5 - r6
            boolean r3 = r7.handlesTouchEvent(r4, r5, r3, r11)
            if (r3 == 0) goto L_0x0033
            r0 = r1
            goto L_0x0037
        L_0x0033:
            int r2 = r2 + -1
            goto L_0x000d
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != 0) goto L_0x0075
            android.graphics.RectF r2 = r7.mBoundsCheck
            int r3 = r10.getRight()
            float r3 = (float) r3
            float r3 = r3 + r8
            int r4 = r10.getLeft()
            float r4 = (float) r4
            float r3 = r3 - r4
            int r4 = r10.getBottom()
            float r4 = (float) r4
            float r4 = r4 + r9
            int r5 = r10.getTop()
            float r5 = (float) r5
            float r4 = r4 - r5
            r2.set(r8, r9, r3, r4)
            int r2 = r11.getAction()
            if (r2 != 0) goto L_0x006c
            android.graphics.RectF r2 = r7.mBoundsCheck
            float r3 = r11.getX()
            float r4 = r11.getY()
            boolean r2 = r2.contains(r3, r4)
            if (r2 == 0) goto L_0x0075
        L_0x006c:
            float r8 = -r8
            float r9 = -r9
            boolean r8 = r7.callTransformedTouchEvent(r10, r11, r8, r9)
            if (r8 == 0) goto L_0x0075
            return r1
        L_0x0075:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.handlesTouchEvent(float, float, android.view.View, android.view.MotionEvent):boolean");
    }

    private void init(AttributeSet attributeSet) {
        MotionScene motionScene;
        int i5;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z4 = true;
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.mScene = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z4 = obtainStyledAttributes.getBoolean(index, z4);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            i5 = 2;
                        } else {
                            i5 = 0;
                        }
                        this.mDebugPath = i5;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.mDebugPath = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.mScene == null) {
                Log.e(TAG, "WARNING NO app:layoutDescription tag");
            }
            if (!z4) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            checkStructure();
        }
        if (this.mCurrentState == -1 && (motionScene = this.mScene) != null) {
            this.mCurrentState = motionScene.getStartId();
            this.mBeginState = this.mScene.getStartId();
            this.mEndState = this.mScene.getEndId();
        }
    }

    private void processTransitionCompleted() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if (this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) {
            int i5 = 0;
            this.mIsAnimating = false;
            ArrayList<Integer> arrayList = this.mTransitionCompleted;
            int size = arrayList.size();
            while (i5 < size) {
                Integer num = arrayList.get(i5);
                i5++;
                Integer num2 = num;
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionCompleted(this, num2.intValue());
                }
                CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().onTransitionCompleted(this, num2.intValue());
                    }
                }
            }
            this.mTransitionCompleted.clear();
        }
    }

    /* access modifiers changed from: private */
    public void setupMotionViews() {
        int childCount = getChildCount();
        this.mModel.build();
        boolean z4 = true;
        this.mInTransition = true;
        SparseArray sparseArray = new SparseArray();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int gatPathMotionArc = this.mScene.gatPathMotionArc();
        if (gatPathMotionArc != -1) {
            for (int i7 = 0; i7 < childCount; i7++) {
                MotionController motionController = this.mFrameArrayList.get(getChildAt(i7));
                if (motionController != null) {
                    motionController.setPathMotionArc(gatPathMotionArc);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.mFrameArrayList.size()];
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i9));
            if (motionController2.getAnimateRelativeTo() != -1) {
                sparseBooleanArray.put(motionController2.getAnimateRelativeTo(), true);
                iArr[i8] = motionController2.getAnimateRelativeTo();
                i8++;
            }
        }
        if (this.mDecoratorsHelpers != null) {
            for (int i10 = 0; i10 < i8; i10++) {
                MotionController motionController3 = this.mFrameArrayList.get(findViewById(iArr[i10]));
                if (motionController3 != null) {
                    this.mScene.getKeyFrames(motionController3);
                }
            }
            ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                MotionHelper motionHelper = arrayList.get(i11);
                i11++;
                motionHelper.onPreSetup(this, this.mFrameArrayList);
            }
            for (int i12 = 0; i12 < i8; i12++) {
                MotionController motionController4 = this.mFrameArrayList.get(findViewById(iArr[i12]));
                if (motionController4 != null) {
                    motionController4.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        } else {
            for (int i13 = 0; i13 < i8; i13++) {
                MotionController motionController5 = this.mFrameArrayList.get(findViewById(iArr[i13]));
                if (motionController5 != null) {
                    this.mScene.getKeyFrames(motionController5);
                    motionController5.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            MotionController motionController6 = this.mFrameArrayList.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                this.mScene.getKeyFrames(motionController6);
                motionController6.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            if (((double) staggered) >= 0.0d) {
                z4 = false;
            }
            float abs = Math.abs(staggered);
            float f5 = -3.4028235E38f;
            float f6 = Float.MAX_VALUE;
            float f7 = -3.4028235E38f;
            float f8 = Float.MAX_VALUE;
            for (int i15 = 0; i15 < childCount; i15++) {
                MotionController motionController7 = this.mFrameArrayList.get(getChildAt(i15));
                if (!Float.isNaN(motionController7.mMotionStagger)) {
                    for (int i16 = 0; i16 < childCount; i16++) {
                        MotionController motionController8 = this.mFrameArrayList.get(getChildAt(i16));
                        if (!Float.isNaN(motionController8.mMotionStagger)) {
                            f6 = Math.min(f6, motionController8.mMotionStagger);
                            f5 = Math.max(f5, motionController8.mMotionStagger);
                        }
                    }
                    while (i5 < childCount) {
                        MotionController motionController9 = this.mFrameArrayList.get(getChildAt(i5));
                        if (!Float.isNaN(motionController9.mMotionStagger)) {
                            motionController9.mStaggerScale = 1.0f / (1.0f - abs);
                            if (z4) {
                                motionController9.mStaggerOffset = abs - (((f5 - motionController9.mMotionStagger) / (f5 - f6)) * abs);
                            } else {
                                motionController9.mStaggerOffset = abs - (((motionController9.mMotionStagger - f6) * abs) / (f5 - f6));
                            }
                        }
                        i5++;
                    }
                    return;
                }
                float finalX = motionController7.getFinalX();
                float finalY = motionController7.getFinalY();
                float f9 = z4 ? finalY - finalX : finalY + finalX;
                f8 = Math.min(f8, f9);
                f7 = Math.max(f7, f9);
            }
            while (i5 < childCount) {
                MotionController motionController10 = this.mFrameArrayList.get(getChildAt(i5));
                float finalX2 = motionController10.getFinalX();
                float finalY2 = motionController10.getFinalY();
                float f10 = z4 ? finalY2 - finalX2 : finalY2 + finalX2;
                motionController10.mStaggerScale = 1.0f / (1.0f - abs);
                motionController10.mStaggerOffset = abs - (((f10 - f8) * abs) / (f7 - f8));
                i5++;
            }
        }
    }

    /* access modifiers changed from: private */
    public Rect toRect(ConstraintWidget constraintWidget) {
        this.mTempRect.top = constraintWidget.getY();
        this.mTempRect.left = constraintWidget.getX();
        Rect rect = this.mTempRect;
        int width = constraintWidget.getWidth();
        Rect rect2 = this.mTempRect;
        rect.right = width + rect2.left;
        int height = constraintWidget.getHeight();
        Rect rect3 = this.mTempRect;
        rect2.bottom = height + rect3.top;
        return rect3;
    }

    private static boolean willJump(float f5, float f6, float f7) {
        if (f5 > 0.0f) {
            float f8 = f5 / f7;
            return f6 + ((f5 * f8) - (((f7 * f8) * f8) / 2.0f)) > 1.0f;
        }
        float f9 = (-f5) / f7;
        return f6 + ((f5 * f9) + (((f7 * f9) * f9) / 2.0f)) < 0.0f;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new CopyOnWriteArrayList<>();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    /* access modifiers changed from: package-private */
    public void animateTo(float f5) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            float f6 = this.mTransitionLastPosition;
            float f7 = this.mTransitionPosition;
            if (f6 != f7 && this.mTransitionInstantly) {
                this.mTransitionLastPosition = f7;
            }
            float f8 = this.mTransitionLastPosition;
            if (f8 != f5) {
                this.mTemporalInterpolator = false;
                this.mTransitionGoalPosition = f5;
                this.mTransitionDuration = ((float) motionScene.getDuration()) / 1000.0f;
                setProgress(this.mTransitionGoalPosition);
                this.mInterpolator = null;
                this.mProgressInterpolator = this.mScene.getInterpolator();
                this.mTransitionInstantly = false;
                this.mAnimationStartTime = getNanoTime();
                this.mInTransition = true;
                this.mTransitionPosition = f8;
                this.mTransitionLastPosition = f8;
                invalidate();
            }
        }
    }

    public boolean applyViewTransition(int i5, MotionController motionController) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            return motionScene.applyViewTransition(i5, motionController);
        }
        return false;
    }

    public ConstraintSet cloneConstraintSet(int i5) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        ConstraintSet constraintSet = motionScene.getConstraintSet(i5);
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(constraintSet);
        return constraintSet2;
    }

    /* access modifiers changed from: package-private */
    public void disableAutoTransition(boolean z4) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.disableAutoTransition(z4);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        String str;
        ViewTransitionController viewTransitionController;
        ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
        int i5 = 0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                MotionHelper motionHelper = arrayList.get(i6);
                i6++;
                motionHelper.onPreDraw(canvas);
            }
        }
        evaluate(false);
        MotionScene motionScene = this.mScene;
        if (!(motionScene == null || (viewTransitionController = motionScene.mViewTransitionController) == null)) {
            viewTransitionController.animate();
        }
        super.dispatchDraw(canvas);
        if (this.mScene != null) {
            if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
                this.mFrames++;
                long nanoTime = getNanoTime();
                long j5 = this.mLastDrawTime;
                if (j5 != -1) {
                    long j6 = nanoTime - j5;
                    if (j6 > 200000000) {
                        this.mLastFps = ((float) ((int) ((((float) this.mFrames) / (((float) j6) * 1.0E-9f)) * 100.0f))) / 100.0f;
                        this.mFrames = 0;
                        this.mLastDrawTime = nanoTime;
                    }
                } else {
                    this.mLastDrawTime = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder sb = new StringBuilder();
                sb.append(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ");
                sb.append(Debug.getState(this, this.mEndState));
                sb.append(" (progress: ");
                sb.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                sb.append(" ) state=");
                int i7 = this.mCurrentState;
                if (i7 == -1) {
                    str = "undefined";
                } else {
                    str = Debug.getState(this, i7);
                }
                sb.append(str);
                String sb2 = sb.toString();
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                canvas.drawText(sb2, 11.0f, (float) (getHeight() - 29), paint);
                paint.setColor(-7864184);
                canvas.drawText(sb2, 10.0f, (float) (getHeight() - 30), paint);
            }
            if (this.mDebugPath > 1) {
                if (this.mDevModeDraw == null) {
                    this.mDevModeDraw = new DevModeDraw();
                }
                this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
            }
            ArrayList<MotionHelper> arrayList2 = this.mDecoratorsHelpers;
            if (arrayList2 != null) {
                int size2 = arrayList2.size();
                while (i5 < size2) {
                    MotionHelper motionHelper2 = arrayList2.get(i5);
                    i5++;
                    motionHelper2.onPostDraw(canvas);
                }
            }
        }
    }

    public void enableTransition(int i5, boolean z4) {
        MotionScene.Transition transition = getTransition(i5);
        if (z4) {
            transition.setEnabled(true);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (transition == motionScene.mCurrentTransition) {
            Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.mCurrentState).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.mScene.mCurrentTransition = next;
                    break;
                }
            }
        }
        transition.setEnabled(false);
    }

    public void enableViewTransition(int i5, boolean z4) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.enableViewTransition(i5, z4);
        }
    }

    /* access modifiers changed from: package-private */
    public void endTrigger(boolean z4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            MotionController motionController = this.mFrameArrayList.get(getChildAt(i5));
            if (motionController != null) {
                motionController.endTrigger(z4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0205 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0118 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluate(boolean r21) {
        /*
            r20 = this;
            r0 = r20
            long r1 = r0.mTransitionLastTime
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0010
            long r1 = r0.getNanoTime()
            r0.mTransitionLastTime = r1
        L_0x0010:
            float r1 = r0.mTransitionLastPosition
            r2 = 0
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r4 = -1
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r3 <= 0) goto L_0x0020
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0020
            r0.mCurrentState = r4
        L_0x0020:
            boolean r3 = r0.mKeepAnimating
            r6 = 1
            r7 = 0
            if (r3 != 0) goto L_0x0032
            boolean r3 = r0.mInTransition
            if (r3 == 0) goto L_0x0235
            if (r21 != 0) goto L_0x0032
            float r3 = r0.mTransitionGoalPosition
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0235
        L_0x0032:
            float r3 = r0.mTransitionGoalPosition
            float r3 = r3 - r1
            float r1 = java.lang.Math.signum(r3)
            long r8 = r0.getNanoTime()
            android.view.animation.Interpolator r3 = r0.mInterpolator
            boolean r10 = r3 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            r11 = 814313567(0x3089705f, float:1.0E-9)
            if (r10 != 0) goto L_0x0051
            long r12 = r0.mTransitionLastTime
            long r12 = r8 - r12
            float r10 = (float) r12
            float r10 = r10 * r1
            float r10 = r10 * r11
            float r12 = r0.mTransitionDuration
            float r10 = r10 / r12
            goto L_0x0052
        L_0x0051:
            r10 = r2
        L_0x0052:
            float r12 = r0.mTransitionLastPosition
            float r12 = r12 + r10
            boolean r13 = r0.mTransitionInstantly
            if (r13 == 0) goto L_0x005b
            float r12 = r0.mTransitionGoalPosition
        L_0x005b:
            int r13 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x0065
            float r14 = r0.mTransitionGoalPosition
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x006f
        L_0x0065:
            int r14 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
            float r14 = r0.mTransitionGoalPosition
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
        L_0x006f:
            float r12 = r0.mTransitionGoalPosition
            r0.mInTransition = r7
            r14 = r6
            goto L_0x0076
        L_0x0075:
            r14 = r7
        L_0x0076:
            r0.mTransitionLastPosition = r12
            r0.mTransitionPosition = r12
            r0.mTransitionLastTime = r8
            r15 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r3 == 0) goto L_0x0104
            if (r14 != 0) goto L_0x0104
            boolean r14 = r0.mTemporalInterpolator
            if (r14 == 0) goto L_0x00e4
            r21 = r11
            long r11 = r0.mAnimationStartTime
            long r11 = r8 - r11
            float r10 = (float) r11
            float r10 = r10 * r21
            float r3 = r3.getInterpolation(r10)
            android.view.animation.Interpolator r10 = r0.mInterpolator
            androidx.constraintlayout.motion.utils.StopLogic r11 = r0.mStopLogic
            r12 = 2
            if (r10 != r11) goto L_0x00a5
            boolean r10 = r11.isStopped()
            if (r10 == 0) goto L_0x00a3
            r10 = r12
            goto L_0x00a6
        L_0x00a3:
            r10 = r6
            goto L_0x00a6
        L_0x00a5:
            r10 = r7
        L_0x00a6:
            r0.mTransitionLastPosition = r3
            r0.mTransitionLastTime = r8
            android.view.animation.Interpolator r8 = r0.mInterpolator
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r9 == 0) goto L_0x00e2
            androidx.constraintlayout.motion.widget.MotionInterpolator r8 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r8
            float r8 = r8.getVelocity()
            r0.mLastVelocity = r8
            float r9 = java.lang.Math.abs(r8)
            float r11 = r0.mTransitionDuration
            float r9 = r9 * r11
            int r9 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r9 > 0) goto L_0x00c7
            if (r10 != r12) goto L_0x00c7
            r0.mInTransition = r7
        L_0x00c7:
            int r9 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x00d4
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 < 0) goto L_0x00d4
            r0.mTransitionLastPosition = r5
            r0.mInTransition = r7
            r3 = r5
        L_0x00d4:
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x00e2
            int r8 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r8 > 0) goto L_0x00e2
            r0.mTransitionLastPosition = r2
            r0.mInTransition = r7
            r12 = r2
            goto L_0x0107
        L_0x00e2:
            r12 = r3
            goto L_0x0107
        L_0x00e4:
            float r3 = r3.getInterpolation(r12)
            android.view.animation.Interpolator r8 = r0.mInterpolator
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r9 == 0) goto L_0x00f7
            androidx.constraintlayout.motion.widget.MotionInterpolator r8 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r8
            float r8 = r8.getVelocity()
            r0.mLastVelocity = r8
            goto L_0x0101
        L_0x00f7:
            float r12 = r12 + r10
            float r8 = r8.getInterpolation(r12)
            float r8 = r8 - r3
            float r8 = r8 * r1
            float r8 = r8 / r10
            r0.mLastVelocity = r8
        L_0x0101:
            r12 = r3
        L_0x0102:
            r10 = r7
            goto L_0x0107
        L_0x0104:
            r0.mLastVelocity = r10
            goto L_0x0102
        L_0x0107:
            float r3 = r0.mLastVelocity
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r3 <= 0) goto L_0x0116
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r0.setState(r3)
        L_0x0116:
            if (r10 == r6) goto L_0x013d
            if (r13 <= 0) goto L_0x0120
            float r3 = r0.mTransitionGoalPosition
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x012a
        L_0x0120:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x012e
            float r3 = r0.mTransitionGoalPosition
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x012e
        L_0x012a:
            float r12 = r0.mTransitionGoalPosition
            r0.mInTransition = r7
        L_0x012e:
            int r3 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0136
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x013d
        L_0x0136:
            r0.mInTransition = r7
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
        L_0x013d:
            int r3 = r0.getChildCount()
            r0.mKeepAnimating = r7
            long r17 = r0.getNanoTime()
            r0.mPostInterpolationPosition = r12
            android.view.animation.Interpolator r8 = r0.mProgressInterpolator
            if (r8 != 0) goto L_0x0150
            r16 = r12
            goto L_0x0156
        L_0x0150:
            float r8 = r8.getInterpolation(r12)
            r16 = r8
        L_0x0156:
            android.view.animation.Interpolator r8 = r0.mProgressInterpolator
            if (r8 == 0) goto L_0x016e
            float r9 = r0.mTransitionDuration
            float r9 = r1 / r9
            float r9 = r9 + r12
            float r8 = r8.getInterpolation(r9)
            r0.mLastVelocity = r8
            android.view.animation.Interpolator r9 = r0.mProgressInterpolator
            float r9 = r9.getInterpolation(r12)
            float r8 = r8 - r9
            r0.mLastVelocity = r8
        L_0x016e:
            r8 = r7
        L_0x016f:
            if (r8 >= r3) goto L_0x0190
            android.view.View r15 = r0.getChildAt(r8)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r9 = r0.mFrameArrayList
            java.lang.Object r9 = r9.get(r15)
            r14 = r9
            androidx.constraintlayout.motion.widget.MotionController r14 = (androidx.constraintlayout.motion.widget.MotionController) r14
            if (r14 == 0) goto L_0x018d
            boolean r9 = r0.mKeepAnimating
            androidx.constraintlayout.core.motion.utils.KeyCache r10 = r0.mKeyCache
            r19 = r10
            boolean r10 = r14.interpolate(r15, r16, r17, r19)
            r9 = r9 | r10
            r0.mKeepAnimating = r9
        L_0x018d:
            int r8 = r8 + 1
            goto L_0x016f
        L_0x0190:
            if (r13 <= 0) goto L_0x0198
            float r3 = r0.mTransitionGoalPosition
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x01a2
        L_0x0198:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x01a4
            float r3 = r0.mTransitionGoalPosition
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x01a4
        L_0x01a2:
            r3 = r6
            goto L_0x01a5
        L_0x01a4:
            r3 = r7
        L_0x01a5:
            boolean r8 = r0.mKeepAnimating
            if (r8 != 0) goto L_0x01b4
            boolean r8 = r0.mInTransition
            if (r8 != 0) goto L_0x01b4
            if (r3 == 0) goto L_0x01b4
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r8 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r8)
        L_0x01b4:
            boolean r8 = r0.mMeasureDuringTransition
            if (r8 == 0) goto L_0x01bb
            r0.requestLayout()
        L_0x01bb:
            boolean r8 = r0.mKeepAnimating
            r3 = r3 ^ r6
            r3 = r3 | r8
            r0.mKeepAnimating = r3
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x01de
            int r3 = r0.mBeginState
            if (r3 == r4) goto L_0x01de
            int r4 = r0.mCurrentState
            if (r4 == r3) goto L_0x01de
            r0.mCurrentState = r3
            androidx.constraintlayout.motion.widget.MotionScene r4 = r0.mScene
            androidx.constraintlayout.widget.ConstraintSet r3 = r4.getConstraintSet(r3)
            r3.applyCustomAttributes(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            r7 = r6
        L_0x01de:
            double r3 = (double) r12
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x01fc
            int r3 = r0.mCurrentState
            int r4 = r0.mEndState
            if (r3 == r4) goto L_0x01fc
            r0.mCurrentState = r4
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            androidx.constraintlayout.widget.ConstraintSet r3 = r3.getConstraintSet(r4)
            r3.applyCustomAttributes(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            r7 = r6
        L_0x01fc:
            boolean r3 = r0.mKeepAnimating
            if (r3 != 0) goto L_0x0219
            boolean r3 = r0.mInTransition
            if (r3 == 0) goto L_0x0205
            goto L_0x0219
        L_0x0205:
            if (r13 <= 0) goto L_0x020b
            int r3 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0213
        L_0x020b:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x021c
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x021c
        L_0x0213:
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            goto L_0x021c
        L_0x0219:
            r0.invalidate()
        L_0x021c:
            boolean r3 = r0.mKeepAnimating
            if (r3 != 0) goto L_0x0235
            boolean r3 = r0.mInTransition
            if (r3 != 0) goto L_0x0235
            if (r13 <= 0) goto L_0x022a
            int r3 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0232
        L_0x022a:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0235
            int r1 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0235
        L_0x0232:
            r0.onNewStateAttachHandlers()
        L_0x0235:
            float r1 = r0.mTransitionLastPosition
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0247
            int r1 = r0.mCurrentState
            int r2 = r0.mEndState
            if (r1 == r2) goto L_0x0242
            goto L_0x0243
        L_0x0242:
            r6 = r7
        L_0x0243:
            r0.mCurrentState = r2
        L_0x0245:
            r7 = r6
            goto L_0x0256
        L_0x0247:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0256
            int r1 = r0.mCurrentState
            int r2 = r0.mBeginState
            if (r1 == r2) goto L_0x0252
            goto L_0x0253
        L_0x0252:
            r6 = r7
        L_0x0253:
            r0.mCurrentState = r2
            goto L_0x0245
        L_0x0256:
            boolean r1 = r0.mNeedsFireTransitionCompleted
            r1 = r1 | r7
            r0.mNeedsFireTransitionCompleted = r1
            if (r7 == 0) goto L_0x0264
            boolean r1 = r0.mInLayout
            if (r1 != 0) goto L_0x0264
            r0.requestLayout()
        L_0x0264:
            float r1 = r0.mTransitionLastPosition
            r0.mTransitionPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.evaluate(boolean):void");
    }

    /* access modifiers changed from: protected */
    public void fireTransitionCompleted() {
        int i5;
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (!this.mTransitionCompleted.isEmpty()) {
                ArrayList<Integer> arrayList = this.mTransitionCompleted;
                i5 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i5 = -1;
            }
            int i6 = this.mCurrentState;
            if (!(i5 == i6 || i6 == -1)) {
                this.mTransitionCompleted.add(Integer.valueOf(i6));
            }
        }
        processTransitionCompleted();
        Runnable runnable = this.mOnComplete;
        if (runnable != null) {
            runnable.run();
            this.mOnComplete = null;
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr != null && this.mScheduledTransitions > 0) {
            transitionToState(iArr[0]);
            int[] iArr2 = this.mScheduledTransitionTo;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.mScheduledTransitions--;
        }
    }

    public void fireTrigger(int i5, boolean z4, float f5) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i5, z4, f5);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i5, z4, f5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void getAnchorDpDt(int i5, float f5, float f6, float f7, float[] fArr) {
        String str;
        HashMap<View, MotionController> hashMap = this.mFrameArrayList;
        View viewById = getViewById(i5);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.getDpDt(f5, f6, f7, fArr);
            float y4 = viewById.getY();
            this.mLastPos = f5;
            this.mLastY = y4;
            return;
        }
        if (viewById == null) {
            str = "" + i5;
        } else {
            str = viewById.getContext().getResources().getResourceName(i5);
        }
        Log.w(TAG, "WARNING could not find view id " + str);
    }

    public ConstraintSet getConstraintSet(int i5) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(i5);
    }

    @IdRes
    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    /* access modifiers changed from: package-private */
    public String getConstraintSetNames(int i5) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i5);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public int[] getMatchingConstraintSetIds(String... strArr) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getMatchingStateLabels(strArr);
    }

    /* access modifiers changed from: package-private */
    public MotionController getMotionController(int i5) {
        return this.mFrameArrayList.get(findViewById(i5));
    }

    /* access modifiers changed from: protected */
    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public MotionScene getScene() {
        return this.mScene;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int i5) {
        return this.mScene.getTransitionById(i5);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mTransitionDuration = ((float) motionScene.getDuration()) / 1000.0f;
        }
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f5, float f6, float[] fArr, int i5) {
        float f7;
        float[] fArr2;
        float f8 = this.mLastVelocity;
        float f9 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float signum = Math.signum(this.mTransitionGoalPosition - f9);
            float interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
            f7 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f8 = (signum * ((interpolation - f7) / EPSILON)) / this.mTransitionDuration;
        } else {
            f7 = f9;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof MotionInterpolator) {
            f8 = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.mFrameArrayList.get(view);
        if ((i5 & 1) == 0) {
            fArr2 = fArr;
            motionController.getPostLayoutDvDp(f7, view.getWidth(), view.getHeight(), f5, f6, fArr2);
        } else {
            fArr2 = fArr;
            motionController.getDpDt(f7, f5, f6, fArr2);
        }
        if (i5 < 2) {
            fArr2[0] = fArr2[0] * f8;
            fArr2[1] = fArr2[1] * f8;
        }
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.mDelayedApply;
    }

    public boolean isInRotation() {
        return this.mInRotation;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public boolean isViewTransitionEnabled(int i5) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            return motionScene.isViewTransitionEnabled(i5);
        }
        return false;
    }

    public void jumpToState(int i5) {
        if (!isAttachedToWindow()) {
            this.mCurrentState = i5;
        }
        if (this.mBeginState == i5) {
            setProgress(0.0f);
        } else if (this.mEndState == i5) {
            setProgress(1.0f);
        } else {
            setTransition(i5, i5);
        }
    }

    public void loadLayoutDescription(int i5) {
        int i6;
        MotionScene.Transition transition;
        if (i5 != 0) {
            try {
                MotionScene motionScene = new MotionScene(getContext(), this, i5);
                this.mScene = motionScene;
                if (this.mCurrentState == -1) {
                    this.mCurrentState = motionScene.getStartId();
                    this.mBeginState = this.mScene.getStartId();
                    this.mEndState = this.mScene.getEndId();
                }
                if (isAttachedToWindow()) {
                    Display display = getDisplay();
                    int i7 = 0;
                    if (display == null) {
                        i6 = 0;
                    } else {
                        i6 = display.getRotation();
                    }
                    this.mPreviouseRotation = i6;
                    MotionScene motionScene2 = this.mScene;
                    if (motionScene2 != null) {
                        ConstraintSet constraintSet = motionScene2.getConstraintSet(this.mCurrentState);
                        this.mScene.readFallback(this);
                        ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            while (i7 < size) {
                                MotionHelper motionHelper = arrayList.get(i7);
                                i7++;
                                motionHelper.onFinishedMotionScene(this);
                            }
                        }
                        if (constraintSet != null) {
                            constraintSet.applyTo(this);
                        }
                        this.mBeginState = this.mCurrentState;
                    }
                    onNewStateAttachHandlers();
                    StateCache stateCache = this.mStateCache;
                    if (stateCache == null) {
                        MotionScene motionScene3 = this.mScene;
                        if (motionScene3 != null && (transition = motionScene3.mCurrentTransition) != null && transition.getAutoTransition() == 4) {
                            transitionToEnd();
                            setState(TransitionState.SETUP);
                            setState(TransitionState.MOVING);
                        }
                    } else if (this.mDelayedApply) {
                        post(new Runnable() {
                            public void run() {
                                MotionLayout.this.mStateCache.apply();
                            }
                        });
                    } else {
                        stateCache.apply();
                    }
                } else {
                    this.mScene = null;
                }
            } catch (Exception e5) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e5);
            } catch (Exception e6) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e6);
            }
        } else {
            this.mScene = null;
        }
    }

    /* access modifiers changed from: package-private */
    public int lookUpConstraintId(String str) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    /* access modifiers changed from: protected */
    public MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i5;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.mPreviouseRotation = display.getRotation();
        }
        MotionScene motionScene = this.mScene;
        if (!(motionScene == null || (i5 = this.mCurrentState) == -1)) {
            ConstraintSet constraintSet = motionScene.getConstraintSet(i5);
            this.mScene.readFallback(this);
            ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
            if (arrayList != null) {
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    MotionHelper motionHelper = arrayList.get(i6);
                    i6++;
                    motionHelper.onFinishedMotionScene(this);
                }
            }
            if (constraintSet != null) {
                constraintSet.applyTo(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        StateCache stateCache = this.mStateCache;
        if (stateCache == null) {
            MotionScene motionScene2 = this.mScene;
            if (motionScene2 != null && (transition = motionScene2.mCurrentTransition) != null && transition.getAutoTransition() == 4) {
                transitionToEnd();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            }
        } else if (this.mDelayedApply) {
            post(new Runnable() {
                public void run() {
                    MotionLayout.this.mStateCache.apply();
                }
            });
        } else {
            stateCache.apply();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchResponse touchResponse;
        int touchRegionId;
        RectF touchRegion;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled) {
            ViewTransitionController viewTransitionController = motionScene.mViewTransitionController;
            if (viewTransitionController != null) {
                viewTransitionController.touchEvent(motionEvent);
            }
            MotionScene.Transition transition = this.mScene.mCurrentTransition;
            if (transition != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (touchRegion = touchResponse.getTouchRegion(this, new RectF())) == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && (touchRegionId = touchResponse.getTouchRegionId()) != -1)) {
                View view = this.mRegionView;
                if (view == null || view.getId() != touchRegionId) {
                    this.mRegionView = findViewById(touchRegionId);
                }
                View view2 = this.mRegionView;
                if (view2 != null) {
                    this.mBoundsCheck.set((float) view2.getLeft(), (float) this.mRegionView.getTop(), (float) this.mRegionView.getRight(), (float) this.mRegionView.getBottom());
                    if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent((float) this.mRegionView.getLeft(), (float) this.mRegionView.getTop(), this.mRegionView, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        MotionLayout motionLayout;
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z4, i5, i6, i7, i8);
                this.mInLayout = false;
                return;
            }
            motionLayout = this;
            int i9 = i7 - i5;
            int i10 = i8 - i6;
            try {
                if (motionLayout.mLastLayoutWidth == i9) {
                    if (motionLayout.mLastLayoutHeight != i10) {
                    }
                    motionLayout.mLastLayoutWidth = i9;
                    motionLayout.mLastLayoutHeight = i10;
                    motionLayout.mOldWidth = i9;
                    motionLayout.mOldHeight = i10;
                    motionLayout.mInLayout = false;
                }
                rebuildScene();
                evaluate(true);
                motionLayout.mLastLayoutWidth = i9;
                motionLayout.mLastLayoutHeight = i10;
                motionLayout.mOldWidth = i9;
                motionLayout.mOldHeight = i10;
                motionLayout.mInLayout = false;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                motionLayout.mInLayout = false;
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            motionLayout = this;
            Throwable th22 = th;
            motionLayout.mInLayout = false;
            throw th22;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        boolean z4;
        if (this.mScene == null) {
            super.onMeasure(i5, i6);
            return;
        }
        boolean z5 = false;
        if (this.mLastWidthMeasureSpec == i5 && this.mLastHeightMeasureSpec == i6) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            onNewStateAttachHandlers();
            processTransitionCompleted();
            z4 = true;
        }
        if (this.mDirtyHierarchy) {
            z4 = true;
        }
        this.mLastWidthMeasureSpec = i5;
        this.mLastHeightMeasureSpec = i6;
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if ((z4 || this.mModel.isNotConfiguredWith(startId, endId)) && this.mBeginState != -1) {
            super.onMeasure(i5, i6);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(startId), this.mScene.getConstraintSet(endId));
            this.mModel.reEvaluateState();
            this.mModel.setMeasuredId(startId, endId);
        } else {
            if (z4) {
                super.onMeasure(i5, i6);
            }
            z5 = true;
        }
        if (this.mMeasureDuringTransition || z5) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int width = this.mLayoutWidget.getWidth() + getPaddingLeft() + getPaddingRight();
            int height = this.mLayoutWidget.getHeight() + paddingTop;
            int i7 = this.mWidthMeasureMode;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                int i8 = this.mStartWrapWidth;
                width = (int) (((float) i8) + (this.mPostInterpolationPosition * ((float) (this.mEndWrapWidth - i8))));
                requestLayout();
            }
            int i9 = this.mHeightMeasureMode;
            if (i9 == Integer.MIN_VALUE || i9 == 0) {
                int i10 = this.mStartWrapHeight;
                height = (int) (((float) i10) + (this.mPostInterpolationPosition * ((float) (this.mEndWrapHeight - i10))));
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        evaluateLayout();
    }

    public boolean onNestedFling(@NonNull View view, float f5, float f6, boolean z4) {
        return false;
    }

    public boolean onNestedPreFling(@NonNull View view, float f5, float f6) {
        return false;
    }

    public void onNestedPreScroll(@NonNull final View view, int i5, int i6, @NonNull int[] iArr, int i7) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (transition = motionScene.mCurrentTransition) != null && transition.isEnabled()) {
            int i8 = -1;
            if (!transition.isEnabled() || (touchResponse = transition.getTouchResponse()) == null || (touchRegionId = touchResponse.getTouchRegionId()) == -1 || view.getId() == touchRegionId) {
                if (motionScene.getMoveWhenScrollAtTop()) {
                    TouchResponse touchResponse2 = transition.getTouchResponse();
                    if (!(touchResponse2 == null || (touchResponse2.getFlags() & 4) == 0)) {
                        i8 = i6;
                    }
                    float f5 = this.mTransitionPosition;
                    if ((f5 == 1.0f || f5 == 0.0f) && view.canScrollVertically(i8)) {
                        return;
                    }
                }
                if (!(transition.getTouchResponse() == null || (transition.getTouchResponse().getFlags() & 1) == 0)) {
                    float progressDirection = motionScene.getProgressDirection((float) i5, (float) i6);
                    float f6 = this.mTransitionLastPosition;
                    if ((f6 <= 0.0f && progressDirection < 0.0f) || (f6 >= 1.0f && progressDirection > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new Runnable() {
                            public void run() {
                                view.setNestedScrollingEnabled(true);
                            }
                        });
                        return;
                    }
                }
                float f7 = this.mTransitionPosition;
                long nanoTime = getNanoTime();
                float f8 = (float) i5;
                this.mScrollTargetDX = f8;
                float f9 = (float) i6;
                this.mScrollTargetDY = f9;
                this.mScrollTargetDT = (float) (((double) (nanoTime - this.mScrollTargetTime)) * 1.0E-9d);
                this.mScrollTargetTime = nanoTime;
                motionScene.processScrollMove(f8, f9);
                if (f7 != this.mTransitionPosition) {
                    iArr[0] = i5;
                    iArr[1] = i6;
                }
                evaluate(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mUndergoingMotion = true;
                }
            }
        }
    }

    public void onNestedScroll(@NonNull View view, int i5, int i6, int i7, int i8, int i9) {
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i5, int i6) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void onNewStateAttachHandlers() {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            if (motionScene.autoTransition(this, this.mCurrentState)) {
                requestLayout();
                return;
            }
            int i5 = this.mCurrentState;
            if (i5 != -1) {
                this.mScene.addOnClickListeners(this, i5);
            }
            if (this.mScene.supportTouch()) {
                this.mScene.setupTouch();
            }
        }
    }

    public void onRtlPropertiesChanged(int i5) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i5, int i6) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.mScene;
        if (motionScene == null || (transition = motionScene.mCurrentTransition) == null || transition.getTouchResponse() == null || (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) {
            return false;
        }
        return true;
    }

    public void onStopNestedScroll(@NonNull View view, int i5) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            float f5 = this.mScrollTargetDT;
            if (f5 != 0.0f) {
                motionScene.processScrollUp(this.mScrollTargetDX / f5, this.mScrollTargetDY / f5);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null || !this.mInteractionEnabled || !motionScene.supportTouch()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.mScene.mCurrentTransition;
        if (transition != null && !transition.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.mScene.processTouchEvent(motionEvent, getCurrentState(), this);
        if (this.mScene.mCurrentTransition.isTransitionFlag(4)) {
            return this.mScene.mCurrentTransition.getTouchResponse().isDragStarted();
        }
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new CopyOnWriteArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.mDecoratorsHelpers == null) {
                    this.mDecoratorsHelpers = new ArrayList<>();
                }
                this.mDecoratorsHelpers.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    /* access modifiers changed from: protected */
    public void parseLayoutDescription(int i5) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(transitionListener);
    }

    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.mMeasureDuringTransition && this.mCurrentState == -1 && (motionScene = this.mScene) != null && (transition = motionScene.mCurrentTransition) != null) {
            int layoutDuringTransition = transition.getLayoutDuringTransition();
            if (layoutDuringTransition != 0) {
                if (layoutDuringTransition == 2) {
                    int childCount = getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        this.mFrameArrayList.get(getChildAt(i5)).remeasure();
                    }
                    return;
                }
            } else {
                return;
            }
        }
        super.requestLayout();
    }

    public void rotateTo(int i5, int i6) {
        int i7 = 1;
        this.mInRotation = true;
        this.mPreRotateWidth = getWidth();
        this.mPreRotateHeight = getHeight();
        int rotation = getDisplay().getRotation();
        if ((rotation + 1) % 4 <= (this.mPreviouseRotation + 1) % 4) {
            i7 = 2;
        }
        this.mRotatMode = i7;
        this.mPreviouseRotation = rotation;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            ViewState viewState = this.mPreRotate.get(childAt);
            if (viewState == null) {
                viewState = new ViewState();
                this.mPreRotate.put(childAt, viewState);
            }
            viewState.getState(childAt);
        }
        this.mBeginState = -1;
        this.mEndState = i5;
        this.mScene.setTransition(-1, i5);
        this.mModel.initFrom(this.mLayoutWidget, (ConstraintSet) null, this.mScene.getConstraintSet(this.mEndState));
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        invalidate();
        transitionToEnd(new Runnable() {
            public void run() {
                boolean unused = MotionLayout.this.mInRotation = false;
            }
        });
        if (i6 > 0) {
            this.mTransitionDuration = ((float) i6) / 1000.0f;
        }
    }

    public void scheduleTransitionTo(int i5) {
        if (getCurrentState() == -1) {
            transitionToState(i5);
            return;
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr == null) {
            this.mScheduledTransitionTo = new int[4];
        } else if (iArr.length <= this.mScheduledTransitions) {
            this.mScheduledTransitionTo = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mScheduledTransitionTo;
        int i6 = this.mScheduledTransitions;
        this.mScheduledTransitions = i6 + 1;
        iArr2[i6] = i5;
    }

    public void setDebugMode(int i5) {
        this.mDebugPath = i5;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z4) {
        this.mDelayedApply = z4;
    }

    public void setInteractionEnabled(boolean z4) {
        this.mInteractionEnabled = z4;
    }

    public void setInterpolatedProgress(float f5) {
        if (this.mScene != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f5));
                return;
            }
        }
        setProgress(f5);
    }

    public void setOnHide(float f5) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.mOnHideHelpers.get(i5).setProgress(f5);
            }
        }
    }

    public void setOnShow(float f5) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.mOnShowHelpers.get(i5).setProgress(f5);
            }
        }
    }

    public void setProgress(float f5, float f6) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f5);
            this.mStateCache.setVelocity(f6);
            return;
        }
        setProgress(f5);
        setState(TransitionState.MOVING);
        this.mLastVelocity = f6;
        float f7 = 0.0f;
        int i5 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
        if (i5 != 0) {
            if (i5 > 0) {
                f7 = 1.0f;
            }
            animateTo(f7);
        } else if (f5 != 0.0f && f5 != 1.0f) {
            if (f5 > 0.5f) {
                f7 = 1.0f;
            }
            animateTo(f7);
        }
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    /* access modifiers changed from: package-private */
    public void setStartState(int i5) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i5);
            this.mStateCache.setEndState(i5);
            return;
        }
        this.mCurrentState = i5;
    }

    /* access modifiers changed from: package-private */
    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState != transitionState2 || this.mCurrentState != -1) {
            TransitionState transitionState3 = this.mTransitionState;
            this.mTransitionState = transitionState;
            TransitionState transitionState4 = TransitionState.MOVING;
            if (transitionState3 == transitionState4 && transitionState == transitionState4) {
                fireTransitionChange();
            }
            int ordinal = transitionState3.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                if (transitionState == transitionState4) {
                    fireTransitionChange();
                }
                if (transitionState == transitionState2) {
                    fireTransitionCompleted();
                }
            } else if (ordinal == 2 && transitionState == transitionState2) {
                fireTransitionCompleted();
            }
        }
    }

    public void setTransition(int i5, int i6) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i5);
            this.mStateCache.setEndState(i6);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mBeginState = i5;
            this.mEndState = i6;
            motionScene.setTransition(i5, i6);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(i5), this.mScene.getConstraintSet(i6));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            transitionToStart();
        }
    }

    public void setTransitionDuration(int i5) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e(TAG, "MotionScene not defined");
        } else {
            motionScene.setDuration(i5);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.apply();
        }
    }

    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r10 != 7) goto L_0x00f6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void touchAnimateTo(int r10, float r11, float r12) {
        /*
            r9 = this;
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.mScene
            if (r0 != 0) goto L_0x0005
            goto L_0x000b
        L_0x0005:
            float r0 = r9.mTransitionLastPosition
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x000c
        L_0x000b:
            return
        L_0x000c:
            r0 = 1
            r9.mTemporalInterpolator = r0
            long r1 = r9.getNanoTime()
            r9.mAnimationStartTime = r1
            androidx.constraintlayout.motion.widget.MotionScene r1 = r9.mScene
            int r1 = r1.getDuration()
            float r1 = (float) r1
            r2 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r2
            r9.mTransitionDuration = r1
            r9.mTransitionGoalPosition = r11
            r9.mInTransition = r0
            r1 = 0
            r2 = 7
            r3 = 6
            r4 = 2
            if (r10 == 0) goto L_0x003b
            if (r10 == r0) goto L_0x003b
            if (r10 == r4) goto L_0x003b
            r5 = 4
            if (r10 == r5) goto L_0x0083
            r5 = 5
            if (r10 == r5) goto L_0x003d
            if (r10 == r3) goto L_0x003b
            if (r10 == r2) goto L_0x003b
            goto L_0x00f6
        L_0x003b:
            r5 = r12
            goto L_0x0096
        L_0x003d:
            float r10 = r9.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.mScene
            float r0 = r0.getMaxAcceleration()
            boolean r10 = willJump(r12, r10, r0)
            if (r10 == 0) goto L_0x005e
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            float r11 = r9.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.mScene
            float r0 = r0.getMaxAcceleration()
            r10.config(r12, r11, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            r9.mInterpolator = r10
            goto L_0x00f6
        L_0x005e:
            androidx.constraintlayout.motion.utils.StopLogic r2 = r9.mStopLogic
            float r3 = r9.mTransitionLastPosition
            float r6 = r9.mTransitionDuration
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r7 = r10.getMaxAcceleration()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r8 = r10.getMaxVelocity()
            r4 = r11
            r5 = r12
            r2.config(r3, r4, r5, r6, r7, r8)
            r9.mLastVelocity = r1
            int r10 = r9.mCurrentState
            r9.mTransitionGoalPosition = r11
            r9.mCurrentState = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.mStopLogic
            r9.mInterpolator = r10
            goto L_0x00f6
        L_0x0083:
            r5 = r12
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            float r11 = r9.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r12 = r9.mScene
            float r12 = r12.getMaxAcceleration()
            r10.config(r5, r11, r12)
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            r9.mInterpolator = r10
            goto L_0x00f6
        L_0x0096:
            if (r10 == r0) goto L_0x00a5
            if (r10 != r2) goto L_0x009b
            goto L_0x00a5
        L_0x009b:
            if (r10 == r4) goto L_0x00a2
            if (r10 != r3) goto L_0x00a0
            goto L_0x00a2
        L_0x00a0:
            r2 = r11
            goto L_0x00a6
        L_0x00a2:
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00a0
        L_0x00a5:
            r2 = r1
        L_0x00a6:
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            int r10 = r10.getAutoCompleteMode()
            if (r10 != 0) goto L_0x00c6
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.mStopLogic
            float r1 = r9.mTransitionLastPosition
            float r4 = r9.mTransitionDuration
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r10 = r10.getMaxAcceleration()
            androidx.constraintlayout.motion.widget.MotionScene r11 = r9.mScene
            float r6 = r11.getMaxVelocity()
            r3 = r5
            r5 = r10
            r0.config(r1, r2, r3, r4, r5, r6)
            goto L_0x00ec
        L_0x00c6:
            r3 = r5
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.mStopLogic
            float r1 = r9.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r4 = r10.getSpringMass()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r5 = r10.getSpringStiffiness()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r6 = r10.getSpringDamping()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r7 = r10.getSpringStopThreshold()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            int r8 = r10.getSpringBoundary()
            r0.springConfig(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x00ec:
            int r10 = r9.mCurrentState
            r9.mTransitionGoalPosition = r2
            r9.mCurrentState = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.mStopLogic
            r9.mInterpolator = r10
        L_0x00f6:
            r10 = 0
            r9.mTransitionInstantly = r10
            long r10 = r9.getNanoTime()
            r9.mAnimationStartTime = r10
            r9.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.touchAnimateTo(int, float, float):void");
    }

    public void touchSpringTo(float f5, float f6) {
        if (this.mScene != null && this.mTransitionLastPosition != f5) {
            this.mTemporalInterpolator = true;
            this.mAnimationStartTime = getNanoTime();
            this.mTransitionDuration = ((float) this.mScene.getDuration()) / 1000.0f;
            this.mTransitionGoalPosition = f5;
            this.mInTransition = true;
            float f7 = f5;
            this.mStopLogic.springConfig(this.mTransitionLastPosition, f7, f6, this.mScene.getSpringMass(), this.mScene.getSpringStiffiness(), this.mScene.getSpringDamping(), this.mScene.getSpringStopThreshold(), this.mScene.getSpringBoundary());
            int i5 = this.mCurrentState;
            this.mTransitionGoalPosition = f7;
            this.mCurrentState = i5;
            this.mInterpolator = this.mStopLogic;
            this.mTransitionInstantly = false;
            this.mAnimationStartTime = getNanoTime();
            invalidate();
        }
    }

    public void transitionToEnd() {
        animateTo(1.0f);
        this.mOnComplete = null;
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int i5) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setEndState(i5);
            return;
        }
        transitionToState(i5, -1, -1);
    }

    public void updateState(int i5, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(i5, constraintSet);
        }
        updateState();
        if (this.mCurrentState == i5) {
            constraintSet.applyTo(this);
        }
    }

    public void updateStateAnimate(int i5, ConstraintSet constraintSet, int i6) {
        if (this.mScene != null && this.mCurrentState == i5) {
            int i7 = R.id.view_transition;
            updateState(i7, getConstraintSet(i5));
            setState(i7, -1, -1);
            updateState(i5, constraintSet);
            MotionScene.Transition transition = new MotionScene.Transition(-1, this.mScene, i7, i5);
            transition.setDuration(i6);
            setTransition(transition);
            transitionToEnd();
        }
    }

    public void viewTransition(int i5, View... viewArr) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.viewTransition(i5, viewArr);
        } else {
            Log.e(TAG, " no motionScene");
        }
    }

    private static class MyTracker implements MotionTracker {
        private static MyTracker sMe = new MyTracker();
        VelocityTracker mTracker;

        private MyTracker() {
        }

        public static MyTracker obtain() {
            sMe.mTracker = VelocityTracker.obtain();
            return sMe;
        }

        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public void clear() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        public void computeCurrentVelocity(int i5) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i5);
            }
        }

        public float getXVelocity() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        public float getYVelocity() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        public void recycle() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mTracker = null;
            }
        }

        public void computeCurrentVelocity(int i5, float f5) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i5, f5);
            }
        }

        public float getXVelocity(int i5) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(i5);
            }
            return 0.0f;
        }

        public float getYVelocity(int i5) {
            if (this.mTracker != null) {
                return getYVelocity(i5);
            }
            return 0.0f;
        }
    }

    public void onNestedScroll(@NonNull View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        if (!(!this.mUndergoingMotion && i5 == 0 && i6 == 0)) {
            iArr[0] = iArr[0] + i7;
            iArr[1] = iArr[1] + i8;
        }
        this.mUndergoingMotion = false;
    }

    public void transitionToStart(Runnable runnable) {
        animateTo(0.0f);
        this.mOnComplete = runnable;
    }

    public void transitionToEnd(Runnable runnable) {
        animateTo(1.0f);
        this.mOnComplete = runnable;
    }

    public void transitionToState(int i5, int i6) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setEndState(i5);
            return;
        }
        transitionToState(i5, -1, -1, i6);
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    public void setState(int i5, int i6, int i7) {
        setState(TransitionState.SETUP);
        this.mCurrentState = i5;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i5, (float) i6, (float) i7);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.getConstraintSet(i5).applyTo(this);
        }
    }

    public void setProgress(float f5) {
        int i5 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
        if (i5 < 0 || f5 > 1.0f) {
            Log.w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f5);
            return;
        }
        if (i5 <= 0) {
            if (this.mTransitionLastPosition == 1.0f && this.mCurrentState == this.mEndState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f5 >= 1.0f) {
            if (this.mTransitionLastPosition == 0.0f && this.mCurrentState == this.mBeginState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(TransitionState.MOVING);
        }
        if (this.mScene != null) {
            this.mTransitionInstantly = true;
            this.mTransitionGoalPosition = f5;
            this.mTransitionPosition = f5;
            this.mTransitionLastTime = -1;
            this.mAnimationStartTime = -1;
            this.mInterpolator = null;
            this.mInTransition = true;
            invalidate();
        }
    }

    public void transitionToState(int i5, int i6, int i7) {
        transitionToState(i5, i6, i7, -1);
    }

    public void transitionToState(int i5, int i6, int i7, int i8) {
        StateSet stateSet;
        int convertToConstraintSet;
        MotionScene motionScene = this.mScene;
        if (!(motionScene == null || (stateSet = motionScene.mStateSet) == null || (convertToConstraintSet = stateSet.convertToConstraintSet(this.mCurrentState, i5, (float) i6, (float) i7)) == -1)) {
            i5 = convertToConstraintSet;
        }
        int i9 = this.mCurrentState;
        if (i9 != i5) {
            if (this.mBeginState == i5) {
                animateTo(0.0f);
                if (i8 > 0) {
                    this.mTransitionDuration = ((float) i8) / 1000.0f;
                }
            } else if (this.mEndState == i5) {
                animateTo(1.0f);
                if (i8 > 0) {
                    this.mTransitionDuration = ((float) i8) / 1000.0f;
                }
            } else {
                this.mEndState = i5;
                if (i9 != -1) {
                    setTransition(i9, i5);
                    animateTo(1.0f);
                    this.mTransitionLastPosition = 0.0f;
                    transitionToEnd();
                    if (i8 > 0) {
                        this.mTransitionDuration = ((float) i8) / 1000.0f;
                        return;
                    }
                    return;
                }
                this.mTemporalInterpolator = false;
                this.mTransitionGoalPosition = 1.0f;
                this.mTransitionPosition = 0.0f;
                this.mTransitionLastPosition = 0.0f;
                this.mTransitionLastTime = getNanoTime();
                this.mAnimationStartTime = getNanoTime();
                this.mTransitionInstantly = false;
                this.mInterpolator = null;
                if (i8 == -1) {
                    this.mTransitionDuration = ((float) this.mScene.getDuration()) / 1000.0f;
                }
                this.mBeginState = -1;
                this.mScene.setTransition(-1, this.mEndState);
                SparseArray sparseArray = new SparseArray();
                if (i8 == 0) {
                    this.mTransitionDuration = ((float) this.mScene.getDuration()) / 1000.0f;
                } else if (i8 > 0) {
                    this.mTransitionDuration = ((float) i8) / 1000.0f;
                }
                int childCount = getChildCount();
                this.mFrameArrayList.clear();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    this.mFrameArrayList.put(childAt, new MotionController(childAt));
                    sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
                }
                this.mInTransition = true;
                this.mModel.initFrom(this.mLayoutWidget, (ConstraintSet) null, this.mScene.getConstraintSet(i5));
                rebuildScene();
                this.mModel.build();
                computeCurrentPositions();
                int width = getWidth();
                int height = getHeight();
                if (this.mDecoratorsHelpers != null) {
                    for (int i11 = 0; i11 < childCount; i11++) {
                        MotionController motionController = this.mFrameArrayList.get(getChildAt(i11));
                        if (motionController != null) {
                            this.mScene.getKeyFrames(motionController);
                        }
                    }
                    ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
                    int size = arrayList.size();
                    int i12 = 0;
                    while (i12 < size) {
                        MotionHelper motionHelper = arrayList.get(i12);
                        i12++;
                        motionHelper.onPreSetup(this, this.mFrameArrayList);
                    }
                    for (int i13 = 0; i13 < childCount; i13++) {
                        MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i13));
                        if (motionController2 != null) {
                            motionController2.setup(width, height, this.mTransitionDuration, getNanoTime());
                        }
                    }
                } else {
                    for (int i14 = 0; i14 < childCount; i14++) {
                        MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i14));
                        if (motionController3 != null) {
                            this.mScene.getKeyFrames(motionController3);
                            motionController3.setup(width, height, this.mTransitionDuration, getNanoTime());
                        }
                    }
                }
                float staggered = this.mScene.getStaggered();
                if (staggered != 0.0f) {
                    float f5 = Float.MAX_VALUE;
                    float f6 = -3.4028235E38f;
                    for (int i15 = 0; i15 < childCount; i15++) {
                        MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i15));
                        float finalY = motionController4.getFinalY() + motionController4.getFinalX();
                        f5 = Math.min(f5, finalY);
                        f6 = Math.max(f6, finalY);
                    }
                    for (int i16 = 0; i16 < childCount; i16++) {
                        MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i16));
                        float finalX = motionController5.getFinalX();
                        float finalY2 = motionController5.getFinalY();
                        motionController5.mStaggerScale = 1.0f / (1.0f - staggered);
                        motionController5.mStaggerOffset = staggered - ((((finalX + finalY2) - f5) * staggered) / (f6 - f5));
                    }
                }
                this.mTransitionPosition = 0.0f;
                this.mTransitionLastPosition = 0.0f;
                this.mInTransition = true;
                invalidate();
            }
        }
    }

    public void setTransition(int i5) {
        float f5;
        if (this.mScene != null) {
            MotionScene.Transition transition = getTransition(i5);
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache();
                }
                this.mStateCache.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            int i6 = this.mCurrentState;
            float f6 = 0.0f;
            if (i6 == this.mBeginState) {
                f5 = 0.0f;
            } else {
                f5 = i6 == this.mEndState ? 1.0f : Float.NaN;
            }
            this.mScene.setTransition(transition);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            if (this.mTransitionLastPosition != f5) {
                if (f5 == 0.0f) {
                    endTrigger(true);
                    this.mScene.getConstraintSet(this.mBeginState).applyTo(this);
                } else if (f5 == 1.0f) {
                    endTrigger(false);
                    this.mScene.getConstraintSet(this.mEndState).applyTo(this);
                }
            }
            if (!Float.isNaN(f5)) {
                f6 = f5;
            }
            this.mTransitionLastPosition = f6;
            if (Float.isNaN(f5)) {
                Log.v(TAG, Debug.getLocation() + " transitionToStart ");
                transitionToStart();
                return;
            }
            setProgress(f5);
        }
    }

    private void checkStructure(int i5, ConstraintSet constraintSet) {
        String name = Debug.getName(getContext(), i5);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int id = childAt.getId();
            if (id == -1) {
                Log.w(TAG, "CHECK: " + name + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (constraintSet.getConstraint(id) == null) {
                Log.w(TAG, "CHECK: " + name + " NO CONSTRAINTS for " + Debug.getName(childAt));
            }
        }
        int[] knownIds = constraintSet.getKnownIds();
        for (int i7 = 0; i7 < knownIds.length; i7++) {
            int i8 = knownIds[i7];
            String name2 = Debug.getName(getContext(), i8);
            if (findViewById(knownIds[i7]) == null) {
                Log.w(TAG, "CHECK: " + name + " NO View matches id " + name2);
            }
            if (constraintSet.getHeight(i8) == -1) {
                Log.w(TAG, "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
            }
            if (constraintSet.getWidth(i8) == -1) {
                Log.w(TAG, "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setTransition(MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        setState(TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1 : getNanoTime();
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if (startId != this.mBeginState || endId != this.mEndState) {
            this.mBeginState = startId;
            this.mEndState = endId;
            this.mScene.setTransition(startId, endId);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
            this.mModel.reEvaluateState();
            rebuildScene();
        }
    }

    private void checkStructure(MotionScene.Transition transition) {
        if (transition.getStartConstraintSetId() == transition.getEndConstraintSetId()) {
            Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        init(attributeSet);
    }
}
