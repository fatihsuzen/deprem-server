package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MotionScene {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final String CONSTRAINTSET_TAG = "ConstraintSet";
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DESKTOP = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final String INCLUDE_TAG = "include";
    private static final String INCLUDE_TAG_UC = "Include";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final String KEYFRAMESET_TAG = "KeyFrameSet";
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int MIN_DURATION = 8;
    private static final String MOTIONSCENE_TAG = "MotionScene";
    private static final String ONCLICK_TAG = "OnClick";
    private static final String ONSWIPE_TAG = "OnSwipe";
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String STATESET_TAG = "StateSet";
    private static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    private static final String TRANSITION_TAG = "Transition";
    public static final int UNSET = -1;
    private static final String VIEW_TRANSITION = "ViewTransition";
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    /* access modifiers changed from: private */
    public SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    Transition mCurrentTransition = null;
    /* access modifiers changed from: private */
    public int mDefaultDuration = 400;
    private Transition mDefaultTransition = null;
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean mDisableAutoTransition = false;
    private boolean mIgnoreTouch = false;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    /* access modifiers changed from: private */
    public int mLayoutDuringTransition = 0;
    /* access modifiers changed from: private */
    public final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion = false;
    private boolean mRtl;
    StateSet mStateSet = null;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private MotionLayout.MotionTracker mVelocityTracker;
    final ViewTransitionController mViewTransitionController;

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
    }

    private int getId(Context context, String str) {
        int i5;
        if (str.contains("/")) {
            i5 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
        } else {
            i5 = -1;
        }
        if (i5 == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e(TypedValues.MotionScene.NAME, "error in parsing id");
        }
        return i5;
    }

    private int getIndex(Transition transition) {
        int access$300 = transition.mId;
        if (access$300 != -1) {
            for (int i5 = 0; i5 < this.mTransitionList.size(); i5++) {
                if (this.mTransitionList.get(i5).mId == access$300) {
                    return i5;
                }
            }
            return -1;
        }
        throw new IllegalArgumentException("The transition must have an id");
    }

    static String getLine(Context context, int i5, XmlPullParser xmlPullParser) {
        return ".(" + Debug.getName(context, i5) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    private int getRealID(int i5) {
        int stateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        if (stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i5, -1, -1)) == -1) {
            return i5;
        }
        return stateGetConstraintID;
    }

    private boolean hasCycleDependency(int i5) {
        int i6 = this.mDeriveMap.get(i5);
        int size = this.mDeriveMap.size();
        while (i6 > 0) {
            if (i6 == i5) {
                return true;
            }
            int i7 = size - 1;
            if (size < 0) {
                return true;
            }
            i6 = this.mDeriveMap.get(i6);
            size = i7;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        if (this.mVelocityTracker != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "Error parsing resource: "
            java.lang.String r1 = "MotionScene"
            android.content.res.Resources r2 = r10.getResources()
            android.content.res.XmlResourceParser r2 = r2.getXml(r11)
            int r3 = r2.getEventType()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r4 = 0
        L_0x0011:
            r5 = 1
            if (r3 == r5) goto L_0x0180
            r6 = 2
            if (r3 == r6) goto L_0x0019
            goto L_0x0155
        L_0x0019:
            java.lang.String r3 = r2.getName()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            int r7 = r3.hashCode()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r8 = -1
            switch(r7) {
                case -1349929691: goto L_0x0087;
                case -1239391468: goto L_0x007c;
                case -687739768: goto L_0x0072;
                case 61998586: goto L_0x0067;
                case 269306229: goto L_0x005e;
                case 312750793: goto L_0x0054;
                case 327855227: goto L_0x004a;
                case 793277014: goto L_0x0042;
                case 1382829617: goto L_0x0038;
                case 1942574248: goto L_0x0027;
                default: goto L_0x0025;
            }     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0025:
            goto L_0x0091
        L_0x0027:
            java.lang.String r5 = "include"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 6
            goto L_0x0092
        L_0x0032:
            r10 = move-exception
            goto L_0x015b
        L_0x0035:
            r10 = move-exception
            goto L_0x016e
        L_0x0038:
            java.lang.String r5 = "StateSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 4
            goto L_0x0092
        L_0x0042:
            boolean r3 = r3.equals(r1)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 0
            goto L_0x0092
        L_0x004a:
            java.lang.String r5 = "OnSwipe"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = r6
            goto L_0x0092
        L_0x0054:
            java.lang.String r5 = "OnClick"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 3
            goto L_0x0092
        L_0x005e:
            java.lang.String r6 = "Transition"
            boolean r3 = r3.equals(r6)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0067:
            java.lang.String r5 = "ViewTransition"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 9
            goto L_0x0092
        L_0x0072:
            java.lang.String r5 = "Include"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 7
            goto L_0x0092
        L_0x007c:
            java.lang.String r5 = "KeyFrameSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 8
            goto L_0x0092
        L_0x0087:
            java.lang.String r5 = "ConstraintSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 5
            goto L_0x0092
        L_0x0091:
            r5 = r8
        L_0x0092:
            switch(r5) {
                case 0: goto L_0x0152;
                case 1: goto L_0x0111;
                case 2: goto L_0x00d5;
                case 3: goto L_0x00c6;
                case 4: goto L_0x00bd;
                case 5: goto L_0x00b8;
                case 6: goto L_0x00b3;
                case 7: goto L_0x00b3;
                case 8: goto L_0x00a3;
                case 9: goto L_0x0097;
                default: goto L_0x0095;
            }     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0095:
            goto L_0x0155
        L_0x0097:
            androidx.constraintlayout.motion.widget.ViewTransition r3 = new androidx.constraintlayout.motion.widget.ViewTransition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.ViewTransitionController r5 = r9.mViewTransitionController     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r5.add(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00a3:
            androidx.constraintlayout.motion.widget.KeyFrames r3 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r4 == 0) goto L_0x0155
            java.util.ArrayList r5 = r4.mKeyFramesList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r5.add(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00b3:
            r9.parseInclude((android.content.Context) r10, (org.xmlpull.v1.XmlPullParser) r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00b8:
            r9.parseConstraintSet(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00bd:
            androidx.constraintlayout.widget.StateSet r3 = new androidx.constraintlayout.widget.StateSet     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r9.mStateSet = r3     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00c6:
            if (r4 == 0) goto L_0x0155
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r9.mMotionLayout     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            boolean r3 = r3.isInEditMode()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != 0) goto L_0x0155
            r4.addOnClick((android.content.Context) r10, (org.xmlpull.v1.XmlPullParser) r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00d5:
            if (r4 != 0) goto L_0x0104
            android.content.res.Resources r3 = r10.getResources()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = r3.getResourceEntryName(r11)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            int r5 = r2.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r7 = " OnSwipe ("
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r6.append(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = ".xml:"
            r6.append(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r6.append(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = ")"
            r6.append(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = r6.toString()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            android.util.Log.v(r1, r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0104:
            if (r4 == 0) goto L_0x0155
            androidx.constraintlayout.motion.widget.TouchResponse r3 = new androidx.constraintlayout.motion.widget.TouchResponse     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r9.mMotionLayout     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r5, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.TouchResponse unused = r4.mTouchResponse = r3     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x0111:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mTransitionList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = new androidx.constraintlayout.motion.widget.MotionScene$Transition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r4.<init>(r9, r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.add(r4)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != 0) goto L_0x0138
            boolean r3 = r4.mIsAbstract     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != 0) goto L_0x0138
            r9.mCurrentTransition = r4     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r4.mTouchResponse     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0138
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r3.mTouchResponse     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            boolean r5 = r9.mRtl     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.setRTL(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0138:
            boolean r3 = r4.mIsAbstract     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0155
            int r3 = r4.mConstraintSetEnd     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != r8) goto L_0x0147
            r9.mDefaultTransition = r4     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x014c
        L_0x0147:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mAbstractTransitionList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.add(r4)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x014c:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mTransitionList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.remove(r4)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x0152:
            r9.parseMotionSceneTags(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0155:
            int r3 = r2.next()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0011
        L_0x015b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            android.util.Log.e(r1, r11, r10)
            goto L_0x0180
        L_0x016e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            android.util.Log.e(r1, r11, r10)
        L_0x0180:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.load(android.content.Context, int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseConstraintSet(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            r13 = this;
            androidx.constraintlayout.widget.ConstraintSet r0 = new androidx.constraintlayout.widget.ConstraintSet
            r0.<init>()
            r1 = 0
            r0.setForceId(r1)
            int r2 = r15.getAttributeCount()
            r3 = -1
            r4 = r1
            r5 = r3
            r6 = r5
        L_0x0011:
            r7 = 1
            if (r4 >= r2) goto L_0x00de
            java.lang.String r8 = r15.getAttributeName(r4)
            java.lang.String r9 = r15.getAttributeValue(r4)
            r8.getClass()
            int r10 = r8.hashCode()
            r11 = 3
            r12 = 2
            switch(r10) {
                case -1496482599: goto L_0x004b;
                case -1153153640: goto L_0x0040;
                case 3355: goto L_0x0035;
                case 973381616: goto L_0x002a;
                default: goto L_0x0028;
            }
        L_0x0028:
            r8 = r3
            goto L_0x0055
        L_0x002a:
            java.lang.String r10 = "stateLabels"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0033
            goto L_0x0028
        L_0x0033:
            r8 = r11
            goto L_0x0055
        L_0x0035:
            java.lang.String r10 = "id"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x003e
            goto L_0x0028
        L_0x003e:
            r8 = r12
            goto L_0x0055
        L_0x0040:
            java.lang.String r10 = "constraintRotate"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0049
            goto L_0x0028
        L_0x0049:
            r8 = r7
            goto L_0x0055
        L_0x004b:
            java.lang.String r10 = "deriveConstraintsFrom"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0054
            goto L_0x0028
        L_0x0054:
            r8 = r1
        L_0x0055:
            switch(r8) {
                case 0: goto L_0x00d6;
                case 1: goto L_0x0078;
                case 2: goto L_0x005f;
                case 3: goto L_0x005a;
                default: goto L_0x0058;
            }
        L_0x0058:
            goto L_0x00da
        L_0x005a:
            r0.setStateLabels(r9)
            goto L_0x00da
        L_0x005f:
            int r5 = r13.getId(r14, r9)
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r13.mConstraintSetIdMap
            java.lang.String r8 = stripID(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r7.put(r8, r9)
            java.lang.String r7 = androidx.constraintlayout.motion.widget.Debug.getName((android.content.Context) r14, (int) r5)
            r0.mIdString = r7
            goto L_0x00da
        L_0x0078:
            int r8 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x0080 }
            r0.mRotate = r8     // Catch:{ NumberFormatException -> 0x0080 }
            goto L_0x00da
        L_0x0080:
            r9.getClass()
            int r8 = r9.hashCode()
            r10 = 4
            switch(r8) {
                case -768416914: goto L_0x00b9;
                case 3317767: goto L_0x00ae;
                case 3387192: goto L_0x00a3;
                case 108511772: goto L_0x0098;
                case 1954540437: goto L_0x008d;
                default: goto L_0x008b;
            }
        L_0x008b:
            r8 = r3
            goto L_0x00c3
        L_0x008d:
            java.lang.String r8 = "x_right"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x0096
            goto L_0x008b
        L_0x0096:
            r8 = r10
            goto L_0x00c3
        L_0x0098:
            java.lang.String r8 = "right"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00a1
            goto L_0x008b
        L_0x00a1:
            r8 = r11
            goto L_0x00c3
        L_0x00a3:
            java.lang.String r8 = "none"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00ac
            goto L_0x008b
        L_0x00ac:
            r8 = r12
            goto L_0x00c3
        L_0x00ae:
            java.lang.String r8 = "left"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00b7
            goto L_0x008b
        L_0x00b7:
            r8 = r7
            goto L_0x00c3
        L_0x00b9:
            java.lang.String r8 = "x_left"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00c2
            goto L_0x008b
        L_0x00c2:
            r8 = r1
        L_0x00c3:
            switch(r8) {
                case 0: goto L_0x00d3;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00cd;
                case 3: goto L_0x00ca;
                case 4: goto L_0x00c7;
                default: goto L_0x00c6;
            }
        L_0x00c6:
            goto L_0x00da
        L_0x00c7:
            r0.mRotate = r11
            goto L_0x00da
        L_0x00ca:
            r0.mRotate = r7
            goto L_0x00da
        L_0x00cd:
            r0.mRotate = r1
            goto L_0x00da
        L_0x00d0:
            r0.mRotate = r12
            goto L_0x00da
        L_0x00d3:
            r0.mRotate = r10
            goto L_0x00da
        L_0x00d6:
            int r6 = r13.getId(r14, r9)
        L_0x00da:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x00de:
            if (r5 == r3) goto L_0x00f8
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r13.mMotionLayout
            int r1 = r1.mDebugPath
            if (r1 == 0) goto L_0x00e9
            r0.setValidateOnParse(r7)
        L_0x00e9:
            r0.load((android.content.Context) r14, (org.xmlpull.v1.XmlPullParser) r15)
            if (r6 == r3) goto L_0x00f3
            android.util.SparseIntArray r14 = r13.mDeriveMap
            r14.put(r5, r6)
        L_0x00f3:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r14 = r13.mConstraintSetMap
            r14.put(r5, r0)
        L_0x00f8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.parseConstraintSet(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    private void parseInclude(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            if (index == R.styleable.include_constraintSet) {
                parseInclude(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i6 = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
                this.mDefaultDuration = i6;
                if (i6 < 8) {
                    this.mDefaultDuration = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i5, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.mConstraintSetMap.get(i5);
        constraintSet.derivedState = constraintSet.mIdString;
        int i6 = this.mDeriveMap.get(i5);
        if (i6 > 0) {
            readConstraintChain(i6, motionLayout);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i6);
            if (constraintSet2 == null) {
                Log.e(TypedValues.MotionScene.NAME, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), i6));
                return;
            }
            constraintSet.derivedState += "/" + constraintSet2.derivedState;
            constraintSet.readFallback(constraintSet2);
        } else {
            constraintSet.derivedState += "  layout";
            constraintSet.readFallback((ConstraintLayout) motionLayout);
        }
        constraintSet.applyDeltaFrom(constraintSet);
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i5) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Transition transition = arrayList.get(i6);
            i6++;
            Transition transition2 = transition;
            if (transition2.mOnClicks.size() > 0) {
                ArrayList access$400 = transition2.mOnClicks;
                int size2 = access$400.size();
                int i7 = 0;
                while (i7 < size2) {
                    Object obj = access$400.get(i7);
                    i7++;
                    ((Transition.TransitionOnClick) obj).removeOnClickListeners(motionLayout);
                }
            }
        }
        ArrayList<Transition> arrayList2 = this.mAbstractTransitionList;
        int size3 = arrayList2.size();
        int i8 = 0;
        while (i8 < size3) {
            Transition transition3 = arrayList2.get(i8);
            i8++;
            Transition transition4 = transition3;
            if (transition4.mOnClicks.size() > 0) {
                ArrayList access$4002 = transition4.mOnClicks;
                int size4 = access$4002.size();
                int i9 = 0;
                while (i9 < size4) {
                    Object obj2 = access$4002.get(i9);
                    i9++;
                    ((Transition.TransitionOnClick) obj2).removeOnClickListeners(motionLayout);
                }
            }
        }
        ArrayList<Transition> arrayList3 = this.mTransitionList;
        int size5 = arrayList3.size();
        int i10 = 0;
        while (i10 < size5) {
            Transition transition5 = arrayList3.get(i10);
            i10++;
            Transition transition6 = transition5;
            if (transition6.mOnClicks.size() > 0) {
                ArrayList access$4003 = transition6.mOnClicks;
                int size6 = access$4003.size();
                int i11 = 0;
                while (i11 < size6) {
                    Object obj3 = access$4003.get(i11);
                    i11++;
                    ((Transition.TransitionOnClick) obj3).addOnClickListeners(motionLayout, i5, transition6);
                }
            }
        }
        ArrayList<Transition> arrayList4 = this.mAbstractTransitionList;
        int size7 = arrayList4.size();
        int i12 = 0;
        while (i12 < size7) {
            Transition transition7 = arrayList4.get(i12);
            i12++;
            Transition transition8 = transition7;
            if (transition8.mOnClicks.size() > 0) {
                ArrayList access$4004 = transition8.mOnClicks;
                int size8 = access$4004.size();
                int i13 = 0;
                while (i13 < size8) {
                    Object obj4 = access$4004.get(i13);
                    i13++;
                    ((Transition.TransitionOnClick) obj4).addOnClickListeners(motionLayout, i5, transition8);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    public boolean applyViewTransition(int i5, MotionController motionController) {
        return this.mViewTransitionController.applyViewTransition(i5, motionController);
    }

    /* access modifiers changed from: package-private */
    public boolean autoTransition(MotionLayout motionLayout, int i5) {
        Transition transition;
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Transition transition2 = arrayList.get(i6);
            i6++;
            Transition transition3 = transition2;
            if (transition3.mAutoTransition != 0 && ((transition = this.mCurrentTransition) != transition3 || !transition.isTransitionFlag(2))) {
                if (i5 == transition3.mConstraintSetStart && (transition3.mAutoTransition == 4 || transition3.mAutoTransition == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(transition3);
                    if (transition3.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                } else if (i5 == transition3.mConstraintSetEnd && (transition3.mAutoTransition == 3 || transition3.mAutoTransition == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(transition3);
                    if (transition3.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition bestTransitionFor(int i5, float f5, float f6, MotionEvent motionEvent) {
        RectF limitBoundsTo;
        float f7;
        int i6 = i5;
        float f8 = f5;
        float f9 = f6;
        if (i6 == -1) {
            return this.mCurrentTransition;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i5);
        RectF rectF = new RectF();
        float f10 = 0.0f;
        Transition transition = null;
        for (Transition next : transitionsWithState) {
            if (!next.mDisable && next.mTouchResponse != null) {
                next.mTouchResponse.setRTL(this.mRtl);
                RectF touchRegion = next.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                if ((touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && ((limitBoundsTo = next.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF)) == null || motionEvent == null || limitBoundsTo.contains(motionEvent.getX(), motionEvent.getY()))) {
                    float dot = next.mTouchResponse.dot(f8, f9);
                    if (next.mTouchResponse.mIsRotateMode && motionEvent != null) {
                        float x4 = motionEvent.getX() - next.mTouchResponse.mRotateCenterX;
                        float y4 = motionEvent.getY() - next.mTouchResponse.mRotateCenterY;
                        dot = ((float) (Math.atan2((double) (f9 + y4), (double) (f8 + x4)) - Math.atan2((double) x4, (double) y4))) * 10.0f;
                    }
                    if (next.mConstraintSetEnd == i6) {
                        f7 = -1.0f;
                    } else {
                        f7 = 1.1f;
                    }
                    float f11 = dot * f7;
                    if (f11 > f10) {
                        transition = next;
                        f10 = f11;
                    }
                }
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z4) {
        this.mDisableAutoTransition = z4;
    }

    public void enableViewTransition(int i5, boolean z4) {
        this.mViewTransitionController.enableViewTransition(i5, z4);
    }

    public int gatPathMotionArc() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mPathMotionArc;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int getAutoCompleteMode() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.mCurrentTransition.mTouchResponse.getAutoCompleteMode();
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        for (int i5 = 0; i5 < this.mConstraintSetMap.size(); i5++) {
            int keyAt = this.mConstraintSetMap.keyAt(i5);
            if (str.equals(context.getResources().getResourceName(keyAt))) {
                return this.mConstraintSetMap.get(keyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr[i5] = this.mConstraintSetMap.keyAt(i5);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mDuration;
        }
        return this.mDefaultDuration;
    }

    /* access modifiers changed from: package-private */
    public int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetEnd;
    }

    public Interpolator getInterpolator() {
        int access$1500 = this.mCurrentTransition.mDefaultInterpolator;
        if (access$1500 == -2) {
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
        }
        if (access$1500 == -1) {
            final Easing interpolator = Easing.getInterpolator(this.mCurrentTransition.mDefaultInterpolatorString);
            return new Interpolator() {
                public float getInterpolation(float f5) {
                    return (float) interpolator.get((double) f5);
                }
            };
        } else if (access$1500 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (access$1500 == 1) {
                return new AccelerateInterpolator();
            }
            if (access$1500 == 2) {
                return new DecelerateInterpolator();
            }
            if (access$1500 == 4) {
                return new BounceInterpolator();
            }
            if (access$1500 == 5) {
                return new OvershootInterpolator();
            }
            if (access$1500 != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    /* access modifiers changed from: package-private */
    public Key getKeyFrame(Context context, int i5, int i6, int i7) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return null;
        }
        ArrayList access$1400 = transition.mKeyFramesList;
        int size = access$1400.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = access$1400.get(i8);
            i8++;
            KeyFrames keyFrames = (KeyFrames) obj;
            Iterator<Integer> it = keyFrames.getKeys().iterator();
            while (true) {
                if (it.hasNext()) {
                    Integer next = it.next();
                    if (i6 == next.intValue()) {
                        ArrayList<Key> keyFramesForView = keyFrames.getKeyFramesForView(next.intValue());
                        int size2 = keyFramesForView.size();
                        int i9 = 0;
                        while (i9 < size2) {
                            Key key = keyFramesForView.get(i9);
                            i9++;
                            Key key2 = key;
                            if (key2.mFramePosition == i7 && key2.mType == i5) {
                                return key2;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.mCurrentTransition;
        int i5 = 0;
        if (transition == null) {
            Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                ArrayList access$1400 = transition2.mKeyFramesList;
                int size = access$1400.size();
                while (i5 < size) {
                    Object obj = access$1400.get(i5);
                    i5++;
                    ((KeyFrames) obj).addFrames(motionController);
                }
                return;
            }
            return;
        }
        ArrayList access$14002 = transition.mKeyFramesList;
        int size2 = access$14002.size();
        while (i5 < size2) {
            Object obj2 = access$14002.get(i5);
            i5++;
            ((KeyFrames) obj2).addFrames(motionController);
        }
    }

    public int[] getMatchingStateLabels(String... strArr) {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintSet valueAt = this.mConstraintSetMap.valueAt(i6);
            int keyAt = this.mConstraintSetMap.keyAt(i6);
            if (valueAt.matchesLabels(strArr)) {
                valueAt.getStateLabels();
                iArr[i5] = keyAt;
                i5++;
            }
        }
        return Arrays.copyOf(iArr, i5);
    }

    /* access modifiers changed from: package-private */
    public float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxAcceleration();
    }

    /* access modifiers changed from: package-private */
    public float getMaxVelocity() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxVelocity();
    }

    /* access modifiers changed from: package-private */
    public boolean getMoveWhenScrollAtTop() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return this.mCurrentTransition.mTouchResponse.getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View view, int i5) {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float getProgressDirection(float f5, float f6) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getProgressDirection(f5, f6);
    }

    /* access modifiers changed from: package-private */
    public int getSpringBoundary() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringBoundary();
    }

    /* access modifiers changed from: package-private */
    public float getSpringDamping() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringDamping();
    }

    /* access modifiers changed from: package-private */
    public float getSpringMass() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringMass();
    }

    /* access modifiers changed from: package-private */
    public float getSpringStiffiness() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringStiffness();
    }

    /* access modifiers changed from: package-private */
    public float getSpringStopThreshold() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringStopThreshold();
    }

    public float getStaggered() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mStagger;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetStart;
    }

    public Transition getTransitionById(int i5) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Transition transition = arrayList.get(i6);
            i6++;
            Transition transition2 = transition;
            if (transition2.mId == i5) {
                return transition2;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getTransitionDirection(int i5) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Transition transition = arrayList.get(i6);
            i6++;
            if (transition.mConstraintSetStart == i5) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> getTransitionsWithState(int i5) {
        int realID = getRealID(i5);
        ArrayList arrayList = new ArrayList();
        ArrayList<Transition> arrayList2 = this.mTransitionList;
        int size = arrayList2.size();
        int i6 = 0;
        while (i6 < size) {
            Transition transition = arrayList2.get(i6);
            i6++;
            Transition transition2 = transition;
            if (transition2.mConstraintSetStart == realID || transition2.mConstraintSetEnd == realID) {
                arrayList.add(transition2);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public boolean hasKeyFramePosition(View view, int i5) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return false;
        }
        ArrayList access$1400 = transition.mKeyFramesList;
        int size = access$1400.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = access$1400.get(i6);
            i6++;
            ArrayList<Key> keyFramesForView = ((KeyFrames) obj).getKeyFramesForView(view.getId());
            int size2 = keyFramesForView.size();
            int i7 = 0;
            while (true) {
                if (i7 < size2) {
                    Key key = keyFramesForView.get(i7);
                    i7++;
                    if (key.mFramePosition == i5) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isViewTransitionEnabled(int i5) {
        return this.mViewTransitionController.isViewTransitionEnabled(i5);
    }

    public int lookUpConstraintId(String str) {
        Integer num = this.mConstraintSetIdMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String lookUpConstraintName(int i5) {
        for (Map.Entry next : this.mConstraintSetIdMap.entrySet()) {
            Integer num = (Integer) next.getValue();
            if (num != null && num.intValue() == i5) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
    }

    /* access modifiers changed from: package-private */
    public void processScrollMove(float f5, float f6) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.scrollMove(f5, f6);
        }
    }

    /* access modifiers changed from: package-private */
    public void processScrollUp(float f5, float f6) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.scrollUp(f5, f6);
        }
    }

    /* access modifiers changed from: package-private */
    public void processTouchEvent(MotionEvent motionEvent, int i5, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i5 != -1) {
            int action = motionEvent.getAction();
            boolean z4 = false;
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (this.mCurrentTransition.mTouchResponse != null) {
                    RectF limitBoundsTo = this.mCurrentTransition.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo == null || limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        RectF touchRegion = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                        if (touchRegion == null || touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            this.mMotionOutsideRegion = false;
                        } else {
                            this.mMotionOutsideRegion = true;
                        }
                        this.mCurrentTransition.mTouchResponse.setDown(this.mLastTouchX, this.mLastTouchY);
                        return;
                    }
                    this.mLastTouchDown = null;
                    this.mIgnoreTouch = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.mIgnoreTouch) {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if ((((double) rawX) != 0.0d || ((double) rawY) != 0.0d) && (motionEvent2 = this.mLastTouchDown) != null) {
                    Transition bestTransitionFor = bestTransitionFor(i5, rawX, rawY, motionEvent2);
                    if (bestTransitionFor != null) {
                        motionLayout.setTransition(bestTransitionFor);
                        RectF touchRegion2 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                        if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            z4 = true;
                        }
                        this.mMotionOutsideRegion = z4;
                        this.mCurrentTransition.mTouchResponse.setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                    }
                } else {
                    return;
                }
            }
        }
        if (!this.mIgnoreTouch) {
            Transition transition = this.mCurrentTransition;
            if (!(transition == null || transition.mTouchResponse == null || this.mMotionOutsideRegion)) {
                this.mCurrentTransition.mTouchResponse.processTouchEvent(motionEvent, this.mVelocityTracker, i5, this);
            }
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (motionTracker = this.mVelocityTracker) != null) {
                motionTracker.recycle();
                this.mVelocityTracker = null;
                int i6 = motionLayout.mCurrentState;
                if (i6 != -1) {
                    autoTransition(motionLayout, i6);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void readFallback(MotionLayout motionLayout) {
        int i5 = 0;
        while (i5 < this.mConstraintSetMap.size()) {
            int keyAt = this.mConstraintSetMap.keyAt(i5);
            if (hasCycleDependency(keyAt)) {
                Log.e(TypedValues.MotionScene.NAME, "Cannot be derived from yourself");
                return;
            } else {
                readConstraintChain(keyAt, motionLayout);
                i5++;
            }
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i5, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i5, constraintSet);
    }

    public void setDuration(int i5) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(i5);
        } else {
            this.mDefaultDuration = i5;
        }
    }

    public void setKeyframe(View view, int i5, String str, Object obj) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            ArrayList access$1400 = transition.mKeyFramesList;
            int size = access$1400.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj2 = access$1400.get(i6);
                i6++;
                ArrayList<Key> keyFramesForView = ((KeyFrames) obj2).getKeyFramesForView(view.getId());
                int size2 = keyFramesForView.size();
                int i7 = 0;
                while (i7 < size2) {
                    Key key = keyFramesForView.get(i7);
                    i7++;
                    if (key.mFramePosition == i5 && obj != null) {
                        Float f5 = (Float) obj;
                    }
                }
            }
        }
    }

    public void setRtl(boolean z4) {
        this.mRtl = z4;
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTransition(int r10, int r11) {
        /*
            r9 = this;
            androidx.constraintlayout.widget.StateSet r0 = r9.mStateSet
            r1 = -1
            if (r0 == 0) goto L_0x0018
            int r0 = r0.stateGetConstraintID(r10, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r10
        L_0x000d:
            androidx.constraintlayout.widget.StateSet r2 = r9.mStateSet
            int r2 = r2.stateGetConstraintID(r11, r1, r1)
            if (r2 == r1) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            r2 = r11
            goto L_0x001a
        L_0x0018:
            r0 = r10
            goto L_0x0016
        L_0x001a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition
            if (r3 == 0) goto L_0x002d
            int r3 = r3.mConstraintSetEnd
            if (r3 != r11) goto L_0x002d
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition
            int r3 = r3.mConstraintSetStart
            if (r3 != r10) goto L_0x002d
            goto L_0x006c
        L_0x002d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mTransitionList
            int r4 = r3.size()
            r5 = 0
            r6 = r5
        L_0x0035:
            if (r6 >= r4) goto L_0x006d
            java.lang.Object r7 = r3.get(r6)
            int r6 = r6 + 1
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r7
            int r8 = r7.mConstraintSetEnd
            if (r8 != r2) goto L_0x004b
            int r8 = r7.mConstraintSetStart
            if (r8 == r0) goto L_0x0057
        L_0x004b:
            int r8 = r7.mConstraintSetEnd
            if (r8 != r11) goto L_0x0035
            int r8 = r7.mConstraintSetStart
            if (r8 != r10) goto L_0x0035
        L_0x0057:
            r9.mCurrentTransition = r7
            if (r7 == 0) goto L_0x006c
            androidx.constraintlayout.motion.widget.TouchResponse r10 = r7.mTouchResponse
            if (r10 == 0) goto L_0x006c
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = r9.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r10 = r10.mTouchResponse
            boolean r11 = r9.mRtl
            r10.setRTL(r11)
        L_0x006c:
            return
        L_0x006d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = r9.mDefaultTransition
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mAbstractTransitionList
            int r4 = r3.size()
        L_0x0075:
            if (r5 >= r4) goto L_0x0087
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r6
            int r7 = r6.mConstraintSetEnd
            if (r7 != r11) goto L_0x0075
            r10 = r6
            goto L_0x0075
        L_0x0087:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r11 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r11.<init>(r9, r10)
            int unused = r11.mConstraintSetStart = r0
            int unused = r11.mConstraintSetEnd = r2
            if (r0 == r1) goto L_0x0099
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r10 = r9.mTransitionList
            r10.add(r11)
        L_0x0099:
            r9.mCurrentTransition = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.setTransition(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void setupTouch() {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setupTouch();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean supportTouch() {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Transition transition = arrayList.get(i5);
            i5++;
            if (transition.mTouchResponse != null) {
                return true;
            }
        }
        Transition transition2 = this.mCurrentTransition;
        if (transition2 == null || transition2.mTouchResponse == null) {
            return false;
        }
        return true;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        if (motionLayout == this.mMotionLayout && motionLayout.mScene == this) {
            return true;
        }
        return false;
    }

    public void viewTransition(int i5, View... viewArr) {
        this.mViewTransitionController.viewTransition(i5, viewArr);
    }

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int INTERPOLATE_ANTICIPATE = 6;
        public static final int INTERPOLATE_BOUNCE = 4;
        public static final int INTERPOLATE_EASE_IN = 1;
        public static final int INTERPOLATE_EASE_IN_OUT = 0;
        public static final int INTERPOLATE_EASE_OUT = 2;
        public static final int INTERPOLATE_LINEAR = 3;
        public static final int INTERPOLATE_OVERSHOOT = 5;
        public static final int INTERPOLATE_REFERENCE_ID = -2;
        public static final int INTERPOLATE_SPLINE_STRING = -1;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        static final int TRANSITION_FLAG_INTERCEPT_TOUCH = 4;
        static final int TRANSITION_FLAG_INTRA_AUTO = 2;
        /* access modifiers changed from: private */
        public int mAutoTransition = 0;
        /* access modifiers changed from: private */
        public int mConstraintSetEnd = -1;
        /* access modifiers changed from: private */
        public int mConstraintSetStart = -1;
        /* access modifiers changed from: private */
        public int mDefaultInterpolator = 0;
        /* access modifiers changed from: private */
        public int mDefaultInterpolatorID = -1;
        /* access modifiers changed from: private */
        public String mDefaultInterpolatorString = null;
        /* access modifiers changed from: private */
        public boolean mDisable = false;
        /* access modifiers changed from: private */
        public int mDuration = 400;
        /* access modifiers changed from: private */
        public int mId = -1;
        /* access modifiers changed from: private */
        public boolean mIsAbstract = false;
        /* access modifiers changed from: private */
        public ArrayList<KeyFrames> mKeyFramesList = new ArrayList<>();
        private int mLayoutDuringTransition = 0;
        /* access modifiers changed from: private */
        public final MotionScene mMotionScene;
        /* access modifiers changed from: private */
        public ArrayList<TransitionOnClick> mOnClicks = new ArrayList<>();
        /* access modifiers changed from: private */
        public int mPathMotionArc = -1;
        /* access modifiers changed from: private */
        public float mStagger = 0.0f;
        /* access modifiers changed from: private */
        public TouchResponse mTouchResponse = null;
        private int mTransitionFlags = 0;

        Transition(MotionScene motionScene, Transition transition) {
            this.mMotionScene = motionScene;
            this.mDuration = motionScene.mDefaultDuration;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArray.getIndex(i5);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintSetEnd);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.mConstraintSetEnd = motionScene.parseInclude(context, this.mConstraintSetEnd);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.mConstraintSetStart);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.mConstraintSetStart = motionScene.parseInclude(context, this.mConstraintSetStart);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i6 = typedArray.peekValue(index).type;
                    if (i6 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i6 == 3) {
                        String string = typedArray.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                                this.mDefaultInterpolator = -2;
                            } else {
                                this.mDefaultInterpolator = -1;
                            }
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i7 = typedArray.getInt(index, this.mDuration);
                    this.mDuration = i7;
                    if (i7 < 8) {
                        this.mDuration = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            fill(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public void addKeyFrame(KeyFrames keyFrames) {
            this.mKeyFramesList.add(keyFrames);
        }

        public void addOnClick(int i5, int i6) {
            ArrayList<TransitionOnClick> arrayList = this.mOnClicks;
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                TransitionOnClick transitionOnClick = arrayList.get(i7);
                i7++;
                TransitionOnClick transitionOnClick2 = transitionOnClick;
                if (transitionOnClick2.mTargetId == i5) {
                    transitionOnClick2.mMode = i6;
                    return;
                }
            }
            this.mOnClicks.add(new TransitionOnClick(this, i5, i6));
        }

        public String debugString(Context context) {
            String str;
            if (this.mConstraintSetStart == -1) {
                str = "null";
            } else {
                str = context.getResources().getResourceEntryName(this.mConstraintSetStart);
            }
            if (this.mConstraintSetEnd == -1) {
                return str + " -> null";
            }
            return str + " -> " + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i5) {
            if ((i5 & this.mTransitionFlags) != 0) {
                return true;
            }
            return false;
        }

        public void removeOnClick(int i5) {
            TransitionOnClick transitionOnClick;
            ArrayList<TransitionOnClick> arrayList = this.mOnClicks;
            int size = arrayList.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    transitionOnClick = null;
                    break;
                }
                TransitionOnClick transitionOnClick2 = arrayList.get(i6);
                i6++;
                transitionOnClick = transitionOnClick2;
                if (transitionOnClick.mTargetId == i5) {
                    break;
                }
            }
            if (transitionOnClick != null) {
                this.mOnClicks.remove(transitionOnClick);
            }
        }

        public void setAutoTransition(int i5) {
            this.mAutoTransition = i5;
        }

        public void setDuration(int i5) {
            this.mDuration = Math.max(i5, 8);
        }

        public void setEnabled(boolean z4) {
            this.mDisable = !z4;
        }

        public void setInterpolatorInfo(int i5, String str, int i6) {
            this.mDefaultInterpolator = i5;
            this.mDefaultInterpolatorString = str;
            this.mDefaultInterpolatorID = i6;
        }

        public void setLayoutDuringTransition(int i5) {
            this.mLayoutDuringTransition = i5;
        }

        public void setOnSwipe(OnSwipe onSwipe) {
            TouchResponse touchResponse;
            if (onSwipe == null) {
                touchResponse = null;
            } else {
                touchResponse = new TouchResponse(this.mMotionScene.mMotionLayout, onSwipe);
            }
            this.mTouchResponse = touchResponse;
        }

        public void setOnTouchUp(int i5) {
            TouchResponse touchResponse = getTouchResponse();
            if (touchResponse != null) {
                touchResponse.setTouchUpMode(i5);
            }
        }

        public void setPathMotionArc(int i5) {
            this.mPathMotionArc = i5;
        }

        public void setStagger(float f5) {
            this.mStagger = f5;
        }

        public void setTransitionFlag(int i5) {
            this.mTransitionFlags = i5;
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i5 = 0; i5 < indexCount; i5++) {
                    int index = obtainStyledAttributes.getIndex(i5);
                    if (index == R.styleable.OnClick_targetId) {
                        this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.mMode = obtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public void addOnClickListeners(MotionLayout motionLayout, int i5, Transition transition) {
                boolean z4;
                boolean z5;
                boolean z6;
                boolean z7;
                int i6 = this.mTargetId;
                View view = motionLayout;
                if (i6 != -1) {
                    view = motionLayout.findViewById(i6);
                }
                if (view == null) {
                    Log.e(TypedValues.MotionScene.NAME, "OnClick could not find id " + this.mTargetId);
                    return;
                }
                int access$100 = transition.mConstraintSetStart;
                int access$000 = transition.mConstraintSetEnd;
                if (access$100 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                int i7 = this.mMode;
                boolean z8 = false;
                if ((i7 & 1) == 0 || i5 != access$100) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if ((i7 & 256) == 0 || i5 != access$100) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                boolean z9 = z4 | z5;
                if ((i7 & 1) == 0 || i5 != access$100) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                boolean z10 = z6 | z9;
                if ((i7 & 16) == 0 || i5 != access$000) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                boolean z11 = z10 | z7;
                if ((i7 & 4096) != 0 && i5 == access$000) {
                    z8 = true;
                }
                if (z11 || z8) {
                    view.setOnClickListener(this);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean isTransitionViable(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.mTransition;
                if (transition2 == transition) {
                    return true;
                }
                int access$000 = transition2.mConstraintSetEnd;
                int access$100 = this.mTransition.mConstraintSetStart;
                if (access$100 != -1) {
                    int i5 = motionLayout.mCurrentState;
                    if (i5 == access$100 || i5 == access$000) {
                        return true;
                    }
                    return false;
                } else if (motionLayout.mCurrentState != access$000) {
                    return true;
                } else {
                    return false;
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:35:0x009f  */
            /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r8) {
                /*
                    r7 = this;
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = r7.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r8 = r8.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionLayout r8 = r8.mMotionLayout
                    boolean r0 = r8.isInteractionEnabled()
                    if (r0 != 0) goto L_0x0012
                    goto L_0x00e4
                L_0x0012:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    int r0 = r0.mConstraintSetStart
                    r1 = -1
                    if (r0 != r1) goto L_0x004b
                    int r0 = r8.getCurrentState()
                    if (r0 != r1) goto L_0x002b
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    int r0 = r0.mConstraintSetEnd
                    r8.transitionToState(r0)
                    return
                L_0x002b:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = r7.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r2 = r2.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r7.mTransition
                    r1.<init>(r2, r3)
                    int unused = r1.mConstraintSetStart = r0
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    int r0 = r0.mConstraintSetEnd
                    int unused = r1.mConstraintSetEnd = r0
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r1)
                    r8.transitionToEnd()
                    return
                L_0x004b:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r0 = r0.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r0.mCurrentTransition
                    int r1 = r7.mMode
                    r2 = r1 & 1
                    r3 = 0
                    r4 = 1
                    if (r2 != 0) goto L_0x0062
                    r2 = r1 & 256(0x100, float:3.59E-43)
                    if (r2 == 0) goto L_0x0060
                    goto L_0x0062
                L_0x0060:
                    r2 = r3
                    goto L_0x0063
                L_0x0062:
                    r2 = r4
                L_0x0063:
                    r5 = r1 & 16
                    if (r5 != 0) goto L_0x006e
                    r1 = r1 & 4096(0x1000, float:5.74E-42)
                    if (r1 == 0) goto L_0x006c
                    goto L_0x006e
                L_0x006c:
                    r1 = r3
                    goto L_0x006f
                L_0x006e:
                    r1 = r4
                L_0x006f:
                    if (r2 == 0) goto L_0x0098
                    if (r1 == 0) goto L_0x0098
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = r7.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r5 = r5.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = r5.mCurrentTransition
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = r7.mTransition
                    if (r5 == r6) goto L_0x0082
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r6)
                L_0x0082:
                    int r5 = r8.getCurrentState()
                    int r6 = r8.getEndState()
                    if (r5 == r6) goto L_0x0099
                    float r5 = r8.getProgress()
                    r6 = 1056964608(0x3f000000, float:0.5)
                    int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                    if (r5 <= 0) goto L_0x0097
                    goto L_0x0099
                L_0x0097:
                    r1 = r3
                L_0x0098:
                    r3 = r2
                L_0x0099:
                    boolean r0 = r7.isTransitionViable(r0, r8)
                    if (r0 == 0) goto L_0x00e4
                    if (r3 == 0) goto L_0x00af
                    int r0 = r7.mMode
                    r0 = r0 & r4
                    if (r0 == 0) goto L_0x00af
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r8.transitionToEnd()
                    return
                L_0x00af:
                    if (r1 == 0) goto L_0x00c0
                    int r0 = r7.mMode
                    r0 = r0 & 16
                    if (r0 == 0) goto L_0x00c0
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r8.transitionToStart()
                    return
                L_0x00c0:
                    if (r3 == 0) goto L_0x00d3
                    int r0 = r7.mMode
                    r0 = r0 & 256(0x100, float:3.59E-43)
                    if (r0 == 0) goto L_0x00d3
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r0 = 1065353216(0x3f800000, float:1.0)
                    r8.setProgress(r0)
                    return
                L_0x00d3:
                    if (r1 == 0) goto L_0x00e4
                    int r0 = r7.mMode
                    r0 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r0 == 0) goto L_0x00e4
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r0 = 0
                    r8.setProgress(r0)
                L_0x00e4:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick.onClick(android.view.View):void");
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i5 = this.mTargetId;
                if (i5 != -1) {
                    View findViewById = motionLayout.findViewById(i5);
                    if (findViewById == null) {
                        Log.e(TypedValues.MotionScene.NAME, " (*)  could not find id " + this.mTargetId);
                        return;
                    }
                    findViewById.setOnClickListener((View.OnClickListener) null);
                }
            }

            public TransitionOnClick(Transition transition, int i5, int i6) {
                this.mTransition = transition;
                this.mTargetId = i5;
                this.mMode = i6;
            }
        }

        public Transition(int i5, MotionScene motionScene, int i6, int i7) {
            this.mId = i5;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i6;
            this.mConstraintSetEnd = i7;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }

    /* access modifiers changed from: package-private */
    public ConstraintSet getConstraintSet(int i5) {
        return getConstraintSet(i5, -1, -1);
    }

    /* access modifiers changed from: package-private */
    public ConstraintSet getConstraintSet(int i5, int i6, int i7) {
        int stateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        if (!(stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i5, i6, i7)) == -1)) {
            i5 = stateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i5) != null) {
            return this.mConstraintSetMap.get(i5);
        }
        Log.e(TypedValues.MotionScene.NAME, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), i5) + " In MotionScene");
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    /* access modifiers changed from: private */
    public int parseInclude(Context context, int i5) {
        XmlResourceParser xml = context.getResources().getXml(i5);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && CONSTRAINTSET_TAG.equals(name)) {
                    return parseConstraintSet(context, xml);
                }
            }
            return -1;
        } catch (XmlPullParserException e5) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i5, e5);
            return -1;
        } catch (IOException e6) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i5, e6);
            return -1;
        }
    }

    MotionScene(Context context, MotionLayout motionLayout, int i5) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
        load(context, i5);
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        int i6 = R.id.motion_base;
        sparseArray.put(i6, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(i6));
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
        }
    }
}
