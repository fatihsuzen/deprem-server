package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.SharedPreferences;

public final class am {
    public static void a(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        if (context != null) {
            SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("share_date_setting_filter", 0).edit();
            if ("String".equals(simpleName)) {
                edit.putString(str, (String) obj);
            } else if ("Integer".equals(simpleName)) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if ("Boolean".equals(simpleName)) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if ("Float".equals(simpleName)) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if ("Long".equals(simpleName)) {
                edit.putLong(str, ((Long) obj).longValue());
            }
            edit.apply();
        }
    }
}
