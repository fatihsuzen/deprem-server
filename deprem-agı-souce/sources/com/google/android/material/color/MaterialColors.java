package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;

public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int CHROMA_NEUTRAL = 6;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;
    private static final int TONE_SURFACE_CONTAINER_DARK = 12;
    private static final int TONE_SURFACE_CONTAINER_HIGH_DARK = 17;
    private static final int TONE_SURFACE_CONTAINER_HIGH_LIGHT = 92;
    private static final int TONE_SURFACE_CONTAINER_LIGHT = 94;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i5, @IntRange(from = 0, to = 255) int i6) {
        return ColorUtils.setAlphaComponent(i5, (Color.alpha(i5) * i6) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i5) {
        return resolveColor(view.getContext(), MaterialAttributes.resolveTypedValueOrThrow(view, i5));
    }

    @ColorInt
    @Nullable
    public static Integer getColorOrNull(@NonNull Context context, @AttrRes int i5) {
        TypedValue resolve = MaterialAttributes.resolve(context, i5);
        if (resolve != null) {
            return Integer.valueOf(resolveColor(context, resolve));
        }
        return null;
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i5, @IntRange(from = 0, to = 100) int i6) {
        Hct fromInt = Hct.fromInt(i5);
        fromInt.setTone((double) i6);
        return fromInt.toInt();
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context context, @ColorInt int i5) {
        return getColorRoles(i5, isLightTheme(context));
    }

    @NonNull
    public static ColorStateList getColorStateList(@NonNull Context context, @AttrRes int i5, @NonNull ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        TypedValue resolve = MaterialAttributes.resolve(context, i5);
        if (resolve != null) {
            colorStateList2 = resolveColorStateList(context, resolve);
        } else {
            colorStateList2 = null;
        }
        if (colorStateList2 == null) {
            return colorStateList;
        }
        return colorStateList2;
    }

    @Nullable
    public static ColorStateList getColorStateListOrNull(@NonNull Context context, @AttrRes int i5) {
        TypedValue resolve = MaterialAttributes.resolve(context, i5);
        if (resolve == null) {
            return null;
        }
        int i6 = resolve.resourceId;
        if (i6 != 0) {
            return ContextCompat.getColorStateList(context, i6);
        }
        int i7 = resolve.data;
        if (i7 != 0) {
            return ColorStateList.valueOf(i7);
        }
        return null;
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerFromSeed(@NonNull Context context, @ColorInt int i5) {
        int i6;
        if (isLightTheme(context)) {
            i6 = 94;
        } else {
            i6 = 12;
        }
        return getColorRole(i5, i6, 6);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerHighFromSeed(@NonNull Context context, @ColorInt int i5) {
        int i6;
        if (isLightTheme(context)) {
            i6 = 92;
        } else {
            i6 = 17;
        }
        return getColorRole(i5, i6, 6);
    }

    @ColorInt
    public static int harmonize(@ColorInt int i5, @ColorInt int i6) {
        return Blend.harmonize(i5, i6);
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context context, @ColorInt int i5) {
        return harmonize(i5, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int i5) {
        if (i5 == 0 || ColorUtils.calculateLuminance(i5) <= 0.5d) {
            return false;
        }
        return true;
    }

    static boolean isLightTheme(@NonNull Context context) {
        return MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i5, @AttrRes int i6) {
        return layer(view, i5, i6, 1.0f);
    }

    private static int resolveColor(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i5 = typedValue.resourceId;
        if (i5 != 0) {
            return ContextCompat.getColor(context, i5);
        }
        return typedValue.data;
    }

    private static ColorStateList resolveColorStateList(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i5 = typedValue.resourceId;
        if (i5 != 0) {
            return ContextCompat.getColorStateList(context, i5);
        }
        return ColorStateList.valueOf(typedValue.data);
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int i5, boolean z4) {
        if (z4) {
            return new ColorRoles(getColorRole(i5, 40), getColorRole(i5, 100), getColorRole(i5, 90), getColorRole(i5, 10));
        }
        return new ColorRoles(getColorRole(i5, 80), getColorRole(i5, 20), getColorRole(i5, 30), getColorRole(i5, 90));
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i5, @AttrRes int i6, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        return layer(getColor(view, i5), getColor(view, i6), f5);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i5, String str) {
        return resolveColor(context, MaterialAttributes.resolveTypedValueOrThrow(context, i5, str));
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i5, @IntRange(from = 0, to = 100) int i6, int i7) {
        Hct fromInt = Hct.fromInt(getColorRole(i5, i6));
        fromInt.setChroma((double) i7);
        return fromInt.toInt();
    }

    @ColorInt
    public static int layer(@ColorInt int i5, @ColorInt int i6, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        return layer(i5, ColorUtils.setAlphaComponent(i6, Math.round(((float) Color.alpha(i6)) * f5)));
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i5, @ColorInt int i6) {
        return getColor(view.getContext(), i5, i6);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i5, @ColorInt int i6) {
        Integer colorOrNull = getColorOrNull(context, i5);
        return colorOrNull != null ? colorOrNull.intValue() : i6;
    }

    @ColorInt
    public static int layer(@ColorInt int i5, @ColorInt int i6) {
        return ColorUtils.compositeColors(i6, i5);
    }
}
