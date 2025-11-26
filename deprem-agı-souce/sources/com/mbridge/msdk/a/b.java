package com.mbridge.msdk.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import t1.a;
import u1.d;
import u1.f;
import u1.i;
import u1.k;
import u1.l;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7849a = DomainNameUtils.VERIFICATION_URL;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0085, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0086, code lost:
        r1 = r17;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:8:0x0025] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static u1.b a(android.content.Context r17, boolean r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            java.lang.String r6 = "failed, exception "
            java.lang.String r0 = com.mbridge.msdk.MBridgeConstans.OMID_JS_SERVICE_CONTENT
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = a()
            com.mbridge.msdk.MBridgeConstans.OMID_JS_SERVICE_CONTENT = r0
        L_0x0010:
            java.lang.String r0 = com.mbridge.msdk.MBridgeConstans.OMID_JS_SERVICE_CONTENT
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r7 = 0
            java.lang.String r8 = "OMSDK"
            if (r0 != 0) goto L_0x0021
            boolean r0 = android.text.TextUtils.isEmpty(r19)
            if (r0 == 0) goto L_0x0025
        L_0x0021:
            r1 = r17
            goto L_0x00dd
        L_0x0025:
            c((android.content.Context) r17)     // Catch:{ IllegalArgumentException -> 0x003b, Exception -> 0x0035 }
            java.lang.String r0 = "Mintegral"
            java.lang.String r1 = "MAL_16.8.61"
            u1.l r9 = u1.l.a(r0, r1)     // Catch:{ IllegalArgumentException -> 0x0085, Exception -> 0x0035 }
            if (r18 == 0) goto L_0x0040
            u1.f r0 = u1.f.NATIVE_DISPLAY     // Catch:{ IllegalArgumentException -> 0x003b, Exception -> 0x0035 }
            goto L_0x0042
        L_0x0035:
            r0 = move-exception
            r1 = r17
        L_0x0038:
            r12 = r20
            goto L_0x0089
        L_0x003b:
            r0 = move-exception
            r1 = r17
            goto L_0x00b2
        L_0x0040:
            u1.f r0 = u1.f.VIDEO     // Catch:{ IllegalArgumentException -> 0x0085, Exception -> 0x0035 }
        L_0x0042:
            u1.i r1 = u1.i.BEGIN_TO_RENDER     // Catch:{ IllegalArgumentException -> 0x0085, Exception -> 0x0035 }
            u1.k r2 = u1.k.NATIVE     // Catch:{ IllegalArgumentException -> 0x0085, Exception -> 0x0035 }
            if (r18 == 0) goto L_0x004b
            u1.k r3 = u1.k.NONE     // Catch:{ IllegalArgumentException -> 0x003b, Exception -> 0x0035 }
            goto L_0x004c
        L_0x004b:
            r3 = r2
        L_0x004c:
            r4 = 0
            u1.c r10 = u1.c.a(r0, r1, r2, r3, r4)     // Catch:{ IllegalArgumentException -> 0x0085, Exception -> 0x0035 }
            r1 = r17
            r0 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r24
            java.util.List r0 = a(r0, r1, r2, r3, r4, r5)     // Catch:{ IllegalArgumentException -> 0x0082, Exception -> 0x007f }
            java.lang.String r2 = com.mbridge.msdk.MBridgeConstans.OMID_JS_SERVICE_CONTENT     // Catch:{ IllegalArgumentException -> 0x007b, Exception -> 0x0079 }
            r12 = r20
            r3 = r23
            u1.d r0 = u1.d.b(r9, r2, r0, r3, r12)     // Catch:{ IllegalArgumentException -> 0x0077, Exception -> 0x0075 }
            u1.b r7 = u1.b.b(r10, r0)     // Catch:{ IllegalArgumentException -> 0x0077, Exception -> 0x0075 }
            java.lang.String r0 = "adSession create success"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r8, (java.lang.String) r0)     // Catch:{ IllegalArgumentException -> 0x0077, Exception -> 0x0075 }
            return r7
        L_0x0075:
            r0 = move-exception
            goto L_0x0089
        L_0x0077:
            r0 = move-exception
            goto L_0x00b2
        L_0x0079:
            r0 = move-exception
            goto L_0x0038
        L_0x007b:
            r0 = move-exception
        L_0x007c:
            r12 = r20
            goto L_0x00b2
        L_0x007f:
            r0 = move-exception
            r12 = r2
            goto L_0x0089
        L_0x0082:
            r0 = move-exception
            r12 = r2
            goto L_0x00b2
        L_0x0085:
            r0 = move-exception
            r1 = r17
            goto L_0x007c
        L_0x0089:
            java.lang.String r2 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r8, r2)
            com.mbridge.msdk.foundation.same.report.h r11 = new com.mbridge.msdk.foundation.same.report.h
            r11.<init>(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r16 = r1.toString()
            r14 = r21
            r15 = r22
            r13 = r24
            r11.a((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16)
            goto L_0x00dc
        L_0x00b2:
            java.lang.String r2 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r8, r2)
            com.mbridge.msdk.foundation.same.report.h r11 = new com.mbridge.msdk.foundation.same.report.h
            r11.<init>(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r16 = r1.toString()
            r12 = r20
            r14 = r21
            r15 = r22
            r13 = r24
            r11.a((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16)
        L_0x00dc:
            return r7
        L_0x00dd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "createNativeAdSession: TextUtils.isEmpty(omid) = "
            r0.append(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r19)
            r0.append(r2)
            java.lang.String r2 = " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = "
            r0.append(r2)
            java.lang.String r2 = com.mbridge.msdk.MBridgeConstans.OMID_JS_SERVICE_CONTENT
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r8, (java.lang.String) r0)
            com.mbridge.msdk.foundation.same.report.h r11 = new com.mbridge.msdk.foundation.same.report.h
            r11.<init>(r1)
            java.lang.String r16 = "failed, OMID_JS_SERVICE_CONTENT null or omid null"
            r12 = r20
            r14 = r21
            r15 = r22
            r13 = r24
            r11.a((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.a.b.a(android.content.Context, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):u1.b");
    }

    private static String b() {
        try {
            File file = new File(e.a(c.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
            if (file.exists()) {
                return ad.b(file);
            }
            return "";
        } catch (Exception e5) {
            af.a("OMSDK", e5.getMessage());
            return "";
        }
    }

    private static void c(Context context) {
        if (!a.b()) {
            a.a(context);
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = b();
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace("/*OMSDK_INSERT_HERE*/", MBridgeConstans.OMID_JS_H5_CONTENT).replace("[INSERT RESOURCE URL]", f7849a);
    }

    public static void b(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_URL)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = "";
            new h(context).a("", "", "", "", "fetch OM failed, OMID_JS_H5_URL null");
        } else if (context != null) {
            try {
                new a(context.getApplicationContext()).get(0, MBridgeConstans.OMID_JS_H5_URL, (com.mbridge.msdk.foundation.same.net.f.e) null, (com.mbridge.msdk.foundation.same.net.b) new com.mbridge.msdk.foundation.same.net.b.a() {
                    public final void a(String str) {
                        af.a("OMSDK", "fetch OMJSH5Content failed, errorCode = " + str);
                        new h(context).a("", "", "", "", "fetch OM H5 failed, request failed");
                    }

                    public final void b(String str) {
                        MBridgeConstans.OMID_JS_H5_CONTENT = str;
                        b.b(str);
                    }
                }, "om_sdk", (long) ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            } catch (Exception e5) {
                af.b("OMSDK", e5.getMessage());
            }
        }
    }

    public static void b(final String str) {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    File file = new File(e.a(c.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    ad.a(str.getBytes(), file);
                } catch (Exception e5) {
                    af.a("OMSDK", e5.getMessage());
                }
            }
        }).start();
    }

    private static String a() {
        try {
            return ad.b(new File(e.a(c.MBRIDGE_OTHER), "/omsdk/om_js_content.txt"));
        } catch (Exception e5) {
            af.a("OMSDK", e5.getMessage());
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        com.mbridge.msdk.foundation.tools.af.b("OMSDK", r10.getMessage());
        r4 = new com.mbridge.msdk.foundation.same.report.h(r11);
        r6 = r15;
        r4.a(r12, r6, r13, r14, "failed, exception " + r10.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        r5 = r12;
        r12 = r15;
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b3, code lost:
        r5 = r12;
        r12 = r15;
        r10 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045 A[Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }, ExcHandler: JSONException (r0v5 'e' org.json.JSONException A[CUSTOM_DECLARE, Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }]), Splitter:B:1:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<u1.m> a(java.lang.String r10, android.content.Context r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.String r1 = "failed, exception "
            java.lang.String r2 = "OMSDK"
            java.lang.String r0 = ""
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ IllegalArgumentException -> 0x00b2, MalformedURLException -> 0x0089, JSONException -> 0x0045 }
            r4.<init>(r10)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            if (r10 == 0) goto L_0x00da
            r10 = 0
        L_0x0013:
            int r5 = r4.length()     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            if (r10 >= r5) goto L_0x00da
            org.json.JSONObject r5 = r4.optJSONObject(r10)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            java.lang.String r6 = "vkey"
            java.lang.String r6 = r5.optString(r6, r0)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            java.net.URL r7 = new java.net.URL     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            java.lang.String r8 = "et_url"
            java.lang.String r8 = r5.optString(r8, r0)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            r7.<init>(r8)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            java.lang.String r8 = "verification_p"
            java.lang.String r5 = r5.optString(r8, r0)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            if (r8 == 0) goto L_0x0058
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            if (r5 == 0) goto L_0x0053
            u1.m r5 = u1.m.b(r7)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            goto L_0x005c
        L_0x0045:
            r0 = move-exception
            r10 = r0
            goto L_0x0062
        L_0x0048:
            r0 = move-exception
            r10 = r0
            r5 = r12
            r12 = r15
            goto L_0x008d
        L_0x004d:
            r0 = move-exception
            r10 = r0
            r5 = r12
            r12 = r15
            goto L_0x00b6
        L_0x0053:
            u1.m r5 = u1.m.b(r7)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            goto L_0x005c
        L_0x0058:
            u1.m r5 = u1.m.a(r6, r7, r5)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
        L_0x005c:
            r3.add(r5)     // Catch:{ IllegalArgumentException -> 0x004d, MalformedURLException -> 0x0048, JSONException -> 0x0045 }
            int r10 = r10 + 1
            goto L_0x0013
        L_0x0062:
            java.lang.String r0 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
            com.mbridge.msdk.foundation.same.report.h r4 = new com.mbridge.msdk.foundation.same.report.h
            r4.<init>(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            java.lang.String r10 = r10.getMessage()
            r11.append(r10)
            java.lang.String r9 = r11.toString()
            r5 = r12
            r7 = r13
            r8 = r14
            r6 = r15
            r4.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)
            goto L_0x00da
        L_0x0089:
            r0 = move-exception
            r5 = r12
            r12 = r15
            r10 = r0
        L_0x008d:
            java.lang.String r15 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r15)
            r15 = r10
            com.mbridge.msdk.foundation.same.report.h r10 = new com.mbridge.msdk.foundation.same.report.h
            r10.<init>(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            java.lang.String r15 = r15.getMessage()
            r11.append(r15)
            java.lang.String r15 = r11.toString()
            r11 = r5
            r10.a((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15)
            goto L_0x00da
        L_0x00b2:
            r0 = move-exception
            r5 = r12
            r12 = r15
            r10 = r0
        L_0x00b6:
            java.lang.String r15 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r15)
            r15 = r10
            com.mbridge.msdk.foundation.same.report.h r10 = new com.mbridge.msdk.foundation.same.report.h
            r10.<init>(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            java.lang.String r15 = r15.getMessage()
            r11.append(r15)
            java.lang.String r15 = r11.toString()
            r11 = r5
            r10.a((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15)
        L_0x00da:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.a.b.a(java.lang.String, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public static u1.b a(Context context, WebView webView, String str, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = a();
        }
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = b();
        }
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) || TextUtils.isEmpty(campaignEx.getOmid())) {
            af.a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(campaignEx.getOmid()) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
            new h(context).a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), campaignEx.getCampaignUnitId(), "failed, OMID_JS_SERVICE_CONTENT null or omid null");
            return null;
        }
        f fVar = f.DEFINED_BY_JAVASCRIPT;
        c(context);
        u1.b b5 = u1.b.b(u1.c.a(f.HTML_DISPLAY, i.BEGIN_TO_RENDER, k.NATIVE, k.NONE, false), d.a(l.a("Mintegral", MBConfiguration.SDK_VERSION), webView, (String) null, (String) null));
        b5.d(webView);
        return b5;
    }

    public static void a(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = "";
            new h(context).a("", "", "", "", "fetch OM failed, OMID_JS_SERVICE_URL null");
        } else if (context != null) {
            try {
                new a(context.getApplicationContext()).get(0, MBridgeConstans.OMID_JS_SERVICE_URL, (com.mbridge.msdk.foundation.same.net.f.e) null, (com.mbridge.msdk.foundation.same.net.b) new com.mbridge.msdk.foundation.same.net.b.a() {
                    public final void a(String str) {
                        af.a("OMSDK", "fetch OMJSContent failed, errorCode = " + str);
                        new h(context).a("", "", "", "", "fetch OM failed, request failed");
                    }

                    public final void b(String str) {
                        MBridgeConstans.OMID_JS_SERVICE_CONTENT = str;
                        b.a(str);
                    }
                }, "om_sdk", (long) ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            } catch (Exception e5) {
                af.b("OMSDK", e5.getMessage());
            }
        }
    }

    public static void a(final String str) {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    File file = new File(e.a(c.MBRIDGE_OTHER), "/omsdk/om_js_content.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    ad.a(str.getBytes(), file);
                } catch (Exception e5) {
                    af.a("OMSDK", e5.getMessage());
                }
            }
        }).start();
    }
}
