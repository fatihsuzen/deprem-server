package com.mbridge.msdk.foundation.tools;

import android.net.ConnectivityManager;
import com.mbridge.msdk.foundation.controller.c;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static ConnectivityManager f9750a;

    public static synchronized ConnectivityManager a() {
        ConnectivityManager connectivityManager;
        synchronized (w.class) {
            try {
                if (f9750a == null && c.m().c() != null) {
                    f9750a = (ConnectivityManager) c.m().c().getSystemService("connectivity");
                }
            } catch (Exception e5) {
                af.b("NetManager", e5.getMessage());
            }
            connectivityManager = f9750a;
        }
        return connectivityManager;
    }
}
