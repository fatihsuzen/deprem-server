package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuView;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class NavigationBarView extends FrameLayout {
    public static final int ACTIVE_INDICATOR_WIDTH_MATCH_PARENT = -1;
    public static final int ACTIVE_INDICATOR_WIDTH_WRAP_CONTENT = -2;
    public static final int ITEM_GRAVITY_CENTER = 17;
    public static final int ITEM_GRAVITY_START_CENTER = 8388627;
    public static final int ITEM_GRAVITY_TOP_CENTER = 49;
    public static final int ITEM_ICON_GRAVITY_START = 1;
    public static final int ITEM_ICON_GRAVITY_TOP = 0;
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    private static final int MENU_PRESENTER_ID = 1;
    @NonNull
    private final NavigationBarMenu menu;
    private MenuInflater menuInflater;
    @NonNull
    private final NavigationBarMenuView menuView;
    @NonNull
    private final NavigationBarPresenter presenter;
    /* access modifiers changed from: private */
    public OnItemReselectedListener reselectedListener;
    /* access modifiers changed from: private */
    public OnItemSelectedListener selectedListener;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ItemGravity {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ItemIconGravity {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LabelVisibility {
    }

    public interface OnItemReselectedListener {
        void onNavigationItemReselected(@NonNull MenuItem menuItem);
    }

    public interface OnItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @NonNull
            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }

            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        @Nullable
        Bundle menuPresenterState;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void readFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.menuPresenterState = parcel.readBundle(classLoader);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeBundle(this.menuPresenterState);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x023c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationBarView(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, @androidx.annotation.AttrRes int r13, @androidx.annotation.StyleRes int r14) {
        /*
            r10 = this;
            android.content.Context r11 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r11, r12, r13, r14)
            r10.<init>(r11, r12, r13)
            com.google.android.material.navigation.NavigationBarPresenter r11 = new com.google.android.material.navigation.NavigationBarPresenter
            r11.<init>()
            r10.presenter = r11
            android.content.Context r0 = r10.getContext()
            int[] r2 = com.google.android.material.R.styleable.NavigationBarView
            int r6 = com.google.android.material.R.styleable.NavigationBarView_itemTextAppearanceInactive
            int r7 = com.google.android.material.R.styleable.NavigationBarView_itemTextAppearanceActive
            int[] r5 = new int[]{r6, r7}
            r1 = r12
            r3 = r13
            r4 = r14
            androidx.appcompat.widget.TintTypedArray r12 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r0, r1, r2, r3, r4, r5)
            com.google.android.material.navigation.NavigationBarMenu r13 = new com.google.android.material.navigation.NavigationBarMenu
            java.lang.Class r14 = r10.getClass()
            int r2 = r10.getMaxItemCount()
            boolean r5 = r10.isSubMenuSupported()
            r13.<init>(r0, r14, r2, r5)
            r10.menu = r13
            com.google.android.material.navigation.NavigationBarMenuView r14 = r10.createNavigationBarMenuView(r0)
            r10.menuView = r14
            int r2 = r10.getSuggestedMinimumHeight()
            r14.setMinimumHeight(r2)
            int r2 = r10.getCollapsedMaxItemCount()
            r14.setCollapsedMaxItemCount(r2)
            r11.setMenuView(r14)
            r2 = 1
            r11.setId(r2)
            r14.setPresenter(r11)
            r13.addMenuPresenter(r11)
            android.content.Context r5 = r10.getContext()
            r11.initForMenu(r5, r13)
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemIconTint
            boolean r5 = r12.hasValue(r11)
            if (r5 == 0) goto L_0x006e
            android.content.res.ColorStateList r11 = r12.getColorStateList(r11)
            r14.setIconTintList(r11)
            goto L_0x0078
        L_0x006e:
            r11 = 16842808(0x1010038, float:2.3693715E-38)
            android.content.res.ColorStateList r11 = r14.createDefaultColorStateList(r11)
            r14.setIconTintList(r11)
        L_0x0078:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemIconSize
            android.content.res.Resources r5 = r10.getResources()
            int r8 = com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_icon_size
            int r5 = r5.getDimensionPixelSize(r8)
            int r11 = r12.getDimensionPixelSize(r11, r5)
            r10.setItemIconSize(r11)
            boolean r11 = r12.hasValue(r6)
            r5 = 0
            if (r11 == 0) goto L_0x0099
            int r11 = r12.getResourceId(r6, r5)
            r10.setItemTextAppearanceInactive(r11)
        L_0x0099:
            boolean r11 = r12.hasValue(r7)
            if (r11 == 0) goto L_0x00a6
            int r11 = r12.getResourceId(r7, r5)
            r10.setItemTextAppearanceActive(r11)
        L_0x00a6:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_horizontalItemTextAppearanceInactive
            boolean r6 = r12.hasValue(r11)
            if (r6 == 0) goto L_0x00b5
            int r11 = r12.getResourceId(r11, r5)
            r10.setHorizontalItemTextAppearanceInactive(r11)
        L_0x00b5:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_horizontalItemTextAppearanceActive
            boolean r6 = r12.hasValue(r11)
            if (r6 == 0) goto L_0x00c4
            int r11 = r12.getResourceId(r11, r5)
            r10.setHorizontalItemTextAppearanceActive(r11)
        L_0x00c4:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemTextAppearanceActiveBoldEnabled
            boolean r11 = r12.getBoolean(r11, r2)
            r10.setItemTextAppearanceActiveBoldEnabled(r11)
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemTextColor
            boolean r6 = r12.hasValue(r11)
            if (r6 == 0) goto L_0x00dc
            android.content.res.ColorStateList r11 = r12.getColorStateList(r11)
            r10.setItemTextColor(r11)
        L_0x00dc:
            android.graphics.drawable.Drawable r11 = r10.getBackground()
            android.content.res.ColorStateList r6 = com.google.android.material.drawable.DrawableUtils.getColorStateListOrNull(r11)
            if (r11 == 0) goto L_0x00e8
            if (r6 == 0) goto L_0x0100
        L_0x00e8:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r11 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r0, (android.util.AttributeSet) r1, (int) r3, (int) r4)
            com.google.android.material.shape.ShapeAppearanceModel r11 = r11.build()
            com.google.android.material.shape.MaterialShapeDrawable r1 = new com.google.android.material.shape.MaterialShapeDrawable
            r1.<init>((com.google.android.material.shape.ShapeAppearanceModel) r11)
            if (r6 == 0) goto L_0x00fa
            r1.setFillColor(r6)
        L_0x00fa:
            r1.initializeElevationOverlay(r0)
            r10.setBackground(r1)
        L_0x0100:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemPaddingTop
            boolean r1 = r12.hasValue(r11)
            if (r1 == 0) goto L_0x010f
            int r11 = r12.getDimensionPixelSize(r11, r5)
            r10.setItemPaddingTop(r11)
        L_0x010f:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemPaddingBottom
            boolean r1 = r12.hasValue(r11)
            if (r1 == 0) goto L_0x011e
            int r11 = r12.getDimensionPixelSize(r11, r5)
            r10.setItemPaddingBottom(r11)
        L_0x011e:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_activeIndicatorLabelPadding
            boolean r1 = r12.hasValue(r11)
            if (r1 == 0) goto L_0x012d
            int r11 = r12.getDimensionPixelSize(r11, r5)
            r10.setActiveIndicatorLabelPadding(r11)
        L_0x012d:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_iconLabelHorizontalSpacing
            boolean r1 = r12.hasValue(r11)
            if (r1 == 0) goto L_0x013c
            int r11 = r12.getDimensionPixelSize(r11, r5)
            r10.setIconLabelHorizontalSpacing(r11)
        L_0x013c:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_elevation
            boolean r1 = r12.hasValue(r11)
            if (r1 == 0) goto L_0x014c
            int r11 = r12.getDimensionPixelSize(r11, r5)
            float r11 = (float) r11
            r10.setElevation(r11)
        L_0x014c:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_backgroundTint
            android.content.res.ColorStateList r11 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (androidx.appcompat.widget.TintTypedArray) r12, (int) r11)
            android.graphics.drawable.Drawable r1 = r10.getBackground()
            android.graphics.drawable.Drawable r1 = r1.mutate()
            r1.setTintList(r11)
            int r11 = com.google.android.material.R.styleable.NavigationBarView_labelVisibilityMode
            r1 = -1
            int r11 = r12.getInteger(r11, r1)
            r10.setLabelVisibilityMode(r11)
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemIconGravity
            int r11 = r12.getInteger(r11, r5)
            r10.setItemIconGravity(r11)
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemGravity
            r3 = 49
            int r11 = r12.getInteger(r11, r3)
            r10.setItemGravity(r11)
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemBackground
            int r11 = r12.getResourceId(r11, r5)
            if (r11 == 0) goto L_0x0187
            r14.setItemBackgroundRes(r11)
            goto L_0x0190
        L_0x0187:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemRippleColor
            android.content.res.ColorStateList r11 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (androidx.appcompat.widget.TintTypedArray) r12, (int) r11)
            r10.setItemRippleColor(r11)
        L_0x0190:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_measureBottomPaddingFromLabelBaseline
            boolean r11 = r12.getBoolean(r11, r2)
            r10.setMeasureBottomPaddingFromLabelBaseline(r11)
            int r11 = com.google.android.material.R.styleable.NavigationBarView_labelFontScalingEnabled
            boolean r11 = r12.getBoolean(r11, r5)
            r10.setLabelFontScalingEnabled(r11)
            int r11 = com.google.android.material.R.styleable.NavigationBarView_labelMaxLines
            int r11 = r12.getInteger(r11, r2)
            r10.setLabelMaxLines(r11)
            int r11 = com.google.android.material.R.styleable.NavigationBarView_itemActiveIndicatorStyle
            int r11 = r12.getResourceId(r11, r5)
            if (r11 == 0) goto L_0x0263
            r10.setItemActiveIndicatorEnabled(r2)
            int[] r3 = com.google.android.material.R.styleable.NavigationBarActiveIndicator
            android.content.res.TypedArray r11 = r0.obtainStyledAttributes(r11, r3)
            int r3 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_android_width
            int r3 = r11.getDimensionPixelSize(r3, r5)
            r10.setItemActiveIndicatorWidth(r3)
            int r4 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_android_height
            int r4 = r11.getDimensionPixelSize(r4, r5)
            r10.setItemActiveIndicatorHeight(r4)
            int r4 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_marginHorizontal
            int r4 = r11.getDimensionPixelOffset(r4, r5)
            r10.setItemActiveIndicatorMarginHorizontal(r4)
            int r6 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_expandedWidth
            java.lang.String r7 = r11.getString(r6)
            r8 = -2
            if (r7 == 0) goto L_0x01f5
            java.lang.String r9 = java.lang.String.valueOf(r1)
            boolean r9 = r9.equals(r7)
            if (r9 == 0) goto L_0x01eb
            goto L_0x01fb
        L_0x01eb:
            java.lang.String r1 = java.lang.String.valueOf(r8)
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x01f7
        L_0x01f5:
            r1 = r8
            goto L_0x01fb
        L_0x01f7:
            int r1 = r11.getDimensionPixelSize(r6, r8)
        L_0x01fb:
            r10.setItemActiveIndicatorExpandedWidth(r1)
            int r1 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_expandedHeight
            int r1 = r11.getDimensionPixelSize(r1, r3)
            r10.setItemActiveIndicatorExpandedHeight(r1)
            int r1 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_expandedMarginHorizontal
            int r1 = r11.getDimensionPixelOffset(r1, r4)
            r10.setItemActiveIndicatorExpandedMarginHorizontal(r1)
            android.content.res.Resources r1 = r10.getResources()
            int r3 = com.google.android.material.R.dimen.m3_navigation_item_leading_trailing_space
            int r1 = r1.getDimensionPixelSize(r3)
            int r3 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingStart
            int r3 = r11.getDimensionPixelOffset(r3, r1)
            int r4 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingEnd
            int r1 = r11.getDimensionPixelOffset(r4, r1)
            int r4 = r10.getLayoutDirection()
            if (r4 != r2) goto L_0x022e
            r4 = r1
            goto L_0x022f
        L_0x022e:
            r4 = r3
        L_0x022f:
            int r6 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingTop
            int r6 = r11.getDimensionPixelOffset(r6, r5)
            int r7 = r10.getLayoutDirection()
            if (r7 != r2) goto L_0x023c
            goto L_0x023d
        L_0x023c:
            r3 = r1
        L_0x023d:
            int r1 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingBottom
            int r1 = r11.getDimensionPixelOffset(r1, r5)
            r10.setItemActiveIndicatorExpandedPadding(r4, r6, r3, r1)
            int r1 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_android_color
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r11, (int) r1)
            r10.setItemActiveIndicatorColor(r1)
            int r1 = com.google.android.material.R.styleable.NavigationBarActiveIndicator_shapeAppearance
            int r1 = r11.getResourceId(r1, r5)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r0 = com.google.android.material.shape.ShapeAppearanceModel.builder(r0, r1, r5)
            com.google.android.material.shape.ShapeAppearanceModel r0 = r0.build()
            r10.setItemActiveIndicatorShapeAppearance(r0)
            r11.recycle()
        L_0x0263:
            int r11 = com.google.android.material.R.styleable.NavigationBarView_menu
            boolean r0 = r12.hasValue(r11)
            if (r0 == 0) goto L_0x0272
            int r11 = r12.getResourceId(r11, r5)
            r10.inflateMenu(r11)
        L_0x0272:
            r12.recycle()
            boolean r11 = r10.shouldAddMenuView()
            if (r11 != 0) goto L_0x027e
            r10.addView(r14)
        L_0x027e:
            com.google.android.material.navigation.NavigationBarView$1 r11 = new com.google.android.material.navigation.NavigationBarView$1
            r11.<init>()
            r13.setCallback(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationBarView.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    private void setMeasureBottomPaddingFromLabelBaseline(boolean z4) {
        this.menuView.setMeasurePaddingFromLabelBaseline(z4);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract NavigationBarMenuView createNavigationBarMenuView(@NonNull Context context);

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.menuView.getActiveIndicatorLabelPadding();
    }

    @Nullable
    public BadgeDrawable getBadge(int i5) {
        return this.menuView.getBadge(i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getCollapsedMaxItemCount() {
        return getMaxItemCount();
    }

    @StyleRes
    public int getHorizontalItemTextAppearanceActive() {
        return this.menuView.getHorizontalItemTextAppearanceActive();
    }

    @StyleRes
    public int getHorizontalItemTextAppearanceInactive() {
        return this.menuView.getHorizontalItemTextAppearanceInactive();
    }

    @Px
    public int getIconLabelHorizontalSpacing() {
        return this.menuView.getIconLabelHorizontalSpacing();
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.menuView.getItemActiveIndicatorColor();
    }

    @Px
    public int getItemActiveIndicatorExpandedHeight() {
        return this.menuView.getItemActiveIndicatorExpandedHeight();
    }

    @Px
    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.menuView.getItemActiveIndicatorExpandedMarginHorizontal();
    }

    @Px
    public int getItemActiveIndicatorExpandedWidth() {
        return this.menuView.getItemActiveIndicatorExpandedWidth();
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.menuView.getItemActiveIndicatorHeight();
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.menuView.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.menuView.getItemActiveIndicatorShapeAppearance();
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.menuView.getItemActiveIndicatorWidth();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    @Deprecated
    @DrawableRes
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public int getItemGravity() {
        return this.menuView.getItemGravity();
    }

    public int getItemIconGravity() {
        return this.menuView.getItemIconGravity();
    }

    @Dimension
    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    @Px
    public int getItemPaddingBottom() {
        return this.menuView.getItemPaddingBottom();
    }

    @Px
    public int getItemPaddingTop() {
        return this.menuView.getItemPaddingTop();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.menuView.getItemRippleColor();
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelMaxLines(int i5) {
        return this.menuView.getLabelMaxLines();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView getMenuView() {
        return this.menuView;
    }

    @NonNull
    public ViewGroup getMenuViewGroup() {
        return this.menuView;
    }

    @NonNull
    public BadgeDrawable getOrCreateBadge(int i5) {
        return this.menuView.getOrCreateBadge(i5);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarPresenter getPresenter() {
        return this.presenter;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.menuView.getScaleLabelTextWithFont();
    }

    @IdRes
    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int i5) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i5, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    public boolean isItemActiveIndicatorEnabled() {
        return this.menuView.getItemActiveIndicatorEnabled();
    }

    /* access modifiers changed from: protected */
    public boolean isSubMenuSupported() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuPresenterState);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuPresenterState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    public void removeBadge(int i5) {
        this.menuView.removeBadge(i5);
    }

    public void setActiveIndicatorLabelPadding(@Px int i5) {
        this.menuView.setActiveIndicatorLabelPadding(i5);
    }

    public void setElevation(float f5) {
        super.setElevation(f5);
        MaterialShapeUtils.setElevation(this, f5);
    }

    public void setHorizontalItemTextAppearanceActive(@StyleRes int i5) {
        this.menuView.setHorizontalItemTextAppearanceActive(i5);
    }

    public void setHorizontalItemTextAppearanceInactive(@StyleRes int i5) {
        this.menuView.setHorizontalItemTextAppearanceInactive(i5);
    }

    public void setIconLabelHorizontalSpacing(@Px int i5) {
        this.menuView.setIconLabelHorizontalSpacing(i5);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.menuView.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z4) {
        this.menuView.setItemActiveIndicatorEnabled(z4);
    }

    public void setItemActiveIndicatorExpandedHeight(@Px int i5) {
        this.menuView.setItemActiveIndicatorExpandedHeight(i5);
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(@Px int i5) {
        this.menuView.setItemActiveIndicatorExpandedMarginHorizontal(i5);
    }

    public void setItemActiveIndicatorExpandedPadding(@Px int i5, @Px int i6, @Px int i7, @Px int i8) {
        this.menuView.setItemActiveIndicatorExpandedPadding(i5, i6, i7, i8);
    }

    public void setItemActiveIndicatorExpandedWidth(@Px int i5) {
        this.menuView.setItemActiveIndicatorExpandedWidth(i5);
    }

    public void setItemActiveIndicatorHeight(@Px int i5) {
        this.menuView.setItemActiveIndicatorHeight(i5);
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i5) {
        this.menuView.setItemActiveIndicatorMarginHorizontal(i5);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.menuView.setItemActiveIndicatorShapeAppearance(shapeAppearanceModel);
    }

    public void setItemActiveIndicatorWidth(@Px int i5) {
        this.menuView.setItemActiveIndicatorWidth(i5);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.menuView.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i5) {
        this.menuView.setItemBackgroundRes(i5);
    }

    public void setItemGravity(int i5) {
        if (this.menuView.getItemGravity() != i5) {
            this.menuView.setItemGravity(i5);
            this.presenter.updateMenuView(false);
        }
    }

    public void setItemIconGravity(int i5) {
        if (this.menuView.getItemIconGravity() != i5) {
            this.menuView.setItemIconGravity(i5);
            this.presenter.updateMenuView(false);
        }
    }

    public void setItemIconSize(@Dimension int i5) {
        this.menuView.setItemIconSize(i5);
    }

    public void setItemIconSizeRes(@DimenRes int i5) {
        setItemIconSize(getResources().getDimensionPixelSize(i5));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.menuView.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i5, @Nullable View.OnTouchListener onTouchListener) {
        this.menuView.setItemOnTouchListener(i5, onTouchListener);
    }

    public void setItemPaddingBottom(@Px int i5) {
        this.menuView.setItemPaddingBottom(i5);
    }

    public void setItemPaddingTop(@Px int i5) {
        this.menuView.setItemPaddingTop(i5);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.menuView.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(@StyleRes int i5) {
        this.menuView.setItemTextAppearanceActive(i5);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z4) {
        this.menuView.setItemTextAppearanceActiveBoldEnabled(z4);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i5) {
        this.menuView.setItemTextAppearanceInactive(i5);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.menuView.setItemTextColor(colorStateList);
    }

    public void setLabelFontScalingEnabled(boolean z4) {
        this.menuView.setLabelFontScalingEnabled(z4);
    }

    public void setLabelMaxLines(int i5) {
        this.menuView.setLabelMaxLines(i5);
    }

    public void setLabelVisibilityMode(int i5) {
        if (this.menuView.getLabelVisibilityMode() != i5) {
            this.menuView.setLabelVisibilityMode(i5);
            this.presenter.updateMenuView(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable OnItemReselectedListener onItemReselectedListener) {
        this.reselectedListener = onItemReselectedListener;
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener onItemSelectedListener) {
        this.selectedListener = onItemSelectedListener;
    }

    public void setSelectedItemId(@IdRes int i5) {
        MenuItem findItem = this.menu.findItem(i5);
        if (findItem != null) {
            boolean performItemAction = this.menu.performItemAction(findItem, this.presenter, 0);
            if (!findItem.isCheckable()) {
                return;
            }
            if (!performItemAction || findItem.isChecked()) {
                this.menuView.setCheckedItem(findItem);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldAddMenuView() {
        return false;
    }
}
