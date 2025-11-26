package com.google.android.material.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEFAULT_COLLAPSED_MAX_COUNT = 7;
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int NO_PADDING = -1;
    private static final int NO_SELECTED_ITEM = -1;
    @NonNull
    private final SparseArray<BadgeDrawable> badgeDrawables = new SparseArray<>();
    @Nullable
    private NavigationBarMenuItemView[] buttons;
    private MenuItem checkedItem = null;
    private int collapsedMaxItemCount = 7;
    private boolean dividersEnabled = false;
    private boolean expanded;
    @StyleRes
    private int horizontalItemTextAppearanceActive;
    @StyleRes
    private int horizontalItemTextAppearanceInactive;
    private int iconLabelHorizontalSpacing = -1;
    private ColorStateList itemActiveIndicatorColor;
    private boolean itemActiveIndicatorEnabled;
    private int itemActiveIndicatorExpandedHeight;
    private int itemActiveIndicatorExpandedMarginHorizontal;
    private final Rect itemActiveIndicatorExpandedPadding = new Rect();
    private int itemActiveIndicatorExpandedWidth;
    private int itemActiveIndicatorHeight;
    private int itemActiveIndicatorLabelPadding = -1;
    private int itemActiveIndicatorMarginHorizontal;
    private boolean itemActiveIndicatorResizeable = false;
    private ShapeAppearanceModel itemActiveIndicatorShapeAppearance;
    private int itemActiveIndicatorWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    private int itemGravity = 49;
    private int itemIconGravity;
    @Dimension
    private int itemIconSize;
    @Nullable
    private ColorStateList itemIconTint;
    private int itemPaddingBottom = -1;
    private int itemPaddingTop = -1;
    @Nullable
    private Pools.Pool<NavigationBarItemView> itemPool;
    private int itemPoolSize = 0;
    @Nullable
    private ColorStateList itemRippleColor;
    @StyleRes
    private int itemTextAppearanceActive;
    private boolean itemTextAppearanceActiveBoldEnabled;
    @StyleRes
    private int itemTextAppearanceInactive;
    @Nullable
    private final ColorStateList itemTextColorDefault = createDefaultColorStateList(16842808);
    private ColorStateList itemTextColorFromUser;
    private int labelMaxLines = 1;
    private int labelVisibilityMode;
    private boolean measurePaddingFromLabelBaseline;
    /* access modifiers changed from: private */
    public NavigationBarMenuBuilder menu;
    @NonNull
    private final View.OnClickListener onClickListener;
    @NonNull
    private final SparseArray<View.OnTouchListener> onTouchListeners = new SparseArray<>();
    /* access modifiers changed from: private */
    public NavigationBarPresenter presenter;
    private boolean scaleLabelWithFont;
    private int selectedItemId = -1;
    private int selectedItemPosition = -1;
    @Nullable
    private final TransitionSet set;

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        if (isInEditMode()) {
            this.set = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.set = autoTransition;
            autoTransition.setOrdering(0);
            autoTransition.excludeTarget((Class<?>) TextView.class, true);
            autoTransition.setDuration((long) MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationMedium4, getResources().getInteger(R.integer.material_motion_duration_long_1)));
            autoTransition.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            autoTransition.addTransition(new TextScale());
        }
        this.onClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
                boolean performItemAction = NavigationBarMenuView.this.menu.performItemAction(itemData, NavigationBarMenuView.this.presenter, 0);
                if (itemData != null && itemData.isCheckable()) {
                    if (!performItemAction || itemData.isChecked()) {
                        NavigationBarMenuView.this.setCheckedItem(itemData);
                    }
                }
            }
        };
        setImportantForAccessibility(1);
    }

    @Nullable
    private Drawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance == null || this.itemActiveIndicatorColor == null) {
            return null;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
        materialShapeDrawable.setFillColor(this.itemActiveIndicatorColor);
        return materialShapeDrawable;
    }

    private NavigationBarItemView createMenuItem(int i5, MenuItemImpl menuItemImpl, boolean z4, boolean z5) {
        this.presenter.setUpdateSuspended(true);
        menuItemImpl.setCheckable(true);
        this.presenter.setUpdateSuspended(false);
        NavigationBarItemView newItem = getNewItem();
        newItem.setShifting(z4);
        newItem.setLabelMaxLines(this.labelMaxLines);
        newItem.setIconTintList(this.itemIconTint);
        newItem.setIconSize(this.itemIconSize);
        newItem.setTextColor(this.itemTextColorDefault);
        newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
        newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
        newItem.setHorizontalTextAppearanceInactive(this.horizontalItemTextAppearanceInactive);
        newItem.setHorizontalTextAppearanceActive(this.horizontalItemTextAppearanceActive);
        newItem.setTextAppearanceActiveBoldEnabled(this.itemTextAppearanceActiveBoldEnabled);
        newItem.setTextColor(this.itemTextColorFromUser);
        int i6 = this.itemPaddingTop;
        if (i6 != -1) {
            newItem.setItemPaddingTop(i6);
        }
        int i7 = this.itemPaddingBottom;
        if (i7 != -1) {
            newItem.setItemPaddingBottom(i7);
        }
        newItem.setMeasureBottomPaddingFromLabelBaseline(this.measurePaddingFromLabelBaseline);
        newItem.setLabelFontScalingEnabled(this.scaleLabelWithFont);
        int i8 = this.itemActiveIndicatorLabelPadding;
        if (i8 != -1) {
            newItem.setActiveIndicatorLabelPadding(i8);
        }
        int i9 = this.iconLabelHorizontalSpacing;
        if (i9 != -1) {
            newItem.setIconLabelHorizontalSpacing(i9);
        }
        newItem.setActiveIndicatorWidth(this.itemActiveIndicatorWidth);
        newItem.setActiveIndicatorHeight(this.itemActiveIndicatorHeight);
        newItem.setActiveIndicatorExpandedWidth(this.itemActiveIndicatorExpandedWidth);
        newItem.setActiveIndicatorExpandedHeight(this.itemActiveIndicatorExpandedHeight);
        newItem.setActiveIndicatorMarginHorizontal(this.itemActiveIndicatorMarginHorizontal);
        newItem.setItemGravity(this.itemGravity);
        newItem.setActiveIndicatorExpandedPadding(this.itemActiveIndicatorExpandedPadding);
        newItem.setActiveIndicatorExpandedMarginHorizontal(this.itemActiveIndicatorExpandedMarginHorizontal);
        newItem.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        newItem.setActiveIndicatorResizeable(this.itemActiveIndicatorResizeable);
        newItem.setActiveIndicatorEnabled(this.itemActiveIndicatorEnabled);
        Drawable drawable = this.itemBackground;
        if (drawable != null) {
            newItem.setItemBackground(drawable);
        } else {
            newItem.setItemBackground(this.itemBackgroundRes);
        }
        newItem.setItemRippleColor(this.itemRippleColor);
        newItem.setLabelVisibilityMode(this.labelVisibilityMode);
        newItem.setItemIconGravity(this.itemIconGravity);
        newItem.setOnlyShowWhenExpanded(z5);
        newItem.setExpanded(this.expanded);
        newItem.initialize(menuItemImpl, 0);
        newItem.setItemPosition(i5);
        int itemId = menuItemImpl.getItemId();
        newItem.setOnTouchListener(this.onTouchListeners.get(itemId));
        newItem.setOnClickListener(this.onClickListener);
        int i10 = this.selectedItemId;
        if (i10 != 0 && itemId == i10) {
            this.selectedItemPosition = i5;
        }
        setBadgeIfNeeded(newItem);
        return newItem;
    }

    private int getCollapsedVisibleItemCount() {
        return Math.min(this.collapsedMaxItemCount, this.menu.getVisibleMainContentItemCount());
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemView;
        Pools.Pool<NavigationBarItemView> pool = this.itemPool;
        if (pool != null) {
            navigationBarItemView = pool.acquire();
        } else {
            navigationBarItemView = null;
        }
        if (navigationBarItemView == null) {
            return createNavigationBarItemView(getContext());
        }
        return navigationBarItemView;
    }

    private boolean isMenuStructureSame() {
        NavigationBarMenuBuilder navigationBarMenuBuilder;
        boolean z4;
        if (this.buttons == null || (navigationBarMenuBuilder = this.menu) == null || navigationBarMenuBuilder.size() != this.buttons.length) {
            return false;
        }
        int i5 = 0;
        while (true) {
            boolean z5 = true;
            if (i5 >= this.buttons.length) {
                return true;
            }
            if ((this.menu.getItemAt(i5) instanceof DividerMenuItem) && !(this.buttons[i5] instanceof NavigationBarDividerView)) {
                return false;
            }
            if (!this.menu.getItemAt(i5).hasSubMenu() || (this.buttons[i5] instanceof NavigationBarSubheaderView)) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (this.menu.getItemAt(i5).hasSubMenu() || (this.buttons[i5] instanceof NavigationBarItemView)) {
                z5 = false;
            }
            if ((this.menu.getItemAt(i5) instanceof DividerMenuItem) || (!z4 && !z5)) {
                i5++;
            }
        }
        return false;
    }

    private boolean isValidId(int i5) {
        return i5 != -1;
    }

    private void releaseItemPool() {
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null && this.itemPool != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    NavigationBarItemView navigationBarItemView = (NavigationBarItemView) navigationBarMenuItemView;
                    this.itemPool.release(navigationBarItemView);
                    navigationBarItemView.clear();
                }
            }
        }
    }

    private void removeUnusedBadges() {
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < this.menu.size(); i5++) {
            hashSet.add(Integer.valueOf(this.menu.getItemAt(i5).getItemId()));
        }
        for (int i6 = 0; i6 < this.badgeDrawables.size(); i6++) {
            int keyAt = this.badgeDrawables.keyAt(i6);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.badgeDrawables.delete(keyAt);
            }
        }
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (isValidId(id) && (badgeDrawable = this.badgeDrawables.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    private void validateMenuItemId(int i5) {
        if (!isValidId(i5)) {
            throw new IllegalArgumentException(i5 + " is not a valid view id");
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        NavigationBarDividerView navigationBarDividerView;
        boolean z4;
        removeAllViews();
        releaseItemPool();
        this.presenter.setUpdateSuspended(true);
        this.menu.refreshItems();
        this.presenter.setUpdateSuspended(false);
        int contentItemCount = this.menu.getContentItemCount();
        if (contentItemCount == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            this.itemPool = null;
            return;
        }
        if (this.itemPool == null || this.itemPoolSize != contentItemCount) {
            this.itemPoolSize = contentItemCount;
            this.itemPool = new Pools.SynchronizedPool(contentItemCount);
        }
        removeUnusedBadges();
        int size = this.menu.size();
        this.buttons = new NavigationBarMenuItemView[size];
        boolean isShifting = isShifting(this.labelVisibilityMode, getCurrentVisibleContentItemCount());
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem itemAt = this.menu.getItemAt(i7);
            boolean z5 = itemAt instanceof DividerMenuItem;
            if (z5) {
                NavigationBarDividerView navigationBarDividerView2 = new NavigationBarDividerView(getContext());
                navigationBarDividerView2.setOnlyShowWhenExpanded(true);
                navigationBarDividerView2.setDividersEnabled(this.dividersEnabled);
                navigationBarDividerView = navigationBarDividerView2;
            } else if (itemAt.hasSubMenu()) {
                if (i5 <= 0) {
                    NavigationBarSubheaderView navigationBarSubheaderView = new NavigationBarSubheaderView(getContext());
                    int i8 = this.horizontalItemTextAppearanceActive;
                    if (i8 == 0) {
                        i8 = this.itemTextAppearanceActive;
                    }
                    navigationBarSubheaderView.setTextAppearance(i8);
                    navigationBarSubheaderView.setTextColor(this.itemTextColorFromUser);
                    navigationBarSubheaderView.setOnlyShowWhenExpanded(true);
                    navigationBarSubheaderView.initialize((MenuItemImpl) itemAt, 0);
                    i5 = itemAt.getSubMenu().size();
                    navigationBarDividerView = navigationBarSubheaderView;
                } else {
                    throw new IllegalArgumentException("Only one layer of submenu is supported; a submenu inside a submenu is not supported by the Navigation Bar.");
                }
            } else if (i5 > 0) {
                i5--;
                navigationBarDividerView = createMenuItem(i7, (MenuItemImpl) itemAt, isShifting, true);
            } else {
                MenuItemImpl menuItemImpl = (MenuItemImpl) itemAt;
                if (i6 >= this.collapsedMaxItemCount) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                i6++;
                navigationBarDividerView = createMenuItem(i7, menuItemImpl, isShifting, z4);
            }
            if (!z5 && itemAt.isCheckable() && this.selectedItemPosition == -1) {
                this.selectedItemPosition = i7;
            }
            this.buttons[i7] = navigationBarDividerView;
            addView(navigationBarDividerView);
        }
        int min = Math.min(size - 1, this.selectedItemPosition);
        this.selectedItemPosition = min;
        setCheckedItem(this.buttons[min].getItemData());
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i5) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i5, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i6 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i6, defaultColor});
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract NavigationBarItemView createNavigationBarItemView(@NonNull Context context);

    @Nullable
    public NavigationBarItemView findItemView(int i5) {
        validateMenuItemId(i5);
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr == null) {
            return null;
        }
        for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
            if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                NavigationBarItemView navigationBarItemView = (NavigationBarItemView) navigationBarMenuItemView;
                if (navigationBarItemView.getId() == i5) {
                    return navigationBarItemView;
                }
            }
        }
        return null;
    }

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.itemActiveIndicatorLabelPadding;
    }

    @Nullable
    public BadgeDrawable getBadge(int i5) {
        return this.badgeDrawables.get(i5);
    }

    /* access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    public int getCurrentVisibleContentItemCount() {
        if (this.expanded) {
            return this.menu.getVisibleContentItemCount();
        }
        return getCollapsedVisibleItemCount();
    }

    @StyleRes
    public int getHorizontalItemTextAppearanceActive() {
        return this.horizontalItemTextAppearanceActive;
    }

    @StyleRes
    public int getHorizontalItemTextAppearanceInactive() {
        return this.horizontalItemTextAppearanceInactive;
    }

    @Px
    public int getIconLabelHorizontalSpacing() {
        return this.iconLabelHorizontalSpacing;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.itemActiveIndicatorColor;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.itemActiveIndicatorEnabled;
    }

    @Px
    public int getItemActiveIndicatorExpandedHeight() {
        return this.itemActiveIndicatorExpandedHeight;
    }

    @Px
    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.itemActiveIndicatorExpandedMarginHorizontal;
    }

    @Px
    public int getItemActiveIndicatorExpandedWidth() {
        return this.itemActiveIndicatorExpandedWidth;
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.itemActiveIndicatorHeight;
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.itemActiveIndicatorMarginHorizontal;
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null && navigationBarMenuItemViewArr.length > 0) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    return ((NavigationBarItemView) navigationBarMenuItemView).getBackground();
                }
            }
        }
        return this.itemBackground;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    public int getItemGravity() {
        return this.itemGravity;
    }

    public int getItemIconGravity() {
        return this.itemIconGravity;
    }

    @Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    @Px
    public int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    @Px
    public int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelMaxLines() {
        return this.labelMaxLines;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public NavigationBarMenuBuilder getMenu() {
        return this.menu;
    }

    /* access modifiers changed from: package-private */
    public BadgeDrawable getOrCreateBadge(int i5) {
        validateMenuItemId(i5);
        BadgeDrawable badgeDrawable = this.badgeDrawables.get(i5);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.create(getContext());
            this.badgeDrawables.put(i5, badgeDrawable);
        }
        NavigationBarItemView findItemView = findItemView(i5);
        if (findItemView != null) {
            findItemView.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.scaleLabelWithFont;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    /* access modifiers changed from: protected */
    public int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(@NonNull MenuBuilder menuBuilder) {
        this.menu = new NavigationBarMenuBuilder(menuBuilder);
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    /* access modifiers changed from: protected */
    public boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    /* access modifiers changed from: protected */
    public boolean isShifting(int i5, int i6) {
        return i5 == -1 ? i6 > 3 : i5 == 0;
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getCurrentVisibleContentItemCount(), false, 1));
    }

    /* access modifiers changed from: package-private */
    public void removeBadge(int i5) {
        validateMenuItemId(i5);
        NavigationBarItemView findItemView = findItemView(i5);
        if (findItemView != null) {
            findItemView.removeBadge();
        }
        this.badgeDrawables.put(i5, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void restoreBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        for (int i5 = 0; i5 < sparseArray.size(); i5++) {
            int keyAt = sparseArray.keyAt(i5);
            if (this.badgeDrawables.indexOfKey(keyAt) < 0) {
                this.badgeDrawables.append(keyAt, sparseArray.get(keyAt));
            }
        }
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    NavigationBarItemView navigationBarItemView = (NavigationBarItemView) navigationBarMenuItemView;
                    BadgeDrawable badgeDrawable = this.badgeDrawables.get(navigationBarItemView.getId());
                    if (badgeDrawable != null) {
                        navigationBarItemView.setBadge(badgeDrawable);
                    }
                }
            }
        }
    }

    public void setActiveIndicatorLabelPadding(@Px int i5) {
        this.itemActiveIndicatorLabelPadding = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorLabelPadding(i5);
                }
            }
        }
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        if (this.checkedItem != menuItem && menuItem.isCheckable()) {
            MenuItem menuItem2 = this.checkedItem;
            if (menuItem2 != null && menuItem2.isChecked()) {
                this.checkedItem.setChecked(false);
            }
            menuItem.setChecked(true);
            this.checkedItem = menuItem;
        }
    }

    public void setCollapsedMaxItemCount(int i5) {
        this.collapsedMaxItemCount = i5;
    }

    public void setExpanded(boolean z4) {
        this.expanded = z4;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView expanded2 : navigationBarMenuItemViewArr) {
                expanded2.setExpanded(z4);
            }
        }
    }

    public void setHorizontalItemTextAppearanceActive(@StyleRes int i5) {
        this.horizontalItemTextAppearanceActive = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setHorizontalTextAppearanceActive(i5);
                }
            }
        }
    }

    public void setHorizontalItemTextAppearanceInactive(@StyleRes int i5) {
        this.horizontalItemTextAppearanceInactive = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setHorizontalTextAppearanceInactive(i5);
                }
            }
        }
    }

    public void setIconLabelHorizontalSpacing(@Px int i5) {
        this.iconLabelHorizontalSpacing = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setIconLabelHorizontalSpacing(i5);
                }
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setIconTintList(colorStateList);
                }
            }
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.itemActiveIndicatorColor = colorStateList;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
                }
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z4) {
        this.itemActiveIndicatorEnabled = z4;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorEnabled(z4);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedHeight(@Px int i5) {
        this.itemActiveIndicatorExpandedHeight = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorExpandedHeight(i5);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(@Px int i5) {
        this.itemActiveIndicatorExpandedMarginHorizontal = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorExpandedMarginHorizontal(i5);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedPadding(int i5, int i6, int i7, int i8) {
        Rect rect = this.itemActiveIndicatorExpandedPadding;
        rect.left = i5;
        rect.top = i6;
        rect.right = i7;
        rect.bottom = i8;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorExpandedPadding(this.itemActiveIndicatorExpandedPadding);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedWidth(@Px int i5) {
        this.itemActiveIndicatorExpandedWidth = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorExpandedWidth(i5);
                }
            }
        }
    }

    public void setItemActiveIndicatorHeight(@Px int i5) {
        this.itemActiveIndicatorHeight = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorHeight(i5);
                }
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i5) {
        this.itemActiveIndicatorMarginHorizontal = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorMarginHorizontal(i5);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setItemActiveIndicatorResizeable(boolean z4) {
        this.itemActiveIndicatorResizeable = z4;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorResizeable(z4);
                }
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.itemActiveIndicatorShapeAppearance = shapeAppearanceModel;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
                }
            }
        }
    }

    public void setItemActiveIndicatorWidth(@Px int i5) {
        this.itemActiveIndicatorWidth = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorWidth(i5);
                }
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemBackground(drawable);
                }
            }
        }
    }

    public void setItemBackgroundRes(int i5) {
        this.itemBackgroundRes = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemBackground(i5);
                }
            }
        }
    }

    public void setItemGravity(int i5) {
        this.itemGravity = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemGravity(i5);
                }
            }
        }
    }

    public void setItemIconGravity(int i5) {
        this.itemIconGravity = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemIconGravity(i5);
                }
            }
        }
    }

    public void setItemIconSize(@Dimension int i5) {
        this.itemIconSize = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setIconSize(i5);
                }
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i5, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.onTouchListeners.remove(i5);
        } else {
            this.onTouchListeners.put(i5, onTouchListener);
        }
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if ((navigationBarMenuItemView instanceof NavigationBarItemView) && navigationBarMenuItemView.getItemData() != null && navigationBarMenuItemView.getItemData().getItemId() == i5) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(@Px int i5) {
        this.itemPaddingBottom = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemPaddingBottom(this.itemPaddingBottom);
                }
            }
        }
    }

    public void setItemPaddingTop(@Px int i5) {
        this.itemPaddingTop = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemPaddingTop(i5);
                }
            }
        }
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.itemRippleColor = colorStateList;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemRippleColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i5) {
        this.itemTextAppearanceActive = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setTextAppearanceActive(i5);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z4) {
        this.itemTextAppearanceActiveBoldEnabled = z4;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setTextAppearanceActiveBoldEnabled(z4);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i5) {
        this.itemTextAppearanceInactive = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setTextAppearanceInactive(i5);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setTextColor(colorStateList);
                }
            }
        }
    }

    public void setLabelFontScalingEnabled(boolean z4) {
        this.scaleLabelWithFont = z4;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setLabelFontScalingEnabled(z4);
                }
            }
        }
    }

    public void setLabelMaxLines(int i5) {
        this.labelMaxLines = i5;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setLabelMaxLines(i5);
                }
            }
        }
    }

    public void setLabelVisibilityMode(int i5) {
        this.labelVisibilityMode = i5;
    }

    public void setMeasurePaddingFromLabelBaseline(boolean z4) {
        this.measurePaddingFromLabelBaseline = z4;
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setMeasureBottomPaddingFromLabelBaseline(z4);
                }
            }
        }
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.presenter = navigationBarPresenter;
    }

    public void setSubmenuDividersEnabled(boolean z4) {
        if (this.dividersEnabled != z4) {
            this.dividersEnabled = z4;
            NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
            if (navigationBarMenuItemViewArr != null) {
                for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                    if (navigationBarMenuItemView instanceof NavigationBarDividerView) {
                        ((NavigationBarDividerView) navigationBarMenuItemView).setDividersEnabled(z4);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void tryRestoreSelectedItemId(int i5) {
        int size = this.menu.size();
        for (int i6 = 0; i6 < size; i6++) {
            MenuItem itemAt = this.menu.getItemAt(i6);
            if (i5 == itemAt.getItemId()) {
                this.selectedItemId = i5;
                this.selectedItemPosition = i6;
                setCheckedItem(itemAt);
                return;
            }
        }
    }

    public void updateActiveIndicator(int i5) {
        NavigationBarMenuItemView[] navigationBarMenuItemViewArr = this.buttons;
        if (navigationBarMenuItemViewArr != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : navigationBarMenuItemViewArr) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).updateActiveIndicatorLayoutParams(i5);
                }
            }
        }
    }

    public void updateMenuView() {
        TransitionSet transitionSet;
        if (this.menu != null && this.buttons != null) {
            this.presenter.setUpdateSuspended(true);
            this.menu.refreshItems();
            this.presenter.setUpdateSuspended(false);
            if (!isMenuStructureSame()) {
                buildMenuView();
                return;
            }
            int i5 = this.selectedItemId;
            int size = this.menu.size();
            for (int i6 = 0; i6 < size; i6++) {
                MenuItem itemAt = this.menu.getItemAt(i6);
                if (itemAt.isChecked()) {
                    setCheckedItem(itemAt);
                    this.selectedItemId = itemAt.getItemId();
                    this.selectedItemPosition = i6;
                }
            }
            if (!(i5 == this.selectedItemId || (transitionSet = this.set) == null)) {
                TransitionManager.beginDelayedTransition(this, transitionSet);
            }
            boolean isShifting = isShifting(this.labelVisibilityMode, getCurrentVisibleContentItemCount());
            for (int i7 = 0; i7 < size; i7++) {
                this.presenter.setUpdateSuspended(true);
                this.buttons[i7].setExpanded(this.expanded);
                NavigationBarMenuItemView navigationBarMenuItemView = this.buttons[i7];
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    NavigationBarItemView navigationBarItemView = (NavigationBarItemView) navigationBarMenuItemView;
                    navigationBarItemView.setLabelVisibilityMode(this.labelVisibilityMode);
                    navigationBarItemView.setItemIconGravity(this.itemIconGravity);
                    navigationBarItemView.setItemGravity(this.itemGravity);
                    navigationBarItemView.setShifting(isShifting);
                }
                if (this.menu.getItemAt(i7) instanceof MenuItemImpl) {
                    this.buttons[i7].initialize((MenuItemImpl) this.menu.getItemAt(i7), 0);
                }
                this.presenter.setUpdateSuspended(false);
            }
        }
    }
}
