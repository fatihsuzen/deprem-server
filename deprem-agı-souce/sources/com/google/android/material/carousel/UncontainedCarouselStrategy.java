package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.KeylineState;

public final class UncontainedCarouselStrategy extends CarouselStrategy {
    private static final float MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD = 0.85f;

    private float calculateMediumChildSize(float f5, float f6, float f7) {
        float max = Math.max(1.5f * f7, f5);
        float f8 = MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD * f6;
        if (max > f8) {
            max = Math.max(f8, f7 * 1.2f);
        }
        return Math.min(f6, max);
    }

    private KeylineState createCenterAlignedKeylineState(int i5, float f5, float f6, int i6, float f7, float f8, float f9) {
        float f10 = f5;
        float f11 = f6;
        float f12 = f7;
        float min = Math.min(f8, f11);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(min, f11, f10);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(f12, f11, f10);
        float f13 = f12 / 2.0f;
        float f14 = (f9 + 0.0f) - f13;
        float f15 = f14 + f13;
        float f16 = min / 2.0f;
        float f17 = (((float) i6) * f11) + f15;
        KeylineState.Builder addKeylineRange = new KeylineState.Builder(f11, i5).addAnchorKeyline((f14 - f13) - f16, childMaskPercentage, min).addKeyline(f14, childMaskPercentage2, f12, false).addKeylineRange((f11 / 2.0f) + f15, 0.0f, f11, i6, true);
        addKeylineRange.addKeyline(f13 + f17, childMaskPercentage2, f12, false);
        addKeylineRange.addAnchorKeyline(f17 + f12 + f16, childMaskPercentage, min);
        return addKeylineRange.build();
    }

    private KeylineState createLeftAlignedKeylineState(Context context, float f5, int i5, float f6, int i6, float f7, int i7, float f8) {
        float f9 = f5;
        float f10 = f6;
        float f11 = f7;
        float min = Math.min(f8, f10);
        float max = Math.max(min, 0.5f * f11);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(max, f10, f9);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(min, f10, f9);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(f11, f10, f9);
        int i8 = i6;
        float f12 = (((float) i8) * f10) + 0.0f;
        KeylineState.Builder addKeylineRange = new KeylineState.Builder(f10, i5).addAnchorKeyline(0.0f - (max / 2.0f), childMaskPercentage, max).addKeylineRange(f10 / 2.0f, 0.0f, f10, i8, true);
        if (i7 > 0) {
            float f13 = (f11 / 2.0f) + f12;
            f12 += f11;
            addKeylineRange.addKeyline(f13, childMaskPercentage3, f11, false);
        }
        addKeylineRange.addAnchorKeyline(f12 + (CarouselStrategyHelper.getExtraSmallSize(context) / 2.0f), childMaskPercentage2, min);
        return addKeylineRange.build();
    }

    /* access modifiers changed from: package-private */
    public CarouselStrategy.StrategyType getStrategyType() {
        return CarouselStrategy.StrategyType.UNCONTAINED;
    }

    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerHeight;
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        } else {
            containerHeight = carousel.getContainerHeight();
        }
        int i5 = containerHeight;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f5 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f5 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
        }
        float f6 = measuredHeight;
        float f7 = f5;
        float f8 = f6 + f7;
        float extraSmallSize = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f7;
        float extraSmallSize2 = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f7;
        float f9 = (float) i5;
        int max = Math.max(1, (int) Math.floor((double) (f9 / f8)));
        float f10 = f9 - (((float) max) * f8);
        if (carousel.getCarouselAlignment() == 1) {
            float f11 = f10 / 2.0f;
            KeylineState createCenterAlignedKeylineState = createCenterAlignedKeylineState(i5, f7, f8, max, Math.max(Math.min(3.0f * f11, f8), getSmallItemSizeMin() + f7), extraSmallSize2, f11);
            return createCenterAlignedKeylineState;
        }
        int i6 = 1;
        int i7 = max;
        float f12 = f8;
        int i8 = i5;
        if (f10 <= 0.0f) {
            i6 = 0;
        }
        int i9 = i6;
        return createLeftAlignedKeylineState(view.getContext(), f7, i8, f12, i7, calculateMediumChildSize(extraSmallSize, f12, f10), i9, extraSmallSize2);
    }
}
