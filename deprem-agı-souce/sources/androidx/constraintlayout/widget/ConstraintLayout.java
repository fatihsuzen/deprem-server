package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.2.0-alpha04";
    private static SharedValues sSharedValues;
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    /* access modifiers changed from: private */
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    protected ConstraintLayoutStates mConstraintLayoutSpec = null;
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    protected boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    /* access modifiers changed from: protected */
    public ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    Measurer mMeasurer = new Measurer(this);
    /* access modifiers changed from: private */
    public Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private ArrayList<ValueModifier> mModifiers;
    private int mOnMeasureHeightMeasureSpec = 0;
    private int mOnMeasureWidthMeasureSpec = 0;
    /* access modifiers changed from: private */
    public int mOptimizationLevel = 257;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray<>();

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = r0
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.<clinit>():void");
        }
    }

    class Measurer implements BasicMeasure.Measurer {
        ConstraintLayout mLayout;
        int mLayoutHeightSpec;
        int mLayoutWidthSpec;
        int mPaddingBottom;
        int mPaddingHeight;
        int mPaddingTop;
        int mPaddingWidth;

        Measurer(ConstraintLayout constraintLayout) {
            this.mLayout = constraintLayout;
        }

        private boolean isSimilarSpec(int i5, int i6, int i7) {
            if (i5 == i6) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i5);
            int mode2 = View.MeasureSpec.getMode(i6);
            int size = View.MeasureSpec.getSize(i6);
            if (mode2 != 1073741824) {
                return false;
            }
            if ((mode == Integer.MIN_VALUE || mode == 0) && i7 == size) {
                return true;
            }
            return false;
        }

        public void captureLayoutInfo(int i5, int i6, int i7, int i8, int i9, int i10) {
            this.mPaddingTop = i7;
            this.mPaddingBottom = i8;
            this.mPaddingWidth = i9;
            this.mPaddingHeight = i10;
            this.mLayoutWidthSpec = i5;
            this.mLayoutHeightSpec = i6;
        }

        public final void didMeasures() {
            int childCount = this.mLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.mLayout.getChildAt(i5);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).updatePostMeasure(this.mLayout);
                }
            }
            int size = this.mLayout.mConstraintHelpers.size();
            if (size > 0) {
                for (int i6 = 0; i6 < size; i6++) {
                    ((ConstraintHelper) this.mLayout.mConstraintHelpers.get(i6)).updatePostMeasure(this.mLayout);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:103:0x01b8  */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x01cb  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0148  */
        @android.annotation.SuppressLint({"WrongCall"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void measure(androidx.constraintlayout.core.widgets.ConstraintWidget r22, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure r23) {
            /*
                r21 = this;
                r0 = r21
                r1 = r22
                r2 = r23
                if (r1 != 0) goto L_0x000a
                goto L_0x0318
            L_0x000a:
                int r3 = r1.getVisibility()
                r4 = 8
                r5 = 0
                if (r3 != r4) goto L_0x0020
                boolean r3 = r1.isInPlaceholder()
                if (r3 != 0) goto L_0x0020
                r2.measuredWidth = r5
                r2.measuredHeight = r5
                r2.measuredBaseline = r5
                return
            L_0x0020:
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r1.getParent()
                if (r3 != 0) goto L_0x0028
                goto L_0x0318
            L_0x0028:
                androidx.constraintlayout.widget.ConstraintLayout r3 = androidx.constraintlayout.widget.ConstraintLayout.this
                androidx.constraintlayout.core.Metrics r3 = r3.mMetrics
                r4 = 1
                if (r3 == 0) goto L_0x0041
                androidx.constraintlayout.widget.ConstraintLayout r3 = androidx.constraintlayout.widget.ConstraintLayout.this
                androidx.constraintlayout.core.Metrics r3 = r3.mMetrics
                int r6 = r3.mNumberOfMeasures
                int r6 = r6 + r4
                r3.mNumberOfMeasures = r6
                long r6 = java.lang.System.nanoTime()
                goto L_0x0043
            L_0x0041:
                r6 = 0
            L_0x0043:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.horizontalBehavior
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r2.verticalBehavior
                int r9 = r2.horizontalDimension
                int r10 = r2.verticalDimension
                int r11 = r0.mPaddingTop
                int r12 = r0.mPaddingBottom
                int r11 = r11 + r12
                int r12 = r0.mPaddingWidth
                java.lang.Object r13 = r1.getCompanionWidget()
                android.view.View r13 = (android.view.View) r13
                int[] r14 = androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour
                int r15 = r3.ordinal()
                r15 = r14[r15]
                if (r15 == r4) goto L_0x00ce
                r5 = 2
                if (r15 == r5) goto L_0x00c4
                r5 = 3
                if (r15 == r5) goto L_0x00b5
                r5 = 4
                if (r15 == r5) goto L_0x006e
                r5 = 0
                goto L_0x00d5
            L_0x006e:
                int r5 = r0.mLayoutWidthSpec
                r9 = -2
                int r5 = android.view.ViewGroup.getChildMeasureSpec(r5, r12, r9)
                int r9 = r1.mMatchConstraintDefaultWidth
                if (r9 != r4) goto L_0x007b
                r9 = r4
                goto L_0x007c
            L_0x007b:
                r9 = 0
            L_0x007c:
                int r12 = r2.measureStrategy
                int r15 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS
                if (r12 == r15) goto L_0x0086
                int r15 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS
                if (r12 != r15) goto L_0x00d5
            L_0x0086:
                int r12 = r13.getMeasuredHeight()
                int r15 = r1.getHeight()
                if (r12 != r15) goto L_0x0092
                r12 = r4
                goto L_0x0093
            L_0x0092:
                r12 = 0
            L_0x0093:
                int r15 = r2.measureStrategy
                int r4 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS
                if (r15 == r4) goto L_0x00a9
                if (r9 == 0) goto L_0x00a9
                if (r9 == 0) goto L_0x009f
                if (r12 != 0) goto L_0x00a9
            L_0x009f:
                boolean r4 = r13 instanceof androidx.constraintlayout.widget.Placeholder
                if (r4 != 0) goto L_0x00a9
                boolean r4 = r1.isResolvedHorizontally()
                if (r4 == 0) goto L_0x00d5
            L_0x00a9:
                int r4 = r1.getWidth()
                r5 = 1073741824(0x40000000, float:2.0)
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r5)
            L_0x00b3:
                r5 = r4
                goto L_0x00d5
            L_0x00b5:
                r5 = 1073741824(0x40000000, float:2.0)
                int r4 = r0.mLayoutWidthSpec
                int r9 = r1.getHorizontalMargin()
                int r12 = r12 + r9
                r9 = -1
                int r4 = android.view.ViewGroup.getChildMeasureSpec(r4, r12, r9)
                goto L_0x00b3
            L_0x00c4:
                r5 = 1073741824(0x40000000, float:2.0)
                int r4 = r0.mLayoutWidthSpec
                r9 = -2
                int r4 = android.view.ViewGroup.getChildMeasureSpec(r4, r12, r9)
                goto L_0x00b3
            L_0x00ce:
                r5 = 1073741824(0x40000000, float:2.0)
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r5)
                goto L_0x00b3
            L_0x00d5:
                int r4 = r8.ordinal()
                r4 = r14[r4]
                r9 = 1
                if (r4 == r9) goto L_0x0148
                r12 = 2
                if (r4 == r12) goto L_0x013e
                r10 = 3
                if (r4 == r10) goto L_0x012f
                r10 = 4
                if (r4 == r10) goto L_0x00e9
                r4 = 0
                goto L_0x014e
            L_0x00e9:
                int r4 = r0.mLayoutHeightSpec
                r10 = -2
                int r4 = android.view.ViewGroup.getChildMeasureSpec(r4, r11, r10)
                int r10 = r1.mMatchConstraintDefaultHeight
                if (r10 != r9) goto L_0x00f6
                r9 = 1
                goto L_0x00f7
            L_0x00f6:
                r9 = 0
            L_0x00f7:
                int r10 = r2.measureStrategy
                int r11 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS
                if (r10 == r11) goto L_0x0101
                int r11 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS
                if (r10 != r11) goto L_0x014e
            L_0x0101:
                int r10 = r13.getMeasuredWidth()
                int r11 = r1.getWidth()
                if (r10 != r11) goto L_0x010d
                r10 = 1
                goto L_0x010e
            L_0x010d:
                r10 = 0
            L_0x010e:
                int r11 = r2.measureStrategy
                int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS
                if (r11 == r12) goto L_0x0124
                if (r9 == 0) goto L_0x0124
                if (r9 == 0) goto L_0x011a
                if (r10 != 0) goto L_0x0124
            L_0x011a:
                boolean r9 = r13 instanceof androidx.constraintlayout.widget.Placeholder
                if (r9 != 0) goto L_0x0124
                boolean r9 = r1.isResolvedVertically()
                if (r9 == 0) goto L_0x014e
            L_0x0124:
                int r4 = r1.getHeight()
                r9 = 1073741824(0x40000000, float:2.0)
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r9)
                goto L_0x014e
            L_0x012f:
                r9 = 1073741824(0x40000000, float:2.0)
                int r4 = r0.mLayoutHeightSpec
                int r10 = r1.getVerticalMargin()
                int r11 = r11 + r10
                r10 = -1
                int r4 = android.view.ViewGroup.getChildMeasureSpec(r4, r11, r10)
                goto L_0x014e
            L_0x013e:
                r9 = 1073741824(0x40000000, float:2.0)
                int r4 = r0.mLayoutHeightSpec
                r10 = -2
                int r4 = android.view.ViewGroup.getChildMeasureSpec(r4, r11, r10)
                goto L_0x014e
            L_0x0148:
                r9 = 1073741824(0x40000000, float:2.0)
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r9)
            L_0x014e:
                androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r1.getParent()
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r9 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r9
                if (r9 == 0) goto L_0x01cb
                androidx.constraintlayout.widget.ConstraintLayout r10 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r10 = r10.mOptimizationLevel
                r11 = 256(0x100, float:3.59E-43)
                boolean r10 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r10, r11)
                if (r10 == 0) goto L_0x01cb
                int r10 = r13.getMeasuredWidth()
                int r11 = r1.getWidth()
                if (r10 != r11) goto L_0x01cb
                int r10 = r13.getMeasuredWidth()
                int r11 = r9.getWidth()
                if (r10 >= r11) goto L_0x01cb
                int r10 = r13.getMeasuredHeight()
                int r11 = r1.getHeight()
                if (r10 != r11) goto L_0x01cb
                int r10 = r13.getMeasuredHeight()
                int r9 = r9.getHeight()
                if (r10 >= r9) goto L_0x01cb
                int r9 = r13.getBaseline()
                int r10 = r1.getBaselineDistance()
                if (r9 != r10) goto L_0x01cb
                boolean r9 = r1.isMeasureRequested()
                if (r9 != 0) goto L_0x01cb
                int r9 = r1.getLastHorizontalMeasureSpec()
                int r10 = r1.getWidth()
                boolean r9 = r0.isSimilarSpec(r9, r5, r10)
                if (r9 == 0) goto L_0x01cb
                int r9 = r1.getLastVerticalMeasureSpec()
                int r10 = r1.getHeight()
                boolean r9 = r0.isSimilarSpec(r9, r4, r10)
                if (r9 == 0) goto L_0x01cb
                int r3 = r1.getWidth()
                r2.measuredWidth = r3
                int r3 = r1.getHeight()
                r2.measuredHeight = r3
                int r1 = r1.getBaselineDistance()
                r2.measuredBaseline = r1
                return
            L_0x01cb:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
                if (r3 != r9) goto L_0x01d1
                r10 = 1
                goto L_0x01d2
            L_0x01d1:
                r10 = 0
            L_0x01d2:
                if (r8 != r9) goto L_0x01d6
                r9 = 1
                goto L_0x01d7
            L_0x01d6:
                r9 = 0
            L_0x01d7:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
                if (r8 == r11) goto L_0x01e2
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r8 != r12) goto L_0x01e0
                goto L_0x01e2
            L_0x01e0:
                r8 = 0
                goto L_0x01e3
            L_0x01e2:
                r8 = 1
            L_0x01e3:
                if (r3 == r11) goto L_0x01ec
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r3 != r11) goto L_0x01ea
                goto L_0x01ec
            L_0x01ea:
                r3 = 0
                goto L_0x01ed
            L_0x01ec:
                r3 = 1
            L_0x01ed:
                r11 = 0
                if (r10 == 0) goto L_0x01f8
                float r12 = r1.mDimensionRatio
                int r12 = (r12 > r11 ? 1 : (r12 == r11 ? 0 : -1))
                if (r12 <= 0) goto L_0x01f8
                r12 = 1
                goto L_0x01f9
            L_0x01f8:
                r12 = 0
            L_0x01f9:
                if (r9 == 0) goto L_0x0203
                float r14 = r1.mDimensionRatio
                int r11 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
                if (r11 <= 0) goto L_0x0203
                r11 = 1
                goto L_0x0204
            L_0x0203:
                r11 = 0
            L_0x0204:
                if (r13 != 0) goto L_0x0208
                goto L_0x0318
            L_0x0208:
                android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r14 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r14
                int r15 = r2.measureStrategy
                r16 = r3
                int r3 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS
                if (r15 == r3) goto L_0x022f
                int r3 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS
                if (r15 == r3) goto L_0x022f
                if (r10 == 0) goto L_0x022f
                int r3 = r1.mMatchConstraintDefaultWidth
                if (r3 != 0) goto L_0x022f
                if (r9 == 0) goto L_0x022f
                int r3 = r1.mMatchConstraintDefaultHeight
                if (r3 == 0) goto L_0x0227
                goto L_0x022f
            L_0x0227:
                r19 = r6
                r4 = 0
                r9 = -1
                r10 = 0
                r15 = 0
                goto L_0x02d1
            L_0x022f:
                boolean r3 = r13 instanceof androidx.constraintlayout.widget.VirtualLayout
                if (r3 == 0) goto L_0x0241
                boolean r3 = r1 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
                if (r3 == 0) goto L_0x0241
                r3 = r1
                androidx.constraintlayout.core.widgets.VirtualLayout r3 = (androidx.constraintlayout.core.widgets.VirtualLayout) r3
                r9 = r13
                androidx.constraintlayout.widget.VirtualLayout r9 = (androidx.constraintlayout.widget.VirtualLayout) r9
                r9.onMeasure(r3, r5, r4)
                goto L_0x0244
            L_0x0241:
                r13.measure(r5, r4)
            L_0x0244:
                r1.setLastMeasureSpec(r5, r4)
                int r3 = r13.getMeasuredWidth()
                int r9 = r13.getMeasuredHeight()
                int r10 = r13.getBaseline()
                int r15 = r1.mMatchConstraintMinWidth
                if (r15 <= 0) goto L_0x025e
                int r15 = java.lang.Math.max(r15, r3)
            L_0x025b:
                r17 = r4
                goto L_0x0260
            L_0x025e:
                r15 = r3
                goto L_0x025b
            L_0x0260:
                int r4 = r1.mMatchConstraintMaxWidth
                if (r4 <= 0) goto L_0x0268
                int r15 = java.lang.Math.min(r4, r15)
            L_0x0268:
                int r4 = r1.mMatchConstraintMinHeight
                if (r4 <= 0) goto L_0x0273
                int r4 = java.lang.Math.max(r4, r9)
            L_0x0270:
                r18 = r5
                goto L_0x0275
            L_0x0273:
                r4 = r9
                goto L_0x0270
            L_0x0275:
                int r5 = r1.mMatchConstraintMaxHeight
                if (r5 <= 0) goto L_0x027d
                int r4 = java.lang.Math.min(r5, r4)
            L_0x027d:
                androidx.constraintlayout.widget.ConstraintLayout r5 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r5 = r5.mOptimizationLevel
                r19 = r6
                r6 = 1
                boolean r5 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r5, r6)
                if (r5 != 0) goto L_0x02a3
                r5 = 1056964608(0x3f000000, float:0.5)
                if (r12 == 0) goto L_0x0299
                if (r8 == 0) goto L_0x0299
                float r6 = r1.mDimensionRatio
                float r7 = (float) r4
                float r7 = r7 * r6
                float r7 = r7 + r5
                int r15 = (int) r7
                goto L_0x02a3
            L_0x0299:
                if (r11 == 0) goto L_0x02a3
                if (r16 == 0) goto L_0x02a3
                float r4 = r1.mDimensionRatio
                float r6 = (float) r15
                float r6 = r6 / r4
                float r6 = r6 + r5
                int r4 = (int) r6
            L_0x02a3:
                if (r3 != r15) goto L_0x02aa
                if (r9 == r4) goto L_0x02a8
                goto L_0x02aa
            L_0x02a8:
                r9 = -1
                goto L_0x02d1
            L_0x02aa:
                r5 = 1073741824(0x40000000, float:2.0)
                if (r3 == r15) goto L_0x02b3
                int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r5)
                goto L_0x02b5
            L_0x02b3:
                r3 = r18
            L_0x02b5:
                if (r9 == r4) goto L_0x02bc
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r5)
                goto L_0x02be
            L_0x02bc:
                r4 = r17
            L_0x02be:
                r13.measure(r3, r4)
                r1.setLastMeasureSpec(r3, r4)
                int r15 = r13.getMeasuredWidth()
                int r4 = r13.getMeasuredHeight()
                int r10 = r13.getBaseline()
                goto L_0x02a8
            L_0x02d1:
                if (r10 == r9) goto L_0x02d5
                r9 = 1
                goto L_0x02d6
            L_0x02d5:
                r9 = 0
            L_0x02d6:
                int r3 = r2.horizontalDimension
                if (r15 != r3) goto L_0x02e1
                int r3 = r2.verticalDimension
                if (r4 == r3) goto L_0x02df
                goto L_0x02e1
            L_0x02df:
                r5 = 0
                goto L_0x02e2
            L_0x02e1:
                r5 = 1
            L_0x02e2:
                r2.measuredNeedsSolverPass = r5
                boolean r3 = r14.mNeedsBaseline
                if (r3 == 0) goto L_0x02e9
                r9 = 1
            L_0x02e9:
                if (r9 == 0) goto L_0x02f7
                r3 = -1
                if (r10 == r3) goto L_0x02f7
                int r1 = r1.getBaselineDistance()
                if (r1 == r10) goto L_0x02f7
                r6 = 1
                r2.measuredNeedsSolverPass = r6
            L_0x02f7:
                r2.measuredWidth = r15
                r2.measuredHeight = r4
                r2.measuredHasBaseline = r9
                r2.measuredBaseline = r10
                androidx.constraintlayout.widget.ConstraintLayout r1 = androidx.constraintlayout.widget.ConstraintLayout.this
                androidx.constraintlayout.core.Metrics r1 = r1.mMetrics
                if (r1 == 0) goto L_0x0318
                long r1 = java.lang.System.nanoTime()
                androidx.constraintlayout.widget.ConstraintLayout r3 = androidx.constraintlayout.widget.ConstraintLayout.this
                androidx.constraintlayout.core.Metrics r3 = r3.mMetrics
                long r4 = r3.measuresWidgetsDuration
                long r1 = r1 - r19
                long r4 = r4 + r1
                r3.measuresWidgetsDuration = r4
            L_0x0318:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.Measurer.measure(androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure):void");
        }
    }

    public interface ValueModifier {
        boolean update(int i5, int i6, int i7, View view, LayoutParams layoutParams);
    }

    public ConstraintLayout(@NonNull Context context) {
        super(context);
        init((AttributeSet) null, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new SharedValues();
        }
        return sSharedValues;
    }

    private ConstraintWidget getTargetWidget(int i5) {
        if (i5 == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i5);
        if (view == null && (view = findViewById(i5)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mWidget;
    }

    private void init(AttributeSet attributeSet, int i5, int i6) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i5, i6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i5));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        if (isInEditMode) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).setDebugName(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt2 = getChildAt(i7);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.applyToInternal(this, true);
        }
        this.mLayoutWidget.removeAllChildren();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.mConstraintHelpers.get(i8).updatePreLayout(this);
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt3 = getChildAt(i9);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).updatePreLayout(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt4 = getChildAt(i10);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt5 = getChildAt(i11);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                this.mLayoutWidget.add(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, (LayoutParams) childAt5.getLayoutParams(), this.mTempMapIdToWidget);
            }
        }
    }

    private void setWidgetBaseline(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray, int i5, ConstraintAnchor.Type type) {
        View view = this.mChildrenByIds.get(i5);
        ConstraintWidget constraintWidget2 = sparseArray.get(i5);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
            layoutParams.mNeedsBaseline = true;
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
            if (type == type2) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.mNeedsBaseline = true;
                layoutParams2.mWidget.setHasBaseline(true);
            }
            constraintWidget.getAnchor(type2).connect(constraintWidget2.getAnchor(type), layoutParams.baselineMargin, layoutParams.goneBaselineMargin, true);
            constraintWidget.setHasBaseline(true);
            constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
            constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
        }
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            } else if (getChildAt(i5).isLayoutRequested()) {
                z4 = true;
                break;
            } else {
                i5++;
            }
        }
        if (z4) {
            setChildrenConstraints();
        }
        return z4;
    }

    public void addValueModifier(ValueModifier valueModifier) {
        if (this.mModifiers == null) {
            this.mModifiers = new ArrayList<>();
        }
        this.mModifiers.add(valueModifier);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void applyConstraintsFromLayoutParams(boolean r15, android.view.View r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r18, android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r19) {
        /*
            r14 = this;
            r0 = r16
            r1 = r17
            r6 = r18
            r7 = r19
            r6.validate()
            r8 = 0
            r6.helped = r8
            int r2 = r0.getVisibility()
            r1.setVisibility(r2)
            boolean r2 = r6.mIsInPlaceholder
            if (r2 == 0) goto L_0x0022
            r2 = 1
            r1.setInPlaceholder(r2)
            r2 = 8
            r1.setVisibility(r2)
        L_0x0022:
            r1.setCompanionWidget(r0)
            boolean r2 = r0 instanceof androidx.constraintlayout.widget.ConstraintHelper
            if (r2 == 0) goto L_0x0034
            androidx.constraintlayout.widget.ConstraintHelper r0 = (androidx.constraintlayout.widget.ConstraintHelper) r0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = r14.mLayoutWidget
            boolean r2 = r2.isRtl()
            r0.resolveRtl(r1, r2)
        L_0x0034:
            boolean r0 = r6.mIsGuideline
            r9 = -1
            if (r0 == 0) goto L_0x0058
            r15 = r1
            androidx.constraintlayout.core.widgets.Guideline r15 = (androidx.constraintlayout.core.widgets.Guideline) r15
            int r0 = r6.mResolvedGuideBegin
            int r1 = r6.mResolvedGuideEnd
            float r2 = r6.mResolvedGuidePercent
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x004c
            r15.setGuidePercent((float) r2)
            return
        L_0x004c:
            if (r0 == r9) goto L_0x0052
            r15.setGuideBegin(r0)
            return
        L_0x0052:
            if (r1 == r9) goto L_0x0057
            r15.setGuideEnd(r1)
        L_0x0057:
            return
        L_0x0058:
            int r0 = r6.mResolvedLeftToLeft
            int r2 = r6.mResolvedLeftToRight
            int r10 = r6.mResolvedRightToLeft
            int r11 = r6.mResolvedRightToRight
            int r5 = r6.mResolveGoneLeftMargin
            int r12 = r6.mResolveGoneRightMargin
            float r13 = r6.mResolvedHorizontalBias
            int r3 = r6.circleConstraint
            if (r3 == r9) goto L_0x007d
            java.lang.Object r0 = r7.get(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r0
            if (r0 == 0) goto L_0x0079
            float r2 = r6.circleAngle
            int r3 = r6.circleRadius
            r1.connectCircularConstraint(r0, r2, r3)
        L_0x0079:
            r0 = r1
            r2 = r6
            goto L_0x0180
        L_0x007d:
            if (r0 == r9) goto L_0x0093
            java.lang.Object r0 = r7.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00a9
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            int r4 = r6.leftMargin
            r3 = r1
            r0 = r17
            r0.immediateConnect(r1, r2, r3, r4, r5)
            goto L_0x00a9
        L_0x0093:
            if (r2 == r9) goto L_0x00a9
            java.lang.Object r0 = r7.get(r2)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00a9
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            int r4 = r6.leftMargin
            r0 = r17
            r0.immediateConnect(r1, r2, r3, r4, r5)
        L_0x00a9:
            if (r10 == r9) goto L_0x00c1
            java.lang.Object r0 = r7.get(r10)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00d7
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            int r4 = r6.rightMargin
            r0 = r17
            r5 = r12
            r0.immediateConnect(r1, r2, r3, r4, r5)
            goto L_0x00d7
        L_0x00c1:
            r5 = r12
            if (r11 == r9) goto L_0x00d7
            java.lang.Object r0 = r7.get(r11)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00d7
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            int r4 = r6.rightMargin
            r3 = r1
            r0 = r17
            r0.immediateConnect(r1, r2, r3, r4, r5)
        L_0x00d7:
            int r0 = r6.topToTop
            if (r0 == r9) goto L_0x00f1
            java.lang.Object r0 = r7.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x010b
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            int r4 = r6.topMargin
            int r5 = r6.goneTopMargin
            r3 = r1
            r0 = r17
            r0.immediateConnect(r1, r2, r3, r4, r5)
            goto L_0x010b
        L_0x00f1:
            int r0 = r6.topToBottom
            if (r0 == r9) goto L_0x010b
            java.lang.Object r0 = r7.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x010b
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            int r4 = r6.topMargin
            int r5 = r6.goneTopMargin
            r0 = r17
            r0.immediateConnect(r1, r2, r3, r4, r5)
        L_0x010b:
            int r0 = r6.bottomToTop
            if (r0 == r9) goto L_0x0126
            java.lang.Object r0 = r7.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x013f
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            int r4 = r6.bottomMargin
            int r5 = r6.goneBottomMargin
            r0 = r17
            r0.immediateConnect(r1, r2, r3, r4, r5)
            goto L_0x013f
        L_0x0126:
            int r0 = r6.bottomToBottom
            if (r0 == r9) goto L_0x013f
            java.lang.Object r0 = r7.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x013f
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            int r4 = r6.bottomMargin
            int r5 = r6.goneBottomMargin
            r3 = r1
            r0 = r17
            r0.immediateConnect(r1, r2, r3, r4, r5)
        L_0x013f:
            int r4 = r6.baselineToBaseline
            if (r4 == r9) goto L_0x0150
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            r0 = r14
            r1 = r17
            r2 = r6
            r3 = r7
            r0.setWidgetBaseline(r1, r2, r3, r4, r5)
        L_0x014d:
            r0 = r17
            goto L_0x016f
        L_0x0150:
            r2 = r6
            int r4 = r2.baselineToTop
            if (r4 == r9) goto L_0x0160
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            r0 = r14
            r1 = r17
            r3 = r19
            r0.setWidgetBaseline(r1, r2, r3, r4, r5)
            goto L_0x014d
        L_0x0160:
            int r4 = r2.baselineToBottom
            if (r4 == r9) goto L_0x014d
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            r0 = r14
            r1 = r17
            r3 = r19
            r0.setWidgetBaseline(r1, r2, r3, r4, r5)
            r0 = r1
        L_0x016f:
            r1 = 0
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x0177
            r0.setHorizontalBiasPercent(r13)
        L_0x0177:
            float r3 = r2.verticalBias
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0180
            r0.setVerticalBiasPercent(r3)
        L_0x0180:
            if (r15 == 0) goto L_0x018f
            int r15 = r2.editorAbsoluteX
            if (r15 != r9) goto L_0x018a
            int r1 = r2.editorAbsoluteY
            if (r1 == r9) goto L_0x018f
        L_0x018a:
            int r1 = r2.editorAbsoluteY
            r0.setOrigin(r15, r1)
        L_0x018f:
            boolean r15 = r2.mHorizontalDimensionFixed
            r1 = -2
            if (r15 != 0) goto L_0x01c5
            int r15 = r2.width
            if (r15 != r9) goto L_0x01bc
            boolean r15 = r2.constrainedWidth
            if (r15 == 0) goto L_0x01a2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r0.setHorizontalDimensionBehaviour(r15)
            goto L_0x01a7
        L_0x01a2:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r0.setHorizontalDimensionBehaviour(r15)
        L_0x01a7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r15 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r0.getAnchor(r15)
            int r3 = r2.leftMargin
            r15.mMargin = r3
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r15 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r0.getAnchor(r15)
            int r3 = r2.rightMargin
            r15.mMargin = r3
            goto L_0x01d8
        L_0x01bc:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r0.setHorizontalDimensionBehaviour(r15)
            r0.setWidth(r8)
            goto L_0x01d8
        L_0x01c5:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.setHorizontalDimensionBehaviour(r15)
            int r15 = r2.width
            r0.setWidth(r15)
            int r15 = r2.width
            if (r15 != r1) goto L_0x01d8
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r0.setHorizontalDimensionBehaviour(r15)
        L_0x01d8:
            boolean r15 = r2.mVerticalDimensionFixed
            if (r15 != 0) goto L_0x020d
            int r15 = r2.height
            if (r15 != r9) goto L_0x0204
            boolean r15 = r2.constrainedHeight
            if (r15 == 0) goto L_0x01ea
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r0.setVerticalDimensionBehaviour(r15)
            goto L_0x01ef
        L_0x01ea:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r0.setVerticalDimensionBehaviour(r15)
        L_0x01ef:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r15 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r0.getAnchor(r15)
            int r1 = r2.topMargin
            r15.mMargin = r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r15 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r0.getAnchor(r15)
            int r1 = r2.bottomMargin
            r15.mMargin = r1
            goto L_0x0220
        L_0x0204:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r0.setVerticalDimensionBehaviour(r15)
            r0.setHeight(r8)
            goto L_0x0220
        L_0x020d:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.setVerticalDimensionBehaviour(r15)
            int r15 = r2.height
            r0.setHeight(r15)
            int r15 = r2.height
            if (r15 != r1) goto L_0x0220
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r0.setVerticalDimensionBehaviour(r15)
        L_0x0220:
            java.lang.String r15 = r2.dimensionRatio
            r0.setDimensionRatio(r15)
            float r15 = r2.horizontalWeight
            r0.setHorizontalWeight(r15)
            float r15 = r2.verticalWeight
            r0.setVerticalWeight(r15)
            int r15 = r2.horizontalChainStyle
            r0.setHorizontalChainStyle(r15)
            int r15 = r2.verticalChainStyle
            r0.setVerticalChainStyle(r15)
            int r15 = r2.wrapBehaviorInParent
            r0.setWrapBehaviorInParent(r15)
            int r15 = r2.matchConstraintDefaultWidth
            int r1 = r2.matchConstraintMinWidth
            int r3 = r2.matchConstraintMaxWidth
            float r4 = r2.matchConstraintPercentWidth
            r0.setHorizontalMatchStyle(r15, r1, r3, r4)
            int r15 = r2.matchConstraintDefaultHeight
            int r1 = r2.matchConstraintMinHeight
            int r3 = r2.matchConstraintMaxHeight
            float r2 = r2.matchConstraintPercentHeight
            r0.setVerticalMatchStyle(r15, r1, r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.applyConstraintsFromLayoutParams(boolean, android.view.View, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                this.mConstraintHelpers.get(i5).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i7 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i8 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(SupportMenu.CATEGORY_MASK);
                        float f5 = (float) i7;
                        float f6 = (float) i8;
                        float f7 = (float) (i7 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        canvas2.drawLine(f5, f6, f7, f6, paint);
                        float f8 = f5;
                        float parseInt4 = (float) (i8 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f9 = f7;
                        canvas2.drawLine(f9, f6, f7, parseInt4, paint);
                        float f10 = f6;
                        float f11 = parseInt4;
                        float f12 = f8;
                        canvas2.drawLine(f9, f11, f12, parseInt4, paint);
                        float f13 = f9;
                        float f14 = f12;
                        float f15 = f10;
                        canvas2.drawLine(f14, f11, f12, f15, paint);
                        float f16 = f15;
                        float f17 = f11;
                        float f18 = f16;
                        paint.setColor(-16711936);
                        float f19 = f13;
                        canvas2.drawLine(f14, f18, f19, f17, paint);
                        canvas2.drawLine(f14, f17, f19, f18, paint);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean dynamicUpdateConstraints(int i5, int i6) {
        if (this.mModifiers == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        ArrayList<ValueModifier> arrayList = this.mModifiers;
        int size3 = arrayList.size();
        boolean z4 = false;
        int i7 = 0;
        while (i7 < size3) {
            int i8 = i7 + 1;
            ValueModifier valueModifier = arrayList.get(i7);
            ArrayList<ConstraintWidget> children = this.mLayoutWidget.getChildren();
            int size4 = children.size();
            for (int i9 = 0; i9 < size4; i9++) {
                View view = (View) children.get(i9).getCompanionWidget();
                z4 |= valueModifier.update(size, size2, view.getId(), view, (LayoutParams) view.getLayoutParams());
            }
            i7 = i8;
        }
        return z4;
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i5, Object obj) {
        if (i5 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.mLayoutWidget.stringId == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.mLayoutWidget.stringId = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.mLayoutWidget.stringId = "parent";
            }
        }
        if (this.mLayoutWidget.getDebugName() == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            constraintWidgetContainer.setDebugName(constraintWidgetContainer.stringId);
            Log.v(TAG, " setDebugName " + this.mLayoutWidget.getDebugName());
        }
        ArrayList<ConstraintWidget> children = this.mLayoutWidget.getChildren();
        int size = children.size();
        int i5 = 0;
        while (i5 < size) {
            ConstraintWidget constraintWidget = children.get(i5);
            i5++;
            ConstraintWidget constraintWidget2 = constraintWidget;
            View view = (View) constraintWidget2.getCompanionWidget();
            if (view != null) {
                if (constraintWidget2.stringId == null && (id = view.getId()) != -1) {
                    constraintWidget2.stringId = getContext().getResources().getResourceEntryName(id);
                }
                if (constraintWidget2.getDebugName() == null) {
                    constraintWidget2.setDebugName(constraintWidget2.stringId);
                    Log.v(TAG, " setDebugName " + constraintWidget2.getDebugName());
                }
            }
        }
        this.mLayoutWidget.getSceneString(sb);
        return sb.toString();
    }

    public View getViewById(int i5) {
        return this.mChildrenByIds.get(i5);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).mWidget;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).mWidget;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isRtl() {
        if ((getContext().getApplicationInfo().flags & 4194304) == 0 || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    public void loadLayoutDescription(int i5) {
        if (i5 != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i5);
            } catch (Resources.NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
            }
        } else {
            this.mConstraintLayoutSpec = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        View content;
        Metrics metrics = this.mMetrics;
        if (metrics != null) {
            metrics.mNumberOfLayouts++;
        }
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.mWidget;
            if ((childAt.getVisibility() != 8 || layoutParams.mIsGuideline || layoutParams.mIsHelper || layoutParams.mIsVirtualGroup || isInEditMode) && !layoutParams.mIsInPlaceholder) {
                int x4 = constraintWidget.getX();
                int y4 = constraintWidget.getY();
                int width = constraintWidget.getWidth() + x4;
                int height = constraintWidget.getHeight() + y4;
                childAt.layout(x4, y4, width, height);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(x4, y4, width, height);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.mConstraintHelpers.get(i10).updatePostLayout(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        long j5;
        if (this.mMetrics != null) {
            j5 = System.nanoTime();
            this.mMetrics.mChildCount = (long) getChildCount();
            this.mMetrics.mMeasureCalls++;
        } else {
            j5 = 0;
        }
        boolean dynamicUpdateConstraints = this.mDirtyHierarchy | dynamicUpdateConstraints(i5, i6);
        this.mDirtyHierarchy = dynamicUpdateConstraints;
        if (!dynamicUpdateConstraints) {
            int childCount = getChildCount();
            int i7 = 0;
            while (true) {
                if (i7 >= childCount) {
                    break;
                } else if (getChildAt(i7).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                } else {
                    i7++;
                }
            }
        }
        this.mOnMeasureWidthMeasureSpec = i5;
        this.mOnMeasureHeightMeasureSpec = i6;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.updateHierarchy();
            }
        }
        this.mLayoutWidget.fillMetrics(this.mMetrics);
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i5, i6);
        resolveMeasuredDimension(i5, i6, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        Metrics metrics = this.mMetrics;
        if (metrics != null) {
            metrics.mMeasureDuration += System.nanoTime() - j5;
        }
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Guideline guideline = new Guideline();
            layoutParams.mWidget = guideline;
            layoutParams.mIsGuideline = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).mIsHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.remove(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    /* access modifiers changed from: protected */
    public void parseLayoutDescription(int i5) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i5);
    }

    /* access modifiers changed from: package-private */
    public void removeValueModifier(ValueModifier valueModifier) {
        if (valueModifier != null) {
            this.mModifiers.remove(valueModifier);
        }
    }

    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void resolveMeasuredDimension(int i5, int i6, int i7, int i8, boolean z4, boolean z5) {
        Measurer measurer = this.mMeasurer;
        int i9 = measurer.mPaddingHeight;
        int resolveSizeAndState = View.resolveSizeAndState(i7 + measurer.mPaddingWidth, i5, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(i8 + i9, i6, 0);
        int i10 = resolveSizeAndState & ViewCompat.MEASURED_SIZE_MASK;
        int i11 = resolveSizeAndState2 & ViewCompat.MEASURED_SIZE_MASK;
        int min = Math.min(this.mMaxWidth, i10);
        int min2 = Math.min(this.mMaxHeight, i11);
        if (z4) {
            min |= 16777216;
        }
        if (z5) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    /* access modifiers changed from: protected */
    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i5, int i6, int i7) {
        int i8;
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int size2 = View.MeasureSpec.getSize(i7);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i9 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.captureLayoutInfo(i6, i7, max, max2, paddingWidth, i9);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            max3 = Math.max(0, getPaddingLeft());
        } else if (isRtl()) {
            i8 = max4;
            int i10 = size - paddingWidth;
            int i11 = size2 - i9;
            setSelfDimensionBehaviour(constraintWidgetContainer, mode, i10, mode2, i11);
            constraintWidgetContainer.measure(i5, mode, i10, mode2, i11, this.mLastMeasureWidth, this.mLastMeasureHeight, i8, max);
        }
        i8 = max3;
        int i102 = size - paddingWidth;
        int i112 = size2 - i9;
        setSelfDimensionBehaviour(constraintWidgetContainer, mode, i102, mode2, i112);
        constraintWidgetContainer.measure(i5, mode, i102, mode2, i112, this.mLastMeasureWidth, this.mLastMeasureHeight, i8, max);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i5, Object obj, Object obj2) {
        if (i5 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.mDesignIds.put(str, num);
        }
    }

    public void setId(int i5) {
        this.mChildrenByIds.remove(getId());
        super.setId(i5);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i5) {
        if (i5 != this.mMaxHeight) {
            this.mMaxHeight = i5;
            requestLayout();
        }
    }

    public void setMaxWidth(int i5) {
        if (i5 != this.mMaxWidth) {
            this.mMaxWidth = i5;
            requestLayout();
        }
    }

    public void setMinHeight(int i5) {
        if (i5 != this.mMinHeight) {
            this.mMinHeight = i5;
            requestLayout();
        }
    }

    public void setMinWidth(int i5) {
        if (i5 != this.mMinWidth) {
            this.mMinWidth = i5;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i5) {
        this.mOptimizationLevel = i5;
        this.mLayoutWidget.setOptimizationLevel(i5);
    }

    /* access modifiers changed from: protected */
    public void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i5, int i6, int i7, int i8) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        Measurer measurer = this.mMeasurer;
        int i9 = measurer.mPaddingHeight;
        int i10 = measurer.mPaddingWidth;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i5 != Integer.MIN_VALUE) {
            if (i5 == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i6 = Math.max(0, this.mMinWidth);
                }
            } else if (i5 != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                i6 = Math.min(this.mMaxWidth - i10, i6);
                dimensionBehaviour = dimensionBehaviour2;
            }
            i6 = 0;
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i6 = Math.max(0, this.mMinWidth);
            }
        }
        if (i7 != Integer.MIN_VALUE) {
            if (i7 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i8 = Math.max(0, this.mMinHeight);
                }
            } else if (i7 == 1073741824) {
                i8 = Math.min(this.mMaxHeight - i9, i8);
            }
            i8 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i8 = Math.max(0, this.mMinHeight);
            }
        }
        if (!(i6 == constraintWidgetContainer.getWidth() && i8 == constraintWidgetContainer.getHeight())) {
            constraintWidgetContainer.invalidateMeasures();
        }
        constraintWidgetContainer.setX(0);
        constraintWidgetContainer.setY(0);
        constraintWidgetContainer.setMaxWidth(this.mMaxWidth - i10);
        constraintWidgetContainer.setMaxHeight(this.mMaxHeight - i9);
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        constraintWidgetContainer.setWidth(i6);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        constraintWidgetContainer.setHeight(i8);
        constraintWidgetContainer.setMinWidth(this.mMinWidth - i10);
        constraintWidgetContainer.setMinHeight(this.mMinHeight - i9);
    }

    public void setState(int i5, int i6, int i7) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i5, (float) i6, (float) i7);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        init(attributeSet, i5, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        init(attributeSet, i5, i6);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int CIRCLE = 8;
        public static final int END = 7;
        public static final int GONE_UNSET = Integer.MIN_VALUE;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
        public static final int WRAP_BEHAVIOR_INCLUDED = 0;
        public static final int WRAP_BEHAVIOR_SKIPPED = 3;
        public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
        public int baselineMargin = 0;
        public int baselineToBaseline = -1;
        public int baselineToBottom = -1;
        public int baselineToTop = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String constraintTag = null;
        public String dimensionRatio = null;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBaselineMargin = Integer.MIN_VALUE;
        public int goneBottomMargin = Integer.MIN_VALUE;
        public int goneEndMargin = Integer.MIN_VALUE;
        public int goneLeftMargin = Integer.MIN_VALUE;
        public int goneRightMargin = Integer.MIN_VALUE;
        public int goneStartMargin = Integer.MIN_VALUE;
        public int goneTopMargin = Integer.MIN_VALUE;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean guidelineUseRtl = true;
        public boolean helped = false;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        public float horizontalWeight = -1.0f;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        int mDimensionRatioSide = 1;
        float mDimensionRatioValue = 0.0f;
        boolean mHeightSet = true;
        boolean mHorizontalDimensionFixed = true;
        boolean mIsGuideline = false;
        boolean mIsHelper = false;
        boolean mIsInPlaceholder = false;
        boolean mIsVirtualGroup = false;
        boolean mNeedsBaseline = false;
        int mResolveGoneLeftMargin = Integer.MIN_VALUE;
        int mResolveGoneRightMargin = Integer.MIN_VALUE;
        int mResolvedGuideBegin;
        int mResolvedGuideEnd;
        float mResolvedGuidePercent;
        float mResolvedHorizontalBias = 0.5f;
        int mResolvedLeftToLeft = -1;
        int mResolvedLeftToRight = -1;
        int mResolvedRightToLeft = -1;
        int mResolvedRightToRight = -1;
        boolean mVerticalDimensionFixed = true;
        ConstraintWidget mWidget = new ConstraintWidget();
        boolean mWidthSet = true;
        public int matchConstraintDefaultHeight = 0;
        public int matchConstraintDefaultWidth = 0;
        public int matchConstraintMaxHeight = 0;
        public int matchConstraintMaxWidth = 0;
        public int matchConstraintMinHeight = 0;
        public int matchConstraintMinWidth = 0;
        public float matchConstraintPercentHeight = 1.0f;
        public float matchConstraintPercentWidth = 1.0f;
        public int orientation = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        public float verticalWeight = -1.0f;
        public int wrapBehaviorInParent = 0;

        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int GUIDELINE_USE_RTL = 67;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF = 53;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF = 52;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT = 65;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH = 64;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BASELINE = 55;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int LAYOUT_MARGIN_BASELINE = 54;
            public static final int LAYOUT_WRAP_BEHAVIOR_IN_PARENT = 66;
            public static final int UNUSED = 0;
            public static final SparseIntArray sMap;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                sMap = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }

            private Table() {
            }
        }

        @SuppressLint({"ClassVerificationFailure"})
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.leftMargin = marginLayoutParams.leftMargin;
                this.rightMargin = marginLayoutParams.rightMargin;
                this.topMargin = marginLayoutParams.topMargin;
                this.bottomMargin = marginLayoutParams.bottomMargin;
                setMarginStart(marginLayoutParams.getMarginStart());
                setMarginEnd(marginLayoutParams.getMarginEnd());
            }
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.guideBegin = layoutParams2.guideBegin;
                this.guideEnd = layoutParams2.guideEnd;
                this.guidePercent = layoutParams2.guidePercent;
                this.guidelineUseRtl = layoutParams2.guidelineUseRtl;
                this.leftToLeft = layoutParams2.leftToLeft;
                this.leftToRight = layoutParams2.leftToRight;
                this.rightToLeft = layoutParams2.rightToLeft;
                this.rightToRight = layoutParams2.rightToRight;
                this.topToTop = layoutParams2.topToTop;
                this.topToBottom = layoutParams2.topToBottom;
                this.bottomToTop = layoutParams2.bottomToTop;
                this.bottomToBottom = layoutParams2.bottomToBottom;
                this.baselineToBaseline = layoutParams2.baselineToBaseline;
                this.baselineToTop = layoutParams2.baselineToTop;
                this.baselineToBottom = layoutParams2.baselineToBottom;
                this.circleConstraint = layoutParams2.circleConstraint;
                this.circleRadius = layoutParams2.circleRadius;
                this.circleAngle = layoutParams2.circleAngle;
                this.startToEnd = layoutParams2.startToEnd;
                this.startToStart = layoutParams2.startToStart;
                this.endToStart = layoutParams2.endToStart;
                this.endToEnd = layoutParams2.endToEnd;
                this.goneLeftMargin = layoutParams2.goneLeftMargin;
                this.goneTopMargin = layoutParams2.goneTopMargin;
                this.goneRightMargin = layoutParams2.goneRightMargin;
                this.goneBottomMargin = layoutParams2.goneBottomMargin;
                this.goneStartMargin = layoutParams2.goneStartMargin;
                this.goneEndMargin = layoutParams2.goneEndMargin;
                this.goneBaselineMargin = layoutParams2.goneBaselineMargin;
                this.baselineMargin = layoutParams2.baselineMargin;
                this.horizontalBias = layoutParams2.horizontalBias;
                this.verticalBias = layoutParams2.verticalBias;
                this.dimensionRatio = layoutParams2.dimensionRatio;
                this.mDimensionRatioValue = layoutParams2.mDimensionRatioValue;
                this.mDimensionRatioSide = layoutParams2.mDimensionRatioSide;
                this.horizontalWeight = layoutParams2.horizontalWeight;
                this.verticalWeight = layoutParams2.verticalWeight;
                this.horizontalChainStyle = layoutParams2.horizontalChainStyle;
                this.verticalChainStyle = layoutParams2.verticalChainStyle;
                this.constrainedWidth = layoutParams2.constrainedWidth;
                this.constrainedHeight = layoutParams2.constrainedHeight;
                this.matchConstraintDefaultWidth = layoutParams2.matchConstraintDefaultWidth;
                this.matchConstraintDefaultHeight = layoutParams2.matchConstraintDefaultHeight;
                this.matchConstraintMinWidth = layoutParams2.matchConstraintMinWidth;
                this.matchConstraintMaxWidth = layoutParams2.matchConstraintMaxWidth;
                this.matchConstraintMinHeight = layoutParams2.matchConstraintMinHeight;
                this.matchConstraintMaxHeight = layoutParams2.matchConstraintMaxHeight;
                this.matchConstraintPercentWidth = layoutParams2.matchConstraintPercentWidth;
                this.matchConstraintPercentHeight = layoutParams2.matchConstraintPercentHeight;
                this.editorAbsoluteX = layoutParams2.editorAbsoluteX;
                this.editorAbsoluteY = layoutParams2.editorAbsoluteY;
                this.orientation = layoutParams2.orientation;
                this.mHorizontalDimensionFixed = layoutParams2.mHorizontalDimensionFixed;
                this.mVerticalDimensionFixed = layoutParams2.mVerticalDimensionFixed;
                this.mNeedsBaseline = layoutParams2.mNeedsBaseline;
                this.mIsGuideline = layoutParams2.mIsGuideline;
                this.mResolvedLeftToLeft = layoutParams2.mResolvedLeftToLeft;
                this.mResolvedLeftToRight = layoutParams2.mResolvedLeftToRight;
                this.mResolvedRightToLeft = layoutParams2.mResolvedRightToLeft;
                this.mResolvedRightToRight = layoutParams2.mResolvedRightToRight;
                this.mResolveGoneLeftMargin = layoutParams2.mResolveGoneLeftMargin;
                this.mResolveGoneRightMargin = layoutParams2.mResolveGoneRightMargin;
                this.mResolvedHorizontalBias = layoutParams2.mResolvedHorizontalBias;
                this.constraintTag = layoutParams2.constraintTag;
                this.wrapBehaviorInParent = layoutParams2.wrapBehaviorInParent;
                this.mWidget = layoutParams2.mWidget;
                this.mWidthSet = layoutParams2.mWidthSet;
                this.mHeightSet = layoutParams2.mHeightSet;
            }
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.mWidget;
        }

        public void reset() {
            ConstraintWidget constraintWidget = this.mWidget;
            if (constraintWidget != null) {
                constraintWidget.reset();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0082  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r11) {
            /*
                r10 = this;
                int r0 = r10.leftMargin
                int r1 = r10.rightMargin
                super.resolveLayoutDirection(r11)
                int r11 = r10.getLayoutDirection()
                r2 = 0
                r3 = 1
                if (r3 != r11) goto L_0x0011
                r11 = r3
                goto L_0x0012
            L_0x0011:
                r11 = r2
            L_0x0012:
                r4 = -1
                r10.mResolvedRightToLeft = r4
                r10.mResolvedRightToRight = r4
                r10.mResolvedLeftToLeft = r4
                r10.mResolvedLeftToRight = r4
                int r5 = r10.goneLeftMargin
                r10.mResolveGoneLeftMargin = r5
                int r5 = r10.goneRightMargin
                r10.mResolveGoneRightMargin = r5
                float r5 = r10.horizontalBias
                r10.mResolvedHorizontalBias = r5
                int r6 = r10.guideBegin
                r10.mResolvedGuideBegin = r6
                int r7 = r10.guideEnd
                r10.mResolvedGuideEnd = r7
                float r8 = r10.guidePercent
                r10.mResolvedGuidePercent = r8
                r9 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r11 == 0) goto L_0x0094
                int r11 = r10.startToEnd
                if (r11 == r4) goto L_0x003f
                r10.mResolvedRightToLeft = r11
            L_0x003d:
                r2 = r3
                goto L_0x0046
            L_0x003f:
                int r11 = r10.startToStart
                if (r11 == r4) goto L_0x0046
                r10.mResolvedRightToRight = r11
                goto L_0x003d
            L_0x0046:
                int r11 = r10.endToStart
                if (r11 == r4) goto L_0x004d
                r10.mResolvedLeftToRight = r11
                r2 = r3
            L_0x004d:
                int r11 = r10.endToEnd
                if (r11 == r4) goto L_0x0054
                r10.mResolvedLeftToLeft = r11
                r2 = r3
            L_0x0054:
                int r11 = r10.goneStartMargin
                if (r11 == r9) goto L_0x005a
                r10.mResolveGoneRightMargin = r11
            L_0x005a:
                int r11 = r10.goneEndMargin
                if (r11 == r9) goto L_0x0060
                r10.mResolveGoneLeftMargin = r11
            L_0x0060:
                r11 = 1065353216(0x3f800000, float:1.0)
                if (r2 == 0) goto L_0x0068
                float r2 = r11 - r5
                r10.mResolvedHorizontalBias = r2
            L_0x0068:
                boolean r2 = r10.mIsGuideline
                if (r2 == 0) goto L_0x00b8
                int r2 = r10.orientation
                if (r2 != r3) goto L_0x00b8
                boolean r2 = r10.guidelineUseRtl
                if (r2 == 0) goto L_0x00b8
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r3 == 0) goto L_0x0082
                float r11 = r11 - r8
                r10.mResolvedGuidePercent = r11
                r10.mResolvedGuideBegin = r4
                r10.mResolvedGuideEnd = r4
                goto L_0x00b8
            L_0x0082:
                if (r6 == r4) goto L_0x008b
                r10.mResolvedGuideEnd = r6
                r10.mResolvedGuideBegin = r4
                r10.mResolvedGuidePercent = r2
                goto L_0x00b8
            L_0x008b:
                if (r7 == r4) goto L_0x00b8
                r10.mResolvedGuideBegin = r7
                r10.mResolvedGuideEnd = r4
                r10.mResolvedGuidePercent = r2
                goto L_0x00b8
            L_0x0094:
                int r11 = r10.startToEnd
                if (r11 == r4) goto L_0x009a
                r10.mResolvedLeftToRight = r11
            L_0x009a:
                int r11 = r10.startToStart
                if (r11 == r4) goto L_0x00a0
                r10.mResolvedLeftToLeft = r11
            L_0x00a0:
                int r11 = r10.endToStart
                if (r11 == r4) goto L_0x00a6
                r10.mResolvedRightToLeft = r11
            L_0x00a6:
                int r11 = r10.endToEnd
                if (r11 == r4) goto L_0x00ac
                r10.mResolvedRightToRight = r11
            L_0x00ac:
                int r11 = r10.goneStartMargin
                if (r11 == r9) goto L_0x00b2
                r10.mResolveGoneLeftMargin = r11
            L_0x00b2:
                int r11 = r10.goneEndMargin
                if (r11 == r9) goto L_0x00b8
                r10.mResolveGoneRightMargin = r11
            L_0x00b8:
                int r11 = r10.endToStart
                if (r11 != r4) goto L_0x0102
                int r11 = r10.endToEnd
                if (r11 != r4) goto L_0x0102
                int r11 = r10.startToStart
                if (r11 != r4) goto L_0x0102
                int r11 = r10.startToEnd
                if (r11 != r4) goto L_0x0102
                int r11 = r10.rightToLeft
                if (r11 == r4) goto L_0x00d7
                r10.mResolvedRightToLeft = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00e5
                if (r1 <= 0) goto L_0x00e5
                r10.rightMargin = r1
                goto L_0x00e5
            L_0x00d7:
                int r11 = r10.rightToRight
                if (r11 == r4) goto L_0x00e5
                r10.mResolvedRightToRight = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00e5
                if (r1 <= 0) goto L_0x00e5
                r10.rightMargin = r1
            L_0x00e5:
                int r11 = r10.leftToLeft
                if (r11 == r4) goto L_0x00f4
                r10.mResolvedLeftToLeft = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0102
                if (r0 <= 0) goto L_0x0102
                r10.leftMargin = r0
                return
            L_0x00f4:
                int r11 = r10.leftToRight
                if (r11 == r4) goto L_0x0102
                r10.mResolvedLeftToRight = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0102
                if (r0 <= 0) goto L_0x0102
                r10.leftMargin = r0
            L_0x0102:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public void setWidgetDebugName(String str) {
            this.mWidget.setDebugName(str);
        }

        public void validate() {
            this.mIsGuideline = false;
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            int i5 = this.width;
            if (i5 == -2 && this.constrainedWidth) {
                this.mHorizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            int i6 = this.height;
            if (i6 == -2 && this.constrainedHeight) {
                this.mVerticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            if (i5 == 0 || i5 == -1) {
                this.mHorizontalDimensionFixed = false;
                if (i5 == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (i6 == 0 || i6 == -1) {
                this.mVerticalDimensionFixed = false;
                if (i6 == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.mIsGuideline = true;
                this.mHorizontalDimensionFixed = true;
                this.mVerticalDimensionFixed = true;
                if (!(this.mWidget instanceof Guideline)) {
                    this.mWidget = new Guideline();
                }
                ((Guideline) this.mWidget).setOrientation(this.orientation);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                int i6 = Table.sMap.get(index);
                switch (i6) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f5 = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f5;
                        if (f5 >= 0.0f) {
                            break;
                        } else {
                            this.circleAngle = (360.0f - f5) % 360.0f;
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 != -1) {
                            break;
                        } else {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 != -1) {
                            break;
                        } else {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 != -1) {
                            break;
                        } else {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 != -1) {
                            break;
                        } else {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 != -1) {
                            break;
                        } else {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 != -1) {
                            break;
                        } else {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 != -1) {
                            break;
                        } else {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 != -1) {
                            break;
                        } else {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 != -1) {
                            break;
                        } else {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 != -1) {
                            break;
                        } else {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        int i7 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultWidth = i7;
                        if (i7 != 1) {
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        int i8 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultHeight = i8;
                        if (i8 != 1) {
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) != -2) {
                                break;
                            } else {
                                this.matchConstraintMinWidth = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) != -2) {
                                break;
                            } else {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            }
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) != -2) {
                                break;
                            } else {
                                this.matchConstraintMinHeight = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) != -2) {
                                break;
                            } else {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            }
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    default:
                        switch (i6) {
                            case 44:
                                ConstraintSet.parseDimensionRatioString(this, obtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                break;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                break;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                break;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                break;
                            case 51:
                                this.constraintTag = obtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.baselineToTop);
                                this.baselineToTop = resourceId15;
                                if (resourceId15 != -1) {
                                    break;
                                } else {
                                    this.baselineToTop = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.baselineToBottom);
                                this.baselineToBottom = resourceId16;
                                if (resourceId16 != -1) {
                                    break;
                                } else {
                                    this.baselineToBottom = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 54:
                                this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                break;
                            case 55:
                                this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                break;
                            default:
                                switch (i6) {
                                    case 64:
                                        ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 0);
                                        this.mWidthSet = true;
                                        break;
                                    case 65:
                                        ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 1);
                                        this.mHeightSet = true;
                                        break;
                                    case 66:
                                        this.wrapBehaviorInParent = obtainStyledAttributes.getInt(index, this.wrapBehaviorInParent);
                                        break;
                                    case 67:
                                        this.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
        }
    }
}
