package v;

import android.os.Build;
import android.util.Log;

/* renamed from: v.a  reason: case insensitive filesystem */
public abstract class C1892a {
    private static String a(String str, String str2) {
        String str3 = str + str2;
        if (str3.length() > 23) {
            return str3.substring(0, 23);
        }
        return str3;
    }

    public static void b(String str, String str2, Object obj) {
        String e5 = e(str);
        if (Log.isLoggable(e5, 3)) {
            Log.d(e5, String.format(str2, new Object[]{obj}));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        String e5 = e(str);
        if (Log.isLoggable(e5, 3)) {
            Log.d(e5, String.format(str2, objArr));
        }
    }

    public static void d(String str, String str2, Throwable th) {
        String e5 = e(str);
        if (Log.isLoggable(e5, 6)) {
            Log.e(e5, str2, th);
        }
    }

    private static String e(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return a("TRuntime.", str);
        }
        return "TRuntime." + str;
    }

    public static void f(String str, String str2, Object obj) {
        String e5 = e(str);
        if (Log.isLoggable(e5, 4)) {
            Log.i(e5, String.format(str2, new Object[]{obj}));
        }
    }

    public static void g(String str, String str2, Object obj) {
        String e5 = e(str);
        if (Log.isLoggable(e5, 5)) {
            Log.w(e5, String.format(str2, new Object[]{obj}));
        }
    }
}
