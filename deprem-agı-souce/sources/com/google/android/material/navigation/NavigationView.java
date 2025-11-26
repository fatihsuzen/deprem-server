package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.activity.BackEventCompat;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeableDelegate;

public class NavigationView extends ScrimInsetsFrameLayout implements MaterialBackHandler {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEF_STYLE_RES = R.style.Widget_Design_NavigationView;
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private final DrawerLayout.DrawerListener backDrawerListener;
    /* access modifiers changed from: private */
    public final MaterialBackOrchestrator backOrchestrator;
    private boolean bottomInsetScrimEnabled;
    @Px
    private int drawerLayoutCornerSize;
    private final boolean drawerLayoutCornerSizeBackAnimationEnabled;
    @Px
    private final int drawerLayoutCornerSizeBackAnimationMax;
    private boolean endInsetScrimEnabled;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    @NonNull
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    /* access modifiers changed from: private */
    public final NavigationMenuPresenter presenter;
    private final ShapeableDelegate shapeableDelegate;
    private final MaterialSideContainerBackHelper sideContainerBackHelper;
    private boolean startInsetScrimEnabled;
    /* access modifiers changed from: private */
    public final int[] tmpLocation;
    private boolean topInsetScrimEnabled;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public NavigationView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @Nullable
    private ColorStateList createDefaultColorStateList(int i5) {
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
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i6, defaultColor});
    }

    @NonNull
    private Drawable createDefaultItemBackground(@NonNull TintTypedArray tintTypedArray) {
        return createDefaultItemDrawable(tintTypedArray, MaterialResources.getColorStateList(getContext(), tintTypedArray, R.styleable.NavigationView_itemShapeFillColor));
    }

    @NonNull
    private Drawable createDefaultItemDrawable(@NonNull TintTypedArray tintTypedArray, @Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(colorStateList);
        return new InsetDrawable(materialShapeDrawable, tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    private boolean hasShapeAppearance(@NonNull TintTypedArray tintTypedArray) {
        if (tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearanceOverlay)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void maybeClearCornerSizeAnimationForDrawerLayout() {
        if (this.drawerLayoutCornerSizeBackAnimationEnabled && this.drawerLayoutCornerSize != 0) {
            this.drawerLayoutCornerSize = 0;
            maybeUpdateCornerSizeForDrawerLayout(getWidth(), getHeight());
        }
    }

    private void maybeUpdateCornerSizeForDrawerLayout(@Px int i5, @Px int i6) {
        boolean z4;
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.LayoutParams)) {
            if ((this.drawerLayoutCornerSize > 0 || this.drawerLayoutCornerSizeBackAnimationEnabled) && (getBackground() instanceof MaterialShapeDrawable)) {
                if (Gravity.getAbsoluteGravity(((DrawerLayout.LayoutParams) getLayoutParams()).gravity, getLayoutDirection()) == 3) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
                ShapeAppearanceModel.Builder allCornerSizes = materialShapeDrawable.getShapeAppearanceModel().toBuilder().setAllCornerSizes((float) this.drawerLayoutCornerSize);
                if (z4) {
                    allCornerSizes.setTopLeftCornerSize(0.0f);
                    allCornerSizes.setBottomLeftCornerSize(0.0f);
                } else {
                    allCornerSizes.setTopRightCornerSize(0.0f);
                    allCornerSizes.setBottomRightCornerSize(0.0f);
                }
                ShapeAppearanceModel build = allCornerSizes.build();
                materialShapeDrawable.setShapeAppearanceModel(build);
                this.shapeableDelegate.onShapeAppearanceChanged(this, build);
                this.shapeableDelegate.onMaskChanged(this, new RectF(0.0f, 0.0f, (float) i5, (float) i6));
                this.shapeableDelegate.setOffsetZeroCornerEdgeBoundsEnabled(this, true);
            }
        }
    }

    private Pair<DrawerLayout, DrawerLayout.LayoutParams> requireDrawerLayoutParent() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.LayoutParams)) {
            return new Pair<>((DrawerLayout) parent, (DrawerLayout.LayoutParams) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                boolean z4;
                boolean z5;
                boolean z6;
                boolean z7;
                boolean z8;
                boolean z9;
                boolean z10;
                boolean z11;
                boolean z12;
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                boolean z13 = true;
                if (NavigationView.this.tmpLocation[1] == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                NavigationView.this.presenter.setBehindStatusBar(z4);
                NavigationView navigationView2 = NavigationView.this;
                if (!z4 || !navigationView2.isTopInsetScrimEnabled()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                navigationView2.setDrawTopInsetForeground(z5);
                if (NavigationView.this.getLayoutDirection() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (NavigationView.this.tmpLocation[0] == 0 || NavigationView.this.tmpLocation[0] + NavigationView.this.getWidth() == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                NavigationView navigationView3 = NavigationView.this;
                if (!z7 || (!z6 ? !navigationView3.isStartInsetScrimEnabled() : !navigationView3.isEndInsetScrimEnabled())) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                navigationView3.setDrawLeftInsetForeground(z8);
                Activity activity = ContextUtils.getActivity(NavigationView.this.getContext());
                if (activity != null) {
                    Rect currentWindowBounds = WindowUtils.getCurrentWindowBounds(activity);
                    if (currentWindowBounds.height() - NavigationView.this.getHeight() == NavigationView.this.tmpLocation[1]) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    NavigationView navigationView4 = NavigationView.this;
                    if (!z9 || !z10 || !navigationView4.isBottomInsetScrimEnabled()) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    navigationView4.setDrawBottomInsetForeground(z11);
                    if (currentWindowBounds.width() == NavigationView.this.tmpLocation[0] || currentWindowBounds.width() - NavigationView.this.getWidth() == NavigationView.this.tmpLocation[0]) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    NavigationView navigationView5 = NavigationView.this;
                    if (!z12 || (!z6 ? !navigationView5.isEndInsetScrimEnabled() : !navigationView5.isStartInsetScrimEnabled())) {
                        z13 = false;
                    }
                    navigationView5.setDrawRightInsetForeground(z13);
                }
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(@NonNull View view) {
        this.presenter.addHeaderView(view);
    }

    public void cancelBackProgress() {
        requireDrawerLayoutParent();
        this.sideContainerBackHelper.cancelBackProgress();
        maybeClearCornerSizeAnimationForDrawerLayout();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(@NonNull Canvas canvas) {
        this.shapeableDelegate.maybeClip(canvas, new d(this));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public MaterialSideContainerBackHelper getBackHelper() {
        return this.sideContainerBackHelper;
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.presenter.getDividerInsetEnd();
    }

    @Px
    public int getDividerInsetStart() {
        return this.presenter.getDividerInsetStart();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int i5) {
        return this.presenter.getHeaderView(i5);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    @Px
    public int getItemVerticalPadding() {
        return this.presenter.getItemVerticalPadding();
    }

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.presenter.getSubheaderInsetEnd();
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.presenter.getSubheaderInsetStart();
    }

    public void handleBackInvoked() {
        Pair<DrawerLayout, DrawerLayout.LayoutParams> requireDrawerLayoutParent = requireDrawerLayoutParent();
        DrawerLayout drawerLayout = (DrawerLayout) requireDrawerLayoutParent.first;
        BackEventCompat onHandleBackInvoked = this.sideContainerBackHelper.onHandleBackInvoked();
        if (onHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.closeDrawer((View) this);
            return;
        }
        this.sideContainerBackHelper.finishBackProgress(onHandleBackInvoked, ((DrawerLayout.LayoutParams) requireDrawerLayoutParent.second).gravity, DrawerLayoutUtils.getScrimCloseAnimatorListener(drawerLayout, this), DrawerLayoutUtils.getScrimCloseAnimatorUpdateListener(drawerLayout));
    }

    public View inflateHeaderView(@LayoutRes int i5) {
        return this.presenter.inflateHeaderView(i5);
    }

    public void inflateMenu(int i5) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i5, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.bottomInsetScrimEnabled;
    }

    public boolean isEndInsetScrimEnabled() {
        return this.endInsetScrimEnabled;
    }

    public boolean isStartInsetScrimEnabled() {
        return this.startInsetScrimEnabled;
    }

    public boolean isTopInsetScrimEnabled() {
        return this.topInsetScrimEnabled;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.backOrchestrator.shouldListenForBackCallbacks()) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            drawerLayout.removeDrawerListener(this.backDrawerListener);
            drawerLayout.addDrawerListener(this.backDrawerListener);
            if (drawerLayout.isDrawerOpen((View) this)) {
                this.backOrchestrator.startListeningForBackCallbacksWithPriorityOverlay();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).removeDrawerListener(this.backDrawerListener);
        }
        this.backOrchestrator.stopListeningForBackCallbacks();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onInsetsChanged(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.presenter.dispatchApplyWindowInsets(windowInsetsCompat);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        if (mode == Integer.MIN_VALUE) {
            i5 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i5), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            i5 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(i5, i6);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        maybeUpdateCornerSizeForDrawerLayout(i5, i6);
    }

    public void removeHeaderView(@NonNull View view) {
        this.presenter.removeHeaderView(view);
    }

    public void setBottomInsetScrimEnabled(boolean z4) {
        this.bottomInsetScrimEnabled = z4;
    }

    public void setCheckedItem(@IdRes int i5) {
        MenuItem findItem = this.menu.findItem(i5);
        if (findItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    public void setDividerInsetEnd(@Px int i5) {
        this.presenter.setDividerInsetEnd(i5);
    }

    public void setDividerInsetStart(@Px int i5) {
        this.presenter.setDividerInsetStart(i5);
    }

    public void setElevation(float f5) {
        super.setElevation(f5);
        MaterialShapeUtils.setElevation(this, f5);
    }

    public void setEndInsetScrimEnabled(boolean z4) {
        this.endInsetScrimEnabled = z4;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceCompatClippingEnabled(boolean z4) {
        this.shapeableDelegate.setForceCompatClippingEnabled(this, z4);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i5) {
        setItemBackground(getContext().getDrawable(i5));
    }

    public void setItemHorizontalPadding(@Dimension int i5) {
        this.presenter.setItemHorizontalPadding(i5);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i5) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i5));
    }

    public void setItemIconPadding(@Dimension int i5) {
        this.presenter.setItemIconPadding(i5);
    }

    public void setItemIconPaddingResource(int i5) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i5));
    }

    public void setItemIconSize(@Dimension int i5) {
        this.presenter.setItemIconSize(i5);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public void setItemMaxLines(int i5) {
        this.presenter.setItemMaxLines(i5);
    }

    public void setItemTextAppearance(@StyleRes int i5) {
        this.presenter.setItemTextAppearance(i5);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z4) {
        this.presenter.setItemTextAppearanceActiveBoldEnabled(z4);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public void setItemVerticalPadding(@Px int i5) {
        this.presenter.setItemVerticalPadding(i5);
    }

    public void setItemVerticalPaddingResource(@DimenRes int i5) {
        this.presenter.setItemVerticalPadding(getResources().getDimensionPixelSize(i5));
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    public void setOverScrollMode(int i5) {
        super.setOverScrollMode(i5);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i5);
        }
    }

    public void setStartInsetScrimEnabled(boolean z4) {
        this.startInsetScrimEnabled = z4;
    }

    public void setSubheaderInsetEnd(@Px int i5) {
        this.presenter.setSubheaderInsetEnd(i5);
    }

    public void setSubheaderInsetStart(@Px int i5) {
        this.presenter.setSubheaderInsetStart(i5);
    }

    public void setTopInsetScrimEnabled(boolean z4) {
        this.topInsetScrimEnabled = z4;
    }

    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
        requireDrawerLayoutParent();
        this.sideContainerBackHelper.startBackProgress(backEventCompat);
    }

    public void updateBackProgress(@NonNull BackEventCompat backEventCompat) {
        this.sideContainerBackHelper.updateBackProgress(backEventCompat, ((DrawerLayout.LayoutParams) requireDrawerLayoutParent().second).gravity);
        if (this.drawerLayoutCornerSizeBackAnimationEnabled) {
            this.drawerLayoutCornerSize = AnimationUtils.lerp(0, this.drawerLayoutCornerSizeBackAnimationMax, this.sideContainerBackHelper.interpolateProgress(backEventCompat.getProgress()));
            maybeUpdateCornerSizeForDrawerLayout(getWidth(), getHeight());
        }
    }

    public static class SavedState extends AbsSavedState {
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
        public Bundle menuState;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r2 = r18
            r4 = r19
            int r5 = DEF_STYLE_RES
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r2, r4, r5)
            r0.<init>(r1, r2, r4)
            com.google.android.material.internal.NavigationMenuPresenter r7 = new com.google.android.material.internal.NavigationMenuPresenter
            r7.<init>()
            r0.presenter = r7
            r1 = 2
            int[] r1 = new int[r1]
            r0.tmpLocation = r1
            r8 = 1
            r0.topInsetScrimEnabled = r8
            r0.bottomInsetScrimEnabled = r8
            r0.startInsetScrimEnabled = r8
            r0.endInsetScrimEnabled = r8
            r9 = 0
            r0.drawerLayoutCornerSize = r9
            com.google.android.material.shape.ShapeableDelegate r1 = com.google.android.material.shape.ShapeableDelegate.create(r0)
            r0.shapeableDelegate = r1
            com.google.android.material.motion.MaterialSideContainerBackHelper r1 = new com.google.android.material.motion.MaterialSideContainerBackHelper
            r1.<init>(r0)
            r0.sideContainerBackHelper = r1
            com.google.android.material.motion.MaterialBackOrchestrator r1 = new com.google.android.material.motion.MaterialBackOrchestrator
            r1.<init>(r0)
            r0.backOrchestrator = r1
            com.google.android.material.navigation.NavigationView$1 r1 = new com.google.android.material.navigation.NavigationView$1
            r1.<init>()
            r0.backDrawerListener = r1
            android.content.Context r1 = r0.getContext()
            com.google.android.material.internal.NavigationMenu r10 = new com.google.android.material.internal.NavigationMenu
            r10.<init>(r1)
            r0.menu = r10
            int[] r3 = com.google.android.material.R.styleable.NavigationView
            int[] r6 = new int[r9]
            androidx.appcompat.widget.TintTypedArray r3 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r6 = com.google.android.material.R.styleable.NavigationView_android_background
            boolean r11 = r3.hasValue(r6)
            if (r11 == 0) goto L_0x0066
            android.graphics.drawable.Drawable r6 = r3.getDrawable(r6)
            r0.setBackground(r6)
        L_0x0066:
            int r6 = com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize
            int r6 = r3.getDimensionPixelSize(r6, r9)
            r0.drawerLayoutCornerSize = r6
            if (r6 != 0) goto L_0x0072
            r6 = r8
            goto L_0x0073
        L_0x0072:
            r6 = r9
        L_0x0073:
            r0.drawerLayoutCornerSizeBackAnimationEnabled = r6
            android.content.res.Resources r6 = r0.getResources()
            int r11 = com.google.android.material.R.dimen.m3_navigation_drawer_layout_corner_size
            int r6 = r6.getDimensionPixelSize(r11)
            r0.drawerLayoutCornerSizeBackAnimationMax = r6
            android.graphics.drawable.Drawable r6 = r0.getBackground()
            android.content.res.ColorStateList r11 = com.google.android.material.drawable.DrawableUtils.getColorStateListOrNull(r6)
            if (r6 == 0) goto L_0x008d
            if (r11 == 0) goto L_0x00a5
        L_0x008d:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r2 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r1, (android.util.AttributeSet) r2, (int) r4, (int) r5)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.build()
            com.google.android.material.shape.MaterialShapeDrawable r4 = new com.google.android.material.shape.MaterialShapeDrawable
            r4.<init>((com.google.android.material.shape.ShapeAppearanceModel) r2)
            if (r11 == 0) goto L_0x009f
            r4.setFillColor(r11)
        L_0x009f:
            r4.initializeElevationOverlay(r1)
            r0.setBackground(r4)
        L_0x00a5:
            int r2 = com.google.android.material.R.styleable.NavigationView_elevation
            boolean r4 = r3.hasValue(r2)
            if (r4 == 0) goto L_0x00b5
            int r2 = r3.getDimensionPixelSize(r2, r9)
            float r2 = (float) r2
            r0.setElevation(r2)
        L_0x00b5:
            int r2 = com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows
            boolean r2 = r3.getBoolean(r2, r9)
            r0.setFitsSystemWindows(r2)
            int r2 = com.google.android.material.R.styleable.NavigationView_android_maxWidth
            int r2 = r3.getDimensionPixelSize(r2, r9)
            r0.maxWidth = r2
            int r2 = com.google.android.material.R.styleable.NavigationView_subheaderColor
            boolean r4 = r3.hasValue(r2)
            r5 = 0
            if (r4 == 0) goto L_0x00d4
            android.content.res.ColorStateList r2 = r3.getColorStateList(r2)
            goto L_0x00d5
        L_0x00d4:
            r2 = r5
        L_0x00d5:
            int r4 = com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance
            boolean r6 = r3.hasValue(r4)
            if (r6 == 0) goto L_0x00e2
            int r4 = r3.getResourceId(r4, r9)
            goto L_0x00e3
        L_0x00e2:
            r4 = r9
        L_0x00e3:
            r6 = 16842808(0x1010038, float:2.3693715E-38)
            if (r4 != 0) goto L_0x00ee
            if (r2 != 0) goto L_0x00ee
            android.content.res.ColorStateList r2 = r0.createDefaultColorStateList(r6)
        L_0x00ee:
            int r11 = com.google.android.material.R.styleable.NavigationView_itemIconTint
            boolean r12 = r3.hasValue(r11)
            if (r12 == 0) goto L_0x00fb
            android.content.res.ColorStateList r6 = r3.getColorStateList(r11)
            goto L_0x00ff
        L_0x00fb:
            android.content.res.ColorStateList r6 = r0.createDefaultColorStateList(r6)
        L_0x00ff:
            int r11 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance
            boolean r12 = r3.hasValue(r11)
            if (r12 == 0) goto L_0x010c
            int r11 = r3.getResourceId(r11, r9)
            goto L_0x010d
        L_0x010c:
            r11 = r9
        L_0x010d:
            int r12 = com.google.android.material.R.styleable.NavigationView_itemTextAppearanceActiveBoldEnabled
            boolean r12 = r3.getBoolean(r12, r8)
            int r13 = com.google.android.material.R.styleable.NavigationView_itemIconSize
            boolean r14 = r3.hasValue(r13)
            if (r14 == 0) goto L_0x0122
            int r13 = r3.getDimensionPixelSize(r13, r9)
            r0.setItemIconSize(r13)
        L_0x0122:
            int r13 = com.google.android.material.R.styleable.NavigationView_itemTextColor
            boolean r14 = r3.hasValue(r13)
            if (r14 == 0) goto L_0x012f
            android.content.res.ColorStateList r13 = r3.getColorStateList(r13)
            goto L_0x0130
        L_0x012f:
            r13 = r5
        L_0x0130:
            if (r11 != 0) goto L_0x013b
            if (r13 != 0) goto L_0x013b
            r13 = 16842806(0x1010036, float:2.369371E-38)
            android.content.res.ColorStateList r13 = r0.createDefaultColorStateList(r13)
        L_0x013b:
            int r14 = com.google.android.material.R.styleable.NavigationView_itemBackground
            android.graphics.drawable.Drawable r14 = r3.getDrawable(r14)
            if (r14 != 0) goto L_0x0165
            boolean r15 = r0.hasShapeAppearance(r3)
            if (r15 == 0) goto L_0x0165
            android.graphics.drawable.Drawable r14 = r0.createDefaultItemBackground(r3)
            int r15 = com.google.android.material.R.styleable.NavigationView_itemRippleColor
            android.content.res.ColorStateList r15 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r1, (androidx.appcompat.widget.TintTypedArray) r3, (int) r15)
            if (r15 == 0) goto L_0x0165
            android.graphics.drawable.Drawable r8 = r0.createDefaultItemDrawable(r3, r5)
            android.graphics.drawable.RippleDrawable r9 = new android.graphics.drawable.RippleDrawable
            android.content.res.ColorStateList r15 = com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(r15)
            r9.<init>(r15, r5, r8)
            r7.setItemForeground(r9)
        L_0x0165:
            int r5 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding
            boolean r8 = r3.hasValue(r5)
            if (r8 == 0) goto L_0x0176
            r8 = 0
            int r5 = r3.getDimensionPixelSize(r5, r8)
            r0.setItemHorizontalPadding(r5)
            goto L_0x0177
        L_0x0176:
            r8 = 0
        L_0x0177:
            int r5 = com.google.android.material.R.styleable.NavigationView_itemVerticalPadding
            boolean r9 = r3.hasValue(r5)
            if (r9 == 0) goto L_0x0186
            int r5 = r3.getDimensionPixelSize(r5, r8)
            r0.setItemVerticalPadding(r5)
        L_0x0186:
            int r5 = com.google.android.material.R.styleable.NavigationView_dividerInsetStart
            int r5 = r3.getDimensionPixelSize(r5, r8)
            r0.setDividerInsetStart(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_dividerInsetEnd
            int r5 = r3.getDimensionPixelSize(r5, r8)
            r0.setDividerInsetEnd(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_subheaderInsetStart
            int r5 = r3.getDimensionPixelSize(r5, r8)
            r0.setSubheaderInsetStart(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd
            int r5 = r3.getDimensionPixelSize(r5, r8)
            r0.setSubheaderInsetEnd(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled
            boolean r8 = r0.topInsetScrimEnabled
            boolean r5 = r3.getBoolean(r5, r8)
            r0.setTopInsetScrimEnabled(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled
            boolean r8 = r0.bottomInsetScrimEnabled
            boolean r5 = r3.getBoolean(r5, r8)
            r0.setBottomInsetScrimEnabled(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_startInsetScrimEnabled
            boolean r8 = r0.startInsetScrimEnabled
            boolean r5 = r3.getBoolean(r5, r8)
            r0.setStartInsetScrimEnabled(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_endInsetScrimEnabled
            boolean r8 = r0.endInsetScrimEnabled
            boolean r5 = r3.getBoolean(r5, r8)
            r0.setEndInsetScrimEnabled(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_itemIconPadding
            r8 = 0
            int r5 = r3.getDimensionPixelSize(r5, r8)
            int r8 = com.google.android.material.R.styleable.NavigationView_itemMaxLines
            r9 = 1
            int r8 = r3.getInt(r8, r9)
            r0.setItemMaxLines(r8)
            com.google.android.material.navigation.NavigationView$2 r8 = new com.google.android.material.navigation.NavigationView$2
            r8.<init>()
            r10.setCallback(r8)
            r7.setId(r9)
            r7.initForMenu(r1, r10)
            if (r4 == 0) goto L_0x01fa
            r7.setSubheaderTextAppearance(r4)
        L_0x01fa:
            r7.setSubheaderColor(r2)
            r7.setItemIconTintList(r6)
            int r1 = r0.getOverScrollMode()
            r7.setOverScrollMode(r1)
            if (r11 == 0) goto L_0x020c
            r7.setItemTextAppearance(r11)
        L_0x020c:
            r7.setItemTextAppearanceActiveBoldEnabled(r12)
            r7.setItemTextColor(r13)
            r7.setItemBackground(r14)
            r7.setItemIconPadding(r5)
            r10.addMenuPresenter(r7)
            androidx.appcompat.view.menu.MenuView r1 = r7.getMenuView(r0)
            android.view.View r1 = (android.view.View) r1
            r0.addView(r1)
            int r1 = com.google.android.material.R.styleable.NavigationView_menu
            boolean r2 = r3.hasValue(r1)
            r8 = 0
            if (r2 == 0) goto L_0x0234
            int r1 = r3.getResourceId(r1, r8)
            r0.inflateMenu(r1)
        L_0x0234:
            int r1 = com.google.android.material.R.styleable.NavigationView_headerLayout
            boolean r2 = r3.hasValue(r1)
            if (r2 == 0) goto L_0x0243
            int r1 = r3.getResourceId(r1, r8)
            r0.inflateHeaderView(r1)
        L_0x0243:
            r3.recycle()
            r0.setupInsetScrimsListener()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
