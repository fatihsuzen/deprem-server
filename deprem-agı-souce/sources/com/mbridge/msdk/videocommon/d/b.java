package com.mbridge.msdk.videocommon.d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.c.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f13034a = null;

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, c> f13035b = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static volatile b f13036d;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f13037c = false;

    /* renamed from: e  reason: collision with root package name */
    private CopyOnWriteArrayList<String> f13038e = new CopyOnWriteArrayList<>();

    private b() {
    }

    public static b a() {
        if (f13036d == null) {
            synchronized (b.class) {
                try {
                    if (f13036d == null) {
                        f13036d = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13036d;
    }

    public static boolean e(String str) {
        JSONArray optJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (optJSONArray = new JSONObject(str).optJSONArray("unitSetting")) != null) {
                String optString = optJSONArray.optJSONObject(0).optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (optJSONArray.length() <= 0 || TextUtils.isEmpty(optString)) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }

    private void g(String str, String str2) {
        if (!this.f13037c) {
            this.f13037c = true;
            new a().a(c.m().c(), str, str2);
        }
    }

    private void h(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            Context c5 = c.m().c();
            i.a(c5, str, str2, 2, "alert url is exception ,url:" + str);
            return;
        }
        H5DownLoadManager.getInstance().downloadH5Res(new com.mbridge.msdk.foundation.same.report.d.c(true), str, new H5DownLoadManager.ZipDownloadListener() {
            public final void onFailed(String str, String str2) {
                i.a(c.m().c(), str, str2, 2, str2);
            }

            public final void onSuccess(String str, String str2, boolean z4) {
                i.a(c.m().c(), str, str2, 1, "");
            }
        });
    }

    public final void b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f13038e.remove(str);
            }
        } catch (Exception unused) {
        }
    }

    public final a c() {
        a aVar = new a();
        HashMap hashMap = new HashMap(5);
        hashMap.put("1", 1000);
        hashMap.put("9", 1000);
        hashMap.put("8", 1000);
        HashMap hashMap2 = new HashMap(3);
        hashMap2.put("1", new com.mbridge.msdk.videocommon.b.c("Virtual Item", 1));
        aVar.a((Map<String, Integer>) hashMap);
        aVar.b((Map<String, com.mbridge.msdk.videocommon.b.c>) hashMap2);
        aVar.a(43200);
        aVar.b(5400);
        aVar.c(3600);
        aVar.d(3600);
        aVar.e(5);
        aVar.a(1);
        return aVar;
    }

    public final boolean d() {
        return this.f13037c;
    }

    public final void f(String str) {
        try {
            com.mbridge.msdk.foundation.a.a.a a5 = com.mbridge.msdk.foundation.a.a.a.a();
            String a6 = a5.a("reward_" + str);
            if (!TextUtils.isEmpty(a6)) {
                JSONObject jSONObject = new JSONObject(a6);
                jSONObject.put("current_time", System.currentTimeMillis());
                c(str, jSONObject.toString());
            }
        } catch (Throwable th) {
            af.b("RewardSettingManager", th.getMessage());
        }
    }

    public final boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f13038e.contains(str);
    }

    public final a b() {
        a aVar = f13034a;
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.foundation.a.a.a a5 = com.mbridge.msdk.foundation.a.a.a.a();
        String a6 = a5.a("reward_" + c.m().k());
        if (!TextUtils.isEmpty(a6)) {
            a a7 = a.a(a6);
            if (a7 != null) {
                long d5 = a7.d();
                if (a7.i() + d5 > System.currentTimeMillis()) {
                    return a7;
                }
            }
            g(c.m().k(), c.m().b());
            return c();
        }
        g(c.m().k(), c.m().b());
        return c();
    }

    public final void d(String str, String str2) {
        try {
            String a5 = com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str + "_" + str2);
            if (!TextUtils.isEmpty(a5)) {
                JSONObject jSONObject = new JSONObject(a5);
                jSONObject.put("current_time", System.currentTimeMillis());
                a(str, str2, jSONObject.toString());
            }
        } catch (Throwable th) {
            af.b("RewardSettingManager", th.getMessage());
        }
    }

    public final String g(String str) {
        return com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str);
    }

    public final void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f13038e.add(str);
            }
        } catch (Exception unused) {
        }
    }

    public final c f(String str, String str2) {
        String str3 = "reward_" + str + "_" + str2;
        if (f13035b.containsKey(str3)) {
            return f13035b.get(str3);
        }
        c c5 = c.c(com.mbridge.msdk.foundation.a.a.a.a().a(str3));
        if (c5 != null) {
            f13035b.put(str3, c5);
        }
        return c5;
    }

    public final String e(String str, String str2) {
        return com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str + "_" + str2);
    }

    public final void a(String str, String str2, String str3, com.mbridge.msdk.videocommon.c.c cVar) {
        try {
            if (!TextUtils.isEmpty(str3)) {
                if (!this.f13038e.contains(str3)) {
                    a(str3);
                    new a().a(c.m().c(), str, str2, str3, cVar);
                    return;
                }
            }
            af.a("test_reward_unit_setting", "unitID: " + str3 + " is requesting");
        } catch (Exception unused) {
        }
    }

    public final a e() {
        String str = "reward_" + c.m().k();
        if (f13034a == null) {
            String a5 = com.mbridge.msdk.foundation.a.a.a.a().a(str);
            if (!TextUtils.isEmpty(a5)) {
                a a6 = a.a(a5);
                if (a6 != null) {
                    f13034a = a6;
                }
                return a6;
            }
        }
        return f13034a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.videocommon.d.c a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "reward"
            r0.append(r1)
            java.lang.String r1 = "_"
            r0.append(r1)
            r0.append(r5)
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r1 = f13035b
            boolean r1 = r1.containsKey(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0042
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r1 = f13035b     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Exception -> 0x0032 }
            com.mbridge.msdk.videocommon.d.c r0 = (com.mbridge.msdk.videocommon.d.c) r0     // Catch:{ Exception -> 0x0032 }
            boolean r1 = r4.a((com.mbridge.msdk.videocommon.d.c) r0)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0034
        L_0x0032:
            r0 = r2
        L_0x0033:
            r1 = 0
        L_0x0034:
            if (r1 == 0) goto L_0x0041
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r1 = r1.b()
            r4.a(r5, r1, r6, r2)
        L_0x0041:
            return r0
        L_0x0042:
            com.mbridge.msdk.foundation.a.a.a r1 = com.mbridge.msdk.foundation.a.a.a.a()
            java.lang.String r1 = r1.a(r0)
            com.mbridge.msdk.videocommon.d.c r1 = com.mbridge.msdk.videocommon.d.c.c((java.lang.String) r1)
            boolean r3 = r4.a((com.mbridge.msdk.videocommon.d.c) r1)
            if (r3 == 0) goto L_0x0060
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r0 = r0.b()
            r4.a(r5, r0, r6, r2)
            return r2
        L_0x0060:
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r5 = f13035b
            r5.put(r0, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.d.b.a(java.lang.String, java.lang.String):com.mbridge.msdk.videocommon.d.c");
    }

    public final void b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str2))) {
            h(str2, str);
        }
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            a().a(c.m().k(), str, false);
            String str2 = c.f13043a;
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str2))) {
                h(str2, str);
            }
        }
    }

    public final c b(boolean z4) {
        c cVar = new c();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.mbridge.msdk.videocommon.b.b(1, 30, (com.mbridge.msdk.videocommon.b.a) null));
            cVar.a((List<com.mbridge.msdk.videocommon.b.b>) arrayList);
            cVar.m(1);
            cVar.l(1);
            cVar.n(1);
            cVar.q(1);
            cVar.o(1);
            cVar.p(1);
            cVar.h(3);
            cVar.i(80);
            cVar.j(100);
            cVar.k(0);
            cVar.g(2);
            cVar.e(-1);
            cVar.x(70);
            cVar.d(2);
            if (z4) {
                cVar.c(5);
            } else {
                cVar.c(-1);
            }
            cVar.b(0);
            cVar.a(0);
            cVar.f(1);
            cVar.r(1);
            cVar.t(3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(4);
            arrayList2.add(6);
            cVar.a((ArrayList<Integer>) arrayList2);
            cVar.u(1);
            cVar.v(1);
            cVar.w(60);
            return cVar;
        } catch (Exception e5) {
            e5.printStackTrace();
            return cVar;
        }
    }

    public final void c(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str, str2);
        f13034a = a.a(str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.videocommon.d.c a(java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "reward_"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = "_"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r1 = f13035b
            boolean r1 = r1.containsKey(r0)
            r2 = 0
            if (r1 == 0) goto L_0x003f
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r7 = f13035b     // Catch:{ Exception -> 0x002f }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ Exception -> 0x002f }
            com.mbridge.msdk.videocommon.d.c r7 = (com.mbridge.msdk.videocommon.d.c) r7     // Catch:{ Exception -> 0x002f }
            boolean r0 = r4.a((com.mbridge.msdk.videocommon.d.c) r7)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0031
        L_0x002f:
            r7 = r2
        L_0x0030:
            r0 = 0
        L_0x0031:
            if (r0 == 0) goto L_0x003e
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r0 = r0.b()
            r4.a(r5, r0, r6, r2)
        L_0x003e:
            return r7
        L_0x003f:
            com.mbridge.msdk.foundation.a.a.a r1 = com.mbridge.msdk.foundation.a.a.a.a()
            java.lang.String r1 = r1.a(r0)
            com.mbridge.msdk.videocommon.d.c r1 = com.mbridge.msdk.videocommon.d.c.c((java.lang.String) r1)
            boolean r3 = r4.a((com.mbridge.msdk.videocommon.d.c) r1)
            if (r3 == 0) goto L_0x0064
            if (r1 != 0) goto L_0x0063
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r0 = r0.b()
            r4.a(r5, r0, r6, r2)
            com.mbridge.msdk.videocommon.d.c r5 = r4.b((boolean) r7)
            return r5
        L_0x0063:
            return r1
        L_0x0064:
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r5 = f13035b
            r5.put(r0, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.d.b.a(java.lang.String, java.lang.String, boolean):com.mbridge.msdk.videocommon.d.c");
    }

    private final boolean a(c cVar) {
        a b5 = b();
        if (b5 == null || cVar == null) {
            return true;
        }
        return cVar.x() + b5.e() <= System.currentTimeMillis();
    }

    public final void a(String str, String str2, String str3) {
        String str4 = "reward_" + str + "_" + str2;
        com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
        f13035b.put(str4, c.c(str3));
        if (!com.mbridge.msdk.e.b.a() && !TextUtils.isEmpty(c.f13043a)) {
            h(c.f13043a, str2);
        }
    }

    public final void a(boolean z4) {
        this.f13037c = z4;
    }
}
