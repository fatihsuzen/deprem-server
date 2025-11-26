package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.StateListShapeAppearanceModel;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialButtonHelper {
    private boolean backgroundOverwritten = false;
    @Nullable
    private ColorStateList backgroundTint;
    @Nullable
    private PorterDuff.Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private boolean cornerRadiusSet = false;
    @Nullable
    private SpringForce cornerSpringForce;
    private int elevation;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;
    @Nullable
    private Drawable maskDrawable;
    private final MaterialButton materialButton;
    @Nullable
    private MaterialShapeDrawable.OnCornerSizeChangeListener onCornerSizeChangeListener;
    @Nullable
    private ColorStateList rippleColor;
    private LayerDrawable rippleDrawable;
    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;
    private boolean shouldDrawSurfaceColorStroke = false;
    @Nullable
    private StateListShapeAppearanceModel stateListShapeAppearanceModel;
    @Nullable
    private ColorStateList strokeColor;
    private int strokeWidth;
    private boolean toggleCheckedStateOnClick = true;

    MaterialButtonHelper(MaterialButton materialButton2, @NonNull ShapeAppearanceModel shapeAppearanceModel2) {
        this.materialButton = materialButton2;
        this.shapeAppearanceModel = shapeAppearanceModel2;
    }

    private Drawable createBackground() {
        int i5;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        StateListShapeAppearanceModel stateListShapeAppearanceModel2 = this.stateListShapeAppearanceModel;
        if (stateListShapeAppearanceModel2 != null) {
            materialShapeDrawable.setStateListShapeAppearanceModel(stateListShapeAppearanceModel2);
        }
        SpringForce springForce = this.cornerSpringForce;
        if (springForce != null) {
            materialShapeDrawable.setCornerSpringForce(springForce);
        }
        MaterialShapeDrawable.OnCornerSizeChangeListener onCornerSizeChangeListener2 = this.onCornerSizeChangeListener;
        if (onCornerSizeChangeListener2 != null) {
            materialShapeDrawable.setOnCornerSizeChangeListener(onCornerSizeChangeListener2);
        }
        materialShapeDrawable.initializeElevationOverlay(this.materialButton.getContext());
        materialShapeDrawable.setTintList(this.backgroundTint);
        PorterDuff.Mode mode = this.backgroundTintMode;
        if (mode != null) {
            materialShapeDrawable.setTintMode(mode);
        }
        materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        StateListShapeAppearanceModel stateListShapeAppearanceModel3 = this.stateListShapeAppearanceModel;
        if (stateListShapeAppearanceModel3 != null) {
            materialShapeDrawable2.setStateListShapeAppearanceModel(stateListShapeAppearanceModel3);
        }
        SpringForce springForce2 = this.cornerSpringForce;
        if (springForce2 != null) {
            materialShapeDrawable2.setCornerSpringForce(springForce2);
        }
        materialShapeDrawable2.setTint(0);
        float f5 = (float) this.strokeWidth;
        if (this.shouldDrawSurfaceColorStroke) {
            i5 = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
        } else {
            i5 = 0;
        }
        materialShapeDrawable2.setStroke(f5, i5);
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.maskDrawable = materialShapeDrawable3;
        StateListShapeAppearanceModel stateListShapeAppearanceModel4 = this.stateListShapeAppearanceModel;
        if (stateListShapeAppearanceModel4 != null) {
            materialShapeDrawable3.setStateListShapeAppearanceModel(stateListShapeAppearanceModel4);
        }
        SpringForce springForce3 = this.cornerSpringForce;
        if (springForce3 != null) {
            ((MaterialShapeDrawable) this.maskDrawable).setCornerSpringForce(springForce3);
        }
        this.maskDrawable.setTint(-1);
        RippleDrawable rippleDrawable2 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.maskDrawable);
        this.rippleDrawable = rippleDrawable2;
        return rippleDrawable2;
    }

    @Nullable
    private MaterialShapeDrawable getMaterialShapeDrawable(boolean z4) {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(z4 ^ true ? 1 : 0);
    }

    @Nullable
    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    private void setVerticalInsets(@Dimension int i5, @Dimension int i6) {
        int paddingStart = this.materialButton.getPaddingStart();
        int paddingTop = this.materialButton.getPaddingTop();
        int paddingEnd = this.materialButton.getPaddingEnd();
        int paddingBottom = this.materialButton.getPaddingBottom();
        int i7 = this.insetTop;
        int i8 = this.insetBottom;
        this.insetBottom = i6;
        this.insetTop = i5;
        if (!this.backgroundOverwritten) {
            updateBackground();
        }
        this.materialButton.setPaddingRelative(paddingStart, (paddingTop + i5) - i7, paddingEnd, (paddingBottom + i6) - i8);
    }

    private void updateBackground() {
        this.materialButton.setInternalBackground(createBackground());
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation((float) this.elevation);
            materialShapeDrawable.setState(this.materialButton.getDrawableState());
        }
    }

    private void updateButtonShape() {
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        if (materialShapeDrawable != null) {
            StateListShapeAppearanceModel stateListShapeAppearanceModel2 = this.stateListShapeAppearanceModel;
            if (stateListShapeAppearanceModel2 != null) {
                materialShapeDrawable.setStateListShapeAppearanceModel(stateListShapeAppearanceModel2);
            } else {
                materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
            }
            SpringForce springForce = this.cornerSpringForce;
            if (springForce != null) {
                materialShapeDrawable.setCornerSpringForce(springForce);
            }
        }
        MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
        if (surfaceColorStrokeDrawable != null) {
            StateListShapeAppearanceModel stateListShapeAppearanceModel3 = this.stateListShapeAppearanceModel;
            if (stateListShapeAppearanceModel3 != null) {
                surfaceColorStrokeDrawable.setStateListShapeAppearanceModel(stateListShapeAppearanceModel3);
            } else {
                surfaceColorStrokeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
            }
            SpringForce springForce2 = this.cornerSpringForce;
            if (springForce2 != null) {
                surfaceColorStrokeDrawable.setCornerSpringForce(springForce2);
            }
        }
        Shapeable maskDrawable2 = getMaskDrawable();
        if (maskDrawable2 != null) {
            maskDrawable2.setShapeAppearanceModel(this.shapeAppearanceModel);
            if (maskDrawable2 instanceof MaterialShapeDrawable) {
                MaterialShapeDrawable materialShapeDrawable2 = (MaterialShapeDrawable) maskDrawable2;
                StateListShapeAppearanceModel stateListShapeAppearanceModel4 = this.stateListShapeAppearanceModel;
                if (stateListShapeAppearanceModel4 != null) {
                    materialShapeDrawable2.setStateListShapeAppearanceModel(stateListShapeAppearanceModel4);
                }
                SpringForce springForce3 = this.cornerSpringForce;
                if (springForce3 != null) {
                    materialShapeDrawable2.setCornerSpringForce(springForce3);
                }
            }
        }
    }

    private void updateStroke() {
        int i5;
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
            if (surfaceColorStrokeDrawable != null) {
                float f5 = (float) this.strokeWidth;
                if (this.shouldDrawSurfaceColorStroke) {
                    i5 = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
                } else {
                    i5 = 0;
                }
                surfaceColorStrokeDrawable.setStroke(f5, i5);
            }
        }
    }

    @NonNull
    private InsetDrawable wrapDrawableWithInset(Drawable drawable) {
        return new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    /* access modifiers changed from: package-private */
    public int getCornerRadius() {
        return this.cornerRadius;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public SpringForce getCornerSpringForce() {
        return this.cornerSpringForce;
    }

    public int getInsetBottom() {
        return this.insetBottom;
    }

    public int getInsetTop() {
        return this.insetTop;
    }

    @Nullable
    public Shapeable getMaskDrawable() {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.rippleDrawable.getNumberOfLayers() > 2) {
            return (Shapeable) this.rippleDrawable.getDrawable(2);
        }
        return (Shapeable) this.rippleDrawable.getDrawable(1);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public StateListShapeAppearanceModel getStateListShapeAppearanceModel() {
        return this.stateListShapeAppearanceModel;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    /* access modifiers changed from: package-private */
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    /* access modifiers changed from: package-private */
    public boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    /* access modifiers changed from: package-private */
    public boolean isCheckable() {
        return this.checkable;
    }

    /* access modifiers changed from: package-private */
    public boolean isToggleCheckedStateOnClick() {
        return this.toggleCheckedStateOnClick;
    }

    /* access modifiers changed from: package-private */
    public void loadFromAttributes(@NonNull TypedArray typedArray) {
        this.insetLeft = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int i5 = R.styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i5)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i5, -1);
            this.cornerRadius = dimensionPixelSize;
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize((float) dimensionPixelSize));
            this.cornerRadiusSet = true;
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.checkable = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.elevation = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        this.toggleCheckedStateOnClick = typedArray.getBoolean(R.styleable.MaterialButton_toggleCheckedStateOnClick, true);
        int paddingStart = this.materialButton.getPaddingStart();
        int paddingTop = this.materialButton.getPaddingTop();
        int paddingEnd = this.materialButton.getPaddingEnd();
        int paddingBottom = this.materialButton.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            setBackgroundOverwritten();
        } else {
            updateBackground();
        }
        this.materialButton.setPaddingRelative(paddingStart + this.insetLeft, paddingTop + this.insetTop, paddingEnd + this.insetRight, paddingBottom + this.insetBottom);
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundColor(int i5) {
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setTint(i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    /* access modifiers changed from: package-private */
    public void setCheckable(boolean z4) {
        this.checkable = z4;
    }

    /* access modifiers changed from: package-private */
    public void setCornerRadius(int i5) {
        if (!this.cornerRadiusSet || this.cornerRadius != i5) {
            this.cornerRadius = i5;
            this.cornerRadiusSet = true;
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize((float) i5));
        }
    }

    /* access modifiers changed from: package-private */
    public void setCornerSizeChangeListener(@Nullable MaterialShapeDrawable.OnCornerSizeChangeListener onCornerSizeChangeListener2) {
        this.onCornerSizeChangeListener = onCornerSizeChangeListener2;
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setOnCornerSizeChangeListener(onCornerSizeChangeListener2);
        }
    }

    /* access modifiers changed from: package-private */
    public void setCornerSpringForce(@NonNull SpringForce springForce) {
        this.cornerSpringForce = springForce;
        if (this.stateListShapeAppearanceModel != null) {
            updateButtonShape();
        }
    }

    public void setInsetBottom(@Dimension int i5) {
        setVerticalInsets(this.insetTop, i5);
    }

    public void setInsetTop(@Dimension int i5) {
        setVerticalInsets(i5, this.insetBottom);
    }

    /* access modifiers changed from: package-private */
    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            if (this.materialButton.getBackground() instanceof RippleDrawable) {
                ((RippleDrawable) this.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        this.stateListShapeAppearanceModel = null;
        updateButtonShape();
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z4) {
        this.shouldDrawSurfaceColorStroke = z4;
        updateStroke();
    }

    /* access modifiers changed from: package-private */
    public void setStateListShapeAppearanceModel(@NonNull StateListShapeAppearanceModel stateListShapeAppearanceModel2) {
        this.stateListShapeAppearanceModel = stateListShapeAppearanceModel2;
        updateButtonShape();
    }

    /* access modifiers changed from: package-private */
    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            updateStroke();
        }
    }

    /* access modifiers changed from: package-private */
    public void setStrokeWidth(int i5) {
        if (this.strokeWidth != i5) {
            this.strokeWidth = i5;
            updateStroke();
        }
    }

    /* access modifiers changed from: package-private */
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            if (getMaterialShapeDrawable() != null) {
                getMaterialShapeDrawable().setTintList(this.backgroundTint);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            if (getMaterialShapeDrawable() != null && this.backgroundTintMode != null) {
                getMaterialShapeDrawable().setTintMode(this.backgroundTintMode);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setToggleCheckedStateOnClick(boolean z4) {
        this.toggleCheckedStateOnClick = z4;
    }

    /* access modifiers changed from: package-private */
    public void updateMaskBounds(int i5, int i6) {
        Drawable drawable = this.maskDrawable;
        if (drawable != null) {
            drawable.setBounds(this.insetLeft, this.insetTop, i6 - this.insetRight, i5 - this.insetBottom);
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }
}
