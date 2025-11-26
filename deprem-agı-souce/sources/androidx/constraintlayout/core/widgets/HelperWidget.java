package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    public void add(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i5 = this.mWidgetsCount + 1;
            ConstraintWidget[] constraintWidgetArr = this.mWidgets;
            if (i5 > constraintWidgetArr.length) {
                this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
            int i6 = this.mWidgetsCount;
            constraintWidgetArr2[i6] = constraintWidget;
            this.mWidgetsCount = i6 + 1;
        }
    }

    public void addDependents(ArrayList<WidgetGroup> arrayList, int i5, WidgetGroup widgetGroup) {
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            widgetGroup.add(this.mWidgets[i6]);
        }
        for (int i7 = 0; i7 < this.mWidgetsCount; i7++) {
            Grouping.findDependents(this.mWidgets[i7], i5, arrayList, widgetGroup);
        }
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.mWidgetsCount = 0;
        int i5 = helperWidget.mWidgetsCount;
        for (int i6 = 0; i6 < i5; i6++) {
            add(hashMap.get(helperWidget.mWidgets[i6]));
        }
    }

    public int findGroupInDependents(int i5) {
        int i6;
        int i7;
        for (int i8 = 0; i8 < this.mWidgetsCount; i8++) {
            ConstraintWidget constraintWidget = this.mWidgets[i8];
            if (i5 == 0 && (i7 = constraintWidget.horizontalGroup) != -1) {
                return i7;
            }
            if (i5 == 1 && (i6 = constraintWidget.verticalGroup) != -1) {
                return i6;
            }
        }
        return -1;
    }

    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, (Object) null);
    }

    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
    }
}
