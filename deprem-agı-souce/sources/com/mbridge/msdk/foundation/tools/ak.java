package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.resource.ResourceConfig;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.MIMManager;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak extends n {

    /* renamed from: a  reason: collision with root package name */
    private static int f9642a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static int f9643b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static int f9644c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static int f9645d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static int f9646e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static int f9647f = 7;

    /* renamed from: g  reason: collision with root package name */
    private static int f9648g = 14;

    /* renamed from: h  reason: collision with root package name */
    private static int f9649h = 19;

    /* renamed from: i  reason: collision with root package name */
    private static int f9650i = 16;

    /* renamed from: j  reason: collision with root package name */
    private static int f9651j = 26;

    /* renamed from: k  reason: collision with root package name */
    private static char[] f9652k = {'.', 'X'};

    /* renamed from: l  reason: collision with root package name */
    private static char[] f9653l = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};

    /* renamed from: m  reason: collision with root package name */
    private static int f9654m = 1;

    /* renamed from: n  reason: collision with root package name */
    private static boolean f9655n = true;

    /* renamed from: o  reason: collision with root package name */
    private static volatile Boolean f9656o = null;

    /* renamed from: p  reason: collision with root package name */
    private static String f9657p = "[一-龥]";

    /* renamed from: q  reason: collision with root package name */
    private static Pattern f9658q = Pattern.compile("[一-龥]");

    /* renamed from: r  reason: collision with root package name */
    private static Map<String, String> f9659r;

    /* renamed from: s  reason: collision with root package name */
    private static Map<String, String> f9660s;

    public static int a(int i5) {
        if ((i5 > 100 && i5 < 199) || i5 == 2) {
            return 1;
        }
        if ((i5 <= 200 || i5 >= 299) && i5 != 4) {
            return (i5 <= 500 || i5 >= 599) ? -1 : 5;
        }
        return 2;
    }

    public static int b(Context context) {
        PackageInfo packageInfo;
        if (context == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                packageInfo = WebView.getCurrentWebViewPackage();
            } else {
                packageInfo = context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            }
            g b5 = h.a().b(c.m().k());
            if (b5 == null) {
                h.a();
                b5 = i.a();
            }
            if (packageInfo == null || TextUtils.isEmpty(packageInfo.versionName) || !packageInfo.versionName.equals("77.0.3865.92")) {
                return b5.aC();
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int c(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return 0;
    }

    public static float d(Context context) {
        if (context != null) {
            try {
                float f5 = context.getResources().getDisplayMetrics().density;
                if (f5 == 0.0f) {
                    return 2.5f;
                }
                return f5;
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return 2.5f;
    }

    public static int e(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return o(context).heightPixels;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static int f(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return o(context).widthPixels;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static int g(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static float i(Context context) {
        return (float) context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float j(Context context) {
        return (float) context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int k(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static boolean l(Context context) {
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
                return true;
            }
            return false;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }

    public static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("SameTools", "isNetworkAvailable", e5);
            }
            return false;
        }
    }

    public static boolean n(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !"wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US))) {
                return false;
            }
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }

    private static DisplayMetrics o(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable th) {
            th.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(str2, str3);
                    return a(str, (Map<String, String>) hashMap);
                }
            }
            return str;
        } catch (Exception e5) {
            af.b("SameTools", e5.getMessage());
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String d(java.lang.String r3) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.ak> r0 = com.mbridge.msdk.foundation.tools.ak.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
            r1.<init>()     // Catch:{ all -> 0x0033 }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = r2.k()     // Catch:{ all -> 0x0033 }
            r1.append(r2)     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x0033 }
            r1.append(r3)     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0033 }
            java.util.Map<java.lang.String, java.lang.String> r1 = f9660s     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0035
            boolean r1 = r1.containsKey(r3)     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0035
            java.util.Map<java.lang.String, java.lang.String> r1 = f9660s     // Catch:{ all -> 0x0033 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)
            return r3
        L_0x0033:
            r3 = move-exception
            goto L_0x0038
        L_0x0035:
            monitor-exit(r0)
            r3 = 0
            return r3
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.d(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[ExcHandler: all (unused java.lang.Throwable), SYNTHETIC, Splitter:B:3:0x0008] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean i(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0027, all -> 0x0048 }
            if (r4 == 0) goto L_0x003e
            java.lang.String r0 = "dyview"
            java.lang.String r0 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x0027, all -> 0x0048 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0027, all -> 0x0048 }
            r3 = 1
            if (r2 != 0) goto L_0x002a
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0020, all -> 0x0048 }
            goto L_0x0021
        L_0x0020:
            r0 = -1
        L_0x0021:
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x002a
            r0 = r3
            goto L_0x002b
        L_0x0027:
            r4 = move-exception
            r0 = r1
            goto L_0x003f
        L_0x002a:
            r0 = r1
        L_0x002b:
            java.lang.String r2 = "natmp"
            java.lang.String r4 = r4.getQueryParameter(r2)     // Catch:{ Exception -> 0x003c }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x003c }
            if (r4 != 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r3 = r0
        L_0x0039:
            return r3
        L_0x003a:
            r1 = r0
            goto L_0x0048
        L_0x003c:
            r4 = move-exception
            goto L_0x003f
        L_0x003e:
            return r1
        L_0x003f:
            java.lang.String r2 = "SameTools"
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x003a }
            com.mbridge.msdk.foundation.tools.af.b(r2, r4)     // Catch:{ all -> 0x003a }
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.i(java.lang.String):boolean");
    }

    public static <T extends String> boolean j(T t5) {
        return t5 != null && t5.length() > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized java.lang.String e(java.lang.String r9) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.ak> r0 = com.mbridge.msdk.foundation.tools.ak.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0046 }
            r1.<init>()     // Catch:{ Exception -> 0x0046 }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0046 }
            java.lang.String r2 = r2.k()     // Catch:{ Exception -> 0x0046 }
            r1.append(r2)     // Catch:{ Exception -> 0x0046 }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ Exception -> 0x0046 }
            r1.append(r9)     // Catch:{ Exception -> 0x0046 }
            java.lang.String r9 = r1.toString()     // Catch:{ Exception -> 0x0046 }
            com.mbridge.msdk.c.h r1 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0046 }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0046 }
            java.lang.String r2 = r2.k()     // Catch:{ Exception -> 0x0046 }
            com.mbridge.msdk.c.g r1 = r1.b(r2)     // Catch:{ Exception -> 0x0046 }
            r2 = 0
            if (r1 == 0) goto L_0x0049
            boolean r3 = r1.aD()     // Catch:{ Exception -> 0x0046 }
            boolean r4 = r1.aI()     // Catch:{ Exception -> 0x0046 }
            int r1 = r1.ae()     // Catch:{ Exception -> 0x0046 }
            int r1 = java.lang.Math.max(r2, r1)     // Catch:{ Exception -> 0x0046 }
            goto L_0x004c
        L_0x0043:
            r9 = move-exception
            goto L_0x0145
        L_0x0046:
            r9 = move-exception
            goto L_0x0138
        L_0x0049:
            r3 = 1
            r1 = 3
            r4 = r2
        L_0x004c:
            if (r4 == 0) goto L_0x0134
            if (r1 != 0) goto L_0x0052
            goto L_0x0134
        L_0x0052:
            if (r3 == 0) goto L_0x0068
            java.util.Map<java.lang.String, java.lang.String> r4 = f9659r     // Catch:{ Exception -> 0x0046 }
            if (r4 == 0) goto L_0x0068
            boolean r4 = r4.containsKey(r9)     // Catch:{ Exception -> 0x0046 }
            if (r4 == 0) goto L_0x0068
            java.util.Map<java.lang.String, java.lang.String> r1 = f9659r     // Catch:{ Exception -> 0x0046 }
            java.lang.Object r9 = r1.get(r9)     // Catch:{ Exception -> 0x0046 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0046 }
            monitor-exit(r0)
            return r9
        L_0x0068:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0046 }
            java.lang.String r5 = ""
            r4.<init>(r5)     // Catch:{ Exception -> 0x0046 }
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ Exception -> 0x0046 }
            r5.<init>()     // Catch:{ Exception -> 0x0046 }
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()     // Catch:{ Exception -> 0x0046 }
            if (r5 == 0) goto L_0x0141
            int r6 = r5.length     // Catch:{ Exception -> 0x0046 }
            if (r6 <= 0) goto L_0x0141
            java.util.List r5 = a((java.lang.StackTraceElement[]) r5)     // Catch:{ Exception -> 0x0046 }
            java.util.Collections.reverse(r5)     // Catch:{ Exception -> 0x0046 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0046 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0046 }
            r6.<init>()     // Catch:{ Exception -> 0x0046 }
        L_0x008d:
            boolean r7 = r5.hasNext()     // Catch:{ Exception -> 0x0046 }
            if (r7 == 0) goto L_0x00cb
            java.lang.Object r7 = r5.next()     // Catch:{ Exception -> 0x0046 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0046 }
            java.lang.String r8 = "com.android"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0046 }
            if (r8 != 0) goto L_0x008d
            java.lang.String r8 = "android.os"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0046 }
            if (r8 != 0) goto L_0x008d
            java.lang.String r8 = "android.app"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0046 }
            if (r8 != 0) goto L_0x008d
            java.lang.String r8 = "java.lang.reflect.Method"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0046 }
            if (r8 != 0) goto L_0x008d
            java.lang.String r8 = "android.view"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0046 }
            if (r8 != 0) goto L_0x008d
            boolean r8 = r6.contains(r7)     // Catch:{ Exception -> 0x0046 }
            if (r8 != 0) goto L_0x008d
            r6.add(r7)     // Catch:{ Exception -> 0x0046 }
            goto L_0x008d
        L_0x00cb:
            int r5 = r6.size()     // Catch:{ Exception -> 0x0046 }
            int r1 = java.lang.Math.min(r5, r1)     // Catch:{ Exception -> 0x0046 }
            if (r1 <= 0) goto L_0x00ec
        L_0x00d5:
            if (r2 >= r1) goto L_0x00ec
            java.lang.Object r5 = r6.get(r2)     // Catch:{ Exception -> 0x0046 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0046 }
            r4.append(r5)     // Catch:{ Exception -> 0x0046 }
            int r5 = r1 + -1
            if (r2 >= r5) goto L_0x00e9
            java.lang.String r5 = "|"
            r4.append(r5)     // Catch:{ Exception -> 0x0046 }
        L_0x00e9:
            int r2 = r2 + 1
            goto L_0x00d5
        L_0x00ec:
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0046 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0046 }
            if (r1 != 0) goto L_0x0105
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0046 }
            r1.<init>()     // Catch:{ Exception -> 0x0046 }
            java.lang.String r2 = "1"
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0046 }
            r1.put(r2, r4)     // Catch:{ Exception -> 0x0046 }
            goto L_0x0106
        L_0x0105:
            r1 = 0
        L_0x0106:
            if (r1 == 0) goto L_0x0130
            int r2 = r1.length()     // Catch:{ Exception -> 0x0046 }
            if (r2 <= 0) goto L_0x0130
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0046 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.C1584a.a(r1)     // Catch:{ Exception -> 0x0046 }
            if (r3 == 0) goto L_0x012e
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0046 }
            if (r2 != 0) goto L_0x012e
            java.util.Map<java.lang.String, java.lang.String> r2 = f9659r     // Catch:{ Exception -> 0x0046 }
            if (r2 != 0) goto L_0x0129
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0046 }
            r2.<init>()     // Catch:{ Exception -> 0x0046 }
            f9659r = r2     // Catch:{ Exception -> 0x0046 }
        L_0x0129:
            java.util.Map<java.lang.String, java.lang.String> r2 = f9659r     // Catch:{ Exception -> 0x0046 }
            r2.put(r9, r1)     // Catch:{ Exception -> 0x0046 }
        L_0x012e:
            monitor-exit(r0)
            return r1
        L_0x0130:
            java.lang.String r9 = ""
            monitor-exit(r0)
            return r9
        L_0x0134:
            java.lang.String r9 = ""
            monitor-exit(r0)
            return r9
        L_0x0138:
            java.lang.String r1 = "SameTools"
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0043 }
            com.mbridge.msdk.foundation.tools.af.b(r1, r9)     // Catch:{ all -> 0x0043 }
        L_0x0141:
            java.lang.String r9 = ""
            monitor-exit(r0)
            return r9
        L_0x0145:
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.e(java.lang.String):java.lang.String");
    }

    public static int f(String str) {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", (Class[]) null).invoke(ab.b(str), (Object[]) null)).intValue();
        } catch (Throwable th) {
            af.b("SameTools", th.getMessage());
            return 0;
        }
    }

    public static Object g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", new Class[]{Context.class, String.class}).invoke((Object) null, new Object[]{c.m().c(), str});
        } catch (ClassNotFoundException e5) {
            af.b("SameTools", e5.getMessage());
            return null;
        } catch (NoSuchMethodException e6) {
            af.b("SameTools", e6.getMessage());
            return null;
        } catch (IllegalAccessException e7) {
            af.b("SameTools", e7.getMessage());
            return null;
        } catch (InvocationTargetException e8) {
            af.b("SameTools", e8.getMessage());
            return null;
        }
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_CAN_ANIM);
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter.equals("1");
                }
            }
            return false;
        } catch (Exception e5) {
            af.b("SameTools", e5.getMessage());
            return false;
        }
    }

    public static void j() {
        HandlerThread handlerThread = new HandlerThread("mb_db_thread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        MBDownloadConfig.Builder builder = new MBDownloadConfig.Builder();
        builder.setDatabaseHandler(handler);
        builder.setDatabaseOpenHelper(new IDatabaseOpenHelper() {
            public final SQLiteDatabase getReadableDatabase() {
                return com.mbridge.msdk.foundation.db.g.a(c.m().c()).c();
            }

            public final SQLiteDatabase getWritableDatabase() {
                return com.mbridge.msdk.foundation.db.g.a(c.m().c()).d();
            }
        });
        builder.setLogger(new ILogger() {
            public final void log(String str, String str2) {
                af.a(str, str2);
            }

            public final void log(String str, Exception exc) {
                af.a(str, exc.getMessage());
            }
        });
        MBDownloadManager.getInstance().initialize(c.m().c(), builder.build(), new ResourceConfig.Builder().setMaxStorageSpace(100).setMaxStorageTime(259200000).build());
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter("isplayableec");
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter.equals("0");
                }
            }
            return false;
        } catch (Exception e5) {
            af.b("SameTools", e5.getMessage());
            return false;
        }
    }

    public static BitmapDrawable n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (decodeByteArray != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(decodeByteArray);
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                bitmapDrawable.setTileModeXY(tileMode, tileMode);
                return bitmapDrawable;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String c(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> a5;
        if (TextUtils.isEmpty(str) || (a5 = b.a(str)) == null || a5.size() <= 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (com.mbridge.msdk.foundation.entity.c next : a5.values()) {
            if (next != null) {
                long e5 = next.e();
                long f5 = next.f();
                long currentTimeMillis = System.currentTimeMillis();
                if (e5 <= 0) {
                    g b5 = h.a().b(c.m().k());
                    if (b5 == null) {
                        h.a();
                        b5 = i.a();
                    }
                    if (f5 + (b5.ad() * 1000) < currentTimeMillis) {
                    }
                } else if (f5 + (e5 * 1000) < currentTimeMillis) {
                }
                List<String> c5 = next.c();
                if (c5 != null && c5.size() > 0) {
                    arrayList.addAll(c5);
                }
            }
        }
        if (arrayList.size() <= 0) {
            return "";
        }
        HashSet hashSet = new HashSet(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);
        return arrayList.toString();
    }

    public static double m(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Double.parseDouble(str);
            }
            return 0.0d;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0.0d;
        }
    }

    private static String a(String str, Map<String, String> map) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (map == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            for (Map.Entry next : map.entrySet()) {
                if (next != null && !TextUtils.isEmpty((CharSequence) next.getKey())) {
                    if (!TextUtils.isEmpty((CharSequence) next.getValue())) {
                        String str2 = (String) next.getValue();
                        if (str.contains((CharSequence) next.getKey())) {
                            if (str2.equals("0")) {
                                sb = new StringBuilder(str.replaceAll("(" + ((String) next.getKey()) + "[^&]*)", ""));
                            } else {
                                sb = new StringBuilder(str.replaceAll("(" + ((String) next.getKey()) + "[^&]*)", ((String) next.getKey()) + ((String) next.getValue())));
                            }
                        } else if (!str2.equals("0")) {
                            sb.append(((String) next.getKey()) + ((String) next.getValue()));
                        }
                    }
                }
            }
            return sb.toString();
        } catch (Exception e5) {
            af.b("SameTools", e5.getMessage());
            return str;
        }
    }

    public static String d() {
        String str;
        try {
            str = UUID.randomUUID().toString() + System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
            str = "";
        }
        if (!ap.a(str)) {
            return str;
        }
        return System.currentTimeMillis() + "";
    }

    public static <T extends String> boolean k(T t5) {
        return t5 == null || t5.length() == 0;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter("dyview");
                if (TextUtils.isEmpty(queryParameter)) {
                    queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
                }
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        return Integer.parseInt(queryParameter);
                    } catch (Exception unused) {
                    }
                }
            }
            return -1;
        } catch (Exception e5) {
            af.b("SameTools", e5.getMessage());
            return -1;
        }
    }

    public static boolean f() {
        if (TextUtils.isEmpty(c.m().h())) {
            return false;
        }
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
            return true;
        } catch (ClassNotFoundException e5) {
            af.b("SameTools", e5.getMessage());
            return false;
        }
    }

    public static boolean h() {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager a5 = w.a();
            if (a5 == null || (networkInfo = a5.getNetworkInfo(17)) == null) {
                return false;
            }
            return networkInfo.isConnected();
        } catch (Exception e5) {
            af.b("SameTools", e5.getMessage());
            return false;
        }
    }

    public static synchronized int d(Context context, String str) {
        int i5;
        synchronized (ak.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        i5 = b(str, context) != null ? 1 : 0;
                    } catch (Exception unused) {
                        i5 = 3;
                    }
                }
            }
            i5 = context == null ? 5 : TextUtils.isEmpty(str) ? 2 : 4;
        }
        return i5;
    }

    public static boolean g() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean i() {
        try {
            if (c.m().c() == null) {
                return false;
            }
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            int parseInt = Integer.parseInt(property2);
            af.a("address = ", property + "~");
            af.a("port = ", parseInt + "~");
            if (TextUtils.isEmpty(property) || parseInt == -1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            af.b("SameTools", th.getMessage());
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[Catch:{ Exception -> 0x001c }, LOOP:0: B:19:0x0040->B:20:0x0042, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(int r5) {
        /*
            java.lang.String r0 = ""
            com.mbridge.msdk.c.h r1 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x001c }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x001c }
            java.lang.String r2 = r2.k()     // Catch:{ Exception -> 0x001c }
            com.mbridge.msdk.c.g r1 = r1.b(r2)     // Catch:{ Exception -> 0x001c }
            if (r1 != 0) goto L_0x001e
            com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x001c }
            com.mbridge.msdk.c.g r1 = com.mbridge.msdk.c.i.a()     // Catch:{ Exception -> 0x001c }
            goto L_0x001e
        L_0x001c:
            r5 = move-exception
            goto L_0x0056
        L_0x001e:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x001c }
            r2.<init>()     // Catch:{ Exception -> 0x001c }
            if (r1 == 0) goto L_0x004a
            int r1 = r1.t()     // Catch:{ Exception -> 0x001c }
            r3 = 1
            if (r1 != r3) goto L_0x004a
            com.mbridge.msdk.foundation.db.a.a r1 = com.mbridge.msdk.foundation.db.a.a.a()     // Catch:{ Exception -> 0x001c }
            java.lang.String[] r1 = r1.b()     // Catch:{ Exception -> 0x001c }
            if (r1 == 0) goto L_0x004a
            int r3 = r1.length     // Catch:{ Exception -> 0x001c }
            if (r3 <= r5) goto L_0x003f
            if (r5 != 0) goto L_0x003c
            goto L_0x003f
        L_0x003c:
            int r5 = r3 - r5
            goto L_0x0040
        L_0x003f:
            r5 = 0
        L_0x0040:
            if (r5 >= r3) goto L_0x004a
            r4 = r1[r5]     // Catch:{ Exception -> 0x001c }
            r2.put(r4)     // Catch:{ Exception -> 0x001c }
            int r5 = r5 + 1
            goto L_0x0040
        L_0x004a:
            int r5 = r2.length()     // Catch:{ Exception -> 0x001c }
            if (r5 <= 0) goto L_0x0055
            java.lang.String r5 = a((org.json.JSONArray) r2)     // Catch:{ Exception -> 0x001c }
            return r5
        L_0x0055:
            return r0
        L_0x0056:
            r5.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.b(int):java.lang.String");
    }

    public static String a(String str) {
        try {
            if (ap.b(str)) {
                return URLEncoder.encode(str, "utf-8");
            }
            return "";
        } catch (Throwable th) {
            af.b("SameTools", th.getMessage(), th);
            return "";
        }
    }

    public static void a(ImageView imageView) {
        if (imageView != null) {
            try {
                imageView.setImageResource(0);
                imageView.setImageDrawable((Drawable) null);
                imageView.setImageURI((Uri) null);
                imageView.setImageBitmap((Bitmap) null);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static final char[] c(int i5) {
        StringBuilder sb;
        if (i5 == 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(aj.f9639a, f9647f)));
            sb.append(f9652k[f9646e]);
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f9639a, f9647f, f9648g)));
            sb.append(f9652k[f9646e]);
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f9639a, f9648g, f9650i)));
            sb.append(f9652k[f9646e]);
            sb.append(String.valueOf(ai.f9631a));
        } else if (i5 == 1) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(aj.f9639a, f9647f)));
            sb.append(f9652k[f9646e]);
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f9639a, f9647f, f9648g)));
            sb.append(f9652k[f9646e]);
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f9639a, f9649h, f9651j)));
        } else if (i5 == 2) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f9639a, f9650i, f9649h)));
            sb.append(String.valueOf(f9653l));
        } else if (i5 != 3) {
            sb = null;
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f9639a, f9650i, f9649h)));
            sb.append(String.valueOf(ai.f9631a));
        }
        return sb.toString().toCharArray();
    }

    public static final void a(final int i5, final ImageView imageView, final CampaignEx campaignEx, Context context, boolean z4, final a aVar) {
        if (imageView != null && campaignEx != null) {
            af.a("configPrivacyButton", "configPrivacyButton");
            boolean z5 = campaignEx.getPrivacyButtonTemplateVisibility() == 0;
            af.a("configPrivacyButton", "privacyButtonVisibilityGone: " + z5 + " isIgnoreCampaignPrivacyConfig: " + z4);
            if (!z4 && z5) {
                try {
                    imageView.setVisibility(8);
                } catch (Exception e5) {
                    af.b("SameTools", e5.getMessage());
                }
            } else if (TextUtils.isEmpty(a(campaignEx))) {
                try {
                    imageView.setVisibility(8);
                } catch (Exception e6) {
                    af.b("SameTools", e6.getMessage());
                }
            } else {
                try {
                    imageView.setVisibility(0);
                } catch (Exception e7) {
                    af.b("SameTools", e7.getMessage());
                }
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        try {
                            ak.a(campaignEx, aVar, i5, (String) imageView.getTag());
                        } catch (Exception e5) {
                            af.b("SameTools", e5.getMessage());
                        }
                    }
                });
            }
        }
    }

    public static JSONArray b(Context context, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            g b5 = h.a().b(c.m().k());
            if (b5 == null) {
                h.a();
                b5 = i.a();
            }
            if (b5 != null && b5.t() == 1) {
                af.c("SameTools", "fqci cfc:" + b5.t());
                String[] b6 = com.mbridge.msdk.foundation.db.a.a.a().b();
                if (b6 != null) {
                    for (String put : b6) {
                        af.c("SameTools", "cfc campaignIds:" + b6);
                        jSONArray.put(put);
                    }
                }
            }
            return jSONArray;
        } catch (Exception e5) {
            e5.printStackTrace();
            return jSONArray;
        }
    }

    public static synchronized boolean c(Context context, String str) {
        boolean z4;
        synchronized (ak.class) {
            z4 = false;
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (b(str, context) != null) {
                            z4 = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return z4;
    }

    public static boolean c(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                return campaignEx.getRetarget_offer() == 1;
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return false;
    }

    public static int e() {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get((Object) null)).intValue();
        } catch (Throwable th) {
            af.b("SameTools", th.getMessage());
            return 0;
        }
    }

    public static int b() {
        int i5 = f9654m;
        f9654m = i5 + 1;
        return i5;
    }

    public static int c(String str, String str2) {
        return a(str, str2, 0);
    }

    public static String a(CampaignEx campaignEx) {
        g b5;
        CampaignEx.a adchoice;
        String str = "";
        if (campaignEx != null) {
            try {
                str = campaignEx.getPrivacyUrl();
            } catch (Exception e5) {
                af.b("SameTools", e5.getMessage());
                return str;
            }
        }
        if (!(!TextUtils.isEmpty(str) || campaignEx == null || (adchoice = campaignEx.getAdchoice()) == null)) {
            str = adchoice.c();
        }
        if (TextUtils.isEmpty(str) && (b5 = h.a().b(c.m().k())) != null) {
            str = b5.j();
        }
        return TextUtils.isEmpty(str) ? d.f().f9371f : str;
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(c(f9642a))).getMethod(String.valueOf(c(f9644c)), new Class[]{String.class, Integer.TYPE}).invoke(Class.forName(String.valueOf(c(f9643b))).getMethod(String.valueOf(c(f9645d)), (Class[]) null).invoke(context, (Object[]) null), new Object[]{str, 8192});
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String c() {
        return MIMManager.a.f9573a.c();
    }

    public static boolean b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return !TextUtils.isEmpty(campaignEx.getDeepLinkURL());
        }
        return false;
    }

    public static List<String> b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        String optString = jSONArray.optString(i5);
                        if (ap.b(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable th) {
                af.b("SameTools", th.getMessage(), th);
            }
        }
        return null;
    }

    public static void a(CampaignEx campaignEx, a aVar, int i5, String str) {
        if (campaignEx != null) {
            try {
                String str2 = campaignEx.getCampaignUnitId() + "_" + i5;
                com.mbridge.msdk.foundation.d.b.a().c(str2);
                com.mbridge.msdk.foundation.d.b.a().a(str2, campaignEx);
                com.mbridge.msdk.foundation.d.b.a().a(str2, aVar);
                com.mbridge.msdk.foundation.d.b.a().a(str2, i5);
                com.mbridge.msdk.foundation.d.b.a().a(str2, str);
                com.mbridge.msdk.foundation.d.b.a().a(str2).e();
            } catch (Throwable th) {
                af.b("SameTools", "feedback error", th);
            }
        }
    }

    public static synchronized void b(String str, String str2) {
        synchronized (ak.class) {
            try {
                if (f9660s == null) {
                    f9660s = new HashMap();
                }
                f9660s.put(c.m().k() + "_" + str, str2);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public static int b(Context context, float f5) {
        float f6 = 2.5f;
        if (context != null) {
            try {
                float f7 = context.getResources().getDisplayMetrics().density;
                if (f7 != 0.0f) {
                    f6 = f7;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return (int) ((f5 / f6) + 0.5f);
    }

    public static int a(Context context, float f5) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f5 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static String b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("device");
                if (jSONObject2 != null) {
                    if (jSONObject2.has(str2)) {
                        if (str3.equals("0")) {
                            jSONObject2.remove(str2);
                        } else {
                            jSONObject2.put(str2, str3);
                        }
                    } else if (!str3.equals("0")) {
                        jSONObject2.put(str2, str3);
                    }
                    return jSONObject.toString();
                }
            } catch (Exception e5) {
                af.b("SameTools", e5.getMessage());
            }
        }
        return str;
    }

    public static double a(Double d5) {
        try {
            String format = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d5);
            if (ap.b(format)) {
                return Double.parseDouble(format);
            }
            return 0.0d;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0.0d;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        if (r2 != null) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002b, code lost:
        if (r2 != null) goto L_0x0021;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0027 A[SYNTHETIC, Splitter:B:19:0x0027] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long a(java.io.File r4) throws java.lang.Exception {
        /*
            r0 = 0
            r2 = 0
            boolean r3 = r4.exists()     // Catch:{ Exception -> 0x002b, all -> 0x001a }
            if (r3 == 0) goto L_0x001c
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002b, all -> 0x001a }
            r3.<init>(r4)     // Catch:{ Exception -> 0x002b, all -> 0x001a }
            int r4 = r3.available()     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            long r0 = (long) r4
            r2 = r3
            goto L_0x001f
        L_0x0015:
            r4 = move-exception
            r2 = r3
            goto L_0x0025
        L_0x0018:
            r2 = r3
            goto L_0x002b
        L_0x001a:
            r4 = move-exception
            goto L_0x0025
        L_0x001c:
            r4.createNewFile()     // Catch:{ Exception -> 0x002b, all -> 0x001a }
        L_0x001f:
            if (r2 == 0) goto L_0x002e
        L_0x0021:
            r2.close()     // Catch:{ Exception -> 0x002e }
            goto L_0x002e
        L_0x0025:
            if (r2 == 0) goto L_0x002a
            r2.close()     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            throw r4
        L_0x002b:
            if (r2 == 0) goto L_0x002e
            goto L_0x0021
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.a(java.io.File):long");
    }

    public static String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        g b5 = h.a().b(c.m().k());
        if (b5 == null) {
            h.a();
            b5 = i.a();
        }
        int Z4 = b5.Z();
        if (jSONArray.length() <= Z4) {
            return jSONArray.toString();
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i5 = 0; i5 < Z4; i5++) {
            try {
                jSONArray2.put(jSONArray.get(i5));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        return jSONArray2.toString();
    }

    public static String a(Context context, String str) {
        String str2 = "";
        try {
            JSONArray b5 = b(context, str);
            if (b5.length() > 0) {
                str2 = a(b5);
            }
            af.c("SameTools", "get excludes:" + str2);
            return str2;
        } catch (Exception e5) {
            e5.printStackTrace();
            return str2;
        }
    }

    public static final int a() {
        if (f9656o == null) {
            try {
                f9656o = MIMManager.a.f9573a.d();
            } catch (Exception e5) {
                af.b("SameTools", e5.getMessage());
            }
        }
        if (f9656o != null) {
            return f9656o.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|4|5|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.ak> r0 = com.mbridge.msdk.foundation.tools.ak.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            r1.<init>(r4)     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = a((java.lang.String) r4, (android.content.Context) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0012 }
            r1.append(r2)     // Catch:{ Exception -> 0x0012 }
            goto L_0x0012
        L_0x0010:
            r2 = move-exception
            goto L_0x0018
        L_0x0012:
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0010 }
            monitor-exit(r0)
            return r2
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2 = new java.lang.StringBuilder("&rtins_type=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.append(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0047, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String a(java.lang.String r2, android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.ak> r0 = com.mbridge.msdk.foundation.tools.ak.class
            monitor-enter(r0)
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0025 }
            java.util.Set r2 = r2.getQueryParameterNames()     // Catch:{ Exception -> 0x0025 }
            if (r2 == 0) goto L_0x001d
            int r2 = r2.size()     // Catch:{ Exception -> 0x0025 }
            if (r2 <= 0) goto L_0x001d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025 }
            goto L_0x002c
        L_0x001b:
            r2 = move-exception
            goto L_0x0046
        L_0x001d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = "?rtins_type="
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025 }
            goto L_0x002c
        L_0x0025:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x001b }
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch:{ all -> 0x001b }
        L_0x002c:
            java.lang.Object r3 = b((java.lang.String) r4, (android.content.Context) r3)     // Catch:{ Exception -> 0x003c }
            if (r3 == 0) goto L_0x0037
            r3 = 1
            r2.append(r3)     // Catch:{ Exception -> 0x003c }
            goto L_0x0040
        L_0x0037:
            r3 = 2
            r2.append(r3)     // Catch:{ Exception -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r3 = 0
            r2.append(r3)     // Catch:{ all -> 0x001b }
        L_0x0040:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x001b }
            monitor-exit(r0)
            return r2
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.a(java.lang.String, android.content.Context, java.lang.String):java.lang.String");
    }

    private static List<String> a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement className : stackTraceElementArr) {
                arrayList.add(className.getClassName());
            }
        }
        return arrayList;
    }

    public static ImageView a(ImageView imageView, BitmapDrawable bitmapDrawable, DisplayMetrics displayMetrics) {
        try {
            bitmapDrawable.setTargetDensity(displayMetrics);
            imageView.setBackground(bitmapDrawable);
            imageView.setClickable(false);
            imageView.setFocusable(false);
            return imageView;
        } catch (Exception e5) {
            e5.printStackTrace();
            return imageView;
        }
    }

    public static void a(View view) {
        if (view != null) {
            try {
                view.setSystemUiVisibility(4102);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String str, CampaignEx campaignEx, int i5) {
        if (!TextUtils.isEmpty(str) && campaignEx != null && c.m().c() != null) {
            com.mbridge.msdk.foundation.db.i a5 = com.mbridge.msdk.foundation.db.i.a((f) com.mbridge.msdk.foundation.db.g.a(c.m().c()));
            com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
            fVar.a(System.currentTimeMillis());
            fVar.b(str);
            fVar.a(campaignEx.getId());
            fVar.a(i5);
            a5.a(fVar);
        }
    }

    public static boolean a(String str, Context context) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0 || jSONObject.optInt("v", -1) != -1) {
            return false;
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str2);
                if (parse == null || TextUtils.isEmpty(parse.getQueryParameter(str))) {
                    return false;
                }
                return true;
            } catch (Exception e5) {
                af.b("SameTools", e5.getMessage());
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static int a(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof String) {
                    return Integer.parseInt((String) obj);
                }
            } catch (Throwable th) {
                af.b("SameTools", th.getMessage(), th);
            }
        }
        return 0;
    }

    public static int a(String str, String str2, int i5) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                if (parse != null) {
                    String queryParameter = parse.getQueryParameter(str2);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        return (int) Math.round(Double.valueOf(String.valueOf(queryParameter)).doubleValue());
                    }
                }
            } catch (Exception e5) {
                af.b("SameTools", e5.getMessage());
                return i5;
            }
        }
        return i5;
    }
}
