package com.google.android.material.math;

import androidx.annotation.NonNull;

public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static boolean areAllElementsEqual(@NonNull float[] fArr) {
        if (fArr.length <= 1) {
            return true;
        }
        float f5 = fArr[0];
        for (int i5 = 1; i5 < fArr.length; i5++) {
            if (fArr[i5] != f5) {
                return false;
            }
        }
        return true;
    }

    public static float dist(float f5, float f6, float f7, float f8) {
        return (float) Math.hypot((double) (f7 - f5), (double) (f8 - f6));
    }

    public static float distanceToFurthestCorner(float f5, float f6, float f7, float f8, float f9, float f10) {
        return max(dist(f5, f6, f7, f8), dist(f5, f6, f9, f8), dist(f5, f6, f9, f10), dist(f5, f6, f7, f10));
    }

    public static float floorMod(float f5, int i5) {
        float f6 = (float) i5;
        int i6 = (int) (f5 / f6);
        if (Math.signum(f5) * f6 < 0.0f && ((float) (i6 * i5)) != f5) {
            i6--;
        }
        return f5 - ((float) (i6 * i5));
    }

    public static boolean geq(float f5, float f6, float f7) {
        return f5 + f7 >= f6;
    }

    public static float lerp(float f5, float f6, float f7) {
        return ((1.0f - f7) * f5) + (f7 * f6);
    }

    private static float max(float f5, float f6, float f7, float f8) {
        return (f5 <= f6 || f5 <= f7 || f5 <= f8) ? (f6 <= f7 || f6 <= f8) ? f7 > f8 ? f7 : f8 : f6 : f5;
    }

    public static int floorMod(int i5, int i6) {
        int i7 = i5 / i6;
        if ((i5 ^ i6) < 0 && i7 * i6 != i5) {
            i7--;
        }
        return i5 - (i7 * i6);
    }
}
