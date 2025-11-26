package l0;

public abstract class h {
    private static String a(int i5, int i6, String str) {
        if (i5 < 0) {
            return j.a("%s (%s) must not be negative", str, Integer.valueOf(i5));
        } else if (i6 >= 0) {
            return j.a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        } else {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i6);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static String b(int i5, int i6, String str) {
        if (i5 < 0) {
            return j.a("%s (%s) must not be negative", str, Integer.valueOf(i5));
        } else if (i6 >= 0) {
            return j.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        } else {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i6);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static String c(int i5, int i6, int i7) {
        if (i5 < 0 || i5 > i7) {
            return b(i5, i7, "start index");
        }
        if (i6 < 0 || i6 > i7) {
            return b(i6, i7, "end index");
        }
        return j.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5));
    }

    public static void d(boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int f(int i5, int i6) {
        return g(i5, i6, "index");
    }

    public static int g(int i5, int i6, String str) {
        if (i5 >= 0 && i5 < i6) {
            return i5;
        }
        throw new IndexOutOfBoundsException(a(i5, i6, str));
    }

    public static Object h(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object i(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static int j(int i5, int i6) {
        return k(i5, i6, "index");
    }

    public static int k(int i5, int i6, String str) {
        if (i5 >= 0 && i5 <= i6) {
            return i5;
        }
        throw new IndexOutOfBoundsException(b(i5, i6, str));
    }

    public static void l(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException(c(i5, i6, i7));
        }
    }

    public static void m(boolean z4) {
        if (!z4) {
            throw new IllegalStateException();
        }
    }

    public static void n(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void o(boolean z4, String str, Object obj) {
        if (!z4) {
            throw new IllegalStateException(j.a(str, obj));
        }
    }
}
