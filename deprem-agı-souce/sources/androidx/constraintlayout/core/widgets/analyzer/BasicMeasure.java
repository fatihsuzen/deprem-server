package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    private static final boolean DO_NOT_USE = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer mConstraintWidgetContainer;
    private Measure mMeasure = new Measure();
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();

    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mConstraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, int i5) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (measure.verticalBehavior == dimensionBehaviour2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z4 || constraintWidget.mDimensionRatio <= 0.0f) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (!z5 || constraintWidget.mDimensionRatio <= 0.0f) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z6 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z7 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.measureStrategy = Measure.SELF_DIMENSIONS;
        return measure2.measuredNeedsSolverPass;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008e, code lost:
        if (r8 != r9) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
        if (r5.mDimensionRatio <= 0.0f) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void measureChildren(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r13) {
        /*
            r12 = this;
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r13.mChildren
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.optimizeFor(r1)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r2 = r13.getMeasurer()
            r3 = 0
            r4 = r3
        L_0x0012:
            if (r4 >= r0) goto L_0x00b0
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r13.mChildren
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r6 == 0) goto L_0x0022
            goto L_0x00ac
        L_0x0022:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r6 == 0) goto L_0x0028
            goto L_0x00ac
        L_0x0028:
            boolean r6 = r5.isInVirtualLayout()
            if (r6 == 0) goto L_0x0030
            goto L_0x00ac
        L_0x0030:
            if (r1 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r5.mHorizontalRun
            if (r6 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r7 = r5.mVerticalRun
            if (r7 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.mDimension
            boolean r6 = r6.resolved
            if (r6 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r7.mDimension
            boolean r6 = r6.resolved
            if (r6 == 0) goto L_0x0048
            goto L_0x00ac
        L_0x0048:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.getDimensionBehaviour(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.getDimensionBehaviour(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L_0x0061
            int r10 = r5.mMatchConstraintDefaultWidth
            if (r10 == r7) goto L_0x0061
            if (r8 != r9) goto L_0x0061
            int r10 = r5.mMatchConstraintDefaultHeight
            if (r10 == r7) goto L_0x0061
            r10 = r7
            goto L_0x0062
        L_0x0061:
            r10 = r3
        L_0x0062:
            if (r10 != 0) goto L_0x0098
            boolean r11 = r13.optimizeFor(r7)
            if (r11 == 0) goto L_0x0098
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r11 != 0) goto L_0x0098
            if (r6 != r9) goto L_0x007d
            int r11 = r5.mMatchConstraintDefaultWidth
            if (r11 != 0) goto L_0x007d
            if (r8 == r9) goto L_0x007d
            boolean r11 = r5.isInHorizontalChain()
            if (r11 != 0) goto L_0x007d
            r10 = r7
        L_0x007d:
            if (r8 != r9) goto L_0x008c
            int r11 = r5.mMatchConstraintDefaultHeight
            if (r11 != 0) goto L_0x008c
            if (r6 == r9) goto L_0x008c
            boolean r11 = r5.isInHorizontalChain()
            if (r11 != 0) goto L_0x008c
            r10 = r7
        L_0x008c:
            if (r6 == r9) goto L_0x0090
            if (r8 != r9) goto L_0x0098
        L_0x0090:
            float r6 = r5.mDimensionRatio
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r7 = r10
        L_0x0099:
            if (r7 == 0) goto L_0x009c
            goto L_0x00ac
        L_0x009c:
            int r6 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS
            r12.measure(r2, r5, r6)
            androidx.constraintlayout.core.Metrics r5 = r13.mMetrics
            if (r5 == 0) goto L_0x00ac
            long r6 = r5.measuredWidgets
            r8 = 1
            long r6 = r6 + r8
            r5.measuredWidgets = r6
        L_0x00ac:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x00b0:
            r2.didMeasures()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.measureChildren(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String str, int i5, int i6, int i7) {
        long j5;
        if (constraintWidgetContainer.mMetrics != null) {
            j5 = System.nanoTime();
        } else {
            j5 = 0;
        }
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i6);
        constraintWidgetContainer.setHeight(i7);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        this.mConstraintWidgetContainer.setPass(i5);
        this.mConstraintWidgetContainer.layout();
        if (constraintWidgetContainer.mMetrics != null) {
            long nanoTime = System.nanoTime();
            Metrics metrics = constraintWidgetContainer.mMetrics;
            metrics.mSolverPasses++;
            metrics.measuresLayoutDuration += nanoTime - j5;
        }
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        long j5;
        int i14;
        boolean z4;
        int i15;
        int i16;
        long j6;
        int i17;
        int i18;
        int i19;
        long j7;
        boolean z5;
        Metrics metrics;
        BasicMeasure basicMeasure = this;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        int i20 = i5;
        int i21 = i8;
        int i22 = i10;
        Measurer measurer = constraintWidgetContainer2.getMeasurer();
        int size = constraintWidgetContainer2.mChildren.size();
        int width = constraintWidgetContainer2.getWidth();
        int height = constraintWidgetContainer2.getHeight();
        boolean enabled = Optimizer.enabled(i20, 128);
        boolean z6 = enabled || Optimizer.enabled(i20, 64);
        if (z6) {
            int i23 = 0;
            while (true) {
                if (i23 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = constraintWidgetContainer2.mChildren.get(i23);
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z7 = (horizontalDimensionBehaviour == dimensionBehaviour) && (constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((!constraintWidget.isInHorizontalChain() || !z7) && ((!constraintWidget.isInVerticalChain() || !z7) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.isInHorizontalChain() && !constraintWidget.isInVerticalChain())) {
                    i23++;
                }
            }
            z6 = false;
        }
        if (z6 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        boolean z8 = z6 & ((i21 == 1073741824 && i22 == 1073741824) || enabled);
        int i24 = 2;
        if (z8) {
            j5 = 1;
            int min = Math.min(constraintWidgetContainer2.getMaxWidth(), i9);
            int min2 = Math.min(constraintWidgetContainer2.getMaxHeight(), i11);
            if (i21 == 1073741824 && constraintWidgetContainer2.getWidth() != min) {
                constraintWidgetContainer2.setWidth(min);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i22 == 1073741824 && constraintWidgetContainer2.getHeight() != min2) {
                constraintWidgetContainer2.setHeight(min2);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i21 == 1073741824 && i22 == 1073741824) {
                z4 = constraintWidgetContainer2.directMeasure(enabled);
                i14 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer2.directMeasureSetup(enabled);
                if (i21 == 1073741824) {
                    directMeasureSetup &= constraintWidgetContainer2.directMeasureWithOrientation(enabled, 0);
                    i14 = 1;
                } else {
                    i14 = 0;
                }
                if (i22 == 1073741824) {
                    z4 = constraintWidgetContainer2.directMeasureWithOrientation(enabled, 1) & directMeasureSetup;
                    i14++;
                } else {
                    z4 = directMeasureSetup;
                }
            }
            if (z4) {
                constraintWidgetContainer2.updateFromRuns(i21 == 1073741824, i22 == 1073741824);
            }
        } else {
            j5 = 1;
            z4 = false;
            i14 = 0;
        }
        long j8 = 0;
        if (!z4 || i14 != 2) {
            int optimizationLevel = constraintWidgetContainer2.getOptimizationLevel();
            if (size > 0) {
                measureChildren(constraintWidgetContainer);
            }
            if (constraintWidgetContainer2.mMetrics != null) {
                j8 = System.nanoTime();
            }
            updateHierarchy(constraintWidgetContainer);
            int size2 = basicMeasure.mVariableDimensionsWidgets.size();
            if (size > 0) {
                int i25 = width;
                int i26 = height;
                basicMeasure.solveLinearSystem(constraintWidgetContainer2, "First pass", 0, i25, i26);
                i16 = i25;
                i15 = i26;
            } else {
                i16 = width;
                i15 = height;
            }
            if (size2 > 0) {
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer2.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z9 = horizontalDimensionBehaviour2 == dimensionBehaviour2;
                boolean z10 = constraintWidgetContainer2.getVerticalDimensionBehaviour() == dimensionBehaviour2;
                int max = Math.max(constraintWidgetContainer2.getWidth(), basicMeasure.mConstraintWidgetContainer.getMinWidth());
                int max2 = Math.max(constraintWidgetContainer2.getHeight(), basicMeasure.mConstraintWidgetContainer.getMinHeight());
                int i27 = 0;
                boolean z11 = false;
                while (i27 < size2) {
                    ConstraintWidget constraintWidget2 = basicMeasure.mVariableDimensionsWidgets.get(i27);
                    boolean z12 = z8;
                    if (!(constraintWidget2 instanceof VirtualLayout)) {
                        j7 = j8;
                        i19 = i16;
                        i18 = i15;
                    } else {
                        int width2 = constraintWidget2.getWidth();
                        j7 = j8;
                        int height2 = constraintWidget2.getHeight();
                        boolean measure = z11 | basicMeasure.measure(measurer, constraintWidget2, Measure.TRY_GIVEN_DIMENSIONS);
                        Metrics metrics2 = constraintWidgetContainer2.mMetrics;
                        i19 = i16;
                        i18 = i15;
                        if (metrics2 != null) {
                            metrics2.measuredMatchWidgets += j5;
                        }
                        int width3 = constraintWidget2.getWidth();
                        int height3 = constraintWidget2.getHeight();
                        if (width3 != width2) {
                            constraintWidget2.setWidth(width3);
                            if (z9 && constraintWidget2.getRight() > max) {
                                max = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            z5 = true;
                        } else {
                            z5 = measure;
                        }
                        if (height3 != height2) {
                            constraintWidget2.setHeight(height3);
                            if (z10 && constraintWidget2.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            z5 = true;
                        }
                        z11 = z5 | ((VirtualLayout) constraintWidget2).needSolverPass();
                    }
                    i27++;
                    i16 = i19;
                    i15 = i18;
                    z8 = z12;
                    j8 = j7;
                    i24 = 2;
                }
                boolean z13 = z8;
                j6 = j8;
                int i28 = i16;
                int i29 = i15;
                int i30 = i24;
                int i31 = 0;
                while (true) {
                    if (i31 >= i30) {
                        break;
                    }
                    int i32 = 0;
                    while (i32 < size2) {
                        ConstraintWidget constraintWidget3 = basicMeasure.mVariableDimensionsWidgets.get(i32);
                        if ((!(constraintWidget3 instanceof Helper) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.getVisibility() != 8 && ((!z13 || !constraintWidget3.mHorizontalRun.mDimension.resolved || !constraintWidget3.mVerticalRun.mDimension.resolved) && !(constraintWidget3 instanceof VirtualLayout))) {
                            int width4 = constraintWidget3.getWidth();
                            int height4 = constraintWidget3.getHeight();
                            int baselineDistance = constraintWidget3.getBaselineDistance();
                            int i33 = Measure.TRY_GIVEN_DIMENSIONS;
                            if (i31 == 1) {
                                i33 = Measure.USE_GIVEN_DIMENSIONS;
                            }
                            boolean measure2 = z11 | basicMeasure.measure(measurer, constraintWidget3, i33);
                            Metrics metrics3 = constraintWidgetContainer2.mMetrics;
                            i17 = i31;
                            if (metrics3 != null) {
                                metrics3.measuredMatchWidgets += j5;
                            }
                            int width5 = constraintWidget3.getWidth();
                            int height5 = constraintWidget3.getHeight();
                            if (width5 != width4) {
                                constraintWidget3.setWidth(width5);
                                if (z9 && constraintWidget3.getRight() > max) {
                                    max = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                                }
                                measure2 = true;
                            }
                            if (height5 != height4) {
                                constraintWidget3.setHeight(height5);
                                if (z10 && constraintWidget3.getBottom() > max2) {
                                    max2 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                                }
                                measure2 = true;
                            }
                            z11 = (!constraintWidget3.hasBaseline() || baselineDistance == constraintWidget3.getBaselineDistance()) ? measure2 : true;
                        } else {
                            i17 = i31;
                        }
                        i32++;
                        basicMeasure = this;
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        i31 = i17;
                    }
                    int i34 = i31;
                    if (!z11) {
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        break;
                    }
                    i31 = i34 + 1;
                    ConstraintWidgetContainer constraintWidgetContainer3 = constraintWidgetContainer;
                    solveLinearSystem(constraintWidgetContainer3, "intermediate pass", i31, i28, i29);
                    basicMeasure = this;
                    constraintWidgetContainer2 = constraintWidgetContainer3;
                    i30 = 2;
                    z11 = false;
                }
            } else {
                j6 = j8;
            }
            constraintWidgetContainer2.setOptimizationLevel(optimizationLevel);
            j8 = j6;
        }
        return constraintWidgetContainer2.mMetrics != null ? System.nanoTime() - j8 : j8;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer.mChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i5);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer.invalidateGraph();
    }
}
