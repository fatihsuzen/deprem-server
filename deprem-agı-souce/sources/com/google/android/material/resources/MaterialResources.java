package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;

    private MaterialResources() {
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i5) {
        int resourceId;
        ColorStateList colorStateList;
        if (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) {
            return typedArray.getColorStateList(i5);
        }
        return colorStateList;
    }

    private static int getComplexUnit(TypedValue typedValue) {
        return typedValue.getComplexUnit();
    }

    public static int getDimensionPixelSize(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i5, int i6) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i5, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i5, i6);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i6);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i5) {
        int resourceId;
        Drawable drawable;
        if (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0 || (drawable = AppCompatResources.getDrawable(context, resourceId)) == null) {
            return typedArray.getDrawable(i5);
        }
        return drawable;
    }

    public static float getFontScale(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    @StyleableRes
    static int getIndexWithValue(@NonNull TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6) {
        if (typedArray.hasValue(i5)) {
            return i5;
        }
        return i6;
    }

    @Nullable
    public static TextAppearance getTextAppearance(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i5) {
        int resourceId;
        if (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static int getUnscaledLineHeight(@NonNull Context context, @StyleRes int i5, int i6) {
        if (i5 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i5, R.styleable.MaterialTextAppearance);
            TypedValue typedValue = new TypedValue();
            boolean value = obtainStyledAttributes.getValue(R.styleable.MaterialTextAppearance_lineHeight, typedValue);
            if (!value) {
                value = obtainStyledAttributes.getValue(R.styleable.MaterialTextAppearance_android_lineHeight, typedValue);
            }
            obtainStyledAttributes.recycle();
            if (value) {
                if (getComplexUnit(typedValue) == 2) {
                    return Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density);
                }
                return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            }
        }
        return i6;
    }

    public static int getUnscaledTextSize(@NonNull Context context, @StyleRes int i5, int i6) {
        if (i5 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i5, androidx.appcompat.R.styleable.TextAppearance);
            TypedValue typedValue = new TypedValue();
            boolean value = obtainStyledAttributes.getValue(androidx.appcompat.R.styleable.TextAppearance_android_textSize, typedValue);
            obtainStyledAttributes.recycle();
            if (value) {
                if (getComplexUnit(typedValue) == 2) {
                    return Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density);
                }
                return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            }
        }
        return i6;
    }

    public static boolean isFontScaleAtLeast1_3(@NonNull Context context) {
        if (context.getResources().getConfiguration().fontScale >= FONT_SCALE_1_3) {
            return true;
        }
        return false;
    }

    public static boolean isFontScaleAtLeast2_0(@NonNull Context context) {
        if (context.getResources().getConfiguration().fontScale >= FONT_SCALE_2_0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @NonNull TintTypedArray tintTypedArray, @StyleableRes int i5) {
        int resourceId;
        ColorStateList colorStateList;
        if (!tintTypedArray.hasValue(i5) || (resourceId = tintTypedArray.getResourceId(i5, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) {
            return tintTypedArray.getColorStateList(i5);
        }
        return colorStateList;
    }
}
