package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FullScreenCarouselStrategy extends CarouselStrategy {
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerHeight;
        int i5;
        int i6;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
            i5 = layoutParams.leftMargin;
            i6 = layoutParams.rightMargin;
        } else {
            containerHeight = carousel.getContainerHeight();
            i5 = layoutParams.topMargin;
            i6 = layoutParams.bottomMargin;
        }
        float f5 = (float) (i5 + i6);
        float f6 = (float) containerHeight;
        return CarouselStrategyHelper.createLeftAlignedKeylineState(view.getContext(), f5, containerHeight, new Arrangement(0, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0, Math.min(f6 + f5, f6), 1, f6));
    }
}
