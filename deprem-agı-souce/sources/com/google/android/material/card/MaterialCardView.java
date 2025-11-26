package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MaterialCardView extends CardView implements Checkable, Shapeable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    private static final int[] CHECKABLE_STATE_SET = {16842911};
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_END = 8388693;
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_START = 8388691;
    public static final int CHECKED_ICON_GRAVITY_TOP_END = 8388661;
    public static final int CHECKED_ICON_GRAVITY_TOP_START = 8388659;
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_CardView;
    private static final int[] DRAGGED_STATE_SET = {R.attr.state_dragged};
    private static final String LOG_TAG = "MaterialCardView";
    @NonNull
    private final MaterialCardViewHelper cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private OnCheckedChangeListener onCheckedChangeListener;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedIconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView materialCardView, boolean z4);
    }

    public MaterialCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void forceRippleRedrawIfNeeded() {
        if (Build.VERSION.SDK_INT > 26) {
            this.cardViewHelper.forceRippleRedraw();
        }
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.cardViewHelper.getBackground().getBounds());
        return rectF;
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.getCardBackgroundColor();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.getCardForegroundColor();
    }

    /* access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.cardViewHelper.getCheckedIcon();
    }

    public int getCheckedIconGravity() {
        return this.cardViewHelper.getCheckedIconGravity();
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.cardViewHelper.getCheckedIconMargin();
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.cardViewHelper.getCheckedIconSize();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.getCheckedIconTint();
    }

    public int getContentPaddingBottom() {
        return this.cardViewHelper.getUserContentPadding().bottom;
    }

    public int getContentPaddingLeft() {
        return this.cardViewHelper.getUserContentPadding().left;
    }

    public int getContentPaddingRight() {
        return this.cardViewHelper.getUserContentPadding().right;
    }

    public int getContentPaddingTop() {
        return this.cardViewHelper.getUserContentPadding().top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.cardViewHelper.getProgress();
    }

    public float getRadius() {
        return this.cardViewHelper.getCornerRadius();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.getRippleColor();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.getShapeAppearanceModel();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.getStrokeColorStateList();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    public boolean isCheckable() {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper == null || !materialCardViewHelper.isCheckable()) {
            return false;
        }
        return true;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isDragged() {
        return this.dragged;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.cardViewHelper.updateClickable();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.cardViewHelper.getBackground());
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i5) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + 3);
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        if (isDragged()) {
            View.mergeDrawableStates(onCreateDrawableState, DRAGGED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        this.cardViewHelper.recalculateCheckedIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    /* access modifiers changed from: package-private */
    public void setAncestorContentPadding(int i5, int i6, int i7, int i8) {
        super.setContentPadding(i5, i6, i7, i8);
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.isParentCardViewDoneInitializing) {
            if (!this.cardViewHelper.isBackgroundOverwritten()) {
                Log.i(LOG_TAG, "Setting a custom background is not supported.");
                this.cardViewHelper.setBackgroundOverwritten(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setCardBackgroundColor(@ColorInt int i5) {
        this.cardViewHelper.setCardBackgroundColor(ColorStateList.valueOf(i5));
    }

    public void setCardElevation(float f5) {
        super.setCardElevation(f5);
        this.cardViewHelper.updateElevation();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.setCardForegroundColor(colorStateList);
    }

    public void setCheckable(boolean z4) {
        this.cardViewHelper.setCheckable(z4);
    }

    public void setChecked(boolean z4) {
        if (this.checked != z4) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.cardViewHelper.setCheckedIcon(drawable);
    }

    public void setCheckedIconGravity(int i5) {
        if (this.cardViewHelper.getCheckedIconGravity() != i5) {
            this.cardViewHelper.setCheckedIconGravity(i5);
        }
    }

    public void setCheckedIconMargin(@Dimension int i5) {
        this.cardViewHelper.setCheckedIconMargin(i5);
    }

    public void setCheckedIconMarginResource(@DimenRes int i5) {
        if (i5 != -1) {
            this.cardViewHelper.setCheckedIconMargin(getResources().getDimensionPixelSize(i5));
        }
    }

    public void setCheckedIconResource(@DrawableRes int i5) {
        this.cardViewHelper.setCheckedIcon(AppCompatResources.getDrawable(getContext(), i5));
    }

    public void setCheckedIconSize(@Dimension int i5) {
        this.cardViewHelper.setCheckedIconSize(i5);
    }

    public void setCheckedIconSizeResource(@DimenRes int i5) {
        if (i5 != 0) {
            this.cardViewHelper.setCheckedIconSize(getResources().getDimensionPixelSize(i5));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.setCheckedIconTint(colorStateList);
    }

    public void setClickable(boolean z4) {
        super.setClickable(z4);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper != null) {
            materialCardViewHelper.updateClickable();
        }
    }

    public void setContentPadding(int i5, int i6, int i7, int i8) {
        this.cardViewHelper.setUserContentPadding(i5, i6, i7, i8);
    }

    public void setDragged(boolean z4) {
        if (this.dragged != z4) {
            this.dragged = z4;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            invalidate();
        }
    }

    public void setMaxCardElevation(float f5) {
        super.setMaxCardElevation(f5);
        this.cardViewHelper.updateInsets();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
    }

    public void setPreventCornerOverlap(boolean z4) {
        super.setPreventCornerOverlap(z4);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
        this.cardViewHelper.setProgress(f5);
    }

    public void setRadius(float f5) {
        super.setRadius(f5);
        this.cardViewHelper.setCornerRadius(f5);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.setRippleColor(colorStateList);
    }

    public void setRippleColorResource(@ColorRes int i5) {
        this.cardViewHelper.setRippleColor(AppCompatResources.getColorStateList(getContext(), i5));
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.isRoundRect(getBoundsAsRectF()));
        this.cardViewHelper.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setStrokeColor(@ColorInt int i5) {
        setStrokeColor(ColorStateList.valueOf(i5));
    }

    public void setStrokeWidth(@Dimension int i5) {
        this.cardViewHelper.setStrokeWidth(i5);
        invalidate();
    }

    public void setUseCompatPadding(boolean z4) {
        super.setUseCompatPadding(z4);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.checked = !this.checked;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            this.cardViewHelper.setChecked(this.checked, true);
            OnCheckedChangeListener onCheckedChangeListener2 = this.onCheckedChangeListener;
            if (onCheckedChangeListener2 != null) {
                onCheckedChangeListener2.onCheckedChanged(this, this.checked);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.setCardBackgroundColor(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.cardViewHelper.setStrokeColor(colorStateList);
        invalidate();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCardView(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            r7 = 0
            r6.checked = r7
            r6.dragged = r7
            r0 = 1
            r6.isParentCardViewDoneInitializing = r0
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialCardView
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r7 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            com.google.android.material.card.MaterialCardViewHelper r8 = new com.google.android.material.card.MaterialCardViewHelper
            r8.<init>(r6, r1, r3, r4)
            r6.cardViewHelper = r8
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r8.setCardBackgroundColor(r9)
            int r9 = super.getContentPaddingLeft()
            int r0 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r8.setUserContentPadding(r9, r0, r1, r2)
            r8.loadFromAttributes(r7)
            r7.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
