package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    private static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z4) {
        }

        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
            this.isOverflowButton = false;
        }

        LayoutParams(int i5, int i6, boolean z4) {
            super(i5, i6);
            this.isOverflowButton = z4;
        }
    }

    private class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.mOnMenuItemClickListener;
            if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(menuItem)) {
                return false;
            }
            return true;
        }

        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.mMenuBuilderCallback;
            if (callback != null) {
                callback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    static int measureChildForCells(View view, int i5, int i6, int i7, int i8) {
        ActionMenuItemView actionMenuItemView;
        boolean z4;
        int i9;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i7) - i8, View.MeasureSpec.getMode(i7));
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView) view;
        } else {
            actionMenuItemView = null;
        }
        boolean z5 = false;
        if (actionMenuItemView == null || !actionMenuItemView.hasText()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (i6 > 0) {
            i9 = 2;
            if (!z4 || i6 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i6 * i5, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i10 = measuredWidth / i5;
                if (measuredWidth % i5 != 0) {
                    i10++;
                }
                if (!z4 || i10 >= 2) {
                    i9 = i10;
                }
                if (!layoutParams.isOverflowButton && z4) {
                    z5 = true;
                }
                layoutParams.expandable = z5;
                layoutParams.cellsUsed = i9;
                view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i9, 1073741824), makeMeasureSpec);
                return i9;
            }
        }
        i9 = 0;
        z5 = true;
        layoutParams.expandable = z5;
        layoutParams.cellsUsed = i9;
        view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i9, 1073741824), makeMeasureSpec);
        return i9;
    }

    private void onMeasureExactFormat(int i5, int i6) {
        boolean z4;
        long j5;
        boolean z5;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z6;
        int i11;
        boolean z7;
        boolean z8;
        boolean z9;
        int i12;
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, paddingTop, -2);
        int i13 = size - paddingLeft;
        int i14 = this.mMinCellSize;
        int i15 = i13 / i14;
        int i16 = i13 % i14;
        if (i15 == 0) {
            setMeasuredDimension(i13, 0);
            return;
        }
        int i17 = i14 + (i16 / i15);
        int childCount = getChildCount();
        int i18 = 0;
        int i19 = 0;
        boolean z10 = false;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        long j6 = 0;
        while (i19 < childCount) {
            View childAt = getChildAt(i19);
            int i23 = size2;
            if (childAt.getVisibility() == 8) {
                i11 = i17;
            } else {
                boolean z11 = childAt instanceof ActionMenuItemView;
                i20++;
                if (z11) {
                    int i24 = this.mGeneratedItemPadding;
                    z7 = z11;
                    z8 = false;
                    childAt.setPadding(i24, 0, i24, 0);
                } else {
                    z7 = z11;
                    z8 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.expanded = z8;
                layoutParams.extraPixels = z8 ? 1 : 0;
                layoutParams.cellsUsed = z8;
                layoutParams.expandable = z8;
                layoutParams.leftMargin = z8;
                layoutParams.rightMargin = z8;
                if (!z7 || !((ActionMenuItemView) childAt).hasText()) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                layoutParams.preventEdgeOffset = z9;
                if (layoutParams.isOverflowButton) {
                    i12 = 1;
                } else {
                    i12 = i15;
                }
                int measureChildForCells = measureChildForCells(childAt, i17, i12, childMeasureSpec, paddingTop);
                i21 = Math.max(i21, measureChildForCells);
                i11 = i17;
                if (layoutParams.expandable) {
                    i22++;
                }
                if (layoutParams.isOverflowButton) {
                    z10 = true;
                }
                i15 -= measureChildForCells;
                i18 = Math.max(i18, childAt.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    j6 |= (long) (1 << i19);
                }
            }
            i19++;
            size2 = i23;
            i17 = i11;
        }
        int i25 = size2;
        int i26 = i17;
        char c5 = 2;
        if (!z10 || i20 != 2) {
            z4 = false;
        } else {
            z4 = true;
        }
        boolean z12 = false;
        while (true) {
            if (i22 <= 0 || i15 <= 0) {
                char c6 = c5;
                j5 = 1;
            } else {
                int i27 = Integer.MAX_VALUE;
                long j7 = 0;
                char c7 = c5;
                int i28 = 0;
                int i29 = 0;
                j5 = 1;
                while (i29 < childCount) {
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i29).getLayoutParams();
                    boolean z13 = z4;
                    if (layoutParams2.expandable) {
                        int i30 = layoutParams2.cellsUsed;
                        if (i30 < i27) {
                            j7 = 1 << i29;
                            i27 = i30;
                            i28 = 1;
                        } else if (i30 == i27) {
                            j7 |= 1 << i29;
                            i28++;
                        }
                    }
                    i29++;
                    z4 = z13;
                }
                boolean z14 = z4;
                j6 |= j7;
                if (i28 > i15) {
                    break;
                }
                int i31 = i27 + 1;
                int i32 = 0;
                while (i32 < childCount) {
                    View childAt2 = getChildAt(i32);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    long j8 = (long) (1 << i32);
                    if ((j7 & j8) == 0) {
                        if (layoutParams3.cellsUsed == i31) {
                            j6 |= j8;
                        }
                        i10 = i32;
                    } else {
                        if (!z14 || !layoutParams3.preventEdgeOffset) {
                            i10 = i32;
                            z6 = true;
                        } else if (i15 == 1) {
                            int i33 = this.mGeneratedItemPadding;
                            z6 = true;
                            i10 = i32;
                            childAt2.setPadding(i33 + i26, 0, i33, 0);
                        } else {
                            i10 = i32;
                            z6 = true;
                        }
                        layoutParams3.cellsUsed++;
                        layoutParams3.expanded = z6;
                        i15--;
                    }
                    i32 = i10 + 1;
                }
                c5 = c7;
                z4 = z14;
                z12 = true;
            }
        }
        char c62 = c5;
        j5 = 1;
        if (z10 || i20 != 1) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (i15 <= 0 || j6 == 0 || (i15 >= i20 - 1 && !z5 && i21 <= 1)) {
            i7 = 0;
        } else {
            float bitCount = (float) Long.bitCount(j6);
            if (!z5) {
                if ((j6 & j5) != 0) {
                    i7 = 0;
                    if (!((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                        bitCount -= 0.5f;
                    }
                } else {
                    i7 = 0;
                }
                int i34 = childCount - 1;
                if ((j6 & ((long) (1 << i34))) != 0 && !((LayoutParams) getChildAt(i34).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
            } else {
                i7 = 0;
            }
            if (bitCount > 0.0f) {
                i9 = (int) (((float) (i15 * i26)) / bitCount);
            } else {
                i9 = i7;
            }
            boolean z15 = z12;
            for (int i35 = i7; i35 < childCount; i35++) {
                if ((j6 & ((long) (1 << i35))) != 0) {
                    View childAt3 = getChildAt(i35);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.extraPixels = i9;
                        layoutParams4.expanded = true;
                        if (i35 == 0 && !layoutParams4.preventEdgeOffset) {
                            layoutParams4.leftMargin = (-i9) / 2;
                        }
                        z15 = true;
                    } else {
                        if (layoutParams4.isOverflowButton) {
                            layoutParams4.extraPixels = i9;
                            layoutParams4.expanded = true;
                            layoutParams4.rightMargin = (-i9) / 2;
                            z15 = true;
                        } else {
                            if (i35 != 0) {
                                layoutParams4.leftMargin = i9 / 2;
                            }
                            if (i35 != childCount - 1) {
                                layoutParams4.rightMargin = i9 / 2;
                            }
                        }
                    }
                }
            }
            z12 = z15;
        }
        if (z12) {
            for (int i36 = i7; i36 < childCount; i36++) {
                View childAt4 = getChildAt(i36);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.expanded) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.cellsUsed * i26) + layoutParams5.extraPixels, 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode != 1073741824) {
            i8 = i18;
        } else {
            i8 = i25;
        }
        setMeasuredDimension(i13, i8);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.mMenu = menuBuilder;
            menuBuilder.setCallback(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.mPresenter = actionMenuPresenter;
            actionMenuPresenter.setReserveOverflow(true);
            ActionMenuPresenter actionMenuPresenter2 = this.mPresenter;
            MenuPresenter.Callback callback = this.mActionMenuPresenterCallback;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.setCallback(callback);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean hasSupportDividerBeforeChildAt(int i5) {
        boolean z4 = false;
        if (i5 == 0) {
            return false;
        }
        View childAt = getChildAt(i5 - 1);
        View childAt2 = getChildAt(i5);
        if (i5 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z4 = ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        if (i5 <= 0 || !(childAt2 instanceof ActionMenuChildView)) {
            return z4;
        }
        return ((ActionMenuChildView) childAt2).needsDividerBefore() | z4;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter == null || !actionMenuPresenter.hideOverflowMenu()) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter == null || !actionMenuPresenter.isOverflowMenuShowPending()) {
            return false;
        }
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter == null || !actionMenuPresenter.isOverflowMenuShowing()) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        if (!this.mFormatItems) {
            super.onLayout(z4, i5, i6, i7, i8);
            return;
        }
        int childCount = getChildCount();
        int i12 = (i8 - i6) / 2;
        int dividerWidth = getDividerWidth();
        int i13 = i7 - i5;
        int paddingRight = (i13 - getPaddingRight()) - getPaddingLeft();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i16)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i10 = getPaddingLeft() + layoutParams.leftMargin;
                        i11 = i10 + measuredWidth;
                    } else {
                        i11 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i10 = i11 - measuredWidth;
                    }
                    int i17 = i12 - (measuredHeight / 2);
                    childAt.layout(i10, i17, i11, measuredHeight + i17);
                    paddingRight -= measuredWidth;
                    i14 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    hasSupportDividerBeforeChildAt(i16);
                    i15++;
                }
            }
        }
        if (childCount == 1 && i14 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i18 = (i13 / 2) - (measuredWidth2 / 2);
            int i19 = i12 - (measuredHeight2 / 2);
            childAt2.layout(i18, i19, measuredWidth2 + i18, measuredHeight2 + i19);
            return;
        }
        int i20 = i15 - (i14 ^ 1);
        if (i20 > 0) {
            i9 = paddingRight / i20;
        } else {
            i9 = 0;
        }
        int max = Math.max(0, i9);
        if (isLayoutRtl) {
            int width = getWidth() - getPaddingRight();
            for (int i21 = 0; i21 < childCount; i21++) {
                View childAt3 = getChildAt(i21);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                    int i22 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i23 = i12 - (measuredHeight3 / 2);
                    childAt3.layout(i22 - measuredWidth3, i23, i22, measuredHeight3 + i23);
                    width = i22 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i24 = 0; i24 < childCount; i24++) {
            View childAt4 = getChildAt(i24);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int i25 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i26 = i12 - (measuredHeight4 / 2);
                childAt4.layout(i25, i26, i25 + measuredWidth4, measuredHeight4 + i26);
                paddingLeft = i25 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        boolean z4;
        MenuBuilder menuBuilder;
        boolean z5 = this.mFormatItems;
        if (View.MeasureSpec.getMode(i5) == 1073741824) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mFormatItems = z4;
        if (z5 != z4) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i5);
        if (!(!this.mFormatItems || (menuBuilder = this.mMenu) == null || size == this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.mFormatItems || childCount <= 0) {
            for (int i7 = 0; i7 < childCount; i7++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i7).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i5, i6);
            return;
        }
        onMeasureExactFormat(i5, i6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z4) {
        this.mPresenter.setExpandedActionViewsExclusive(z4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z4) {
        this.mReserveOverflow = z4;
    }

    public void setPopupTheme(@StyleRes int i5) {
        if (this.mPopupTheme != i5) {
            this.mPopupTheme = i5;
            if (i5 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter == null || !actionMenuPresenter.showOverflowMenu()) {
            return false;
        }
        return true;
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f5);
        this.mGeneratedItemPadding = (int) (f5 * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        if (layoutParams instanceof LayoutParams) {
            layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
        }
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }
}
