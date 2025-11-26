package com.google.android.material.carousel;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface Carousel {
    int getCarouselAlignment();

    int getContainerHeight();

    int getContainerWidth();

    int getItemCount();

    boolean isHorizontal();
}
