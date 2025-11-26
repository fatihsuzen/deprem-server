package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.FontResourcesParserCompat;
import java.lang.reflect.Field;

@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi14 {
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock = new Object();
    @GuardedBy("sWeightCacheLock")
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = new LongSparseArray<>(3);

    static {
        Field field;
        try {
            field = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);
            field.setAccessible(true);
        } catch (Exception e5) {
            Log.e(TAG, e5.getClass().getName(), e5);
            field = null;
        }
        sNativeInstance = field;
    }

    private WeightTypefaceApi14() {
    }

    @Nullable
    static Typeface createWeightStyle(@NonNull TypefaceCompatBaseImpl typefaceCompatBaseImpl, @NonNull Context context, @NonNull Typeface typeface, int i5, boolean z4) {
        if (!isPrivateApiAvailable()) {
            return null;
        }
        boolean z5 = (i5 << 1) | z4;
        synchronized (sWeightCacheLock) {
            try {
                long nativeInstance = getNativeInstance(typeface);
                LongSparseArray<SparseArray<Typeface>> longSparseArray = sWeightTypefaceCache;
                SparseArray sparseArray = longSparseArray.get(nativeInstance);
                if (sparseArray == null) {
                    sparseArray = new SparseArray(4);
                    longSparseArray.put(nativeInstance, sparseArray);
                } else {
                    Typeface typeface2 = (Typeface) sparseArray.get(z5);
                    if (typeface2 != null) {
                        return typeface2;
                    }
                }
                Typeface bestFontFromFamily = getBestFontFromFamily(typefaceCompatBaseImpl, context, typeface, i5, z4);
                if (bestFontFromFamily == null) {
                    bestFontFromFamily = platformTypefaceCreate(typeface, i5, z4);
                }
                sparseArray.put(z5 ? 1 : 0, bestFontFromFamily);
                return bestFontFromFamily;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    private static Typeface getBestFontFromFamily(@NonNull TypefaceCompatBaseImpl typefaceCompatBaseImpl, @NonNull Context context, @NonNull Typeface typeface, int i5, boolean z4) {
        FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamily = typefaceCompatBaseImpl.getFontFamily(typeface);
        if (fontFamily == null) {
            return null;
        }
        return typefaceCompatBaseImpl.createFromFontFamilyFilesResourceEntry(context, fontFamily, context.getResources(), i5, z4);
    }

    private static long getNativeInstance(@NonNull Typeface typeface) {
        try {
            return ((Number) sNativeInstance.get(typeface)).longValue();
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        }
    }

    private static boolean isPrivateApiAvailable() {
        if (sNativeInstance != null) {
            return true;
        }
        return false;
    }

    private static Typeface platformTypefaceCreate(Typeface typeface, int i5, boolean z4) {
        boolean z5;
        int i6 = 0;
        if (i5 >= 600) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 || z4) {
            if (!z5) {
                i6 = 2;
            } else if (!z4) {
                i6 = 1;
            } else {
                i6 = 3;
            }
        }
        return Typeface.create(typeface, i6);
    }
}
