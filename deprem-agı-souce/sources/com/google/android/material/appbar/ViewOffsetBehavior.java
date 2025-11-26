package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset = 0;
    private int tempTopBottomOffset = 0;
    private ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
    }

    public int getLeftAndRightOffset() {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            return viewOffsetHelper2.getLeftAndRightOffset();
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            return viewOffsetHelper2.getTopAndBottomOffset();
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 == null || !viewOffsetHelper2.isHorizontalOffsetEnabled()) {
            return false;
        }
        return true;
    }

    public boolean isVerticalOffsetEnabled() {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 == null || !viewOffsetHelper2.isVerticalOffsetEnabled()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i5) {
        coordinatorLayout.onLayoutChild(v5, i5);
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i5) {
        layoutChild(coordinatorLayout, v5, i5);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new ViewOffsetHelper(v5);
        }
        this.viewOffsetHelper.onViewLayout();
        this.viewOffsetHelper.applyOffsets();
        int i6 = this.tempTopBottomOffset;
        if (i6 != 0) {
            this.viewOffsetHelper.setTopAndBottomOffset(i6);
            this.tempTopBottomOffset = 0;
        }
        int i7 = this.tempLeftRightOffset;
        if (i7 == 0) {
            return true;
        }
        this.viewOffsetHelper.setLeftAndRightOffset(i7);
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z4) {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            viewOffsetHelper2.setHorizontalOffsetEnabled(z4);
        }
    }

    public boolean setLeftAndRightOffset(int i5) {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            return viewOffsetHelper2.setLeftAndRightOffset(i5);
        }
        this.tempLeftRightOffset = i5;
        return false;
    }

    public boolean setTopAndBottomOffset(int i5) {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            return viewOffsetHelper2.setTopAndBottomOffset(i5);
        }
        this.tempTopBottomOffset = i5;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z4) {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            viewOffsetHelper2.setVerticalOffsetEnabled(z4);
        }
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
