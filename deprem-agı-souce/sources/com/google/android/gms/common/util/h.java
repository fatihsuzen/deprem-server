package com.google.android.gms.common.util;

import K.C0665l;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f4877a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f4878b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f4879c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f4880d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f4880d == null) {
            boolean z4 = false;
            if (k.e() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z4 = true;
            }
            f4880d = Boolean.valueOf(z4);
        }
        return f4880d.booleanValue();
    }

    public static boolean b() {
        int i5 = C0665l.f2721a;
        return "user".equals(Build.TYPE);
    }

    public static boolean c(Context context) {
        return g(context.getPackageManager());
    }

    public static boolean d(Context context) {
        if (c(context) && !k.d()) {
            return true;
        }
        if (!e(context)) {
            return false;
        }
        if (!k.e() || k.h()) {
            return true;
        }
        return false;
    }

    public static boolean e(Context context) {
        if (f4878b == null) {
            f4878b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f4878b.booleanValue();
    }

    public static boolean f(Context context) {
        if (f4879c == null) {
            boolean z4 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z4 = false;
            }
            f4879c = Boolean.valueOf(z4);
        }
        return f4879c.booleanValue();
    }

    public static boolean g(PackageManager packageManager) {
        if (f4877a == null) {
            f4877a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f4877a.booleanValue();
    }
}
