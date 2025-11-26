package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import j$.util.Objects;

public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int hash(@Nullable Object... objArr) {
        return Objects.hash(objArr);
    }

    public static int hashCode(@Nullable Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T t5) {
        t5.getClass();
        return t5;
    }

    @Nullable
    public static String toString(@Nullable Object obj, @Nullable String str) {
        if (obj != null) {
            return obj.toString();
        }
        return str;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T t5, @NonNull String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }
}
