package com.google.android.material.loadingindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;

public final class LoadingIndicatorSpec {
    @ColorInt
    int containerColor;
    @Px
    int containerHeight;
    @Px
    int containerWidth;
    @NonNull
    int[] indicatorColors;
    @Px
    int indicatorSize;
    boolean scaleToFit;

    public LoadingIndicatorSpec(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.loadingIndicatorStyle);
    }

    private void loadIndicatorColors(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i5 = R.styleable.LoadingIndicator_indicatorColor;
        if (!typedArray.hasValue(i5)) {
            this.indicatorColors = new int[]{MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, -1)};
        } else if (typedArray.peekValue(i5).type != 1) {
            this.indicatorColors = new int[]{typedArray.getColor(i5, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i5, -1));
            this.indicatorColors = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
    }

    public void setScaleToFit(boolean z4) {
        this.scaleToFit = z4;
    }

    public LoadingIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        this(context, attributeSet, i5, LoadingIndicator.DEF_STYLE_RES);
    }

    public LoadingIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        this.scaleToFit = false;
        this.indicatorColors = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.m3_loading_indicator_shape_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.m3_loading_indicator_container_size);
        Context context2 = context;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.LoadingIndicator, i5, i6, new int[0]);
        this.indicatorSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LoadingIndicator_indicatorSize, dimensionPixelSize);
        this.containerWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LoadingIndicator_containerWidth, dimensionPixelSize2);
        this.containerHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LoadingIndicator_containerHeight, dimensionPixelSize2);
        loadIndicatorColors(context2, obtainStyledAttributes);
        this.containerColor = obtainStyledAttributes.getColor(R.styleable.LoadingIndicator_containerColor, 0);
        obtainStyledAttributes.recycle();
    }
}
