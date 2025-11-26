package com.google.android.gms.common.util;

import K.C0666m;
import T.e;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

public abstract class p {
    public static boolean a(Context context, int i5) {
        if (!b(context, i5, "com.google.android.gms")) {
            return false;
        }
        try {
            return C0666m.a(context).b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return false;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return false;
        }
    }

    public static boolean b(Context context, int i5, String str) {
        return e.a(context).g(i5, str);
    }
}
