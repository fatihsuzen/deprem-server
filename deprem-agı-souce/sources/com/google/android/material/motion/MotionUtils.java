package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.graphics.PathParser;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

public class MotionUtils {
    private static final String EASING_TYPE_CUBIC_BEZIER = "cubic-bezier";
    private static final String EASING_TYPE_FORMAT_END = ")";
    private static final String EASING_TYPE_FORMAT_START = "(";
    private static final String EASING_TYPE_PATH = "path";

    private MotionUtils() {
    }

    private static float getLegacyControlPoint(String[] strArr, int i5) {
        float parseFloat = Float.parseFloat(strArr[i5]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    private static String getLegacyEasingContent(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static TimeInterpolator getLegacyThemeInterpolator(String str) {
        if (isLegacyEasingType(str, EASING_TYPE_CUBIC_BEZIER)) {
            String[] split = getLegacyEasingContent(str, EASING_TYPE_CUBIC_BEZIER).split(",");
            if (split.length == 4) {
                return new PathInterpolator(getLegacyControlPoint(split, 0), getLegacyControlPoint(split, 1), getLegacyControlPoint(split, 2), getLegacyControlPoint(split, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
        } else if (isLegacyEasingType(str, "path")) {
            return new PathInterpolator(PathParser.createPathFromPathData(getLegacyEasingContent(str, "path")));
        } else {
            throw new IllegalArgumentException("Invalid motion easing type: " + str);
        }
    }

    private static boolean isLegacyEasingAttribute(String str) {
        if (isLegacyEasingType(str, EASING_TYPE_CUBIC_BEZIER) || isLegacyEasingType(str, "path")) {
            return true;
        }
        return false;
    }

    private static boolean isLegacyEasingType(String str, String str2) {
        if (!str.startsWith(str2 + EASING_TYPE_FORMAT_START) || !str.endsWith(EASING_TYPE_FORMAT_END)) {
            return false;
        }
        return true;
    }

    public static int resolveThemeDuration(@NonNull Context context, @AttrRes int i5, int i6) {
        return MaterialAttributes.resolveInteger(context, i5, i6);
    }

    @NonNull
    public static TimeInterpolator resolveThemeInterpolator(@NonNull Context context, @AttrRes int i5, @NonNull TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i5, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            if (isLegacyEasingAttribute(valueOf)) {
                return getLegacyThemeInterpolator(valueOf);
            }
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }

    @NonNull
    public static SpringForce resolveThemeSpringForce(@NonNull Context context, @AttrRes int i5, @StyleRes int i6) {
        TypedArray typedArray;
        TypedValue resolve = MaterialAttributes.resolve(context, i5);
        if (resolve == null) {
            typedArray = context.obtainStyledAttributes((AttributeSet) null, R.styleable.MaterialSpring, 0, i6);
        } else {
            typedArray = context.obtainStyledAttributes(resolve.resourceId, R.styleable.MaterialSpring);
        }
        SpringForce springForce = new SpringForce();
        try {
            float f5 = typedArray.getFloat(R.styleable.MaterialSpring_stiffness, Float.MIN_VALUE);
            if (f5 != Float.MIN_VALUE) {
                float f6 = typedArray.getFloat(R.styleable.MaterialSpring_damping, Float.MIN_VALUE);
                if (f6 != Float.MIN_VALUE) {
                    springForce.setStiffness(f5);
                    springForce.setDampingRatio(f6);
                    return springForce;
                }
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
        } finally {
            typedArray.recycle();
        }
    }
}
