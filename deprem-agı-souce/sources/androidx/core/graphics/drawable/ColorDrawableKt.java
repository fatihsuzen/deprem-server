package androidx.core.graphics.drawable;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

public final class ColorDrawableKt {
    public static final ColorDrawable toDrawable(@ColorInt int i5) {
        return new ColorDrawable(i5);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final ColorDrawable toDrawable(Color color) {
        return new ColorDrawable(color.toArgb());
    }
}
