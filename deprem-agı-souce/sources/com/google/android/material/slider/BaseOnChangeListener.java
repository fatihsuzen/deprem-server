package com.google.android.material.slider;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface BaseOnChangeListener<S> {
    void onValueChange(@NonNull S s5, float f5, boolean z4);
}
