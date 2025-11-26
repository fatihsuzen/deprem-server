package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    private static final boolean DO_NOT_USE = false;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
    public WidgetFrame frame;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    private boolean mAnimated;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    public float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    private boolean mHasBaseline;
    int mHeight;
    private int mHeightOverride;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    public HorizontalWidgetRun mHorizontalRun;
    private boolean mHorizontalSolvingPass;
    boolean mHorizontalWrapVisited;
    private boolean mInPlaceholder;
    private boolean mInVirtualLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    private boolean mOptimizeWrapO;
    private boolean mOptimizeWrapOnResolved;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    private boolean mResolvedHorizontal;
    public int[] mResolvedMatchConstraintDefault;
    private boolean mResolvedVertical;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    public VerticalWidgetRun mVerticalRun;
    private boolean mVerticalSolvingPass;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    private int mWidthOverride;
    private int mWrapBehaviorInParent;
    protected int mX;
    protected int mY;
    public boolean measured;
    public WidgetRun[] run;
    public String stringId;
    public ChainRun verticalChainRun;
    public int verticalGroup;

    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.AnonymousClass1.<clinit>():void");
        }
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.mHorizontalRun = null;
        this.mVerticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.mOptimizeWrapO = false;
        this.mOptimizeWrapOnResolved = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = Float.NaN;
        this.mHasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f5;
        this.mVerticalBiasPercent = f5;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARNING: Removed duplicated region for block: B:318:0x04d9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:366:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(androidx.constraintlayout.core.LinearSystem r29, boolean r30, boolean r31, boolean r32, boolean r33, androidx.constraintlayout.core.SolverVariable r34, androidx.constraintlayout.core.SolverVariable r35, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r36, boolean r37, androidx.constraintlayout.core.widgets.ConstraintAnchor r38, androidx.constraintlayout.core.widgets.ConstraintAnchor r39, int r40, int r41, int r42, int r43, float r44, boolean r45, boolean r46, boolean r47, boolean r48, boolean r49, int r50, int r51, int r52, int r53, float r54, boolean r55) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r12 = r38
            r13 = r39
            r14 = r42
            r2 = r43
            r4 = r52
            r5 = r53
            androidx.constraintlayout.core.SolverVariable r6 = r1.createObjectVariable(r12)
            androidx.constraintlayout.core.SolverVariable r7 = r1.createObjectVariable(r13)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r12.getTarget()
            androidx.constraintlayout.core.SolverVariable r15 = r1.createObjectVariable(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r13.getTarget()
            androidx.constraintlayout.core.SolverVariable r8 = r1.createObjectVariable(r8)
            androidx.constraintlayout.core.Metrics r9 = androidx.constraintlayout.core.LinearSystem.getMetrics()
            if (r9 == 0) goto L_0x003a
            androidx.constraintlayout.core.Metrics r9 = androidx.constraintlayout.core.LinearSystem.getMetrics()
            long r10 = r9.nonresolvedWidgets
            r16 = 1
            long r10 = r10 + r16
            r9.nonresolvedWidgets = r10
        L_0x003a:
            boolean r10 = r12.isConnected()
            boolean r11 = r13.isConnected()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r0.mCenter
            boolean r16 = r9.isConnected()
            if (r11 == 0) goto L_0x004d
            int r9 = r10 + 1
            goto L_0x004e
        L_0x004d:
            r9 = r10
        L_0x004e:
            if (r16 == 0) goto L_0x0052
            int r9 = r9 + 1
        L_0x0052:
            r17 = r10
            if (r45 == 0) goto L_0x005a
            r10 = 3
        L_0x0057:
            r18 = r8
            goto L_0x005d
        L_0x005a:
            r10 = r50
            goto L_0x0057
        L_0x005d:
            int r8 = r36.ordinal()
            r19 = r11
            r11 = 1
            if (r8 == 0) goto L_0x006b
            if (r8 == r11) goto L_0x006b
            r11 = 2
            if (r8 == r11) goto L_0x006d
        L_0x006b:
            r8 = 0
            goto L_0x0071
        L_0x006d:
            r11 = 4
            if (r10 == r11) goto L_0x006b
            r8 = 1
        L_0x0071:
            int r11 = r0.mWidthOverride
            r3 = -1
            if (r11 == r3) goto L_0x007d
            if (r30 == 0) goto L_0x007d
            r0.mWidthOverride = r3
            r41 = 0
            goto L_0x0081
        L_0x007d:
            r11 = r41
            r41 = r8
        L_0x0081:
            int r8 = r0.mHeightOverride
            if (r8 == r3) goto L_0x008c
            if (r30 != 0) goto L_0x008c
            r0.mHeightOverride = r3
            r11 = r8
            r8 = 0
            goto L_0x008e
        L_0x008c:
            r8 = r41
        L_0x008e:
            int r3 = r0.mVisibility
            r41 = r11
            r11 = 8
            if (r3 != r11) goto L_0x0099
            r3 = 0
            r8 = 0
            goto L_0x009c
        L_0x0099:
            r3 = r8
            r8 = r41
        L_0x009c:
            if (r55 == 0) goto L_0x00be
            if (r17 != 0) goto L_0x00ae
            if (r19 != 0) goto L_0x00ae
            if (r16 != 0) goto L_0x00ae
            r11 = r40
            r1.addEquality(r6, r11)
        L_0x00a9:
            r23 = r3
            r3 = 8
            goto L_0x00c1
        L_0x00ae:
            if (r17 == 0) goto L_0x00a9
            if (r19 != 0) goto L_0x00a9
            int r11 = r12.getMargin()
            r23 = r3
            r3 = 8
            r1.addEquality(r6, r15, r11, r3)
            goto L_0x00c1
        L_0x00be:
            r23 = r3
            r3 = r11
        L_0x00c1:
            if (r23 != 0) goto L_0x00ea
            if (r37 == 0) goto L_0x00da
            r3 = 0
            r11 = 3
            r1.addEquality(r7, r6, r3, r11)
            r3 = 8
            if (r14 <= 0) goto L_0x00d1
            r1.addGreaterThan(r7, r6, r14, r3)
        L_0x00d1:
            r8 = 2147483647(0x7fffffff, float:NaN)
            if (r2 >= r8) goto L_0x00dd
            r1.addLowerThan(r7, r6, r2, r3)
            goto L_0x00dd
        L_0x00da:
            r1.addEquality(r7, r6, r8, r3)
        L_0x00dd:
            r3 = r5
            r5 = r7
            r2 = r9
            r11 = r18
            r24 = r23
            r18 = r33
            r23 = r4
            goto L_0x01d5
        L_0x00ea:
            r11 = 2
            if (r9 == r11) goto L_0x0110
            if (r45 != 0) goto L_0x0110
            r2 = 1
            if (r10 == r2) goto L_0x00f4
            if (r10 != 0) goto L_0x0110
        L_0x00f4:
            int r2 = java.lang.Math.max(r4, r8)
            if (r5 <= 0) goto L_0x00fe
            int r2 = java.lang.Math.min(r5, r2)
        L_0x00fe:
            r3 = 8
            r1.addEquality(r7, r6, r2, r3)
            r23 = r4
            r3 = r5
            r5 = r7
            r2 = r9
            r11 = r18
            r24 = 0
            r18 = r33
            goto L_0x01d5
        L_0x0110:
            r2 = -2
            if (r4 != r2) goto L_0x0115
            r3 = r8
            goto L_0x0116
        L_0x0115:
            r3 = r4
        L_0x0116:
            if (r5 != r2) goto L_0x011a
            r2 = r8
            goto L_0x011b
        L_0x011a:
            r2 = r5
        L_0x011b:
            if (r8 <= 0) goto L_0x0121
            r4 = 1
            if (r10 == r4) goto L_0x0121
            r8 = 0
        L_0x0121:
            r4 = 8
            if (r3 <= 0) goto L_0x012c
            r1.addGreaterThan(r7, r6, r3, r4)
            int r8 = java.lang.Math.max(r8, r3)
        L_0x012c:
            r5 = 1
            if (r2 <= 0) goto L_0x013b
            if (r31 == 0) goto L_0x0134
            if (r10 != r5) goto L_0x0134
            goto L_0x0137
        L_0x0134:
            r1.addLowerThan(r7, r6, r2, r4)
        L_0x0137:
            int r8 = java.lang.Math.min(r8, r2)
        L_0x013b:
            if (r10 != r5) goto L_0x0161
            if (r31 == 0) goto L_0x0143
            r1.addEquality(r7, r6, r8, r4)
            goto L_0x0154
        L_0x0143:
            if (r47 == 0) goto L_0x014d
            r5 = 5
            r1.addEquality(r7, r6, r8, r5)
            r1.addLowerThan(r7, r6, r8, r4)
            goto L_0x0154
        L_0x014d:
            r5 = 5
            r1.addEquality(r7, r6, r8, r5)
            r1.addLowerThan(r7, r6, r8, r4)
        L_0x0154:
            r5 = r7
            r11 = r18
            r24 = r23
            r18 = r33
            r23 = r3
            r3 = r2
            r2 = r9
            goto L_0x01d5
        L_0x0161:
            r11 = 2
            if (r10 != r11) goto L_0x01ca
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = r12.getType()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r4 == r5) goto L_0x018f
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = r12.getType()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            if (r4 != r8) goto L_0x0175
            goto L_0x018f
        L_0x0175:
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.getAnchor(r5)
            androidx.constraintlayout.core.SolverVariable r4 = r1.createObjectVariable(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.getAnchor(r8)
            androidx.constraintlayout.core.SolverVariable r5 = r1.createObjectVariable(r5)
        L_0x018d:
            r8 = r4
            goto L_0x01a6
        L_0x018f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.getAnchor(r5)
            androidx.constraintlayout.core.SolverVariable r4 = r1.createObjectVariable(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.getAnchor(r8)
            androidx.constraintlayout.core.SolverVariable r5 = r1.createObjectVariable(r5)
            goto L_0x018d
        L_0x01a6:
            androidx.constraintlayout.core.ArrayRow r4 = r1.createRow()
            r37 = r7
            r7 = r5
            r5 = r37
            r37 = r2
            r2 = r9
            r11 = r18
            r9 = r54
            androidx.constraintlayout.core.ArrayRow r4 = r4.createRowDimensionRatio(r5, r6, r7, r8, r9)
            r1.addConstraint(r4)
            if (r31 == 0) goto L_0x01c1
            r23 = 0
        L_0x01c1:
            r18 = r33
            r24 = r23
        L_0x01c5:
            r23 = r3
            r3 = r37
            goto L_0x01d5
        L_0x01ca:
            r37 = r2
            r5 = r7
            r2 = r9
            r11 = r18
            r24 = r23
            r18 = 1
            goto L_0x01c5
        L_0x01d5:
            if (r55 == 0) goto L_0x01d9
            if (r47 == 0) goto L_0x01e0
        L_0x01d9:
            r12 = r34
            r4 = r35
            r11 = 2
            goto L_0x0506
        L_0x01e0:
            if (r17 != 0) goto L_0x01ea
            if (r19 != 0) goto L_0x01ea
            if (r16 != 0) goto L_0x01ea
        L_0x01e6:
            r2 = r11
            r3 = 5
            goto L_0x04d4
        L_0x01ea:
            if (r17 == 0) goto L_0x0203
            if (r19 != 0) goto L_0x0203
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r12.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.mOwner
            if (r31 == 0) goto L_0x01fb
            boolean r2 = r2 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r2 == 0) goto L_0x01fb
            r2 = 8
            goto L_0x01fc
        L_0x01fb:
            r2 = 5
        L_0x01fc:
            r4 = r11
            r11 = r2
            r2 = r4
            r4 = r31
            goto L_0x04d7
        L_0x0203:
            if (r17 != 0) goto L_0x0235
            if (r19 == 0) goto L_0x0235
            int r2 = r13.getMargin()
            int r2 = -r2
            r3 = 8
            r1.addEquality(r5, r11, r2, r3)
            if (r31 == 0) goto L_0x01e6
            boolean r2 = r0.mOptimizeWrapO
            if (r2 == 0) goto L_0x022b
            boolean r2 = r6.isFinalValue
            if (r2 == 0) goto L_0x022b
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.mParent
            if (r2 == 0) goto L_0x022b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r2
            if (r30 == 0) goto L_0x0227
            r2.addHorizontalWrapMinVariable(r12)
            goto L_0x01e6
        L_0x0227:
            r2.addVerticalWrapMinVariable(r12)
            goto L_0x01e6
        L_0x022b:
            r4 = r34
            r2 = 0
            r3 = 5
            r1.addGreaterThan(r6, r4, r2, r3)
            r2 = r11
            goto L_0x04d4
        L_0x0235:
            r4 = r34
            r2 = 0
            if (r17 == 0) goto L_0x01e6
            if (r19 == 0) goto L_0x01e6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r12.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r7.mOwner
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r13.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r8.mOwner
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r0.getParent()
            r16 = 6
            if (r24 == 0) goto L_0x0367
            if (r10 != 0) goto L_0x029f
            if (r3 != 0) goto L_0x0277
            if (r23 != 0) goto L_0x0277
            boolean r3 = r15.isFinalValue
            if (r3 == 0) goto L_0x026c
            boolean r3 = r11.isFinalValue
            if (r3 == 0) goto L_0x026c
            int r2 = r12.getMargin()
            r3 = 8
            r1.addEquality(r6, r15, r2, r3)
            int r2 = r13.getMargin()
            int r2 = -r2
            r1.addEquality(r5, r11, r2, r3)
            return
        L_0x026c:
            r19 = r2
            r22 = r19
            r3 = 8
            r17 = 8
            r21 = 1
            goto L_0x0280
        L_0x0277:
            r21 = r2
            r3 = 5
            r17 = 5
            r19 = 1
            r22 = 1
        L_0x0280:
            boolean r2 = r7 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r2 != 0) goto L_0x0298
            boolean r2 = r8 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r2 == 0) goto L_0x0289
            goto L_0x0298
        L_0x0289:
            r2 = r6
            r6 = r11
            r25 = r21
        L_0x028d:
            r11 = r35
            r21 = r19
            r19 = r3
            r3 = r15
            r15 = r16
            goto L_0x03bd
        L_0x0298:
            r2 = r6
            r6 = r11
            r25 = r21
            r17 = 4
            goto L_0x028d
        L_0x029f:
            r2 = 2
            if (r10 != r2) goto L_0x02c6
            boolean r2 = r7 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r2 != 0) goto L_0x02be
            boolean r2 = r8 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r2 == 0) goto L_0x02ab
            goto L_0x02be
        L_0x02ab:
            r2 = r6
            r6 = r11
            r3 = r15
            r15 = r16
            r17 = 5
        L_0x02b2:
            r19 = 5
        L_0x02b4:
            r21 = 1
            r22 = 1
        L_0x02b8:
            r25 = 0
        L_0x02ba:
            r11 = r35
            goto L_0x03bd
        L_0x02be:
            r2 = r6
            r6 = r11
            r3 = r15
            r15 = r16
            r17 = 4
            goto L_0x02b2
        L_0x02c6:
            r2 = 1
            if (r10 != r2) goto L_0x02d3
            r2 = r6
            r6 = r11
            r3 = r15
            r15 = r16
            r17 = 4
            r19 = 8
            goto L_0x02b4
        L_0x02d3:
            r2 = 3
            if (r10 != r2) goto L_0x0356
            int r2 = r0.mResolvedDimensionRatioSide
            r1 = -1
            if (r2 != r1) goto L_0x02fa
            if (r48 == 0) goto L_0x02f2
            r1 = r29
            r2 = r6
            r6 = r11
            r3 = r15
            if (r31 == 0) goto L_0x02f0
            r15 = 5
        L_0x02e5:
            r17 = 5
            r19 = 8
        L_0x02e9:
            r21 = 1
            r22 = 1
            r25 = 1
            goto L_0x02ba
        L_0x02f0:
            r15 = 4
            goto L_0x02e5
        L_0x02f2:
            r1 = r29
            r2 = r6
            r6 = r11
            r3 = r15
            r15 = 8
            goto L_0x02e5
        L_0x02fa:
            if (r45 == 0) goto L_0x031d
            r1 = r51
            r2 = 2
            if (r1 == r2) goto L_0x0309
            r2 = 1
            if (r1 != r2) goto L_0x0305
            goto L_0x0309
        L_0x0305:
            r1 = 8
            r2 = 5
            goto L_0x030b
        L_0x0309:
            r1 = 5
            r2 = 4
        L_0x030b:
            r19 = r1
            r17 = r2
            r2 = r6
            r6 = r11
            r3 = r15
            r15 = r16
        L_0x0314:
            r21 = 1
            r22 = 1
            r25 = 1
            r1 = r29
            goto L_0x02ba
        L_0x031d:
            if (r3 <= 0) goto L_0x032b
            r1 = r29
            r2 = r6
            r6 = r11
            r3 = r15
            r15 = r16
            r17 = 5
        L_0x0328:
            r19 = 5
            goto L_0x02e9
        L_0x032b:
            if (r3 != 0) goto L_0x034c
            if (r23 != 0) goto L_0x034c
            if (r48 != 0) goto L_0x033b
            r1 = r29
            r2 = r6
            r6 = r11
            r3 = r15
            r15 = r16
            r17 = 8
            goto L_0x0328
        L_0x033b:
            if (r7 == r9) goto L_0x0341
            if (r8 == r9) goto L_0x0341
            r1 = 4
            goto L_0x0342
        L_0x0341:
            r1 = 5
        L_0x0342:
            r19 = r1
            r2 = r6
            r6 = r11
            r3 = r15
            r15 = r16
            r17 = 4
            goto L_0x0314
        L_0x034c:
            r1 = r29
            r2 = r6
            r6 = r11
            r3 = r15
            r15 = r16
            r17 = 4
            goto L_0x0328
        L_0x0356:
            r1 = r29
            r2 = r6
            r6 = r11
            r3 = r15
            r15 = r16
            r17 = 4
            r19 = 5
            r21 = 0
            r22 = 0
            goto L_0x02b8
        L_0x0367:
            boolean r1 = r15.isFinalValue
            if (r1 == 0) goto L_0x03aa
            boolean r1 = r11.isFinalValue
            if (r1 == 0) goto L_0x03aa
            int r1 = r12.getMargin()
            int r2 = r13.getMargin()
            r3 = 8
            r45 = r29
            r49 = r44
            r48 = r1
            r52 = r2
            r53 = r3
            r51 = r5
            r46 = r6
            r50 = r11
            r47 = r15
            r45.addCentering(r46, r47, r48, r49, r50, r51, r52, r53)
            r1 = r45
            r6 = r50
            if (r31 == 0) goto L_0x054d
            if (r18 == 0) goto L_0x054d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r13.mTarget
            if (r2 == 0) goto L_0x03a1
            int r3 = r13.getMargin()
        L_0x039e:
            r11 = r35
            goto L_0x03a3
        L_0x03a1:
            r3 = 0
            goto L_0x039e
        L_0x03a3:
            if (r6 == r11) goto L_0x054d
            r2 = 5
            r1.addGreaterThan(r11, r5, r3, r2)
            return
        L_0x03aa:
            r1 = r29
            r2 = r6
            r6 = r11
            r3 = r15
            r11 = r35
            r15 = r16
            r17 = 4
            r19 = 5
            r21 = 1
            r22 = 1
            r25 = 0
        L_0x03bd:
            if (r22 == 0) goto L_0x03c8
            if (r3 != r6) goto L_0x03c8
            if (r7 == r9) goto L_0x03c8
            r22 = 0
            r26 = 0
            goto L_0x03ca
        L_0x03c8:
            r26 = 1
        L_0x03ca:
            if (r21 == 0) goto L_0x0405
            if (r24 != 0) goto L_0x03e0
            if (r46 != 0) goto L_0x03e0
            if (r48 != 0) goto L_0x03e0
            if (r3 != r4) goto L_0x03e0
            if (r6 != r11) goto L_0x03e0
            r21 = r9
            r9 = 8
            r15 = 0
            r19 = 8
            r26 = 0
            goto L_0x03e5
        L_0x03e0:
            r21 = r9
            r9 = r15
            r15 = r31
        L_0x03e5:
            int r4 = r12.getMargin()
            r27 = r8
            int r8 = r13.getMargin()
            r12 = r34
            r14 = r7
            r31 = r15
            r11 = r21
            r15 = r27
            r7 = r5
            r5 = r44
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            r5 = r6
            r6 = r2
            r2 = r5
            r5 = r7
        L_0x0402:
            r4 = r31
            goto L_0x040d
        L_0x0405:
            r11 = r6
            r6 = r2
            r2 = r11
            r12 = r4
            r14 = r7
            r15 = r8
            r11 = r9
            goto L_0x0402
        L_0x040d:
            int r7 = r0.mVisibility
            r8 = 8
            if (r7 != r8) goto L_0x041b
            boolean r7 = r13.hasDependents()
            if (r7 != 0) goto L_0x041b
            goto L_0x054d
        L_0x041b:
            if (r22 == 0) goto L_0x0441
            if (r4 == 0) goto L_0x042e
            if (r3 == r2) goto L_0x042e
            if (r24 != 0) goto L_0x042e
            boolean r7 = r14 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r7 != 0) goto L_0x042b
            boolean r7 = r15 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r7 == 0) goto L_0x042e
        L_0x042b:
            r7 = r16
            goto L_0x0430
        L_0x042e:
            r7 = r19
        L_0x0430:
            int r8 = r38.getMargin()
            r1.addGreaterThan(r6, r3, r8, r7)
            int r8 = r13.getMargin()
            int r8 = -r8
            r1.addLowerThan(r5, r2, r8, r7)
            r19 = r7
        L_0x0441:
            if (r4 == 0) goto L_0x0455
            if (r49 == 0) goto L_0x0455
            boolean r7 = r14 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r7 != 0) goto L_0x0455
            boolean r7 = r15 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r7 != 0) goto L_0x0455
            if (r15 == r11) goto L_0x0455
            r7 = r16
            r8 = r7
            r20 = 1
            goto L_0x045b
        L_0x0455:
            r7 = r17
            r8 = r19
            r20 = r26
        L_0x045b:
            if (r20 == 0) goto L_0x04a8
            if (r25 == 0) goto L_0x0488
            if (r48 == 0) goto L_0x0463
            if (r32 == 0) goto L_0x0488
        L_0x0463:
            if (r14 == r11) goto L_0x046a
            if (r15 != r11) goto L_0x0468
            goto L_0x046a
        L_0x0468:
            r16 = r7
        L_0x046a:
            boolean r9 = r14 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r9 != 0) goto L_0x0472
            boolean r9 = r15 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r9 == 0) goto L_0x0474
        L_0x0472:
            r16 = 5
        L_0x0474:
            boolean r9 = r14 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r9 != 0) goto L_0x047c
            boolean r9 = r15 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r9 == 0) goto L_0x047e
        L_0x047c:
            r16 = 5
        L_0x047e:
            if (r48 == 0) goto L_0x0482
            r9 = 5
            goto L_0x0484
        L_0x0482:
            r9 = r16
        L_0x0484:
            int r7 = java.lang.Math.max(r9, r7)
        L_0x0488:
            if (r4 == 0) goto L_0x0498
            int r7 = java.lang.Math.min(r8, r7)
            if (r45 == 0) goto L_0x0498
            if (r48 != 0) goto L_0x0498
            if (r14 == r11) goto L_0x0496
            if (r15 != r11) goto L_0x0498
        L_0x0496:
            r11 = 4
            goto L_0x0499
        L_0x0498:
            r11 = r7
        L_0x0499:
            int r7 = r38.getMargin()
            r1.addEquality(r6, r3, r7, r11)
            int r7 = r13.getMargin()
            int r7 = -r7
            r1.addEquality(r5, r2, r7, r11)
        L_0x04a8:
            if (r4 == 0) goto L_0x04b8
            if (r12 != r3) goto L_0x04b1
            int r7 = r38.getMargin()
            goto L_0x04b2
        L_0x04b1:
            r7 = 0
        L_0x04b2:
            if (r3 == r12) goto L_0x04b8
            r3 = 5
            r1.addGreaterThan(r6, r12, r7, r3)
        L_0x04b8:
            if (r4 == 0) goto L_0x04cb
            if (r24 == 0) goto L_0x04cb
            if (r42 != 0) goto L_0x04cb
            if (r23 != 0) goto L_0x04cb
            if (r24 == 0) goto L_0x04cd
            r11 = 3
            if (r10 != r11) goto L_0x04cd
            r3 = 8
            r7 = 0
            r1.addGreaterThan(r5, r6, r7, r3)
        L_0x04cb:
            r3 = 5
            goto L_0x04d2
        L_0x04cd:
            r7 = 0
            r3 = 5
            r1.addGreaterThan(r5, r6, r7, r3)
        L_0x04d2:
            r11 = r3
            goto L_0x04d7
        L_0x04d4:
            r4 = r31
            goto L_0x04d2
        L_0x04d7:
            if (r4 == 0) goto L_0x054d
            if (r18 == 0) goto L_0x054d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.mTarget
            if (r3 == 0) goto L_0x04e6
            int r3 = r13.getMargin()
        L_0x04e3:
            r4 = r35
            goto L_0x04e8
        L_0x04e6:
            r3 = 0
            goto L_0x04e3
        L_0x04e8:
            if (r2 == r4) goto L_0x054d
            boolean r2 = r0.mOptimizeWrapO
            if (r2 == 0) goto L_0x0502
            boolean r2 = r5.isFinalValue
            if (r2 == 0) goto L_0x0502
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.mParent
            if (r2 == 0) goto L_0x0502
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r2
            if (r30 == 0) goto L_0x04fe
            r2.addHorizontalWrapMaxVariable(r13)
            return
        L_0x04fe:
            r2.addVerticalWrapMaxVariable(r13)
            return
        L_0x0502:
            r1.addGreaterThan(r4, r5, r3, r11)
            return
        L_0x0506:
            if (r2 >= r11) goto L_0x054d
            if (r31 == 0) goto L_0x054d
            if (r18 == 0) goto L_0x054d
            r3 = 8
            r7 = 0
            r1.addGreaterThan(r6, r12, r7, r3)
            if (r30 != 0) goto L_0x051d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 != 0) goto L_0x051b
            goto L_0x051d
        L_0x051b:
            r3 = 0
            goto L_0x051e
        L_0x051d:
            r3 = 1
        L_0x051e:
            if (r30 != 0) goto L_0x0544
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0544
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.mOwner
            float r3 = r2.mDimensionRatio
            r6 = 0
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x0542
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r21 = 0
            r3 = r2[r21]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r6) goto L_0x0542
            r20 = 1
            r2 = r2[r20]
            if (r2 != r6) goto L_0x0542
            r11 = r20
            goto L_0x0545
        L_0x0542:
            r11 = 0
            goto L_0x0545
        L_0x0544:
            r11 = r3
        L_0x0545:
            if (r11 == 0) goto L_0x054d
            r3 = 8
            r7 = 0
            r1.addGreaterThan(r4, r5, r7, r3)
        L_0x054d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r4 = r0[r4 + 1];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isChainHead(int r4) {
        /*
            r3 = this;
            int r4 = r4 * 2
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r3.mListAnchors
            r1 = r0[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == r1) goto L_0x001b
            r1 = 1
            int r4 = r4 + r1
            r4 = r0[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r4.mTarget
            if (r0 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 != r4) goto L_0x001b
            return r1
        L_0x001b:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.isChainHead(int):boolean");
    }

    private void serializeAnchor(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget != null) {
            sb.append(str);
            sb.append(" : [ '");
            sb.append(constraintAnchor.mTarget);
            sb.append("',");
            sb.append(constraintAnchor.mMargin);
            sb.append(",");
            sb.append(constraintAnchor.mGoneMargin);
            sb.append(",");
            sb.append(" ] ,\n");
        }
    }

    private void serializeAttribute(StringBuilder sb, String str, float f5, float f6) {
        if (f5 != f6) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(f5);
            sb.append(",\n");
        }
    }

    private void serializeCircle(StringBuilder sb, ConstraintAnchor constraintAnchor, float f5) {
        if (constraintAnchor.mTarget != null && !Float.isNaN(f5)) {
            sb.append("circle : [ '");
            sb.append(constraintAnchor.mTarget);
            sb.append("',");
            sb.append(constraintAnchor.mMargin);
            sb.append(",");
            sb.append(f5);
            sb.append(",");
            sb.append(" ] ,\n");
        }
    }

    private void serializeDimensionRatio(StringBuilder sb, String str, float f5, int i5) {
        if (f5 != 0.0f) {
            sb.append(str);
            sb.append(" :  [");
            sb.append(f5);
            sb.append(",");
            sb.append(i5);
            sb.append("");
            sb.append("],\n");
        }
    }

    private void serializeSize(StringBuilder sb, String str, int i5, int i6, int i7, int i8, int i9, int i10, float f5, float f6) {
        sb.append(str);
        sb.append(" :  {\n");
        serializeAttribute(sb, "size", i5, Integer.MIN_VALUE);
        serializeAttribute(sb, "min", i6, 0);
        serializeAttribute(sb, "max", i7, Integer.MAX_VALUE);
        serializeAttribute(sb, "matchMin", i9, 0);
        serializeAttribute(sb, "matchDef", i10, 0);
        serializeAttribute(sb, "matchPercent", i10, 1);
        serializeAttribute(sb, "matchConstraintPercent", f5, 1.0f);
        serializeAttribute(sb, "weight", f6, 1.0f);
        serializeAttribute(sb, "override", i8, 1);
        sb.append("},\n");
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i5, boolean z4) {
        if (z4) {
            if (hashSet.contains(this)) {
                Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
                hashSet.remove(this);
                addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
            } else {
                return;
            }
        }
        if (i5 == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i5, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i5, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i5, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i5, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i5, true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean addFirst() {
        if ((this instanceof VirtualLayout) || (this instanceof Guideline)) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v0, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (r13 != 3) goto L_0x0053;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x035c  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x046a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x049b  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x049d  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x04a4  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0578  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x057f  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x05b0  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x05d7  */
    /* JADX WARNING: Removed duplicated region for block: B:320:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.core.LinearSystem r51, boolean r52) {
        /*
            r50 = this;
            r0 = r50
            r1 = r51
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.mLeft
            androidx.constraintlayout.core.SolverVariable r2 = r1.createObjectVariable(r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.mRight
            androidx.constraintlayout.core.SolverVariable r3 = r1.createObjectVariable(r3)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.mTop
            androidx.constraintlayout.core.SolverVariable r4 = r1.createObjectVariable(r4)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.mBottom
            androidx.constraintlayout.core.SolverVariable r5 = r1.createObjectVariable(r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.mBaseline
            androidx.constraintlayout.core.SolverVariable r6 = r1.createObjectVariable(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r0.mParent
            r8 = 2
            r9 = 3
            r10 = 1
            r11 = 0
            if (r7 == 0) goto L_0x004d
            if (r7 == 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r12 = r7.mListDimensionBehaviors
            r12 = r12[r11]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 != r13) goto L_0x0036
            r12 = r10
            goto L_0x0037
        L_0x0036:
            r12 = r11
        L_0x0037:
            if (r7 == 0) goto L_0x0043
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r7.mListDimensionBehaviors
            r7 = r7[r10]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r13) goto L_0x0043
            r7 = r10
            goto L_0x0044
        L_0x0043:
            r7 = r11
        L_0x0044:
            int r13 = r0.mWrapBehaviorInParent
            if (r13 == r10) goto L_0x0052
            if (r13 == r8) goto L_0x0050
            if (r13 == r9) goto L_0x004d
            goto L_0x0053
        L_0x004d:
            r7 = r11
            r12 = r7
            goto L_0x0053
        L_0x0050:
            r12 = r11
            goto L_0x0053
        L_0x0052:
            r7 = r11
        L_0x0053:
            int r13 = r0.mVisibility
            r14 = 8
            if (r13 != r14) goto L_0x0070
            boolean r13 = r0.mAnimated
            if (r13 != 0) goto L_0x0070
            boolean r13 = r0.hasDependencies()
            if (r13 != 0) goto L_0x0070
            boolean[] r13 = r0.mIsInBarrier
            boolean r15 = r13[r11]
            if (r15 != 0) goto L_0x0070
            boolean r13 = r13[r10]
            if (r13 != 0) goto L_0x0070
            r7 = r0
            goto L_0x05e7
        L_0x0070:
            boolean r13 = r0.mResolvedHorizontal
            r15 = 5
            if (r13 != 0) goto L_0x0079
            boolean r8 = r0.mResolvedVertical
            if (r8 == 0) goto L_0x00f6
        L_0x0079:
            if (r13 == 0) goto L_0x00a8
            int r8 = r0.mX
            r1.addEquality(r2, r8)
            int r8 = r0.mX
            int r13 = r0.mWidth
            int r8 = r8 + r13
            r1.addEquality(r3, r8)
            if (r12 == 0) goto L_0x00a8
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r0.mParent
            if (r8 == 0) goto L_0x00a8
            boolean r13 = r0.mOptimizeWrapOnResolved
            if (r13 == 0) goto L_0x009f
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r8
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r0.mLeft
            r8.addHorizontalWrapMinVariable(r13)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r0.mRight
            r8.addHorizontalWrapMaxVariable(r13)
            goto L_0x00a8
        L_0x009f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r8.mRight
            androidx.constraintlayout.core.SolverVariable r8 = r1.createObjectVariable(r8)
            r1.addGreaterThan(r8, r3, r11, r15)
        L_0x00a8:
            boolean r8 = r0.mResolvedVertical
            if (r8 == 0) goto L_0x00e9
            int r8 = r0.mY
            r1.addEquality(r4, r8)
            int r8 = r0.mY
            int r13 = r0.mHeight
            int r8 = r8 + r13
            r1.addEquality(r5, r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r0.mBaseline
            boolean r8 = r8.hasDependents()
            if (r8 == 0) goto L_0x00c9
            int r8 = r0.mY
            int r13 = r0.mBaselineDistance
            int r8 = r8 + r13
            r1.addEquality(r6, r8)
        L_0x00c9:
            if (r7 == 0) goto L_0x00e9
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r0.mParent
            if (r8 == 0) goto L_0x00e9
            boolean r13 = r0.mOptimizeWrapOnResolved
            if (r13 == 0) goto L_0x00e0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r8
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r0.mTop
            r8.addVerticalWrapMinVariable(r13)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r0.mBottom
            r8.addVerticalWrapMaxVariable(r13)
            goto L_0x00e9
        L_0x00e0:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r8.mBottom
            androidx.constraintlayout.core.SolverVariable r8 = r1.createObjectVariable(r8)
            r1.addGreaterThan(r8, r5, r11, r15)
        L_0x00e9:
            boolean r8 = r0.mResolvedHorizontal
            if (r8 == 0) goto L_0x00f6
            boolean r8 = r0.mResolvedVertical
            if (r8 == 0) goto L_0x00f6
            r0.mResolvedHorizontal = r11
            r0.mResolvedVertical = r11
            return
        L_0x00f6:
            androidx.constraintlayout.core.Metrics r8 = androidx.constraintlayout.core.LinearSystem.sMetrics
            r17 = 1
            r19 = r10
            if (r8 == 0) goto L_0x0104
            long r9 = r8.widgets
            long r9 = r9 + r17
            r8.widgets = r9
        L_0x0104:
            if (r52 == 0) goto L_0x0192
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r9 = r0.mHorizontalRun
            if (r9 == 0) goto L_0x0192
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r10 = r0.mVerticalRun
            if (r10 == 0) goto L_0x0192
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r13 = r9.start
            boolean r15 = r13.resolved
            if (r15 == 0) goto L_0x0192
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r9.end
            boolean r9 = r9.resolved
            if (r9 == 0) goto L_0x0192
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r10.start
            boolean r9 = r9.resolved
            if (r9 == 0) goto L_0x0192
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r10.end
            boolean r9 = r9.resolved
            if (r9 == 0) goto L_0x0192
            if (r8 == 0) goto L_0x012e
            long r9 = r8.graphSolved
            long r9 = r9 + r17
            r8.graphSolved = r9
        L_0x012e:
            int r8 = r13.value
            r1.addEquality(r2, r8)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r2 = r0.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r1.addEquality(r3, r2)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.start
            int r2 = r2.value
            r1.addEquality(r4, r2)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r1.addEquality(r5, r2)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.baseline
            int r2 = r2.value
            r1.addEquality(r6, r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.mParent
            if (r2 == 0) goto L_0x018d
            if (r12 == 0) goto L_0x0174
            boolean[] r2 = r0.isTerminalWidget
            boolean r2 = r2[r11]
            if (r2 == 0) goto L_0x0174
            boolean r2 = r0.isInHorizontalChain()
            if (r2 != 0) goto L_0x0174
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mRight
            androidx.constraintlayout.core.SolverVariable r2 = r1.createObjectVariable(r2)
            r1.addGreaterThan(r2, r3, r11, r14)
        L_0x0174:
            if (r7 == 0) goto L_0x018d
            boolean[] r2 = r0.isTerminalWidget
            boolean r2 = r2[r19]
            if (r2 == 0) goto L_0x018d
            boolean r2 = r0.isInVerticalChain()
            if (r2 != 0) goto L_0x018d
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mBottom
            androidx.constraintlayout.core.SolverVariable r2 = r1.createObjectVariable(r2)
            r1.addGreaterThan(r2, r5, r11, r14)
        L_0x018d:
            r0.mResolvedHorizontal = r11
            r0.mResolvedVertical = r11
            return
        L_0x0192:
            if (r8 == 0) goto L_0x019a
            long r9 = r8.linearSolved
            long r9 = r9 + r17
            r8.linearSolved = r9
        L_0x019a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r0.mParent
            if (r8 == 0) goto L_0x020d
            boolean r8 = r0.isChainHead(r11)
            if (r8 == 0) goto L_0x01af
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r8
            r8.addChain(r0, r11)
            r8 = r19
            r9 = r8
            goto L_0x01b5
        L_0x01af:
            boolean r8 = r0.isInHorizontalChain()
            r9 = r19
        L_0x01b5:
            boolean r10 = r0.isChainHead(r9)
            if (r10 == 0) goto L_0x01c4
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r10
            r10.addChain(r0, r9)
            r9 = 1
            goto L_0x01c8
        L_0x01c4:
            boolean r9 = r0.isInVerticalChain()
        L_0x01c8:
            if (r8 != 0) goto L_0x01e8
            if (r12 == 0) goto L_0x01e8
            int r10 = r0.mVisibility
            if (r10 == r14) goto L_0x01e8
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mTarget
            if (r10 != 0) goto L_0x01e8
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mTarget
            if (r10 != 0) goto L_0x01e8
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mRight
            androidx.constraintlayout.core.SolverVariable r10 = r1.createObjectVariable(r10)
            r13 = 1
            r1.addGreaterThan(r10, r3, r11, r13)
        L_0x01e8:
            if (r9 != 0) goto L_0x020f
            if (r7 == 0) goto L_0x020f
            int r10 = r0.mVisibility
            if (r10 == r14) goto L_0x020f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mTarget
            if (r10 != 0) goto L_0x020f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mTarget
            if (r10 != 0) goto L_0x020f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mBaseline
            if (r10 != 0) goto L_0x020f
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mBottom
            androidx.constraintlayout.core.SolverVariable r10 = r1.createObjectVariable(r10)
            r13 = 1
            r1.addGreaterThan(r10, r5, r11, r13)
            goto L_0x020f
        L_0x020d:
            r8 = r11
            r9 = r8
        L_0x020f:
            int r10 = r0.mWidth
            int r13 = r0.mMinWidth
            if (r10 >= r13) goto L_0x0216
            goto L_0x0217
        L_0x0216:
            r13 = r10
        L_0x0217:
            int r15 = r0.mHeight
            r17 = r11
            int r11 = r0.mMinHeight
            if (r15 >= r11) goto L_0x0220
            goto L_0x0221
        L_0x0220:
            r11 = r15
        L_0x0221:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r14 = r0.mListDimensionBehaviors
            r22 = r4
            r4 = r14[r17]
            r23 = r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r24 = r6
            if (r4 == r5) goto L_0x0233
            r6 = 1
        L_0x0230:
            r19 = 1
            goto L_0x0236
        L_0x0233:
            r6 = r17
            goto L_0x0230
        L_0x0236:
            r14 = r14[r19]
            r25 = r8
            if (r14 == r5) goto L_0x0240
            r8 = 1
        L_0x023d:
            r26 = r9
            goto L_0x0243
        L_0x0240:
            r8 = r17
            goto L_0x023d
        L_0x0243:
            int r9 = r0.mDimensionRatioSide
            r0.mResolvedDimensionRatioSide = r9
            r27 = r11
            float r11 = r0.mDimensionRatio
            r0.mResolvedDimensionRatio = r11
            r28 = r11
            int r11 = r0.mMatchConstraintDefaultWidth
            r29 = r11
            int r11 = r0.mMatchConstraintDefaultHeight
            r30 = 0
            int r30 = (r28 > r30 ? 1 : (r28 == r30 ? 0 : -1))
            r31 = r11
            if (r30 <= 0) goto L_0x02da
            int r11 = r0.mVisibility
            r32 = r13
            r13 = 8
            if (r11 == r13) goto L_0x02d7
            if (r4 != r5) goto L_0x026b
            if (r29 != 0) goto L_0x026b
            r11 = 3
            goto L_0x026d
        L_0x026b:
            r11 = r29
        L_0x026d:
            if (r14 != r5) goto L_0x0273
            if (r31 != 0) goto L_0x0273
            r13 = 3
            goto L_0x0275
        L_0x0273:
            r13 = r31
        L_0x0275:
            if (r4 != r5) goto L_0x0284
            if (r14 != r5) goto L_0x0284
            r33 = r3
            r3 = 3
            if (r11 != r3) goto L_0x0287
            if (r13 != r3) goto L_0x0287
            r0.setupDimensionRatio(r12, r7, r6, r8)
            goto L_0x02d2
        L_0x0284:
            r33 = r3
            r3 = 3
        L_0x0287:
            r6 = 4
            if (r4 != r5) goto L_0x02a9
            if (r11 != r3) goto L_0x02a9
            r8 = r17
            r0.mResolvedDimensionRatioSide = r8
            float r3 = (float) r15
            float r3 = r3 * r28
            int r3 = (int) r3
            if (r14 == r5) goto L_0x02a0
            r11 = r6
            r4 = r23
            r28 = r27
            r23 = r13
            r13 = r3
        L_0x029e:
            r3 = 0
            goto L_0x02e8
        L_0x02a0:
            r4 = r23
            r28 = r27
            r23 = r13
            r13 = r3
            r3 = 1
            goto L_0x02e8
        L_0x02a9:
            if (r14 != r5) goto L_0x02d2
            if (r13 != r3) goto L_0x02d2
            r3 = 1
            r0.mResolvedDimensionRatioSide = r3
            r3 = -1
            if (r9 != r3) goto L_0x02b9
            r3 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 / r28
            r0.mResolvedDimensionRatio = r3
        L_0x02b9:
            float r3 = r0.mResolvedDimensionRatio
            float r8 = (float) r10
            float r3 = r3 * r8
            int r3 = (int) r3
            r28 = r3
            if (r4 == r5) goto L_0x02ca
            r4 = r23
            r13 = r32
            r3 = 0
            r23 = r6
            goto L_0x02e8
        L_0x02ca:
            r4 = r23
        L_0x02cc:
            r3 = 1
            r23 = r13
            r13 = r32
            goto L_0x02e8
        L_0x02d2:
            r4 = r23
            r28 = r27
            goto L_0x02cc
        L_0x02d7:
            r33 = r3
            goto L_0x02dd
        L_0x02da:
            r32 = r13
            goto L_0x02d7
        L_0x02dd:
            r4 = r23
            r28 = r27
            r11 = r29
            r23 = r31
            r13 = r32
            goto L_0x029e
        L_0x02e8:
            int[] r6 = r0.mResolvedMatchConstraintDefault
            r17 = 0
            r6[r17] = r11
            r19 = 1
            r6[r19] = r23
            r0.mResolvedHasRatio = r3
            if (r3 == 0) goto L_0x02ff
            int r6 = r0.mResolvedDimensionRatioSide
            r8 = -1
            if (r6 == 0) goto L_0x02fd
            if (r6 != r8) goto L_0x0300
        L_0x02fd:
            r9 = 1
            goto L_0x0301
        L_0x02ff:
            r8 = -1
        L_0x0300:
            r9 = 0
        L_0x0301:
            if (r3 == 0) goto L_0x030d
            int r6 = r0.mResolvedDimensionRatioSide
            r10 = 1
            if (r6 == r10) goto L_0x030a
            if (r6 != r8) goto L_0x030d
        L_0x030a:
            r29 = 1
            goto L_0x030f
        L_0x030d:
            r29 = 0
        L_0x030f:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r0.mListDimensionBehaviors
            r17 = 0
            r6 = r6[r17]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r6 != r8) goto L_0x0320
            boolean r6 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r6 == 0) goto L_0x0320
            r6 = r9
            r9 = 1
            goto L_0x0322
        L_0x0320:
            r6 = r9
            r9 = 0
        L_0x0322:
            if (r9 == 0) goto L_0x0325
            r13 = 0
        L_0x0325:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mCenter
            boolean r10 = r10.isConnected()
            r19 = 1
            r27 = r10 ^ 1
            boolean[] r10 = r0.mIsInBarrier
            r14 = 5
            r17 = 0
            boolean r21 = r10[r17]
            boolean r30 = r10[r19]
            int r10 = r0.mHorizontalResolution
            r31 = 0
            r15 = 2
            if (r10 == r15) goto L_0x03a6
            boolean r10 = r0.mResolvedHorizontal
            if (r10 != 0) goto L_0x03a6
            if (r52 == 0) goto L_0x0355
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r10 = r0.mHorizontalRun
            if (r10 == 0) goto L_0x0355
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r14 = r10.start
            boolean r15 = r14.resolved
            if (r15 == 0) goto L_0x0355
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r10.end
            boolean r10 = r10.resolved
            if (r10 != 0) goto L_0x035a
        L_0x0355:
            r10 = r33
            r14 = 8
            goto L_0x03b2
        L_0x035a:
            if (r52 == 0) goto L_0x03a6
            int r6 = r14.value
            r1.addEquality(r2, r6)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r0.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r6 = r6.end
            int r6 = r6.value
            r10 = r33
            r1.addEquality(r10, r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r0.mParent
            if (r6 == 0) goto L_0x038c
            if (r12 == 0) goto L_0x038c
            boolean[] r6 = r0.isTerminalWidget
            r9 = 0
            boolean r6 = r6[r9]
            if (r6 == 0) goto L_0x038c
            boolean r6 = r0.isInHorizontalChain()
            if (r6 != 0) goto L_0x038c
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mRight
            androidx.constraintlayout.core.SolverVariable r6 = r1.createObjectVariable(r6)
            r14 = 8
            r1.addGreaterThan(r6, r10, r9, r14)
        L_0x038c:
            r43 = r2
            r36 = r3
            r46 = r4
            r48 = r5
            r4 = r7
            r49 = r8
            r33 = r10
        L_0x0399:
            r3 = r12
            r45 = r22
            r47 = r24
            r19 = r25
            r20 = r26
            r22 = r11
            goto L_0x0437
        L_0x03a6:
            r43 = r2
            r36 = r3
            r46 = r4
            r48 = r5
            r4 = r7
            r49 = r8
            goto L_0x0399
        L_0x03b2:
            androidx.constraintlayout.core.widgets.ConstraintWidget r15 = r0.mParent
            if (r15 == 0) goto L_0x03bd
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r15.mRight
            androidx.constraintlayout.core.SolverVariable r15 = r1.createObjectVariable(r15)
            goto L_0x03bf
        L_0x03bd:
            r15 = r31
        L_0x03bf:
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r0.mParent
            if (r14 == 0) goto L_0x03ca
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.mLeft
            androidx.constraintlayout.core.SolverVariable r14 = r1.createObjectVariable(r14)
            goto L_0x03cc
        L_0x03ca:
            r14 = r31
        L_0x03cc:
            boolean[] r1 = r0.isTerminalWidget
            r17 = 0
            boolean r1 = r1[r17]
            r32 = r1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r0.mListDimensionBehaviors
            r33 = r8
            r8 = r1[r17]
            r34 = r10
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mLeft
            r35 = r22
            r22 = r11
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mRight
            r36 = r3
            r3 = r12
            int r12 = r0.mX
            r37 = r17
            r17 = r6
            r6 = r14
            int r14 = r0.mMinWidth
            r38 = r1
            int[] r1 = r0.mMaxDimension
            r1 = r1[r37]
            r39 = r1
            float r1 = r0.mHorizontalBiasPercent
            r40 = r1
            r19 = 1
            r1 = r38[r19]
            if (r1 != r5) goto L_0x0405
            r18 = r19
            goto L_0x0407
        L_0x0405:
            r18 = r37
        L_0x0407:
            int r1 = r0.mMatchConstraintMinWidth
            r41 = r1
            int r1 = r0.mMatchConstraintMaxWidth
            r42 = r1
            float r1 = r0.mMatchConstraintPercentWidth
            r43 = r2
            r2 = 1
            r46 = r4
            r48 = r5
            r4 = r7
            r7 = r15
            r47 = r24
            r19 = r25
            r20 = r26
            r5 = r32
            r49 = r33
            r33 = r34
            r45 = r35
            r15 = r39
            r16 = r40
            r24 = r41
            r25 = r42
            r26 = r1
            r1 = r51
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
        L_0x0437:
            if (r52 == 0) goto L_0x048b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r0.mVerticalRun
            if (r2 == 0) goto L_0x048b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r2.start
            boolean r6 = r5.resolved
            if (r6 == 0) goto L_0x048b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.end
            boolean r2 = r2.resolved
            if (r2 == 0) goto L_0x048b
            int r2 = r5.value
            r5 = r45
            r1.addEquality(r5, r2)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r6 = r46
            r1.addEquality(r6, r2)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.baseline
            int r2 = r2.value
            r7 = r47
            r1.addEquality(r7, r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.mParent
            if (r2 == 0) goto L_0x0486
            if (r20 != 0) goto L_0x0486
            if (r4 == 0) goto L_0x0486
            boolean[] r8 = r0.isTerminalWidget
            r13 = 1
            boolean r8 = r8[r13]
            if (r8 == 0) goto L_0x0482
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mBottom
            androidx.constraintlayout.core.SolverVariable r2 = r1.createObjectVariable(r2)
            r8 = 0
            r14 = 8
            r1.addGreaterThan(r2, r6, r8, r14)
            goto L_0x0489
        L_0x0482:
            r8 = 0
        L_0x0483:
            r14 = 8
            goto L_0x0489
        L_0x0486:
            r8 = 0
            r13 = 1
            goto L_0x0483
        L_0x0489:
            r10 = r8
            goto L_0x0496
        L_0x048b:
            r5 = r45
            r6 = r46
            r7 = r47
            r8 = 0
            r13 = 1
            r14 = 8
            r10 = r13
        L_0x0496:
            int r2 = r0.mVerticalResolution
            r15 = 2
            if (r2 != r15) goto L_0x049d
            r11 = r8
            goto L_0x049e
        L_0x049d:
            r11 = r10
        L_0x049e:
            if (r11 == 0) goto L_0x0578
            boolean r2 = r0.mResolvedVertical
            if (r2 != 0) goto L_0x0578
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r0.mListDimensionBehaviors
            r2 = r2[r13]
            r9 = r49
            if (r2 != r9) goto L_0x04b2
            boolean r2 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r2 == 0) goto L_0x04b2
            r9 = r13
            goto L_0x04b3
        L_0x04b2:
            r9 = r8
        L_0x04b3:
            if (r9 == 0) goto L_0x04b7
            r11 = r8
            goto L_0x04b9
        L_0x04b7:
            r11 = r28
        L_0x04b9:
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.mParent
            if (r2 == 0) goto L_0x04c4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mBottom
            androidx.constraintlayout.core.SolverVariable r2 = r1.createObjectVariable(r2)
            goto L_0x04c6
        L_0x04c4:
            r2 = r31
        L_0x04c6:
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r0.mParent
            if (r10 == 0) goto L_0x04d0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mTop
            androidx.constraintlayout.core.SolverVariable r31 = r1.createObjectVariable(r10)
        L_0x04d0:
            int r10 = r0.mBaselineDistance
            if (r10 > 0) goto L_0x04d8
            int r10 = r0.mVisibility
            if (r10 != r14) goto L_0x0518
        L_0x04d8:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r10.mTarget
            if (r12 == 0) goto L_0x0505
            int r10 = r0.getBaselineDistance()
            r1.addEquality(r7, r5, r10, r14)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mTarget
            androidx.constraintlayout.core.SolverVariable r10 = r1.createObjectVariable(r10)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.mBaseline
            int r12 = r12.getMargin()
            r1.addEquality(r7, r10, r12, r14)
            if (r4 == 0) goto L_0x0502
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r0.mBottom
            androidx.constraintlayout.core.SolverVariable r7 = r1.createObjectVariable(r7)
            r14 = 5
            r1.addGreaterThan(r2, r7, r8, r14)
        L_0x0502:
            r27 = r8
            goto L_0x0518
        L_0x0505:
            int r12 = r0.mVisibility
            if (r12 != r14) goto L_0x0511
            int r10 = r10.getMargin()
            r1.addEquality(r7, r5, r10, r14)
            goto L_0x0518
        L_0x0511:
            int r10 = r0.getBaselineDistance()
            r1.addEquality(r7, r5, r10, r14)
        L_0x0518:
            boolean[] r7 = r0.isTerminalWidget
            boolean r7 = r7[r13]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r0.mListDimensionBehaviors
            r17 = r8
            r8 = r10[r13]
            r12 = r10
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mTop
            r44 = r13
            r13 = r11
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mBottom
            r14 = r12
            int r12 = r0.mY
            r15 = r14
            int r14 = r0.mMinHeight
            int[] r1 = r0.mMaxDimension
            r1 = r1[r44]
            r52 = r1
            float r1 = r0.mVerticalBiasPercent
            r15 = r15[r17]
            r16 = r1
            r1 = r48
            if (r15 != r1) goto L_0x0543
            r18 = r44
            goto L_0x0545
        L_0x0543:
            r18 = r17
        L_0x0545:
            int r1 = r0.mMatchConstraintMinHeight
            int r15 = r0.mMatchConstraintMaxHeight
            r24 = r1
            float r1 = r0.mMatchConstraintPercentHeight
            r45 = r5
            r5 = r7
            r7 = r2
            r2 = 0
            r17 = r4
            r4 = r3
            r3 = r17
            r17 = r20
            r20 = r19
            r19 = r17
            r17 = r23
            r23 = r22
            r22 = r17
            r26 = r1
            r46 = r6
            r25 = r15
            r17 = r29
            r21 = r30
            r6 = r31
            r1 = r51
            r15 = r52
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r7 = r0
            goto L_0x057d
        L_0x0578:
            r7 = r0
            r45 = r5
            r46 = r6
        L_0x057d:
            if (r36 == 0) goto L_0x0595
            int r0 = r7.mResolvedDimensionRatioSide
            r6 = 8
            r13 = 1
            if (r0 != r13) goto L_0x0598
            float r5 = r7.mResolvedDimensionRatio
            r0 = r51
            r3 = r33
            r4 = r43
            r2 = r45
            r1 = r46
            r0.addRatio(r1, r2, r3, r4, r5, r6)
        L_0x0595:
            r1 = r51
            goto L_0x05a8
        L_0x0598:
            float r5 = r7.mResolvedDimensionRatio
            r0 = r51
            r1 = r33
            r2 = r43
            r4 = r45
            r3 = r46
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            r1 = r0
        L_0x05a8:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x05ce
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.mCenter
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.getTarget()
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.getOwner()
            float r2 = r7.mCircleConstraintAngle
            r3 = 1119092736(0x42b40000, float:90.0)
            float r2 = r2 + r3
            double r2 = (double) r2
            double r2 = java.lang.Math.toRadians(r2)
            float r2 = (float) r2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r7.mCenter
            int r3 = r3.getMargin()
            r1.addCenterPoint(r7, r0, r2, r3)
        L_0x05ce:
            r8 = 0
            r7.mResolvedHorizontal = r8
            r7.mResolvedVertical = r8
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.sMetrics
            if (r0 == 0) goto L_0x05e7
            int r2 = r1.getNumEquations()
            long r2 = (long) r2
            r0.mEquations = r2
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.sMetrics
            int r1 = r1.getNumVariables()
            long r1 = (long) r1
            r0.mVariables = r1
        L_0x05e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public boolean allowedInBarrier() {
        if (this.mVisibility != 8) {
            return true;
        }
        return false;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i5) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i5);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f5, int i5) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i5, 0);
        this.mCircleConstraintAngle = f5;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.mHasBaseline = constraintWidget.mHasBaseline;
        this.mInPlaceholder = constraintWidget.mInPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget4 = null;
        if (this.mParent == null) {
            constraintWidget2 = null;
        } else {
            constraintWidget2 = hashMap.get(constraintWidget.mParent);
        }
        this.mParent = constraintWidget2;
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mAnimated = constraintWidget.mAnimated;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget5 = constraintWidget.mHorizontalNextWidget;
        if (constraintWidget5 == null) {
            constraintWidget3 = null;
        } else {
            constraintWidget3 = hashMap.get(constraintWidget5);
        }
        this.mHorizontalNextWidget = constraintWidget3;
        ConstraintWidget constraintWidget6 = constraintWidget.mVerticalNextWidget;
        if (constraintWidget6 != null) {
            constraintWidget4 = hashMap.get(constraintWidget6);
        }
        this.mVerticalNextWidget = constraintWidget4;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.mHorizontalRun == null) {
            this.mHorizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.mVerticalRun == null) {
            this.mVerticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i5) {
        if (i5 == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i5 == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i5) {
        if (i5 == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i5 == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.mHasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        int i5;
        ConstraintAnchor constraintAnchor = this.mLeft;
        if (constraintAnchor != null) {
            i5 = constraintAnchor.mMargin;
        } else {
            i5 = 0;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        if (constraintAnchor2 != null) {
            return i5 + constraintAnchor2.mMargin;
        }
        return i5;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i5) {
        if (i5 == 0) {
            return getWidth();
        }
        if (i5 == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.mBottom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget getNextChainMember(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.getNextChainMember(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public int getOptimizerWrapHeight() {
        int i5 = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                i5 = Math.max(this.mMatchConstraintMinHeight, i5);
            } else {
                i5 = this.mMatchConstraintMinHeight;
                if (i5 > 0) {
                    this.mHeight = i5;
                } else {
                    i5 = 0;
                }
            }
            int i6 = this.mMatchConstraintMaxHeight;
            if (i6 <= 0 || i6 >= i5) {
                return i5;
            }
            return i6;
        }
        return i5;
    }

    public int getOptimizerWrapWidth() {
        int i5 = this.mWidth;
        int i6 = 0;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i5;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i6 = Math.max(this.mMatchConstraintMinWidth, i5);
        } else {
            int i7 = this.mMatchConstraintMinWidth;
            if (i7 > 0) {
                this.mWidth = i7;
                i6 = i7;
            }
        }
        int i8 = this.mMatchConstraintMaxWidth;
        if (i8 <= 0 || i8 >= i6) {
            return i6;
        }
        return i8;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.mTop;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget getPreviousChainMember(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.getPreviousChainMember(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int i5) {
        if (i5 == 0) {
            return this.mRelX;
        }
        if (i5 == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int i5) {
        if (i5 == 0) {
            return this.mHorizontalRun;
        }
        if (i5 == 1) {
            return this.mVerticalRun;
        }
        return null;
    }

    public void getSceneString(StringBuilder sb) {
        sb.append("  " + this.stringId + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.mWidth);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.mHeight);
        sb.append("\n");
        sb.append("    actualLeft:" + this.mX);
        sb.append("\n");
        sb.append("    actualTop:" + this.mY);
        sb.append("\n");
        getSceneString(sb, TtmlNode.LEFT, this.mLeft);
        getSceneString(sb, "top", this.mTop);
        getSceneString(sb, TtmlNode.RIGHT, this.mRight);
        getSceneString(sb, "bottom", this.mBottom);
        getSceneString(sb, "baseline", this.mBaseline);
        getSceneString(sb, "centerX", this.mCenterX);
        getSceneString(sb, "centerY", this.mCenterY);
        getSceneString(sb, "    width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mListDimensionBehaviors[0], this.mWeight[0]);
        getSceneString(sb, "    height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mListDimensionBehaviors[1], this.mWeight[1]);
        serializeDimensionRatio(sb, "    dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(sb, "    horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb, "    verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb, "    horizontalChainStyle", this.mHorizontalChainStyle, 0);
        serializeAttribute(sb, "    verticalChainStyle", this.mVerticalChainStyle, 0);
        sb.append("  }");
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i5;
        if (this.mLeft != null) {
            i5 = this.mTop.mMargin;
        } else {
            i5 = 0;
        }
        if (this.mRight != null) {
            return i5 + this.mBottom.mMargin;
        }
        return i5;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getWrapBehaviorInParent() {
        return this.mWrapBehaviorInParent;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public boolean hasBaseline() {
        return this.mHasBaseline;
    }

    public boolean hasDanglingDimension(int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (i5 == 0) {
            if (this.mLeft.mTarget != null) {
                i9 = 1;
            } else {
                i9 = 0;
            }
            if (this.mRight.mTarget != null) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            if (i9 + i10 < 2) {
                return true;
            }
            return false;
        }
        if (this.mTop.mTarget != null) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (this.mBottom.mTarget != null) {
            i7 = 1;
        } else {
            i7 = 0;
        }
        int i11 = i6 + i7;
        if (this.mBaseline.mTarget != null) {
            i8 = 1;
        } else {
            i8 = 0;
        }
        if (i11 + i8 < 2) {
            return true;
        }
        return false;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.mAnchors.get(i5).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDimensionOverride() {
        if (this.mWidthOverride == -1 && this.mHeightOverride == -1) {
            return false;
        }
        return true;
    }

    public boolean hasResolvedTargets(int i5, int i6) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i5 == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft.mTarget;
            if (constraintAnchor3 == null || !constraintAnchor3.hasFinalValue() || (constraintAnchor2 = this.mRight.mTarget) == null || !constraintAnchor2.hasFinalValue() || (this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.mTarget.getFinalValue() + this.mLeft.getMargin()) < i6) {
                return false;
            }
            return true;
        }
        ConstraintAnchor constraintAnchor4 = this.mTop.mTarget;
        if (constraintAnchor4 == null || !constraintAnchor4.hasFinalValue() || (constraintAnchor = this.mBottom.mTarget) == null || !constraintAnchor.hasFinalValue() || (this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.mTarget.getFinalValue() + this.mTop.getMargin()) < i6) {
            return false;
        }
        return true;
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i5, int i6) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i5, i6, true);
    }

    public boolean isAnimated() {
        return this.mAnimated;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.mHorizontalSolvingPass;
    }

    public boolean isInBarrier(int i5) {
        return this.mIsInBarrier[i5];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return false;
        }
        return true;
    }

    public boolean isInPlaceholder() {
        return this.mInPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return false;
        }
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtualLayout;
    }

    public boolean isMeasureRequested() {
        if (!this.mMeasureRequested || this.mVisibility == 8) {
            return false;
        }
        return true;
    }

    public boolean isResolvedHorizontally() {
        if (this.mResolvedHorizontal) {
            return true;
        }
        if (!this.mLeft.hasFinalValue() || !this.mRight.hasFinalValue()) {
            return false;
        }
        return true;
    }

    public boolean isResolvedVertically() {
        if (this.mResolvedVertical) {
            return true;
        }
        if (!this.mTop.hasFinalValue() || !this.mBottom.hasFinalValue()) {
            return false;
        }
        return true;
    }

    public boolean isRoot() {
        if (this.mParent == null) {
            return true;
        }
        return false;
    }

    public boolean isSpreadHeight() {
        if (this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            return true;
        }
        return false;
    }

    public boolean isSpreadWidth() {
        if (this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            return true;
        }
        return false;
    }

    public boolean isVerticalSolvingPassDone() {
        return this.mVerticalSolvingPass;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void markHorizontalSolvingPassDone() {
        this.mHorizontalSolvingPass = true;
    }

    public void markVerticalSolvingPassDone() {
        this.mVerticalSolvingPass = true;
    }

    public boolean oppositeDimensionDependsOn(int i5) {
        char c5;
        if (i5 == 0) {
            c5 = 1;
        } else {
            c5 = 0;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i5];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c5];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3) {
            return true;
        }
        return false;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = Float.NaN;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f5;
        this.mVerticalBiasPercent = f5;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtualLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.mAnchors.get(i5).reset();
            }
        }
    }

    public void resetFinalResolution() {
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
        int size = this.mAnchors.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.mAnchors.get(i5).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void resetSolvingPassFlag() {
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
    }

    public StringBuilder serialize(StringBuilder sb) {
        sb.append("{\n");
        serializeAnchor(sb, TtmlNode.LEFT, this.mLeft);
        serializeAnchor(sb, "top", this.mTop);
        serializeAnchor(sb, TtmlNode.RIGHT, this.mRight);
        serializeAnchor(sb, "bottom", this.mBottom);
        serializeAnchor(sb, "baseline", this.mBaseline);
        serializeAnchor(sb, "centerX", this.mCenterX);
        serializeAnchor(sb, "centerY", this.mCenterY);
        serializeCircle(sb, this.mCenter, this.mCircleConstraintAngle);
        StringBuilder sb2 = sb;
        serializeSize(sb2, "width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        serializeSize(sb, "height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(sb, "dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(sb, "horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb, "verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        sb.append("}\n");
        return sb;
    }

    public void setAnimated(boolean z4) {
        this.mAnimated = z4;
    }

    public void setBaselineDistance(int i5) {
        boolean z4;
        this.mBaselineDistance = i5;
        if (i5 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mHasBaseline = z4;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i5) {
        if (i5 >= 0) {
            this.mContainerItemSkip = i5;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        createObjectVariable5.setName(str + ".baseline");
    }

    public void setDimension(int i5, int i6) {
        this.mWidth = i5;
        int i7 = this.mMinWidth;
        if (i5 < i7) {
            this.mWidth = i7;
        }
        this.mHeight = i6;
        int i8 = this.mMinHeight;
        if (i6 < i8) {
            this.mHeight = i8;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDimensionRatio(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0090
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x0090
        L_0x000b:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L_0x0039
            int r6 = r1 + -1
            if (r2 >= r6) goto L_0x0039
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002b
            goto L_0x0036
        L_0x002b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0035
            r3 = r4
            goto L_0x0036
        L_0x0035:
            r3 = r5
        L_0x0036:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L_0x0039:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L_0x0077
            int r1 = r1 - r4
            if (r2 >= r1) goto L_0x0077
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0086
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0086
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            if (r5 != r4) goto L_0x0071
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0071:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0077:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x0086
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0086:
            r9 = r0
        L_0x0087:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008f
            r8.mDimensionRatio = r9
            r8.mDimensionRatioSide = r5
        L_0x008f:
            return
        L_0x0090:
            r8.mDimensionRatio = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.setDimensionRatio(java.lang.String):void");
    }

    public void setFinalBaseline(int i5) {
        if (this.mHasBaseline) {
            int i6 = i5 - this.mBaselineDistance;
            int i7 = this.mHeight + i6;
            this.mY = i6;
            this.mTop.setFinalValue(i6);
            this.mBottom.setFinalValue(i7);
            this.mBaseline.setFinalValue(i5);
            this.mResolvedVertical = true;
        }
    }

    public void setFinalFrame(int i5, int i6, int i7, int i8, int i9, int i10) {
        setFrame(i5, i6, i7, i8);
        setBaselineDistance(i9);
        if (i10 == 0) {
            this.mResolvedHorizontal = true;
            this.mResolvedVertical = false;
        } else if (i10 == 1) {
            this.mResolvedHorizontal = false;
            this.mResolvedVertical = true;
        } else if (i10 == 2) {
            this.mResolvedHorizontal = true;
            this.mResolvedVertical = true;
        } else {
            this.mResolvedHorizontal = false;
            this.mResolvedVertical = false;
        }
    }

    public void setFinalHorizontal(int i5, int i6) {
        if (!this.mResolvedHorizontal) {
            this.mLeft.setFinalValue(i5);
            this.mRight.setFinalValue(i6);
            this.mX = i5;
            this.mWidth = i6 - i5;
            this.mResolvedHorizontal = true;
        }
    }

    public void setFinalLeft(int i5) {
        this.mLeft.setFinalValue(i5);
        this.mX = i5;
    }

    public void setFinalTop(int i5) {
        this.mTop.setFinalValue(i5);
        this.mY = i5;
    }

    public void setFinalVertical(int i5, int i6) {
        if (!this.mResolvedVertical) {
            this.mTop.setFinalValue(i5);
            this.mBottom.setFinalValue(i6);
            this.mY = i5;
            this.mHeight = i6 - i5;
            if (this.mHasBaseline) {
                this.mBaseline.setFinalValue(i5 + this.mBaselineDistance);
            }
            this.mResolvedVertical = true;
        }
    }

    public void setFrame(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11 = i7 - i5;
        int i12 = i8 - i6;
        this.mX = i5;
        this.mY = i6;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i11 < (i10 = this.mWidth)) {
            i11 = i10;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i12 < (i9 = this.mHeight)) {
            i12 = i9;
        }
        this.mWidth = i11;
        this.mHeight = i12;
        int i13 = this.mMinHeight;
        if (i12 < i13) {
            this.mHeight = i13;
        }
        int i14 = this.mMinWidth;
        if (i11 < i14) {
            this.mWidth = i14;
        }
        int i15 = this.mMatchConstraintMaxWidth;
        if (i15 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mWidth = Math.min(this.mWidth, i15);
        }
        int i16 = this.mMatchConstraintMaxHeight;
        if (i16 > 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mHeight = Math.min(this.mHeight, i16);
        }
        int i17 = this.mWidth;
        if (i11 != i17) {
            this.mWidthOverride = i17;
        }
        int i18 = this.mHeight;
        if (i12 != i18) {
            this.mHeightOverride = i18;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i5) {
        int i6 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i6 == 1) {
            this.mLeft.mGoneMargin = i5;
        } else if (i6 == 2) {
            this.mTop.mGoneMargin = i5;
        } else if (i6 == 3) {
            this.mRight.mGoneMargin = i5;
        } else if (i6 == 4) {
            this.mBottom.mGoneMargin = i5;
        } else if (i6 == 5) {
            this.mBaseline.mGoneMargin = i5;
        }
    }

    public void setHasBaseline(boolean z4) {
        this.mHasBaseline = z4;
    }

    public void setHeight(int i5) {
        this.mHeight = i5;
        int i6 = this.mMinHeight;
        if (i5 < i6) {
            this.mHeight = i6;
        }
    }

    public void setHeightWrapContent(boolean z4) {
        this.mIsHeightWrapContent = z4;
    }

    public void setHorizontalBiasPercent(float f5) {
        this.mHorizontalBiasPercent = f5;
    }

    public void setHorizontalChainStyle(int i5) {
        this.mHorizontalChainStyle = i5;
    }

    public void setHorizontalDimension(int i5, int i6) {
        this.mX = i5;
        int i7 = i6 - i5;
        this.mWidth = i7;
        int i8 = this.mMinWidth;
        if (i7 < i8) {
            this.mWidth = i8;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i5, int i6, int i7, float f5) {
        this.mMatchConstraintDefaultWidth = i5;
        this.mMatchConstraintMinWidth = i6;
        if (i7 == Integer.MAX_VALUE) {
            i7 = 0;
        }
        this.mMatchConstraintMaxWidth = i7;
        this.mMatchConstraintPercentWidth = f5;
        if (f5 > 0.0f && f5 < 1.0f && i5 == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f5) {
        this.mWeight[0] = f5;
    }

    /* access modifiers changed from: protected */
    public void setInBarrier(int i5, boolean z4) {
        this.mIsInBarrier[i5] = z4;
    }

    public void setInPlaceholder(boolean z4) {
        this.mInPlaceholder = z4;
    }

    public void setInVirtualLayout(boolean z4) {
        this.mInVirtualLayout = z4;
    }

    public void setLastMeasureSpec(int i5, int i6) {
        this.mLastHorizontalMeasureSpec = i5;
        this.mLastVerticalMeasureSpec = i6;
        setMeasureRequested(false);
    }

    public void setLength(int i5, int i6) {
        if (i6 == 0) {
            setWidth(i5);
        } else if (i6 == 1) {
            setHeight(i5);
        }
    }

    public void setMaxHeight(int i5) {
        this.mMaxDimension[1] = i5;
    }

    public void setMaxWidth(int i5) {
        this.mMaxDimension[0] = i5;
    }

    public void setMeasureRequested(boolean z4) {
        this.mMeasureRequested = z4;
    }

    public void setMinHeight(int i5) {
        if (i5 < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i5;
        }
    }

    public void setMinWidth(int i5) {
        if (i5 < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i5;
        }
    }

    public void setOffset(int i5, int i6) {
        this.mOffsetX = i5;
        this.mOffsetY = i6;
    }

    public void setOrigin(int i5, int i6) {
        this.mX = i5;
        this.mY = i6;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int i5, int i6) {
        if (i6 == 0) {
            this.mRelX = i5;
        } else if (i6 == 1) {
            this.mRelY = i5;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f5) {
        this.mVerticalBiasPercent = f5;
    }

    public void setVerticalChainStyle(int i5) {
        this.mVerticalChainStyle = i5;
    }

    public void setVerticalDimension(int i5, int i6) {
        this.mY = i5;
        int i7 = i6 - i5;
        this.mHeight = i7;
        int i8 = this.mMinHeight;
        if (i7 < i8) {
            this.mHeight = i8;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i5, int i6, int i7, float f5) {
        this.mMatchConstraintDefaultHeight = i5;
        this.mMatchConstraintMinHeight = i6;
        if (i7 == Integer.MAX_VALUE) {
            i7 = 0;
        }
        this.mMatchConstraintMaxHeight = i7;
        this.mMatchConstraintPercentHeight = f5;
        if (f5 > 0.0f && f5 < 1.0f && i5 == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f5) {
        this.mWeight[1] = f5;
    }

    public void setVisibility(int i5) {
        this.mVisibility = i5;
    }

    public void setWidth(int i5) {
        this.mWidth = i5;
        int i6 = this.mMinWidth;
        if (i5 < i6) {
            this.mWidth = i6;
        }
    }

    public void setWidthWrapContent(boolean z4) {
        this.mIsWidthWrapContent = z4;
    }

    public void setWrapBehaviorInParent(int i5) {
        if (i5 >= 0 && i5 <= 3) {
            this.mWrapBehaviorInParent = i5;
        }
    }

    public void setX(int i5) {
        this.mX = i5;
    }

    public void setY(int i5) {
        this.mY = i5;
    }

    public void setupDimensionRatio(boolean z4, boolean z5, boolean z6, boolean z7) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z6 && !z7) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z6 && z7) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i5 = this.mMatchConstraintMinWidth;
            if (i5 > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (i5 == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(")");
        return sb.toString();
    }

    public void updateFromRuns(boolean z4, boolean z5) {
        int i5;
        int i6;
        boolean isResolved = z4 & this.mHorizontalRun.isResolved();
        boolean isResolved2 = z5 & this.mVerticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.mHorizontalRun;
        int i7 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.mVerticalRun;
        int i8 = verticalWidgetRun.start.value;
        int i9 = horizontalWidgetRun.end.value;
        int i10 = verticalWidgetRun.end.value;
        int i11 = i10 - i8;
        if (i9 - i7 < 0 || i11 < 0 || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE || i9 == Integer.MIN_VALUE || i9 == Integer.MAX_VALUE || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE) {
            i9 = 0;
            i7 = 0;
            i10 = 0;
            i8 = 0;
        }
        int i12 = i9 - i7;
        int i13 = i10 - i8;
        if (isResolved) {
            this.mX = i7;
        }
        if (isResolved2) {
            this.mY = i8;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i12 < (i6 = this.mWidth)) {
                i12 = i6;
            }
            this.mWidth = i12;
            int i14 = this.mMinWidth;
            if (i12 < i14) {
                this.mWidth = i14;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i13 < (i5 = this.mHeight)) {
                i13 = i5;
            }
            this.mHeight = i13;
            int i15 = this.mMinHeight;
            if (i13 < i15) {
                this.mHeight = i15;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z4) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z4 && (horizontalWidgetRun = this.mHorizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z4 && (verticalWidgetRun = this.mVerticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i5 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i5 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i5) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z4;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type != type5) {
            ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER_X;
            if (type == type6 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor anchor = getAnchor(type4);
                ConstraintAnchor anchor2 = constraintWidget.getAnchor(type2);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.RIGHT);
                anchor.connect(anchor2, 0);
                anchor3.connect(anchor2, 0);
                getAnchor(type6).connect(anchor2, 0);
                return;
            }
            ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_Y;
            if (type == type7 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor anchor4 = constraintWidget.getAnchor(type2);
                getAnchor(type3).connect(anchor4, 0);
                getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor4, 0);
                getAnchor(type7).connect(anchor4, 0);
            } else if (type == type6 && type2 == type6) {
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
                getAnchor(type8).connect(constraintWidget.getAnchor(type8), 0);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
                getAnchor(type9).connect(constraintWidget.getAnchor(type9), 0);
                getAnchor(type6).connect(constraintWidget.getAnchor(type2), 0);
            } else if (type == type7 && type2 == type7) {
                ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
                getAnchor(type10).connect(constraintWidget.getAnchor(type10), 0);
                ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
                getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0);
                getAnchor(type7).connect(constraintWidget.getAnchor(type2), 0);
            } else {
                ConstraintAnchor anchor5 = getAnchor(type);
                ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
                if (anchor5.isValidConnection(anchor6)) {
                    ConstraintAnchor.Type type12 = ConstraintAnchor.Type.BASELINE;
                    if (type == type12) {
                        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.TOP);
                        ConstraintAnchor anchor8 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                        if (anchor7 != null) {
                            anchor7.reset();
                        }
                        if (anchor8 != null) {
                            anchor8.reset();
                        }
                    } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor anchor9 = getAnchor(type12);
                        if (anchor9 != null) {
                            anchor9.reset();
                        }
                        ConstraintAnchor anchor10 = getAnchor(type5);
                        if (anchor10.getTarget() != anchor6) {
                            anchor10.reset();
                        }
                        ConstraintAnchor opposite = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor11 = getAnchor(type7);
                        if (anchor11.isConnected()) {
                            opposite.reset();
                            anchor11.reset();
                        }
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor anchor12 = getAnchor(type5);
                        if (anchor12.getTarget() != anchor6) {
                            anchor12.reset();
                        }
                        ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor13 = getAnchor(type6);
                        if (anchor13.isConnected()) {
                            opposite2.reset();
                            anchor13.reset();
                        }
                    }
                    anchor5.connect(anchor6, i5);
                }
            }
        } else if (type2 == type5) {
            ConstraintAnchor.Type type13 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor anchor14 = getAnchor(type13);
            ConstraintAnchor.Type type14 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor anchor15 = getAnchor(type14);
            ConstraintAnchor.Type type15 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor anchor16 = getAnchor(type15);
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor anchor17 = getAnchor(type16);
            boolean z5 = true;
            if ((anchor14 == null || !anchor14.isConnected()) && (anchor15 == null || !anchor15.isConnected())) {
                connect(type13, constraintWidget, type13, 0);
                connect(type14, constraintWidget, type14, 0);
                z4 = true;
            } else {
                z4 = false;
            }
            if ((anchor16 == null || !anchor16.isConnected()) && (anchor17 == null || !anchor17.isConnected())) {
                connect(type15, constraintWidget, type15, 0);
                connect(type16, constraintWidget, type16, 0);
            } else {
                z5 = false;
            }
            if (z4 && z5) {
                getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
            } else if (z4) {
                ConstraintAnchor.Type type17 = ConstraintAnchor.Type.CENTER_X;
                getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            } else if (z5) {
                ConstraintAnchor.Type type18 = ConstraintAnchor.Type.CENTER_Y;
                getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            }
        } else {
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.LEFT;
            if (type2 == type19 || type2 == ConstraintAnchor.Type.RIGHT) {
                connect(type19, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                return;
            }
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.TOP;
            if (type2 == type20 || type2 == ConstraintAnchor.Type.BOTTOM) {
                connect(type20, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
            }
        }
    }

    private void serializeAttribute(StringBuilder sb, String str, int i5, int i6) {
        if (i5 != i6) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(i5);
            sb.append(",\n");
        }
    }

    private void serializeAttribute(StringBuilder sb, String str, String str2, String str3) {
        if (!str3.equals(str2)) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(str2);
            sb.append(",\n");
        }
    }

    public void setDimensionRatio(float f5, int i5) {
        this.mDimensionRatio = f5;
        this.mDimensionRatioSide = i5;
    }

    public void setFrame(int i5, int i6, int i7) {
        if (i7 == 0) {
            setHorizontalDimension(i5, i6);
        } else if (i7 == 1) {
            setVerticalDimension(i5, i6);
        }
    }

    private void getSceneString(StringBuilder sb, String str, int i5, int i6, int i7, int i8, int i9, int i10, float f5, DimensionBehaviour dimensionBehaviour, float f6) {
        sb.append(str);
        sb.append(" :  {\n");
        serializeAttribute(sb, "      behavior", dimensionBehaviour.toString(), DimensionBehaviour.FIXED.toString());
        serializeAttribute(sb, "      size", i5, 0);
        serializeAttribute(sb, "      min", i6, 0);
        serializeAttribute(sb, "      max", i7, Integer.MAX_VALUE);
        serializeAttribute(sb, "      matchMin", i9, 0);
        serializeAttribute(sb, "      matchDef", i10, 0);
        serializeAttribute(sb, "      matchPercent", f5, 1.0f);
        sb.append("    },\n");
    }

    private void getSceneString(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget != null) {
            sb.append("    ");
            sb.append(str);
            sb.append(" : [ '");
            sb.append(constraintAnchor.mTarget);
            sb.append("'");
            if (!(constraintAnchor.mGoneMargin == Integer.MIN_VALUE && constraintAnchor.mMargin == 0)) {
                sb.append(",");
                sb.append(constraintAnchor.mMargin);
                if (constraintAnchor.mGoneMargin != Integer.MIN_VALUE) {
                    sb.append(",");
                    sb.append(constraintAnchor.mGoneMargin);
                    sb.append(",");
                }
            }
            sb.append(" ] ,\n");
        }
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.mHorizontalRun = null;
        this.mVerticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.mOptimizeWrapO = false;
        this.mOptimizeWrapOnResolved = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = Float.NaN;
        this.mHasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f5;
        this.mVerticalBiasPercent = f5;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(int i5, int i6, int i7, int i8) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.mHorizontalRun = null;
        this.mVerticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.mOptimizeWrapO = false;
        this.mOptimizeWrapOnResolved = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = Float.NaN;
        this.mHasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f5;
        this.mVerticalBiasPercent = f5;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = i5;
        this.mY = i6;
        this.mWidth = i7;
        this.mHeight = i8;
        addAnchors();
    }

    public ConstraintWidget(String str, int i5, int i6, int i7, int i8) {
        this(i5, i6, i7, i8);
        setDebugName(str);
    }

    public ConstraintWidget(int i5, int i6) {
        this(0, 0, i5, i6);
    }

    public ConstraintWidget(String str, int i5, int i6) {
        this(i5, i6);
        setDebugName(str);
    }
}
