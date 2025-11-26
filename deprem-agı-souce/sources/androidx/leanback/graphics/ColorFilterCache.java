package androidx.leanback.graphics;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.SparseArray;

public final class ColorFilterCache {
    private static final SparseArray<ColorFilterCache> sColorToFiltersMap = new SparseArray<>();
    private final PorterDuffColorFilter[] mFilters = new PorterDuffColorFilter[256];

    private ColorFilterCache(int i5, int i6, int i7) {
        for (int i8 = 0; i8 <= 255; i8++) {
            this.mFilters[i8] = new PorterDuffColorFilter(Color.argb(i8, i5, i6, i7), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static ColorFilterCache getColorFilterCache(int i5) {
        int red = Color.red(i5);
        int green = Color.green(i5);
        int blue = Color.blue(i5);
        int rgb = Color.rgb(red, green, blue);
        SparseArray<ColorFilterCache> sparseArray = sColorToFiltersMap;
        ColorFilterCache colorFilterCache = sparseArray.get(rgb);
        if (colorFilterCache != null) {
            return colorFilterCache;
        }
        ColorFilterCache colorFilterCache2 = new ColorFilterCache(red, green, blue);
        sparseArray.put(rgb, colorFilterCache2);
        return colorFilterCache2;
    }

    public ColorFilter getFilterForLevel(float f5) {
        if (f5 < 0.0f || ((double) f5) > 1.0d) {
            return null;
        }
        return this.mFilters[(int) (f5 * 255.0f)];
    }
}
