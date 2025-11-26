package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;

public class Grouping {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_GROUPING = false;
    private static final boolean FORCE_USE = true;

    public static WidgetGroup findDependents(ConstraintWidget constraintWidget, int i5, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        int i6;
        int findGroupInDependents;
        if (i5 == 0) {
            i6 = constraintWidget.horizontalGroup;
        } else {
            i6 = constraintWidget.verticalGroup;
        }
        int i7 = 0;
        if (i6 != -1 && (widgetGroup == null || i6 != widgetGroup.getId())) {
            int i8 = 0;
            while (true) {
                if (i8 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup2 = arrayList.get(i8);
                if (widgetGroup2.getId() == i6) {
                    if (widgetGroup != null) {
                        widgetGroup.moveTo(i5, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i8++;
                }
            }
        } else if (i6 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if ((constraintWidget instanceof HelperWidget) && (findGroupInDependents = ((HelperWidget) constraintWidget).findGroupInDependents(i5)) != -1) {
                int i9 = 0;
                while (true) {
                    if (i9 >= arrayList.size()) {
                        break;
                    }
                    WidgetGroup widgetGroup3 = arrayList.get(i9);
                    if (widgetGroup3.getId() == findGroupInDependents) {
                        widgetGroup = widgetGroup3;
                        break;
                    }
                    i9++;
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup(i5);
            }
            arrayList.add(widgetGroup);
        }
        if (widgetGroup.add(constraintWidget)) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                ConstraintAnchor anchor = guideline.getAnchor();
                if (guideline.getOrientation() == 0) {
                    i7 = 1;
                }
                anchor.findDependents(i7, arrayList, widgetGroup);
            }
            if (i5 == 0) {
                constraintWidget.horizontalGroup = widgetGroup.getId();
                constraintWidget.mLeft.findDependents(i5, arrayList, widgetGroup);
                constraintWidget.mRight.findDependents(i5, arrayList, widgetGroup);
            } else {
                constraintWidget.verticalGroup = widgetGroup.getId();
                constraintWidget.mTop.findDependents(i5, arrayList, widgetGroup);
                constraintWidget.mBaseline.findDependents(i5, arrayList, widgetGroup);
                constraintWidget.mBottom.findDependents(i5, arrayList, widgetGroup);
            }
            constraintWidget.mCenter.findDependents(i5, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    private static WidgetGroup findGroup(ArrayList<WidgetGroup> arrayList, int i5) {
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            WidgetGroup widgetGroup = arrayList.get(i6);
            if (i5 == widgetGroup.getId()) {
                return widgetGroup;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:167:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0392 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean simpleSolvingPass(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r17, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r18) {
        /*
            r0 = r17
            java.util.ArrayList r1 = r0.getChildren()
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        L_0x000c:
            if (r4 >= r2) goto L_0x0033
            java.lang.Object r5 = r1.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r0.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = r0.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = r5.getVerticalDimensionBehaviour()
            boolean r6 = validInGroup(r6, r7, r8, r9)
            if (r6 != 0) goto L_0x002b
            return r3
        L_0x002b:
            boolean r5 = r5 instanceof androidx.constraintlayout.core.widgets.Flow
            if (r5 == 0) goto L_0x0030
            return r3
        L_0x0030:
            int r4 = r4 + 1
            goto L_0x000c
        L_0x0033:
            androidx.constraintlayout.core.Metrics r4 = r0.mMetrics
            if (r4 == 0) goto L_0x003e
            long r5 = r4.grouping
            r7 = 1
            long r5 = r5 + r7
            r4.grouping = r5
        L_0x003e:
            r5 = r3
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0045:
            if (r5 >= r2) goto L_0x011e
            java.lang.Object r13 = r1.get(r5)
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = r0.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = r0.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r13.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r13.getVerticalDimensionBehaviour()
            boolean r4 = validInGroup(r14, r15, r4, r12)
            if (r4 != 0) goto L_0x006d
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = r0.mMeasure
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS
            r14 = r18
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.measure(r3, r13, r14, r4, r12)
            goto L_0x006f
        L_0x006d:
            r14 = r18
        L_0x006f:
            boolean r4 = r13 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r4 == 0) goto L_0x0097
            r12 = r13
            androidx.constraintlayout.core.widgets.Guideline r12 = (androidx.constraintlayout.core.widgets.Guideline) r12
            int r15 = r12.getOrientation()
            if (r15 != 0) goto L_0x0086
            if (r8 != 0) goto L_0x0083
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0083:
            r8.add(r12)
        L_0x0086:
            int r15 = r12.getOrientation()
            r3 = 1
            if (r15 != r3) goto L_0x0097
            if (r6 != 0) goto L_0x0094
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0094:
            r6.add(r12)
        L_0x0097:
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.HelperWidget
            if (r3 == 0) goto L_0x00db
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 == 0) goto L_0x00c4
            r3 = r13
            androidx.constraintlayout.core.widgets.Barrier r3 = (androidx.constraintlayout.core.widgets.Barrier) r3
            int r12 = r3.getOrientation()
            if (r12 != 0) goto L_0x00b2
            if (r7 != 0) goto L_0x00af
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x00af:
            r7.add(r3)
        L_0x00b2:
            int r12 = r3.getOrientation()
            r15 = 1
            if (r12 != r15) goto L_0x00db
            if (r9 != 0) goto L_0x00c0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x00c0:
            r9.add(r3)
            goto L_0x00db
        L_0x00c4:
            r3 = r13
            androidx.constraintlayout.core.widgets.HelperWidget r3 = (androidx.constraintlayout.core.widgets.HelperWidget) r3
            if (r7 != 0) goto L_0x00ce
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x00ce:
            r7.add(r3)
            if (r9 != 0) goto L_0x00d8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x00d8:
            r9.add(r3)
        L_0x00db:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x00f7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x00f7
            if (r4 != 0) goto L_0x00f7
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 != 0) goto L_0x00f7
            if (r10 != 0) goto L_0x00f4
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x00f4:
            r10.add(r13)
        L_0x00f7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0119
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0119
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0119
            if (r4 != 0) goto L_0x0119
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 != 0) goto L_0x0119
            if (r11 != 0) goto L_0x0116
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
        L_0x0116:
            r11.add(r13)
        L_0x0119:
            int r5 = r5 + 1
            r3 = 0
            goto L_0x0045
        L_0x011e:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            if (r6 == 0) goto L_0x013a
            int r4 = r6.size()
            r5 = 0
        L_0x012a:
            if (r5 >= r4) goto L_0x013a
            java.lang.Object r12 = r6.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.core.widgets.Guideline r12 = (androidx.constraintlayout.core.widgets.Guideline) r12
            r13 = 0
            r14 = 0
            findDependents(r12, r14, r3, r13)
            goto L_0x012a
        L_0x013a:
            if (r7 == 0) goto L_0x0158
            int r4 = r7.size()
            r5 = 0
        L_0x0141:
            if (r5 >= r4) goto L_0x0158
            java.lang.Object r6 = r7.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.core.widgets.HelperWidget r6 = (androidx.constraintlayout.core.widgets.HelperWidget) r6
            r13 = 0
            r14 = 0
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r12 = findDependents(r6, r14, r3, r13)
            r6.addDependents(r3, r14, r12)
            r12.cleanup(r3)
            goto L_0x0141
        L_0x0158:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.getAnchor(r4)
            java.util.HashSet r5 = r4.getDependents()
            if (r5 == 0) goto L_0x0180
            java.util.HashSet r4 = r4.getDependents()
            java.util.Iterator r4 = r4.iterator()
        L_0x016c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0180
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            r13 = 0
            r14 = 0
            findDependents(r5, r14, r3, r13)
            goto L_0x016c
        L_0x0180:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.getAnchor(r4)
            java.util.HashSet r5 = r4.getDependents()
            if (r5 == 0) goto L_0x01a8
            java.util.HashSet r4 = r4.getDependents()
            java.util.Iterator r4 = r4.iterator()
        L_0x0194:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01a8
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            r13 = 0
            r14 = 0
            findDependents(r5, r14, r3, r13)
            goto L_0x0194
        L_0x01a8:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.getAnchor(r4)
            java.util.HashSet r5 = r4.getDependents()
            if (r5 == 0) goto L_0x01d0
            java.util.HashSet r4 = r4.getDependents()
            java.util.Iterator r4 = r4.iterator()
        L_0x01bc:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01d0
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            r13 = 0
            r14 = 0
            findDependents(r5, r14, r3, r13)
            goto L_0x01bc
        L_0x01d0:
            if (r10 == 0) goto L_0x01e7
            int r4 = r10.size()
            r5 = 0
        L_0x01d7:
            if (r5 >= r4) goto L_0x01e7
            java.lang.Object r6 = r10.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r6
            r13 = 0
            r14 = 0
            findDependents(r6, r14, r3, r13)
            goto L_0x01d7
        L_0x01e7:
            if (r8 == 0) goto L_0x01fe
            int r4 = r8.size()
            r5 = 0
        L_0x01ee:
            if (r5 >= r4) goto L_0x01fe
            java.lang.Object r6 = r8.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.core.widgets.Guideline r6 = (androidx.constraintlayout.core.widgets.Guideline) r6
            r13 = 0
            r15 = 1
            findDependents(r6, r15, r3, r13)
            goto L_0x01ee
        L_0x01fe:
            if (r9 == 0) goto L_0x021c
            int r4 = r9.size()
            r5 = 0
        L_0x0205:
            if (r5 >= r4) goto L_0x021c
            java.lang.Object r6 = r9.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.core.widgets.HelperWidget r6 = (androidx.constraintlayout.core.widgets.HelperWidget) r6
            r13 = 0
            r15 = 1
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r7 = findDependents(r6, r15, r3, r13)
            r6.addDependents(r3, r15, r7)
            r7.cleanup(r3)
            goto L_0x0205
        L_0x021c:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.getAnchor(r4)
            java.util.HashSet r5 = r4.getDependents()
            if (r5 == 0) goto L_0x0244
            java.util.HashSet r4 = r4.getDependents()
            java.util.Iterator r4 = r4.iterator()
        L_0x0230:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0244
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            r13 = 0
            r15 = 1
            findDependents(r5, r15, r3, r13)
            goto L_0x0230
        L_0x0244:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.getAnchor(r4)
            java.util.HashSet r5 = r4.getDependents()
            if (r5 == 0) goto L_0x026c
            java.util.HashSet r4 = r4.getDependents()
            java.util.Iterator r4 = r4.iterator()
        L_0x0258:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x026c
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            r13 = 0
            r15 = 1
            findDependents(r5, r15, r3, r13)
            goto L_0x0258
        L_0x026c:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.getAnchor(r4)
            java.util.HashSet r5 = r4.getDependents()
            if (r5 == 0) goto L_0x0294
            java.util.HashSet r4 = r4.getDependents()
            java.util.Iterator r4 = r4.iterator()
        L_0x0280:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0294
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            r13 = 0
            r15 = 1
            findDependents(r5, r15, r3, r13)
            goto L_0x0280
        L_0x0294:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.getAnchor(r4)
            java.util.HashSet r5 = r4.getDependents()
            if (r5 == 0) goto L_0x02bc
            java.util.HashSet r4 = r4.getDependents()
            java.util.Iterator r4 = r4.iterator()
        L_0x02a8:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02bc
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            r13 = 0
            r15 = 1
            findDependents(r5, r15, r3, r13)
            goto L_0x02a8
        L_0x02bc:
            if (r11 == 0) goto L_0x02d3
            int r4 = r11.size()
            r5 = 0
        L_0x02c3:
            if (r5 >= r4) goto L_0x02d3
            java.lang.Object r6 = r11.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r6
            r13 = 0
            r15 = 1
            findDependents(r6, r15, r3, r13)
            goto L_0x02c3
        L_0x02d3:
            r13 = 0
            r4 = 0
        L_0x02d5:
            if (r4 >= r2) goto L_0x0301
            java.lang.Object r5 = r1.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5.oppositeDimensionsTied()
            if (r6 == 0) goto L_0x02fe
            int r6 = r5.horizontalGroup
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r6 = findGroup(r3, r6)
            int r5 = r5.verticalGroup
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r5 = findGroup(r3, r5)
            if (r6 == 0) goto L_0x02fe
            if (r5 == 0) goto L_0x02fe
            r14 = 0
            r6.moveTo(r14, r5)
            r7 = 2
            r5.setOrientation(r7)
            r3.remove(r6)
        L_0x02fe:
            int r4 = r4 + 1
            goto L_0x02d5
        L_0x0301:
            int r1 = r3.size()
            r15 = 1
            if (r1 > r15) goto L_0x030b
            r16 = 0
            return r16
        L_0x030b:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r0.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r2) goto L_0x034c
            int r1 = r3.size()
            r2 = r13
            r4 = 0
            r5 = 0
        L_0x031a:
            if (r5 >= r1) goto L_0x033d
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r6 = (androidx.constraintlayout.core.widgets.analyzer.WidgetGroup) r6
            int r7 = r6.getOrientation()
            r15 = 1
            if (r7 != r15) goto L_0x032c
            goto L_0x031a
        L_0x032c:
            r14 = 0
            r6.setAuthoritative(r14)
            androidx.constraintlayout.core.LinearSystem r7 = r0.getSystem()
            int r7 = r6.measureWrap((androidx.constraintlayout.core.LinearSystem) r7, (int) r14)
            if (r7 <= r4) goto L_0x031a
            r2 = r6
            r4 = r7
            goto L_0x031a
        L_0x033d:
            if (r2 == 0) goto L_0x034c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.setHorizontalDimensionBehaviour(r1)
            r0.setWidth(r4)
            r15 = 1
            r2.setAuthoritative(r15)
            goto L_0x034d
        L_0x034c:
            r2 = r13
        L_0x034d:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r0.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r4) goto L_0x038e
            int r1 = r3.size()
            r4 = r13
            r5 = 0
            r14 = 0
        L_0x035c:
            if (r5 >= r1) goto L_0x037f
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r6 = (androidx.constraintlayout.core.widgets.analyzer.WidgetGroup) r6
            int r7 = r6.getOrientation()
            if (r7 != 0) goto L_0x036d
            goto L_0x035c
        L_0x036d:
            r7 = 0
            r6.setAuthoritative(r7)
            androidx.constraintlayout.core.LinearSystem r7 = r0.getSystem()
            r15 = 1
            int r7 = r6.measureWrap((androidx.constraintlayout.core.LinearSystem) r7, (int) r15)
            if (r7 <= r14) goto L_0x035c
            r4 = r6
            r14 = r7
            goto L_0x035c
        L_0x037f:
            r15 = 1
            if (r4 == 0) goto L_0x038f
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.setVerticalDimensionBehaviour(r1)
            r0.setHeight(r14)
            r4.setAuthoritative(r15)
            goto L_0x0390
        L_0x038e:
            r15 = 1
        L_0x038f:
            r4 = r13
        L_0x0390:
            if (r2 != 0) goto L_0x0398
            if (r4 == 0) goto L_0x0395
            goto L_0x0398
        L_0x0395:
            r16 = 0
            return r16
        L_0x0398:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.simpleSolvingPass(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer):boolean");
    }

    public static boolean validInGroup(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        boolean z4;
        boolean z5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != dimensionBehaviour6)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != dimensionBehaviour5)) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z4 || z5) {
            return true;
        }
        return false;
    }
}
