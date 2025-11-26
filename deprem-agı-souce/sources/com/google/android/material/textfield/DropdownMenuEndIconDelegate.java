package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.motion.MotionUtils;

class DropdownMenuEndIconDelegate extends EndIconDelegate {
    private static final int DEFAULT_ANIMATION_FADE_IN_DURATION = 67;
    private static final int DEFAULT_ANIMATION_FADE_OUT_DURATION = 50;
    @Nullable
    private AccessibilityManager accessibilityManager;
    private final int animationFadeInDuration;
    @NonNull
    private final TimeInterpolator animationFadeInterpolator;
    private final int animationFadeOutDuration;
    @Nullable
    private AutoCompleteTextView autoCompleteTextView;
    private long dropdownPopupActivatedAt = Long.MAX_VALUE;
    private boolean dropdownPopupDirty;
    private boolean editTextHasFocus;
    /* access modifiers changed from: private */
    public ValueAnimator fadeInAnim;
    private ValueAnimator fadeOutAnim;
    private boolean isEndIconChecked;
    private final View.OnFocusChangeListener onEditTextFocusChangeListener = new k(this);
    private final View.OnClickListener onIconClickListener = new j(this);
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new l(this);

    DropdownMenuEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        Context context = endCompoundLayout.getContext();
        int i5 = R.attr.motionDurationShort3;
        this.animationFadeInDuration = MotionUtils.resolveThemeDuration(context, i5, 67);
        this.animationFadeOutDuration = MotionUtils.resolveThemeDuration(endCompoundLayout.getContext(), i5, 50);
        this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(endCompoundLayout.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
    }

    public static /* synthetic */ void a(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        boolean isPopupShowing = dropdownMenuEndIconDelegate.autoCompleteTextView.isPopupShowing();
        dropdownMenuEndIconDelegate.setEndIconChecked(isPopupShowing);
        dropdownMenuEndIconDelegate.dropdownPopupDirty = isPopupShowing;
    }

    public static /* synthetic */ void b(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, boolean z4) {
        int i5;
        AutoCompleteTextView autoCompleteTextView2 = dropdownMenuEndIconDelegate.autoCompleteTextView;
        if (autoCompleteTextView2 != null && !EditTextUtils.isEditable(autoCompleteTextView2)) {
            CheckableImageButton checkableImageButton = dropdownMenuEndIconDelegate.endIconView;
            if (z4) {
                i5 = 2;
            } else {
                i5 = 1;
            }
            checkableImageButton.setImportantForAccessibility(i5);
        }
    }

    public static /* synthetic */ void c(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, ValueAnimator valueAnimator) {
        dropdownMenuEndIconDelegate.getClass();
        dropdownMenuEndIconDelegate.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    @NonNull
    private static AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static /* synthetic */ void d(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, View view, boolean z4) {
        dropdownMenuEndIconDelegate.editTextHasFocus = z4;
        dropdownMenuEndIconDelegate.refreshIconState();
        if (!z4) {
            dropdownMenuEndIconDelegate.setEndIconChecked(false);
            dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
        }
    }

    public static /* synthetic */ boolean e(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, View view, MotionEvent motionEvent) {
        dropdownMenuEndIconDelegate.getClass();
        if (motionEvent.getAction() == 1) {
            if (dropdownMenuEndIconDelegate.isDropdownPopupActive()) {
                dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
            }
            dropdownMenuEndIconDelegate.showHideDropdown();
            dropdownMenuEndIconDelegate.updateDropdownPopupDirty();
        }
        return false;
    }

    public static /* synthetic */ void f(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        dropdownMenuEndIconDelegate.updateDropdownPopupDirty();
        dropdownMenuEndIconDelegate.setEndIconChecked(false);
    }

    private ValueAnimator getAlphaAnimator(int i5, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.animationFadeInterpolator);
        ofFloat.setDuration((long) i5);
        ofFloat.addUpdateListener(new g(this));
        return ofFloat;
    }

    private void initAnimators() {
        this.fadeInAnim = getAlphaAnimator(this.animationFadeInDuration, 0.0f, 1.0f);
        ValueAnimator alphaAnimator = getAlphaAnimator(this.animationFadeOutDuration, 1.0f, 0.0f);
        this.fadeOutAnim = alphaAnimator;
        alphaAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate.this.refreshIconState();
                DropdownMenuEndIconDelegate.this.fadeInAnim.start();
            }
        });
    }

    private boolean isDropdownPopupActive() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.dropdownPopupActivatedAt;
        if (uptimeMillis < 0 || uptimeMillis > 300) {
            return true;
        }
        return false;
    }

    private void setEndIconChecked(boolean z4) {
        if (this.isEndIconChecked != z4) {
            this.isEndIconChecked = z4;
            this.fadeInAnim.cancel();
            this.fadeOutAnim.start();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setUpDropdownShowHideBehavior() {
        this.autoCompleteTextView.setOnTouchListener(new h(this));
        this.autoCompleteTextView.setOnDismissListener(new i(this));
        this.autoCompleteTextView.setThreshold(0);
    }

    /* access modifiers changed from: private */
    public void showHideDropdown() {
        if (this.autoCompleteTextView != null) {
            if (isDropdownPopupActive()) {
                this.dropdownPopupDirty = false;
            }
            if (!this.dropdownPopupDirty) {
                setEndIconChecked(!this.isEndIconChecked);
                if (this.isEndIconChecked) {
                    this.autoCompleteTextView.requestFocus();
                    this.autoCompleteTextView.showDropDown();
                    return;
                }
                this.autoCompleteTextView.dismissDropDown();
                return;
            }
            this.dropdownPopupDirty = false;
        }
    }

    private void updateDropdownPopupDirty() {
        this.dropdownPopupDirty = true;
        this.dropdownPopupActivatedAt = SystemClock.uptimeMillis();
    }

    public void afterEditTextChanged(Editable editable) {
        if (this.accessibilityManager.isTouchExplorationEnabled() && EditTextUtils.isEditable(this.autoCompleteTextView) && !this.endIconView.hasFocus()) {
            this.autoCompleteTextView.dismissDropDown();
        }
        this.autoCompleteTextView.post(new m(this));
    }

    /* access modifiers changed from: package-private */
    public int getIconContentDescriptionResId() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    /* access modifiers changed from: package-private */
    public int getIconDrawableResId() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return this.onEditTextFocusChangeListener;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    public AccessibilityManager.TouchExplorationStateChangeListener getTouchExplorationStateChangeListener() {
        return this.touchExplorationStateChangeListener;
    }

    /* access modifiers changed from: package-private */
    public boolean isBoxBackgroundModeSupported(int i5) {
        return i5 != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isIconActivable() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isIconActivated() {
        return this.editTextHasFocus;
    }

    /* access modifiers changed from: package-private */
    public boolean isIconCheckable() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isIconChecked() {
        return this.isEndIconChecked;
    }

    public void onEditTextAttached(@Nullable EditText editText) {
        this.autoCompleteTextView = castAutoCompleteTextViewOrThrow(editText);
        setUpDropdownShowHideBehavior();
        this.textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!EditTextUtils.isEditable(editText) && this.accessibilityManager.isTouchExplorationEnabled()) {
            this.endIconView.setImportantForAccessibility(2);
        }
        this.textInputLayout.setEndIconVisible(true);
    }

    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!EditTextUtils.isEditable(this.autoCompleteTextView)) {
            accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.isShowingHintText()) {
            accessibilityNodeInfoCompat.setHintText((CharSequence) null);
        }
    }

    @SuppressLint({"WrongConstant"})
    public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
        boolean z4;
        if (this.accessibilityManager.isEnabled() && !EditTextUtils.isEditable(this.autoCompleteTextView)) {
            if ((accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.isEndIconChecked && !this.autoCompleteTextView.isPopupShowing()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (accessibilityEvent.getEventType() == 1 || z4) {
                showHideDropdown();
                updateDropdownPopupDirty();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setUp() {
        initAnimators();
        this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
    }

    /* access modifiers changed from: package-private */
    public boolean shouldTintIconOnError() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void tearDown() {
        AutoCompleteTextView autoCompleteTextView2 = this.autoCompleteTextView;
        if (autoCompleteTextView2 != null) {
            autoCompleteTextView2.setOnTouchListener((View.OnTouchListener) null);
            this.autoCompleteTextView.setOnDismissListener((AutoCompleteTextView.OnDismissListener) null);
        }
    }
}
