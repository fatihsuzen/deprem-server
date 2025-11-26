package com.mbridge.msdk.click;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.widget.Toast;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.f.a;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.u;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static Handler f8103a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            String str;
            String str2;
            String str3;
            super.handleMessage(message);
            try {
                if (message.what == 1000) {
                    int i5 = message.arg1;
                    int i6 = message.arg2;
                    Bundle data = message.getData();
                    if (data != null) {
                        String string = data.getString("rid");
                        String string2 = data.getString("rid_n");
                        str = data.getString("cid");
                        str3 = string;
                        str2 = string2;
                    } else {
                        str3 = "";
                        str2 = str3;
                        str = str2;
                    }
                    new h(com.mbridge.msdk.foundation.controller.c.m().c()).a(i5, i6, str3, str2, str);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
        }
    };

    public static boolean a(CampaignEx campaignEx) {
        return true;
    }

    public static void b(Context context, String str) {
        Intent launchIntentForPackage;
        List<ResolveInfo> queryIntentActivities;
        ResolveInfo next;
        try {
            if (!TextUtils.isEmpty(str) && c(context, str) && (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) != null && (queryIntentActivities = context.getPackageManager().queryIntentActivities(launchIntentForPackage, 0)) != null && queryIntentActivities.size() > 0 && (next = queryIntentActivities.iterator().next()) != null) {
                ActivityInfo activityInfo = next.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                Intent intent = new Intent();
                intent.setComponent(componentName);
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        } catch (Exception e5) {
            if (b.a()) {
                Toast.makeText(context, "The app connot start up", 0).show();
            }
            e5.printStackTrace();
        }
    }

    public static boolean c(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 8192);
                if (packageInfo != null) {
                    return str.equals(packageInfo.packageName);
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void d(Context context, String str) {
        if (str != null && context != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null) {
                    ActivityInfo activityInfo = resolveActivity.activityInfo;
                    intent.setClassName(activityInfo.packageName, activityInfo.name);
                }
                context.startActivity(intent);
            } catch (Exception e5) {
                e5.printStackTrace();
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    public static boolean e(Context context, String str) {
        Intent intent;
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                if (parse.getScheme().equals("intent")) {
                    intent = Intent.parseUri(str, 1);
                } else if (parse.getScheme().equals("android-app")) {
                    intent = Intent.parseUri(str, 2);
                } else {
                    intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setData(parse);
                }
                if (intent != null) {
                    intent.setComponent((ComponentName) null);
                    intent.setSelector((Intent) null);
                    if (a(context, intent)) {
                        return true;
                    }
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            af.b("CommonClickUtil", th.getMessage(), th);
            return false;
        }
    }

    public static void f(Context context, String str) {
        if (context != null && str != null) {
            try {
                int i5 = MBCommonActivity.f7863d;
                Intent intent = new Intent(context, MBCommonActivity.class);
                intent.putExtra("url", str);
                if (!(context instanceof ContextThemeWrapper)) {
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
            } catch (ClassNotFoundException e5) {
                af.b("CommonClickUtil", e5.getMessage());
            } catch (Throwable th) {
                af.b("CommonClickUtil", th.getMessage());
            }
        }
    }

    public static String a(String str, String str2, String str3) {
        Map<String, b.a> s5;
        try {
            if (!TextUtils.isEmpty(str)) {
                String host = Uri.parse(str).getHost();
                g b5 = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                if (b5 != null && (s5 = b5.s()) != null && !TextUtils.isEmpty(host)) {
                    Iterator<Map.Entry<String, b.a>> it = s5.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str4 = (String) it.next().getKey();
                        if (!TextUtils.isEmpty(str4) && host.contains(str4)) {
                            b.a aVar = s5.get(str4);
                            if (aVar != null) {
                                return a(a(a(a(str, aVar.a(), String.valueOf((float) ab.h(com.mbridge.msdk.foundation.controller.c.m().c()))), aVar.b(), String.valueOf((float) ab.j(com.mbridge.msdk.foundation.controller.c.m().c()))), aVar.c(), str2), aVar.d(), str3);
                            }
                        }
                    }
                }
            }
            return str;
        } catch (Exception e5) {
            e5.printStackTrace();
            return str;
        }
    }

    private static String a(String str, List<String> list, String str2) {
        if (list != null) {
            for (String next : list) {
                if (!TextUtils.isEmpty(next)) {
                    str = str.replaceAll(next, str2);
                }
            }
        }
        return str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|(2:12|(2:14|(2:26|16))(0))|17|18|19|20|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "com.android.vending"
            android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r3 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x00a2 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x00a2 }
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r2)     // Catch:{ Exception -> 0x00a2 }
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ Exception -> 0x00a2 }
            r3 = 0
            java.util.List r2 = r2.queryIntentActivities(r1, r3)     // Catch:{ Exception -> 0x00a2 }
            int r4 = r2.size()     // Catch:{ Exception -> 0x00a2 }
            if (r4 <= 0) goto L_0x0022
            r3 = 1
        L_0x0022:
            java.lang.String r4 = "market://"
            boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r5 = "https://play.google.com/store/apps/details?id="
            java.lang.String r6 = ""
            java.lang.String r7 = "market://details?id="
            if (r4 == 0) goto L_0x0083
            if (r3 != 0) goto L_0x0049
            java.lang.String r9 = r9.replace(r7, r6)     // Catch:{ Exception -> 0x00a2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2 }
            r0.<init>()     // Catch:{ Exception -> 0x00a2 }
            r0.append(r5)     // Catch:{ Exception -> 0x00a2 }
            r0.append(r9)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00a2 }
            d(r8, r9)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x0049:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00a2 }
        L_0x004d:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x0068
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x00a2 }
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch:{ Exception -> 0x00a2 }
            android.content.pm.ActivityInfo r3 = r3.activityInfo     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x00a2 }
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x004d
            java.lang.String r2 = "com.android.vending.AssetBrowserActivity"
            r1.setClassName(r0, r2)     // Catch:{ Exception -> 0x00a2 }
        L_0x0068:
            r8.startActivity(r1)     // Catch:{ Exception -> 0x006c }
            goto L_0x00aa
        L_0x006c:
            java.lang.String r9 = r9.replace(r7, r6)     // Catch:{ Exception -> 0x00a2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2 }
            r0.<init>()     // Catch:{ Exception -> 0x00a2 }
            r0.append(r5)     // Catch:{ Exception -> 0x00a2 }
            r0.append(r9)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00a2 }
            d(r8, r9)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x0083:
            java.lang.String r0 = "https://play.google.com/"
            boolean r0 = r9.startsWith(r0)     // Catch:{ Exception -> 0x00a2 }
            if (r0 == 0) goto L_0x00aa
            java.lang.String r9 = r9.replace(r5, r6)     // Catch:{ Exception -> 0x00a2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2 }
            r0.<init>()     // Catch:{ Exception -> 0x00a2 }
            r0.append(r7)     // Catch:{ Exception -> 0x00a2 }
            r0.append(r9)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00a2 }
            a((android.content.Context) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x00a2:
            r8 = move-exception
            java.lang.String r9 = "CommonClickUtil"
            java.lang.String r0 = "Exception"
            com.mbridge.msdk.foundation.tools.af.b(r9, r0, r8)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.c.a(android.content.Context, java.lang.String):void");
    }

    private static boolean a(Context context, Intent intent) {
        try {
            if (context instanceof Activity) {
                context.startActivity(intent);
                return true;
            }
            if (com.mbridge.msdk.foundation.controller.c.m().e() != null) {
                Context e5 = com.mbridge.msdk.foundation.controller.c.m().e();
                if (!(e5 instanceof Activity)) {
                    return false;
                }
                e5.startActivity(intent);
                return true;
            }
            return false;
        } catch (Throwable th) {
            af.b("CommonClickUtil", th.getMessage(), th);
        }
    }

    public static void a(final Context context, int i5, final String str) {
        if (i5 != 0) {
            try {
                a.b().execute(new Runnable() {
                    public final void run() {
                        try {
                            Method method = u.class.getMethod("mia", new Class[]{Context.class, String.class});
                            Context context = context;
                            if (context != null) {
                                method.invoke((Object) null, new Object[]{context, str});
                                return;
                            }
                            af.b("CommonClickUtil", "Context is null");
                        } catch (Throwable th) {
                            af.b("CommonClickUtil", th.getMessage());
                        }
                    }
                });
            } catch (Throwable th) {
                af.b("CommonClickUtil", th.getMessage());
            }
        }
    }
}
