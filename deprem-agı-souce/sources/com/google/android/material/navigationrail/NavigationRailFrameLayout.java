package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationRailFrameLayout extends FrameLayout {
    int paddingTop = 0;
    boolean scrollingEnabled = false;

    public NavigationRailFrameLayout(@NonNull Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        int childCount = getChildCount();
        int i9 = this.paddingTop;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int max = Math.max(i9, childAt.getTop()) + layoutParams.topMargin;
            childAt.layout(childAt.getLeft(), max, childAt.getRight(), childAt.getMeasuredHeight() + max);
            i9 = max + childAt.getMeasuredHeight() + layoutParams.bottomMargin;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        int childCount = getChildCount();
        int i7 = 0;
        View childAt = getChildAt(0);
        int size = View.MeasureSpec.getSize(i6);
        if (childCount > 1) {
            View childAt2 = getChildAt(0);
            measureChild(childAt2, i5, i6);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
            i7 = layoutParams.topMargin + childAt2.getMeasuredHeight() + layoutParams.bottomMargin;
            int i8 = (size - i7) - this.paddingTop;
            childAt = getChildAt(1);
            if (!this.scrollingEnabled) {
                i6 = View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE);
            }
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        measureChild(childAt, i5, i6);
        setMeasuredDimension(getMeasuredWidth(), Math.max(size, this.paddingTop + i7 + childAt.getMeasuredHeight() + layoutParams2.bottomMargin + layoutParams2.topMargin));
    }

    public void setPaddingTop(int i5) {
        this.paddingTop = i5;
    }

    public void setScrollingEnabled(boolean z4) {
        this.scrollingEnabled = z4;
    }
}
