package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.widget.VirtualLayout;

public class MotionPlaceholder extends VirtualLayout {
    private static final String TAG = "MotionPlaceholder";
    Placeholder mPlaceholder;

    public MotionPlaceholder(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mHelperWidget = new Placeholder();
        validateParams();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i5, int i6) {
        onMeasure(this.mPlaceholder, i5, i6);
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        if (virtualLayout != null) {
            virtualLayout.measure(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.getMeasuredWidth(), virtualLayout.getMeasuredHeight());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5);
    }
}
