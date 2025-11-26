package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private int[] mAlignedDimensions = null;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ConstraintWidget[] mDisplayedWidgets;
    /* access modifiers changed from: private */
    public int mDisplayedWidgetsCount = 0;
    /* access modifiers changed from: private */
    public float mFirstHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mFirstHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mFirstVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mFirstVerticalStyle = -1;
    /* access modifiers changed from: private */
    public int mHorizontalAlign = 2;
    /* access modifiers changed from: private */
    public float mHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mHorizontalGap = 0;
    /* access modifiers changed from: private */
    public int mHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mLastHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mLastHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mLastVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mLastVerticalStyle = -1;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    /* access modifiers changed from: private */
    public int mVerticalAlign = 2;
    /* access modifiers changed from: private */
    public float mVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mVerticalGap = 0;
    /* access modifiers changed from: private */
    public int mVerticalStyle = -1;
    private int mWrapMode = 0;

    private class WidgetsList {
        /* access modifiers changed from: private */
        public ConstraintWidget mBiggest = null;
        int mBiggestDimension = 0;
        private ConstraintAnchor mBottom;
        private int mCount = 0;
        private int mHeight = 0;
        private ConstraintAnchor mLeft;
        private int mMax = 0;
        private int mNbMatchConstraintsWidgets = 0;
        private int mOrientation;
        private int mPaddingBottom = 0;
        private int mPaddingLeft = 0;
        private int mPaddingRight = 0;
        private int mPaddingTop = 0;
        private ConstraintAnchor mRight;
        private int mStartIndex = 0;
        private ConstraintAnchor mTop;
        private int mWidth = 0;

        WidgetsList(int i5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i6) {
            this.mOrientation = i5;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i6;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.mBiggest = null;
            this.mBiggestDimension = 0;
            int i5 = this.mCount;
            int i6 = 0;
            while (i6 < i5 && this.mStartIndex + i6 < Flow.this.mDisplayedWidgetsCount) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i6];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int access$000 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        access$000 = 0;
                    }
                    this.mWidth += width + access$000;
                    int access$300 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.mBiggest == null || this.mBiggestDimension < access$300) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = access$300;
                        this.mHeight = access$300;
                    }
                } else {
                    int access$200 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int access$3002 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int access$100 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        access$100 = 0;
                    }
                    this.mHeight += access$3002 + access$100;
                    if (this.mBiggest == null || this.mBiggestDimension < access$200) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = access$200;
                        this.mWidth = access$200;
                    }
                }
                i6++;
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            int i5 = 0;
            if (this.mOrientation == 0) {
                int access$200 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    access$200 = 0;
                }
                int access$000 = Flow.this.mHorizontalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i5 = access$000;
                }
                this.mWidth += access$200 + i5;
                int access$300 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.mBiggest == null || this.mBiggestDimension < access$300) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = access$300;
                    this.mHeight = access$300;
                }
            } else {
                int access$2002 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int access$3002 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    access$3002 = 0;
                }
                int access$100 = Flow.this.mVerticalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i5 = access$100;
                }
                this.mHeight += access$3002 + i5;
                if (this.mBiggest == null || this.mBiggestDimension < access$2002) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = access$2002;
                    this.mWidth = access$2002;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.mBiggestDimension = 0;
            this.mBiggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:57:0x00e1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void createConstraints(boolean r18, int r19, boolean r20) {
            /*
                r17 = this;
                r0 = r17
                int r1 = r0.mCount
                r2 = 0
                r3 = r2
            L_0x0006:
                if (r3 >= r1) goto L_0x0027
                int r4 = r0.mStartIndex
                int r4 = r4 + r3
                androidx.constraintlayout.core.widgets.Flow r5 = androidx.constraintlayout.core.widgets.Flow.this
                int r5 = r5.mDisplayedWidgetsCount
                if (r4 < r5) goto L_0x0014
                goto L_0x0027
            L_0x0014:
                androidx.constraintlayout.core.widgets.Flow r4 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r4.mDisplayedWidgets
                int r5 = r0.mStartIndex
                int r5 = r5 + r3
                r4 = r4[r5]
                if (r4 == 0) goto L_0x0024
                r4.resetAnchors()
            L_0x0024:
                int r3 = r3 + 1
                goto L_0x0006
            L_0x0027:
                if (r1 == 0) goto L_0x0389
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mBiggest
                if (r3 != 0) goto L_0x002f
                goto L_0x0389
            L_0x002f:
                if (r20 == 0) goto L_0x0035
                if (r19 != 0) goto L_0x0035
                r4 = 1
                goto L_0x0036
            L_0x0035:
                r4 = r2
            L_0x0036:
                r5 = -1
                r6 = r2
                r7 = r5
                r8 = r7
            L_0x003a:
                if (r6 >= r1) goto L_0x0069
                if (r18 == 0) goto L_0x0042
                int r9 = r1 + -1
                int r9 = r9 - r6
                goto L_0x0043
            L_0x0042:
                r9 = r6
            L_0x0043:
                int r10 = r0.mStartIndex
                int r10 = r10 + r9
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mDisplayedWidgetsCount
                if (r10 < r11) goto L_0x004f
                goto L_0x0069
            L_0x004f:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.mDisplayedWidgets
                int r11 = r0.mStartIndex
                int r11 = r11 + r9
                r9 = r10[r11]
                if (r9 == 0) goto L_0x0066
                int r9 = r9.getVisibility()
                if (r9 != 0) goto L_0x0066
                if (r7 != r5) goto L_0x0065
                r7 = r6
            L_0x0065:
                r8 = r6
            L_0x0066:
                int r6 = r6 + 1
                goto L_0x003a
            L_0x0069:
                int r6 = r0.mOrientation
                r9 = 0
                if (r6 != 0) goto L_0x0213
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r0.mBiggest
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.mVerticalStyle
                r6.setVerticalChainStyle(r10)
                int r10 = r0.mPaddingTop
                if (r19 <= 0) goto L_0x0084
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mVerticalGap
                int r10 = r10 + r11
            L_0x0084:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.mTop
                r11.connect(r12, r10)
                if (r20 == 0) goto L_0x0096
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r6.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mBottom
                int r12 = r0.mPaddingBottom
                r10.connect(r11, r12)
            L_0x0096:
                if (r19 <= 0) goto L_0x00a3
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mTop
                androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.mOwner
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mTop
                r10.connect(r11, r2)
            L_0x00a3:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.mVerticalAlign
                r11 = 3
                if (r10 != r11) goto L_0x00dd
                boolean r10 = r6.hasBaseline()
                if (r10 != 0) goto L_0x00dd
                r10 = r2
            L_0x00b3:
                if (r10 >= r1) goto L_0x00dd
                if (r18 == 0) goto L_0x00bb
                int r12 = r1 + -1
                int r12 = r12 - r10
                goto L_0x00bc
            L_0x00bb:
                r12 = r10
            L_0x00bc:
                int r13 = r0.mStartIndex
                int r13 = r13 + r12
                androidx.constraintlayout.core.widgets.Flow r14 = androidx.constraintlayout.core.widgets.Flow.this
                int r14 = r14.mDisplayedWidgetsCount
                if (r13 < r14) goto L_0x00c8
                goto L_0x00dd
            L_0x00c8:
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r13.mDisplayedWidgets
                int r14 = r0.mStartIndex
                int r14 = r14 + r12
                r12 = r13[r14]
                boolean r13 = r12.hasBaseline()
                if (r13 == 0) goto L_0x00da
                goto L_0x00de
            L_0x00da:
                int r10 = r10 + 1
                goto L_0x00b3
            L_0x00dd:
                r12 = r6
            L_0x00de:
                r10 = r2
            L_0x00df:
                if (r10 >= r1) goto L_0x0389
                if (r18 == 0) goto L_0x00e7
                int r13 = r1 + -1
                int r13 = r13 - r10
                goto L_0x00e8
            L_0x00e7:
                r13 = r10
            L_0x00e8:
                int r14 = r0.mStartIndex
                int r14 = r14 + r13
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.mDisplayedWidgetsCount
                if (r14 < r15) goto L_0x00f5
                goto L_0x0389
            L_0x00f5:
                androidx.constraintlayout.core.widgets.Flow r14 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r14 = r14.mDisplayedWidgets
                int r15 = r0.mStartIndex
                int r15 = r15 + r13
                r14 = r14[r15]
                if (r14 != 0) goto L_0x0106
                r14 = r9
                r9 = r11
                goto L_0x020d
            L_0x0106:
                if (r10 != 0) goto L_0x0114
                androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r14.mLeft
                r16 = 1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.mLeft
                int r11 = r0.mPaddingLeft
                r14.connect((androidx.constraintlayout.core.widgets.ConstraintAnchor) r15, (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3, (int) r11)
                goto L_0x0116
            L_0x0114:
                r16 = 1
            L_0x0116:
                if (r13 != 0) goto L_0x0174
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.mHorizontalStyle
                r11 = 1065353216(0x3f800000, float:1.0)
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.mHorizontalBias
                if (r18 == 0) goto L_0x012a
                float r13 = r11 - r13
            L_0x012a:
                int r15 = r0.mStartIndex
                if (r15 != 0) goto L_0x014e
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.mFirstHorizontalStyle
                if (r15 == r5) goto L_0x014e
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.mFirstHorizontalStyle
                if (r18 == 0) goto L_0x0147
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.mFirstHorizontalBias
            L_0x0144:
                float r11 = r11 - r13
            L_0x0145:
                r13 = r11
                goto L_0x016e
            L_0x0147:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                float r11 = r11.mFirstHorizontalBias
                goto L_0x0145
            L_0x014e:
                if (r20 == 0) goto L_0x016e
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.mLastHorizontalStyle
                if (r15 == r5) goto L_0x016e
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.mLastHorizontalStyle
                if (r18 == 0) goto L_0x0167
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.mLastHorizontalBias
                goto L_0x0144
            L_0x0167:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                float r11 = r11.mLastHorizontalBias
                goto L_0x0145
            L_0x016e:
                r14.setHorizontalChainStyle(r3)
                r14.setHorizontalBiasPercent(r13)
            L_0x0174:
                int r3 = r1 + -1
                if (r10 != r3) goto L_0x0181
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mRight
                int r13 = r0.mPaddingRight
                r14.connect((androidx.constraintlayout.core.widgets.ConstraintAnchor) r3, (androidx.constraintlayout.core.widgets.ConstraintAnchor) r11, (int) r13)
            L_0x0181:
                if (r9 == 0) goto L_0x01ab
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.mRight
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.mHorizontalGap
                r3.connect(r11, r13)
                if (r10 != r7) goto L_0x0199
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mLeft
                int r11 = r0.mPaddingLeft
                r3.setGoneMargin(r11)
            L_0x0199:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r9.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r14.mLeft
                r3.connect(r11, r2)
                int r3 = r8 + 1
                if (r10 != r3) goto L_0x01ab
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r9.mRight
                int r9 = r0.mPaddingRight
                r3.setGoneMargin(r9)
            L_0x01ab:
                if (r14 == r6) goto L_0x020c
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.mVerticalAlign
                r9 = 3
                if (r3 != r9) goto L_0x01cc
                boolean r3 = r12.hasBaseline()
                if (r3 == 0) goto L_0x01cc
                if (r14 == r12) goto L_0x01cc
                boolean r3 = r14.hasBaseline()
                if (r3 == 0) goto L_0x01cc
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mBaseline
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.mBaseline
                r3.connect(r11, r2)
                goto L_0x020d
            L_0x01cc:
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.mVerticalAlign
                if (r3 == 0) goto L_0x0204
                r11 = r16
                if (r3 == r11) goto L_0x01fc
                if (r4 == 0) goto L_0x01ed
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mTop
                int r13 = r0.mPaddingTop
                r3.connect(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mBottom
                int r13 = r0.mPaddingBottom
                r3.connect(r11, r13)
                goto L_0x020d
            L_0x01ed:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mTop
                r3.connect(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mBottom
                r3.connect(r11, r2)
                goto L_0x020d
            L_0x01fc:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mBottom
                r3.connect(r11, r2)
                goto L_0x020d
            L_0x0204:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mTop
                r3.connect(r11, r2)
                goto L_0x020d
            L_0x020c:
                r9 = 3
            L_0x020d:
                int r10 = r10 + 1
                r11 = r9
                r9 = r14
                goto L_0x00df
            L_0x0213:
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mBiggest
                androidx.constraintlayout.core.widgets.Flow r6 = androidx.constraintlayout.core.widgets.Flow.this
                int r6 = r6.mHorizontalStyle
                r3.setHorizontalChainStyle(r6)
                int r6 = r0.mPaddingLeft
                if (r19 <= 0) goto L_0x0229
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.mHorizontalGap
                int r6 = r6 + r10
            L_0x0229:
                if (r18 == 0) goto L_0x024b
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mRight
                r10.connect(r11, r6)
                if (r20 == 0) goto L_0x023d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mLeft
                int r11 = r0.mPaddingRight
                r6.connect(r10, r11)
            L_0x023d:
                if (r19 <= 0) goto L_0x026a
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.mRight
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.mOwner
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mRight
                r6.connect(r10, r2)
                goto L_0x026a
            L_0x024b:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mLeft
                r10.connect(r11, r6)
                if (r20 == 0) goto L_0x025d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mRight
                int r11 = r0.mPaddingRight
                r6.connect(r10, r11)
            L_0x025d:
                if (r19 <= 0) goto L_0x026a
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.mLeft
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.mOwner
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mLeft
                r6.connect(r10, r2)
            L_0x026a:
                r6 = r2
            L_0x026b:
                if (r6 >= r1) goto L_0x0389
                int r10 = r0.mStartIndex
                int r10 = r10 + r6
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mDisplayedWidgetsCount
                if (r10 < r11) goto L_0x027a
                goto L_0x0389
            L_0x027a:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.mDisplayedWidgets
                int r11 = r0.mStartIndex
                int r11 = r11 + r6
                r10 = r10[r11]
                if (r10 != 0) goto L_0x028a
                r12 = 1
                goto L_0x0385
            L_0x028a:
                if (r6 != 0) goto L_0x02d6
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.mTop
                int r13 = r0.mPaddingTop
                r10.connect((androidx.constraintlayout.core.widgets.ConstraintAnchor) r11, (androidx.constraintlayout.core.widgets.ConstraintAnchor) r12, (int) r13)
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mVerticalStyle
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.mVerticalBias
                int r13 = r0.mStartIndex
                if (r13 != 0) goto L_0x02ba
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.mFirstVerticalStyle
                if (r13 == r5) goto L_0x02ba
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mFirstVerticalStyle
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.mFirstVerticalBias
                goto L_0x02d0
            L_0x02ba:
                if (r20 == 0) goto L_0x02d0
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.mLastVerticalStyle
                if (r13 == r5) goto L_0x02d0
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mLastVerticalStyle
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.mLastVerticalBias
            L_0x02d0:
                r10.setVerticalChainStyle(r11)
                r10.setVerticalBiasPercent(r12)
            L_0x02d6:
                int r11 = r1 + -1
                if (r6 != r11) goto L_0x02e3
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.mBottom
                int r13 = r0.mPaddingBottom
                r10.connect((androidx.constraintlayout.core.widgets.ConstraintAnchor) r11, (androidx.constraintlayout.core.widgets.ConstraintAnchor) r12, (int) r13)
            L_0x02e3:
                if (r9 == 0) goto L_0x030f
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r9.mBottom
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.mVerticalGap
                r11.connect(r12, r13)
                if (r6 != r7) goto L_0x02fb
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.mTop
                int r12 = r0.mPaddingTop
                r11.setGoneMargin(r12)
            L_0x02fb:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r10.mTop
                r11.connect(r12, r2)
                r16 = 1
                int r11 = r8 + 1
                if (r6 != r11) goto L_0x030f
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.mBottom
                int r11 = r0.mPaddingBottom
                r9.setGoneMargin(r11)
            L_0x030f:
                if (r10 == r3) goto L_0x0340
                r9 = 2
                if (r18 == 0) goto L_0x0342
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mHorizontalAlign
                if (r11 == 0) goto L_0x0339
                r12 = 1
                if (r11 == r12) goto L_0x0331
                if (r11 == r9) goto L_0x0322
                goto L_0x0340
            L_0x0322:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
                goto L_0x0340
            L_0x0331:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
                goto L_0x0340
            L_0x0339:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
            L_0x0340:
                r12 = 1
                goto L_0x0384
            L_0x0342:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mHorizontalAlign
                if (r11 == 0) goto L_0x037c
                r12 = 1
                if (r11 == r12) goto L_0x0374
                if (r11 == r9) goto L_0x0350
                goto L_0x0384
            L_0x0350:
                if (r4 == 0) goto L_0x0365
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mLeft
                int r13 = r0.mPaddingLeft
                r9.connect(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mRight
                int r13 = r0.mPaddingRight
                r9.connect(r11, r13)
                goto L_0x0384
            L_0x0365:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
                goto L_0x0384
            L_0x0374:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
                goto L_0x0384
            L_0x037c:
                r12 = 1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
            L_0x0384:
                r9 = r10
            L_0x0385:
                int r6 = r6 + 1
                goto L_0x026b
            L_0x0389:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.WidgetsList.createConstraints(boolean, int, boolean):void");
        }

        public int getHeight() {
            if (this.mOrientation == 1) {
                return this.mHeight - Flow.this.mVerticalGap;
            }
            return this.mHeight;
        }

        public int getWidth() {
            if (this.mOrientation == 0) {
                return this.mWidth - Flow.this.mHorizontalGap;
            }
            return this.mWidth;
        }

        public void measureMatchConstraints(int i5) {
            int i6 = this.mNbMatchConstraintsWidgets;
            if (i6 != 0) {
                int i7 = this.mCount;
                int i8 = i5 / i6;
                int i9 = 0;
                while (i9 < i7 && this.mStartIndex + i9 < Flow.this.mDisplayedWidgetsCount) {
                    ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i9];
                    if (this.mOrientation == 0) {
                        if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                            Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i8, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                        }
                    } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                        int i10 = i8;
                        Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i10);
                        i8 = i10;
                    }
                    i9++;
                }
                recomputeDimensions();
            }
        }

        public void setStartIndex(int i5) {
            this.mStartIndex = i5;
        }

        public void setup(int i5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i6, int i7, int i8, int i9, int i10) {
            this.mOrientation = i5;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i6;
            this.mPaddingTop = i7;
            this.mPaddingRight = i8;
            this.mPaddingBottom = i9;
            this.mMax = i10;
        }
    }

    private void createAlignedConstraints(boolean z4) {
        ConstraintWidget constraintWidget;
        float f5;
        int i5;
        if (this.mAlignedDimensions != null && this.mAlignedBiggestElementsInCols != null && this.mAlignedBiggestElementsInRows != null) {
            for (int i6 = 0; i6 < this.mDisplayedWidgetsCount; i6++) {
                this.mDisplayedWidgets[i6].resetAnchors();
            }
            int[] iArr = this.mAlignedDimensions;
            int i7 = iArr[0];
            int i8 = iArr[1];
            float f6 = this.mHorizontalBias;
            ConstraintWidget constraintWidget2 = null;
            int i9 = 0;
            while (i9 < i7) {
                if (z4) {
                    i5 = (i7 - i9) - 1;
                    f5 = 1.0f - this.mHorizontalBias;
                } else {
                    f5 = f6;
                    i5 = i9;
                }
                ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i5];
                if (!(constraintWidget3 == null || constraintWidget3.getVisibility() == 8)) {
                    if (i9 == 0) {
                        constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                        constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                        constraintWidget3.setHorizontalBiasPercent(f5);
                    }
                    if (i9 == i7 - 1) {
                        constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                    }
                    if (i9 > 0 && constraintWidget2 != null) {
                        constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                        constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
                i9++;
                f6 = f5;
            }
            for (int i10 = 0; i10 < i8; i10++) {
                ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i10];
                if (!(constraintWidget4 == null || constraintWidget4.getVisibility() == 8)) {
                    if (i10 == 0) {
                        constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                        constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                        constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                    }
                    if (i10 == i8 - 1) {
                        constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                    }
                    if (i10 > 0 && constraintWidget2 != null) {
                        constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                        constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i11 = 0; i11 < i7; i11++) {
                for (int i12 = 0; i12 < i8; i12++) {
                    int i13 = (i12 * i7) + i11;
                    if (this.mOrientation == 1) {
                        i13 = (i11 * i8) + i12;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                    if (!(i13 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i13]) == null || constraintWidget.getVisibility() == 8)) {
                        ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i11];
                        ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i12];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                            constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                            constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public int getWidgetHeight(ConstraintWidget constraintWidget, int i5) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i6 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i7 = (int) (constraintWidget.mMatchConstraintPercentHeight * ((float) i5));
                if (i7 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i7);
                }
                return i7;
            }
            constraintWidget2 = constraintWidget;
            if (i6 == 1) {
                return constraintWidget2.getHeight();
            }
            if (i6 == 3) {
                return (int) ((((float) constraintWidget2.getWidth()) * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getHeight();
    }

    /* access modifiers changed from: private */
    public int getWidgetWidth(ConstraintWidget constraintWidget, int i5) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i6 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i7 = (int) (constraintWidget.mMatchConstraintPercentWidth * ((float) i5));
                if (i7 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i7, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i7;
            }
            constraintWidget2 = constraintWidget;
            if (i6 == 1) {
                return constraintWidget2.getWidth();
            }
            if (i6 == 3) {
                return (int) ((((float) constraintWidget2.getHeight()) * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getWidth();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x011d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e  */
    private void measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            r10 = this;
            r0 = 0
            if (r13 != 0) goto L_0x0026
            int r1 = r10.mMaxElementsWrap
            if (r1 > 0) goto L_0x0023
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x000a:
            if (r2 >= r12) goto L_0x0023
            if (r2 <= 0) goto L_0x0011
            int r4 = r10.mHorizontalGap
            int r3 = r3 + r4
        L_0x0011:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0016
            goto L_0x0020
        L_0x0016:
            int r4 = r10.getWidgetWidth(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            int r1 = r1 + 1
        L_0x0020:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0023:
            r2 = r1
            r1 = r0
            goto L_0x0047
        L_0x0026:
            int r1 = r10.mMaxElementsWrap
            if (r1 > 0) goto L_0x0046
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x002d:
            if (r2 >= r12) goto L_0x0046
            if (r2 <= 0) goto L_0x0034
            int r4 = r10.mVerticalGap
            int r3 = r3 + r4
        L_0x0034:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0039
            goto L_0x0043
        L_0x0039:
            int r4 = r10.getWidgetHeight(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            int r1 = r1 + 1
        L_0x0043:
            int r2 = r2 + 1
            goto L_0x002d
        L_0x0046:
            r2 = r0
        L_0x0047:
            int[] r3 = r10.mAlignedDimensions
            if (r3 != 0) goto L_0x0050
            r3 = 2
            int[] r3 = new int[r3]
            r10.mAlignedDimensions = r3
        L_0x0050:
            r3 = 1
            if (r1 != 0) goto L_0x0055
            if (r13 == r3) goto L_0x0059
        L_0x0055:
            if (r2 != 0) goto L_0x005b
            if (r13 != 0) goto L_0x005b
        L_0x0059:
            r4 = r3
            goto L_0x005c
        L_0x005b:
            r4 = r0
        L_0x005c:
            if (r4 != 0) goto L_0x011d
            if (r13 != 0) goto L_0x006a
            float r1 = (float) r12
            float r5 = (float) r2
            float r1 = r1 / r5
            double r5 = (double) r1
            double r5 = java.lang.Math.ceil(r5)
            int r1 = (int) r5
            goto L_0x0073
        L_0x006a:
            float r2 = (float) r12
            float r5 = (float) r1
            float r2 = r2 / r5
            double r5 = (double) r2
            double r5 = java.lang.Math.ceil(r5)
            int r2 = (int) r5
        L_0x0073:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r10.mAlignedBiggestElementsInCols
            r6 = 0
            if (r5 == 0) goto L_0x0080
            int r7 = r5.length
            if (r7 >= r2) goto L_0x007c
            goto L_0x0080
        L_0x007c:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0084
        L_0x0080:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r2]
            r10.mAlignedBiggestElementsInCols = r5
        L_0x0084:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r10.mAlignedBiggestElementsInRows
            if (r5 == 0) goto L_0x0090
            int r7 = r5.length
            if (r7 >= r1) goto L_0x008c
            goto L_0x0090
        L_0x008c:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0094
        L_0x0090:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r1]
            r10.mAlignedBiggestElementsInRows = r5
        L_0x0094:
            r5 = r0
        L_0x0095:
            if (r5 >= r2) goto L_0x00d9
            r6 = r0
        L_0x0098:
            if (r6 >= r1) goto L_0x00d6
            int r7 = r6 * r2
            int r7 = r7 + r5
            if (r13 != r3) goto L_0x00a2
            int r7 = r5 * r1
            int r7 = r7 + r6
        L_0x00a2:
            int r8 = r11.length
            if (r7 < r8) goto L_0x00a6
            goto L_0x00d3
        L_0x00a6:
            r7 = r11[r7]
            if (r7 != 0) goto L_0x00ab
            goto L_0x00d3
        L_0x00ab:
            int r8 = r10.getWidgetWidth(r7, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r10.mAlignedBiggestElementsInCols
            r9 = r9[r5]
            if (r9 == 0) goto L_0x00bb
            int r9 = r9.getWidth()
            if (r9 >= r8) goto L_0x00bf
        L_0x00bb:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.mAlignedBiggestElementsInCols
            r8[r5] = r7
        L_0x00bf:
            int r8 = r10.getWidgetHeight(r7, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r10.mAlignedBiggestElementsInRows
            r9 = r9[r6]
            if (r9 == 0) goto L_0x00cf
            int r9 = r9.getHeight()
            if (r9 >= r8) goto L_0x00d3
        L_0x00cf:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.mAlignedBiggestElementsInRows
            r8[r6] = r7
        L_0x00d3:
            int r6 = r6 + 1
            goto L_0x0098
        L_0x00d6:
            int r5 = r5 + 1
            goto L_0x0095
        L_0x00d9:
            r5 = r0
            r6 = r5
        L_0x00db:
            if (r5 >= r2) goto L_0x00f0
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r7 = r10.mAlignedBiggestElementsInCols
            r7 = r7[r5]
            if (r7 == 0) goto L_0x00ed
            if (r5 <= 0) goto L_0x00e8
            int r8 = r10.mHorizontalGap
            int r6 = r6 + r8
        L_0x00e8:
            int r7 = r10.getWidgetWidth(r7, r14)
            int r6 = r6 + r7
        L_0x00ed:
            int r5 = r5 + 1
            goto L_0x00db
        L_0x00f0:
            r5 = r0
            r7 = r5
        L_0x00f2:
            if (r5 >= r1) goto L_0x0107
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.mAlignedBiggestElementsInRows
            r8 = r8[r5]
            if (r8 == 0) goto L_0x0104
            if (r5 <= 0) goto L_0x00ff
            int r9 = r10.mVerticalGap
            int r7 = r7 + r9
        L_0x00ff:
            int r8 = r10.getWidgetHeight(r8, r14)
            int r7 = r7 + r8
        L_0x0104:
            int r5 = r5 + 1
            goto L_0x00f2
        L_0x0107:
            r15[r0] = r6
            r15[r3] = r7
            if (r13 != 0) goto L_0x0115
            if (r6 <= r14) goto L_0x0059
            if (r2 <= r3) goto L_0x0059
            int r2 = r2 + -1
            goto L_0x005c
        L_0x0115:
            if (r7 <= r14) goto L_0x0059
            if (r1 <= r3) goto L_0x0059
            int r1 = r1 + -1
            goto L_0x005c
        L_0x011d:
            int[] r11 = r10.mAlignedDimensions
            r11[r0] = r2
            r11[r3] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i5, int i6, int i7, int[] iArr) {
        int i8;
        boolean z4;
        Flow flow;
        int i9;
        boolean z5;
        ConstraintAnchor constraintAnchor;
        boolean z6;
        int i10;
        Flow flow2 = this;
        int i11 = i5;
        if (i11 != 0) {
            flow2.mChainList.clear();
            int i12 = i7;
            WidgetsList widgetsList = new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i12);
            flow2.mChainList.add(widgetsList);
            if (i6 == 0) {
                i8 = 0;
                int i13 = 0;
                int i14 = 0;
                while (i14 < i11) {
                    ConstraintWidget constraintWidget = constraintWidgetArr[i14];
                    int widgetWidth = flow2.getWidgetWidth(constraintWidget, i12);
                    if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i8++;
                    }
                    int i15 = i8;
                    if ((i13 == i12 || flow2.mHorizontalGap + i13 + widgetWidth > i12) && widgetsList.mBiggest != null) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (!z6 && i14 > 0 && (i10 = flow2.mMaxElementsWrap) > 0 && i14 % i10 == 0) {
                        z6 = true;
                    }
                    if (z6) {
                        widgetsList = new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i12);
                        widgetsList.setStartIndex(i14);
                        flow2.mChainList.add(widgetsList);
                    } else if (i14 > 0) {
                        i13 += flow2.mHorizontalGap + widgetWidth;
                        widgetsList.add(constraintWidget);
                        i14++;
                        i8 = i15;
                    }
                    i13 = widgetWidth;
                    widgetsList.add(constraintWidget);
                    i14++;
                    i8 = i15;
                }
            } else {
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                while (i18 < i11) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i18];
                    int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i12);
                    if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i8++;
                    }
                    int i19 = i8;
                    if ((i17 == i12 || flow2.mVerticalGap + i17 + widgetHeight > i12) && widgetsList.mBiggest != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4 && i18 > 0 && (i9 = flow2.mMaxElementsWrap) > 0 && i18 % i9 == 0) {
                        z4 = true;
                    }
                    if (z4) {
                        widgetsList = new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i12);
                        flow = flow2;
                        widgetsList.setStartIndex(i18);
                        flow.mChainList.add(widgetsList);
                    } else {
                        flow = flow2;
                        if (i18 > 0) {
                            i17 += flow.mVerticalGap + widgetHeight;
                            widgetsList.add(constraintWidget2);
                            i18++;
                            i12 = i7;
                            i16 = i19;
                            flow2 = flow;
                        }
                    }
                    i17 = widgetHeight;
                    widgetsList.add(constraintWidget2);
                    i18++;
                    i12 = i7;
                    i16 = i19;
                    flow2 = flow;
                }
            }
            Flow flow3 = flow2;
            int size = flow3.mChainList.size();
            ConstraintAnchor constraintAnchor2 = flow3.mLeft;
            ConstraintAnchor constraintAnchor3 = flow3.mTop;
            ConstraintAnchor constraintAnchor4 = flow3.mRight;
            ConstraintAnchor constraintAnchor5 = flow3.mBottom;
            int paddingLeft = flow3.getPaddingLeft();
            int paddingTop = flow3.getPaddingTop();
            int paddingRight = flow3.getPaddingRight();
            int paddingBottom = flow3.getPaddingBottom();
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (i8 > 0 && z5) {
                for (int i20 = 0; i20 < size; i20++) {
                    WidgetsList widgetsList2 = flow3.mChainList.get(i20);
                    if (i6 == 0) {
                        widgetsList2.measureMatchConstraints(i7 - widgetsList2.getWidth());
                    } else {
                        widgetsList2.measureMatchConstraints(i7 - widgetsList2.getHeight());
                    }
                }
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchor2;
            int i21 = paddingBottom;
            int i22 = 0;
            int i23 = paddingRight;
            int i24 = paddingTop;
            int i25 = paddingLeft;
            ConstraintAnchor constraintAnchor7 = constraintAnchor5;
            ConstraintAnchor constraintAnchor8 = constraintAnchor4;
            ConstraintAnchor constraintAnchor9 = constraintAnchor3;
            int i26 = 0;
            for (int i27 = 0; i27 < size; i27++) {
                WidgetsList widgetsList3 = flow3.mChainList.get(i27);
                if (i6 == 0) {
                    if (i27 < size - 1) {
                        constraintAnchor7 = flow3.mChainList.get(i27 + 1).mBiggest.mTop;
                        i21 = 0;
                    } else {
                        constraintAnchor7 = flow3.mBottom;
                        i21 = flow3.getPaddingBottom();
                    }
                    int i28 = i22;
                    WidgetsList widgetsList4 = widgetsList3;
                    ConstraintAnchor constraintAnchor10 = widgetsList3.mBiggest.mBottom;
                    int i29 = i26;
                    widgetsList4.setup(i6, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i25, i24, i23, i21, i7);
                    int max = Math.max(i28, widgetsList4.getWidth());
                    int height = widgetsList4.getHeight() + i29;
                    if (i27 > 0) {
                        height += flow3.mVerticalGap;
                    }
                    int i30 = max;
                    i26 = height;
                    i22 = i30;
                    constraintAnchor9 = constraintAnchor10;
                    i24 = 0;
                } else {
                    int i31 = i22;
                    int i32 = i26;
                    WidgetsList widgetsList5 = widgetsList3;
                    if (i27 < size - 1) {
                        constraintAnchor = flow3.mChainList.get(i27 + 1).mBiggest.mLeft;
                        i23 = 0;
                    } else {
                        constraintAnchor = flow3.mRight;
                        i23 = flow3.getPaddingRight();
                    }
                    constraintAnchor8 = constraintAnchor;
                    ConstraintAnchor constraintAnchor11 = widgetsList5.mBiggest.mRight;
                    widgetsList5.setup(i6, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i25, i24, i23, i21, i7);
                    int width = widgetsList5.getWidth() + i31;
                    int max2 = Math.max(i32, widgetsList5.getHeight());
                    if (i27 > 0) {
                        width += flow3.mHorizontalGap;
                    }
                    int i33 = width;
                    i26 = max2;
                    i22 = i33;
                    i25 = 0;
                    constraintAnchor6 = constraintAnchor11;
                }
            }
            iArr[0] = i22;
            iArr[1] = i26;
        }
    }

    private void measureChainWrap_new(ConstraintWidget[] constraintWidgetArr, int i5, int i6, int i7, int[] iArr) {
        int i8;
        boolean z4;
        Flow flow;
        int i9;
        boolean z5;
        boolean z6;
        ConstraintAnchor constraintAnchor;
        boolean z7;
        int i10;
        Flow flow2 = this;
        int i11 = i5;
        if (i11 != 0) {
            flow2.mChainList.clear();
            int i12 = i7;
            WidgetsList widgetsList = new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i12);
            flow2.mChainList.add(widgetsList);
            boolean z8 = true;
            if (i6 == 0) {
                int i13 = 0;
                i8 = 0;
                int i14 = 0;
                int i15 = 0;
                while (i15 < i11) {
                    i13++;
                    ConstraintWidget constraintWidget = constraintWidgetArr[i15];
                    int widgetWidth = flow2.getWidgetWidth(constraintWidget, i12);
                    if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i8++;
                    }
                    int i16 = i8;
                    if ((i14 == i12 || flow2.mHorizontalGap + i14 + widgetWidth > i12) && widgetsList.mBiggest != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (!z7 && i15 > 0 && (i10 = flow2.mMaxElementsWrap) > 0 && i13 > i10) {
                        z7 = true;
                    }
                    if (z7) {
                        widgetsList = new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i12);
                        widgetsList.setStartIndex(i15);
                        flow2.mChainList.add(widgetsList);
                        i13 = 1;
                    } else if (i15 > 0) {
                        i14 += flow2.mHorizontalGap + widgetWidth;
                        widgetsList.add(constraintWidget);
                        i15++;
                        i8 = i16;
                    }
                    i14 = widgetWidth;
                    widgetsList.add(constraintWidget);
                    i15++;
                    i8 = i16;
                }
            } else {
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                while (i20 < i11) {
                    i17++;
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i20];
                    int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i12);
                    if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i8++;
                    }
                    int i21 = i8;
                    if ((i19 == i12 || flow2.mVerticalGap + i19 + widgetHeight > i12) && widgetsList.mBiggest != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4 && i20 > 0 && (i9 = flow2.mMaxElementsWrap) > 0 && i17 > i9) {
                        z4 = true;
                    }
                    if (z4) {
                        widgetsList = new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i12);
                        flow = flow2;
                        widgetsList.setStartIndex(i20);
                        flow.mChainList.add(widgetsList);
                        i17 = 1;
                    } else {
                        flow = flow2;
                        if (i20 > 0) {
                            i19 += flow.mVerticalGap + widgetHeight;
                            widgetsList.add(constraintWidget2);
                            i20++;
                            i12 = i7;
                            i18 = i21;
                            flow2 = flow;
                        }
                    }
                    i19 = widgetHeight;
                    widgetsList.add(constraintWidget2);
                    i20++;
                    i12 = i7;
                    i18 = i21;
                    flow2 = flow;
                }
            }
            Flow flow3 = flow2;
            int size = flow3.mChainList.size();
            ConstraintAnchor constraintAnchor2 = flow3.mLeft;
            ConstraintAnchor constraintAnchor3 = flow3.mTop;
            ConstraintAnchor constraintAnchor4 = flow3.mRight;
            ConstraintAnchor constraintAnchor5 = flow3.mBottom;
            int paddingLeft = flow3.getPaddingLeft();
            int paddingTop = flow3.getPaddingTop();
            int paddingRight = flow3.getPaddingRight();
            int paddingBottom = flow3.getPaddingBottom();
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (i8 > 0 && z5) {
                for (int i22 = 0; i22 < size; i22++) {
                    WidgetsList widgetsList2 = flow3.mChainList.get(i22);
                    if (i6 == 0) {
                        widgetsList2.measureMatchConstraints(i7 - widgetsList2.getWidth());
                    } else {
                        widgetsList2.measureMatchConstraints(i7 - widgetsList2.getHeight());
                    }
                }
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchor3;
            int i23 = paddingBottom;
            int i24 = 0;
            int i25 = 0;
            int i26 = paddingRight;
            int i27 = paddingTop;
            int i28 = paddingLeft;
            ConstraintAnchor constraintAnchor7 = constraintAnchor5;
            ConstraintAnchor constraintAnchor8 = constraintAnchor4;
            ConstraintAnchor constraintAnchor9 = constraintAnchor2;
            int i29 = 0;
            while (i25 < size) {
                WidgetsList widgetsList3 = flow3.mChainList.get(i25);
                if (i6 == 0) {
                    if (i25 < size - 1) {
                        constraintAnchor7 = flow3.mChainList.get(i25 + 1).mBiggest.mTop;
                        i23 = 0;
                    } else {
                        constraintAnchor7 = flow3.mBottom;
                        i23 = flow3.getPaddingBottom();
                    }
                    ConstraintAnchor constraintAnchor10 = widgetsList3.mBiggest.mBottom;
                    z6 = z8;
                    int i30 = i29;
                    int i31 = i24;
                    WidgetsList widgetsList4 = widgetsList3;
                    widgetsList4.setup(i6, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i28, i27, i26, i23, i7);
                    int max = Math.max(i30, widgetsList4.getWidth());
                    int height = widgetsList4.getHeight() + i31;
                    if (i25 > 0) {
                        height += flow3.mVerticalGap;
                    }
                    int i32 = max;
                    i24 = height;
                    i29 = i32;
                    constraintAnchor6 = constraintAnchor10;
                    i27 = 0;
                } else {
                    int i33 = i24;
                    z6 = z8;
                    int i34 = i29;
                    WidgetsList widgetsList5 = widgetsList3;
                    if (i25 < size - 1) {
                        constraintAnchor = flow3.mChainList.get(i25 + 1).mBiggest.mLeft;
                        i26 = 0;
                    } else {
                        constraintAnchor = flow3.mRight;
                        i26 = flow3.getPaddingRight();
                    }
                    constraintAnchor8 = constraintAnchor;
                    ConstraintAnchor constraintAnchor11 = widgetsList5.mBiggest.mRight;
                    widgetsList5.setup(i6, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i28, i27, i26, i23, i7);
                    int width = widgetsList5.getWidth() + i34;
                    int max2 = Math.max(i33, widgetsList5.getHeight());
                    if (i25 > 0) {
                        width += flow3.mHorizontalGap;
                    }
                    int i35 = width;
                    i24 = max2;
                    i29 = i35;
                    i28 = 0;
                    constraintAnchor9 = constraintAnchor11;
                }
                i25++;
                z8 = z6;
            }
            iArr[0] = i29;
            iArr[z8] = i24;
        }
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i5, int i6, int i7, int[] iArr) {
        WidgetsList widgetsList;
        int i8 = i5;
        if (i8 != 0) {
            if (this.mChainList.size() == 0) {
                widgetsList = new WidgetsList(i6, this.mLeft, this.mTop, this.mRight, this.mBottom, i7);
                this.mChainList.add(widgetsList);
            } else {
                WidgetsList widgetsList2 = this.mChainList.get(0);
                widgetsList2.clear();
                widgetsList2.setup(i6, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i7);
                widgetsList = widgetsList2;
            }
            for (int i9 = 0; i9 < i8; i9++) {
                widgetsList.add(constraintWidgetArr[i9]);
            }
            iArr[0] = widgetsList.getWidth();
            iArr[1] = widgetsList.getHeight();
        }
    }

    public void addToSolver(LinearSystem linearSystem, boolean z4) {
        boolean z5;
        boolean z6;
        boolean z7;
        super.addToSolver(linearSystem, z4);
        if (getParent() == null || !((ConstraintWidgetContainer) getParent()).isRtl()) {
            z5 = false;
        } else {
            z5 = true;
        }
        int i5 = this.mWrapMode;
        if (i5 != 0) {
            if (i5 == 1) {
                int size = this.mChainList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    WidgetsList widgetsList = this.mChainList.get(i6);
                    if (i6 == size - 1) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    widgetsList.createConstraints(z5, i6, z6);
                }
            } else if (i5 == 2) {
                createAlignedConstraints(z5);
            } else if (i5 == 3) {
                int size2 = this.mChainList.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    WidgetsList widgetsList2 = this.mChainList.get(i7);
                    if (i7 == size2 - 1) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    widgetsList2.createConstraints(z5, i7, z7);
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z5, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    public float getMaxElementsWrap() {
        return (float) this.mMaxElementsWrap;
    }

    public void measure(int i5, int i6, int i7, int i8) {
        int i9;
        ConstraintWidget[] constraintWidgetArr;
        boolean z4;
        int i10 = i5;
        int i11 = i6;
        int i12 = i7;
        int i13 = i8;
        if (this.mWidgetsCount <= 0 || measureChildren()) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int[] iArr = new int[2];
            int i14 = (i11 - paddingLeft) - paddingRight;
            int i15 = this.mOrientation;
            if (i15 == 1) {
                i14 = (i13 - paddingTop) - paddingBottom;
            }
            int i16 = i14;
            if (i15 == 0) {
                if (this.mHorizontalStyle == -1) {
                    this.mHorizontalStyle = 0;
                }
                if (this.mVerticalStyle == -1) {
                    this.mVerticalStyle = 0;
                }
            } else {
                if (this.mHorizontalStyle == -1) {
                    this.mHorizontalStyle = 0;
                }
                if (this.mVerticalStyle == -1) {
                    this.mVerticalStyle = 0;
                }
            }
            ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                i9 = this.mWidgetsCount;
                if (i17 >= i9) {
                    break;
                }
                if (this.mWidgets[i17].getVisibility() == 8) {
                    i18++;
                }
                i17++;
            }
            if (i18 > 0) {
                ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[(i9 - i18)];
                int i19 = 0;
                i9 = 0;
                while (i19 < this.mWidgetsCount) {
                    ConstraintWidget constraintWidget = this.mWidgets[i19];
                    ConstraintWidget[] constraintWidgetArr4 = constraintWidgetArr3;
                    if (constraintWidget.getVisibility() != 8) {
                        constraintWidgetArr4[i9] = constraintWidget;
                        i9++;
                    }
                    i19++;
                    constraintWidgetArr3 = constraintWidgetArr4;
                }
                constraintWidgetArr = constraintWidgetArr3;
            } else {
                constraintWidgetArr = constraintWidgetArr2;
            }
            int i20 = i9;
            this.mDisplayedWidgets = constraintWidgetArr;
            this.mDisplayedWidgetsCount = i20;
            int i21 = this.mWrapMode;
            if (i21 == 0) {
                measureNoWrap(constraintWidgetArr, i20, this.mOrientation, i16, iArr);
            } else if (i21 == 1) {
                measureChainWrap(constraintWidgetArr, i20, this.mOrientation, i16, iArr);
            } else if (i21 == 2) {
                measureAligned(constraintWidgetArr, i20, this.mOrientation, i16, iArr);
            } else if (i21 == 3) {
                measureChainWrap_new(constraintWidgetArr, i20, this.mOrientation, i16, iArr);
            }
            int i22 = iArr[0] + paddingLeft + paddingRight;
            int i23 = iArr[1] + paddingTop + paddingBottom;
            if (i10 == 1073741824) {
                i22 = i11;
            } else if (i10 == Integer.MIN_VALUE) {
                i22 = Math.min(i22, i11);
            } else if (i10 != 0) {
                i22 = 0;
            }
            if (i12 == 1073741824) {
                i23 = i13;
            } else if (i12 == Integer.MIN_VALUE) {
                i23 = Math.min(i23, i13);
            } else if (i12 != 0) {
                i23 = 0;
            }
            setMeasure(i22, i23);
            setWidth(i22);
            setHeight(i23);
            if (this.mWidgetsCount > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            needsCallbackFromSolver(z4);
            return;
        }
        setMeasure(0, 0);
        needsCallbackFromSolver(false);
    }

    public void setFirstHorizontalBias(float f5) {
        this.mFirstHorizontalBias = f5;
    }

    public void setFirstHorizontalStyle(int i5) {
        this.mFirstHorizontalStyle = i5;
    }

    public void setFirstVerticalBias(float f5) {
        this.mFirstVerticalBias = f5;
    }

    public void setFirstVerticalStyle(int i5) {
        this.mFirstVerticalStyle = i5;
    }

    public void setHorizontalAlign(int i5) {
        this.mHorizontalAlign = i5;
    }

    public void setHorizontalBias(float f5) {
        this.mHorizontalBias = f5;
    }

    public void setHorizontalGap(int i5) {
        this.mHorizontalGap = i5;
    }

    public void setHorizontalStyle(int i5) {
        this.mHorizontalStyle = i5;
    }

    public void setLastHorizontalBias(float f5) {
        this.mLastHorizontalBias = f5;
    }

    public void setLastHorizontalStyle(int i5) {
        this.mLastHorizontalStyle = i5;
    }

    public void setLastVerticalBias(float f5) {
        this.mLastVerticalBias = f5;
    }

    public void setLastVerticalStyle(int i5) {
        this.mLastVerticalStyle = i5;
    }

    public void setMaxElementsWrap(int i5) {
        this.mMaxElementsWrap = i5;
    }

    public void setOrientation(int i5) {
        this.mOrientation = i5;
    }

    public void setVerticalAlign(int i5) {
        this.mVerticalAlign = i5;
    }

    public void setVerticalBias(float f5) {
        this.mVerticalBias = f5;
    }

    public void setVerticalGap(int i5) {
        this.mVerticalGap = i5;
    }

    public void setVerticalStyle(int i5) {
        this.mVerticalStyle = i5;
    }

    public void setWrapMode(int i5) {
        this.mWrapMode = i5;
    }
}
