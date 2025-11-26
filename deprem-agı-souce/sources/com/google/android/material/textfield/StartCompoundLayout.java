package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

@SuppressLint({"ViewConstructor"})
class StartCompoundLayout extends LinearLayout {
    private boolean hintExpanded;
    @Nullable
    private CharSequence prefixText;
    private final TextView prefixTextView;
    private int startIconMinSize;
    private View.OnLongClickListener startIconOnLongClickListener;
    @NonNull
    private ImageView.ScaleType startIconScaleType;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final TextInputLayout textInputLayout;

    StartCompoundLayout(TextInputLayout textInputLayout2, TintTypedArray tintTypedArray) {
        super(textInputLayout2.getContext());
        this.textInputLayout = textInputLayout2;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, this, false);
        this.startIconView = checkableImageButton;
        IconHelper.setCompatRippleBackgroundIfNeeded(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.prefixTextView = appCompatTextView;
        initStartIconView(tintTypedArray);
        initPrefixTextView(tintTypedArray);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void initPrefixTextView(TintTypedArray tintTypedArray) {
        this.prefixTextView.setVisibility(8);
        this.prefixTextView.setId(R.id.textinput_prefix_text);
        this.prefixTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.prefixTextView.setAccessibilityLiveRegion(1);
        setPrefixTextAppearance(tintTypedArray.getResourceId(R.styleable.TextInputLayout_prefixTextAppearance, 0));
        int i5 = R.styleable.TextInputLayout_prefixTextColor;
        if (tintTypedArray.hasValue(i5)) {
            setPrefixTextColor(tintTypedArray.getColorStateList(i5));
        }
        setPrefixText(tintTypedArray.getText(R.styleable.TextInputLayout_prefixText));
    }

    private void initStartIconView(TintTypedArray tintTypedArray) {
        if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            ((ViewGroup.MarginLayoutParams) this.startIconView.getLayoutParams()).setMarginEnd(0);
        }
        setStartIconOnClickListener((View.OnClickListener) null);
        setStartIconOnLongClickListener((View.OnLongClickListener) null);
        int i5 = R.styleable.TextInputLayout_startIconTint;
        if (tintTypedArray.hasValue(i5)) {
            this.startIconTintList = MaterialResources.getColorStateList(getContext(), tintTypedArray, i5);
        }
        int i6 = R.styleable.TextInputLayout_startIconTintMode;
        if (tintTypedArray.hasValue(i6)) {
            this.startIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(i6, -1), (PorterDuff.Mode) null);
        }
        int i7 = R.styleable.TextInputLayout_startIconDrawable;
        if (tintTypedArray.hasValue(i7)) {
            setStartIconDrawable(tintTypedArray.getDrawable(i7));
            int i8 = R.styleable.TextInputLayout_startIconContentDescription;
            if (tintTypedArray.hasValue(i8)) {
                setStartIconContentDescription(tintTypedArray.getText(i8));
            }
            setStartIconCheckable(tintTypedArray.getBoolean(R.styleable.TextInputLayout_startIconCheckable, true));
        }
        setStartIconMinSize(tintTypedArray.getDimensionPixelSize(R.styleable.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size)));
        int i9 = R.styleable.TextInputLayout_startIconScaleType;
        if (tintTypedArray.hasValue(i9)) {
            setStartIconScaleType(IconHelper.convertScaleType(tintTypedArray.getInt(i9, -1)));
        }
    }

    private void updateVisibility() {
        int i5;
        int i6 = 8;
        if (this.prefixText == null || this.hintExpanded) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        if (this.startIconView.getVisibility() == 0 || i5 == 0) {
            i6 = 0;
        }
        setVisibility(i6);
        this.prefixTextView.setVisibility(i5);
        this.textInputLayout.updateDummyDrawables();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getPrefixText() {
        return this.prefixText;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    /* access modifiers changed from: package-private */
    public int getPrefixTextStartOffset() {
        int i5;
        if (isStartIconVisible()) {
            i5 = this.startIconView.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) this.startIconView.getLayoutParams()).getMarginEnd();
        } else {
            i5 = 0;
        }
        return getPaddingStart() + this.prefixTextView.getPaddingStart() + i5;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public int getStartIconMinSize() {
        return this.startIconMinSize;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.startIconScaleType;
    }

    /* access modifiers changed from: package-private */
    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    /* access modifiers changed from: package-private */
    public boolean isStartIconVisible() {
        if (this.startIconView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void onHintStateChanged(boolean z4) {
        this.hintExpanded = z4;
        updateVisibility();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        updatePrefixTextViewPadding();
    }

    /* access modifiers changed from: package-private */
    public void refreshStartIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.startIconView, this.startIconTintList);
    }

    /* access modifiers changed from: package-private */
    public void setPrefixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.prefixText = charSequence2;
        this.prefixTextView.setText(charSequence);
        updateVisibility();
    }

    /* access modifiers changed from: package-private */
    public void setPrefixTextAppearance(@StyleRes int i5) {
        TextViewCompat.setTextAppearance(this.prefixTextView, i5);
    }

    /* access modifiers changed from: package-private */
    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.prefixTextView.setTextColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void setStartIconCheckable(boolean z4) {
        this.startIconView.setCheckable(z4);
    }

    /* access modifiers changed from: package-private */
    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.applyIconTint(this.textInputLayout, this.startIconView, this.startIconTintList, this.startIconTintMode);
            setStartIconVisible(true);
            refreshStartIconDrawableState();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener((View.OnClickListener) null);
        setStartIconOnLongClickListener((View.OnLongClickListener) null);
        setStartIconContentDescription((CharSequence) null);
    }

    /* access modifiers changed from: package-private */
    public void setStartIconMinSize(@Px int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        } else if (i5 != this.startIconMinSize) {
            this.startIconMinSize = i5;
            IconHelper.setIconMinSize(this.startIconView, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        IconHelper.setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        IconHelper.setIconOnLongClickListener(this.startIconView, onLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.startIconScaleType = scaleType;
        IconHelper.setIconScaleType(this.startIconView, scaleType);
    }

    /* access modifiers changed from: package-private */
    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            IconHelper.applyIconTint(this.textInputLayout, this.startIconView, colorStateList, this.startIconTintMode);
        }
    }

    /* access modifiers changed from: package-private */
    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            IconHelper.applyIconTint(this.textInputLayout, this.startIconView, this.startIconTintList, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void setStartIconVisible(boolean z4) {
        int i5;
        if (isStartIconVisible() != z4) {
            CheckableImageButton checkableImageButton = this.startIconView;
            if (z4) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            checkableImageButton.setVisibility(i5);
            updatePrefixTextViewPadding();
            updateVisibility();
        }
    }

    /* access modifiers changed from: package-private */
    public void setupAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.prefixTextView.getVisibility() == 0) {
            accessibilityNodeInfoCompat.setLabelFor(this.prefixTextView);
            accessibilityNodeInfoCompat.setTraversalAfter(this.prefixTextView);
            return;
        }
        accessibilityNodeInfoCompat.setTraversalAfter(this.startIconView);
    }

    /* access modifiers changed from: package-private */
    public void updatePrefixTextViewPadding() {
        int i5;
        EditText editText = this.textInputLayout.editText;
        if (editText != null) {
            if (isStartIconVisible()) {
                i5 = 0;
            } else {
                i5 = editText.getPaddingStart();
            }
            this.prefixTextView.setPaddingRelative(i5, editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
        }
    }
}
