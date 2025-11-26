package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public class HeroCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = {0, 1};
    private static final int[] SMALL_COUNTS = {1};
    private int keylineCount = 0;

    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int i5;
        int[] iArr;
        int[] iArr2;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f5 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredWidth = (float) (view.getMeasuredWidth() * 2);
        if (carousel.isHorizontal()) {
            f5 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredWidth = (float) (view.getMeasuredHeight() * 2);
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f5;
        float max = Math.max(getSmallItemSizeMax() + f5, smallItemSizeMin);
        float f6 = (float) containerHeight;
        float min = Math.min(measuredWidth + f5, f6);
        float clamp = MathUtils.clamp((measuredWidth / 3.0f) + f5, smallItemSizeMin + f5, max + f5);
        float f7 = (min + clamp) / 2.0f;
        int[] iArr3 = SMALL_COUNTS;
        int i6 = 0;
        int[] iArr4 = f6 < 2.0f * smallItemSizeMin ? new int[]{0} : iArr3;
        float f8 = f7;
        int max2 = (int) Math.max(1.0d, Math.floor((double) ((f6 - (((float) CarouselStrategyHelper.maxValue(iArr3)) * max)) / min)));
        int ceil = (((int) Math.ceil((double) (f6 / min))) - max2) + 1;
        int[] iArr5 = new int[ceil];
        for (int i7 = 0; i7 < ceil; i7++) {
            iArr5[i7] = max2 + i7;
        }
        if (carousel.getCarouselAlignment() == 1) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            iArr = CarouselStrategy.doubleCounts(iArr4);
        } else {
            iArr = iArr4;
        }
        if (i5 != 0) {
            iArr2 = CarouselStrategy.doubleCounts(MEDIUM_COUNTS);
        } else {
            iArr2 = MEDIUM_COUNTS;
        }
        int[] iArr6 = iArr2;
        float f9 = f8;
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f6, clamp, smallItemSizeMin, max, iArr, f9, iArr6, min, iArr5);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (findLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f6, clamp, smallItemSizeMin, max, iArr4, f9, MEDIUM_COUNTS, min, iArr5);
        } else {
            i6 = i5;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f5, containerHeight, findLowestCostArrangement, i6);
    }

    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i5) {
        if (carousel.getCarouselAlignment() != 1) {
            return false;
        }
        if ((i5 >= this.keylineCount || carousel.getItemCount() < this.keylineCount) && (i5 < this.keylineCount || carousel.getItemCount() >= this.keylineCount)) {
            return false;
        }
        return true;
    }
}
