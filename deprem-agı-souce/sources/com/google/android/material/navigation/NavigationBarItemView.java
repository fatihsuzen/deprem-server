package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.BaselineLayout;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarItemView extends FrameLayout implements NavigationBarMenuItemView {
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_LABELED_TRANSFORM = new ActiveIndicatorTransform();
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new ActiveIndicatorUnlabeledTransform();
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int INVALID_ITEM_POSITION = -1;
    private ValueAnimator activeIndicatorAnimator;
    private int activeIndicatorDesiredHeight = 0;
    private int activeIndicatorDesiredWidth = 0;
    private boolean activeIndicatorEnabled = false;
    private int activeIndicatorExpandedDesiredHeight = 0;
    private int activeIndicatorExpandedDesiredWidth = -2;
    private int activeIndicatorExpandedMarginHorizontal = 0;
    private int activeIndicatorLabelPadding;
    private int activeIndicatorMarginHorizontal = 0;
    private float activeIndicatorProgress = 0.0f;
    private boolean activeIndicatorResizeable = false;
    private ActiveIndicatorTransform activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
    @NonNull
    private final View activeIndicatorView;
    @Nullable
    private BadgeDrawable badgeDrawable;
    private int badgeFixedEdge = 0;
    private boolean boldText = false;
    @NonNull
    private final LinearLayout contentContainer;
    private BaselineLayout currentLabelGroup;
    private boolean expanded = false;
    private BaselineLayout expandedLabelGroup;
    private float expandedLabelScaleDownFactor;
    private float expandedLabelScaleUpFactor;
    private float expandedLabelShiftAmountY;
    private TextView expandedLargeLabel;
    private TextView expandedSmallLabel;
    @StyleRes
    private int horizontalTextAppearanceActive = 0;
    @StyleRes
    private int horizontalTextAppearanceInactive = 0;
    private final ImageView icon;
    @NonNull
    private final FrameLayout iconContainer;
    private int iconLabelHorizontalSpacing;
    @Nullable
    private ColorStateList iconTint;
    private boolean initialized = false;
    @NonNull
    private final LinearLayout innerContentContainer;
    private boolean isShifting;
    private Rect itemActiveIndicatorExpandedPadding = new Rect();
    @Nullable
    Drawable itemBackground;
    @Nullable
    private MenuItemImpl itemData;
    private int itemGravity = 49;
    private int itemIconGravity;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private int itemPosition = -1;
    private ColorStateList itemRippleColor;
    private final BaselineLayout labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private boolean measurePaddingFromBaseline = false;
    private boolean onlyShowWhenExpanded = false;
    @Nullable
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private boolean scaleLabelSizeWithFont = false;
    private float scaleUpFactor;
    private float shiftAmountY;
    private final TextView smallLabel;
    @StyleRes
    private int textAppearanceActive = 0;
    @StyleRes
    private int textAppearanceInactive = 0;
    @Nullable
    private ColorStateList textColor;
    @Nullable
    private Drawable wrappedIconDrawable;

    private static class ActiveIndicatorTransform {
        private static final float ALPHA_FRACTION = 0.2f;
        private static final float SCALE_X_HIDDEN = 0.4f;
        private static final float SCALE_X_SHOWN = 1.0f;

        private ActiveIndicatorTransform() {
        }

        /* access modifiers changed from: protected */
        public float calculateAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
            float f7;
            float f8;
            int i5 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
            if (i5 == 0) {
                f7 = 0.8f;
            } else {
                f7 = 0.0f;
            }
            if (i5 == 0) {
                f8 = 1.0f;
            } else {
                f8 = 0.2f;
            }
            return AnimationUtils.lerp(0.0f, 1.0f, f7, f8, f5);
        }

        /* access modifiers changed from: protected */
        public float calculateScaleX(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
            return AnimationUtils.lerp((float) SCALE_X_HIDDEN, 1.0f, f5);
        }

        /* access modifiers changed from: protected */
        public float calculateScaleY(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
            return 1.0f;
        }

        public void updateForProgress(@FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6, @NonNull View view) {
            view.setScaleX(calculateScaleX(f5));
            view.setScaleY(calculateScaleY(f5));
            view.setAlpha(calculateAlpha(f5, f6));
        }
    }

    private static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        private ActiveIndicatorUnlabeledTransform() {
            super();
        }

        /* access modifiers changed from: protected */
        public float calculateScaleY(float f5) {
            return calculateScaleX(f5);
        }
    }

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(getItemLayoutResId(), this, true);
        this.contentContainer = (LinearLayout) findViewById(R.id.navigation_bar_item_content_container);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.navigation_bar_item_inner_content_container);
        this.innerContentContainer = linearLayout;
        this.activeIndicatorView = findViewById(R.id.navigation_bar_item_active_indicator_view);
        this.iconContainer = (FrameLayout) findViewById(R.id.navigation_bar_item_icon_container);
        this.icon = (ImageView) findViewById(R.id.navigation_bar_item_icon_view);
        BaselineLayout baselineLayout = (BaselineLayout) findViewById(R.id.navigation_bar_item_labels_group);
        this.labelGroup = baselineLayout;
        TextView textView = (TextView) findViewById(R.id.navigation_bar_item_small_label_view);
        this.smallLabel = textView;
        TextView textView2 = (TextView) findViewById(R.id.navigation_bar_item_large_label_view);
        this.largeLabel = textView2;
        initializeDefaultExpandedLabelGroupViews();
        this.currentLabelGroup = baselineLayout;
        setBackgroundResource(getItemBackgroundResId());
        this.itemPaddingTop = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.itemPaddingBottom = baselineLayout.getPaddingBottom();
        this.activeIndicatorLabelPadding = 0;
        this.iconLabelHorizontalSpacing = 0;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        this.expandedSmallLabel.setImportantForAccessibility(2);
        this.expandedLargeLabel.setImportantForAccessibility(2);
        setFocusable(true);
        calculateTextScaleFactors();
        this.activeIndicatorExpandedDesiredHeight = getResources().getDimensionPixelSize(R.dimen.m3_navigation_item_expanded_active_indicator_height_default);
        linearLayout.addOnLayoutChangeListener(new c(this));
    }

    public static /* synthetic */ void a(NavigationBarItemView navigationBarItemView, View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        boolean z4;
        if (navigationBarItemView.icon.getVisibility() == 0) {
            navigationBarItemView.tryUpdateBadgeBounds(navigationBarItemView.icon);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) navigationBarItemView.innerContentContainer.getLayoutParams();
        int i13 = (i7 - i5) + layoutParams.rightMargin + layoutParams.leftMargin;
        int i14 = (i8 - i6) + layoutParams.topMargin + layoutParams.bottomMargin;
        boolean z5 = true;
        if (navigationBarItemView.itemIconGravity == 1 && navigationBarItemView.activeIndicatorExpandedDesiredWidth == -2) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) navigationBarItemView.activeIndicatorView.getLayoutParams();
            if (navigationBarItemView.activeIndicatorExpandedDesiredWidth != -2 || navigationBarItemView.activeIndicatorView.getMeasuredWidth() == i13) {
                z4 = false;
            } else {
                layoutParams2.width = Math.max(i13, Math.min(navigationBarItemView.activeIndicatorDesiredWidth, navigationBarItemView.getMeasuredWidth() - (navigationBarItemView.activeIndicatorMarginHorizontal * 2)));
                z4 = true;
            }
            if (navigationBarItemView.activeIndicatorView.getMeasuredHeight() < i14) {
                layoutParams2.height = i14;
            } else {
                z5 = z4;
            }
            if (z5) {
                navigationBarItemView.activeIndicatorView.setLayoutParams(layoutParams2);
            }
        }
    }

    private void addDefaultExpandedLabelGroupViews() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.innerContentContainer.addView(this.expandedLabelGroup, layoutParams);
        setExpandedLabelGroupMargins();
    }

    private void calculateTextScaleFactors() {
        float textSize = this.smallLabel.getTextSize();
        float textSize2 = this.largeLabel.getTextSize();
        this.shiftAmountY = textSize - textSize2;
        this.scaleUpFactor = (textSize2 * 1.0f) / textSize;
        this.scaleDownFactor = (textSize * 1.0f) / textSize2;
        float textSize3 = this.expandedSmallLabel.getTextSize();
        float textSize4 = this.expandedLargeLabel.getTextSize();
        this.expandedLabelShiftAmountY = textSize3 - textSize4;
        this.expandedLabelScaleUpFactor = (textSize4 * 1.0f) / textSize3;
        this.expandedLabelScaleDownFactor = (textSize3 * 1.0f) / textSize4;
    }

    private static Drawable createItemBackgroundCompat(@NonNull ColorStateList colorStateList) {
        return new RippleDrawable(RippleUtils.convertToRippleDrawableColor(colorStateList), (Drawable) null, (Drawable) null);
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i5 = 0;
        for (int i6 = 0; i6 < indexOfChild; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i5++;
            }
        }
        return i5;
    }

    private int getSuggestedIconWidth() {
        int i5;
        BadgeDrawable badgeDrawable2 = this.badgeDrawable;
        if (badgeDrawable2 == null) {
            i5 = 0;
        } else {
            i5 = badgeDrawable2.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iconContainer.getLayoutParams();
        return Math.max(i5, layoutParams.leftMargin) + this.icon.getMeasuredWidth() + Math.max(i5, layoutParams.rightMargin);
    }

    private boolean hasBadge() {
        if (this.badgeDrawable != null) {
            return true;
        }
        return false;
    }

    private void initializeDefaultExpandedLabelGroupViews() {
        float dimension = getResources().getDimension(R.dimen.default_navigation_text_size);
        float dimension2 = getResources().getDimension(R.dimen.default_navigation_active_text_size);
        BaselineLayout baselineLayout = new BaselineLayout(getContext());
        this.expandedLabelGroup = baselineLayout;
        baselineLayout.setVisibility(8);
        this.expandedLabelGroup.setDuplicateParentStateEnabled(true);
        this.expandedLabelGroup.setMeasurePaddingFromBaseline(this.measurePaddingFromBaseline);
        TextView textView = new TextView(getContext());
        this.expandedSmallLabel = textView;
        textView.setMaxLines(1);
        TextView textView2 = this.expandedSmallLabel;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView2.setEllipsize(truncateAt);
        this.expandedSmallLabel.setDuplicateParentStateEnabled(true);
        this.expandedSmallLabel.setIncludeFontPadding(false);
        this.expandedSmallLabel.setGravity(16);
        this.expandedSmallLabel.setTextSize(dimension);
        TextView textView3 = new TextView(getContext());
        this.expandedLargeLabel = textView3;
        textView3.setMaxLines(1);
        this.expandedLargeLabel.setEllipsize(truncateAt);
        this.expandedLargeLabel.setDuplicateParentStateEnabled(true);
        this.expandedLargeLabel.setVisibility(4);
        this.expandedLargeLabel.setIncludeFontPadding(false);
        this.expandedLargeLabel.setGravity(16);
        this.expandedLargeLabel.setTextSize(dimension2);
        this.expandedLabelGroup.addView(this.expandedSmallLabel);
        this.expandedLabelGroup.addView(this.expandedLargeLabel);
    }

    private boolean isActiveIndicatorResizeableAndUnlabeled() {
        if (!this.activeIndicatorResizeable || this.labelVisibilityMode != 2) {
            return false;
        }
        return true;
    }

    private void maybeAnimateActiveIndicatorToProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f5) {
        if (!this.activeIndicatorEnabled || !this.initialized || !isAttachedToWindow()) {
            setActiveIndicatorProgress(f5, f5);
            return;
        }
        ValueAnimator valueAnimator = this.activeIndicatorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.activeIndicatorAnimator = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.activeIndicatorProgress, f5});
        this.activeIndicatorAnimator = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NavigationBarItemView.this.setActiveIndicatorProgress(((Float) valueAnimator.getAnimatedValue()).floatValue(), f5);
            }
        });
        this.activeIndicatorAnimator.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        this.activeIndicatorAnimator.setDuration((long) MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationLong2, getResources().getInteger(R.integer.material_motion_duration_long_1)));
        this.activeIndicatorAnimator.start();
    }

    private void refreshChecked() {
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null) {
            setChecked(menuItemImpl.isChecked());
        }
    }

    private void refreshItemBackground() {
        Drawable drawable = this.itemBackground;
        RippleDrawable rippleDrawable = null;
        boolean z4 = true;
        if (this.itemRippleColor != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.activeIndicatorEnabled && getActiveIndicatorDrawable() != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.itemRippleColor), (Drawable) null, activeIndicatorDrawable);
                z4 = false;
            } else if (drawable == null) {
                drawable = createItemBackgroundCompat(this.itemRippleColor);
            }
        }
        this.iconContainer.setPadding(0, 0, 0, 0);
        this.iconContainer.setForeground(rippleDrawable);
        setBackground(drawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z4);
        }
    }

    /* access modifiers changed from: private */
    public void setActiveIndicatorProgress(@FloatRange(from = 0.0d, to = 1.0d) float f5, float f6) {
        this.activeIndicatorTransform.updateForProgress(f5, f6, this.activeIndicatorView);
        this.activeIndicatorProgress = f5;
    }

    private void setExpandedLabelGroupMargins() {
        int i5;
        int i6;
        int i7 = 0;
        if (this.icon.getLayoutParams().width > 0) {
            i5 = this.iconLabelHorizontalSpacing;
        } else {
            i5 = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.expandedLabelGroup.getLayoutParams();
        if (layoutParams != null) {
            if (getLayoutDirection() == 1) {
                i6 = i5;
            } else {
                i6 = 0;
            }
            layoutParams.rightMargin = i6;
            if (getLayoutDirection() != 1) {
                i7 = i5;
            }
            layoutParams.leftMargin = i7;
        }
    }

    private void setLabelPivots(TextView textView) {
        textView.setPivotX((float) (textView.getWidth() / 2));
        textView.setPivotY((float) textView.getBaseline());
    }

    private void setLayoutConfigurationIconAndLabel(View view, View view2, float f5, float f6) {
        int i5;
        int i6;
        int i7;
        int i8;
        LinearLayout linearLayout = this.contentContainer;
        if (this.itemIconGravity == 0) {
            i5 = (int) (((float) this.itemPaddingTop) + f6);
        } else {
            i5 = 0;
        }
        setViewMarginAndGravity(linearLayout, i5, 0, this.itemGravity);
        LinearLayout linearLayout2 = this.innerContentContainer;
        int i9 = this.itemIconGravity;
        if (i9 == 0) {
            i6 = 0;
        } else {
            i6 = this.itemActiveIndicatorExpandedPadding.top;
        }
        if (i9 == 0) {
            i7 = 0;
        } else {
            i7 = this.itemActiveIndicatorExpandedPadding.bottom;
        }
        if (i9 == 0) {
            i8 = 17;
        } else {
            i8 = NavigationBarView.ITEM_GRAVITY_START_CENTER;
        }
        setViewMarginAndGravity(linearLayout2, i6, i7, i8);
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        this.currentLabelGroup.setVisibility(0);
        setViewScaleValues(view, 1.0f, 1.0f, 0);
        setViewScaleValues(view2, f5, f5, 4);
    }

    private void setLayoutConfigurationIconOnly() {
        int i5;
        LinearLayout linearLayout = this.contentContainer;
        int i6 = this.itemPaddingTop;
        if (this.itemIconGravity == 0) {
            i5 = 17;
        } else {
            i5 = this.itemGravity;
        }
        setViewMarginAndGravity(linearLayout, i6, i6, i5);
        setViewMarginAndGravity(this.innerContentContainer, 0, 0, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.currentLabelGroup.setVisibility(8);
    }

    private void setTextAppearanceForLabel(TextView textView, int i5) {
        if (this.scaleLabelSizeWithFont) {
            TextViewCompat.setTextAppearance(textView, i5);
        } else {
            setTextAppearanceWithoutFontScaling(textView, i5);
        }
    }

    private static void setTextAppearanceWithoutFontScaling(TextView textView, @StyleRes int i5) {
        TextViewCompat.setTextAppearance(textView, i5);
        int unscaledTextSize = MaterialResources.getUnscaledTextSize(textView.getContext(), i5, 0);
        if (unscaledTextSize != 0) {
            textView.setTextSize(0, (float) unscaledTextSize);
        }
    }

    private static void setViewMarginAndGravity(@NonNull View view, int i5, int i6, int i7) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i5;
        layoutParams.bottomMargin = i6;
        layoutParams.gravity = i7;
        view.setLayoutParams(layoutParams);
    }

    private static void setViewScaleValues(@NonNull View view, float f5, float f6, int i5) {
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setVisibility(i5);
    }

    private void tryAttachBadgeToAnchor(@Nullable View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view);
        }
    }

    private void tryRemoveBadgeFromAnchor(@Nullable View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
            }
            this.badgeDrawable = null;
        }
    }

    private void tryUpdateBadgeBounds(View view) {
        if (hasBadge()) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, (FrameLayout) null);
        }
    }

    private void updateActiveIndicatorTransform() {
        if (isActiveIndicatorResizeableAndUnlabeled()) {
            this.activeIndicatorTransform = ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
        } else {
            this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        }
    }

    private void updateActiveLabelBoldness() {
        TextView textView = this.largeLabel;
        textView.setTypeface(textView.getTypeface(), this.boldText ? 1 : 0);
        TextView textView2 = this.expandedLargeLabel;
        textView2.setTypeface(textView2.getTypeface(), this.boldText ? 1 : 0);
    }

    private void updateActiveLabelTextAppearance(@Nullable TextView textView, @StyleRes int i5) {
        if (textView != null) {
            setTextAppearanceForLabel(textView, i5);
            calculateTextScaleFactors();
            textView.setMinimumHeight(MaterialResources.getUnscaledLineHeight(textView.getContext(), i5, 0));
            ColorStateList colorStateList = this.textColor;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
            updateActiveLabelBoldness();
        }
    }

    private void updateInactiveLabelTextAppearance(@Nullable TextView textView, @StyleRes int i5) {
        if (textView != null) {
            setTextAppearanceForLabel(textView, i5);
            calculateTextScaleFactors();
            textView.setMinimumHeight(MaterialResources.getUnscaledLineHeight(textView.getContext(), i5, 0));
            ColorStateList colorStateList = this.textColor;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    private void updateItemIconGravity() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        this.badgeFixedEdge = 0;
        this.currentLabelGroup = this.labelGroup;
        int i11 = 8;
        if (this.itemIconGravity == 1) {
            if (this.expandedLabelGroup.getParent() == null) {
                addDefaultExpandedLabelGroupViews();
            }
            Rect rect = this.itemActiveIndicatorExpandedPadding;
            int i12 = rect.left;
            int i13 = rect.right;
            int i14 = rect.top;
            i10 = rect.bottom;
            this.badgeFixedEdge = 1;
            int i15 = this.activeIndicatorExpandedMarginHorizontal;
            this.currentLabelGroup = this.expandedLabelGroup;
            i5 = i14;
            i6 = i13;
            i7 = i12;
            i8 = i15;
            i9 = 0;
        } else {
            i10 = 0;
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i9 = 8;
            i11 = 0;
        }
        this.labelGroup.setVisibility(i11);
        this.expandedLabelGroup.setVisibility(i9);
        ((FrameLayout.LayoutParams) this.contentContainer.getLayoutParams()).gravity = this.itemGravity;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.innerContentContainer.getLayoutParams();
        layoutParams.leftMargin = i7;
        layoutParams.rightMargin = i6;
        layoutParams.topMargin = i5;
        layoutParams.bottomMargin = i10;
        setPadding(i8, 0, i8, 0);
        updateActiveIndicatorLayoutParams(getWidth());
    }

    private static void updateViewPaddingBottom(@NonNull View view, int i5) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i5);
    }

    private void updateVisibility() {
        int i5;
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null) {
            if (!menuItemImpl.isVisible() || (!this.expanded && this.onlyShowWhenExpanded)) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            setVisibility(i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        removeBadge();
        this.itemData = null;
        this.activeIndicatorProgress = 0.0f;
        this.initialized = false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.activeIndicatorEnabled) {
            this.iconContainer.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        return this.activeIndicatorView.getBackground();
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    @NonNull
    public BaselineLayout getExpandedLabelGroup() {
        return this.expandedLabelGroup;
    }

    /* access modifiers changed from: protected */
    @DrawableRes
    public int getItemBackgroundResId() {
        return R.drawable.mtrl_navigation_bar_item_background;
    }

    @Nullable
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    /* access modifiers changed from: protected */
    @DimenRes
    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    /* access modifiers changed from: protected */
    @LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    @NonNull
    public BaselineLayout getLabelGroup() {
        return this.labelGroup;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.contentContainer.getLayoutParams();
        return this.contentContainer.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        if (this.itemIconGravity == 1) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.innerContentContainer.getLayoutParams();
            return this.innerContentContainer.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams2.leftMargin + this.labelGroup.getMeasuredWidth() + layoutParams2.rightMargin);
    }

    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i5) {
        CharSequence charSequence;
        this.itemData = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
            charSequence = menuItemImpl.getTooltipText();
        } else {
            charSequence = menuItemImpl.getTitle();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
        updateVisibility();
        this.initialized = true;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public boolean isOnlyVisibleWhenExpanded() {
        return this.onlyShowWhenExpanded;
    }

    @NonNull
    public int[] onCreateDrawableState(int i5) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + 1);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.itemData.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable2 = this.badgeDrawable;
        if (badgeDrawable2 != null && badgeDrawable2.isVisible()) {
            CharSequence title = this.itemData.getTitle();
            if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(title + ", " + this.badgeDrawable.getContentDescription());
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(final int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        post(new Runnable() {
            public void run() {
                NavigationBarItemView.this.updateActiveIndicatorLayoutParams(i5);
            }
        });
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable drawable) {
        this.activeIndicatorView.setBackground(drawable);
        refreshItemBackground();
    }

    public void setActiveIndicatorEnabled(boolean z4) {
        int i5;
        this.activeIndicatorEnabled = z4;
        refreshItemBackground();
        View view = this.activeIndicatorView;
        if (z4) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        view.setVisibility(i5);
        requestLayout();
    }

    public void setActiveIndicatorExpandedHeight(int i5) {
        this.activeIndicatorExpandedDesiredHeight = i5;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorExpandedMarginHorizontal(@Px int i5) {
        this.activeIndicatorExpandedMarginHorizontal = i5;
        if (this.itemIconGravity == 1) {
            setPadding(i5, 0, i5, 0);
        }
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorExpandedPadding(@NonNull Rect rect) {
        this.itemActiveIndicatorExpandedPadding = rect;
    }

    public void setActiveIndicatorExpandedWidth(int i5) {
        this.activeIndicatorExpandedDesiredWidth = i5;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorHeight(int i5) {
        this.activeIndicatorDesiredHeight = i5;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i5) {
        int i6;
        if (this.activeIndicatorLabelPadding != i5) {
            this.activeIndicatorLabelPadding = i5;
            ((LinearLayout.LayoutParams) this.labelGroup.getLayoutParams()).topMargin = i5;
            if (this.expandedLabelGroup.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.expandedLabelGroup.getLayoutParams();
                if (getLayoutDirection() == 1) {
                    i6 = i5;
                } else {
                    i6 = 0;
                }
                layoutParams.rightMargin = i6;
                if (getLayoutDirection() == 1) {
                    i5 = 0;
                }
                layoutParams.leftMargin = i5;
                requestLayout();
            }
        }
    }

    public void setActiveIndicatorMarginHorizontal(@Px int i5) {
        this.activeIndicatorMarginHorizontal = i5;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z4) {
        this.activeIndicatorResizeable = z4;
    }

    public void setActiveIndicatorWidth(int i5) {
        this.activeIndicatorDesiredWidth = i5;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    /* access modifiers changed from: package-private */
    public void setBadge(@NonNull BadgeDrawable badgeDrawable2) {
        if (this.badgeDrawable != badgeDrawable2) {
            if (hasBadge() && this.icon != null) {
                Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
                tryRemoveBadgeFromAnchor(this.icon);
            }
            this.badgeDrawable = badgeDrawable2;
            badgeDrawable2.setBadgeFixedEdge(this.badgeFixedEdge);
            ImageView imageView = this.icon;
            if (imageView != null) {
                tryAttachBadgeToAnchor(imageView);
            }
        }
    }

    public void setCheckable(boolean z4) {
        refreshDrawableState();
    }

    public void setChecked(boolean z4) {
        float f5;
        setLabelPivots(this.largeLabel);
        setLabelPivots(this.smallLabel);
        setLabelPivots(this.expandedLargeLabel);
        setLabelPivots(this.expandedSmallLabel);
        if (z4) {
            f5 = 1.0f;
        } else {
            f5 = 0.0f;
        }
        maybeAnimateActiveIndicatorToProgress(f5);
        TextView textView = this.largeLabel;
        TextView textView2 = this.smallLabel;
        float f6 = this.shiftAmountY;
        float f7 = this.scaleUpFactor;
        float f8 = this.scaleDownFactor;
        if (this.itemIconGravity == 1) {
            textView = this.expandedLargeLabel;
            textView2 = this.expandedSmallLabel;
            f6 = this.expandedLabelShiftAmountY;
            f7 = this.expandedLabelScaleUpFactor;
            f8 = this.expandedLabelScaleDownFactor;
        }
        int i5 = this.labelVisibilityMode;
        if (i5 != -1) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        setLayoutConfigurationIconOnly();
                    }
                } else if (z4) {
                    setLayoutConfigurationIconAndLabel(textView, textView2, f7, f6);
                } else {
                    setLayoutConfigurationIconAndLabel(textView2, textView, f8, 0.0f);
                }
            } else if (z4) {
                setLayoutConfigurationIconAndLabel(textView, textView2, f7, 0.0f);
            } else {
                setLayoutConfigurationIconOnly();
            }
        } else if (this.isShifting) {
            if (z4) {
                setLayoutConfigurationIconAndLabel(textView, textView2, f7, 0.0f);
            } else {
                setLayoutConfigurationIconOnly();
            }
        } else if (z4) {
            setLayoutConfigurationIconAndLabel(textView, textView2, f7, f6);
        } else {
            setLayoutConfigurationIconAndLabel(textView2, textView, f8, 0.0f);
        }
        refreshDrawableState();
        setSelected(z4);
    }

    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        this.smallLabel.setEnabled(z4);
        this.largeLabel.setEnabled(z4);
        this.expandedSmallLabel.setEnabled(z4);
        this.expandedLargeLabel.setEnabled(z4);
        this.icon.setEnabled(z4);
    }

    public void setExpanded(boolean z4) {
        this.expanded = z4;
        updateVisibility();
    }

    public void setHorizontalTextAppearanceActive(@StyleRes int i5) {
        this.horizontalTextAppearanceActive = i5;
        TextView textView = this.expandedLargeLabel;
        if (i5 == 0) {
            i5 = this.textAppearanceActive;
        }
        updateActiveLabelTextAppearance(textView, i5);
    }

    public void setHorizontalTextAppearanceInactive(@StyleRes int i5) {
        this.horizontalTextAppearanceInactive = i5;
        TextView textView = this.expandedSmallLabel;
        if (i5 == 0) {
            i5 = this.textAppearanceInactive;
        }
        updateInactiveLabelTextAppearance(textView, i5);
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != this.originalIconDrawable) {
            this.originalIconDrawable = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                this.wrappedIconDrawable = drawable;
                ColorStateList colorStateList = this.iconTint;
                if (colorStateList != null) {
                    drawable.setTintList(colorStateList);
                }
            }
            this.icon.setImageDrawable(drawable);
        }
    }

    public void setIconLabelHorizontalSpacing(int i5) {
        if (this.iconLabelHorizontalSpacing != i5) {
            this.iconLabelHorizontalSpacing = i5;
            setExpandedLabelGroupMargins();
            requestLayout();
        }
    }

    public void setIconSize(int i5) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = i5;
        this.icon.setLayoutParams(layoutParams);
        setExpandedLabelGroupMargins();
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData != null && (drawable = this.wrappedIconDrawable) != null) {
            drawable.setTintList(colorStateList);
            this.wrappedIconDrawable.invalidateSelf();
        }
    }

    public void setItemBackground(int i5) {
        setItemBackground(i5 == 0 ? null : getContext().getDrawable(i5));
    }

    public void setItemGravity(int i5) {
        this.itemGravity = i5;
        requestLayout();
    }

    public void setItemIconGravity(int i5) {
        if (this.itemIconGravity != i5) {
            this.itemIconGravity = i5;
            updateItemIconGravity();
            refreshItemBackground();
        }
    }

    public void setItemPaddingBottom(int i5) {
        if (this.itemPaddingBottom != i5) {
            this.itemPaddingBottom = i5;
            refreshChecked();
        }
    }

    public void setItemPaddingTop(int i5) {
        if (this.itemPaddingTop != i5) {
            this.itemPaddingTop = i5;
            refreshChecked();
        }
    }

    public void setItemPosition(int i5) {
        this.itemPosition = i5;
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.itemRippleColor = colorStateList;
        refreshItemBackground();
    }

    public void setLabelFontScalingEnabled(boolean z4) {
        this.scaleLabelSizeWithFont = z4;
        setTextAppearanceActive(this.textAppearanceActive);
        setTextAppearanceInactive(this.textAppearanceInactive);
        setHorizontalTextAppearanceActive(this.horizontalTextAppearanceActive);
        setHorizontalTextAppearanceInactive(this.horizontalTextAppearanceInactive);
    }

    public void setLabelMaxLines(int i5) {
        this.smallLabel.setMaxLines(i5);
        this.largeLabel.setMaxLines(i5);
        this.expandedSmallLabel.setMaxLines(i5);
        this.expandedLargeLabel.setMaxLines(i5);
        if (Build.VERSION.SDK_INT > 34) {
            this.smallLabel.setGravity(17);
            this.largeLabel.setGravity(17);
        } else if (i5 > 1) {
            this.smallLabel.setEllipsize((TextUtils.TruncateAt) null);
            this.largeLabel.setEllipsize((TextUtils.TruncateAt) null);
            this.smallLabel.setGravity(17);
            this.largeLabel.setGravity(17);
        } else {
            this.smallLabel.setGravity(16);
            this.largeLabel.setGravity(16);
        }
        requestLayout();
    }

    public void setLabelVisibilityMode(int i5) {
        if (this.labelVisibilityMode != i5) {
            this.labelVisibilityMode = i5;
            updateActiveIndicatorTransform();
            updateActiveIndicatorLayoutParams(getWidth());
            refreshChecked();
        }
    }

    public void setMeasureBottomPaddingFromLabelBaseline(boolean z4) {
        this.measurePaddingFromBaseline = z4;
        this.labelGroup.setMeasurePaddingFromBaseline(z4);
        this.smallLabel.setIncludeFontPadding(z4);
        this.largeLabel.setIncludeFontPadding(z4);
        this.expandedLabelGroup.setMeasurePaddingFromBaseline(z4);
        this.expandedSmallLabel.setIncludeFontPadding(z4);
        this.expandedLargeLabel.setIncludeFontPadding(z4);
        requestLayout();
    }

    public void setOnlyShowWhenExpanded(boolean z4) {
        this.onlyShowWhenExpanded = z4;
        updateVisibility();
    }

    public void setShifting(boolean z4) {
        if (this.isShifting != z4) {
            this.isShifting = z4;
            refreshChecked();
        }
    }

    public void setShortcut(boolean z4, char c5) {
    }

    public void setTextAppearanceActive(@StyleRes int i5) {
        this.textAppearanceActive = i5;
        updateActiveLabelTextAppearance(this.largeLabel, i5);
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z4) {
        this.boldText = z4;
        setTextAppearanceActive(this.textAppearanceActive);
        setHorizontalTextAppearanceActive(this.horizontalTextAppearanceActive);
        updateActiveLabelBoldness();
    }

    public void setTextAppearanceInactive(@StyleRes int i5) {
        this.textAppearanceInactive = i5;
        updateInactiveLabelTextAppearance(this.smallLabel, i5);
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
            this.expandedSmallLabel.setTextColor(colorStateList);
            this.expandedLargeLabel.setTextColor(colorStateList);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        this.expandedSmallLabel.setText(charSequence);
        this.expandedLargeLabel.setText(charSequence);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.itemData;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    public boolean showsIcon() {
        return true;
    }

    public void updateActiveIndicatorLayoutParams(int i5) {
        if (i5 > 0 || getVisibility() != 0) {
            int min = Math.min(this.activeIndicatorDesiredWidth, i5 - (this.activeIndicatorMarginHorizontal * 2));
            int i6 = this.activeIndicatorDesiredHeight;
            if (this.itemIconGravity == 1) {
                int i7 = i5 - (this.activeIndicatorExpandedMarginHorizontal * 2);
                int i8 = this.activeIndicatorExpandedDesiredWidth;
                if (i8 != -1) {
                    if (i8 == -2) {
                        i7 = this.contentContainer.getMeasuredWidth();
                    } else {
                        i7 = Math.min(i8, i7);
                    }
                }
                min = i7;
                i6 = Math.max(this.activeIndicatorExpandedDesiredHeight, this.innerContentContainer.getMeasuredHeight());
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.activeIndicatorView.getLayoutParams();
            if (isActiveIndicatorResizeableAndUnlabeled()) {
                i6 = min;
            }
            layoutParams.height = i6;
            layoutParams.width = Math.max(0, min);
            this.activeIndicatorView.setLayoutParams(layoutParams);
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.itemBackground = drawable;
        refreshItemBackground();
    }
}
