package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

class HelperReferences extends WidgetRun {
    HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void addDependency(DependencyNode dependencyNode) {
        this.start.mDependencies.add(dependencyNode);
        dependencyNode.mTargets.add(this.start);
    }

    /* access modifiers changed from: package-private */
    public void apply() {
        ConstraintWidget constraintWidget = this.mWidget;
        if (constraintWidget instanceof Barrier) {
            this.start.delegateToWidgetRun = true;
            Barrier barrier = (Barrier) constraintWidget;
            int barrierType = barrier.getBarrierType();
            boolean allowsGoneWidget = barrier.getAllowsGoneWidget();
            int i5 = 0;
            if (barrierType == 0) {
                this.start.mType = DependencyNode.Type.LEFT;
                while (i5 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget2 = barrier.mWidgets[i5];
                    if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.mHorizontalRun.start;
                        dependencyNode.mDependencies.add(this.start);
                        this.start.mTargets.add(dependencyNode);
                    }
                    i5++;
                }
                addDependency(this.mWidget.mHorizontalRun.start);
                addDependency(this.mWidget.mHorizontalRun.end);
            } else if (barrierType == 1) {
                this.start.mType = DependencyNode.Type.RIGHT;
                while (i5 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget3 = barrier.mWidgets[i5];
                    if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.mHorizontalRun.end;
                        dependencyNode2.mDependencies.add(this.start);
                        this.start.mTargets.add(dependencyNode2);
                    }
                    i5++;
                }
                addDependency(this.mWidget.mHorizontalRun.start);
                addDependency(this.mWidget.mHorizontalRun.end);
            } else if (barrierType == 2) {
                this.start.mType = DependencyNode.Type.TOP;
                while (i5 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget4 = barrier.mWidgets[i5];
                    if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.mVerticalRun.start;
                        dependencyNode3.mDependencies.add(this.start);
                        this.start.mTargets.add(dependencyNode3);
                    }
                    i5++;
                }
                addDependency(this.mWidget.mVerticalRun.start);
                addDependency(this.mWidget.mVerticalRun.end);
            } else if (barrierType == 3) {
                this.start.mType = DependencyNode.Type.BOTTOM;
                while (i5 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget5 = barrier.mWidgets[i5];
                    if (allowsGoneWidget || constraintWidget5.getVisibility() != 8) {
                        DependencyNode dependencyNode4 = constraintWidget5.mVerticalRun.end;
                        dependencyNode4.mDependencies.add(this.start);
                        this.start.mTargets.add(dependencyNode4);
                    }
                    i5++;
                }
                addDependency(this.mWidget.mVerticalRun.start);
                addDependency(this.mWidget.mVerticalRun.end);
            }
        }
    }

    public void applyToWidget() {
        ConstraintWidget constraintWidget = this.mWidget;
        if (constraintWidget instanceof Barrier) {
            int barrierType = ((Barrier) constraintWidget).getBarrierType();
            if (barrierType == 0 || barrierType == 1) {
                this.mWidget.setX(this.start.value);
            } else {
                this.mWidget.setY(this.start.value);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.mRunGroup = null;
        this.start.clear();
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.start.resolved = false;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsWrapComputation() {
        return false;
    }

    public void update(Dependency dependency) {
        Barrier barrier = (Barrier) this.mWidget;
        int barrierType = barrier.getBarrierType();
        int i5 = 0;
        int i6 = -1;
        for (DependencyNode dependencyNode : this.start.mTargets) {
            int i7 = dependencyNode.value;
            if (i6 == -1 || i7 < i6) {
                i6 = i7;
            }
            if (i5 < i7) {
                i5 = i7;
            }
        }
        if (barrierType == 0 || barrierType == 2) {
            this.start.resolve(i6 + barrier.getMargin());
        } else {
            this.start.resolve(i5 + barrier.getMargin());
        }
    }
}
