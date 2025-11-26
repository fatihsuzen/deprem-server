package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.privacysandbox.ads.adservices.adid.i;
import com.google.android.gms.common.util.k;

abstract class Q {
    private static SharedPreferences b(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    static boolean c(Context context) {
        return b(context).getBoolean("proxy_notification_initialized", false);
    }

    static boolean d(SharedPreferences sharedPreferences, boolean z4) {
        if (!sharedPreferences.contains("proxy_retention") || sharedPreferences.getBoolean("proxy_retention", false) != z4) {
            return false;
        }
        return true;
    }

    static void e(Context context, boolean z4) {
        SharedPreferences.Editor edit = b(context).edit();
        edit.putBoolean("proxy_notification_initialized", z4);
        edit.apply();
    }

    static void f(Context context, D d5, boolean z4) {
        if (k.g() && !d(b(context), z4)) {
            d5.j(z4).f(new i(), new P(context, z4));
        }
    }

    /* access modifiers changed from: package-private */
    public static void g(Context context, boolean z4) {
        SharedPreferences.Editor edit = b(context).edit();
        edit.putBoolean("proxy_retention", z4);
        edit.apply();
    }
}
