package com.mbridge.msdk.foundation.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aj extends m {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f9639a = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};

    /* renamed from: b  reason: collision with root package name */
    public static boolean f9640b = false;

    /* renamed from: c  reason: collision with root package name */
    public static LinearLayout f9641c;

    public static class a {
        public static boolean a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
            try {
                List<ResolveInfo> a5 = a(context);
                if (a5 != null) {
                    if (a5.size() > 0) {
                        if (!a(str)) {
                            if (c(str)) {
                                str = "market://" + str.substring(str.indexOf("details?id="));
                            } else {
                                str = null;
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            return false;
                        }
                        Intent b5 = b(context);
                        b5.setData(Uri.parse(str));
                        b5.addFlags(268435456);
                        Iterator<ResolveInfo> it = a5.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                                    b5.setPackage("com.android.vending");
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        context.startActivity(b5);
                        aj.a((BaseTrackingListener) nativeTrackingListener);
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                af.b("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }

        private static Intent b(Context context) {
            return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.package.name"));
        }

        private static boolean c(String str) {
            Uri parse;
            try {
                if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getHost())) {
                    return false;
                }
                if (parse.getHost().equals("play.google.com") || parse.getHost().equals("market.android.com")) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                af.b("SDKUtil", Log.getStackTraceString(th));
            }
            return false;
        }

        public static boolean b(String str) {
            return a(str) || c(str);
        }

        private static List<ResolveInfo> a(Context context) {
            try {
                return context.getPackageManager().queryIntentActivities(b(context), 0);
            } catch (Exception e5) {
                e5.printStackTrace();
                return null;
            }
        }

        public static boolean a(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return Uri.parse(str).getScheme().equals("market");
                }
                return false;
            } catch (Throwable th) {
                af.b("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File b5 = e.b(c.MBRIDGE_700_IMG);
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            if (str.lastIndexOf("/") == -1) {
                str2 = str.hashCode() + str2;
            } else {
                str2 = (str.hashCode() + str.substring(str.lastIndexOf("/") + 1).hashCode()) + str2;
            }
        }
        return new File(b5, str2).getAbsolutePath();
    }

    public static void b(Campaign campaign, ViewGroup viewGroup) {
        a(campaign, viewGroup, 0, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|(2:12|(2:14|(2:26|16))(0))|17|18|19|20|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, java.lang.String r9, com.mbridge.msdk.out.NativeListener.NativeTrackingListener r10) {
        /*
            java.lang.String r0 = "com.android.vending"
            android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r3 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x00a5 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x00a5 }
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r2)     // Catch:{ Exception -> 0x00a5 }
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ Exception -> 0x00a5 }
            r3 = 0
            java.util.List r2 = r2.queryIntentActivities(r1, r3)     // Catch:{ Exception -> 0x00a5 }
            int r4 = r2.size()     // Catch:{ Exception -> 0x00a5 }
            if (r4 <= 0) goto L_0x0022
            r3 = 1
        L_0x0022:
            java.lang.String r4 = "market://"
            boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r5 = "https://play.google.com/store/apps/details?id="
            java.lang.String r6 = ""
            java.lang.String r7 = "market://details?id="
            if (r4 == 0) goto L_0x0086
            if (r3 != 0) goto L_0x0049
            java.lang.String r9 = r9.replace(r7, r6)     // Catch:{ Exception -> 0x00a5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5 }
            r0.<init>()     // Catch:{ Exception -> 0x00a5 }
            r0.append(r5)     // Catch:{ Exception -> 0x00a5 }
            r0.append(r9)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00a5 }
            a((android.content.Context) r8, (java.lang.String) r9, (com.mbridge.msdk.out.BaseTrackingListener) r10)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00af
        L_0x0049:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00a5 }
        L_0x004d:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x00a5 }
            if (r3 == 0) goto L_0x0068
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x00a5 }
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch:{ Exception -> 0x00a5 }
            android.content.pm.ActivityInfo r3 = r3.activityInfo     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x00a5 }
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x00a5 }
            if (r3 == 0) goto L_0x004d
            java.lang.String r2 = "com.android.vending.AssetBrowserActivity"
            r1.setClassName(r0, r2)     // Catch:{ Exception -> 0x00a5 }
        L_0x0068:
            r8.startActivity(r1)     // Catch:{ Exception -> 0x006f }
            a((com.mbridge.msdk.out.BaseTrackingListener) r10)     // Catch:{ Exception -> 0x006f }
            goto L_0x00af
        L_0x006f:
            java.lang.String r9 = r9.replace(r7, r6)     // Catch:{ Exception -> 0x00a5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5 }
            r0.<init>()     // Catch:{ Exception -> 0x00a5 }
            r0.append(r5)     // Catch:{ Exception -> 0x00a5 }
            r0.append(r9)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00a5 }
            a((android.content.Context) r8, (java.lang.String) r9, (com.mbridge.msdk.out.BaseTrackingListener) r10)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00af
        L_0x0086:
            java.lang.String r0 = "https://play.google.com/"
            boolean r0 = r9.startsWith(r0)     // Catch:{ Exception -> 0x00a5 }
            if (r0 == 0) goto L_0x00af
            java.lang.String r9 = r9.replace(r5, r6)     // Catch:{ Exception -> 0x00a5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5 }
            r0.<init>()     // Catch:{ Exception -> 0x00a5 }
            r0.append(r7)     // Catch:{ Exception -> 0x00a5 }
            r0.append(r9)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00a5 }
            a((android.content.Context) r8, (java.lang.String) r9, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r10)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00af
        L_0x00a5:
            r8 = move-exception
            java.lang.String r9 = "SDKUtil"
            java.lang.String r8 = r8.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r9, r8)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.aj.a(android.content.Context, java.lang.String, com.mbridge.msdk.out.NativeListener$NativeTrackingListener):void");
    }

    public static void a(Campaign campaign, ViewGroup viewGroup) {
        if (campaign != null) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (campaignEx.getLinkType() != 8 || campaignEx.getAabEntity() == null || campaignEx.getAabEntity().getHlp() != 1) {
                return;
            }
            if (viewGroup == null) {
                af.d("SDKUtil", "hide linkType==8 loading view failed. viewGroup is null");
                return;
            }
            try {
                LinearLayout linearLayout = f9641c;
                if (linearLayout != null) {
                    viewGroup.removeView(linearLayout);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, BaseTrackingListener baseTrackingListener) {
        a(context, str, baseTrackingListener, (CampaignEx) null, (List<String>) new ArrayList());
    }

    public static void a(Context context, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        if (context != null) {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            if (list != null) {
                list.add("web_view");
            }
            if (f9640b) {
                a(context, str, (BaseTrackingListener) nativeTrackingListener, campaignEx, list);
                return;
            }
            try {
                int i5 = MBCommonActivity.f7863d;
                Intent intent = new Intent(context, MBCommonActivity.class);
                if (!TextUtils.isEmpty(str)) {
                    if (a.a(str)) {
                        str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
                    }
                    intent.putExtra("url", str);
                    af.c("url", "webview url = " + str);
                    intent.setFlags(268435456);
                    intent.putExtra("mvcommon", campaignEx);
                    context.startActivity(intent);
                    eVar.a("result", 1);
                    eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 9);
                    if (list != null) {
                        eVar.a("click_path", list.toString());
                    }
                    d.a().a("2000150", campaignEx, eVar);
                }
            } catch (Exception unused) {
                eVar.a("result", 2);
                a(context, str, (BaseTrackingListener) nativeTrackingListener, campaignEx, list);
            }
        }
    }

    public static void a(Context context, String str, BaseTrackingListener baseTrackingListener, CampaignEx campaignEx, List<String> list) {
        if (str != null && context != null) {
            if (list != null) {
                list.add("browser");
            }
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            try {
                if (a.a(str)) {
                    str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setComponent((ComponentName) null);
                intent.setSelector((Intent) null);
                intent.addFlags(268435456);
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null) {
                    ActivityInfo activityInfo = resolveActivity.activityInfo;
                    intent.setClassName(activityInfo.packageName, activityInfo.name);
                }
                context.startActivity(intent);
                a(baseTrackingListener);
                eVar.a("result", 1);
            } catch (Exception e5) {
                e5.printStackTrace();
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent2.addFlags(268468224);
                    context.startActivity(intent2);
                    a(baseTrackingListener);
                    eVar.a("result", 1);
                } catch (Exception e6) {
                    e6.printStackTrace();
                    eVar.a("result", 2);
                }
            }
            try {
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 5);
                if (list != null) {
                    eVar.a("click_path", list.toString());
                }
                d.a().a("2000150", campaignEx, eVar);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(BaseTrackingListener baseTrackingListener) {
        if (baseTrackingListener instanceof NativeListener.TrackingExListener) {
            ((NativeListener.TrackingExListener) baseTrackingListener).onLeaveApp();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r10, java.lang.String r11, com.mbridge.msdk.foundation.entity.CampaignEx r12, com.mbridge.msdk.click.a r13, com.mbridge.msdk.out.BaseTrackingListener r14, java.util.List<java.lang.String> r15) {
        /*
            java.lang.String r1 = "result"
            com.mbridge.msdk.foundation.same.report.d.e r2 = new com.mbridge.msdk.foundation.same.report.d.e
            r2.<init>()
            r0 = 9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "type"
            r2.a(r3, r0)
            com.mbridge.msdk.foundation.webview.BrowserView r8 = new com.mbridge.msdk.foundation.webview.BrowserView     // Catch:{ Exception -> 0x0047 }
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0047 }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x0047 }
            r8.<init>((android.content.Context) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r12)     // Catch:{ Exception -> 0x0047 }
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x0047 }
            int r3 = com.mbridge.msdk.foundation.tools.ab.j(r10)     // Catch:{ Exception -> 0x0047 }
            int r4 = com.mbridge.msdk.foundation.tools.ab.h(r10)     // Catch:{ Exception -> 0x0047 }
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x0047 }
            r8.setLayoutParams(r0)     // Catch:{ Exception -> 0x0047 }
            com.mbridge.msdk.foundation.webview.a r4 = new com.mbridge.msdk.foundation.webview.a     // Catch:{ Exception -> 0x0047 }
            r5 = r10
            r6 = r12
            r7 = r13
            r9 = r14
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0044 }
            r8.setListener(r4)     // Catch:{ Exception -> 0x0044 }
            r8.loadUrl(r11)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r10 = "1"
            r2.a(r1, r10)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0058
        L_0x0044:
            r0 = move-exception
        L_0x0045:
            r10 = r0
            goto L_0x004a
        L_0x0047:
            r0 = move-exception
            r6 = r12
            goto L_0x0045
        L_0x004a:
            java.lang.String r11 = "SDKUtil"
            java.lang.String r10 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r11, r10)
            java.lang.String r10 = "2"
            r2.a(r1, r10)
        L_0x0058:
            if (r15 == 0) goto L_0x0063
            java.lang.String r10 = "click_path"
            java.lang.String r11 = r15.toString()
            r2.a(r10, r11)
        L_0x0063:
            com.mbridge.msdk.foundation.same.report.d.d r10 = com.mbridge.msdk.foundation.same.report.d.d.a()
            java.lang.String r11 = "2000150"
            r10.a((java.lang.String) r11, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.same.report.d.e) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.aj.a(android.content.Context, java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.click.a, com.mbridge.msdk.out.BaseTrackingListener, java.util.List):void");
    }

    public static void a(Campaign campaign, ViewGroup viewGroup, int i5, int i6) {
        if (campaign != null) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (campaignEx.getLinkType() != 8 || campaignEx.getAabEntity() == null || campaignEx.getAabEntity().getHlp() != 1) {
                return;
            }
            if (viewGroup == null) {
                af.d("SDKUtil", "show linkType==8 loading view failed. viewGroup is null");
                return;
            }
            try {
                if (f9641c == null) {
                    Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                    if (c5 instanceof Activity) {
                        f9641c = (LinearLayout) LayoutInflater.from(c5.getApplicationContext()).inflate(x.a(c5.getApplicationContext(), "mbridge_cm_loading_layout", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                    } else {
                        f9641c = (LinearLayout) LayoutInflater.from(c5).inflate(x.a(c5, "mbridge_cm_loading_layout", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                    }
                }
                int min = Math.min(viewGroup.getWidth(), viewGroup.getHeight());
                int min2 = Math.min(Math.max(min / 4, 70), min);
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(min2, min2);
                    layoutParams.gravity = 17;
                    at.a(f9641c);
                    viewGroup.addView(f9641c, layoutParams);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(min2, min2);
                if (i6 == 0 && i5 == 0) {
                    layoutParams2.addRule(13);
                } else {
                    layoutParams2.leftMargin = i6;
                    layoutParams2.topMargin = i5;
                }
                at.a(f9641c);
                viewGroup.addView(f9641c, layoutParams2);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
