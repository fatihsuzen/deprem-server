package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    static int sMyCounter;
    BasicMeasure mBasicMeasureSolver = new BasicMeasure(this);
    int mDebugSolverPassCount = 0;
    public DependencyGraph mDependencyGraph = new DependencyGraph(this);
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    public int mHorizontalChainsSize = 0;
    private WeakReference<ConstraintAnchor> mHorizontalWrapMax = null;
    private WeakReference<ConstraintAnchor> mHorizontalWrapMin = null;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    public BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    protected BasicMeasure.Measurer mMeasurer = null;
    public Metrics mMetrics;
    private int mOptimizationLevel = 257;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    private int mPass;
    public boolean mSkipSolver = false;
    protected LinearSystem mSystem = new LinearSystem();
    ChainHead[] mVerticalChainsArray = new ChainHead[4];
    public int mVerticalChainsSize = 0;
    private WeakReference<ConstraintAnchor> mVerticalWrapMax = null;
    private WeakReference<ConstraintAnchor> mVerticalWrapMin = null;
    public boolean mVerticalWrapOptimized = false;
    HashSet<ConstraintWidget> mWidgetsToAdd = new HashSet<>();
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;

    public ConstraintWidgetContainer() {
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i5 = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i5 >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addMaxWrap(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.mSystem.addGreaterThan(solverVariable, this.mSystem.createObjectVariable(constraintAnchor), 0, 5);
    }

    private void addMinWrap(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.mSystem.addGreaterThan(this.mSystem.createObjectVariable(constraintAnchor), solverVariable, 0, 5);
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i5 = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i5 >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* access modifiers changed from: package-private */
    public void addChain(ConstraintWidget constraintWidget, int i5) {
        if (i5 == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i5 == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        LinearSystem linearSystem2;
        ConstraintWidgetContainer constraintWidgetContainer;
        int i5;
        boolean optimizeFor = optimizeFor(64);
        addToSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z4 = false;
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i6);
            constraintWidget.setInBarrier(0, false);
            constraintWidget.setInBarrier(1, false);
            if (constraintWidget instanceof Barrier) {
                z4 = true;
            }
        }
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(i7);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).markWidgets();
                }
            }
        }
        this.mWidgetsToAdd.clear();
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget3 = this.mChildren.get(i8);
            if (constraintWidget3.addFirst()) {
                if (constraintWidget3 instanceof VirtualLayout) {
                    this.mWidgetsToAdd.add(constraintWidget3);
                } else {
                    constraintWidget3.addToSolver(linearSystem, optimizeFor);
                }
            }
        }
        while (this.mWidgetsToAdd.size() > 0) {
            int size2 = this.mWidgetsToAdd.size();
            Iterator<ConstraintWidget> it = this.mWidgetsToAdd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) it.next();
                if (virtualLayout.contains(this.mWidgetsToAdd)) {
                    virtualLayout.addToSolver(linearSystem, optimizeFor);
                    this.mWidgetsToAdd.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == this.mWidgetsToAdd.size()) {
                Iterator<ConstraintWidget> it2 = this.mWidgetsToAdd.iterator();
                while (it2.hasNext()) {
                    it2.next().addToSolver(linearSystem, optimizeFor);
                }
                this.mWidgetsToAdd.clear();
            }
        }
        if (LinearSystem.USE_DEPENDENCY_ORDERING) {
            HashSet hashSet = new HashSet();
            for (int i9 = 0; i9 < size; i9++) {
                ConstraintWidget constraintWidget4 = this.mChildren.get(i9);
                if (!constraintWidget4.addFirst()) {
                    hashSet.add(constraintWidget4);
                }
            }
            if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                i5 = 0;
            } else {
                i5 = 1;
            }
            constraintWidgetContainer = this;
            linearSystem2 = linearSystem;
            constraintWidgetContainer.addChildrenToSolverByDependency(this, linearSystem2, hashSet, i5, false);
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) it3.next();
                Optimizer.checkMatchParent(this, linearSystem2, constraintWidget5);
                constraintWidget5.addToSolver(linearSystem2, optimizeFor);
            }
        } else {
            constraintWidgetContainer = this;
            linearSystem2 = linearSystem;
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget6 = constraintWidgetContainer.mChildren.get(i10);
                if (constraintWidget6 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.mListDimensionBehaviors;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.addToSolver(linearSystem2, optimizeFor);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.checkMatchParent(this, linearSystem2, constraintWidget6);
                    if (!constraintWidget6.addFirst()) {
                        constraintWidget6.addToSolver(linearSystem2, optimizeFor);
                    }
                }
            }
        }
        if (constraintWidgetContainer.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem2, (ArrayList<ConstraintWidget>) null, 0);
        }
        if (constraintWidgetContainer.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem2, (ArrayList<ConstraintWidget>) null, 1);
        }
        return true;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.mHorizontalWrapMax;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.mHorizontalWrapMax.get().getFinalValue()) {
            this.mHorizontalWrapMax = new WeakReference<>(constraintAnchor);
        }
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.mHorizontalWrapMin;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.mHorizontalWrapMin.get().getFinalValue()) {
            this.mHorizontalWrapMin = new WeakReference<>(constraintAnchor);
        }
    }

    /* access modifiers changed from: package-private */
    public void addVerticalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.mVerticalWrapMax;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.mVerticalWrapMax.get().getFinalValue()) {
            this.mVerticalWrapMax = new WeakReference<>(constraintAnchor);
        }
    }

    /* access modifiers changed from: package-private */
    public void addVerticalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.mVerticalWrapMin;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.mVerticalWrapMin.get().getFinalValue()) {
            this.mVerticalWrapMin = new WeakReference<>(constraintAnchor);
        }
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean z4) {
        return this.mDependencyGraph.directMeasure(z4);
    }

    public boolean directMeasureSetup(boolean z4) {
        return this.mDependencyGraph.directMeasureSetup(z4);
    }

    public boolean directMeasureWithOrientation(boolean z4, int i5) {
        return this.mDependencyGraph.directMeasureWithOrientation(z4, i5);
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i5);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public void getSceneString(StringBuilder sb) {
        sb.append(this.stringId + ":{\n");
        sb.append("  actualWidth:" + this.mWidth);
        sb.append("\n");
        sb.append("  actualHeight:" + this.mHeight);
        sb.append("\n");
        ArrayList<ConstraintWidget> children = getChildren();
        int size = children.size();
        int i5 = 0;
        while (i5 < size) {
            ConstraintWidget constraintWidget = children.get(i5);
            i5++;
            constraintWidget.getSceneString(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i5);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: int} */
    /* JADX WARNING: type inference failed for: r6v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0247 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x033b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r21 = this;
            r1 = r21
            r2 = 0
            r1.mX = r2
            r1.mY = r2
            r1.mWidthMeasuredTooSmall = r2
            r1.mHeightMeasuredTooSmall = r2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r1.mChildren
            int r3 = r0.size()
            int r0 = r1.getWidth()
            int r0 = java.lang.Math.max(r2, r0)
            int r4 = r1.getHeight()
            int r4 = java.lang.Math.max(r2, r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            r6 = 1
            r7 = r5[r6]
            r5 = r5[r2]
            androidx.constraintlayout.core.Metrics r8 = r1.mMetrics
            if (r8 == 0) goto L_0x0033
            long r9 = r8.layouts
            r11 = 1
            long r9 = r9 + r11
            r8.layouts = r9
        L_0x0033:
            int r8 = r1.mPass
            if (r8 != 0) goto L_0x008f
            int r8 = r1.mOptimizationLevel
            boolean r8 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r8, r6)
            if (r8 == 0) goto L_0x008f
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r8 = r1.getMeasurer()
            androidx.constraintlayout.core.widgets.analyzer.Direct.solvingPass(r1, r8)
            r8 = r2
        L_0x0047:
            if (r8 >= r3) goto L_0x008f
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r9 = r1.mChildren
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9.isMeasureRequested()
            if (r10 == 0) goto L_0x008c
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r10 != 0) goto L_0x008c
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r10 != 0) goto L_0x008c
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r10 != 0) goto L_0x008c
            boolean r10 = r9.isInVirtualLayout()
            if (r10 != 0) goto L_0x008c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r9.getDimensionBehaviour(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.getDimensionBehaviour(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r12) goto L_0x0080
            int r10 = r9.mMatchConstraintDefaultWidth
            if (r10 == r6) goto L_0x0080
            if (r11 != r12) goto L_0x0080
            int r10 = r9.mMatchConstraintDefaultHeight
            if (r10 == r6) goto L_0x0080
            goto L_0x008c
        L_0x0080:
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r10 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r10.<init>()
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r11 = r1.mMeasurer
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS
            measure(r2, r9, r11, r10, r12)
        L_0x008c:
            int r8 = r8 + 1
            goto L_0x0047
        L_0x008f:
            r8 = 2
            if (r3 <= r8) goto L_0x00d8
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r9) goto L_0x0098
            if (r7 != r9) goto L_0x00d8
        L_0x0098:
            int r10 = r1.mOptimizationLevel
            r11 = 1024(0x400, float:1.435E-42)
            boolean r10 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r10, r11)
            if (r10 == 0) goto L_0x00d8
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r10 = r1.getMeasurer()
            boolean r10 = androidx.constraintlayout.core.widgets.analyzer.Grouping.simpleSolvingPass(r1, r10)
            if (r10 == 0) goto L_0x00d8
            if (r5 != r9) goto L_0x00c0
            int r10 = r1.getWidth()
            if (r0 >= r10) goto L_0x00bc
            if (r0 <= 0) goto L_0x00bc
            r1.setWidth(r0)
            r1.mWidthMeasuredTooSmall = r6
            goto L_0x00c0
        L_0x00bc:
            int r0 = r1.getWidth()
        L_0x00c0:
            if (r7 != r9) goto L_0x00d4
            int r9 = r1.getHeight()
            if (r4 >= r9) goto L_0x00d0
            if (r4 <= 0) goto L_0x00d0
            r1.setHeight(r4)
            r1.mHeightMeasuredTooSmall = r6
            goto L_0x00d4
        L_0x00d0:
            int r4 = r1.getHeight()
        L_0x00d4:
            r9 = r4
            r4 = r0
            r0 = r6
            goto L_0x00db
        L_0x00d8:
            r9 = r4
            r4 = r0
            r0 = r2
        L_0x00db:
            r10 = 64
            boolean r11 = r1.optimizeFor(r10)
            if (r11 != 0) goto L_0x00ee
            r11 = 128(0x80, float:1.794E-43)
            boolean r11 = r1.optimizeFor(r11)
            if (r11 == 0) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            r11 = r2
            goto L_0x00ef
        L_0x00ee:
            r11 = r6
        L_0x00ef:
            androidx.constraintlayout.core.LinearSystem r12 = r1.mSystem
            r12.graphOptimizer = r2
            r12.newgraphOptimizer = r2
            int r13 = r1.mOptimizationLevel
            if (r13 == 0) goto L_0x00fd
            if (r11 == 0) goto L_0x00fd
            r12.newgraphOptimizer = r6
        L_0x00fd:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r11 = r1.mChildren
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r1.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r13) goto L_0x0110
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r1.getVerticalDimensionBehaviour()
            if (r12 != r13) goto L_0x010e
            goto L_0x0110
        L_0x010e:
            r12 = r2
            goto L_0x0111
        L_0x0110:
            r12 = r6
        L_0x0111:
            r1.resetChains()
            r13 = r2
        L_0x0115:
            if (r13 >= r3) goto L_0x012b
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r14 = r1.mChildren
            java.lang.Object r14 = r14.get(r13)
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            boolean r15 = r14 instanceof androidx.constraintlayout.core.widgets.WidgetContainer
            if (r15 == 0) goto L_0x0128
            androidx.constraintlayout.core.widgets.WidgetContainer r14 = (androidx.constraintlayout.core.widgets.WidgetContainer) r14
            r14.layout()
        L_0x0128:
            int r13 = r13 + 1
            goto L_0x0115
        L_0x012b:
            boolean r10 = r1.optimizeFor(r10)
            r13 = r0
            r0 = r2
            r14 = r6
        L_0x0132:
            if (r14 == 0) goto L_0x0345
            int r15 = r0 + 1
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x01fd }
            r0.reset()     // Catch:{ Exception -> 0x01fd }
            r1.resetChains()     // Catch:{ Exception -> 0x01fd }
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x01fd }
            r1.createObjectVariables(r0)     // Catch:{ Exception -> 0x01fd }
            r0 = r2
        L_0x0144:
            if (r0 >= r3) goto L_0x0167
            r16 = r2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.mChildren     // Catch:{ Exception -> 0x0163 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ Exception -> 0x0163 }
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2     // Catch:{ Exception -> 0x0163 }
            r17 = r8
            androidx.constraintlayout.core.LinearSystem r8 = r1.mSystem     // Catch:{ Exception -> 0x015e }
            r2.createObjectVariables(r8)     // Catch:{ Exception -> 0x015e }
            int r0 = r0 + 1
            r2 = r16
            r8 = r17
            goto L_0x0144
        L_0x015e:
            r0 = move-exception
        L_0x015f:
            r18 = r6
            goto L_0x0204
        L_0x0163:
            r0 = move-exception
            r17 = r8
            goto L_0x015f
        L_0x0167:
            r16 = r2
            r17 = r8
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x015e }
            boolean r14 = r1.addChildrenToSolver(r0)     // Catch:{ Exception -> 0x015e }
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.mVerticalWrapMin     // Catch:{ Exception -> 0x015e }
            r2 = 0
            if (r0 == 0) goto L_0x0196
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x015e }
            if (r0 == 0) goto L_0x0196
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.mVerticalWrapMin     // Catch:{ Exception -> 0x015e }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x015e }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x015e }
            androidx.constraintlayout.core.LinearSystem r8 = r1.mSystem     // Catch:{ Exception -> 0x015e }
            r18 = r6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r1.mTop     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.SolverVariable r6 = r8.createObjectVariable(r6)     // Catch:{ Exception -> 0x0194 }
            r1.addMinWrap(r0, r6)     // Catch:{ Exception -> 0x0194 }
            r1.mVerticalWrapMin = r2     // Catch:{ Exception -> 0x0194 }
            goto L_0x0198
        L_0x0194:
            r0 = move-exception
            goto L_0x0204
        L_0x0196:
            r18 = r6
        L_0x0198:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.mVerticalWrapMax     // Catch:{ Exception -> 0x0194 }
            if (r0 == 0) goto L_0x01b7
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0194 }
            if (r0 == 0) goto L_0x01b7
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.mVerticalWrapMax     // Catch:{ Exception -> 0x0194 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.mSystem     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.mBottom     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.createObjectVariable(r8)     // Catch:{ Exception -> 0x0194 }
            r1.addMaxWrap(r0, r6)     // Catch:{ Exception -> 0x0194 }
            r1.mVerticalWrapMax = r2     // Catch:{ Exception -> 0x0194 }
        L_0x01b7:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.mHorizontalWrapMin     // Catch:{ Exception -> 0x0194 }
            if (r0 == 0) goto L_0x01d6
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0194 }
            if (r0 == 0) goto L_0x01d6
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.mHorizontalWrapMin     // Catch:{ Exception -> 0x0194 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.mSystem     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.mLeft     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.createObjectVariable(r8)     // Catch:{ Exception -> 0x0194 }
            r1.addMinWrap(r0, r6)     // Catch:{ Exception -> 0x0194 }
            r1.mHorizontalWrapMin = r2     // Catch:{ Exception -> 0x0194 }
        L_0x01d6:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.mHorizontalWrapMax     // Catch:{ Exception -> 0x0194 }
            if (r0 == 0) goto L_0x01f5
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0194 }
            if (r0 == 0) goto L_0x01f5
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.mHorizontalWrapMax     // Catch:{ Exception -> 0x0194 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.mSystem     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.mRight     // Catch:{ Exception -> 0x0194 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.createObjectVariable(r8)     // Catch:{ Exception -> 0x0194 }
            r1.addMaxWrap(r0, r6)     // Catch:{ Exception -> 0x0194 }
            r1.mHorizontalWrapMax = r2     // Catch:{ Exception -> 0x0194 }
        L_0x01f5:
            if (r14 == 0) goto L_0x021d
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0194 }
            r0.minimize()     // Catch:{ Exception -> 0x0194 }
            goto L_0x021d
        L_0x01fd:
            r0 = move-exception
            r16 = r2
            r18 = r6
            r17 = r8
        L_0x0204:
            r0.printStackTrace()
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "EXCEPTION : "
            r6.append(r8)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r2.println(r0)
        L_0x021d:
            if (r14 == 0) goto L_0x0228
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem
            boolean[] r2 = androidx.constraintlayout.core.widgets.Optimizer.sFlags
            boolean r0 = r1.updateChildrenFromSolver(r0, r2)
            goto L_0x0243
        L_0x0228:
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem
            r1.updateFromSolver(r0, r10)
            r0 = r16
        L_0x022f:
            if (r0 >= r3) goto L_0x0241
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.mChildren
            java.lang.Object r2 = r2.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            androidx.constraintlayout.core.LinearSystem r6 = r1.mSystem
            r2.updateFromSolver(r6, r10)
            int r0 = r0 + 1
            goto L_0x022f
        L_0x0241:
            r0 = r16
        L_0x0243:
            r2 = 8
            if (r12 == 0) goto L_0x02b4
            if (r15 >= r2) goto L_0x02b4
            boolean[] r6 = androidx.constraintlayout.core.widgets.Optimizer.sFlags
            boolean r6 = r6[r17]
            if (r6 == 0) goto L_0x02b4
            r6 = r16
            r8 = r6
            r14 = r8
        L_0x0253:
            if (r6 >= r3) goto L_0x027d
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.mChildren
            java.lang.Object r2 = r2.get(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            r19 = r0
            int r0 = r2.mX
            int r20 = r2.getWidth()
            int r0 = r0 + r20
            int r8 = java.lang.Math.max(r8, r0)
            int r0 = r2.mY
            int r2 = r2.getHeight()
            int r0 = r0 + r2
            int r14 = java.lang.Math.max(r14, r0)
            int r6 = r6 + 1
            r0 = r19
            r2 = 8
            goto L_0x0253
        L_0x027d:
            r19 = r0
            int r0 = r1.mMinWidth
            int r0 = java.lang.Math.max(r0, r8)
            int r2 = r1.mMinHeight
            int r2 = java.lang.Math.max(r2, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r6) goto L_0x02a0
            int r8 = r1.getWidth()
            if (r8 >= r0) goto L_0x02a0
            r1.setWidth(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r0[r16] = r6
            r13 = r18
            r19 = r13
        L_0x02a0:
            if (r7 != r6) goto L_0x02b6
            int r0 = r1.getHeight()
            if (r0 >= r2) goto L_0x02b6
            r1.setHeight(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r0[r18] = r6
            r13 = r18
            r19 = r13
            goto L_0x02b6
        L_0x02b4:
            r19 = r0
        L_0x02b6:
            int r0 = r1.mMinWidth
            int r2 = r1.getWidth()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r1.getWidth()
            if (r0 <= r2) goto L_0x02d3
            r1.setWidth(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r16] = r2
            r13 = r18
            r19 = r13
        L_0x02d3:
            int r0 = r1.mMinHeight
            int r2 = r1.getHeight()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r1.getHeight()
            if (r0 <= r2) goto L_0x02f0
            r1.setHeight(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r18] = r2
            r13 = r18
            r19 = r13
        L_0x02f0:
            if (r13 != 0) goto L_0x0334
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r0 = r0[r16]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r2) goto L_0x0313
            if (r4 <= 0) goto L_0x0313
            int r0 = r1.getWidth()
            if (r0 <= r4) goto L_0x0313
            r6 = r18
            r1.mWidthMeasuredTooSmall = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r16] = r8
            r1.setWidth(r4)
            r13 = r6
            r19 = r13
            goto L_0x0315
        L_0x0313:
            r6 = r18
        L_0x0315:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r0 = r0[r6]
            if (r0 != r2) goto L_0x0334
            if (r9 <= 0) goto L_0x0334
            int r0 = r1.getHeight()
            if (r0 <= r9) goto L_0x0334
            r1.mHeightMeasuredTooSmall = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r6] = r2
            r1.setHeight(r9)
            r0 = 8
            r13 = 1
            r19 = 1
            goto L_0x0336
        L_0x0334:
            r0 = 8
        L_0x0336:
            if (r15 <= r0) goto L_0x033b
            r14 = r16
            goto L_0x033d
        L_0x033b:
            r14 = r19
        L_0x033d:
            r0 = r15
            r2 = r16
            r8 = r17
            r6 = 1
            goto L_0x0132
        L_0x0345:
            r16 = r2
            r1.mChildren = r11
            if (r13 == 0) goto L_0x0353
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r0[r16] = r5
            r18 = 1
            r0[r18] = r7
        L_0x0353:
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem
            androidx.constraintlayout.core.Cache r0 = r0.getCache()
            r1.resetSolverVariables(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.layout():void");
    }

    public long measure(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        int i14 = i12;
        this.mPaddingLeft = i14;
        int i15 = i13;
        this.mPaddingTop = i15;
        return this.mBasicMeasureSolver.solverMeasure(this, i5, i14, i15, i6, i7, i8, i9, i10, i11);
    }

    public boolean optimizeFor(int i5) {
        if ((this.mOptimizationLevel & i5) == i5) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public void setOptimizationLevel(int i5) {
        this.mOptimizationLevel = i5;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setPadding(int i5, int i6, int i7, int i8) {
        this.mPaddingLeft = i5;
        this.mPaddingTop = i6;
        this.mPaddingRight = i7;
        this.mPaddingBottom = i8;
    }

    public void setPass(int i5) {
        this.mPass = i5;
    }

    public void setRtl(boolean z4) {
        this.mIsRtl = z4;
    }

    public boolean updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean optimizeFor = optimizeFor(64);
        updateFromSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i5);
            constraintWidget.updateFromSolver(linearSystem, optimizeFor);
            if (constraintWidget.hasDimensionOverride()) {
                z4 = true;
            }
        }
        return z4;
    }

    public void updateFromRuns(boolean z4, boolean z5) {
        super.updateFromRuns(z4, z5);
        int size = this.mChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.mChildren.get(i5).updateFromRuns(z4, z5);
        }
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }

    public static boolean measure(int i5, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i6) {
        int i7;
        int i8;
        if (measurer == null) {
            return false;
        }
        if (constraintWidget.getVisibility() == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
            measure.measuredWidth = 0;
            measure.measuredHeight = 0;
            return false;
        }
        measure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        measure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        measure.horizontalDimension = constraintWidget.getWidth();
        measure.verticalDimension = constraintWidget.getHeight();
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z4 = dimensionBehaviour == dimensionBehaviour2;
        boolean z5 = measure.verticalBehavior == dimensionBehaviour2;
        boolean z6 = z4 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z7 = z5 && constraintWidget.mDimensionRatio > 0.0f;
        if (z4 && constraintWidget.hasDanglingDimension(0) && constraintWidget.mMatchConstraintDefaultWidth == 0 && !z6) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z5 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z4 = false;
        }
        if (z5 && constraintWidget.hasDanglingDimension(1) && constraintWidget.mMatchConstraintDefaultHeight == 0 && !z7) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z4 && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z5 = false;
        }
        if (constraintWidget.isResolvedHorizontally()) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            z4 = false;
        }
        if (constraintWidget.isResolvedVertically()) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            z5 = false;
        }
        if (z6) {
            if (constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z5) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.verticalBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i8 = measure.verticalDimension;
                } else {
                    measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    i8 = measure.measuredHeight;
                }
                measure.horizontalBehavior = dimensionBehaviour4;
                measure.horizontalDimension = (int) (constraintWidget.getDimensionRatio() * ((float) i8));
            }
        }
        if (z7) {
            if (constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z4) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.horizontalBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i7 = measure.horizontalDimension;
                } else {
                    measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    i7 = measure.measuredWidth;
                }
                measure.verticalBehavior = dimensionBehaviour6;
                if (constraintWidget.getDimensionRatioSide() == -1) {
                    measure.verticalDimension = (int) (((float) i7) / constraintWidget.getDimensionRatio());
                } else {
                    measure.verticalDimension = (int) (constraintWidget.getDimensionRatio() * ((float) i7));
                }
            }
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.setHasBaseline(measure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(measure.measuredBaseline);
        measure.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
        return measure.measuredNeedsSolverPass;
    }

    public ConstraintWidgetContainer(int i5, int i6, int i7, int i8) {
        super(i5, i6, i7, i8);
    }

    public ConstraintWidgetContainer(int i5, int i6) {
        super(i5, i6);
    }

    public ConstraintWidgetContainer(String str, int i5, int i6) {
        super(i5, i6);
        setDebugName(str);
    }
}
