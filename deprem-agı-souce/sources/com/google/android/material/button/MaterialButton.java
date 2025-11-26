package com.google.android.material.button;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.c;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.customview.view.AbsSavedState;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.R;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.StateListShapeAppearanceModel;
import com.google.android.material.shape.StateListSizeChange;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    private static final int[] CHECKABLE_STATE_SET = {16842911};
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Button;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;
    private static final String LOG_TAG = "MaterialButton";
    @AttrRes
    private static final int MATERIAL_SIZE_OVERLAY_ATTR = R.attr.materialSizeOverlay;
    private static final float OPTICAL_CENTER_RATIO = 0.11f;
    private static final int UNSET = -1;
    private static final FloatPropertyCompat<MaterialButton> WIDTH_INCREASE = new FloatPropertyCompat<MaterialButton>("widthIncrease") {
        public float getValue(MaterialButton materialButton) {
            return materialButton.getDisplayedWidthIncrease();
        }

        public void setValue(MaterialButton materialButton, float f5) {
            materialButton.setDisplayedWidthIncrease(f5);
        }
    };
    @Nullable
    private String accessibilityClassName;
    @Px
    int allowedWidthDecrease;
    private boolean broadcasting;
    private boolean checked;
    private float displayedWidthDecrease;
    private float displayedWidthIncrease;
    @Nullable
    private Drawable icon;
    private int iconGravity;
    @Px
    private int iconLeft;
    @Px
    private int iconPadding;
    @Px
    private int iconSize;
    @Nullable
    private ColorStateList iconTint;
    @Nullable
    private PorterDuff.Mode iconTintMode;
    @Px
    private int iconTop;
    private boolean isInHorizontalButtonGroup;
    @NonNull
    private final MaterialButtonHelper materialButtonHelper;
    @NonNull
    private final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;
    @Nullable
    private OnPressedChangeListener onPressedChangeListenerInternal;
    private boolean opticalCenterEnabled;
    private int opticalCenterShift;
    private int orientation;
    @Nullable
    private LinearLayout.LayoutParams originalLayoutParams;
    @Px
    private int originalPaddingEnd;
    @Px
    private int originalPaddingStart;
    private float originalWidth;
    @Nullable
    StateListSizeChange sizeChange;
    @Px
    int widthChangeMax;
    @Nullable
    private SpringAnimation widthIncreaseSpringAnimation;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {
        private int mIconPaddingId;
        private boolean mPropertiesMapped = false;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.mIconPaddingId = propertyMapper.mapInt("iconPadding", R.attr.iconPadding);
            this.mPropertiesMapped = true;
        }

        public void readProperties(@NonNull MaterialButton materialButton, @NonNull PropertyReader propertyReader) {
            if (this.mPropertiesMapped) {
                propertyReader.readInt(this.mIconPaddingId, materialButton.getIconPadding());
                return;
            }
            throw c.a();
        }
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z4);
    }

    interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton materialButton, boolean z4);
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

            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        boolean checked;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void readFromParcel(@NonNull Parcel parcel) {
            boolean z4 = true;
            if (parcel.readInt() != 1) {
                z4 = false;
            }
            this.checked = z4;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            readFromParcel(parcel);
        }
    }

    public MaterialButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ void a(MaterialButton materialButton) {
        materialButton.opticalCenterShift = materialButton.getOpticalCenterShift();
        materialButton.updatePaddingsAndSizeForWidthAnimation();
        materialButton.invalidate();
    }

    public static /* synthetic */ void b(MaterialButton materialButton, float f5) {
        int i5 = (int) (f5 * OPTICAL_CENTER_RATIO);
        if (materialButton.opticalCenterShift != i5) {
            materialButton.opticalCenterShift = i5;
            materialButton.updatePaddingsAndSizeForWidthAnimation();
            materialButton.invalidate();
        }
    }

    private SpringForce createSpringForce() {
        return MotionUtils.resolveThemeSpringForce(getContext(), R.attr.motionSpringFastSpatial, R.style.Motion_Material3_Spring_Standard_Fast_Spatial);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment == 1) {
            return getGravityTextAlignment();
        }
        if (textAlignment == 6 || textAlignment == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (textAlignment != 4) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    /* access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.displayedWidthIncrease;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (gravity == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (gravity == 5 || gravity == 8388613) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    private int getOpticalCenterShift() {
        MaterialShapeDrawable materialShapeDrawable;
        if (!this.opticalCenterEnabled || !this.isInHorizontalButtonGroup || (materialShapeDrawable = this.materialButtonHelper.getMaterialShapeDrawable()) == null) {
            return 0;
        }
        return (int) (materialShapeDrawable.getCornerSizeDiffX() * OPTICAL_CENTER_RATIO);
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f5 = 0.0f;
        for (int i5 = 0; i5 < lineCount; i5++) {
            f5 = Math.max(f5, getLayout().getLineWidth(i5));
        }
        return (int) Math.ceil((double) f5);
    }

    private void initializeSizeAnimation() {
        SpringAnimation springAnimation = new SpringAnimation(this, WIDTH_INCREASE);
        this.widthIncreaseSpringAnimation = springAnimation;
        springAnimation.setSpring(createSpringForce());
    }

    private boolean isIconEnd() {
        int i5 = this.iconGravity;
        if (i5 == 3 || i5 == 4) {
            return true;
        }
        return false;
    }

    private boolean isIconStart() {
        int i5 = this.iconGravity;
        if (i5 == 1 || i5 == 2) {
            return true;
        }
        return false;
    }

    private boolean isIconTop() {
        int i5 = this.iconGravity;
        if (i5 == 16 || i5 == 32) {
            return true;
        }
        return false;
    }

    private boolean isInHorizontalButtonGroup() {
        if (!(getParent() instanceof MaterialButtonGroup) || ((MaterialButtonGroup) getParent()).getOrientation() != 0) {
            return false;
        }
        return true;
    }

    private boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private boolean isUsingOriginalBackground() {
        MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
        if (materialButtonHelper2 == null || materialButtonHelper2.isBackgroundOverwritten()) {
            return false;
        }
        return true;
    }

    private void maybeAnimateSize(boolean z4) {
        if (this.sizeChange != null) {
            if (this.widthIncreaseSpringAnimation == null) {
                initializeSizeAnimation();
            }
            if (this.isInHorizontalButtonGroup) {
                this.widthIncreaseSpringAnimation.animateToFinalPosition((float) Math.min(this.widthChangeMax, this.sizeChange.getSizeChangeForState(getDrawableState()).widthChange.getChange(getWidth())));
                if (z4) {
                    this.widthIncreaseSpringAnimation.skipToEnd();
                }
            }
        }
    }

    private void resetIconDrawable() {
        if (isIconStart()) {
            setCompoundDrawablesRelative(this.icon, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (isIconEnd()) {
            setCompoundDrawablesRelative((Drawable) null, (Drawable) null, this.icon, (Drawable) null);
        } else if (isIconTop()) {
            setCompoundDrawablesRelative((Drawable) null, this.icon, (Drawable) null, (Drawable) null);
        }
    }

    private void setCheckedInternal(boolean z4) {
        if (isCheckable() && this.checked != z4) {
            this.checked = z4;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).onButtonCheckedStateChanged(this, this.checked);
            }
            if (!this.broadcasting) {
                this.broadcasting = true;
                Iterator<OnCheckedChangeListener> it = this.onCheckedChangeListeners.iterator();
                while (it.hasNext()) {
                    it.next().onCheckedChanged(this, this.checked);
                }
                this.broadcasting = false;
            }
        }
    }

    /* access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f5) {
        if (this.displayedWidthIncrease != f5) {
            this.displayedWidthIncrease = f5;
            updatePaddingsAndSizeForWidthAnimation();
            invalidate();
            if (getParent() instanceof MaterialButtonGroup) {
                ((MaterialButtonGroup) getParent()).onButtonWidthChanged(this, (int) this.displayedWidthIncrease);
            }
        }
    }

    private void updateIcon(boolean z4) {
        Drawable drawable = this.icon;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.icon = mutate;
            mutate.setTintList(this.iconTint);
            PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                this.icon.setTintMode(mode);
            }
            int i5 = this.iconSize;
            if (i5 == 0) {
                i5 = this.icon.getIntrinsicWidth();
            }
            int i6 = this.iconSize;
            if (i6 == 0) {
                i6 = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int i7 = this.iconLeft;
            int i8 = this.iconTop;
            drawable2.setBounds(i7, i8, i5 + i7, i6 + i8);
            this.icon.setVisible(true, z4);
        }
        if (z4) {
            resetIconDrawable();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((isIconStart() && drawable3 != this.icon) || ((isIconEnd() && drawable5 != this.icon) || (isIconTop() && drawable4 != this.icon))) {
            resetIconDrawable();
        }
    }

    private void updateIconPosition(int i5, int i6) {
        if (this.icon != null && getLayout() != null) {
            if (isIconStart() || isIconEnd()) {
                this.iconTop = 0;
                Layout.Alignment actualTextAlignment = getActualTextAlignment();
                int i7 = this.iconGravity;
                boolean z4 = true;
                if (i7 == 1 || i7 == 3 || ((i7 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i7 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
                    this.iconLeft = 0;
                    updateIcon(false);
                    return;
                }
                int i8 = this.iconSize;
                if (i8 == 0) {
                    i8 = this.icon.getIntrinsicWidth();
                }
                int textLayoutWidth = ((((i5 - getTextLayoutWidth()) - getPaddingEnd()) - i8) - this.iconPadding) - getPaddingStart();
                if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                    textLayoutWidth /= 2;
                }
                boolean isLayoutRTL = isLayoutRTL();
                if (this.iconGravity != 4) {
                    z4 = false;
                }
                if (isLayoutRTL != z4) {
                    textLayoutWidth = -textLayoutWidth;
                }
                if (this.iconLeft != textLayoutWidth) {
                    this.iconLeft = textLayoutWidth;
                    updateIcon(false);
                }
            } else if (isIconTop()) {
                this.iconLeft = 0;
                if (this.iconGravity == 16) {
                    this.iconTop = 0;
                    updateIcon(false);
                    return;
                }
                int i9 = this.iconSize;
                if (i9 == 0) {
                    i9 = this.icon.getIntrinsicHeight();
                }
                int max = Math.max(0, (((((i6 - getTextHeight()) - getPaddingTop()) - i9) - this.iconPadding) - getPaddingBottom()) / 2);
                if (this.iconTop != max) {
                    this.iconTop = max;
                    updateIcon(false);
                }
            }
        }
    }

    private void updatePaddingsAndSizeForWidthAnimation() {
        int i5 = (int) (this.displayedWidthIncrease - this.displayedWidthDecrease);
        int i6 = (i5 / 2) + this.opticalCenterShift;
        getLayoutParams().width = (int) (this.originalWidth + ((float) i5));
        setPaddingRelative(this.originalPaddingStart + i6, getPaddingTop(), (this.originalPaddingEnd + i5) - i6, getPaddingBottom());
    }

    public void addOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.add(onCheckedChangeListener);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"KotlinPropertyAccess"})
    @NonNull
    public String getA11yClassName() {
        Class cls;
        if (!TextUtils.isEmpty(this.accessibilityClassName)) {
            return this.accessibilityClassName;
        }
        if (isCheckable()) {
            cls = CompoundButton.class;
        } else {
            cls = Button.class;
        }
        return cls.getName();
    }

    /* access modifiers changed from: package-private */
    @Px
    public int getAllowedWidthDecrease() {
        return this.allowedWidthDecrease;
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getCornerRadius();
        }
        return 0;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SpringForce getCornerSpringForce() {
        return this.materialButtonHelper.getCornerSpringForce();
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    @Px
    public int getIconPadding() {
        return this.iconPadding;
    }

    @Px
    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    @Dimension
    public int getInsetBottom() {
        return this.materialButtonHelper.getInsetBottom();
    }

    @Dimension
    public int getInsetTop() {
        return this.materialButtonHelper.getInsetTop();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getRippleColor();
        }
        return null;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getShapeAppearanceModel();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StateListShapeAppearanceModel getStateListShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStateListShapeAppearanceModel();
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeColor();
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeWidth();
        }
        return 0;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getSupportBackgroundTintList();
        }
        return super.getSupportBackgroundTintList();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getSupportBackgroundTintMode();
        }
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
        if (materialButtonHelper2 == null || !materialButtonHelper2.isCheckable()) {
            return false;
        }
        return true;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isOpticalCenterEnabled() {
        return this.opticalCenterEnabled;
    }

    public boolean isToggleCheckedStateOnClick() {
        return this.materialButtonHelper.isToggleCheckedStateOnClick();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground()) {
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i5) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + 2);
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9;
        super.onLayout(z4, i5, i6, i7, i8);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        int i10 = getResources().getConfiguration().orientation;
        if (this.orientation != i10) {
            this.orientation = i10;
            this.originalWidth = -1.0f;
        }
        if (this.originalWidth == -1.0f) {
            this.originalWidth = (float) getMeasuredWidth();
            if (this.originalLayoutParams == null && (getParent() instanceof MaterialButtonGroup) && ((MaterialButtonGroup) getParent()).getButtonSizeChange() != null) {
                this.originalLayoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.originalLayoutParams);
                layoutParams.width = (int) this.originalWidth;
                setLayoutParams(layoutParams);
            }
        }
        if (this.allowedWidthDecrease == -1) {
            if (this.icon == null) {
                i9 = 0;
            } else {
                int iconPadding2 = getIconPadding();
                int i11 = this.iconSize;
                if (i11 == 0) {
                    i11 = this.icon.getIntrinsicWidth();
                }
                i9 = iconPadding2 + i11;
            }
            this.allowedWidthDecrease = (getMeasuredWidth() - getTextLayoutWidth()) - i9;
        }
        if (this.originalPaddingStart == -1) {
            this.originalPaddingStart = getPaddingStart();
        }
        if (this.originalPaddingEnd == -1) {
            this.originalPaddingEnd = getPaddingEnd();
        }
        this.isInHorizontalButtonGroup = isInHorizontalButtonGroup();
    }

    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        super.onTextChanged(charSequence, i5, i6, i7);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean performClick() {
        if (isEnabled() && this.materialButtonHelper.isToggleCheckedStateOnClick()) {
            toggle();
        }
        return super.performClick();
    }

    /* access modifiers changed from: package-private */
    public void recoverOriginalLayoutParams() {
        LinearLayout.LayoutParams layoutParams = this.originalLayoutParams;
        if (layoutParams != null) {
            setLayoutParams(layoutParams);
            this.originalLayoutParams = null;
            this.originalWidth = -1.0f;
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.icon != null) {
            if (this.icon.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void removeOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.remove(onCheckedChangeListener);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setA11yClassName(@Nullable String str) {
        this.accessibilityClassName = str;
    }

    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(@ColorInt int i5) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setBackgroundColor(i5);
        } else {
            super.setBackgroundColor(i5);
        }
    }

    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!isUsingOriginalBackground()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.w(LOG_TAG, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.materialButtonHelper.setBackgroundOverwritten();
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    public void setBackgroundResource(@DrawableRes int i5) {
        Drawable drawable;
        if (i5 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), i5);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z4) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setCheckable(z4);
        }
    }

    public void setChecked(boolean z4) {
        setCheckedInternal(z4);
    }

    public void setCornerRadius(@Px int i5) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setCornerRadius(i5);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i5) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i5));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setCornerSpringForce(@NonNull SpringForce springForce) {
        this.materialButtonHelper.setCornerSpringForce(springForce);
    }

    /* access modifiers changed from: package-private */
    public void setDisplayedWidthDecrease(int i5) {
        this.displayedWidthDecrease = (float) Math.min(i5, this.allowedWidthDecrease);
        updatePaddingsAndSizeForWidthAnimation();
        invalidate();
    }

    public void setElevation(float f5) {
        super.setElevation(f5);
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.getMaterialShapeDrawable().setElevation(f5);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            updateIcon(true);
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i5) {
        if (this.iconGravity != i5) {
            this.iconGravity = i5;
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i5) {
        if (this.iconPadding != i5) {
            this.iconPadding = i5;
            setCompoundDrawablePadding(i5);
        }
    }

    public void setIconResource(@DrawableRes int i5) {
        Drawable drawable;
        if (i5 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), i5);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(@Px int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.iconSize != i5) {
            this.iconSize = i5;
            updateIcon(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public void setIconTintResource(@ColorRes int i5) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i5));
    }

    public void setInsetBottom(@Dimension int i5) {
        this.materialButtonHelper.setInsetBottom(i5);
    }

    public void setInsetTop(@Dimension int i5) {
        this.materialButtonHelper.setInsetTop(i5);
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(@Nullable OnPressedChangeListener onPressedChangeListener) {
        this.onPressedChangeListenerInternal = onPressedChangeListener;
    }

    public void setOpticalCenterEnabled(boolean z4) {
        if (this.opticalCenterEnabled != z4) {
            this.opticalCenterEnabled = z4;
            if (z4) {
                this.materialButtonHelper.setCornerSizeChangeListener(new a(this));
            } else {
                this.materialButtonHelper.setCornerSizeChangeListener((MaterialShapeDrawable.OnCornerSizeChangeListener) null);
            }
            post(new b(this));
        }
    }

    public void setPressed(boolean z4) {
        OnPressedChangeListener onPressedChangeListener = this.onPressedChangeListenerInternal;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.onPressedChanged(this, z4);
        }
        super.setPressed(z4);
        maybeAnimateSize(false);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setRippleColor(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i5) {
        if (isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i5));
        }
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShapeAppearanceModel(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z4) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShouldDrawSurfaceColorStroke(z4);
        }
    }

    /* access modifiers changed from: package-private */
    public void setSizeChange(@NonNull StateListSizeChange stateListSizeChange) {
        if (this.sizeChange != stateListSizeChange) {
            this.sizeChange = stateListSizeChange;
            maybeAnimateSize(true);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStateListShapeAppearanceModel(@NonNull StateListShapeAppearanceModel stateListShapeAppearanceModel) {
        if (isUsingOriginalBackground()) {
            if (this.materialButtonHelper.getCornerSpringForce() == null && stateListShapeAppearanceModel.isStateful()) {
                this.materialButtonHelper.setCornerSpringForce(createSpringForce());
            }
            this.materialButtonHelper.setStateListShapeAppearanceModel(stateListShapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeColor(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i5) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i5));
        }
    }

    public void setStrokeWidth(@Px int i5) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeWidth(i5);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i5) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i5));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintList(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintMode(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public void setTextAlignment(int i5) {
        super.setTextAlignment(i5);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z4) {
        this.materialButtonHelper.setToggleCheckedStateOnClick(z4);
    }

    public void setWidth(@Px int i5) {
        this.originalWidth = -1.0f;
        super.setWidth(i5);
    }

    /* access modifiers changed from: package-private */
    public void setWidthChangeMax(@Px int i5) {
        if (this.widthChangeMax != i5) {
            this.widthChangeMax = i5;
            maybeAnimateSize(true);
        }
    }

    public void toggle() {
        setChecked(!this.checked);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = DEF_STYLE_RES
            int r0 = MATERIAL_SIZE_OVERLAY_ATTR
            int[] r0 = new int[]{r0}
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4, r0)
            r7.<init>(r8, r9, r10)
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            r7.onCheckedChangeListeners = r8
            r8 = 0
            r7.checked = r8
            r7.broadcasting = r8
            r6 = -1
            r7.orientation = r6
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7.originalWidth = r0
            r7.originalPaddingStart = r6
            r7.originalPaddingEnd = r6
            r7.allowedWidthDecrease = r6
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButton
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.MaterialButton_iconPadding
            int r10 = r9.getDimensionPixelSize(r10, r8)
            r7.iconPadding = r10
            int r10 = com.google.android.material.R.styleable.MaterialButton_iconTintMode
            int r10 = r9.getInt(r10, r6)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r10 = com.google.android.material.internal.ViewUtils.parseTintMode(r10, r2)
            r7.iconTintMode = r10
            android.content.Context r10 = r7.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r2)
            r7.iconTint = r10
            android.content.Context r10 = r7.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r10 = com.google.android.material.resources.MaterialResources.getDrawable(r10, r9, r2)
            r7.icon = r10
            int r10 = com.google.android.material.R.styleable.MaterialButton_iconGravity
            r2 = 1
            int r10 = r9.getInteger(r10, r2)
            r7.iconGravity = r10
            int r10 = com.google.android.material.R.styleable.MaterialButton_iconSize
            int r10 = r9.getDimensionPixelSize(r10, r8)
            r7.iconSize = r10
            int r10 = com.google.android.material.R.styleable.MaterialButton_shapeAppearance
            com.google.android.material.shape.StateListShapeAppearanceModel r10 = com.google.android.material.shape.StateListShapeAppearanceModel.create(r0, r9, r10)
            if (r10 == 0) goto L_0x0082
            com.google.android.material.shape.ShapeAppearanceModel r0 = r10.getDefaultShape(r2)
            goto L_0x008a
        L_0x0082:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r0 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r0, (android.util.AttributeSet) r1, (int) r3, (int) r4)
            com.google.android.material.shape.ShapeAppearanceModel r0 = r0.build()
        L_0x008a:
            int r1 = com.google.android.material.R.styleable.MaterialButton_opticalCenterEnabled
            boolean r1 = r9.getBoolean(r1, r8)
            com.google.android.material.button.MaterialButtonHelper r3 = new com.google.android.material.button.MaterialButtonHelper
            r3.<init>(r7, r0)
            r7.materialButtonHelper = r3
            r3.loadFromAttributes(r9)
            int r0 = com.google.android.material.R.styleable.MaterialButton_android_checked
            boolean r0 = r9.getBoolean(r0, r8)
            r7.setCheckedInternal(r0)
            if (r10 == 0) goto L_0x00af
            androidx.dynamicanimation.animation.SpringForce r0 = r7.createSpringForce()
            r3.setCornerSpringForce(r0)
            r3.setStateListShapeAppearanceModel(r10)
        L_0x00af:
            r7.setOpticalCenterEnabled(r1)
            r9.recycle()
            int r9 = r7.iconPadding
            r7.setCompoundDrawablePadding(r9)
            android.graphics.drawable.Drawable r9 = r7.icon
            if (r9 == 0) goto L_0x00bf
            r8 = r2
        L_0x00bf:
            r7.updateIcon(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
