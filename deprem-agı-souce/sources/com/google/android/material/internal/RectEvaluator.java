package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    public RectEvaluator(@NonNull Rect rect2) {
        this.rect = rect2;
    }

    public Rect evaluate(float f5, @NonNull Rect rect2, @NonNull Rect rect3) {
        int i5 = rect2.left;
        int i6 = i5 + ((int) (((float) (rect3.left - i5)) * f5));
        int i7 = rect2.top;
        int i8 = i7 + ((int) (((float) (rect3.top - i7)) * f5));
        int i9 = rect2.right;
        int i10 = rect2.bottom;
        int i11 = i10 + ((int) (((float) (rect3.bottom - i10)) * f5));
        this.rect.set(i6, i8, i9 + ((int) (((float) (rect3.right - i9)) * f5)), i11);
        return this.rect;
    }
}
