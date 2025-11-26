package com.mbridge.msdk.foundation.tools;

import D.C0635a;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.tools.b;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebEnvCheckEntry;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f9702a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f9703b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f9704c = false;

    /* renamed from: d  reason: collision with root package name */
    public static int f9705d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static String f9706e = "";

    /* renamed from: f  reason: collision with root package name */
    private static boolean f9707f = false;

    /* renamed from: g  reason: collision with root package name */
    private static String f9708g = "";

    /* renamed from: h  reason: collision with root package name */
    private static boolean f9709h = false;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f9710i = false;

    public static int a() {
        return f9705d;
    }

    public static String b() {
        if (!c.k() || !c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!b.a()) {
            if (TextUtils.isEmpty(f9703b)) {
                return "";
            }
            return f9703b;
        } else if (TextUtils.isEmpty(f9703b)) {
            if (!f9704c) {
                a(com.mbridge.msdk.foundation.controller.c.m().c());
                f9704c = true;
            }
            return "";
        } else if (b.b()) {
            return f9703b;
        } else {
            if (f9705d == 0) {
                return f9703b;
            }
            return "";
        }
    }

    public static String c() {
        if (!c.k() || !c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!b.a()) {
            if (TextUtils.isEmpty(f9702a)) {
                return "";
            }
            return f9702a;
        } else if (TextUtils.isEmpty(f9702a)) {
            ab.j();
            if (!f9704c) {
                a(com.mbridge.msdk.foundation.controller.c.m().c());
                f9704c = true;
            }
            if (TextUtils.isEmpty(f9702a)) {
                return "";
            }
            return f9702a;
        } else if (b.b()) {
            return f9702a;
        } else {
            if (f9705d == 0) {
                return f9702a;
            }
            return "";
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(f9708g) && !f9707f) {
            e();
        }
        return f9708g;
    }

    public static String e() {
        if (!c.k() || !c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (f9707f) {
            return f9706e;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ContentResolver contentResolver = com.mbridge.msdk.foundation.controller.c.m().c().getContentResolver();
            int i5 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking");
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i5);
            jSONObject.put("amazonId", string);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                f9708g = jSONObject2;
                f9706e = z.b(jSONObject2);
            }
        } catch (Settings.SettingNotFoundException e5) {
            af.b("DomainSameDiTool", e5.getMessage());
        } catch (Throwable th) {
            af.b("DomainSameDiTool", th.getMessage());
        }
        f9707f = true;
        return f9706e;
    }

    public static void a(int i5) {
        f9705d = i5;
    }

    public static void a(final Context context) {
        new Thread(new Runnable() {
            public final void run() {
                if (c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID) && b.a()) {
                    try {
                        C0635a.C0043a a5 = C0635a.a(context);
                        f.a(a5.a());
                        f.f9705d = a5.b() ? 1 : 0;
                        f.a(context, a5.a(), f.f9705d);
                    } catch (Exception unused) {
                        af.d("DomainSameDiTool", "GET ADID ERROR TRY TO GET FROM GOOGLE PLAY APP");
                        try {
                            b.a a6 = new b().a(context);
                            f.a(a6.a());
                            f.f9705d = a6.b() ? 1 : 0;
                            f.a(context, a6.a(), f.f9705d);
                        } catch (Exception unused2) {
                            af.d("DomainSameDiTool", "GET ADID FROM GOOGLE PLAY APP ERROR");
                        }
                    } catch (Throwable th) {
                        af.b("DomainSameDiTool", th.getMessage());
                    }
                }
            }
        }).start();
    }

    public static void a(String str) {
        f9703b = z.b(str);
        f9702a = str;
    }

    static /* synthetic */ void a(Context context, String str, int i5) {
        try {
            if (ap.b(str)) {
                an.b(context, MBridgeConstans.SP_GA_ID, str);
            }
            an.b(context, MBridgeConstans.SP_GA_ID_LIMIT, Integer.valueOf(i5));
        } catch (Exception e5) {
            af.b("DomainSameDiTool", e5.getMessage());
        }
    }

    public static void b(Context context) {
        if (context != null) {
            Class<WebEnvCheckEntry> cls = WebEnvCheckEntry.class;
            try {
                WebEnvCheckEntry newInstance = cls.newInstance();
                cls.getMethod("check", new Class[]{Context.class}).invoke(newInstance, new Object[]{context});
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static boolean c(Context context) {
        try {
            if (f9710i) {
                return f9709h;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                f9709h = context.getPackageManager().checkPermission(z.a("DkP3hrKuHoPMH+zwL+fALkK/WQc5x5zH+TcincKNNVfWNVJcVM=="), context.getPackageName()) == 0;
            } else {
                f9709h = true;
            }
            f9710i = true;
            return f9709h;
        } catch (Exception unused) {
            f9709h = false;
        }
    }
}
