package com.google.android.material.checkbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ViewUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int[][] CHECKBOX_STATES;
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[] ERROR_STATE_SET;
    @SuppressLint({"DiscouragedApi"})
    private static final int FRAMEWORK_BUTTON_DRAWABLE_RES_ID = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    private static final int[] INDETERMINATE_STATE_SET = {R.attr.state_indeterminate};
    public static final int STATE_CHECKED = 1;
    public static final int STATE_INDETERMINATE = 2;
    public static final int STATE_UNCHECKED = 0;
    private boolean broadcasting;
    @Nullable
    private Drawable buttonDrawable;
    @Nullable
    private Drawable buttonIconDrawable;
    @Nullable
    ColorStateList buttonIconTintList;
    @NonNull
    private PorterDuff.Mode buttonIconTintMode;
    @Nullable
    ColorStateList buttonTintList;
    private boolean centerIfNoTextEnabled;
    private int checkedState;
    /* access modifiers changed from: private */
    public int[] currentStateChecked;
    @Nullable
    private CharSequence customStateDescription;
    @Nullable
    private CharSequence errorAccessibilityLabel;
    private boolean errorShown;
    @Nullable
    private ColorStateList materialThemeColorsTintList;
    @Nullable
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
    @NonNull
    private final LinkedHashSet<OnCheckedStateChangedListener> onCheckedStateChangedListeners;
    @NonNull
    private final LinkedHashSet<OnErrorChangedListener> onErrorChangedListeners;
    @Nullable
    private final AnimatedVectorDrawableCompat transitionToUnchecked;
    private final Animatable2Compat.AnimationCallback transitionToUncheckedCallback;
    private boolean useMaterialThemeColors;
    private boolean usingMaterialButtonDrawable;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedState {
    }

    public interface OnCheckedStateChangedListener {
        void onCheckedStateChangedListener(@NonNull MaterialCheckBox materialCheckBox, int i5);
    }

    public interface OnErrorChangedListener {
        void onErrorChanged(@NonNull MaterialCheckBox materialCheckBox, boolean z4);
    }

    static class SavedState extends View.BaseSavedState {
        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }
        };
        int checkedState;

        @NonNull
        private String getCheckedStateString() {
            int i5 = this.checkedState;
            if (i5 == 1) {
                return "checked";
            }
            if (i5 != 2) {
                return "unchecked";
            }
            return "indeterminate";
        }

        @NonNull
        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + getCheckedStateString() + "}";
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeValue(Integer.valueOf(this.checkedState));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.checkedState = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    static {
        int i5 = R.attr.state_error;
        ERROR_STATE_SET = new int[]{i5};
        CHECKBOX_STATES = new int[][]{new int[]{16842910, i5}, new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    }

    public MaterialCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    private String getButtonStateDescription() {
        int i5 = this.checkedState;
        if (i5 == 1) {
            return getResources().getString(R.string.mtrl_checkbox_state_description_checked);
        }
        if (i5 == 0) {
            return getResources().getString(R.string.mtrl_checkbox_state_description_unchecked);
        }
        return getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int[][] iArr = CHECKBOX_STATES;
            int[] iArr2 = new int[iArr.length];
            int color = MaterialColors.getColor(this, androidx.appcompat.R.attr.colorControlActivated);
            int color2 = MaterialColors.getColor(this, androidx.appcompat.R.attr.colorError);
            int color3 = MaterialColors.getColor(this, R.attr.colorSurface);
            int color4 = MaterialColors.getColor(this, R.attr.colorOnSurface);
            iArr2[0] = MaterialColors.layer(color3, color2, 1.0f);
            iArr2[1] = MaterialColors.layer(color3, color, 1.0f);
            iArr2[2] = MaterialColors.layer(color3, color4, 0.54f);
            iArr2[3] = MaterialColors.layer(color3, color4, 0.38f);
            iArr2[4] = MaterialColors.layer(color3, color4, 0.38f);
            this.materialThemeColorsTintList = new ColorStateList(iArr, iArr2);
        }
        return this.materialThemeColorsTintList;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.buttonTintList;
        if (colorStateList != null) {
            return colorStateList;
        }
        if (super.getButtonTintList() != null) {
            return super.getButtonTintList();
        }
        return getSupportButtonTintList();
    }

    private boolean isButtonDrawableLegacy(TintTypedArray tintTypedArray) {
        int resourceId = tintTypedArray.getResourceId(R.styleable.MaterialCheckBox_android_button, 0);
        int resourceId2 = tintTypedArray.getResourceId(R.styleable.MaterialCheckBox_buttonCompat, 0);
        if (resourceId == FRAMEWORK_BUTTON_DRAWABLE_RES_ID && resourceId2 == 0) {
            return true;
        }
        return false;
    }

    private void refreshButtonDrawable() {
        this.buttonDrawable = DrawableUtils.createTintableMutatedDrawableIfNeeded(this.buttonDrawable, this.buttonTintList, CompoundButtonCompat.getButtonTintMode(this));
        this.buttonIconDrawable = DrawableUtils.createTintableMutatedDrawableIfNeeded(this.buttonIconDrawable, this.buttonIconTintList, this.buttonIconTintMode);
        setUpDefaultButtonDrawableAnimationIfNeeded();
        updateButtonTints();
        super.setButtonDrawable(DrawableUtils.compositeTwoLayeredDrawable(this.buttonDrawable, this.buttonIconDrawable));
        refreshDrawableState();
    }

    private void setDefaultStateDescription() {
        if (Build.VERSION.SDK_INT >= 30 && this.customStateDescription == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    private void setUpDefaultButtonDrawableAnimationIfNeeded() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
        if (this.usingMaterialButtonDrawable) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.transitionToUnchecked;
            if (animatedVectorDrawableCompat2 != null) {
                animatedVectorDrawableCompat2.unregisterAnimationCallback(this.transitionToUncheckedCallback);
                this.transitionToUnchecked.registerAnimationCallback(this.transitionToUncheckedCallback);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable = this.buttonDrawable;
                if ((drawable instanceof AnimatedStateListDrawable) && (animatedVectorDrawableCompat = this.transitionToUnchecked) != null) {
                    int i5 = R.id.checked;
                    int i6 = R.id.unchecked;
                    ((AnimatedStateListDrawable) drawable).addTransition(i5, i6, animatedVectorDrawableCompat, false);
                    ((AnimatedStateListDrawable) this.buttonDrawable).addTransition(R.id.indeterminate, i6, this.transitionToUnchecked, false);
                }
            }
        }
    }

    private void updateButtonTints() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.buttonDrawable;
        if (!(drawable == null || (colorStateList2 = this.buttonTintList) == null)) {
            drawable.setTintList(colorStateList2);
        }
        Drawable drawable2 = this.buttonIconDrawable;
        if (drawable2 != null && (colorStateList = this.buttonIconTintList) != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    public void addOnCheckedStateChangedListener(@NonNull OnCheckedStateChangedListener onCheckedStateChangedListener) {
        this.onCheckedStateChangedListeners.add(onCheckedStateChangedListener);
    }

    public void addOnErrorChangedListener(@NonNull OnErrorChangedListener onErrorChangedListener) {
        this.onErrorChangedListeners.add(onErrorChangedListener);
    }

    public void clearOnCheckedStateChangedListeners() {
        this.onCheckedStateChangedListeners.clear();
    }

    public void clearOnErrorChangedListeners() {
        this.onErrorChangedListeners.clear();
    }

    @Nullable
    public Drawable getButtonDrawable() {
        return this.buttonDrawable;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.buttonIconDrawable;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.buttonIconTintList;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.buttonIconTintMode;
    }

    @Nullable
    public ColorStateList getButtonTintList() {
        return this.buttonTintList;
    }

    public int getCheckedState() {
        return this.checkedState;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.errorAccessibilityLabel;
    }

    public boolean isCenterIfNoTextEnabled() {
        return this.centerIfNoTextEnabled;
    }

    public boolean isChecked() {
        if (this.checkedState == 1) {
            return true;
        }
        return false;
    }

    public boolean isErrorShown() {
        return this.errorShown;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && this.buttonTintList == null && this.buttonIconTintList == null) {
            setUseMaterialThemeColors(true);
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i5) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, INDETERMINATE_STATE_SET);
        }
        if (isErrorShown()) {
            View.mergeDrawableStates(onCreateDrawableState, ERROR_STATE_SET);
        }
        this.currentStateChecked = DrawableUtils.getCheckedState(onCreateDrawableState);
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable buttonDrawable2;
        int i5;
        if (!this.centerIfNoTextEnabled || !TextUtils.isEmpty(getText()) || (buttonDrawable2 = CompoundButtonCompat.getButtonDrawable(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            i5 = -1;
        } else {
            i5 = 1;
        }
        int width = ((getWidth() - buttonDrawable2.getIntrinsicWidth()) / 2) * i5;
        int save = canvas.save();
        canvas.translate((float) width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable2.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    public void onInitializeAccessibilityNodeInfo(@Nullable AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && isErrorShown()) {
            accessibilityNodeInfo.setText(accessibilityNodeInfo.getText() + ", " + this.errorAccessibilityLabel);
        }
    }

    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.checkedState);
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checkedState = getCheckedState();
        return savedState;
    }

    public void removeOnCheckedStateChangedListener(@NonNull OnCheckedStateChangedListener onCheckedStateChangedListener) {
        this.onCheckedStateChangedListeners.remove(onCheckedStateChangedListener);
    }

    public void removeOnErrorChangedListener(@NonNull OnErrorChangedListener onErrorChangedListener) {
        this.onErrorChangedListeners.remove(onErrorChangedListener);
    }

    public void setButtonDrawable(@DrawableRes int i5) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), i5));
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.buttonIconDrawable = drawable;
        refreshButtonDrawable();
    }

    public void setButtonIconDrawableResource(@DrawableRes int i5) {
        setButtonIconDrawable(AppCompatResources.getDrawable(getContext(), i5));
    }

    public void setButtonIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.buttonIconTintList != colorStateList) {
            this.buttonIconTintList = colorStateList;
            refreshButtonDrawable();
        }
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.buttonIconTintMode != mode) {
            this.buttonIconTintMode = mode;
            refreshButtonDrawable();
        }
    }

    public void setButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.buttonTintList != colorStateList) {
            this.buttonTintList = colorStateList;
            refreshButtonDrawable();
        }
    }

    public void setButtonTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        refreshButtonDrawable();
    }

    public void setCenterIfNoTextEnabled(boolean z4) {
        this.centerIfNoTextEnabled = z4;
    }

    public void setChecked(boolean z4) {
        setCheckedState(z4 ? 1 : 0);
    }

    public void setCheckedState(int i5) {
        boolean z4;
        AutofillManager a5;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener2;
        if (this.checkedState != i5) {
            this.checkedState = i5;
            if (i5 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            super.setChecked(z4);
            refreshDrawableState();
            setDefaultStateDescription();
            if (!this.broadcasting) {
                this.broadcasting = true;
                LinkedHashSet<OnCheckedStateChangedListener> linkedHashSet = this.onCheckedStateChangedListeners;
                if (linkedHashSet != null) {
                    Iterator<OnCheckedStateChangedListener> it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        it.next().onCheckedStateChangedListener(this, this.checkedState);
                    }
                }
                if (!(this.checkedState == 2 || (onCheckedChangeListener2 = this.onCheckedChangeListener) == null)) {
                    onCheckedChangeListener2.onCheckedChanged(this, isChecked());
                }
                if (Build.VERSION.SDK_INT >= 26 && (a5 = b.a(getContext().getSystemService(a.a()))) != null) {
                    a5.notifyValueChanged(this);
                }
                this.broadcasting = false;
            }
        }
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence charSequence) {
        this.errorAccessibilityLabel = charSequence;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int i5) {
        CharSequence charSequence;
        if (i5 != 0) {
            charSequence = getResources().getText(i5);
        } else {
            charSequence = null;
        }
        setErrorAccessibilityLabel(charSequence);
    }

    public void setErrorShown(boolean z4) {
        if (this.errorShown != z4) {
            this.errorShown = z4;
            refreshDrawableState();
            Iterator<OnErrorChangedListener> it = this.onErrorChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().onErrorChanged(this, this.errorShown);
            }
        }
    }

    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
    }

    @RequiresApi(30)
    public void setStateDescription(@Nullable CharSequence charSequence) {
        this.customStateDescription = charSequence;
        if (charSequence == null) {
            setDefaultStateDescription();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        this.useMaterialThemeColors = z4;
        if (z4) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, (ColorStateList) null);
        }
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.checkboxStyle);
    }

    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.buttonDrawable = drawable;
        this.usingMaterialButtonDrawable = false;
        refreshButtonDrawable();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCheckBox(android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            r7.onErrorChangedListeners = r8
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            r7.onCheckedStateChangedListeners = r8
            android.content.Context r8 = r7.getContext()
            int r0 = com.google.android.material.R.drawable.mtrl_checkbox_button_checked_unchecked
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r8 = androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.create(r8, r0)
            r7.transitionToUnchecked = r8
            com.google.android.material.checkbox.MaterialCheckBox$1 r8 = new com.google.android.material.checkbox.MaterialCheckBox$1
            r8.<init>()
            r7.transitionToUncheckedCallback = r8
            android.content.Context r0 = r7.getContext()
            android.graphics.drawable.Drawable r8 = androidx.core.widget.CompoundButtonCompat.getButtonDrawable(r7)
            r7.buttonDrawable = r8
            android.content.res.ColorStateList r8 = r7.getSuperButtonTintList()
            r7.buttonTintList = r8
            r8 = 0
            r7.setSupportButtonTintList(r8)
            int[] r2 = com.google.android.material.R.styleable.MaterialCheckBox
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            androidx.appcompat.widget.TintTypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.MaterialCheckBox_buttonIcon
            android.graphics.drawable.Drawable r10 = r9.getDrawable(r10)
            r7.buttonIconDrawable = r10
            android.graphics.drawable.Drawable r10 = r7.buttonDrawable
            r1 = 1
            if (r10 == 0) goto L_0x007b
            boolean r10 = com.google.android.material.internal.ThemeEnforcement.isMaterial3Theme(r0)
            if (r10 == 0) goto L_0x007b
            boolean r10 = r7.isButtonDrawableLegacy(r9)
            if (r10 == 0) goto L_0x007b
            super.setButtonDrawable((android.graphics.drawable.Drawable) r8)
            int r8 = com.google.android.material.R.drawable.mtrl_checkbox_button
            android.graphics.drawable.Drawable r8 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r0, r8)
            r7.buttonDrawable = r8
            r7.usingMaterialButtonDrawable = r1
            android.graphics.drawable.Drawable r8 = r7.buttonIconDrawable
            if (r8 != 0) goto L_0x007b
            int r8 = com.google.android.material.R.drawable.mtrl_checkbox_button_icon
            android.graphics.drawable.Drawable r8 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r0, r8)
            r7.buttonIconDrawable = r8
        L_0x007b:
            int r8 = com.google.android.material.R.styleable.MaterialCheckBox_buttonIconTint
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (androidx.appcompat.widget.TintTypedArray) r9, (int) r8)
            r7.buttonIconTintList = r8
            int r8 = com.google.android.material.R.styleable.MaterialCheckBox_buttonIconTintMode
            r10 = -1
            int r8 = r9.getInt(r8, r10)
            android.graphics.PorterDuff$Mode r10 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r8 = com.google.android.material.internal.ViewUtils.parseTintMode(r8, r10)
            r7.buttonIconTintMode = r8
            int r8 = com.google.android.material.R.styleable.MaterialCheckBox_useMaterialThemeColors
            boolean r8 = r9.getBoolean(r8, r6)
            r7.useMaterialThemeColors = r8
            int r8 = com.google.android.material.R.styleable.MaterialCheckBox_centerIfNoTextEnabled
            boolean r8 = r9.getBoolean(r8, r1)
            r7.centerIfNoTextEnabled = r8
            int r8 = com.google.android.material.R.styleable.MaterialCheckBox_errorShown
            boolean r8 = r9.getBoolean(r8, r6)
            r7.errorShown = r8
            int r8 = com.google.android.material.R.styleable.MaterialCheckBox_errorAccessibilityLabel
            java.lang.CharSequence r8 = r9.getText(r8)
            r7.errorAccessibilityLabel = r8
            int r8 = com.google.android.material.R.styleable.MaterialCheckBox_checkedState
            boolean r10 = r9.hasValue(r8)
            if (r10 == 0) goto L_0x00c1
            int r8 = r9.getInt(r8, r6)
            r7.setCheckedState(r8)
        L_0x00c1:
            r9.recycle()
            r7.refreshButtonDrawable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.checkbox.MaterialCheckBox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
