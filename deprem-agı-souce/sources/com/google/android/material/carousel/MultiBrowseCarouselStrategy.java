package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = {1, 0};
    private static final int[] SMALL_COUNTS = {1};
    private int keylineCount = 0;

    /* access modifiers changed from: package-private */
    public boolean ensureArrangementFitsItemCount(Arrangement arrangement, int i5) {
        boolean z4;
        int itemCount = arrangement.getItemCount() - i5;
        if (itemCount <= 0 || (arrangement.smallCount <= 0 && arrangement.mediumCount <= 1)) {
            z4 = false;
        } else {
            z4 = true;
        }
        while (itemCount > 0) {
            int i6 = arrangement.smallCount;
            if (i6 > 0) {
                arrangement.smallCount = i6 - 1;
            } else {
                int i7 = arrangement.mediumCount;
                if (i7 > 1) {
                    arrangement.mediumCount = i7 - 1;
                }
            }
            itemCount--;
        }
        return z4;
    }

    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        boolean z4;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f5 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f5 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f5;
        float max = Math.max(getSmallItemSizeMax() + f5, smallItemSizeMin);
        float f6 = (float) containerHeight;
        float min = Math.min(measuredHeight + f5, f6);
        float clamp = MathUtils.clamp((measuredHeight / 3.0f) + f5, smallItemSizeMin + f5, max + f5);
        float f7 = (min + clamp) / 2.0f;
        int[] iArr = SMALL_COUNTS;
        float f8 = 2.0f * smallItemSizeMin;
        if (f6 <= f8) {
            iArr = new int[]{0};
        }
        int[] iArr2 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() == 1) {
            iArr = CarouselStrategy.doubleCounts(iArr);
            iArr2 = CarouselStrategy.doubleCounts(iArr2);
        }
        int[] iArr3 = iArr2;
        int[] iArr4 = iArr;
        int[] iArr5 = iArr3;
        float f9 = f5;
        int ceil = (int) Math.ceil((double) (f6 / min));
        int max2 = (ceil - ((int) Math.max(1.0d, Math.floor((double) (((f6 - (((float) CarouselStrategyHelper.maxValue(iArr5)) * f7)) - (((float) CarouselStrategyHelper.maxValue(iArr4)) * max)) / min))))) + 1;
        int[] iArr6 = new int[max2];
        for (int i5 = 0; i5 < max2; i5++) {
            iArr6[i5] = ceil - i5;
        }
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f6, clamp, smallItemSizeMin, max, iArr4, f7, iArr5, min, iArr6);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        boolean ensureArrangementFitsItemCount = ensureArrangementFitsItemCount(findLowestCostArrangement, carousel.getItemCount());
        int i6 = findLowestCostArrangement.mediumCount;
        if (i6 == 0 && findLowestCostArrangement.smallCount == 0 && f6 > f8) {
            findLowestCostArrangement.smallCount = 1;
            z4 = true;
        } else {
            z4 = ensureArrangementFitsItemCount;
        }
        if (z4) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f6, clamp, smallItemSizeMin, max, new int[]{findLowestCostArrangement.smallCount}, f7, new int[]{i6}, min, new int[]{findLowestCostArrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f9, containerHeight, findLowestCostArrangement, carousel.getCarouselAlignment());
    }

    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i5) {
        if (i5 < this.keylineCount && carousel.getItemCount() >= this.keylineCount) {
            return true;
        }
        if (i5 < this.keylineCount || carousel.getItemCount() >= this.keylineCount) {
            return false;
        }
        return true;
    }
}
