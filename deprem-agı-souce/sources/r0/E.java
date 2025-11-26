package r0;

public abstract class E {
    public static void a(boolean z4, String str) {
        if (!z4) {
            throw new IllegalArgumentException(str);
        }
    }

    public static Object b(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static void d(boolean z4, String str) {
        if (!z4) {
            throw new IllegalStateException(str);
        }
    }
}
