package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

public class WidgetGroup {
    private static final boolean DEBUG = false;
    static int sCount;
    boolean mAuthoritative = false;
    int mId;
    private int mMoveTo = -1;
    int mOrientation;
    ArrayList<MeasureResult> mResults = null;
    ArrayList<ConstraintWidget> mWidgets = new ArrayList<>();

    static class MeasureResult {
        int mBaseline;
        int mBottom;
        int mLeft;
        int mOrientation;
        int mRight;
        int mTop;
        WeakReference<ConstraintWidget> mWidgetRef;

        MeasureResult(ConstraintWidget constraintWidget, LinearSystem linearSystem, int i5) {
            this.mWidgetRef = new WeakReference<>(constraintWidget);
            this.mLeft = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
            this.mTop = linearSystem.getObjectVariableValue(constraintWidget.mTop);
            this.mRight = linearSystem.getObjectVariableValue(constraintWidget.mRight);
            this.mBottom = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
            this.mBaseline = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
            this.mOrientation = i5;
        }

        public void apply() {
            ConstraintWidget constraintWidget = this.mWidgetRef.get();
            if (constraintWidget != null) {
                constraintWidget.setFinalFrame(this.mLeft, this.mTop, this.mRight, this.mBottom, this.mBaseline, this.mOrientation);
            }
        }
    }

    public WidgetGroup(int i5) {
        int i6 = sCount;
        sCount = i6 + 1;
        this.mId = i6;
        this.mOrientation = i5;
    }

    private boolean contains(ConstraintWidget constraintWidget) {
        return this.mWidgets.contains(constraintWidget);
    }

    private String getOrientationString() {
        int i5 = this.mOrientation;
        if (i5 == 0) {
            return "Horizontal";
        }
        if (i5 == 1) {
            return "Vertical";
        }
        if (i5 == 2) {
            return "Both";
        }
        return "Unknown";
    }

    private int measureWrap(int i5, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(i5);
        if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED) {
            return -1;
        }
        if (i5 == 0) {
            return constraintWidget.getWidth();
        }
        return constraintWidget.getHeight();
    }

    private int solverMeasure(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i5) {
        int objectVariableValue;
        int objectVariableValue2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).getParent();
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList.get(i6).addToSolver(linearSystem, false);
        }
        if (i5 == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i5 == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.minimize();
        } catch (Exception e5) {
            System.err.println(e5.toString() + "\n" + Arrays.toString(e5.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.mResults = new ArrayList<>();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            this.mResults.add(new MeasureResult(arrayList.get(i7), linearSystem, i5));
        }
        if (i5 == 0) {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mLeft);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mRight);
            linearSystem.reset();
        } else {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mTop);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mBottom);
            linearSystem.reset();
        }
        return objectVariableValue2 - objectVariableValue;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        if (this.mWidgets.contains(constraintWidget)) {
            return false;
        }
        this.mWidgets.add(constraintWidget);
        return true;
    }

    public void apply() {
        if (this.mResults != null && this.mAuthoritative) {
            for (int i5 = 0; i5 < this.mResults.size(); i5++) {
                this.mResults.get(i5).apply();
            }
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        int size = this.mWidgets.size();
        if (this.mMoveTo != -1 && size > 0) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                WidgetGroup widgetGroup = arrayList.get(i5);
                if (this.mMoveTo == widgetGroup.mId) {
                    moveTo(this.mOrientation, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void clear() {
        this.mWidgets.clear();
    }

    public int getId() {
        return this.mId;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        for (int i5 = 0; i5 < this.mWidgets.size(); i5++) {
            if (widgetGroup.contains(this.mWidgets.get(i5))) {
                return true;
            }
        }
        return false;
    }

    public boolean isAuthoritative() {
        return this.mAuthoritative;
    }

    public void moveTo(int i5, WidgetGroup widgetGroup) {
        ArrayList<ConstraintWidget> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i6);
            i6++;
            ConstraintWidget constraintWidget2 = constraintWidget;
            widgetGroup.add(constraintWidget2);
            if (i5 == 0) {
                constraintWidget2.horizontalGroup = widgetGroup.getId();
            } else {
                constraintWidget2.verticalGroup = widgetGroup.getId();
            }
        }
        this.mMoveTo = widgetGroup.mId;
    }

    public void setAuthoritative(boolean z4) {
        this.mAuthoritative = z4;
    }

    public void setOrientation(int i5) {
        this.mOrientation = i5;
    }

    public int size() {
        return this.mWidgets.size();
    }

    public String toString() {
        String str = getOrientationString() + " [" + this.mId + "] <";
        ArrayList<ConstraintWidget> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i5);
            i5++;
            str = str + " " + constraintWidget.getDebugName();
        }
        return str + " >";
    }

    public int measureWrap(LinearSystem linearSystem, int i5) {
        if (this.mWidgets.size() == 0) {
            return 0;
        }
        return solverMeasure(linearSystem, this.mWidgets, i5);
    }
}
