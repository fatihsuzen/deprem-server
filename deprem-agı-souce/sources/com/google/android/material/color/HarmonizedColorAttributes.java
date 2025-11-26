package com.google.android.material.color;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;

public final class HarmonizedColorAttributes {
    private static final int[] HARMONIZED_MATERIAL_ATTRIBUTES = {R.attr.colorError, com.google.android.material.R.attr.colorOnError, com.google.android.material.R.attr.colorErrorContainer, com.google.android.material.R.attr.colorOnErrorContainer};
    private final int[] attributes;
    @StyleRes
    private final int themeOverlay;

    private HarmonizedColorAttributes(@AttrRes @NonNull int[] iArr, @StyleRes int i5) {
        if (i5 == 0 || iArr.length != 0) {
            this.attributes = iArr;
            this.themeOverlay = i5;
            return;
        }
        throw new IllegalArgumentException("Theme overlay should be used with the accompanying int[] attributes.");
    }

    @NonNull
    public static HarmonizedColorAttributes create(@AttrRes @NonNull int[] iArr) {
        return new HarmonizedColorAttributes(iArr, 0);
    }

    @NonNull
    public static HarmonizedColorAttributes createMaterialDefaults() {
        return create(HARMONIZED_MATERIAL_ATTRIBUTES, com.google.android.material.R.style.ThemeOverlay_Material3_HarmonizedColors);
    }

    @NonNull
    public int[] getAttributes() {
        return this.attributes;
    }

    @StyleRes
    public int getThemeOverlay() {
        return this.themeOverlay;
    }

    @NonNull
    public static HarmonizedColorAttributes create(@AttrRes @NonNull int[] iArr, @StyleRes int i5) {
        return new HarmonizedColorAttributes(iArr, i5);
    }
}
