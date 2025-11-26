package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;

public final class an {

    /* renamed from: a  reason: collision with root package name */
    static FastKV f9665a;

    public static Object a(Context context, String str, Object obj) {
        String str2;
        if (context != null) {
            if (obj != null) {
                str2 = obj.getClass().getSimpleName();
            } else {
                str2 = "";
            }
            d.a();
            if (f9665a == null) {
                try {
                    f9665a = new FastKV.Builder(e.a(c.MBRIDGE_700_CONFIG), "share_date").build();
                } catch (Exception unused) {
                    f9665a = null;
                }
            }
            if (f9665a != null) {
                try {
                    if ("String".equals(str2)) {
                        return f9665a.getString(str, (String) obj);
                    }
                    if ("Integer".equals(str2)) {
                        return Integer.valueOf(f9665a.getInt(str, ((Integer) obj).intValue()));
                    }
                    if ("Boolean".equals(str2)) {
                        return Boolean.valueOf(f9665a.getBoolean(str, ((Boolean) obj).booleanValue()));
                    }
                    if ("Float".equals(str2)) {
                        return Float.valueOf(f9665a.getFloat(str, ((Float) obj).floatValue()));
                    }
                    if ("Long".equals(str2)) {
                        return Long.valueOf(f9665a.getLong(str, ((Long) obj).longValue()));
                    }
                } catch (Exception unused2) {
                }
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("share_date", 0);
                if ("String".equals(str2)) {
                    return sharedPreferences.getString(str, (String) obj);
                }
                if ("Integer".equals(str2)) {
                    return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
                }
                if ("Boolean".equals(str2)) {
                    return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
                }
                if ("Float".equals(str2)) {
                    return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
                }
                if ("Long".equals(str2)) {
                    return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
                }
            }
        }
        return obj;
    }

    public static void b(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        if (context != null) {
            d.a();
            if (f9665a == null) {
                try {
                    f9665a = new FastKV.Builder(e.a(c.MBRIDGE_700_CONFIG), "share_date").build();
                } catch (Exception unused) {
                    f9665a = null;
                }
            }
            if (f9665a != null) {
                try {
                    if ("String".equals(simpleName)) {
                        f9665a.putString(str, (String) obj);
                    } else if ("Integer".equals(simpleName)) {
                        f9665a.putInt(str, ((Integer) obj).intValue());
                    } else if ("Boolean".equals(simpleName)) {
                        f9665a.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if ("Float".equals(simpleName)) {
                        f9665a.putFloat(str, ((Float) obj).floatValue());
                    } else if ("Long".equals(simpleName)) {
                        f9665a.putLong(str, ((Long) obj).longValue());
                    }
                } catch (Exception unused2) {
                }
            } else {
                SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("share_date", 0).edit();
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
}
