package com.mbridge.msdk.foundation.controller.authoritycontroller;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;

public class c extends b {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f8854c;

    private c() {
        c();
    }

    public static void c(boolean z4) {
    }

    public static c j() {
        if (f8854c == null) {
            synchronized (c.class) {
                try {
                    if (f8854c == null) {
                        f8854c = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8854c;
    }

    public static boolean k() {
        return true;
    }

    public final int b(String str) {
        g b5 = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (b5 == null) {
            h.a();
            b5 = i.a();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return b5.aw();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return b5.av();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            return b5.ax();
        }
        return -1;
    }

    public final boolean c(String str) {
        boolean z4;
        boolean z5;
        g b5 = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (b5 == null) {
            h.a();
            b5 = i.a();
            z4 = true;
        } else {
            z4 = false;
        }
        int ak = b5.ak();
        if (ak != 0 ? !(ak == 1 && b(str) == 1) : !(a(str) == 1 && b(str) == 1)) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            z5 = a(str) == 1;
        }
        if (!str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID) || j().g() != 2) {
            return z5;
        }
        return !b5.aH() && !z4 && a(str) == 1;
    }
}
