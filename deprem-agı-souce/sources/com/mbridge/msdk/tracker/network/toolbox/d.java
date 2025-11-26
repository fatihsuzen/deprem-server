package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import com.mbridge.msdk.tracker.network.u;

public final class d {
    public static String a(String str, u<?> uVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return "";
        }
        byte[] p5 = uVar.p();
        if (p5 == null || p5.length == 0) {
            return str;
        }
        if (str.endsWith("?")) {
            return str + new String(p5);
        }
        return str + "?" + new String(p5);
    }
}
