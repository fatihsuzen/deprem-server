package com.mbridge.msdk.newreward.function.h;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ak;

public final class d {
    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return SameMD5.getMD5(ak.d());
        }
        try {
            String[] split = str.split("_");
            if (split == null || split.length < 3) {
                str2 = "";
            } else {
                str2 = split[2];
            }
            if (TextUtils.isEmpty(str2)) {
                return SameMD5.getMD5(ak.d());
            }
            return str2;
        } catch (Exception unused) {
            return SameMD5.getMD5(ak.d());
        }
    }
}
