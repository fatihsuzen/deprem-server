package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import java.util.ArrayList;
import java.util.List;

public class RangeSlider extends BaseSlider<RangeSlider, OnChangeListener, OnSliderTouchListener> {
    private float minSeparation;
    private int separationUnit;

    public interface OnChangeListener extends BaseOnChangeListener<RangeSlider> {
        void onValueChange(@NonNull RangeSlider rangeSlider, float f5, boolean z4);

        /* bridge */ /* synthetic */ void onValueChange(@NonNull Object obj, float f5, boolean z4);
    }

    public interface OnSliderTouchListener extends BaseOnSliderTouchListener<RangeSlider> {
        void onStartTrackingTouch(@NonNull RangeSlider rangeSlider);

        /* bridge */ /* synthetic */ void onStartTrackingTouch(@NonNull Object obj);

        void onStopTrackingTouch(@NonNull RangeSlider rangeSlider);

        /* bridge */ /* synthetic */ void onStopTrackingTouch(@NonNull Object obj);
    }

    static class RangeSliderState extends AbsSavedState {
        public static final Parcelable.Creator<RangeSliderState> CREATOR = new Parcelable.Creator<RangeSliderState>() {
            public RangeSliderState createFromParcel(Parcel parcel) {
                return new RangeSliderState(parcel);
            }

            public RangeSliderState[] newArray(int i5) {
                return new RangeSliderState[i5];
            }
        };
        /* access modifiers changed from: private */
        public float minSeparation;
        /* access modifiers changed from: private */
        public int separationUnit;

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeFloat(this.minSeparation);
            parcel.writeInt(this.separationUnit);
        }

        RangeSliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private RangeSliderState(Parcel parcel) {
            super(parcel.readParcelable(RangeSliderState.class.getClassLoader()));
            this.minSeparation = parcel.readFloat();
            this.separationUnit = parcel.readInt();
        }
    }

    public RangeSlider(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static List<Float> convertToFloat(TypedArray typedArray) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < typedArray.length(); i5++) {
            arrayList.add(Float.valueOf(typedArray.getFloat(i5, -1.0f)));
        }
        return arrayList;
    }

    public /* bridge */ /* synthetic */ void addOnChangeListener(@NonNull BaseOnChangeListener baseOnChangeListener) {
        super.addOnChangeListener(baseOnChangeListener);
    }

    public /* bridge */ /* synthetic */ void addOnSliderTouchListener(@NonNull BaseOnSliderTouchListener baseOnSliderTouchListener) {
        super.addOnSliderTouchListener(baseOnSliderTouchListener);
    }

    public /* bridge */ /* synthetic */ void clearOnChangeListeners() {
        super.clearOnChangeListeners();
    }

    public /* bridge */ /* synthetic */ void clearOnSliderTouchListeners() {
        super.clearOnSliderTouchListeners();
    }

    public /* bridge */ /* synthetic */ boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @NonNull
    public /* bridge */ /* synthetic */ CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    public /* bridge */ /* synthetic */ int getActiveThumbIndex() {
        return super.getActiveThumbIndex();
    }

    public /* bridge */ /* synthetic */ int getFocusedThumbIndex() {
        return super.getFocusedThumbIndex();
    }

    @Px
    public /* bridge */ /* synthetic */ int getHaloRadius() {
        return super.getHaloRadius();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getHaloTintList() {
        return super.getHaloTintList();
    }

    public /* bridge */ /* synthetic */ int getLabelBehavior() {
        return super.getLabelBehavior();
    }

    public float getMinSeparation() {
        return this.minSeparation;
    }

    public /* bridge */ /* synthetic */ float getStepSize() {
        return super.getStepSize();
    }

    public /* bridge */ /* synthetic */ float getThumbElevation() {
        return super.getThumbElevation();
    }

    @Px
    public /* bridge */ /* synthetic */ int getThumbHeight() {
        return super.getThumbHeight();
    }

    @Px
    public /* bridge */ /* synthetic */ int getThumbRadius() {
        return super.getThumbRadius();
    }

    public /* bridge */ /* synthetic */ ColorStateList getThumbStrokeColor() {
        return super.getThumbStrokeColor();
    }

    public /* bridge */ /* synthetic */ float getThumbStrokeWidth() {
        return super.getThumbStrokeWidth();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getThumbTintList() {
        return super.getThumbTintList();
    }

    public /* bridge */ /* synthetic */ int getThumbTrackGapSize() {
        return super.getThumbTrackGapSize();
    }

    @Px
    public /* bridge */ /* synthetic */ int getThumbWidth() {
        return super.getThumbWidth();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTickActiveRadius() {
        return super.getTickActiveRadius();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickActiveTintList() {
        return super.getTickActiveTintList();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTickInactiveRadius() {
        return super.getTickInactiveRadius();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickInactiveTintList() {
        return super.getTickInactiveTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickTintList() {
        return super.getTickTintList();
    }

    public /* bridge */ /* synthetic */ int getTickVisibilityMode() {
        return super.getTickVisibilityMode();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackActiveTintList() {
        return super.getTrackActiveTintList();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTrackCornerSize() {
        return super.getTrackCornerSize();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTrackHeight() {
        return super.getTrackHeight();
    }

    @Nullable
    public /* bridge */ /* synthetic */ ColorStateList getTrackIconActiveColor() {
        return super.getTrackIconActiveColor();
    }

    @Nullable
    public /* bridge */ /* synthetic */ Drawable getTrackIconActiveEnd() {
        return super.getTrackIconActiveEnd();
    }

    @Nullable
    public /* bridge */ /* synthetic */ Drawable getTrackIconActiveStart() {
        return super.getTrackIconActiveStart();
    }

    @Nullable
    public /* bridge */ /* synthetic */ ColorStateList getTrackIconInactiveColor() {
        return super.getTrackIconInactiveColor();
    }

    @Nullable
    public /* bridge */ /* synthetic */ Drawable getTrackIconInactiveEnd() {
        return super.getTrackIconInactiveEnd();
    }

    @Nullable
    public /* bridge */ /* synthetic */ Drawable getTrackIconInactiveStart() {
        return super.getTrackIconInactiveStart();
    }

    public /* bridge */ /* synthetic */ int getTrackIconSize() {
        return super.getTrackIconSize();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackInactiveTintList() {
        return super.getTrackInactiveTintList();
    }

    public /* bridge */ /* synthetic */ int getTrackInsideCornerSize() {
        return super.getTrackInsideCornerSize();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTrackSidePadding() {
        return super.getTrackSidePadding();
    }

    public /* bridge */ /* synthetic */ int getTrackStopIndicatorSize() {
        return super.getTrackStopIndicatorSize();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackTintList() {
        return super.getTrackTintList();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTrackWidth() {
        return super.getTrackWidth();
    }

    public /* bridge */ /* synthetic */ float getValueFrom() {
        return super.getValueFrom();
    }

    public /* bridge */ /* synthetic */ float getValueTo() {
        return super.getValueTo();
    }

    @NonNull
    public List<Float> getValues() {
        return super.getValues();
    }

    public /* bridge */ /* synthetic */ boolean hasLabelFormatter() {
        return super.hasLabelFormatter();
    }

    public /* bridge */ /* synthetic */ boolean isCentered() {
        return super.isCentered();
    }

    public /* bridge */ /* synthetic */ boolean isTickVisible() {
        return super.isTickVisible();
    }

    public /* bridge */ /* synthetic */ boolean isVertical() {
        return super.isVertical();
    }

    public /* bridge */ /* synthetic */ void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    public /* bridge */ /* synthetic */ boolean onKeyDown(int i5, @NonNull KeyEvent keyEvent) {
        return super.onKeyDown(i5, keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean onKeyUp(int i5, @NonNull KeyEvent keyEvent) {
        return super.onKeyUp(i5, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        RangeSliderState rangeSliderState = (RangeSliderState) parcelable;
        super.onRestoreInstanceState(rangeSliderState.getSuperState());
        this.minSeparation = rangeSliderState.minSeparation;
        int access$100 = rangeSliderState.separationUnit;
        this.separationUnit = access$100;
        setSeparationUnit(access$100);
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        RangeSliderState rangeSliderState = new RangeSliderState(super.onSaveInstanceState());
        float unused = rangeSliderState.minSeparation = this.minSeparation;
        int unused2 = rangeSliderState.separationUnit = this.separationUnit;
        return rangeSliderState;
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void onVisibilityAggregated(boolean z4) {
        super.onVisibilityAggregated(z4);
    }

    public /* bridge */ /* synthetic */ void removeOnChangeListener(@NonNull BaseOnChangeListener baseOnChangeListener) {
        super.removeOnChangeListener(baseOnChangeListener);
    }

    public /* bridge */ /* synthetic */ void removeOnSliderTouchListener(@NonNull BaseOnSliderTouchListener baseOnSliderTouchListener) {
        super.removeOnSliderTouchListener(baseOnSliderTouchListener);
    }

    public /* bridge */ /* synthetic */ void scheduleTooltipTimeout() {
        super.scheduleTooltipTimeout();
    }

    public /* bridge */ /* synthetic */ void setCentered(boolean z4) {
        super.setCentered(z4);
    }

    public void setCustomThumbDrawable(@DrawableRes int i5) {
        super.setCustomThumbDrawable(i5);
    }

    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        super.setCustomThumbDrawablesForValues(iArr);
    }

    public /* bridge */ /* synthetic */ void setEnabled(boolean z4) {
        super.setEnabled(z4);
    }

    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int i5) {
        super.setFocusedThumbIndex(i5);
    }

    public /* bridge */ /* synthetic */ void setHaloRadius(@Px @IntRange(from = 0) int i5) {
        super.setHaloRadius(i5);
    }

    public /* bridge */ /* synthetic */ void setHaloRadiusResource(@DimenRes int i5) {
        super.setHaloRadiusResource(i5);
    }

    public /* bridge */ /* synthetic */ void setHaloTintList(@NonNull ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setLabelBehavior(int i5) {
        super.setLabelBehavior(i5);
    }

    public /* bridge */ /* synthetic */ void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        super.setLabelFormatter(labelFormatter);
    }

    public void setMinSeparation(@Dimension float f5) {
        this.minSeparation = f5;
        this.separationUnit = 0;
        setSeparationUnit(0);
    }

    public void setMinSeparationValue(float f5) {
        this.minSeparation = f5;
        this.separationUnit = 1;
        setSeparationUnit(1);
    }

    public /* bridge */ /* synthetic */ void setOrientation(int i5) {
        super.setOrientation(i5);
    }

    public /* bridge */ /* synthetic */ void setStepSize(float f5) {
        super.setStepSize(f5);
    }

    public /* bridge */ /* synthetic */ void setThumbElevation(float f5) {
        super.setThumbElevation(f5);
    }

    public /* bridge */ /* synthetic */ void setThumbElevationResource(@DimenRes int i5) {
        super.setThumbElevationResource(i5);
    }

    public /* bridge */ /* synthetic */ void setThumbHeight(@Px @IntRange(from = 0) int i5) {
        super.setThumbHeight(i5);
    }

    public /* bridge */ /* synthetic */ void setThumbHeightResource(@DimenRes int i5) {
        super.setThumbHeightResource(i5);
    }

    public /* bridge */ /* synthetic */ void setThumbRadius(@Px @IntRange(from = 0) int i5) {
        super.setThumbRadius(i5);
    }

    public /* bridge */ /* synthetic */ void setThumbRadiusResource(@DimenRes int i5) {
        super.setThumbRadiusResource(i5);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        super.setThumbStrokeColor(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeColorResource(@ColorRes int i5) {
        super.setThumbStrokeColorResource(i5);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeWidth(float f5) {
        super.setThumbStrokeWidth(f5);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeWidthResource(@DimenRes int i5) {
        super.setThumbStrokeWidthResource(i5);
    }

    public /* bridge */ /* synthetic */ void setThumbTintList(@NonNull ColorStateList colorStateList) {
        super.setThumbTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setThumbTrackGapSize(@Px int i5) {
        super.setThumbTrackGapSize(i5);
    }

    public /* bridge */ /* synthetic */ void setThumbWidth(@Px @IntRange(from = 0) int i5) {
        super.setThumbWidth(i5);
    }

    public /* bridge */ /* synthetic */ void setThumbWidthResource(@DimenRes int i5) {
        super.setThumbWidthResource(i5);
    }

    public /* bridge */ /* synthetic */ void setTickActiveRadius(@Px @IntRange(from = 0) int i5) {
        super.setTickActiveRadius(i5);
    }

    public /* bridge */ /* synthetic */ void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickInactiveRadius(@Px @IntRange(from = 0) int i5) {
        super.setTickInactiveRadius(i5);
    }

    public /* bridge */ /* synthetic */ void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickTintList(@NonNull ColorStateList colorStateList) {
        super.setTickTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickVisibilityMode(int i5) {
        super.setTickVisibilityMode(i5);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void setTickVisible(boolean z4) {
        super.setTickVisible(z4);
    }

    public /* bridge */ /* synthetic */ void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTrackCornerSize(@Px int i5) {
        super.setTrackCornerSize(i5);
    }

    public /* bridge */ /* synthetic */ void setTrackHeight(@Px @IntRange(from = 0) int i5) {
        super.setTrackHeight(i5);
    }

    public /* bridge */ /* synthetic */ void setTrackIconActiveColor(@Nullable ColorStateList colorStateList) {
        super.setTrackIconActiveColor(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTrackIconActiveEnd(@DrawableRes int i5) {
        super.setTrackIconActiveEnd(i5);
    }

    public /* bridge */ /* synthetic */ void setTrackIconActiveStart(@DrawableRes int i5) {
        super.setTrackIconActiveStart(i5);
    }

    public /* bridge */ /* synthetic */ void setTrackIconInactiveColor(@Nullable ColorStateList colorStateList) {
        super.setTrackIconInactiveColor(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTrackIconInactiveEnd(@DrawableRes int i5) {
        super.setTrackIconInactiveEnd(i5);
    }

    public /* bridge */ /* synthetic */ void setTrackIconInactiveStart(@DrawableRes int i5) {
        super.setTrackIconInactiveStart(i5);
    }

    public /* bridge */ /* synthetic */ void setTrackIconSize(@Px int i5) {
        super.setTrackIconSize(i5);
    }

    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTrackInsideCornerSize(@Px int i5) {
        super.setTrackInsideCornerSize(i5);
    }

    public /* bridge */ /* synthetic */ void setTrackStopIndicatorSize(@Px int i5) {
        super.setTrackStopIndicatorSize(i5);
    }

    public /* bridge */ /* synthetic */ void setTrackTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setValueFrom(float f5) {
        super.setValueFrom(f5);
    }

    public /* bridge */ /* synthetic */ void setValueTo(float f5) {
        super.setValueTo(f5);
    }

    public void setValues(@NonNull Float... fArr) {
        super.setValues(fArr);
    }

    public RangeSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        super.setCustomThumbDrawable(drawable);
    }

    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        super.setCustomThumbDrawablesForValues(drawableArr);
    }

    public /* bridge */ /* synthetic */ void setTrackIconActiveEnd(@Nullable Drawable drawable) {
        super.setTrackIconActiveEnd(drawable);
    }

    public /* bridge */ /* synthetic */ void setTrackIconActiveStart(@Nullable Drawable drawable) {
        super.setTrackIconActiveStart(drawable);
    }

    public /* bridge */ /* synthetic */ void setTrackIconInactiveEnd(@Nullable Drawable drawable) {
        super.setTrackIconInactiveEnd(drawable);
    }

    public /* bridge */ /* synthetic */ void setTrackIconInactiveStart(@Nullable Drawable drawable) {
        super.setTrackIconInactiveStart(drawable);
    }

    public void setValues(@NonNull List<Float> list) {
        super.setValues(list);
    }

    public RangeSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.RangeSlider, i5, BaseSlider.DEF_STYLE_RES, new int[0]);
        int i6 = R.styleable.RangeSlider_values;
        if (obtainStyledAttributes.hasValue(i6)) {
            setValues(convertToFloat(obtainStyledAttributes.getResources().obtainTypedArray(obtainStyledAttributes.getResourceId(i6, 0))));
        }
        this.minSeparation = obtainStyledAttributes.getDimension(R.styleable.RangeSlider_minSeparation, 0.0f);
        obtainStyledAttributes.recycle();
    }
}
