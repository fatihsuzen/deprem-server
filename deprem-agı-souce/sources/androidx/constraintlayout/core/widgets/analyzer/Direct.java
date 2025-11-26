package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Iterator;

public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static final boolean EARLY_TERMINATION = true;
    private static int sHcount = 0;
    private static BasicMeasure.Measure sMeasure = new BasicMeasure.Measure();
    private static int sVcount = 0;

    private static boolean canMeasure(int i5, ConstraintWidget constraintWidget) {
        ConstraintWidgetContainer constraintWidgetContainer;
        boolean z4;
        boolean z5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        if (constraintWidget.getParent() != null) {
            constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
        } else {
            constraintWidgetContainer = null;
        }
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour2 = constraintWidgetContainer.getVerticalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (horizontalDimensionBehaviour == dimensionBehaviour5 || constraintWidget.isResolvedHorizontally() || horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || ((horizontalDimensionBehaviour == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(0)) || (horizontalDimensionBehaviour == dimensionBehaviour2 && constraintWidget.mMatchConstraintDefaultWidth == 1 && constraintWidget.hasResolvedTargets(0, constraintWidget.getWidth())))) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (verticalDimensionBehaviour == dimensionBehaviour5 || constraintWidget.isResolvedVertically() || verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || ((verticalDimensionBehaviour == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.mMatchConstraintDefaultHeight == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(1)) || (verticalDimensionBehaviour == dimensionBehaviour && constraintWidget.mMatchConstraintDefaultHeight == 1 && constraintWidget.hasResolvedTargets(1, constraintWidget.getHeight())))) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (constraintWidget.mDimensionRatio > 0.0f && (z4 || z5)) {
            return true;
        }
        if (!z4 || !z5) {
            return false;
        }
        return true;
    }

    private static void horizontalSolvingPass(int i5, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z4) {
        boolean z5;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z6;
        boolean z7;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget2 = constraintWidget;
        BasicMeasure.Measurer measurer2 = measurer;
        boolean z8 = z4;
        if (!constraintWidget2.isHorizontalSolvingPassDone()) {
            boolean z9 = true;
            sHcount++;
            if (!(constraintWidget2 instanceof ConstraintWidgetContainer) && constraintWidget2.isMeasureRequested()) {
                int i6 = i5 + 1;
                if (canMeasure(i6, constraintWidget2)) {
                    ConstraintWidgetContainer.measure(i6, constraintWidget2, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
            }
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT);
            int finalValue = anchor.getFinalValue();
            int finalValue2 = anchor2.getFinalValue();
            if (anchor.getDependents() != null && anchor.hasFinalValue()) {
                Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget3 = next.mOwner;
                    int i7 = i5 + 1;
                    boolean canMeasure = canMeasure(i7, constraintWidget3);
                    if (!constraintWidget3.isMeasureRequested() || !canMeasure) {
                        z6 = z9;
                    } else {
                        z6 = z9;
                        ConstraintWidgetContainer.measure(i7, constraintWidget3, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                    if ((next != constraintWidget3.mLeft || (constraintAnchor4 = constraintWidget3.mRight.mTarget) == null || !constraintAnchor4.hasFinalValue()) && (next != constraintWidget3.mRight || (constraintAnchor3 = constraintWidget3.mLeft.mTarget) == null || !constraintAnchor3.hasFinalValue())) {
                        z7 = false;
                    } else {
                        z7 = z6;
                    }
                    ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget3.getHorizontalDimensionBehaviour();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (horizontalDimensionBehaviour != dimensionBehaviour || canMeasure) {
                        if (!constraintWidget3.isMeasureRequested()) {
                            ConstraintAnchor constraintAnchor5 = constraintWidget3.mLeft;
                            if (next == constraintAnchor5 && constraintWidget3.mRight.mTarget == null) {
                                int margin = constraintAnchor5.getMargin() + finalValue;
                                constraintWidget3.setFinalHorizontal(margin, constraintWidget3.getWidth() + margin);
                                horizontalSolvingPass(i7, constraintWidget3, measurer2, z8);
                            } else {
                                ConstraintAnchor constraintAnchor6 = constraintWidget3.mRight;
                                if (next == constraintAnchor6 && constraintAnchor5.mTarget == null) {
                                    int margin2 = finalValue - constraintAnchor6.getMargin();
                                    constraintWidget3.setFinalHorizontal(margin2 - constraintWidget3.getWidth(), margin2);
                                    horizontalSolvingPass(i7, constraintWidget3, measurer2, z8);
                                } else if (z7 && !constraintWidget3.isInHorizontalChain()) {
                                    solveHorizontalCenterConstraints(i7, measurer2, constraintWidget3, z8);
                                }
                            }
                        }
                    } else if (constraintWidget3.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget3.mMatchConstraintMaxWidth >= 0 && constraintWidget3.mMatchConstraintMinWidth >= 0 && ((constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultWidth == 0 && constraintWidget3.getDimensionRatio() == 0.0f)) && !constraintWidget3.isInHorizontalChain() && !constraintWidget3.isInVirtualLayout() && z7 && !constraintWidget3.isInHorizontalChain())) {
                        solveHorizontalMatchConstraint(i7, constraintWidget2, measurer2, constraintWidget3, z8);
                    }
                    z9 = z6;
                }
            }
            boolean z10 = z9;
            if (!(constraintWidget2 instanceof Guideline)) {
                if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
                    Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
                    while (it2.hasNext()) {
                        ConstraintAnchor next2 = it2.next();
                        ConstraintWidget constraintWidget4 = next2.mOwner;
                        int i8 = i5 + 1;
                        boolean canMeasure2 = canMeasure(i8, constraintWidget4);
                        if (constraintWidget4.isMeasureRequested() && canMeasure2) {
                            ConstraintWidgetContainer.measure(i8, constraintWidget4, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                        }
                        if ((next2 != constraintWidget4.mLeft || (constraintAnchor2 = constraintWidget4.mRight.mTarget) == null || !constraintAnchor2.hasFinalValue()) && (next2 != constraintWidget4.mRight || (constraintAnchor = constraintWidget4.mLeft.mTarget) == null || !constraintAnchor.hasFinalValue())) {
                            z5 = false;
                        } else {
                            z5 = z10;
                        }
                        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidget4.getHorizontalDimensionBehaviour();
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (horizontalDimensionBehaviour2 != dimensionBehaviour2 || canMeasure2) {
                            if (!constraintWidget4.isMeasureRequested()) {
                                ConstraintAnchor constraintAnchor7 = constraintWidget4.mLeft;
                                if (next2 == constraintAnchor7 && constraintWidget4.mRight.mTarget == null) {
                                    int margin3 = constraintAnchor7.getMargin() + finalValue2;
                                    constraintWidget4.setFinalHorizontal(margin3, constraintWidget4.getWidth() + margin3);
                                    horizontalSolvingPass(i8, constraintWidget4, measurer2, z8);
                                } else {
                                    ConstraintAnchor constraintAnchor8 = constraintWidget4.mRight;
                                    if (next2 == constraintAnchor8 && constraintAnchor7.mTarget == null) {
                                        int margin4 = finalValue2 - constraintAnchor8.getMargin();
                                        constraintWidget4.setFinalHorizontal(margin4 - constraintWidget4.getWidth(), margin4);
                                        horizontalSolvingPass(i8, constraintWidget4, measurer2, z8);
                                    } else if (z5 && !constraintWidget4.isInHorizontalChain()) {
                                        solveHorizontalCenterConstraints(i8, measurer2, constraintWidget4, z8);
                                    }
                                }
                            }
                        } else if (constraintWidget4.getHorizontalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget4.mMatchConstraintMaxWidth >= 0 && constraintWidget4.mMatchConstraintMinWidth >= 0) {
                            if ((constraintWidget4.getVisibility() == 8 || (constraintWidget4.mMatchConstraintDefaultWidth == 0 && constraintWidget4.getDimensionRatio() == 0.0f)) && !constraintWidget4.isInHorizontalChain() && !constraintWidget4.isInVirtualLayout() && z5 && !constraintWidget4.isInHorizontalChain()) {
                                solveHorizontalMatchConstraint(i8, constraintWidget2, measurer2, constraintWidget4, z8);
                            }
                        }
                    }
                }
                constraintWidget2.markHorizontalSolvingPassDone();
            }
        }
    }

    public static String ls(int i5) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < i5; i6++) {
            sb.append("  ");
        }
        sb.append("+-(" + i5 + ") ");
        return sb.toString();
    }

    private static void solveBarrier(int i5, Barrier barrier, BasicMeasure.Measurer measurer, int i6, boolean z4) {
        if (!barrier.allSolved()) {
            return;
        }
        if (i6 == 0) {
            horizontalSolvingPass(i5 + 1, barrier, measurer, z4);
        } else {
            verticalSolvingPass(i5 + 1, barrier, measurer);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d9, code lost:
        if (r6.mOwner == r2) goto L_0x01dd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean solveChain(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r20, androidx.constraintlayout.core.LinearSystem r21, int r22, int r23, androidx.constraintlayout.core.widgets.ChainHead r24, boolean r25, boolean r26, boolean r27) {
        /*
            r0 = 0
            if (r27 == 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r22 != 0) goto L_0x000d
            boolean r1 = r20.isResolvedHorizontally()
            if (r1 != 0) goto L_0x0014
            return r0
        L_0x000d:
            boolean r1 = r20.isResolvedVertically()
            if (r1 != 0) goto L_0x0014
            return r0
        L_0x0014:
            boolean r1 = r20.isRtl()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r24.getFirst()
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r24.getLast()
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r24.getFirstVisibleWidget()
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r24.getLastVisibleWidget()
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r24.getHead()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r2.mListAnchors
            r7 = r7[r23]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r3.mListAnchors
            int r8 = r23 + 1
            r3 = r3[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r7.mTarget
            if (r9 == 0) goto L_0x003e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mTarget
            if (r10 != 0) goto L_0x0042
        L_0x003e:
            r16 = r0
            goto L_0x0234
        L_0x0042:
            boolean r9 = r9.hasFinalValue()
            if (r9 == 0) goto L_0x0050
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r3.mTarget
            boolean r9 = r9.hasFinalValue()
            if (r9 != 0) goto L_0x0054
        L_0x0050:
            r16 = r0
            goto L_0x0234
        L_0x0054:
            if (r4 == 0) goto L_0x0058
            if (r5 != 0) goto L_0x005c
        L_0x0058:
            r16 = r0
            goto L_0x0234
        L_0x005c:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.mTarget
            int r7 = r7.getFinalValue()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r9 = r4.mListAnchors
            r9 = r9[r23]
            int r9 = r9.getMargin()
            int r7 = r7 + r9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            int r3 = r3.getFinalValue()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r9 = r5.mListAnchors
            r9 = r9[r8]
            int r9 = r9.getMargin()
            int r3 = r3 - r9
            int r9 = r3 - r7
            if (r9 > 0) goto L_0x007f
            return r0
        L_0x007f:
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r10 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r10.<init>()
            r11 = r0
            r12 = r11
            r14 = r12
            r15 = r14
            r16 = r15
            r13 = r2
        L_0x008b:
            r17 = 0
            r0 = 1
            if (r11 != 0) goto L_0x0106
            boolean r18 = canMeasure(r0, r13)
            if (r18 != 0) goto L_0x0097
            return r16
        L_0x0097:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r13.mListDimensionBehaviors
            r0 = r0[r22]
            r18 = r2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r2) goto L_0x00a2
            return r16
        L_0x00a2:
            boolean r0 = r13.isMeasureRequested()
            if (r0 == 0) goto L_0x00b5
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            int r2 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS
            r19 = r6
            r6 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.measure(r6, r13, r0, r10, r2)
            goto L_0x00b7
        L_0x00b5:
            r19 = r6
        L_0x00b7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r23]
            int r0 = r0.getMargin()
            int r15 = r15 + r0
            if (r22 != 0) goto L_0x00c8
            int r0 = r13.getWidth()
        L_0x00c6:
            int r15 = r15 + r0
            goto L_0x00cd
        L_0x00c8:
            int r0 = r13.getHeight()
            goto L_0x00c6
        L_0x00cd:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r8]
            int r0 = r0.getMargin()
            int r15 = r15 + r0
            int r14 = r14 + 1
            int r0 = r13.getVisibility()
            r2 = 8
            if (r0 == r2) goto L_0x00e2
            int r12 = r12 + 1
        L_0x00e2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x00fb
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.mOwner
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            r2 = r2[r23]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x00fb
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.mOwner
            if (r2 == r13) goto L_0x00f9
            goto L_0x00fb
        L_0x00f9:
            r17 = r0
        L_0x00fb:
            if (r17 == 0) goto L_0x0100
            r13 = r17
            goto L_0x0101
        L_0x0100:
            r11 = 1
        L_0x0101:
            r2 = r18
            r6 = r19
            goto L_0x008b
        L_0x0106:
            r18 = r2
            r19 = r6
            if (r12 != 0) goto L_0x010d
            return r16
        L_0x010d:
            if (r12 == r14) goto L_0x0110
            return r16
        L_0x0110:
            if (r9 >= r15) goto L_0x0113
            return r16
        L_0x0113:
            int r9 = r9 - r15
            r0 = 2
            if (r25 == 0) goto L_0x011c
            int r2 = r12 + 1
            int r9 = r9 / r2
        L_0x011a:
            r6 = 1
            goto L_0x0123
        L_0x011c:
            if (r26 == 0) goto L_0x011a
            if (r12 <= r0) goto L_0x011a
            int r9 = r9 / r12
            r6 = 1
            int r9 = r9 - r6
        L_0x0123:
            if (r12 != r6) goto L_0x0154
            if (r22 != 0) goto L_0x012c
            float r0 = r19.getHorizontalBiasPercent()
            goto L_0x0130
        L_0x012c:
            float r0 = r19.getVerticalBiasPercent()
        L_0x0130:
            r2 = 1056964608(0x3f000000, float:0.5)
            float r3 = (float) r7
            float r3 = r3 + r2
            float r2 = (float) r9
            float r2 = r2 * r0
            float r3 = r3 + r2
            int r0 = (int) r3
            if (r22 != 0) goto L_0x0143
            int r2 = r4.getWidth()
            int r2 = r2 + r0
            r4.setFinalHorizontal(r0, r2)
            goto L_0x014b
        L_0x0143:
            int r2 = r4.getHeight()
            int r2 = r2 + r0
            r4.setFinalVertical(r0, r2)
        L_0x014b:
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            r6 = 1
            horizontalSolvingPass(r6, r4, r0, r1)
            return r6
        L_0x0154:
            if (r25 == 0) goto L_0x01e7
            int r7 = r7 + r9
            r0 = r16
            r2 = r18
        L_0x015b:
            if (r0 != 0) goto L_0x0233
            int r3 = r2.getVisibility()
            r4 = 8
            if (r3 != r4) goto L_0x0181
            if (r22 != 0) goto L_0x0172
            r2.setFinalHorizontal(r7, r7)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r3 = r20.getMeasurer()
            horizontalSolvingPass(r6, r2, r3, r1)
            goto L_0x017c
        L_0x0172:
            r2.setFinalVertical(r7, r7)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r3 = r20.getMeasurer()
            verticalSolvingPass(r6, r2, r3)
        L_0x017c:
            r3 = r21
            r5 = r16
            goto L_0x01c2
        L_0x0181:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r23]
            int r3 = r3.getMargin()
            int r7 = r7 + r3
            if (r22 != 0) goto L_0x01a2
            int r3 = r2.getWidth()
            int r3 = r3 + r7
            r2.setFinalHorizontal(r7, r3)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r3 = r20.getMeasurer()
            r6 = 1
            horizontalSolvingPass(r6, r2, r3, r1)
            int r3 = r2.getWidth()
        L_0x01a0:
            int r7 = r7 + r3
            goto L_0x01b7
        L_0x01a2:
            r6 = 1
            int r3 = r2.getHeight()
            int r3 = r3 + r7
            r2.setFinalVertical(r7, r3)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r3 = r20.getMeasurer()
            verticalSolvingPass(r6, r2, r3)
            int r3 = r2.getHeight()
            goto L_0x01a0
        L_0x01b7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r8]
            int r3 = r3.getMargin()
            int r7 = r7 + r3
            int r7 = r7 + r9
            goto L_0x017c
        L_0x01c2:
            r2.addToSolver(r3, r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r2.mListAnchors
            r5 = r5[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x01db
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r5.mListAnchors
            r6 = r6[r23]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x01db
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.mOwner
            if (r6 == r2) goto L_0x01dd
        L_0x01db:
            r5 = r17
        L_0x01dd:
            if (r5 == 0) goto L_0x01e1
            r2 = r5
            goto L_0x01e2
        L_0x01e1:
            r0 = 1
        L_0x01e2:
            r6 = 1
            r16 = 0
            goto L_0x015b
        L_0x01e7:
            if (r26 == 0) goto L_0x0232
            if (r12 != r0) goto L_0x022f
            if (r22 != 0) goto L_0x020e
            int r0 = r4.getWidth()
            int r0 = r0 + r7
            r4.setFinalHorizontal(r7, r0)
            int r0 = r5.getWidth()
            int r0 = r3 - r0
            r5.setFinalHorizontal(r0, r3)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            r6 = 1
            horizontalSolvingPass(r6, r4, r0, r1)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            horizontalSolvingPass(r6, r5, r0, r1)
            goto L_0x022e
        L_0x020e:
            r6 = 1
            int r0 = r4.getHeight()
            int r0 = r0 + r7
            r4.setFinalVertical(r7, r0)
            int r0 = r5.getHeight()
            int r0 = r3 - r0
            r5.setFinalVertical(r0, r3)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            verticalSolvingPass(r6, r4, r0)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            verticalSolvingPass(r6, r5, r0)
        L_0x022e:
            return r6
        L_0x022f:
            r16 = 0
            return r16
        L_0x0232:
            r6 = 1
        L_0x0233:
            return r6
        L_0x0234:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.solveChain(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead, boolean, boolean, boolean):boolean");
    }

    private static void solveHorizontalCenterConstraints(int i5, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z4) {
        float f5;
        float horizontalBiasPercent = constraintWidget.getHorizontalBiasPercent();
        int finalValue = constraintWidget.mLeft.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mRight.mTarget.getFinalValue();
        int margin = constraintWidget.mLeft.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mRight.getMargin();
        if (finalValue == finalValue2) {
            horizontalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int width = constraintWidget.getWidth();
        int i6 = (finalValue2 - finalValue) - width;
        if (finalValue > finalValue2) {
            i6 = (finalValue - finalValue2) - width;
        }
        if (i6 > 0) {
            f5 = (horizontalBiasPercent * ((float) i6)) + 0.5f;
        } else {
            f5 = horizontalBiasPercent * ((float) i6);
        }
        int i7 = ((int) f5) + finalValue;
        int i8 = i7 + width;
        if (finalValue > finalValue2) {
            i8 = i7 - width;
        }
        constraintWidget.setFinalHorizontal(i7, i8);
        horizontalSolvingPass(i5 + 1, constraintWidget, measurer, z4);
    }

    private static void solveHorizontalMatchConstraint(int i5, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z4) {
        int i6;
        float horizontalBiasPercent = constraintWidget2.getHorizontalBiasPercent();
        int finalValue = constraintWidget2.mLeft.mTarget.getFinalValue() + constraintWidget2.mLeft.getMargin();
        int finalValue2 = constraintWidget2.mRight.mTarget.getFinalValue() - constraintWidget2.mRight.getMargin();
        if (finalValue2 >= finalValue) {
            int width = constraintWidget2.getWidth();
            if (constraintWidget2.getVisibility() != 8) {
                int i7 = constraintWidget2.mMatchConstraintDefaultWidth;
                if (i7 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        i6 = constraintWidget.getWidth();
                    } else {
                        i6 = constraintWidget.getParent().getWidth();
                    }
                    width = (int) (constraintWidget2.getHorizontalBiasPercent() * 0.5f * ((float) i6));
                } else if (i7 == 0) {
                    width = finalValue2 - finalValue;
                }
                width = Math.max(constraintWidget2.mMatchConstraintMinWidth, width);
                int i8 = constraintWidget2.mMatchConstraintMaxWidth;
                if (i8 > 0) {
                    width = Math.min(i8, width);
                }
            }
            int i9 = finalValue + ((int) ((horizontalBiasPercent * ((float) ((finalValue2 - finalValue) - width))) + 0.5f));
            constraintWidget2.setFinalHorizontal(i9, width + i9);
            horizontalSolvingPass(i5 + 1, constraintWidget2, measurer, z4);
        }
    }

    private static void solveVerticalCenterConstraints(int i5, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float f5;
        float verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
        int finalValue = constraintWidget.mTop.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mBottom.mTarget.getFinalValue();
        int margin = constraintWidget.mTop.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mBottom.getMargin();
        if (finalValue == finalValue2) {
            verticalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int height = constraintWidget.getHeight();
        int i6 = (finalValue2 - finalValue) - height;
        if (finalValue > finalValue2) {
            i6 = (finalValue - finalValue2) - height;
        }
        if (i6 > 0) {
            f5 = (verticalBiasPercent * ((float) i6)) + 0.5f;
        } else {
            f5 = verticalBiasPercent * ((float) i6);
        }
        int i7 = (int) f5;
        int i8 = finalValue + i7;
        int i9 = i8 + height;
        if (finalValue > finalValue2) {
            i8 = finalValue - i7;
            i9 = i8 - height;
        }
        constraintWidget.setFinalVertical(i8, i9);
        verticalSolvingPass(i5 + 1, constraintWidget, measurer);
    }

    private static void solveVerticalMatchConstraint(int i5, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        int i6;
        float verticalBiasPercent = constraintWidget2.getVerticalBiasPercent();
        int finalValue = constraintWidget2.mTop.mTarget.getFinalValue() + constraintWidget2.mTop.getMargin();
        int finalValue2 = constraintWidget2.mBottom.mTarget.getFinalValue() - constraintWidget2.mBottom.getMargin();
        if (finalValue2 >= finalValue) {
            int height = constraintWidget2.getHeight();
            if (constraintWidget2.getVisibility() != 8) {
                int i7 = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i7 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        i6 = constraintWidget.getHeight();
                    } else {
                        i6 = constraintWidget.getParent().getHeight();
                    }
                    height = (int) (verticalBiasPercent * 0.5f * ((float) i6));
                } else if (i7 == 0) {
                    height = finalValue2 - finalValue;
                }
                height = Math.max(constraintWidget2.mMatchConstraintMinHeight, height);
                int i8 = constraintWidget2.mMatchConstraintMaxHeight;
                if (i8 > 0) {
                    height = Math.min(i8, height);
                }
            }
            int i9 = finalValue + ((int) ((verticalBiasPercent * ((float) ((finalValue2 - finalValue) - height))) + 0.5f));
            constraintWidget2.setFinalVertical(i9, height + i9);
            verticalSolvingPass(i5 + 1, constraintWidget2, measurer);
        }
    }

    public static void solvingPass(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidgetContainer.getVerticalDimensionBehaviour();
        sHcount = 0;
        sVcount = 0;
        constraintWidgetContainer.resetFinalResolution();
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i5 = 0; i5 < size; i5++) {
            children.get(i5).resetFinalResolution();
        }
        boolean isRtl = constraintWidgetContainer.isRtl();
        if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalHorizontal(0, constraintWidgetContainer.getWidth());
        } else {
            constraintWidgetContainer.setFinalLeft(0);
        }
        boolean z4 = false;
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = children.get(i6);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    if (guideline.getRelativeBegin() != -1) {
                        guideline.setFinalValue(guideline.getRelativeBegin());
                    } else if (guideline.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue(constraintWidgetContainer.getWidth() - guideline.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue((int) ((guideline.getRelativePercent() * ((float) constraintWidgetContainer.getWidth())) + 0.5f));
                    }
                    z4 = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).getOrientation() == 0) {
                z5 = true;
            }
        }
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget2 = children.get(i7);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.getOrientation() == 1) {
                        horizontalSolvingPass(0, guideline2, measurer, isRtl);
                    }
                }
            }
        }
        horizontalSolvingPass(0, constraintWidgetContainer, measurer, isRtl);
        if (z5) {
            for (int i8 = 0; i8 < size; i8++) {
                ConstraintWidget constraintWidget3 = children.get(i8);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.getOrientation() == 0) {
                        solveBarrier(0, barrier, measurer, 0, isRtl);
                    }
                }
            }
        }
        if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalVertical(0, constraintWidgetContainer.getHeight());
        } else {
            constraintWidgetContainer.setFinalTop(0);
        }
        boolean z6 = false;
        boolean z7 = false;
        for (int i9 = 0; i9 < size; i9++) {
            ConstraintWidget constraintWidget4 = children.get(i9);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.getOrientation() == 0) {
                    if (guideline3.getRelativeBegin() != -1) {
                        guideline3.setFinalValue(guideline3.getRelativeBegin());
                    } else if (guideline3.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue(constraintWidgetContainer.getHeight() - guideline3.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue((int) ((guideline3.getRelativePercent() * ((float) constraintWidgetContainer.getHeight())) + 0.5f));
                    }
                    z6 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).getOrientation() == 1) {
                z7 = true;
            }
        }
        if (z6) {
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget5 = children.get(i10);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.getOrientation() == 0) {
                        verticalSolvingPass(1, guideline4, measurer);
                    }
                }
            }
        }
        verticalSolvingPass(0, constraintWidgetContainer, measurer);
        if (z7) {
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget6 = children.get(i11);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.getOrientation() == 1) {
                        solveBarrier(0, barrier2, measurer, 1, isRtl);
                    }
                }
            }
        }
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget7 = children.get(i12);
            if (constraintWidget7.isMeasureRequested() && canMeasure(0, constraintWidget7)) {
                ConstraintWidgetContainer.measure(0, constraintWidget7, measurer, sMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
                if (!(constraintWidget7 instanceof Guideline)) {
                    horizontalSolvingPass(0, constraintWidget7, measurer, isRtl);
                    verticalSolvingPass(0, constraintWidget7, measurer);
                } else if (((Guideline) constraintWidget7).getOrientation() == 0) {
                    verticalSolvingPass(0, constraintWidget7, measurer);
                } else {
                    horizontalSolvingPass(0, constraintWidget7, measurer, isRtl);
                }
            }
        }
    }

    private static void verticalSolvingPass(int i5, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        boolean z4;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z5;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget2 = constraintWidget;
        BasicMeasure.Measurer measurer2 = measurer;
        if (!constraintWidget2.isVerticalSolvingPassDone()) {
            boolean z6 = true;
            sVcount++;
            if (!(constraintWidget2 instanceof ConstraintWidgetContainer) && constraintWidget2.isMeasureRequested()) {
                int i6 = i5 + 1;
                if (canMeasure(i6, constraintWidget2)) {
                    ConstraintWidgetContainer.measure(i6, constraintWidget2, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
            }
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor2 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM);
            int finalValue = anchor.getFinalValue();
            int finalValue2 = anchor2.getFinalValue();
            if (anchor.getDependents() != null && anchor.hasFinalValue()) {
                Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget3 = next.mOwner;
                    int i7 = i5 + 1;
                    boolean canMeasure = canMeasure(i7, constraintWidget3);
                    if (constraintWidget3.isMeasureRequested() && canMeasure) {
                        ConstraintWidgetContainer.measure(i7, constraintWidget3, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                    if ((next != constraintWidget3.mTop || (constraintAnchor4 = constraintWidget3.mBottom.mTarget) == null || !constraintAnchor4.hasFinalValue()) && (next != constraintWidget3.mBottom || (constraintAnchor3 = constraintWidget3.mTop.mTarget) == null || !constraintAnchor3.hasFinalValue())) {
                        z5 = false;
                    } else {
                        z5 = z6;
                    }
                    ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget3.getVerticalDimensionBehaviour();
                    boolean z7 = z6;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (verticalDimensionBehaviour != dimensionBehaviour || canMeasure) {
                        if (!constraintWidget3.isMeasureRequested()) {
                            ConstraintAnchor constraintAnchor5 = constraintWidget3.mTop;
                            if (next == constraintAnchor5 && constraintWidget3.mBottom.mTarget == null) {
                                int margin = constraintAnchor5.getMargin() + finalValue;
                                constraintWidget3.setFinalVertical(margin, constraintWidget3.getHeight() + margin);
                                verticalSolvingPass(i7, constraintWidget3, measurer2);
                            } else {
                                ConstraintAnchor constraintAnchor6 = constraintWidget3.mBottom;
                                if (next == constraintAnchor6 && constraintAnchor5.mTarget == null) {
                                    int margin2 = finalValue - constraintAnchor6.getMargin();
                                    constraintWidget3.setFinalVertical(margin2 - constraintWidget3.getHeight(), margin2);
                                    verticalSolvingPass(i7, constraintWidget3, measurer2);
                                } else if (z5 && !constraintWidget3.isInVerticalChain()) {
                                    solveVerticalCenterConstraints(i7, measurer2, constraintWidget3);
                                }
                            }
                        }
                    } else if (constraintWidget3.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget3.mMatchConstraintMaxHeight >= 0 && constraintWidget3.mMatchConstraintMinHeight >= 0 && ((constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultHeight == 0 && constraintWidget3.getDimensionRatio() == 0.0f)) && !constraintWidget3.isInVerticalChain() && !constraintWidget3.isInVirtualLayout() && z5 && !constraintWidget3.isInVerticalChain())) {
                        solveVerticalMatchConstraint(i7, constraintWidget2, measurer2, constraintWidget3);
                    }
                    z6 = z7;
                }
            }
            boolean z8 = z6;
            if (!(constraintWidget2 instanceof Guideline)) {
                if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
                    Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
                    while (it2.hasNext()) {
                        ConstraintAnchor next2 = it2.next();
                        ConstraintWidget constraintWidget4 = next2.mOwner;
                        int i8 = i5 + 1;
                        boolean canMeasure2 = canMeasure(i8, constraintWidget4);
                        if (constraintWidget4.isMeasureRequested() && canMeasure2) {
                            ConstraintWidgetContainer.measure(i8, constraintWidget4, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                        }
                        if ((next2 != constraintWidget4.mTop || (constraintAnchor2 = constraintWidget4.mBottom.mTarget) == null || !constraintAnchor2.hasFinalValue()) && (next2 != constraintWidget4.mBottom || (constraintAnchor = constraintWidget4.mTop.mTarget) == null || !constraintAnchor.hasFinalValue())) {
                            z4 = false;
                        } else {
                            z4 = z8;
                        }
                        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour2 = constraintWidget4.getVerticalDimensionBehaviour();
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (verticalDimensionBehaviour2 != dimensionBehaviour2 || canMeasure2) {
                            if (!constraintWidget4.isMeasureRequested()) {
                                ConstraintAnchor constraintAnchor7 = constraintWidget4.mTop;
                                if (next2 == constraintAnchor7 && constraintWidget4.mBottom.mTarget == null) {
                                    int margin3 = constraintAnchor7.getMargin() + finalValue2;
                                    constraintWidget4.setFinalVertical(margin3, constraintWidget4.getHeight() + margin3);
                                    verticalSolvingPass(i8, constraintWidget4, measurer2);
                                } else {
                                    ConstraintAnchor constraintAnchor8 = constraintWidget4.mBottom;
                                    if (next2 == constraintAnchor8 && constraintAnchor7.mTarget == null) {
                                        int margin4 = finalValue2 - constraintAnchor8.getMargin();
                                        constraintWidget4.setFinalVertical(margin4 - constraintWidget4.getHeight(), margin4);
                                        verticalSolvingPass(i8, constraintWidget4, measurer2);
                                    } else if (z4 && !constraintWidget4.isInVerticalChain()) {
                                        solveVerticalCenterConstraints(i8, measurer2, constraintWidget4);
                                    }
                                }
                            }
                        } else if (constraintWidget4.getVerticalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget4.mMatchConstraintMaxHeight >= 0 && constraintWidget4.mMatchConstraintMinHeight >= 0) {
                            if ((constraintWidget4.getVisibility() == 8 || (constraintWidget4.mMatchConstraintDefaultHeight == 0 && constraintWidget4.getDimensionRatio() == 0.0f)) && !constraintWidget4.isInVerticalChain() && !constraintWidget4.isInVirtualLayout() && z4 && !constraintWidget4.isInVerticalChain()) {
                                solveVerticalMatchConstraint(i8, constraintWidget2, measurer2, constraintWidget4);
                            }
                        }
                    }
                }
                ConstraintAnchor anchor3 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BASELINE);
                if (anchor3.getDependents() != null && anchor3.hasFinalValue()) {
                    int finalValue3 = anchor3.getFinalValue();
                    Iterator<ConstraintAnchor> it3 = anchor3.getDependents().iterator();
                    while (it3.hasNext()) {
                        ConstraintAnchor next3 = it3.next();
                        ConstraintWidget constraintWidget5 = next3.mOwner;
                        int i9 = i5 + 1;
                        boolean canMeasure3 = canMeasure(i9, constraintWidget5);
                        if (constraintWidget5.isMeasureRequested() && canMeasure3) {
                            ConstraintWidgetContainer.measure(i9, constraintWidget5, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                        }
                        if ((constraintWidget5.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || canMeasure3) && !constraintWidget5.isMeasureRequested() && next3 == constraintWidget5.mBaseline) {
                            constraintWidget5.setFinalBaseline(next3.getMargin() + finalValue3);
                            verticalSolvingPass(i9, constraintWidget5, measurer2);
                        }
                    }
                }
                constraintWidget2.markVerticalSolvingPassDone();
            }
        }
    }
}
