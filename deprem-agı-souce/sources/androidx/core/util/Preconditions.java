package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException();
        }
    }

    public static float checkArgumentFinite(float f5, @NonNull String str) {
        if (Float.isNaN(f5)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        } else if (!Float.isInfinite(f5)) {
            return f5;
        } else {
            throw new IllegalArgumentException(str + " must not be infinite");
        }
    }

    public static int checkArgumentInRange(int i5, int i6, int i7, @NonNull String str) {
        if (i5 < i6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i7)}));
        } else if (i5 <= i7) {
            return i5;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i7)}));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i5, @Nullable String str) {
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i5, int i6) {
        if ((i5 & i6) == i5) {
            return i5;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i5) + ", but only 0x" + Integer.toHexString(i6) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t5) {
        t5.getClass();
        return t5;
    }

    public static void checkState(boolean z4, @Nullable String str) {
        if (!z4) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t5) {
        if (!TextUtils.isEmpty(t5)) {
            return t5;
        }
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean z4, @NonNull Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i5) {
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t5, @NonNull Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z4) {
        checkState(z4, (String) null);
    }

    public static void checkArgument(boolean z4, @NonNull String str, @NonNull Object... objArr) {
        if (!z4) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t5, @NonNull Object obj) {
        if (!TextUtils.isEmpty(t5)) {
            return t5;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t5, @NonNull String str, @NonNull Object... objArr) {
        if (!TextUtils.isEmpty(t5)) {
            return t5;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static long checkArgumentInRange(long j5, long j6, long j7, @NonNull String str) {
        if (j5 < j6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Long.valueOf(j6), Long.valueOf(j7)}));
        } else if (j5 <= j7) {
            return j5;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Long.valueOf(j6), Long.valueOf(j7)}));
        }
    }

    public static float checkArgumentInRange(float f5, float f6, float f7, @NonNull String str) {
        if (f5 < f6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{str, Float.valueOf(f6), Float.valueOf(f7)}));
        } else if (f5 <= f7) {
            return f5;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{str, Float.valueOf(f6), Float.valueOf(f7)}));
        }
    }

    public static double checkArgumentInRange(double d5, double d6, double d7, @NonNull String str) {
        if (d5 < d6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{str, Double.valueOf(d6), Double.valueOf(d7)}));
        } else if (d5 <= d7) {
            return d5;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{str, Double.valueOf(d6), Double.valueOf(d7)}));
        }
    }
}
