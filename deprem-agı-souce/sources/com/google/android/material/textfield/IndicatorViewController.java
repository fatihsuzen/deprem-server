package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

final class IndicatorViewController {
    private static final int CAPTION_STATE_ERROR = 1;
    private static final int CAPTION_STATE_HELPER_TEXT = 2;
    private static final int CAPTION_STATE_NONE = 0;
    static final int COUNTER_INDEX = 2;
    private static final int DEFAULT_CAPTION_FADE_ANIMATION_DURATION = 167;
    private static final int DEFAULT_CAPTION_TRANSLATION_Y_ANIMATION_DURATION = 217;
    static final int ERROR_INDEX = 0;
    static final int HELPER_INDEX = 1;
    /* access modifiers changed from: private */
    @Nullable
    public Animator captionAnimator;
    private FrameLayout captionArea;
    /* access modifiers changed from: private */
    public int captionDisplayed;
    private final int captionFadeInAnimationDuration;
    @NonNull
    private final TimeInterpolator captionFadeInAnimationInterpolator;
    private final int captionFadeOutAnimationDuration;
    @NonNull
    private final TimeInterpolator captionFadeOutAnimationInterpolator;
    private int captionToShow;
    private final int captionTranslationYAnimationDuration;
    @NonNull
    private final TimeInterpolator captionTranslationYAnimationInterpolator;
    private final float captionTranslationYPx;
    private final Context context;
    private boolean errorEnabled;
    @Nullable
    private CharSequence errorText;
    private int errorTextAppearance;
    /* access modifiers changed from: private */
    @Nullable
    public TextView errorView;
    private int errorViewAccessibilityLiveRegion;
    @Nullable
    private CharSequence errorViewContentDescription;
    @Nullable
    private ColorStateList errorViewTextColor;
    private CharSequence helperText;
    private boolean helperTextEnabled;
    private int helperTextTextAppearance;
    @Nullable
    private TextView helperTextView;
    @Nullable
    private ColorStateList helperTextViewTextColor;
    private LinearLayout indicatorArea;
    private int indicatorsAdded;
    /* access modifiers changed from: private */
    @NonNull
    public final TextInputLayout textInputView;
    private Typeface typeface;

    public IndicatorViewController(@NonNull TextInputLayout textInputLayout) {
        Context context2 = textInputLayout.getContext();
        this.context = context2;
        this.textInputView = textInputLayout;
        this.captionTranslationYPx = (float) context2.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        int i5 = R.attr.motionDurationShort4;
        this.captionTranslationYAnimationDuration = MotionUtils.resolveThemeDuration(context2, i5, DEFAULT_CAPTION_TRANSLATION_Y_ANIMATION_DURATION);
        this.captionFadeInAnimationDuration = MotionUtils.resolveThemeDuration(context2, R.attr.motionDurationMedium4, DEFAULT_CAPTION_FADE_ANIMATION_DURATION);
        this.captionFadeOutAnimationDuration = MotionUtils.resolveThemeDuration(context2, i5, DEFAULT_CAPTION_FADE_ANIMATION_DURATION);
        int i6 = R.attr.motionEasingEmphasizedDecelerateInterpolator;
        this.captionTranslationYAnimationInterpolator = MotionUtils.resolveThemeInterpolator(context2, i6, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        this.captionFadeInAnimationInterpolator = MotionUtils.resolveThemeInterpolator(context2, i6, timeInterpolator);
        this.captionFadeOutAnimationInterpolator = MotionUtils.resolveThemeInterpolator(context2, R.attr.motionEasingLinearInterpolator, timeInterpolator);
    }

    private boolean canAdjustIndicatorPadding() {
        if (this.indicatorArea == null || this.textInputView.getEditText() == null) {
            return false;
        }
        return true;
    }

    private void createCaptionAnimators(@NonNull List<Animator> list, boolean z4, @Nullable TextView textView, int i5, int i6, int i7) {
        boolean z5;
        if (textView != null && z4) {
            if (i5 == i7 || i5 == i6) {
                if (i7 == i5) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                ObjectAnimator createCaptionOpacityAnimator = createCaptionOpacityAnimator(textView, z5);
                if (i5 == i7 && i6 != 0) {
                    createCaptionOpacityAnimator.setStartDelay((long) this.captionFadeOutAnimationDuration);
                }
                list.add(createCaptionOpacityAnimator);
                if (i7 == i5 && i6 != 0) {
                    ObjectAnimator createCaptionTranslationYAnimator = createCaptionTranslationYAnimator(textView);
                    createCaptionTranslationYAnimator.setStartDelay((long) this.captionFadeOutAnimationDuration);
                    list.add(createCaptionTranslationYAnimator);
                }
            }
        }
    }

    private ObjectAnimator createCaptionOpacityAnimator(TextView textView, boolean z4) {
        float f5;
        int i5;
        TimeInterpolator timeInterpolator;
        if (z4) {
            f5 = 1.0f;
        } else {
            f5 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{f5});
        if (z4) {
            i5 = this.captionFadeInAnimationDuration;
        } else {
            i5 = this.captionFadeOutAnimationDuration;
        }
        ofFloat.setDuration((long) i5);
        if (z4) {
            timeInterpolator = this.captionFadeInAnimationInterpolator;
        } else {
            timeInterpolator = this.captionFadeOutAnimationInterpolator;
        }
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    private ObjectAnimator createCaptionTranslationYAnimator(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.captionTranslationYPx, 0.0f});
        ofFloat.setDuration((long) this.captionTranslationYAnimationDuration);
        ofFloat.setInterpolator(this.captionTranslationYAnimationInterpolator);
        return ofFloat;
    }

    @Nullable
    private TextView getCaptionViewFromDisplayState(int i5) {
        if (i5 == 1) {
            return this.errorView;
        }
        if (i5 != 2) {
            return null;
        }
        return this.helperTextView;
    }

    private int getIndicatorPadding(boolean z4, @DimenRes int i5, int i6) {
        if (z4) {
            return this.context.getResources().getDimensionPixelSize(i5);
        }
        return i6;
    }

    private boolean isCaptionStateError(int i5) {
        if (i5 != 1 || this.errorView == null || TextUtils.isEmpty(this.errorText)) {
            return false;
        }
        return true;
    }

    private boolean isCaptionStateHelperText(int i5) {
        if (i5 != 2 || this.helperTextView == null || TextUtils.isEmpty(this.helperText)) {
            return false;
        }
        return true;
    }

    private void setCaptionViewVisibilities(int i5, int i6) {
        TextView captionViewFromDisplayState;
        TextView captionViewFromDisplayState2;
        if (i5 != i6) {
            if (!(i6 == 0 || (captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i6)) == null)) {
                captionViewFromDisplayState2.setVisibility(0);
                captionViewFromDisplayState2.setAlpha(1.0f);
            }
            if (!(i5 == 0 || (captionViewFromDisplayState = getCaptionViewFromDisplayState(i5)) == null)) {
                captionViewFromDisplayState.setVisibility(4);
                if (i5 == 1) {
                    captionViewFromDisplayState.setText((CharSequence) null);
                }
            }
            this.captionDisplayed = i6;
        }
    }

    private void setTextViewTypeface(@Nullable TextView textView, Typeface typeface2) {
        if (textView != null) {
            textView.setTypeface(typeface2);
        }
    }

    private void setViewGroupGoneIfEmpty(@NonNull ViewGroup viewGroup, int i5) {
        if (i5 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean shouldAnimateCaptionView(@Nullable TextView textView, @NonNull CharSequence charSequence) {
        if (!this.textInputView.isLaidOut() || !this.textInputView.isEnabled()) {
            return false;
        }
        if (this.captionToShow != this.captionDisplayed || textView == null || !TextUtils.equals(textView.getText(), charSequence)) {
            return true;
        }
        return false;
    }

    private void updateCaptionViewsVisibility(int i5, int i6, boolean z4) {
        IndicatorViewController indicatorViewController;
        if (i5 != i6) {
            if (z4) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.captionAnimator = animatorSet;
                ArrayList arrayList = new ArrayList();
                indicatorViewController = this;
                int i7 = i5;
                int i8 = i6;
                indicatorViewController.createCaptionAnimators(arrayList, this.helperTextEnabled, this.helperTextView, 2, i7, i8);
                indicatorViewController.createCaptionAnimators(arrayList, indicatorViewController.errorEnabled, indicatorViewController.errorView, 1, i7, i8);
                AnimatorSetCompat.playTogether(animatorSet, arrayList);
                final TextView captionViewFromDisplayState = getCaptionViewFromDisplayState(i7);
                final TextView captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i8);
                final int i9 = i7;
                final int i10 = i8;
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        int unused = IndicatorViewController.this.captionDisplayed = i10;
                        Animator unused2 = IndicatorViewController.this.captionAnimator = null;
                        TextView textView = captionViewFromDisplayState;
                        if (textView != null) {
                            textView.setVisibility(4);
                            if (i9 == 1 && IndicatorViewController.this.errorView != null) {
                                IndicatorViewController.this.errorView.setText((CharSequence) null);
                            }
                        }
                        TextView textView2 = captionViewFromDisplayState2;
                        if (textView2 != null) {
                            textView2.setTranslationY(0.0f);
                            captionViewFromDisplayState2.setAlpha(1.0f);
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        TextView textView = captionViewFromDisplayState2;
                        if (textView != null) {
                            textView.setVisibility(0);
                            captionViewFromDisplayState2.setAlpha(0.0f);
                        }
                    }
                });
                animatorSet.start();
            } else {
                indicatorViewController = this;
                setCaptionViewVisibilities(i5, i6);
            }
            indicatorViewController.textInputView.updateEditTextBackground();
            indicatorViewController.textInputView.updateLabelState(z4);
            indicatorViewController.textInputView.updateTextInputBoxState();
        }
    }

    /* access modifiers changed from: package-private */
    public void addIndicator(TextView textView, int i5) {
        if (this.indicatorArea == null && this.captionArea == null) {
            LinearLayout linearLayout = new LinearLayout(this.context);
            this.indicatorArea = linearLayout;
            linearLayout.setOrientation(0);
            this.textInputView.addView(this.indicatorArea, -1, -2);
            this.captionArea = new FrameLayout(this.context);
            this.indicatorArea.addView(this.captionArea, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.textInputView.getEditText() != null) {
                adjustIndicatorPadding();
            }
        }
        if (isCaptionView(i5)) {
            this.captionArea.setVisibility(0);
            this.captionArea.addView(textView);
        } else {
            this.indicatorArea.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
    }

    /* access modifiers changed from: package-private */
    public void adjustIndicatorPadding() {
        if (canAdjustIndicatorPadding()) {
            EditText editText = this.textInputView.getEditText();
            boolean isFontScaleAtLeast1_3 = MaterialResources.isFontScaleAtLeast1_3(this.context);
            LinearLayout linearLayout = this.indicatorArea;
            int i5 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
            linearLayout.setPaddingRelative(getIndicatorPadding(isFontScaleAtLeast1_3, i5, editText.getPaddingStart()), getIndicatorPadding(isFontScaleAtLeast1_3, R.dimen.material_helper_text_font_1_3_padding_top, this.context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), getIndicatorPadding(isFontScaleAtLeast1_3, i5, editText.getPaddingEnd()), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelCaptionAnimator() {
        Animator animator = this.captionAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean errorIsDisplayed() {
        return isCaptionStateError(this.captionDisplayed);
    }

    /* access modifiers changed from: package-private */
    public boolean errorShouldBeShown() {
        return isCaptionStateError(this.captionToShow);
    }

    /* access modifiers changed from: package-private */
    public int getErrorAccessibilityLiveRegion() {
        return this.errorViewAccessibilityLiveRegion;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.errorViewContentDescription;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getErrorText() {
        return this.errorText;
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int getErrorViewCurrentTextColor() {
        TextView textView = this.errorView;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getErrorViewTextColors() {
        TextView textView = this.errorView;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getHelperText() {
        return this.helperText;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public View getHelperTextView() {
        return this.helperTextView;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getHelperTextViewColors() {
        TextView textView = this.helperTextView;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int getHelperTextViewCurrentTextColor() {
        TextView textView = this.helperTextView;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean helperTextIsDisplayed() {
        return isCaptionStateHelperText(this.captionDisplayed);
    }

    /* access modifiers changed from: package-private */
    public boolean helperTextShouldBeShown() {
        return isCaptionStateHelperText(this.captionToShow);
    }

    /* access modifiers changed from: package-private */
    public void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) {
            if (!this.helperTextEnabled || TextUtils.isEmpty(this.helperText)) {
                this.captionToShow = 0;
            } else {
                this.captionToShow = 2;
            }
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, ""));
    }

    /* access modifiers changed from: package-private */
    public void hideHelperText() {
        cancelCaptionAnimator();
        int i5 = this.captionDisplayed;
        if (i5 == 2) {
            this.captionToShow = 0;
        }
        updateCaptionViewsVisibility(i5, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, ""));
    }

    /* access modifiers changed from: package-private */
    public boolean isCaptionView(int i5) {
        return i5 == 0 || i5 == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    /* access modifiers changed from: package-private */
    public boolean isHelperTextEnabled() {
        return this.helperTextEnabled;
    }

    /* access modifiers changed from: package-private */
    public void removeIndicator(TextView textView, int i5) {
        FrameLayout frameLayout;
        if (this.indicatorArea != null) {
            if (!isCaptionView(i5) || (frameLayout = this.captionArea) == null) {
                this.indicatorArea.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i6 = this.indicatorsAdded - 1;
            this.indicatorsAdded = i6;
            setViewGroupGoneIfEmpty(this.indicatorArea, i6);
        }
    }

    /* access modifiers changed from: package-private */
    public void setErrorAccessibilityLiveRegion(int i5) {
        this.errorViewAccessibilityLiveRegion = i5;
        TextView textView = this.errorView;
        if (textView != null) {
            textView.setAccessibilityLiveRegion(i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.errorViewContentDescription = charSequence;
        TextView textView = this.errorView;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void setErrorEnabled(boolean z4) {
        if (this.errorEnabled != z4) {
            cancelCaptionAnimator();
            if (z4) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.context);
                this.errorView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_error);
                this.errorView.setTextAlignment(5);
                Typeface typeface2 = this.typeface;
                if (typeface2 != null) {
                    this.errorView.setTypeface(typeface2);
                }
                setErrorTextAppearance(this.errorTextAppearance);
                setErrorViewTextColor(this.errorViewTextColor);
                setErrorContentDescription(this.errorViewContentDescription);
                setErrorAccessibilityLiveRegion(this.errorViewAccessibilityLiveRegion);
                this.errorView.setVisibility(4);
                addIndicator(this.errorView, 0);
            } else {
                hideError();
                removeIndicator(this.errorView, 0);
                this.errorView = null;
                this.textInputView.updateEditTextBackground();
                this.textInputView.updateTextInputBoxState();
            }
            this.errorEnabled = z4;
        }
    }

    /* access modifiers changed from: package-private */
    public void setErrorTextAppearance(@StyleRes int i5) {
        this.errorTextAppearance = i5;
        TextView textView = this.errorView;
        if (textView != null) {
            this.textInputView.setTextAppearanceCompatWithErrorFallback(textView, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void setErrorViewTextColor(@Nullable ColorStateList colorStateList) {
        this.errorViewTextColor = colorStateList;
        TextView textView = this.errorView;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void setHelperTextAppearance(@StyleRes int i5) {
        this.helperTextTextAppearance = i5;
        TextView textView = this.helperTextView;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void setHelperTextEnabled(boolean z4) {
        if (this.helperTextEnabled != z4) {
            cancelCaptionAnimator();
            if (z4) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.context);
                this.helperTextView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_helper_text);
                this.helperTextView.setTextAlignment(5);
                Typeface typeface2 = this.typeface;
                if (typeface2 != null) {
                    this.helperTextView.setTypeface(typeface2);
                }
                this.helperTextView.setVisibility(4);
                this.helperTextView.setAccessibilityLiveRegion(1);
                setHelperTextAppearance(this.helperTextTextAppearance);
                setHelperTextViewTextColor(this.helperTextViewTextColor);
                addIndicator(this.helperTextView, 1);
                this.helperTextView.setAccessibilityDelegate(new View.AccessibilityDelegate() {
                    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                        EditText editText = IndicatorViewController.this.textInputView.getEditText();
                        if (editText != null) {
                            accessibilityNodeInfo.setLabeledBy(editText);
                        }
                    }
                });
            } else {
                hideHelperText();
                removeIndicator(this.helperTextView, 1);
                this.helperTextView = null;
                this.textInputView.updateEditTextBackground();
                this.textInputView.updateTextInputBoxState();
            }
            this.helperTextEnabled = z4;
        }
    }

    /* access modifiers changed from: package-private */
    public void setHelperTextViewTextColor(@Nullable ColorStateList colorStateList) {
        this.helperTextViewTextColor = colorStateList;
        TextView textView = this.helperTextView;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void setTypefaces(Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            setTextViewTypeface(this.errorView, typeface2);
            setTextViewTypeface(this.helperTextView, typeface2);
        }
    }

    /* access modifiers changed from: package-private */
    public void showError(CharSequence charSequence) {
        cancelCaptionAnimator();
        this.errorText = charSequence;
        this.errorView.setText(charSequence);
        int i5 = this.captionDisplayed;
        if (i5 != 1) {
            this.captionToShow = 1;
        }
        updateCaptionViewsVisibility(i5, this.captionToShow, shouldAnimateCaptionView(this.errorView, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void showHelper(CharSequence charSequence) {
        cancelCaptionAnimator();
        this.helperText = charSequence;
        this.helperTextView.setText(charSequence);
        int i5 = this.captionDisplayed;
        if (i5 != 2) {
            this.captionToShow = 2;
        }
        updateCaptionViewsVisibility(i5, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, charSequence));
    }
}
