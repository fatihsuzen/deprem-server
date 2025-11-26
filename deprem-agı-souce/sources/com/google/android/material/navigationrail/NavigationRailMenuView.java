package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationRailMenuView extends NavigationBarMenuView {
    @Px
    private int itemMinimumHeight = -1;
    @Px
    private int itemSpacing = 0;
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams2;
        layoutParams2.gravity = 49;
        setLayoutParams(layoutParams2);
        setItemActiveIndicatorResizeable(true);
    }

    private int makeSharedHeightSpec(int i5, int i6, int i7) {
        int max = i6 / Math.max(1, i7);
        int i8 = this.itemMinimumHeight;
        if (i8 == -1) {
            i8 = View.MeasureSpec.getSize(i5);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(i8, max), 0);
    }

    private int measureChildHeight(View view, int i5, int i6) {
        view.measure(i5, i6);
        if (view.getVisibility() != 8) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int measureSharedChildHeights(int i5, int i6, int i7, View view) {
        int i8;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 0);
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (!(childAt instanceof NavigationBarItemView)) {
                int measureChildHeight = measureChildHeight(childAt, i5, makeMeasureSpec);
                i6 -= measureChildHeight;
                i9 += measureChildHeight;
            }
        }
        int max = Math.max(i6, 0);
        if (view == null) {
            i8 = makeSharedHeightSpec(i5, max, i7);
        } else {
            i8 = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() == 0) {
                i11++;
            }
            if ((childAt2 instanceof NavigationBarItemView) && childAt2 != view) {
                i9 += measureChildHeight(childAt2, i5, i8);
            }
        }
        return i9 + (Math.max(0, i11 - 1) * this.itemSpacing);
    }

    private int measureShiftingChildHeights(int i5, int i6, int i7) {
        int i8;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i8 = measureChildHeight(childAt, i5, makeSharedHeightSpec(i5, i6, i7));
            i6 -= i8;
            i7--;
        } else {
            i8 = 0;
        }
        return i8 + measureSharedChildHeights(i5, i6, i7, childAt);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    @Px
    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    @Px
    public int getItemSpacing() {
        return this.itemSpacing;
    }

    /* access modifiers changed from: package-private */
    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9;
        int childCount = getChildCount();
        int i10 = i7 - i5;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                i12 += childAt.getMeasuredHeight();
                i11++;
            }
        }
        if (i11 <= 1) {
            i9 = 0;
        } else {
            i9 = Math.max(0, Math.min((getMeasuredHeight() - i12) / (i11 - 1), this.itemSpacing));
        }
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8) {
                int measuredHeight = childAt2.getMeasuredHeight();
                childAt2.layout(0, i14, i10, measuredHeight + i14);
                i14 += measuredHeight + i9;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7;
        int size = View.MeasureSpec.getSize(i6);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        if (currentVisibleContentItemCount <= 1 || !isShifting(getLabelVisibilityMode(), currentVisibleContentItemCount)) {
            i7 = measureSharedChildHeights(i5, size, currentVisibleContentItemCount, (View) null);
        } else {
            i7 = measureShiftingChildHeights(i5, size, currentVisibleContentItemCount);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i5), View.resolveSizeAndState(i7, i6, 0));
    }

    public void setItemMinimumHeight(@Px int i5) {
        if (this.itemMinimumHeight != i5) {
            this.itemMinimumHeight = i5;
            requestLayout();
        }
    }

    public void setItemSpacing(@Px int i5) {
        if (this.itemSpacing != i5) {
            this.itemSpacing = i5;
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void setMenuGravity(int i5) {
        FrameLayout.LayoutParams layoutParams2 = this.layoutParams;
        if (layoutParams2.gravity != i5) {
            layoutParams2.gravity = i5;
            setLayoutParams(layoutParams2);
        }
    }
}
