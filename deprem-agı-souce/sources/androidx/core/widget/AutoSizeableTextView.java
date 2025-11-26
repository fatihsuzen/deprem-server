package androidx.core.widget;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface AutoSizeableTextView {
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE;

    static {
        boolean z4;
        if (Build.VERSION.SDK_INT >= 27) {
            z4 = true;
        } else {
            z4 = false;
        }
        PLATFORM_SUPPORTS_AUTOSIZE = z4;
    }

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int i5, int i6, int i7, int i8) throws IllegalArgumentException;

    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i5) throws IllegalArgumentException;

    void setAutoSizeTextTypeWithDefaults(int i5);
}
