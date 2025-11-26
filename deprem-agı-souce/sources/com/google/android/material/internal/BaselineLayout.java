package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup {
    private int baseline = -1;
    private boolean measurePaddingFromBaseline;

    public BaselineLayout(Context context) {
        super(context, (AttributeSet) null, 0);
    }

    public int getBaseline() {
        return this.baseline;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i7 - i5) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                if (this.baseline == -1 || childAt.getBaseline() == -1) {
                    i9 = paddingTop;
                } else {
                    i9 = (this.baseline + paddingTop) - childAt.getBaseline();
                }
                childAt.layout(i11, i9, measuredWidth + i11, measuredHeight + i9);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i5, i6);
                i7 = Math.max(i7, childAt.getMeasuredHeight());
                int baseline2 = childAt.getBaseline();
                if (baseline2 != -1) {
                    i11 = Math.max(i11, baseline2);
                    i12 = Math.max(i12, childAt.getMeasuredHeight() - baseline2);
                }
                i9 = Math.max(i9, childAt.getMeasuredWidth());
                i8 = Math.max(i8, childAt.getMeasuredHeight());
                i10 = View.combineMeasuredStates(i10, childAt.getMeasuredState());
            }
        }
        if (i11 != -1) {
            if (this.measurePaddingFromBaseline) {
                i8 = Math.max(i8, Math.max(i12, getPaddingBottom()) + i11);
            }
            this.baseline = i11;
        }
        if (!this.measurePaddingFromBaseline) {
            i8 = i7 + getPaddingBottom();
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i9, getSuggestedMinimumWidth()), i5, i10), View.resolveSizeAndState(Math.max(i8, getSuggestedMinimumHeight()), i6, i10 << 16));
    }

    public void setMeasurePaddingFromBaseline(boolean z4) {
        this.measurePaddingFromBaseline = z4;
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
