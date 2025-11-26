package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    public boolean dual = false;
    int mDirection;
    WidgetRun mFirstRun = null;
    int mGroupIndex;
    WidgetRun mLastRun = null;
    ArrayList<WidgetRun> mRuns = new ArrayList<>();
    public int position = 0;

    RunGroup(WidgetRun widgetRun, int i5) {
        int i6 = index;
        this.mGroupIndex = i6;
        index = i6 + 1;
        this.mFirstRun = widgetRun;
        this.mLastRun = widgetRun;
        this.mDirection = i5;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i5) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.mWidget.isTerminalWidget[i5]) {
            return false;
        }
        for (Dependency next : widgetRun.start.mDependencies) {
            if ((next instanceof DependencyNode) && (widgetRun3 = dependencyNode2.mRun) != widgetRun && (dependencyNode2 = (DependencyNode) next) == widgetRun3.start) {
                if (widgetRun instanceof ChainRun) {
                    ArrayList<WidgetRun> arrayList = ((ChainRun) widgetRun).mWidgets;
                    int size = arrayList.size();
                    int i6 = 0;
                    while (i6 < size) {
                        WidgetRun widgetRun4 = arrayList.get(i6);
                        i6++;
                        defineTerminalWidget(widgetRun4, i5);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.mWidget.isTerminalWidget[i5] = false;
                }
                defineTerminalWidget(dependencyNode2.mRun, i5);
            }
        }
        for (Dependency next2 : widgetRun.end.mDependencies) {
            if ((next2 instanceof DependencyNode) && (widgetRun2 = dependencyNode.mRun) != widgetRun && (dependencyNode = (DependencyNode) next2) == widgetRun2.start) {
                if (widgetRun instanceof ChainRun) {
                    ArrayList<WidgetRun> arrayList2 = ((ChainRun) widgetRun).mWidgets;
                    int size2 = arrayList2.size();
                    int i7 = 0;
                    while (i7 < size2) {
                        WidgetRun widgetRun5 = arrayList2.get(i7);
                        i7++;
                        defineTerminalWidget(widgetRun5, i5);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.mWidget.isTerminalWidget[i5] = false;
                }
                defineTerminalWidget(dependencyNode.mRun, i5);
            }
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j5) {
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun instanceof HelperReferences) {
            return j5;
        }
        int size = dependencyNode.mDependencies.size();
        long j6 = j5;
        for (int i5 = 0; i5 < size; i5++) {
            Dependency dependency = dependencyNode.mDependencies.get(i5);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    j6 = Math.min(j6, traverseEnd(dependencyNode2, ((long) dependencyNode2.mMargin) + j5));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j6;
        }
        long wrapDimension = j5 - widgetRun.getWrapDimension();
        return Math.min(Math.min(j6, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - ((long) widgetRun.start.mMargin));
    }

    private long traverseStart(DependencyNode dependencyNode, long j5) {
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun instanceof HelperReferences) {
            return j5;
        }
        int size = dependencyNode.mDependencies.size();
        long j6 = j5;
        for (int i5 = 0; i5 < size; i5++) {
            Dependency dependency = dependencyNode.mDependencies.get(i5);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    j6 = Math.max(j6, traverseStart(dependencyNode2, ((long) dependencyNode2.mMargin) + j5));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j6;
        }
        long wrapDimension = j5 + widgetRun.getWrapDimension();
        return Math.max(Math.max(j6, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - ((long) widgetRun.end.mMargin));
    }

    public void add(WidgetRun widgetRun) {
        this.mRuns.add(widgetRun);
        this.mLastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i5) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        long wrapDimension;
        int i6;
        WidgetRun widgetRun3 = this.mFirstRun;
        long j5 = 0;
        if (widgetRun3 instanceof ChainRun) {
            if (((ChainRun) widgetRun3).orientation != i5) {
                return 0;
            }
        } else if (i5 == 0) {
            if (!(widgetRun3 instanceof HorizontalWidgetRun)) {
                return 0;
            }
        } else if (!(widgetRun3 instanceof VerticalWidgetRun)) {
            return 0;
        }
        if (i5 == 0) {
            widgetRun = constraintWidgetContainer.mHorizontalRun;
        } else {
            widgetRun = constraintWidgetContainer.mVerticalRun;
        }
        DependencyNode dependencyNode = widgetRun.start;
        if (i5 == 0) {
            widgetRun2 = constraintWidgetContainer.mHorizontalRun;
        } else {
            widgetRun2 = constraintWidgetContainer.mVerticalRun;
        }
        DependencyNode dependencyNode2 = widgetRun2.end;
        boolean contains = widgetRun3.start.mTargets.contains(dependencyNode);
        boolean contains2 = this.mFirstRun.end.mTargets.contains(dependencyNode2);
        long wrapDimension2 = this.mFirstRun.getWrapDimension();
        if (contains && contains2) {
            long traverseStart = traverseStart(this.mFirstRun.start, 0);
            long traverseEnd = traverseEnd(this.mFirstRun.end, 0);
            long j6 = traverseStart - wrapDimension2;
            WidgetRun widgetRun4 = this.mFirstRun;
            int i7 = widgetRun4.end.mMargin;
            if (j6 >= ((long) (-i7))) {
                j6 += (long) i7;
            }
            int i8 = widgetRun4.start.mMargin;
            long j7 = ((-traverseEnd) - wrapDimension2) - ((long) i8);
            if (j7 >= ((long) i8)) {
                j7 -= (long) i8;
            }
            float biasPercent = widgetRun4.mWidget.getBiasPercent(i5);
            if (biasPercent > 0.0f) {
                j5 = (long) ((((float) j7) / biasPercent) + (((float) j6) / (1.0f - biasPercent)));
            }
            float f5 = (float) j5;
            long j8 = ((long) ((f5 * biasPercent) + 0.5f)) + wrapDimension2 + ((long) ((f5 * (1.0f - biasPercent)) + 0.5f));
            WidgetRun widgetRun5 = this.mFirstRun;
            wrapDimension = ((long) widgetRun5.start.mMargin) + j8;
            i6 = widgetRun5.end.mMargin;
        } else if (contains) {
            DependencyNode dependencyNode3 = this.mFirstRun.start;
            return Math.max(traverseStart(dependencyNode3, (long) dependencyNode3.mMargin), ((long) this.mFirstRun.start.mMargin) + wrapDimension2);
        } else if (contains2) {
            DependencyNode dependencyNode4 = this.mFirstRun.end;
            return Math.max(-traverseEnd(dependencyNode4, (long) dependencyNode4.mMargin), ((long) (-this.mFirstRun.end.mMargin)) + wrapDimension2);
        } else {
            WidgetRun widgetRun6 = this.mFirstRun;
            wrapDimension = ((long) widgetRun6.start.mMargin) + widgetRun6.getWrapDimension();
            i6 = this.mFirstRun.end.mMargin;
        }
        return wrapDimension - ((long) i6);
    }

    public void defineTerminalWidgets(boolean z4, boolean z5) {
        if (z4) {
            WidgetRun widgetRun = this.mFirstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z5) {
            WidgetRun widgetRun2 = this.mFirstRun;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}
