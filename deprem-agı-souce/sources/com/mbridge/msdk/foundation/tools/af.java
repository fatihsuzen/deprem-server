package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9609a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f9610b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f9611c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f9612d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f9613e = false;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f9614f = false;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f9615g = false;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f9616h = false;

    static {
        if (!MBridgeConstans.DEBUG) {
        }
    }

    public static void a(String str, String str2) {
        if (f9609a && !TextUtils.isEmpty(str2)) {
            Log.d(a(str), str2);
        }
    }

    public static void b(String str, String str2) {
        if (f9610b && str2 != null) {
            Log.e(a(str), str2);
        }
    }

    public static void c(String str, String str2) {
        if (f9611c && !TextUtils.isEmpty(str2)) {
            Log.i(a(str), str2);
        }
    }

    public static void d(String str, String str2) {
        if (f9616h && !TextUtils.isEmpty(str2)) {
            Log.w(a(str), str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f9610b && str2 != null && th != null) {
            Log.e(a(str), str2, th);
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "MBRIDGE_" + str;
    }

    public static void c(String str, String str2, Throwable th) {
        if (f9616h && !TextUtils.isEmpty(str2)) {
            Log.w(a(str), str2, th);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f9609a && !TextUtils.isEmpty(str2)) {
            Log.d(a(str), str2, th);
        }
    }

    public static void a(String str, Throwable th) {
        if (f9616h && th != null) {
            Log.w(a(str), th);
        }
    }
}
