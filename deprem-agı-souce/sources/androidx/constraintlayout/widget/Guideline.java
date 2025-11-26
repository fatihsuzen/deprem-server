package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Guideline extends View {
    private boolean mFilterRedundantCalls = true;

    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(@NonNull Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z4) {
        this.mFilterRedundantCalls = z4;
    }

    public void setGuidelineBegin(int i5) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.mFilterRedundantCalls || layoutParams.guideBegin != i5) {
            layoutParams.guideBegin = i5;
            setLayoutParams(layoutParams);
        }
    }

    public void setGuidelineEnd(int i5) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.mFilterRedundantCalls || layoutParams.guideEnd != i5) {
            layoutParams.guideEnd = i5;
            setLayoutParams(layoutParams);
        }
    }

    public void setGuidelinePercent(float f5) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.mFilterRedundantCalls || layoutParams.guidePercent != f5) {
            layoutParams.guidePercent = f5;
            setLayoutParams(layoutParams);
        }
    }

    public void setVisibility(int i5) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5);
        super.setVisibility(8);
    }
}
