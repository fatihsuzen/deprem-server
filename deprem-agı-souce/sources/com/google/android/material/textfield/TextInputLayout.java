package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEFAULT_PLACEHOLDER_FADE_DURATION = 87;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_TextInputLayout;
    private static final int[][] EDIT_TEXT_BACKGROUND_RIPPLE_STATE = {new int[]{16842919}, new int[0]};
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private static final int NO_WIDTH = -1;
    private static final int PLACEHOLDER_START_DELAY = 67;
    private static final String TAG = "TextInputLayout";
    private ValueAnimator animator;
    private boolean areCornerRadiiRtl;
    @Nullable
    private MaterialShapeDrawable boxBackground;
    private boolean boxBackgroundApplied;
    @ColorInt
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    @ColorInt
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    @Nullable
    private MaterialShapeDrawable boxUnderlineDefault;
    @Nullable
    private MaterialShapeDrawable boxUnderlineFocused;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    @Nullable
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    @Nullable
    private ColorStateList counterTextColor;
    @Nullable
    private TextView counterView;
    @Nullable
    private ColorStateList cursorColor;
    @Nullable
    private ColorStateList cursorErrorColor;
    @ColorInt
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    @ColorInt
    private int defaultStrokeColor;
    @ColorInt
    private int disabledColor;
    @ColorInt
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;
    @Nullable
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    /* access modifiers changed from: private */
    @NonNull
    public final EndCompoundLayout endLayout;
    private boolean expandedHintEnabled;
    private final int extraSpaceBetweenPlaceholderAndHint;
    private StateListDrawable filledDropDownMenuBackground;
    @ColorInt
    private int focusedFilledBackgroundColor;
    @ColorInt
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean globalLayoutListenerAdded;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    @ColorInt
    private int hoveredFilledBackgroundColor;
    @ColorInt
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    /* access modifiers changed from: private */
    public final IndicatorViewController indicatorViewController;
    @NonNull
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    @NonNull
    private LengthCounter lengthCounter;
    private int maxEms;
    private int maxWidth;
    private int minEms;
    private int minWidth;
    private Drawable originalEditTextEndDrawable;
    int originalEditTextMinimumHeight;
    private CharSequence originalHint;
    private MaterialShapeDrawable outlinedDropDownMenuBackground;
    /* access modifiers changed from: private */
    public boolean placeholderEnabled;
    @Nullable
    private Fade placeholderFadeIn;
    @Nullable
    private Fade placeholderFadeOut;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;
    @Nullable
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;
    /* access modifiers changed from: private */
    public boolean restoringSavedState;
    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;
    @Nullable
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    /* access modifiers changed from: private */
    @NonNull
    public final StartCompoundLayout startLayout;
    private ColorStateList strokeErrorColor;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Editable editable;
            boolean z4;
            String str;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.layout.getEditText();
            if (editText != null) {
                editable = editText.getText();
            } else {
                editable = null;
            }
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence placeholderText = this.layout.getPlaceholderText();
            int counterMaxLength = this.layout.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean isEmpty = TextUtils.isEmpty(editable);
            boolean isEmpty2 = TextUtils.isEmpty(hint);
            boolean isHintExpanded = this.layout.isHintExpanded();
            boolean isEmpty3 = TextUtils.isEmpty(error);
            if (!isEmpty3 || !TextUtils.isEmpty(counterOverflowDescription)) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!isEmpty2) {
                str = hint.toString();
            } else {
                str = "";
            }
            this.layout.startLayout.setupAccessibilityNodeInfo(accessibilityNodeInfoCompat);
            if (!isEmpty) {
                accessibilityNodeInfoCompat.setText(editable);
            } else if (!TextUtils.isEmpty(str)) {
                accessibilityNodeInfoCompat.setText(str);
                if (!isHintExpanded && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(str + ", " + placeholderText);
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(str);
                } else {
                    if (!isEmpty) {
                        str = editable + ", " + str;
                    }
                    accessibilityNodeInfoCompat.setText(str);
                }
                accessibilityNodeInfoCompat.setShowingHintText(isEmpty);
            }
            if (editable == null || editable.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z4) {
                if (isEmpty3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            View helperTextView = this.layout.indicatorViewController.getHelperTextView();
            if (helperTextView != null) {
                accessibilityNodeInfoCompat.setLabelFor(helperTextView);
            }
            this.layout.endLayout.getEndIconDelegate().onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        }

        public void onPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.layout.endLayout.getEndIconDelegate().onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface LengthCounter {
        int countLength(@Nullable Editable editable);
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@NonNull TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i5);
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

            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        @Nullable
        CharSequence error;
        boolean isEndIconChecked;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + "}";
        }

        public void writeToParcel(@NonNull Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            TextUtils.writeToParcel(this.error, parcel, i5);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
        }

        SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() != 1 ? false : true;
        }
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addPlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            this.inputFrame.addView(textView);
            this.placeholderTextView.setVisibility(0);
        }
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText != null && this.boxBackgroundMode == 1) {
            if (!isHintTextSingleLine()) {
                EditText editText2 = this.editText;
                editText2.setPaddingRelative(editText2.getPaddingStart(), (int) (this.collapsingTextHelper.getCollapsedTextHeight() + ((float) this.extraSpaceBetweenPlaceholderAndHint)), this.editText.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            } else if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
                EditText editText3 = this.editText;
                editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), this.editText.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                EditText editText4 = this.editText;
                editText4.setPaddingRelative(editText4.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), this.editText.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null) {
            ShapeAppearanceModel shapeAppearanceModel2 = materialShapeDrawable.getShapeAppearanceModel();
            ShapeAppearanceModel shapeAppearanceModel3 = this.shapeAppearanceModel;
            if (shapeAppearanceModel2 != shapeAppearanceModel3) {
                this.boxBackground.setShapeAppearanceModel(shapeAppearanceModel3);
            }
            if (canDrawOutlineStroke()) {
                this.boxBackground.setStroke((float) this.boxStrokeWidthPx, this.boxStrokeColor);
            }
            int calculateBoxBackgroundColor = calculateBoxBackgroundColor();
            this.boxBackgroundColor = calculateBoxBackgroundColor;
            this.boxBackground.setFillColor(ColorStateList.valueOf(calculateBoxBackgroundColor));
            applyBoxUnderlineAttributes();
            updateEditTextBoxBackgroundIfNeeded();
        }
    }

    private void applyBoxUnderlineAttributes() {
        ColorStateList colorStateList;
        if (this.boxUnderlineDefault != null && this.boxUnderlineFocused != null) {
            if (canDrawStroke()) {
                MaterialShapeDrawable materialShapeDrawable = this.boxUnderlineDefault;
                if (this.editText.isFocused()) {
                    colorStateList = ColorStateList.valueOf(this.defaultStrokeColor);
                } else {
                    colorStateList = ColorStateList.valueOf(this.boxStrokeColor);
                }
                materialShapeDrawable.setFillColor(colorStateList);
                this.boxUnderlineFocused.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
            }
            invalidate();
        }
    }

    private void applyCutoutPadding(@NonNull RectF rectF) {
        float f5 = rectF.left;
        int i5 = this.boxLabelCutoutPaddingPx;
        rectF.left = f5 - ((float) i5);
        rectF.right += (float) i5;
    }

    private void assignBoxBackgroundByMode() {
        int i5 = this.boxBackgroundMode;
        if (i5 == 0) {
            this.boxBackground = null;
            this.boxUnderlineDefault = null;
            this.boxUnderlineFocused = null;
        } else if (i5 == 1) {
            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderlineDefault = new MaterialShapeDrawable();
            this.boxUnderlineFocused = new MaterialShapeDrawable();
        } else if (i5 == 2) {
            if (!this.hintEnabled || (this.boxBackground instanceof CutoutDrawable)) {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            } else {
                this.boxBackground = CutoutDrawable.create(this.shapeAppearanceModel);
            }
            this.boxUnderlineDefault = null;
            this.boxUnderlineFocused = null;
        } else {
            throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    public static /* synthetic */ int c(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    private int calculateBoxBackgroundColor() {
        int i5 = this.boxBackgroundColor;
        if (this.boxBackgroundMode == 1) {
            return MaterialColors.layer(MaterialColors.getColor((View) this, R.attr.colorSurface, 0), this.boxBackgroundColor);
        }
        return i5;
    }

    @NonNull
    private Rect calculateCollapsedTextBounds(@NonNull Rect rect) {
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            rect2.bottom = rect.bottom;
            int i5 = this.boxBackgroundMode;
            if (i5 == 1) {
                rect2.left = getLabelLeftBoundAlignedWithPrefixAndSuffix(rect.left, isLayoutRtl);
                rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
                rect2.right = getLabelRightBoundAlignedWithPrefixAndSuffix(rect.right, isLayoutRtl);
                return rect2;
            } else if (i5 != 2) {
                rect2.left = getLabelLeftBoundAlignedWithPrefixAndSuffix(rect.left, isLayoutRtl);
                rect2.top = getPaddingTop();
                rect2.right = getLabelRightBoundAlignedWithPrefixAndSuffix(rect.right, isLayoutRtl);
                return rect2;
            } else {
                rect2.left = rect.left + this.editText.getPaddingLeft();
                rect2.top = rect.top - calculateLabelMarginTop();
                rect2.right = rect.right - this.editText.getPaddingRight();
                return rect2;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private int calculateExpandedLabelBottom(@NonNull Rect rect, @NonNull Rect rect2, float f5) {
        if (isSingleLineFilledTextField()) {
            return (int) (((float) rect2.top) + f5);
        }
        return rect.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(@NonNull Rect rect, float f5) {
        int i5;
        if (isSingleLineFilledTextField()) {
            return (int) (((float) rect.centerY()) - (f5 / 2.0f));
        }
        if (this.boxBackgroundMode != 0 || isHintTextSingleLine()) {
            i5 = 0;
        } else {
            i5 = (int) (this.collapsingTextHelper.getExpandedTextSingleLineHeight() / 2.0f);
        }
        return (rect.top + this.editText.getCompoundPaddingTop()) - i5;
    }

    @NonNull
    private Rect calculateExpandedTextBounds(@NonNull Rect rect) {
        float f5;
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            if (isHintTextSingleLine()) {
                f5 = this.collapsingTextHelper.getExpandedTextSingleLineHeight();
            } else {
                f5 = this.collapsingTextHelper.getExpandedTextFullSingleLineHeight() * ((float) this.collapsingTextHelper.getExpandedLineCount());
            }
            rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
            rect2.top = calculateExpandedLabelTop(rect, f5);
            rect2.right = rect.right - this.editText.getCompoundPaddingRight();
            rect2.bottom = calculateExpandedLabelBottom(rect, rect2, f5);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int calculateLabelMarginTop() {
        if (!this.hintEnabled) {
            return 0;
        }
        int i5 = this.boxBackgroundMode;
        if (i5 == 0) {
            return (int) this.collapsingTextHelper.getCollapsedTextHeight();
        }
        if (i5 != 2) {
            return 0;
        }
        if (isHintTextSingleLine()) {
            return (int) (this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f);
        }
        return Math.max(0, (int) (this.collapsingTextHelper.getCollapsedTextHeight() - (this.collapsingTextHelper.getCollapsedSingleLineHeight() / 2.0f)));
    }

    private boolean canDrawOutlineStroke() {
        if (this.boxBackgroundMode != 2 || !canDrawStroke()) {
            return false;
        }
        return true;
    }

    private boolean canDrawStroke() {
        if (this.boxStrokeWidthPx <= -1 || this.boxStrokeColor == 0) {
            return false;
        }
        return true;
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((CutoutDrawable) this.boxBackground).removeCutout();
        }
    }

    private void collapseHint(boolean z4) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z4 || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        } else {
            animateToExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
        updatePlaceholderText();
        this.startLayout.onHintStateChanged(false);
        this.endLayout.onHintStateChanged(false);
    }

    private Fade createPlaceholderFadeTransition() {
        Fade fade = new Fade();
        fade.setDuration((long) MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationShort2, 87));
        fade.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR));
        return fade;
    }

    private boolean cutoutEnabled() {
        if (!this.hintEnabled || TextUtils.isEmpty(this.hint) || !(this.boxBackground instanceof CutoutDrawable)) {
            return false;
        }
        return true;
    }

    private void dispatchOnEditTextAttached() {
        Iterator<OnEditTextAttachedListener> it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEditTextAttached(this);
        }
    }

    private void drawBoxUnderline(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        if (this.boxUnderlineFocused != null && (materialShapeDrawable = this.boxUnderlineDefault) != null) {
            materialShapeDrawable.draw(canvas);
            if (this.editText.isFocused()) {
                Rect bounds = this.boxUnderlineFocused.getBounds();
                Rect bounds2 = this.boxUnderlineDefault.getBounds();
                float expansionFraction = this.collapsingTextHelper.getExpansionFraction();
                int centerX = bounds2.centerX();
                bounds.left = AnimationUtils.lerp(centerX, bounds2.left, expansionFraction);
                bounds.right = AnimationUtils.lerp(centerX, bounds2.right, expansionFraction);
                this.boxUnderlineFocused.draw(canvas);
            }
        }
    }

    private void drawHint(@NonNull Canvas canvas) {
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    private void expandHint(boolean z4) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z4 || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(0.0f);
        } else {
            animateToExpansionFraction(0.0f);
        }
        if (cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout()) {
            closeCutout();
        }
        this.hintExpanded = true;
        hidePlaceholderText();
        this.startLayout.onHintStateChanged(true);
        this.endLayout.onHintStateChanged(true);
    }

    private MaterialShapeDrawable getDropDownMaterialShapeDrawable(boolean z4) {
        float f5;
        float f6;
        ColorStateList colorStateList;
        float dimensionPixelOffset = (float) getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        if (z4) {
            f5 = dimensionPixelOffset;
        } else {
            f5 = 0.0f;
        }
        EditText editText2 = this.editText;
        if (editText2 instanceof MaterialAutoCompleteTextView) {
            f6 = ((MaterialAutoCompleteTextView) editText2).getPopupElevation();
        } else {
            f6 = (float) getResources().getDimensionPixelOffset(R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        }
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ShapeAppearanceModel build = ShapeAppearanceModel.builder().setTopLeftCornerSize(f5).setTopRightCornerSize(f5).setBottomLeftCornerSize(dimensionPixelOffset).setBottomRightCornerSize(dimensionPixelOffset).build();
        EditText editText3 = this.editText;
        if (editText3 instanceof MaterialAutoCompleteTextView) {
            colorStateList = ((MaterialAutoCompleteTextView) editText3).getDropDownBackgroundTintList();
        } else {
            colorStateList = null;
        }
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(getContext(), f6, colorStateList);
        createWithElevationOverlay.setShapeAppearanceModel(build);
        createWithElevationOverlay.setPadding(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return createWithElevationOverlay;
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText editText2 = this.editText;
        if (!(editText2 instanceof AutoCompleteTextView) || EditTextUtils.isEditable(editText2)) {
            return this.boxBackground;
        }
        int color = MaterialColors.getColor(this.editText, androidx.appcompat.R.attr.colorControlHighlight);
        int i5 = this.boxBackgroundMode;
        if (i5 == 2) {
            return getOutlinedBoxBackgroundWithRipple(getContext(), this.boxBackground, color, EDIT_TEXT_BACKGROUND_RIPPLE_STATE);
        }
        if (i5 == 1) {
            return getFilledBoxBackgroundWithRipple(this.boxBackground, this.boxBackgroundColor, color, EDIT_TEXT_BACKGROUND_RIPPLE_STATE);
        }
        return null;
    }

    private static Drawable getFilledBoxBackgroundWithRipple(MaterialShapeDrawable materialShapeDrawable, int i5, int i6, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.layer(i6, i5, 0.1f), i5}), materialShapeDrawable, materialShapeDrawable);
    }

    private int getLabelLeftBoundAlignedWithPrefixAndSuffix(int i5, boolean z4) {
        int compoundPaddingLeft;
        if (!z4 && getPrefixText() != null) {
            compoundPaddingLeft = this.startLayout.getPrefixTextStartOffset();
        } else if (!z4 || getSuffixText() == null) {
            compoundPaddingLeft = this.editText.getCompoundPaddingLeft();
        } else {
            compoundPaddingLeft = this.endLayout.getSuffixTextEndOffset();
        }
        return i5 + compoundPaddingLeft;
    }

    private int getLabelRightBoundAlignedWithPrefixAndSuffix(int i5, boolean z4) {
        int compoundPaddingRight;
        if (!z4 && getSuffixText() != null) {
            compoundPaddingRight = this.endLayout.getSuffixTextEndOffset();
        } else if (!z4 || getPrefixText() == null) {
            compoundPaddingRight = this.editText.getCompoundPaddingRight();
        } else {
            compoundPaddingRight = this.startLayout.getPrefixTextStartOffset();
        }
        return i5 - compoundPaddingRight;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.filledDropDownMenuBackground == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.filledDropDownMenuBackground = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, getOrCreateOutlinedDropDownMenuBackground());
            this.filledDropDownMenuBackground.addState(new int[0], getDropDownMaterialShapeDrawable(false));
        }
        return this.filledDropDownMenuBackground;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.outlinedDropDownMenuBackground == null) {
            this.outlinedDropDownMenuBackground = getDropDownMaterialShapeDrawable(true);
        }
        return this.outlinedDropDownMenuBackground;
    }

    private static Drawable getOutlinedBoxBackgroundWithRipple(Context context, MaterialShapeDrawable materialShapeDrawable, int i5, int[][] iArr) {
        int color = MaterialColors.getColor(context, R.attr.colorSurface, "TextInputLayout");
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        int layer = MaterialColors.layer(i5, color, 0.1f);
        materialShapeDrawable2.setFillColor(new ColorStateList(iArr, new int[]{layer, 0}));
        materialShapeDrawable2.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{layer, color});
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        materialShapeDrawable3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
    }

    private void hidePlaceholderText() {
        TextView textView = this.placeholderTextView;
        if (textView != null && this.placeholderEnabled) {
            textView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeOut);
            this.placeholderTextView.setVisibility(4);
        }
    }

    private boolean isHintTextSingleLine() {
        if (getHintMaxLines() == 1) {
            return true;
        }
        return false;
    }

    private boolean isOnError() {
        if (shouldShowError()) {
            return true;
        }
        if (this.counterView == null || !this.counterOverflowed) {
            return false;
        }
        return true;
    }

    private boolean isSingleLineFilledTextField() {
        if (this.boxBackgroundMode != 1 || this.editText.getMinLines() > 1) {
            return false;
        }
        return true;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        updateEditTextBoxBackgroundIfNeeded();
        updateTextInputBoxState();
        updateBoxCollapsedPaddingTop();
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
        setDropDownMenuBackgroundIfNeeded();
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextBottomTextBounds(rectF, this.editText.getWidth(), this.editText.getGravity());
            if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                applyCutoutPadding(rectF);
                rectF.offset((float) (-getPaddingLeft()), (((float) (-getPaddingTop())) - (rectF.height() / 2.0f)) + ((float) this.boxStrokeWidthPx));
                rectF.top = 0.0f;
                ((CutoutDrawable) this.boxBackground).setCutout(rectF);
            }
        }
    }

    private void recalculateCutout() {
        if (cutoutEnabled() && !this.hintExpanded) {
            closeCutout();
            openCutout();
        }
    }

    private static void recursiveSetEnabled(@NonNull ViewGroup viewGroup, boolean z4) {
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            childAt.setEnabled(z4);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z4);
            }
        }
    }

    private void removePlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void setDropDownMenuBackgroundIfNeeded() {
        EditText editText2 = this.editText;
        if (editText2 instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText2;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i5 = this.boxBackgroundMode;
                if (i5 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i5 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    private void setEditText(EditText editText2) {
        if (this.editText == null) {
            if (getEndIconMode() != 3 && !(editText2 instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.editText = editText2;
            int i5 = this.minEms;
            if (i5 != -1) {
                setMinEms(i5);
            } else {
                setMinWidth(this.minWidth);
            }
            int i6 = this.maxEms;
            if (i6 != -1) {
                setMaxEms(i6);
            } else {
                setMaxWidth(this.maxWidth);
            }
            this.boxBackgroundApplied = false;
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
            this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
            this.collapsingTextHelper.setExpandedLetterSpacing(this.editText.getLetterSpacing());
            int gravity = this.editText.getGravity();
            this.collapsingTextHelper.setCollapsedTextGravity((gravity & -113) | 48);
            this.collapsingTextHelper.setExpandedTextGravity(gravity);
            this.originalEditTextMinimumHeight = editText2.getMinimumHeight();
            this.editText.addTextChangedListener(new TextWatcher(editText2) {
                int previousLineCount;
                final /* synthetic */ EditText val$editText;

                {
                    this.val$editText = r2;
                    this.previousLineCount = r2.getLineCount();
                }

                public void afterTextChanged(@NonNull Editable editable) {
                    int i5;
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.updateLabelState(!textInputLayout.restoringSavedState);
                    TextInputLayout textInputLayout2 = TextInputLayout.this;
                    if (textInputLayout2.counterEnabled) {
                        textInputLayout2.updateCounter(editable);
                    }
                    if (TextInputLayout.this.placeholderEnabled) {
                        TextInputLayout.this.updatePlaceholderText(editable);
                    }
                    int lineCount = this.val$editText.getLineCount();
                    int i6 = this.previousLineCount;
                    if (lineCount != i6) {
                        if (lineCount < i6 && this.val$editText.getMinimumHeight() != (i5 = TextInputLayout.this.originalEditTextMinimumHeight)) {
                            this.val$editText.setMinimumHeight(i5);
                        }
                        this.previousLineCount = lineCount;
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                }

                public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                }
            });
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    CharSequence hint2 = this.editText.getHint();
                    this.originalHint = hint2;
                    setHint(hint2);
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                updateCursorColor();
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText());
            }
            updateEditTextBackground();
            this.indicatorViewController.adjustIndicatorPadding();
            this.startLayout.bringToFront();
            this.endLayout.bringToFront();
            dispatchOnEditTextAttached();
            this.endLayout.updateSuffixTextViewPadding();
            if (!isEnabled()) {
                editText2.setEnabled(false);
            }
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            this.collapsingTextHelper.setText(charSequence);
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z4) {
        if (this.placeholderEnabled != z4) {
            if (z4) {
                addPlaceholderTextView();
            } else {
                removePlaceholderTextView();
                this.placeholderTextView = null;
            }
            this.placeholderEnabled = z4;
        }
    }

    private boolean shouldUpdateEndDummyDrawable() {
        if ((this.endLayout.isErrorIconVisible() || ((this.endLayout.hasEndIcon() && isEndIconVisible()) || this.endLayout.getSuffixText() != null)) && this.endLayout.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        if ((getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.startLayout.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private void showPlaceholderText() {
        if (this.placeholderTextView != null && this.placeholderEnabled && !TextUtils.isEmpty(this.placeholderText)) {
            this.placeholderTextView.setText(this.placeholderText);
            TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeIn);
            this.placeholderTextView.setVisibility(0);
            this.placeholderTextView.bringToFront();
        }
    }

    private void updateBoxCollapsedPaddingTop() {
        if (this.boxBackgroundMode != 1) {
            return;
        }
        if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
            this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
        } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
        }
    }

    private void updateBoxUnderlineBounds(@NonNull Rect rect) {
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderlineDefault;
        if (materialShapeDrawable != null) {
            int i5 = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i5 - this.boxStrokeWidthDefaultPx, rect.right, i5);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.boxUnderlineFocused;
        if (materialShapeDrawable2 != null) {
            int i6 = rect.bottom;
            materialShapeDrawable2.setBounds(rect.left, i6 - this.boxStrokeWidthFocusedPx, rect.right, i6);
        }
    }

    private void updateCollapsingTextDimens(int i5) {
        this.collapsingTextHelper.updateTextHeights(i5);
        Rect rect = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect(this, this.editText, rect);
        this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
        updateInputLayoutMargins();
        adjustFilledEditTextPaddingForLargeFont();
        updateEditTextHeight(i5);
    }

    private void updateCounter() {
        if (this.counterView != null) {
            EditText editText2 = this.editText;
            updateCounter(editText2 == null ? null : editText2.getText());
        }
    }

    private static void updateCounterContentDescription(@NonNull Context context, @NonNull TextView textView, int i5, int i6, boolean z4) {
        int i7;
        if (z4) {
            i7 = R.string.character_counter_overflowed_content_description;
        } else {
            i7 = R.string.character_counter_content_description;
        }
        textView.setContentDescription(context.getString(i7, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6)}));
    }

    private void updateCounterTextAppearanceAndColor() {
        int i5;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.counterView;
        if (textView != null) {
            if (this.counterOverflowed) {
                i5 = this.counterOverflowTextAppearance;
            } else {
                i5 = this.counterTextAppearance;
            }
            setTextAppearanceCompatWithErrorFallback(textView, i5);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (this.counterOverflowed && (colorStateList = this.counterOverflowTextColor) != null) {
                this.counterView.setTextColor(colorStateList);
            }
        }
    }

    @RequiresApi(29)
    private void updateCursorColor() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.cursorColor;
        if (colorStateList2 == null) {
            colorStateList2 = MaterialColors.getColorStateListOrNull(getContext(), androidx.appcompat.R.attr.colorControlActivated);
        }
        EditText editText2 = this.editText;
        if (editText2 != null && editText2.getTextCursorDrawable() != null) {
            Drawable mutate = DrawableCompat.wrap(this.editText.getTextCursorDrawable()).mutate();
            if (isOnError() && (colorStateList = this.cursorErrorColor) != null) {
                colorStateList2 = colorStateList;
            }
            mutate.setTintList(colorStateList2);
        }
    }

    private void updateEditTextBoxBackground() {
        this.editText.setBackground(getEditTextBoxBackground());
    }

    private void updateEditTextHeight(int i5) {
        boolean z4;
        float f5;
        if (this.editText != null) {
            float expandedTextHeight = this.collapsingTextHelper.getExpandedTextHeight();
            float f6 = 0.0f;
            if (this.placeholderText != null) {
                TextPaint textPaint = new TextPaint(TsExtractor.TS_STREAM_TYPE_AC3);
                textPaint.set(this.placeholderTextView.getPaint());
                textPaint.setTextSize(this.placeholderTextView.getTextSize());
                textPaint.setTypeface(this.placeholderTextView.getTypeface());
                textPaint.setLetterSpacing(this.placeholderTextView.getLetterSpacing());
                try {
                    StaticLayoutBuilderCompat obtain = StaticLayoutBuilderCompat.obtain(this.placeholderText, textPaint, i5);
                    if (getLayoutDirection() == 1) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    StaticLayout build = obtain.setIsRtl(z4).setIncludePad(true).setLineSpacing(this.placeholderTextView.getLineSpacingExtra(), this.placeholderTextView.getLineSpacingMultiplier()).setStaticLayoutBuilderConfigurer(new x(this)).build();
                    if (this.boxBackgroundMode == 1) {
                        f5 = this.collapsingTextHelper.getCollapsedTextHeight() + ((float) this.boxCollapsedPaddingTopPx) + ((float) this.extraSpaceBetweenPlaceholderAndHint);
                    } else {
                        f5 = 0.0f;
                    }
                    f6 = ((float) build.getHeight()) + f5;
                } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e5) {
                    Log.e("TextInputLayout", e5.getCause().getMessage(), e5);
                }
            }
            float max = Math.max(expandedTextHeight, f6);
            if (((float) this.editText.getMeasuredHeight()) < max) {
                this.editText.setMinimumHeight(Math.round(max));
            }
        }
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        int max;
        if (this.editText == null || this.editText.getMeasuredHeight() >= (max = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            return false;
        }
        this.editText.setMinimumHeight(max);
        return true;
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int calculateLabelMarginTop = calculateLabelMarginTop();
            if (calculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = calculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        EditText editText2;
        if (this.placeholderTextView != null && (editText2 = this.editText) != null) {
            this.placeholderTextView.setGravity(editText2.getGravity());
            this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        }
    }

    private void updatePlaceholderText() {
        EditText editText2 = this.editText;
        updatePlaceholderText(editText2 == null ? null : editText2.getText());
    }

    private void updateStrokeErrorColor(boolean z4, boolean z5) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z4) {
            this.boxStrokeColor = colorForState2;
        } else if (z5) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    public void addOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.add(onEditTextAttachedListener);
        if (this.editText != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void addOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.endLayout.addOnEndIconChangedListener(onEndIconChangedListener);
    }

    public void addView(@NonNull View view, int i5, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i5, layoutParams);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void animateToExpansionFraction(float f5) {
        if (this.collapsingTextHelper.getExpansionFraction() != f5) {
            if (this.animator == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.animator = valueAnimator;
                valueAnimator.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
                this.animator.setDuration((long) MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationMedium4, LABEL_SCALE_ANIMATION_DURATION));
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), f5});
            this.animator.start();
        }
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endLayout.clearOnEndIconChangedListeners();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean cutoutIsOpen() {
        if (!cutoutEnabled() || !((CutoutDrawable) this.boxBackground).hasCutout()) {
            return false;
        }
        return true;
    }

    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i5) {
        EditText editText2 = this.editText;
        if (editText2 == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i5);
            return;
        }
        if (this.originalHint != null) {
            boolean z4 = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence hint2 = editText2.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i5);
            } finally {
                this.editText.setHint(hint2);
                this.isProvidingHint = z4;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i5);
            onProvideAutofillVirtualStructure(viewStructure, i5);
            viewStructure.setChildCount(this.inputFrame.getChildCount());
            for (int i6 = 0; i6 < this.inputFrame.getChildCount(); i6++) {
                View childAt = this.inputFrame.getChildAt(i6);
                ViewStructure newChild = viewStructure.newChild(i6);
                childAt.dispatchProvideAutofillStructure(newChild, i5);
                if (childAt == this.editText) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        drawHint(canvas);
        drawBoxUnderline(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z4;
        if (!this.inDrawableStateChanged) {
            boolean z5 = true;
            this.inDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            if (collapsingTextHelper2 != null) {
                z4 = collapsingTextHelper2.setState(drawableState);
            } else {
                z4 = false;
            }
            if (this.editText != null) {
                if (!isLaidOut() || !isEnabled()) {
                    z5 = false;
                }
                updateLabelState(z5);
            }
            updateEditTextBackground();
            updateTextInputBoxState();
            if (z4) {
                invalidate();
            }
            this.inDrawableStateChanged = false;
        }
    }

    public int getBaseline() {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            return editText2.getBaseline() + getPaddingTop() + calculateLabelMarginTop();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int i5 = this.boxBackgroundMode;
        if (i5 == 1 || i5 == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
        }
        return this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
        }
        return this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
        }
        return this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusTopStart() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
        }
        return this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.counterEnabled || !this.counterOverflowed || (textView = this.counterView) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.counterOverflowTextColor;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    @RequiresApi(29)
    @Nullable
    public ColorStateList getCursorColor() {
        return this.cursorColor;
    }

    @RequiresApi(29)
    @Nullable
    public ColorStateList getCursorErrorColor() {
        return this.cursorErrorColor;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    @Nullable
    public EditText getEditText() {
        return this.editText;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.endLayout.getEndIconContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.endLayout.getEndIconDrawable();
    }

    public int getEndIconMinSize() {
        return this.endLayout.getEndIconMinSize();
    }

    public int getEndIconMode() {
        return this.endLayout.getEndIconMode();
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.endLayout.getEndIconScaleType();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.endLayout.getEndIconView();
    }

    @Nullable
    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled()) {
            return this.indicatorViewController.getErrorText();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.indicatorViewController.getErrorAccessibilityLiveRegion();
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.endLayout.getErrorIconDrawable();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled()) {
            return this.indicatorViewController.getHelperText();
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    public int getHintMaxLines() {
        return this.collapsingTextHelper.getExpandedMaxLines();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @NonNull
    public LengthCounter getLengthCounter() {
        return this.lengthCounter;
    }

    public int getMaxEms() {
        return this.maxEms;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMinEms() {
        return this.minEms;
    }

    @Px
    public int getMinWidth() {
        return this.minWidth;
    }

    @Deprecated
    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endLayout.getPasswordVisibilityToggleContentDescription();
    }

    @Deprecated
    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endLayout.getPasswordVisibilityToggleDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.startLayout.getPrefixText();
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.startLayout.getPrefixTextColor();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.startLayout.getPrefixTextView();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.startLayout.getStartIconContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.startLayout.getStartIconDrawable();
    }

    public int getStartIconMinSize() {
        return this.startLayout.getStartIconMinSize();
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.startLayout.getStartIconScaleType();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.endLayout.getSuffixText();
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.endLayout.getSuffixTextColor();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.endLayout.getSuffixTextView();
    }

    @Nullable
    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endLayout.isEndIconCheckable();
    }

    public boolean isEndIconVisible() {
        return this.endLayout.isEndIconVisible();
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    /* access modifiers changed from: package-private */
    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endLayout.isPasswordVisibilityToggleEnabled();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startLayout.isStartIconCheckable();
    }

    public boolean isStartIconVisible() {
        return this.startLayout.isStartIconVisible();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(configuration);
    }

    public void onGlobalLayout() {
        this.endLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.globalLayoutListenerAdded = false;
        boolean updateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
        boolean updateDummyDrawables = updateDummyDrawables();
        if (updateEditTextHeightBasedOnIcon || updateDummyDrawables) {
            this.editText.post(new v(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        EditText editText2 = this.editText;
        if (editText2 != null) {
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, editText2, rect);
            updateBoxUnderlineBounds(rect);
            if (this.hintEnabled) {
                this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
                int gravity = this.editText.getGravity();
                this.collapsingTextHelper.setCollapsedTextGravity((gravity & -113) | 48);
                this.collapsingTextHelper.setExpandedTextGravity(gravity);
                this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
                this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(rect));
                this.collapsingTextHelper.recalculate();
                if (cutoutEnabled() && !this.hintExpanded) {
                    openCutout();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (!this.globalLayoutListenerAdded) {
            this.endLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.globalLayoutListenerAdded = true;
        }
        updatePlaceholderMeasurementsBasedOnEditText();
        this.endLayout.updateSuffixTextViewPadding();
        if (!isHintTextSingleLine()) {
            updateCollapsingTextDimens((this.editText.getMeasuredWidth() - this.editText.getCompoundPaddingLeft()) - this.editText.getCompoundPaddingRight());
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            post(new Runnable() {
                public void run() {
                    TextInputLayout.this.endLayout.checkEndIcon();
                }
            });
        }
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        boolean z4 = true;
        if (i5 != 1) {
            z4 = false;
        }
        if (z4 != this.areCornerRadiiRtl) {
            float cornerSize = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
            float cornerSize2 = this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
            float cornerSize3 = this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
            float cornerSize4 = this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
            CornerTreatment topLeftCorner = this.shapeAppearanceModel.getTopLeftCorner();
            CornerTreatment topRightCorner = this.shapeAppearanceModel.getTopRightCorner();
            ShapeAppearanceModel build = ShapeAppearanceModel.builder().setTopLeftCorner(topRightCorner).setTopRightCorner(topLeftCorner).setBottomLeftCorner(this.shapeAppearanceModel.getBottomRightCorner()).setBottomRightCorner(this.shapeAppearanceModel.getBottomLeftCorner()).setTopLeftCornerSize(cornerSize2).setTopRightCornerSize(cornerSize).setBottomLeftCornerSize(cornerSize4).setBottomRightCornerSize(cornerSize3).build();
            this.areCornerRadiiRtl = z4;
            setShapeAppearanceModel(build);
        }
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (shouldShowError()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = this.endLayout.isEndIconChecked();
        return savedState;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z4) {
        this.endLayout.togglePasswordVisibilityToggle(z4);
    }

    public void refreshEndIconDrawableState() {
        this.endLayout.refreshEndIconDrawableState();
    }

    public void refreshErrorIconDrawableState() {
        this.endLayout.refreshErrorIconDrawableState();
    }

    public void refreshStartIconDrawableState() {
        this.startLayout.refreshStartIconDrawableState();
    }

    public void removeOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.remove(onEditTextAttachedListener);
    }

    public void removeOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.endLayout.removeOnEndIconChangedListener(onEndIconChangedListener);
    }

    public void setBoxBackgroundColor(@ColorInt int i5) {
        if (this.boxBackgroundColor != i5) {
            this.boxBackgroundColor = i5;
            this.defaultFilledBackgroundColor = i5;
            this.focusedFilledBackgroundColor = i5;
            this.hoveredFilledBackgroundColor = i5;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i5) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i5));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.defaultFilledBackgroundColor = defaultColor;
        this.boxBackgroundColor = defaultColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int i5) {
        if (i5 != this.boxBackgroundMode) {
            this.boxBackgroundMode = i5;
            if (this.editText != null) {
                onApplyBoxBackgroundMode();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i5) {
        this.boxCollapsedPaddingTopPx = i5;
    }

    public void setBoxCornerFamily(int i5) {
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCorner(i5, this.shapeAppearanceModel.getTopLeftCornerSize()).setTopRightCorner(i5, this.shapeAppearanceModel.getTopRightCornerSize()).setBottomLeftCorner(i5, this.shapeAppearanceModel.getBottomLeftCornerSize()).setBottomRightCorner(i5, this.shapeAppearanceModel.getBottomRightCornerSize()).build();
        applyBoxAttributes();
    }

    public void setBoxCornerRadii(float f5, float f6, float f7, float f8) {
        float f9;
        float f10;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        this.areCornerRadiiRtl = isLayoutRtl;
        if (isLayoutRtl) {
            f9 = f6;
        } else {
            f9 = f5;
        }
        if (!isLayoutRtl) {
            f5 = f6;
        }
        if (isLayoutRtl) {
            f10 = f8;
        } else {
            f10 = f7;
        }
        if (!isLayoutRtl) {
            f7 = f8;
        }
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable == null || materialShapeDrawable.getTopLeftCornerResolvedSize() != f9 || this.boxBackground.getTopRightCornerResolvedSize() != f5 || this.boxBackground.getBottomLeftCornerResolvedSize() != f10 || this.boxBackground.getBottomRightCornerResolvedSize() != f7) {
            this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(f9).setTopRightCornerSize(f5).setBottomLeftCornerSize(f10).setBottomRightCornerSize(f7).build();
            applyBoxAttributes();
        }
    }

    public void setBoxCornerRadiiResources(@DimenRes int i5, @DimenRes int i6, @DimenRes int i7, @DimenRes int i8) {
        setBoxCornerRadii(getContext().getResources().getDimension(i5), getContext().getResources().getDimension(i6), getContext().getResources().getDimension(i8), getContext().getResources().getDimension(i7));
    }

    public void setBoxStrokeColor(@ColorInt int i5) {
        if (this.focusedStrokeColor != i5) {
            this.focusedStrokeColor = i5;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int i5) {
        this.boxStrokeWidthDefaultPx = i5;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int i5) {
        this.boxStrokeWidthFocusedPx = i5;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i5) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i5));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i5) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i5));
    }

    public void setCounterEnabled(boolean z4) {
        if (this.counterEnabled != z4) {
            if (z4) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.counterView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface2 = this.typeface;
                if (typeface2 != null) {
                    this.counterView.setTypeface(typeface2);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.addIndicator(this.counterView, 2);
                ((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z4;
        }
    }

    public void setCounterMaxLength(int i5) {
        if (this.counterMaxLength != i5) {
            if (i5 > 0) {
                this.counterMaxLength = i5;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i5) {
        if (this.counterOverflowTextAppearance != i5) {
            this.counterOverflowTextAppearance = i5;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i5) {
        if (this.counterTextAppearance != i5) {
            this.counterTextAppearance = i5;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    @RequiresApi(29)
    public void setCursorColor(@Nullable ColorStateList colorStateList) {
        if (this.cursorColor != colorStateList) {
            this.cursorColor = colorStateList;
            updateCursorColor();
        }
    }

    @RequiresApi(29)
    public void setCursorErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.cursorErrorColor != colorStateList) {
            this.cursorErrorColor = colorStateList;
            if (isOnError()) {
                updateCursorColor();
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    public void setEnabled(boolean z4) {
        recursiveSetEnabled(this, z4);
        super.setEnabled(z4);
    }

    public void setEndIconActivated(boolean z4) {
        this.endLayout.setEndIconActivated(z4);
    }

    public void setEndIconCheckable(boolean z4) {
        this.endLayout.setEndIconCheckable(z4);
    }

    public void setEndIconContentDescription(@StringRes int i5) {
        this.endLayout.setEndIconContentDescription(i5);
    }

    public void setEndIconDrawable(@DrawableRes int i5) {
        this.endLayout.setEndIconDrawable(i5);
    }

    public void setEndIconMinSize(@IntRange(from = 0) int i5) {
        this.endLayout.setEndIconMinSize(i5);
    }

    public void setEndIconMode(int i5) {
        this.endLayout.setEndIconMode(i5);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.endLayout.setEndIconOnClickListener(onClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.endLayout.setEndIconOnLongClickListener(onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.endLayout.setEndIconScaleType(scaleType);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        this.endLayout.setEndIconTintList(colorStateList);
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.endLayout.setEndIconTintMode(mode);
    }

    public void setEndIconVisible(boolean z4) {
        this.endLayout.setEndIconVisible(z4);
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.indicatorViewController.isErrorEnabled()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.showError(charSequence);
        } else {
            this.indicatorViewController.hideError();
        }
    }

    public void setErrorAccessibilityLiveRegion(int i5) {
        this.indicatorViewController.setErrorAccessibilityLiveRegion(i5);
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.indicatorViewController.setErrorContentDescription(charSequence);
    }

    public void setErrorEnabled(boolean z4) {
        this.indicatorViewController.setErrorEnabled(z4);
    }

    public void setErrorIconDrawable(@DrawableRes int i5) {
        this.endLayout.setErrorIconDrawable(i5);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.endLayout.setErrorIconOnClickListener(onClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.endLayout.setErrorIconOnLongClickListener(onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.endLayout.setErrorIconTintList(colorStateList);
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.endLayout.setErrorIconTintMode(mode);
    }

    public void setErrorTextAppearance(@StyleRes int i5) {
        this.indicatorViewController.setErrorTextAppearance(i5);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.indicatorViewController.setErrorViewTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z4) {
        if (this.expandedHintEnabled != z4) {
            this.expandedHintEnabled = z4;
            updateLabelState(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.showHelper(charSequence);
        } else if (isHelperTextEnabled()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z4) {
        this.indicatorViewController.setHelperTextEnabled(z4);
    }

    public void setHelperTextTextAppearance(@StyleRes int i5) {
        this.indicatorViewController.setHelperTextAppearance(i5);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z4) {
        this.hintAnimationEnabled = z4;
    }

    public void setHintEnabled(boolean z4) {
        if (z4 != this.hintEnabled) {
            this.hintEnabled = z4;
            if (!z4) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint2 = this.editText.getHint();
                if (!TextUtils.isEmpty(hint2)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint2);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintMaxLines(int i5) {
        this.collapsingTextHelper.setCollapsedMaxLines(i5);
        this.collapsingTextHelper.setExpandedMaxLines(i5);
        requestLayout();
    }

    public void setHintTextAppearance(@StyleRes int i5) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i5);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    public void setLengthCounter(@NonNull LengthCounter lengthCounter2) {
        this.lengthCounter = lengthCounter2;
    }

    public void setMaxEms(int i5) {
        this.maxEms = i5;
        EditText editText2 = this.editText;
        if (editText2 != null && i5 != -1) {
            editText2.setMaxEms(i5);
        }
    }

    public void setMaxWidth(@Px int i5) {
        this.maxWidth = i5;
        EditText editText2 = this.editText;
        if (editText2 != null && i5 != -1) {
            editText2.setMaxWidth(i5);
        }
    }

    public void setMaxWidthResource(@DimenRes int i5) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i5));
    }

    public void setMinEms(int i5) {
        this.minEms = i5;
        EditText editText2 = this.editText;
        if (editText2 != null && i5 != -1) {
            editText2.setMinEms(i5);
        }
    }

    public void setMinWidth(@Px int i5) {
        this.minWidth = i5;
        EditText editText2 = this.editText;
        if (editText2 != null && i5 != -1) {
            editText2.setMinWidth(i5);
        }
    }

    public void setMinWidthResource(@DimenRes int i5) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i5));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i5) {
        this.endLayout.setPasswordVisibilityToggleContentDescription(i5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i5) {
        this.endLayout.setPasswordVisibilityToggleDrawable(i5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z4) {
        this.endLayout.setPasswordVisibilityToggleEnabled(z4);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.endLayout.setPasswordVisibilityToggleTintList(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.endLayout.setPasswordVisibilityToggleTintMode(mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.placeholderTextView == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.placeholderTextView = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            this.placeholderTextView.setImportantForAccessibility(1);
            this.placeholderTextView.setAccessibilityLiveRegion(1);
            Fade createPlaceholderFadeTransition = createPlaceholderFadeTransition();
            this.placeholderFadeIn = createPlaceholderFadeTransition;
            createPlaceholderFadeTransition.setStartDelay(67);
            this.placeholderFadeOut = createPlaceholderFadeTransition();
            setPlaceholderTextAppearance(this.placeholderTextAppearance);
            setPlaceholderTextColor(this.placeholderTextColor);
            ViewCompat.setAccessibilityDelegate(this.placeholderTextView, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setVisibleToUser(false);
                }
            });
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        }
        updatePlaceholderText();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i5) {
        this.placeholderTextAppearance = i5;
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i5);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            TextView textView = this.placeholderTextView;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.startLayout.setPrefixText(charSequence);
    }

    public void setPrefixTextAppearance(@StyleRes int i5) {
        this.startLayout.setPrefixTextAppearance(i5);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.startLayout.setPrefixTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel2) {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null && materialShapeDrawable.getShapeAppearanceModel() != shapeAppearanceModel2) {
            this.shapeAppearanceModel = shapeAppearanceModel2;
            applyBoxAttributes();
        }
    }

    public void setStartIconCheckable(boolean z4) {
        this.startLayout.setStartIconCheckable(z4);
    }

    public void setStartIconContentDescription(@StringRes int i5) {
        setStartIconContentDescription(i5 != 0 ? getResources().getText(i5) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i5) {
        setStartIconDrawable(i5 != 0 ? AppCompatResources.getDrawable(getContext(), i5) : null);
    }

    public void setStartIconMinSize(@IntRange(from = 0) int i5) {
        this.startLayout.setStartIconMinSize(i5);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.startLayout.setStartIconOnClickListener(onClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.startLayout.setStartIconOnLongClickListener(onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.startLayout.setStartIconScaleType(scaleType);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        this.startLayout.setStartIconTintList(colorStateList);
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.startLayout.setStartIconTintMode(mode);
    }

    public void setStartIconVisible(boolean z4) {
        this.startLayout.setStartIconVisible(z4);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.endLayout.setSuffixText(charSequence);
    }

    public void setSuffixTextAppearance(@StyleRes int i5) {
        this.endLayout.setSuffixTextAppearance(i5);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.endLayout.setSuffixTextColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void setTextAppearanceCompatWithErrorFallback(@NonNull TextView textView, @StyleRes int i5) {
        try {
            TextViewCompat.setTextAppearance(textView, i5);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        TextViewCompat.setTextAppearance(textView, androidx.appcompat.R.style.TextAppearance_AppCompat_Caption);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            ViewCompat.setAccessibilityDelegate(editText2, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            this.collapsingTextHelper.setTypefaces(typeface2);
            this.indicatorViewController.setTypefaces(typeface2);
            TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldShowError() {
        return this.indicatorViewController.errorShouldBeShown();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean updateDummyDrawables() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.editText
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r10.shouldUpdateStartDummyDrawable()
            r2 = 0
            r3 = 2
            r4 = 3
            r5 = 1
            if (r0 == 0) goto L_0x0049
            com.google.android.material.textfield.StartCompoundLayout r0 = r10.startLayout
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.editText
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            android.graphics.drawable.Drawable r6 = r10.startDummyDrawable
            if (r6 == 0) goto L_0x0025
            int r6 = r10.startDummyDrawableWidth
            if (r6 == r0) goto L_0x0031
        L_0x0025:
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r6.<init>()
            r10.startDummyDrawable = r6
            r10.startDummyDrawableWidth = r0
            r6.setBounds(r1, r1, r0, r5)
        L_0x0031:
            android.widget.EditText r0 = r10.editText
            android.graphics.drawable.Drawable[] r0 = r0.getCompoundDrawablesRelative()
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.startDummyDrawable
            if (r6 == r7) goto L_0x0062
            android.widget.EditText r6 = r10.editText
            r8 = r0[r5]
            r9 = r0[r3]
            r0 = r0[r4]
            r6.setCompoundDrawablesRelative(r7, r8, r9, r0)
            goto L_0x0060
        L_0x0049:
            android.graphics.drawable.Drawable r0 = r10.startDummyDrawable
            if (r0 == 0) goto L_0x0062
            android.widget.EditText r0 = r10.editText
            android.graphics.drawable.Drawable[] r0 = r0.getCompoundDrawablesRelative()
            android.widget.EditText r6 = r10.editText
            r7 = r0[r5]
            r8 = r0[r3]
            r0 = r0[r4]
            r6.setCompoundDrawablesRelative(r2, r7, r8, r0)
            r10.startDummyDrawable = r2
        L_0x0060:
            r0 = r5
            goto L_0x0063
        L_0x0062:
            r0 = r1
        L_0x0063:
            boolean r6 = r10.shouldUpdateEndDummyDrawable()
            if (r6 == 0) goto L_0x00d5
            com.google.android.material.textfield.EndCompoundLayout r2 = r10.endLayout
            android.widget.TextView r2 = r2.getSuffixTextView()
            int r2 = r2.getMeasuredWidth()
            android.widget.EditText r6 = r10.editText
            int r6 = r6.getPaddingRight()
            int r2 = r2 - r6
            com.google.android.material.textfield.EndCompoundLayout r6 = r10.endLayout
            com.google.android.material.internal.CheckableImageButton r6 = r6.getCurrentEndIconView()
            if (r6 == 0) goto L_0x0092
            int r7 = r6.getMeasuredWidth()
            int r2 = r2 + r7
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r6 = r6.getMarginStart()
            int r2 = r2 + r6
        L_0x0092:
            android.widget.EditText r6 = r10.editText
            android.graphics.drawable.Drawable[] r6 = r6.getCompoundDrawablesRelative()
            android.graphics.drawable.Drawable r7 = r10.endDummyDrawable
            if (r7 == 0) goto L_0x00b3
            int r8 = r10.endDummyDrawableWidth
            if (r8 == r2) goto L_0x00b3
            r10.endDummyDrawableWidth = r2
            r7.setBounds(r1, r1, r2, r5)
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r2 = r6[r5]
            android.graphics.drawable.Drawable r3 = r10.endDummyDrawable
            r4 = r6[r4]
            r0.setCompoundDrawablesRelative(r1, r2, r3, r4)
            return r5
        L_0x00b3:
            if (r7 != 0) goto L_0x00c1
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>()
            r10.endDummyDrawable = r7
            r10.endDummyDrawableWidth = r2
            r7.setBounds(r1, r1, r2, r5)
        L_0x00c1:
            r2 = r6[r3]
            android.graphics.drawable.Drawable r3 = r10.endDummyDrawable
            if (r2 == r3) goto L_0x00f7
            r10.originalEditTextEndDrawable = r2
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r2 = r6[r5]
            r4 = r6[r4]
            r0.setCompoundDrawablesRelative(r1, r2, r3, r4)
            return r5
        L_0x00d5:
            android.graphics.drawable.Drawable r6 = r10.endDummyDrawable
            if (r6 == 0) goto L_0x00f7
            android.widget.EditText r6 = r10.editText
            android.graphics.drawable.Drawable[] r6 = r6.getCompoundDrawablesRelative()
            r3 = r6[r3]
            android.graphics.drawable.Drawable r7 = r10.endDummyDrawable
            if (r3 != r7) goto L_0x00f3
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r3 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.originalEditTextEndDrawable
            r4 = r6[r4]
            r0.setCompoundDrawablesRelative(r1, r3, r7, r4)
            goto L_0x00f4
        L_0x00f3:
            r5 = r0
        L_0x00f4:
            r10.endDummyDrawable = r2
            return r5
        L_0x00f7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateDummyDrawables():boolean");
    }

    /* access modifiers changed from: package-private */
    public void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackgroundMode == 0 && (background = editText2.getBackground()) != null) {
            if (DrawableUtils.canSafelyMutateDrawable(background)) {
                background = background.mutate();
            }
            if (shouldShowError()) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
            } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
                DrawableCompat.clearColorFilter(background);
                this.editText.refreshDrawableState();
            } else {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateEditTextBoxBackgroundIfNeeded() {
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackground != null) {
            if ((this.boxBackgroundApplied || editText2.getBackground() == null) && this.boxBackgroundMode != 0) {
                updateEditTextBoxBackground();
                this.boxBackgroundApplied = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateLabelState(boolean z4) {
        updateLabelState(z4, false);
    }

    /* access modifiers changed from: package-private */
    public void updateTextInputBoxState() {
        boolean z4;
        TextView textView;
        EditText editText2;
        EditText editText3;
        if (this.boxBackground != null && this.boxBackgroundMode != 0) {
            boolean z5 = false;
            if (isFocused() || ((editText3 = this.editText) != null && editText3.hasFocus())) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (isHovered() || ((editText2 = this.editText) != null && editText2.isHovered())) {
                z5 = true;
            }
            if (!isEnabled()) {
                this.boxStrokeColor = this.disabledColor;
            } else if (shouldShowError()) {
                if (this.strokeErrorColor != null) {
                    updateStrokeErrorColor(z4, z5);
                } else {
                    this.boxStrokeColor = getErrorCurrentTextColors();
                }
            } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
                if (z4) {
                    this.boxStrokeColor = this.focusedStrokeColor;
                } else if (z5) {
                    this.boxStrokeColor = this.hoveredStrokeColor;
                } else {
                    this.boxStrokeColor = this.defaultStrokeColor;
                }
            } else if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z4, z5);
            } else {
                this.boxStrokeColor = textView.getCurrentTextColor();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                updateCursorColor();
            }
            this.endLayout.onTextInputBoxStateUpdated();
            refreshStartIconDrawableState();
            if (this.boxBackgroundMode == 2) {
                int i5 = this.boxStrokeWidthPx;
                if (!z4 || !isEnabled()) {
                    this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
                } else {
                    this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
                }
                if (this.boxStrokeWidthPx != i5) {
                    recalculateCutout();
                }
            }
            if (this.boxBackgroundMode == 1) {
                if (!isEnabled()) {
                    this.boxBackgroundColor = this.disabledFilledBackgroundColor;
                } else if (z5 && !z4) {
                    this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
                } else if (z4) {
                    this.boxBackgroundColor = this.focusedFilledBackgroundColor;
                } else {
                    this.boxBackgroundColor = this.defaultFilledBackgroundColor;
                }
            }
            applyBoxAttributes();
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    private void updateLabelState(boolean z4, boolean z5) {
        ColorStateList colorStateList;
        TextView textView;
        int i5;
        boolean isEnabled = isEnabled();
        EditText editText2 = this.editText;
        boolean z6 = false;
        boolean z7 = editText2 != null && !TextUtils.isEmpty(editText2.getText());
        EditText editText3 = this.editText;
        if (editText3 != null && editText3.hasFocus()) {
            z6 = true;
        }
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.setCollapsedAndExpandedTextColor(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.defaultHintTextColor;
            if (colorStateList3 != null) {
                i5 = colorStateList3.getColorForState(new int[]{-16842910}, this.disabledColor);
            } else {
                i5 = this.disabledColor;
            }
            this.collapsingTextHelper.setCollapsedAndExpandedTextColor(ColorStateList.valueOf(i5));
        } else if (shouldShowError()) {
            this.collapsingTextHelper.setCollapsedAndExpandedTextColor(this.indicatorViewController.getErrorViewTextColors());
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.setCollapsedAndExpandedTextColor(textView.getTextColors());
        } else if (z6 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        if (z7 || !this.expandedHintEnabled || (isEnabled() && z6)) {
            if (z5 || this.hintExpanded) {
                collapseHint(z4);
            }
        } else if (z5 || !this.hintExpanded) {
            expandHint(z4);
        }
    }

    /* access modifiers changed from: private */
    public void updatePlaceholderText(@Nullable Editable editable) {
        if (this.lengthCounter.countLength(editable) != 0 || this.hintExpanded) {
            hidePlaceholderText();
        } else {
            showPlaceholderText();
        }
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        this.endLayout.setEndIconContentDescription(charSequence);
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.endLayout.setEndIconDrawable(drawable);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.endLayout.setErrorIconDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.endLayout.setPasswordVisibilityToggleContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.endLayout.setPasswordVisibilityToggleDrawable(drawable);
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        this.startLayout.setStartIconContentDescription(charSequence);
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.startLayout.setStartIconDrawable(drawable);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r20, @androidx.annotation.Nullable android.util.AttributeSet r21, int r22) {
        /*
            r19 = this;
            r0 = r19
            r2 = r21
            r4 = r22
            int r5 = DEF_STYLE_RES
            r1 = r20
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r2, r4, r5)
            r0.<init>(r1, r2, r4)
            r7 = -1
            r0.minEms = r7
            r0.maxEms = r7
            r0.minWidth = r7
            r0.maxWidth = r7
            com.google.android.material.textfield.IndicatorViewController r1 = new com.google.android.material.textfield.IndicatorViewController
            r1.<init>(r0)
            r0.indicatorViewController = r1
            com.google.android.material.textfield.w r1 = new com.google.android.material.textfield.w
            r1.<init>()
            r0.lengthCounter = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.tmpRect = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.tmpBoundsRect = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.tmpRectF = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.editTextAttachedListeners = r1
            com.google.android.material.internal.CollapsingTextHelper r1 = new com.google.android.material.internal.CollapsingTextHelper
            r1.<init>(r0)
            r0.collapsingTextHelper = r1
            r8 = 0
            r0.globalLayoutListenerAdded = r8
            android.content.Context r3 = r0.getContext()
            r9 = 1
            r0.setOrientation(r9)
            r0.setWillNotDraw(r8)
            r0.setAddStatesFromChildren(r9)
            android.widget.FrameLayout r10 = new android.widget.FrameLayout
            r10.<init>(r3)
            r0.inputFrame = r10
            r10.setAddStatesFromChildren(r9)
            android.animation.TimeInterpolator r6 = com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR
            r1.setTextSizeInterpolator(r6)
            r1.setPositionInterpolator(r6)
            r6 = 8388659(0x800033, float:1.1755015E-38)
            r1.setCollapsedTextGravity(r6)
            r1 = r3
            int[] r3 = com.google.android.material.R.styleable.TextInputLayout
            int r11 = com.google.android.material.R.styleable.TextInputLayout_counterTextAppearance
            int r12 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextAppearance
            int r13 = com.google.android.material.R.styleable.TextInputLayout_errorTextAppearance
            int r14 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextAppearance
            int r15 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            int[] r6 = new int[]{r11, r12, r13, r14, r15}
            androidx.appcompat.widget.TintTypedArray r3 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r1, r2, r3, r4, r5, r6)
            com.google.android.material.textfield.StartCompoundLayout r6 = new com.google.android.material.textfield.StartCompoundLayout
            r6.<init>(r0, r3)
            r0.startLayout = r6
            int r8 = com.google.android.material.R.styleable.TextInputLayout_hintEnabled
            boolean r8 = r3.getBoolean(r8, r9)
            r0.hintEnabled = r8
            int r8 = com.google.android.material.R.styleable.TextInputLayout_android_hint
            java.lang.CharSequence r8 = r3.getText(r8)
            r0.setHint((java.lang.CharSequence) r8)
            int r8 = com.google.android.material.R.styleable.TextInputLayout_hintAnimationEnabled
            boolean r8 = r3.getBoolean(r8, r9)
            r0.hintAnimationEnabled = r8
            int r8 = com.google.android.material.R.styleable.TextInputLayout_expandedHintEnabled
            boolean r8 = r3.getBoolean(r8, r9)
            r0.expandedHintEnabled = r8
            int r8 = com.google.android.material.R.styleable.TextInputLayout_android_minEms
            boolean r16 = r3.hasValue(r8)
            if (r16 == 0) goto L_0x00c1
            int r8 = r3.getInt(r8, r7)
            r0.setMinEms(r8)
            goto L_0x00d0
        L_0x00c1:
            int r8 = com.google.android.material.R.styleable.TextInputLayout_android_minWidth
            boolean r16 = r3.hasValue(r8)
            if (r16 == 0) goto L_0x00d0
            int r8 = r3.getDimensionPixelSize(r8, r7)
            r0.setMinWidth(r8)
        L_0x00d0:
            int r8 = com.google.android.material.R.styleable.TextInputLayout_android_maxEms
            boolean r16 = r3.hasValue(r8)
            if (r16 == 0) goto L_0x00e0
            int r8 = r3.getInt(r8, r7)
            r0.setMaxEms(r8)
            goto L_0x00ef
        L_0x00e0:
            int r8 = com.google.android.material.R.styleable.TextInputLayout_android_maxWidth
            boolean r16 = r3.hasValue(r8)
            if (r16 == 0) goto L_0x00ef
            int r8 = r3.getDimensionPixelSize(r8, r7)
            r0.setMaxWidth(r8)
        L_0x00ef:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r2 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r1, (android.util.AttributeSet) r2, (int) r4, (int) r5)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.build()
            r0.shapeAppearanceModel = r2
            android.content.res.Resources r2 = r1.getResources()
            int r4 = com.google.android.material.R.dimen.mtrl_textinput_box_label_cutout_padding
            int r2 = r2.getDimensionPixelOffset(r4)
            r0.boxLabelCutoutPaddingPx = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxCollapsedPaddingTop
            r4 = 0
            int r2 = r3.getDimensionPixelOffset(r2, r4)
            r0.boxCollapsedPaddingTopPx = r2
            android.content.res.Resources r2 = r0.getResources()
            int r4 = com.google.android.material.R.dimen.m3_multiline_hint_filled_text_extra_space
            int r2 = r2.getDimensionPixelSize(r4)
            r0.extraSpaceBetweenPlaceholderAndHint = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidth
            android.content.res.Resources r4 = r1.getResources()
            int r5 = com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_default
            int r4 = r4.getDimensionPixelSize(r5)
            int r2 = r3.getDimensionPixelSize(r2, r4)
            r0.boxStrokeWidthDefaultPx = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidthFocused
            android.content.res.Resources r4 = r1.getResources()
            int r5 = com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_focused
            int r4 = r4.getDimensionPixelSize(r5)
            int r2 = r3.getDimensionPixelSize(r2, r4)
            r0.boxStrokeWidthFocusedPx = r2
            int r2 = r0.boxStrokeWidthDefaultPx
            r0.boxStrokeWidthPx = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopStart
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r3.getDimension(r2, r4)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopEnd
            float r5 = r3.getDimension(r5, r4)
            int r8 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomEnd
            float r8 = r3.getDimension(r8, r4)
            int r9 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomStart
            float r4 = r3.getDimension(r9, r4)
            com.google.android.material.shape.ShapeAppearanceModel r9 = r0.shapeAppearanceModel
            com.google.android.material.shape.ShapeAppearanceModel$Builder r9 = r9.toBuilder()
            r17 = 0
            int r18 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r18 < 0) goto L_0x016b
            r9.setTopLeftCornerSize((float) r2)
        L_0x016b:
            int r2 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r2 < 0) goto L_0x0172
            r9.setTopRightCornerSize((float) r5)
        L_0x0172:
            int r2 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r2 < 0) goto L_0x0179
            r9.setBottomRightCornerSize((float) r8)
        L_0x0179:
            int r2 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r2 < 0) goto L_0x0180
            r9.setBottomLeftCornerSize((float) r4)
        L_0x0180:
            com.google.android.material.shape.ShapeAppearanceModel r2 = r9.build()
            r0.shapeAppearanceModel = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxBackgroundColor
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r1, (androidx.appcompat.widget.TintTypedArray) r3, (int) r2)
            if (r2 == 0) goto L_0x01e6
            int r4 = r2.getDefaultColor()
            r0.defaultFilledBackgroundColor = r4
            r0.boxBackgroundColor = r4
            boolean r4 = r2.isStateful()
            r5 = 16843623(0x1010367, float:2.3696E-38)
            r8 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            if (r4 == 0) goto L_0x01c7
            int[] r4 = new int[]{r8}
            int r4 = r2.getColorForState(r4, r7)
            r0.disabledFilledBackgroundColor = r4
            r4 = 16842908(0x101009c, float:2.3693995E-38)
            r8 = 16842910(0x101009e, float:2.3694E-38)
            int[] r4 = new int[]{r4, r8}
            int r4 = r2.getColorForState(r4, r7)
            r0.focusedFilledBackgroundColor = r4
            int[] r4 = new int[]{r5, r8}
            int r2 = r2.getColorForState(r4, r7)
            r0.hoveredFilledBackgroundColor = r2
            goto L_0x01f1
        L_0x01c7:
            int r2 = r0.defaultFilledBackgroundColor
            r0.focusedFilledBackgroundColor = r2
            int r2 = com.google.android.material.R.color.mtrl_filled_background_color
            android.content.res.ColorStateList r2 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r1, r2)
            int[] r4 = new int[]{r8}
            int r4 = r2.getColorForState(r4, r7)
            r0.disabledFilledBackgroundColor = r4
            int[] r4 = new int[]{r5}
            int r2 = r2.getColorForState(r4, r7)
            r0.hoveredFilledBackgroundColor = r2
            goto L_0x01f1
        L_0x01e6:
            r4 = 0
            r0.boxBackgroundColor = r4
            r0.defaultFilledBackgroundColor = r4
            r0.disabledFilledBackgroundColor = r4
            r0.focusedFilledBackgroundColor = r4
            r0.hoveredFilledBackgroundColor = r4
        L_0x01f1:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_textColorHint
            boolean r4 = r3.hasValue(r2)
            if (r4 == 0) goto L_0x0201
            android.content.res.ColorStateList r2 = r3.getColorStateList(r2)
            r0.focusedTextColor = r2
            r0.defaultHintTextColor = r2
        L_0x0201:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeColor
            android.content.res.ColorStateList r4 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r1, (androidx.appcompat.widget.TintTypedArray) r3, (int) r2)
            r5 = 0
            int r2 = r3.getColor(r2, r5)
            r0.focusedStrokeColor = r2
            int r2 = com.google.android.material.R.color.mtrl_textinput_default_box_stroke_color
            int r2 = androidx.core.content.ContextCompat.getColor(r1, r2)
            r0.defaultStrokeColor = r2
            int r2 = com.google.android.material.R.color.mtrl_textinput_disabled_color
            int r2 = androidx.core.content.ContextCompat.getColor(r1, r2)
            r0.disabledColor = r2
            int r2 = com.google.android.material.R.color.mtrl_textinput_hovered_box_stroke_color
            int r2 = androidx.core.content.ContextCompat.getColor(r1, r2)
            r0.hoveredStrokeColor = r2
            if (r4 == 0) goto L_0x022b
            r0.setBoxStrokeColorStateList(r4)
        L_0x022b:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeErrorColor
            boolean r4 = r3.hasValue(r2)
            if (r4 == 0) goto L_0x023a
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r1, (androidx.appcompat.widget.TintTypedArray) r3, (int) r2)
            r0.setBoxStrokeErrorColor(r1)
        L_0x023a:
            int r1 = r3.getResourceId(r15, r7)
            r4 = 0
            if (r1 == r7) goto L_0x0248
            int r1 = r3.getResourceId(r15, r4)
            r0.setHintTextAppearance(r1)
        L_0x0248:
            int r1 = com.google.android.material.R.styleable.TextInputLayout_cursorColor
            android.content.res.ColorStateList r1 = r3.getColorStateList(r1)
            r0.cursorColor = r1
            int r1 = com.google.android.material.R.styleable.TextInputLayout_cursorErrorColor
            android.content.res.ColorStateList r1 = r3.getColorStateList(r1)
            r0.cursorErrorColor = r1
            int r1 = r3.getResourceId(r13, r4)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorContentDescription
            java.lang.CharSequence r2 = r3.getText(r2)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_errorAccessibilityLiveRegion
            r8 = 1
            int r5 = r3.getInt(r5, r8)
            int r8 = com.google.android.material.R.styleable.TextInputLayout_errorEnabled
            boolean r8 = r3.getBoolean(r8, r4)
            int r9 = r3.getResourceId(r14, r4)
            int r13 = com.google.android.material.R.styleable.TextInputLayout_helperTextEnabled
            boolean r13 = r3.getBoolean(r13, r4)
            int r14 = com.google.android.material.R.styleable.TextInputLayout_helperText
            java.lang.CharSequence r14 = r3.getText(r14)
            int r15 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextAppearance
            int r15 = r3.getResourceId(r15, r4)
            int r7 = com.google.android.material.R.styleable.TextInputLayout_placeholderText
            java.lang.CharSequence r7 = r3.getText(r7)
            r21 = r14
            int r14 = com.google.android.material.R.styleable.TextInputLayout_counterEnabled
            boolean r14 = r3.getBoolean(r14, r4)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_counterMaxLength
            r22 = r14
            r14 = -1
            int r4 = r3.getInt(r4, r14)
            r0.setCounterMaxLength(r4)
            r4 = 0
            int r11 = r3.getResourceId(r11, r4)
            r0.counterTextAppearance = r11
            int r11 = r3.getResourceId(r12, r4)
            r0.counterOverflowTextAppearance = r11
            int r11 = com.google.android.material.R.styleable.TextInputLayout_boxBackgroundMode
            int r4 = r3.getInt(r11, r4)
            r0.setBoxBackgroundMode(r4)
            r0.setErrorContentDescription(r2)
            r0.setErrorAccessibilityLiveRegion(r5)
            int r2 = r0.counterOverflowTextAppearance
            r0.setCounterOverflowTextAppearance(r2)
            r0.setHelperTextTextAppearance(r9)
            r0.setErrorTextAppearance(r1)
            int r1 = r0.counterTextAppearance
            r0.setCounterTextAppearance(r1)
            r0.setPlaceholderText(r7)
            r0.setPlaceholderTextAppearance(r15)
            int r1 = com.google.android.material.R.styleable.TextInputLayout_errorTextColor
            boolean r2 = r3.hasValue(r1)
            if (r2 == 0) goto L_0x02e0
            android.content.res.ColorStateList r1 = r3.getColorStateList(r1)
            r0.setErrorTextColor(r1)
        L_0x02e0:
            int r1 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextColor
            boolean r2 = r3.hasValue(r1)
            if (r2 == 0) goto L_0x02ef
            android.content.res.ColorStateList r1 = r3.getColorStateList(r1)
            r0.setHelperTextColor(r1)
        L_0x02ef:
            int r1 = com.google.android.material.R.styleable.TextInputLayout_hintTextColor
            boolean r2 = r3.hasValue(r1)
            if (r2 == 0) goto L_0x02fe
            android.content.res.ColorStateList r1 = r3.getColorStateList(r1)
            r0.setHintTextColor(r1)
        L_0x02fe:
            int r1 = com.google.android.material.R.styleable.TextInputLayout_counterTextColor
            boolean r2 = r3.hasValue(r1)
            if (r2 == 0) goto L_0x030d
            android.content.res.ColorStateList r1 = r3.getColorStateList(r1)
            r0.setCounterTextColor(r1)
        L_0x030d:
            int r1 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextColor
            boolean r2 = r3.hasValue(r1)
            if (r2 == 0) goto L_0x031c
            android.content.res.ColorStateList r1 = r3.getColorStateList(r1)
            r0.setCounterOverflowTextColor(r1)
        L_0x031c:
            int r1 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextColor
            boolean r2 = r3.hasValue(r1)
            if (r2 == 0) goto L_0x032b
            android.content.res.ColorStateList r1 = r3.getColorStateList(r1)
            r0.setPlaceholderTextColor(r1)
        L_0x032b:
            com.google.android.material.textfield.EndCompoundLayout r1 = new com.google.android.material.textfield.EndCompoundLayout
            r1.<init>(r0, r3)
            r0.endLayout = r1
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_enabled
            r4 = 1
            boolean r2 = r3.getBoolean(r2, r4)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_hintMaxLines
            int r5 = r3.getInt(r5, r4)
            r0.setHintMaxLines(r5)
            r3.recycle()
            r3 = 2
            r0.setImportantForAccessibility(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r5 = 26
            if (r3 < r5) goto L_0x0352
            r0.setImportantForAutofill(r4)
        L_0x0352:
            r10.addView(r6)
            r10.addView(r1)
            r0.addView(r10)
            r0.setEnabled(r2)
            r0.setHelperTextEnabled(r13)
            r0.setErrorEnabled(r8)
            r1 = r22
            r0.setCounterEnabled(r1)
            r1 = r21
            r0.setHelperText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void updateCounter(@Nullable Editable editable) {
        int countLength = this.lengthCounter.countLength(editable);
        boolean z4 = this.counterOverflowed;
        int i5 = this.counterMaxLength;
        if (i5 == -1) {
            this.counterView.setText(String.valueOf(countLength));
            this.counterView.setContentDescription((CharSequence) null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = countLength > i5;
            updateCounterContentDescription(getContext(), this.counterView, countLength, this.counterMaxLength, this.counterOverflowed);
            if (z4 != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            this.counterView.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(countLength), Integer.valueOf(this.counterMaxLength)})));
        }
        if (this.editText != null && z4 != this.counterOverflowed) {
            updateLabelState(false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }

    public void setHint(@StringRes int i5) {
        setHint(i5 != 0 ? getResources().getText(i5) : null);
    }
}
