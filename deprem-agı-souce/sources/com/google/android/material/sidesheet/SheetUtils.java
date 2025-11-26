package com.google.android.material.sidesheet;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class SheetUtils {
    private SheetUtils() {
    }

    static boolean isSwipeMostlyHorizontal(float f5, float f6) {
        if (Math.abs(f5) > Math.abs(f6)) {
            return true;
        }
        return false;
    }
}
