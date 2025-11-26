package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;

public final class ap {
    public static boolean a(String str) {
        if (str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean b(String str) {
        if (str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str)) {
            return false;
        }
        return true;
    }
}
