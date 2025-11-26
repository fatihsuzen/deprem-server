package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    private static final int DEFAULT_LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final int DEFAULT_LABEL_ANIMATION_EXIT_DURATION = 117;
    static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION = "minSeparation(%s) must be greater or equal to 0";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final int HALO_ALPHA = 63;
    private static final int LABEL_ANIMATION_ENTER_DURATION_ATTR = R.attr.motionDurationMedium4;
    private static final int LABEL_ANIMATION_ENTER_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final int LABEL_ANIMATION_EXIT_DURATION_ATTR = R.attr.motionDurationShort3;
    private static final int LABEL_ANIMATION_EXIT_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    private static final float LEFT_LABEL_PIVOT_X = 1.2f;
    private static final float LEFT_LABEL_PIVOT_Y = 0.5f;
    private static final int MAX_TIMEOUT_TOOLTIP_WITH_ACCESSIBILITY = 120000;
    private static final int MIN_TIMEOUT_TOOLTIP_WITH_ACCESSIBILITY = 10000;
    private static final float RIGHT_LABEL_PIVOT_X = -0.2f;
    private static final float RIGHT_LABEL_PIVOT_Y = 0.5f;
    /* access modifiers changed from: private */
    public static final String TAG = "BaseSlider";
    private static final double THRESHOLD = 1.0E-4d;
    private static final float THUMB_WIDTH_PRESSED_RATIO = 0.5f;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private static final float TOP_LABEL_PIVOT_X = 0.5f;
    private static final float TOP_LABEL_PIVOT_Y = 1.2f;
    private static final float TOUCH_SLOP_RATIO = 0.8f;
    private static final int TRACK_CORNER_SIZE_UNSET = -1;
    static final int UNIT_PX = 0;
    static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
    private static final String WARNING_PARSE_ERROR = "Error parsing value(%s), valueFrom(%s), and valueTo(%s) into a float.";
    private BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;
    /* access modifiers changed from: private */
    @NonNull
    public final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;
    @NonNull
    private final Paint activeTicksPaint;
    @NonNull
    private final Paint activeTrackPaint;
    @NonNull
    private final RectF activeTrackRect;
    private boolean centered;
    @NonNull
    private final List<L> changeListeners;
    @NonNull
    private final RectF cornerRect;
    @Nullable
    private Drawable customThumbDrawable;
    @NonNull
    private List<Drawable> customThumbDrawablesForValues;
    @NonNull
    private final MaterialShapeDrawable defaultThumbDrawable;
    private int defaultThumbRadius;
    private int defaultThumbTrackGapSize;
    private int defaultThumbWidth;
    private int defaultTickActiveRadius;
    private int defaultTickInactiveRadius;
    private int defaultTrackThickness;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;
    @NonNull
    private ColorStateList haloColor;
    @NonNull
    private final Paint haloPaint;
    private int haloRadius;
    @NonNull
    private final Rect iconRect;
    @NonNull
    private final RectF iconRectF;
    @NonNull
    private final Paint inactiveTicksPaint;
    @NonNull
    private final RectF inactiveTrackLeftRect;
    @NonNull
    private final Paint inactiveTrackPaint;
    @NonNull
    private final RectF inactiveTrackRightRect;
    private boolean isLongPress;
    private int labelBehavior;
    private int labelPadding;
    @NonNull
    private final Rect labelRect;
    private int labelStyle;
    /* access modifiers changed from: private */
    @NonNull
    public final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTickSpacing;
    @Px
    private int minTouchTargetSize;
    private int minTrackSidePadding;
    private int minWidgetThickness;
    @NonNull
    private final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    @NonNull
    private final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
    @NonNull
    private final Runnable resetActiveThumbIndex;
    @NonNull
    private final Matrix rotationMatrix;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;
    @NonNull
    private final Paint stopIndicatorPaint;
    private boolean thisAndAncestorsVisible;
    private int thumbHeight;
    private boolean thumbIsPressed;
    @NonNull
    private final Paint thumbPaint;
    private int thumbTrackGapSize;
    private int thumbWidth;
    private int tickActiveRadius;
    @NonNull
    private ColorStateList tickColorActive;
    @NonNull
    private ColorStateList tickColorInactive;
    private int tickInactiveRadius;
    private int tickVisibilityMode;
    private float[] ticksCoordinates;
    private final int tooltipTimeoutMillis;
    private float touchDownAxis1;
    private float touchDownAxis2;
    @NonNull
    private final List<T> touchListeners;
    private float touchPosition;
    @NonNull
    private ColorStateList trackColorActive;
    @NonNull
    private ColorStateList trackColorInactive;
    private int trackCornerSize;
    @Nullable
    private ColorStateList trackIconActiveColor;
    @Nullable
    private Drawable trackIconActiveEnd;
    private boolean trackIconActiveEndMutated;
    @Nullable
    private Drawable trackIconActiveStart;
    private boolean trackIconActiveStartMutated;
    @Nullable
    private ColorStateList trackIconInactiveColor;
    @Nullable
    private Drawable trackIconInactiveEnd;
    private boolean trackIconInactiveEndMutated;
    @Nullable
    private Drawable trackIconInactiveStart;
    private boolean trackIconInactiveStartMutated;
    @Px
    private int trackIconPadding;
    @Px
    private int trackIconSize;
    private int trackInsideCornerSize;
    @NonNull
    private final Path trackPath;
    private int trackSidePadding;
    private int trackStopIndicatorSize;
    private int trackThickness;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetOrientation;
    private int widgetThickness;

    private class AccessibilityEventSender implements Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        public void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }

        /* access modifiers changed from: package-private */
        public void setVirtualViewId(int i5) {
            this.virtualViewId = i5;
        }
    }

    public static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> slider;
        final Rect virtualViewBounds = new Rect();

        AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.slider = baseSlider;
        }

        @NonNull
        private String startOrEndDescription(int i5) {
            if (i5 == this.slider.getValues().size() - 1) {
                return this.slider.getContext().getString(R.string.material_slider_range_end);
            }
            if (i5 == 0) {
                return this.slider.getContext().getString(R.string.material_slider_range_start);
            }
            return "";
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float f5, float f6) {
            for (int i5 = 0; i5 < this.slider.getValues().size(); i5++) {
                this.slider.updateBoundsForVirtualViewId(i5, this.virtualViewBounds);
                if (this.virtualViewBounds.contains((int) f5, (int) f6)) {
                    return i5;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(@NonNull List<Integer> list) {
            for (int i5 = 0; i5 < this.slider.getValues().size(); i5++) {
                list.add(Integer.valueOf(i5));
            }
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i5, int i6, @Nullable Bundle bundle) {
            if (!this.slider.isEnabled()) {
                return false;
            }
            if (i6 == 4096 || i6 == 8192) {
                float access$900 = this.slider.calculateStepIncrement(20);
                if (i6 == 8192) {
                    access$900 = -access$900;
                }
                if (this.slider.isRtl()) {
                    access$900 = -access$900;
                }
                if (!this.slider.snapThumbToValue(i5, MathUtils.clamp(this.slider.getValues().get(i5).floatValue() + access$900, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                    return false;
                }
                this.slider.setActiveThumbIndex(i5);
                this.slider.scheduleTooltipTimeout();
                this.slider.updateHaloHotspot();
                this.slider.postInvalidate();
                invalidateVirtualView(i5);
                return true;
            }
            if (i6 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                if (this.slider.snapThumbToValue(i5, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                    this.slider.updateHaloHotspot();
                    this.slider.postInvalidate();
                    invalidateVirtualView(i5);
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int i5, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.slider.getValues();
            Float f5 = values.get(i5);
            float floatValue = f5.floatValue();
            float valueFrom = this.slider.getValueFrom();
            float valueTo = this.slider.getValueTo();
            if (this.slider.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            NumberFormat numberInstance = NumberFormat.getNumberInstance();
            numberInstance.setMaximumFractionDigits(2);
            try {
                valueFrom = numberInstance.parse(numberInstance.format((double) valueFrom)).floatValue();
                valueTo = numberInstance.parse(numberInstance.format((double) valueTo)).floatValue();
                floatValue = numberInstance.parse(numberInstance.format((double) floatValue)).floatValue();
            } catch (ParseException unused) {
                Log.w(BaseSlider.TAG, String.format(BaseSlider.WARNING_PARSE_ERROR, new Object[]{f5, Float.valueOf(valueFrom), Float.valueOf(valueTo)}));
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.slider.getContentDescription() != null) {
                sb.append(this.slider.getContentDescription());
                sb.append(",");
            }
            String access$600 = this.slider.formatValue(floatValue);
            String string = this.slider.getContext().getString(R.string.material_slider_value);
            if (values.size() > 1) {
                string = startOrEndDescription(i5);
            }
            CharSequence stateDescription = ViewCompat.getStateDescription(this.slider);
            if (!TextUtils.isEmpty(stateDescription)) {
                accessibilityNodeInfoCompat.setStateDescription(stateDescription);
            } else {
                sb.append(String.format(Locale.getDefault(), "%s, %s", new Object[]{string, access$600}));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.slider.updateBoundsForVirtualViewId(i5, this.virtualViewBounds);
            accessibilityNodeInfoCompat.setBoundsInParent(this.virtualViewBounds);
        }
    }

    private enum FullCornerDirection {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() {
            @NonNull
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel);
            }

            @NonNull
            public SliderState[] newArray(int i5) {
                return new SliderState[i5];
            }
        };
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        public void writeToParcel(@NonNull Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.values = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }
    }

    public BaseSlider(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ void a(BaseSlider baseSlider) {
        baseSlider.setActiveThumbIndex(-1);
        baseSlider.invalidate();
    }

    private void adjustCustomThumbDrawableBounds(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.thumbWidth, this.thumbHeight);
            return;
        }
        float max = ((float) Math.max(this.thumbWidth, this.thumbHeight)) / ((float) Math.max(intrinsicWidth, intrinsicHeight));
        drawable.setBounds(0, 0, (int) (((float) intrinsicWidth) * max), (int) (((float) intrinsicHeight) * max));
    }

    private void attachLabelToContentView(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
    }

    public static /* synthetic */ void b(BaseSlider baseSlider, ValueAnimator valueAnimator) {
        baseSlider.getClass();
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        for (TooltipDrawable revealFraction : baseSlider.labels) {
            revealFraction.setRevealFraction(floatValue);
        }
        baseSlider.postInvalidateOnAnimation();
    }

    private void calculateBoundsAndDrawTrackIcon(@NonNull Canvas canvas, @NonNull RectF rectF, @Nullable Drawable drawable, boolean z4) {
        if (drawable != null) {
            calculateTrackIconBounds(rectF, this.iconRectF, this.trackIconSize, this.trackIconPadding, z4);
            if (!this.iconRectF.isEmpty()) {
                drawTrackIcon(canvas, this.iconRectF, drawable);
                return;
            }
            return;
        }
    }

    private float calculateEndTrackCornerSize(float f5) {
        int i5;
        if (this.values.isEmpty() || !hasGapBetweenThumbAndTrack()) {
            return f5;
        }
        if (isRtl() || isVertical()) {
            i5 = 0;
        } else {
            i5 = this.values.size() - 1;
        }
        float valueToX = valueToX(this.values.get(i5).floatValue()) - ((float) this.trackSidePadding);
        int i6 = this.trackWidth;
        if (valueToX > ((float) i6) - f5) {
            return Math.max(((float) i6) - valueToX, (float) this.trackInsideCornerSize);
        }
        return f5;
    }

    @Nullable
    private Float calculateIncrementForKey(int i5) {
        float f5;
        if (this.isLongPress) {
            f5 = calculateStepIncrement(20);
        } else {
            f5 = calculateStepIncrement();
        }
        if (i5 == 69) {
            return Float.valueOf(-f5);
        }
        if (i5 == 70 || i5 == 81) {
            return Float.valueOf(f5);
        }
        switch (i5) {
            case 19:
                if (isVertical()) {
                    return Float.valueOf(f5);
                }
                return null;
            case 20:
                if (isVertical()) {
                    return Float.valueOf(-f5);
                }
                return null;
            case 21:
                if (!isRtl()) {
                    f5 = -f5;
                }
                return Float.valueOf(f5);
            case 22:
                if (isRtl()) {
                    f5 = -f5;
                }
                return Float.valueOf(f5);
            default:
                return null;
        }
    }

    private void calculateLabelBounds(TooltipDrawable tooltipDrawable, float f5) {
        int i5;
        int i6;
        int i7;
        int i8;
        int intrinsicHeight;
        if (isVertical()) {
            i8 = (this.trackSidePadding + ((int) (normalizeValue(f5) * ((float) this.trackWidth)))) - (tooltipDrawable.getIntrinsicHeight() / 2);
            i5 = tooltipDrawable.getIntrinsicHeight() + i8;
            if (isRtl()) {
                i7 = calculateTrackCenter() - (this.labelPadding + (this.thumbHeight / 2));
                intrinsicHeight = tooltipDrawable.getIntrinsicWidth();
            } else {
                int calculateTrackCenter = calculateTrackCenter() + this.labelPadding + (this.thumbHeight / 2);
                int i9 = calculateTrackCenter;
                i7 = tooltipDrawable.getIntrinsicWidth() + calculateTrackCenter;
                i6 = i9;
                this.labelRect.set(i8, i6, i5, i7);
            }
        } else {
            i8 = (this.trackSidePadding + ((int) (normalizeValue(f5) * ((float) this.trackWidth)))) - (tooltipDrawable.getIntrinsicWidth() / 2);
            i5 = tooltipDrawable.getIntrinsicWidth() + i8;
            i7 = calculateTrackCenter() - (this.labelPadding + (this.thumbHeight / 2));
            intrinsicHeight = tooltipDrawable.getIntrinsicHeight();
        }
        i6 = i7 - intrinsicHeight;
        this.labelRect.set(i8, i6, i5, i7);
    }

    private float calculateStartTrackCornerSize(float f5) {
        int i5;
        if (this.values.isEmpty() || !hasGapBetweenThumbAndTrack()) {
            return f5;
        }
        if (isRtl() || isVertical()) {
            i5 = this.values.size() - 1;
        } else {
            i5 = 0;
        }
        float valueToX = valueToX(this.values.get(i5).floatValue()) - ((float) this.trackSidePadding);
        if (valueToX < f5) {
            return Math.max(valueToX, (float) this.trackInsideCornerSize);
        }
        return f5;
    }

    private float calculateStepIncrement() {
        float f5 = this.stepSize;
        if (f5 == 0.0f) {
            return 1.0f;
        }
        return f5;
    }

    private int calculateTrackCenter() {
        int i5 = this.widgetThickness / 2;
        int i6 = 0;
        if (this.labelBehavior == 1 || shouldAlwaysShowLabel()) {
            i6 = this.labels.get(0).getIntrinsicHeight();
        }
        return i5 + i6;
    }

    private void calculateTrackIconBounds(@NonNull RectF rectF, @NonNull RectF rectF2, @Px int i5, @Px int i6, boolean z4) {
        boolean z5;
        float f5;
        if (rectF.right - rectF.left >= ((float) ((i6 * 2) + i5))) {
            if (isRtl() || isVertical()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z4 ^ z5) {
                f5 = rectF.left + ((float) i6);
            } else {
                f5 = (rectF.right - ((float) i6)) - ((float) i5);
            }
            float f6 = (float) i5;
            float calculateTrackCenter = ((float) calculateTrackCenter()) - (f6 / 2.0f);
            rectF2.set(f5, calculateTrackCenter, f5 + f6, f6 + calculateTrackCenter);
            return;
        }
        rectF2.setEmpty();
    }

    private int convertToTickVisibilityMode(boolean z4) {
        return z4 ? 0 : 2;
    }

    private ValueAnimator createLabelAnimator(boolean z4) {
        float f5;
        ValueAnimator valueAnimator;
        int i5;
        TimeInterpolator timeInterpolator;
        float f6 = 1.0f;
        if (z4) {
            f5 = 0.0f;
        } else {
            f5 = 1.0f;
        }
        if (z4) {
            valueAnimator = this.labelsOutAnimator;
        } else {
            valueAnimator = this.labelsInAnimator;
        }
        float animatorCurrentValueOrDefault = getAnimatorCurrentValueOrDefault(valueAnimator, f5);
        if (!z4) {
            f6 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{animatorCurrentValueOrDefault, f6});
        if (z4) {
            i5 = MotionUtils.resolveThemeDuration(getContext(), LABEL_ANIMATION_ENTER_DURATION_ATTR, 83);
            timeInterpolator = MotionUtils.resolveThemeInterpolator(getContext(), LABEL_ANIMATION_ENTER_EASING_ATTR, AnimationUtils.DECELERATE_INTERPOLATOR);
        } else {
            i5 = MotionUtils.resolveThemeDuration(getContext(), LABEL_ANIMATION_EXIT_DURATION_ATTR, 117);
            timeInterpolator = MotionUtils.resolveThemeInterpolator(getContext(), LABEL_ANIMATION_EXIT_EASING_ATTR, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        }
        ofFloat.setDuration((long) i5);
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.addUpdateListener(new b(this));
        return ofFloat;
    }

    private void createLabelPool() {
        int i5;
        if (this.labels.size() > this.values.size()) {
            List<TooltipDrawable> subList = this.labels.subList(this.values.size(), this.labels.size());
            for (TooltipDrawable next : subList) {
                if (isAttachedToWindow()) {
                    detachLabelFromContentView(next);
                }
            }
            subList.clear();
        }
        while (true) {
            i5 = 0;
            if (this.labels.size() >= this.values.size()) {
                break;
            }
            TooltipDrawable createFromAttributes = TooltipDrawable.createFromAttributes(getContext(), (AttributeSet) null, 0, this.labelStyle);
            this.labels.add(createFromAttributes);
            if (isAttachedToWindow()) {
                attachLabelToContentView(createFromAttributes);
            }
        }
        if (this.labels.size() != 1) {
            i5 = 1;
        }
        for (TooltipDrawable strokeWidth : this.labels) {
            strokeWidth.setStrokeWidth((float) i5);
        }
    }

    private void detachLabelFromContentView(TooltipDrawable tooltipDrawable) {
        ViewGroup contentView = ViewUtils.getContentView(this);
        if (contentView != null) {
            contentView.getOverlay().remove(tooltipDrawable);
            tooltipDrawable.detachView(contentView);
        }
    }

    private float dimenToValue(float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        float f6 = (f5 - ((float) this.trackSidePadding)) / ((float) this.trackWidth);
        float f7 = this.valueFrom;
        return (f6 * (f7 - this.valueTo)) + f7;
    }

    private void dispatchOnChangedFromUser(int i5) {
        for (L onValueChange : this.changeListeners) {
            onValueChange.onValueChange(this, this.values.get(i5).floatValue(), true);
        }
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null && accessibilityManager2.isEnabled()) {
            scheduleAccessibilityEventSender(i5);
        }
    }

    private void dispatchOnChangedProgrammatically() {
        for (L l5 : this.changeListeners) {
            ArrayList<Float> arrayList = this.values;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Float f5 = arrayList.get(i5);
                i5++;
                l5.onValueChange(this, f5.floatValue(), false);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawActiveTracks(@androidx.annotation.NonNull android.graphics.Canvas r17, int r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            float[] r6 = r0.getActiveRange()
            int r1 = r0.trackSidePadding
            float r2 = (float) r1
            r7 = 1
            r3 = r6[r7]
            r4 = r18
            float r4 = (float) r4
            float r3 = r3 * r4
            float r2 = r2 + r3
            float r1 = (float) r1
            r8 = 0
            r3 = r6[r8]
            float r3 = r3 * r4
            float r1 = r1 + r3
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x0021
            android.graphics.RectF r1 = r0.activeTrackRect
            r1.setEmpty()
            return
        L_0x0021:
            com.google.android.material.slider.BaseSlider$FullCornerDirection r3 = com.google.android.material.slider.BaseSlider.FullCornerDirection.NONE
            java.util.ArrayList<java.lang.Float> r4 = r0.values
            int r4 = r4.size()
            if (r4 != r7) goto L_0x0043
            boolean r4 = r0.isCentered()
            if (r4 != 0) goto L_0x0043
            boolean r3 = r0.isRtl()
            if (r3 != 0) goto L_0x0041
            boolean r3 = r0.isVertical()
            if (r3 == 0) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            com.google.android.material.slider.BaseSlider$FullCornerDirection r3 = com.google.android.material.slider.BaseSlider.FullCornerDirection.LEFT
            goto L_0x0043
        L_0x0041:
            com.google.android.material.slider.BaseSlider$FullCornerDirection r3 = com.google.android.material.slider.BaseSlider.FullCornerDirection.RIGHT
        L_0x0043:
            r5 = r3
            r9 = r8
        L_0x0045:
            java.util.ArrayList<java.lang.Float> r3 = r0.values
            int r3 = r3.size()
            if (r9 >= r3) goto L_0x00fc
            java.util.ArrayList<java.lang.Float> r3 = r0.values
            int r3 = r3.size()
            if (r3 <= r7) goto L_0x0088
            if (r9 <= 0) goto L_0x0069
            java.util.ArrayList<java.lang.Float> r1 = r0.values
            int r2 = r9 + -1
            java.lang.Object r1 = r1.get(r2)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            float r1 = r0.valueToX(r1)
        L_0x0069:
            java.util.ArrayList<java.lang.Float> r2 = r0.values
            java.lang.Object r2 = r2.get(r9)
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            float r2 = r0.valueToX(r2)
            boolean r3 = r0.isRtl()
            if (r3 != 0) goto L_0x0085
            boolean r3 = r0.isVertical()
            if (r3 == 0) goto L_0x0088
        L_0x0085:
            r15 = r2
            r2 = r1
            r1 = r15
        L_0x0088:
            int r3 = r0.getTrackCornerSize()
            int r4 = r5.ordinal()
            if (r4 == r7) goto L_0x00c5
            r10 = 2
            if (r4 == r10) goto L_0x00be
            r10 = 3
            if (r4 == r10) goto L_0x0099
            goto L_0x00a5
        L_0x0099:
            boolean r4 = r0.isCentered()
            if (r4 != 0) goto L_0x00a8
            int r4 = r0.thumbTrackGapSize
            float r10 = (float) r4
            float r1 = r1 + r10
        L_0x00a3:
            float r4 = (float) r4
            float r2 = r2 - r4
        L_0x00a5:
            r10 = r1
            r11 = r2
            goto L_0x00ca
        L_0x00a8:
            r4 = r6[r7]
            r10 = 1056964608(0x3f000000, float:0.5)
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 != 0) goto L_0x00b5
            int r4 = r0.thumbTrackGapSize
            float r4 = (float) r4
            float r1 = r1 + r4
            goto L_0x00a5
        L_0x00b5:
            r4 = r6[r8]
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 != 0) goto L_0x00a5
            int r4 = r0.thumbTrackGapSize
            goto L_0x00a3
        L_0x00be:
            int r4 = r0.thumbTrackGapSize
            float r4 = (float) r4
            float r1 = r1 + r4
            float r4 = (float) r3
            float r2 = r2 + r4
            goto L_0x00a5
        L_0x00c5:
            float r4 = (float) r3
            float r1 = r1 - r4
            int r4 = r0.thumbTrackGapSize
            goto L_0x00a3
        L_0x00ca:
            int r1 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r1 < 0) goto L_0x00d6
            android.graphics.RectF r1 = r0.activeTrackRect
            r1.setEmpty()
            r12 = r19
            goto L_0x00f4
        L_0x00d6:
            android.graphics.RectF r1 = r0.activeTrackRect
            r12 = r19
            float r2 = (float) r12
            int r4 = r0.trackThickness
            float r13 = (float) r4
            r14 = 1073741824(0x40000000, float:2.0)
            float r13 = r13 / r14
            float r13 = r2 - r13
            float r4 = (float) r4
            float r4 = r4 / r14
            float r2 = r2 + r4
            r1.set(r10, r13, r11, r2)
            android.graphics.Paint r2 = r0.activeTrackPaint
            android.graphics.RectF r1 = r0.activeTrackRect
            float r4 = (float) r3
            r3 = r1
            r1 = r17
            r0.updateTrack(r1, r2, r3, r4, r5)
        L_0x00f4:
            int r9 = r9 + 1
            r0 = r16
            r1 = r10
            r2 = r11
            goto L_0x0045
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.drawActiveTracks(android.graphics.Canvas, int, int):void");
    }

    private void drawInactiveTrackSection(float f5, float f6, float f7, float f8, @NonNull Canvas canvas, RectF rectF, FullCornerDirection fullCornerDirection) {
        if (f6 - f5 > ((float) (getTrackCornerSize() - this.thumbTrackGapSize))) {
            rectF.set(f5, f7, f6, f8);
        } else {
            rectF.setEmpty();
        }
        updateTrack(canvas, this.inactiveTrackPaint, rectF, (float) getTrackCornerSize(), fullCornerDirection);
    }

    private void drawInactiveTracks(@NonNull Canvas canvas, int i5, int i6) {
        float[] activeRange = getActiveRange();
        float f5 = (float) i6;
        int i7 = this.trackThickness;
        float f6 = f5 - (((float) i7) / 2.0f);
        float f7 = f5 + (((float) i7) / 2.0f);
        float f8 = (float) i5;
        Canvas canvas2 = canvas;
        drawInactiveTrackSection((float) (this.trackSidePadding - getTrackCornerSize()), (((float) this.trackSidePadding) + (activeRange[0] * f8)) - ((float) this.thumbTrackGapSize), f6, f7, canvas2, this.inactiveTrackLeftRect, FullCornerDirection.LEFT);
        int i8 = this.trackSidePadding;
        drawInactiveTrackSection(((float) i8) + (activeRange[1] * f8) + ((float) this.thumbTrackGapSize), (float) (i8 + i5 + getTrackCornerSize()), f6, f7, canvas2, this.inactiveTrackRightRect, FullCornerDirection.RIGHT);
    }

    private void drawStopIndicator(@NonNull Canvas canvas, float f5, float f6) {
        ArrayList<Float> arrayList = this.values;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Float f7 = arrayList.get(i5);
            i5++;
            float valueToX = valueToX(f7.floatValue());
            float f8 = ((float) this.thumbTrackGapSize) + (((float) this.thumbWidth) / 2.0f);
            if (f5 >= valueToX - f8 && f5 <= valueToX + f8) {
                return;
            }
        }
        if (isVertical()) {
            canvas.drawPoint(f6, f5, this.stopIndicatorPaint);
        } else {
            canvas.drawPoint(f5, f6, this.stopIndicatorPaint);
        }
    }

    private void drawThumbDrawable(@NonNull Canvas canvas, int i5, int i6, float f5, @NonNull Drawable drawable) {
        canvas.save();
        if (isVertical()) {
            canvas.concat(this.rotationMatrix);
        }
        canvas.translate(((float) (this.trackSidePadding + ((int) (normalizeValue(f5) * ((float) i5))))) - (((float) drawable.getBounds().width()) / 2.0f), ((float) i6) - (((float) drawable.getBounds().height()) / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    private void drawThumbs(@NonNull Canvas canvas, int i5, int i6) {
        int i7;
        int i8;
        Canvas canvas2;
        int i9 = 0;
        while (i9 < this.values.size()) {
            float floatValue = this.values.get(i9).floatValue();
            Drawable drawable = this.customThumbDrawable;
            if (drawable != null) {
                canvas2 = canvas;
                i8 = i5;
                i7 = i6;
                drawThumbDrawable(canvas2, i8, i7, floatValue, drawable);
            } else {
                canvas2 = canvas;
                i8 = i5;
                i7 = i6;
                if (i9 < this.customThumbDrawablesForValues.size()) {
                    drawThumbDrawable(canvas2, i8, i7, floatValue, this.customThumbDrawablesForValues.get(i9));
                } else {
                    if (!isEnabled()) {
                        canvas2.drawCircle(((float) this.trackSidePadding) + (normalizeValue(floatValue) * ((float) i8)), (float) i7, (float) getThumbRadius(), this.thumbPaint);
                    }
                    drawThumbDrawable(canvas2, i8, i7, floatValue, this.defaultThumbDrawable);
                }
            }
            i9++;
            canvas = canvas2;
            i5 = i8;
            i6 = i7;
        }
    }

    private void drawTicks(int i5, int i6, Canvas canvas, Paint paint) {
        float f5;
        while (i5 < i6) {
            if (isVertical()) {
                f5 = this.ticksCoordinates[i5 + 1];
            } else {
                f5 = this.ticksCoordinates[i5];
            }
            if (!isOverlappingThumb(f5) && (!isCentered() || !isOverlappingCenterGap(f5))) {
                float[] fArr = this.ticksCoordinates;
                canvas.drawPoint(fArr[i5], fArr[i5 + 1], paint);
            }
            i5 += 2;
        }
    }

    private void drawTrackIcon(@NonNull Canvas canvas, @NonNull RectF rectF, @NonNull Drawable drawable) {
        if (isVertical()) {
            this.rotationMatrix.mapRect(rectF);
        }
        rectF.round(this.iconRect);
        drawable.setBounds(this.iconRect);
        drawable.draw(canvas);
    }

    private void drawTrackIcons(@NonNull Canvas canvas, @NonNull RectF rectF, @NonNull RectF rectF2) {
        if (hasTrackIcons()) {
            if (this.values.size() > 1) {
                Log.w(TAG, "Track icons can only be used when only 1 thumb is present.");
            }
            calculateBoundsAndDrawTrackIcon(canvas, rectF, this.trackIconActiveStart, true);
            calculateBoundsAndDrawTrackIcon(canvas, rectF2, this.trackIconInactiveStart, true);
            calculateBoundsAndDrawTrackIcon(canvas, rectF, this.trackIconActiveEnd, false);
            calculateBoundsAndDrawTrackIcon(canvas, rectF2, this.trackIconInactiveEnd, false);
        }
    }

    private void ensureLabelsAdded() {
        if (!this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = true;
            ValueAnimator createLabelAnimator = createLabelAnimator(true);
            this.labelsInAnimator = createLabelAnimator;
            this.labelsOutAnimator = null;
            createLabelAnimator.start();
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        for (int i5 = 0; i5 < this.values.size() && it.hasNext(); i5++) {
            if (i5 != this.focusedThumbIdx) {
                setValueForLabel(it.next(), this.values.get(i5).floatValue());
            }
        }
        if (it.hasNext()) {
            setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())}));
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            ValueAnimator createLabelAnimator = createLabelAnimator(false);
            this.labelsOutAnimator = createLabelAnimator;
            this.labelsInAnimator = null;
            createLabelAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ViewOverlay access$000 = BaseSlider.this.getContentViewOverlay();
                    if (access$000 != null) {
                        for (TooltipDrawable remove : BaseSlider.this.labels) {
                            access$000.remove(remove);
                        }
                    }
                }
            });
            this.labelsOutAnimator.start();
        }
    }

    private void focusThumbOnFocusGained(int i5) {
        if (i5 == 1) {
            moveFocus(Integer.MAX_VALUE);
        } else if (i5 == 2) {
            moveFocus(Integer.MIN_VALUE);
        } else if (i5 == 17) {
            moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        } else if (i5 == 66) {
            moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        }
    }

    /* access modifiers changed from: private */
    public String formatValue(float f5) {
        String str;
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(f5);
        }
        if (((float) ((int) f5)) == f5) {
            str = "%.0f";
        } else {
            str = "%.2f";
        }
        return String.format(str, new Object[]{Float.valueOf(f5)});
    }

    private float[] getActiveRange() {
        float floatValue = this.values.get(0).floatValue();
        ArrayList<Float> arrayList = this.values;
        float floatValue2 = arrayList.get(arrayList.size() - 1).floatValue();
        if (this.values.size() == 1) {
            floatValue = this.valueFrom;
        }
        float normalizeValue = normalizeValue(floatValue);
        float normalizeValue2 = normalizeValue(floatValue2);
        if (isCentered()) {
            float min = Math.min(0.5f, normalizeValue2);
            normalizeValue2 = Math.max(0.5f, normalizeValue2);
            normalizeValue = min;
        }
        if (isCentered() || (!isRtl() && !isVertical())) {
            return new float[]{normalizeValue, normalizeValue2};
        }
        return new float[]{normalizeValue2, normalizeValue};
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator valueAnimator, float f5) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f5;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private float getClampedValue(int i5, float f5) {
        float f6;
        float f7;
        float minSeparation = getMinSeparation();
        if (this.separationUnit == 0) {
            minSeparation = dimenToValue(minSeparation);
        }
        if (isRtl() || isVertical()) {
            minSeparation = -minSeparation;
        }
        int i6 = i5 + 1;
        if (i6 >= this.values.size()) {
            f6 = this.valueTo;
        } else {
            f6 = this.values.get(i6).floatValue() - minSeparation;
        }
        int i7 = i5 - 1;
        if (i7 < 0) {
            f7 = this.valueFrom;
        } else {
            f7 = this.values.get(i7).floatValue() + minSeparation;
        }
        return MathUtils.clamp(f5, f7, f6);
    }

    @ColorInt
    private int getColorForState(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    /* access modifiers changed from: private */
    @Nullable
    public ViewOverlay getContentViewOverlay() {
        ViewGroup contentView = ViewUtils.getContentView(this);
        if (contentView == null) {
            return null;
        }
        return contentView.getOverlay();
    }

    private float[] getCornerRadii(float f5, float f6) {
        if (isVertical()) {
            return new float[]{f5, f5, f5, f5, f6, f6, f6, f6};
        }
        return new float[]{f5, f5, f6, f6, f6, f6, f5, f5};
    }

    private int getDesiredTickCount() {
        return (int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f);
    }

    private int getMaxTickCount() {
        return (this.trackWidth / this.minTickSpacing) + 1;
    }

    private float getValueOfTouchPosition() {
        double snapPosition = snapPosition(this.touchPosition);
        if (isRtl() || isVertical()) {
            snapPosition = 1.0d - snapPosition;
        }
        float f5 = this.valueTo;
        float f6 = this.valueFrom;
        return (float) ((snapPosition * ((double) (f5 - f6))) + ((double) f6));
    }

    private float getValueOfTouchPositionAbsolute() {
        float f5 = this.touchPosition;
        if (isRtl() || isVertical()) {
            f5 = 1.0f - f5;
        }
        float f6 = this.valueTo;
        float f7 = this.valueFrom;
        return (f5 * (f6 - f7)) + f7;
    }

    private boolean hasGapBetweenThumbAndTrack() {
        if (this.thumbTrackGapSize > 0) {
            return true;
        }
        return false;
    }

    private boolean hasTrackIcons() {
        if (this.trackIconActiveStart == null && this.trackIconActiveEnd == null && this.trackIconInactiveStart == null && this.trackIconInactiveEnd == null) {
            return false;
        }
        return true;
    }

    private Drawable initializeCustomThumbDrawable(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        adjustCustomThumbDrawableBounds(newDrawable);
        return newDrawable;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth((float) this.trackThickness);
        this.activeTrackPaint.setStrokeWidth((float) this.trackThickness);
    }

    private boolean isInHorizontalScrollingContainer() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollHorizontally(1) || viewGroup.canScrollHorizontally(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private boolean isInVerticalScrollingContainer() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMouseEvent(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) == 3) {
            return true;
        }
        return false;
    }

    private boolean isMultipleOfStepSize(double d5) {
        double doubleValue = new BigDecimal(Double.toString(d5)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(((double) Math.round(doubleValue)) - doubleValue) < THRESHOLD) {
            return true;
        }
        return false;
    }

    private boolean isOverlappingCenterGap(float f5) {
        float f6 = ((float) this.thumbTrackGapSize) + (((float) this.thumbWidth) / 2.0f);
        float f7 = ((float) (this.trackWidth + (this.trackSidePadding * 2))) / 2.0f;
        if (f5 < f7 - f6 || f5 > f7 + f6) {
            return false;
        }
        return true;
    }

    private boolean isOverlappingThumb(float f5) {
        float f6 = ((float) this.thumbTrackGapSize) + (((float) this.thumbWidth) / 2.0f);
        Iterator<Float> it = this.values.iterator();
        if (it.hasNext()) {
            float valueToX = valueToX(it.next().floatValue());
            if (f5 < valueToX - f6 || f5 > valueToX + f6) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean isPotentialHorizontalScroll(MotionEvent motionEvent) {
        if (isMouseEvent(motionEvent) || !isInHorizontalScrollingContainer()) {
            return false;
        }
        return true;
    }

    private boolean isPotentialVerticalScroll(MotionEvent motionEvent) {
        if (isMouseEvent(motionEvent) || !isInVerticalScrollingContainer()) {
            return false;
        }
        return true;
    }

    private boolean isSliderVisibleOnScreen() {
        Rect rect = new Rect();
        ViewUtils.getContentView(this).getHitRect(rect);
        if (!getLocalVisibleRect(rect) || !isThisAndAncestorsVisible()) {
            return false;
        }
        return true;
    }

    private boolean isThisAndAncestorsVisible() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.thisAndAncestorsVisible;
        }
        return isShown();
    }

    private void loadResources(@NonNull Resources resources) {
        this.minWidgetThickness = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = dimensionPixelOffset;
        this.trackSidePadding = dimensionPixelOffset;
        this.defaultThumbRadius = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.defaultTrackThickness = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        int i5 = R.dimen.mtrl_slider_tick_radius;
        this.defaultTickActiveRadius = resources.getDimensionPixelSize(i5);
        this.defaultTickInactiveRadius = resources.getDimensionPixelSize(i5);
        this.minTickSpacing = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_min_spacing);
        this.labelPadding = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        this.trackIconPadding = resources.getDimensionPixelOffset(R.dimen.m3_slider_track_icon_padding);
    }

    private void maybeDrawCompatHalo(@NonNull Canvas canvas, int i5, int i6) {
        Canvas canvas2;
        if (shouldDrawCompatHalo()) {
            float[] fArr = {((float) this.trackSidePadding) + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) i5)), (float) i6};
            if (isVertical()) {
                this.rotationMatrix.mapPoints(fArr);
            }
            if (Build.VERSION.SDK_INT < 28) {
                float f5 = fArr[0];
                int i7 = this.haloRadius;
                float f6 = fArr[1];
                canvas2 = canvas;
                canvas2.clipRect(f5 - ((float) i7), f6 - ((float) i7), f5 + ((float) i7), f6 + ((float) i7), Region.Op.UNION);
            } else {
                canvas2 = canvas;
            }
            canvas2.drawCircle(fArr[0], fArr[1], (float) this.haloRadius, this.haloPaint);
        }
    }

    private void maybeDrawStopIndicator(@NonNull Canvas canvas, int i5) {
        if (this.trackStopIndicatorSize > 0 && !this.values.isEmpty()) {
            ArrayList<Float> arrayList = this.values;
            float floatValue = arrayList.get(arrayList.size() - 1).floatValue();
            float f5 = this.valueTo;
            if (floatValue < f5) {
                drawStopIndicator(canvas, valueToX(f5), (float) i5);
            }
            if (isCentered() || (this.values.size() > 1 && this.values.get(0).floatValue() > this.valueFrom)) {
                drawStopIndicator(canvas, valueToX(this.valueFrom), (float) i5);
            }
        }
    }

    private void maybeDrawTicks(@NonNull Canvas canvas) {
        float[] fArr = this.ticksCoordinates;
        if (fArr != null && fArr.length != 0) {
            float[] activeRange = getActiveRange();
            int ceil = (int) Math.ceil((double) (activeRange[0] * ((((float) this.ticksCoordinates.length) / 2.0f) - 1.0f)));
            int floor = (int) Math.floor((double) (activeRange[1] * ((((float) this.ticksCoordinates.length) / 2.0f) - 1.0f)));
            if (ceil > 0) {
                drawTicks(0, ceil * 2, canvas, this.inactiveTicksPaint);
            }
            if (ceil <= floor) {
                drawTicks(ceil * 2, (floor + 1) * 2, canvas, this.activeTicksPaint);
            }
            int i5 = (floor + 1) * 2;
            float[] fArr2 = this.ticksCoordinates;
            if (i5 < fArr2.length) {
                drawTicks(i5, fArr2.length, canvas, this.inactiveTicksPaint);
            }
        }
    }

    private boolean maybeIncreaseTrackSidePadding() {
        int i5;
        int max = this.minTrackSidePadding + Math.max(Math.max(Math.max((this.thumbWidth / 2) - this.defaultThumbRadius, 0), Math.max((this.trackThickness - this.defaultTrackThickness) / 2, 0)), Math.max(Math.max(this.tickActiveRadius - this.defaultTickActiveRadius, 0), Math.max(this.tickInactiveRadius - this.defaultTickInactiveRadius, 0)));
        if (this.trackSidePadding == max) {
            return false;
        }
        this.trackSidePadding = max;
        if (!isLaidOut()) {
            return true;
        }
        if (isVertical()) {
            i5 = getHeight();
        } else {
            i5 = getWidth();
        }
        updateTrackWidth(i5);
        return true;
    }

    private boolean maybeIncreaseWidgetThickness() {
        int paddingTop;
        int paddingBottom;
        if (isVertical()) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i5 = paddingTop + paddingBottom;
        int max = Math.max(this.minWidgetThickness, Math.max(this.trackThickness + i5, this.thumbHeight + i5));
        if (max == this.widgetThickness) {
            return false;
        }
        this.widgetThickness = max;
        return true;
    }

    private boolean moveFocus(int i5) {
        int i6 = this.focusedThumbIdx;
        int clamp = (int) MathUtils.clamp(((long) i6) + ((long) i5), 0, (long) (this.values.size() - 1));
        this.focusedThumbIdx = clamp;
        if (clamp == i6) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = clamp;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int i5) {
        if (isRtl() || isVertical()) {
            if (i5 == Integer.MIN_VALUE) {
                i5 = Integer.MAX_VALUE;
            } else {
                i5 = -i5;
            }
        }
        return moveFocus(i5);
    }

    private float normalizeValue(float f5) {
        float f6 = this.valueFrom;
        float f7 = (f5 - f6) / (this.valueTo - f6);
        if (isRtl() || isVertical()) {
            return 1.0f - f7;
        }
        return f7;
    }

    @Nullable
    private Boolean onKeyDownNoActiveThumb(int i5, @NonNull KeyEvent keyEvent) {
        if (i5 != 61) {
            if (i5 != 66) {
                if (i5 != 81) {
                    if (i5 == 69) {
                        moveFocus(-1);
                        return Boolean.TRUE;
                    } else if (i5 != 70) {
                        switch (i5) {
                            case 21:
                                moveFocusInAbsoluteDirection(-1);
                                return Boolean.TRUE;
                            case 22:
                                moveFocusInAbsoluteDirection(1);
                                return Boolean.TRUE;
                            case 23:
                                break;
                            default:
                                return null;
                        }
                    }
                }
                moveFocus(1);
                return Boolean.TRUE;
            }
            this.activeThumbIdx = this.focusedThumbIdx;
            postInvalidate();
            return Boolean.TRUE;
        } else if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(moveFocus(1));
        } else {
            if (keyEvent.isShiftPressed()) {
                return Boolean.valueOf(moveFocus(-1));
            }
            return Boolean.FALSE;
        }
    }

    private void onStartTrackingTouch() {
        for (T onStartTrackingTouch : this.touchListeners) {
            onStartTrackingTouch.onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        for (T onStopTrackingTouch : this.touchListeners) {
            onStopTrackingTouch.onStopTrackingTouch(this);
        }
    }

    private void positionLabel(TooltipDrawable tooltipDrawable, float f5) {
        calculateLabelBounds(tooltipDrawable, f5);
        if (isVertical()) {
            RectF rectF = new RectF(this.labelRect);
            this.rotationMatrix.mapRect(rectF);
            rectF.round(this.labelRect);
        }
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, this.labelRect);
        tooltipDrawable.setBounds(this.labelRect);
    }

    private void processAttributes(Context context, AttributeSet attributeSet, int i5) {
        int i6;
        int i7;
        int i8;
        Context context2 = context;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.Slider, i5, DEF_STYLE_RES, new int[0]);
        setOrientation(obtainStyledAttributes.getInt(R.styleable.Slider_android_orientation, 0));
        this.labelStyle = obtainStyledAttributes.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip);
        this.valueFrom = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        setCentered(obtainStyledAttributes.getBoolean(R.styleable.Slider_centered, false));
        this.stepSize = obtainStyledAttributes.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        this.minTouchTargetSize = (int) Math.ceil((double) obtainStyledAttributes.getDimension(R.styleable.Slider_minTouchTargetSize, (float) MaterialAttributes.resolveMinimumAccessibleTouchTarget(context2)));
        int i9 = R.styleable.Slider_trackColor;
        boolean hasValue = obtainStyledAttributes.hasValue(i9);
        if (hasValue) {
            i6 = i9;
        } else {
            i6 = R.styleable.Slider_trackColorInactive;
        }
        if (!hasValue) {
            i9 = R.styleable.Slider_trackColorActive;
        }
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, obtainStyledAttributes, i6);
        if (colorStateList == null) {
            colorStateList = AppCompatResources.getColorStateList(context2, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateList);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context2, obtainStyledAttributes, i9);
        if (colorStateList2 == null) {
            colorStateList2 = AppCompatResources.getColorStateList(context2, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateList2);
        this.defaultThumbDrawable.setFillColor(MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.Slider_thumbColor));
        int i10 = R.styleable.Slider_thumbStrokeColor;
        if (obtainStyledAttributes.hasValue(i10)) {
            setThumbStrokeColor(MaterialResources.getColorStateList(context2, obtainStyledAttributes, i10));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.Slider_haloColor);
        if (colorStateList3 == null) {
            colorStateList3 = AppCompatResources.getColorStateList(context2, R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateList3);
        int i11 = R.styleable.Slider_tickVisibilityMode;
        if (obtainStyledAttributes.hasValue(i11)) {
            i7 = obtainStyledAttributes.getInt(i11, -1);
        } else {
            i7 = convertToTickVisibilityMode(obtainStyledAttributes.getBoolean(R.styleable.Slider_tickVisible, true));
        }
        this.tickVisibilityMode = i7;
        int i12 = R.styleable.Slider_tickColor;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i12);
        if (hasValue2) {
            i8 = i12;
        } else {
            i8 = R.styleable.Slider_tickColorInactive;
        }
        if (!hasValue2) {
            i12 = R.styleable.Slider_tickColorActive;
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context2, obtainStyledAttributes, i8);
        if (colorStateList4 == null) {
            colorStateList4 = AppCompatResources.getColorStateList(context2, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateList4);
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context2, obtainStyledAttributes, i12);
        if (colorStateList5 == null) {
            colorStateList5 = AppCompatResources.getColorStateList(context2, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateList5);
        setThumbTrackGapSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbTrackGapSize, 0));
        setTrackStopIndicatorSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackStopIndicatorSize, 0));
        setTrackCornerSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackCornerSize, -1));
        setTrackInsideCornerSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackInsideCornerSize, 0));
        setTrackIconActiveStart(MaterialResources.getDrawable(context2, obtainStyledAttributes, R.styleable.Slider_trackIconActiveStart));
        setTrackIconActiveEnd(MaterialResources.getDrawable(context2, obtainStyledAttributes, R.styleable.Slider_trackIconActiveEnd));
        setTrackIconActiveColor(MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.Slider_trackIconActiveColor));
        setTrackIconInactiveStart(MaterialResources.getDrawable(context2, obtainStyledAttributes, R.styleable.Slider_trackIconInactiveStart));
        setTrackIconInactiveEnd(MaterialResources.getDrawable(context2, obtainStyledAttributes, R.styleable.Slider_trackIconInactiveEnd));
        setTrackIconInactiveColor(MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.Slider_trackIconInactiveColor));
        setTrackIconSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackIconSize, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0) * 2;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbWidth, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbHeight, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        setTickActiveRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_tickRadiusActive, this.trackStopIndicatorSize / 2));
        setTickInactiveRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_tickRadiusInactive, this.trackStopIndicatorSize / 2));
        setLabelBehavior(obtainStyledAttributes.getInt(R.styleable.Slider_labelBehavior, 0));
        if (!obtainStyledAttributes.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
    }

    private void scheduleAccessibilityEventSender(int i5) {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
        if (accessibilityEventSender2 == null) {
            this.accessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender2);
        }
        this.accessibilityEventSender.setVirtualViewId(i5);
        postDelayed(this.accessibilityEventSender, 200);
    }

    private void setValueForLabel(TooltipDrawable tooltipDrawable, float f5) {
        tooltipDrawable.setText(formatValue(f5));
        positionLabel(tooltipDrawable, f5);
        ViewOverlay contentViewOverlay = getContentViewOverlay();
        if (contentViewOverlay != null) {
            contentViewOverlay.add(tooltipDrawable);
        }
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.values.size() != arrayList.size() || !this.values.equals(arrayList)) {
                this.values = arrayList;
                this.dirtyConfig = true;
                this.focusedThumbIdx = 0;
                updateHaloHotspot();
                createLabelPool();
                dispatchOnChangedProgrammatically();
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private boolean shouldAlwaysShowLabel() {
        if (this.labelBehavior == 3) {
            return true;
        }
        return false;
    }

    private boolean shouldDrawCompatHalo() {
        if (this.forceDrawCompatHalo || !(getBackground() instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    private boolean snapActiveThumbToValue(float f5) {
        return snapThumbToValue(this.activeThumbIdx, f5);
    }

    private double snapPosition(float f5) {
        float f6 = this.stepSize;
        if (f6 <= 0.0f) {
            return (double) f5;
        }
        int i5 = (int) ((this.valueTo - this.valueFrom) / f6);
        return ((double) Math.round(f5 * ((float) i5))) / ((double) i5);
    }

    /* access modifiers changed from: private */
    public boolean snapThumbToValue(int i5, float f5) {
        this.focusedThumbIdx = i5;
        if (((double) Math.abs(f5 - this.values.get(i5).floatValue())) < THRESHOLD) {
            return false;
        }
        this.values.set(i5, Float.valueOf(getClampedValue(i5, f5)));
        dispatchOnChangedFromUser(i5);
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    /* access modifiers changed from: private */
    public void updateHaloHotspot() {
        if (!shouldDrawCompatHalo() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                float normalizeValue = (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) this.trackWidth)) + ((float) this.trackSidePadding);
                int calculateTrackCenter = calculateTrackCenter();
                int i5 = this.haloRadius;
                float[] fArr = {normalizeValue - ((float) i5), (float) (calculateTrackCenter - i5), normalizeValue + ((float) i5), (float) (calculateTrackCenter + i5)};
                if (isVertical()) {
                    this.rotationMatrix.mapPoints(fArr);
                }
                background.setHotspotBounds((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
            }
        }
    }

    private void updateLabelPivots() {
        float f5;
        boolean isVertical = isVertical();
        boolean isRtl = isRtl();
        float f6 = 0.5f;
        if (!isVertical || !isRtl) {
            f5 = 1.2f;
            if (isVertical) {
                f6 = 1.2f;
                f5 = 0.5f;
            }
        } else {
            f5 = 0.5f;
            f6 = -0.2f;
        }
        for (TooltipDrawable pivots : this.labels) {
            pivots.setPivots(f6, f5);
        }
    }

    /* access modifiers changed from: private */
    public void updateLabels() {
        updateLabelPivots();
        int i5 = this.labelBehavior;
        if (i5 == 0 || i5 == 1) {
            if (this.activeThumbIdx == -1 || !isEnabled()) {
                ensureLabelsRemoved();
            } else {
                ensureLabelsAdded();
            }
        } else if (i5 == 2) {
            ensureLabelsRemoved();
        } else if (i5 != 3) {
            throw new IllegalArgumentException("Unexpected labelBehavior: " + this.labelBehavior);
        } else if (!isEnabled() || !isSliderVisibleOnScreen()) {
            ensureLabelsRemoved();
        } else {
            ensureLabelsAdded();
        }
    }

    private void updateRotationMatrix() {
        float calculateTrackCenter = (float) calculateTrackCenter();
        this.rotationMatrix.reset();
        this.rotationMatrix.setRotate(90.0f, calculateTrackCenter, calculateTrackCenter);
    }

    private void updateThumbWidthWhenPressed() {
        if (hasGapBetweenThumbAndTrack()) {
            int i5 = this.thumbWidth;
            this.defaultThumbWidth = i5;
            this.defaultThumbTrackGapSize = this.thumbTrackGapSize;
            int round = Math.round(((float) i5) * 0.5f);
            int i6 = this.thumbWidth - round;
            setThumbWidth(round);
            setThumbTrackGapSize(this.thumbTrackGapSize - (i6 / 2));
        }
    }

    private void updateTicksCoordinates() {
        validateConfigurationIfDirty();
        int i5 = 0;
        if (this.stepSize <= 0.0f) {
            updateTicksCoordinates(0);
            return;
        }
        int i6 = this.tickVisibilityMode;
        if (i6 == 0) {
            i5 = Math.min(getDesiredTickCount(), getMaxTickCount());
        } else if (i6 == 1) {
            int desiredTickCount = getDesiredTickCount();
            if (desiredTickCount <= getMaxTickCount()) {
                i5 = desiredTickCount;
            }
        } else if (i6 != 2) {
            throw new IllegalStateException("Unexpected tickVisibilityMode: " + this.tickVisibilityMode);
        }
        updateTicksCoordinates(i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateTrack(android.graphics.Canvas r7, android.graphics.Paint r8, android.graphics.RectF r9, float r10, com.google.android.material.slider.BaseSlider.FullCornerDirection r11) {
        /*
            r6 = this;
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            float r0 = r6.calculateStartTrackCornerSize(r10)
            float r10 = r6.calculateEndTrackCornerSize(r10)
            int r1 = r11.ordinal()
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x0026
            if (r1 == r2) goto L_0x0022
            r4 = 3
            if (r1 == r4) goto L_0x001d
            goto L_0x0029
        L_0x001d:
            int r10 = r6.trackInsideCornerSize
            float r0 = (float) r10
        L_0x0020:
            float r10 = (float) r10
            goto L_0x0029
        L_0x0022:
            int r0 = r6.trackInsideCornerSize
            float r0 = (float) r0
            goto L_0x0029
        L_0x0026:
            int r10 = r6.trackInsideCornerSize
            goto L_0x0020
        L_0x0029:
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            r8.setStyle(r1)
            android.graphics.Paint$Cap r1 = android.graphics.Paint.Cap.BUTT
            r8.setStrokeCap(r1)
            boolean r1 = r6.hasGapBetweenThumbAndTrack()
            if (r1 == 0) goto L_0x003c
            r8.setAntiAlias(r3)
        L_0x003c:
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>(r9)
            boolean r4 = r6.isVertical()
            if (r4 == 0) goto L_0x004c
            android.graphics.Matrix r4 = r6.rotationMatrix
            r4.mapRect(r1)
        L_0x004c:
            android.graphics.Path r4 = r6.trackPath
            r4.reset()
            float r4 = r9.width()
            float r5 = r0 + r10
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x006c
            android.graphics.Path r9 = r6.trackPath
            float[] r10 = r6.getCornerRadii(r0, r10)
            android.graphics.Path$Direction r11 = android.graphics.Path.Direction.CW
            r9.addRoundRect(r1, r10, r11)
            android.graphics.Path r9 = r6.trackPath
            r7.drawPath(r9, r8)
            return
        L_0x006c:
            float r4 = java.lang.Math.min(r0, r10)
            float r10 = java.lang.Math.max(r0, r10)
            r7.save()
            android.graphics.Path r0 = r6.trackPath
            android.graphics.Path$Direction r5 = android.graphics.Path.Direction.CW
            r0.addRoundRect(r1, r4, r4, r5)
            android.graphics.Path r0 = r6.trackPath
            r7.clipPath(r0)
            int r11 = r11.ordinal()
            r0 = 1073741824(0x40000000, float:2.0)
            if (r11 == r3) goto L_0x00b0
            if (r11 == r2) goto L_0x00a1
            android.graphics.RectF r11 = r6.cornerRect
            float r0 = r9.centerX()
            float r0 = r0 - r10
            float r1 = r9.top
            float r2 = r9.centerX()
            float r2 = r2 + r10
            float r9 = r9.bottom
            r11.set(r0, r1, r2, r9)
            goto L_0x00bd
        L_0x00a1:
            android.graphics.RectF r11 = r6.cornerRect
            float r1 = r9.right
            float r0 = r0 * r10
            float r0 = r1 - r0
            float r2 = r9.top
            float r9 = r9.bottom
            r11.set(r0, r2, r1, r9)
            goto L_0x00bd
        L_0x00b0:
            android.graphics.RectF r11 = r6.cornerRect
            float r1 = r9.left
            float r2 = r9.top
            float r0 = r0 * r10
            float r0 = r0 + r1
            float r9 = r9.bottom
            r11.set(r1, r2, r0, r9)
        L_0x00bd:
            boolean r9 = r6.isVertical()
            if (r9 == 0) goto L_0x00ca
            android.graphics.Matrix r9 = r6.rotationMatrix
            android.graphics.RectF r11 = r6.cornerRect
            r9.mapRect(r11)
        L_0x00ca:
            android.graphics.RectF r9 = r6.cornerRect
            r7.drawRoundRect(r9, r10, r10, r8)
            r7.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.updateTrack(android.graphics.Canvas, android.graphics.Paint, android.graphics.RectF, float, com.google.android.material.slider.BaseSlider$FullCornerDirection):void");
    }

    private void updateTrackIconActiveEnd() {
        Drawable drawable = this.trackIconActiveEnd;
        if (drawable != null) {
            if (!this.trackIconActiveEndMutated && this.trackIconActiveColor != null) {
                this.trackIconActiveEnd = DrawableCompat.wrap(drawable).mutate();
                this.trackIconActiveEndMutated = true;
            }
            if (this.trackIconActiveEndMutated) {
                this.trackIconActiveEnd.setTintList(this.trackIconActiveColor);
            }
        }
    }

    private void updateTrackIconActiveStart() {
        Drawable drawable = this.trackIconActiveStart;
        if (drawable != null) {
            if (!this.trackIconActiveStartMutated && this.trackIconActiveColor != null) {
                this.trackIconActiveStart = DrawableCompat.wrap(drawable).mutate();
                this.trackIconActiveStartMutated = true;
            }
            if (this.trackIconActiveStartMutated) {
                this.trackIconActiveStart.setTintList(this.trackIconActiveColor);
            }
        }
    }

    private void updateTrackIconInactiveEnd() {
        Drawable drawable = this.trackIconInactiveEnd;
        if (drawable != null) {
            if (!this.trackIconInactiveEndMutated && this.trackIconInactiveColor != null) {
                this.trackIconInactiveEnd = DrawableCompat.wrap(drawable).mutate();
                this.trackIconInactiveEndMutated = true;
            }
            if (this.trackIconInactiveEndMutated) {
                this.trackIconInactiveEnd.setTintList(this.trackIconInactiveColor);
            }
        }
    }

    private void updateTrackIconInactiveStart() {
        Drawable drawable = this.trackIconInactiveStart;
        if (drawable != null) {
            if (!this.trackIconInactiveStartMutated && this.trackIconInactiveColor != null) {
                this.trackIconInactiveStart = DrawableCompat.wrap(drawable).mutate();
                this.trackIconInactiveStartMutated = true;
            }
            if (this.trackIconInactiveStartMutated) {
                this.trackIconInactiveStart.setTintList(this.trackIconInactiveColor);
            }
        }
    }

    private void updateTrackWidth(int i5) {
        this.trackWidth = Math.max(i5 - (this.trackSidePadding * 2), 0);
        updateTicksCoordinates();
    }

    private void updateWidgetLayout(boolean z4) {
        boolean maybeIncreaseWidgetThickness = maybeIncreaseWidgetThickness();
        boolean maybeIncreaseTrackSidePadding = maybeIncreaseTrackSidePadding();
        if (isVertical()) {
            updateRotationMatrix();
        }
        if (maybeIncreaseWidgetThickness || z4) {
            requestLayout();
        } else if (maybeIncreaseTrackSidePadding) {
            postInvalidate();
        }
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            validateValues();
            validateStepSize();
            validateMinSeparation();
            warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    private void validateMinSeparation() {
        float minSeparation = getMinSeparation();
        if (minSeparation >= 0.0f) {
            float f5 = this.stepSize;
            if (f5 > 0.0f && minSeparation > 0.0f) {
                if (this.separationUnit != 1) {
                    throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT, new Object[]{Float.valueOf(minSeparation), Float.valueOf(this.stepSize)}));
                } else if (minSeparation < f5 || !isMultipleOfStepSize((double) minSeparation)) {
                    throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE, new Object[]{Float.valueOf(minSeparation), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)}));
                }
            }
        } else {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION, new Object[]{Float.valueOf(minSeparation)}));
        }
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f && !valueLandsOnTick(this.valueTo)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.valueOf(this.stepSize), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
        }
    }

    private void validateValues() {
        if (this.valueFrom < this.valueTo) {
            ArrayList<Float> arrayList = this.values;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Float f5 = arrayList.get(i5);
                i5++;
                Float f6 = f5;
                if (f6.floatValue() < this.valueFrom || f6.floatValue() > this.valueTo) {
                    throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, new Object[]{f6, Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
                } else if (this.stepSize > 0.0f && !valueLandsOnTick(f6.floatValue())) {
                    throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, new Object[]{f6, Float.valueOf(this.valueFrom), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)}));
                }
            }
            return;
        }
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, new Object[]{Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
    }

    private boolean valueLandsOnTick(float f5) {
        return isMultipleOfStepSize(new BigDecimal(Float.toString(f5)).subtract(new BigDecimal(Float.toString(this.valueFrom)), MathContext.DECIMAL64).doubleValue());
    }

    private float valueToX(float f5) {
        return (normalizeValue(f5) * ((float) this.trackWidth)) + ((float) this.trackSidePadding);
    }

    private void warnAboutFloatingPointError() {
        float f5 = this.stepSize;
        if (f5 != 0.0f) {
            if (((float) ((int) f5)) != f5) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"stepSize", Float.valueOf(f5)}));
            }
            float f6 = this.valueFrom;
            if (((float) ((int) f6)) != f6) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"valueFrom", Float.valueOf(f6)}));
            }
            float f7 = this.valueTo;
            if (((float) ((int) f7)) != f7) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"valueTo", Float.valueOf(f7)}));
            }
        }
    }

    public void addOnChangeListener(@NonNull L l5) {
        this.changeListeners.add(l5);
    }

    public void addOnSliderTouchListener(@NonNull T t5) {
        this.touchListeners.add(t5);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        this.stopIndicatorPaint.setColor(getColorForState(this.tickColorInactive));
        for (TooltipDrawable next : this.labels) {
            if (next.isStateful()) {
                next.setState(getDrawableState());
            }
        }
        if (this.defaultThumbDrawable.isStateful()) {
            this.defaultThumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void forceDrawCompatHalo(boolean z4) {
        this.forceDrawCompatHalo = z4;
    }

    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    @Px
    public int getHaloRadius() {
        return this.haloRadius;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    /* access modifiers changed from: protected */
    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.defaultThumbDrawable.getElevation();
    }

    @Px
    public int getThumbHeight() {
        return this.thumbHeight;
    }

    @Px
    public int getThumbRadius() {
        return this.thumbWidth / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.defaultThumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.defaultThumbDrawable.getStrokeWidth();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.defaultThumbDrawable.getFillColor();
    }

    public int getThumbTrackGapSize() {
        return this.thumbTrackGapSize;
    }

    @Px
    public int getThumbWidth() {
        return this.thumbWidth;
    }

    @Px
    public int getTickActiveRadius() {
        return this.tickActiveRadius;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    @Px
    public int getTickInactiveRadius() {
        return this.tickInactiveRadius;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public int getTickVisibilityMode() {
        return this.tickVisibilityMode;
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    @Px
    public int getTrackCornerSize() {
        int i5 = this.trackCornerSize;
        if (i5 == -1) {
            return this.trackThickness / 2;
        }
        return i5;
    }

    @Px
    public int getTrackHeight() {
        return this.trackThickness;
    }

    @Nullable
    public ColorStateList getTrackIconActiveColor() {
        return this.trackIconActiveColor;
    }

    @Nullable
    public Drawable getTrackIconActiveEnd() {
        return this.trackIconActiveEnd;
    }

    @Nullable
    public Drawable getTrackIconActiveStart() {
        return this.trackIconActiveStart;
    }

    @Nullable
    public ColorStateList getTrackIconInactiveColor() {
        return this.trackIconInactiveColor;
    }

    @Nullable
    public Drawable getTrackIconInactiveEnd() {
        return this.trackIconInactiveEnd;
    }

    @Nullable
    public Drawable getTrackIconInactiveStart() {
        return this.trackIconInactiveStart;
    }

    public int getTrackIconSize() {
        return this.trackIconSize;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public int getTrackInsideCornerSize() {
        return this.trackInsideCornerSize;
    }

    @Px
    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public int getTrackStopIndicatorSize() {
        return this.trackStopIndicatorSize;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Px
    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        if (this.formatter != null) {
            return true;
        }
        return false;
    }

    public boolean isCentered() {
        return this.centered;
    }

    /* access modifiers changed from: package-private */
    public final boolean isRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isTickVisible() {
        int i5 = this.tickVisibilityMode;
        if (i5 == 0) {
            return true;
        }
        if (i5 != 1) {
            if (i5 == 2) {
                return false;
            }
            throw new IllegalStateException("Unexpected tickVisibilityMode: " + this.tickVisibilityMode);
        } else if (getDesiredTickCount() <= getMaxTickCount()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isVertical() {
        if (this.widgetOrientation == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.thisAndAncestorsVisible = isShown();
        getViewTreeObserver().addOnScrollChangedListener(this.onScrollChangedListener);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
        for (TooltipDrawable attachLabelToContentView : this.labels) {
            attachLabelToContentView(attachLabelToContentView);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
        if (accessibilityEventSender2 != null) {
            removeCallbacks(accessibilityEventSender2);
        }
        this.labelsAreAnimatedIn = false;
        for (TooltipDrawable detachLabelFromContentView : this.labels) {
            detachLabelFromContentView(detachLabelFromContentView);
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            updateTicksCoordinates();
        }
        super.onDraw(canvas);
        int calculateTrackCenter = calculateTrackCenter();
        drawInactiveTracks(canvas, this.trackWidth, calculateTrackCenter);
        drawActiveTracks(canvas, this.trackWidth, calculateTrackCenter);
        if (isRtl() || isVertical()) {
            drawTrackIcons(canvas, this.activeTrackRect, this.inactiveTrackLeftRect);
        } else {
            drawTrackIcons(canvas, this.activeTrackRect, this.inactiveTrackRightRect);
        }
        maybeDrawTicks(canvas);
        maybeDrawStopIndicator(canvas, calculateTrackCenter);
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawCompatHalo(canvas, this.trackWidth, calculateTrackCenter);
        }
        updateLabels();
        drawThumbs(canvas, this.trackWidth, calculateTrackCenter);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i5, @Nullable Rect rect) {
        super.onFocusChanged(z4, i5, rect);
        if (!z4) {
            this.activeThumbIdx = -1;
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
            return;
        }
        focusThumbOnFocusGained(i5);
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(false);
    }

    public boolean onKeyDown(int i5, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i5, keyEvent);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        if (this.activeThumbIdx == -1) {
            Boolean onKeyDownNoActiveThumb = onKeyDownNoActiveThumb(i5, keyEvent);
            if (onKeyDownNoActiveThumb != null) {
                return onKeyDownNoActiveThumb.booleanValue();
            }
            return super.onKeyDown(i5, keyEvent);
        }
        this.isLongPress |= keyEvent.isLongPress();
        Float calculateIncrementForKey = calculateIncrementForKey(i5);
        if (calculateIncrementForKey != null) {
            if (snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + calculateIncrementForKey.floatValue())) {
                updateHaloHotspot();
                postInvalidate();
            }
            return true;
        }
        if (i5 != 23) {
            if (i5 != 61) {
                if (i5 != 66) {
                    return super.onKeyDown(i5, keyEvent);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return moveFocus(1);
            } else {
                if (keyEvent.isShiftPressed()) {
                    return moveFocus(-1);
                }
                return false;
            }
        }
        this.activeThumbIdx = -1;
        postInvalidate();
        return true;
    }

    public boolean onKeyUp(int i5, @NonNull KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i5, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7 = 0;
        if (this.labelBehavior == 1 || shouldAlwaysShowLabel()) {
            i7 = this.labels.get(0).getIntrinsicHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.widgetThickness + i7, 1073741824);
        if (isVertical()) {
            super.onMeasure(makeMeasureSpec, i6);
        } else {
            super.onMeasure(i5, makeMeasureSpec);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        if (isVertical()) {
            i5 = i6;
        }
        updateTrackWidth(i5);
        updateHaloHotspot();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r3 != 3) goto L_0x015c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.isEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r6.isVertical()
            if (r0 == 0) goto L_0x0013
            float r0 = r7.getY()
            goto L_0x0017
        L_0x0013:
            float r0 = r7.getX()
        L_0x0017:
            boolean r2 = r6.isVertical()
            if (r2 == 0) goto L_0x0022
            float r2 = r7.getX()
            goto L_0x0026
        L_0x0022:
            float r2 = r7.getY()
        L_0x0026:
            int r3 = r6.trackSidePadding
            float r3 = (float) r3
            float r3 = r0 - r3
            int r4 = r6.trackWidth
            float r4 = (float) r4
            float r3 = r3 / r4
            r6.touchPosition = r3
            r4 = 0
            float r3 = java.lang.Math.max(r4, r3)
            r6.touchPosition = r3
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = java.lang.Math.min(r4, r3)
            r6.touchPosition = r3
            int r3 = r7.getActionMasked()
            r4 = 1
            if (r3 == 0) goto L_0x011c
            if (r3 == r4) goto L_0x00b1
            r5 = 2
            if (r3 == r5) goto L_0x0051
            r0 = 3
            if (r3 == r0) goto L_0x00b1
            goto L_0x015c
        L_0x0051:
            boolean r3 = r6.thumbIsPressed
            if (r3 != 0) goto L_0x00a6
            boolean r3 = r6.isVertical()
            if (r3 != 0) goto L_0x0070
            boolean r3 = r6.isPotentialVerticalScroll(r7)
            if (r3 == 0) goto L_0x0070
            float r3 = r6.touchDownAxis1
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            int r3 = r6.scaledTouchSlop
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            return r1
        L_0x0070:
            boolean r0 = r6.isVertical()
            if (r0 == 0) goto L_0x008f
            boolean r0 = r6.isPotentialHorizontalScroll(r7)
            if (r0 == 0) goto L_0x008f
            float r0 = r6.touchDownAxis2
            float r2 = r2 - r0
            float r0 = java.lang.Math.abs(r2)
            int r2 = r6.scaledTouchSlop
            float r2 = (float) r2
            r3 = 1061997773(0x3f4ccccd, float:0.8)
            float r2 = r2 * r3
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x008f
            return r1
        L_0x008f:
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r4)
            boolean r0 = r6.pickActiveThumb()
            if (r0 != 0) goto L_0x009e
            goto L_0x015c
        L_0x009e:
            r6.thumbIsPressed = r4
            r6.updateThumbWidthWhenPressed()
            r6.onStartTrackingTouch()
        L_0x00a6:
            r6.snapTouchPosition()
            r6.updateHaloHotspot()
            r6.invalidate()
            goto L_0x015c
        L_0x00b1:
            r6.thumbIsPressed = r1
            android.view.MotionEvent r0 = r6.lastEvent
            if (r0 == 0) goto L_0x00f2
            int r0 = r0.getActionMasked()
            if (r0 != 0) goto L_0x00f2
            android.view.MotionEvent r0 = r6.lastEvent
            float r0 = r0.getX()
            float r1 = r7.getX()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            int r1 = r6.scaledTouchSlop
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x00f2
            android.view.MotionEvent r0 = r6.lastEvent
            float r0 = r0.getY()
            float r1 = r7.getY()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            int r1 = r6.scaledTouchSlop
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x00f2
            boolean r0 = r6.pickActiveThumb()
            if (r0 == 0) goto L_0x00f2
            r6.onStartTrackingTouch()
        L_0x00f2:
            int r0 = r6.activeThumbIdx
            r1 = -1
            if (r0 == r1) goto L_0x0118
            r6.snapTouchPosition()
            r6.updateHaloHotspot()
            boolean r0 = r6.hasGapBetweenThumbAndTrack()
            if (r0 == 0) goto L_0x0113
            int r0 = r6.defaultThumbWidth
            if (r0 == r1) goto L_0x0113
            int r2 = r6.defaultThumbTrackGapSize
            if (r2 == r1) goto L_0x0113
            r6.setThumbWidth(r0)
            int r0 = r6.defaultThumbTrackGapSize
            r6.setThumbTrackGapSize(r0)
        L_0x0113:
            r6.activeThumbIdx = r1
            r6.onStopTrackingTouch()
        L_0x0118:
            r6.invalidate()
            goto L_0x015c
        L_0x011c:
            r6.touchDownAxis1 = r0
            r6.touchDownAxis2 = r2
            boolean r0 = r6.isVertical()
            if (r0 != 0) goto L_0x012d
            boolean r0 = r6.isPotentialVerticalScroll(r7)
            if (r0 == 0) goto L_0x012d
            goto L_0x015c
        L_0x012d:
            boolean r0 = r6.isVertical()
            if (r0 == 0) goto L_0x013a
            boolean r0 = r6.isPotentialHorizontalScroll(r7)
            if (r0 == 0) goto L_0x013a
            goto L_0x015c
        L_0x013a:
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r4)
            boolean r0 = r6.pickActiveThumb()
            if (r0 != 0) goto L_0x0148
            goto L_0x015c
        L_0x0148:
            r6.requestFocus()
            r6.thumbIsPressed = r4
            r6.updateThumbWidthWhenPressed()
            r6.onStartTrackingTouch()
            r6.snapTouchPosition()
            r6.updateHaloHotspot()
            r6.invalidate()
        L_0x015c:
            boolean r0 = r6.thumbIsPressed
            r6.setPressed(r0)
            android.view.MotionEvent r7 = android.view.MotionEvent.obtain(r7)
            r6.lastEvent = r7
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onVisibilityAggregated(boolean z4) {
        super.onVisibilityAggregated(z4);
        this.thisAndAncestorsVisible = z4;
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i5) {
        ViewOverlay contentViewOverlay;
        super.onVisibilityChanged(view, i5);
        if (i5 != 0 && (contentViewOverlay = getContentViewOverlay()) != null) {
            for (TooltipDrawable remove : this.labels) {
                contentViewOverlay.remove(remove);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean pickActiveThumb() {
        boolean z4;
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float valueToX = valueToX(valueOfTouchPositionAbsolute);
        this.activeThumbIdx = 0;
        float abs = Math.abs(this.values.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i5 = 1; i5 < this.values.size(); i5++) {
            float abs2 = Math.abs(this.values.get(i5).floatValue() - valueOfTouchPositionAbsolute);
            float valueToX2 = valueToX(this.values.get(i5).floatValue());
            if (Float.compare(abs2, abs) > 0) {
                break;
            }
            if (isRtl() || isVertical() ? valueToX2 - valueToX <= 0.0f : valueToX2 - valueToX >= 0.0f) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (Float.compare(abs2, abs) < 0) {
                this.activeThumbIdx = i5;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(valueToX2 - valueToX) < ((float) this.scaledTouchSlop)) {
                    this.activeThumbIdx = -1;
                    return false;
                } else if (z4) {
                    this.activeThumbIdx = i5;
                }
            }
            abs = abs2;
        }
        if (this.activeThumbIdx != -1) {
            return true;
        }
        return false;
    }

    public void removeOnChangeListener(@NonNull L l5) {
        this.changeListeners.remove(l5);
    }

    public void removeOnSliderTouchListener(@NonNull T t5) {
        this.touchListeners.remove(t5);
    }

    public void scheduleTooltipTimeout() {
        removeCallbacks(this.resetActiveThumbIndex);
        postDelayed(this.resetActiveThumbIndex, (long) this.tooltipTimeoutMillis);
    }

    /* access modifiers changed from: protected */
    public void setActiveThumbIndex(int i5) {
        this.activeThumbIdx = i5;
    }

    public void setCentered(boolean z4) {
        if (this.centered != z4) {
            this.centered = z4;
            if (z4) {
                setValues(Float.valueOf((this.valueFrom + this.valueTo) / 2.0f));
            } else {
                setValues(Float.valueOf(this.valueFrom));
            }
            updateWidgetLayout(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawable(@DrawableRes int i5) {
        setCustomThumbDrawable(getResources().getDrawable(i5));
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            drawableArr[i5] = getResources().getDrawable(iArr[i5]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    public void setEnabled(boolean z4) {
        int i5;
        super.setEnabled(z4);
        if (z4) {
            i5 = 0;
        } else {
            i5 = 2;
        }
        setLayerType(i5, (Paint) null);
    }

    public void setFocusedThumbIndex(int i5) {
        if (i5 < 0 || i5 >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = i5;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(i5);
        postInvalidate();
    }

    public void setHaloRadius(@Px @IntRange(from = 0) int i5) {
        if (i5 != this.haloRadius) {
            this.haloRadius = i5;
            Drawable background = getBackground();
            if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
                postInvalidate();
            } else {
                DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
            }
        }
    }

    public void setHaloRadiusResource(@DimenRes int i5) {
        setHaloRadius(getResources().getDimensionPixelSize(i5));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.haloColor)) {
            this.haloColor = colorStateList;
            Drawable background = getBackground();
            if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
                this.haloPaint.setColor(getColorForState(colorStateList));
                this.haloPaint.setAlpha(63);
                invalidate();
                return;
            }
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    public void setLabelBehavior(int i5) {
        if (this.labelBehavior != i5) {
            this.labelBehavior = i5;
            updateWidgetLayout(true);
        }
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    public void setOrientation(int i5) {
        if (this.widgetOrientation != i5) {
            this.widgetOrientation = i5;
            updateWidgetLayout(true);
        }
    }

    /* access modifiers changed from: protected */
    public void setSeparationUnit(int i5) {
        this.separationUnit = i5;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setStepSize(float f5) {
        if (f5 < 0.0f) {
            throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.valueOf(f5), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
        } else if (this.stepSize != f5) {
            this.stepSize = f5;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f5) {
        this.defaultThumbDrawable.setElevation(f5);
    }

    public void setThumbElevationResource(@DimenRes int i5) {
        setThumbElevation(getResources().getDimension(i5));
    }

    public void setThumbHeight(@Px @IntRange(from = 0) int i5) {
        if (i5 != this.thumbHeight) {
            this.thumbHeight = i5;
            this.defaultThumbDrawable.setBounds(0, 0, this.thumbWidth, i5);
            Drawable drawable = this.customThumbDrawable;
            if (drawable != null) {
                adjustCustomThumbDrawableBounds(drawable);
            }
            for (Drawable adjustCustomThumbDrawableBounds : this.customThumbDrawablesForValues) {
                adjustCustomThumbDrawableBounds(adjustCustomThumbDrawableBounds);
            }
            updateWidgetLayout(false);
        }
    }

    public void setThumbHeightResource(@DimenRes int i5) {
        setThumbHeight(getResources().getDimensionPixelSize(i5));
    }

    public void setThumbRadius(@Px @IntRange(from = 0) int i5) {
        int i6 = i5 * 2;
        setThumbWidth(i6);
        setThumbHeight(i6);
    }

    public void setThumbRadiusResource(@DimenRes int i5) {
        setThumbRadius(getResources().getDimensionPixelSize(i5));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.defaultThumbDrawable.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i5) {
        if (i5 != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i5));
        }
    }

    public void setThumbStrokeWidth(float f5) {
        this.defaultThumbDrawable.setStrokeWidth(f5);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i5) {
        if (i5 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i5));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.defaultThumbDrawable.getFillColor())) {
            this.defaultThumbDrawable.setFillColor(colorStateList);
            invalidate();
        }
    }

    public void setThumbTrackGapSize(@Px int i5) {
        if (this.thumbTrackGapSize != i5) {
            this.thumbTrackGapSize = i5;
            invalidate();
        }
    }

    public void setThumbWidth(@Px @IntRange(from = 0) int i5) {
        if (i5 != this.thumbWidth) {
            this.thumbWidth = i5;
            this.defaultThumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, ((float) this.thumbWidth) / 2.0f).build());
            this.defaultThumbDrawable.setBounds(0, 0, this.thumbWidth, this.thumbHeight);
            Drawable drawable = this.customThumbDrawable;
            if (drawable != null) {
                adjustCustomThumbDrawableBounds(drawable);
            }
            for (Drawable adjustCustomThumbDrawableBounds : this.customThumbDrawablesForValues) {
                adjustCustomThumbDrawableBounds(adjustCustomThumbDrawableBounds);
            }
            updateWidgetLayout(false);
        }
    }

    public void setThumbWidthResource(@DimenRes int i5) {
        setThumbWidth(getResources().getDimensionPixelSize(i5));
    }

    public void setTickActiveRadius(@Px @IntRange(from = 0) int i5) {
        if (this.tickActiveRadius != i5) {
            this.tickActiveRadius = i5;
            this.activeTicksPaint.setStrokeWidth((float) (i5 * 2));
            updateWidgetLayout(false);
        }
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.tickColorActive)) {
            this.tickColorActive = colorStateList;
            this.activeTicksPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTickInactiveRadius(@Px @IntRange(from = 0) int i5) {
        if (this.tickInactiveRadius != i5) {
            this.tickInactiveRadius = i5;
            this.inactiveTicksPaint.setStrokeWidth((float) (i5 * 2));
            updateWidgetLayout(false);
        }
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.tickColorInactive)) {
            this.tickColorInactive = colorStateList;
            this.inactiveTicksPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisibilityMode(int i5) {
        if (this.tickVisibilityMode != i5) {
            this.tickVisibilityMode = i5;
            postInvalidate();
        }
    }

    @Deprecated
    public void setTickVisible(boolean z4) {
        setTickVisibilityMode(convertToTickVisibilityMode(z4));
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.trackColorActive)) {
            this.trackColorActive = colorStateList;
            this.activeTrackPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTrackCornerSize(@Px int i5) {
        if (this.trackCornerSize != i5) {
            this.trackCornerSize = i5;
            invalidate();
        }
    }

    public void setTrackHeight(@Px @IntRange(from = 0) int i5) {
        if (this.trackThickness != i5) {
            this.trackThickness = i5;
            invalidateTrack();
            updateWidgetLayout(false);
        }
    }

    public void setTrackIconActiveColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != this.trackIconActiveColor) {
            this.trackIconActiveColor = colorStateList;
            updateTrackIconActiveStart();
            updateTrackIconActiveEnd();
            invalidate();
        }
    }

    public void setTrackIconActiveEnd(@Nullable Drawable drawable) {
        if (drawable != this.trackIconActiveEnd) {
            this.trackIconActiveEnd = drawable;
            this.trackIconActiveEndMutated = false;
            updateTrackIconActiveEnd();
            invalidate();
        }
    }

    public void setTrackIconActiveStart(@Nullable Drawable drawable) {
        if (drawable != this.trackIconActiveStart) {
            this.trackIconActiveStart = drawable;
            this.trackIconActiveStartMutated = false;
            updateTrackIconActiveStart();
            invalidate();
        }
    }

    public void setTrackIconInactiveColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != this.trackIconInactiveColor) {
            this.trackIconInactiveColor = colorStateList;
            updateTrackIconInactiveStart();
            updateTrackIconInactiveEnd();
            invalidate();
        }
    }

    public void setTrackIconInactiveEnd(@Nullable Drawable drawable) {
        if (drawable != this.trackIconInactiveEnd) {
            this.trackIconInactiveEnd = drawable;
            this.trackIconInactiveEndMutated = false;
            updateTrackIconInactiveEnd();
            invalidate();
        }
    }

    public void setTrackIconInactiveStart(@Nullable Drawable drawable) {
        if (drawable != this.trackIconInactiveStart) {
            this.trackIconInactiveStart = drawable;
            this.trackIconInactiveStartMutated = false;
            updateTrackIconInactiveStart();
            invalidate();
        }
    }

    public void setTrackIconSize(@Px int i5) {
        if (this.trackIconSize != i5) {
            this.trackIconSize = i5;
            invalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.trackColorInactive)) {
            this.trackColorInactive = colorStateList;
            this.inactiveTrackPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTrackInsideCornerSize(@Px int i5) {
        if (this.trackInsideCornerSize != i5) {
            this.trackInsideCornerSize = i5;
            invalidate();
        }
    }

    public void setTrackStopIndicatorSize(@Px int i5) {
        if (this.trackStopIndicatorSize != i5) {
            this.trackStopIndicatorSize = i5;
            this.stopIndicatorPaint.setStrokeWidth((float) i5);
            invalidate();
        }
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f5) {
        this.valueFrom = f5;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f5) {
        this.valueTo = f5;
        this.dirtyConfig = true;
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public void setValues(@NonNull Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void updateBoundsForVirtualViewId(int i5, Rect rect) {
        int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i5).floatValue()) * ((float) this.trackWidth)));
        int calculateTrackCenter = calculateTrackCenter();
        int max = Math.max(this.thumbWidth / 2, this.minTouchTargetSize / 2);
        int max2 = Math.max(this.thumbHeight / 2, this.minTouchTargetSize / 2);
        RectF rectF = new RectF((float) (normalizeValue - max), (float) (calculateTrackCenter - max2), (float) (normalizeValue + max), (float) (calculateTrackCenter + max2));
        if (isVertical()) {
            this.rotationMatrix.mapRect(rectF);
        }
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    /* access modifiers changed from: private */
    public float calculateStepIncrement(int i5) {
        float calculateStepIncrement = calculateStepIncrement();
        float f5 = (this.valueTo - this.valueFrom) / calculateStepIncrement;
        float f6 = (float) i5;
        if (f5 <= f6) {
            return calculateStepIncrement;
        }
        return ((float) Math.round(f5 / f6)) * calculateStepIncrement;
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        this.customThumbDrawable = initializeCustomThumbDrawable(drawable);
        this.customThumbDrawablesForValues.clear();
        postInvalidate();
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i5, DEF_STYLE_RES), attributeSet, i5);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.defaultThumbWidth = -1;
        this.defaultThumbTrackGapSize = -1;
        this.centered = false;
        this.trackIconActiveStartMutated = false;
        this.trackIconActiveEndMutated = false;
        this.trackIconInactiveStartMutated = false;
        this.trackIconInactiveEndMutated = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.isLongPress = false;
        this.trackPath = new Path();
        this.activeTrackRect = new RectF();
        this.inactiveTrackLeftRect = new RectF();
        this.inactiveTrackRightRect = new RectF();
        this.cornerRect = new RectF();
        this.labelRect = new Rect();
        this.iconRectF = new RectF();
        this.iconRect = new Rect();
        this.rotationMatrix = new Matrix();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.defaultThumbDrawable = materialShapeDrawable;
        this.customThumbDrawablesForValues = Collections.EMPTY_LIST;
        this.separationUnit = 0;
        this.onScrollChangedListener = new c(this);
        this.onGlobalLayoutListener = new d(this);
        this.resetActiveThumbIndex = new e(this);
        Context context2 = getContext();
        this.thisAndAncestorsVisible = isShown();
        this.inactiveTrackPaint = new Paint();
        this.activeTrackPaint = new Paint();
        Paint paint = new Paint(1);
        this.thumbPaint = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.haloPaint = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.inactiveTicksPaint = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.activeTicksPaint = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.stopIndicatorPaint = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        loadResources(context2.getResources());
        processAttributes(context2, attributeSet, i5);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper2 = new AccessibilityHelper(this);
        this.accessibilityHelper = accessibilityHelper2;
        ViewCompat.setAccessibilityDelegate(this, accessibilityHelper2);
        AccessibilityManager accessibilityManager2 = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.accessibilityManager = accessibilityManager2;
        if (Build.VERSION.SDK_INT >= 29) {
            this.tooltipTimeoutMillis = accessibilityManager2.getRecommendedTimeoutMillis(10000, 6);
        } else {
            this.tooltipTimeoutMillis = MAX_TIMEOUT_TOOLTIP_WITH_ACCESSIBILITY;
        }
    }

    /* access modifiers changed from: package-private */
    public void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList(list));
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.customThumbDrawable = null;
        this.customThumbDrawablesForValues = new ArrayList();
        for (Drawable initializeCustomThumbDrawable : drawableArr) {
            this.customThumbDrawablesForValues.add(initializeCustomThumbDrawable(initializeCustomThumbDrawable));
        }
        postInvalidate();
    }

    public void setTrackIconActiveEnd(@DrawableRes int i5) {
        setTrackIconActiveEnd(i5 != 0 ? AppCompatResources.getDrawable(getContext(), i5) : null);
    }

    public void setTrackIconActiveStart(@DrawableRes int i5) {
        setTrackIconActiveStart(i5 != 0 ? AppCompatResources.getDrawable(getContext(), i5) : null);
    }

    public void setTrackIconInactiveEnd(@DrawableRes int i5) {
        setTrackIconInactiveEnd(i5 != 0 ? AppCompatResources.getDrawable(getContext(), i5) : null);
    }

    public void setTrackIconInactiveStart(@DrawableRes int i5) {
        setTrackIconInactiveStart(i5 != 0 ? AppCompatResources.getDrawable(getContext(), i5) : null);
    }

    private void updateTicksCoordinates(int i5) {
        if (i5 == 0) {
            this.ticksCoordinates = null;
            return;
        }
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != i5 * 2) {
            this.ticksCoordinates = new float[(i5 * 2)];
        }
        float f5 = ((float) this.trackWidth) / ((float) (i5 - 1));
        float calculateTrackCenter = (float) calculateTrackCenter();
        for (int i6 = 0; i6 < i5 * 2; i6 += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i6] = ((float) this.trackSidePadding) + ((((float) i6) / 2.0f) * f5);
            fArr2[i6 + 1] = calculateTrackCenter;
        }
        if (isVertical()) {
            this.rotationMatrix.mapPoints(this.ticksCoordinates);
        }
    }
}
