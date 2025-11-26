package androidx.datastore.preferences.protobuf;

final class Android {
    private static boolean ASSUME_ANDROID;
    private static final boolean IS_ROBOLECTRIC;
    private static final Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");

    static {
        boolean z4;
        if (ASSUME_ANDROID || getClassForName("org.robolectric.Robolectric") == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        IS_ROBOLECTRIC = z4;
    }

    private Android() {
    }

    private static <T> Class<T> getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    static boolean isOnAndroidDevice() {
        if (ASSUME_ANDROID) {
            return true;
        }
        if (MEMORY_CLASS == null || IS_ROBOLECTRIC) {
            return false;
        }
        return true;
    }
}
