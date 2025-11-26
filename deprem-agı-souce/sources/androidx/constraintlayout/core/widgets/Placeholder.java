package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;

public class Placeholder extends VirtualLayout {
    public void addToSolver(LinearSystem linearSystem, boolean z4) {
        super.addToSolver(linearSystem, z4);
        if (this.mWidgetsCount > 0) {
            ConstraintWidget constraintWidget = this.mWidgets[0];
            constraintWidget.resetAllConstraints();
            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
            constraintWidget.connect(type, (ConstraintWidget) this, type);
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
            constraintWidget.connect(type2, (ConstraintWidget) this, type2);
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
            constraintWidget.connect(type3, (ConstraintWidget) this, type3);
            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
            constraintWidget.connect(type4, (ConstraintWidget) this, type4);
        }
    }

    public void measure(int i5, int i6, int i7, int i8) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        boolean z4 = false;
        if (this.mWidgetsCount > 0) {
            paddingLeft += this.mWidgets[0].getWidth();
            paddingTop += this.mWidgets[0].getHeight();
        }
        int max = Math.max(getMinWidth(), paddingLeft);
        int max2 = Math.max(getMinHeight(), paddingTop);
        if (i5 != 1073741824) {
            if (i5 == Integer.MIN_VALUE) {
                i6 = Math.min(max, i6);
            } else if (i5 == 0) {
                i6 = max;
            } else {
                i6 = 0;
            }
        }
        if (i7 != 1073741824) {
            if (i7 == Integer.MIN_VALUE) {
                i8 = Math.min(max2, i8);
            } else if (i7 == 0) {
                i8 = max2;
            } else {
                i8 = 0;
            }
        }
        setMeasure(i6, i8);
        setWidth(i6);
        setHeight(i8);
        if (this.mWidgetsCount > 0) {
            z4 = true;
        }
        needsCallbackFromSolver(z4);
    }
}
