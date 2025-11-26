package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;

public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i5) {
        int i6;
        ChainHead[] chainHeadArr;
        int i7;
        if (i5 == 0) {
            i7 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i6 = 0;
        } else {
            i7 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i6 = 2;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            ChainHead chainHead = chainHeadArr[i8];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i5, i6, chainHead);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v2, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v3, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX WARNING: type inference failed for: r6v12, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r8 == 2) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        if (r8 == 2) goto L_0x0033;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x025d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02b1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x046f  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x04a9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x04c5  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x04ce  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x04d2  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x04e2  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x04e6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x038b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:323:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.core.LinearSystem r38, int r39, int r40, androidx.constraintlayout.core.widgets.ChainHead r41) {
        /*
            r0 = r37
            r1 = r38
            r9 = r39
            r2 = r41
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r2.mFirst
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r2.mLast
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r2.mFirstVisibleWidget
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r2.mLastVisibleWidget
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r2.mHead
            float r4 = r2.mTotalWeight
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r0.mListDimensionBehaviors
            r5 = r5[r9]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r14 = 1
            if (r5 != r6) goto L_0x001f
            r5 = r14
            goto L_0x0020
        L_0x001f:
            r5 = 0
        L_0x0020:
            r6 = 2
            if (r9 != 0) goto L_0x0039
            int r8 = r3.mHorizontalChainStyle
            if (r8 != 0) goto L_0x0029
            r15 = r14
            goto L_0x002a
        L_0x0029:
            r15 = 0
        L_0x002a:
            if (r8 != r14) goto L_0x002f
            r16 = r14
            goto L_0x0031
        L_0x002f:
            r16 = 0
        L_0x0031:
            if (r8 != r6) goto L_0x0035
        L_0x0033:
            r6 = r14
            goto L_0x0036
        L_0x0035:
            r6 = 0
        L_0x0036:
            r14 = r10
            r8 = 0
            goto L_0x004a
        L_0x0039:
            int r8 = r3.mVerticalChainStyle
            if (r8 != 0) goto L_0x003f
            r15 = r14
            goto L_0x0040
        L_0x003f:
            r15 = 0
        L_0x0040:
            if (r8 != r14) goto L_0x0045
            r16 = r14
            goto L_0x0047
        L_0x0045:
            r16 = 0
        L_0x0047:
            if (r8 != r6) goto L_0x0035
            goto L_0x0033
        L_0x004a:
            r19 = r4
            r22 = 0
            if (r8 != 0) goto L_0x0130
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            r4 = r4[r40]
            if (r6 == 0) goto L_0x0059
            r20 = 1
            goto L_0x005b
        L_0x0059:
            r20 = 4
        L_0x005b:
            int r23 = r4.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r14.mListDimensionBehaviors
            r7 = r7[r9]
            r24 = r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 != r5) goto L_0x0073
            int[] r7 = r14.mResolvedMatchConstraintDefault
            r7 = r7[r9]
            if (r7 != 0) goto L_0x0073
            r7 = 1
        L_0x0070:
            r25 = r6
            goto L_0x0075
        L_0x0073:
            r7 = 0
            goto L_0x0070
        L_0x0075:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r4.mTarget
            if (r6 == 0) goto L_0x0081
            if (r14 == r10) goto L_0x0081
            int r6 = r6.getMargin()
            int r23 = r23 + r6
        L_0x0081:
            r6 = r23
            if (r25 == 0) goto L_0x008b
            if (r14 == r10) goto L_0x008b
            if (r14 == r12) goto L_0x008b
            r20 = 8
        L_0x008b:
            r23 = r7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r4.mTarget
            if (r7 == 0) goto L_0x00cb
            if (r14 != r12) goto L_0x00a0
            r26 = r8
            androidx.constraintlayout.core.SolverVariable r8 = r4.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r7 = r7.mSolverVariable
            r27 = r15
            r15 = 6
            r1.addGreaterThan(r8, r7, r6, r15)
            goto L_0x00ad
        L_0x00a0:
            r26 = r8
            r27 = r15
            androidx.constraintlayout.core.SolverVariable r8 = r4.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r7 = r7.mSolverVariable
            r15 = 8
            r1.addGreaterThan(r8, r7, r6, r15)
        L_0x00ad:
            if (r23 == 0) goto L_0x00b3
            if (r25 != 0) goto L_0x00b3
            r20 = 5
        L_0x00b3:
            if (r14 != r12) goto L_0x00bf
            if (r25 == 0) goto L_0x00bf
            boolean r7 = r14.isInBarrier(r9)
            if (r7 == 0) goto L_0x00bf
            r7 = 5
            goto L_0x00c1
        L_0x00bf:
            r7 = r20
        L_0x00c1:
            androidx.constraintlayout.core.SolverVariable r8 = r4.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.core.SolverVariable r4 = r4.mSolverVariable
            r1.addEquality(r8, r4, r6, r7)
            goto L_0x00cf
        L_0x00cb:
            r26 = r8
            r27 = r15
        L_0x00cf:
            if (r24 == 0) goto L_0x0103
            int r4 = r14.getVisibility()
            r15 = 8
            if (r4 == r15) goto L_0x00f1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r14.mListDimensionBehaviors
            r4 = r4[r9]
            if (r4 != r5) goto L_0x00f1
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            int r5 = r40 + 1
            r5 = r4[r5]
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            r4 = r4[r40]
            androidx.constraintlayout.core.SolverVariable r4 = r4.mSolverVariable
            r6 = 5
            r7 = 0
            r1.addGreaterThan(r5, r4, r7, r6)
            goto L_0x00f2
        L_0x00f1:
            r7 = 0
        L_0x00f2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            r4 = r4[r40]
            androidx.constraintlayout.core.SolverVariable r4 = r4.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r0.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            r15 = 8
            r1.addGreaterThan(r4, r5, r7, r15)
        L_0x0103:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            int r5 = r40 + 1
            r4 = r4[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x011e
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.mOwner
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r4.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x011e
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            if (r5 == r14) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r22 = r4
        L_0x011e:
            if (r22 == 0) goto L_0x0125
            r14 = r22
            r8 = r26
            goto L_0x0126
        L_0x0125:
            r8 = 1
        L_0x0126:
            r4 = r19
            r5 = r24
            r6 = r25
            r15 = r27
            goto L_0x004a
        L_0x0130:
            r24 = r5
            r25 = r6
            r27 = r15
            if (r13 == 0) goto L_0x0194
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            int r5 = r40 + 1
            r4 = r4[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0194
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r13.mListAnchors
            r4 = r4[r5]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r13.mListDimensionBehaviors
            r6 = r6[r9]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x016a
            int[] r6 = r13.mResolvedMatchConstraintDefault
            r6 = r6[r9]
            if (r6 != 0) goto L_0x016a
            if (r25 != 0) goto L_0x016a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r4.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r6.mOwner
            if (r7 != r0) goto L_0x016a
            androidx.constraintlayout.core.SolverVariable r7 = r4.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            int r8 = r4.getMargin()
            int r8 = -r8
            r15 = 5
            r1.addEquality(r7, r6, r8, r15)
            goto L_0x0180
        L_0x016a:
            r15 = 5
            if (r25 == 0) goto L_0x0180
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r4.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r6.mOwner
            if (r7 != r0) goto L_0x0180
            androidx.constraintlayout.core.SolverVariable r7 = r4.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            int r8 = r4.getMargin()
            int r8 = -r8
            r14 = 4
            r1.addEquality(r7, r6, r8, r14)
        L_0x0180:
            androidx.constraintlayout.core.SolverVariable r6 = r4.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r5 = r7[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            int r4 = r4.getMargin()
            int r4 = -r4
            r7 = 6
            r1.addLowerThan(r6, r5, r4, r7)
            goto L_0x0195
        L_0x0194:
            r15 = 5
        L_0x0195:
            if (r24 == 0) goto L_0x01ae
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r4 = r40 + 1
            r0 = r0[r4]
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r11.mListAnchors
            r4 = r5[r4]
            androidx.constraintlayout.core.SolverVariable r5 = r4.mSolverVariable
            int r4 = r4.getMargin()
            r6 = 8
            r1.addGreaterThan(r0, r5, r4, r6)
        L_0x01ae:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r2.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x025b
            int r4 = r0.size()
            r5 = 1
            if (r4 <= r5) goto L_0x025b
            boolean r5 = r2.mHasUndefinedWeights
            if (r5 == 0) goto L_0x01c7
            boolean r5 = r2.mHasComplexMatchWeights
            if (r5 != 0) goto L_0x01c7
            int r5 = r2.mWidgetsMatchCount
            float r5 = (float) r5
            r30 = r5
            goto L_0x01c9
        L_0x01c7:
            r30 = r19
        L_0x01c9:
            r5 = 0
            r29 = r5
            r6 = r22
            r7 = 0
        L_0x01cf:
            if (r7 >= r4) goto L_0x025b
            java.lang.Object r8 = r0.get(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r8
            float[] r14 = r8.mWeight
            r14 = r14[r9]
            int r19 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r19 >= 0) goto L_0x0200
            boolean r14 = r2.mHasComplexMatchWeights
            if (r14 == 0) goto L_0x01f8
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r8 = r8.mListAnchors
            int r14 = r40 + 1
            r14 = r8[r14]
            androidx.constraintlayout.core.SolverVariable r14 = r14.mSolverVariable
            r8 = r8[r40]
            androidx.constraintlayout.core.SolverVariable r8 = r8.mSolverVariable
            r37 = r5
            r5 = 4
            r15 = 0
            r1.addEquality(r14, r8, r15, r5)
            r5 = r15
            goto L_0x021a
        L_0x01f8:
            r37 = r5
            r5 = 4
            r14 = 1065353216(0x3f800000, float:1.0)
        L_0x01fd:
            r31 = r14
            goto L_0x0204
        L_0x0200:
            r37 = r5
            r5 = 4
            goto L_0x01fd
        L_0x0204:
            int r14 = (r31 > r37 ? 1 : (r31 == r37 ? 0 : -1))
            if (r14 != 0) goto L_0x021d
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r8 = r8.mListAnchors
            int r14 = r40 + 1
            r14 = r8[r14]
            androidx.constraintlayout.core.SolverVariable r14 = r14.mSolverVariable
            r8 = r8[r40]
            androidx.constraintlayout.core.SolverVariable r8 = r8.mSolverVariable
            r5 = 0
            r15 = 8
            r1.addEquality(r14, r8, r5, r15)
        L_0x021a:
            r19 = r0
            goto L_0x0252
        L_0x021d:
            r5 = 0
            if (r6 == 0) goto L_0x024d
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r6.mListAnchors
            r14 = r6[r40]
            androidx.constraintlayout.core.SolverVariable r14 = r14.mSolverVariable
            int r15 = r40 + 1
            r6 = r6[r15]
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r19 = r0
            r0 = r5[r40]
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            r5 = r5[r15]
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            androidx.constraintlayout.core.ArrayRow r28 = r1.createRow()
            r34 = r0
            r35 = r5
            r33 = r6
            r32 = r14
            r28.createRowEqualMatchDimensions(r29, r30, r31, r32, r33, r34, r35)
            r0 = r28
            r1.addConstraint(r0)
            goto L_0x024f
        L_0x024d:
            r19 = r0
        L_0x024f:
            r6 = r8
            r29 = r31
        L_0x0252:
            int r7 = r7 + 1
            r5 = r37
            r0 = r19
            r15 = 5
            goto L_0x01cf
        L_0x025b:
            if (r12 == 0) goto L_0x02af
            if (r12 == r13) goto L_0x0261
            if (r25 == 0) goto L_0x02af
        L_0x0261:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r10.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            int r4 = r40 + 1
            r2 = r2[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x0272
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            goto L_0x0274
        L_0x0272:
            r0 = r22
        L_0x0274:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.mTarget
            if (r5 == 0) goto L_0x027b
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            goto L_0x027d
        L_0x027b:
            r5 = r22
        L_0x027d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r12.mListAnchors
            r6 = r6[r40]
            if (r13 == 0) goto L_0x0287
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r4]
        L_0x0287:
            if (r0 == 0) goto L_0x02ab
            if (r5 == 0) goto L_0x02ab
            if (r9 != 0) goto L_0x0291
            float r3 = r3.mHorizontalBiasPercent
        L_0x028f:
            r4 = r3
            goto L_0x0294
        L_0x0291:
            float r3 = r3.mVerticalBiasPercent
            goto L_0x028f
        L_0x0294:
            int r3 = r6.getMargin()
            int r7 = r2.getMargin()
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            r8 = 7
            r36 = r2
            r2 = r0
            r0 = r1
            r1 = r6
            r6 = r36
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x02ab:
            r0 = r38
            goto L_0x04a7
        L_0x02af:
            if (r27 == 0) goto L_0x0391
            if (r12 == 0) goto L_0x0391
            int r0 = r2.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x02be
            int r1 = r2.mWidgetsCount
            if (r1 != r0) goto L_0x02be
            r18 = 1
            goto L_0x02c0
        L_0x02be:
            r18 = 0
        L_0x02c0:
            r14 = r12
            r15 = r14
        L_0x02c2:
            if (r14 == 0) goto L_0x02ab
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r9]
        L_0x02c8:
            if (r0 == 0) goto L_0x02d7
            int r1 = r0.getVisibility()
            r6 = 8
            if (r1 != r6) goto L_0x02d9
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r9]
            goto L_0x02c8
        L_0x02d7:
            r6 = 8
        L_0x02d9:
            if (r0 != 0) goto L_0x02e5
            if (r14 != r13) goto L_0x02de
            goto L_0x02e5
        L_0x02de:
            r19 = r0
            r9 = r6
        L_0x02e1:
            r21 = 5
            goto L_0x0384
        L_0x02e5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            r1 = r1[r40]
            androidx.constraintlayout.core.SolverVariable r2 = r1.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x02f2
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            goto L_0x02f4
        L_0x02f2:
            r3 = r22
        L_0x02f4:
            if (r15 == r14) goto L_0x02ff
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r4 = r40 + 1
            r3 = r3[r4]
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            goto L_0x030e
        L_0x02ff:
            if (r14 != r12) goto L_0x030e
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r10.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x030c
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            goto L_0x030e
        L_0x030c:
            r3 = r22
        L_0x030e:
            int r1 = r1.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            int r5 = r40 + 1
            r4 = r4[r5]
            int r4 = r4.getMargin()
            if (r0 == 0) goto L_0x0325
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r0.mListAnchors
            r7 = r7[r40]
            androidx.constraintlayout.core.SolverVariable r8 = r7.mSolverVariable
            goto L_0x0332
        L_0x0325:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r7 = r7[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 == 0) goto L_0x0330
            androidx.constraintlayout.core.SolverVariable r8 = r7.mSolverVariable
            goto L_0x0332
        L_0x0330:
            r8 = r22
        L_0x0332:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r14.mListAnchors
            r6 = r6[r5]
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            if (r7 == 0) goto L_0x033f
            int r7 = r7.getMargin()
            int r4 = r4 + r7
        L_0x033f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r15.mListAnchors
            r7 = r7[r5]
            int r7 = r7.getMargin()
            int r1 = r1 + r7
            if (r2 == 0) goto L_0x037e
            if (r3 == 0) goto L_0x037e
            if (r8 == 0) goto L_0x037e
            if (r6 == 0) goto L_0x037e
            if (r14 != r12) goto L_0x035a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r40]
            int r1 = r1.getMargin()
        L_0x035a:
            if (r14 != r13) goto L_0x0364
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r13.mListAnchors
            r4 = r4[r5]
            int r4 = r4.getMargin()
        L_0x0364:
            r7 = r4
            r5 = r8
            if (r18 == 0) goto L_0x036b
            r8 = 8
            goto L_0x036c
        L_0x036b:
            r8 = 5
        L_0x036c:
            r4 = 1056964608(0x3f000000, float:0.5)
            r9 = r3
            r3 = r1
            r1 = r2
            r2 = r9
            r19 = r0
            r9 = 8
            r21 = 5
            r0 = r38
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0384
        L_0x037e:
            r19 = r0
            r9 = 8
            goto L_0x02e1
        L_0x0384:
            int r0 = r14.getVisibility()
            if (r0 == r9) goto L_0x038b
            r15 = r14
        L_0x038b:
            r9 = r39
            r14 = r19
            goto L_0x02c2
        L_0x0391:
            r9 = 8
            if (r16 == 0) goto L_0x02ab
            if (r12 == 0) goto L_0x02ab
            int r0 = r2.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x03a2
            int r1 = r2.mWidgetsCount
            if (r1 != r0) goto L_0x03a2
            r18 = 1
            goto L_0x03a4
        L_0x03a2:
            r18 = 0
        L_0x03a4:
            r14 = r12
            r15 = r14
        L_0x03a6:
            if (r14 == 0) goto L_0x0454
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r39]
        L_0x03ac:
            if (r0 == 0) goto L_0x03b9
            int r1 = r0.getVisibility()
            if (r1 != r9) goto L_0x03b9
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r39]
            goto L_0x03ac
        L_0x03b9:
            if (r14 == r12) goto L_0x0446
            if (r14 == r13) goto L_0x0446
            if (r0 == 0) goto L_0x0446
            if (r0 != r13) goto L_0x03c3
            r0 = r22
        L_0x03c3:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            r1 = r1[r40]
            androidx.constraintlayout.core.SolverVariable r2 = r1.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x03cf
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
        L_0x03cf:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r4 = r40 + 1
            r3 = r3[r4]
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            int r1 = r1.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r14.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            if (r0 == 0) goto L_0x03f5
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r0.mListAnchors
            r6 = r6[r40]
            androidx.constraintlayout.core.SolverVariable r7 = r6.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r6.mTarget
            if (r8 == 0) goto L_0x03f2
            androidx.constraintlayout.core.SolverVariable r8 = r8.mSolverVariable
            goto L_0x0406
        L_0x03f2:
            r8 = r22
            goto L_0x0406
        L_0x03f5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r13.mListAnchors
            r6 = r6[r40]
            if (r6 == 0) goto L_0x03fe
            androidx.constraintlayout.core.SolverVariable r7 = r6.mSolverVariable
            goto L_0x0400
        L_0x03fe:
            r7 = r22
        L_0x0400:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r8 = r14.mListAnchors
            r8 = r8[r4]
            androidx.constraintlayout.core.SolverVariable r8 = r8.mSolverVariable
        L_0x0406:
            if (r6 == 0) goto L_0x040d
            int r6 = r6.getMargin()
            int r5 = r5 + r6
        L_0x040d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r15.mListAnchors
            r4 = r6[r4]
            int r4 = r4.getMargin()
            int r1 = r1 + r4
            if (r18 == 0) goto L_0x041a
            r4 = r9
            goto L_0x041b
        L_0x041a:
            r4 = 4
        L_0x041b:
            if (r2 == 0) goto L_0x043d
            if (r3 == 0) goto L_0x043d
            if (r7 == 0) goto L_0x043d
            if (r8 == 0) goto L_0x043d
            r6 = r8
            r8 = r4
            r4 = 1056964608(0x3f000000, float:0.5)
            r19 = r3
            r3 = r1
            r1 = r2
            r2 = r19
            r19 = r7
            r7 = r5
            r5 = r19
            r19 = r0
            r20 = 4
            r0 = r38
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = r0
            goto L_0x0443
        L_0x043d:
            r1 = r38
            r19 = r0
            r20 = 4
        L_0x0443:
            r0 = r19
            goto L_0x044a
        L_0x0446:
            r1 = r38
            r20 = 4
        L_0x044a:
            int r2 = r14.getVisibility()
            if (r2 == r9) goto L_0x0451
            r15 = r14
        L_0x0451:
            r14 = r0
            goto L_0x03a6
        L_0x0454:
            r1 = r38
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            int r4 = r40 + 1
            r9 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mTarget
            r8 = 5
            if (r2 == 0) goto L_0x047c
            if (r12 == r13) goto L_0x047e
            androidx.constraintlayout.core.SolverVariable r3 = r0.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            r1.addEquality(r3, r2, r0, r8)
        L_0x047c:
            r0 = r1
            goto L_0x0497
        L_0x047e:
            if (r10 == 0) goto L_0x047c
            androidx.constraintlayout.core.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            int r3 = r0.getMargin()
            androidx.constraintlayout.core.SolverVariable r5 = r9.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r6 = r10.mSolverVariable
            int r7 = r9.getMargin()
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0497:
            if (r10 == 0) goto L_0x04a7
            if (r12 == r13) goto L_0x04a7
            androidx.constraintlayout.core.SolverVariable r1 = r9.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r10.mSolverVariable
            int r3 = r9.getMargin()
            int r3 = -r3
            r0.addEquality(r1, r2, r3, r8)
        L_0x04a7:
            if (r27 != 0) goto L_0x04ab
            if (r16 == 0) goto L_0x0506
        L_0x04ab:
            if (r12 == 0) goto L_0x0506
            if (r12 == r13) goto L_0x0506
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r2 = r1[r40]
            if (r13 != 0) goto L_0x04b6
            r13 = r12
        L_0x04b6:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            r17 = 1
            int r4 = r40 + 1
            r3 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.mTarget
            if (r5 == 0) goto L_0x04c5
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            goto L_0x04c7
        L_0x04c5:
            r5 = r22
        L_0x04c7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mTarget
            if (r6 == 0) goto L_0x04ce
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            goto L_0x04d0
        L_0x04ce:
            r6 = r22
        L_0x04d0:
            if (r11 == r13) goto L_0x04e0
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r6 = r6[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x04de
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            r22 = r6
        L_0x04de:
            r6 = r22
        L_0x04e0:
            if (r12 != r13) goto L_0x04e4
            r3 = r1[r4]
        L_0x04e4:
            if (r5 == 0) goto L_0x0506
            if (r6 == 0) goto L_0x0506
            int r1 = r2.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r13.mListAnchors
            r4 = r7[r4]
            int r7 = r4.getMargin()
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            r8 = 5
            r4 = 1056964608(0x3f000000, float:0.5)
            r36 = r3
            r3 = r1
            r1 = r2
            r2 = r5
            r5 = r6
            r6 = r36
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0506:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Chain.applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead):void");
    }
}
