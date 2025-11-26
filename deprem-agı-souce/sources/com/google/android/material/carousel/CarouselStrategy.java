package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

public abstract class CarouselStrategy {
    private float smallSizeMax;
    private float smallSizeMin;

    enum StrategyType {
        CONTAINED,
        UNCONTAINED
    }

    static int[] doubleCounts(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr2[i5] = iArr[i5] * 2;
        }
        return iArr2;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static float getChildMaskPercentage(float f5, float f6, float f7) {
        return 1.0f - ((f5 - f7) / (f6 - f7));
    }

    public float getSmallItemSizeMax() {
        return this.smallSizeMax;
    }

    public float getSmallItemSizeMin() {
        return this.smallSizeMin;
    }

    /* access modifiers changed from: package-private */
    public StrategyType getStrategyType() {
        return StrategyType.CONTAINED;
    }

    /* access modifiers changed from: package-private */
    public void initialize(Context context) {
        float f5 = this.smallSizeMin;
        if (f5 <= 0.0f) {
            f5 = CarouselStrategyHelper.getSmallSizeMin(context);
        }
        this.smallSizeMin = f5;
        float f6 = this.smallSizeMax;
        if (f6 <= 0.0f) {
            f6 = CarouselStrategyHelper.getSmallSizeMax(context);
        }
        this.smallSizeMax = f6;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view);

    public void setSmallItemSizeMax(float f5) {
        this.smallSizeMax = f5;
    }

    public void setSmallItemSizeMin(float f5) {
        this.smallSizeMin = f5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i5) {
        return false;
    }
}
