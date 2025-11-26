package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;

public class DependencyGraph {
    private static final boolean DEBUG = false;
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer mContainer;
    ArrayList<RunGroup> mGroups = new ArrayList<>();
    private BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    private BasicMeasure.Measurer mMeasurer = null;
    private boolean mNeedBuildGraph = true;
    private boolean mNeedRedoMeasures = true;
    private ArrayList<RunGroup> mRunGroups = new ArrayList<>();
    private ArrayList<WidgetRun> mRuns = new ArrayList<>();
    private ConstraintWidgetContainer mWidgetcontainer;

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mWidgetcontainer = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    private void applyGroup(DependencyNode dependencyNode, int i5, int i6, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        ArrayList<RunGroup> arrayList2;
        DependencyNode dependencyNode3;
        int i7;
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun.mRunGroup == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.mWidgetcontainer;
            if (widgetRun != constraintWidgetContainer.mHorizontalRun && widgetRun != constraintWidgetContainer.mVerticalRun) {
                if (runGroup == null) {
                    runGroup = new RunGroup(widgetRun, i6);
                    arrayList.add(runGroup);
                }
                RunGroup runGroup2 = runGroup;
                widgetRun.mRunGroup = runGroup2;
                runGroup2.add(widgetRun);
                for (Dependency next : widgetRun.start.mDependencies) {
                    if (next instanceof DependencyNode) {
                        i7 = i5;
                        dependencyNode3 = dependencyNode2;
                        arrayList2 = arrayList;
                        applyGroup((DependencyNode) next, i7, 0, dependencyNode3, arrayList2, runGroup2);
                    } else {
                        i7 = i5;
                        dependencyNode3 = dependencyNode2;
                        arrayList2 = arrayList;
                    }
                    i5 = i7;
                    dependencyNode2 = dependencyNode3;
                    arrayList = arrayList2;
                }
                int i8 = i5;
                DependencyNode dependencyNode4 = dependencyNode2;
                ArrayList<RunGroup> arrayList3 = arrayList;
                for (Dependency next2 : widgetRun.end.mDependencies) {
                    if (next2 instanceof DependencyNode) {
                        applyGroup((DependencyNode) next2, i8, 1, dependencyNode4, arrayList3, runGroup2);
                    }
                }
                if (i8 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (Dependency next3 : ((VerticalWidgetRun) widgetRun).baseline.mDependencies) {
                        if (next3 instanceof DependencyNode) {
                            applyGroup((DependencyNode) next3, i8, 2, dependencyNode4, arrayList3, runGroup2);
                        }
                    }
                }
                for (DependencyNode next4 : widgetRun.start.mTargets) {
                    if (next4 == dependencyNode4) {
                        runGroup2.dual = true;
                    }
                    applyGroup(next4, i8, 0, dependencyNode4, arrayList3, runGroup2);
                }
                for (DependencyNode next5 : widgetRun.end.mTargets) {
                    if (next5 == dependencyNode4) {
                        runGroup2.dual = true;
                    }
                    applyGroup(next5, i8, 1, dependencyNode4, arrayList3, runGroup2);
                }
                if (i8 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (DependencyNode applyGroup : ((VerticalWidgetRun) widgetRun).baseline.mTargets) {
                        try {
                            applyGroup(applyGroup, i8, 2, dependencyNode4, arrayList3, runGroup2);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r16v1 */
    /* JADX WARNING: type inference failed for: r3v82 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean basicMeasureWidgets(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r22) {
        /*
            r21 = this;
            r0 = r22
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r0.mChildren
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        L_0x000a:
            if (r4 >= r2) goto L_0x0347
            java.lang.Object r5 = r1.get(r4)
            int r4 = r4 + 1
            r7 = r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r7.mListDimensionBehaviors
            r6 = r5[r3]
            r12 = 1
            r5 = r5[r12]
            int r8 = r7.getVisibility()
            r9 = 8
            if (r8 != r9) goto L_0x0027
            r7.measured = r12
            goto L_0x000a
        L_0x0027:
            float r8 = r7.mMatchConstraintPercentWidth
            r13 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            r9 = 2
            if (r8 >= 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r8) goto L_0x0036
            r7.mMatchConstraintDefaultWidth = r9
        L_0x0036:
            float r8 = r7.mMatchConstraintPercentHeight
            int r8 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r8 >= 0) goto L_0x0042
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r8) goto L_0x0042
            r7.mMatchConstraintDefaultHeight = r9
        L_0x0042:
            float r8 = r7.getDimensionRatio()
            r10 = 0
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            r10 = 3
            if (r8 <= 0) goto L_0x0078
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r8) goto L_0x005b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r11) goto L_0x0058
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 != r11) goto L_0x005b
        L_0x0058:
            r7.mMatchConstraintDefaultWidth = r10
            goto L_0x0078
        L_0x005b:
            if (r5 != r8) goto L_0x0068
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r6 == r11) goto L_0x0065
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r6 != r11) goto L_0x0068
        L_0x0065:
            r7.mMatchConstraintDefaultHeight = r10
            goto L_0x0078
        L_0x0068:
            if (r6 != r8) goto L_0x0078
            if (r5 != r8) goto L_0x0078
            int r8 = r7.mMatchConstraintDefaultWidth
            if (r8 != 0) goto L_0x0072
            r7.mMatchConstraintDefaultWidth = r10
        L_0x0072:
            int r8 = r7.mMatchConstraintDefaultHeight
            if (r8 != 0) goto L_0x0078
            r7.mMatchConstraintDefaultHeight = r10
        L_0x0078:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r8) goto L_0x008e
            int r11 = r7.mMatchConstraintDefaultWidth
            if (r11 != r12) goto L_0x008e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r7.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.mTarget
            if (r11 == 0) goto L_0x008c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r7.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.mTarget
            if (r11 != 0) goto L_0x008e
        L_0x008c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x008e:
            if (r5 != r8) goto L_0x00a2
            int r11 = r7.mMatchConstraintDefaultHeight
            if (r11 != r12) goto L_0x00a2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r7.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.mTarget
            if (r11 == 0) goto L_0x00a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r7.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.mTarget
            if (r11 != 0) goto L_0x00a2
        L_0x00a0:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x00a2:
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r11 = r7.mHorizontalRun
            r11.mDimensionBehavior = r6
            int r14 = r7.mMatchConstraintDefaultWidth
            r11.matchConstraintsType = r14
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r11 = r7.mVerticalRun
            r11.mDimensionBehavior = r5
            int r15 = r7.mMatchConstraintDefaultHeight
            r11.matchConstraintsType = r15
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r16 = r3
            if (r6 == r11) goto L_0x00c0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r6 == r3) goto L_0x00c0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r6 != r3) goto L_0x00ce
        L_0x00c0:
            if (r5 == r11) goto L_0x00ca
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 == r3) goto L_0x00ca
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r3) goto L_0x00ce
        L_0x00ca:
            r10 = r5
            r8 = r6
            goto L_0x02f8
        L_0x00ce:
            if (r6 != r8) goto L_0x01a3
            r3 = r8
            r17 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r18 = r13
            if (r5 == r8) goto L_0x00e5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 != r13) goto L_0x00de
            goto L_0x00e5
        L_0x00de:
            r20 = r10
            r10 = r5
            r5 = r20
            goto L_0x01ab
        L_0x00e5:
            if (r14 != r10) goto L_0x0120
            if (r5 != r8) goto L_0x00f1
            r9 = 0
            r11 = 0
            r10 = r8
            r6 = r21
            r6.measure(r7, r8, r9, r10, r11)
        L_0x00f1:
            int r11 = r7.getHeight()
            float r3 = (float) r11
            float r5 = r7.mDimensionRatio
            float r3 = r3 * r5
            float r3 = r3 + r17
            int r9 = (int) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10 = r8
            r6 = r21
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r7.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getWidth()
            r3.resolve(r5)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r7.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getHeight()
            r3.resolve(r5)
            r7.measured = r12
        L_0x011c:
            r3 = r16
            goto L_0x000a
        L_0x0120:
            if (r14 != r12) goto L_0x0135
            r9 = 0
            r11 = 0
            r6 = r21
            r10 = r5
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r7.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getWidth()
            r3.wrapValue = r5
            goto L_0x011c
        L_0x0135:
            r20 = r10
            r10 = r5
            r5 = r20
            if (r14 != r9) goto L_0x0174
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r0.mListDimensionBehaviors
            r8 = r8[r16]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r8 == r13) goto L_0x0146
            if (r8 != r11) goto L_0x01ab
        L_0x0146:
            float r3 = r7.mMatchConstraintPercentWidth
            int r5 = r0.getWidth()
            float r5 = (float) r5
            float r3 = r3 * r5
            float r3 = r3 + r17
            int r9 = (int) r3
            int r11 = r7.getHeight()
            r6 = r21
            r8 = r13
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r7.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getWidth()
            r3.resolve(r5)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r7.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getHeight()
            r3.resolve(r5)
            r7.measured = r12
            goto L_0x011c
        L_0x0174:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r13 = r7.mListAnchors
            r9 = r13[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 == 0) goto L_0x0182
            r9 = r13[r12]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 != 0) goto L_0x01ab
        L_0x0182:
            r9 = 0
            r11 = 0
            r6 = r21
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r7.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getWidth()
            r3.resolve(r5)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r7.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getHeight()
            r3.resolve(r5)
            r7.measured = r12
            goto L_0x011c
        L_0x01a3:
            r3 = r10
            r10 = r5
            r5 = r3
            r3 = r8
            r18 = r13
            r17 = 1056964608(0x3f000000, float:0.5)
        L_0x01ab:
            if (r10 != r3) goto L_0x01b6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r6 == r8) goto L_0x01b9
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r6 != r9) goto L_0x01b6
            goto L_0x01b9
        L_0x01b6:
            r8 = r6
            goto L_0x0288
        L_0x01b9:
            if (r15 != r5) goto L_0x01fb
            if (r6 != r8) goto L_0x01c5
            r9 = 0
            r11 = 0
            r10 = r8
            r6 = r21
            r6.measure(r7, r8, r9, r10, r11)
        L_0x01c5:
            int r9 = r7.getWidth()
            float r3 = r7.mDimensionRatio
            int r5 = r7.getDimensionRatioSide()
            r6 = -1
            if (r5 != r6) goto L_0x01d4
            float r3 = r18 / r3
        L_0x01d4:
            float r5 = (float) r9
            float r5 = r5 * r3
            float r5 = r5 + r17
            int r11 = (int) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10 = r8
            r6 = r21
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r7.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getWidth()
            r3.resolve(r5)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r7.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getHeight()
            r3.resolve(r5)
            r7.measured = r12
            goto L_0x011c
        L_0x01fb:
            if (r15 != r12) goto L_0x0212
            r9 = 0
            r11 = 0
            r10 = r8
            r8 = r6
            r6 = r21
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r7.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getHeight()
            r3.wrapValue = r5
            goto L_0x011c
        L_0x0212:
            r9 = r8
            r8 = r6
            r6 = r9
            r9 = 2
            if (r15 != r9) goto L_0x0254
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r0.mListDimensionBehaviors
            r5 = r5[r12]
            r9 = r10
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 == r10) goto L_0x0226
            if (r5 != r11) goto L_0x0224
            goto L_0x0226
        L_0x0224:
            r10 = r9
            goto L_0x0288
        L_0x0226:
            float r3 = r7.mMatchConstraintPercentHeight
            int r9 = r7.getWidth()
            int r5 = r0.getHeight()
            float r5 = (float) r5
            float r3 = r3 * r5
            float r3 = r3 + r17
            int r11 = (int) r3
            r6 = r21
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r7.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getWidth()
            r3.resolve(r5)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r7.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getHeight()
            r3.resolve(r5)
            r7.measured = r12
            goto L_0x011c
        L_0x0254:
            r9 = r10
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r10 = r7.mListAnchors
            r19 = 2
            r11 = r10[r19]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.mTarget
            if (r11 == 0) goto L_0x0265
            r5 = r10[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x0224
        L_0x0265:
            r10 = r9
            r9 = 0
            r11 = 0
            r8 = r6
            r6 = r21
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r7.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getWidth()
            r3.resolve(r5)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r7.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getHeight()
            r3.resolve(r5)
            r7.measured = r12
            goto L_0x011c
        L_0x0288:
            if (r8 != r3) goto L_0x011c
            if (r10 != r3) goto L_0x011c
            if (r14 == r12) goto L_0x02d8
            if (r15 != r12) goto L_0x0291
            goto L_0x02d8
        L_0x0291:
            r9 = 2
            if (r15 != r9) goto L_0x011c
            if (r14 != r9) goto L_0x011c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r0.mListDimensionBehaviors
            r5 = r3[r16]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 != r8) goto L_0x011c
            r3 = r3[r12]
            if (r3 != r8) goto L_0x011c
            float r3 = r7.mMatchConstraintPercentWidth
            float r5 = r7.mMatchConstraintPercentHeight
            int r6 = r0.getWidth()
            float r6 = (float) r6
            float r3 = r3 * r6
            float r3 = r3 + r17
            int r9 = (int) r3
            int r3 = r0.getHeight()
            float r3 = (float) r3
            float r5 = r5 * r3
            float r5 = r5 + r17
            int r11 = (int) r5
            r10 = r8
            r6 = r21
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r7.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getWidth()
            r3.resolve(r5)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r7.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getHeight()
            r3.resolve(r5)
            r7.measured = r12
            goto L_0x011c
        L_0x02d8:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r9 = 0
            r11 = 0
            r10 = r8
            r6 = r21
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r7.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getWidth()
            r3.wrapValue = r5
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r7.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getHeight()
            r3.wrapValue = r5
            goto L_0x011c
        L_0x02f8:
            int r3 = r7.getWidth()
            if (r8 != r11) goto L_0x030f
            int r3 = r0.getWidth()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r7.mLeft
            int r5 = r5.mMargin
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r7.mRight
            int r5 = r5.mMargin
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = r6
        L_0x030f:
            r9 = r3
            int r3 = r7.getHeight()
            if (r10 != r11) goto L_0x0327
            int r3 = r0.getHeight()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r7.mTop
            int r5 = r5.mMargin
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r7.mBottom
            int r5 = r5.mMargin
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10 = r5
        L_0x0327:
            r6 = r21
            r11 = r3
            r6.measure(r7, r8, r9, r10, r11)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r7.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getWidth()
            r3.resolve(r5)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r7.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            int r5 = r7.getHeight()
            r3.resolve(r5)
            r7.measured = r12
            goto L_0x011c
        L_0x0347:
            r16 = r3
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.basicMeasureWidgets(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):boolean");
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i5) {
        int size = this.mGroups.size();
        long j5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            j5 = Math.max(j5, this.mGroups.get(i6).computeWrapSize(constraintWidgetContainer, i5));
        }
        return (int) j5;
    }

    private void displayGraph() {
        ArrayList<WidgetRun> arrayList = this.mRuns;
        int size = arrayList.size();
        String str = "digraph {\n";
        int i5 = 0;
        while (i5 < size) {
            WidgetRun widgetRun = arrayList.get(i5);
            i5++;
            str = generateDisplayGraph(widgetRun, str);
        }
        PrintStream printStream = System.out;
        printStream.println("content:<<\n" + (str + "\n}\n") + "\n>>");
    }

    private void findGroup(WidgetRun widgetRun, int i5, ArrayList<RunGroup> arrayList) {
        WidgetRun widgetRun2 = widgetRun;
        for (Dependency next : widgetRun2.start.mDependencies) {
            if (next instanceof DependencyNode) {
                applyGroup((DependencyNode) next, i5, 0, widgetRun2.end, arrayList, (RunGroup) null);
            } else if (next instanceof WidgetRun) {
                applyGroup(((WidgetRun) next).start, i5, 0, widgetRun2.end, arrayList, (RunGroup) null);
            }
        }
        for (Dependency next2 : widgetRun2.end.mDependencies) {
            if (next2 instanceof DependencyNode) {
                applyGroup((DependencyNode) next2, i5, 1, widgetRun2.start, arrayList, (RunGroup) null);
            } else if (next2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) next2).end, i5, 1, widgetRun2.start, arrayList, (RunGroup) null);
            }
        }
        int i6 = i5;
        if (i6 == 1) {
            for (Dependency next3 : ((VerticalWidgetRun) widgetRun2).baseline.mDependencies) {
                if (next3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) next3, i6, 2, (DependencyNode) null, arrayList, (RunGroup) null);
                }
                i6 = i5;
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun chainRun, String str) {
        int i5 = chainRun.orientation;
        StringBuilder sb = new StringBuilder("subgraph ");
        sb.append("cluster_");
        sb.append(chainRun.mWidget.getDebugName());
        if (i5 == 0) {
            sb.append("_h");
        } else {
            sb.append("_v");
        }
        sb.append(" {\n");
        ArrayList<WidgetRun> arrayList = chainRun.mWidgets;
        int size = arrayList.size();
        String str2 = "";
        int i6 = 0;
        while (i6 < size) {
            WidgetRun widgetRun = arrayList.get(i6);
            i6++;
            WidgetRun widgetRun2 = widgetRun;
            sb.append(widgetRun2.mWidget.getDebugName());
            if (i5 == 0) {
                sb.append("_HORIZONTAL");
            } else {
                sb.append("_VERTICAL");
            }
            sb.append(";\n");
            str2 = generateDisplayGraph(widgetRun2, str2);
        }
        sb.append("}\n");
        return str + str2 + sb;
    }

    private String generateDisplayGraph(WidgetRun widgetRun, String str) {
        boolean z4;
        DependencyNode dependencyNode = widgetRun.start;
        DependencyNode dependencyNode2 = widgetRun.end;
        StringBuilder sb = new StringBuilder(str);
        if (!(widgetRun instanceof HelperReferences) && dependencyNode.mDependencies.isEmpty() && dependencyNode2.mDependencies.isEmpty() && dependencyNode.mTargets.isEmpty() && dependencyNode2.mTargets.isEmpty()) {
            return str;
        }
        sb.append(nodeDefinition(widgetRun));
        boolean isCenteredConnection = isCenteredConnection(dependencyNode, dependencyNode2);
        String generateDisplayNode = generateDisplayNode(dependencyNode2, isCenteredConnection, generateDisplayNode(dependencyNode, isCenteredConnection, str));
        boolean z5 = widgetRun instanceof VerticalWidgetRun;
        if (z5) {
            generateDisplayNode = generateDisplayNode(((VerticalWidgetRun) widgetRun).baseline, isCenteredConnection, generateDisplayNode);
        }
        if ((widgetRun instanceof HorizontalWidgetRun) || (((z4 = widgetRun instanceof ChainRun)) && ((ChainRun) widgetRun).orientation == 0)) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = widgetRun.mWidget.getHorizontalDimensionBehaviour();
            if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED || horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.mTargets.isEmpty() && dependencyNode2.mTargets.isEmpty()) {
                    sb.append("\n");
                    sb.append(dependencyNode2.name());
                    sb.append(" -> ");
                    sb.append(dependencyNode.name());
                    sb.append("\n");
                } else if (dependencyNode.mTargets.isEmpty() && !dependencyNode2.mTargets.isEmpty()) {
                    sb.append("\n");
                    sb.append(dependencyNode.name());
                    sb.append(" -> ");
                    sb.append(dependencyNode2.name());
                    sb.append("\n");
                }
            } else if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.mWidget.getDimensionRatio() > 0.0f) {
                sb.append("\n");
                sb.append(widgetRun.mWidget.getDebugName());
                sb.append("_HORIZONTAL -> ");
                sb.append(widgetRun.mWidget.getDebugName());
                sb.append("_VERTICAL;\n");
            }
        } else if (z5 || (z4 && ((ChainRun) widgetRun).orientation == 1)) {
            ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = widgetRun.mWidget.getVerticalDimensionBehaviour();
            if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED || verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.mTargets.isEmpty() && dependencyNode2.mTargets.isEmpty()) {
                    sb.append("\n");
                    sb.append(dependencyNode2.name());
                    sb.append(" -> ");
                    sb.append(dependencyNode.name());
                    sb.append("\n");
                } else if (dependencyNode.mTargets.isEmpty() && !dependencyNode2.mTargets.isEmpty()) {
                    sb.append("\n");
                    sb.append(dependencyNode.name());
                    sb.append(" -> ");
                    sb.append(dependencyNode2.name());
                    sb.append("\n");
                }
            } else if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.mWidget.getDimensionRatio() > 0.0f) {
                sb.append("\n");
                sb.append(widgetRun.mWidget.getDebugName());
                sb.append("_VERTICAL -> ");
                sb.append(widgetRun.mWidget.getDebugName());
                sb.append("_HORIZONTAL;\n");
            }
        }
        if (widgetRun instanceof ChainRun) {
            return generateChainDisplayGraph((ChainRun) widgetRun, generateDisplayNode);
        }
        return sb.toString();
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean z4, String str) {
        StringBuilder sb = new StringBuilder(str);
        for (DependencyNode name : dependencyNode.mTargets) {
            String str2 = ("\n" + dependencyNode.name()) + " -> " + name.name();
            if (dependencyNode.mMargin > 0 || z4 || (dependencyNode.mRun instanceof HelperReferences)) {
                String str3 = str2 + "[";
                if (dependencyNode.mMargin > 0) {
                    str3 = str3 + "label=\"" + dependencyNode.mMargin + "\"";
                    if (z4) {
                        str3 = str3 + ",";
                    }
                }
                if (z4) {
                    str3 = str3 + " style=dashed ";
                }
                if (dependencyNode.mRun instanceof HelperReferences) {
                    str3 = str3 + " style=bold,color=gray ";
                }
                str2 = str3 + "]";
            }
            sb.append(str2 + "\n");
        }
        return sb.toString();
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode dependencyNode2) {
        int i5 = 0;
        for (DependencyNode dependencyNode3 : dependencyNode.mTargets) {
            if (dependencyNode3 != dependencyNode2) {
                i5++;
            }
        }
        int i6 = 0;
        for (DependencyNode dependencyNode4 : dependencyNode2.mTargets) {
            if (dependencyNode4 != dependencyNode) {
                i6++;
            }
        }
        if (i5 <= 0 || i6 <= 0) {
            return false;
        }
        return true;
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i5, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i6) {
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i5;
        measure.verticalDimension = i6;
        this.mMeasurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun widgetRun) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z4 = widgetRun instanceof VerticalWidgetRun;
        String debugName = widgetRun.mWidget.getDebugName();
        StringBuilder sb = new StringBuilder(debugName);
        if (!z4) {
            dimensionBehaviour = widgetRun.mWidget.getHorizontalDimensionBehaviour();
        } else {
            dimensionBehaviour = widgetRun.mWidget.getVerticalDimensionBehaviour();
        }
        RunGroup runGroup = widgetRun.mRunGroup;
        if (!z4) {
            sb.append("_HORIZONTAL");
        } else {
            sb.append("_VERTICAL");
        }
        sb.append(" [shape=none, label=<");
        sb.append("<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">");
        sb.append("  <TR>");
        if (!z4) {
            sb.append("    <TD ");
            if (widgetRun.start.resolved) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"LEFT\" BORDER=\"1\">L</TD>");
        } else {
            sb.append("    <TD ");
            if (widgetRun.start.resolved) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"TOP\" BORDER=\"1\">T</TD>");
        }
        sb.append("    <TD BORDER=\"1\" ");
        boolean z5 = widgetRun.mDimension.resolved;
        if (z5 && !widgetRun.mWidget.measured) {
            sb.append(" BGCOLOR=\"green\" ");
        } else if (z5) {
            sb.append(" BGCOLOR=\"lightgray\" ");
        } else if (widgetRun.mWidget.measured) {
            sb.append(" BGCOLOR=\"yellow\" ");
        }
        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            sb.append("style=\"dashed\"");
        }
        sb.append(">");
        sb.append(debugName);
        if (runGroup != null) {
            sb.append(" [");
            sb.append(runGroup.mGroupIndex + 1);
            sb.append("/");
            sb.append(RunGroup.index);
            sb.append("]");
        }
        sb.append(" </TD>");
        if (!z4) {
            sb.append("    <TD ");
            if (widgetRun.end.resolved) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"RIGHT\" BORDER=\"1\">R</TD>");
        } else {
            sb.append("    <TD ");
            if (((VerticalWidgetRun) widgetRun).baseline.resolved) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>");
            sb.append("    <TD ");
            if (widgetRun.end.resolved) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"BOTTOM\" BORDER=\"1\">B</TD>");
        }
        sb.append("  </TR></TABLE>");
        sb.append(">];\n");
        return sb.toString();
    }

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.mWidgetcontainer.mHorizontalRun, 0, this.mGroups);
        findGroup(this.mWidgetcontainer.mVerticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        boolean z4;
        boolean z5;
        if (this.mNeedBuildGraph) {
            buildGraph();
            ArrayList<ConstraintWidget> arrayList = this.mWidgetcontainer.mChildren;
            int size = arrayList.size();
            boolean z6 = false;
            int i5 = 0;
            while (i5 < size) {
                ConstraintWidget constraintWidget = arrayList.get(i5);
                i5++;
                ConstraintWidget constraintWidget2 = constraintWidget;
                boolean[] zArr = constraintWidget2.isTerminalWidget;
                zArr[0] = true;
                zArr[1] = true;
                if (constraintWidget2 instanceof Barrier) {
                    z6 = true;
                }
            }
            if (!z6) {
                ArrayList<RunGroup> arrayList2 = this.mGroups;
                int size2 = arrayList2.size();
                int i6 = 0;
                while (i6 < size2) {
                    RunGroup runGroup = arrayList2.get(i6);
                    i6++;
                    RunGroup runGroup2 = runGroup;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    runGroup2.defineTerminalWidgets(z4, z5);
                }
            }
        }
    }

    public boolean directMeasure(boolean z4) {
        boolean z5;
        boolean z6 = false;
        if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
            ArrayList<ConstraintWidget> arrayList = this.mWidgetcontainer.mChildren;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                ConstraintWidget constraintWidget = arrayList.get(i5);
                i5++;
                ConstraintWidget constraintWidget2 = constraintWidget;
                constraintWidget2.ensureWidgetRuns();
                constraintWidget2.measured = false;
                constraintWidget2.mHorizontalRun.reset();
                constraintWidget2.mVerticalRun.reset();
            }
            this.mWidgetcontainer.ensureWidgetRuns();
            ConstraintWidgetContainer constraintWidgetContainer = this.mWidgetcontainer;
            constraintWidgetContainer.measured = false;
            constraintWidgetContainer.mHorizontalRun.reset();
            this.mWidgetcontainer.mVerticalRun.reset();
            this.mNeedRedoMeasures = false;
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.mWidgetcontainer.setX(0);
        this.mWidgetcontainer.setY(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mWidgetcontainer.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mWidgetcontainer.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph) {
            buildGraph();
        }
        int x4 = this.mWidgetcontainer.getX();
        int y4 = this.mWidgetcontainer.getY();
        this.mWidgetcontainer.mHorizontalRun.start.resolve(x4);
        this.mWidgetcontainer.mVerticalRun.start.resolve(y4);
        measureWidgets();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == dimensionBehaviour3 || dimensionBehaviour2 == dimensionBehaviour3) {
            if (z4) {
                ArrayList<WidgetRun> arrayList2 = this.mRuns;
                int size2 = arrayList2.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        break;
                    }
                    WidgetRun widgetRun = arrayList2.get(i6);
                    i6++;
                    if (!widgetRun.supportsWrapComputation()) {
                        z4 = false;
                        break;
                    }
                }
            }
            if (z4 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.mWidgetcontainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.mWidgetcontainer;
                constraintWidgetContainer2.setWidth(computeWrap(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.mWidgetcontainer;
                constraintWidgetContainer3.mHorizontalRun.mDimension.resolve(constraintWidgetContainer3.getWidth());
            }
            if (z4 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.mWidgetcontainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.mWidgetcontainer;
                constraintWidgetContainer4.setHeight(computeWrap(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.mWidgetcontainer;
                constraintWidgetContainer5.mVerticalRun.mDimension.resolve(constraintWidgetContainer5.getHeight());
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer6 = this.mWidgetcontainer;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer6.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour4 == dimensionBehaviour5 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int width = constraintWidgetContainer6.getWidth() + x4;
            this.mWidgetcontainer.mHorizontalRun.end.resolve(width);
            this.mWidgetcontainer.mHorizontalRun.mDimension.resolve(width - x4);
            measureWidgets();
            ConstraintWidgetContainer constraintWidgetContainer7 = this.mWidgetcontainer;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = constraintWidgetContainer7.mListDimensionBehaviors[1];
            if (dimensionBehaviour6 == dimensionBehaviour5 || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer7.getHeight() + y4;
                this.mWidgetcontainer.mVerticalRun.end.resolve(height);
                this.mWidgetcontainer.mVerticalRun.mDimension.resolve(height - y4);
            }
            measureWidgets();
            z5 = true;
        } else {
            z5 = false;
        }
        ArrayList<WidgetRun> arrayList3 = this.mRuns;
        int size3 = arrayList3.size();
        int i7 = 0;
        while (i7 < size3) {
            WidgetRun widgetRun2 = arrayList3.get(i7);
            i7++;
            WidgetRun widgetRun3 = widgetRun2;
            if (widgetRun3.mWidget != this.mWidgetcontainer || widgetRun3.mResolved) {
                widgetRun3.applyToWidget();
            }
        }
        ArrayList<WidgetRun> arrayList4 = this.mRuns;
        int size4 = arrayList4.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size4) {
                z6 = true;
                break;
            }
            WidgetRun widgetRun4 = arrayList4.get(i8);
            i8++;
            WidgetRun widgetRun5 = widgetRun4;
            if ((z5 || widgetRun5.mWidget != this.mWidgetcontainer) && (!widgetRun5.start.resolved || ((!widgetRun5.end.resolved && !(widgetRun5 instanceof GuidelineReference)) || (!widgetRun5.mDimension.resolved && !(widgetRun5 instanceof ChainRun) && !(widgetRun5 instanceof GuidelineReference))))) {
                break;
            }
        }
        this.mWidgetcontainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.mWidgetcontainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z6;
    }

    public boolean directMeasureSetup(boolean z4) {
        if (this.mNeedBuildGraph) {
            ArrayList<ConstraintWidget> arrayList = this.mWidgetcontainer.mChildren;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                ConstraintWidget constraintWidget = arrayList.get(i5);
                i5++;
                ConstraintWidget constraintWidget2 = constraintWidget;
                constraintWidget2.ensureWidgetRuns();
                constraintWidget2.measured = false;
                HorizontalWidgetRun horizontalWidgetRun = constraintWidget2.mHorizontalRun;
                horizontalWidgetRun.mDimension.resolved = false;
                horizontalWidgetRun.mResolved = false;
                horizontalWidgetRun.reset();
                VerticalWidgetRun verticalWidgetRun = constraintWidget2.mVerticalRun;
                verticalWidgetRun.mDimension.resolved = false;
                verticalWidgetRun.mResolved = false;
                verticalWidgetRun.reset();
            }
            this.mWidgetcontainer.ensureWidgetRuns();
            ConstraintWidgetContainer constraintWidgetContainer = this.mWidgetcontainer;
            constraintWidgetContainer.measured = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.mHorizontalRun;
            horizontalWidgetRun2.mDimension.resolved = false;
            horizontalWidgetRun2.mResolved = false;
            horizontalWidgetRun2.reset();
            VerticalWidgetRun verticalWidgetRun2 = this.mWidgetcontainer.mVerticalRun;
            verticalWidgetRun2.mDimension.resolved = false;
            verticalWidgetRun2.mResolved = false;
            verticalWidgetRun2.reset();
            buildGraph();
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.mWidgetcontainer.setX(0);
        this.mWidgetcontainer.setY(0);
        this.mWidgetcontainer.mHorizontalRun.start.resolve(0);
        this.mWidgetcontainer.mVerticalRun.start.resolve(0);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x013b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean directMeasureWithOrientation(boolean r12, int r13) {
        /*
            r11 = this;
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = r11.mWidgetcontainer
            r1 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r0.getDimensionBehaviour(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = r11.mWidgetcontainer
            r3 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r2.getDimensionBehaviour(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r11.mWidgetcontainer
            int r4 = r4.getX()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r11.mWidgetcontainer
            int r5 = r5.getY()
            if (r12 == 0) goto L_0x0087
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 == r6) goto L_0x0022
            if (r2 != r6) goto L_0x0087
        L_0x0022:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r6 = r11.mRuns
            int r7 = r6.size()
            r8 = r1
        L_0x0029:
            if (r8 >= r7) goto L_0x003e
            java.lang.Object r9 = r6.get(r8)
            int r8 = r8 + 1
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r9 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r9
            int r10 = r9.orientation
            if (r10 != r13) goto L_0x0029
            boolean r9 = r9.supportsWrapComputation()
            if (r9 != 0) goto L_0x0029
            r12 = r1
        L_0x003e:
            if (r13 != 0) goto L_0x0064
            if (r12 == 0) goto L_0x0087
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r12) goto L_0x0087
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r12 = r11.mWidgetcontainer
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r12.setHorizontalDimensionBehaviour(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r12 = r11.mWidgetcontainer
            int r6 = r11.computeWrap(r12, r1)
            r12.setWidth(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r12 = r11.mWidgetcontainer
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r12.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.mDimension
            int r12 = r12.getWidth()
            r6.resolve(r12)
            goto L_0x0087
        L_0x0064:
            if (r12 == 0) goto L_0x0087
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r12) goto L_0x0087
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r12 = r11.mWidgetcontainer
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r12.setVerticalDimensionBehaviour(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r12 = r11.mWidgetcontainer
            int r6 = r11.computeWrap(r12, r3)
            r12.setHeight(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r12 = r11.mWidgetcontainer
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r6 = r12.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.mDimension
            int r12 = r12.getHeight()
            r6.resolve(r12)
        L_0x0087:
            if (r13 != 0) goto L_0x00b1
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r12 = r11.mWidgetcontainer
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r12.mListDimensionBehaviors
            r5 = r5[r1]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 == r6) goto L_0x0097
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r5 != r6) goto L_0x00c0
        L_0x0097:
            int r12 = r12.getWidth()
            int r12 = r12 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r11.mWidgetcontainer
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r5 = r5.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r5.end
            r5.resolve(r12)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r11.mWidgetcontainer
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r5 = r5.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r5 = r5.mDimension
            int r12 = r12 - r4
            r5.resolve(r12)
        L_0x00af:
            r12 = r3
            goto L_0x00db
        L_0x00b1:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r12 = r11.mWidgetcontainer
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r12.mListDimensionBehaviors
            r4 = r4[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r4 == r6) goto L_0x00c2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r4 != r6) goto L_0x00c0
            goto L_0x00c2
        L_0x00c0:
            r12 = r1
            goto L_0x00db
        L_0x00c2:
            int r12 = r12.getHeight()
            int r12 = r12 + r5
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r11.mWidgetcontainer
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r4 = r4.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r4.end
            r4.resolve(r12)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r11.mWidgetcontainer
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r4 = r4.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r4 = r4.mDimension
            int r12 = r12 - r5
            r4.resolve(r12)
            goto L_0x00af
        L_0x00db:
            r11.measureWidgets()
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r11.mRuns
            int r5 = r4.size()
            r6 = r1
        L_0x00e5:
            if (r6 >= r5) goto L_0x0103
            java.lang.Object r7 = r4.get(r6)
            int r6 = r6 + 1
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            int r8 = r7.orientation
            if (r8 == r13) goto L_0x00f4
            goto L_0x00e5
        L_0x00f4:
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r7.mWidget
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r9 = r11.mWidgetcontainer
            if (r8 != r9) goto L_0x00ff
            boolean r8 = r7.mResolved
            if (r8 != 0) goto L_0x00ff
            goto L_0x00e5
        L_0x00ff:
            r7.applyToWidget()
            goto L_0x00e5
        L_0x0103:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r11.mRuns
            int r5 = r4.size()
            r6 = r1
        L_0x010a:
            if (r6 >= r5) goto L_0x013b
            java.lang.Object r7 = r4.get(r6)
            int r6 = r6 + 1
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            int r8 = r7.orientation
            if (r8 == r13) goto L_0x0119
            goto L_0x010a
        L_0x0119:
            if (r12 != 0) goto L_0x0122
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r7.mWidget
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r9 = r11.mWidgetcontainer
            if (r8 != r9) goto L_0x0122
            goto L_0x010a
        L_0x0122:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r8 = r7.start
            boolean r8 = r8.resolved
            if (r8 != 0) goto L_0x0129
            goto L_0x013c
        L_0x0129:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r8 = r7.end
            boolean r8 = r8.resolved
            if (r8 != 0) goto L_0x0130
            goto L_0x013c
        L_0x0130:
            boolean r8 = r7 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r8 != 0) goto L_0x010a
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r7 = r7.mDimension
            boolean r7 = r7.resolved
            if (r7 != 0) goto L_0x010a
            goto L_0x013c
        L_0x013b:
            r1 = r3
        L_0x013c:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r12 = r11.mWidgetcontainer
            r12.setHorizontalDimensionBehaviour(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r12 = r11.mWidgetcontainer
            r12.setVerticalDimensionBehaviour(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.directMeasureWithOrientation(boolean, int):boolean");
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        boolean z4;
        boolean z5;
        DimensionDependency dimensionDependency;
        ArrayList<ConstraintWidget> arrayList = this.mWidgetcontainer.mChildren;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i5);
            i5++;
            ConstraintWidget constraintWidget2 = constraintWidget;
            if (!constraintWidget2.measured) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget2.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i6 = constraintWidget2.mMatchConstraintDefaultWidth;
                int i7 = constraintWidget2.mMatchConstraintDefaultHeight;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i6 == 1)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i7 == 1)) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                DimensionDependency dimensionDependency2 = constraintWidget2.mHorizontalRun.mDimension;
                boolean z6 = dimensionDependency2.resolved;
                DimensionDependency dimensionDependency3 = constraintWidget2.mVerticalRun.mDimension;
                boolean z7 = dimensionDependency3.resolved;
                if (z6 && z7) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    measure(constraintWidget2, dimensionBehaviour4, dimensionDependency2.value, dimensionBehaviour4, dimensionDependency3.value);
                    constraintWidget2.measured = true;
                } else if (!z6 || !z5) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviour3;
                    if (z7 && z4) {
                        measure(constraintWidget2, dimensionBehaviour5, dimensionDependency2.value, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency3.value);
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            constraintWidget2.mHorizontalRun.mDimension.wrapValue = constraintWidget2.getWidth();
                        } else {
                            constraintWidget2.mHorizontalRun.mDimension.resolve(constraintWidget2.getWidth());
                            constraintWidget2.measured = true;
                        }
                    }
                } else {
                    measure(constraintWidget2, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency2.value, dimensionBehaviour3, dimensionDependency3.value);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget2.mVerticalRun.mDimension.wrapValue = constraintWidget2.getHeight();
                    } else {
                        constraintWidget2.mVerticalRun.mDimension.resolve(constraintWidget2.getHeight());
                        constraintWidget2.measured = true;
                    }
                }
                if (constraintWidget2.measured && (dimensionDependency = constraintWidget2.mVerticalRun.mBaselineDimension) != null) {
                    dimensionDependency.resolve(constraintWidget2.getBaselineDistance());
                }
            }
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.mContainer.mHorizontalRun.clear();
        this.mContainer.mVerticalRun.clear();
        arrayList.add(this.mContainer.mHorizontalRun);
        arrayList.add(this.mContainer.mVerticalRun);
        ArrayList<ConstraintWidget> arrayList2 = this.mContainer.mChildren;
        int size = arrayList2.size();
        HashSet hashSet = null;
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            ConstraintWidget constraintWidget = arrayList2.get(i6);
            i6++;
            ConstraintWidget constraintWidget2 = constraintWidget;
            if (constraintWidget2 instanceof Guideline) {
                arrayList.add(new GuidelineReference(constraintWidget2));
            } else {
                if (constraintWidget2.isInHorizontalChain()) {
                    if (constraintWidget2.horizontalChainRun == null) {
                        constraintWidget2.horizontalChainRun = new ChainRun(constraintWidget2, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget2.horizontalChainRun);
                } else {
                    arrayList.add(constraintWidget2.mHorizontalRun);
                }
                if (constraintWidget2.isInVerticalChain()) {
                    if (constraintWidget2.verticalChainRun == null) {
                        constraintWidget2.verticalChainRun = new ChainRun(constraintWidget2, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget2.verticalChainRun);
                } else {
                    arrayList.add(constraintWidget2.mVerticalRun);
                }
                if (constraintWidget2 instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(constraintWidget2));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        int size2 = arrayList.size();
        int i7 = 0;
        while (i7 < size2) {
            WidgetRun widgetRun = arrayList.get(i7);
            i7++;
            widgetRun.clear();
        }
        int size3 = arrayList.size();
        while (i5 < size3) {
            WidgetRun widgetRun2 = arrayList.get(i5);
            i5++;
            WidgetRun widgetRun3 = widgetRun2;
            if (widgetRun3.mWidget != this.mContainer) {
                widgetRun3.apply();
            }
        }
    }
}
