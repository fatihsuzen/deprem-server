package com.google.android.material.navigationrail;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarDividerView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.resources.MaterialResources;

public class NavigationRailView extends NavigationBarView {
    static final int COLLAPSED_MAX_ITEM_COUNT = 7;
    private static final TimeInterpolator CUBIC_BEZIER_INTERPOLATOR = new PathInterpolator(0.38f, 1.21f, 0.22f, 1.0f);
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    private static final int EXPAND_DURATION = 500;
    private static final int FADE_DURATION = 100;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;
    private int collapsedIconGravity;
    private int collapsedItemGravity;
    private int collapsedItemMinHeight;
    private int collapsedItemSpacing;
    private NavigationRailFrameLayout contentContainer;
    private final int contentMarginTop;
    private boolean expanded;
    private int expandedIconGravity;
    private int expandedItemGravity;
    private int expandedItemMinHeight;
    private int expandedItemSpacing;
    private final int headerMarginBottom;
    @Nullable
    private View headerView;
    private final int maxExpandedWidth;
    private final int minExpandedWidth;
    /* access modifiers changed from: private */
    @Nullable
    public Boolean paddingBottomSystemWindowInsets;
    /* access modifiers changed from: private */
    @Nullable
    public Boolean paddingStartSystemWindowInsets;
    /* access modifiers changed from: private */
    @Nullable
    public Boolean paddingTopSystemWindowInsets;
    private final boolean scrollingEnabled;
    private boolean submenuDividersEnabled;

    public NavigationRailView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addContentContainer() {
        View view = (View) getMenuView();
        NavigationRailFrameLayout navigationRailFrameLayout = new NavigationRailFrameLayout(getContext());
        this.contentContainer = navigationRailFrameLayout;
        navigationRailFrameLayout.setPaddingTop(this.contentMarginTop);
        this.contentContainer.setScrollingEnabled(this.scrollingEnabled);
        this.contentContainer.setClipChildren(false);
        this.contentContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.contentContainer.addView(view);
        if (!this.scrollingEnabled) {
            addView(this.contentContainer);
            return;
        }
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(this.contentContainer);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(scrollView);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() {
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.displayCutout());
                NavigationRailView navigationRailView = NavigationRailView.this;
                if (navigationRailView.shouldApplyWindowInsetPadding(navigationRailView.paddingTopSystemWindowInsets)) {
                    relativePadding.top += insets.top;
                }
                NavigationRailView navigationRailView2 = NavigationRailView.this;
                if (navigationRailView2.shouldApplyWindowInsetPadding(navigationRailView2.paddingBottomSystemWindowInsets)) {
                    relativePadding.bottom += insets.bottom;
                }
                NavigationRailView navigationRailView3 = NavigationRailView.this;
                if (navigationRailView3.shouldApplyWindowInsetPadding(navigationRailView3.paddingStartSystemWindowInsets)) {
                    if (ViewUtils.isLayoutRtl(view)) {
                        relativePadding.start += Math.max(insets.right, insets2.right);
                    } else {
                        relativePadding.start += Math.max(insets.left, insets2.left);
                    }
                }
                relativePadding.applyToView(view);
                return windowInsetsCompat;
            }
        });
    }

    private int getMaxChildWidth() {
        int childCount = getNavigationRailMenuView().getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getNavigationRailMenuView().getChildAt(i6);
            if (childAt.getVisibility() != 8 && !(childAt instanceof NavigationBarDividerView)) {
                i5 = Math.max(i5, childAt.getMeasuredWidth());
            }
        }
        return i5;
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private int makeExpandedWidthMeasureSpec(int i5, int i6) {
        int min = Math.min(this.minExpandedWidth, View.MeasureSpec.getSize(i5));
        if (View.MeasureSpec.getMode(i5) == 1073741824) {
            return i5;
        }
        int max = Math.max(i6, min);
        View view = this.headerView;
        if (view != null) {
            max = Math.max(max, view.getMeasuredWidth());
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(getSuggestedMinimumWidth(), Math.min(max, this.maxExpandedWidth)), 1073741824);
    }

    private int makeMinWidthSpec(int i5) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i5) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i5;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i5), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    private void setExpanded(boolean z4) {
        if (this.expanded != z4) {
            startTransitionAnimation();
            this.expanded = z4;
            int i5 = this.collapsedIconGravity;
            int i6 = this.collapsedItemSpacing;
            int i7 = this.collapsedItemMinHeight;
            int i8 = this.collapsedItemGravity;
            if (z4) {
                i5 = this.expandedIconGravity;
                i6 = this.expandedItemSpacing;
                i7 = this.expandedItemMinHeight;
                i8 = this.expandedItemGravity;
            }
            getNavigationRailMenuView().setItemGravity(i8);
            super.setItemIconGravity(i5);
            getNavigationRailMenuView().setItemSpacing(i6);
            getNavigationRailMenuView().setItemMinimumHeight(i7);
            getNavigationRailMenuView().setExpanded(z4);
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldApplyWindowInsetPadding(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return getFitsSystemWindows();
    }

    private void startTransitionAnimation() {
        if (isLaidOut()) {
            Transition interpolator = new ChangeBounds().setDuration(500).setInterpolator(CUBIC_BEZIER_INTERPOLATOR);
            Transition duration = new Fade().setDuration(100);
            Transition duration2 = new Fade().setDuration(100);
            LabelMoveTransition labelMoveTransition = new LabelMoveTransition();
            Transition duration3 = new Fade().setDuration(100);
            int childCount = getNavigationRailMenuView().getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getNavigationRailMenuView().getChildAt(i5);
                if (childAt instanceof NavigationBarItemView) {
                    NavigationBarItemView navigationBarItemView = (NavigationBarItemView) childAt;
                    interpolator.excludeTarget((View) navigationBarItemView.getLabelGroup(), true);
                    interpolator.excludeTarget((View) navigationBarItemView.getExpandedLabelGroup(), true);
                    if (this.expanded) {
                        duration2.addTarget((View) navigationBarItemView.getExpandedLabelGroup());
                        duration.addTarget((View) navigationBarItemView.getLabelGroup());
                    } else {
                        duration2.addTarget((View) navigationBarItemView.getLabelGroup());
                        duration.addTarget((View) navigationBarItemView.getExpandedLabelGroup());
                    }
                    labelMoveTransition.addTarget((View) navigationBarItemView.getExpandedLabelGroup());
                }
                duration3.addTarget(childAt);
            }
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.setOrdering(0);
            transitionSet.addTransition(interpolator).addTransition(duration).addTransition(labelMoveTransition);
            if (!this.expanded) {
                transitionSet.addTransition(duration3);
            }
            TransitionSet transitionSet2 = new TransitionSet();
            transitionSet2.setOrdering(0);
            transitionSet2.addTransition(duration2);
            if (this.expanded) {
                transitionSet2.addTransition(duration3);
            }
            TransitionSet transitionSet3 = new TransitionSet();
            transitionSet3.setOrdering(1);
            transitionSet3.addTransition(transitionSet2).addTransition(transitionSet);
            TransitionManager.beginDelayedTransition((ViewGroup) getParent(), transitionSet3);
        }
    }

    public void addHeaderView(@LayoutRes int i5) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i5, this, false));
    }

    public void collapse() {
        if (this.expanded) {
            setExpanded(false);
            announceForAccessibility(getResources().getString(R.string.nav_rail_collapsed_a11y_label));
        }
    }

    public void expand() {
        if (!this.expanded) {
            setExpanded(true);
            announceForAccessibility(getResources().getString(R.string.nav_rail_expanded_a11y_label));
        }
    }

    public int getCollapsedItemMinimumHeight() {
        return this.collapsedItemMinHeight;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getCollapsedMaxItemCount() {
        return 7;
    }

    public int getExpandedItemMinimumHeight() {
        return this.expandedItemMinHeight;
    }

    @Nullable
    public View getHeaderView() {
        return this.headerView;
    }

    public int getItemGravity() {
        return getNavigationRailMenuView().getItemGravity();
    }

    public int getItemIconGravity() {
        return getNavigationRailMenuView().getItemIconGravity();
    }

    public int getItemMinimumHeight() {
        return getNavigationRailMenuView().getItemMinimumHeight();
    }

    public int getItemSpacing() {
        return getNavigationRailMenuView().getItemSpacing();
    }

    public int getMaxItemCount() {
        return Integer.MAX_VALUE;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public boolean getSubmenuDividersEnabled() {
        return this.submenuDividersEnabled;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    /* access modifiers changed from: protected */
    public boolean isSubMenuSupported() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int makeMinWidthSpec = makeMinWidthSpec(i5);
        if (this.expanded) {
            measureChild(getNavigationRailMenuView(), i5, i6);
            View view = this.headerView;
            if (view != null) {
                measureChild(view, i5, i6);
            }
            makeMinWidthSpec = makeExpandedWidthMeasureSpec(i5, getMaxChildWidth());
            if (getItemActiveIndicatorExpandedWidth() == -1) {
                getNavigationRailMenuView().updateActiveIndicator(View.MeasureSpec.getSize(makeMinWidthSpec));
            }
        }
        super.onMeasure(makeMinWidthSpec, i6);
        if (this.contentContainer.getMeasuredHeight() < getMeasuredHeight()) {
            measureChild(this.contentContainer, makeMinWidthSpec, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void removeHeaderView() {
        View view = this.headerView;
        if (view != null) {
            this.contentContainer.removeView(view);
            this.headerView = null;
        }
    }

    public void setCollapsedItemMinimumHeight(@Px int i5) {
        this.collapsedItemMinHeight = i5;
        if (!this.expanded) {
            ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i5);
        }
    }

    public void setCollapsedItemSpacing(@Px int i5) {
        this.collapsedItemSpacing = i5;
        if (!this.expanded) {
            getNavigationRailMenuView().setItemSpacing(i5);
        }
    }

    public void setExpandedItemMinimumHeight(@Px int i5) {
        this.expandedItemMinHeight = i5;
        if (this.expanded) {
            ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i5);
        }
    }

    public void setItemGravity(int i5) {
        this.collapsedItemGravity = i5;
        this.expandedItemGravity = i5;
        super.setItemGravity(i5);
    }

    public void setItemIconGravity(int i5) {
        this.collapsedIconGravity = i5;
        this.expandedIconGravity = i5;
        super.setItemIconGravity(i5);
    }

    public void setItemMinimumHeight(@Px int i5) {
        this.collapsedItemMinHeight = i5;
        this.expandedItemMinHeight = i5;
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i5);
    }

    public void setItemSpacing(@Px int i5) {
        this.collapsedItemSpacing = i5;
        this.expandedItemSpacing = i5;
        getNavigationRailMenuView().setItemSpacing(i5);
    }

    public void setMenuGravity(int i5) {
        getNavigationRailMenuView().setMenuGravity(i5);
    }

    public void setSubmenuDividersEnabled(boolean z4) {
        if (this.submenuDividersEnabled != z4) {
            this.submenuDividersEnabled = z4;
            getNavigationRailMenuView().setSubmenuDividersEnabled(z4);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldAddMenuView() {
        return true;
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public void addHeaderView(@NonNull View view) {
        removeHeaderView();
        this.headerView = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.bottomMargin = this.headerMarginBottom;
        this.contentContainer.addView(view, 0, layoutParams);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationRailMenuView createNavigationBarMenuView(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.paddingStartSystemWindowInsets = null;
        this.expanded = false;
        this.collapsedItemMinHeight = -1;
        this.collapsedIconGravity = 0;
        this.collapsedItemGravity = 49;
        Context context2 = getContext();
        this.expandedItemSpacing = getContext().getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_expanded_item_spacing);
        this.expandedItemGravity = NavigationBarView.ITEM_GRAVITY_START_CENTER;
        this.expandedIconGravity = 1;
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.NavigationRailView, i5, i6, new int[0]);
        int i7 = R.styleable.NavigationRailView_contentMarginTop;
        Resources resources = getResources();
        int i8 = R.dimen.mtrl_navigation_rail_margin;
        this.contentMarginTop = obtainTintedStyledAttributes.getDimensionPixelSize(i7, resources.getDimensionPixelSize(i8));
        this.headerMarginBottom = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_headerMarginBottom, getResources().getDimensionPixelSize(i8));
        this.scrollingEnabled = obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_scrollingEnabled, false);
        setSubmenuDividersEnabled(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_submenuDividersEnabled, false));
        addContentContainer();
        int resourceId = obtainTintedStyledAttributes.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (resourceId != 0) {
            addHeaderView(resourceId);
        }
        setMenuGravity(obtainTintedStyledAttributes.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        int i9 = R.styleable.NavigationRailView_itemMinHeight;
        int dimensionPixelSize = obtainTintedStyledAttributes.getDimensionPixelSize(i9, -1);
        int dimensionPixelSize2 = obtainTintedStyledAttributes.getDimensionPixelSize(i9, -1);
        int i10 = R.styleable.NavigationRailView_collapsedItemMinHeight;
        dimensionPixelSize = obtainTintedStyledAttributes.hasValue(i10) ? obtainTintedStyledAttributes.getDimensionPixelSize(i10, -1) : dimensionPixelSize;
        int i11 = R.styleable.NavigationRailView_expandedItemMinHeight;
        dimensionPixelSize2 = obtainTintedStyledAttributes.hasValue(i11) ? obtainTintedStyledAttributes.getDimensionPixelSize(i11, -1) : dimensionPixelSize2;
        setCollapsedItemMinimumHeight(dimensionPixelSize);
        setExpandedItemMinimumHeight(dimensionPixelSize2);
        this.minExpandedWidth = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_expandedMinWidth, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_min_expanded_width));
        this.maxExpandedWidth = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_expandedMaxWidth, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_max_expanded_width));
        int i12 = R.styleable.NavigationRailView_paddingTopSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i12)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i12, false));
        }
        int i13 = R.styleable.NavigationRailView_paddingBottomSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i13)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i13, false));
        }
        int i14 = R.styleable.NavigationRailView_paddingStartSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i14)) {
            this.paddingStartSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i14, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float lerp = AnimationUtils.lerp(0.0f, 1.0f, 0.3f, 1.0f, MaterialResources.getFontScale(context2) - 1.0f);
        setItemPaddingTop(Math.round((float) AnimationUtils.lerp(getItemPaddingTop(), dimensionPixelOffset, lerp)));
        setItemPaddingBottom(Math.round((float) AnimationUtils.lerp(getItemPaddingBottom(), dimensionPixelOffset2, lerp)));
        setCollapsedItemSpacing(obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_itemSpacing, 0));
        setExpanded(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_expanded, false));
        obtainTintedStyledAttributes.recycle();
        applyWindowInsets();
    }
}
