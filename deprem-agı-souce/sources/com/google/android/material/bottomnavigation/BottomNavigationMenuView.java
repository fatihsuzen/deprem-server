package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private final List<Integer> tempChildWidths = new ArrayList();

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int childCount = getChildCount();
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                if (getLayoutDirection() == 1) {
                    int i13 = i9 - i11;
                    childAt.layout(i13 - childAt.getMeasuredWidth(), 0, i13, i10);
                } else {
                    childAt.layout(i11, 0, childAt.getMeasuredWidth() + i11, i10);
                }
                i11 += childAt.getMeasuredWidth();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int size = View.MeasureSpec.getSize(i5);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        int childCount = getChildCount();
        this.tempChildWidths.clear();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6), Integer.MIN_VALUE);
        int i12 = 1;
        int i13 = 0;
        if (getItemIconGravity() == 0) {
            if (!isShifting(getLabelVisibilityMode(), currentVisibleContentItemCount) || !isItemHorizontalTranslationEnabled()) {
                if (currentVisibleContentItemCount != 0) {
                    i12 = currentVisibleContentItemCount;
                }
                int min = Math.min(size / i12, this.activeItemMaxWidth);
                int i14 = size - (currentVisibleContentItemCount * min);
                for (int i15 = 0; i15 < childCount; i15++) {
                    if (getChildAt(i15).getVisibility() == 8) {
                        i9 = 0;
                    } else if (i14 > 0) {
                        i9 = min + 1;
                        i14--;
                    } else {
                        i9 = min;
                    }
                    this.tempChildWidths.add(Integer.valueOf(i9));
                }
            } else {
                View childAt = getChildAt(getSelectedItemPosition());
                int i16 = this.activeItemMinWidth;
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                    i16 = Math.max(i16, childAt.getMeasuredWidth());
                }
                if (childAt.getVisibility() != 8) {
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                int i17 = currentVisibleContentItemCount - i10;
                int min2 = Math.min(size - (this.inactiveItemMinWidth * i17), Math.min(i16, this.activeItemMaxWidth));
                int i18 = size - min2;
                if (i17 != 0) {
                    i12 = i17;
                }
                int min3 = Math.min(i18 / i12, this.inactiveItemMaxWidth);
                int i19 = i18 - (i17 * min3);
                for (int i20 = 0; i20 < childCount; i20++) {
                    if (getChildAt(i20).getVisibility() != 8) {
                        if (i20 == getSelectedItemPosition()) {
                            i11 = min2;
                        } else {
                            i11 = min3;
                        }
                        if (i19 > 0) {
                            i11++;
                            i19--;
                        }
                    } else {
                        i11 = 0;
                    }
                    this.tempChildWidths.add(Integer.valueOf(i11));
                }
            }
            i7 = 0;
            i8 = 0;
            while (i13 < childCount) {
                View childAt2 = getChildAt(i13);
                if (childAt2.getVisibility() != 8) {
                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths.get(i13).intValue(), 1073741824), makeMeasureSpec);
                    childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                    i7 += childAt2.getMeasuredWidth();
                    i8 = Math.max(i8, childAt2.getMeasuredHeight());
                }
                i13++;
            }
        } else {
            if (currentVisibleContentItemCount == 0) {
                currentVisibleContentItemCount = 1;
            }
            float f5 = (float) size;
            float f6 = (float) currentVisibleContentItemCount;
            int round = Math.round((Math.min(((float) (currentVisibleContentItemCount + 3)) / 10.0f, 0.9f) * f5) / f6);
            int round2 = Math.round(f5 / f6);
            int i21 = 0;
            int i22 = 0;
            while (i13 < childCount) {
                View childAt3 = getChildAt(i13);
                if (childAt3.getVisibility() != 8) {
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(round2, Integer.MIN_VALUE), makeMeasureSpec);
                    if (childAt3.getMeasuredWidth() < round) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(round, 1073741824), makeMeasureSpec);
                    }
                    i21 += childAt3.getMeasuredWidth();
                    i22 = Math.max(i22, childAt3.getMeasuredHeight());
                }
                i13++;
            }
            i7 = i21;
            i8 = i22;
        }
        setMeasuredDimension(i7, Math.max(i8, getSuggestedMinimumHeight()));
    }

    public void setItemHorizontalTranslationEnabled(boolean z4) {
        this.itemHorizontalTranslationEnabled = z4;
    }
}
