package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;

class ClearTextEndIconDelegate extends EndIconDelegate {
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private static final int DEFAULT_ANIMATION_FADE_DURATION = 100;
    private static final int DEFAULT_ANIMATION_SCALE_DURATION = 150;
    private final int animationFadeDuration;
    @NonNull
    private final TimeInterpolator animationFadeInterpolator;
    private final int animationScaleDuration;
    @NonNull
    private final TimeInterpolator animationScaleInterpolator;
    @Nullable
    private EditText editText;
    private AnimatorSet iconInAnim;
    private ValueAnimator iconOutAnim;
    private final View.OnFocusChangeListener onFocusChangeListener = new b(this);
    private final View.OnClickListener onIconClickListener = new a(this);

    ClearTextEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        Context context = endCompoundLayout.getContext();
        int i5 = R.attr.motionDurationShort3;
        this.animationFadeDuration = MotionUtils.resolveThemeDuration(context, i5, 100);
        this.animationScaleDuration = MotionUtils.resolveThemeDuration(endCompoundLayout.getContext(), i5, DEFAULT_ANIMATION_SCALE_DURATION);
        this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(endCompoundLayout.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.animationScaleInterpolator = MotionUtils.resolveThemeInterpolator(endCompoundLayout.getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }

    public static /* synthetic */ void a(ClearTextEndIconDelegate clearTextEndIconDelegate, View view) {
        EditText editText2 = clearTextEndIconDelegate.editText;
        if (editText2 != null) {
            Editable text = editText2.getText();
            if (text != null) {
                text.clear();
            }
            clearTextEndIconDelegate.refreshIconState();
        }
    }

    /* access modifiers changed from: private */
    public void animateIcon(boolean z4) {
        boolean z5;
        if (this.endLayout.isEndIconVisible() == z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z4 && !this.iconInAnim.isRunning()) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z5) {
                this.iconInAnim.end();
            }
        } else if (!z4) {
            this.iconInAnim.cancel();
            this.iconOutAnim.start();
            if (z5) {
                this.iconOutAnim.end();
            }
        }
    }

    public static /* synthetic */ void c(ClearTextEndIconDelegate clearTextEndIconDelegate, ValueAnimator valueAnimator) {
        clearTextEndIconDelegate.getClass();
        clearTextEndIconDelegate.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void d(ClearTextEndIconDelegate clearTextEndIconDelegate, ValueAnimator valueAnimator) {
        clearTextEndIconDelegate.getClass();
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        clearTextEndIconDelegate.endIconView.setScaleX(floatValue);
        clearTextEndIconDelegate.endIconView.setScaleY(floatValue);
    }

    private ValueAnimator getAlphaAnimator(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.animationFadeInterpolator);
        ofFloat.setDuration((long) this.animationFadeDuration);
        ofFloat.addUpdateListener(new c(this));
        return ofFloat;
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{ANIMATION_SCALE_FROM_VALUE, 1.0f});
        ofFloat.setInterpolator(this.animationScaleInterpolator);
        ofFloat.setDuration((long) this.animationScaleDuration);
        ofFloat.addUpdateListener(new e(this));
        return ofFloat;
    }

    private void initAnimators() {
        ValueAnimator scaleAnimator = getScaleAnimator();
        ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.iconInAnim = animatorSet;
        animatorSet.playTogether(new Animator[]{scaleAnimator, alphaAnimator});
        this.iconInAnim.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.endLayout.setEndIconVisible(true);
            }
        });
        ValueAnimator alphaAnimator2 = getAlphaAnimator(1.0f, 0.0f);
        this.iconOutAnim = alphaAnimator2;
        alphaAnimator2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.endLayout.setEndIconVisible(false);
            }
        });
    }

    private boolean shouldBeVisible() {
        EditText editText2 = this.editText;
        if (editText2 == null) {
            return false;
        }
        if ((editText2.hasFocus() || this.endIconView.hasFocus()) && this.editText.getText().length() > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void afterEditTextChanged(@NonNull Editable editable) {
        if (this.endLayout.getSuffixText() == null) {
            animateIcon(shouldBeVisible());
        }
    }

    /* access modifiers changed from: package-private */
    public int getIconContentDescriptionResId() {
        return R.string.clear_text_end_icon_content_description;
    }

    /* access modifiers changed from: package-private */
    public int getIconDrawableResId() {
        return R.drawable.mtrl_ic_cancel;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener getOnIconViewFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    public void onEditTextAttached(@Nullable EditText editText2) {
        this.editText = editText2;
        this.textInputLayout.setEndIconVisible(shouldBeVisible());
    }

    /* access modifiers changed from: package-private */
    public void onSuffixVisibilityChanged(boolean z4) {
        if (this.endLayout.getSuffixText() != null) {
            animateIcon(z4);
        }
    }

    /* access modifiers changed from: package-private */
    public void setUp() {
        initAnimators();
    }

    /* access modifiers changed from: package-private */
    public void tearDown() {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            editText2.post(new d(this));
        }
    }
}
