package com.google.android.material.search;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public class SearchBar extends Toolbar {
    private static final int DEFAULT_SCROLL_FLAGS = 53;
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_SearchBar;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    /* access modifiers changed from: private */
    public final int backgroundColor;
    /* access modifiers changed from: private */
    public MaterialShapeDrawable backgroundShape;
    @Nullable
    private View centerView;
    private final boolean defaultMarginsEnabled;
    private final Drawable defaultNavigationIcon;
    private boolean defaultScrollFlagsEnabled;
    private final boolean forceDefaultNavigationOnClickListener;
    private final boolean layoutInflated;
    private final AppBarLayout.LiftOnScrollProgressListener liftColorListener;
    private boolean liftOnScroll;
    /* access modifiers changed from: private */
    @Nullable
    public final ColorStateList liftOnScrollColor;
    private int maxWidth;
    private int menuResId;
    @Nullable
    private ActionMenuView menuView;
    @Nullable
    private ImageButton navIconButton;
    @Nullable
    private Integer navigationIconTint;
    @Nullable
    private Drawable originalNavigationIconBackground;
    private final TextView placeholderTextView;
    private final SearchBarAnimationHelper searchBarAnimationHelper;
    private boolean textCentered;
    private final TextView textView;
    private final FrameLayout textViewContainer;
    private final boolean tintNavigationIcon;

    public static abstract class OnLoadAnimationCallback {
        public void onAnimationEnd() {
        }

        public void onAnimationStart() {
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        String text;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeString(this.text);
        }

        public SavedState(Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.text = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SearchBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addLiftOnScrollProgressListener() {
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists != null && this.liftOnScrollColor != null) {
            appBarLayoutParentIfExists.addLiftOnScrollProgressListener(this.liftColorListener);
        }
    }

    private int defaultIfZero(int i5, int i6) {
        return i5 == 0 ? i6 : i5;
    }

    @Nullable
    private ActionMenuView findOrGetMenuView() {
        if (this.menuView == null) {
            this.menuView = ToolbarUtils.getActionMenuView(this);
        }
        return this.menuView;
    }

    @Nullable
    private ImageButton findOrGetNavView() {
        if (this.navIconButton == null) {
            this.navIconButton = ToolbarUtils.getNavigationIconButton(this);
        }
        return this.navIconButton;
    }

    @Nullable
    private AppBarLayout getAppBarLayoutParentIfExists() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AppBarLayout) {
                return (AppBarLayout) parent;
            }
        }
        return null;
    }

    private void initBackground(ShapeAppearanceModel shapeAppearanceModel, @ColorInt int i5, float f5, float f6, @ColorInt int i6) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        this.backgroundShape = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(getContext());
        this.backgroundShape.setElevation(f5);
        if (f6 >= 0.0f) {
            this.backgroundShape.setStroke(f6, i6);
        }
        int color = MaterialColors.getColor(this, androidx.appcompat.R.attr.colorControlHighlight);
        this.backgroundShape.setFillColor(ColorStateList.valueOf(i5));
        ColorStateList valueOf = ColorStateList.valueOf(color);
        MaterialShapeDrawable materialShapeDrawable2 = this.backgroundShape;
        setBackground(new RippleDrawable(valueOf, materialShapeDrawable2, materialShapeDrawable2));
    }

    private void initNavigationIcon() {
        Drawable drawable;
        if (getNavigationIcon() == null) {
            drawable = this.defaultNavigationIcon;
        } else {
            drawable = getNavigationIcon();
        }
        setNavigationIcon(drawable);
        setNavigationIconDecorative(true);
    }

    private void initTextView(@StyleRes int i5, String str, String str2) {
        if (i5 != -1) {
            TextViewCompat.setTextAppearance(this.textView, i5);
            TextViewCompat.setTextAppearance(this.placeholderTextView, i5);
        }
        setText((CharSequence) str);
        setHint((CharSequence) str2);
        setTextCentered(this.textCentered);
    }

    private void layoutChild(View view, int i5, int i6, int i7, int i8) {
        if (getLayoutDirection() == 1) {
            view.layout(getMeasuredWidth() - i7, i6, getMeasuredWidth() - i5, i8);
        } else {
            view.layout(i5, i6, i7, i8);
        }
    }

    private void layoutTextViewCenterAvoidToolbarViewsAndPadding() {
        View view;
        int i5;
        int i6;
        int measuredWidth = (getMeasuredWidth() / 2) - (this.textViewContainer.getMeasuredWidth() / 2);
        int measuredWidth2 = this.textViewContainer.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (getMeasuredHeight() / 2) - (this.textViewContainer.getMeasuredHeight() / 2);
        int measuredHeight2 = this.textViewContainer.getMeasuredHeight() + measuredHeight;
        boolean z4 = true;
        if (getLayoutDirection() != 1) {
            z4 = false;
        }
        View findOrGetMenuView = findOrGetMenuView();
        View findOrGetNavView = findOrGetNavView();
        int measuredWidth3 = (this.textViewContainer.getMeasuredWidth() / 2) - (this.textView.getMeasuredWidth() / 2);
        int measuredWidth4 = this.textView.getMeasuredWidth() + measuredWidth3;
        int i7 = measuredWidth3 + measuredWidth;
        int i8 = measuredWidth4 + measuredWidth;
        if (z4) {
            view = findOrGetMenuView;
        } else {
            view = findOrGetNavView;
        }
        if (z4) {
            findOrGetMenuView = findOrGetNavView;
        }
        if (view != null) {
            i5 = Math.max(view.getRight() - i7, 0);
        } else {
            i5 = 0;
        }
        int i9 = i7 + i5;
        int i10 = i8 + i5;
        if (findOrGetMenuView != null) {
            i6 = Math.max(i10 - findOrGetMenuView.getLeft(), 0);
        } else {
            i6 = 0;
        }
        int i11 = i9 - i6;
        int i12 = i10 - i6;
        int max = ((i5 - i6) + Math.max(Math.max(getPaddingLeft() - i11, getContentInsetLeft() - i11), 0)) - Math.max(Math.max(i12 - (getMeasuredWidth() - getPaddingRight()), i12 - (getMeasuredWidth() - getContentInsetRight())), 0);
        this.textViewContainer.layout(measuredWidth + max, measuredHeight, measuredWidth2 + max, measuredHeight2);
    }

    private void layoutViewInCenter(View view) {
        if (view != null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
            int i5 = measuredWidth2 + measuredWidth;
            int measuredHeight = view.getMeasuredHeight();
            int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
            layoutChild(view, measuredWidth2, measuredHeight2, i5, measuredHeight2 + measuredHeight);
        }
    }

    @Nullable
    private Drawable maybeTintNavigationIcon(@Nullable Drawable drawable) {
        int i5;
        int i6;
        if (!this.tintNavigationIcon || drawable == null) {
            return drawable;
        }
        Integer num = this.navigationIconTint;
        if (num != null) {
            i5 = num.intValue();
        } else {
            if (drawable == this.defaultNavigationIcon) {
                i6 = R.attr.colorOnSurfaceVariant;
            } else {
                i6 = R.attr.colorOnSurface;
            }
            i5 = MaterialColors.getColor(this, i6);
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        wrap.setTint(i5);
        return wrap;
    }

    private void measureCenterView(int i5, int i6) {
        View view = this.centerView;
        if (view != null) {
            view.measure(i5, i6);
        }
    }

    private void removeLiftOnScrollProgressListener() {
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists != null) {
            appBarLayoutParentIfExists.removeLiftOnScrollProgressListener(this.liftColorListener);
        }
    }

    private void setDefaultMargins() {
        if (this.defaultMarginsEnabled && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = defaultIfZero(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = defaultIfZero(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = defaultIfZero(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = defaultIfZero(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void setHandwritingBoundsInsets() {
        int i5;
        int i6;
        if (Build.VERSION.SDK_INT >= 34) {
            boolean z4 = true;
            int i7 = 0;
            if (getLayoutDirection() != 1) {
                z4 = false;
            }
            ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
            if (navigationIconButton == null || !navigationIconButton.isClickable()) {
                i5 = 0;
            } else if (z4) {
                i5 = getWidth() - navigationIconButton.getLeft();
            } else {
                i5 = navigationIconButton.getRight();
            }
            ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(this);
            if (actionMenuView != null) {
                if (z4) {
                    i7 = actionMenuView.getRight();
                } else {
                    i7 = getWidth() - actionMenuView.getLeft();
                }
            }
            if (z4) {
                i6 = i7;
            } else {
                i6 = i5;
            }
            float f5 = (float) (-i6);
            if (!z4) {
                i5 = i7;
            }
            setHandwritingBoundsOffsets(f5, 0.0f, (float) (-i5), 0.0f);
        }
    }

    private void setNavigationIconDecorative(boolean z4) {
        Drawable drawable;
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
        if (navigationIconButton != null) {
            navigationIconButton.setClickable(!z4);
            navigationIconButton.setFocusable(!z4);
            Drawable background = navigationIconButton.getBackground();
            if (background != null) {
                this.originalNavigationIconBackground = background;
            }
            if (z4) {
                drawable = null;
            } else {
                drawable = this.originalNavigationIconBackground;
            }
            navigationIconButton.setBackgroundDrawable(drawable);
            setHandwritingBoundsInsets();
        }
    }

    private void setOrClearDefaultScrollFlags() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.defaultScrollFlagsEnabled) {
                if (layoutParams.getScrollFlags() == 0) {
                    layoutParams.setScrollFlags(53);
                }
            } else if (layoutParams.getScrollFlags() == 53) {
                layoutParams.setScrollFlags(0);
            }
        }
    }

    private void validateAttributes(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue(NAMESPACE_APP, CampaignEx.JSON_KEY_TITLE) != null) {
                throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
            } else if (attributeSet.getAttributeValue(NAMESPACE_APP, "subtitle") != null) {
                throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
            }
        }
    }

    public void addCollapseAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.searchBarAnimationHelper.addCollapseAnimationListener(animatorListenerAdapter);
    }

    public void addExpandAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.searchBarAnimationHelper.addExpandAnimationListener(animatorListenerAdapter);
    }

    public void addOnLoadAnimationCallback(@NonNull OnLoadAnimationCallback onLoadAnimationCallback) {
        this.searchBarAnimationHelper.addOnLoadAnimationCallback(onLoadAnimationCallback);
    }

    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (this.layoutInflated && this.centerView == null && !(view instanceof ActionMenuView)) {
            this.centerView = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i5, layoutParams);
    }

    public void clearText() {
        this.textView.setText("");
        this.placeholderTextView.setText("");
    }

    public boolean collapse(@NonNull View view) {
        return collapse(view, (AppBarLayout) null);
    }

    public boolean expand(@NonNull View view) {
        return expand(view, (AppBarLayout) null);
    }

    @Nullable
    public View getCenterView() {
        return this.centerView;
    }

    /* access modifiers changed from: package-private */
    public float getCompatElevation() {
        MaterialShapeDrawable materialShapeDrawable = this.backgroundShape;
        if (materialShapeDrawable != null) {
            return materialShapeDrawable.getElevation();
        }
        return getElevation();
    }

    public float getCornerSize() {
        return this.backgroundShape.getTopLeftCornerResolvedSize();
    }

    /* access modifiers changed from: protected */
    @DimenRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    /* access modifiers changed from: protected */
    @DrawableRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    @Nullable
    public CharSequence getHint() {
        return this.textView.getHint();
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    /* access modifiers changed from: package-private */
    public int getMenuResId() {
        return this.menuResId;
    }

    /* access modifiers changed from: package-private */
    public TextView getPlaceholderTextView() {
        return this.placeholderTextView;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.backgroundShape.getStrokeColor().getDefaultColor();
    }

    @Dimension
    public float getStrokeWidth() {
        return this.backgroundShape.getStrokeWidth();
    }

    @NonNull
    public CharSequence getText() {
        return this.textView.getText();
    }

    public boolean getTextCentered() {
        return this.textCentered;
    }

    @NonNull
    public TextView getTextView() {
        return this.textView;
    }

    public void inflateMenu(@MenuRes int i5) {
        super.inflateMenu(i5);
        this.menuResId = i5;
    }

    public boolean isCollapsing() {
        return this.searchBarAnimationHelper.isCollapsing();
    }

    public boolean isDefaultScrollFlagsEnabled() {
        return this.defaultScrollFlagsEnabled;
    }

    public boolean isExpanding() {
        return this.searchBarAnimationHelper.isExpanding();
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.searchBarAnimationHelper.isOnLoadAnimationFadeInEnabled();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.backgroundShape);
        setDefaultMargins();
        setOrClearDefaultScrollFlags();
        if (this.liftOnScroll) {
            addLiftOnScrollProgressListener();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeLiftOnScrollProgressListener();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        if (Build.VERSION.SDK_INT >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(isEmpty);
        }
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        View view = this.centerView;
        if (view != null) {
            layoutViewInCenter(view);
        }
        setHandwritingBoundsInsets();
        if (this.textView != null && this.textCentered) {
            layoutTextViewCenterAvoidToolbarViewsAndPadding();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7 = this.maxWidth;
        if (i7 >= 0 && i7 < View.MeasureSpec.getSize(i5)) {
            i5 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, View.MeasureSpec.getMode(i5));
        }
        super.onMeasure(i5, i6);
        measureCenterView(i5, i6);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText((CharSequence) savedState.text);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        String str;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        if (text == null) {
            str = null;
        } else {
            str = text.toString();
        }
        savedState.text = str;
        return savedState;
    }

    public boolean removeCollapseAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.searchBarAnimationHelper.removeCollapseAnimationListener(animatorListenerAdapter);
    }

    public boolean removeExpandAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.searchBarAnimationHelper.removeExpandAnimationListener(animatorListenerAdapter);
    }

    public boolean removeOnLoadAnimationCallback(@NonNull OnLoadAnimationCallback onLoadAnimationCallback) {
        return this.searchBarAnimationHelper.removeOnLoadAnimationCallback(onLoadAnimationCallback);
    }

    public void setCenterView(@Nullable View view) {
        View view2 = this.centerView;
        if (view2 != null) {
            removeView(view2);
            this.centerView = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z4) {
        this.defaultScrollFlagsEnabled = z4;
        setOrClearDefaultScrollFlags();
    }

    public void setElevation(float f5) {
        super.setElevation(f5);
        MaterialShapeDrawable materialShapeDrawable = this.backgroundShape;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f5);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.textView.setHint(charSequence);
    }

    public void setLiftOnScroll(boolean z4) {
        this.liftOnScroll = z4;
        if (z4) {
            addLiftOnScrollProgressListener();
        } else {
            removeLiftOnScrollProgressListener();
        }
    }

    public void setMaxWidth(@Px int i5) {
        if (this.maxWidth != i5) {
            this.maxWidth = i5;
            requestLayout();
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(maybeTintNavigationIcon(drawable));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        boolean z4;
        if (!this.forceDefaultNavigationOnClickListener) {
            super.setNavigationOnClickListener(onClickListener);
            if (onClickListener == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            setNavigationIconDecorative(z4);
        }
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z4) {
        this.searchBarAnimationHelper.setOnLoadAnimationFadeInEnabled(z4);
    }

    /* access modifiers changed from: package-private */
    public void setPlaceholderText(String str) {
        this.placeholderTextView.setText(str);
    }

    public void setStrokeColor(@ColorInt int i5) {
        if (getStrokeColor() != i5) {
            this.backgroundShape.setStrokeColor(ColorStateList.valueOf(i5));
        }
    }

    public void setStrokeWidth(@Dimension float f5) {
        if (getStrokeWidth() != f5) {
            this.backgroundShape.setStrokeWidth(f5);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(@Nullable CharSequence charSequence) {
        this.textView.setText(charSequence);
        this.placeholderTextView.setText(charSequence);
    }

    public void setTextCentered(boolean z4) {
        this.textCentered = z4;
        TextView textView2 = this.textView;
        if (textView2 != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView2.getLayoutParams();
            if (z4) {
                layoutParams.gravity = 1;
                this.textView.setGravity(1);
            } else {
                layoutParams.gravity = 0;
                this.textView.setGravity(0);
            }
            this.textView.setLayoutParams(layoutParams);
            this.placeholderTextView.setLayoutParams(layoutParams);
        }
    }

    public void setTitle(CharSequence charSequence) {
    }

    public void startOnLoadAnimation() {
        post(new C1546b(this));
    }

    public void stopOnLoadAnimation() {
        this.searchBarAnimationHelper.stopOnLoadAnimation(this);
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        private boolean initialized = false;

        public ScrollingViewBehavior() {
        }

        private void setAppBarLayoutTransparent(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            boolean onDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
            if (!this.initialized && (view2 instanceof AppBarLayout)) {
                this.initialized = true;
                setAppBarLayoutTransparent((AppBarLayout) view2);
            }
            return onDependentViewChanged;
        }

        /* access modifiers changed from: protected */
        public boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }

        public ScrollingViewBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public SearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSearchBarStyle);
    }

    public boolean collapse(@NonNull View view, @Nullable AppBarLayout appBarLayout) {
        return collapse(view, appBarLayout, false);
    }

    public boolean expand(@NonNull View view, @Nullable AppBarLayout appBarLayout) {
        return expand(view, appBarLayout, false);
    }

    public void setHint(@StringRes int i5) {
        this.textView.setHint(i5);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SearchBar(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r2 = r18
            r4 = r19
            int r5 = DEF_STYLE_RES
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r2, r4, r5)
            r0.<init>(r1, r2, r4)
            r7 = -1
            r0.menuResId = r7
            com.google.android.material.search.SearchBar$1 r1 = new com.google.android.material.search.SearchBar$1
            r1.<init>()
            r0.liftColorListener = r1
            android.content.Context r1 = r0.getContext()
            r0.validateAttributes(r2)
            int r3 = r0.getDefaultNavigationIconResource()
            android.graphics.drawable.Drawable r3 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r3)
            r0.defaultNavigationIcon = r3
            com.google.android.material.search.SearchBarAnimationHelper r3 = new com.google.android.material.search.SearchBarAnimationHelper
            r3.<init>()
            r0.searchBarAnimationHelper = r3
            int[] r3 = com.google.android.material.R.styleable.SearchBar
            r8 = 0
            int[] r6 = new int[r8]
            android.content.res.TypedArray r3 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r1, r2, r3, r4, r5, r6)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r2 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r1, (android.util.AttributeSet) r2, (int) r4, (int) r5)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.build()
            int r4 = com.google.android.material.R.styleable.SearchBar_backgroundTint
            int r4 = r3.getColor(r4, r8)
            r0.backgroundColor = r4
            int r5 = com.google.android.material.R.styleable.SearchBar_liftOnScrollColor
            android.content.res.ColorStateList r5 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r1, (android.content.res.TypedArray) r3, (int) r5)
            r0.liftOnScrollColor = r5
            int r5 = com.google.android.material.R.styleable.SearchBar_elevation
            r6 = 0
            float r5 = r3.getDimension(r5, r6)
            int r6 = com.google.android.material.R.styleable.SearchBar_defaultMarginsEnabled
            r9 = 1
            boolean r6 = r3.getBoolean(r6, r9)
            r0.defaultMarginsEnabled = r6
            int r6 = com.google.android.material.R.styleable.SearchBar_defaultScrollFlagsEnabled
            boolean r6 = r3.getBoolean(r6, r9)
            r0.defaultScrollFlagsEnabled = r6
            int r6 = com.google.android.material.R.styleable.SearchBar_hideNavigationIcon
            boolean r6 = r3.getBoolean(r6, r8)
            int r10 = com.google.android.material.R.styleable.SearchBar_forceDefaultNavigationOnClickListener
            boolean r10 = r3.getBoolean(r10, r8)
            r0.forceDefaultNavigationOnClickListener = r10
            int r10 = com.google.android.material.R.styleable.SearchBar_tintNavigationIcon
            boolean r10 = r3.getBoolean(r10, r9)
            r0.tintNavigationIcon = r10
            int r10 = com.google.android.material.R.styleable.SearchBar_navigationIconTint
            boolean r11 = r3.hasValue(r10)
            if (r11 == 0) goto L_0x0094
            int r10 = r3.getColor(r10, r7)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r0.navigationIconTint = r10
        L_0x0094:
            int r10 = com.google.android.material.R.styleable.SearchBar_android_textAppearance
            int r10 = r3.getResourceId(r10, r7)
            int r11 = com.google.android.material.R.styleable.SearchBar_android_text
            java.lang.String r11 = r3.getString(r11)
            int r12 = com.google.android.material.R.styleable.SearchBar_android_hint
            java.lang.String r12 = r3.getString(r12)
            int r13 = com.google.android.material.R.styleable.SearchBar_strokeWidth
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r13 = r3.getDimension(r13, r14)
            int r14 = com.google.android.material.R.styleable.SearchBar_strokeColor
            int r14 = r3.getColor(r14, r8)
            int r15 = com.google.android.material.R.styleable.SearchBar_textCentered
            boolean r15 = r3.getBoolean(r15, r8)
            r0.textCentered = r15
            int r15 = com.google.android.material.R.styleable.SearchBar_liftOnScroll
            boolean r8 = r3.getBoolean(r15, r8)
            r0.liftOnScroll = r8
            int r8 = com.google.android.material.R.styleable.SearchBar_android_maxWidth
            int r7 = r3.getDimensionPixelSize(r8, r7)
            r0.maxWidth = r7
            r3.recycle()
            if (r6 != 0) goto L_0x00d4
            r0.initNavigationIcon()
        L_0x00d4:
            r0.setClickable(r9)
            r0.setFocusable(r9)
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r3 = com.google.android.material.R.layout.mtrl_search_bar
            r1.inflate(r3, r0)
            r0.layoutInflated = r9
            int r1 = com.google.android.material.R.id.open_search_bar_text_view
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.textView = r1
            int r1 = com.google.android.material.R.id.open_search_bar_placeholder_text_view
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.placeholderTextView = r1
            int r1 = com.google.android.material.R.id.open_search_bar_text_view_container
            android.view.View r1 = r0.findViewById(r1)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            r0.textViewContainer = r1
            r0.setElevation(r5)
            r0.initTextView(r10, r11, r12)
            r1 = r2
            r2 = r4
            r3 = r5
            r4 = r13
            r5 = r14
            r0.initBackground(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public boolean collapse(@NonNull View view, @Nullable AppBarLayout appBarLayout, boolean z4) {
        if ((view.getVisibility() != 0 || isCollapsing()) && !isExpanding()) {
            return false;
        }
        this.searchBarAnimationHelper.startCollapseAnimation(this, view, appBarLayout, z4);
        return true;
    }

    public boolean expand(@NonNull View view, @Nullable AppBarLayout appBarLayout, boolean z4) {
        if ((view.getVisibility() == 0 || isExpanding()) && !isCollapsing()) {
            return false;
        }
        this.searchBarAnimationHelper.startExpandAnimation(this, view, appBarLayout, z4);
        return true;
    }

    public void setText(@StringRes int i5) {
        this.textView.setText(i5);
        this.placeholderTextView.setText(i5);
    }
}
