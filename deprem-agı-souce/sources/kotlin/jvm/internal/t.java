package kotlin.jvm.internal;

import W2.C2220i;
import W2.I;
import java.util.Arrays;

public abstract class t {
    public static boolean a(Object obj, Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        if (obj2 == null) {
            return true;
        }
        return false;
    }

    public static void b(Object obj) {
        if (obj == null) {
            o();
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            p(str);
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) l(new NullPointerException(str + " must not be null")));
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            s(str);
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            r(str);
        }
    }

    public static int g(int i5, int i6) {
        if (i5 < i6) {
            return -1;
        }
        return i5 == i6 ? 0 : 1;
    }

    public static int h(long j5, long j6) {
        int i5 = (j5 > j6 ? 1 : (j5 == j6 ? 0 : -1));
        if (i5 < 0) {
            return -1;
        }
        return i5 == 0 ? 0 : 1;
    }

    private static String i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = t.class.getName();
        int i5 = 0;
        while (!stackTrace[i5].getClassName().equals(name)) {
            i5++;
        }
        while (stackTrace[i5].getClassName().equals(name)) {
            i5++;
        }
        StackTraceElement stackTraceElement = stackTrace[i5];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static void j() {
        t();
    }

    public static void k(int i5, String str) {
        t();
    }

    private static Throwable l(Throwable th) {
        return m(th, t.class.getName());
    }

    static Throwable m(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i5 = -1;
        for (int i6 = 0; i6 < length; i6++) {
            if (str.equals(stackTrace[i6].getClassName())) {
                i5 = i6;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i5 + 1, length));
        return th;
    }

    public static String n(String str, Object obj) {
        return str + obj;
    }

    public static void o() {
        throw ((NullPointerException) l(new NullPointerException()));
    }

    public static void p(String str) {
        throw ((NullPointerException) l(new NullPointerException(str)));
    }

    public static void q() {
        throw ((C2220i) l(new C2220i()));
    }

    private static void r(String str) {
        throw ((IllegalArgumentException) l(new IllegalArgumentException(i(str))));
    }

    private static void s(String str) {
        throw ((NullPointerException) l(new NullPointerException(i(str))));
    }

    public static void t() {
        u("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void u(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void v(String str) {
        throw ((I) l(new I(str)));
    }

    public static void w(String str) {
        v("lateinit property " + str + " has not been initialized");
    }
}
