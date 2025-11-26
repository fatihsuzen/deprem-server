package com.mbridge.msdk.e;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.MBConfiguration;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f8762a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Boolean f8763b;

    public static boolean a() {
        boolean z4;
        if (f8762a == null) {
            try {
                if (Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                f8762a = Boolean.valueOf(z4);
                return z4;
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonUtils", "isChina", e5);
                }
            }
        }
        if (f8762a == null || !f8762a.booleanValue()) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        boolean z4;
        if (f8763b == null) {
            try {
                if (Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                f8763b = Boolean.valueOf(z4);
                return z4;
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonUtils", "isOversea", e5);
                }
            }
        }
        if (f8763b == null || !f8763b.booleanValue()) {
            return false;
        }
        return true;
    }
}
