package com.mbridge.msdk.foundation.tools;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.ah;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public final class ab extends k {

    /* renamed from: A  reason: collision with root package name */
    private static String f9576A = "";

    /* renamed from: B  reason: collision with root package name */
    private static Object f9577B = null;

    /* renamed from: C  reason: collision with root package name */
    private static int f9578C = 0;

    /* renamed from: D  reason: collision with root package name */
    private static int f9579D = 0;

    /* renamed from: E  reason: collision with root package name */
    private static String f9580E = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f9581e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f9582f = "";

    /* renamed from: g  reason: collision with root package name */
    private static int f9583g = -1;

    /* renamed from: h  reason: collision with root package name */
    private static String f9584h = "";

    /* renamed from: i  reason: collision with root package name */
    private static int f9585i = -1;

    /* renamed from: j  reason: collision with root package name */
    private static int f9586j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static String f9587k = "";

    /* renamed from: l  reason: collision with root package name */
    private static int f9588l = -1;

    /* renamed from: m  reason: collision with root package name */
    private static String f9589m = "";

    /* renamed from: n  reason: collision with root package name */
    private static String f9590n = "";
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static volatile int f9591o = -1;

    /* renamed from: p  reason: collision with root package name */
    private static String f9592p = "";

    /* renamed from: q  reason: collision with root package name */
    private static String f9593q = "";

    /* renamed from: r  reason: collision with root package name */
    private static int f9594r = -1;

    /* renamed from: s  reason: collision with root package name */
    private static int f9595s = -1;

    /* renamed from: t  reason: collision with root package name */
    private static int f9596t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public static String f9597u = "";

    /* renamed from: v  reason: collision with root package name */
    private static String f9598v = null;

    /* renamed from: w  reason: collision with root package name */
    private static int f9599w = 0;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public static String f9600x = "";

    /* renamed from: y  reason: collision with root package name */
    private static int f9601y = -1;

    /* renamed from: z  reason: collision with root package name */
    private static int f9602z;

    private static void B() {
        String str = Build.VERSION.RELEASE;
        String h5 = h();
        String str2 = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(h5)) {
            f9600x = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Mozilla/5.0 (Linux; Android ");
        sb.append(str);
        sb.append("; ");
        sb.append(h5);
        sb.append(" Build/");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
        f9600x = sb.toString();
    }

    private static long C() {
        Context c5 = c.m().c();
        if (c5 == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) c5.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private static String D() {
        String str;
        if (!TextUtils.isEmpty(f9584h)) {
            return f9584h;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            str = (String) cls.getMethod("getOsBrand", (Class[]) null).invoke(cls, (Object[]) null);
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage());
            str = null;
        }
        try {
            if (TextUtils.isEmpty(str) || !str.equals("harmony")) {
                f9584h = "android";
                return f9584h;
            }
            jSONObject.put("osType", str);
            Class<?> cls2 = Class.forName("ohos.system.version.SystemVersion");
            jSONObject.put("version", (String) cls2.getMethod("getVersion", (Class[]) null).invoke(cls2, (Object[]) null));
            try {
                jSONObject.put("pure_state", Settings.Secure.getInt(c.m().c().getContentResolver(), "pure_mode_state", -1));
            } catch (Throwable th2) {
                af.b("SameDiTool", th2.getMessage());
            }
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                jSONObject2 = z.b(jSONObject2);
            }
            f9584h = jSONObject2;
            return f9584h;
        } catch (Throwable th3) {
            af.b("SameDiTool", th3.getMessage());
        }
    }

    public static String a(Context context, int i5) {
        TelephonyManager telephonyManager;
        if (!(i5 == 0 || i5 == 9)) {
            try {
                if (!a.f9207z || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                    return "";
                }
                return String.valueOf(telephonyManager.getNetworkType());
            } catch (Throwable th) {
                af.b("SameDiTool", th.getMessage(), th);
            }
        }
        return "";
    }

    public static int b(int i5) {
        switch (i5) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    public static int c(String str) {
        if (f9579D == 0) {
            f9579D = ak.f(str);
        }
        return f9579D;
    }

    public static String f(Context context) {
        if (context == null) {
            return f9593q;
        }
        try {
            if (!TextUtils.isEmpty(f9593q)) {
                return f9593q;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            f9593q = str;
            return str;
        } catch (Exception e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public static String g() {
        if (TextUtils.isEmpty(f9600x)) {
            g(c.m().c());
        }
        return f9600x;
    }

    public static String h() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MODEL;
    }

    public static String i() {
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA);
        return "";
    }

    public static int j(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap i5 = i(context);
            return i5.get("width") == null ? displayMetrics.widthPixels : ((Integer) i5.get("width")).intValue();
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static int k() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return -1;
        }
        return Build.VERSION.SDK_INT;
    }

    public static String l(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f9590n = "";
            } else if (TextUtils.isEmpty(f9590n)) {
                if (context == null) {
                    f9590n = "";
                    return f9589m;
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (ak.j(simOperator)) {
                    f9590n = simOperator.substring(Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            f9590n = "";
        }
        return f9590n;
    }

    @SuppressLint({"MissingPermission"})
    public static int m(Context context) {
        try {
            final Context c5 = c.m().c();
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return f9591o;
            }
            if (c5 == null) {
                return f9591o;
            }
            if (f9591o != -1) {
                try {
                    AnonymousClass3 r22 = new Runnable() {
                        @SuppressLint({"MissingPermission"})
                        public final void run() {
                            try {
                                ConnectivityManager connectivityManager = (ConnectivityManager) c5.getSystemService("connectivity");
                                if (connectivityManager != null) {
                                    if (a.f9207z) {
                                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                        if (activeNetworkInfo == null) {
                                            int unused = ab.f9591o = 0;
                                        } else if (activeNetworkInfo.getType() == 1) {
                                            int unused2 = ab.f9591o = 9;
                                        } else {
                                            TelephonyManager telephonyManager = (TelephonyManager) c5.getSystemService("phone");
                                            if (telephonyManager == null) {
                                                int unused3 = ab.f9591o = 0;
                                            } else {
                                                int unused4 = ab.f9591o = ab.b(telephonyManager.getNetworkType());
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e5) {
                                af.b("SameDiTool", e5.getMessage(), e5);
                                int unused5 = ab.f9591o = 0;
                            }
                        }
                    };
                    if (com.mbridge.msdk.foundation.same.f.a.d().getActiveCount() < 1) {
                        com.mbridge.msdk.foundation.same.f.a.d().execute(r22);
                    }
                } catch (Throwable th) {
                    af.b("SameDiTool", th.getMessage());
                }
                return f9591o;
            }
            f9591o = 0;
            return f9591o;
        } catch (Exception e5) {
            af.b("SameDiTool", e5.getMessage(), e5);
            f9591o = 0;
            return f9591o;
        }
    }

    public static String n() {
        String str = "";
        try {
            Context c5 = c.m().c();
            long a5 = aa.a();
            long C4 = C();
            String A4 = A(c5);
            String str2 = "app_tki_" + a5 + "_" + C4 + "_" + A4;
            String str3 = (String) an.a(c5, str2, str);
            try {
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("1", A4);
                    jSONObject.put("2", String.valueOf(C4));
                    jSONObject.put(ExifInterface.GPS_MEASUREMENT_3D, String.valueOf(a5));
                    jSONObject.put("4", str);
                    jSONObject.put(CampaignEx.CLICKMODE_ON, str);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                str = C1584a.a(jSONObject.toString());
                an.b(c5, str2, str);
                return str;
            } catch (Exception e6) {
                e = e6;
                str = str3;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    public static int o() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return 0;
        }
        if (f9595s < 1) {
            try {
                Context c5 = c.m().c();
                long longValue = ((Long) an.a(c5, "TotalRamSize", 0L)).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - longValue > 1800000 || f9595s == -1) {
                    f9595s = Long.valueOf((C() / 1000) / 1000).intValue();
                    an.b(c5, "TotalRamSize", Long.valueOf(currentTimeMillis));
                }
            } catch (Throwable th) {
                af.b("SameDiTool", th.getMessage(), th);
            }
        }
        return f9595s;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:7|8|9|10|11|12|13|(1:15)|18|19|20|21|47|48) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0099, code lost:
        if (r1 == null) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00aa, code lost:
        if (r1 == null) goto L_0x00ad;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0070 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0096 A[SYNTHETIC, Splitter:B:35:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a7 A[SYNTHETIC, Splitter:B:43:0x00a7] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x008d=Splitter:B:32:0x008d, B:40:0x009e=Splitter:B:40:0x009e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String p() {
        /*
            java.lang.String r0 = "SameDiTool"
            com.mbridge.msdk.foundation.controller.authoritycontroller.c r1 = com.mbridge.msdk.foundation.controller.authoritycontroller.c.j()
            java.lang.String r2 = "authority_general_data"
            boolean r1 = r1.c((java.lang.String) r2)
            if (r1 != 0) goto L_0x0011
            java.lang.String r0 = ""
            return r0
        L_0x0011:
            int r1 = f9599w
            java.lang.String r2 = "GB"
            if (r1 <= 0) goto L_0x0029
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = f9599w
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0029:
            java.lang.String r1 = "/proc/meminfo"
            r3 = 0
            f9599w = r3
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x0088, all -> 0x0083 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0088, all -> 0x0083 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x007e, all -> 0x0079 }
            r5 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r4, r5)     // Catch:{ Exception -> 0x007e, all -> 0x0079 }
            java.lang.String r3 = r1.readLine()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r5 = 1
            r3 = r3[r5]     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r1.close()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            if (r3 == 0) goto L_0x006d
            java.lang.Float r5 = new java.lang.Float     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            float r3 = r3.floatValue()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r6 = 1233125376(0x49800000, float:1048576.0)
            float r3 = r3 / r6
            r5.<init>(r3)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            double r5 = r5.doubleValue()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            double r5 = java.lang.Math.ceil(r5)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            int r3 = (int) r5     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            f9599w = r3     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r3 = move-exception
            goto L_0x008d
        L_0x006b:
            r3 = move-exception
            goto L_0x009e
        L_0x006d:
            r4.close()     // Catch:{ IOException -> 0x0070 }
        L_0x0070:
            r1.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x00ad
        L_0x0074:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00ad
        L_0x0079:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x008d
        L_0x007e:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x009e
        L_0x0083:
            r1 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
            goto L_0x008d
        L_0x0088:
            r1 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
            goto L_0x009e
        L_0x008d:
            java.lang.String r5 = r3.getMessage()     // Catch:{ all -> 0x009c }
            com.mbridge.msdk.foundation.tools.af.b(r0, r5, r3)     // Catch:{ all -> 0x009c }
            if (r4 == 0) goto L_0x0099
            r4.close()     // Catch:{ IOException -> 0x0099 }
        L_0x0099:
            if (r1 == 0) goto L_0x00ad
            goto L_0x0070
        L_0x009c:
            r0 = move-exception
            goto L_0x00bf
        L_0x009e:
            java.lang.String r5 = r3.getMessage()     // Catch:{ all -> 0x009c }
            com.mbridge.msdk.foundation.tools.af.b(r0, r5, r3)     // Catch:{ all -> 0x009c }
            if (r4 == 0) goto L_0x00aa
            r4.close()     // Catch:{ IOException -> 0x00aa }
        L_0x00aa:
            if (r1 == 0) goto L_0x00ad
            goto L_0x0070
        L_0x00ad:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = f9599w
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00bf:
            if (r4 == 0) goto L_0x00c4
            r4.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x00c4:
            if (r1 == 0) goto L_0x00ce
            r1.close()     // Catch:{ IOException -> 0x00ca }
            goto L_0x00ce
        L_0x00ca:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00ce:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ab.p():java.lang.String");
    }

    public static String q(Context context) {
        if (context == null) {
            return f9576A;
        }
        try {
            if (!TextUtils.isEmpty(f9576A)) {
                return f9576A;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f9576A = str;
            return str;
        } catch (Exception e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public static int r() {
        try {
            if (ak.h()) {
                return 1;
            }
            if (ak.i()) {
                return 2;
            }
            return 0;
        } catch (Exception e5) {
            af.b("SameDiTool", e5.getMessage());
            return 0;
        }
    }

    public static int s() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static int t() {
        return f9601y;
    }

    public static int u() {
        if (f9578C == 0) {
            f9578C = ak.e();
        }
        return f9578C;
    }

    public static int v() {
        return f9588l;
    }

    public static String w() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(f9592p)) {
            int s5 = s();
            f9592p = s5 + "";
        }
        return f9592p;
    }

    private static void y(final Context context) {
        try {
            new Thread(new Runnable() {
                public final void run() {
                    String str;
                    try {
                        str = WebSettings.getDefaultUserAgent(context);
                    } catch (Throwable unused) {
                        str = null;
                    }
                    try {
                        if (!TextUtils.isEmpty(str) && !str.equals(ab.f9600x)) {
                            String unused2 = ab.f9600x = str;
                            ab.z(context);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static void z(Context context) {
        try {
            an.b(context, "mbridge_ua", f9600x);
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage(), th);
        }
    }

    private static String A(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f9582f = "";
            } else if (TextUtils.isEmpty(f9582f)) {
                f9582f = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            f9582f = "";
        }
        return f9582f;
    }

    public static Object b(String str) {
        if (f9577B == null) {
            f9577B = ak.g(str);
        }
        return f9577B;
    }

    public static void e(final Context context) {
        if (context != null) {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    f.b(context);
                } else {
                    new Handler(context.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            f.b(context);
                        }
                    });
                }
            } catch (Exception e5) {
                af.b("SameDiTool", "", e5);
            }
        }
    }

    public static String t(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(f9587k)) {
            if (context == null) {
                return "en-US";
            }
            try {
                if (context.getResources() != null) {
                    if (context.getResources().getConfiguration() != null) {
                        Locale locale = context.getResources().getConfiguration().locale;
                        if (locale == null) {
                            return "en-US";
                        }
                        String languageTag = locale.toLanguageTag();
                        f9587k = languageTag;
                        return languageTag;
                    }
                }
                return "en-US";
            } catch (Throwable th) {
                af.a("SameDiTool", th.getMessage());
                f9587k = "en-US";
            }
        }
        return f9587k;
    }

    public static int v(Context context) {
        if (f9583g == -1) {
            f9583g = ak.c(context, "com.tencent.mm") ? 1 : 0;
        }
        return f9583g;
    }

    public static String x() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.BRAND;
    }

    public static HashMap i(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            hashMap.put("height", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("width", Integer.valueOf(displayMetrics.widthPixels));
            return hashMap;
        } catch (Exception e5) {
            af.b("SameDiTool", e5.getMessage(), e5);
            return hashMap;
        }
    }

    public static String k(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f9589m = "";
            } else if (TextUtils.isEmpty(f9589m)) {
                if (context == null) {
                    f9589m = "";
                    return "";
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (ak.j(simOperator)) {
                    f9589m = simOperator.substring(0, Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            f9589m = "";
        }
        return f9589m;
    }

    public static int s(Context context) {
        Configuration configuration;
        if (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null || configuration.orientation != 2) {
            return 1;
        }
        return 2;
    }

    public static int z() {
        if (f9585i == -1) {
            f9585i = ak.f() ? 1 : 0;
        }
        return f9585i;
    }

    public static void c(int i5) {
        f9588l = i5;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String g(android.content.Context r8) {
        /*
            com.mbridge.msdk.foundation.controller.authoritycontroller.c r0 = com.mbridge.msdk.foundation.controller.authoritycontroller.c.j()
            java.lang.String r1 = "authority_general_data"
            boolean r0 = r0.c((java.lang.String) r1)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.String r0 = f9600x
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "SameDiTool"
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = "mbridge_ua"
            java.lang.String r3 = ""
            java.lang.Object r0 = com.mbridge.msdk.foundation.tools.an.a(r8, r0, r3)     // Catch:{ all -> 0x0027 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0027 }
            f9600x = r0     // Catch:{ all -> 0x0027 }
            goto L_0x002f
        L_0x0027:
            r0 = move-exception
            java.lang.String r3 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r3, r0)
        L_0x002f:
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch:{ all -> 0x00a0 }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x00a0 }
            if (r0 != r3) goto L_0x00b2
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DNT_GUA_ON_UI     // Catch:{ all -> 0x00a0 }
            if (r0 != 0) goto L_0x00b2
            java.lang.String r0 = f9600x     // Catch:{ all -> 0x00a0 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x00ae
            java.lang.String r0 = android.webkit.WebSettings.getDefaultUserAgent(r8)     // Catch:{ all -> 0x004b }
            f9600x = r0     // Catch:{ all -> 0x004b }
        L_0x004b:
            java.lang.String r0 = f9600x     // Catch:{ all -> 0x00a0 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x00c8
            java.lang.Class<android.webkit.WebSettings> r0 = android.webkit.WebSettings.class
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x007f }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x007f }
            java.lang.Class<android.webkit.WebView> r5 = android.webkit.WebView.class
            r7 = 1
            r4[r7] = r5     // Catch:{ all -> 0x007f }
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r4)     // Catch:{ all -> 0x007f }
            r0.setAccessible(r7)     // Catch:{ all -> 0x007f }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x007f }
            r3[r6] = r8     // Catch:{ all -> 0x007f }
            r3[r7] = r1     // Catch:{ all -> 0x007f }
            java.lang.Object r1 = r0.newInstance(r3)     // Catch:{ all -> 0x007f }
            android.webkit.WebSettings r1 = (android.webkit.WebSettings) r1     // Catch:{ all -> 0x007f }
            java.lang.String r1 = r1.getUserAgentString()     // Catch:{ all -> 0x007f }
            f9600x = r1     // Catch:{ all -> 0x007f }
            r0.setAccessible(r6)     // Catch:{ all -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00a0 }
        L_0x0083:
            java.lang.String r0 = f9600x     // Catch:{ all -> 0x00a0 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x00a2
            android.webkit.WebView r0 = new android.webkit.WebView     // Catch:{ all -> 0x009b }
            r0.<init>(r8)     // Catch:{ all -> 0x009b }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ all -> 0x009b }
            java.lang.String r0 = r0.getUserAgentString()     // Catch:{ all -> 0x009b }
            f9600x = r0     // Catch:{ all -> 0x009b }
            goto L_0x00a2
        L_0x009b:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00a0 }
            goto L_0x00a2
        L_0x00a0:
            r0 = move-exception
            goto L_0x00c1
        L_0x00a2:
            java.lang.String r0 = f9600x     // Catch:{ all -> 0x00a0 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x00c8
            B()     // Catch:{ all -> 0x00a0 }
            goto L_0x00c8
        L_0x00ae:
            y(r8)     // Catch:{ all -> 0x00a0 }
            goto L_0x00c8
        L_0x00b2:
            java.lang.String r0 = f9600x     // Catch:{ all -> 0x00a0 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x00bd
            B()     // Catch:{ all -> 0x00a0 }
        L_0x00bd:
            y(r8)     // Catch:{ all -> 0x00a0 }
            goto L_0x00c8
        L_0x00c1:
            java.lang.String r1 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r1, r0)
        L_0x00c8:
            z(r8)
            java.lang.String r8 = f9600x
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ab.g(android.content.Context):java.lang.String");
    }

    public static int h(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap i5 = i(context);
            return i5.get("height") == null ? displayMetrics.heightPixels : ((Integer) i5.get("height")).intValue();
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static int r(Context context) {
        if (context == null) {
            return f9602z;
        }
        int i5 = f9602z;
        if (i5 != 0) {
            return i5;
        }
        try {
            int i6 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            f9602z = i6;
            return i6;
        } catch (Exception e5) {
            e5.printStackTrace();
            return -1;
        }
    }

    public static int u(Context context) {
        if (context == null) {
            return f9596t;
        }
        if (f9596t == 0) {
            try {
                f9596t = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e5) {
                af.b("SameDiTool", e5.getMessage());
            }
        }
        return f9596t;
    }

    public static String y() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                return "";
            }
            if (TextUtils.isEmpty(f9597u)) {
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            String unused = ab.f9597u = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }).start();
                return f9597u;
            }
            return f9597u;
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage(), th);
        }
    }

    public static void j() {
        try {
            Object a5 = an.a(c.m().c(), MBridgeConstans.SP_GA_ID, "");
            Object a6 = an.a(c.m().c(), MBridgeConstans.SP_GA_ID_LIMIT, 0);
            if (a5 instanceof String) {
                String str = (String) a5;
                if (!TextUtils.isEmpty(str)) {
                    f.a(str);
                }
                if (a6 instanceof Integer) {
                    f.f9705d = ((Integer) a6).intValue();
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("SameDiTool", e5.getMessage());
            }
        }
    }

    public static boolean w(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static String a(String str, Context context) {
        try {
            if (!TextUtils.isEmpty(f9581e)) {
                return f9581e;
            }
            if (!TextUtils.isEmpty(str) && context != null) {
                f9581e = context.getPackageManager().getInstallerPackageName(str);
                af.a("SameDiTool", "PKGSource:" + f9581e);
            }
            return f9581e;
        } catch (Exception e5) {
            af.b("SameDiTool", e5.getMessage(), e5);
        }
    }

    public static int f() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return 0;
            }
            Context c5 = c.m().c();
            long j5 = 0;
            long longValue = ((Long) an.a(c5, "FreeRamSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || f9594r == -1) {
                Context c6 = c.m().c();
                if (c6 != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) c6.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    j5 = memoryInfo.availMem;
                }
                f9594r = Long.valueOf((j5 / 1000) / 1000).intValue();
                an.b(c5, "FreeRamSize", Long.valueOf(currentTimeMillis));
            }
            return f9594r;
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage(), th);
        }
    }

    public static int q() {
        try {
            if (!ah.a.f9630a.a("v_a_d_p", false)) {
                return 0;
            }
            if (ak.h()) {
                f9586j = 1;
            } else if (ak.i()) {
                f9586j = 2;
            } else {
                f9586j = 0;
            }
            return f9586j;
        } catch (Exception e5) {
            f9586j = 0;
            af.b("SameDiTool", e5.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b0, code lost:
        if (r4 == null) goto L_0x00b3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007e A[SYNTHETIC, Splitter:B:38:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a4 A[SYNTHETIC, Splitter:B:51:0x00a4] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0075=Splitter:B:35:0x0075, B:48:0x009b=Splitter:B:48:0x009b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o(android.content.Context r9) {
        /*
            java.lang.String r0 = "SameDiTool"
            com.mbridge.msdk.foundation.controller.authoritycontroller.c r1 = com.mbridge.msdk.foundation.controller.authoritycontroller.c.j()
            java.lang.String r2 = "authority_general_data"
            boolean r1 = r1.c((java.lang.String) r2)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0011
            return r2
        L_0x0011:
            if (r9 != 0) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.String r1 = f9598v
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x001f
            java.lang.String r9 = f9598v
            return r9
        L_0x001f:
            java.lang.String r1 = "/proc/meminfo"
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x0072, all -> 0x006f }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0072, all -> 0x006f }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            r5 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            java.lang.String r3 = r1.readLine()     // Catch:{ IOException -> 0x0068, all -> 0x0065 }
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ IOException -> 0x0068, all -> 0x0065 }
            r5 = 1
            r3 = r3[r5]     // Catch:{ IOException -> 0x0068, all -> 0x0065 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ IOException -> 0x0068, all -> 0x0065 }
            long r5 = r3.longValue()     // Catch:{ IOException -> 0x0068, all -> 0x0065 }
            r7 = 1024(0x400, double:5.06E-321)
            long r5 = r5 * r7
            java.lang.String r9 = android.text.format.Formatter.formatFileSize(r9, r5)     // Catch:{ IOException -> 0x0068, all -> 0x0065 }
            f9598v = r9     // Catch:{ IOException -> 0x0068, all -> 0x0065 }
            r1.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0058
        L_0x0050:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r2, r1)
        L_0x0058:
            r4.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0064
        L_0x005c:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r2, r1)
        L_0x0064:
            return r9
        L_0x0065:
            r9 = move-exception
            r3 = r1
            goto L_0x0075
        L_0x0068:
            r9 = move-exception
            r3 = r1
            goto L_0x009b
        L_0x006b:
            r9 = move-exception
            goto L_0x0075
        L_0x006d:
            r9 = move-exception
            goto L_0x009b
        L_0x006f:
            r9 = move-exception
            r4 = r3
            goto L_0x0075
        L_0x0072:
            r9 = move-exception
            r4 = r3
            goto L_0x009b
        L_0x0075:
            java.lang.String r1 = r9.getMessage()     // Catch:{ all -> 0x0099 }
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)     // Catch:{ all -> 0x0099 }
            if (r3 == 0) goto L_0x008a
            r3.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x008a
        L_0x0082:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)
        L_0x008a:
            if (r4 == 0) goto L_0x00b3
        L_0x008c:
            r4.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x00b3
        L_0x0090:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)
            goto L_0x00b3
        L_0x0099:
            r9 = move-exception
            goto L_0x00b4
        L_0x009b:
            java.lang.String r1 = r9.getMessage()     // Catch:{ all -> 0x0099 }
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)     // Catch:{ all -> 0x0099 }
            if (r3 == 0) goto L_0x00b0
            r3.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00b0
        L_0x00a8:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)
        L_0x00b0:
            if (r4 == 0) goto L_0x00b3
            goto L_0x008c
        L_0x00b3:
            return r2
        L_0x00b4:
            if (r3 == 0) goto L_0x00c2
            r3.close()     // Catch:{ IOException -> 0x00ba }
            goto L_0x00c2
        L_0x00ba:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r2, r1)
        L_0x00c2:
            if (r4 == 0) goto L_0x00d0
            r4.close()     // Catch:{ IOException -> 0x00c8 }
            goto L_0x00d0
        L_0x00c8:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r2, r1)
        L_0x00d0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ab.o(android.content.Context):java.lang.String");
    }

    public static String l() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER;
    }

    public static String m() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String n(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return "";
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "time_12_24");
        } catch (Exception e5) {
            af.b("SameDiTool", e5.getMessage(), e5);
            return "";
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    public static void p(Context context) {
        try {
            f.a(context);
            w();
            f(context);
            q(context);
            r(context);
            s(context);
            h();
            x();
            t(context);
            y();
            a.f9159B = false;
            a.f9207z = ak.a("android.permission.ACCESS_NETWORK_STATE", context);
            u(context);
            D();
            f.e();
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    try {
                        com.mbridge.msdk.e.c.a();
                    } catch (Exception e5) {
                        af.b("SameDiTool", e5.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage());
        }
    }
}
