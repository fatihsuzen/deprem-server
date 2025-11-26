package com.mbridge.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.a.a.a;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8013a = "h";

    /* renamed from: b  reason: collision with root package name */
    private static volatile h f8014b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile g f8015c;

    /* renamed from: d  reason: collision with root package name */
    private static HashMap<String, k> f8016d = new HashMap<>();

    private h() {
    }

    public static void a(Context context, String str) {
        FastKV fastKV;
        d.a();
        Map<String, Object> map = null;
        try {
            fastKV = new FastKV.Builder(e.a(c.MBRIDGE_700_CONFIG), "mbridge").build();
        } catch (Exception unused) {
            fastKV = null;
        }
        if (fastKV != null) {
            try {
                map = fastKV.getAll();
            } catch (Exception unused2) {
            }
            if (map != null) {
                try {
                    for (String next : map.keySet()) {
                        if (next.startsWith(str + "_")) {
                            f8016d.put(next, k.g((String) map.get(next)));
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        } else {
            try {
                Map<String, ?> all = context.getSharedPreferences("mbridge", 0).getAll();
                for (String next2 : all.keySet()) {
                    if (next2.startsWith(str + "_")) {
                        f8016d.put(next2, k.g((String) all.get(next2)));
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    private k i(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.c.m().k();
        }
        String str3 = str + "_" + str2;
        if (f8016d.containsKey(str3)) {
            return f8016d.get(str3);
        }
        k kVar = null;
        try {
            kVar = k.g(a.a().a(str3));
            f8016d.put(str3, kVar);
            return kVar;
        } catch (Exception e5) {
            e5.printStackTrace();
            return kVar;
        }
    }

    public final g b(String str) {
        if (f8015c == null) {
            try {
                String a5 = a.a().a(str);
                if (!TextUtils.isEmpty(a5)) {
                    JSONObject jSONObject = new JSONObject(a5);
                    if (jSONObject.has(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        jSONObject.remove(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                    }
                    if (jSONObject.has("c")) {
                        jSONObject.remove("c");
                    }
                    f8015c = g.e(jSONObject.toString());
                    if (f8015c != null) {
                        f8015c.aL();
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return f8015c;
    }

    public final String c(String str) {
        a a5 = a.a();
        return a5.a("ivreward_" + str);
    }

    public final k d(String str, String str2) {
        k i5 = i(str, str2);
        if (i5 != null && i5.v() == 0) {
            i5.a(1);
        }
        return i5;
    }

    public final boolean e(String str, String str2) {
        g b5 = b(str2);
        if (d(str2) && a(str2, 1, str)) {
            new j().b(com.mbridge.msdk.foundation.controller.c.m().c(), str2, com.mbridge.msdk.foundation.controller.c.m().b());
        }
        k d5 = d(str2, str);
        if (!(b5 == null || d5 == null)) {
            long currentTimeMillis = System.currentTimeMillis();
            long i5 = d5.i() + (b5.at() * 1000);
            if (i5 > currentTimeMillis) {
                String str3 = f8013a;
                af.c(str3, "unit setting  nexttime is not ready  [settingNextRequestTime= " + i5 + " currentTime = " + currentTimeMillis + "]");
                return false;
            }
        }
        af.c(f8013a, "unit setting timeout or not exists");
        return true;
    }

    public final void f(String str, String str2) {
        a a5 = a.a();
        a5.a("ivreward_" + str, str2);
    }

    public final String g(String str) {
        if (str == null) {
            return "";
        }
        try {
            String a5 = a.a().a(str);
            if (a5 == null) {
                return "";
            }
            return a5;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return "";
        }
    }

    public final void h(String str, String str2) {
        try {
            a a5 = a.a();
            String a6 = a5.a(str + "_" + str2);
            if (!TextUtils.isEmpty(a6)) {
                JSONObject jSONObject = new JSONObject(a6);
                jSONObject.put("current_time", System.currentTimeMillis());
                a(str, str2, jSONObject.toString());
            }
        } catch (Throwable th) {
            af.b(f8013a, th.getMessage());
        }
    }

    public final k c(String str, String str2) {
        k d5 = d(str, str2);
        return d5 == null ? k.y() : d5;
    }

    public final void f(String str) {
        try {
            String g5 = g(str);
            if (!TextUtils.isEmpty(g5)) {
                JSONObject jSONObject = new JSONObject(g5);
                jSONObject.put("current_time", System.currentTimeMillis());
                g(str, jSONObject.toString());
            }
        } catch (Throwable th) {
            af.b(f8013a, th.getMessage());
        }
    }

    public final boolean d(String str) {
        g b5 = b(str);
        if (b5 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long D4 = b5.D() + (b5.H() * 1000);
            if (D4 > currentTimeMillis) {
                String str2 = f8013a;
                af.c(str2, "app setting nexttime is not ready  [settingNextRequestTime= " + D4 + " currentTime = " + currentTimeMillis + "]");
                return false;
            }
        }
        af.c(f8013a, "app setting timeout or not exists");
        return true;
    }

    public final void g(String str, String str2) {
        a.a().a(str, str2);
        f8015c = g.e(str2);
        if (f8015c != null) {
            f8015c.aL();
        }
        v.a().a(f8015c.b());
    }

    public final void e(String str) {
        a a5 = a.a();
        a5.c("ivreward_" + str);
    }

    public final k b(String str, String str2) {
        return i(str, str2);
    }

    public static h a() {
        if (f8014b == null) {
            synchronized (h.class) {
                try {
                    if (f8014b == null) {
                        f8014b = new h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8014b;
    }

    public final g a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return i.a();
            }
            g b5 = b(str);
            return b5 == null ? i.a() : b5;
        } catch (Exception unused) {
            return i.a();
        }
    }

    public final boolean a(String str, int i5, String str2) {
        try {
            Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
            String str3 = str + "_" + i5 + "_" + str2;
            long currentTimeMillis = System.currentTimeMillis();
            long j5 = 0;
            long longValue = ((Long) an.a(c5, str3, 0L)).longValue();
            g b5 = b(str);
            if (b5 == null) {
                a();
                b5 = i.a();
            } else {
                j5 = longValue;
            }
            if (j5 + (b5.ao() * 1000) > currentTimeMillis) {
                return false;
            }
            an.b(c5, str3, Long.valueOf(currentTimeMillis));
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }

    public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return jSONObject2;
        }
        if (!(jSONObject2 == null || jSONObject2.length() == 0)) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (!"unitSetting".equals(next) || !jSONObject.has("unitSetting")) {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } else {
                        JSONArray jSONArray = jSONObject.getJSONArray("unitSetting");
                        jSONArray.put(0, a((JSONObject) jSONArray.get(0), (JSONObject) jSONObject2.getJSONArray("unitSetting").get(0)));
                        jSONObject.put(next, jSONArray);
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2;
        a.a().a(str4, str3);
        f8016d.put(str4, k.g(str3));
    }

    public final k a(String str, String str2) {
        k i5 = i(str, str2);
        return i5 == null ? k.y() : i5;
    }
}
