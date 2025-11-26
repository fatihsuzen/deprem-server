package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.resources.MaterialAttributes;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeEnforcement {
    private static final int[] APPCOMPAT_CHECK_ATTRS = {R.attr.colorPrimary};
    private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final int[] MATERIAL_CHECK_ATTRS = {com.google.android.material.R.attr.colorPrimaryVariant};
    private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";

    private ThemeEnforcement() {
    }

    public static void checkAppCompatTheme(@NonNull Context context) {
        checkTheme(context, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    private static void checkCompatibleTheme(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ThemeEnforcement, i5, i6);
        boolean z4 = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z4) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(com.google.android.material.R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                checkMaterialTheme(context);
            }
        }
        checkAppCompatTheme(context);
    }

    public static void checkMaterialTheme(@NonNull Context context) {
        checkTheme(context, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    private static void checkTextAppearance(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i5, @StyleRes int i6, @StyleableRes @Nullable int... iArr2) {
        boolean z4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ThemeEnforcement, i5, i6);
        boolean z5 = false;
        if (!obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            if (obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1) {
                z5 = true;
            }
            z4 = z5;
        } else {
            z4 = isCustomTextAppearanceValid(context, attributeSet, iArr, i5, i6, iArr2);
        }
        obtainStyledAttributes.recycle();
        if (!z4) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void checkTheme(@NonNull Context context, @NonNull int[] iArr, String str) {
        if (!isTheme(context, iArr)) {
            throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
        }
    }

    public static boolean isAppCompatTheme(@NonNull Context context) {
        return isTheme(context, APPCOMPAT_CHECK_ATTRS);
    }

    private static boolean isCustomTextAppearanceValid(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i5, @StyleRes int i6, @StyleableRes @NonNull int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, i6);
        for (int resourceId : iArr2) {
            if (obtainStyledAttributes.getResourceId(resourceId, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static boolean isMaterial3Theme(@NonNull Context context) {
        return MaterialAttributes.resolveBoolean(context, com.google.android.material.R.attr.isMaterial3Theme, false);
    }

    public static boolean isMaterialTheme(@NonNull Context context) {
        return isTheme(context, MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(@NonNull Context context, @NonNull int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (!obtainStyledAttributes.hasValue(i5)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    @NonNull
    public static TypedArray obtainStyledAttributes(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i5, @StyleRes int i6, @StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i5, i6);
        checkTextAppearance(context, attributeSet, iArr, i5, i6, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i5, i6);
    }

    public static TintTypedArray obtainTintedStyledAttributes(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i5, @StyleRes int i6, @StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i5, i6);
        checkTextAppearance(context, attributeSet, iArr, i5, i6, iArr2);
        return TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i5, i6);
    }
}
