package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

class DimensionDependency extends DependencyNode {
    public int wrapValue;

    DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.mType = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.mType = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    public void resolve(int i5) {
        if (!this.resolved) {
            this.resolved = true;
            this.value = i5;
            for (Dependency next : this.mDependencies) {
                next.update(next);
            }
        }
    }
}
