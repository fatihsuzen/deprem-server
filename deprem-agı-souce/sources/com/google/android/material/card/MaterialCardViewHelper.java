package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.cardview.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final Drawable CHECKED_ICON_NONE;
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    public static final int DEFAULT_FADE_ANIM_DURATION = 300;
    private static final int DEFAULT_STROKE_VALUE = -1;
    @NonNull
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;
    private float checkedAnimationProgress = 0.0f;
    @Nullable
    private Drawable checkedIcon;
    private int checkedIconGravity;
    @Dimension
    private int checkedIconMargin;
    @Dimension
    private int checkedIconSize;
    @Nullable
    private ColorStateList checkedIconTint;
    @Nullable
    private LayerDrawable clickableForegroundDrawable;
    @Nullable
    private Drawable fgDrawable;
    @NonNull
    private final MaterialShapeDrawable foregroundContentDrawable;
    @Nullable
    private MaterialShapeDrawable foregroundShapeDrawable;
    @Nullable
    private ValueAnimator iconAnimator;
    private final TimeInterpolator iconFadeAnimInterpolator;
    private final int iconFadeInAnimDuration;
    private final int iconFadeOutAnimDuration;
    private boolean isBackgroundOverwritten = false;
    @NonNull
    private final MaterialCardView materialCardView;
    @Nullable
    private ColorStateList rippleColor;
    @Nullable
    private Drawable rippleDrawable;
    @Nullable
    private ShapeAppearanceModel shapeAppearanceModel;
    @Nullable
    private ColorStateList strokeColor;
    @Dimension
    private int strokeWidth;
    @NonNull
    private final Rect userContentPadding = new Rect();

    static {
        ColorDrawable colorDrawable;
        if (Build.VERSION.SDK_INT <= 28) {
            colorDrawable = new ColorDrawable();
        } else {
            colorDrawable = null;
        }
        CHECKED_ICON_NONE = colorDrawable;
    }

    public MaterialCardViewHelper(@NonNull MaterialCardView materialCardView2, AttributeSet attributeSet, int i5, @StyleRes int i6) {
        this.materialCardView = materialCardView2;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView2.getContext(), attributeSet, i5, i6);
        this.bgDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView2.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray obtainStyledAttributes = materialCardView2.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i5, R.style.CardView);
        int i7 = R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i7)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(i7, 0.0f));
        }
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(builder.build());
        this.iconFadeAnimInterpolator = MotionUtils.resolveThemeInterpolator(materialCardView2.getContext(), com.google.android.material.R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.iconFadeInAnimDuration = MotionUtils.resolveThemeDuration(materialCardView2.getContext(), com.google.android.material.R.attr.motionDurationShort2, DEFAULT_FADE_ANIM_DURATION);
        this.iconFadeOutAnimDuration = MotionUtils.resolveThemeDuration(materialCardView2.getContext(), com.google.android.material.R.attr.motionDurationShort1, DEFAULT_FADE_ANIM_DURATION);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void a(MaterialCardViewHelper materialCardViewHelper, ValueAnimator valueAnimator) {
        materialCardViewHelper.getClass();
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialCardViewHelper.checkedIcon.setAlpha((int) (255.0f * floatValue));
        materialCardViewHelper.checkedAnimationProgress = floatValue;
    }

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment cornerTreatment, float f5) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - COS_45) * ((double) f5));
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f5 / 2.0f;
        }
        return 0.0f;
    }

    private float calculateHorizontalBackgroundPadding() {
        float f5;
        float maxCardElevation = this.materialCardView.getMaxCardElevation();
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            f5 = calculateActualCornerPadding();
        } else {
            f5 = 0.0f;
        }
        return maxCardElevation + f5;
    }

    private float calculateVerticalBackgroundPadding() {
        float f5;
        float maxCardElevation = this.materialCardView.getMaxCardElevation() * CARD_VIEW_SHADOW_MULTIPLIER;
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            f5 = calculateActualCornerPadding();
        } else {
            f5 = 0.0f;
        }
        return maxCardElevation + f5;
    }

    private boolean canClipToOutline() {
        return this.bgDrawable.isRoundRect();
    }

    @NonNull
    private Drawable createForegroundRippleDrawable() {
        this.foregroundShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        return new RippleDrawable(this.rippleColor, (Drawable) null, this.foregroundShapeDrawable);
    }

    @NonNull
    private Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.rippleDrawable = createForegroundRippleDrawable();
        }
        if (this.clickableForegroundDrawable == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, this.checkedIcon});
            this.clickableForegroundDrawable = layerDrawable;
            layerDrawable.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
        }
        return this.clickableForegroundDrawable;
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (!this.materialCardView.getPreventCornerOverlap() || !this.materialCardView.getUseCompatPadding()) {
            return 0.0f;
        }
        return (float) ((1.0d - COS_45) * ((double) this.materialCardView.getCardViewRadius()));
    }

    @NonNull
    private Drawable insetDrawable(Drawable drawable) {
        int i5;
        int i6;
        if (this.materialCardView.getUseCompatPadding()) {
            i5 = (int) Math.ceil((double) calculateVerticalBackgroundPadding());
            i6 = (int) Math.ceil((double) calculateHorizontalBackgroundPadding());
        } else {
            i6 = 0;
            i5 = 0;
        }
        return new InsetDrawable(drawable, i6, i5, i6, i5) {
            public int getMinimumHeight() {
                return -1;
            }

            public int getMinimumWidth() {
                return -1;
            }

            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private boolean isCheckedIconBottom() {
        if ((this.checkedIconGravity & 80) == 80) {
            return true;
        }
        return false;
    }

    private boolean isCheckedIconEnd() {
        if ((this.checkedIconGravity & GravityCompat.END) == 8388613) {
            return true;
        }
        return false;
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        if (!this.materialCardView.getPreventCornerOverlap() || canClipToOutline()) {
            return false;
        }
        return true;
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        if (!this.materialCardView.getPreventCornerOverlap() || !canClipToOutline() || !this.materialCardView.getUseCompatPadding()) {
            return false;
        }
        return true;
    }

    private boolean shouldUseClickableForeground() {
        if (this.materialCardView.isClickable()) {
            return true;
        }
        View view = this.materialCardView;
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    private void updateInsetForeground(Drawable drawable) {
        if (this.materialCardView.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
        } else {
            this.materialCardView.setForeground(insetDrawable(drawable));
        }
    }

    private void updateRippleColor() {
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            ((RippleDrawable) drawable).setColor(this.rippleColor);
        }
    }

    public void animateCheckedIcon(boolean z4) {
        float f5;
        float f6;
        int i5;
        if (z4) {
            f5 = 1.0f;
        } else {
            f5 = 0.0f;
        }
        if (z4) {
            f6 = 1.0f - this.checkedAnimationProgress;
        } else {
            f6 = this.checkedAnimationProgress;
        }
        ValueAnimator valueAnimator = this.iconAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.iconAnimator = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.checkedAnimationProgress, f5});
        this.iconAnimator = ofFloat;
        ofFloat.addUpdateListener(new a(this));
        this.iconAnimator.setInterpolator(this.iconFadeAnimInterpolator);
        ValueAnimator valueAnimator2 = this.iconAnimator;
        if (z4) {
            i5 = this.iconFadeInAnimDuration;
        } else {
            i5 = this.iconFadeOutAnimDuration;
        }
        valueAnimator2.setDuration((long) (((float) i5) * f6));
        this.iconAnimator.start();
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(api = 23)
    public void forceRippleRedraw() {
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i5 = bounds.bottom;
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i5 - 1);
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i5);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    /* access modifiers changed from: package-private */
    public int getCheckedIconGravity() {
        return this.checkedIconGravity;
    }

    /* access modifiers changed from: package-private */
    @Dimension
    public int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    /* access modifiers changed from: package-private */
    @Dimension
    public int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    /* access modifiers changed from: package-private */
    public float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    /* access modifiers changed from: package-private */
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int getStrokeColor() {
        ColorStateList colorStateList = this.strokeColor;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    /* access modifiers changed from: package-private */
    @Dimension
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    /* access modifiers changed from: package-private */
    public boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    /* access modifiers changed from: package-private */
    public boolean isCheckable() {
        return this.checkable;
    }

    /* access modifiers changed from: package-private */
    public void loadFromAttributes(@NonNull TypedArray typedArray) {
        Drawable drawable;
        ColorStateList colorStateList = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = colorStateList;
        if (colorStateList == null) {
            this.strokeColor = ColorStateList.valueOf(-1);
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z4 = typedArray.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = z4;
        this.materialCardView.setLongClickable(z4);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        setCheckedIconSize(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconSize, 0));
        setCheckedIconMargin(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconMargin, 0));
        this.checkedIconGravity = typedArray.getInteger(com.google.android.material.R.styleable.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = colorStateList2;
        if (colorStateList2 == null) {
            this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, androidx.appcompat.R.attr.colorControlHighlight));
        }
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        if (shouldUseClickableForeground()) {
            drawable = getClickableForeground();
        } else {
            drawable = this.foregroundContentDrawable;
        }
        this.fgDrawable = drawable;
        this.materialCardView.setForeground(insetDrawable(drawable));
    }

    /* access modifiers changed from: package-private */
    public void recalculateCheckedIconPosition(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (this.clickableForegroundDrawable != null) {
            if (this.materialCardView.getUseCompatPadding()) {
                i8 = (int) Math.ceil((double) (calculateVerticalBackgroundPadding() * 2.0f));
                i7 = (int) Math.ceil((double) (calculateHorizontalBackgroundPadding() * 2.0f));
            } else {
                i8 = 0;
                i7 = 0;
            }
            if (isCheckedIconEnd()) {
                i9 = ((i5 - this.checkedIconMargin) - this.checkedIconSize) - i7;
            } else {
                i9 = this.checkedIconMargin;
            }
            if (isCheckedIconBottom()) {
                i10 = this.checkedIconMargin;
            } else {
                i10 = ((i6 - this.checkedIconMargin) - this.checkedIconSize) - i8;
            }
            int i15 = i10;
            if (isCheckedIconEnd()) {
                i11 = this.checkedIconMargin;
            } else {
                i11 = ((i5 - this.checkedIconMargin) - this.checkedIconSize) - i7;
            }
            if (isCheckedIconBottom()) {
                i12 = ((i6 - this.checkedIconMargin) - this.checkedIconSize) - i8;
            } else {
                i12 = this.checkedIconMargin;
            }
            int i16 = i12;
            if (this.materialCardView.getLayoutDirection() == 1) {
                i14 = i11;
                i13 = i9;
            } else {
                i13 = i11;
                i14 = i9;
            }
            this.clickableForegroundDrawable.setLayerInset(2, i14, i16, i13, i15);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundOverwritten(boolean z4) {
        this.isBackgroundOverwritten = z4;
    }

    /* access modifiers changed from: package-private */
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.bgDrawable.setFillColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void setCheckable(boolean z4) {
        this.checkable = z4;
    }

    public void setChecked(boolean z4) {
        setChecked(z4, false);
    }

    /* access modifiers changed from: package-private */
    public void setCheckedIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.checkedIcon = mutate;
            mutate.setTintList(this.checkedIconTint);
            setChecked(this.materialCardView.isChecked());
        } else {
            this.checkedIcon = CHECKED_ICON_NONE;
        }
        LayerDrawable layerDrawable = this.clickableForegroundDrawable;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, this.checkedIcon);
        }
    }

    /* access modifiers changed from: package-private */
    public void setCheckedIconGravity(int i5) {
        this.checkedIconGravity = i5;
        recalculateCheckedIconPosition(this.materialCardView.getMeasuredWidth(), this.materialCardView.getMeasuredHeight());
    }

    /* access modifiers changed from: package-private */
    public void setCheckedIconMargin(@Dimension int i5) {
        this.checkedIconMargin = i5;
    }

    /* access modifiers changed from: package-private */
    public void setCheckedIconSize(@Dimension int i5) {
        this.checkedIconSize = i5;
    }

    /* access modifiers changed from: package-private */
    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.checkedIconTint = colorStateList;
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void setCornerRadius(float f5) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(f5));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
            updateContentPadding();
        }
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            updateInsets();
        }
    }

    /* access modifiers changed from: package-private */
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
        this.bgDrawable.setInterpolation(f5);
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f5);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f5);
        }
    }

    /* access modifiers changed from: package-private */
    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.rippleColor = colorStateList;
        updateRippleColor();
    }

    /* access modifiers changed from: package-private */
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        this.bgDrawable.setShapeAppearanceModel(shapeAppearanceModel2);
        MaterialShapeDrawable materialShapeDrawable = this.bgDrawable;
        materialShapeDrawable.setShadowBitmapDrawingEnable(!materialShapeDrawable.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundContentDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel2);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.foregroundShapeDrawable;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel2);
        }
    }

    /* access modifiers changed from: package-private */
    public void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            updateStroke();
        }
    }

    /* access modifiers changed from: package-private */
    public void setStrokeWidth(@Dimension int i5) {
        if (i5 != this.strokeWidth) {
            this.strokeWidth = i5;
            updateStroke();
        }
    }

    /* access modifiers changed from: package-private */
    public void setUserContentPadding(int i5, int i6, int i7, int i8) {
        this.userContentPadding.set(i5, i6, i7, i8);
        updateContentPadding();
    }

    /* access modifiers changed from: package-private */
    public void updateClickable() {
        Drawable drawable;
        Drawable drawable2 = this.fgDrawable;
        if (shouldUseClickableForeground()) {
            drawable = getClickableForeground();
        } else {
            drawable = this.foregroundContentDrawable;
        }
        this.fgDrawable = drawable;
        if (drawable2 != drawable) {
            updateInsetForeground(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateContentPadding() {
        float f5;
        if (shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground()) {
            f5 = calculateActualCornerPadding();
        } else {
            f5 = 0.0f;
        }
        int parentCardViewCalculatedCornerPadding = (int) (f5 - getParentCardViewCalculatedCornerPadding());
        MaterialCardView materialCardView2 = this.materialCardView;
        Rect rect = this.userContentPadding;
        materialCardView2.setAncestorContentPadding(rect.left + parentCardViewCalculatedCornerPadding, rect.top + parentCardViewCalculatedCornerPadding, rect.right + parentCardViewCalculatedCornerPadding, rect.bottom + parentCardViewCalculatedCornerPadding);
    }

    /* access modifiers changed from: package-private */
    public void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    /* access modifiers changed from: package-private */
    public void updateInsets() {
        if (!isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    /* access modifiers changed from: package-private */
    public void updateStroke() {
        this.foregroundContentDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
    }

    public void setChecked(boolean z4, boolean z5) {
        Drawable drawable = this.checkedIcon;
        if (drawable == null) {
            return;
        }
        if (z5) {
            animateCheckedIcon(z4);
            return;
        }
        drawable.setAlpha(z4 ? 255 : 0);
        this.checkedAnimationProgress = z4 ? 1.0f : 0.0f;
    }
}
