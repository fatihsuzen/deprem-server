package androidx.core.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static float deriveDimension(int i5, float f5, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i5, f5, displayMetrics);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int i5, float f5, @NonNull DisplayMetrics displayMetrics) {
        float f6;
        float f7;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(i5, f5, displayMetrics);
        }
        if (i5 == 0) {
            return f5;
        }
        if (i5 == 1) {
            float f8 = displayMetrics.density;
            if (f8 == 0.0f) {
                return 0.0f;
            }
            return f5 / f8;
        } else if (i5 != 2) {
            if (i5 == 3) {
                float f9 = displayMetrics.xdpi;
                if (f9 == 0.0f) {
                    return 0.0f;
                }
                f6 = f5 / f9;
                f7 = INCHES_PER_PT;
            } else if (i5 == 4) {
                float f10 = displayMetrics.xdpi;
                if (f10 == 0.0f) {
                    return 0.0f;
                }
                return f5 / f10;
            } else if (i5 == 5) {
                float f11 = displayMetrics.xdpi;
                if (f11 == 0.0f) {
                    return 0.0f;
                }
                f6 = f5 / f11;
                f7 = INCHES_PER_MM;
            } else {
                throw new IllegalArgumentException("Invalid unitToConvertTo " + i5);
            }
            return f6 / f7;
        } else {
            float f12 = displayMetrics.scaledDensity;
            if (f12 == 0.0f) {
                return 0.0f;
            }
            return f5 / f12;
        }
    }

    public static float dpToPx(float f5, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f5, displayMetrics);
    }

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int i5) {
        return i5 & 15;
    }

    public static float pxToDp(float f5, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(1, f5, displayMetrics);
    }

    public static float pxToSp(float f5, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(2, f5, displayMetrics);
    }

    public static float spToPx(float f5, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f5, displayMetrics);
    }
}
