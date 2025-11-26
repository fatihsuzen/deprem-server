package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

final class LeftSheetDelegate extends SheetDelegate {
    final SideSheetBehavior<? extends View> sheetBehavior;

    LeftSheetDelegate(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.sheetBehavior = sideSheetBehavior;
    }

    /* access modifiers changed from: package-private */
    public int calculateInnerMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    /* access modifiers changed from: package-private */
    public float calculateSlideOffset(int i5) {
        float hiddenOffset = (float) getHiddenOffset();
        return (((float) i5) - hiddenOffset) / (((float) getExpandedOffset()) - hiddenOffset);
    }

    /* access modifiers changed from: package-private */
    public int getCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    /* access modifiers changed from: package-private */
    public int getExpandedOffset() {
        return Math.max(0, this.sheetBehavior.getParentInnerEdge() + this.sheetBehavior.getInnerMargin());
    }

    /* access modifiers changed from: package-private */
    public int getHiddenOffset() {
        return (-this.sheetBehavior.getChildWidth()) - this.sheetBehavior.getInnerMargin();
    }

    /* access modifiers changed from: package-private */
    public int getMaxViewPositionHorizontal() {
        return this.sheetBehavior.getInnerMargin();
    }

    /* access modifiers changed from: package-private */
    public int getMinViewPositionHorizontal() {
        return -this.sheetBehavior.getChildWidth();
    }

    /* access modifiers changed from: package-private */
    public <V extends View> int getOuterEdge(@NonNull V v5) {
        return v5.getRight() + this.sheetBehavior.getInnerMargin();
    }

    public int getParentInnerEdge(@NonNull CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    /* access modifiers changed from: package-private */
    public int getSheetEdge() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public boolean isExpandingOutwards(float f5) {
        return f5 > 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean isReleasedCloseToInnerEdge(@NonNull View view) {
        if (view.getRight() < (getExpandedOffset() - getHiddenOffset()) / 2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isSwipeSignificant(float f5, float f6) {
        if (!SheetUtils.isSwipeMostlyHorizontal(f5, f6) || Math.abs(f5) <= ((float) this.sheetBehavior.getSignificantVelocityThreshold())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldHide(@NonNull View view, float f5) {
        if (Math.abs(((float) view.getLeft()) + (f5 * this.sheetBehavior.getHideFriction())) > this.sheetBehavior.getHideThreshold()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void updateCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i5) {
        marginLayoutParams.leftMargin = i5;
    }

    /* access modifiers changed from: package-private */
    public void updateCoplanarSiblingLayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i5, int i6) {
        if (i5 <= this.sheetBehavior.getParentWidth()) {
            marginLayoutParams.leftMargin = i6;
        }
    }
}
