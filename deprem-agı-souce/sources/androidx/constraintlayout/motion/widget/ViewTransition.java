package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class ViewTransition {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    public static final String CONSTRAINT_OVERRIDE = "ConstraintOverride";
    public static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    public static final String CUSTOM_METHOD = "CustomMethod";
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    public static final String KEY_FRAME_SET_TAG = "KeyFrameSet";
    static final int LINEAR = 3;
    public static final int ONSTATE_ACTION_DOWN = 1;
    public static final int ONSTATE_ACTION_DOWN_UP = 3;
    public static final int ONSTATE_ACTION_UP = 2;
    public static final int ONSTATE_SHARED_VALUE_SET = 4;
    public static final int ONSTATE_SHARED_VALUE_UNSET = 5;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "ViewTransition";
    private static final int UNSET = -1;
    static final int VIEWTRANSITIONMODE_ALLSTATES = 1;
    static final int VIEWTRANSITIONMODE_CURRENTSTATE = 0;
    static final int VIEWTRANSITIONMODE_NOSTATE = 2;
    public static final String VIEW_TRANSITION_TAG = "ViewTransition";
    private int mClearsTag = -1;
    ConstraintSet.Constraint mConstraintDelta;
    Context mContext;
    private int mDefaultInterpolator = 0;
    private int mDefaultInterpolatorID = -1;
    private String mDefaultInterpolatorString = null;
    private boolean mDisabled = false;
    private int mDuration = -1;
    private int mId;
    private int mIfTagNotSet = -1;
    private int mIfTagSet = -1;
    KeyFrames mKeyFrames;
    private int mOnStateTransition = -1;
    private int mPathMotionArc = 0;
    ConstraintSet mSet;
    private int mSetsTag = -1;
    private int mSharedValueCurrent = -1;
    private int mSharedValueID = -1;
    private int mSharedValueTarget = -1;
    private int mTargetId;
    private String mTargetString;
    private int mUpDuration = -1;
    int mViewTransitionMode;

    static class Animate {
        KeyCache mCache = new KeyCache();
        private final int mClearsTag;
        float mDpositionDt;
        int mDuration;
        boolean mHoldAt100 = false;
        Interpolator mInterpolator;
        long mLastRender;
        MotionController mMC;
        float mPosition;
        boolean mReverse = false;
        private final int mSetsTag;
        long mStart;
        Rect mTempRec = new Rect();
        int mUpDuration;
        ViewTransitionController mVtController;

        Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i5, int i6, int i7, Interpolator interpolator, int i8, int i9) {
            float f5;
            this.mVtController = viewTransitionController;
            this.mMC = motionController;
            this.mDuration = i5;
            this.mUpDuration = i6;
            long nanoTime = System.nanoTime();
            this.mStart = nanoTime;
            this.mLastRender = nanoTime;
            this.mVtController.addAnimation(this);
            this.mInterpolator = interpolator;
            this.mSetsTag = i8;
            this.mClearsTag = i9;
            if (i7 == 3) {
                this.mHoldAt100 = true;
            }
            if (i5 == 0) {
                f5 = Float.MAX_VALUE;
            } else {
                f5 = 1.0f / ((float) i5);
            }
            this.mDpositionDt = f5;
            mutate();
        }

        /* access modifiers changed from: package-private */
        public void mutate() {
            if (this.mReverse) {
                mutateReverse();
            } else {
                mutateForward();
            }
        }

        /* access modifiers changed from: package-private */
        public void mutateForward() {
            float interpolation;
            long nanoTime = System.nanoTime();
            this.mLastRender = nanoTime;
            float f5 = this.mPosition + (((float) (((double) (nanoTime - this.mLastRender)) * 1.0E-6d)) * this.mDpositionDt);
            this.mPosition = f5;
            if (f5 >= 1.0f) {
                this.mPosition = 1.0f;
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator == null) {
                interpolation = this.mPosition;
            } else {
                interpolation = interpolator.getInterpolation(this.mPosition);
            }
            float f6 = interpolation;
            MotionController motionController = this.mMC;
            boolean interpolate = motionController.interpolate(motionController.mView, f6, nanoTime, this.mCache);
            if (this.mPosition >= 1.0f) {
                if (this.mSetsTag != -1) {
                    this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
                }
                if (this.mClearsTag != -1) {
                    this.mMC.getView().setTag(this.mClearsTag, (Object) null);
                }
                if (!this.mHoldAt100) {
                    this.mVtController.removeAnimation(this);
                }
            }
            if (this.mPosition < 1.0f || interpolate) {
                this.mVtController.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public void mutateReverse() {
            float interpolation;
            long nanoTime = System.nanoTime();
            this.mLastRender = nanoTime;
            float f5 = this.mPosition - (((float) (((double) (nanoTime - this.mLastRender)) * 1.0E-6d)) * this.mDpositionDt);
            this.mPosition = f5;
            if (f5 < 0.0f) {
                this.mPosition = 0.0f;
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator == null) {
                interpolation = this.mPosition;
            } else {
                interpolation = interpolator.getInterpolation(this.mPosition);
            }
            float f6 = interpolation;
            MotionController motionController = this.mMC;
            boolean interpolate = motionController.interpolate(motionController.mView, f6, nanoTime, this.mCache);
            if (this.mPosition <= 0.0f) {
                if (this.mSetsTag != -1) {
                    this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
                }
                if (this.mClearsTag != -1) {
                    this.mMC.getView().setTag(this.mClearsTag, (Object) null);
                }
                this.mVtController.removeAnimation(this);
            }
            if (this.mPosition > 0.0f || interpolate) {
                this.mVtController.invalidate();
            }
        }

        public void reactTo(int i5, float f5, float f6) {
            if (i5 != 1) {
                if (i5 == 2) {
                    this.mMC.getView().getHitRect(this.mTempRec);
                    if (!this.mTempRec.contains((int) f5, (int) f6) && !this.mReverse) {
                        reverse(true);
                    }
                }
            } else if (!this.mReverse) {
                reverse(true);
            }
        }

        /* access modifiers changed from: package-private */
        public void reverse(boolean z4) {
            int i5;
            float f5;
            this.mReverse = z4;
            if (z4 && (i5 = this.mUpDuration) != -1) {
                if (i5 == 0) {
                    f5 = Float.MAX_VALUE;
                } else {
                    f5 = 1.0f / ((float) i5);
                }
                this.mDpositionDt = f5;
            }
            this.mVtController.invalidate();
            this.mLastRender = System.nanoTime();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    ViewTransition(android.content.Context r11, org.xmlpull.v1.XmlPullParser r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Error parsing XML resource"
            java.lang.String r1 = "ViewTransition"
            r10.<init>()
            r2 = -1
            r10.mOnStateTransition = r2
            r3 = 0
            r10.mDisabled = r3
            r10.mPathMotionArc = r3
            r10.mDuration = r2
            r10.mUpDuration = r2
            r10.mDefaultInterpolator = r3
            r4 = 0
            r10.mDefaultInterpolatorString = r4
            r10.mDefaultInterpolatorID = r2
            r10.mSetsTag = r2
            r10.mClearsTag = r2
            r10.mIfTagSet = r2
            r10.mIfTagNotSet = r2
            r10.mSharedValueTarget = r2
            r10.mSharedValueID = r2
            r10.mSharedValueCurrent = r2
            r10.mContext = r11
            int r4 = r12.getEventType()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
        L_0x002e:
            r5 = 1
            if (r4 == r5) goto L_0x00ee
            r6 = 3
            r7 = 2
            if (r4 == r7) goto L_0x004b
            if (r4 == r6) goto L_0x0039
            goto L_0x00e1
        L_0x0039:
            java.lang.String r4 = r12.getName()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            boolean r4 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            if (r4 == 0) goto L_0x00e1
            goto L_0x00ee
        L_0x0045:
            r11 = move-exception
            goto L_0x00e7
        L_0x0048:
            r11 = move-exception
            goto L_0x00eb
        L_0x004b:
            java.lang.String r4 = r12.getName()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            int r8 = r4.hashCode()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            r9 = 4
            switch(r8) {
                case -1962203927: goto L_0x007e;
                case -1239391468: goto L_0x0074;
                case 61998586: goto L_0x006c;
                case 366511058: goto L_0x0062;
                case 1791837707: goto L_0x0058;
                default: goto L_0x0057;
            }     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
        L_0x0057:
            goto L_0x0088
        L_0x0058:
            java.lang.String r8 = "CustomAttribute"
            boolean r8 = r4.equals(r8)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            if (r8 == 0) goto L_0x0088
            r8 = r6
            goto L_0x0089
        L_0x0062:
            java.lang.String r8 = "CustomMethod"
            boolean r8 = r4.equals(r8)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            if (r8 == 0) goto L_0x0088
            r8 = r9
            goto L_0x0089
        L_0x006c:
            boolean r8 = r4.equals(r1)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            if (r8 == 0) goto L_0x0088
            r8 = r3
            goto L_0x0089
        L_0x0074:
            java.lang.String r8 = "KeyFrameSet"
            boolean r8 = r4.equals(r8)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            if (r8 == 0) goto L_0x0088
            r8 = r5
            goto L_0x0089
        L_0x007e:
            java.lang.String r8 = "ConstraintOverride"
            boolean r8 = r4.equals(r8)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            if (r8 == 0) goto L_0x0088
            r8 = r7
            goto L_0x0089
        L_0x0088:
            r8 = r2
        L_0x0089:
            if (r8 == 0) goto L_0x00de
            if (r8 == r5) goto L_0x00d6
            if (r8 == r7) goto L_0x00cf
            if (r8 == r6) goto L_0x00c7
            if (r8 == r9) goto L_0x00c7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            java.lang.String r6 = androidx.constraintlayout.motion.widget.Debug.getLoc()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            r5.append(r6)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            java.lang.String r6 = " unknown tag "
            r5.append(r6)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            java.lang.String r4 = r5.toString()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            android.util.Log.e(r1, r4)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            java.lang.String r5 = ".xml:"
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            int r5 = r12.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            java.lang.String r4 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            android.util.Log.e(r1, r4)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            goto L_0x00e1
        L_0x00c7:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r4 = r10.mConstraintDelta     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r4 = r4.mCustomConstraints     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r11, r12, r4)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            goto L_0x00e1
        L_0x00cf:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r4 = androidx.constraintlayout.widget.ConstraintSet.buildDelta(r11, r12)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            r10.mConstraintDelta = r4     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            goto L_0x00e1
        L_0x00d6:
            androidx.constraintlayout.motion.widget.KeyFrames r4 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            r4.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            r10.mKeyFrames = r4     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            goto L_0x00e1
        L_0x00de:
            r10.parseViewTransitionTags(r11, r12)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
        L_0x00e1:
            int r4 = r12.next()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0045 }
            goto L_0x002e
        L_0x00e7:
            android.util.Log.e(r1, r0, r11)
            goto L_0x00ee
        L_0x00eb:
            android.util.Log.e(r1, r0, r11)
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public static /* synthetic */ void a(ViewTransition viewTransition, View[] viewArr) {
        if (viewTransition.mSetsTag != -1) {
            for (View tag : viewArr) {
                tag.setTag(viewTransition.mSetsTag, Long.valueOf(System.nanoTime()));
            }
        }
        if (viewTransition.mClearsTag != -1) {
            for (View tag2 : viewArr) {
                tag2.setTag(viewTransition.mClearsTag, (Object) null);
            }
        }
    }

    private void parseViewTransitionTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            if (index == R.styleable.ViewTransition_android_id) {
                this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    this.mTargetId = resourceId;
                    if (resourceId == -1) {
                        this.mTargetString = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.mTargetString = obtainStyledAttributes.getString(index);
                } else {
                    this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.mOnStateTransition = obtainStyledAttributes.getInt(index, this.mOnStateTransition);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.mDisabled = obtainStyledAttributes.getBoolean(index, this.mDisabled);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.mDuration = obtainStyledAttributes.getInt(index, this.mDuration);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.mUpDuration = obtainStyledAttributes.getInt(index, this.mUpDuration);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.mViewTransitionMode = obtainStyledAttributes.getInt(index, this.mViewTransitionMode);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                int i6 = obtainStyledAttributes.peekValue(index).type;
                if (i6 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.mDefaultInterpolatorID = resourceId2;
                    if (resourceId2 != -1) {
                        this.mDefaultInterpolator = -2;
                    }
                } else if (i6 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mDefaultInterpolatorString = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.mDefaultInterpolator = -1;
                    } else {
                        this.mDefaultInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                        this.mDefaultInterpolator = -2;
                    }
                } else {
                    this.mDefaultInterpolator = obtainStyledAttributes.getInteger(index, this.mDefaultInterpolator);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.mSetsTag = obtainStyledAttributes.getResourceId(index, this.mSetsTag);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.mClearsTag = obtainStyledAttributes.getResourceId(index, this.mClearsTag);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.mIfTagSet = obtainStyledAttributes.getResourceId(index, this.mIfTagSet);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.mIfTagNotSet = obtainStyledAttributes.getResourceId(index, this.mIfTagNotSet);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.mSharedValueID = obtainStyledAttributes.getResourceId(index, this.mSharedValueID);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.mSharedValueTarget = obtainStyledAttributes.getInteger(index, this.mSharedValueTarget);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void updateTransition(MotionScene.Transition transition, View view) {
        int i5 = this.mDuration;
        if (i5 != -1) {
            transition.setDuration(i5);
        }
        transition.setPathMotionArc(this.mPathMotionArc);
        transition.setInterpolatorInfo(this.mDefaultInterpolator, this.mDefaultInterpolatorString, this.mDefaultInterpolatorID);
        int id = view.getId();
        KeyFrames keyFrames = this.mKeyFrames;
        if (keyFrames != null) {
            ArrayList<Key> keyFramesForView = keyFrames.getKeyFramesForView(-1);
            KeyFrames keyFrames2 = new KeyFrames();
            int size = keyFramesForView.size();
            int i6 = 0;
            while (i6 < size) {
                Key key = keyFramesForView.get(i6);
                i6++;
                keyFrames2.addKey(key.clone().setViewId(id));
            }
            transition.addKeyFrame(keyFrames2);
        }
    }

    /* access modifiers changed from: package-private */
    public void applyIndependentTransition(ViewTransitionController viewTransitionController, MotionLayout motionLayout, View view) {
        MotionController motionController = new MotionController(view);
        motionController.setBothStates(view);
        this.mKeyFrames.addAllFrames(motionController);
        motionController.setup(motionLayout.getWidth(), motionLayout.getHeight(), (float) this.mDuration, System.nanoTime());
        new Animate(viewTransitionController, motionController, this.mDuration, this.mUpDuration, this.mOnStateTransition, getInterpolator(motionLayout.getContext()), this.mSetsTag, this.mClearsTag);
    }

    /* access modifiers changed from: package-private */
    public void applyTransition(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i5, ConstraintSet constraintSet, View... viewArr) {
        if (!this.mDisabled) {
            int i6 = this.mViewTransitionMode;
            if (i6 == 2) {
                applyIndependentTransition(viewTransitionController, motionLayout, viewArr[0]);
                return;
            }
            if (i6 == 1) {
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                for (int i7 : constraintSetIds) {
                    if (i7 != i5) {
                        ConstraintSet constraintSet2 = motionLayout.getConstraintSet(i7);
                        for (View id : viewArr) {
                            ConstraintSet.Constraint constraint = constraintSet2.getConstraint(id.getId());
                            ConstraintSet.Constraint constraint2 = this.mConstraintDelta;
                            if (constraint2 != null) {
                                constraint2.applyDelta(constraint);
                                constraint.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
                            }
                        }
                    }
                }
            }
            ConstraintSet constraintSet3 = new ConstraintSet();
            constraintSet3.clone(constraintSet);
            for (View id2 : viewArr) {
                ConstraintSet.Constraint constraint3 = constraintSet3.getConstraint(id2.getId());
                ConstraintSet.Constraint constraint4 = this.mConstraintDelta;
                if (constraint4 != null) {
                    constraint4.applyDelta(constraint3);
                    constraint3.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
                }
            }
            motionLayout.updateState(i5, constraintSet3);
            int i8 = R.id.view_transition;
            motionLayout.updateState(i8, constraintSet);
            motionLayout.setState(i8, -1, -1);
            MotionScene.Transition transition = new MotionScene.Transition(-1, motionLayout.mScene, i8, i5);
            for (View updateTransition : viewArr) {
                updateTransition(transition, updateTransition);
            }
            motionLayout.setTransition(transition);
            motionLayout.transitionToEnd(new a(this, viewArr));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean checkTags(View view) {
        boolean z4;
        boolean z5;
        int i5 = this.mIfTagSet;
        if (i5 != -1 && view.getTag(i5) == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        int i6 = this.mIfTagNotSet;
        if (i6 == -1 || view.getTag(i6) == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z4 || !z5) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int getId() {
        return this.mId;
    }

    /* access modifiers changed from: package-private */
    public Interpolator getInterpolator(Context context) {
        int i5 = this.mDefaultInterpolator;
        if (i5 == -2) {
            return AnimationUtils.loadInterpolator(context, this.mDefaultInterpolatorID);
        }
        if (i5 == -1) {
            final Easing interpolator = Easing.getInterpolator(this.mDefaultInterpolatorString);
            return new Interpolator() {
                public float getInterpolation(float f5) {
                    return (float) interpolator.get((double) f5);
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
            if (i5 == 5) {
                return new OvershootInterpolator();
            }
            if (i5 != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    public int getSharedValue() {
        return this.mSharedValueTarget;
    }

    public int getSharedValueCurrent() {
        return this.mSharedValueCurrent;
    }

    public int getSharedValueID() {
        return this.mSharedValueID;
    }

    public int getStateTransition() {
        return this.mOnStateTransition;
    }

    /* access modifiers changed from: package-private */
    public boolean isEnabled() {
        return !this.mDisabled;
    }

    /* access modifiers changed from: package-private */
    public boolean matchesView(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.mTargetId == -1 && this.mTargetString == null) || !checkTags(view)) {
            return false;
        }
        if (view.getId() == this.mTargetId) {
            return true;
        }
        if (this.mTargetString != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).constraintTag) != null && str.matches(this.mTargetString)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setEnabled(boolean z4) {
        this.mDisabled = !z4;
    }

    /* access modifiers changed from: package-private */
    public void setId(int i5) {
        this.mId = i5;
    }

    public void setSharedValue(int i5) {
        this.mSharedValueTarget = i5;
    }

    public void setSharedValueCurrent(int i5) {
        this.mSharedValueCurrent = i5;
    }

    public void setSharedValueID(int i5) {
        this.mSharedValueID = i5;
    }

    public void setStateTransition(int i5) {
        this.mOnStateTransition = i5;
    }

    /* access modifiers changed from: package-private */
    public boolean supports(int i5) {
        int i6 = this.mOnStateTransition;
        if (i6 == 1) {
            if (i5 == 0) {
                return true;
            }
            return false;
        } else if (i6 == 2) {
            if (i5 == 1) {
                return true;
            }
            return false;
        } else if (i6 == 3 && i5 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "ViewTransition(" + Debug.getName(this.mContext, this.mId) + ")";
    }
}
