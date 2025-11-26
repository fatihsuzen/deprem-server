package com.google.android.material.theme.overlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.ContextThemeWrapper;

public class MaterialThemeOverlay {
    private static final int[] ANDROID_THEME_OVERLAY_ATTRS = {16842752, R.attr.theme};
    private static final int[] MATERIAL_THEME_OVERLAY_ATTR = {com.google.android.material.R.attr.materialThemeOverlay};

    private MaterialThemeOverlay() {
    }

    @StyleRes
    private static int obtainAndroidThemeOverlayId(@NonNull Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ANDROID_THEME_OVERLAY_ATTRS);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return resourceId;
        }
        return resourceId2;
    }

    @NonNull
    private static int[] obtainMaterialOverlayIds(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull int[] iArr, @AttrRes int i5, @StyleRes int i6) {
        int[] iArr2 = new int[iArr.length];
        if (iArr.length > 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, i6);
            for (int i7 = 0; i7 < iArr.length; i7++) {
                iArr2[i7] = obtainStyledAttributes.getResourceId(i7, 0);
            }
            obtainStyledAttributes.recycle();
        }
        return iArr2;
    }

    @StyleRes
    private static int obtainMaterialThemeOverlayId(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        return obtainMaterialOverlayIds(context, attributeSet, MATERIAL_THEME_OVERLAY_ATTR, i5, i6)[0];
    }

    @NonNull
    public static Context wrap(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        return wrap(context, attributeSet, i5, i6, new int[0]);
    }

    @NonNull
    public static Context wrap(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6, @NonNull int[] iArr) {
        int obtainMaterialThemeOverlayId = obtainMaterialThemeOverlayId(context, attributeSet, i5, i6);
        boolean z4 = (context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == obtainMaterialThemeOverlayId;
        if (obtainMaterialThemeOverlayId == 0 || z4) {
            return context;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, obtainMaterialThemeOverlayId);
        for (int i7 : obtainMaterialOverlayIds(context, attributeSet, iArr, i5, i6)) {
            if (i7 != 0) {
                contextThemeWrapper.getTheme().applyStyle(i7, true);
            }
        }
        int obtainAndroidThemeOverlayId = obtainAndroidThemeOverlayId(context, attributeSet);
        if (obtainAndroidThemeOverlayId != 0) {
            contextThemeWrapper.getTheme().applyStyle(obtainAndroidThemeOverlayId, true);
        }
        return contextThemeWrapper;
    }
}
