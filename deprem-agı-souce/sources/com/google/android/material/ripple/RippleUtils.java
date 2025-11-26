package com.google.android.material.ripple;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.color.MaterialColors;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleUtils {
    private static final int[] ENABLED_PRESSED_STATE_SET = {16842910, 16842919};
    private static final int[] FOCUSED_STATE_SET = {16842908};
    @VisibleForTesting
    static final String LOG_TAG = RippleUtils.class.getSimpleName();
    private static final int[] PRESSED_STATE_SET = {16842919};
    private static final int[] SELECTED_PRESSED_STATE_SET = {16842913, 16842919};
    private static final int[] SELECTED_STATE_SET = {16842913};
    @VisibleForTesting
    static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";
    @Deprecated
    public static final boolean USE_FRAMEWORK_RIPPLE = true;

    private static class RippleUtilsLollipop {
        private RippleUtilsLollipop() {
        }

        /* access modifiers changed from: private */
        @DoNotInline
        public static Drawable createOvalRipple(@NonNull Context context, @Px int i5) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            return new RippleDrawable(MaterialColors.getColorStateList(context, R.attr.colorControlHighlight, ColorStateList.valueOf(0)), (Drawable) null, new InsetDrawable(gradientDrawable, i5, i5, i5, i5));
        }
    }

    private RippleUtils() {
    }

    @NonNull
    public static ColorStateList convertToRippleDrawableColor(@Nullable ColorStateList colorStateList) {
        int[] iArr = FOCUSED_STATE_SET;
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, iArr, StateSet.NOTHING}, new int[]{getColorForState(colorStateList, SELECTED_PRESSED_STATE_SET), getColorForState(colorStateList, iArr), getColorForState(colorStateList, PRESSED_STATE_SET)});
    }

    @NonNull
    public static Drawable createOvalRippleLollipop(@NonNull Context context, @Px int i5) {
        return RippleUtilsLollipop.createOvalRipple(context, i5);
    }

    @ColorInt
    private static int doubleAlpha(@ColorInt int i5) {
        return ColorUtils.setAlphaComponent(i5, Math.min(Color.alpha(i5) * 2, 255));
    }

    @ColorInt
    private static int getColorForState(@Nullable ColorStateList colorStateList, int[] iArr) {
        int i5;
        if (colorStateList != null) {
            i5 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i5 = 0;
        }
        return doubleAlpha(i5);
    }

    @NonNull
    public static ColorStateList sanitizeRippleDrawableColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(ENABLED_PRESSED_STATE_SET, 0)) != 0) {
            Log.w(LOG_TAG, TRANSPARENT_DEFAULT_COLOR_WARNING);
        }
        return colorStateList;
    }

    public static boolean shouldDrawRippleCompat(@NonNull int[] iArr) {
        boolean z4 = false;
        boolean z5 = false;
        for (int i5 : iArr) {
            if (i5 == 16842910) {
                z4 = true;
            } else if (i5 == 16842908 || i5 == 16842919 || i5 == 16843623) {
                z5 = true;
            }
        }
        if (!z4 || !z5) {
            return false;
        }
        return true;
    }
}
