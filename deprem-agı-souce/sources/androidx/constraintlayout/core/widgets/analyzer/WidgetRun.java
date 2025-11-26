package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public abstract class WidgetRun implements Dependency {
    public DependencyNode end = new DependencyNode(this);
    DimensionDependency mDimension = new DimensionDependency(this);
    protected ConstraintWidget.DimensionBehaviour mDimensionBehavior;
    boolean mResolved = false;
    RunGroup mRunGroup;
    protected RunType mRunType = RunType.NONE;
    ConstraintWidget mWidget;
    public int matchConstraintsType;
    public int orientation = 0;
    public DependencyNode start = new DependencyNode(this);

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.mWidget = constraintWidget;
    }

    private void resolveDimension(int i5, int i6) {
        WidgetRun widgetRun;
        float f5;
        int i7;
        int i8 = this.matchConstraintsType;
        if (i8 == 0) {
            this.mDimension.resolve(getLimitedDimension(i6, i5));
        } else if (i8 == 1) {
            this.mDimension.resolve(Math.min(getLimitedDimension(this.mDimension.wrapValue, i5), i6));
        } else if (i8 == 2) {
            ConstraintWidget parent = this.mWidget.getParent();
            if (parent != null) {
                if (i5 == 0) {
                    widgetRun = parent.mHorizontalRun;
                } else {
                    widgetRun = parent.mVerticalRun;
                }
                DimensionDependency dimensionDependency = widgetRun.mDimension;
                if (dimensionDependency.resolved) {
                    if (i5 == 0) {
                        f5 = this.mWidget.mMatchConstraintPercentWidth;
                    } else {
                        f5 = this.mWidget.mMatchConstraintPercentHeight;
                    }
                    this.mDimension.resolve(getLimitedDimension((int) ((((float) dimensionDependency.value) * f5) + 0.5f), i5));
                }
            }
        } else if (i8 == 3) {
            ConstraintWidget constraintWidget = this.mWidget;
            WidgetRun widgetRun2 = constraintWidget.mHorizontalRun;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun2.mDimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && widgetRun2.matchConstraintsType == 3) {
                VerticalWidgetRun verticalWidgetRun = constraintWidget.mVerticalRun;
                if (verticalWidgetRun.mDimensionBehavior == dimensionBehaviour2 && verticalWidgetRun.matchConstraintsType == 3) {
                    return;
                }
            }
            if (i5 == 0) {
                widgetRun2 = constraintWidget.mVerticalRun;
            }
            if (widgetRun2.mDimension.resolved) {
                float dimensionRatio = constraintWidget.getDimensionRatio();
                if (i5 == 1) {
                    i7 = (int) ((((float) widgetRun2.mDimension.value) / dimensionRatio) + 0.5f);
                } else {
                    i7 = (int) ((dimensionRatio * ((float) widgetRun2.mDimension.value)) + 0.5f);
                }
                this.mDimension.resolve(i7);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i5) {
        dependencyNode.mTargets.add(dependencyNode2);
        dependencyNode.mMargin = i5;
        dependencyNode2.mDependencies.add(dependencyNode);
    }

    /* access modifiers changed from: package-private */
    public abstract void apply();

    /* access modifiers changed from: package-private */
    public abstract void applyToWidget();

    /* access modifiers changed from: package-private */
    public abstract void clear();

    /* access modifiers changed from: protected */
    public final int getLimitedDimension(int i5, int i6) {
        if (i6 == 0) {
            ConstraintWidget constraintWidget = this.mWidget;
            int i7 = constraintWidget.mMatchConstraintMaxWidth;
            int max = Math.max(constraintWidget.mMatchConstraintMinWidth, i5);
            if (i7 > 0) {
                max = Math.min(i7, i5);
            }
            if (max != i5) {
                return max;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.mWidget;
            int i8 = constraintWidget2.mMatchConstraintMaxHeight;
            int max2 = Math.max(constraintWidget2.mMatchConstraintMinHeight, i5);
            if (i8 > 0) {
                max2 = Math.min(i8, i5);
            }
            if (max2 != i5) {
                return max2;
            }
        }
        return i5;
    }

    /* access modifiers changed from: protected */
    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int i5 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i5 == 1) {
            return constraintWidget.mHorizontalRun.start;
        }
        if (i5 == 2) {
            return constraintWidget.mHorizontalRun.end;
        }
        if (i5 == 3) {
            return constraintWidget.mVerticalRun.start;
        }
        if (i5 == 4) {
            return constraintWidget.mVerticalRun.baseline;
        }
        if (i5 != 5) {
            return null;
        }
        return constraintWidget.mVerticalRun.end;
    }

    public long getWrapDimension() {
        DimensionDependency dimensionDependency = this.mDimension;
        if (dimensionDependency.resolved) {
            return (long) dimensionDependency.value;
        }
        return 0;
    }

    public boolean isCenterConnection() {
        int size = this.start.mTargets.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            if (this.start.mTargets.get(i6).mRun != this) {
                i5++;
            }
        }
        int size2 = this.end.mTargets.size();
        for (int i7 = 0; i7 < size2; i7++) {
            if (this.end.mTargets.get(i7).mRun != this) {
                i5++;
            }
        }
        if (i5 >= 2) {
            return true;
        }
        return false;
    }

    public boolean isDimensionResolved() {
        return this.mDimension.resolved;
    }

    public boolean isResolved() {
        return this.mResolved;
    }

    /* access modifiers changed from: package-private */
    public abstract void reset();

    /* access modifiers changed from: package-private */
    public abstract boolean supportsWrapComputation();

    public void update(Dependency dependency) {
    }

    /* access modifiers changed from: protected */
    public void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i5) {
        float f5;
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = target.value + constraintAnchor.getMargin();
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i6 = margin2 - margin;
            if (!this.mDimension.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                resolveDimension(i5, i6);
            }
            DimensionDependency dimensionDependency = this.mDimension;
            if (dimensionDependency.resolved) {
                if (dimensionDependency.value == i6) {
                    this.start.resolve(margin);
                    this.end.resolve(margin2);
                    return;
                }
                if (i5 == 0) {
                    f5 = this.mWidget.getHorizontalBiasPercent();
                } else {
                    f5 = this.mWidget.getVerticalBiasPercent();
                }
                if (target == target2) {
                    margin = target.value;
                    margin2 = target2.value;
                    f5 = 0.5f;
                }
                this.start.resolve((int) (((float) margin) + 0.5f + (((float) ((margin2 - margin) - this.mDimension.value)) * f5)));
                this.end.resolve(this.start.value + this.mDimension.value);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateRunEnd(Dependency dependency) {
    }

    /* access modifiers changed from: protected */
    public void updateRunStart(Dependency dependency) {
    }

    public long wrapSize(int i5) {
        DimensionDependency dimensionDependency = this.mDimension;
        if (!dimensionDependency.resolved) {
            return 0;
        }
        long j5 = (long) dimensionDependency.value;
        if (isCenterConnection()) {
            return j5 + ((long) (this.start.mMargin - this.end.mMargin));
        }
        if (i5 == 0) {
            return j5 + ((long) this.start.mMargin);
        }
        return j5 - ((long) this.end.mMargin);
    }

    /* access modifiers changed from: protected */
    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i5, DimensionDependency dimensionDependency) {
        dependencyNode.mTargets.add(dependencyNode2);
        dependencyNode.mTargets.add(this.mDimension);
        dependencyNode.mMarginFactor = i5;
        dependencyNode.mMarginDependency = dimensionDependency;
        dependencyNode2.mDependencies.add(dependencyNode);
        dimensionDependency.mDependencies.add(dependencyNode);
    }

    /* access modifiers changed from: protected */
    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i5) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i5 == 0 ? constraintWidget.mHorizontalRun : constraintWidget.mVerticalRun;
        int i6 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }
}
