package com.google.android.gms.common.util;

import N.C0722p;
import android.content.Context;
import android.util.Log;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4875a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    public static boolean a(Context context, Throwable th) {
        try {
            C0722p.k(context);
            C0722p.k(th);
            return false;
        } catch (Exception e5) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e5);
            return false;
        }
    }
}
