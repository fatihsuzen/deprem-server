package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;

public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    private GravityCompat() {
    }

    public static void apply(int i5, int i6, int i7, @NonNull Rect rect, @NonNull Rect rect2, int i8) {
        Gravity.apply(i5, i6, i7, rect, rect2, i8);
    }

    public static void applyDisplay(int i5, @NonNull Rect rect, @NonNull Rect rect2, int i6) {
        Gravity.applyDisplay(i5, rect, rect2, i6);
    }

    public static int getAbsoluteGravity(int i5, int i6) {
        return Gravity.getAbsoluteGravity(i5, i6);
    }

    public static void apply(int i5, int i6, int i7, @NonNull Rect rect, int i8, int i9, @NonNull Rect rect2, int i10) {
        Gravity.apply(i5, i6, i7, rect, i8, i9, rect2, i10);
    }
}
