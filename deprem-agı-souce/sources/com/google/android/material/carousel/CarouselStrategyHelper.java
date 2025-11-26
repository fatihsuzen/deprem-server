package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.carousel.KeylineState;

final class CarouselStrategyHelper {
    private CarouselStrategyHelper() {
    }

    static float addEnd(float f5, float f6, int i5) {
        return f5 + (((float) Math.max(0, i5 - 1)) * f6);
    }

    static float addStart(float f5, float f6, int i5) {
        return i5 > 0 ? f5 + (f6 / 2.0f) : f5;
    }

    static KeylineState createCenterAlignedKeylineState(@NonNull Context context, float f5, int i5, @NonNull Arrangement arrangement) {
        float f6;
        float f7;
        float f8 = f5;
        int i6 = i5;
        Arrangement arrangement2 = arrangement;
        float min = Math.min(getExtraSmallSize(context) + f8, arrangement2.largeSize);
        float f9 = min / 2.0f;
        float f10 = 0.0f - f9;
        float addStart = addStart(0.0f, arrangement2.smallSize, arrangement2.smallCount);
        float updateCurPosition = updateCurPosition(0.0f, addEnd(addStart, arrangement2.smallSize, (int) Math.floor((double) (((float) arrangement2.smallCount) / 2.0f))), arrangement2.smallSize, arrangement2.smallCount);
        float addStart2 = addStart(updateCurPosition, arrangement2.mediumSize, arrangement2.mediumCount);
        float updateCurPosition2 = updateCurPosition(updateCurPosition, addEnd(addStart2, arrangement2.mediumSize, (int) Math.floor((double) (((float) arrangement2.mediumCount) / 2.0f))), arrangement2.mediumSize, arrangement2.mediumCount);
        float addStart3 = addStart(updateCurPosition2, arrangement2.largeSize, arrangement2.largeCount);
        float updateCurPosition3 = updateCurPosition(updateCurPosition2, addEnd(addStart3, arrangement2.largeSize, arrangement2.largeCount), arrangement2.largeSize, arrangement2.largeCount);
        float addStart4 = addStart(updateCurPosition3, arrangement2.mediumSize, arrangement2.mediumCount);
        float addStart5 = addStart(updateCurPosition(updateCurPosition3, addEnd(addStart4, arrangement2.mediumSize, (int) Math.ceil((double) (((float) arrangement2.mediumCount) / 2.0f))), arrangement2.mediumSize, arrangement2.mediumCount), arrangement2.smallSize, arrangement2.smallCount);
        float f11 = ((float) i6) + f9;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(min, arrangement2.largeSize, f8);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement2.smallSize, arrangement2.largeSize, f8);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement2.mediumSize, arrangement2.largeSize, f8);
        KeylineState.Builder addAnchorKeyline = new KeylineState.Builder(arrangement2.largeSize, i6).addAnchorKeyline(f10, childMaskPercentage, min);
        int i7 = arrangement2.smallCount;
        if (i7 > 0) {
            f6 = 2.0f;
            f7 = childMaskPercentage;
            addAnchorKeyline.addKeylineRange(addStart, childMaskPercentage2, arrangement2.smallSize, (int) Math.floor((double) (((float) i7) / 2.0f)));
        } else {
            f6 = 2.0f;
            f7 = childMaskPercentage;
        }
        int i8 = arrangement2.mediumCount;
        if (i8 > 0) {
            addAnchorKeyline.addKeylineRange(addStart2, childMaskPercentage3, arrangement2.mediumSize, (int) Math.floor((double) (((float) i8) / f6)));
        }
        float f12 = childMaskPercentage2;
        KeylineState.Builder builder = addAnchorKeyline;
        float f13 = f12;
        builder.addKeylineRange(addStart3, 0.0f, arrangement2.largeSize, arrangement2.largeCount, true);
        int i9 = arrangement2.mediumCount;
        if (i9 > 0) {
            builder.addKeylineRange(addStart4, childMaskPercentage3, arrangement2.mediumSize, (int) Math.ceil((double) (((float) i9) / f6)));
        }
        int i10 = arrangement2.smallCount;
        if (i10 > 0) {
            builder.addKeylineRange(addStart5, f13, arrangement2.smallSize, (int) Math.ceil((double) (((float) i10) / f6)));
        }
        builder.addAnchorKeyline(f11, f7, min);
        return builder.build();
    }

    static KeylineState createKeylineState(@NonNull Context context, float f5, int i5, @NonNull Arrangement arrangement, int i6) {
        if (i6 == 1) {
            return createCenterAlignedKeylineState(context, f5, i5, arrangement);
        }
        return createLeftAlignedKeylineState(context, f5, i5, arrangement);
    }

    static KeylineState createLeftAlignedKeylineState(@NonNull Context context, float f5, int i5, @NonNull Arrangement arrangement) {
        float min = Math.min(getExtraSmallSize(context) + f5, arrangement.largeSize);
        float f6 = min / 2.0f;
        float f7 = 0.0f - f6;
        float addStart = addStart(0.0f, arrangement.largeSize, arrangement.largeCount);
        float updateCurPosition = updateCurPosition(0.0f, addEnd(addStart, arrangement.largeSize, arrangement.largeCount), arrangement.largeSize, arrangement.largeCount);
        float addStart2 = addStart(updateCurPosition, arrangement.mediumSize, arrangement.mediumCount);
        float addStart3 = addStart(updateCurPosition(updateCurPosition, addStart2, arrangement.mediumSize, arrangement.mediumCount), arrangement.smallSize, arrangement.smallCount);
        float f8 = ((float) i5) + f6;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(min, arrangement.largeSize, f5);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, f5);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, f5);
        KeylineState.Builder addKeylineRange = new KeylineState.Builder(arrangement.largeSize, i5).addAnchorKeyline(f7, childMaskPercentage, min).addKeylineRange(addStart, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            addKeylineRange.addKeyline(addStart2, childMaskPercentage3, arrangement.mediumSize);
        }
        int i6 = arrangement.smallCount;
        if (i6 > 0) {
            addKeylineRange.addKeylineRange(addStart3, childMaskPercentage2, arrangement.smallSize, i6);
        }
        addKeylineRange.addAnchorKeyline(f8, childMaskPercentage, min);
        return addKeylineRange.build();
    }

    static float getExtraSmallSize(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    static float getSmallSizeMax(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    static float getSmallSizeMin(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    static int maxValue(int[] iArr) {
        int i5 = Integer.MIN_VALUE;
        for (int i6 : iArr) {
            if (i6 > i5) {
                i5 = i6;
            }
        }
        return i5;
    }

    static float updateCurPosition(float f5, float f6, float f7, int i5) {
        return i5 > 0 ? f6 + (f7 / 2.0f) : f5;
    }
}
