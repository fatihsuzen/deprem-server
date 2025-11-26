package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

abstract class SheetDelegate {
    SheetDelegate() {
    }

    /* access modifiers changed from: package-private */
    public abstract int calculateInnerMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    /* access modifiers changed from: package-private */
    public abstract float calculateSlideOffset(int i5);

    /* access modifiers changed from: package-private */
    public abstract int getCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    /* access modifiers changed from: package-private */
    public abstract int getExpandedOffset();

    /* access modifiers changed from: package-private */
    public abstract int getHiddenOffset();

    /* access modifiers changed from: package-private */
    public abstract int getMaxViewPositionHorizontal();

    /* access modifiers changed from: package-private */
    public abstract int getMinViewPositionHorizontal();

    /* access modifiers changed from: package-private */
    public abstract <V extends View> int getOuterEdge(@NonNull V v5);

    /* access modifiers changed from: package-private */
    public abstract int getParentInnerEdge(@NonNull CoordinatorLayout coordinatorLayout);

    /* access modifiers changed from: package-private */
    public abstract int getSheetEdge();

    /* access modifiers changed from: package-private */
    public abstract boolean isExpandingOutwards(float f5);

    /* access modifiers changed from: package-private */
    public abstract boolean isReleasedCloseToInnerEdge(@NonNull View view);

    /* access modifiers changed from: package-private */
    public abstract boolean isSwipeSignificant(float f5, float f6);

    /* access modifiers changed from: package-private */
    public abstract boolean shouldHide(@NonNull View view, float f5);

    /* access modifiers changed from: package-private */
    public abstract void updateCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i5);

    /* access modifiers changed from: package-private */
    public abstract void updateCoplanarSiblingLayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i5, int i6);
}
